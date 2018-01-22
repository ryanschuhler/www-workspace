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
import com.liferay.osb.www.marketing.events.service.MarketingEventSponsorLocalServiceUtil;

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
public class MarketingEventSponsorClp extends BaseModelImpl<MarketingEventSponsor>
	implements MarketingEventSponsor {
	public MarketingEventSponsorClp() {
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
	public long getPrimaryKey() {
		return _marketingEventSponsorId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMarketingEventSponsorId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _marketingEventSponsorId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

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

		_entityCacheEnabled = GetterUtil.getBoolean("entityCacheEnabled");
		_finderCacheEnabled = GetterUtil.getBoolean("finderCacheEnabled");
	}

	@Override
	public long getMarketingEventSponsorId() {
		return _marketingEventSponsorId;
	}

	@Override
	public void setMarketingEventSponsorId(long marketingEventSponsorId) {
		_marketingEventSponsorId = marketingEventSponsorId;

		if (_marketingEventSponsorRemoteModel != null) {
			try {
				Class<?> clazz = _marketingEventSponsorRemoteModel.getClass();

				Method method = clazz.getMethod("setMarketingEventSponsorId",
						long.class);

				method.invoke(_marketingEventSponsorRemoteModel,
					marketingEventSponsorId);
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

		if (_marketingEventSponsorRemoteModel != null) {
			try {
				Class<?> clazz = _marketingEventSponsorRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_marketingEventSponsorRemoteModel, userId);
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

		if (_marketingEventSponsorRemoteModel != null) {
			try {
				Class<?> clazz = _marketingEventSponsorRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_marketingEventSponsorRemoteModel, userName);
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

		if (_marketingEventSponsorRemoteModel != null) {
			try {
				Class<?> clazz = _marketingEventSponsorRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_marketingEventSponsorRemoteModel, createDate);
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

		if (_marketingEventSponsorRemoteModel != null) {
			try {
				Class<?> clazz = _marketingEventSponsorRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_marketingEventSponsorRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getMarketingEventId() {
		return _marketingEventId;
	}

	@Override
	public void setMarketingEventId(long marketingEventId) {
		_marketingEventId = marketingEventId;

		if (_marketingEventSponsorRemoteModel != null) {
			try {
				Class<?> clazz = _marketingEventSponsorRemoteModel.getClass();

				Method method = clazz.getMethod("setMarketingEventId",
						long.class);

				method.invoke(_marketingEventSponsorRemoteModel,
					marketingEventId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getMarketingEventSponsorLevelId() {
		return _marketingEventSponsorLevelId;
	}

	@Override
	public void setMarketingEventSponsorLevelId(
		long marketingEventSponsorLevelId) {
		_marketingEventSponsorLevelId = marketingEventSponsorLevelId;

		if (_marketingEventSponsorRemoteModel != null) {
			try {
				Class<?> clazz = _marketingEventSponsorRemoteModel.getClass();

				Method method = clazz.getMethod("setMarketingEventSponsorLevelId",
						long.class);

				method.invoke(_marketingEventSponsorRemoteModel,
					marketingEventSponsorLevelId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_marketingEventSponsorRemoteModel != null) {
			try {
				Class<?> clazz = _marketingEventSponsorRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_marketingEventSponsorRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public String getDescription(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getDescription(languageId);
	}

	@Override
	public String getDescription(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getDescription(languageId, useDefault);
	}

	@Override
	public String getDescription(String languageId) {
		return LocalizationUtil.getLocalization(getDescription(), languageId);
	}

	@Override
	public String getDescription(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getDescription(), languageId,
			useDefault);
	}

	@Override
	public String getDescriptionCurrentLanguageId() {
		return _descriptionCurrentLanguageId;
	}

	@Override
	public String getDescriptionCurrentValue() {
		Locale locale = getLocale(_descriptionCurrentLanguageId);

		return getDescription(locale);
	}

	@Override
	public Map<Locale, String> getDescriptionMap() {
		return LocalizationUtil.getLocalizationMap(getDescription());
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_marketingEventSponsorRemoteModel != null) {
			try {
				Class<?> clazz = _marketingEventSponsorRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_marketingEventSponsorRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setDescription(String description, Locale locale) {
		setDescription(description, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setDescription(String description, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(description)) {
			setDescription(LocalizationUtil.updateLocalization(
					getDescription(), "Description", description, languageId,
					defaultLanguageId));
		}
		else {
			setDescription(LocalizationUtil.removeLocalization(
					getDescription(), "Description", languageId));
		}
	}

	@Override
	public void setDescriptionCurrentLanguageId(String languageId) {
		_descriptionCurrentLanguageId = languageId;
	}

	@Override
	public void setDescriptionMap(Map<Locale, String> descriptionMap) {
		setDescriptionMap(descriptionMap, LocaleUtil.getDefault());
	}

	@Override
	public void setDescriptionMap(Map<Locale, String> descriptionMap,
		Locale defaultLocale) {
		if (descriptionMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setDescription(LocalizationUtil.updateLocalization(descriptionMap,
					getDescription(), "Description",
					LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
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

		if (_marketingEventSponsorRemoteModel != null) {
			try {
				Class<?> clazz = _marketingEventSponsorRemoteModel.getClass();

				Method method = clazz.getMethod("setImageFileEntryId",
						long.class);

				method.invoke(_marketingEventSponsorRemoteModel,
					imageFileEntryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUrl() {
		return _url;
	}

	@Override
	public void setUrl(String url) {
		_url = url;

		if (_marketingEventSponsorRemoteModel != null) {
			try {
				Class<?> clazz = _marketingEventSponsorRemoteModel.getClass();

				Method method = clazz.getMethod("setUrl", String.class);

				method.invoke(_marketingEventSponsorRemoteModel, url);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
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

	public BaseModel<?> getMarketingEventSponsorRemoteModel() {
		return _marketingEventSponsorRemoteModel;
	}

	public void setMarketingEventSponsorRemoteModel(
		BaseModel<?> marketingEventSponsorRemoteModel) {
		_marketingEventSponsorRemoteModel = marketingEventSponsorRemoteModel;
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

		Class<?> remoteModelClass = _marketingEventSponsorRemoteModel.getClass();

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

		Object returnValue = method.invoke(_marketingEventSponsorRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() {
		if (this.isNew()) {
			MarketingEventSponsorLocalServiceUtil.addMarketingEventSponsor(this);
		}
		else {
			MarketingEventSponsorLocalServiceUtil.updateMarketingEventSponsor(this);
		}
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> descriptionMap = getDescriptionMap();

		for (Map.Entry<Locale, String> entry : descriptionMap.entrySet()) {
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
		String xml = getDescription();

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

		String description = getDescription(defaultLocale);

		if (Validator.isNull(description)) {
			setDescription(getDescription(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setDescription(getDescription(defaultLocale), defaultLocale,
				defaultLocale);
		}
	}

	@Override
	public MarketingEventSponsor toEscapedModel() {
		return (MarketingEventSponsor)ProxyUtil.newProxyInstance(MarketingEventSponsor.class.getClassLoader(),
			new Class[] { MarketingEventSponsor.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		MarketingEventSponsorClp clone = new MarketingEventSponsorClp();

		clone.setMarketingEventSponsorId(getMarketingEventSponsorId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setMarketingEventId(getMarketingEventId());
		clone.setMarketingEventSponsorLevelId(getMarketingEventSponsorLevelId());
		clone.setName(getName());
		clone.setDescription(getDescription());
		clone.setImageFileEntryId(getImageFileEntryId());
		clone.setUrl(getUrl());

		return clone;
	}

	@Override
	public int compareTo(MarketingEventSponsor marketingEventSponsor) {
		int value = 0;

		value = getName().compareTo(marketingEventSponsor.getName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MarketingEventSponsorClp)) {
			return false;
		}

		MarketingEventSponsorClp marketingEventSponsor = (MarketingEventSponsorClp)obj;

		long primaryKey = marketingEventSponsor.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{marketingEventSponsorId=");
		sb.append(getMarketingEventSponsorId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", marketingEventId=");
		sb.append(getMarketingEventId());
		sb.append(", marketingEventSponsorLevelId=");
		sb.append(getMarketingEventSponsorLevelId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", imageFileEntryId=");
		sb.append(getImageFileEntryId());
		sb.append(", url=");
		sb.append(getUrl());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append(
			"com.liferay.osb.www.marketing.events.model.MarketingEventSponsor");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>marketingEventSponsorId</column-name><column-value><![CDATA[");
		sb.append(getMarketingEventSponsorId());
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
			"<column><column-name>marketingEventId</column-name><column-value><![CDATA[");
		sb.append(getMarketingEventId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>marketingEventSponsorLevelId</column-name><column-value><![CDATA[");
		sb.append(getMarketingEventSponsorLevelId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageFileEntryId</column-name><column-value><![CDATA[");
		sb.append(getImageFileEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>url</column-name><column-value><![CDATA[");
		sb.append(getUrl());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _marketingEventSponsorId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _marketingEventId;
	private long _marketingEventSponsorLevelId;
	private String _name;
	private String _description;
	private String _descriptionCurrentLanguageId;
	private long _imageFileEntryId;
	private String _url;
	private BaseModel<?> _marketingEventSponsorRemoteModel;
	private Class<?> _clpSerializerClass = ClpSerializer.class;
	private boolean _entityCacheEnabled;
	private boolean _finderCacheEnabled;
}