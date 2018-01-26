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

package com.liferay.osb.www.marketing.events.model;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.osb.www.marketing.events.util.MarketingEventDateFormat;
import com.liferay.portal.kernel.json.JSONObject;

import java.io.Serializable;

import java.text.Format;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/**
 * @author Allen Ziegenfus
 */
public interface MarketingEventAgendaDisplay extends Serializable {

	public JSONObject getCategoryFiltersJSONObject();

	public String getCSSClass(AssetCategory assetCategory);

	public Format getDateFormat(
		MarketingEventDateFormat marketingEventDateFormat, String pattern,
		Locale locale);

	public List<MarketingEventAgendaRowDisplay>
		getMarketingEventAgendaRowDisplays(Date date);

	public List<Date> getMarketingEventDates();

	public Map<Date, List<MarketingEventSession>> getMarketingEventSessions();

	public List<AssetCategory> getMarketingEventTopicsAssetCategories();

	public List<AssetCategory> getMarketingEventTracksAssetCategories();

	public TimeZone getTimeZone();

	public boolean isEmpty();

}