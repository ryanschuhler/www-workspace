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
 * This class is used by SOAP remote services, specifically {@link com.liferay.osb.www.marketing.events.service.http.MarketingEventSponsorServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.osb.www.marketing.events.service.http.MarketingEventSponsorServiceSoap
 * @generated
 */
@ProviderType
public class MarketingEventSponsorSoap implements Serializable {
	public static MarketingEventSponsorSoap toSoapModel(
		MarketingEventSponsor model) {
		MarketingEventSponsorSoap soapModel = new MarketingEventSponsorSoap();

		soapModel.setMarketingEventSponsorId(model.getMarketingEventSponsorId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setMarketingEventId(model.getMarketingEventId());
		soapModel.setMarketingEventSponsorLevelId(model.getMarketingEventSponsorLevelId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setImageFileEntryId(model.getImageFileEntryId());
		soapModel.setUrl(model.getUrl());

		return soapModel;
	}

	public static MarketingEventSponsorSoap[] toSoapModels(
		MarketingEventSponsor[] models) {
		MarketingEventSponsorSoap[] soapModels = new MarketingEventSponsorSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MarketingEventSponsorSoap[][] toSoapModels(
		MarketingEventSponsor[][] models) {
		MarketingEventSponsorSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MarketingEventSponsorSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MarketingEventSponsorSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MarketingEventSponsorSoap[] toSoapModels(
		List<MarketingEventSponsor> models) {
		List<MarketingEventSponsorSoap> soapModels = new ArrayList<MarketingEventSponsorSoap>(models.size());

		for (MarketingEventSponsor model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MarketingEventSponsorSoap[soapModels.size()]);
	}

	public MarketingEventSponsorSoap() {
	}

	public long getPrimaryKey() {
		return _marketingEventSponsorId;
	}

	public void setPrimaryKey(long pk) {
		setMarketingEventSponsorId(pk);
	}

	public long getMarketingEventSponsorId() {
		return _marketingEventSponsorId;
	}

	public void setMarketingEventSponsorId(long marketingEventSponsorId) {
		_marketingEventSponsorId = marketingEventSponsorId;
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

	public long getMarketingEventSponsorLevelId() {
		return _marketingEventSponsorLevelId;
	}

	public void setMarketingEventSponsorLevelId(
		long marketingEventSponsorLevelId) {
		_marketingEventSponsorLevelId = marketingEventSponsorLevelId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
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

	public String getUrl() {
		return _url;
	}

	public void setUrl(String url) {
		_url = url;
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
	private long _imageFileEntryId;
	private String _url;
}