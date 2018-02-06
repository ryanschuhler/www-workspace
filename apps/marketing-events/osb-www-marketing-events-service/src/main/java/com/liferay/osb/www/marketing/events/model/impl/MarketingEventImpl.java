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
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetVocabularyLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.util.DLUtil;
import com.liferay.osb.www.marketing.events.configuration.MarketingEventsConfiguration;
import com.liferay.osb.www.marketing.events.model.MarketingEventConstants;
import com.liferay.osb.www.marketing.events.util.MarketingEventsUtil;
import com.liferay.osgi.util.ServiceTrackerFactory;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.model.Region;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.AddressLocalServiceUtil;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.util.tracker.ServiceTracker;

/**
 * @author Rachael Koestartyo
 * @author Allen Ziegenfus
 * @author Ryan Schuhler
 * @author Joan H. Kim
 */
public class MarketingEventImpl extends MarketingEventBaseImpl {

	public MarketingEventImpl() {
	}

	@JSON
	public Address getAddress() {
		try {
			if (_address == null) {
				_address = AddressLocalServiceUtil.fetchAddress(getAddressId());
			}
		}
		catch (Exception e) {
			if (_log.isWarnEnabled()) {
				_log.warn(e, e);
			}
		}

		return _address;
	}

	@JSON
	public Country getCountry() {
		try {
			Address address = getAddress();

			return MarketingEventsUtil.getCountry(address.getCountryId());
		}
		catch (Exception e) {
			if (_log.isWarnEnabled()) {
				_log.warn(e, e);
			}
		}

		return null;
	}

	@JSON
	public JSONObject getExtraSettingsJSONObject() {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		UnicodeProperties extraSettingsProperties =
			getExtraSettingsProperties();

		for (Map.Entry<String, String> entry :
				extraSettingsProperties.entrySet()) {

			jsonObject.put(entry.getKey(), entry.getValue());
		}

		return jsonObject;
	}

	public UnicodeProperties getExtraSettingsProperties() {
		UnicodeProperties extraSettingsProperties = new UnicodeProperties(true);

		extraSettingsProperties.fastLoad(getExtraSettings());

		return extraSettingsProperties;
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
	public JSONObject getMarketingEventSessionAssetCategoriesJSONObject()
		throws PortalException {

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		for (String vocabularyName : sessionVocabularyNames()) {
			List<AssetCategory> assetCategories = new ArrayList<>();

			try {
				AssetVocabulary assetVocabulary =
					AssetVocabularyLocalServiceUtil.getGroupVocabulary(
						getSiteGroupId(), vocabularyName);

				assetCategories = assetVocabulary.getCategories();
			}
			catch (Exception e) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"Unable to get asset vocabulary categories for " +
							getSiteGroupId(),
						e);
				}
			}

			jsonObject.put(
				StringUtil.replace(
					vocabularyName, CharPool.SPACE, StringPool.BLANK),
				MarketingEventsUtil.getAssetCategoriesJSONArray(
					assetCategories));
		}

		return jsonObject;
	}

	@JSON
	public Region getRegion() {
		try {
			Address address = getAddress();

			return MarketingEventsUtil.getRegion(address.getRegionId());
		}
		catch (Exception e) {
			if (_log.isWarnEnabled()) {
				_log.warn(e, e);
			}
		}

		return null;
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

	public String getVideoURL(String extension) {
		if (!hasVideo()) {
			return StringPool.BLANK;
		}

		return MarketingEventConstants.VIDEOS_URL + getVideoTitle() + extension;
	}

	public boolean hasVideo() {
		if (isTypeWebinar() && Validator.isNotNull(getVideoTitle())) {
			return true;
		}

		return false;
	}

	public boolean isTypeCommunity() {
		if (getType() == MarketingEventConstants.TYPE_COMMUNITY) {
			return true;
		}

		return false;
	}

	public boolean isTypeConference() {
		if (getType() == MarketingEventConstants.TYPE_CONFERENCE) {
			return true;
		}

		return false;
	}

	public boolean isTypeIndustry() {
		if (getType() == MarketingEventConstants.TYPE_INDUSTRY) {
			return true;
		}

		return false;
	}

	public boolean isTypePartner() {
		if (getType() == MarketingEventConstants.TYPE_PARTNER) {
			return true;
		}

		return false;
	}

	public boolean isTypeRoadshow() {
		if (getType() == MarketingEventConstants.TYPE_ROADSHOW) {
			return true;
		}

		return false;
	}

	public boolean isTypeWebinar() {
		if (getType() == MarketingEventConstants.TYPE_WEBINAR) {
			return true;
		}

		return false;
	}

	protected String[] sessionVocabularyNames() {
		try {
			ConfigurationAdmin configurationAdmin = _getConfigurationAdmin();

			Configuration configuration = configurationAdmin.getConfiguration(
				"com.liferay.osb.www.marketing.events.configuration." +
					"MarketingEventsConfiguration",
				StringPool.QUESTION);

			_configuration = ConfigurableUtil.createConfigurable(
				MarketingEventsConfiguration.class,
				configuration.getProperties());

			return _configuration.sessionVocabularyNames();
		}
		catch (IOException ioe) {
			return StringPool.EMPTY_ARRAY;
		}
	}

	private ConfigurationAdmin _getConfigurationAdmin() {
		return _configAdminServiceTracker.getService();
	}

	private static Log _log = LogFactoryUtil.getLog(MarketingEventImpl.class);

	private Address _address;
	private ServiceTracker<ConfigurationAdmin, ConfigurationAdmin>
		_configAdminServiceTracker = ServiceTrackerFactory.open(
			ConfigurationAdmin.class);
	private volatile MarketingEventsConfiguration _configuration;
	private FileEntry _imageFileEntry;
	private FileEntry _slidesFileEntry;

}