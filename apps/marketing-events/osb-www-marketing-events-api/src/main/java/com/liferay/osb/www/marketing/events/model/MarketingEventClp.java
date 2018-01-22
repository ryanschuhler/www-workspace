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

import com.liferay.osb.www.marketing.events.service.ClpSerializer;
import com.liferay.osb.www.marketing.events.service.MarketingEventLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @generated
 */
@ProviderType
public class MarketingEventClp extends BaseModelImpl<MarketingEvent>
	implements MarketingEvent {
	public MarketingEventClp() {
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
	public long getPrimaryKey() {
		return _marketingEventId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMarketingEventId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _marketingEventId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

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

		_entityCacheEnabled = GetterUtil.getBoolean("entityCacheEnabled");
		_finderCacheEnabled = GetterUtil.getBoolean("finderCacheEnabled");
	}

	@Override
	public long getMarketingEventId() {
		return _marketingEventId;
	}

	@Override
	public void setMarketingEventId(long marketingEventId) {
		_marketingEventId = marketingEventId;

		if (_marketingEventRemoteModel != null) {
			try {
				Class<?> clazz = _marketingEventRemoteModel.getClass();

				Method method = clazz.getMethod("setMarketingEventId",
						long.class);

				method.invoke(_marketingEventRemoteModel, marketingEventId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_marketingEventRemoteModel != null) {
			try {
				Class<?> clazz = _marketingEventRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_marketingEventRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_marketingEventRemoteModel != null) {
			try {
				Class<?> clazz = _marketingEventRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_marketingEventRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_marketingEventRemoteModel != null) {
			try {
				Class<?> clazz = _marketingEventRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_marketingEventRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_marketingEventRemoteModel != null) {
			try {
				Class<?> clazz = _marketingEventRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_marketingEventRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_marketingEventRemoteModel != null) {
			try {
				Class<?> clazz = _marketingEventRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_marketingEventRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getType() {
		return _type;
	}

	@Override
	public void setType(int type) {
		_type = type;

		if (_marketingEventRemoteModel != null) {
			try {
				Class<?> clazz = _marketingEventRemoteModel.getClass();

				Method method = clazz.getMethod("setType", int.class);

				method.invoke(_marketingEventRemoteModel, type);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTitle() {
		return _title;
	}

	@Override
	public String getTitle(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getTitle(languageId);
	}

	@Override
	public String getTitle(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getTitle(languageId, useDefault);
	}

	@Override
	public String getTitle(String languageId) {
		return LocalizationUtil.getLocalization(getTitle(), languageId);
	}

	@Override
	public String getTitle(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getTitle(), languageId,
			useDefault);
	}

	@Override
	public String getTitleCurrentLanguageId() {
		return _titleCurrentLanguageId;
	}

	@Override
	public String getTitleCurrentValue() {
		Locale locale = getLocale(_titleCurrentLanguageId);

		return getTitle(locale);
	}

	@Override
	public Map<Locale, String> getTitleMap() {
		return LocalizationUtil.getLocalizationMap(getTitle());
	}

	@Override
	public void setTitle(String title) {
		_title = title;

		if (_marketingEventRemoteModel != null) {
			try {
				Class<?> clazz = _marketingEventRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_marketingEventRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setTitle(String title, Locale locale) {
		setTitle(title, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setTitle(String title, Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(title)) {
			setTitle(LocalizationUtil.updateLocalization(getTitle(), "Title",
					title, languageId, defaultLanguageId));
		}
		else {
			setTitle(LocalizationUtil.removeLocalization(getTitle(), "Title",
					languageId));
		}
	}

	@Override
	public void setTitleCurrentLanguageId(String languageId) {
		_titleCurrentLanguageId = languageId;
	}

	@Override
	public void setTitleMap(Map<Locale, String> titleMap) {
		setTitleMap(titleMap, LocaleUtil.getDefault());
	}

	@Override
	public void setTitleMap(Map<Locale, String> titleMap, Locale defaultLocale) {
		if (titleMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setTitle(LocalizationUtil.updateLocalization(titleMap, getTitle(),
					"Title", LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public String getTitleURL() {
		return _titleURL;
	}

	@Override
	public void setTitleURL(String titleURL) {
		_titleURL = titleURL;

		if (_marketingEventRemoteModel != null) {
			try {
				Class<?> clazz = _marketingEventRemoteModel.getClass();

				Method method = clazz.getMethod("setTitleURL", String.class);

				method.invoke(_marketingEventRemoteModel, titleURL);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHostedBy() {
		return _hostedBy;
	}

	@Override
	public void setHostedBy(String hostedBy) {
		_hostedBy = hostedBy;

		if (_marketingEventRemoteModel != null) {
			try {
				Class<?> clazz = _marketingEventRemoteModel.getClass();

				Method method = clazz.getMethod("setHostedBy", String.class);

				method.invoke(_marketingEventRemoteModel, hostedBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHostedByURL() {
		return _hostedByURL;
	}

	@Override
	public void setHostedByURL(String hostedByURL) {
		_hostedByURL = hostedByURL;

		if (_marketingEventRemoteModel != null) {
			try {
				Class<?> clazz = _marketingEventRemoteModel.getClass();

				Method method = clazz.getMethod("setHostedByURL", String.class);

				method.invoke(_marketingEventRemoteModel, hostedByURL);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSummary() {
		return _summary;
	}

	@Override
	public String getSummary(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getSummary(languageId);
	}

	@Override
	public String getSummary(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getSummary(languageId, useDefault);
	}

	@Override
	public String getSummary(String languageId) {
		return LocalizationUtil.getLocalization(getSummary(), languageId);
	}

	@Override
	public String getSummary(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getSummary(), languageId,
			useDefault);
	}

	@Override
	public String getSummaryCurrentLanguageId() {
		return _summaryCurrentLanguageId;
	}

	@Override
	public String getSummaryCurrentValue() {
		Locale locale = getLocale(_summaryCurrentLanguageId);

		return getSummary(locale);
	}

	@Override
	public Map<Locale, String> getSummaryMap() {
		return LocalizationUtil.getLocalizationMap(getSummary());
	}

	@Override
	public void setSummary(String summary) {
		_summary = summary;

		if (_marketingEventRemoteModel != null) {
			try {
				Class<?> clazz = _marketingEventRemoteModel.getClass();

				Method method = clazz.getMethod("setSummary", String.class);

				method.invoke(_marketingEventRemoteModel, summary);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setSummary(String summary, Locale locale) {
		setSummary(summary, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setSummary(String summary, Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(summary)) {
			setSummary(LocalizationUtil.updateLocalization(getSummary(),
					"Summary", summary, languageId, defaultLanguageId));
		}
		else {
			setSummary(LocalizationUtil.removeLocalization(getSummary(),
					"Summary", languageId));
		}
	}

	@Override
	public void setSummaryCurrentLanguageId(String languageId) {
		_summaryCurrentLanguageId = languageId;
	}

	@Override
	public void setSummaryMap(Map<Locale, String> summaryMap) {
		setSummaryMap(summaryMap, LocaleUtil.getDefault());
	}

	@Override
	public void setSummaryMap(Map<Locale, String> summaryMap,
		Locale defaultLocale) {
		if (summaryMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setSummary(LocalizationUtil.updateLocalization(summaryMap,
					getSummary(), "Summary",
					LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public long getSiteGroupId() {
		return _siteGroupId;
	}

	@Override
	public void setSiteGroupId(long siteGroupId) {
		_siteGroupId = siteGroupId;

		if (_marketingEventRemoteModel != null) {
			try {
				Class<?> clazz = _marketingEventRemoteModel.getClass();

				Method method = clazz.getMethod("setSiteGroupId", long.class);

				method.invoke(_marketingEventRemoteModel, siteGroupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getImageFileEntryId() {
		return _imageFileEntryId;
	}

	@Override
	public void setImageFileEntryId(long imageFileEntryId) {
		_imageFileEntryId = imageFileEntryId;

		if (_marketingEventRemoteModel != null) {
			try {
				Class<?> clazz = _marketingEventRemoteModel.getClass();

				Method method = clazz.getMethod("setImageFileEntryId",
						long.class);

				method.invoke(_marketingEventRemoteModel, imageFileEntryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSlidesFileEntryId() {
		return _slidesFileEntryId;
	}

	@Override
	public void setSlidesFileEntryId(long slidesFileEntryId) {
		_slidesFileEntryId = slidesFileEntryId;

		if (_marketingEventRemoteModel != null) {
			try {
				Class<?> clazz = _marketingEventRemoteModel.getClass();

				Method method = clazz.getMethod("setSlidesFileEntryId",
						long.class);

				method.invoke(_marketingEventRemoteModel, slidesFileEntryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVideoTitle() {
		return _videoTitle;
	}

	@Override
	public void setVideoTitle(String videoTitle) {
		_videoTitle = videoTitle;

		if (_marketingEventRemoteModel != null) {
			try {
				Class<?> clazz = _marketingEventRemoteModel.getClass();

				Method method = clazz.getMethod("setVideoTitle", String.class);

				method.invoke(_marketingEventRemoteModel, videoTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTimeZoneId() {
		return _timeZoneId;
	}

	@Override
	public void setTimeZoneId(String timeZoneId) {
		_timeZoneId = timeZoneId;

		if (_marketingEventRemoteModel != null) {
			try {
				Class<?> clazz = _marketingEventRemoteModel.getClass();

				Method method = clazz.getMethod("setTimeZoneId", String.class);

				method.invoke(_marketingEventRemoteModel, timeZoneId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getStartDate() {
		return _startDate;
	}

	@Override
	public void setStartDate(Date startDate) {
		_startDate = startDate;

		if (_marketingEventRemoteModel != null) {
			try {
				Class<?> clazz = _marketingEventRemoteModel.getClass();

				Method method = clazz.getMethod("setStartDate", Date.class);

				method.invoke(_marketingEventRemoteModel, startDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEndDate() {
		return _endDate;
	}

	@Override
	public void setEndDate(Date endDate) {
		_endDate = endDate;

		if (_marketingEventRemoteModel != null) {
			try {
				Class<?> clazz = _marketingEventRemoteModel.getClass();

				Method method = clazz.getMethod("setEndDate", Date.class);

				method.invoke(_marketingEventRemoteModel, endDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getDateTBA() {
		return _dateTBA;
	}

	@Override
	public boolean isDateTBA() {
		return _dateTBA;
	}

	@Override
	public void setDateTBA(boolean dateTBA) {
		_dateTBA = dateTBA;

		if (_marketingEventRemoteModel != null) {
			try {
				Class<?> clazz = _marketingEventRemoteModel.getClass();

				Method method = clazz.getMethod("setDateTBA", boolean.class);

				method.invoke(_marketingEventRemoteModel, dateTBA);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAddressId() {
		return _addressId;
	}

	@Override
	public void setAddressId(long addressId) {
		_addressId = addressId;

		if (_marketingEventRemoteModel != null) {
			try {
				Class<?> clazz = _marketingEventRemoteModel.getClass();

				Method method = clazz.getMethod("setAddressId", long.class);

				method.invoke(_marketingEventRemoteModel, addressId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getLatitude() {
		return _latitude;
	}

	@Override
	public void setLatitude(double latitude) {
		_latitude = latitude;

		if (_marketingEventRemoteModel != null) {
			try {
				Class<?> clazz = _marketingEventRemoteModel.getClass();

				Method method = clazz.getMethod("setLatitude", double.class);

				method.invoke(_marketingEventRemoteModel, latitude);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getLongitude() {
		return _longitude;
	}

	@Override
	public void setLongitude(double longitude) {
		_longitude = longitude;

		if (_marketingEventRemoteModel != null) {
			try {
				Class<?> clazz = _marketingEventRemoteModel.getClass();

				Method method = clazz.getMethod("setLongitude", double.class);

				method.invoke(_marketingEventRemoteModel, longitude);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getGlobalRegion() {
		return _globalRegion;
	}

	@Override
	public void setGlobalRegion(int globalRegion) {
		_globalRegion = globalRegion;

		if (_marketingEventRemoteModel != null) {
			try {
				Class<?> clazz = _marketingEventRemoteModel.getClass();

				Method method = clazz.getMethod("setGlobalRegion", int.class);

				method.invoke(_marketingEventRemoteModel, globalRegion);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getOnline() {
		return _online;
	}

	@Override
	public boolean isOnline() {
		return _online;
	}

	@Override
	public void setOnline(boolean online) {
		_online = online;

		if (_marketingEventRemoteModel != null) {
			try {
				Class<?> clazz = _marketingEventRemoteModel.getClass();

				Method method = clazz.getMethod("setOnline", boolean.class);

				method.invoke(_marketingEventRemoteModel, online);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getRegistrationType() {
		return _registrationType;
	}

	@Override
	public void setRegistrationType(int registrationType) {
		_registrationType = registrationType;

		if (_marketingEventRemoteModel != null) {
			try {
				Class<?> clazz = _marketingEventRemoteModel.getClass();

				Method method = clazz.getMethod("setRegistrationType", int.class);

				method.invoke(_marketingEventRemoteModel, registrationType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRegistrationURL() {
		return _registrationURL;
	}

	@Override
	public void setRegistrationURL(String registrationURL) {
		_registrationURL = registrationURL;

		if (_marketingEventRemoteModel != null) {
			try {
				Class<?> clazz = _marketingEventRemoteModel.getClass();

				Method method = clazz.getMethod("setRegistrationURL",
						String.class);

				method.invoke(_marketingEventRemoteModel, registrationURL);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExtraSettings() {
		return _extraSettings;
	}

	@Override
	public void setExtraSettings(String extraSettings) {
		_extraSettings = extraSettings;

		if (_marketingEventRemoteModel != null) {
			try {
				Class<?> clazz = _marketingEventRemoteModel.getClass();

				Method method = clazz.getMethod("setExtraSettings", String.class);

				method.invoke(_marketingEventRemoteModel, extraSettings);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public com.liferay.portal.kernel.model.Address getAddress() {
		try {
			String methodName = "getAddress";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			com.liferay.portal.kernel.model.Address returnObj = (com.liferay.portal.kernel.model.Address)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public com.liferay.portal.kernel.model.Country getCountry() {
		try {
			String methodName = "getCountry";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			com.liferay.portal.kernel.model.Country returnObj = (com.liferay.portal.kernel.model.Country)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getExtraSettingsJSONObject() {
		try {
			String methodName = "getExtraSettingsJSONObject";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			com.liferay.portal.kernel.json.JSONObject returnObj = (com.liferay.portal.kernel.json.JSONObject)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public com.liferay.portal.kernel.util.UnicodeProperties getExtraSettingsProperties() {
		try {
			String methodName = "getExtraSettingsProperties";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			com.liferay.portal.kernel.util.UnicodeProperties returnObj = (com.liferay.portal.kernel.util.UnicodeProperties)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public com.liferay.portal.kernel.repository.model.FileEntry getImageFileEntry() {
		try {
			String methodName = "getImageFileEntry";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			com.liferay.portal.kernel.repository.model.FileEntry returnObj = (com.liferay.portal.kernel.repository.model.FileEntry)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getImageFileEntryURL() {
		try {
			String methodName = "getImageFileEntryURL";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getMarketingEventSessionAssetCategoriesJSONObject() {
		try {
			String methodName = "getMarketingEventSessionAssetCategoriesJSONObject";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			com.liferay.portal.kernel.json.JSONObject returnObj = (com.liferay.portal.kernel.json.JSONObject)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public com.liferay.portal.kernel.repository.model.FileEntry getSlidesFileEntry() {
		try {
			String methodName = "getSlidesFileEntry";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			com.liferay.portal.kernel.repository.model.FileEntry returnObj = (com.liferay.portal.kernel.repository.model.FileEntry)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getVideoURL(java.lang.String extension) {
		try {
			String methodName = "getVideoURL";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { extension };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public boolean hasVideo() {
		try {
			String methodName = "hasVideo";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Boolean returnObj = (Boolean)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public boolean isTypeCommunity() {
		try {
			String methodName = "isTypeCommunity";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Boolean returnObj = (Boolean)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public boolean isTypeConference() {
		try {
			String methodName = "isTypeConference";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Boolean returnObj = (Boolean)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public boolean isTypeIndustry() {
		try {
			String methodName = "isTypeIndustry";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Boolean returnObj = (Boolean)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public boolean isTypePartner() {
		try {
			String methodName = "isTypePartner";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Boolean returnObj = (Boolean)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public boolean isTypeRoadshow() {
		try {
			String methodName = "isTypeRoadshow";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Boolean returnObj = (Boolean)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public boolean isTypeWebinar() {
		try {
			String methodName = "isTypeWebinar";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Boolean returnObj = (Boolean)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getMarketingEventRemoteModel() {
		return _marketingEventRemoteModel;
	}

	public void setMarketingEventRemoteModel(
		BaseModel<?> marketingEventRemoteModel) {
		_marketingEventRemoteModel = marketingEventRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _marketingEventRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_marketingEventRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() {
		if (this.isNew()) {
			MarketingEventLocalServiceUtil.addMarketingEvent(this);
		}
		else {
			MarketingEventLocalServiceUtil.updateMarketingEvent(this);
		}
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> titleMap = getTitleMap();

		for (Map.Entry<Locale, String> entry : titleMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		Map<Locale, String> summaryMap = getSummaryMap();

		for (Map.Entry<Locale, String> entry : summaryMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		return availableLanguageIds.toArray(new String[availableLanguageIds.size()]);
	}

	@Override
	public String getDefaultLanguageId() {
		String xml = getTitle();

		if (xml == null) {
			return StringPool.BLANK;
		}

		Locale defaultLocale = LocaleUtil.getDefault();

		return LocalizationUtil.getDefaultLanguageId(xml, defaultLocale);
	}

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException {
		prepareLocalizedFieldsForImport(null);
	}

	@Override
	@SuppressWarnings("unused")
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException {
		Locale defaultLocale = LocaleUtil.getDefault();

		String modelDefaultLanguageId = getDefaultLanguageId();

		String title = getTitle(defaultLocale);

		if (Validator.isNull(title)) {
			setTitle(getTitle(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setTitle(getTitle(defaultLocale), defaultLocale, defaultLocale);
		}

		String summary = getSummary(defaultLocale);

		if (Validator.isNull(summary)) {
			setSummary(getSummary(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setSummary(getSummary(defaultLocale), defaultLocale, defaultLocale);
		}
	}

	@Override
	public MarketingEvent toEscapedModel() {
		return (MarketingEvent)ProxyUtil.newProxyInstance(MarketingEvent.class.getClassLoader(),
			new Class[] { MarketingEvent.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		MarketingEventClp clone = new MarketingEventClp();

		clone.setMarketingEventId(getMarketingEventId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setType(getType());
		clone.setTitle(getTitle());
		clone.setTitleURL(getTitleURL());
		clone.setHostedBy(getHostedBy());
		clone.setHostedByURL(getHostedByURL());
		clone.setSummary(getSummary());
		clone.setSiteGroupId(getSiteGroupId());
		clone.setImageFileEntryId(getImageFileEntryId());
		clone.setSlidesFileEntryId(getSlidesFileEntryId());
		clone.setVideoTitle(getVideoTitle());
		clone.setTimeZoneId(getTimeZoneId());
		clone.setStartDate(getStartDate());
		clone.setEndDate(getEndDate());
		clone.setDateTBA(getDateTBA());
		clone.setAddressId(getAddressId());
		clone.setLatitude(getLatitude());
		clone.setLongitude(getLongitude());
		clone.setGlobalRegion(getGlobalRegion());
		clone.setOnline(getOnline());
		clone.setRegistrationType(getRegistrationType());
		clone.setRegistrationURL(getRegistrationURL());
		clone.setExtraSettings(getExtraSettings());

		return clone;
	}

	@Override
	public int compareTo(MarketingEvent marketingEvent) {
		long primaryKey = marketingEvent.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MarketingEventClp)) {
			return false;
		}

		MarketingEventClp marketingEvent = (MarketingEventClp)obj;

		long primaryKey = marketingEvent.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(57);

		sb.append("{marketingEventId=");
		sb.append(getMarketingEventId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", titleURL=");
		sb.append(getTitleURL());
		sb.append(", hostedBy=");
		sb.append(getHostedBy());
		sb.append(", hostedByURL=");
		sb.append(getHostedByURL());
		sb.append(", summary=");
		sb.append(getSummary());
		sb.append(", siteGroupId=");
		sb.append(getSiteGroupId());
		sb.append(", imageFileEntryId=");
		sb.append(getImageFileEntryId());
		sb.append(", slidesFileEntryId=");
		sb.append(getSlidesFileEntryId());
		sb.append(", videoTitle=");
		sb.append(getVideoTitle());
		sb.append(", timeZoneId=");
		sb.append(getTimeZoneId());
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append(", dateTBA=");
		sb.append(getDateTBA());
		sb.append(", addressId=");
		sb.append(getAddressId());
		sb.append(", latitude=");
		sb.append(getLatitude());
		sb.append(", longitude=");
		sb.append(getLongitude());
		sb.append(", globalRegion=");
		sb.append(getGlobalRegion());
		sb.append(", online=");
		sb.append(getOnline());
		sb.append(", registrationType=");
		sb.append(getRegistrationType());
		sb.append(", registrationURL=");
		sb.append(getRegistrationURL());
		sb.append(", extraSettings=");
		sb.append(getExtraSettings());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(88);

		sb.append("<model><model-name>");
		sb.append("com.liferay.osb.www.marketing.events.model.MarketingEvent");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>marketingEventId</column-name><column-value><![CDATA[");
		sb.append(getMarketingEventId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>titleURL</column-name><column-value><![CDATA[");
		sb.append(getTitleURL());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hostedBy</column-name><column-value><![CDATA[");
		sb.append(getHostedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hostedByURL</column-name><column-value><![CDATA[");
		sb.append(getHostedByURL());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>summary</column-name><column-value><![CDATA[");
		sb.append(getSummary());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>siteGroupId</column-name><column-value><![CDATA[");
		sb.append(getSiteGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageFileEntryId</column-name><column-value><![CDATA[");
		sb.append(getImageFileEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>slidesFileEntryId</column-name><column-value><![CDATA[");
		sb.append(getSlidesFileEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>videoTitle</column-name><column-value><![CDATA[");
		sb.append(getVideoTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>timeZoneId</column-name><column-value><![CDATA[");
		sb.append(getTimeZoneId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startDate</column-name><column-value><![CDATA[");
		sb.append(getStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endDate</column-name><column-value><![CDATA[");
		sb.append(getEndDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateTBA</column-name><column-value><![CDATA[");
		sb.append(getDateTBA());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>addressId</column-name><column-value><![CDATA[");
		sb.append(getAddressId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>latitude</column-name><column-value><![CDATA[");
		sb.append(getLatitude());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>longitude</column-name><column-value><![CDATA[");
		sb.append(getLongitude());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>globalRegion</column-name><column-value><![CDATA[");
		sb.append(getGlobalRegion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>online</column-name><column-value><![CDATA[");
		sb.append(getOnline());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>registrationType</column-name><column-value><![CDATA[");
		sb.append(getRegistrationType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>registrationURL</column-name><column-value><![CDATA[");
		sb.append(getRegistrationURL());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>extraSettings</column-name><column-value><![CDATA[");
		sb.append(getExtraSettings());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _marketingEventId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _type;
	private String _title;
	private String _titleCurrentLanguageId;
	private String _titleURL;
	private String _hostedBy;
	private String _hostedByURL;
	private String _summary;
	private String _summaryCurrentLanguageId;
	private long _siteGroupId;
	private long _imageFileEntryId;
	private long _slidesFileEntryId;
	private String _videoTitle;
	private String _timeZoneId;
	private Date _startDate;
	private Date _endDate;
	private boolean _dateTBA;
	private long _addressId;
	private double _latitude;
	private double _longitude;
	private int _globalRegion;
	private boolean _online;
	private int _registrationType;
	private String _registrationURL;
	private String _extraSettings;
	private BaseModel<?> _marketingEventRemoteModel;
	private Class<?> _clpSerializerClass = ClpSerializer.class;
	private boolean _entityCacheEnabled;
	private boolean _finderCacheEnabled;
}