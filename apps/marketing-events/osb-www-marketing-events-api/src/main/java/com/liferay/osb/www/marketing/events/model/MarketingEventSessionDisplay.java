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
import com.liferay.osb.www.marketing.events.util.MarketingEventSessionLogoType;

import java.util.List;
import java.util.Locale;

/**
 * @author Allen Ziegenfus
 */
public interface MarketingEventSessionDisplay {

	public String getDescription(Locale locale);

	public MarketingEventSession getMarketingEventSession();

	public List<AssetCategory> getMarketingEventSessionTopicsAssetCategories();

	public List<AssetCategory> getMarketingEventSessionTracksAssetCategories();

	public List<AssetCategory> getMarketingEventSessionTypesAssetCategories();

	public List<MarketingEventUser> getMarketingEventUsers();

	public String getRoomName();

	public List<String> getSessionLogoURLs(
		MarketingEventSessionLogoType marketingEventSessionLogoType);

	public boolean hasRoom();

}