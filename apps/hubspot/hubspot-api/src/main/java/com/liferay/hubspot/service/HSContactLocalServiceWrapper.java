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

package com.liferay.hubspot.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link HSContactLocalService}.
 *
 * @author Peter Shin
 * @see HSContactLocalService
 * @generated
 */
@ProviderType
public class HSContactLocalServiceWrapper implements HSContactLocalService,
	ServiceWrapper<HSContactLocalService> {
	public HSContactLocalServiceWrapper(
		HSContactLocalService hsContactLocalService) {
		_hsContactLocalService = hsContactLocalService;
	}

	@Override
	public com.liferay.hubspot.model.HSContact addHSContact(long companyId,
		java.lang.String className, long classPK,
		java.lang.String emailAddress, java.lang.String firstName,
		java.lang.String lastName, java.lang.String phoneNumber,
		java.lang.String street, java.lang.String city,
		java.lang.String region, java.lang.String postalCode,
		java.lang.String country, java.lang.String jobTitle,
		java.lang.String twitterUserName, java.lang.String websiteURL,
		java.lang.String notes, java.lang.String lifeCycleStage,
		java.lang.String persona, java.lang.String sfLeadCountry,
		java.lang.String sfLeadIndustry, java.lang.String sfLeadCompany,
		java.lang.String sfLeadDepartment, java.lang.String sfLeadRole,
		java.lang.String sfLeadSource)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _hsContactLocalService.addHSContact(companyId, className,
			classPK, emailAddress, firstName, lastName, phoneNumber, street,
			city, region, postalCode, country, jobTitle, twitterUserName,
			websiteURL, notes, lifeCycleStage, persona, sfLeadCountry,
			sfLeadIndustry, sfLeadCompany, sfLeadDepartment, sfLeadRole,
			sfLeadSource);
	}

	@Override
	public com.liferay.hubspot.model.HSContact fetchHSContactByEmailAddress(
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _hsContactLocalService.fetchHSContactByEmailAddress(emailAddress);
	}

	@Override
	public com.liferay.hubspot.model.HSContact fetchHSContactByUserToken(
		java.lang.String userToken)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _hsContactLocalService.fetchHSContactByUserToken(userToken);
	}

	@Override
	public com.liferay.hubspot.model.HSContact fetchHSContactByVisitorId(
		long visitorId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _hsContactLocalService.fetchHSContactByVisitorId(visitorId);
	}

	@Override
	public com.liferay.hubspot.model.HSContact getHSContactByEmailAddress(
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _hsContactLocalService.getHSContactByEmailAddress(emailAddress);
	}

	@Override
	public com.liferay.hubspot.model.HSContact getHSContactByUserToken(
		java.lang.String userToken)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _hsContactLocalService.getHSContactByUserToken(userToken);
	}

	@Override
	public com.liferay.hubspot.model.HSContact getHSContactByVisitorId(
		long visitorId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _hsContactLocalService.getHSContactByVisitorId(visitorId);
	}

	@Override
	public com.liferay.hubspot.model.HSContact updateHSContact(long companyId,
		java.lang.String className, long classPK, long visitorId,
		java.lang.String emailAddress, java.lang.String firstName,
		java.lang.String lastName, java.lang.String phoneNumber,
		java.lang.String street, java.lang.String city,
		java.lang.String region, java.lang.String postalCode,
		java.lang.String country, java.lang.String jobTitle,
		java.lang.String twitterUserName, java.lang.String websiteURL,
		java.lang.String notes, java.lang.String lifeCycleStage,
		java.lang.String persona, java.lang.String sfLeadCountry,
		java.lang.String sfLeadIndustry, java.lang.String sfLeadCompany,
		java.lang.String sfLeadDepartment, java.lang.String sfLeadRole,
		java.lang.String sfLeadSource)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _hsContactLocalService.updateHSContact(companyId, className,
			classPK, visitorId, emailAddress, firstName, lastName, phoneNumber,
			street, city, region, postalCode, country, jobTitle,
			twitterUserName, websiteURL, notes, lifeCycleStage, persona,
			sfLeadCountry, sfLeadIndustry, sfLeadCompany, sfLeadDepartment,
			sfLeadRole, sfLeadSource);
	}

	@Override
	public com.liferay.hubspot.model.HSContact updateHSContact(long companyId,
		java.lang.String className, long classPK, long visitorId,
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String phoneNumber, java.lang.String street,
		java.lang.String city, java.lang.String region,
		java.lang.String postalCode, java.lang.String country,
		java.lang.String jobTitle, java.lang.String twitterUserName,
		java.lang.String websiteURL, java.lang.String persona)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _hsContactLocalService.updateHSContact(companyId, className,
			classPK, visitorId, firstName, lastName, phoneNumber, street, city,
			region, postalCode, country, jobTitle, twitterUserName, websiteURL,
			persona);
	}

	@Override
	public com.liferay.portal.kernel.messaging.Message getAllHSContactSummaries(
		int contactOffset, int count)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _hsContactLocalService.getAllHSContactSummaries(contactOffset,
			count);
	}

	@Override
	public com.liferay.portal.kernel.messaging.Message getRecentHSContactSummaries(
		int contactOffset, int timeOffset, int count)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _hsContactLocalService.getRecentHSContactSummaries(contactOffset,
			timeOffset, count);
	}

	@Override
	public com.liferay.portal.kernel.messaging.Message search(
		java.lang.String query, int offset, int count)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _hsContactLocalService.search(query, offset, count);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _hsContactLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public void deleteHSContact(long companyId, long userId, long visitorId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_hsContactLocalService.deleteHSContact(companyId, userId, visitorId);
	}

	@Override
	public HSContactLocalService getWrappedService() {
		return _hsContactLocalService;
	}

	@Override
	public void setWrappedService(HSContactLocalService hsContactLocalService) {
		_hsContactLocalService = hsContactLocalService;
	}

	private HSContactLocalService _hsContactLocalService;
}