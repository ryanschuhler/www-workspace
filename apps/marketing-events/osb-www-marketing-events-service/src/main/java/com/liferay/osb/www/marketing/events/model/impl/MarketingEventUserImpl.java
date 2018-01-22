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
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.util.DLUtil;
import com.liferay.osb.www.marketing.events.model.MarketingEventUser;
import com.liferay.osb.www.marketing.events.model.SocialLink;
import com.liferay.osb.www.marketing.events.service.SocialLinkLocalServiceUtil;
import com.liferay.osb.www.marketing.events.util.MarketingEventsUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.StringPool;

import java.util.List;

/**
 * @author Joan H. Kim
 * @author Allen Ziegenfus
 * @author Weston Hancock
 */
public class MarketingEventUserImpl extends MarketingEventUserBaseImpl {

	public MarketingEventUserImpl() {
	}

	public List<AssetCategory> getAssetCategories() throws PortalException {
		return AssetCategoryLocalServiceUtil.getCategories(
			MarketingEventUser.class.getName(), getMarketingEventUserId());
	}

	@JSON
	public JSONArray getAssetCategoriesJSONArray() throws PortalException {
		return MarketingEventsUtil.getAssetCategoriesJSONArray(
			getAssetCategories());
	}

	public FileEntry getCompanyLogoFileEntry() {
		if (getCompanyLogoFileEntryId() <= 0) {
			return null;
		}

		try {
			if (_companyLogoFileEntry == null) {
				_companyLogoFileEntry = DLAppLocalServiceUtil.getFileEntry(
					getCompanyLogoFileEntryId());
			}

			return _companyLogoFileEntry;
		}
		catch (Exception e) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"Unable to get company logo for " +
						getCompanyLogoFileEntryId(),
					e);
			}

			return null;
		}
	}

	@JSON
	public String getCompanyLogoFileEntryURL() {
		FileEntry fileEntry = getCompanyLogoFileEntry();

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
						getCompanyLogoFileEntryId(),
					e);
			}

			return StringPool.BLANK;
		}
	}

	public String getFullName() {
		return getFirstName() + StringPool.SPACE + getLastName();
	}

	public FileEntry getImageFileEntry() {
		if (getImageFileEntryId() <= 0) {
			return null;
		}

		try {
			if (_imageFileEntry == null) {
				_imageFileEntry = DLAppLocalServiceUtil.getFileEntry(
					getImageFileEntryId());
			}

			return _imageFileEntry;
		}
		catch (Exception e) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"Unable to get image for " + getImageFileEntryId(), e);
			}

			return null;
		}
	}

	@JSON
	public String getImageFileEntryURL() {
		FileEntry fileEntry = getImageFileEntry();

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
						getImageFileEntryId(),
					e);
			}

			return StringPool.BLANK;
		}
	}

	@JSON
	public List<SocialLink> getSocialLinks() throws PortalException {
		return SocialLinkLocalServiceUtil.getSocialLinks(
			getMarketingEventUserId(), QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	public User getUser() throws PortalException {
		return UserLocalServiceUtil.getUser(getUserId());
	}

	private static Log _log = LogFactoryUtil.getLog(
		MarketingEventUserImpl.class);

	private FileEntry _companyLogoFileEntry;
	private FileEntry _imageFileEntry;

}