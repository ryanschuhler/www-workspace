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
import com.liferay.hubspot.model.HSContactConstants;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.DateUtil;

import java.util.Date;

/**
 * @author Peter Shin
 */
public class HSContactImpl implements HSContact {

	public HSContactImpl() {
		this(
			null, null, null, null, null, null, null, null, null, null, null,
			null, null, null, null, null, null, null, null, null, null, null,
			null, null, null, null);
	}

	public HSContactImpl(JSONObject hsContactJSONObject) {
		processProperties(hsContactJSONObject);

		setHSContactJSONObject(hsContactJSONObject);
		setVisitorId(
			hsContactJSONObject.getLong(HSContactConstants.KEY_VISITOR_ID));
	}

	public HSContactImpl(
		Long visitorId, Date createDate, Date modifiedDate, String emailAddress,
		String firstName, String lastName, String phoneNumber, String street,
		String city, String region, String postalCode, String country,
		String jobTitle, String twitterUserName, String websiteURL,
		String notes, String lifeCycleStage, String persona,
		String sfLeadCountry, String sfLeadIndustry, String sfLeadCompany,
		String sfLeadDepartment, String sfLeadRole, Integer sfTrialLicenseCount,
		String sfLeadSource, JSONObject hsContactJSONObject) {

		_city = city;
		_country = country;
		_createDate = createDate;
		_emailAddress = emailAddress;
		_firstName = firstName;
		_hsContactJSONObject = hsContactJSONObject;
		_jobTitle = jobTitle;
		_lastName = lastName;
		_lifeCycleStage = lifeCycleStage;
		_modifiedDate = modifiedDate;
		_notes = notes;
		_persona = persona;
		_phoneNumber = phoneNumber;
		_postalCode = postalCode;
		_region = region;
		_sfLeadCompany = sfLeadCompany;
		_sfLeadCountry = sfLeadCountry;
		_sfLeadDepartment = sfLeadDepartment;
		_sfLeadIndustry = sfLeadIndustry;
		_sfLeadRole = sfLeadRole;
		_sfLeadSource = sfLeadSource;
		_sfTrialLicenseCount = sfTrialLicenseCount;
		_street = street;
		_twitterUserName = twitterUserName;
		_visitorId = visitorId;
		_websiteURL = websiteURL;
	}

	@Override
	public String getCity() {
		return _city;
	}

