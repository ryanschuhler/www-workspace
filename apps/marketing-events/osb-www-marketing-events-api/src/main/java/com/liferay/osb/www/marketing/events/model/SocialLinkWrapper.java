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
 * This class is a wrapper for {@link SocialLink}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SocialLink
 * @generated
 */
@ProviderType
public class SocialLinkWrapper implements SocialLink, ModelWrapper<SocialLink> {
	public SocialLinkWrapper(SocialLink socialLink) {
		_socialLink = socialLink;
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
	}

	@Override
	public java.lang.Object clone() {
		return new SocialLinkWrapper((SocialLink)_socialLink.clone());
	}

	@Override
	public int compareTo(SocialLink socialLink) {
		return _socialLink.compareTo(socialLink);
	}

	/**
	* Returns the create date of this social link.
	*
	* @return the create date of this social link
	*/
	@Override
	public Date getCreateDate() {
		return _socialLink.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _socialLink.getExpandoBridge();
	}

	/**
	* Returns the marketing event user ID of this social link.
	*
	* @return the marketing event user ID of this social link
	*/
	@Override
	public long getMarketingEventUserId() {
		return _socialLink.getMarketingEventUserId();
	}

	/**
	* Returns the marketing event user uuid of this social link.
	*
	* @return the marketing event user uuid of this social link
	*/
	@Override
	public java.lang.String getMarketingEventUserUuid() {
		return _socialLink.getMarketingEventUserUuid();
	}

	/**
	* Returns the modified date of this social link.
	*
	* @return the modified date of this social link
	*/
	@Override
	public Date getModifiedDate() {
		return _socialLink.getModifiedDate();
	}

	/**
	* Returns the primary key of this social link.
	*
	* @return the primary key of this social link
	*/
	@Override
	public long getPrimaryKey() {
		return _socialLink.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _socialLink.getPrimaryKeyObj();
	}

	/**
	* Returns the social link ID of this social link.
	*
	* @return the social link ID of this social link
	*/
	@Override
	public long getSocialLinkId() {
		return _socialLink.getSocialLinkId();
	}

	@Override
	public SocialLinkType getSocialLinkType()
		throws com.liferay.portal.kernel.exception.PortalException {
		return _socialLink.getSocialLinkType();
	}

	/**
	* Returns the social link type ID of this social link.
	*
	* @return the social link type ID of this social link
	*/
	@Override
	public long getSocialLinkTypeId() {
		return _socialLink.getSocialLinkTypeId();
	}

	@Override
	public java.lang.String getSocialLinkTypeImageFileEntryURL()
		throws com.liferay.portal.kernel.exception.PortalException {
		return _socialLink.getSocialLinkTypeImageFileEntryURL();
	}

	@Override
	public java.lang.String getSocialLinkTypeName()
		throws com.liferay.portal.kernel.exception.PortalException {
		return _socialLink.getSocialLinkTypeName();
	}

	/**
	* Returns the url of this social link.
	*
	* @return the url of this social link
	*/
	@Override
	public java.lang.String getUrl() {
		return _socialLink.getUrl();
	}

	/**
	* Returns the user ID of this social link.
	*
	* @return the user ID of this social link
	*/
	@Override
	public long getUserId() {
		return _socialLink.getUserId();
	}

	/**
	* Returns the user name of this social link.
	*
	* @return the user name of this social link
	*/
	@Override
	public java.lang.String getUserName() {
		return _socialLink.getUserName();
	}

	/**
	* Returns the user uuid of this social link.
	*
	* @return the user uuid of this social link
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _socialLink.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _socialLink.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _socialLink.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _socialLink.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _socialLink.isNew();
	}

	@Override
	public void persist() {
		_socialLink.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_socialLink.setCachedModel(cachedModel);
	}

	/**
	* Sets the create date of this social link.
	*
	* @param createDate the create date of this social link
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_socialLink.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_socialLink.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_socialLink.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_socialLink.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the marketing event user ID of this social link.
	*
	* @param marketingEventUserId the marketing event user ID of this social link
	*/
	@Override
	public void setMarketingEventUserId(long marketingEventUserId) {
		_socialLink.setMarketingEventUserId(marketingEventUserId);
	}

	/**
	* Sets the marketing event user uuid of this social link.
	*
	* @param marketingEventUserUuid the marketing event user uuid of this social link
	*/
	@Override
	public void setMarketingEventUserUuid(
		java.lang.String marketingEventUserUuid) {
		_socialLink.setMarketingEventUserUuid(marketingEventUserUuid);
	}

	/**
	* Sets the modified date of this social link.
	*
	* @param modifiedDate the modified date of this social link
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_socialLink.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_socialLink.setNew(n);
	}

	/**
	* Sets the primary key of this social link.
	*
	* @param primaryKey the primary key of this social link
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_socialLink.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_socialLink.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the social link ID of this social link.
	*
	* @param socialLinkId the social link ID of this social link
	*/
	@Override
	public void setSocialLinkId(long socialLinkId) {
		_socialLink.setSocialLinkId(socialLinkId);
	}

	/**
	* Sets the social link type ID of this social link.
	*
	* @param socialLinkTypeId the social link type ID of this social link
	*/
	@Override
	public void setSocialLinkTypeId(long socialLinkTypeId) {
		_socialLink.setSocialLinkTypeId(socialLinkTypeId);
	}

	/**
	* Sets the url of this social link.
	*
	* @param url the url of this social link
	*/
	@Override
	public void setUrl(java.lang.String url) {
		_socialLink.setUrl(url);
	}

	/**
	* Sets the user ID of this social link.
	*
	* @param userId the user ID of this social link
	*/
	@Override
	public void setUserId(long userId) {
		_socialLink.setUserId(userId);
	}

	/**
	* Sets the user name of this social link.
	*
	* @param userName the user name of this social link
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_socialLink.setUserName(userName);
	}

	/**
	* Sets the user uuid of this social link.
	*
	* @param userUuid the user uuid of this social link
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_socialLink.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<SocialLink> toCacheModel() {
		return _socialLink.toCacheModel();
	}

	@Override
	public SocialLink toEscapedModel() {
		return new SocialLinkWrapper(_socialLink.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _socialLink.toString();
	}

	@Override
	public SocialLink toUnescapedModel() {
		return new SocialLinkWrapper(_socialLink.toUnescapedModel());
	}

	@Override
	public java.lang.String toXmlString() {
		return _socialLink.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SocialLinkWrapper)) {
			return false;
		}

		SocialLinkWrapper socialLinkWrapper = (SocialLinkWrapper)obj;

		if (Objects.equals(_socialLink, socialLinkWrapper._socialLink)) {
			return true;
		}

		return false;
	}

	@Override
	public SocialLink getWrappedModel() {
		return _socialLink;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _socialLink.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _socialLink.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_socialLink.resetOriginalValues();
	}

	private final SocialLink _socialLink;
}