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

package com.liferay.hubspot.model;

import com.liferay.portal.kernel.json.JSONObject;

import java.io.Serializable;

import java.util.Date;

/**
 * @author Peter Shin
 */
public interface HSContact extends Serializable {

	public String getCity();

	public String getCountry();

	public Date getCreateDate();

	public String getEmailAddress();

	public String getFirstName();

	public JSONObject getHSContactJSONObject();

	public String getJobTitle();

	public String getLastName();

	public String getLifeCycleStage();

	public Date getModifiedDate();

	public String getNotes();

	public String getPersona();

	public String getPhoneNumber();

	public String getPostalCode();

	public String getRegion();

	public String getSFLeadCompany();

	public String getSFLeadCountry();

	public String getSFLeadDepartment();

	public String getSFLeadIndustry();

	public String getSFLeadRole();

	public String getSFLeadSource();

	public Integer getSFTrialLicenseCount();

	public String getStreet();

	public String getTwitterUserName();

	public Long getVisitorId();

	public String getWebsiteURL();

	public void setCity(String city);

	public void setCountry(String country);

	public void setCreateDate(Date createDate);

	public void setEmailAddress(String emailAddress);

	public void setFirstName(String firstName);

	public void setHSContactJSONObject(JSONObject hsContactJSONObject);

	public void setJobTitle(String jobTitle);

	public void setLastName(String lastName);

	public void setLifeCycleStage(String lifeCycleStage);

	public void setModifiedDate(Date modifiedDate);

	public void setNotes(String notes);

	public void setPersona(String persona);

	public void setPhoneNumber(String phoneNumber);

	public void setPostalCode(String postalCode);

	public void setRegion(String region);

	public void setSFLeadCompany(String sfLeadCompany);

	public void setSFLeadCountry(String sfLeadCountry);

	public void setSFLeadDepartment(String sfLeadDepartment);

	public void setSFLeadIndustry(String sfLeadIndustry);

	public void setSFLeadRole(String sfLeadRole);

	public void setSFLeadSource(String sfLeadSource);

	public void setSFTrialLicenseCount(Integer sfTrialLicenseCount);

	public void setStreet(String street);

	public void setTwitterUserName(String twitterUserName);

	public void setVisitorId(Long visitorId);

	public void setWebsiteURL(String websiteURL);

}
