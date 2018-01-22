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
 * This class is used by SOAP remote services, specifically {@link com.liferay.osb.www.marketing.events.service.http.MarketingEventSessionServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.osb.www.marketing.events.service.http.MarketingEventSessionServiceSoap
 * @generated
 */
@ProviderType
public class MarketingEventSessionSoap implements Serializable {
	public static MarketingEventSessionSoap toSoapModel(
		MarketingEventSession model) {
		MarketingEventSessionSoap soapModel = new MarketingEventSessionSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setMarketingEventSessionId(model.getMarketingEventSessionId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setMarketingEventId(model.getMarketingEventId());
		soapModel.setMarketingEventSessionRoomId(model.getMarketingEventSessionRoomId());
		soapModel.setTitle(model.getTitle());
		soapModel.setDescription(model.getDescription());
		soapModel.setKeywords(model.getKeywords());
		soapModel.setSlidesFileEntryId(model.getSlidesFileEntryId());
		soapModel.setVideoURL(model.getVideoURL());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());

		return soapModel;
	}

	public static MarketingEventSessionSoap[] toSoapModels(
		MarketingEventSession[] models) {
		MarketingEventSessionSoap[] soapModels = new MarketingEventSessionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MarketingEventSessionSoap[][] toSoapModels(
		MarketingEventSession[][] models) {
		MarketingEventSessionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MarketingEventSessionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MarketingEventSessionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MarketingEventSessionSoap[] toSoapModels(
		List<MarketingEventSession> models) {
		List<MarketingEventSessionSoap> soapModels = new ArrayList<MarketingEventSessionSoap>(models.size());

		for (MarketingEventSession model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MarketingEventSessionSoap[soapModels.size()]);
	}

	public MarketingEventSessionSoap() {
	}

	public long getPrimaryKey() {
		return _marketingEventSessionId;
	}

	public void setPrimaryKey(long pk) {
		setMarketingEventSessionId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getMarketingEventSessionId() {
		return _marketingEventSessionId;
	}

	public void setMarketingEventSessionId(long marketingEventSessionId) {
		_marketingEventSessionId = marketingEventSessionId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
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

	public long getMarketingEventSessionRoomId() {
		return _marketingEventSessionRoomId;
	}

	public void setMarketingEventSessionRoomId(long marketingEventSessionRoomId) {
		_marketingEventSessionRoomId = marketingEventSessionRoomId;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getKeywords() {
		return _keywords;
	}

	public void setKeywords(String keywords) {
		_keywords = keywords;
	}

	public long getSlidesFileEntryId() {
		return _slidesFileEntryId;
	}

	public void setSlidesFileEntryId(long slidesFileEntryId) {
		_slidesFileEntryId = slidesFileEntryId;
	}

	public String getVideoURL() {
		return _videoURL;
	}

	public void setVideoURL(String videoURL) {
		_videoURL = videoURL;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
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
	private long _marketingEventSessionId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _marketingEventId;
	private long _marketingEventSessionRoomId;
	private String _title;
	private String _description;
	private String _keywords;
	private long _slidesFileEntryId;
	private String _videoURL;
	private Date _startDate;
	private Date _endDate;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
}