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
 * Provides a wrapper for {@link HSFormLocalService}.
 *
 * @author Peter Shin
 * @see HSFormLocalService
 * @generated
 */
@ProviderType
public class HSFormLocalServiceWrapper implements HSFormLocalService,
	ServiceWrapper<HSFormLocalService> {
	public HSFormLocalServiceWrapper(HSFormLocalService hsFormLocalService) {
		_hsFormLocalService = hsFormLocalService;
	}

	@Override
	public com.liferay.hubspot.model.HSForm fetchHSFormByGUID(
		java.lang.String guid)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _hsFormLocalService.fetchHSFormByGUID(guid);
	}

	@Override
	public com.liferay.hubspot.model.HSForm getHSFormByGUID(
		java.lang.String guid)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _hsFormLocalService.getHSFormByGUID(guid);
	}

	@Override
	public com.liferay.hubspot.model.HSForm submitHSForm(
		java.lang.String guid, java.lang.String userToken,
		java.lang.String ipAddress, java.lang.String pageURL,
		java.lang.String pageName, java.lang.String redirectURL,
		java.lang.String salesforceCampaignId, java.lang.String[] fields)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _hsFormLocalService.submitHSForm(guid, userToken, ipAddress,
			pageURL, pageName, redirectURL, salesforceCampaignId, fields);
	}

	@Override
	public com.liferay.hubspot.model.HSForm submitHSForm(
		java.lang.String guid, java.lang.String[] fields)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _hsFormLocalService.submitHSForm(guid, fields);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _hsFormLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<com.liferay.hubspot.model.HSForm> getAllHSForms()
		throws com.liferay.portal.kernel.exception.PortalException {
		return _hsFormLocalService.getAllHSForms();
	}

	@Override
	public HSFormLocalService getWrappedService() {
		return _hsFormLocalService;
	}

	@Override
	public void setWrappedService(HSFormLocalService hsFormLocalService) {
		_hsFormLocalService = hsFormLocalService;
	}

	private HSFormLocalService _hsFormLocalService;
}