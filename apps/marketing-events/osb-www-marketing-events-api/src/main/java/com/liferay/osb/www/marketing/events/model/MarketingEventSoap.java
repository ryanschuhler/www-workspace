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
 * This class is used by SOAP remote services, specifically {@link com.liferay.osb.www.marketing.events.service.http.MarketingEventServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.osb.www.marketing.events.service.http.MarketingEventServiceSoap
 * @generated
 */
@ProviderType
public class MarketingEventSoap implements Serializable {
	public static MarketingEventSoap toSoapModel(MarketingEvent model) {
		MarketingEventSoap soapModel = new MarketingEventSoap();

		soapModel.setMarketingEventId(model.getMarketingEventId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setType(model.getType());
		soapModel.setTitle(model.getTitle());
		soapModel.setTitleURL(model.getTitleURL());
		soapModel.setHostedBy(model.getHostedBy());
		soapModel.setHostedByURL(model.getHostedByURL());
		soapModel.setSummary(model.getSummary());
		soapModel.setSiteGroupId(model.getSiteGroupId());
		soapModel.setImageFileEntryId(model.getImageFileEntryId());
		soapModel.setSlidesFileEntryId(model.getSlidesFileEntryId());
		soapModel.setVideoTitle(model.getVideoTitle());
		soapModel.setTimeZoneId(model.getTimeZoneId());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setDateTBA(model.getDateTBA());
		soapModel.setAddressId(model.getAddressId());
		soapModel.setLatitude(model.getLatitude());
		soapModel.setLongitude(model.getLongitude());
		soapModel.setGlobalRegion(model.getGlobalRegion());
		soapModel.setOnline(model.getOnline());
		soapModel.setRegistrationType(model.getRegistrationType());
		soapModel.setRegistrationURL(model.getRegistrationURL());
		soapModel.setExtraSettings(model.getExtraSettings());

		return soapModel;
	}

	public static MarketingEventSoap[] toSoapModels(MarketingEvent[] models) {
		MarketingEventSoap[] soapModels = new MarketingEventSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MarketingEventSoap[][] toSoapModels(MarketingEvent[][] models) {
		MarketingEventSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MarketingEventSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MarketingEventSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MarketingEventSoap[] toSoapModels(List<MarketingEvent> models) {
		List<MarketingEventSoap> soapModels = new ArrayList<MarketingEventSoap>(models.size());

		for (MarketingEvent model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MarketingEventSoap[soapModels.size()]);
	}

	public MarketingEventSoap() {
	}

	public long getPrimaryKey() {
		return _marketingEventId;
	}

	public void setPrimaryKey(long pk) {
		setMarketingEventId(pk);
	}

	public long getMarketingEventId() {
		return _marketingEventId;
	}

	public void setMarketingEventId(long marketingEventId) {
		_marketingEventId = marketingEventId;
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

	public int getType() {
		return _type;
	}

	public void setType(int type) {
		_type = type;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getTitleURL() {
		return _titleURL;
	}

	public void setTitleURL(String titleURL) {
		_titleURL = titleURL;
	}

	public String getHostedBy() {
		return _hostedBy;
	}

	public void setHostedBy(String hostedBy) {
		_hostedBy = hostedBy;
	}

	public String getHostedByURL() {
		return _hostedByURL;
	}

	public void setHostedByURL(String hostedByURL) {
		_hostedByURL = hostedByURL;
	}

	public String getSummary() {
		return _summary;
	}

	public void setSummary(String summary) {
		_summary = summary;
	}

	public long getSiteGroupId() {
		return _siteGroupId;
	}

	public void setSiteGroupId(long siteGroupId) {
		_siteGroupId = siteGroupId;
	}

	public long getImageFileEntryId() {
		return _imageFileEntryId;
	}

	public void setImageFileEntryId(long imageFileEntryId) {
		_imageFileEntryId = imageFileEntryId;
	}

	public long getSlidesFileEntryId() {
		return _slidesFileEntryId;
	}

	public void setSlidesFileEntryId(long slidesFileEntryId) {
		_slidesFileEntryId = slidesFileEntryId;
	}

	public String getVideoTitle() {
		return _videoTitle;
	}

	public void setVideoTitle(String videoTitle) {
		_videoTitle = videoTitle;
	}

	public String getTimeZoneId() {
		return _timeZoneId;
	}

	public void setTimeZoneId(String timeZoneId) {
		_timeZoneId = timeZoneId;
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

	public boolean getDateTBA() {
		return _dateTBA;
	}

	public boolean isDateTBA() {
		return _dateTBA;
	}

	public void setDateTBA(boolean dateTBA) {
		_dateTBA = dateTBA;
	}

	public long getAddressId() {
		return _addressId;
	}

	public void setAddressId(long addressId) {
		_addressId = addressId;
	}

	public double getLatitude() {
		return _latitude;
	}

	public void setLatitude(double latitude) {
		_latitude = latitude;
	}

	public double getLongitude() {
		return _longitude;
	}

	public void setLongitude(double longitude) {
		_longitude = longitude;
	}

	public int getGlobalRegion() {
		return _globalRegion;
	}

	public void setGlobalRegion(int globalRegion) {
		_globalRegion = globalRegion;
	}

	public boolean getOnline() {
		return _online;
	}

	public boolean isOnline() {
		return _online;
	}

	public void setOnline(boolean online) {
		_online = online;
	}

	public int getRegistrationType() {
		return _registrationType;
	}

	public void setRegistrationType(int registrationType) {
		_registrationType = registrationType;
	}

	public String getRegistrationURL() {
		return _registrationURL;
	}

	public void setRegistrationURL(String registrationURL) {
		_registrationURL = registrationURL;
	}

	public String getExtraSettings() {
		return _extraSettings;
	}

	public void setExtraSettings(String extraSettings) {
		_extraSettings = extraSettings;
	}

	private long _marketingEventId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _type;
	private String _title;
	private String _titleURL;
	private String _hostedBy;
	private String _hostedByURL;
	private String _summary;
	private long _siteGroupId;
	private long _imageFileEntryId;
	private long _slidesFileEntryId;
	private String _videoTitle;
	private String _timeZoneId;
	private Date _startDate;
	private Date _endDate;
	private boolean _dateTBA;
	private long _addressId;
	private double _latitude;
	private double _longitude;
	private int _globalRegion;
	private boolean _online;
	private int _registrationType;
	private String _registrationURL;
	private String _extraSettings;
}