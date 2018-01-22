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
 * This class is a wrapper for {@link SocialLinkType}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SocialLinkType
 * @generated
 */
@ProviderType
public class SocialLinkTypeWrapper implements SocialLinkType,
	ModelWrapper<SocialLinkType> {
	public SocialLinkTypeWrapper(SocialLinkType socialLinkType) {
		_socialLinkType = socialLinkType;
	}

	@Override
	public Class<?> getModelClass() {
		return SocialLinkType.class;
	}

	@Override
	public String getModelClassName() {
		return SocialLinkType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("socialLinkTypeId", getSocialLinkTypeId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("imageFileEntryId", getImageFileEntryId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long socialLinkTypeId = (Long)attributes.get("socialLinkTypeId");

		if (socialLinkTypeId != null) {
			setSocialLinkTypeId(socialLinkTypeId);
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
		return new SocialLinkTypeWrapper((SocialLinkType)_socialLinkType.clone());
	}

	@Override
	public int compareTo(SocialLinkType socialLinkType) {
		return _socialLinkType.compareTo(socialLinkType);
	}

	/**
	* Returns the create date of this social link type.
	*
	* @return the create date of this social link type
	*/
	@Override
	public Date getCreateDate() {
		return _socialLinkType.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _socialLinkType.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.repository.model.FileEntry getImageFileEntry() {
		return _socialLinkType.getImageFileEntry();
	}

	/**
	* Returns the image file entry ID of this social link type.
	*
	* @return the image file entry ID of this social link type
	*/
	@Override
	public long getImageFileEntryId() {
		return _socialLinkType.getImageFileEntryId();
	}

	@Override
	public java.lang.String getImageFileEntryURL() {
		return _socialLinkType.getImageFileEntryURL();
	}

	/**
	* Returns the modified date of this social link type.
	*
	* @return the modified date of this social link type
	*/
	@Override
	public Date getModifiedDate() {
		return _socialLinkType.getModifiedDate();
	}

	/**
	* Returns the name of this social link type.
	*
	* @return the name of this social link type
	*/
	@Override
	public java.lang.String getName() {
		return _socialLinkType.getName();
	}

	/**
	* Returns the primary key of this social link type.
	*
	* @return the primary key of this social link type
	*/
	@Override
	public long getPrimaryKey() {
		return _socialLinkType.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _socialLinkType.getPrimaryKeyObj();
	}

	/**
	* Returns the social link type ID of this social link type.
	*
	* @return the social link type ID of this social link type
	*/
	@Override
	public long getSocialLinkTypeId() {
		return _socialLinkType.getSocialLinkTypeId();
	}

	/**
	* Returns the user ID of this social link type.
	*
	* @return the user ID of this social link type
	*/
	@Override
	public long getUserId() {
		return _socialLinkType.getUserId();
	}

	/**
	* Returns the user name of this social link type.
	*
	* @return the user name of this social link type
	*/
	@Override
	public java.lang.String getUserName() {
		return _socialLinkType.getUserName();
	}

	/**
	* Returns the user uuid of this social link type.
	*
	* @return the user uuid of this social link type
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _socialLinkType.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _socialLinkType.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _socialLinkType.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _socialLinkType.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _socialLinkType.isNew();
	}

	@Override
	public void persist() {
		_socialLinkType.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_socialLinkType.setCachedModel(cachedModel);
	}

	/**
	* Sets the create date of this social link type.
	*
	* @param createDate the create date of this social link type
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_socialLinkType.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_socialLinkType.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_socialLinkType.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_socialLinkType.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the image file entry ID of this social link type.
	*
	* @param imageFileEntryId the image file entry ID of this social link type
	*/
	@Override
	public void setImageFileEntryId(long imageFileEntryId) {
		_socialLinkType.setImageFileEntryId(imageFileEntryId);
	}

	/**
	* Sets the modified date of this social link type.
	*
	* @param modifiedDate the modified date of this social link type
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_socialLinkType.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the name of this social link type.
	*
	* @param name the name of this social link type
	*/
	@Override
	public void setName(java.lang.String name) {
		_socialLinkType.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_socialLinkType.setNew(n);
	}

	/**
	* Sets the primary key of this social link type.
	*
	* @param primaryKey the primary key of this social link type
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_socialLinkType.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_socialLinkType.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the social link type ID of this social link type.
	*
	* @param socialLinkTypeId the social link type ID of this social link type
	*/
	@Override
	public void setSocialLinkTypeId(long socialLinkTypeId) {
		_socialLinkType.setSocialLinkTypeId(socialLinkTypeId);
	}

	/**
	* Sets the user ID of this social link type.
	*
	* @param userId the user ID of this social link type
	*/
	@Override
	public void setUserId(long userId) {
		_socialLinkType.setUserId(userId);
	}

	/**
	* Sets the user name of this social link type.
	*
	* @param userName the user name of this social link type
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_socialLinkType.setUserName(userName);
	}

	/**
	* Sets the user uuid of this social link type.
	*
	* @param userUuid the user uuid of this social link type
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_socialLinkType.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<SocialLinkType> toCacheModel() {
		return _socialLinkType.toCacheModel();
	}

	@Override
	public SocialLinkType toEscapedModel() {
		return new SocialLinkTypeWrapper(_socialLinkType.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _socialLinkType.toString();
	}

	@Override
	public SocialLinkType toUnescapedModel() {
		return new SocialLinkTypeWrapper(_socialLinkType.toUnescapedModel());
	}

	@Override
	public java.lang.String toXmlString() {
		return _socialLinkType.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SocialLinkTypeWrapper)) {
			return false;
		}

		SocialLinkTypeWrapper socialLinkTypeWrapper = (SocialLinkTypeWrapper)obj;

		if (Objects.equals(_socialLinkType,
					socialLinkTypeWrapper._socialLinkType)) {
			return true;
		}

		return false;
	}

	@Override
	public SocialLinkType getWrappedModel() {
		return _socialLinkType;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _socialLinkType.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _socialLinkType.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_socialLinkType.resetOriginalValues();
	}

	private final SocialLinkType _socialLinkType;
}