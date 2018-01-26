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

import com.liferay.osb.www.marketing.events.model.MarketingEventAnnouncement;
import com.liferay.osb.www.marketing.events.service.base.MarketingEventAnnouncementServiceBaseImpl;
import com.liferay.osb.www.marketing.events.service.permission.OSBWWWMarketingEventPermissionUtil;
import com.liferay.osb.www.marketing.events.util.comparator.MarketingEventAnnouncementDisplayDateComparator;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.util.Date;
import java.util.List;

/**
 * @author Ryan Schuhler
 */
public class MarketingEventAnnouncementServiceImpl
	extends MarketingEventAnnouncementServiceBaseImpl {

	@AccessControlled(guestAccessEnabled = true)
	public List<MarketingEventAnnouncement> getMarketingEventAnnouncements(
			long marketingEventId, boolean asc, int start, int end)
		throws PortalException {

		OSBWWWMarketingEventPermissionUtil.check(
			getPermissionChecker(), ActionKeys.VIEW);

		return marketingEventAnnouncementLocalService.
			getMarketingEventAnnouncements(
				marketingEventId, start, end,
				new MarketingEventAnnouncementDisplayDateComparator(asc));
	}

	@AccessControlled(guestAccessEnabled = true)
	public List<MarketingEventAnnouncement> getMarketingEventAnnouncements(
			long marketingEventId, int start, int end)
		throws PortalException {

		OSBWWWMarketingEventPermissionUtil.check(
			getPermissionChecker(), ActionKeys.VIEW);

		return marketingEventAnnouncementLocalService.
			getMarketingEventAnnouncements(
				marketingEventId, new Date(), WorkflowConstants.STATUS_APPROVED,
				start, end,
				new MarketingEventAnnouncementDisplayDateComparator(false));
	}

}