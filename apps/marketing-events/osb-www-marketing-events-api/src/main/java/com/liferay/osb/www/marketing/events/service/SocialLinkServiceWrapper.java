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

package com.liferay.osb.www.marketing.events.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SocialLinkService}.
 *
 * @author Brian Wing Shun Chan
 * @see SocialLinkService
 * @generated
 */
@ProviderType
public class SocialLinkServiceWrapper implements SocialLinkService,
	ServiceWrapper<SocialLinkService> {
	public SocialLinkServiceWrapper(SocialLinkService socialLinkService) {
		_socialLinkService = socialLinkService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _socialLinkService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<com.liferay.osb.www.marketing.events.model.SocialLink> getSocialLinks(
		long marketingEventUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _socialLinkService.getSocialLinks(marketingEventUserId, start,
			end);
	}

	@Override
	public SocialLinkService getWrappedService() {
		return _socialLinkService;
	}

	@Override
	public void setWrappedService(SocialLinkService socialLinkService) {
		_socialLinkService = socialLinkService;
	}

	private SocialLinkService _socialLinkService;
}