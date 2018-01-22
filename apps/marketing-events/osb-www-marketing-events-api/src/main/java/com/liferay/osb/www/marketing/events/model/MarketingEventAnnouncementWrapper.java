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
 * This class is a wrapper for {@link MarketingEventAnnouncement}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEventAnnouncement
 * @generated
 */
@ProviderType
public class MarketingEventAnnouncementWrapper
	implements MarketingEventAnnouncement,
		ModelWrapper<MarketingEventAnnouncement> {
	public MarketingEventAnnouncementWrapper(
		MarketingEventAnnouncement marketingEventAnnouncement) {
		_marketingEventAnnouncement = marketingEventAnnouncement;
	}

	@Override
	public Class<?> getModelClass() {
		return MarketingEventAnnouncement.class;
	}

	@Override
	public String getModelClassName() {
		return MarketingEventAnnouncement.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("marketingEventAnnouncementId",
			getMarketingEventAnnouncementId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("marketingEventId", getMarketingEventId());
		attributes.put("title", getTitle());
		attributes.put("message", getMessage());
		attributes.put("summary", getSummary());
		attributes.put("imageFileEntryId", getImageFileEntryId());
		attributes.put("linkURL", getLinkURL());
		attributes.put("linkLabel", getLinkLabel());
		attributes.put("displayDate", getDisplayDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long marketingEventAnnouncementId = (Long)attributes.get(
				"marketingEventAnnouncementId");

		if (marketingEventAnnouncementId != null) {
			setMarketingEventAnnouncementId(marketingEventAnnouncementId);
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

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String message = (String)attributes.get("message");

		if (message != null) {
			setMessage(message);
		}

		String summary = (String)attributes.get("summary");

		if (summary != null) {
			setSummary(summary);
		}

		Long imageFileEntryId = (Long)attributes.get("imageFileEntryId");

		if (imageFileEntryId != null) {
			setImageFileEntryId(imageFileEntryId);
		}

		String linkURL = (String)attributes.get("linkURL");

		if (linkURL != null) {
			setLinkURL(linkURL);
		}

		String linkLabel = (String)attributes.get("linkLabel");

		if (linkLabel != null) {
			setLinkLabel(linkLabel);
		}

		Date displayDate = (Date)attributes.get("displayDate");

		if (displayDate != null) {
			setDisplayDate(displayDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}
	}

	@Override
	public java.lang.Object clone() {
		return new MarketingEventAnnouncementWrapper((MarketingEventAnnouncement)_marketingEventAnnouncement.clone());
	}

	@Override
	public int compareTo(MarketingEventAnnouncement marketingEventAnnouncement) {
		return _marketingEventAnnouncement.compareTo(marketingEventAnnouncement);
	}

	/**
	* Returns the create date of this marketing event announcement.
	*
	* @return the create date of this marketing event announcement
	*/
	@Override
	public Date getCreateDate() {
		return _marketingEventAnnouncement.getCreateDate();
	}

	/**
	* Returns the display date of this marketing event announcement.
	*
	* @return the display date of this marketing event announcement
	*/
	@Override
	public Date getDisplayDate() {
		return _marketingEventAnnouncement.getDisplayDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _marketingEventAnnouncement.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.repository.model.FileEntry getImageFileEntry() {
		return _marketingEventAnnouncement.getImageFileEntry();
	}

	/**
	* Returns the image file entry ID of this marketing event announcement.
	*
	* @return the image file entry ID of this marketing event announcement
	*/
	@Override
	public long getImageFileEntryId() {
		return _marketingEventAnnouncement.getImageFileEntryId();
	}

	@Override
	public java.lang.String getImageFileEntryURL() {
		return _marketingEventAnnouncement.getImageFileEntryURL();
	}

	/**
	* Returns the link label of this marketing event announcement.
	*
	* @return the link label of this marketing event announcement
	*/
	@Override
	public java.lang.String getLinkLabel() {
		return _marketingEventAnnouncement.getLinkLabel();
	}

	/**
	* Returns the link url of this marketing event announcement.
	*
	* @return the link url of this marketing event announcement
	*/
	@Override
	public java.lang.String getLinkURL() {
		return _marketingEventAnnouncement.getLinkURL();
	}

	/**
	* Returns the marketing event announcement ID of this marketing event announcement.
	*
	* @return the marketing event announcement ID of this marketing event announcement
	*/
	@Override
	public long getMarketingEventAnnouncementId() {
		return _marketingEventAnnouncement.getMarketingEventAnnouncementId();
	}

	/**
	* Returns the marketing event ID of this marketing event announcement.
	*
	* @return the marketing event ID of this marketing event announcement
	*/
	@Override
	public long getMarketingEventId() {
		return _marketingEventAnnouncement.getMarketingEventId();
	}

	/**
	* Returns the message of this marketing event announcement.
	*
	* @return the message of this marketing event announcement
	*/
	@Override
	public java.lang.String getMessage() {
		return _marketingEventAnnouncement.getMessage();
	}

	/**
	* Returns the modified date of this marketing event announcement.
	*
	* @return the modified date of this marketing event announcement
	*/
	@Override
	public Date getModifiedDate() {
		return _marketingEventAnnouncement.getModifiedDate();
	}

	/**
	* Returns the primary key of this marketing event announcement.
	*
	* @return the primary key of this marketing event announcement
	*/
	@Override
	public long getPrimaryKey() {
		return _marketingEventAnnouncement.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _marketingEventAnnouncement.getPrimaryKeyObj();
	}

	/**
	* Returns the status of this marketing event announcement.
	*
	* @return the status of this marketing event announcement
	*/
	@Override
	public int getStatus() {
		return _marketingEventAnnouncement.getStatus();
	}

	/**
	* Returns the status by user ID of this marketing event announcement.
	*
	* @return the status by user ID of this marketing event announcement
	*/
	@Override
	public long getStatusByUserId() {
		return _marketingEventAnnouncement.getStatusByUserId();
	}

	/**
	* Returns the status by user name of this marketing event announcement.
	*
	* @return the status by user name of this marketing event announcement
	*/
	@Override
	public java.lang.String getStatusByUserName() {
		return _marketingEventAnnouncement.getStatusByUserName();
	}

	/**
	* Returns the status by user uuid of this marketing event announcement.
	*
	* @return the status by user uuid of this marketing event announcement
	*/
	@Override
	public java.lang.String getStatusByUserUuid() {
		return _marketingEventAnnouncement.getStatusByUserUuid();
	}

	/**
	* Returns the status date of this marketing event announcement.
	*
	* @return the status date of this marketing event announcement
	*/
	@Override
	public Date getStatusDate() {
		return _marketingEventAnnouncement.getStatusDate();
	}

	/**
	* Returns the summary of this marketing event announcement.
	*
	* @return the summary of this marketing event announcement
	*/
	@Override
	public java.lang.String getSummary() {
		return _marketingEventAnnouncement.getSummary();
	}

	/**
	* Returns the title of this marketing event announcement.
	*
	* @return the title of this marketing event announcement
	*/
	@Override
	public java.lang.String getTitle() {
		return _marketingEventAnnouncement.getTitle();
	}

	/**
	* Returns the user ID of this marketing event announcement.
	*
	* @return the user ID of this marketing event announcement
	*/
	@Override
	public long getUserId() {
		return _marketingEventAnnouncement.getUserId();
	}

	/**
	* Returns the user name of this marketing event announcement.
	*
	* @return the user name of this marketing event announcement
	*/
	@Override
	public java.lang.String getUserName() {
		return _marketingEventAnnouncement.getUserName();
	}

	/**
	* Returns the user uuid of this marketing event announcement.
	*
	* @return the user uuid of this marketing event announcement
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _marketingEventAnnouncement.getUserUuid();
	}

	/**
	* Returns the uuid of this marketing event announcement.
	*
	* @return the uuid of this marketing event announcement
	*/
	@Override
	public java.lang.String getUuid() {
		return _marketingEventAnnouncement.getUuid();
	}

	@Override
	public int hashCode() {
		return _marketingEventAnnouncement.hashCode();
	}

	/**
	* Returns <code>true</code> if this marketing event announcement is approved.
	*
	* @return <code>true</code> if this marketing event announcement is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _marketingEventAnnouncement.isApproved();
	}

	@Override
	public boolean isCachedModel() {
		return _marketingEventAnnouncement.isCachedModel();
	}

	/**
	* Returns <code>true</code> if this marketing event announcement is denied.
	*
	* @return <code>true</code> if this marketing event announcement is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _marketingEventAnnouncement.isDenied();
	}

	/**
	* Returns <code>true</code> if this marketing event announcement is a draft.
	*
	* @return <code>true</code> if this marketing event announcement is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _marketingEventAnnouncement.isDraft();
	}

	@Override
	public boolean isEscapedModel() {
		return _marketingEventAnnouncement.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this marketing event announcement is expired.
	*
	* @return <code>true</code> if this marketing event announcement is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _marketingEventAnnouncement.isExpired();
	}

	/**
	* Returns <code>true</code> if this marketing event announcement is inactive.
	*
	* @return <code>true</code> if this marketing event announcement is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _marketingEventAnnouncement.isInactive();
	}

	/**
	* Returns <code>true</code> if this marketing event announcement is incomplete.
	*
	* @return <code>true</code> if this marketing event announcement is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _marketingEventAnnouncement.isIncomplete();
	}

	@Override
	public boolean isNew() {
		return _marketingEventAnnouncement.isNew();
	}

	/**
	* Returns <code>true</code> if this marketing event announcement is pending.
	*
	* @return <code>true</code> if this marketing event announcement is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _marketingEventAnnouncement.isPending();
	}

	/**
	* Returns <code>true</code> if this marketing event announcement is scheduled.
	*
	* @return <code>true</code> if this marketing event announcement is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _marketingEventAnnouncement.isScheduled();
	}

	@Override
	public void persist() {
		_marketingEventAnnouncement.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_marketingEventAnnouncement.setCachedModel(cachedModel);
	}

	/**
	* Sets the create date of this marketing event announcement.
	*
	* @param createDate the create date of this marketing event announcement
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_marketingEventAnnouncement.setCreateDate(createDate);
	}

	/**
	* Sets the display date of this marketing event announcement.
	*
	* @param displayDate the display date of this marketing event announcement
	*/
	@Override
	public void setDisplayDate(Date displayDate) {
		_marketingEventAnnouncement.setDisplayDate(displayDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_marketingEventAnnouncement.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_marketingEventAnnouncement.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_marketingEventAnnouncement.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the image file entry ID of this marketing event announcement.
	*
	* @param imageFileEntryId the image file entry ID of this marketing event announcement
	*/
	@Override
	public void setImageFileEntryId(long imageFileEntryId) {
		_marketingEventAnnouncement.setImageFileEntryId(imageFileEntryId);
	}

	/**
	* Sets the link label of this marketing event announcement.
	*
	* @param linkLabel the link label of this marketing event announcement
	*/
	@Override
	public void setLinkLabel(java.lang.String linkLabel) {
		_marketingEventAnnouncement.setLinkLabel(linkLabel);
	}

	/**
	* Sets the link url of this marketing event announcement.
	*
	* @param linkURL the link url of this marketing event announcement
	*/
	@Override
	public void setLinkURL(java.lang.String linkURL) {
		_marketingEventAnnouncement.setLinkURL(linkURL);
	}

	/**
	* Sets the marketing event announcement ID of this marketing event announcement.
	*
	* @param marketingEventAnnouncementId the marketing event announcement ID of this marketing event announcement
	*/
	@Override
	public void setMarketingEventAnnouncementId(
		long marketingEventAnnouncementId) {
		_marketingEventAnnouncement.setMarketingEventAnnouncementId(marketingEventAnnouncementId);
	}

	/**
	* Sets the marketing event ID of this marketing event announcement.
	*
	* @param marketingEventId the marketing event ID of this marketing event announcement
	*/
	@Override
	public void setMarketingEventId(long marketingEventId) {
		_marketingEventAnnouncement.setMarketingEventId(marketingEventId);
	}

	/**
	* Sets the message of this marketing event announcement.
	*
	* @param message the message of this marketing event announcement
	*/
	@Override
	public void setMessage(java.lang.String message) {
		_marketingEventAnnouncement.setMessage(message);
	}

	/**
	* Sets the modified date of this marketing event announcement.
	*
	* @param modifiedDate the modified date of this marketing event announcement
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_marketingEventAnnouncement.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_marketingEventAnnouncement.setNew(n);
	}

	/**
	* Sets the primary key of this marketing event announcement.
	*
	* @param primaryKey the primary key of this marketing event announcement
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_marketingEventAnnouncement.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_marketingEventAnnouncement.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the status of this marketing event announcement.
	*
	* @param status the status of this marketing event announcement
	*/
	@Override
	public void setStatus(int status) {
		_marketingEventAnnouncement.setStatus(status);
	}

	/**
	* Sets the status by user ID of this marketing event announcement.
	*
	* @param statusByUserId the status by user ID of this marketing event announcement
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_marketingEventAnnouncement.setStatusByUserId(statusByUserId);
	}

	/**
	* Sets the status by user name of this marketing event announcement.
	*
	* @param statusByUserName the status by user name of this marketing event announcement
	*/
	@Override
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_marketingEventAnnouncement.setStatusByUserName(statusByUserName);
	}

	/**
	* Sets the status by user uuid of this marketing event announcement.
	*
	* @param statusByUserUuid the status by user uuid of this marketing event announcement
	*/
	@Override
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_marketingEventAnnouncement.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Sets the status date of this marketing event announcement.
	*
	* @param statusDate the status date of this marketing event announcement
	*/
	@Override
	public void setStatusDate(Date statusDate) {
		_marketingEventAnnouncement.setStatusDate(statusDate);
	}

	/**
	* Sets the summary of this marketing event announcement.
	*
	* @param summary the summary of this marketing event announcement
	*/
	@Override
	public void setSummary(java.lang.String summary) {
		_marketingEventAnnouncement.setSummary(summary);
	}

	/**
	* Sets the title of this marketing event announcement.
	*
	* @param title the title of this marketing event announcement
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_marketingEventAnnouncement.setTitle(title);
	}

	/**
	* Sets the user ID of this marketing event announcement.
	*
	* @param userId the user ID of this marketing event announcement
	*/
	@Override
	public void setUserId(long userId) {
		_marketingEventAnnouncement.setUserId(userId);
	}

	/**
	* Sets the user name of this marketing event announcement.
	*
	* @param userName the user name of this marketing event announcement
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_marketingEventAnnouncement.setUserName(userName);
	}

	/**
	* Sets the user uuid of this marketing event announcement.
	*
	* @param userUuid the user uuid of this marketing event announcement
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_marketingEventAnnouncement.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this marketing event announcement.
	*
	* @param uuid the uuid of this marketing event announcement
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_marketingEventAnnouncement.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<MarketingEventAnnouncement> toCacheModel() {
		return _marketingEventAnnouncement.toCacheModel();
	}

	@Override
	public MarketingEventAnnouncement toEscapedModel() {
		return new MarketingEventAnnouncementWrapper(_marketingEventAnnouncement.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _marketingEventAnnouncement.toString();
	}

	@Override
	public MarketingEventAnnouncement toUnescapedModel() {
		return new MarketingEventAnnouncementWrapper(_marketingEventAnnouncement.toUnescapedModel());
	}

	@Override
	public java.lang.String toXmlString() {
		return _marketingEventAnnouncement.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MarketingEventAnnouncementWrapper)) {
			return false;
		}

		MarketingEventAnnouncementWrapper marketingEventAnnouncementWrapper = (MarketingEventAnnouncementWrapper)obj;

		if (Objects.equals(_marketingEventAnnouncement,
					marketingEventAnnouncementWrapper._marketingEventAnnouncement)) {
			return true;
		}

		return false;
	}

	@Override
	public MarketingEventAnnouncement getWrappedModel() {
		return _marketingEventAnnouncement;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _marketingEventAnnouncement.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _marketingEventAnnouncement.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_marketingEventAnnouncement.resetOriginalValues();
	}

	private final MarketingEventAnnouncement _marketingEventAnnouncement;
}