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

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetLinkConstants;
import com.liferay.osb.www.marketing.events.exception.MarketingEventSessionEndDateException;
import com.liferay.osb.www.marketing.events.exception.MarketingEventSessionStartDateException;
import com.liferay.osb.www.marketing.events.exception.MarketingEventSessionTitleException;
import com.liferay.osb.www.marketing.events.exception.MarketingEventSessionVideoURLException;
import com.liferay.osb.www.marketing.events.model.MarketingEvent;
import com.liferay.osb.www.marketing.events.model.MarketingEventSession;
import com.liferay.osb.www.marketing.events.model.MarketingEventUser;
import com.liferay.osb.www.marketing.events.service.base.MarketingEventSessionLocalServiceBaseImpl;
import com.liferay.osb.www.marketing.events.util.comparator.MarketingEventSessionStartDateComparator;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistry;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.TimeZoneUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/**
 * @author Joan H. Kim
 * @author Ryan Schuhler
 * @author Rebecca Dai
 * @author Allen Ziegenfus
 */
public class MarketingEventSessionLocalServiceImpl
	extends MarketingEventSessionLocalServiceBaseImpl {

	public MarketingEventSession addMarketingEventSession(
			long userId, long marketingEventId,
			long marketingEventSessionRoomId, Map<Locale, String> titleMap,
			Map<Locale, String> descriptionMap, Map<Locale, String> keywordsMap,
			long slidesFileEntryId, String videoURL, int startDateMonth,
			int startDateDay, int startDateYear, int startDateHour,
			int startDateMinute, int endDateMonth, int endDateDay,
			int endDateYear, int endDateHour, int endDateMinute, int status,
			long[] marketingEventUserIds, ServiceContext serviceContext)
		throws PortalException {

		User user = userPersistence.findByPrimaryKey(userId);
		Date now = new Date();

		validate(titleMap, videoURL);

		long marketingEventSessionId = counterLocalService.increment();

		MarketingEventSession marketingEventSession =
			marketingEventSessionPersistence.create(marketingEventSessionId);

		marketingEventSession.setUserId(user.getUserId());
		marketingEventSession.setUserName(user.getFullName());
		marketingEventSession.setCreateDate(serviceContext.getCreateDate(now));
		marketingEventSession.setModifiedDate(
			serviceContext.getModifiedDate(now));
		marketingEventSession.setMarketingEventId(marketingEventId);
		marketingEventSession.setMarketingEventSessionRoomId(
			marketingEventSessionRoomId);
		marketingEventSession.setTitleMap(titleMap);
		marketingEventSession.setDescriptionMap(descriptionMap);
		marketingEventSession.setKeywordsMap(keywordsMap);
		marketingEventSession.setSlidesFileEntryId(slidesFileEntryId);
		marketingEventSession.setVideoURL(videoURL);

		MarketingEvent marketingEvent =
			marketingEventPersistence.findByPrimaryKey(marketingEventId);

		TimeZone timeZone = TimeZoneUtil.getTimeZone(
			marketingEvent.getTimeZoneId());

		Date startDate = PortalUtil.getDate(
			startDateMonth, startDateDay, startDateYear, startDateHour,
			startDateMinute, timeZone,
			MarketingEventSessionStartDateException.class);

		marketingEventSession.setStartDate(startDate);

		Date endDate = PortalUtil.getDate(
			endDateMonth, endDateDay, endDateYear, endDateHour, endDateMinute,
			timeZone, MarketingEventSessionEndDateException.class);

		marketingEventSession.setEndDate(endDate);

		marketingEventSession.setStatus(status);
		marketingEventSession.setStatusByUserId(user.getUserId());
		marketingEventSession.setStatusByUserName(user.getFullName());
		marketingEventSession.setStatusDate(
			serviceContext.getModifiedDate(now));

		marketingEventSessionPersistence.update(marketingEventSession);

		marketingEventSessionPersistence.setMarketingEventUsers(
			marketingEventSessionId, marketingEventUserIds);

		updateAsset(
			user.getUserId(), serviceContext.getScopeGroupId(),
			marketingEventSession, serviceContext.getAssetCategoryIds(),
			serviceContext.getAssetTagNames(),
			serviceContext.getAssetLinkEntryIds());

		return marketingEventSession;
	}

	@Override
	public MarketingEventSession deleteMarketingEventSession(
			long marketingEventSessionId)
		throws PortalException {

		MarketingEventSession marketingEventSession = getMarketingEventSession(
			marketingEventSessionId);

		return deleteMarketingEventSession(marketingEventSession);
	}

	@Override
	public MarketingEventSession deleteMarketingEventSession(
			MarketingEventSession marketingEventSession)
		throws PortalException {

		// Marketing event session

		marketingEventSessionPersistence.remove(marketingEventSession);

		// Asset categories

		assetEntryLocalService.deleteEntry(
			MarketingEventSession.class.getName(),
			marketingEventSession.getMarketingEventSessionId());

		// Indexer

		Indexer<MarketingEventSession> indexer =
			getMarketingEventSessionIndexer();

		indexer.delete(marketingEventSession);

		return marketingEventSession;
	}

	public List<MarketingEventSession> getMarketingEventSessions(
		long marketingEventId, int status, int start, int end,
		OrderByComparator obc) {

		return marketingEventSessionPersistence.findByMEI_S(
			marketingEventId, status, start, end, obc);
	}

	public List<MarketingEventSession> getMarketingEventSessions(
		long marketingEventId, int start, int end, OrderByComparator obc) {

		return marketingEventSessionPersistence.findByMarketingEventId(
			marketingEventId, start, end, obc);
	}

	public List<MarketingEventSession> getMarketingEventSessions(
			long[] categoryIds, int[] statuses, int start, int end,
			OrderByComparator obc)
		throws PortalException {

		return marketingEventSessionFinder.findByCI_S(
			categoryIds, statuses, start, end, obc);
	}

	public int getMarketingEventSessionsCount(long marketingEventId) {
		return marketingEventSessionPersistence.countByMarketingEventId(
			marketingEventId);
	}

	public int getMarketingEventSessionsCount(
		long marketingEventId, long marketingEventSessionRoomId) {

		return marketingEventSessionPersistence.countByMEI_MESRI(
			marketingEventId, marketingEventSessionRoomId);
	}

	public Map<Date, List<MarketingEventSession>> getMarketingEventSessionsMap(
			long marketingEventId, boolean asc)
		throws PortalException {

		Map<Date, List<MarketingEventSession>> marketingEventSessionsMap =
			new LinkedHashMap<>();

		MarketingEvent marketingEvent =
			marketingEventPersistence.findByPrimaryKey(marketingEventId);

		Calendar startDate = CalendarFactoryUtil.getCalendar(
			TimeZoneUtil.getTimeZone(marketingEvent.getTimeZoneId()));

		List<MarketingEventSession> marketingEventSessions =
			marketingEventSessionPersistence.findByMEI_S(
				marketingEventId, WorkflowConstants.STATUS_APPROVED,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				new MarketingEventSessionStartDateComparator(asc));

		for (MarketingEventSession marketingEventSession :
				marketingEventSessions) {

			startDate.setTime(marketingEventSession.getStartDate());

			startDate.set(Calendar.HOUR_OF_DAY, 0);
			startDate.set(Calendar.MINUTE, 0);
			startDate.set(Calendar.SECOND, 0);
			startDate.set(Calendar.MILLISECOND, 0);

			List<MarketingEventSession> marketingEventSessionsList = null;

			if (marketingEventSessionsMap.containsKey(startDate.getTime())) {
				marketingEventSessionsList = marketingEventSessionsMap.get(
					startDate.getTime());
			}
			else {
				marketingEventSessionsList = new ArrayList<>();
			}

			marketingEventSessionsList.add(marketingEventSession);

			marketingEventSessionsMap.put(
				startDate.getTime(), marketingEventSessionsList);
		}

		return marketingEventSessionsMap;
	}
	
	public List<Map.Entry<Date, List<MarketingEventSession>>> getMarketingEventSessionEntries(
			long marketingEventId, boolean asc) 
		throws PortalException {

		List<Map.Entry<Date, List<MarketingEventSession>>> marketingEventSessions = new ArrayList<>();
		
		 Map<Date, List<MarketingEventSession>> marketingEventSessionsMap = 
			getMarketingEventSessionsMap(marketingEventId, asc);
		 
		 marketingEventSessions.addAll(marketingEventSessionsMap.entrySet());
		 
		return marketingEventSessions;
	}


	public List<MarketingEventUser> getMarketingEventSessionUsers(
		long marketingEventSessionId, int start, int end,
		OrderByComparator obc) {

		return marketingEventSessionPersistence.getMarketingEventUsers(
			marketingEventSessionId, start, end, obc);
	}
	
	@Override
	public void updateAsset(
			long userId, long groupId,
			MarketingEventSession marketingEventSession,
			long[] assetCategoryIds, String[] assetTagNames,
			long[] assetLinkEntryIds)
		throws PortalException, SearchException, SystemException {

		AssetEntry assetEntry = assetEntryLocalService.updateEntry(
			userId, groupId, marketingEventSession.getCreateDate(),
			marketingEventSession.getModifiedDate(),
			MarketingEventSession.class.getName(),
			marketingEventSession.getMarketingEventSessionId(),
			marketingEventSession.getUuid(), 0, assetCategoryIds, assetTagNames,
			marketingEventSession.isApproved(), null, null, null,
			ContentTypes.TEXT, marketingEventSession.getTitle(),
			marketingEventSession.getDescription(), null, null, null, 0, 0,
			null, false);

		assetLinkLocalService.updateLinks(
			userId, assetEntry.getEntryId(), assetLinkEntryIds,
			AssetLinkConstants.TYPE_CHILD);

		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(
			MarketingEventSession.class);

		indexer.reindex(marketingEventSession);
	}

	public MarketingEventSession updateMarketingEventSession(
			long marketingEventSessionId, long marketingEventSessionRoomId,
			Map<Locale, String> titleMap, Map<Locale, String> descriptionMap,
			Map<Locale, String> keywordsMap, long slidesFileEntryId,
			String videoURL, int startDateMonth, int startDateDay,
			int startDateYear, int startDateHour, int startDateMinute,
			int endDateMonth, int endDateDay, int endDateYear, int endDateHour,
			int endDateMinute, int status, long[] marketingEventUserIds,
			ServiceContext serviceContext)
		throws PortalException {

		User user = userPersistence.findByPrimaryKey(
			serviceContext.getUserId());
		Date now = new Date();

		validate(titleMap, videoURL);

		MarketingEventSession marketingEventSession =
			marketingEventSessionPersistence.findByPrimaryKey(
				marketingEventSessionId);

		marketingEventSession.setModifiedDate(
			serviceContext.getModifiedDate(now));
		marketingEventSession.setMarketingEventSessionRoomId(
			marketingEventSessionRoomId);
		marketingEventSession.setTitleMap(titleMap);
		marketingEventSession.setDescriptionMap(descriptionMap);
		marketingEventSession.setKeywordsMap(keywordsMap);
		marketingEventSession.setSlidesFileEntryId(slidesFileEntryId);
		marketingEventSession.setVideoURL(videoURL);

		MarketingEvent marketingEvent =
			marketingEventPersistence.findByPrimaryKey(
				marketingEventSession.getMarketingEventId());

		TimeZone timeZone = TimeZoneUtil.getTimeZone(
			marketingEvent.getTimeZoneId());

		Date startDate = PortalUtil.getDate(
			startDateMonth, startDateDay, startDateYear, startDateHour,
			startDateMinute, timeZone,
			MarketingEventSessionStartDateException.class);

		marketingEventSession.setStartDate(startDate);

		Date endDate = PortalUtil.getDate(
			endDateMonth, endDateDay, endDateYear, endDateHour, endDateMinute,
			timeZone, MarketingEventSessionEndDateException.class);

		marketingEventSession.setEndDate(endDate);

		marketingEventSession.setStatus(status);
		marketingEventSession.setStatusByUserId(user.getUserId());
		marketingEventSession.setStatusByUserName(user.getFullName());
		marketingEventSession.setStatusDate(
			serviceContext.getModifiedDate(now));

		marketingEventSessionPersistence.update(marketingEventSession);

		marketingEventSessionPersistence.setMarketingEventUsers(
			marketingEventSessionId, marketingEventUserIds);

		updateAsset(
				user.getUserId(), serviceContext.getScopeGroupId(),
				marketingEventSession, serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(),
				serviceContext.getAssetLinkEntryIds());

		return marketingEventSession;
	}

	protected Indexer<MarketingEventSession> getMarketingEventSessionIndexer() {
		Indexer<MarketingEventSession> indexer =
			indexerRegistry.nullSafeGetIndexer(MarketingEventSession.class);

		return indexer;
	}

	protected void validate(Map<Locale, String> titleMap, String videoURL)
		throws PortalException {

		boolean emptyTitleMap = true;

		for (String title : titleMap.values()) {
			if (Validator.isNotNull(title)) {
				emptyTitleMap = false;

				break;
			}
		}

		if (emptyTitleMap) {
			throw new MarketingEventSessionTitleException();
		}

		if (Validator.isNotNull(videoURL) && !Validator.isUrl(videoURL)) {
			throw new MarketingEventSessionVideoURLException();
		}
	}

	@ServiceReference(type = IndexerRegistry.class)
	protected IndexerRegistry indexerRegistry;

}