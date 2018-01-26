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

package com.liferay.osb.www.marketing.events.util;

import com.liferay.osb.www.marketing.events.model.MarketingEventAgendaDisplay;
import com.liferay.osb.www.marketing.events.model.MarketingEventConstants;
import com.liferay.osb.www.marketing.events.model.MarketingEventSessionConstants;

import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

/**
 * @author Allen Ziegenfus
 */
public class MarketingEventAgendaDisplayContext {

	public MarketingEventAgendaDisplayContext(
		PortletPreferences portletPreferences, ThemeDisplay themeDisplay) {

		_portletPreferences = portletPreferences;
		_themeDisplay = themeDisplay;
	}

	public String getAgendaCustomDatePattern() {
		return GetterUtil.getString(
			_portletPreferences.getValue("agendaCustomDatePattern", null),
			MarketingEventConstants.DATE_FORMAT_DEFAULT_PATTERN);
	}

	public int getDefaultDay() {
		return GetterUtil.getInteger(
			_portletPreferences.getValue("defaultDay", null), 0);
	}

	public MarketingEventAgendaDisplay getMarketingEventAgendaDisplay() {
		return MarketingEventCacheUtil.getMarketingEventAgendaDisplay(
			getMarketingEventSiteGroupId());
	}

	public MarketingEventDateFormat getMarketingEventDateFormat() {
		int agendaDateFormatType = GetterUtil.getInteger(
			_portletPreferences.getValue("agendaDateFormatType",
			StringPool.BLANK));

		return MarketingEventDateFormat.toMarketingEventDateFormat(
			agendaDateFormatType);
	}

	public MarketingEventSessionLogoType getMarketingEventSessionLogoType() {
		String logoType = GetterUtil.getString(
			_portletPreferences.getValue("logoType", StringPool.BLANK));

		if (Validator.isNotNull(logoType)) {
			return MarketingEventSessionLogoType.parse(logoType);
		}

		return MarketingEventSessionLogoType.LOGO_TYPE_SPEAKER_COMPANY;
	}

	public long getMarketingEventSiteGroupId() {
		return GetterUtil.getLong(
			_portletPreferences.getValue("marketingEventSiteGroupId", null),
			_themeDisplay.getScopeGroupId());
	}

	public String getSessionTimeFormat() {
		return GetterUtil.getString(
			_portletPreferences.getValue("sessionTimeFormat", null),
			MarketingEventSessionConstants.TIME_FORMAT_DEFAULT_PATTERN);
	}

	public boolean isShowRoomLocation() {
		return GetterUtil.getBoolean(
			_portletPreferences.getValue("showRoomLocation",
			String.valueOf(true)));
	}

	public boolean isShowSpeakerAvatar() {
		return GetterUtil.getBoolean(
			_portletPreferences.getValue("showSpeakerAvatar",
			String.valueOf(true)));
	}

	public boolean isShowSpeakerCompanyName() {
		return GetterUtil.getBoolean(
			_portletPreferences.getValue("showSpeakerCompanyName",
			String.valueOf(true)));
	}

	public boolean isShowSpeakerName() {
		return GetterUtil.getBoolean(
			_portletPreferences.getValue("showSpeakerName",
			String.valueOf(true)));
	}

	public boolean isShowSpeakerOnSingleLine() {
		return GetterUtil.getBoolean(
			_portletPreferences.getValue("showSpeakerOnSingleLine",
			String.valueOf(false)));
	}

	public boolean isShowSpeakerTitle() {
		return GetterUtil.getBoolean(
			_portletPreferences.getValue("showSpeakerTitle",
			String.valueOf(true)));
	}

	public boolean isShowTime() {
		return GetterUtil.getBoolean(
			_portletPreferences.getValue("showTime", String.valueOf(true)));
	}

	public boolean isShowTopic() {
		return GetterUtil.getBoolean(
			_portletPreferences.getValue("showTopic", String.valueOf(false)));
	}

	private PortletPreferences _portletPreferences;
	private ThemeDisplay _themeDisplay;

}