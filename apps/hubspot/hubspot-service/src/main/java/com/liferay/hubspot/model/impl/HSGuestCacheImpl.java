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

package com.liferay.hubspot.model.impl;

import com.liferay.hubspot.model.HSContact;
import com.liferay.hubspot.model.HSContactCacheConstants;
import com.liferay.hubspot.model.HSGuestCache;
import com.liferay.hubspot.model.HSGuestCacheConstants;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.HtmlUtil;

/**
 * @author Peter Shin
 */
public class HSGuestCacheImpl implements HSGuestCache {

	public HSGuestCacheImpl(HSContact hsContact) {
		this(
			hsContact.getVisitorId(), hsContact.getEmailAddress(),
			hsContact.getFirstName(), hsContact.getLastName(),
			hsContact.getPhoneNumber(), hsContact.getSFLeadCountry(),
			hsContact.getSFLeadIndustry(), hsContact.getSFLeadCompany(),
			hsContact.getSFLeadDepartment(), hsContact.getSFLeadRole());
	}

	public HSGuestCacheImpl(long companyId, long licenseKeyId) {
		String data = null;

		JSONObject dataJSONObject = null;

		try {
			dataJSONObject = JSONFactoryUtil.createJSONObject(
				HtmlUtil.unescape(data));
		}
		catch (JSONException jsone) {
			return;
		}

		if (dataJSONObject.has(HSGuestCacheConstants.KEY_EMAIL_ADDRESS)) {
			_emailAddress = dataJSONObject.getString(
				HSGuestCacheConstants.KEY_EMAIL_ADDRESS);
		}

		if (dataJSONObject.has(HSGuestCacheConstants.KEY_FIRST_NAME)) {
			_firstName = dataJSONObject.getString(
				HSGuestCacheConstants.KEY_FIRST_NAME);
		}

		if (dataJSONObject.has(HSGuestCacheConstants.KEY_LAST_NAME)) {
			_lastName = dataJSONObject.getString(
				HSGuestCacheConstants.KEY_LAST_NAME);
		}

		if (dataJSONObject.has(HSGuestCacheConstants.KEY_PHONE_NUMBER)) {
			_phoneNumber = dataJSONObject.getString(
				HSGuestCacheConstants.KEY_PHONE_NUMBER);
		}

		if (dataJSONObject.has(HSGuestCacheConstants.KEY_SF_LEAD_COMPANY)) {
			_sfLeadCompany = dataJSONObject.getString(
				HSGuestCacheConstants.KEY_SF_LEAD_COMPANY);
		}

		if (dataJSONObject.has(HSGuestCacheConstants.KEY_SF_LEAD_COUNTRY)) {
			_sfLeadCountry = dataJSONObject.getString(
				HSGuestCacheConstants.KEY_SF_LEAD_COUNTRY);
		}

		if (dataJSONObject.has(HSGuestCacheConstants.KEY_SF_LEAD_INDUSTRY)) {
			_sfLeadIndustry = dataJSONObject.getString(
				HSGuestCacheConstants.KEY_SF_LEAD_INDUSTRY);
		}

		if (dataJSONObject.has(HSGuestCacheConstants.KEY_SF_LEAD_DEPARTMENT)) {
			_sfLeadDepartment = dataJSONObject.getString(
				HSGuestCacheConstants.KEY_SF_LEAD_DEPARTMENT);
		}

		if (dataJSONObject.has(HSGuestCacheConstants.KEY_SF_LEAD_ROLE)) {
			_sfLeadRole = dataJSONObject.getString(
				HSGuestCacheConstants.KEY_SF_LEAD_ROLE);
		}

		if (dataJSONObject.has(HSGuestCacheConstants.KEY_VISITOR_ID)) {
			_visitorId = dataJSONObject.getLong(
				HSGuestCacheConstants.KEY_VISITOR_ID);
		}
	}

	public HSGuestCacheImpl(
		Long visitorId, String emailAddress, String firstName, String lastName,
		String phoneNumber, String sfLeadCountry, String sfLeadIndustry,
		String sfLeadCompany, String sfLeadDepartment, String sfLeadRole) {

		_emailAddress = emailAddress;
		_firstName = firstName;
		_lastName = lastName;
		_phoneNumber = phoneNumber;
		_sfLeadCompany = sfLeadCompany;
		_sfLeadCountry = sfLeadCountry;
		_sfLeadDepartment = sfLeadDepartment;
		_sfLeadIndustry = sfLeadIndustry;
		_sfLeadRole = sfLeadRole;
		_visitorId = visitorId;
	}

