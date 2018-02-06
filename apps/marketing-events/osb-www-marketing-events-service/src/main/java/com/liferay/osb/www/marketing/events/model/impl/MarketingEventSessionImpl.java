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

import com.liferay.asset.kernel.exception.NoSuchVocabularyException;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetVocabularyLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.util.DLUtil;
import com.liferay.osb.www.marketing.events.model.MarketingEvent;
import com.liferay.osb.www.marketing.events.model.MarketingEventSession;
import com.liferay.osb.www.marketing.events.model.MarketingEventSessionRoom;
import com.liferay.osb.www.marketing.events.model.MarketingEventUser;
import com.liferay.osb.www.marketing.events.service.MarketingEventLocalServiceUtil;
import com.liferay.osb.www.marketing.events.service.MarketingEventSessionLocalServiceUtil;
import com.liferay.osb.www.marketing.events.service.MarketingEventSessionRoomLocalServiceUtil;
import com.liferay.osb.www.marketing.events.util.MarketingEventsUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.AddressLocalServiceUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Joan H. Kim
 * @author Ryan Schuhler
 * @author Allen Ziegenfus
 */
public class MarketingEventSessionImpl extends MarketingEventSessionBaseImpl {

	public MarketingEventSessionImpl() {
	}

	public List<AssetCategory> getAssetCategories() throws PortalException {
		return AssetCategoryLocalServiceUtil.getCategories(
			MarketingEventSession.class.getName(),
			getMarketingEventSessionId());
	}

	public List<AssetCategory> getAssetCategories(String vocabularyName)
		throws PortalException {

		List<AssetCategory> assetCategories = new ArrayList<>();

		AssetVocabulary assetVocabulary = null;

		MarketingEvent marketingEvent =
			MarketingEventLocalServiceUtil.getMarketingEvent(
				getMarketingEventId());

		try {
			assetVocabulary =
				AssetVocabularyLocalServiceUtil.getGroupVocabulary(
					marketingEvent.getSiteGroupId(), vocabularyName);
		}
		catch (NoSuchVocabularyException nsve) {
			return Collections.emptyList();
		}

		for (AssetCategory assetCategory : getAssetCategories()) {
			if (assetCategory.getVocabularyId() ==
					assetVocabulary.getVocabularyId()) {

				assetCategories.add(assetCategory);
			}
		}

		return assetCategories;
	}

	@JSON
	public JSONArray getAssetCategoriesJSONArray() throws PortalException {
		return MarketingEventsUtil.getAssetCategoriesJSONArray(
			getAssetCategories());
	}

	public List<FileEntry> getChildFileEntries() throws PortalException {
		return getChildFileEntries(new String[0]);
	}

	public List<FileEntry> getChildFileEntries(String[] mimeTypes)
		throws PortalException {

		List<FileEntry> fileEntries = new ArrayList<>();

		AssetEntry assetEntry = AssetEntryLocalServiceUtil.getEntry(
			MarketingEventSession.class.getName(),
			getMarketingEventSessionId());

		List<AssetEntry> childAssetEntries =
			AssetEntryLocalServiceUtil.getChildEntries(assetEntry.getEntryId());

		for (AssetEntry childAssetEntry : childAssetEntries) {
			if ((mimeTypes.length > 0) &&
				!ArrayUtil.contains(mimeTypes, childAssetEntry.getMimeType())) {

				continue;
			}

			try {
				FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(
					childAssetEntry.getClassPK());

				fileEntries.add(fileEntry);
			}
			catch (Exception e) {
				if (_log.isDebugEnabled()) {
					_log.debug(e);
				}
			}
		}

		return fileEntries;
	}

	public List<String> getChildFileEntryURLs() throws PortalException {
		return getChildFileEntryURLs(new String[0]);
	}

	public List<String> getChildFileEntryURLs(String[] mimeTypes)
		throws PortalException {

		List<String> fileEntryURLs = new ArrayList<>();

		for (FileEntry fileEntry : getChildFileEntries(mimeTypes)) {
			String url = DLUtil.getPreviewURL(
				fileEntry, fileEntry.getFileVersion(), null, StringPool.BLANK,
				false, true);

			fileEntryURLs.add(url);
		}

		return fileEntryURLs;
	}

	public List<String> getMarketingEventSessionImageURLs(
			MarketingEventSession marketingEventSession)
		throws PortalException {

		List<String> imageURLs = new ArrayList<>();

		AssetEntry marketingEventSessionAssetEntry =
			AssetEntryLocalServiceUtil.getEntry(
				MarketingEventSession.class.getName(),
				marketingEventSession.getMarketingEventSessionId());

		List<AssetEntry> assetEntries =
			AssetEntryLocalServiceUtil.getChildEntries(
				marketingEventSessionAssetEntry.getEntryId());

		for (AssetEntry assetEntry : assetEntries) {
			if (StringUtil.equalsIgnoreCase(
					DLFileEntry.class.getName(), assetEntry.getClassName())) {

				FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(
					assetEntry.getClassPK());

				String imageURL = DLUtil.getPreviewURL(
					fileEntry, fileEntry.getFileVersion(), null,
					StringPool.BLANK, false, true);

				imageURLs.add(imageURL);
			}
		}

		return imageURLs;
	}

	@JSON
	public MarketingEventSessionRoom getMarketingEventSessionRoom()
		throws PortalException {

		return MarketingEventSessionRoomLocalServiceUtil.
			fetchMarketingEventSessionRoom(getMarketingEventSessionRoomId());
	}

	public long[] getMarketingEventUserIds() {
		List<MarketingEventUser> marketingEventUsers = getMarketingEventUsers();

		return StringUtil.split(
			ListUtil.toString(marketingEventUsers, "marketingEventUserId"), 0L);
	}

	@JSON
	public List<MarketingEventUser> getMarketingEventUsers() {
		AddressLocalServiceUtil.fetchAddress(10);
		return
			MarketingEventSessionLocalServiceUtil.getMarketingEventSessionUsers(
				getMarketingEventSessionId(), QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null);
	}

	@JSON
	public String getRemoteURL() {
		StringBundler sb = new StringBundler(8);

		sb.append(StringPool.SLASH);
		sb.append("eventId");
		sb.append(StringPool.SLASH);
		sb.append(getMarketingEventId());
		sb.append(StringPool.SLASH);
		sb.append("sessionId");
		sb.append(StringPool.SLASH);
		sb.append(getMarketingEventSessionId());

		return sb.toString();
	}

	public FileEntry getSlidesFileEntry() {
		if (getSlidesFileEntryId() <= 0) {
			return null;
		}

		try {
			if (_slidesFileEntry == null) {
				_slidesFileEntry = DLAppLocalServiceUtil.getFileEntry(
					getSlidesFileEntryId());
			}

			return _slidesFileEntry;
		}
		catch (Exception e) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"Unable to get slides for " + getSlidesFileEntryId(), e);
			}

			return null;
		}
	}

	@JSON
	public String getSlidesFileEntryURL() {
		FileEntry fileEntry = getSlidesFileEntry();

		if (fileEntry == null) {
			return StringPool.BLANK;
		}

		try {
			return DLUtil.getPreviewURL(
				fileEntry, fileEntry.getFileVersion(), null, StringPool.BLANK,
				false, true);
		}
		catch (Exception e) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"Unable to get file version for " +
						getSlidesFileEntryId(),
					e);
			}

			return StringPool.BLANK;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		MarketingEventSessionImpl.class);

	private FileEntry _slidesFileEntry;

}