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

import com.liferay.osb.www.marketing.events.exception.MarketingEventSponsorNameException;
import com.liferay.osb.www.marketing.events.model.MarketingEventSponsor;
import com.liferay.osb.www.marketing.events.model.MarketingEventSponsorLevel;
import com.liferay.osb.www.marketing.events.service.base.MarketingEventSponsorLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @author Ryan Schuhler
 */
public class MarketingEventSponsorLocalServiceImpl
	extends MarketingEventSponsorLocalServiceBaseImpl {

	public MarketingEventSponsor addMarketingEventSponsor(
			long userId, long marketingEventId,
			long marketingEventSponsorLevelId, String name,
			Map<Locale, String> descriptionMap, long imageFileEntryId,
			String url, ServiceContext serviceContext)
		throws PortalException {

		User user = userPersistence.findByPrimaryKey(userId);
		MarketingEventSponsorLevel marketingEventSponsorLevel =
			marketingEventSponsorLevelLocalService.
				getMarketingEventSponsorLevel(marketingEventSponsorLevelId);
		Date now = new Date();

		validate(name);

		long marketingEventSponsorId = counterLocalService.increment();

		MarketingEventSponsor marketingEventSponsor =
			marketingEventSponsorPersistence.create(marketingEventSponsorId);

		marketingEventSponsor.setUserId(user.getUserId());
		marketingEventSponsor.setUserName(user.getFullName());
		marketingEventSponsor.setCreateDate(serviceContext.getCreateDate(now));
		marketingEventSponsor.setModifiedDate(
			serviceContext.getModifiedDate(now));
		marketingEventSponsor.setMarketingEventId(marketingEventId);
		marketingEventSponsor.setMarketingEventSponsorLevelId(
			marketingEventSponsorLevel.getMarketingEventSponsorLevelId());
		marketingEventSponsor.setName(name);
		marketingEventSponsor.setDescriptionMap(descriptionMap);
		marketingEventSponsor.setImageFileEntryId(imageFileEntryId);
		marketingEventSponsor.setUrl(url);

		marketingEventSponsorPersistence.update(marketingEventSponsor);

		return marketingEventSponsor;
	}

	public List<MarketingEventSponsor> getMarketingEventSponsors(
		long marketingEventId, int start, int end, OrderByComparator obc) {

		return marketingEventSponsorPersistence.findByMarketingEventId(
			marketingEventId, start, end, obc);
	}

	public List<MarketingEventSponsor> getMarketingEventSponsors(
		long marketingEventId, long marketingEventSponsorLevelId) {

		return marketingEventSponsorPersistence.findByMEI_MESLI(
			marketingEventId, marketingEventSponsorLevelId);
	}

	public int getMarketingEventSponsorsCount(long marketingEventId) {
		return marketingEventSponsorPersistence.countByMarketingEventId(
			marketingEventId);
	}

	public int getMarketingEventSponsorsCount(
		long marketingEventId, long marketingEventSponsorLevelId) {

		return marketingEventSponsorPersistence.countByMEI_MESLI(
			marketingEventId, marketingEventSponsorLevelId);
	}

	public MarketingEventSponsor updateMarketingEventSponsor(
			long marketingEventSponsorId, long marketingEventSponsorLevelId,
			String name, Map<Locale, String> descriptionMap,
			long imageFileEntryId, String url, ServiceContext serviceContext)
		throws PortalException {

		MarketingEventSponsor marketingEventSponsor =
			marketingEventSponsorPersistence.findByPrimaryKey(
				marketingEventSponsorId);
		MarketingEventSponsorLevel marketingEventSponsorLevel =
			marketingEventSponsorLevelLocalService.
				getMarketingEventSponsorLevel(marketingEventSponsorLevelId);
		Date now = new Date();

		validate(name);

		marketingEventSponsor.setModifiedDate(
			serviceContext.getModifiedDate(now));
		marketingEventSponsor.setMarketingEventSponsorLevelId(
			marketingEventSponsorLevel.getMarketingEventSponsorLevelId());
		marketingEventSponsor.setName(name);
		marketingEventSponsor.setDescriptionMap(descriptionMap);
		marketingEventSponsor.setImageFileEntryId(imageFileEntryId);
		marketingEventSponsor.setUrl(url);

		marketingEventSponsorPersistence.update(marketingEventSponsor);

		return marketingEventSponsor;
	}

	protected void validate(String name) throws PortalException {
		if (Validator.isNull(name)) {
			throw new MarketingEventSponsorNameException();
		}
	}

}