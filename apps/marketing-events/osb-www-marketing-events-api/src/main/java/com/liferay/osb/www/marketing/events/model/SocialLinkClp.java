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
import com.liferay.osb.www.marketing.events.service.SocialLinkLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @generated
 */
@ProviderType
public class SocialLinkClp extends BaseModelImpl<SocialLink>
	implements SocialLink {
	public SocialLinkClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SocialLink.class;
	}

	@Override
	public String getModelClassName() {
		return SocialLink.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _socialLinkId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSocialLinkId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _socialLinkId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("socialLinkId", getSocialLinkId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("marketingEventUserId", getMarketingEventUserId());
		attributes.put("socialLinkTypeId", getSocialLinkTypeId());
		attributes.put("url", getUrl());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long socialLinkId = (Long)attributes.get("socialLinkId");

		if (socialLinkId != null) {
			setSocialLinkId(socialLinkId);
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

		Long marketingEventUserId = (Long)attributes.get("marketingEventUserId");

		if (marketingEventUserId != null) {
			setMarketingEventUserId(marketingEventUserId);
		}

		Long socialLinkTypeId = (Long)attributes.get("socialLinkTypeId");

		if (socialLinkTypeId != null) {
			setSocialLinkTypeId(socialLinkTypeId);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}

		_entityCacheEnabled = GetterUtil.getBoolean("entityCacheEnabled");
		_finderCacheEnabled = GetterUtil.getBoolean("finderCacheEnabled");
	}

	@Override
	public long getSocialLinkId() {
		return _socialLinkId;
	}

	@Override
	public void setSocialLinkId(long socialLinkId) {
		_socialLinkId = socialLinkId;

		if (_socialLinkRemoteModel != null) {
			try {
				Class<?> clazz = _socialLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setSocialLinkId", long.class);

				method.invoke(_socialLinkRemoteModel, socialLinkId);
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

		if (_socialLinkRemoteModel != null) {
			try {
				Class<?> clazz = _socialLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_socialLinkRemoteModel, userId);
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

		if (_socialLinkRemoteModel != null) {
			try {
				Class<?> clazz = _socialLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_socialLinkRemoteModel, userName);
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

		if (_socialLinkRemoteModel != null) {
			try {
				Class<?> clazz = _socialLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_socialLinkRemoteModel, createDate);
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

		if (_socialLinkRemoteModel != null) {
			try {
				Class<?> clazz = _socialLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_socialLinkRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getMarketingEventUserId() {
		return _marketingEventUserId;
	}

	@Override
	public void setMarketingEventUserId(long marketingEventUserId) {
		_marketingEventUserId = marketingEventUserId;

		if (_socialLinkRemoteModel != null) {
			try {
				Class<?> clazz = _socialLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setMarketingEventUserId",
						long.class);

				method.invoke(_socialLinkRemoteModel, marketingEventUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMarketingEventUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getMarketingEventUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setMarketingEventUserUuid(String marketingEventUserUuid) {
	}

	@Override
	public long getSocialLinkTypeId() {
		return _socialLinkTypeId;
	}

	@Override
	public void setSocialLinkTypeId(long socialLinkTypeId) {
		_socialLinkTypeId = socialLinkTypeId;

		if (_socialLinkRemoteModel != null) {
			try {
				Class<?> clazz = _socialLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setSocialLinkTypeId",
						long.class);

				method.invoke(_socialLinkRemoteModel, socialLinkTypeId);
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

		if (_socialLinkRemoteModel != null) {
			try {
				Class<?> clazz = _socialLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setUrl", String.class);

				method.invoke(_socialLinkRemoteModel, url);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public SocialLinkType getSocialLinkType() {
		try {
			String methodName = "getSocialLinkType";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			SocialLinkType returnObj = (SocialLinkType)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getSocialLinkTypeImageFileEntryURL() {
		try {
			String methodName = "getSocialLinkTypeImageFileEntryURL";

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
	public java.lang.String getSocialLinkTypeName() {
		try {
			String methodName = "getSocialLinkTypeName";

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

	public BaseModel<?> getSocialLinkRemoteModel() {
		return _socialLinkRemoteModel;
	}

	public void setSocialLinkRemoteModel(BaseModel<?> socialLinkRemoteModel) {
		_socialLinkRemoteModel = socialLinkRemoteModel;
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

		Class<?> remoteModelClass = _socialLinkRemoteModel.getClass();

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

		Object returnValue = method.invoke(_socialLinkRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() {
		if (this.isNew()) {
			SocialLinkLocalServiceUtil.addSocialLink(this);
		}
		else {
			SocialLinkLocalServiceUtil.updateSocialLink(this);
		}
	}

	@Override
	public SocialLink toEscapedModel() {
		return (SocialLink)ProxyUtil.newProxyInstance(SocialLink.class.getClassLoader(),
			new Class[] { SocialLink.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SocialLinkClp clone = new SocialLinkClp();

		clone.setSocialLinkId(getSocialLinkId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setMarketingEventUserId(getMarketingEventUserId());
		clone.setSocialLinkTypeId(getSocialLinkTypeId());
		clone.setUrl(getUrl());

		return clone;
	}

	@Override
	public int compareTo(SocialLink socialLink) {
		long primaryKey = socialLink.getPrimaryKey();

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

		if (!(obj instanceof SocialLinkClp)) {
			return false;
		}

		SocialLinkClp socialLink = (SocialLinkClp)obj;

		long primaryKey = socialLink.getPrimaryKey();

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
		StringBundler sb = new StringBundler(17);

		sb.append("{socialLinkId=");
		sb.append(getSocialLinkId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", marketingEventUserId=");
		sb.append(getMarketingEventUserId());
		sb.append(", socialLinkTypeId=");
		sb.append(getSocialLinkTypeId());
		sb.append(", url=");
		sb.append(getUrl());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.liferay.osb.www.marketing.events.model.SocialLink");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>socialLinkId</column-name><column-value><![CDATA[");
		sb.append(getSocialLinkId());
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
			"<column><column-name>marketingEventUserId</column-name><column-value><![CDATA[");
		sb.append(getMarketingEventUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>socialLinkTypeId</column-name><column-value><![CDATA[");
		sb.append(getSocialLinkTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>url</column-name><column-value><![CDATA[");
		sb.append(getUrl());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _socialLinkId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _marketingEventUserId;
	private long _socialLinkTypeId;
	private String _url;
	private BaseModel<?> _socialLinkRemoteModel;
	private Class<?> _clpSerializerClass = ClpSerializer.class;
	private boolean _entityCacheEnabled;
	private boolean _finderCacheEnabled;
}