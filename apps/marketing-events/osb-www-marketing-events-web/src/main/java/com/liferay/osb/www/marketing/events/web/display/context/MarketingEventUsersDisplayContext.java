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

package com.liferay.osb.www.marketing.events.web.display.context;

import com.liferay.osb.www.marketing.events.constants.OSBWWWMarketingEventsConstants;
import com.liferay.osb.www.marketing.events.model.MarketingEventUsersDisplay;
import com.liferay.osb.www.marketing.events.util.MarketingEventUsersCacheUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletPreferences;

/**
 * @author Allen Ziegenfus
 */
public class MarketingEventUsersDisplayContext {

	public MarketingEventUsersDisplayContext(
		PortletPreferences portletPreferences, ThemeDisplay themeDisplay) {

		_portletPreferences = portletPreferences;
		_themeDisplay = themeDisplay;
	}

	public long[] getAnyAssetCategoryIds() throws Exception {
		if (_anyAssetCategoryIds != null) {
			return _anyAssetCategoryIds;
		}

		String anyAssetCategoryIdsString = _portletPreferences.getValue(
			"anyAssetCategoryIds", null);

		_anyAssetCategoryIds = StringUtil.split(anyAssetCategoryIdsString, 0L);

		return _anyAssetCategoryIds;
	}

	public String getAnyAssetCategoryIdsString() throws Exception {
		return StringUtil.merge(getAnyAssetCategoryIds());
	}

	public String getDisplayStyle() {
		return GetterUtil.getString(
			_portletPreferences.getValue("displayStyle", "default"));
	}

	public long[] getGroupIds() {
		List<Long> groupIds = new ArrayList<>();
		List<Group> groups = getGroups();

		for (Group group : groups) {
			groupIds.add(group.getGroupId());
		}

		return ArrayUtil.toLongArray(groupIds);
	}

	public List<Group> getGroups() {
		Company company = _themeDisplay.getCompany();

		Group group = GroupLocalServiceUtil.fetchGroup(
			company.getCompanyId(),
			OSBWWWMarketingEventsConstants.PARENT_GROUP_NAME_EVENTS);

		return GroupLocalServiceUtil.getGroups(
			company.getCompanyId(), group.getGroupId(), true);
	}

	public String getHeaderText() {
		return GetterUtil.getString(
			_portletPreferences.getValue("headerText", "Speakers"));
	}

	public String getKeynoteSpeakerBadgeText() {
		return GetterUtil.getString(
			_portletPreferences.getValue("keynoteSpeakerBadgeText", ""));
	}

	public long getMarketingEventSiteGroupId() {
		return GetterUtil.getLong(
			_portletPreferences.getValue("marketingEventSiteGroupId", null),
			_themeDisplay.getScopeGroupId());
	}

	public MarketingEventUsersDisplay getMarketingEventUsersDisplay()
		throws Exception {

		return MarketingEventUsersCacheUtil.getMarketingEventUsersDisplay(
			getMarketingEventSiteGroupId(), getAnyAssetCategoryIds(),
			getNotAnyAssetCategoryIds(), getOrderByCol(), getOrderByType(),
			_themeDisplay.getLanguageId());
	}

	public long[] getNotAnyAssetCategoryIds() throws Exception {
		if (_notAnyAssetCategoryIds != null) {
			return _notAnyAssetCategoryIds;
		}

		String notAnyAssetCategoryIdsString = _portletPreferences.getValue(
			"notAnyAssetCategoryIds", null);

		_notAnyAssetCategoryIds = StringUtil.split(
			notAnyAssetCategoryIdsString, 0L);

		return _notAnyAssetCategoryIds;
	}

	public String getNotAnyAssetCategoryIdsString() throws Exception {
		return StringUtil.merge(getNotAnyAssetCategoryIds());
	}

	public String getOrderByCol() {
		return GetterUtil.getString(
			_portletPreferences.getValue("orderByCol", "priority"));
	}

	public String getOrderByType() {
		return GetterUtil.getString(
			_portletPreferences.getValue("orderByType", "asc"));
	}

	private long[] _anyAssetCategoryIds;
	private long[] _notAnyAssetCategoryIds;
	private PortletPreferences _portletPreferences;
	private ThemeDisplay _themeDisplay;

}