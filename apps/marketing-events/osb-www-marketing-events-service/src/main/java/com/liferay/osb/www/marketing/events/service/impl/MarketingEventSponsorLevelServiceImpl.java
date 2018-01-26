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

import com.liferay.osb.www.marketing.events.model.MarketingEventSponsorLevel;
import com.liferay.osb.www.marketing.events.service.base.MarketingEventSponsorLevelServiceBaseImpl;
import com.liferay.osb.www.marketing.events.service.permission.OSBWWWMarketingEventPermissionUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.security.permission.ActionKeys;

import java.util.List;

/**
 * @author Ryan Schuhler
 * @author Joan H. Kim
 */
public class MarketingEventSponsorLevelServiceImpl
	extends MarketingEventSponsorLevelServiceBaseImpl {

	@AccessControlled(guestAccessEnabled = true)
	public List<MarketingEventSponsorLevel> getMarketingEventSponsorLevels(
			long marketingEventId, int start, int end)
		throws PortalException {

		OSBWWWMarketingEventPermissionUtil.check(
			getPermissionChecker(), ActionKeys.VIEW);

		return marketingEventSponsorLevelLocalService.
			getMarketingEventSponsorLevels(marketingEventId, start, end, null);
	}

}