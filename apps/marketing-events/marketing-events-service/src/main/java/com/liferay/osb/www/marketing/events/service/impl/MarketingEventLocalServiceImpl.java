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

import com.liferay.osb.www.marketing.events.exception.DuplicateSiteGroupException;
import com.liferay.osb.www.marketing.events.exception.MarketingEventEndDateException;
import com.liferay.osb.www.marketing.events.exception.MarketingEventHostedByException;
import com.liferay.osb.www.marketing.events.exception.MarketingEventHostedByURLException;
import com.liferay.osb.www.marketing.events.exception.MarketingEventRegistrationURLException;
import com.liferay.osb.www.marketing.events.exception.MarketingEventStartDateException;
import com.liferay.osb.www.marketing.events.exception.MarketingEventTitleException;
import com.liferay.osb.www.marketing.events.exception.MarketingEventTitleURLException;
import com.liferay.osb.www.marketing.events.exception.MarketingEventVideoTitleException;
import com.liferay.osb.www.marketing.events.model.MarketingEvent;
import com.liferay.osb.www.marketing.events.model.MarketingEventConstants;
import com.liferay.osb.www.marketing.events.service.base.MarketingEventLocalServiceBaseImpl;
import com.liferay.osb.www.marketing.events.util.comparator.MarketingEventStartDateComparator;
import com.liferay.osb.www.marketing.events.util.comparator.MarketingEventTypeComparator;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistry;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.QueryConfig;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.TextFormatter;
import com.liferay.portal.kernel.util.TimeZoneUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/**
 * @author Rachael Koestartyo
 * @author Ryan Schuhler
 */
