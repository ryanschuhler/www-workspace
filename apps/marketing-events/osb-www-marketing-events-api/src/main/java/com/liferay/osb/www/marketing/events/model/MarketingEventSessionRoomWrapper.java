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
 * This class is a wrapper for {@link MarketingEventSessionRoom}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEventSessionRoom
 * @generated
 */
@ProviderType
public class MarketingEventSessionRoomWrapper
	implements MarketingEventSessionRoom,
		ModelWrapper<MarketingEventSessionRoom> {
	public MarketingEventSessionRoomWrapper(
		MarketingEventSessionRoom marketingEventSessionRoom) {
		_marketingEventSessionRoom = marketingEventSessionRoom;
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
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("marketingEventSessionRoomId",
			getMarketingEventSessionRoomId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("marketingEventId", getMarketingEventId());
		attributes.put("name", getName());
		attributes.put("imageFileEntryId", getImageFileEntryId());

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
	}

	@Override
	public java.lang.Object clone() {
		return new MarketingEventSessionRoomWrapper((MarketingEventSessionRoom)_marketingEventSessionRoom.clone());
	}

	@Override
	public int compareTo(MarketingEventSessionRoom marketingEventSessionRoom) {
		return _marketingEventSessionRoom.compareTo(marketingEventSessionRoom);
	}

	/**
	* Returns the create date of this marketing event session room.
	*
	* @return the create date of this marketing event session room
	*/
	@Override
	public Date getCreateDate() {
		return _marketingEventSessionRoom.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _marketingEventSessionRoom.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.repository.model.FileEntry getImageFileEntry() {
		return _marketingEventSessionRoom.getImageFileEntry();
	}

	/**
	* Returns the image file entry ID of this marketing event session room.
	*
	* @return the image file entry ID of this marketing event session room
	*/
	@Override
	public long getImageFileEntryId() {
		return _marketingEventSessionRoom.getImageFileEntryId();
	}

	@Override
	public java.lang.String getImageFileEntryURL() {
		return _marketingEventSessionRoom.getImageFileEntryURL();
	}

	/**
	* Returns the marketing event ID of this marketing event session room.
	*
	* @return the marketing event ID of this marketing event session room
	*/
	@Override
	public long getMarketingEventId() {
		return _marketingEventSessionRoom.getMarketingEventId();
	}

	/**
	* Returns the marketing event session room ID of this marketing event session room.
	*
	* @return the marketing event session room ID of this marketing event session room
	*/
	@Override
	public long getMarketingEventSessionRoomId() {
		return _marketingEventSessionRoom.getMarketingEventSessionRoomId();
	}

	/**
	* Returns the modified date of this marketing event session room.
	*
	* @return the modified date of this marketing event session room
	*/
	@Override
	public Date getModifiedDate() {
		return _marketingEventSessionRoom.getModifiedDate();
	}

	/**
	* Returns the name of this marketing event session room.
	*
	* @return the name of this marketing event session room
	*/
	@Override
	public java.lang.String getName() {
		return _marketingEventSessionRoom.getName();
	}

	/**
	* Returns the primary key of this marketing event session room.
	*
	* @return the primary key of this marketing event session room
	*/
	@Override
	public long getPrimaryKey() {
		return _marketingEventSessionRoom.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _marketingEventSessionRoom.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _marketingEventSessionRoom.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _marketingEventSessionRoom.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _marketingEventSessionRoom.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _marketingEventSessionRoom.isNew();
	}

	@Override
	public void persist() {
		_marketingEventSessionRoom.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_marketingEventSessionRoom.setCachedModel(cachedModel);
	}

	/**
	* Sets the create date of this marketing event session room.
	*
	* @param createDate the create date of this marketing event session room
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_marketingEventSessionRoom.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_marketingEventSessionRoom.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_marketingEventSessionRoom.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_marketingEventSessionRoom.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the image file entry ID of this marketing event session room.
	*
	* @param imageFileEntryId the image file entry ID of this marketing event session room
	*/
	@Override
	public void setImageFileEntryId(long imageFileEntryId) {
		_marketingEventSessionRoom.setImageFileEntryId(imageFileEntryId);
	}

	/**
	* Sets the marketing event ID of this marketing event session room.
	*
	* @param marketingEventId the marketing event ID of this marketing event session room
	*/
	@Override
	public void setMarketingEventId(long marketingEventId) {
		_marketingEventSessionRoom.setMarketingEventId(marketingEventId);
	}

	/**
	* Sets the marketing event session room ID of this marketing event session room.
	*
	* @param marketingEventSessionRoomId the marketing event session room ID of this marketing event session room
	*/
	@Override
	public void setMarketingEventSessionRoomId(long marketingEventSessionRoomId) {
		_marketingEventSessionRoom.setMarketingEventSessionRoomId(marketingEventSessionRoomId);
	}

	/**
	* Sets the modified date of this marketing event session room.
	*
	* @param modifiedDate the modified date of this marketing event session room
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_marketingEventSessionRoom.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the name of this marketing event session room.
	*
	* @param name the name of this marketing event session room
	*/
	@Override
	public void setName(java.lang.String name) {
		_marketingEventSessionRoom.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_marketingEventSessionRoom.setNew(n);
	}

	/**
	* Sets the primary key of this marketing event session room.
	*
	* @param primaryKey the primary key of this marketing event session room
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_marketingEventSessionRoom.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_marketingEventSessionRoom.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<MarketingEventSessionRoom> toCacheModel() {
		return _marketingEventSessionRoom.toCacheModel();
	}

	@Override
	public MarketingEventSessionRoom toEscapedModel() {
		return new MarketingEventSessionRoomWrapper(_marketingEventSessionRoom.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _marketingEventSessionRoom.toString();
	}

	@Override
	public MarketingEventSessionRoom toUnescapedModel() {
		return new MarketingEventSessionRoomWrapper(_marketingEventSessionRoom.toUnescapedModel());
	}

	@Override
	public java.lang.String toXmlString() {
		return _marketingEventSessionRoom.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MarketingEventSessionRoomWrapper)) {
			return false;
		}

		MarketingEventSessionRoomWrapper marketingEventSessionRoomWrapper = (MarketingEventSessionRoomWrapper)obj;

		if (Objects.equals(_marketingEventSessionRoom,
					marketingEventSessionRoomWrapper._marketingEventSessionRoom)) {
			return true;
		}

		return false;
	}

	@Override
	public MarketingEventSessionRoom getWrappedModel() {
		return _marketingEventSessionRoom;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _marketingEventSessionRoom.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _marketingEventSessionRoom.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_marketingEventSessionRoom.resetOriginalValues();
	}

	private final MarketingEventSessionRoom _marketingEventSessionRoom;
}