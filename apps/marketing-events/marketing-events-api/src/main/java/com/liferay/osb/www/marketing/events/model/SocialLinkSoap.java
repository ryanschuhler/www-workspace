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
 * This class is used by SOAP remote services, specifically {@link com.liferay.osb.www.marketing.events.service.http.SocialLinkServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.osb.www.marketing.events.service.http.SocialLinkServiceSoap
 * @generated
 */
@ProviderType
public class SocialLinkSoap implements Serializable {
	public static SocialLinkSoap toSoapModel(SocialLink model) {
		SocialLinkSoap soapModel = new SocialLinkSoap();

		soapModel.setSocialLinkId(model.getSocialLinkId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setMarketingEventUserId(model.getMarketingEventUserId());
		soapModel.setSocialLinkTypeId(model.getSocialLinkTypeId());
		soapModel.setUrl(model.getUrl());

		return soapModel;
	}

	public static SocialLinkSoap[] toSoapModels(SocialLink[] models) {
		SocialLinkSoap[] soapModels = new SocialLinkSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SocialLinkSoap[][] toSoapModels(SocialLink[][] models) {
		SocialLinkSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SocialLinkSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SocialLinkSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SocialLinkSoap[] toSoapModels(List<SocialLink> models) {
		List<SocialLinkSoap> soapModels = new ArrayList<SocialLinkSoap>(models.size());

		for (SocialLink model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SocialLinkSoap[soapModels.size()]);
	}

	public SocialLinkSoap() {
	}

	public long getPrimaryKey() {
		return _socialLinkId;
	}

	public void setPrimaryKey(long pk) {
		setSocialLinkId(pk);
	}

	public long getSocialLinkId() {
		return _socialLinkId;
	}

	public void setSocialLinkId(long socialLinkId) {
		_socialLinkId = socialLinkId;
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

	public long getMarketingEventUserId() {
		return _marketingEventUserId;
	}

	public void setMarketingEventUserId(long marketingEventUserId) {
		_marketingEventUserId = marketingEventUserId;
	}

	public long getSocialLinkTypeId() {
		return _socialLinkTypeId;
	}

	public void setSocialLinkTypeId(long socialLinkTypeId) {
		_socialLinkTypeId = socialLinkTypeId;
	}

	public String getUrl() {
		return _url;
	}

	public void setUrl(String url) {
		_url = url;
	}

	private long _socialLinkId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _marketingEventUserId;
	private long _socialLinkTypeId;
	private String _url;
}