public class MarketingEventLocalServiceImpl
	extends MarketingEventLocalServiceBaseImpl {

	public MarketingEvent addMarketingEvent(
			long userId, int type, String defaultLanguageId,
			Map<Locale, String> titleMap, String titleURL, String hostedBy,
			String hostedByURL, Map<Locale, String> summaryMap,
			long siteGroupId, long imageFileEntryId, long slidesFileEntryId,
			String videoTitle, String timeZoneId, int startDateMonth,
			int startDateDay, int startDateYear, int startDateHour,
			int startDateMinute, int endDateMonth, int endDateDay,
			int endDateYear, int endDateHour, int endDateMinute,
			boolean dateTBA, String addressStreet1, String addressStreet2,
			String addressStreet3, String addressCity, String addressZip,
			long addressRegionId, long addressCountryId, double latitude,
			double longitude, int globalRegion, boolean online,
			int registrationType, String registrationURL, String extraSettings,
			ServiceContext serviceContext)
		throws PortalException {

		// Marketing event

		User user = userPersistence.findByPrimaryKey(userId);
		TimeZone timeZone = TimeZoneUtil.getTimeZone(timeZoneId);
		Date startDate = PortalUtil.getDate(
			startDateMonth, startDateDay, startDateYear, startDateHour,
			startDateMinute, timeZone, MarketingEventStartDateException.class);

		Date endDate = null;

		if (!dateTBA) {
			endDate = PortalUtil.getDate(
				endDateMonth, endDateDay, endDateYear, endDateHour,
				endDateMinute, timeZone, MarketingEventEndDateException.class);
		}

		if (online) {
			globalRegion = MarketingEventConstants.GLOBAL_REGION_WORLDWIDE;
		}

		Date now = new Date();

		long marketingEventId = counterLocalService.increment();

		MarketingEvent marketingEvent = marketingEventPersistence.create(
			marketingEventId);

		validate(
			marketingEvent, defaultLanguageId, titleMap, titleURL, hostedBy,
			hostedByURL, siteGroupId, videoTitle, registrationURL);

		marketingEvent.setCompanyId(user.getCompanyId());
		marketingEvent.setUserId(user.getUserId());
		marketingEvent.setUserName(user.getFullName());
		marketingEvent.setCreateDate(serviceContext.getCreateDate(now));
		marketingEvent.setModifiedDate(serviceContext.getModifiedDate(now));
		marketingEvent.setType(type);
		marketingEvent.setTitleMap(
			titleMap, LocaleUtil.fromLanguageId(defaultLanguageId));
		marketingEvent.setTitleURL(titleURL);
		marketingEvent.setHostedBy(hostedBy);
		marketingEvent.setHostedByURL(hostedByURL);
		marketingEvent.setSummaryMap(
			summaryMap, LocaleUtil.fromLanguageId(defaultLanguageId));
		marketingEvent.setSiteGroupId(siteGroupId);
		marketingEvent.setImageFileEntryId(imageFileEntryId);
		marketingEvent.setSlidesFileEntryId(slidesFileEntryId);
		marketingEvent.setVideoTitle(videoTitle);
		marketingEvent.setTimeZoneId(timeZoneId);
		marketingEvent.setStartDate(startDate);
		marketingEvent.setEndDate(endDate);
		marketingEvent.setDateTBA(dateTBA);
		marketingEvent.setLatitude(latitude);
		marketingEvent.setLongitude(longitude);
		marketingEvent.setGlobalRegion(globalRegion);
		marketingEvent.setOnline(online);
		marketingEvent.setRegistrationType(registrationType);
		marketingEvent.setRegistrationURL(registrationURL);
		marketingEvent.setExtraSettings(extraSettings);

		// Address

		Address address = addAddress(
			user.getUserId(), marketingEvent.getMarketingEventId(),
			addressStreet1, addressStreet2, addressStreet3, addressCity,
			addressZip, addressRegionId, addressCountryId,
			marketingEvent.isOnline(), serviceContext);

		if (address != null) {
			marketingEvent.setAddressId(address.getAddressId());
		}
		else {
			marketingEvent.setAddressId(
				MarketingEventConstants.DEFAULT_ADDRESS_ID);
		}

		marketingEventPersistence.update(marketingEvent);

		// Indexer

		Indexer<MarketingEvent> indexer =
			IndexerRegistryUtil.nullSafeGetIndexer(MarketingEvent.class);

		indexer.reindex(marketingEvent);

		return marketingEvent;
	}

	@Override
	public MarketingEvent deleteMarketingEvent(long marketingEventId)
		throws PortalException {

		MarketingEvent marketingEvent =
			marketingEventPersistence.findByPrimaryKey(marketingEventId);

		return deleteMarketingEvent(marketingEvent);
	}

	@Override
	public MarketingEvent deleteMarketingEvent(MarketingEvent marketingEvent)
		throws PortalException {

		// Marketing event

		marketingEventPersistence.remove(marketingEvent);

		// Address

		deleteAddress(marketingEvent.getAddressId());

		// Indexer

		Indexer<MarketingEvent> indexer = getMarketingEventIndexer();

		indexer.delete(marketingEvent);

		return marketingEvent;
	}

	public List<MarketingEvent> getMarketingEvents(
		int type, Date startDate, int start, int end, OrderByComparator obc) {

		return marketingEventPersistence.findByT_GtSD(
			type, startDate, start, end, obc);
	}

	public List<MarketingEvent> getMarketingEvents(
		int type, int start, int end, OrderByComparator obc) {

		return marketingEventPersistence.findByType(type, start, end, obc);
	}

	public List<MarketingEvent> getMarketingEvents(
		int[] types, int[] globalRegions, long[] countryIds,
		int[] locationTypes, boolean pastEvents, String userLanguageId,
		String orderByCol, String orderByType) {

		DynamicQuery dynamicQuery = buildDynamicQuery(
			types, globalRegions, countryIds, locationTypes, pastEvents);

		List<MarketingEvent> marketingEvents = dynamicQuery(dynamicQuery);

		return sort(marketingEvents, userLanguageId, orderByCol, orderByType);
	}

	public MarketingEvent getSiteGroupMarketingEvent(long siteGroupId) {
		return marketingEventPersistence.fetchBySiteGroupId(siteGroupId);
	}

	public Hits search(
		long companyId, String title, String summary, int[] types,
		int[] globalRegions, Date startDateGT, Date startDateLT,
		boolean andSearch, int start, int end, Sort sort) {

		try {
			SearchContext searchContext = new SearchContext();

			searchContext.setAndSearch(andSearch);

			Map<String, Serializable> attributes = new HashMap<>();

			attributes.put("globalRegion", globalRegions);
			attributes.put("startDateGT", startDateGT);
			attributes.put("startDateLT", startDateLT);
			attributes.put("summary", summary);
			attributes.put("title", title);
			attributes.put("type", types);

			searchContext.setAttributes(attributes);

			searchContext.setCompanyId(companyId);
			searchContext.setEnd(end);

			QueryConfig queryConfig = new QueryConfig();

			queryConfig.setHighlightEnabled(false);
			queryConfig.setScoreEnabled(false);

			searchContext.setQueryConfig(queryConfig);

			if (sort != null) {
				searchContext.setSorts(new Sort[] {sort});
			}

			searchContext.setStart(start);

			Indexer<MarketingEvent> indexer = getMarketingEventIndexer();

			return indexer.search(searchContext);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	public MarketingEvent updateMarketingEvent(
			long marketingEventId, int type, String defaultLanguageId,
			Map<Locale, String> titleMap, String titleURL, String hostedBy,
			String hostedByURL, Map<Locale, String> summaryMap,
			long siteGroupId, long imageFileEntryId, long slidesFileEntryId,
			String videoTitle, String timeZoneId, int startDateMonth,
			int startDateDay, int startDateYear, int startDateHour,
			int startDateMinute, int endDateMonth, int endDateDay,
			int endDateYear, int endDateHour, int endDateMinute,
			boolean dateTBA, String addressStreet1, String addressStreet2,
			String addressStreet3, String addressCity, String addressZip,
			long addressRegionId, long addressCountryId, double latitude,
			double longitude, int globalRegion, boolean online,
			int registrationType, String registrationURL, String extraSettings,
			ServiceContext serviceContext)
		throws PortalException {

		// Marketing event

		TimeZone timeZone = TimeZoneUtil.getTimeZone(timeZoneId);
		Date startDate = PortalUtil.getDate(
			startDateMonth, startDateDay, startDateYear, startDateHour,
			startDateMinute, timeZone, MarketingEventStartDateException.class);

		Date endDate = null;

		if (!dateTBA) {
			endDate = PortalUtil.getDate(
				endDateMonth, endDateDay, endDateYear, endDateHour,
				endDateMinute, timeZone, MarketingEventEndDateException.class);
		}

		if (online) {
			globalRegion = MarketingEventConstants.GLOBAL_REGION_WORLDWIDE;
		}

		MarketingEvent marketingEvent =
			marketingEventPersistence.findByPrimaryKey(marketingEventId);

		validate(
			marketingEvent, defaultLanguageId, titleMap, titleURL, hostedBy,
			hostedByURL, siteGroupId, videoTitle, registrationURL);

		marketingEvent.setModifiedDate(serviceContext.getModifiedDate(null));
		marketingEvent.setType(type);
		marketingEvent.setTitleMap(
			titleMap, LocaleUtil.fromLanguageId(defaultLanguageId));
		marketingEvent.setTitleURL(titleURL);
		marketingEvent.setHostedBy(hostedBy);
		marketingEvent.setHostedByURL(hostedByURL);
		marketingEvent.setSummaryMap(
			summaryMap, LocaleUtil.fromLanguageId(defaultLanguageId));
		marketingEvent.setSiteGroupId(siteGroupId);
		marketingEvent.setImageFileEntryId(imageFileEntryId);
		marketingEvent.setSlidesFileEntryId(slidesFileEntryId);
		marketingEvent.setVideoTitle(videoTitle);
		marketingEvent.setTimeZoneId(timeZoneId);
		marketingEvent.setStartDate(startDate);
		marketingEvent.setEndDate(endDate);
		marketingEvent.setDateTBA(dateTBA);
		marketingEvent.setLatitude(latitude);
		marketingEvent.setLongitude(longitude);
		marketingEvent.setGlobalRegion(globalRegion);
		marketingEvent.setOnline(online);
		marketingEvent.setRegistrationType(registrationType);
		marketingEvent.setRegistrationURL(registrationURL);
		marketingEvent.setExtraSettings(extraSettings);

		// Address

		Address address = updateAddress(
			addressStreet1, addressStreet2, addressStreet3, addressCity,
			addressZip, addressRegionId, addressCountryId, marketingEvent,
			serviceContext);

		if (address != null) {
			marketingEvent.setAddressId(address.getAddressId());
		}
		else {
			marketingEvent.setAddressId(
				MarketingEventConstants.DEFAULT_ADDRESS_ID);
		}

		marketingEventPersistence.update(marketingEvent);

		// Indexer

		Indexer<MarketingEvent> indexer = getMarketingEventIndexer();

		indexer.reindex(marketingEvent);

		return marketingEvent;
	}

	protected Address addAddress(
			long userId, long marketingEventId, String addressStreet1,
			String addressStreet2, String addressStreet3, String addressCity,
			String addressZip, long addressRegionId, long addressCountryId,
			boolean online, ServiceContext serviceContext)
		throws PortalException {

		if (online) {
			return null;
		}

		if (Validator.isNull(addressStreet1) &&
			Validator.isNull(addressStreet2) &&
			Validator.isNull(addressStreet3) && Validator.isNull(addressCity) &&
			Validator.isNull(addressZip) && (addressRegionId == 0) &&
			(addressCountryId == 0)) {

			return null;
		}

		if (Validator.isNull(addressZip)) {
			addressZip = MarketingEventConstants.ADDRESS_ZIP_NOT_AVAILABLE;
		}

		return addressLocalService.addAddress(
			userId, MarketingEvent.class.getName(), marketingEventId,
			addressStreet1, addressStreet2, addressStreet3, addressCity,
			addressZip, addressRegionId, addressCountryId, 0, false, true,
			serviceContext);
	}

	protected DynamicQuery buildDynamicQuery(
		int[] types, int[] globalRegions, long[] countryIds,
		int[] locationTypes, boolean pastEvents) {

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			MarketingEvent.class, getClassLoader());

		Junction junction = RestrictionsFactoryUtil.conjunction();

		if ((types != null) && (types.length > 0)) {
			Property typeProperty = PropertyFactoryUtil.forName("type");

			junction.add(in(typeProperty, types));
		}

		if ((globalRegions != null) && (globalRegions.length > 0) &&
			!ArrayUtil.contains(
				globalRegions,
				MarketingEventConstants.GLOBAL_REGION_WORLDWIDE)) {

			Property globalRegionProperty = PropertyFactoryUtil.forName(
				"globalRegion");

			int[] globalRegionValues = ArrayUtil.append(
				globalRegions, MarketingEventConstants.GLOBAL_REGION_WORLDWIDE);

			junction.add(in(globalRegionProperty, globalRegionValues));
		}

		if ((countryIds != null) && (countryIds.length > 0)) {
			List<Address> addresses = getAddresses(countryIds);

			long[] addressIds = StringUtil.split(
				ListUtil.toString(addresses, "addressId"), 0L);

			long[] addressIdValues = ArrayUtil.append(
				addressIds, MarketingEventConstants.DEFAULT_ADDRESS_ID);

			Property addressIdProperty = PropertyFactoryUtil.forName(
				"addressId");

			junction.add(in(addressIdProperty, addressIdValues));
		}

		if ((locationTypes != null) && (locationTypes.length > 0)) {
			boolean[] onlineValues = new boolean[0];

			if (ArrayUtil.contains(
					locationTypes,
					MarketingEventConstants.LOCATION_TYPE_IN_PERSON)) {

				onlineValues = ArrayUtil.append(onlineValues, Boolean.FALSE);
			}

			if (ArrayUtil.contains(
					locationTypes,
					MarketingEventConstants.LOCATION_TYPE_ONLINE)) {

				onlineValues = ArrayUtil.append(onlineValues, Boolean.TRUE);
			}

			Property onlineProperty = PropertyFactoryUtil.forName("online");

			junction.add(in(onlineProperty, onlineValues));
		}

		Property endDateProperty = PropertyFactoryUtil.forName("endDate");

		Date now = new Date();

		if (pastEvents) {
			junction.add(endDateProperty.lt(now));
		}
		else {
			junction.add(endDateProperty.ge(now));
		}

		return dynamicQuery.add(junction);
	}

	protected Address deleteAddress(long addressId) throws PortalException {
		Address address = addressLocalService.fetchAddress(addressId);

		if (address == null) {
			return null;
		}

		return addressLocalService.deleteAddress(addressId);
	}

	protected List<Address> getAddresses(long[] countryIds) {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Address.class, PortalClassLoaderUtil.getClassLoader());

		long classNameId = classNameLocalService.getClassNameId(
			MarketingEvent.class.getName());

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("classNameId", classNameId));

		Property property = PropertyFactoryUtil.forName("countryId");

		dynamicQuery.add(in(property, countryIds));

		return addressLocalService.dynamicQuery(dynamicQuery);
	}

	protected Indexer<MarketingEvent> getMarketingEventIndexer() {
		Indexer<MarketingEvent> indexer = indexerRegistry.nullSafeGetIndexer(
			MarketingEvent.class);

		return indexer;
	}

	protected Criterion in(Property property, Object values) {
		List<Object> list = new ArrayList<>();

		if (values instanceof boolean[]) {
			list.addAll(ListUtil.toList((boolean[])values));
		}
		else if (values instanceof int[]) {
			list.addAll(ListUtil.toList((int[])values));
		}
		else if (values instanceof long[]) {
			list.addAll(ListUtil.toList((long[])values));
		}

		return property.in(list);
	}

	protected List<MarketingEvent> sort(
		List<MarketingEvent> marketingEvents, String userLanguageId,
		String orderByCol, String orderByType) {

		Locale locale = LocaleUtil.fromLanguageId(userLanguageId, false);

		boolean asc = false;

		if (StringUtil.equalsIgnoreCase(
				orderByType, MarketingEventConstants.ORDER_BY_TYPE_ASC)) {

			asc = true;
		}

		if (StringUtil.contains(orderByCol, StringPool.DASH)) {
			orderByCol = TextFormatter.format(orderByCol, TextFormatter.M);
		}

		Comparator<MarketingEvent> comparator = null;

		if (StringUtil.equalsIgnoreCase(orderByCol, "type")) {
			comparator = new MarketingEventTypeComparator(locale, asc);
		}
		else {
			comparator = new MarketingEventStartDateComparator(locale, asc);
		}

		return ListUtil.sort(marketingEvents, comparator);
	}

	protected Address updateAddress(
		String addressStreet1, String addressStreet2, String addressStreet3,
		String addressCity, String addressZip, long addressRegionId,
		long addressCountryId, MarketingEvent marketingEvent,
		ServiceContext serviceContext) throws PortalException {

		if (marketingEvent.getAddressId() ==
				MarketingEventConstants.DEFAULT_ADDRESS_ID) {

			long userId = marketingEvent.getUserId();
			long marketingEventId = marketingEvent.getMarketingEventId();
			boolean online = marketingEvent.isOnline();

			return addAddress(
				userId, marketingEventId, addressStreet1, addressStreet2,
				addressStreet3, addressCity, addressZip, addressRegionId,
				addressCountryId, online, serviceContext);
		}

		if (marketingEvent.isOnline()) {
			return deleteAddress(marketingEvent.getAddressId());
		}

		if (Validator.isNull(addressStreet1) &&
			Validator.isNull(addressStreet2) &&
			Validator.isNull(addressStreet3) && Validator.isNull(addressCity) &&
			Validator.isNull(addressZip) && (addressRegionId == 0) &&
			(addressCountryId == 0)) {

			return deleteAddress(marketingEvent.getAddressId());
		}

		if (Validator.isNull(addressZip)) {
			addressZip = MarketingEventConstants.ADDRESS_ZIP_NOT_AVAILABLE;
		}

		return addressLocalService.updateAddress(
			marketingEvent.getAddressId(), addressStreet1, addressStreet2,
			addressStreet3, addressCity, addressZip, addressRegionId,
			addressCountryId, 0, false, true);
	}

	protected void validate(
			MarketingEvent marketingEvent, String defaultLanguageId,
			Map<Locale, String> titleMap, String titleURL, String hostedBy,
			String hostedByURL, long siteGroupId, String videoTitle,
			String registrationURL)
		throws PortalException {

		boolean emptyTitleMap = true;

		for (String title : titleMap.values()) {
			if (Validator.isNotNull(title)) {
				emptyTitleMap = false;

				break;
			}
		}

		if (emptyTitleMap) {
			throw new MarketingEventTitleException();
		}

		if (Validator.isNotNull(titleURL) && !Validator.isUrl(titleURL)) {
			throw new MarketingEventTitleURLException();
		}

		if (Validator.isNull(hostedBy) && Validator.isNotNull(hostedByURL)) {
			throw new MarketingEventHostedByException();
		}

		if (Validator.isNotNull(hostedByURL) && !Validator.isUrl(hostedByURL)) {
			throw new MarketingEventHostedByURLException();
		}

		int count = marketingEventPersistence.countBySiteGroupId(siteGroupId);

		if ((count > 0) && (siteGroupId > 0) &&
			(marketingEvent.getSiteGroupId() != siteGroupId)) {

			throw new DuplicateSiteGroupException();
		}

		if (Validator.isNotNull(videoTitle)) {
			String s = videoTitle;

			s = FileUtil.getShortFileName(videoTitle);
			s = FileUtil.stripExtension(videoTitle);

			if (!videoTitle.equals(s)) {
				throw new MarketingEventVideoTitleException();
			}
		}

		if (Validator.isNotNull(registrationURL) &&
			!Validator.isUrl(registrationURL)) {

			throw new MarketingEventRegistrationURLException();
		}
	}

	@ServiceReference(type = IndexerRegistry.class)
	protected IndexerRegistry indexerRegistry;

}