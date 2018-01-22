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

import com.liferay.osb.www.marketing.events.exception.MarketingEventSponsorLevelNameException;
import com.liferay.osb.www.marketing.events.exception.RequiredMarketingEventSponsorLevelException;
import com.liferay.osb.www.marketing.events.model.MarketingEventSponsorLevel;
import com.liferay.osb.www.marketing.events.service.base.MarketingEventSponsorLevelLocalServiceBaseImpl;
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
 * @author Joan H. Kim
 */
public class MarketingEventSponsorLevelLocalServiceImpl
	extends MarketingEventSponsorLevelLocalServiceBaseImpl {

	public MarketingEventSponsorLevel addMarketingEventSponsorLevel(
			long userId, long marketingEventId, Map<Locale, String> nameMap,
			int priority, ServiceContext serviceContext)
		throws PortalException {

		User user = userPersistence.findByPrimaryKey(userId);
		Date now = new Date();

		validate(nameMap);

		long marketingEventSponsorLevelId = counterLocalService.increment();

		MarketingEventSponsorLevel marketingEventSponsorLevel =
			marketingEventSponsorLevelPersistence.create(
				marketingEventSponsorLevelId);

		marketingEventSponsorLevel.setUserId(user.getUserId());
		marketingEventSponsorLevel.setUserName(user.getFullName());
		marketingEventSponsorLevel.setCreateDate(
			serviceContext.getCreateDate(now));
		marketingEventSponsorLevel.setModifiedDate(
			serviceContext.getModifiedDate(now));
		marketingEventSponsorLevel.setMarketingEventId(marketingEventId);
		marketingEventSponsorLevel.setNameMap(nameMap);
		marketingEventSponsorLevel.setPriority(priority);

		marketingEventSponsorLevelPersistence.update(
			marketingEventSponsorLevel);

		return marketingEventSponsorLevel;
	}

	@Override
	public MarketingEventSponsorLevel deleteMarketingEventSponsorLevel(
			long marketingEventSponsorLevelId)
		throws PortalException {

		MarketingEventSponsorLevel marketingEventSponsorLevel =
			marketingEventSponsorLevelPersistence.findByPrimaryKey(
				marketingEventSponsorLevelId);

		return deleteMarketingEventSponsorLevel(marketingEventSponsorLevel);
	}

	@Override
	public MarketingEventSponsorLevel deleteMarketingEventSponsorLevel(
			MarketingEventSponsorLevel marketingEventSponsorLevel)
		throws PortalException {

		int count =
			marketingEventSponsorLocalService.getMarketingEventSponsorsCount(
				marketingEventSponsorLevel.getMarketingEventId(),
				marketingEventSponsorLevel.getMarketingEventSponsorLevelId());

		if (count > 0) {
			throw new RequiredMarketingEventSponsorLevelException();
		}

		return marketingEventSponsorLevel;
	}

	public List<MarketingEventSponsorLevel> getMarketingEventSponsorLevels(
		long marketingEventId, int start, int end, OrderByComparator obc) {

		return marketingEventSponsorLevelPersistence.findByMarketingEventId(
			marketingEventId, start, end, obc);
	}

	public int getMarketingEventSponsorLevelsCount(long marketingEventId) {
		return marketingEventSponsorLevelPersistence.countByMarketingEventId(
			marketingEventId);
	}

	public MarketingEventSponsorLevel updateMarketingEventSponsorLevel(
			long marketingEventSponsorLevelId, Map<Locale, String> nameMap,
			int priority, ServiceContext serviceContext)
		throws PortalException {

		Date now = new Date();

		validate(nameMap);

		MarketingEventSponsorLevel marketingEventSponsorLevel =
			marketingEventSponsorLevelPersistence.findByPrimaryKey(
				marketingEventSponsorLevelId);

		marketingEventSponsorLevel.setModifiedDate(
			serviceContext.getModifiedDate(now));
		marketingEventSponsorLevel.setNameMap(nameMap);
		marketingEventSponsorLevel.setPriority(priority);

		marketingEventSponsorLevelPersistence.update(
			marketingEventSponsorLevel);

		return marketingEventSponsorLevel;
	}

	protected void validate(Map<Locale, String> nameMap)
		throws PortalException {

		boolean emptyNameMap = true;

		for (String name : nameMap.values()) {
			if (Validator.isNotNull(name)) {
				emptyNameMap = false;

				break;
			}
		}

		if (emptyNameMap) {
			throw new MarketingEventSponsorLevelNameException();
		}
	}

}