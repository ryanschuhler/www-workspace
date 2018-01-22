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
 * Provides a wrapper for {@link MarketingEventSessionRoomService}.
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEventSessionRoomService
 * @generated
 */
@ProviderType
public class MarketingEventSessionRoomServiceWrapper
	implements MarketingEventSessionRoomService,
		ServiceWrapper<MarketingEventSessionRoomService> {
	public MarketingEventSessionRoomServiceWrapper(
		MarketingEventSessionRoomService marketingEventSessionRoomService) {
		_marketingEventSessionRoomService = marketingEventSessionRoomService;
	}

	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventSessionRoom fetchMarketingEventSessionRoom(
		long marketingEventSessionRoomId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventSessionRoomService.fetchMarketingEventSessionRoom(marketingEventSessionRoomId);
	}

	@Override
	public java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventSessionRoom> getMarketingEventSessionRooms(
		long marketingEventId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventSessionRoomService.getMarketingEventSessionRooms(marketingEventId,
			start, end);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _marketingEventSessionRoomService.getOSGiServiceIdentifier();
	}

	@Override
	public MarketingEventSessionRoomService getWrappedService() {
		return _marketingEventSessionRoomService;
	}

	@Override
	public void setWrappedService(
		MarketingEventSessionRoomService marketingEventSessionRoomService) {
		_marketingEventSessionRoomService = marketingEventSessionRoomService;
	}

	private MarketingEventSessionRoomService _marketingEventSessionRoomService;
}