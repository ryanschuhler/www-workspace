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
 * This class is a wrapper for {@link MarketingEventSponsorLevel}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEventSponsorLevel
 * @generated
 */
@ProviderType
public class MarketingEventSponsorLevelWrapper
	implements MarketingEventSponsorLevel,
		ModelWrapper<MarketingEventSponsorLevel> {
	public MarketingEventSponsorLevelWrapper(
		MarketingEventSponsorLevel marketingEventSponsorLevel) {
		_marketingEventSponsorLevel = marketingEventSponsorLevel;
	}

	@Override
	public Class<?> getModelClass() {
		return MarketingEventSponsorLevel.class;
	}

	@Override
	public String getModelClassName() {
		return MarketingEventSponsorLevel.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("marketingEventSponsorLevelId",
			getMarketingEventSponsorLevelId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("marketingEventId", getMarketingEventId());
		attributes.put("name", getName());
		attributes.put("priority", getPriority());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long marketingEventSponsorLevelId = (Long)attributes.get(
				"marketingEventSponsorLevelId");

		if (marketingEventSponsorLevelId != null) {
			setMarketingEventSponsorLevelId(marketingEventSponsorLevelId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Integer priority = (Integer)attributes.get("priority");

		if (priority != null) {
			setPriority(priority);
		}
	}

	@Override
	public java.lang.Object clone() {
		return new MarketingEventSponsorLevelWrapper((MarketingEventSponsorLevel)_marketingEventSponsorLevel.clone());
	}

	@Override
	public int compareTo(MarketingEventSponsorLevel marketingEventSponsorLevel) {
		return _marketingEventSponsorLevel.compareTo(marketingEventSponsorLevel);
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _marketingEventSponsorLevel.getAvailableLanguageIds();
	}

	/**
	* Returns the create date of this marketing event sponsor level.
	*
	* @return the create date of this marketing event sponsor level
	*/
	@Override
	public Date getCreateDate() {
		return _marketingEventSponsorLevel.getCreateDate();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _marketingEventSponsorLevel.getDefaultLanguageId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _marketingEventSponsorLevel.getExpandoBridge();
	}

	/**
	* Returns the marketing event ID of this marketing event sponsor level.
	*
	* @return the marketing event ID of this marketing event sponsor level
	*/
	@Override
	public long getMarketingEventId() {
		return _marketingEventSponsorLevel.getMarketingEventId();
	}

	/**
	* Returns the marketing event sponsor level ID of this marketing event sponsor level.
	*
	* @return the marketing event sponsor level ID of this marketing event sponsor level
	*/
	@Override
	public long getMarketingEventSponsorLevelId() {
		return _marketingEventSponsorLevel.getMarketingEventSponsorLevelId();
	}

	/**
	* Returns the modified date of this marketing event sponsor level.
	*
	* @return the modified date of this marketing event sponsor level
	*/
	@Override
	public Date getModifiedDate() {
		return _marketingEventSponsorLevel.getModifiedDate();
	}

	/**
	* Returns the name of this marketing event sponsor level.
	*
	* @return the name of this marketing event sponsor level
	*/
	@Override
	public java.lang.String getName() {
		return _marketingEventSponsorLevel.getName();
	}

	/**
	* Returns the localized name of this marketing event sponsor level in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized name of this marketing event sponsor level
	*/
	@Override
	public java.lang.String getName(java.util.Locale locale) {
		return _marketingEventSponsorLevel.getName(locale);
	}

	/**
	* Returns the localized name of this marketing event sponsor level in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized name of this marketing event sponsor level. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getName(java.util.Locale locale, boolean useDefault) {
		return _marketingEventSponsorLevel.getName(locale, useDefault);
	}

	/**
	* Returns the localized name of this marketing event sponsor level in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized name of this marketing event sponsor level
	*/
	@Override
	public java.lang.String getName(java.lang.String languageId) {
		return _marketingEventSponsorLevel.getName(languageId);
	}

	/**
	* Returns the localized name of this marketing event sponsor level in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized name of this marketing event sponsor level
	*/
	@Override
	public java.lang.String getName(java.lang.String languageId,
		boolean useDefault) {
		return _marketingEventSponsorLevel.getName(languageId, useDefault);
	}

	@Override
	public java.lang.String getNameCurrentLanguageId() {
		return _marketingEventSponsorLevel.getNameCurrentLanguageId();
	}

	@Override
	public java.lang.String getNameCurrentValue() {
		return _marketingEventSponsorLevel.getNameCurrentValue();
	}

	/**
	* Returns a map of the locales and localized names of this marketing event sponsor level.
	*
	* @return the locales and localized names of this marketing event sponsor level
	*/
	@Override
	public Map<java.util.Locale, java.lang.String> getNameMap() {
		return _marketingEventSponsorLevel.getNameMap();
	}

	/**
	* Returns the primary key of this marketing event sponsor level.
	*
	* @return the primary key of this marketing event sponsor level
	*/
	@Override
	public long getPrimaryKey() {
		return _marketingEventSponsorLevel.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _marketingEventSponsorLevel.getPrimaryKeyObj();
	}

	/**
	* Returns the priority of this marketing event sponsor level.
	*
	* @return the priority of this marketing event sponsor level
	*/
	@Override
	public int getPriority() {
		return _marketingEventSponsorLevel.getPriority();
	}

	/**
	* Returns the user ID of this marketing event sponsor level.
	*
	* @return the user ID of this marketing event sponsor level
	*/
	@Override
	public long getUserId() {
		return _marketingEventSponsorLevel.getUserId();
	}

	/**
	* Returns the user name of this marketing event sponsor level.
	*
	* @return the user name of this marketing event sponsor level
	*/
	@Override
	public java.lang.String getUserName() {
		return _marketingEventSponsorLevel.getUserName();
	}

	/**
	* Returns the user uuid of this marketing event sponsor level.
	*
	* @return the user uuid of this marketing event sponsor level
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _marketingEventSponsorLevel.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _marketingEventSponsorLevel.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _marketingEventSponsorLevel.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _marketingEventSponsorLevel.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _marketingEventSponsorLevel.isNew();
	}

	@Override
	public void persist() {
		_marketingEventSponsorLevel.persist();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.kernel.exception.LocaleException {
		_marketingEventSponsorLevel.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.kernel.exception.LocaleException {
		_marketingEventSponsorLevel.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_marketingEventSponsorLevel.setCachedModel(cachedModel);
	}

	/**
	* Sets the create date of this marketing event sponsor level.
	*
	* @param createDate the create date of this marketing event sponsor level
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_marketingEventSponsorLevel.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_marketingEventSponsorLevel.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_marketingEventSponsorLevel.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_marketingEventSponsorLevel.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the marketing event ID of this marketing event sponsor level.
	*
	* @param marketingEventId the marketing event ID of this marketing event sponsor level
	*/
	@Override
	public void setMarketingEventId(long marketingEventId) {
		_marketingEventSponsorLevel.setMarketingEventId(marketingEventId);
	}

	/**
	* Sets the marketing event sponsor level ID of this marketing event sponsor level.
	*
	* @param marketingEventSponsorLevelId the marketing event sponsor level ID of this marketing event sponsor level
	*/
	@Override
	public void setMarketingEventSponsorLevelId(
		long marketingEventSponsorLevelId) {
		_marketingEventSponsorLevel.setMarketingEventSponsorLevelId(marketingEventSponsorLevelId);
	}

	/**
	* Sets the modified date of this marketing event sponsor level.
	*
	* @param modifiedDate the modified date of this marketing event sponsor level
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_marketingEventSponsorLevel.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the name of this marketing event sponsor level.
	*
	* @param name the name of this marketing event sponsor level
	*/
	@Override
	public void setName(java.lang.String name) {
		_marketingEventSponsorLevel.setName(name);
	}

	/**
	* Sets the localized name of this marketing event sponsor level in the language.
	*
	* @param name the localized name of this marketing event sponsor level
	* @param locale the locale of the language
	*/
	@Override
	public void setName(java.lang.String name, java.util.Locale locale) {
		_marketingEventSponsorLevel.setName(name, locale);
	}

	/**
	* Sets the localized name of this marketing event sponsor level in the language, and sets the default locale.
	*
	* @param name the localized name of this marketing event sponsor level
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setName(java.lang.String name, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_marketingEventSponsorLevel.setName(name, locale, defaultLocale);
	}

	@Override
	public void setNameCurrentLanguageId(java.lang.String languageId) {
		_marketingEventSponsorLevel.setNameCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized names of this marketing event sponsor level from the map of locales and localized names.
	*
	* @param nameMap the locales and localized names of this marketing event sponsor level
	*/
	@Override
	public void setNameMap(Map<java.util.Locale, java.lang.String> nameMap) {
		_marketingEventSponsorLevel.setNameMap(nameMap);
	}

	/**
	* Sets the localized names of this marketing event sponsor level from the map of locales and localized names, and sets the default locale.
	*
	* @param nameMap the locales and localized names of this marketing event sponsor level
	* @param defaultLocale the default locale
	*/
	@Override
	public void setNameMap(Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Locale defaultLocale) {
		_marketingEventSponsorLevel.setNameMap(nameMap, defaultLocale);
	}

	@Override
	public void setNew(boolean n) {
		_marketingEventSponsorLevel.setNew(n);
	}

	/**
	* Sets the primary key of this marketing event sponsor level.
	*
	* @param primaryKey the primary key of this marketing event sponsor level
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_marketingEventSponsorLevel.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_marketingEventSponsorLevel.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the priority of this marketing event sponsor level.
	*
	* @param priority the priority of this marketing event sponsor level
	*/
	@Override
	public void setPriority(int priority) {
		_marketingEventSponsorLevel.setPriority(priority);
	}

	/**
	* Sets the user ID of this marketing event sponsor level.
	*
	* @param userId the user ID of this marketing event sponsor level
	*/
	@Override
	public void setUserId(long userId) {
		_marketingEventSponsorLevel.setUserId(userId);
	}

	/**
	* Sets the user name of this marketing event sponsor level.
	*
	* @param userName the user name of this marketing event sponsor level
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_marketingEventSponsorLevel.setUserName(userName);
	}

	/**
	* Sets the user uuid of this marketing event sponsor level.
	*
	* @param userUuid the user uuid of this marketing event sponsor level
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_marketingEventSponsorLevel.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<MarketingEventSponsorLevel> toCacheModel() {
		return _marketingEventSponsorLevel.toCacheModel();
	}

	@Override
	public MarketingEventSponsorLevel toEscapedModel() {
		return new MarketingEventSponsorLevelWrapper(_marketingEventSponsorLevel.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _marketingEventSponsorLevel.toString();
	}

	@Override
	public MarketingEventSponsorLevel toUnescapedModel() {
		return new MarketingEventSponsorLevelWrapper(_marketingEventSponsorLevel.toUnescapedModel());
	}

	@Override
	public java.lang.String toXmlString() {
		return _marketingEventSponsorLevel.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MarketingEventSponsorLevelWrapper)) {
			return false;
		}

		MarketingEventSponsorLevelWrapper marketingEventSponsorLevelWrapper = (MarketingEventSponsorLevelWrapper)obj;

		if (Objects.equals(_marketingEventSponsorLevel,
					marketingEventSponsorLevelWrapper._marketingEventSponsorLevel)) {
			return true;
		}

		return false;
	}

	@Override
	public MarketingEventSponsorLevel getWrappedModel() {
		return _marketingEventSponsorLevel;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _marketingEventSponsorLevel.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _marketingEventSponsorLevel.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_marketingEventSponsorLevel.resetOriginalValues();
	}

	private final MarketingEventSponsorLevel _marketingEventSponsorLevel;
}