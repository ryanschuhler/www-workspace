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
 * Provides the local service utility for HSForm. This utility wraps
 * {@link com.liferay.hubspot.service.impl.HSFormLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Peter Shin
 * @see HSFormLocalService
 * @see com.liferay.hubspot.service.base.HSFormLocalServiceBaseImpl
 * @see com.liferay.hubspot.service.impl.HSFormLocalServiceImpl
 * @generated
 */
@ProviderType
public class HSFormLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.hubspot.service.impl.HSFormLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.hubspot.model.HSForm fetchHSFormByGUID(
		java.lang.String guid)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().fetchHSFormByGUID(guid);
	}

	public static com.liferay.hubspot.model.HSForm getHSFormByGUID(
		java.lang.String guid)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getHSFormByGUID(guid);
	}

	public static com.liferay.hubspot.model.HSForm submitHSForm(
		java.lang.String guid, java.lang.String userToken,
		java.lang.String ipAddress, java.lang.String pageURL,
		java.lang.String pageName, java.lang.String redirectURL,
		java.lang.String salesforceCampaignId, java.lang.String[] fields)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .submitHSForm(guid, userToken, ipAddress, pageURL, pageName,
			redirectURL, salesforceCampaignId, fields);
	}

	public static com.liferay.hubspot.model.HSForm submitHSForm(
		java.lang.String guid, java.lang.String[] fields)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().submitHSForm(guid, fields);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List<com.liferay.hubspot.model.HSForm> getAllHSForms()
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getAllHSForms();
	}

	public static HSFormLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<HSFormLocalService, HSFormLocalService> _serviceTracker =
		ServiceTrackerFactory.open(HSFormLocalService.class);
}