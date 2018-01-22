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
import com.liferay.osb.www.marketing.events.service.MarketingEventSessionRoomLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @generated
 */
@ProviderType
public class MarketingEventSessionRoomClp extends BaseModelImpl<MarketingEventSessionRoom>
	implements MarketingEventSessionRoom {
	public MarketingEventSessionRoomClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return MarketingEventSessionRoom.class;
	}

	@Override
	public String getModelClassName() {
		return MarketingEventSessionRoom.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _marketingEventSessionRoomId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMarketingEventSessionRoomId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _marketingEventSessionRoomId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("marketingEventSessionRoomId",
			getMarketingEventSessionRoomId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("marketingEventId", getMarketingEventId());
		attributes.put("name", getName());
		attributes.put("imageFileEntryId", getImageFileEntryId());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long marketingEventSessionRoomId = (Long)attributes.get(
				"marketingEventSessionRoomId");

		if (marketingEventSessionRoomId != null) {
			setMarketingEventSessionRoomId(marketingEventSessionRoomId);
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

		Long imageFileEntryId = (Long)attributes.get("imageFileEntryId");

		if (imageFileEntryId != null) {
			setImageFileEntryId(imageFileEntryId);
		}

		_entityCacheEnabled = GetterUtil.getBoolean("entityCacheEnabled");
		_finderCacheEnabled = GetterUtil.getBoolean("finderCacheEnabled");
	}

	@Override
	public long getMarketingEventSessionRoomId() {
		return _marketingEventSessionRoomId;
	}

	@Override
	public void setMarketingEventSessionRoomId(long marketingEventSessionRoomId) {
		_marketingEventSessionRoomId = marketingEventSessionRoomId;

		if (_marketingEventSessionRoomRemoteModel != null) {
			try {
				Class<?> clazz = _marketingEventSessionRoomRemoteModel.getClass();

				Method method = clazz.getMethod("setMarketingEventSessionRoomId",
						long.class);

				method.invoke(_marketingEventSessionRoomRemoteModel,
					marketingEventSessionRoomId);
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

		if (_marketingEventSessionRoomRemoteModel != null) {
			try {
				Class<?> clazz = _marketingEventSessionRoomRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_marketingEventSessionRoomRemoteModel, createDate);
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

		if (_marketingEventSessionRoomRemoteModel != null) {
			try {
				Class<?> clazz = _marketingEventSessionRoomRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_marketingEventSessionRoomRemoteModel,
					modifiedDate);
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

		if (_marketingEventSessionRoomRemoteModel != null) {
			try {
				Class<?> clazz = _marketingEventSessionRoomRemoteModel.getClass();

				Method method = clazz.getMethod("setMarketingEventId",
						long.class);

				method.invoke(_marketingEventSessionRoomRemoteModel,
					marketingEventId);
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

		if (_marketingEventSessionRoomRemoteModel != null) {
			try {
				Class<?> clazz = _marketingEventSessionRoomRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_marketingEventSessionRoomRemoteModel, name);
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

		if (_marketingEventSessionRoomRemoteModel != null) {
			try {
				Class<?> clazz = _marketingEventSessionRoomRemoteModel.getClass();

				Method method = clazz.getMethod("setImageFileEntryId",
						long.class);

				method.invoke(_marketingEventSessionRoomRemoteModel,
					imageFileEntryId);
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

	public BaseModel<?> getMarketingEventSessionRoomRemoteModel() {
		return _marketingEventSessionRoomRemoteModel;
	}

	public void setMarketingEventSessionRoomRemoteModel(
		BaseModel<?> marketingEventSessionRoomRemoteModel) {
		_marketingEventSessionRoomRemoteModel = marketingEventSessionRoomRemoteModel;
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

		Class<?> remoteModelClass = _marketingEventSessionRoomRemoteModel.getClass();

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

		Object returnValue = method.invoke(_marketingEventSessionRoomRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() {
		if (this.isNew()) {
			MarketingEventSessionRoomLocalServiceUtil.addMarketingEventSessionRoom(this);
		}
		else {
			MarketingEventSessionRoomLocalServiceUtil.updateMarketingEventSessionRoom(this);
		}
	}

	@Override
	public MarketingEventSessionRoom toEscapedModel() {
		return (MarketingEventSessionRoom)ProxyUtil.newProxyInstance(MarketingEventSessionRoom.class.getClassLoader(),
			new Class[] { MarketingEventSessionRoom.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		MarketingEventSessionRoomClp clone = new MarketingEventSessionRoomClp();

		clone.setMarketingEventSessionRoomId(getMarketingEventSessionRoomId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setMarketingEventId(getMarketingEventId());
		clone.setName(getName());
		clone.setImageFileEntryId(getImageFileEntryId());

		return clone;
	}

	@Override
	public int compareTo(MarketingEventSessionRoom marketingEventSessionRoom) {
		long primaryKey = marketingEventSessionRoom.getPrimaryKey();

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

		if (!(obj instanceof MarketingEventSessionRoomClp)) {
			return false;
		}

		MarketingEventSessionRoomClp marketingEventSessionRoom = (MarketingEventSessionRoomClp)obj;

		long primaryKey = marketingEventSessionRoom.getPrimaryKey();

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
		StringBundler sb = new StringBundler(13);

		sb.append("{marketingEventSessionRoomId=");
		sb.append(getMarketingEventSessionRoomId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", marketingEventId=");
		sb.append(getMarketingEventId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", imageFileEntryId=");
		sb.append(getImageFileEntryId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append(
			"com.liferay.osb.www.marketing.events.model.MarketingEventSessionRoom");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>marketingEventSessionRoomId</column-name><column-value><![CDATA[");
		sb.append(getMarketingEventSessionRoomId());
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
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageFileEntryId</column-name><column-value><![CDATA[");
		sb.append(getImageFileEntryId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _marketingEventSessionRoomId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _marketingEventId;
	private String _name;
	private long _imageFileEntryId;
	private BaseModel<?> _marketingEventSessionRoomRemoteModel;
	private Class<?> _clpSerializerClass = ClpSerializer.class;
	private boolean _entityCacheEnabled;
	private boolean _finderCacheEnabled;
}