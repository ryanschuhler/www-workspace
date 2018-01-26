/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.osb.www.marketing.events.model.impl;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.osb.www.marketing.events.model.MarketingEvent;
import com.liferay.osb.www.marketing.events.model.MarketingEventAgendaDisplay;
import com.liferay.osb.www.marketing.events.model.MarketingEventAgendaRowDisplay;
import com.liferay.osb.www.marketing.events.model.MarketingEventConstants;
import com.liferay.osb.www.marketing.events.model.MarketingEventSession;
import com.liferay.osb.www.marketing.events.model.MarketingEventSessionDisplay;
import com.liferay.osb.www.marketing.events.util.MarketingEventDateFormat;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.FastDateFormatFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.TimeZoneUtil;
import com.liferay.portal.kernel.util.Validator;

import java.text.Format;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/**
 * @author Allen Ziegenfus
 */
public class MarketingEventAgendaDisplayImpl
	implements MarketingEventAgendaDisplay {

	public MarketingEventAgendaDisplayImpl(
			MarketingEvent marketingEvent,
			Map<Date, List<MarketingEventSession>> marketingEventSessions,
			List<AssetCategory> marketingEventTracksAssetCategories,
			List<AssetCategory> marketingEventTopicsAssetCategories)
		throws PortalException, SystemException {

		_marketingEvent = marketingEvent;
		_marketingEventSessions = marketingEventSessions;
		_marketingEventTracksAssetCategories =
			marketingEventTracksAssetCategories;
		_marketingEventTopicsAssetCategories =
			marketingEventTopicsAssetCategories;

		for (int i = 0; i < _marketingEventTracksAssetCategories.size(); i++) {
			AssetCategory assetCategory =
				_marketingEventTracksAssetCategories.get(i);

			_cssClasses.put(assetCategory, "track-category-" + (i + 1));
		}

		setMarketingEventAgendaRowDisplays();
	}

	@Override
	public JSONObject getCategoryFiltersJSONObject() {
		return _categoryFiltersJSONObject;
	}

	@Override
	public String getCSSClass(AssetCategory assetCategory) {
		return _cssClasses.get(assetCategory);
	}

	@Override
	public Format getDateFormat(
		MarketingEventDateFormat marketingEventDateFormat, String pattern,
		Locale locale) {

		if (marketingEventDateFormat == MarketingEventDateFormat.CUSTOM) {
			try {
				return FastDateFormatFactoryUtil.getSimpleDateFormat(
					pattern, locale, getTimeZone());
			}
			catch (IllegalArgumentException iae) {
				return FastDateFormatFactoryUtil.getSimpleDateFormat(
					MarketingEventConstants.DATE_FORMAT_DEFAULT_PATTERN, locale,
					getTimeZone());
			}
		}

		return FastDateFormatFactoryUtil.getDate(
			marketingEventDateFormat.getStyle(), locale, getTimeZone());
	}

	@Override
	public List<MarketingEventAgendaRowDisplay>
		getMarketingEventAgendaRowDisplays(Date date) {

		return _marketingEventAgendaRowDisplays.get(date);
	}

	@Override
	public List<Date> getMarketingEventDates() {
		return new ArrayList<Date>(_marketingEventSessions.keySet());
	}

	@Override
	public Map<Date, List<MarketingEventSession>> getMarketingEventSessions() {
		return _marketingEventSessions;
	}

	@Override
	public List<AssetCategory> getMarketingEventTopicsAssetCategories() {
		return _marketingEventTopicsAssetCategories;
	}

	@Override
	public List<AssetCategory> getMarketingEventTracksAssetCategories() {
		return _marketingEventTracksAssetCategories;
	}

	@Override
	public TimeZone getTimeZone() {
		if (_marketingEvent == null) {
			return TimeZoneUtil.getDefault();
		}

		return TimeZoneUtil.getTimeZone(_marketingEvent.getTimeZoneId());
	}

	@Override
	public boolean isEmpty() {
		return _marketingEventSessions.isEmpty();
	}

	protected void setMarketingEventAgendaRowDisplays()
		throws PortalException, SystemException {

		_marketingEventAgendaRowDisplays =
			new HashMap<Date, List<MarketingEventAgendaRowDisplay>>();

		Format format = FastDateFormatFactoryUtil.getSimpleDateFormat(
			"HHmm", getTimeZone());

		List<Date> dates = getMarketingEventDates();

		for (int i = 0; i < dates.size(); i++) {
			Date date = dates.get(i);

			String dayCSSClass = "day-" + (i + 1);

			Date previousDate = new Date(0);

			List<MarketingEventAgendaRowDisplay> agendaRows =
				new ArrayList<MarketingEventAgendaRowDisplay>();

			MarketingEventAgendaRowDisplayImpl currentAgendaRow = null;

			for (MarketingEventSession marketingEventSession :
					_marketingEventSessions.get(date)) {

				Calendar startDate = CalendarFactoryUtil.getCalendar(
					getTimeZone());

				startDate.setTime(marketingEventSession.getStartDate());

				String hourCSSClass = "hour-" + format.format(startDate);

				updateCategoryFilters(
					marketingEventSession, dayCSSClass, hourCSSClass);

				Date currentDate = marketingEventSession.getStartDate();

				if (currentDate.getTime() != previousDate.getTime()) {
					if (Validator.isNotNull(currentAgendaRow)) {
						agendaRows.add(currentAgendaRow);
					}

					currentAgendaRow =
						new MarketingEventAgendaRowDisplayImpl(
							hourCSSClass, currentDate);

					previousDate = currentDate;
				}

				MarketingEventSessionDisplay marketingEventSessionDisplay =
					new MarketingEventSessionDisplayImpl(marketingEventSession);

				currentAgendaRow.addMarketingEventSessionDisplay(
					marketingEventSessionDisplay);
			}

			agendaRows.add(currentAgendaRow);

			_marketingEventAgendaRowDisplays.put(date, agendaRows);
		}
	}

	protected void updateCategoryFilters(
			MarketingEventSession marketingEventSession, String dayCSSClass,
			String hourCSSClass)
		throws PortalException, SystemException {

		for (AssetCategory sessionCategory :
				marketingEventSession.getAssetCategories()) {

			JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

			String key = String.valueOf(sessionCategory.getCategoryId());

			if (_categoryFiltersJSONObject.has(key)) {
				jsonArray = _categoryFiltersJSONObject.getJSONArray(key);
			}

			jsonArray.put(
				".session-" +
				marketingEventSession.getMarketingEventSessionId());

			String dayHourCSSClass =
				StringPool.PERIOD + dayCSSClass + StringPool.SPACE +
				StringPool.PERIOD + hourCSSClass;

			String cssClasses = jsonArray.toString();

			if (cssClasses.indexOf(dayHourCSSClass) == -1) {
				jsonArray.put(dayHourCSSClass);
			}

			_categoryFiltersJSONObject.put(key, jsonArray);
		}
	}

	private JSONObject _categoryFiltersJSONObject =
		JSONFactoryUtil.createJSONObject();
	private Map<AssetCategory, String> _cssClasses =
		new HashMap<AssetCategory, String>();
	private MarketingEvent _marketingEvent;
	private Map<Date, List<MarketingEventAgendaRowDisplay>>
		_marketingEventAgendaRowDisplays;
	private Map<Date, List<MarketingEventSession>> _marketingEventSessions;
	private List<AssetCategory> _marketingEventTopicsAssetCategories;
	private List<AssetCategory> _marketingEventTracksAssetCategories;

}