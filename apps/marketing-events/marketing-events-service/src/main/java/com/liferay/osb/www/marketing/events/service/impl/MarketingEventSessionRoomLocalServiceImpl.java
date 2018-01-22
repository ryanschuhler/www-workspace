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

import com.liferay.osb.www.marketing.events.exception.MarketingEventSessionRoomNameException;
import com.liferay.osb.www.marketing.events.exception.RequiredMarketingEventSessionRoomException;
import com.liferay.osb.www.marketing.events.model.MarketingEventSessionRoom;
import com.liferay.osb.www.marketing.events.service.base.MarketingEventSessionRoomLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;
import java.util.List;

/**
 * @author Joan H. Kim
 */
public class MarketingEventSessionRoomLocalServiceImpl
	extends MarketingEventSessionRoomLocalServiceBaseImpl {

	public MarketingEventSessionRoom addMarketingEventSessionRoom(
			long marketingEventId, String name, long imageFileEntryId,
			ServiceContext serviceContext)
		throws PortalException {

		Date now = new Date();

		validate(name);

		long marketingEventSessionRoomId = counterLocalService.increment();

		MarketingEventSessionRoom marketingEventSessionRoom =
			marketingEventSessionRoomPersistence.create(
				marketingEventSessionRoomId);

		marketingEventSessionRoom.setCreateDate(
			serviceContext.getCreateDate(now));
		marketingEventSessionRoom.setModifiedDate(
			serviceContext.getModifiedDate(now));
		marketingEventSessionRoom.setMarketingEventId(marketingEventId);
		marketingEventSessionRoom.setName(name);
		marketingEventSessionRoom.setImageFileEntryId(imageFileEntryId);

		marketingEventSessionRoomPersistence.update(marketingEventSessionRoom);

		return marketingEventSessionRoom;
	}

	@Override
	public MarketingEventSessionRoom deleteMarketingEventSessionRoom(
			long marketingEventSessionRoomId)
		throws PortalException {

		MarketingEventSessionRoom marketingEventSessionRoom =
			marketingEventSessionRoomPersistence.findByPrimaryKey(
				marketingEventSessionRoomId);

		return deleteMarketingEventSessionRoom(marketingEventSessionRoom);
	}

	@Override
	public MarketingEventSessionRoom deleteMarketingEventSessionRoom(
			MarketingEventSessionRoom marketingEventSessionRoom)
		throws PortalException {

		int count =
			marketingEventSessionLocalService.getMarketingEventSessionsCount(
				marketingEventSessionRoom.getMarketingEventId(),
				marketingEventSessionRoom.getMarketingEventSessionRoomId());

		if (count > 0) {
			throw new RequiredMarketingEventSessionRoomException();
		}

		marketingEventSessionRoomPersistence.remove(marketingEventSessionRoom);

		return marketingEventSessionRoom;
	}

	public List<MarketingEventSessionRoom> getMarketingEventSessionRooms(
		long marketingEventId, int start, int end, OrderByComparator obc) {

		return marketingEventSessionRoomPersistence.findByMarketingEventId(
			marketingEventId, start, end, obc);
	}

	public int getMarketingEventSessionRoomsCount(long marketingEventId) {
		return marketingEventSessionRoomPersistence.countByMarketingEventId(
			marketingEventId);
	}

	public MarketingEventSessionRoom updateMarketingEventSessionRoom(
			long marketingEventSessionRoomId, String name,
			long imageFileEntryId, ServiceContext serviceContext)
		throws PortalException {

		Date now = new Date();

		validate(name);

		MarketingEventSessionRoom marketingEventSessionRoom =
			marketingEventSessionRoomPersistence.findByPrimaryKey(
				marketingEventSessionRoomId);

		marketingEventSessionRoom.setModifiedDate(
			serviceContext.getModifiedDate(now));
		marketingEventSessionRoom.setName(name);
		marketingEventSessionRoom.setImageFileEntryId(imageFileEntryId);

		marketingEventSessionRoomPersistence.update(marketingEventSessionRoom);

		return marketingEventSessionRoom;
	}

	protected void validate(String name) throws PortalException {
		if (Validator.isNull(name)) {
			throw new MarketingEventSessionRoomNameException();
		}
	}

}