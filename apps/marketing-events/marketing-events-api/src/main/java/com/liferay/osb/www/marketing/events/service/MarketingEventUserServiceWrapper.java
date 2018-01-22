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
 * Provides a wrapper for {@link MarketingEventUserService}.
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEventUserService
 * @generated
 */
@ProviderType
public class MarketingEventUserServiceWrapper
	implements MarketingEventUserService,
		ServiceWrapper<MarketingEventUserService> {
	public MarketingEventUserServiceWrapper(
		MarketingEventUserService marketingEventUserService) {
		_marketingEventUserService = marketingEventUserService;
	}

	@Override
	public java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventUser> getMarketingEventUsers(
		long marketingEventId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventUserService.getMarketingEventUsers(marketingEventId,
			start, end);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _marketingEventUserService.getOSGiServiceIdentifier();
	}

	@Override
	public MarketingEventUserService getWrappedService() {
		return _marketingEventUserService;
	}

	@Override
	public void setWrappedService(
		MarketingEventUserService marketingEventUserService) {
		_marketingEventUserService = marketingEventUserService;
	}

	private MarketingEventUserService _marketingEventUserService;
}