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
import com.liferay.osb.www.marketing.events.model.MarketingEventAgendaRowDisplay;
import com.liferay.osb.www.marketing.events.model.MarketingEventSessionDisplay;
import com.liferay.portal.kernel.util.Accessor;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Allen Ziegenfus
 */
public class MarketingEventAgendaRowDisplayImpl
	implements MarketingEventAgendaRowDisplay {

	public MarketingEventAgendaRowDisplayImpl(String cssClass, Date startDate) {
		_cssClass = cssClass;
		_startDate = startDate;
	}

	public void addMarketingEventSessionDisplay(
		MarketingEventSessionDisplay marketingEventSessionDisplay) {

		List<AssetCategory> assetCategories =
			marketingEventSessionDisplay.
				getMarketingEventSessionTracksAssetCategories();

		String sessionTracks = ListUtil.toString(
			assetCategories, _nameAccessor);

		_marketingEventSessionDisplays.put(
			sessionTracks, marketingEventSessionDisplay);
	}

	@Override
	public String getCSSClass() {
		return _cssClass;
	}

	@Override
	public List<MarketingEventSessionDisplay>
		getMarketingEventSessionDisplays() {

		List<MarketingEventSessionDisplay> marketingEventSessionDisplays =
			new ArrayList<>();

		for (String key : _marketingEventSessionDisplays.keySet()) {
			marketingEventSessionDisplays.add(
				_marketingEventSessionDisplays.get(key));
		}

		return marketingEventSessionDisplays;
	}

	@Override
	public Date getStartDate() {
		return _startDate;
	}

	private String _cssClass;
	private Map<String, MarketingEventSessionDisplay>
		_marketingEventSessionDisplays = new TreeMap<>();

	private Accessor<AssetCategory, String> _nameAccessor =
		new Accessor<AssetCategory, String>() {

			@Override
			public String get(AssetCategory assetCategory) {
				return StringUtil.toUpperCase(assetCategory.getName());
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<AssetCategory> getTypeClass() {
				return AssetCategory.class;
			}

		};

	private Date _startDate;

}