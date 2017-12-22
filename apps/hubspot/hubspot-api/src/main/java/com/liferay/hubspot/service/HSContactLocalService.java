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

import com.liferay.hubspot.model.HSContact;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

/**
 * Provides the local service interface for HSContact. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Peter Shin
 * @see HSContactLocalServiceUtil
 * @see com.liferay.hubspot.service.base.HSContactLocalServiceBaseImpl
 * @see com.liferay.hubspot.service.impl.HSContactLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface HSContactLocalService extends BaseLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link HSContactLocalServiceUtil} to access the hs contact local service. Add custom service methods to {@link com.liferay.hubspot.service.impl.HSContactLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public HSContact addHSContact(long companyId, java.lang.String className,
		long classPK, java.lang.String emailAddress,
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
		throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public HSContact fetchHSContactByEmailAddress(java.lang.String emailAddress)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public HSContact fetchHSContactByUserToken(java.lang.String userToken)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public HSContact fetchHSContactByVisitorId(long visitorId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public HSContact getHSContactByEmailAddress(java.lang.String emailAddress)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public HSContact getHSContactByUserToken(java.lang.String userToken)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public HSContact getHSContactByVisitorId(long visitorId)
		throws PortalException;

	public HSContact updateHSContact(long companyId,
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
		java.lang.String sfLeadSource) throws PortalException, SystemException;

	public HSContact updateHSContact(long companyId,
		java.lang.String className, long classPK, long visitorId,
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String phoneNumber, java.lang.String street,
		java.lang.String city, java.lang.String region,
		java.lang.String postalCode, java.lang.String country,
		java.lang.String jobTitle, java.lang.String twitterUserName,
		java.lang.String websiteURL, java.lang.String persona)
		throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Message getAllHSContactSummaries(int contactOffset, int count)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Message getRecentHSContactSummaries(int contactOffset,
		int timeOffset, int count) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Message search(java.lang.String query, int offset, int count)
		throws PortalException;

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	public void deleteHSContact(long companyId, long userId, long visitorId)
		throws PortalException, SystemException;
}