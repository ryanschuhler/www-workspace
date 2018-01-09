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
 * Provides the remote service utility for HSForm. This utility wraps
 * {@link com.liferay.hubspot.service.impl.HSFormServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Peter Shin
 * @see HSFormService
 * @see com.liferay.hubspot.service.base.HSFormServiceBaseImpl
 * @see com.liferay.hubspot.service.impl.HSFormServiceImpl
 * @generated
 */
@ProviderType
public class HSFormServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.hubspot.service.impl.HSFormServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
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

	public static HSFormService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<HSFormService, HSFormService> _serviceTracker = ServiceTrackerFactory.open(HSFormService.class);
}