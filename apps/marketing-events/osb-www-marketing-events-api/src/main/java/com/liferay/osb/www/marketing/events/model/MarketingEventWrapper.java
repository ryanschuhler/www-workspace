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
 * This class is a wrapper for {@link MarketingEvent}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEvent
 * @generated
 */
@ProviderType
public class MarketingEventWrapper implements MarketingEvent,
	ModelWrapper<MarketingEvent> {
	public MarketingEventWrapper(MarketingEvent marketingEvent) {
		_marketingEvent = marketingEvent;
	}

	@Override
	public Class<?> getModelClass() {
		return MarketingEvent.class;
	}

	@Override
	public String getModelClassName() {
		return MarketingEvent.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("marketingEventId", getMarketingEventId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("type", getType());
		attributes.put("title", getTitle());
		attributes.put("titleURL", getTitleURL());
		attributes.put("hostedBy", getHostedBy());
		attributes.put("hostedByURL", getHostedByURL());
		attributes.put("summary", getSummary());
		attributes.put("siteGroupId", getSiteGroupId());
		attributes.put("imageFileEntryId", getImageFileEntryId());
		attributes.put("slidesFileEntryId", getSlidesFileEntryId());
		attributes.put("videoTitle", getVideoTitle());
		attributes.put("timeZoneId", getTimeZoneId());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("dateTBA", getDateTBA());
		attributes.put("addressId", getAddressId());
		attributes.put("latitude", getLatitude());
		attributes.put("longitude", getLongitude());
		attributes.put("globalRegion", getGlobalRegion());
		attributes.put("online", getOnline());
		attributes.put("registrationType", getRegistrationType());
		attributes.put("registrationURL", getRegistrationURL());
		attributes.put("extraSettings", getExtraSettings());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long marketingEventId = (Long)attributes.get("marketingEventId");

		if (marketingEventId != null) {
			setMarketingEventId(marketingEventId);
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

		Integer type = (Integer)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String titleURL = (String)attributes.get("titleURL");

		if (titleURL != null) {
			setTitleURL(titleURL);
		}

		String hostedBy = (String)attributes.get("hostedBy");

		if (hostedBy != null) {
			setHostedBy(hostedBy);
		}

		String hostedByURL = (String)attributes.get("hostedByURL");

		if (hostedByURL != null) {
			setHostedByURL(hostedByURL);
		}

		String summary = (String)attributes.get("summary");

		if (summary != null) {
			setSummary(summary);
		}

		Long siteGroupId = (Long)attributes.get("siteGroupId");

		if (siteGroupId != null) {
			setSiteGroupId(siteGroupId);
		}

		Long imageFileEntryId = (Long)attributes.get("imageFileEntryId");

		if (imageFileEntryId != null) {
			setImageFileEntryId(imageFileEntryId);
		}

		Long slidesFileEntryId = (Long)attributes.get("slidesFileEntryId");

		if (slidesFileEntryId != null) {
			setSlidesFileEntryId(slidesFileEntryId);
		}

		String videoTitle = (String)attributes.get("videoTitle");

		if (videoTitle != null) {
			setVideoTitle(videoTitle);
		}

		String timeZoneId = (String)attributes.get("timeZoneId");

		if (timeZoneId != null) {
			setTimeZoneId(timeZoneId);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Boolean dateTBA = (Boolean)attributes.get("dateTBA");

		if (dateTBA != null) {
			setDateTBA(dateTBA);
		}

		Long addressId = (Long)attributes.get("addressId");

		if (addressId != null) {
			setAddressId(addressId);
		}

		Double latitude = (Double)attributes.get("latitude");

		if (latitude != null) {
			setLatitude(latitude);
		}

		Double longitude = (Double)attributes.get("longitude");

		if (longitude != null) {
			setLongitude(longitude);
		}

		Integer globalRegion = (Integer)attributes.get("globalRegion");

		if (globalRegion != null) {
			setGlobalRegion(globalRegion);
		}

		Boolean online = (Boolean)attributes.get("online");

		if (online != null) {
			setOnline(online);
		}

		Integer registrationType = (Integer)attributes.get("registrationType");

		if (registrationType != null) {
			setRegistrationType(registrationType);
		}

		String registrationURL = (String)attributes.get("registrationURL");

		if (registrationURL != null) {
			setRegistrationURL(registrationURL);
		}

		String extraSettings = (String)attributes.get("extraSettings");

		if (extraSettings != null) {
			setExtraSettings(extraSettings);
		}
	}

	@Override
	public java.lang.Object clone() {
		return new MarketingEventWrapper((MarketingEvent)_marketingEvent.clone());
	}

	@Override
	public int compareTo(MarketingEvent marketingEvent) {
		return _marketingEvent.compareTo(marketingEvent);
	}

	@Override
	public com.liferay.portal.kernel.model.Address getAddress() {
		return _marketingEvent.getAddress();
	}

	/**
	* Returns the address ID of this marketing event.
	*
	* @return the address ID of this marketing event
	*/
	@Override
	public long getAddressId() {
		return _marketingEvent.getAddressId();
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _marketingEvent.getAvailableLanguageIds();
	}

	/**
	* Returns the company ID of this marketing event.
	*
	* @return the company ID of this marketing event
	*/
	@Override
	public long getCompanyId() {
		return _marketingEvent.getCompanyId();
	}

	@Override
	public com.liferay.portal.kernel.model.Country getCountry() {
		return _marketingEvent.getCountry();
	}

	/**
	* Returns the create date of this marketing event.
	*
	* @return the create date of this marketing event
	*/
	@Override
	public Date getCreateDate() {
		return _marketingEvent.getCreateDate();
	}

	/**
	* Returns the date tba of this marketing event.
	*
	* @return the date tba of this marketing event
	*/
	@Override
	public boolean getDateTBA() {
		return _marketingEvent.getDateTBA();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _marketingEvent.getDefaultLanguageId();
	}

	/**
	* Returns the end date of this marketing event.
	*
	* @return the end date of this marketing event
	*/
	@Override
	public Date getEndDate() {
		return _marketingEvent.getEndDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _marketingEvent.getExpandoBridge();
	}

	/**
	* Returns the extra settings of this marketing event.
	*
	* @return the extra settings of this marketing event
	*/
	@Override
	public java.lang.String getExtraSettings() {
		return _marketingEvent.getExtraSettings();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getExtraSettingsJSONObject() {
		return _marketingEvent.getExtraSettingsJSONObject();
	}

	@Override
	public com.liferay.portal.kernel.util.UnicodeProperties getExtraSettingsProperties() {
		return _marketingEvent.getExtraSettingsProperties();
	}

	/**
	* Returns the global region of this marketing event.
	*
	* @return the global region of this marketing event
	*/
	@Override
	public int getGlobalRegion() {
		return _marketingEvent.getGlobalRegion();
	}

	/**
	* Returns the hosted by of this marketing event.
	*
	* @return the hosted by of this marketing event
	*/
	@Override
	public java.lang.String getHostedBy() {
		return _marketingEvent.getHostedBy();
	}

	/**
	* Returns the hosted by url of this marketing event.
	*
	* @return the hosted by url of this marketing event
	*/
	@Override
	public java.lang.String getHostedByURL() {
		return _marketingEvent.getHostedByURL();
	}

	@Override
	public com.liferay.portal.kernel.repository.model.FileEntry getImageFileEntry() {
		return _marketingEvent.getImageFileEntry();
	}

	/**
	* Returns the image file entry ID of this marketing event.
	*
	* @return the image file entry ID of this marketing event
	*/
	@Override
	public long getImageFileEntryId() {
		return _marketingEvent.getImageFileEntryId();
	}

	@Override
	public java.lang.String getImageFileEntryURL() {
		return _marketingEvent.getImageFileEntryURL();
	}

	/**
	* Returns the latitude of this marketing event.
	*
	* @return the latitude of this marketing event
	*/
	@Override
	public double getLatitude() {
		return _marketingEvent.getLatitude();
	}

	/**
	* Returns the longitude of this marketing event.
	*
	* @return the longitude of this marketing event
	*/
	@Override
	public double getLongitude() {
		return _marketingEvent.getLongitude();
	}

	/**
	* Returns the marketing event ID of this marketing event.
	*
	* @return the marketing event ID of this marketing event
	*/
	@Override
	public long getMarketingEventId() {
		return _marketingEvent.getMarketingEventId();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getMarketingEventSessionAssetCategoriesJSONObject()
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEvent.getMarketingEventSessionAssetCategoriesJSONObject();
	}

	/**
	* Returns the modified date of this marketing event.
	*
	* @return the modified date of this marketing event
	*/
	@Override
	public Date getModifiedDate() {
		return _marketingEvent.getModifiedDate();
	}

	/**
	* Returns the online of this marketing event.
	*
	* @return the online of this marketing event
	*/
	@Override
	public boolean getOnline() {
		return _marketingEvent.getOnline();
	}

	/**
	* Returns the primary key of this marketing event.
	*
	* @return the primary key of this marketing event
	*/
	@Override
	public long getPrimaryKey() {
		return _marketingEvent.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _marketingEvent.getPrimaryKeyObj();
	}

	/**
	* Returns the registration type of this marketing event.
	*
	* @return the registration type of this marketing event
	*/
	@Override
	public int getRegistrationType() {
		return _marketingEvent.getRegistrationType();
	}

	/**
	* Returns the registration url of this marketing event.
	*
	* @return the registration url of this marketing event
	*/
	@Override
	public java.lang.String getRegistrationURL() {
		return _marketingEvent.getRegistrationURL();
	}

	/**
	* Returns the site group ID of this marketing event.
	*
	* @return the site group ID of this marketing event
	*/
	@Override
	public long getSiteGroupId() {
		return _marketingEvent.getSiteGroupId();
	}

	@Override
	public com.liferay.portal.kernel.repository.model.FileEntry getSlidesFileEntry() {
		return _marketingEvent.getSlidesFileEntry();
	}

	/**
	* Returns the slides file entry ID of this marketing event.
	*
	* @return the slides file entry ID of this marketing event
	*/
	@Override
	public long getSlidesFileEntryId() {
		return _marketingEvent.getSlidesFileEntryId();
	}

	/**
	* Returns the start date of this marketing event.
	*
	* @return the start date of this marketing event
	*/
	@Override
	public Date getStartDate() {
		return _marketingEvent.getStartDate();
	}

	/**
	* Returns the summary of this marketing event.
	*
	* @return the summary of this marketing event
	*/
	@Override
	public java.lang.String getSummary() {
		return _marketingEvent.getSummary();
	}

	/**
	* Returns the localized summary of this marketing event in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized summary of this marketing event
	*/
	@Override
	public java.lang.String getSummary(java.util.Locale locale) {
		return _marketingEvent.getSummary(locale);
	}

	/**
	* Returns the localized summary of this marketing event in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized summary of this marketing event. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getSummary(java.util.Locale locale,
		boolean useDefault) {
		return _marketingEvent.getSummary(locale, useDefault);
	}

	/**
	* Returns the localized summary of this marketing event in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized summary of this marketing event
	*/
	@Override
	public java.lang.String getSummary(java.lang.String languageId) {
		return _marketingEvent.getSummary(languageId);
	}

	/**
	* Returns the localized summary of this marketing event in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized summary of this marketing event
	*/
	@Override
	public java.lang.String getSummary(java.lang.String languageId,
		boolean useDefault) {
		return _marketingEvent.getSummary(languageId, useDefault);
	}

	@Override
	public java.lang.String getSummaryCurrentLanguageId() {
		return _marketingEvent.getSummaryCurrentLanguageId();
	}

	@Override
	public java.lang.String getSummaryCurrentValue() {
		return _marketingEvent.getSummaryCurrentValue();
	}

	/**
	* Returns a map of the locales and localized summaries of this marketing event.
	*
	* @return the locales and localized summaries of this marketing event
	*/
	@Override
	public Map<java.util.Locale, java.lang.String> getSummaryMap() {
		return _marketingEvent.getSummaryMap();
	}

	/**
	* Returns the time zone ID of this marketing event.
	*
	* @return the time zone ID of this marketing event
	*/
	@Override
	public java.lang.String getTimeZoneId() {
		return _marketingEvent.getTimeZoneId();
	}

	/**
	* Returns the title of this marketing event.
	*
	* @return the title of this marketing event
	*/
	@Override
	public java.lang.String getTitle() {
		return _marketingEvent.getTitle();
	}

	/**
	* Returns the localized title of this marketing event in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized title of this marketing event
	*/
	@Override
	public java.lang.String getTitle(java.util.Locale locale) {
		return _marketingEvent.getTitle(locale);
	}

	/**
	* Returns the localized title of this marketing event in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized title of this marketing event. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getTitle(java.util.Locale locale, boolean useDefault) {
		return _marketingEvent.getTitle(locale, useDefault);
	}

	/**
	* Returns the localized title of this marketing event in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized title of this marketing event
	*/
	@Override
	public java.lang.String getTitle(java.lang.String languageId) {
		return _marketingEvent.getTitle(languageId);
	}

	/**
	* Returns the localized title of this marketing event in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized title of this marketing event
	*/
	@Override
	public java.lang.String getTitle(java.lang.String languageId,
		boolean useDefault) {
		return _marketingEvent.getTitle(languageId, useDefault);
	}

	@Override
	public java.lang.String getTitleCurrentLanguageId() {
		return _marketingEvent.getTitleCurrentLanguageId();
	}

	@Override
	public java.lang.String getTitleCurrentValue() {
		return _marketingEvent.getTitleCurrentValue();
	}

	/**
	* Returns a map of the locales and localized titles of this marketing event.
	*
	* @return the locales and localized titles of this marketing event
	*/
	@Override
	public Map<java.util.Locale, java.lang.String> getTitleMap() {
		return _marketingEvent.getTitleMap();
	}

	/**
	* Returns the title url of this marketing event.
	*
	* @return the title url of this marketing event
	*/
	@Override
	public java.lang.String getTitleURL() {
		return _marketingEvent.getTitleURL();
	}

	/**
	* Returns the type of this marketing event.
	*
	* @return the type of this marketing event
	*/
	@Override
	public int getType() {
		return _marketingEvent.getType();
	}

	/**
	* Returns the user ID of this marketing event.
	*
	* @return the user ID of this marketing event
	*/
	@Override
	public long getUserId() {
		return _marketingEvent.getUserId();
	}

	/**
	* Returns the user name of this marketing event.
	*
	* @return the user name of this marketing event
	*/
	@Override
	public java.lang.String getUserName() {
		return _marketingEvent.getUserName();
	}

	/**
	* Returns the user uuid of this marketing event.
	*
	* @return the user uuid of this marketing event
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _marketingEvent.getUserUuid();
	}

	/**
	* Returns the video title of this marketing event.
	*
	* @return the video title of this marketing event
	*/
	@Override
	public java.lang.String getVideoTitle() {
		return _marketingEvent.getVideoTitle();
	}

	@Override
	public java.lang.String getVideoURL(java.lang.String extension) {
		return _marketingEvent.getVideoURL(extension);
	}

	@Override
	public int hashCode() {
		return _marketingEvent.hashCode();
	}

	@Override
	public boolean hasVideo() {
		return _marketingEvent.hasVideo();
	}

	@Override
	public boolean isCachedModel() {
		return _marketingEvent.isCachedModel();
	}

	/**
	* Returns <code>true</code> if this marketing event is date tba.
	*
	* @return <code>true</code> if this marketing event is date tba; <code>false</code> otherwise
	*/
	@Override
	public boolean isDateTBA() {
		return _marketingEvent.isDateTBA();
	}

	@Override
	public boolean isEscapedModel() {
		return _marketingEvent.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _marketingEvent.isNew();
	}

	/**
	* Returns <code>true</code> if this marketing event is online.
	*
	* @return <code>true</code> if this marketing event is online; <code>false</code> otherwise
	*/
	@Override
	public boolean isOnline() {
		return _marketingEvent.isOnline();
	}

	@Override
	public boolean isTypeCommunity() {
		return _marketingEvent.isTypeCommunity();
	}

	@Override
	public boolean isTypeConference() {
		return _marketingEvent.isTypeConference();
	}

	@Override
	public boolean isTypeIndustry() {
		return _marketingEvent.isTypeIndustry();
	}

	@Override
	public boolean isTypePartner() {
		return _marketingEvent.isTypePartner();
	}

	@Override
	public boolean isTypeRoadshow() {
		return _marketingEvent.isTypeRoadshow();
	}

	@Override
	public boolean isTypeWebinar() {
		return _marketingEvent.isTypeWebinar();
	}

	@Override
	public void persist() {
		_marketingEvent.persist();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.kernel.exception.LocaleException {
		_marketingEvent.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.kernel.exception.LocaleException {
		_marketingEvent.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	/**
	* Sets the address ID of this marketing event.
	*
	* @param addressId the address ID of this marketing event
	*/
	@Override
	public void setAddressId(long addressId) {
		_marketingEvent.setAddressId(addressId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_marketingEvent.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this marketing event.
	*
	* @param companyId the company ID of this marketing event
	*/
	@Override
	public void setCompanyId(long companyId) {
		_marketingEvent.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this marketing event.
	*
	* @param createDate the create date of this marketing event
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_marketingEvent.setCreateDate(createDate);
	}

	/**
	* Sets whether this marketing event is date tba.
	*
	* @param dateTBA the date tba of this marketing event
	*/
	@Override
	public void setDateTBA(boolean dateTBA) {
		_marketingEvent.setDateTBA(dateTBA);
	}

	/**
	* Sets the end date of this marketing event.
	*
	* @param endDate the end date of this marketing event
	*/
	@Override
	public void setEndDate(Date endDate) {
		_marketingEvent.setEndDate(endDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_marketingEvent.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_marketingEvent.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_marketingEvent.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the extra settings of this marketing event.
	*
	* @param extraSettings the extra settings of this marketing event
	*/
	@Override
	public void setExtraSettings(java.lang.String extraSettings) {
		_marketingEvent.setExtraSettings(extraSettings);
	}

	/**
	* Sets the global region of this marketing event.
	*
	* @param globalRegion the global region of this marketing event
	*/
	@Override
	public void setGlobalRegion(int globalRegion) {
		_marketingEvent.setGlobalRegion(globalRegion);
	}

	/**
	* Sets the hosted by of this marketing event.
	*
	* @param hostedBy the hosted by of this marketing event
	*/
	@Override
	public void setHostedBy(java.lang.String hostedBy) {
		_marketingEvent.setHostedBy(hostedBy);
	}

	/**
	* Sets the hosted by url of this marketing event.
	*
	* @param hostedByURL the hosted by url of this marketing event
	*/
	@Override
	public void setHostedByURL(java.lang.String hostedByURL) {
		_marketingEvent.setHostedByURL(hostedByURL);
	}

	/**
	* Sets the image file entry ID of this marketing event.
	*
	* @param imageFileEntryId the image file entry ID of this marketing event
	*/
	@Override
	public void setImageFileEntryId(long imageFileEntryId) {
		_marketingEvent.setImageFileEntryId(imageFileEntryId);
	}

	/**
	* Sets the latitude of this marketing event.
	*
	* @param latitude the latitude of this marketing event
	*/
	@Override
	public void setLatitude(double latitude) {
		_marketingEvent.setLatitude(latitude);
	}

	/**
	* Sets the longitude of this marketing event.
	*
	* @param longitude the longitude of this marketing event
	*/
	@Override
	public void setLongitude(double longitude) {
		_marketingEvent.setLongitude(longitude);
	}

	/**
	* Sets the marketing event ID of this marketing event.
	*
	* @param marketingEventId the marketing event ID of this marketing event
	*/
	@Override
	public void setMarketingEventId(long marketingEventId) {
		_marketingEvent.setMarketingEventId(marketingEventId);
	}

	/**
	* Sets the modified date of this marketing event.
	*
	* @param modifiedDate the modified date of this marketing event
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_marketingEvent.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_marketingEvent.setNew(n);
	}

	/**
	* Sets whether this marketing event is online.
	*
	* @param online the online of this marketing event
	*/
	@Override
	public void setOnline(boolean online) {
		_marketingEvent.setOnline(online);
	}

	/**
	* Sets the primary key of this marketing event.
	*
	* @param primaryKey the primary key of this marketing event
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_marketingEvent.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_marketingEvent.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the registration type of this marketing event.
	*
	* @param registrationType the registration type of this marketing event
	*/
	@Override
	public void setRegistrationType(int registrationType) {
		_marketingEvent.setRegistrationType(registrationType);
	}

	/**
	* Sets the registration url of this marketing event.
	*
	* @param registrationURL the registration url of this marketing event
	*/
	@Override
	public void setRegistrationURL(java.lang.String registrationURL) {
		_marketingEvent.setRegistrationURL(registrationURL);
	}

	/**
	* Sets the site group ID of this marketing event.
	*
	* @param siteGroupId the site group ID of this marketing event
	*/
	@Override
	public void setSiteGroupId(long siteGroupId) {
		_marketingEvent.setSiteGroupId(siteGroupId);
	}

	/**
	* Sets the slides file entry ID of this marketing event.
	*
	* @param slidesFileEntryId the slides file entry ID of this marketing event
	*/
	@Override
	public void setSlidesFileEntryId(long slidesFileEntryId) {
		_marketingEvent.setSlidesFileEntryId(slidesFileEntryId);
	}

	/**
	* Sets the start date of this marketing event.
	*
	* @param startDate the start date of this marketing event
	*/
	@Override
	public void setStartDate(Date startDate) {
		_marketingEvent.setStartDate(startDate);
	}

	/**
	* Sets the summary of this marketing event.
	*
	* @param summary the summary of this marketing event
	*/
	@Override
	public void setSummary(java.lang.String summary) {
		_marketingEvent.setSummary(summary);
	}

	/**
	* Sets the localized summary of this marketing event in the language.
	*
	* @param summary the localized summary of this marketing event
	* @param locale the locale of the language
	*/
	@Override
	public void setSummary(java.lang.String summary, java.util.Locale locale) {
		_marketingEvent.setSummary(summary, locale);
	}

	/**
	* Sets the localized summary of this marketing event in the language, and sets the default locale.
	*
	* @param summary the localized summary of this marketing event
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setSummary(java.lang.String summary, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_marketingEvent.setSummary(summary, locale, defaultLocale);
	}

	@Override
	public void setSummaryCurrentLanguageId(java.lang.String languageId) {
		_marketingEvent.setSummaryCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized summaries of this marketing event from the map of locales and localized summaries.
	*
	* @param summaryMap the locales and localized summaries of this marketing event
	*/
	@Override
	public void setSummaryMap(
		Map<java.util.Locale, java.lang.String> summaryMap) {
		_marketingEvent.setSummaryMap(summaryMap);
	}

	/**
	* Sets the localized summaries of this marketing event from the map of locales and localized summaries, and sets the default locale.
	*
	* @param summaryMap the locales and localized summaries of this marketing event
	* @param defaultLocale the default locale
	*/
	@Override
	public void setSummaryMap(
		Map<java.util.Locale, java.lang.String> summaryMap,
		java.util.Locale defaultLocale) {
		_marketingEvent.setSummaryMap(summaryMap, defaultLocale);
	}

	/**
	* Sets the time zone ID of this marketing event.
	*
	* @param timeZoneId the time zone ID of this marketing event
	*/
	@Override
	public void setTimeZoneId(java.lang.String timeZoneId) {
		_marketingEvent.setTimeZoneId(timeZoneId);
	}

	/**
	* Sets the title of this marketing event.
	*
	* @param title the title of this marketing event
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_marketingEvent.setTitle(title);
	}

	/**
	* Sets the localized title of this marketing event in the language.
	*
	* @param title the localized title of this marketing event
	* @param locale the locale of the language
	*/
	@Override
	public void setTitle(java.lang.String title, java.util.Locale locale) {
		_marketingEvent.setTitle(title, locale);
	}

	/**
	* Sets the localized title of this marketing event in the language, and sets the default locale.
	*
	* @param title the localized title of this marketing event
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setTitle(java.lang.String title, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_marketingEvent.setTitle(title, locale, defaultLocale);
	}

	@Override
	public void setTitleCurrentLanguageId(java.lang.String languageId) {
		_marketingEvent.setTitleCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized titles of this marketing event from the map of locales and localized titles.
	*
	* @param titleMap the locales and localized titles of this marketing event
	*/
	@Override
	public void setTitleMap(Map<java.util.Locale, java.lang.String> titleMap) {
		_marketingEvent.setTitleMap(titleMap);
	}

	/**
	* Sets the localized titles of this marketing event from the map of locales and localized titles, and sets the default locale.
	*
	* @param titleMap the locales and localized titles of this marketing event
	* @param defaultLocale the default locale
	*/
	@Override
	public void setTitleMap(Map<java.util.Locale, java.lang.String> titleMap,
		java.util.Locale defaultLocale) {
		_marketingEvent.setTitleMap(titleMap, defaultLocale);
	}

	/**
	* Sets the title url of this marketing event.
	*
	* @param titleURL the title url of this marketing event
	*/
	@Override
	public void setTitleURL(java.lang.String titleURL) {
		_marketingEvent.setTitleURL(titleURL);
	}

	/**
	* Sets the type of this marketing event.
	*
	* @param type the type of this marketing event
	*/
	@Override
	public void setType(int type) {
		_marketingEvent.setType(type);
	}

	/**
	* Sets the user ID of this marketing event.
	*
	* @param userId the user ID of this marketing event
	*/
	@Override
	public void setUserId(long userId) {
		_marketingEvent.setUserId(userId);
	}

	/**
	* Sets the user name of this marketing event.
	*
	* @param userName the user name of this marketing event
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_marketingEvent.setUserName(userName);
	}

	/**
	* Sets the user uuid of this marketing event.
	*
	* @param userUuid the user uuid of this marketing event
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_marketingEvent.setUserUuid(userUuid);
	}

	/**
	* Sets the video title of this marketing event.
	*
	* @param videoTitle the video title of this marketing event
	*/
	@Override
	public void setVideoTitle(java.lang.String videoTitle) {
		_marketingEvent.setVideoTitle(videoTitle);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<MarketingEvent> toCacheModel() {
		return _marketingEvent.toCacheModel();
	}

	@Override
	public MarketingEvent toEscapedModel() {
		return new MarketingEventWrapper(_marketingEvent.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _marketingEvent.toString();
	}

	@Override
	public MarketingEvent toUnescapedModel() {
		return new MarketingEventWrapper(_marketingEvent.toUnescapedModel());
	}

	@Override
	public java.lang.String toXmlString() {
		return _marketingEvent.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MarketingEventWrapper)) {
			return false;
		}

		MarketingEventWrapper marketingEventWrapper = (MarketingEventWrapper)obj;

		if (Objects.equals(_marketingEvent,
					marketingEventWrapper._marketingEvent)) {
			return true;
		}

		return false;
	}

	@Override
	public MarketingEvent getWrappedModel() {
		return _marketingEvent;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _marketingEvent.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _marketingEvent.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_marketingEvent.resetOriginalValues();
	}

	private final MarketingEvent _marketingEvent;
}