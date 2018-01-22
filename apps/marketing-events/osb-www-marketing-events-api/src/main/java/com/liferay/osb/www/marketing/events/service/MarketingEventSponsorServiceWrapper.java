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
 * Provides a wrapper for {@link MarketingEventSponsorService}.
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEventSponsorService
 * @generated
 */
@ProviderType
public class MarketingEventSponsorServiceWrapper
	implements MarketingEventSponsorService,
		ServiceWrapper<MarketingEventSponsorService> {
	public MarketingEventSponsorServiceWrapper(
		MarketingEventSponsorService marketingEventSponsorService) {
		_marketingEventSponsorService = marketingEventSponsorService;
	}

	@Override
	public java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventSponsor> getMarketingEventSponsors(
		long marketingEventId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventSponsorService.getMarketingEventSponsors(marketingEventId,
			start, end);
	}

	@Override
	public java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventSponsor> getMarketingEventSponsors(
		long marketingEventId, long marketingEventSponsorLevelId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventSponsorService.getMarketingEventSponsors(marketingEventId,
			marketingEventSponsorLevelId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _marketingEventSponsorService.getOSGiServiceIdentifier();
	}

	@Override
	public MarketingEventSponsorService getWrappedService() {
		return _marketingEventSponsorService;
	}

	@Override
	public void setWrappedService(
		MarketingEventSponsorService marketingEventSponsorService) {
		_marketingEventSponsorService = marketingEventSponsorService;
	}

	private MarketingEventSponsorService _marketingEventSponsorService;
}