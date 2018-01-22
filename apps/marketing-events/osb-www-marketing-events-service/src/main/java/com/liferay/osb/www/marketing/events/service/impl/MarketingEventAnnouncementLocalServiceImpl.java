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

import com.liferay.osb.www.marketing.events.exception.MarketingEventAnnouncementDisplayDateException;
import com.liferay.osb.www.marketing.events.exception.MarketingEventAnnouncementLinkLabelException;
import com.liferay.osb.www.marketing.events.exception.MarketingEventAnnouncementLinkURLException;
import com.liferay.osb.www.marketing.events.exception.MarketingEventAnnouncementMessageException;
import com.liferay.osb.www.marketing.events.exception.MarketingEventAnnouncementTitleException;
import com.liferay.osb.www.marketing.events.model.MarketingEvent;
import com.liferay.osb.www.marketing.events.model.MarketingEventAnnouncement;
import com.liferay.osb.www.marketing.events.service.base.MarketingEventAnnouncementLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.TimeZoneUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * @author Ryan Schuhler
 */
public class MarketingEventAnnouncementLocalServiceImpl
	extends MarketingEventAnnouncementLocalServiceBaseImpl {

	public MarketingEventAnnouncement addMarketingEventAnnouncement(
			long userId, long marketingEventId, String title, String message,
			String summary, long imageFileEntryId, String linkURL,
			String linkLabel, int displayDateMonth, int displayDateDay,
			int displayDateYear, int displayDateHour, int displayDateMinute,
			int status, ServiceContext serviceContext)
		throws PortalException {

		User user = userPersistence.findByPrimaryKey(userId);

		MarketingEvent marketingEvent =
			marketingEventPersistence.findByPrimaryKey(marketingEventId);

		TimeZone timeZone = TimeZoneUtil.getTimeZone(
			marketingEvent.getTimeZoneId());

		Date displayDate = PortalUtil.getDate(
			displayDateMonth, displayDateDay, displayDateYear, displayDateHour,
			displayDateMinute, timeZone,
			MarketingEventAnnouncementDisplayDateException.class);

		validate(title, message, linkURL, linkLabel);

		long marketingEventAnnouncementId = counterLocalService.increment();

		MarketingEventAnnouncement marketingEventAnnouncement =
			marketingEventAnnouncementPersistence.create(
				marketingEventAnnouncementId);

		marketingEventAnnouncement.setUserId(user.getUserId());
		marketingEventAnnouncement.setUserName(user.getFullName());
		marketingEventAnnouncement.setCreateDate(
			serviceContext.getCreateDate(new Date()));
		marketingEventAnnouncement.setModifiedDate(
			serviceContext.getModifiedDate(new Date()));
		marketingEventAnnouncement.setMarketingEventId(marketingEventId);
		marketingEventAnnouncement.setTitle(title);
		marketingEventAnnouncement.setMessage(message);
		marketingEventAnnouncement.setSummary(summary);
		marketingEventAnnouncement.setImageFileEntryId(imageFileEntryId);
		marketingEventAnnouncement.setLinkURL(linkURL);
		marketingEventAnnouncement.setLinkLabel(linkLabel);
		marketingEventAnnouncement.setDisplayDate(displayDate);
		marketingEventAnnouncement.setStatus(status);
		marketingEventAnnouncement.setStatusByUserId(user.getUserId());
		marketingEventAnnouncement.setStatusByUserName(user.getFullName());
		marketingEventAnnouncement.setStatusDate(
			serviceContext.getModifiedDate(new Date()));

		marketingEventAnnouncementPersistence.update(
			marketingEventAnnouncement);

		return marketingEventAnnouncement;
	}

	public List<MarketingEventAnnouncement> getMarketingEventAnnouncements(
		long marketingEventId, Date displayDate, int status, int start, int end,
		OrderByComparator obc) {

		return marketingEventAnnouncementPersistence.findByMEI_LtDD_S(
			marketingEventId, displayDate, status, start, end, obc);
	}

	public List<MarketingEventAnnouncement> getMarketingEventAnnouncements(
		long marketingEventId, int start, int end, OrderByComparator obc) {

		return marketingEventAnnouncementPersistence.findByMarketingEventId(
			marketingEventId, start, end, obc);
	}

	public int getMarketingEventAnnouncementsCount(long marketingEventId) {
		return marketingEventAnnouncementPersistence.countByMarketingEventId(
			marketingEventId);
	}

	public MarketingEventAnnouncement updateMarketingEventAnnouncement(
			long marketingEventAnnouncementId, String title, String message,
			String summary, long imageFileEntryId, String linkURL,
			String linkLabel, int displayDateMonth, int displayDateDay,
			int displayDateYear, int displayDateHour, int displayDateMinute,
			int status, ServiceContext serviceContext)
		throws PortalException {

		User user = userPersistence.findByPrimaryKey(
			serviceContext.getUserId());

		MarketingEventAnnouncement marketingEventAnnouncement =
			marketingEventAnnouncementPersistence.findByPrimaryKey(
				marketingEventAnnouncementId);

		MarketingEvent marketingEvent =
			marketingEventPersistence.findByPrimaryKey(
				marketingEventAnnouncement.getMarketingEventId());

		TimeZone timeZone = TimeZoneUtil.getTimeZone(
			marketingEvent.getTimeZoneId());

		Date displayDate = PortalUtil.getDate(
			displayDateMonth, displayDateDay, displayDateYear, displayDateHour,
			displayDateMinute, timeZone,
			MarketingEventAnnouncementDisplayDateException.class);

		validate(title, message, linkURL, linkLabel);

		marketingEventAnnouncement.setModifiedDate(
			serviceContext.getModifiedDate(new Date()));
		marketingEventAnnouncement.setTitle(title);
		marketingEventAnnouncement.setMessage(message);
		marketingEventAnnouncement.setSummary(summary);
		marketingEventAnnouncement.setImageFileEntryId(imageFileEntryId);
		marketingEventAnnouncement.setLinkURL(linkURL);
		marketingEventAnnouncement.setLinkLabel(linkLabel);
		marketingEventAnnouncement.setDisplayDate(displayDate);
		marketingEventAnnouncement.setStatus(status);
		marketingEventAnnouncement.setStatusByUserId(user.getUserId());
		marketingEventAnnouncement.setStatusByUserName(user.getFullName());
		marketingEventAnnouncement.setStatusDate(
			serviceContext.getModifiedDate(new Date()));

		marketingEventAnnouncementPersistence.update(
			marketingEventAnnouncement);

		return marketingEventAnnouncement;
	}

	public MarketingEventAnnouncement updateStatus(
			long userId, long marketingEventAnnouncementId, int status,
			ServiceContext serviceContext)
		throws PortalException {

		User user = userPersistence.findByPrimaryKey(userId);
		Date now = new Date();

		MarketingEventAnnouncement marketingEventAnnouncement =
			marketingEventAnnouncementPersistence.findByPrimaryKey(
				marketingEventAnnouncementId);

		marketingEventAnnouncement.setModifiedDate(
			serviceContext.getModifiedDate(now));
		marketingEventAnnouncement.setStatus(status);
		marketingEventAnnouncement.setStatusByUserId(user.getUserId());
		marketingEventAnnouncement.setStatusByUserName(user.getFullName());
		marketingEventAnnouncement.setStatusDate(
			serviceContext.getModifiedDate(now));

		marketingEventAnnouncementPersistence.update(
			marketingEventAnnouncement);

		return marketingEventAnnouncement;
	}

	protected void validate(
			String title, String message, String linkURL, String linkLabel)
		throws PortalException {

		if (Validator.isNull(title)) {
			throw new MarketingEventAnnouncementTitleException();
		}

		if (Validator.isNull(message)) {
			throw new MarketingEventAnnouncementMessageException();
		}

		if (Validator.isNull(linkURL)) {
			return;
		}

		if (!Validator.isUrl(linkURL) &&
			!StringUtil.startsWith(linkURL, "/eventId")) {

			throw new MarketingEventAnnouncementLinkURLException();
		}

		if (Validator.isNull(linkLabel)) {
			throw new MarketingEventAnnouncementLinkLabelException();
		}
	}

}