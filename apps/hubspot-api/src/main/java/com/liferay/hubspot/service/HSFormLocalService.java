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

import com.liferay.hubspot.model.HSForm;
import com.liferay.hubspot.model.HSFormDisplay;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.util.List;

/**
 * Provides the local service interface for HSForm. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Peter Shin
 * @see HSFormLocalServiceUtil
 * @see com.liferay.hubspot.service.base.HSFormLocalServiceBaseImpl
 * @see com.liferay.hubspot.service.impl.HSFormLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface HSFormLocalService extends BaseLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link HSFormLocalServiceUtil} to access the hs form local service. Add custom service methods to {@link com.liferay.hubspot.service.impl.HSFormLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public HSForm fetchHSFormByGUID(java.lang.String guid)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<HSForm> getAllHSForms() throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public HSForm getHSFormByGUID(java.lang.String guid)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public HSFormDisplay getHSFormDisplay(java.lang.String guid,
		java.lang.String userToken);

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	public HSForm submitHSForm(java.lang.String guid,
		java.lang.String userToken, java.lang.String ipAddress,
		java.lang.String pageURL, java.lang.String pageName,
		java.lang.String redirectURL, java.lang.String salesforceCampaignId,
		java.lang.String[] fields) throws PortalException;

	public HSForm submitHSForm(java.lang.String guid, java.lang.String[] fields)
		throws PortalException;
}