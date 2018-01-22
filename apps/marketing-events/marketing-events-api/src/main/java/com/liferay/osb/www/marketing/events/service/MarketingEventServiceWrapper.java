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
 * Provides a wrapper for {@link MarketingEventService}.
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEventService
 * @generated
 */
@ProviderType
public class MarketingEventServiceWrapper implements MarketingEventService,
	ServiceWrapper<MarketingEventService> {
	public MarketingEventServiceWrapper(
		MarketingEventService marketingEventService) {
		_marketingEventService = marketingEventService;
	}

	@Override
	public java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEvent> getMarketingEvents(
		int type, java.util.Date startDate, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventService.getMarketingEvents(type, startDate,
			start, end);
	}

	@Override
	public java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEvent> getMarketingEvents(
		int type, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventService.getMarketingEvents(type, start, end);
	}

	@Override
	public java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEvent> getMarketingEvents(
		int[] types, int[] globalRegions, long[] countryIds,
		int[] locationTypes, boolean pastEvents,
		java.lang.String userLanguageId, java.lang.String orderByCol,
		java.lang.String orderByType)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventService.getMarketingEvents(types, globalRegions,
			countryIds, locationTypes, pastEvents, userLanguageId, orderByCol,
			orderByType);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _marketingEventService.getOSGiServiceIdentifier();
	}

	@Override
	public MarketingEventService getWrappedService() {
		return _marketingEventService;
	}

	@Override
	public void setWrappedService(MarketingEventService marketingEventService) {
		_marketingEventService = marketingEventService;
	}

	private MarketingEventService _marketingEventService;
}