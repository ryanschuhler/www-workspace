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
 * Provides a wrapper for {@link MarketingEventSessionService}.
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEventSessionService
 * @generated
 */
@ProviderType
public class MarketingEventSessionServiceWrapper
	implements MarketingEventSessionService,
		ServiceWrapper<MarketingEventSessionService> {
	public MarketingEventSessionServiceWrapper(
		MarketingEventSessionService marketingEventSessionService) {
		_marketingEventSessionService = marketingEventSessionService;
	}

	@Override
	public java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventSession> getMarketingEventSessions(
		long marketingEventId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventSessionService.getMarketingEventSessions(marketingEventId,
			start, end);
	}

	@Override
	public java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventUser> getMarketingEventSessionUsers(
		long marketingEventSessionId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventSessionService.getMarketingEventSessionUsers(marketingEventSessionId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _marketingEventSessionService.getOSGiServiceIdentifier();
	}

	@Override
	public MarketingEventSessionService getWrappedService() {
		return _marketingEventSessionService;
	}

	@Override
	public void setWrappedService(
		MarketingEventSessionService marketingEventSessionService) {
		_marketingEventSessionService = marketingEventSessionService;
	}

	private MarketingEventSessionService _marketingEventSessionService;
}