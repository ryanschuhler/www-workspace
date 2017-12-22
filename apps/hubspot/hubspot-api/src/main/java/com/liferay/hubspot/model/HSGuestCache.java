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

import java.io.Serializable;

/**
 * @author Peter Shin
 */
public interface HSGuestCache extends Serializable {

	public String getEmailAddress();

	public String getFirstName();

	public String getLastName();

	public String getPhoneNumber();

	public String getSFLeadCompany();

	public String getSFLeadCountry();

	public String getSFLeadDepartment();

	public String getSFLeadIndustry();

	public String getSFLeadRole();

	public Long getVisitorId();

	public void setEmailAddress(String emailAddress);

	public void setFirstName(String firstName);

	public void setLastName(String lastName);

	public void setPhoneNumber(String phoneNumber);

	public void setSFLeadCompany(String sfLeadCompany);

	public void setSFLeadCountry(String sfLeadCountry);

	public void setSFLeadDepartment(String sfLeadDepartment);

	public void setSFLeadIndustry(String sfLeadIndustry);

	public void setSFLeadRole(String sfLeadRole);

	public void setVisitorId(Long visitorId);

	public String toString();

}
