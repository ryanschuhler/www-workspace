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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for HSContact. This utility wraps
 * {@link com.liferay.hubspot.service.impl.HSContactLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Peter Shin
 * @see HSContactLocalService
 * @see com.liferay.hubspot.service.base.HSContactLocalServiceBaseImpl
 * @see com.liferay.hubspot.service.impl.HSContactLocalServiceImpl
 * @generated
 */
@ProviderType
public class HSContactLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.hubspot.service.impl.HSContactLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.hubspot.model.HSContact addHSContact(
		long companyId, java.lang.String className, long classPK,
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
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addHSContact(companyId, className, classPK, emailAddress,
			firstName, lastName, phoneNumber, street, city, region, postalCode,
			country, jobTitle, twitterUserName, websiteURL, notes,
			lifeCycleStage, persona, sfLeadCountry, sfLeadIndustry,
			sfLeadCompany, sfLeadDepartment, sfLeadRole, sfLeadSource);
	}

	public static void deleteHSContact(long companyId, long userId,
		long visitorId)
		throws com.liferay.portal.kernel.exception.PortalException {
		getService().deleteHSContact(companyId, userId, visitorId);
	}

	public static com.liferay.hubspot.model.HSContact fetchHSContactByEmailAddress(
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().fetchHSContactByEmailAddress(emailAddress);
	}

	public static com.liferay.hubspot.model.HSContact fetchHSContactByUserToken(
		java.lang.String userToken)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().fetchHSContactByUserToken(userToken);
	}

	public static com.liferay.hubspot.model.HSContact fetchHSContactByVisitorId(
		long visitorId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().fetchHSContactByVisitorId(visitorId);
	}

	public static com.liferay.portal.kernel.messaging.Message getAllHSContactSummaries(
		int contactOffset, int count)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getAllHSContactSummaries(contactOffset, count);
	}

	public static com.liferay.hubspot.model.HSContact getHSContactByEmailAddress(
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getHSContactByEmailAddress(emailAddress);
	}

	public static com.liferay.hubspot.model.HSContact getHSContactByUserToken(
		java.lang.String userToken)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getHSContactByUserToken(userToken);
	}

	public static com.liferay.hubspot.model.HSContact getHSContactByVisitorId(
		long visitorId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getHSContactByVisitorId(visitorId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.messaging.Message getRecentHSContactSummaries(
		int contactOffset, int timeOffset, int count)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .getRecentHSContactSummaries(contactOffset, timeOffset, count);
	}

	public static com.liferay.portal.kernel.messaging.Message search(
		java.lang.String query, int offset, int count)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().search(query, offset, count);
	}

	public static com.liferay.hubspot.model.HSContact updateHSContact(
		long companyId, java.lang.String className, long classPK,
		long visitorId, java.lang.String firstName, java.lang.String lastName,
		java.lang.String phoneNumber, java.lang.String street,
		java.lang.String city, java.lang.String region,
		java.lang.String postalCode, java.lang.String country,
		java.lang.String jobTitle, java.lang.String twitterUserName,
		java.lang.String websiteURL, java.lang.String persona)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateHSContact(companyId, className, classPK, visitorId,
			firstName, lastName, phoneNumber, street, city, region, postalCode,
			country, jobTitle, twitterUserName, websiteURL, persona);
	}

	public static com.liferay.hubspot.model.HSContact updateHSContact(
		long companyId, java.lang.String className, long classPK,
		long visitorId, java.lang.String emailAddress,
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String phoneNumber, java.lang.String street,
		java.lang.String city, java.lang.String region,
		java.lang.String postalCode, java.lang.String country,
		java.lang.String jobTitle, java.lang.String twitterUserName,
		java.lang.String websiteURL, java.lang.String notes,
		java.lang.String lifeCycleStage, java.lang.String persona,
		java.lang.String sfLeadCountry, java.lang.String sfLeadIndustry,
		java.lang.String sfLeadCompany, java.lang.String sfLeadDepartment,
		java.lang.String sfLeadRole, java.lang.String sfLeadSource)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateHSContact(companyId, className, classPK, visitorId,
			emailAddress, firstName, lastName, phoneNumber, street, city,
			region, postalCode, country, jobTitle, twitterUserName, websiteURL,
			notes, lifeCycleStage, persona, sfLeadCountry, sfLeadIndustry,
			sfLeadCompany, sfLeadDepartment, sfLeadRole, sfLeadSource);
	}

	public static HSContactLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<HSContactLocalService, HSContactLocalService> _serviceTracker =
		ServiceTrackerFactory.open(HSContactLocalService.class);
}