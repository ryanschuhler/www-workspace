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
import com.liferay.osb.www.marketing.events.model.MarketingEventConstants;
import com.liferay.osb.www.marketing.events.model.MarketingEventSession;
import com.liferay.osb.www.marketing.events.model.MarketingEventSessionConstants;
import com.liferay.osb.www.marketing.events.model.MarketingEventSessionDisplay;
import com.liferay.osb.www.marketing.events.model.MarketingEventSessionRoom;
import com.liferay.osb.www.marketing.events.model.MarketingEventUser;
import com.liferay.osb.www.marketing.events.util.MarketingEventSessionLogoType;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/**
 * @author Allen Ziegenfus
 */
public class MarketingEventSessionDisplayImpl
	implements MarketingEventSessionDisplay {

	public MarketingEventSessionDisplayImpl(
			MarketingEventSession marketingEventSession)
		throws PortalException, SystemException {

		_marketingEventSession = marketingEventSession;

		_marketingEventSessionTopicsAssetCategories =
			_marketingEventSession.getAssetCategories(
				MarketingEventConstants.ASSET_VOCABULARY_NAME_SESSION_TOPICS);
		_marketingEventSessionTracksAssetCategories =
			_marketingEventSession.getAssetCategories(
				MarketingEventConstants.ASSET_VOCABULARY_NAME_SESSION_TRACKS);
		_marketingEventSessionTypesAssetCategories =
			_marketingEventSession.getAssetCategories(
				MarketingEventConstants.ASSET_VOCABULARY_NAME_SESSION_TYPES);
		_marketingEventUsers = _marketingEventSession.getMarketingEventUsers();

		MarketingEventSessionRoom marketingEventSessionRoom =
			_marketingEventSession.getMarketingEventSessionRoom();

		if (marketingEventSessionRoom != null) {
			_roomName = marketingEventSessionRoom.getName();
		}

		setSessionLogoURLs();
	}

	@Override
	public String getDescription(Locale locale) {
		return StringUtil.replace(
			_marketingEventSession.getDescription(locale), StringPool.NEW_LINE,
			"<br>");
	}

	@Override
	public MarketingEventSession getMarketingEventSession() {
		return _marketingEventSession;
	}

	@Override
	public List<AssetCategory> getMarketingEventSessionTopicsAssetCategories() {
		return _marketingEventSessionTopicsAssetCategories;
	}

	@Override
	public List<AssetCategory> getMarketingEventSessionTracksAssetCategories() {
		return _marketingEventSessionTracksAssetCategories;
	}

	@Override
	public List<AssetCategory> getMarketingEventSessionTypesAssetCategories() {
		return _marketingEventSessionTypesAssetCategories;
	}

	@Override
	public List<MarketingEventUser> getMarketingEventUsers() {
		return _marketingEventUsers;
	}

	@Override
	public String getRoomName() {
		return _roomName;
	}

	@Override
	public List<String> getSessionLogoURLs(
		MarketingEventSessionLogoType marketingEventSessionLogoType) {

		return _marketingEventSessionLogoURLs.get(
			marketingEventSessionLogoType);
	}

	@Override
	public boolean hasRoom() {
		return Validator.isNotNull(_roomName);
	}

	protected void setSessionLogoURLs()
		throws PortalException, SystemException {

		_marketingEventSessionLogoURLs =
			new HashMap<MarketingEventSessionLogoType, List<String>>();

		List<String> sessionURLs = _marketingEventSession.getChildFileEntryURLs(
			MarketingEventSessionConstants.MIME_TYPES_IMAGES);

		_marketingEventSessionLogoURLs.put(
			MarketingEventSessionLogoType.LOGO_TYPE_SESSION, sessionURLs);

		Set<String> companyURLs = new HashSet<String>();

		for (MarketingEventUser marketingEventUser : _marketingEventUsers) {
			companyURLs.add(marketingEventUser.getCompanyLogoFileEntryURL());
		}

		_marketingEventSessionLogoURLs.put(
			MarketingEventSessionLogoType.LOGO_TYPE_SPEAKER_COMPANY,
			new ArrayList<String>(companyURLs));
	}

	private MarketingEventSession _marketingEventSession;
	private Map<MarketingEventSessionLogoType, List<String>>
		_marketingEventSessionLogoURLs;
	private List<AssetCategory> _marketingEventSessionTopicsAssetCategories;
	private List<AssetCategory> _marketingEventSessionTracksAssetCategories;
	private List<AssetCategory> _marketingEventSessionTypesAssetCategories;
	private List<MarketingEventUser> _marketingEventUsers;
	private String _roomName = StringPool.BLANK;

}