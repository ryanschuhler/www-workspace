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

package com.liferay.osb.www.marketing.events.admin.search;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Calendar;

import javax.portlet.PortletRequest;

/**
 * @author Rachael Koestartyo
 */
public class MarketingEventDisplayTerms extends DisplayTerms {

	public static final String ANYTIME = "anytime";

	public static final String GLOBAL_REGIONS = "globalRegions";

	public static final String START_DATE_GT_DAY = "startDateGTDay";

	public static final String START_DATE_GT_MONTH = "startDateGTMonth";

	public static final String START_DATE_GT_YEAR = "startDateGTYear";

	public static final String START_DATE_LT_DAY = "startDateLTDay";

	public static final String START_DATE_LT_MONTH = "startDateLTMonth";

	public static final String START_DATE_LT_YEAR = "startDateLTYear";

	public static final String SUMMARY = "summary";

	public static final String TITLE = "title";

	public static final String TYPES = "types";

	public MarketingEventDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);

		ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		Calendar startDateLTCalendar = CalendarFactoryUtil.getCalendar(
			themeDisplay.getTimeZone(), themeDisplay.getLocale());

		Calendar startDateGTCalendar = CalendarFactoryUtil.getCalendar(
			themeDisplay.getTimeZone(), themeDisplay.getLocale());

		startDateGTCalendar.add(Calendar.MONTH, -1);

		anytime = ParamUtil.getBoolean(portletRequest, ANYTIME, true);
		globalRegions = ParamUtil.getIntegerValues(
			portletRequest, GLOBAL_REGIONS);
		startDateGTDay = ParamUtil.getInteger(
			portletRequest, START_DATE_GT_DAY,
			startDateGTCalendar.get(Calendar.DATE));
		startDateGTMonth = ParamUtil.getInteger(
			portletRequest, START_DATE_GT_MONTH,
			startDateGTCalendar.get(Calendar.MONTH));
		startDateGTYear = ParamUtil.getInteger(
			portletRequest, START_DATE_GT_YEAR,
			startDateGTCalendar.get(Calendar.YEAR));
		startDateLTDay = ParamUtil.getInteger(
			portletRequest, START_DATE_LT_DAY,
			startDateLTCalendar.get(Calendar.DATE));
		startDateLTMonth = ParamUtil.getInteger(
			portletRequest, START_DATE_LT_MONTH,
			startDateLTCalendar.get(Calendar.MONTH));
		startDateLTYear = ParamUtil.getInteger(
			portletRequest, START_DATE_LT_YEAR,
			startDateLTCalendar.get(Calendar.YEAR));
		summary = ParamUtil.getString(portletRequest, SUMMARY);
		title = ParamUtil.getString(portletRequest, TITLE);
		types = ParamUtil.getIntegerValues(portletRequest, TYPES);
	}

	public int[] getGlobalRegions() {
		return globalRegions;
	}

	public int getStartDateGTDay() {
		return startDateGTDay;
	}

	public int getStartDateGTMonth() {
		return startDateGTMonth;
	}

	public int getStartDateGTYear() {
		return startDateGTYear;
	}

	public int getStartDateLTDay() {
		return startDateLTDay;
	}

	public int getStartDateLTMonth() {
		return startDateLTMonth;
	}

	public int getStartDateLTYear() {
		return startDateLTYear;
	}

	public String getSummary() {
		return summary;
	}

	public String getTitle() {
		return title;
	}

	public int[] getTypes() {
		return types;
	}

	public boolean isAnytime() {
		return anytime;
	}

	protected boolean anytime;
	protected int[] globalRegions;
	protected int startDateGTDay;
	protected int startDateGTMonth;
	protected int startDateGTYear;
	protected int startDateLTDay;
	protected int startDateLTMonth;
	protected int startDateLTYear;
	protected String summary;
	protected String title;
	protected int[] types;

}