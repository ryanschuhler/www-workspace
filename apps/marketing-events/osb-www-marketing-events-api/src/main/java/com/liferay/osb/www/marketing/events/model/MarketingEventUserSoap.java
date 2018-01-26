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
 * This class is used by SOAP remote services, specifically {@link com.liferay.osb.www.marketing.events.service.http.MarketingEventUserServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.osb.www.marketing.events.service.http.MarketingEventUserServiceSoap
 * @generated
 */
@ProviderType
public class MarketingEventUserSoap implements Serializable {
	public static MarketingEventUserSoap toSoapModel(MarketingEventUser model) {
		MarketingEventUserSoap soapModel = new MarketingEventUserSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setMarketingEventUserId(model.getMarketingEventUserId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setMarketingEventId(model.getMarketingEventId());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setLastName(model.getLastName());
		soapModel.setCompanyName(model.getCompanyName());
		soapModel.setCompanyLogoFileEntryId(model.getCompanyLogoFileEntryId());
		soapModel.setJobTitle(model.getJobTitle());
		soapModel.setDescription(model.getDescription());
		soapModel.setImageFileEntryId(model.getImageFileEntryId());
		soapModel.setPhoneNumber(model.getPhoneNumber());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());

		return soapModel;
	}

	public static MarketingEventUserSoap[] toSoapModels(
		MarketingEventUser[] models) {
		MarketingEventUserSoap[] soapModels = new MarketingEventUserSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MarketingEventUserSoap[][] toSoapModels(
		MarketingEventUser[][] models) {
		MarketingEventUserSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MarketingEventUserSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MarketingEventUserSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MarketingEventUserSoap[] toSoapModels(
		List<MarketingEventUser> models) {
		List<MarketingEventUserSoap> soapModels = new ArrayList<MarketingEventUserSoap>(models.size());

		for (MarketingEventUser model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MarketingEventUserSoap[soapModels.size()]);
	}

	public MarketingEventUserSoap() {
	}

	public long getPrimaryKey() {
		return _marketingEventUserId;
	}

	public void setPrimaryKey(long pk) {
		setMarketingEventUserId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getMarketingEventUserId() {
		return _marketingEventUserId;
	}

	public void setMarketingEventUserId(long marketingEventUserId) {
		_marketingEventUserId = marketingEventUserId;
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

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public String getCompanyName() {
		return _companyName;
	}

	public void setCompanyName(String companyName) {
		_companyName = companyName;
	}

	public long getCompanyLogoFileEntryId() {
		return _companyLogoFileEntryId;
	}

	public void setCompanyLogoFileEntryId(long companyLogoFileEntryId) {
		_companyLogoFileEntryId = companyLogoFileEntryId;
	}

	public String getJobTitle() {
		return _jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		_jobTitle = jobTitle;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public long getImageFileEntryId() {
		return _imageFileEntryId;
	}

	public void setImageFileEntryId(long imageFileEntryId) {
		_imageFileEntryId = imageFileEntryId;
	}

	public String getPhoneNumber() {
		return _phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		_phoneNumber = phoneNumber;
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
	private long _marketingEventUserId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _marketingEventId;
	private String _firstName;
	private String _lastName;
	private String _companyName;
	private long _companyLogoFileEntryId;
	private String _jobTitle;
	private String _description;
	private long _imageFileEntryId;
	private String _phoneNumber;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
}