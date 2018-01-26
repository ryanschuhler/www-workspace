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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link MarketingEventSponsor}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEventSponsor
 * @generated
 */
@ProviderType
public class MarketingEventSponsorWrapper implements MarketingEventSponsor,
	ModelWrapper<MarketingEventSponsor> {
	public MarketingEventSponsorWrapper(
		MarketingEventSponsor marketingEventSponsor) {
		_marketingEventSponsor = marketingEventSponsor;
	}

	@Override
	public Class<?> getModelClass() {
		return MarketingEventSponsor.class;
	}

	@Override
	public String getModelClassName() {
		return MarketingEventSponsor.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("marketingEventSponsorId", getMarketingEventSponsorId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("marketingEventId", getMarketingEventId());
		attributes.put("marketingEventSponsorLevelId",
			getMarketingEventSponsorLevelId());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("imageFileEntryId", getImageFileEntryId());
		attributes.put("url", getUrl());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long marketingEventSponsorId = (Long)attributes.get(
				"marketingEventSponsorId");

		if (marketingEventSponsorId != null) {
			setMarketingEventSponsorId(marketingEventSponsorId);
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

		Long marketingEventSponsorLevelId = (Long)attributes.get(
				"marketingEventSponsorLevelId");

		if (marketingEventSponsorLevelId != null) {
			setMarketingEventSponsorLevelId(marketingEventSponsorLevelId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long imageFileEntryId = (Long)attributes.get("imageFileEntryId");

		if (imageFileEntryId != null) {
			setImageFileEntryId(imageFileEntryId);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}
	}

	@Override
	public java.lang.Object clone() {
		return new MarketingEventSponsorWrapper((MarketingEventSponsor)_marketingEventSponsor.clone());
	}

	@Override
	public int compareTo(MarketingEventSponsor marketingEventSponsor) {
		return _marketingEventSponsor.compareTo(marketingEventSponsor);
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _marketingEventSponsor.getAvailableLanguageIds();
	}

	/**
	* Returns the create date of this marketing event sponsor.
	*
	* @return the create date of this marketing event sponsor
	*/
	@Override
	public Date getCreateDate() {
		return _marketingEventSponsor.getCreateDate();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _marketingEventSponsor.getDefaultLanguageId();
	}

	/**
	* Returns the description of this marketing event sponsor.
	*
	* @return the description of this marketing event sponsor
	*/
	@Override
	public java.lang.String getDescription() {
		return _marketingEventSponsor.getDescription();
	}

	/**
	* Returns the localized description of this marketing event sponsor in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized description of this marketing event sponsor
	*/
	@Override
	public java.lang.String getDescription(java.util.Locale locale) {
		return _marketingEventSponsor.getDescription(locale);
	}

	/**
	* Returns the localized description of this marketing event sponsor in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized description of this marketing event sponsor. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getDescription(java.util.Locale locale,
		boolean useDefault) {
		return _marketingEventSponsor.getDescription(locale, useDefault);
	}

	/**
	* Returns the localized description of this marketing event sponsor in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized description of this marketing event sponsor
	*/
	@Override
	public java.lang.String getDescription(java.lang.String languageId) {
		return _marketingEventSponsor.getDescription(languageId);
	}

	/**
	* Returns the localized description of this marketing event sponsor in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized description of this marketing event sponsor
	*/
	@Override
	public java.lang.String getDescription(java.lang.String languageId,
		boolean useDefault) {
		return _marketingEventSponsor.getDescription(languageId, useDefault);
	}

	@Override
	public java.lang.String getDescriptionCurrentLanguageId() {
		return _marketingEventSponsor.getDescriptionCurrentLanguageId();
	}

	@Override
	public java.lang.String getDescriptionCurrentValue() {
		return _marketingEventSponsor.getDescriptionCurrentValue();
	}

	/**
	* Returns a map of the locales and localized descriptions of this marketing event sponsor.
	*
	* @return the locales and localized descriptions of this marketing event sponsor
	*/
	@Override
	public Map<java.util.Locale, java.lang.String> getDescriptionMap() {
		return _marketingEventSponsor.getDescriptionMap();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _marketingEventSponsor.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.repository.model.FileEntry getImageFileEntry() {
		return _marketingEventSponsor.getImageFileEntry();
	}

	/**
	* Returns the image file entry ID of this marketing event sponsor.
	*
	* @return the image file entry ID of this marketing event sponsor
	*/
	@Override
	public long getImageFileEntryId() {
		return _marketingEventSponsor.getImageFileEntryId();
	}

	@Override
	public java.lang.String getImageFileEntryURL() {
		return _marketingEventSponsor.getImageFileEntryURL();
	}

	/**
	* Returns the marketing event ID of this marketing event sponsor.
	*
	* @return the marketing event ID of this marketing event sponsor
	*/
	@Override
	public long getMarketingEventId() {
		return _marketingEventSponsor.getMarketingEventId();
	}

	/**
	* Returns the marketing event sponsor ID of this marketing event sponsor.
	*
	* @return the marketing event sponsor ID of this marketing event sponsor
	*/
	@Override
	public long getMarketingEventSponsorId() {
		return _marketingEventSponsor.getMarketingEventSponsorId();
	}

	/**
	* Returns the marketing event sponsor level ID of this marketing event sponsor.
	*
	* @return the marketing event sponsor level ID of this marketing event sponsor
	*/
	@Override
	public long getMarketingEventSponsorLevelId() {
		return _marketingEventSponsor.getMarketingEventSponsorLevelId();
	}

	/**
	* Returns the modified date of this marketing event sponsor.
	*
	* @return the modified date of this marketing event sponsor
	*/
	@Override
	public Date getModifiedDate() {
		return _marketingEventSponsor.getModifiedDate();
	}

	/**
	* Returns the name of this marketing event sponsor.
	*
	* @return the name of this marketing event sponsor
	*/
	@Override
	public java.lang.String getName() {
		return _marketingEventSponsor.getName();
	}

	/**
	* Returns the primary key of this marketing event sponsor.
	*
	* @return the primary key of this marketing event sponsor
	*/
	@Override
	public long getPrimaryKey() {
		return _marketingEventSponsor.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _marketingEventSponsor.getPrimaryKeyObj();
	}

	/**
	* Returns the url of this marketing event sponsor.
	*
	* @return the url of this marketing event sponsor
	*/
	@Override
	public java.lang.String getUrl() {
		return _marketingEventSponsor.getUrl();
	}

	/**
	* Returns the user ID of this marketing event sponsor.
	*
	* @return the user ID of this marketing event sponsor
	*/
	@Override
	public long getUserId() {
		return _marketingEventSponsor.getUserId();
	}

	/**
	* Returns the user name of this marketing event sponsor.
	*
	* @return the user name of this marketing event sponsor
	*/
	@Override
	public java.lang.String getUserName() {
		return _marketingEventSponsor.getUserName();
	}

	/**
	* Returns the user uuid of this marketing event sponsor.
	*
	* @return the user uuid of this marketing event sponsor
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _marketingEventSponsor.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _marketingEventSponsor.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _marketingEventSponsor.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _marketingEventSponsor.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _marketingEventSponsor.isNew();
	}

	@Override
	public void persist() {
		_marketingEventSponsor.persist();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.kernel.exception.LocaleException {
		_marketingEventSponsor.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.kernel.exception.LocaleException {
		_marketingEventSponsor.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_marketingEventSponsor.setCachedModel(cachedModel);
	}

	/**
	* Sets the create date of this marketing event sponsor.
	*
	* @param createDate the create date of this marketing event sponsor
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_marketingEventSponsor.setCreateDate(createDate);
	}

	/**
	* Sets the description of this marketing event sponsor.
	*
	* @param description the description of this marketing event sponsor
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_marketingEventSponsor.setDescription(description);
	}

	/**
	* Sets the localized description of this marketing event sponsor in the language.
	*
	* @param description the localized description of this marketing event sponsor
	* @param locale the locale of the language
	*/
	@Override
	public void setDescription(java.lang.String description,
		java.util.Locale locale) {
		_marketingEventSponsor.setDescription(description, locale);
	}

	/**
	* Sets the localized description of this marketing event sponsor in the language, and sets the default locale.
	*
	* @param description the localized description of this marketing event sponsor
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setDescription(java.lang.String description,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_marketingEventSponsor.setDescription(description, locale, defaultLocale);
	}

	@Override
	public void setDescriptionCurrentLanguageId(java.lang.String languageId) {
		_marketingEventSponsor.setDescriptionCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized descriptions of this marketing event sponsor from the map of locales and localized descriptions.
	*
	* @param descriptionMap the locales and localized descriptions of this marketing event sponsor
	*/
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, java.lang.String> descriptionMap) {
		_marketingEventSponsor.setDescriptionMap(descriptionMap);
	}

	/**
	* Sets the localized descriptions of this marketing event sponsor from the map of locales and localized descriptions, and sets the default locale.
	*
	* @param descriptionMap the locales and localized descriptions of this marketing event sponsor
	* @param defaultLocale the default locale
	*/
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Locale defaultLocale) {
		_marketingEventSponsor.setDescriptionMap(descriptionMap, defaultLocale);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_marketingEventSponsor.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_marketingEventSponsor.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_marketingEventSponsor.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the image file entry ID of this marketing event sponsor.
	*
	* @param imageFileEntryId the image file entry ID of this marketing event sponsor
	*/
	@Override
	public void setImageFileEntryId(long imageFileEntryId) {
		_marketingEventSponsor.setImageFileEntryId(imageFileEntryId);
	}

	/**
	* Sets the marketing event ID of this marketing event sponsor.
	*
	* @param marketingEventId the marketing event ID of this marketing event sponsor
	*/
	@Override
	public void setMarketingEventId(long marketingEventId) {
		_marketingEventSponsor.setMarketingEventId(marketingEventId);
	}

	/**
	* Sets the marketing event sponsor ID of this marketing event sponsor.
	*
	* @param marketingEventSponsorId the marketing event sponsor ID of this marketing event sponsor
	*/
	@Override
	public void setMarketingEventSponsorId(long marketingEventSponsorId) {
		_marketingEventSponsor.setMarketingEventSponsorId(marketingEventSponsorId);
	}

	/**
	* Sets the marketing event sponsor level ID of this marketing event sponsor.
	*
	* @param marketingEventSponsorLevelId the marketing event sponsor level ID of this marketing event sponsor
	*/
	@Override
	public void setMarketingEventSponsorLevelId(
		long marketingEventSponsorLevelId) {
		_marketingEventSponsor.setMarketingEventSponsorLevelId(marketingEventSponsorLevelId);
	}

	/**
	* Sets the modified date of this marketing event sponsor.
	*
	* @param modifiedDate the modified date of this marketing event sponsor
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_marketingEventSponsor.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the name of this marketing event sponsor.
	*
	* @param name the name of this marketing event sponsor
	*/
	@Override
	public void setName(java.lang.String name) {
		_marketingEventSponsor.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_marketingEventSponsor.setNew(n);
	}

	/**
	* Sets the primary key of this marketing event sponsor.
	*
	* @param primaryKey the primary key of this marketing event sponsor
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_marketingEventSponsor.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_marketingEventSponsor.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the url of this marketing event sponsor.
	*
	* @param url the url of this marketing event sponsor
	*/
	@Override
	public void setUrl(java.lang.String url) {
		_marketingEventSponsor.setUrl(url);
	}

	/**
	* Sets the user ID of this marketing event sponsor.
	*
	* @param userId the user ID of this marketing event sponsor
	*/
	@Override
	public void setUserId(long userId) {
		_marketingEventSponsor.setUserId(userId);
	}

	/**
	* Sets the user name of this marketing event sponsor.
	*
	* @param userName the user name of this marketing event sponsor
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_marketingEventSponsor.setUserName(userName);
	}

	/**
	* Sets the user uuid of this marketing event sponsor.
	*
	* @param userUuid the user uuid of this marketing event sponsor
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_marketingEventSponsor.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<MarketingEventSponsor> toCacheModel() {
		return _marketingEventSponsor.toCacheModel();
	}

	@Override
	public MarketingEventSponsor toEscapedModel() {
		return new MarketingEventSponsorWrapper(_marketingEventSponsor.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _marketingEventSponsor.toString();
	}

	@Override
	public MarketingEventSponsor toUnescapedModel() {
		return new MarketingEventSponsorWrapper(_marketingEventSponsor.toUnescapedModel());
	}

	@Override
	public java.lang.String toXmlString() {
		return _marketingEventSponsor.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MarketingEventSponsorWrapper)) {
			return false;
		}

		MarketingEventSponsorWrapper marketingEventSponsorWrapper = (MarketingEventSponsorWrapper)obj;

		if (Objects.equals(_marketingEventSponsor,
					marketingEventSponsorWrapper._marketingEventSponsor)) {
			return true;
		}

		return false;
	}

	@Override
	public MarketingEventSponsor getWrappedModel() {
		return _marketingEventSponsor;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _marketingEventSponsor.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _marketingEventSponsor.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_marketingEventSponsor.resetOriginalValues();
	}

	private final MarketingEventSponsor _marketingEventSponsor;
}