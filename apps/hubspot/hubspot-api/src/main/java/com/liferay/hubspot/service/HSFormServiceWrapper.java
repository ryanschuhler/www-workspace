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
 * Provides a wrapper for {@link HSFormService}.
 *
 * @author Peter Shin
 * @see HSFormService
 * @generated
 */
@ProviderType
public class HSFormServiceWrapper implements HSFormService,
	ServiceWrapper<HSFormService> {
	public HSFormServiceWrapper(HSFormService hsFormService) {
		_hsFormService = hsFormService;
	}

	@Override
	public com.liferay.hubspot.model.HSForm submitHSForm(
		java.lang.String guid, java.lang.String userToken,
		java.lang.String ipAddress, java.lang.String pageURL,
		java.lang.String pageName, java.lang.String redirectURL,
		java.lang.String salesforceCampaignId, java.lang.String[] fields)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _hsFormService.submitHSForm(guid, userToken, ipAddress, pageURL,
			pageName, redirectURL, salesforceCampaignId, fields);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _hsFormService.getOSGiServiceIdentifier();
	}

	@Override
	public HSFormService getWrappedService() {
		return _hsFormService;
	}

	@Override
	public void setWrappedService(HSFormService hsFormService) {
		_hsFormService = hsFormService;
	}

	private HSFormService _hsFormService;
}