	@Override
	public String getCountry() {
		return _country;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
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
	public JSONObject getHSContactJSONObject() {
		return _hsContactJSONObject;
	}

	@Override
	public String getJobTitle() {
		return _jobTitle;
	}

	@Override
	public String getLastName() {
		return _lastName;
	}

	@Override
	public String getLifeCycleStage() {
		return _lifeCycleStage;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public String getNotes() {
		return _notes;
	}

	@Override
	public String getPersona() {
		return _persona;
	}

	@Override
	public String getPhoneNumber() {
		return _phoneNumber;
	}

	@Override
	public String getPostalCode() {
		return _postalCode;
	}

	@Override
	public String getRegion() {
		return _region;
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
	public String getSFLeadSource() {
		return _sfLeadSource;
	}

	@Override
	public Integer getSFTrialLicenseCount() {
		return _sfTrialLicenseCount;
	}

	@Override
	public String getStreet() {
		return _street;
	}

	@Override
	public String getTwitterUserName() {
		return _twitterUserName;
	}

	@Override
	public Long getVisitorId() {
		return _visitorId;
	}

	@Override
	public String getWebsiteURL() {
		return _websiteURL;
	}

	@Override
	public void setCity(String city) {
		_city = city;
	}

	@Override
	public void setCountry(String country) {
		_country = country;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
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
	public void setHSContactJSONObject(JSONObject hsContactJSONObject) {
		_hsContactJSONObject = hsContactJSONObject;
	}

	@Override
	public void setJobTitle(String jobTitle) {
		_jobTitle = jobTitle;
	}

	@Override
	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	@Override
	public void setLifeCycleStage(String lifeCycleStage) {
		_lifeCycleStage = lifeCycleStage;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@Override
	public void setNotes(String notes) {
		_notes = notes;
	}

	@Override
	public void setPersona(String persona) {
		_persona = persona;
	}

	@Override
	public void setPhoneNumber(String phoneNumber) {
		_phoneNumber = phoneNumber;
	}

	@Override
	public void setPostalCode(String postalCode) {
		_postalCode = postalCode;
	}

	@Override
	public void setRegion(String region) {
		_region = region;
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
	public void setSFLeadSource(String sfLeadSource) {
		_sfLeadSource = sfLeadSource;
	}

	@Override
	public void setSFTrialLicenseCount(Integer sfTrialLicenseCount) {
		_sfTrialLicenseCount = sfTrialLicenseCount;
	}

	@Override
	public void setStreet(String street) {
		_street = street;
	}

	@Override
	public void setTwitterUserName(String twitterUserName) {
		_twitterUserName = twitterUserName;
	}

	@Override
	public void setVisitorId(Long visitorId) {
		_visitorId = visitorId;
	}

	@Override
	public void setWebsiteURL(String websiteURL) {
		_websiteURL = websiteURL;
	}

	protected void processProperties(JSONObject contactJSONObject) {
		JSONObject propertiesJSONObject = contactJSONObject.getJSONObject(
			"properties");

		// HubSpot

		JSONObject jsonObject = propertiesJSONObject.getJSONObject(
			HSContactConstants.PROPERTY_CREATE_DATE);

		if (jsonObject != null) {
			setCreateDate(DateUtil.newDate(jsonObject.getLong("value")));
		}

		jsonObject = propertiesJSONObject.getJSONObject(
			HSContactConstants.PROPERTY_MODIFIED_DATE);

		if (jsonObject != null) {
			setModifiedDate(DateUtil.newDate(jsonObject.getLong("value")));
		}

		jsonObject = propertiesJSONObject.getJSONObject(
			HSContactConstants.PROPERTY_EMAIL_ADDRESS);

		if (jsonObject != null) {
			setEmailAddress(jsonObject.getString("value"));
		}

		jsonObject = propertiesJSONObject.getJSONObject(
			HSContactConstants.PROPERTY_FIRST_NAME);

		if (jsonObject != null) {
			setFirstName(jsonObject.getString("value"));
		}

		jsonObject = propertiesJSONObject.getJSONObject(
			HSContactConstants.PROPERTY_LAST_NAME);

		if (jsonObject != null) {
			setLastName(jsonObject.getString("value"));
		}

		jsonObject = propertiesJSONObject.getJSONObject(
			HSContactConstants.PROPERTY_PHONE_NUMBER);

		if (jsonObject != null) {
			setPhoneNumber(jsonObject.getString("value"));
		}

		// HubSpot Address

		jsonObject = propertiesJSONObject.getJSONObject(
			HSContactConstants.PROPERTY_STREET);

		if (jsonObject != null) {
			setStreet(jsonObject.getString("value"));
		}

		jsonObject = propertiesJSONObject.getJSONObject(
			HSContactConstants.PROPERTY_CITY);

		if (jsonObject != null) {
			setCity(jsonObject.getString("value"));
		}

		jsonObject = propertiesJSONObject.getJSONObject(
			HSContactConstants.PROPERTY_REGION);

		if (jsonObject != null) {
			setRegion(jsonObject.getString("value"));
		}

		jsonObject = propertiesJSONObject.getJSONObject(
			HSContactConstants.PROPERTY_POSTAL_CODE);

		if (jsonObject != null) {
			setPostalCode(jsonObject.getString("value"));
		}

		jsonObject = propertiesJSONObject.getJSONObject(
			HSContactConstants.PROPERTY_COUNTRY);

		if (jsonObject != null) {
			setCountry(jsonObject.getString("value"));
		}

		// HubSpot Other

		jsonObject = propertiesJSONObject.getJSONObject(
			HSContactConstants.PROPERTY_JOB_TITLE);

		if (jsonObject != null) {
			setJobTitle(jsonObject.getString("value"));
		}

		jsonObject = propertiesJSONObject.getJSONObject(
			HSContactConstants.PROPERTY_TWITTER_USERNAME);

		if (jsonObject != null) {
			setTwitterUserName(jsonObject.getString("value"));
		}

		jsonObject = propertiesJSONObject.getJSONObject(
			HSContactConstants.PROPERTY_WEBSITE_URL);

		if (jsonObject != null) {
			setWebsiteURL(jsonObject.getString("value"));
		}

		jsonObject = propertiesJSONObject.getJSONObject(
			HSContactConstants.PROPERTY_NOTES);

		if (jsonObject != null) {
			setNotes(jsonObject.getString("value"));
		}

		jsonObject = propertiesJSONObject.getJSONObject(
			HSContactConstants.PROPERTY_LIFE_CYCLE_STAGE);

		if (jsonObject != null) {
			setLifeCycleStage(jsonObject.getString("value"));
		}

		jsonObject = propertiesJSONObject.getJSONObject(
			HSContactConstants.PROPERTY_PERSONA);

		if (jsonObject != null) {
			setPersona(jsonObject.getString("value"));
		}

		// Salesforce

		jsonObject = propertiesJSONObject.getJSONObject(
			HSContactConstants.PROPERTY_SF_LEAD_COUNTRY);

		if (jsonObject != null) {
			setSFLeadCountry(jsonObject.getString("value"));
		}

		jsonObject = propertiesJSONObject.getJSONObject(
			HSContactConstants.PROPERTY_SF_LEAD_INDUSTRY);

		if (jsonObject != null) {
			setSFLeadIndustry(jsonObject.getString("value"));
		}

		jsonObject = propertiesJSONObject.getJSONObject(
			HSContactConstants.PROPERTY_SF_LEAD_COMPANY);

		if (jsonObject != null) {
			setSFLeadCompany(jsonObject.getString("value"));
		}

		jsonObject = propertiesJSONObject.getJSONObject(
			HSContactConstants.PROPERTY_SF_LEAD_DEPARTMENT);

		if (jsonObject != null) {
			setSFLeadDepartment(jsonObject.getString("value"));
		}

		jsonObject = propertiesJSONObject.getJSONObject(
			HSContactConstants.PROPERTY_SF_LEAD_ROLE);

		if (jsonObject != null) {
			setSFLeadRole(jsonObject.getString("value"));
		}

		jsonObject = propertiesJSONObject.getJSONObject(
			HSContactConstants.PROPERTY_SF_TRIAL_LICENSE_COUNT);

		if (jsonObject != null) {
			setSFTrialLicenseCount(jsonObject.getInt("value"));
		}

		jsonObject = propertiesJSONObject.getJSONObject(
			HSContactConstants.PROPERTY_SF_LEAD_SOURCE);

		if (jsonObject != null) {
			setSFLeadSource(jsonObject.getString("value"));
		}
	}

	private String _city;
	private String _country;
	private Date _createDate;
	private String _emailAddress;
	private String _firstName;
	private JSONObject _hsContactJSONObject;
	private String _jobTitle;
	private String _lastName;
	private String _lifeCycleStage;
	private Date _modifiedDate;
	private String _notes;
	private String _persona;
	private String _phoneNumber;
	private String _postalCode;
	private String _region;
	private String _sfLeadCompany;
	private String _sfLeadCountry;
	private String _sfLeadDepartment;
	private String _sfLeadIndustry;
	private String _sfLeadRole;
	private String _sfLeadSource;
	private Integer _sfTrialLicenseCount;
	private String _street;
	private String _twitterUserName;
	private Long _visitorId;
	private String _websiteURL;

}