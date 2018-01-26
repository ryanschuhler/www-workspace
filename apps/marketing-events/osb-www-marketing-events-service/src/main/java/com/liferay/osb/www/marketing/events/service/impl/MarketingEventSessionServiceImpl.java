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

import com.liferay.osb.www.marketing.events.model.MarketingEventSession;
import com.liferay.osb.www.marketing.events.model.MarketingEventUser;
import com.liferay.osb.www.marketing.events.service.base.MarketingEventSessionServiceBaseImpl;
import com.liferay.osb.www.marketing.events.service.permission.OSBWWWMarketingEventPermissionUtil;
import com.liferay.osb.www.marketing.events.util.comparator.MarketingEventSessionStartDateComparator;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.util.List;

/**
 * @author Ryan Schuhler
 * @author Joan H. Kim
 */
public class MarketingEventSessionServiceImpl
	extends MarketingEventSessionServiceBaseImpl {

	@AccessControlled(guestAccessEnabled = true)
	public List<MarketingEventSession> getMarketingEventSessions(
			long marketingEventId, int start, int end)
		throws PortalException {

		OSBWWWMarketingEventPermissionUtil.check(
			getPermissionChecker(), ActionKeys.VIEW);

		return marketingEventSessionLocalService.getMarketingEventSessions(
			marketingEventId, WorkflowConstants.STATUS_APPROVED, start, end,
			new MarketingEventSessionStartDateComparator());
	}

	@AccessControlled(guestAccessEnabled = true)
	public List<MarketingEventUser> getMarketingEventSessionUsers(
			long marketingEventSessionId)
		throws PortalException {

		OSBWWWMarketingEventPermissionUtil.check(
			getPermissionChecker(), ActionKeys.VIEW);

		return marketingEventSessionLocalService.getMarketingEventSessionUsers(
			marketingEventSessionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

}