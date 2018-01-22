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
 * This class is used by SOAP remote services, specifically {@link com.liferay.osb.www.marketing.events.service.http.SocialLinkTypeServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.osb.www.marketing.events.service.http.SocialLinkTypeServiceSoap
 * @generated
 */
@ProviderType
public class SocialLinkTypeSoap implements Serializable {
	public static SocialLinkTypeSoap toSoapModel(SocialLinkType model) {
		SocialLinkTypeSoap soapModel = new SocialLinkTypeSoap();

		soapModel.setSocialLinkTypeId(model.getSocialLinkTypeId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setImageFileEntryId(model.getImageFileEntryId());

		return soapModel;
	}

	public static SocialLinkTypeSoap[] toSoapModels(SocialLinkType[] models) {
		SocialLinkTypeSoap[] soapModels = new SocialLinkTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SocialLinkTypeSoap[][] toSoapModels(SocialLinkType[][] models) {
		SocialLinkTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SocialLinkTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SocialLinkTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SocialLinkTypeSoap[] toSoapModels(List<SocialLinkType> models) {
		List<SocialLinkTypeSoap> soapModels = new ArrayList<SocialLinkTypeSoap>(models.size());

		for (SocialLinkType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SocialLinkTypeSoap[soapModels.size()]);
	}

	public SocialLinkTypeSoap() {
	}

	public long getPrimaryKey() {
		return _socialLinkTypeId;
	}

	public void setPrimaryKey(long pk) {
		setSocialLinkTypeId(pk);
	}

	public long getSocialLinkTypeId() {
		return _socialLinkTypeId;
	}

	public void setSocialLinkTypeId(long socialLinkTypeId) {
		_socialLinkTypeId = socialLinkTypeId;
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

	private long _socialLinkTypeId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private long _imageFileEntryId;
}