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

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link MarketingEventSession}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEventSession
 * @generated
 */
@ProviderType
public class MarketingEventSessionWrapper implements MarketingEventSession,
	ModelWrapper<MarketingEventSession> {
	public MarketingEventSessionWrapper(
		MarketingEventSession marketingEventSession) {
		_marketingEventSession = marketingEventSession;
	}

	@Override
	public Class<?> getModelClass() {
		return MarketingEventSession.class;
	}

	@Override
	public String getModelClassName() {
		return MarketingEventSession.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("marketingEventSessionId", getMarketingEventSessionId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("marketingEventId", getMarketingEventId());
		attributes.put("marketingEventSessionRoomId",
			getMarketingEventSessionRoomId());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("keywords", getKeywords());
		attributes.put("slidesFileEntryId", getSlidesFileEntryId());
		attributes.put("videoURL", getVideoURL());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long marketingEventSessionId = (Long)attributes.get(
				"marketingEventSessionId");

		if (marketingEventSessionId != null) {
			setMarketingEventSessionId(marketingEventSessionId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long marketingEventId = (Long)attributes.get("marketingEventId");

		if (marketingEventId != null) {
			setMarketingEventId(marketingEventId);
		}

		Long marketingEventSessionRoomId = (Long)attributes.get(
				"marketingEventSessionRoomId");

		if (marketingEventSessionRoomId != null) {
			setMarketingEventSessionRoomId(marketingEventSessionRoomId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String keywords = (String)attributes.get("keywords");

		if (keywords != null) {
			setKeywords(keywords);
		}

		Long slidesFileEntryId = (Long)attributes.get("slidesFileEntryId");

		if (slidesFileEntryId != null) {
			setSlidesFileEntryId(slidesFileEntryId);
		}

		String videoURL = (String)attributes.get("videoURL");

		if (videoURL != null) {
			setVideoURL(videoURL);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}
	}

	@Override
	public java.lang.Object clone() {
		return new MarketingEventSessionWrapper((MarketingEventSession)_marketingEventSession.clone());
	}

	@Override
	public int compareTo(MarketingEventSession marketingEventSession) {
		return _marketingEventSession.compareTo(marketingEventSession);
	}

	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory> getAssetCategories()
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventSession.getAssetCategories();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getAssetCategoriesJSONArray()
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventSession.getAssetCategoriesJSONArray();
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _marketingEventSession.getAvailableLanguageIds();
	}

	/**
	* Returns the company ID of this marketing event session.
	*
	* @return the company ID of this marketing event session
	*/
	@Override
	public long getCompanyId() {
		return _marketingEventSession.getCompanyId();
	}

	/**
	* Returns the create date of this marketing event session.
	*
	* @return the create date of this marketing event session
	*/
	@Override
	public Date getCreateDate() {
		return _marketingEventSession.getCreateDate();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _marketingEventSession.getDefaultLanguageId();
	}

	/**
	* Returns the description of this marketing event session.
	*
	* @return the description of this marketing event session
	*/
	@Override
	public java.lang.String getDescription() {
		return _marketingEventSession.getDescription();
	}

	/**
	* Returns the localized description of this marketing event session in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized description of this marketing event session
	*/
	@Override
	public java.lang.String getDescription(java.util.Locale locale) {
		return _marketingEventSession.getDescription(locale);
	}

	/**
	* Returns the localized description of this marketing event session in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized description of this marketing event session. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getDescription(java.util.Locale locale,
		boolean useDefault) {
		return _marketingEventSession.getDescription(locale, useDefault);
	}

	/**
	* Returns the localized description of this marketing event session in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized description of this marketing event session
	*/
	@Override
	public java.lang.String getDescription(java.lang.String languageId) {
		return _marketingEventSession.getDescription(languageId);
	}

	/**
	* Returns the localized description of this marketing event session in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized description of this marketing event session
	*/
	@Override
	public java.lang.String getDescription(java.lang.String languageId,
		boolean useDefault) {
		return _marketingEventSession.getDescription(languageId, useDefault);
	}

	@Override
	public java.lang.String getDescriptionCurrentLanguageId() {
		return _marketingEventSession.getDescriptionCurrentLanguageId();
	}

	@Override
	public java.lang.String getDescriptionCurrentValue() {
		return _marketingEventSession.getDescriptionCurrentValue();
	}

	/**
	* Returns a map of the locales and localized descriptions of this marketing event session.
	*
	* @return the locales and localized descriptions of this marketing event session
	*/
	@Override
	public Map<java.util.Locale, java.lang.String> getDescriptionMap() {
		return _marketingEventSession.getDescriptionMap();
	}

	/**
	* Returns the end date of this marketing event session.
	*
	* @return the end date of this marketing event session
	*/
	@Override
	public Date getEndDate() {
		return _marketingEventSession.getEndDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _marketingEventSession.getExpandoBridge();
	}

	/**
	* Returns the keywords of this marketing event session.
	*
	* @return the keywords of this marketing event session
	*/
	@Override
	public java.lang.String getKeywords() {
		return _marketingEventSession.getKeywords();
	}

	/**
	* Returns the localized keywords of this marketing event session in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized keywords of this marketing event session
	*/
	@Override
	public java.lang.String getKeywords(java.util.Locale locale) {
		return _marketingEventSession.getKeywords(locale);
	}

	/**
	* Returns the localized keywords of this marketing event session in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized keywords of this marketing event session. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getKeywords(java.util.Locale locale,
		boolean useDefault) {
		return _marketingEventSession.getKeywords(locale, useDefault);
	}

	/**
	* Returns the localized keywords of this marketing event session in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized keywords of this marketing event session
	*/
	@Override
	public java.lang.String getKeywords(java.lang.String languageId) {
		return _marketingEventSession.getKeywords(languageId);
	}

	/**
	* Returns the localized keywords of this marketing event session in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized keywords of this marketing event session
	*/
	@Override
	public java.lang.String getKeywords(java.lang.String languageId,
		boolean useDefault) {
		return _marketingEventSession.getKeywords(languageId, useDefault);
	}

	@Override
	public java.lang.String getKeywordsCurrentLanguageId() {
		return _marketingEventSession.getKeywordsCurrentLanguageId();
	}

	@Override
	public java.lang.String getKeywordsCurrentValue() {
		return _marketingEventSession.getKeywordsCurrentValue();
	}

	/**
	* Returns a map of the locales and localized keywordses of this marketing event session.
	*
	* @return the locales and localized keywordses of this marketing event session
	*/
	@Override
	public Map<java.util.Locale, java.lang.String> getKeywordsMap() {
		return _marketingEventSession.getKeywordsMap();
	}

	/**
	* Returns the marketing event ID of this marketing event session.
	*
	* @return the marketing event ID of this marketing event session
	*/
	@Override
	public long getMarketingEventId() {
		return _marketingEventSession.getMarketingEventId();
	}

	/**
	* Returns the marketing event session ID of this marketing event session.
	*
	* @return the marketing event session ID of this marketing event session
	*/
	@Override
	public long getMarketingEventSessionId() {
		return _marketingEventSession.getMarketingEventSessionId();
	}

	@Override
	public MarketingEventSessionRoom getMarketingEventSessionRoom()
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventSession.getMarketingEventSessionRoom();
	}

	/**
	* Returns the marketing event session room ID of this marketing event session.
	*
	* @return the marketing event session room ID of this marketing event session
	*/
	@Override
	public long getMarketingEventSessionRoomId() {
		return _marketingEventSession.getMarketingEventSessionRoomId();
	}

	@Override
	public long[] getMarketingEventUserIds() {
		return _marketingEventSession.getMarketingEventUserIds();
	}

	@Override
	public java.util.List<MarketingEventUser> getMarketingEventUsers() {
		return _marketingEventSession.getMarketingEventUsers();
	}

	/**
	* Returns the modified date of this marketing event session.
	*
	* @return the modified date of this marketing event session
	*/
	@Override
	public Date getModifiedDate() {
		return _marketingEventSession.getModifiedDate();
	}

	/**
	* Returns the primary key of this marketing event session.
	*
	* @return the primary key of this marketing event session
	*/
	@Override
	public long getPrimaryKey() {
		return _marketingEventSession.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _marketingEventSession.getPrimaryKeyObj();
	}

	@Override
	public java.lang.String getRemoteURL() {
		return _marketingEventSession.getRemoteURL();
	}

	@Override
	public com.liferay.portal.kernel.repository.model.FileEntry getSlidesFileEntry() {
		return _marketingEventSession.getSlidesFileEntry();
	}

	/**
	* Returns the slides file entry ID of this marketing event session.
	*
	* @return the slides file entry ID of this marketing event session
	*/
	@Override
	public long getSlidesFileEntryId() {
		return _marketingEventSession.getSlidesFileEntryId();
	}

	@Override
	public java.lang.String getSlidesFileEntryURL() {
		return _marketingEventSession.getSlidesFileEntryURL();
	}

	/**
	* Returns the start date of this marketing event session.
	*
	* @return the start date of this marketing event session
	*/
	@Override
	public Date getStartDate() {
		return _marketingEventSession.getStartDate();
	}

	/**
	* Returns the status of this marketing event session.
	*
	* @return the status of this marketing event session
	*/
	@Override
	public int getStatus() {
		return _marketingEventSession.getStatus();
	}

	/**
	* Returns the status by user ID of this marketing event session.
	*
	* @return the status by user ID of this marketing event session
	*/
	@Override
	public long getStatusByUserId() {
		return _marketingEventSession.getStatusByUserId();
	}

	/**
	* Returns the status by user name of this marketing event session.
	*
	* @return the status by user name of this marketing event session
	*/
	@Override
	public java.lang.String getStatusByUserName() {
		return _marketingEventSession.getStatusByUserName();
	}

	/**
	* Returns the status by user uuid of this marketing event session.
	*
	* @return the status by user uuid of this marketing event session
	*/
	@Override
	public java.lang.String getStatusByUserUuid() {
		return _marketingEventSession.getStatusByUserUuid();
	}

	/**
	* Returns the status date of this marketing event session.
	*
	* @return the status date of this marketing event session
	*/
	@Override
	public Date getStatusDate() {
		return _marketingEventSession.getStatusDate();
	}

	/**
	* Returns the title of this marketing event session.
	*
	* @return the title of this marketing event session
	*/
	@Override
	public java.lang.String getTitle() {
		return _marketingEventSession.getTitle();
	}

	/**
	* Returns the localized title of this marketing event session in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized title of this marketing event session
	*/
	@Override
	public java.lang.String getTitle(java.util.Locale locale) {
		return _marketingEventSession.getTitle(locale);
	}

	/**
	* Returns the localized title of this marketing event session in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized title of this marketing event session. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getTitle(java.util.Locale locale, boolean useDefault) {
		return _marketingEventSession.getTitle(locale, useDefault);
	}

	/**
	* Returns the localized title of this marketing event session in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized title of this marketing event session
	*/
	@Override
	public java.lang.String getTitle(java.lang.String languageId) {
		return _marketingEventSession.getTitle(languageId);
	}

	/**
	* Returns the localized title of this marketing event session in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized title of this marketing event session
	*/
	@Override
	public java.lang.String getTitle(java.lang.String languageId,
		boolean useDefault) {
		return _marketingEventSession.getTitle(languageId, useDefault);
	}

	@Override
	public java.lang.String getTitleCurrentLanguageId() {
		return _marketingEventSession.getTitleCurrentLanguageId();
	}

	@Override
	public java.lang.String getTitleCurrentValue() {
		return _marketingEventSession.getTitleCurrentValue();
	}

	/**
	* Returns a map of the locales and localized titles of this marketing event session.
	*
	* @return the locales and localized titles of this marketing event session
	*/
	@Override
	public Map<java.util.Locale, java.lang.String> getTitleMap() {
		return _marketingEventSession.getTitleMap();
	}

	/**
	* Returns the user ID of this marketing event session.
	*
	* @return the user ID of this marketing event session
	*/
	@Override
	public long getUserId() {
		return _marketingEventSession.getUserId();
	}

	/**
	* Returns the user name of this marketing event session.
	*
	* @return the user name of this marketing event session
	*/
	@Override
	public java.lang.String getUserName() {
		return _marketingEventSession.getUserName();
	}

	/**
	* Returns the user uuid of this marketing event session.
	*
	* @return the user uuid of this marketing event session
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _marketingEventSession.getUserUuid();
	}

	/**
	* Returns the uuid of this marketing event session.
	*
	* @return the uuid of this marketing event session
	*/
	@Override
	public java.lang.String getUuid() {
		return _marketingEventSession.getUuid();
	}

	/**
	* Returns the video url of this marketing event session.
	*
	* @return the video url of this marketing event session
	*/
	@Override
	public java.lang.String getVideoURL() {
		return _marketingEventSession.getVideoURL();
	}

	@Override
	public int hashCode() {
		return _marketingEventSession.hashCode();
	}

	/**
	* Returns <code>true</code> if this marketing event session is approved.
	*
	* @return <code>true</code> if this marketing event session is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _marketingEventSession.isApproved();
	}

	@Override
	public boolean isCachedModel() {
		return _marketingEventSession.isCachedModel();
	}

	/**
	* Returns <code>true</code> if this marketing event session is denied.
	*
	* @return <code>true</code> if this marketing event session is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _marketingEventSession.isDenied();
	}

	/**
	* Returns <code>true</code> if this marketing event session is a draft.
	*
	* @return <code>true</code> if this marketing event session is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _marketingEventSession.isDraft();
	}

	@Override
	public boolean isEscapedModel() {
		return _marketingEventSession.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this marketing event session is expired.
	*
	* @return <code>true</code> if this marketing event session is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _marketingEventSession.isExpired();
	}

	/**
	* Returns <code>true</code> if this marketing event session is inactive.
	*
	* @return <code>true</code> if this marketing event session is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _marketingEventSession.isInactive();
	}

	/**
	* Returns <code>true</code> if this marketing event session is incomplete.
	*
	* @return <code>true</code> if this marketing event session is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _marketingEventSession.isIncomplete();
	}

	@Override
	public boolean isNew() {
		return _marketingEventSession.isNew();
	}

	/**
	* Returns <code>true</code> if this marketing event session is pending.
	*
	* @return <code>true</code> if this marketing event session is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _marketingEventSession.isPending();
	}

	/**
	* Returns <code>true</code> if this marketing event session is scheduled.
	*
	* @return <code>true</code> if this marketing event session is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _marketingEventSession.isScheduled();
	}

	@Override
	public void persist() {
		_marketingEventSession.persist();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.kernel.exception.LocaleException {
		_marketingEventSession.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.kernel.exception.LocaleException {
		_marketingEventSession.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_marketingEventSession.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this marketing event session.
	*
	* @param companyId the company ID of this marketing event session
	*/
	@Override
	public void setCompanyId(long companyId) {
		_marketingEventSession.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this marketing event session.
	*
	* @param createDate the create date of this marketing event session
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_marketingEventSession.setCreateDate(createDate);
	}

	/**
	* Sets the description of this marketing event session.
	*
	* @param description the description of this marketing event session
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_marketingEventSession.setDescription(description);
	}

	/**
	* Sets the localized description of this marketing event session in the language.
	*
	* @param description the localized description of this marketing event session
	* @param locale the locale of the language
	*/
	@Override
	public void setDescription(java.lang.String description,
		java.util.Locale locale) {
		_marketingEventSession.setDescription(description, locale);
	}

	/**
	* Sets the localized description of this marketing event session in the language, and sets the default locale.
	*
	* @param description the localized description of this marketing event session
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setDescription(java.lang.String description,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_marketingEventSession.setDescription(description, locale, defaultLocale);
	}

	@Override
	public void setDescriptionCurrentLanguageId(java.lang.String languageId) {
		_marketingEventSession.setDescriptionCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized descriptions of this marketing event session from the map of locales and localized descriptions.
	*
	* @param descriptionMap the locales and localized descriptions of this marketing event session
	*/
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, java.lang.String> descriptionMap) {
		_marketingEventSession.setDescriptionMap(descriptionMap);
	}

	/**
	* Sets the localized descriptions of this marketing event session from the map of locales and localized descriptions, and sets the default locale.
	*
	* @param descriptionMap the locales and localized descriptions of this marketing event session
	* @param defaultLocale the default locale
	*/
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Locale defaultLocale) {
		_marketingEventSession.setDescriptionMap(descriptionMap, defaultLocale);
	}

	/**
	* Sets the end date of this marketing event session.
	*
	* @param endDate the end date of this marketing event session
	*/
	@Override
	public void setEndDate(Date endDate) {
		_marketingEventSession.setEndDate(endDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_marketingEventSession.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_marketingEventSession.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_marketingEventSession.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the keywords of this marketing event session.
	*
	* @param keywords the keywords of this marketing event session
	*/
	@Override
	public void setKeywords(java.lang.String keywords) {
		_marketingEventSession.setKeywords(keywords);
	}

	/**
	* Sets the localized keywords of this marketing event session in the language.
	*
	* @param keywords the localized keywords of this marketing event session
	* @param locale the locale of the language
	*/
	@Override
	public void setKeywords(java.lang.String keywords, java.util.Locale locale) {
		_marketingEventSession.setKeywords(keywords, locale);
	}

	/**
	* Sets the localized keywords of this marketing event session in the language, and sets the default locale.
	*
	* @param keywords the localized keywords of this marketing event session
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setKeywords(java.lang.String keywords, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_marketingEventSession.setKeywords(keywords, locale, defaultLocale);
	}

	@Override
	public void setKeywordsCurrentLanguageId(java.lang.String languageId) {
		_marketingEventSession.setKeywordsCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized keywordses of this marketing event session from the map of locales and localized keywordses.
	*
	* @param keywordsMap the locales and localized keywordses of this marketing event session
	*/
	@Override
	public void setKeywordsMap(
		Map<java.util.Locale, java.lang.String> keywordsMap) {
		_marketingEventSession.setKeywordsMap(keywordsMap);
	}

	/**
	* Sets the localized keywordses of this marketing event session from the map of locales and localized keywordses, and sets the default locale.
	*
	* @param keywordsMap the locales and localized keywordses of this marketing event session
	* @param defaultLocale the default locale
	*/
	@Override
	public void setKeywordsMap(
		Map<java.util.Locale, java.lang.String> keywordsMap,
		java.util.Locale defaultLocale) {
		_marketingEventSession.setKeywordsMap(keywordsMap, defaultLocale);
	}

	/**
	* Sets the marketing event ID of this marketing event session.
	*
	* @param marketingEventId the marketing event ID of this marketing event session
	*/
	@Override
	public void setMarketingEventId(long marketingEventId) {
		_marketingEventSession.setMarketingEventId(marketingEventId);
	}

	/**
	* Sets the marketing event session ID of this marketing event session.
	*
	* @param marketingEventSessionId the marketing event session ID of this marketing event session
	*/
	@Override
	public void setMarketingEventSessionId(long marketingEventSessionId) {
		_marketingEventSession.setMarketingEventSessionId(marketingEventSessionId);
	}

	/**
	* Sets the marketing event session room ID of this marketing event session.
	*
	* @param marketingEventSessionRoomId the marketing event session room ID of this marketing event session
	*/
	@Override
	public void setMarketingEventSessionRoomId(long marketingEventSessionRoomId) {
		_marketingEventSession.setMarketingEventSessionRoomId(marketingEventSessionRoomId);
	}

	/**
	* Sets the modified date of this marketing event session.
	*
	* @param modifiedDate the modified date of this marketing event session
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_marketingEventSession.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_marketingEventSession.setNew(n);
	}

	/**
	* Sets the primary key of this marketing event session.
	*
	* @param primaryKey the primary key of this marketing event session
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_marketingEventSession.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_marketingEventSession.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the slides file entry ID of this marketing event session.
	*
	* @param slidesFileEntryId the slides file entry ID of this marketing event session
	*/
	@Override
	public void setSlidesFileEntryId(long slidesFileEntryId) {
		_marketingEventSession.setSlidesFileEntryId(slidesFileEntryId);
	}

	/**
	* Sets the start date of this marketing event session.
	*
	* @param startDate the start date of this marketing event session
	*/
	@Override
	public void setStartDate(Date startDate) {
		_marketingEventSession.setStartDate(startDate);
	}

	/**
	* Sets the status of this marketing event session.
	*
	* @param status the status of this marketing event session
	*/
	@Override
	public void setStatus(int status) {
		_marketingEventSession.setStatus(status);
	}

	/**
	* Sets the status by user ID of this marketing event session.
	*
	* @param statusByUserId the status by user ID of this marketing event session
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_marketingEventSession.setStatusByUserId(statusByUserId);
	}

	/**
	* Sets the status by user name of this marketing event session.
	*
	* @param statusByUserName the status by user name of this marketing event session
	*/
	@Override
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_marketingEventSession.setStatusByUserName(statusByUserName);
	}

	/**
	* Sets the status by user uuid of this marketing event session.
	*
	* @param statusByUserUuid the status by user uuid of this marketing event session
	*/
	@Override
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_marketingEventSession.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Sets the status date of this marketing event session.
	*
	* @param statusDate the status date of this marketing event session
	*/
	@Override
	public void setStatusDate(Date statusDate) {
		_marketingEventSession.setStatusDate(statusDate);
	}

	/**
	* Sets the title of this marketing event session.
	*
	* @param title the title of this marketing event session
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_marketingEventSession.setTitle(title);
	}

	/**
	* Sets the localized title of this marketing event session in the language.
	*
	* @param title the localized title of this marketing event session
	* @param locale the locale of the language
	*/
	@Override
	public void setTitle(java.lang.String title, java.util.Locale locale) {
		_marketingEventSession.setTitle(title, locale);
	}

	/**
	* Sets the localized title of this marketing event session in the language, and sets the default locale.
	*
	* @param title the localized title of this marketing event session
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setTitle(java.lang.String title, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_marketingEventSession.setTitle(title, locale, defaultLocale);
	}

	@Override
	public void setTitleCurrentLanguageId(java.lang.String languageId) {
		_marketingEventSession.setTitleCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized titles of this marketing event session from the map of locales and localized titles.
	*
	* @param titleMap the locales and localized titles of this marketing event session
	*/
	@Override
	public void setTitleMap(Map<java.util.Locale, java.lang.String> titleMap) {
		_marketingEventSession.setTitleMap(titleMap);
	}

	/**
	* Sets the localized titles of this marketing event session from the map of locales and localized titles, and sets the default locale.
	*
	* @param titleMap the locales and localized titles of this marketing event session
	* @param defaultLocale the default locale
	*/
	@Override
	public void setTitleMap(Map<java.util.Locale, java.lang.String> titleMap,
		java.util.Locale defaultLocale) {
		_marketingEventSession.setTitleMap(titleMap, defaultLocale);
	}

	/**
	* Sets the user ID of this marketing event session.
	*
	* @param userId the user ID of this marketing event session
	*/
	@Override
	public void setUserId(long userId) {
		_marketingEventSession.setUserId(userId);
	}

	/**
	* Sets the user name of this marketing event session.
	*
	* @param userName the user name of this marketing event session
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_marketingEventSession.setUserName(userName);
	}

	/**
	* Sets the user uuid of this marketing event session.
	*
	* @param userUuid the user uuid of this marketing event session
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_marketingEventSession.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this marketing event session.
	*
	* @param uuid the uuid of this marketing event session
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_marketingEventSession.setUuid(uuid);
	}

	/**
	* Sets the video url of this marketing event session.
	*
	* @param videoURL the video url of this marketing event session
	*/
	@Override
	public void setVideoURL(java.lang.String videoURL) {
		_marketingEventSession.setVideoURL(videoURL);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<MarketingEventSession> toCacheModel() {
		return _marketingEventSession.toCacheModel();
	}

	@Override
	public MarketingEventSession toEscapedModel() {
		return new MarketingEventSessionWrapper(_marketingEventSession.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _marketingEventSession.toString();
	}

	@Override
	public MarketingEventSession toUnescapedModel() {
		return new MarketingEventSessionWrapper(_marketingEventSession.toUnescapedModel());
	}

	@Override
	public java.lang.String toXmlString() {
		return _marketingEventSession.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MarketingEventSessionWrapper)) {
			return false;
		}

		MarketingEventSessionWrapper marketingEventSessionWrapper = (MarketingEventSessionWrapper)obj;

		if (Objects.equals(_marketingEventSession,
					marketingEventSessionWrapper._marketingEventSession)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _marketingEventSession.getStagedModelType();
	}

	@Override
	public MarketingEventSession getWrappedModel() {
		return _marketingEventSession;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _marketingEventSession.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _marketingEventSession.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_marketingEventSession.resetOriginalValues();
	}

	private final MarketingEventSession _marketingEventSession;
}