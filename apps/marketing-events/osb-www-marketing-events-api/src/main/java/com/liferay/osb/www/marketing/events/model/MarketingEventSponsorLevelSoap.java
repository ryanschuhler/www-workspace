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
 * This class is used by SOAP remote services, specifically {@link com.liferay.osb.www.marketing.events.service.http.MarketingEventSponsorLevelServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.osb.www.marketing.events.service.http.MarketingEventSponsorLevelServiceSoap
 * @generated
 */
@ProviderType
public class MarketingEventSponsorLevelSoap implements Serializable {
	public static MarketingEventSponsorLevelSoap toSoapModel(
		MarketingEventSponsorLevel model) {
		MarketingEventSponsorLevelSoap soapModel = new MarketingEventSponsorLevelSoap();

		soapModel.setMarketingEventSponsorLevelId(model.getMarketingEventSponsorLevelId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setMarketingEventId(model.getMarketingEventId());
		soapModel.setName(model.getName());
		soapModel.setPriority(model.getPriority());

		return soapModel;
	}

	public static MarketingEventSponsorLevelSoap[] toSoapModels(
		MarketingEventSponsorLevel[] models) {
		MarketingEventSponsorLevelSoap[] soapModels = new MarketingEventSponsorLevelSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MarketingEventSponsorLevelSoap[][] toSoapModels(
		MarketingEventSponsorLevel[][] models) {
		MarketingEventSponsorLevelSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MarketingEventSponsorLevelSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MarketingEventSponsorLevelSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MarketingEventSponsorLevelSoap[] toSoapModels(
		List<MarketingEventSponsorLevel> models) {
		List<MarketingEventSponsorLevelSoap> soapModels = new ArrayList<MarketingEventSponsorLevelSoap>(models.size());

		for (MarketingEventSponsorLevel model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MarketingEventSponsorLevelSoap[soapModels.size()]);
	}

	public MarketingEventSponsorLevelSoap() {
	}

	public long getPrimaryKey() {
		return _marketingEventSponsorLevelId;
	}

	public void setPrimaryKey(long pk) {
		setMarketingEventSponsorLevelId(pk);
	}

	public long getMarketingEventSponsorLevelId() {
		return _marketingEventSponsorLevelId;
	}

	public void setMarketingEventSponsorLevelId(
		long marketingEventSponsorLevelId) {
		_marketingEventSponsorLevelId = marketingEventSponsorLevelId;
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public int getPriority() {
		return _priority;
	}

	public void setPriority(int priority) {
		_priority = priority;
	}

	private long _marketingEventSponsorLevelId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _marketingEventId;
	private String _name;
	private int _priority;
}