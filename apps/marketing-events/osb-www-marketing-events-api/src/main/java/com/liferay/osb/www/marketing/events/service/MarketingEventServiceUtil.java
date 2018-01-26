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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for MarketingEvent. This utility wraps
 * {@link com.liferay.osb.www.marketing.events.service.impl.MarketingEventServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEventService
 * @see com.liferay.osb.www.marketing.events.service.base.MarketingEventServiceBaseImpl
 * @see com.liferay.osb.www.marketing.events.service.impl.MarketingEventServiceImpl
 * @generated
 */
@ProviderType
public class MarketingEventServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.osb.www.marketing.events.service.impl.MarketingEventServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEvent> getMarketingEvents(
		int type, java.util.Date startDate, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getMarketingEvents(type, startDate, start, end);
	}

	public static java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEvent> getMarketingEvents(
		int type, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getMarketingEvents(type, start, end);
	}

	public static java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEvent> getMarketingEvents(
		int[] types, int[] globalRegions, long[] countryIds,
		int[] locationTypes, boolean pastEvents,
		java.lang.String userLanguageId, java.lang.String orderByCol,
		java.lang.String orderByType)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .getMarketingEvents(types, globalRegions, countryIds,
			locationTypes, pastEvents, userLanguageId, orderByCol, orderByType);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static MarketingEventService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<MarketingEventService, MarketingEventService> _serviceTracker =
		ServiceTrackerFactory.open(MarketingEventService.class);
}