	@Override
	public String getEmailAddress() {
		return _emailAddress;
	}

	@Override
	public String getFirstName() {
		return _firstName;
	}

	@Override
	public String getLastName() {
		return _lastName;
	}

	@Override
	public String getPhoneNumber() {
		return _phoneNumber;
	}

	@Override
	public String getSFLeadCompany() {
		return _sfLeadCompany;
	}

	@Override
	public String getSFLeadCountry() {
		return _sfLeadCountry;
	}

	@Override
	public String getSFLeadDepartment() {
		return _sfLeadDepartment;
	}

	@Override
	public String getSFLeadIndustry() {
		return _sfLeadIndustry;
	}

	@Override
	public String getSFLeadRole() {
		return _sfLeadRole;
	}

	@Override
	public Long getVisitorId() {
		return _visitorId;
	}

	@Override
	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	@Override
	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	@Override
	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	@Override
	public void setPhoneNumber(String phoneNumber) {
		_phoneNumber = phoneNumber;
	}

	@Override
	public void setSFLeadCompany(String sfLeadCompany) {
		_sfLeadCompany = sfLeadCompany;
	}

	@Override
	public void setSFLeadCountry(String sfLeadCountry) {
		_sfLeadCountry = sfLeadCountry;
	}

	@Override
	public void setSFLeadDepartment(String sfLeadDepartment) {
		_sfLeadDepartment = sfLeadDepartment;
	}

	@Override
	public void setSFLeadIndustry(String sfLeadIndustry) {
		_sfLeadIndustry = sfLeadIndustry;
	}

	@Override
	public void setSFLeadRole(String sfLeadRole) {
		_sfLeadRole = sfLeadRole;
	}

	@Override
	public void setVisitorId(Long visitorId) {
		_visitorId = visitorId;
	}

	@Override
	public String toString() {
		JSONObject dataJSONObject = JSONFactoryUtil.createJSONObject();

		if (getEmailAddress() != null) {
			dataJSONObject.put(
				HSGuestCacheConstants.KEY_EMAIL_ADDRESS, getEmailAddress());
		}

		if (getFirstName() != null) {
			dataJSONObject.put(
				HSGuestCacheConstants.KEY_FIRST_NAME, getFirstName());
		}

		if (getLastName() != null) {
			dataJSONObject.put(
				HSGuestCacheConstants.KEY_LAST_NAME, getLastName());
		}

		if (getPhoneNumber() != null) {
			dataJSONObject.put(
				HSGuestCacheConstants.KEY_PHONE_NUMBER, getPhoneNumber());
		}

		if (getSFLeadCompany() != null) {
			dataJSONObject.put(
				HSGuestCacheConstants.KEY_SF_LEAD_COMPANY, getSFLeadCompany());
		}

		if (getSFLeadCountry() != null) {
			dataJSONObject.put(
				HSGuestCacheConstants.KEY_SF_LEAD_COUNTRY, getSFLeadCountry());
		}

		if (getSFLeadDepartment() != null) {
			dataJSONObject.put(
				HSGuestCacheConstants.KEY_SF_LEAD_DEPARTMENT,
				getSFLeadDepartment());
		}

		if (getSFLeadIndustry() != null) {
			dataJSONObject.put(
				HSGuestCacheConstants.KEY_SF_LEAD_INDUSTRY,
				getSFLeadIndustry());
		}

		if (getSFLeadRole() != null) {
			dataJSONObject.put(
				HSGuestCacheConstants.KEY_SF_LEAD_ROLE, getSFLeadRole());
		}

		if (getVisitorId() != null) {
			dataJSONObject.put(
				HSContactCacheConstants.KEY_VISITOR_ID, getVisitorId());
		}

		return dataJSONObject.toString();
	}

	private String _emailAddress;
	private String _firstName;
	private String _lastName;
	private String _phoneNumber;
	private String _sfLeadCompany;
	private String _sfLeadCountry;
	private String _sfLeadDepartment;
	private String _sfLeadIndustry;
	private String _sfLeadRole;
	private Long _visitorId;

}