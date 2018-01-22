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
 * This class is used by SOAP remote services, specifically {@link com.liferay.osb.www.marketing.events.service.http.MarketingEventSessionRoomServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.osb.www.marketing.events.service.http.MarketingEventSessionRoomServiceSoap
 * @generated
 */
@ProviderType
public class MarketingEventSessionRoomSoap implements Serializable {
	public static MarketingEventSessionRoomSoap toSoapModel(
		MarketingEventSessionRoom model) {
		MarketingEventSessionRoomSoap soapModel = new MarketingEventSessionRoomSoap();

		soapModel.setMarketingEventSessionRoomId(model.getMarketingEventSessionRoomId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setMarketingEventId(model.getMarketingEventId());
		soapModel.setName(model.getName());
		soapModel.setImageFileEntryId(model.getImageFileEntryId());

		return soapModel;
	}

	public static MarketingEventSessionRoomSoap[] toSoapModels(
		MarketingEventSessionRoom[] models) {
		MarketingEventSessionRoomSoap[] soapModels = new MarketingEventSessionRoomSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MarketingEventSessionRoomSoap[][] toSoapModels(
		MarketingEventSessionRoom[][] models) {
		MarketingEventSessionRoomSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MarketingEventSessionRoomSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MarketingEventSessionRoomSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MarketingEventSessionRoomSoap[] toSoapModels(
		List<MarketingEventSessionRoom> models) {
		List<MarketingEventSessionRoomSoap> soapModels = new ArrayList<MarketingEventSessionRoomSoap>(models.size());

		for (MarketingEventSessionRoom model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MarketingEventSessionRoomSoap[soapModels.size()]);
	}

	public MarketingEventSessionRoomSoap() {
	}

	public long getPrimaryKey() {
		return _marketingEventSessionRoomId;
	}

	public void setPrimaryKey(long pk) {
		setMarketingEventSessionRoomId(pk);
	}

	public long getMarketingEventSessionRoomId() {
		return _marketingEventSessionRoomId;
	}

	public void setMarketingEventSessionRoomId(long marketingEventSessionRoomId) {
		_marketingEventSessionRoomId = marketingEventSessionRoomId;
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

	public long getImageFileEntryId() {
		return _imageFileEntryId;
	}

	public void setImageFileEntryId(long imageFileEntryId) {
		_imageFileEntryId = imageFileEntryId;
	}

	private long _marketingEventSessionRoomId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _marketingEventId;
	private String _name;
	private long _imageFileEntryId;
}