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
 * This class is a wrapper for {@link MarketingEventUser}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEventUser
 * @generated
 */
@ProviderType
public class MarketingEventUserWrapper implements MarketingEventUser,
	ModelWrapper<MarketingEventUser> {
	public MarketingEventUserWrapper(MarketingEventUser marketingEventUser) {
		_marketingEventUser = marketingEventUser;
	}

	@Override
	public Class<?> getModelClass() {
		return MarketingEventUser.class;
	}

	@Override
	public String getModelClassName() {
		return MarketingEventUser.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("marketingEventUserId", getMarketingEventUserId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("marketingEventId", getMarketingEventId());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("companyName", getCompanyName());
		attributes.put("companyLogoFileEntryId", getCompanyLogoFileEntryId());
		attributes.put("jobTitle", getJobTitle());
		attributes.put("description", getDescription());
		attributes.put("imageFileEntryId", getImageFileEntryId());
		attributes.put("phoneNumber", getPhoneNumber());
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

		Long marketingEventUserId = (Long)attributes.get("marketingEventUserId");

		if (marketingEventUserId != null) {
			setMarketingEventUserId(marketingEventUserId);
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

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String companyName = (String)attributes.get("companyName");

		if (companyName != null) {
			setCompanyName(companyName);
		}

		Long companyLogoFileEntryId = (Long)attributes.get(
				"companyLogoFileEntryId");

		if (companyLogoFileEntryId != null) {
			setCompanyLogoFileEntryId(companyLogoFileEntryId);
		}

		String jobTitle = (String)attributes.get("jobTitle");

		if (jobTitle != null) {
			setJobTitle(jobTitle);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long imageFileEntryId = (Long)attributes.get("imageFileEntryId");

		if (imageFileEntryId != null) {
			setImageFileEntryId(imageFileEntryId);
		}

		String phoneNumber = (String)attributes.get("phoneNumber");

		if (phoneNumber != null) {
			setPhoneNumber(phoneNumber);
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
		return new MarketingEventUserWrapper((MarketingEventUser)_marketingEventUser.clone());
	}

	@Override
	public int compareTo(MarketingEventUser marketingEventUser) {
		return _marketingEventUser.compareTo(marketingEventUser);
	}

	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory> getAssetCategories()
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventUser.getAssetCategories();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getAssetCategoriesJSONArray()
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventUser.getAssetCategoriesJSONArray();
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _marketingEventUser.getAvailableLanguageIds();
	}

	/**
	* Returns the company ID of this marketing event user.
	*
	* @return the company ID of this marketing event user
	*/
	@Override
	public long getCompanyId() {
		return _marketingEventUser.getCompanyId();
	}

	@Override
	public com.liferay.portal.kernel.repository.model.FileEntry getCompanyLogoFileEntry() {
		return _marketingEventUser.getCompanyLogoFileEntry();
	}

	/**
	* Returns the company logo file entry ID of this marketing event user.
	*
	* @return the company logo file entry ID of this marketing event user
	*/
	@Override
	public long getCompanyLogoFileEntryId() {
		return _marketingEventUser.getCompanyLogoFileEntryId();
	}

	@Override
	public java.lang.String getCompanyLogoFileEntryURL() {
		return _marketingEventUser.getCompanyLogoFileEntryURL();
	}

	/**
	* Returns the company name of this marketing event user.
	*
	* @return the company name of this marketing event user
	*/
	@Override
	public java.lang.String getCompanyName() {
		return _marketingEventUser.getCompanyName();
	}

	/**
	* Returns the create date of this marketing event user.
	*
	* @return the create date of this marketing event user
	*/
	@Override
	public Date getCreateDate() {
		return _marketingEventUser.getCreateDate();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _marketingEventUser.getDefaultLanguageId();
	}

	/**
	* Returns the description of this marketing event user.
	*
	* @return the description of this marketing event user
	*/
	@Override
	public java.lang.String getDescription() {
		return _marketingEventUser.getDescription();
	}

	/**
	* Returns the localized description of this marketing event user in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized description of this marketing event user
	*/
	@Override
	public java.lang.String getDescription(java.util.Locale locale) {
		return _marketingEventUser.getDescription(locale);
	}

	/**
	* Returns the localized description of this marketing event user in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized description of this marketing event user. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getDescription(java.util.Locale locale,
		boolean useDefault) {
		return _marketingEventUser.getDescription(locale, useDefault);
	}

	/**
	* Returns the localized description of this marketing event user in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized description of this marketing event user
	*/
	@Override
	public java.lang.String getDescription(java.lang.String languageId) {
		return _marketingEventUser.getDescription(languageId);
	}

	/**
	* Returns the localized description of this marketing event user in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized description of this marketing event user
	*/
	@Override
	public java.lang.String getDescription(java.lang.String languageId,
		boolean useDefault) {
		return _marketingEventUser.getDescription(languageId, useDefault);
	}

	@Override
	public java.lang.String getDescriptionCurrentLanguageId() {
		return _marketingEventUser.getDescriptionCurrentLanguageId();
	}

	@Override
	public java.lang.String getDescriptionCurrentValue() {
		return _marketingEventUser.getDescriptionCurrentValue();
	}

	/**
	* Returns a map of the locales and localized descriptions of this marketing event user.
	*
	* @return the locales and localized descriptions of this marketing event user
	*/
	@Override
	public Map<java.util.Locale, java.lang.String> getDescriptionMap() {
		return _marketingEventUser.getDescriptionMap();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _marketingEventUser.getExpandoBridge();
	}

	/**
	* Returns the first name of this marketing event user.
	*
	* @return the first name of this marketing event user
	*/
	@Override
	public java.lang.String getFirstName() {
		return _marketingEventUser.getFirstName();
	}

	@Override
	public java.lang.String getFullName() {
		return _marketingEventUser.getFullName();
	}

	@Override
	public com.liferay.portal.kernel.repository.model.FileEntry getImageFileEntry() {
		return _marketingEventUser.getImageFileEntry();
	}

	/**
	* Returns the image file entry ID of this marketing event user.
	*
	* @return the image file entry ID of this marketing event user
	*/
	@Override
	public long getImageFileEntryId() {
		return _marketingEventUser.getImageFileEntryId();
	}

	@Override
	public java.lang.String getImageFileEntryURL() {
		return _marketingEventUser.getImageFileEntryURL();
	}

	/**
	* Returns the job title of this marketing event user.
	*
	* @return the job title of this marketing event user
	*/
	@Override
	public java.lang.String getJobTitle() {
		return _marketingEventUser.getJobTitle();
	}

	/**
	* Returns the localized job title of this marketing event user in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized job title of this marketing event user
	*/
	@Override
	public java.lang.String getJobTitle(java.util.Locale locale) {
		return _marketingEventUser.getJobTitle(locale);
	}

	/**
	* Returns the localized job title of this marketing event user in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized job title of this marketing event user. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getJobTitle(java.util.Locale locale,
		boolean useDefault) {
		return _marketingEventUser.getJobTitle(locale, useDefault);
	}

	/**
	* Returns the localized job title of this marketing event user in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized job title of this marketing event user
	*/
	@Override
	public java.lang.String getJobTitle(java.lang.String languageId) {
		return _marketingEventUser.getJobTitle(languageId);
	}

	/**
	* Returns the localized job title of this marketing event user in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized job title of this marketing event user
	*/
	@Override
	public java.lang.String getJobTitle(java.lang.String languageId,
		boolean useDefault) {
		return _marketingEventUser.getJobTitle(languageId, useDefault);
	}

	@Override
	public java.lang.String getJobTitleCurrentLanguageId() {
		return _marketingEventUser.getJobTitleCurrentLanguageId();
	}

	@Override
	public java.lang.String getJobTitleCurrentValue() {
		return _marketingEventUser.getJobTitleCurrentValue();
	}

	/**
	* Returns a map of the locales and localized job titles of this marketing event user.
	*
	* @return the locales and localized job titles of this marketing event user
	*/
	@Override
	public Map<java.util.Locale, java.lang.String> getJobTitleMap() {
		return _marketingEventUser.getJobTitleMap();
	}

	/**
	* Returns the last name of this marketing event user.
	*
	* @return the last name of this marketing event user
	*/
	@Override
	public java.lang.String getLastName() {
		return _marketingEventUser.getLastName();
	}

	/**
	* Returns the marketing event ID of this marketing event user.
	*
	* @return the marketing event ID of this marketing event user
	*/
	@Override
	public long getMarketingEventId() {
		return _marketingEventUser.getMarketingEventId();
	}

	/**
	* Returns the marketing event user ID of this marketing event user.
	*
	* @return the marketing event user ID of this marketing event user
	*/
	@Override
	public long getMarketingEventUserId() {
		return _marketingEventUser.getMarketingEventUserId();
	}

	/**
	* Returns the marketing event user uuid of this marketing event user.
	*
	* @return the marketing event user uuid of this marketing event user
	*/
	@Override
	public java.lang.String getMarketingEventUserUuid() {
		return _marketingEventUser.getMarketingEventUserUuid();
	}

	/**
	* Returns the modified date of this marketing event user.
	*
	* @return the modified date of this marketing event user
	*/
	@Override
	public Date getModifiedDate() {
		return _marketingEventUser.getModifiedDate();
	}

	/**
	* Returns the phone number of this marketing event user.
	*
	* @return the phone number of this marketing event user
	*/
	@Override
	public java.lang.String getPhoneNumber() {
		return _marketingEventUser.getPhoneNumber();
	}

	/**
	* Returns the primary key of this marketing event user.
	*
	* @return the primary key of this marketing event user
	*/
	@Override
	public long getPrimaryKey() {
		return _marketingEventUser.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _marketingEventUser.getPrimaryKeyObj();
	}

	@Override
	public java.util.List<SocialLink> getSocialLinks()
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventUser.getSocialLinks();
	}

	/**
	* Returns the status of this marketing event user.
	*
	* @return the status of this marketing event user
	*/
	@Override
	public int getStatus() {
		return _marketingEventUser.getStatus();
	}

	/**
	* Returns the status by user ID of this marketing event user.
	*
	* @return the status by user ID of this marketing event user
	*/
	@Override
	public long getStatusByUserId() {
		return _marketingEventUser.getStatusByUserId();
	}

	/**
	* Returns the status by user name of this marketing event user.
	*
	* @return the status by user name of this marketing event user
	*/
	@Override
	public java.lang.String getStatusByUserName() {
		return _marketingEventUser.getStatusByUserName();
	}

	/**
	* Returns the status by user uuid of this marketing event user.
	*
	* @return the status by user uuid of this marketing event user
	*/
	@Override
	public java.lang.String getStatusByUserUuid() {
		return _marketingEventUser.getStatusByUserUuid();
	}

	/**
	* Returns the status date of this marketing event user.
	*
	* @return the status date of this marketing event user
	*/
	@Override
	public Date getStatusDate() {
		return _marketingEventUser.getStatusDate();
	}

	@Override
	public com.liferay.portal.kernel.model.User getUser()
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventUser.getUser();
	}

	/**
	* Returns the user ID of this marketing event user.
	*
	* @return the user ID of this marketing event user
	*/
	@Override
	public long getUserId() {
		return _marketingEventUser.getUserId();
	}

	/**
	* Returns the user name of this marketing event user.
	*
	* @return the user name of this marketing event user
	*/
	@Override
	public java.lang.String getUserName() {
		return _marketingEventUser.getUserName();
	}

	/**
	* Returns the user uuid of this marketing event user.
	*
	* @return the user uuid of this marketing event user
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _marketingEventUser.getUserUuid();
	}

	/**
	* Returns the uuid of this marketing event user.
	*
	* @return the uuid of this marketing event user
	*/
	@Override
	public java.lang.String getUuid() {
		return _marketingEventUser.getUuid();
	}

	@Override
	public int hashCode() {
		return _marketingEventUser.hashCode();
	}

	/**
	* Returns <code>true</code> if this marketing event user is approved.
	*
	* @return <code>true</code> if this marketing event user is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _marketingEventUser.isApproved();
	}

	@Override
	public boolean isCachedModel() {
		return _marketingEventUser.isCachedModel();
	}

	/**
	* Returns <code>true</code> if this marketing event user is denied.
	*
	* @return <code>true</code> if this marketing event user is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _marketingEventUser.isDenied();
	}

	/**
	* Returns <code>true</code> if this marketing event user is a draft.
	*
	* @return <code>true</code> if this marketing event user is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _marketingEventUser.isDraft();
	}

	@Override
	public boolean isEscapedModel() {
		return _marketingEventUser.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this marketing event user is expired.
	*
	* @return <code>true</code> if this marketing event user is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _marketingEventUser.isExpired();
	}

	/**
	* Returns <code>true</code> if this marketing event user is inactive.
	*
	* @return <code>true</code> if this marketing event user is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _marketingEventUser.isInactive();
	}

	/**
	* Returns <code>true</code> if this marketing event user is incomplete.
	*
	* @return <code>true</code> if this marketing event user is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _marketingEventUser.isIncomplete();
	}

	@Override
	public boolean isNew() {
		return _marketingEventUser.isNew();
	}

	/**
	* Returns <code>true</code> if this marketing event user is pending.
	*
	* @return <code>true</code> if this marketing event user is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _marketingEventUser.isPending();
	}

	/**
	* Returns <code>true</code> if this marketing event user is scheduled.
	*
	* @return <code>true</code> if this marketing event user is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _marketingEventUser.isScheduled();
	}

	@Override
	public void persist() {
		_marketingEventUser.persist();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.kernel.exception.LocaleException {
		_marketingEventUser.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.kernel.exception.LocaleException {
		_marketingEventUser.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_marketingEventUser.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this marketing event user.
	*
	* @param companyId the company ID of this marketing event user
	*/
	@Override
	public void setCompanyId(long companyId) {
		_marketingEventUser.setCompanyId(companyId);
	}

	/**
	* Sets the company logo file entry ID of this marketing event user.
	*
	* @param companyLogoFileEntryId the company logo file entry ID of this marketing event user
	*/
	@Override
	public void setCompanyLogoFileEntryId(long companyLogoFileEntryId) {
		_marketingEventUser.setCompanyLogoFileEntryId(companyLogoFileEntryId);
	}

	/**
	* Sets the company name of this marketing event user.
	*
	* @param companyName the company name of this marketing event user
	*/
	@Override
	public void setCompanyName(java.lang.String companyName) {
		_marketingEventUser.setCompanyName(companyName);
	}

	/**
	* Sets the create date of this marketing event user.
	*
	* @param createDate the create date of this marketing event user
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_marketingEventUser.setCreateDate(createDate);
	}

	/**
	* Sets the description of this marketing event user.
	*
	* @param description the description of this marketing event user
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_marketingEventUser.setDescription(description);
	}

	/**
	* Sets the localized description of this marketing event user in the language.
	*
	* @param description the localized description of this marketing event user
	* @param locale the locale of the language
	*/
	@Override
	public void setDescription(java.lang.String description,
		java.util.Locale locale) {
		_marketingEventUser.setDescription(description, locale);
	}

	/**
	* Sets the localized description of this marketing event user in the language, and sets the default locale.
	*
	* @param description the localized description of this marketing event user
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setDescription(java.lang.String description,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_marketingEventUser.setDescription(description, locale, defaultLocale);
	}

	@Override
	public void setDescriptionCurrentLanguageId(java.lang.String languageId) {
		_marketingEventUser.setDescriptionCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized descriptions of this marketing event user from the map of locales and localized descriptions.
	*
	* @param descriptionMap the locales and localized descriptions of this marketing event user
	*/
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, java.lang.String> descriptionMap) {
		_marketingEventUser.setDescriptionMap(descriptionMap);
	}

	/**
	* Sets the localized descriptions of this marketing event user from the map of locales and localized descriptions, and sets the default locale.
	*
	* @param descriptionMap the locales and localized descriptions of this marketing event user
	* @param defaultLocale the default locale
	*/
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Locale defaultLocale) {
		_marketingEventUser.setDescriptionMap(descriptionMap, defaultLocale);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_marketingEventUser.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_marketingEventUser.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_marketingEventUser.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the first name of this marketing event user.
	*
	* @param firstName the first name of this marketing event user
	*/
	@Override
	public void setFirstName(java.lang.String firstName) {
		_marketingEventUser.setFirstName(firstName);
	}

	/**
	* Sets the image file entry ID of this marketing event user.
	*
	* @param imageFileEntryId the image file entry ID of this marketing event user
	*/
	@Override
	public void setImageFileEntryId(long imageFileEntryId) {
		_marketingEventUser.setImageFileEntryId(imageFileEntryId);
	}

	/**
	* Sets the job title of this marketing event user.
	*
	* @param jobTitle the job title of this marketing event user
	*/
	@Override
	public void setJobTitle(java.lang.String jobTitle) {
		_marketingEventUser.setJobTitle(jobTitle);
	}

	/**
	* Sets the localized job title of this marketing event user in the language.
	*
	* @param jobTitle the localized job title of this marketing event user
	* @param locale the locale of the language
	*/
	@Override
	public void setJobTitle(java.lang.String jobTitle, java.util.Locale locale) {
		_marketingEventUser.setJobTitle(jobTitle, locale);
	}

	/**
	* Sets the localized job title of this marketing event user in the language, and sets the default locale.
	*
	* @param jobTitle the localized job title of this marketing event user
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setJobTitle(java.lang.String jobTitle, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_marketingEventUser.setJobTitle(jobTitle, locale, defaultLocale);
	}

	@Override
	public void setJobTitleCurrentLanguageId(java.lang.String languageId) {
		_marketingEventUser.setJobTitleCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized job titles of this marketing event user from the map of locales and localized job titles.
	*
	* @param jobTitleMap the locales and localized job titles of this marketing event user
	*/
	@Override
	public void setJobTitleMap(
		Map<java.util.Locale, java.lang.String> jobTitleMap) {
		_marketingEventUser.setJobTitleMap(jobTitleMap);
	}

	/**
	* Sets the localized job titles of this marketing event user from the map of locales and localized job titles, and sets the default locale.
	*
	* @param jobTitleMap the locales and localized job titles of this marketing event user
	* @param defaultLocale the default locale
	*/
	@Override
	public void setJobTitleMap(
		Map<java.util.Locale, java.lang.String> jobTitleMap,
		java.util.Locale defaultLocale) {
		_marketingEventUser.setJobTitleMap(jobTitleMap, defaultLocale);
	}

	/**
	* Sets the last name of this marketing event user.
	*
	* @param lastName the last name of this marketing event user
	*/
	@Override
	public void setLastName(java.lang.String lastName) {
		_marketingEventUser.setLastName(lastName);
	}

	/**
	* Sets the marketing event ID of this marketing event user.
	*
	* @param marketingEventId the marketing event ID of this marketing event user
	*/
	@Override
	public void setMarketingEventId(long marketingEventId) {
		_marketingEventUser.setMarketingEventId(marketingEventId);
	}

	/**
	* Sets the marketing event user ID of this marketing event user.
	*
	* @param marketingEventUserId the marketing event user ID of this marketing event user
	*/
	@Override
	public void setMarketingEventUserId(long marketingEventUserId) {
		_marketingEventUser.setMarketingEventUserId(marketingEventUserId);
	}

	/**
	* Sets the marketing event user uuid of this marketing event user.
	*
	* @param marketingEventUserUuid the marketing event user uuid of this marketing event user
	*/
	@Override
	public void setMarketingEventUserUuid(
		java.lang.String marketingEventUserUuid) {
		_marketingEventUser.setMarketingEventUserUuid(marketingEventUserUuid);
	}

	/**
	* Sets the modified date of this marketing event user.
	*
	* @param modifiedDate the modified date of this marketing event user
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_marketingEventUser.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_marketingEventUser.setNew(n);
	}

	/**
	* Sets the phone number of this marketing event user.
	*
	* @param phoneNumber the phone number of this marketing event user
	*/
	@Override
	public void setPhoneNumber(java.lang.String phoneNumber) {
		_marketingEventUser.setPhoneNumber(phoneNumber);
	}

	/**
	* Sets the primary key of this marketing event user.
	*
	* @param primaryKey the primary key of this marketing event user
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_marketingEventUser.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_marketingEventUser.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the status of this marketing event user.
	*
	* @param status the status of this marketing event user
	*/
	@Override
	public void setStatus(int status) {
		_marketingEventUser.setStatus(status);
	}

	/**
	* Sets the status by user ID of this marketing event user.
	*
	* @param statusByUserId the status by user ID of this marketing event user
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_marketingEventUser.setStatusByUserId(statusByUserId);
	}

	/**
	* Sets the status by user name of this marketing event user.
	*
	* @param statusByUserName the status by user name of this marketing event user
	*/
	@Override
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_marketingEventUser.setStatusByUserName(statusByUserName);
	}

	/**
	* Sets the status by user uuid of this marketing event user.
	*
	* @param statusByUserUuid the status by user uuid of this marketing event user
	*/
	@Override
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_marketingEventUser.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Sets the status date of this marketing event user.
	*
	* @param statusDate the status date of this marketing event user
	*/
	@Override
	public void setStatusDate(Date statusDate) {
		_marketingEventUser.setStatusDate(statusDate);
	}

	/**
	* Sets the user ID of this marketing event user.
	*
	* @param userId the user ID of this marketing event user
	*/
	@Override
	public void setUserId(long userId) {
		_marketingEventUser.setUserId(userId);
	}

	/**
	* Sets the user name of this marketing event user.
	*
	* @param userName the user name of this marketing event user
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_marketingEventUser.setUserName(userName);
	}

	/**
	* Sets the user uuid of this marketing event user.
	*
	* @param userUuid the user uuid of this marketing event user
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_marketingEventUser.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this marketing event user.
	*
	* @param uuid the uuid of this marketing event user
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_marketingEventUser.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<MarketingEventUser> toCacheModel() {
		return _marketingEventUser.toCacheModel();
	}

	@Override
	public MarketingEventUser toEscapedModel() {
		return new MarketingEventUserWrapper(_marketingEventUser.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _marketingEventUser.toString();
	}

	@Override
	public MarketingEventUser toUnescapedModel() {
		return new MarketingEventUserWrapper(_marketingEventUser.toUnescapedModel());
	}

	@Override
	public java.lang.String toXmlString() {
		return _marketingEventUser.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MarketingEventUserWrapper)) {
			return false;
		}

		MarketingEventUserWrapper marketingEventUserWrapper = (MarketingEventUserWrapper)obj;

		if (Objects.equals(_marketingEventUser,
					marketingEventUserWrapper._marketingEventUser)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _marketingEventUser.getStagedModelType();
	}

	@Override
	public MarketingEventUser getWrappedModel() {
		return _marketingEventUser;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _marketingEventUser.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _marketingEventUser.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_marketingEventUser.resetOriginalValues();
	}

	private final MarketingEventUser _marketingEventUser;
}