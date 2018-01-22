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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.osb.www.marketing.events.service.http.MarketingEventAnnouncementServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.osb.www.marketing.events.service.http.MarketingEventAnnouncementServiceSoap
 * @generated
 */
@ProviderType
public class MarketingEventAnnouncementSoap implements Serializable {
	public static MarketingEventAnnouncementSoap toSoapModel(
		MarketingEventAnnouncement model) {
		MarketingEventAnnouncementSoap soapModel = new MarketingEventAnnouncementSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setMarketingEventAnnouncementId(model.getMarketingEventAnnouncementId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setMarketingEventId(model.getMarketingEventId());
		soapModel.setTitle(model.getTitle());
		soapModel.setMessage(model.getMessage());
		soapModel.setSummary(model.getSummary());
		soapModel.setImageFileEntryId(model.getImageFileEntryId());
		soapModel.setLinkURL(model.getLinkURL());
		soapModel.setLinkLabel(model.getLinkLabel());
		soapModel.setDisplayDate(model.getDisplayDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());

		return soapModel;
	}

	public static MarketingEventAnnouncementSoap[] toSoapModels(
		MarketingEventAnnouncement[] models) {
		MarketingEventAnnouncementSoap[] soapModels = new MarketingEventAnnouncementSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MarketingEventAnnouncementSoap[][] toSoapModels(
		MarketingEventAnnouncement[][] models) {
		MarketingEventAnnouncementSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MarketingEventAnnouncementSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MarketingEventAnnouncementSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MarketingEventAnnouncementSoap[] toSoapModels(
		List<MarketingEventAnnouncement> models) {
		List<MarketingEventAnnouncementSoap> soapModels = new ArrayList<MarketingEventAnnouncementSoap>(models.size());

		for (MarketingEventAnnouncement model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MarketingEventAnnouncementSoap[soapModels.size()]);
	}

	public MarketingEventAnnouncementSoap() {
	}

	public long getPrimaryKey() {
		return _marketingEventAnnouncementId;
	}

	public void setPrimaryKey(long pk) {
		setMarketingEventAnnouncementId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getMarketingEventAnnouncementId() {
		return _marketingEventAnnouncementId;
	}

	public void setMarketingEventAnnouncementId(
		long marketingEventAnnouncementId) {
		_marketingEventAnnouncementId = marketingEventAnnouncementId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getMarketingEventId() {
		return _marketingEventId;
	}

	public void setMarketingEventId(long marketingEventId) {
		_marketingEventId = marketingEventId;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getMessage() {
		return _message;
	}

	public void setMessage(String message) {
		_message = message;
	}

	public String getSummary() {
		return _summary;
	}

	public void setSummary(String summary) {
		_summary = summary;
	}

	public long getImageFileEntryId() {
		return _imageFileEntryId;
	}

	public void setImageFileEntryId(long imageFileEntryId) {
		_imageFileEntryId = imageFileEntryId;
	}

	public String getLinkURL() {
		return _linkURL;
	}

	public void setLinkURL(String linkURL) {
		_linkURL = linkURL;
	}

	public String getLinkLabel() {
		return _linkLabel;
	}

	public void setLinkLabel(String linkLabel) {
		_linkLabel = linkLabel;
	}

	public Date getDisplayDate() {
		return _displayDate;
	}

	public void setDisplayDate(Date displayDate) {
		_displayDate = displayDate;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserName() {
		return _statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	private String _uuid;
	private long _marketingEventAnnouncementId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _marketingEventId;
	private String _title;
	private String _message;
	private String _summary;
	private long _imageFileEntryId;
	private String _linkURL;
	private String _linkLabel;
	private Date _displayDate;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
}