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

package com.liferay.osb.www.marketing.events.service.impl;

import com.liferay.osb.www.marketing.events.model.MarketingEventSessionRoom;
import com.liferay.osb.www.marketing.events.service.base.MarketingEventSessionRoomServiceBaseImpl;
import com.liferay.osb.www.marketing.events.service.permission.OSBWWWMarketingEventPermissionUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.security.permission.ActionKeys;

import java.util.List;

/**
 * @author Ryan Schuhler
 * @author Joan H. Kim
 */
public class MarketingEventSessionRoomServiceImpl
	extends MarketingEventSessionRoomServiceBaseImpl {

	@AccessControlled(guestAccessEnabled = true)
	public MarketingEventSessionRoom fetchMarketingEventSessionRoom(
			long marketingEventSessionRoomId)
		throws PortalException {

		OSBWWWMarketingEventPermissionUtil.check(
			getPermissionChecker(), ActionKeys.VIEW);

		return marketingEventSessionRoomLocalService.
			fetchMarketingEventSessionRoom(marketingEventSessionRoomId);
	}

	@AccessControlled(guestAccessEnabled = true)
	public List<MarketingEventSessionRoom> getMarketingEventSessionRooms(
			long marketingEventId, int start, int end)
		throws PortalException {

		OSBWWWMarketingEventPermissionUtil.check(
			getPermissionChecker(), ActionKeys.VIEW);

		return
			marketingEventSessionRoomLocalService.getMarketingEventSessionRooms(
				marketingEventId, start, end, null);
	}

}