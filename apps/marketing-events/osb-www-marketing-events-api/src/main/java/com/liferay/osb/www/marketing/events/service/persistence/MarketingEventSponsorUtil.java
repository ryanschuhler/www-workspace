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

package com.liferay.osb.www.marketing.events.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osb.www.marketing.events.model.MarketingEventSponsor;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the marketing event sponsor service. This utility wraps {@link com.liferay.osb.www.marketing.events.service.persistence.impl.MarketingEventSponsorPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEventSponsorPersistence
 * @see com.liferay.osb.www.marketing.events.service.persistence.impl.MarketingEventSponsorPersistenceImpl
 * @generated
 */
@ProviderType
public class MarketingEventSponsorUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(MarketingEventSponsor marketingEventSponsor) {
		getPersistence().clearCache(marketingEventSponsor);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<MarketingEventSponsor> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MarketingEventSponsor> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MarketingEventSponsor> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MarketingEventSponsor> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MarketingEventSponsor update(
		MarketingEventSponsor marketingEventSponsor) {
		return getPersistence().update(marketingEventSponsor);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MarketingEventSponsor update(
		MarketingEventSponsor marketingEventSponsor,
		ServiceContext serviceContext) {
		return getPersistence().update(marketingEventSponsor, serviceContext);
	}

	/**
	* Returns all the marketing event sponsors where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @return the matching marketing event sponsors
	*/
	public static List<MarketingEventSponsor> findByMarketingEventId(
		long marketingEventId) {
		return getPersistence().findByMarketingEventId(marketingEventId);
	}

	/**
	* Returns a range of all the marketing event sponsors where marketingEventId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSponsorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param marketingEventId the marketing event ID
	* @param start the lower bound of the range of marketing event sponsors
	* @param end the upper bound of the range of marketing event sponsors (not inclusive)
	* @return the range of matching marketing event sponsors
	*/
	public static List<MarketingEventSponsor> findByMarketingEventId(
		long marketingEventId, int start, int end) {
		return getPersistence()
				   .findByMarketingEventId(marketingEventId, start, end);
	}

	/**
	* Returns an ordered range of all the marketing event sponsors where marketingEventId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSponsorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param marketingEventId the marketing event ID
	* @param start the lower bound of the range of marketing event sponsors
	* @param end the upper bound of the range of marketing event sponsors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching marketing event sponsors
	*/
	public static List<MarketingEventSponsor> findByMarketingEventId(
		long marketingEventId, int start, int end,
		OrderByComparator<MarketingEventSponsor> orderByComparator) {
		return getPersistence()
				   .findByMarketingEventId(marketingEventId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the marketing event sponsors where marketingEventId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSponsorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param marketingEventId the marketing event ID
	* @param start the lower bound of the range of marketing event sponsors
	* @param end the upper bound of the range of marketing event sponsors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching marketing event sponsors
	*/
	public static List<MarketingEventSponsor> findByMarketingEventId(
		long marketingEventId, int start, int end,
		OrderByComparator<MarketingEventSponsor> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByMarketingEventId(marketingEventId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first marketing event sponsor in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event sponsor
	* @throws NoSuchMarketingEventSponsorException if a matching marketing event sponsor could not be found
	*/
	public static MarketingEventSponsor findByMarketingEventId_First(
		long marketingEventId,
		OrderByComparator<MarketingEventSponsor> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventSponsorException {
		return getPersistence()
				   .findByMarketingEventId_First(marketingEventId,
			orderByComparator);
	}

	/**
	* Returns the first marketing event sponsor in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event sponsor, or <code>null</code> if a matching marketing event sponsor could not be found
	*/
	public static MarketingEventSponsor fetchByMarketingEventId_First(
		long marketingEventId,
		OrderByComparator<MarketingEventSponsor> orderByComparator) {
		return getPersistence()
				   .fetchByMarketingEventId_First(marketingEventId,
			orderByComparator);
	}

	/**
	* Returns the last marketing event sponsor in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event sponsor
	* @throws NoSuchMarketingEventSponsorException if a matching marketing event sponsor could not be found
	*/
	public static MarketingEventSponsor findByMarketingEventId_Last(
		long marketingEventId,
		OrderByComparator<MarketingEventSponsor> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventSponsorException {
		return getPersistence()
				   .findByMarketingEventId_Last(marketingEventId,
			orderByComparator);
	}

	/**
	* Returns the last marketing event sponsor in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event sponsor, or <code>null</code> if a matching marketing event sponsor could not be found
	*/
	public static MarketingEventSponsor fetchByMarketingEventId_Last(
		long marketingEventId,
		OrderByComparator<MarketingEventSponsor> orderByComparator) {
		return getPersistence()
				   .fetchByMarketingEventId_Last(marketingEventId,
			orderByComparator);
	}

	/**
	* Returns the marketing event sponsors before and after the current marketing event sponsor in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventSponsorId the primary key of the current marketing event sponsor
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next marketing event sponsor
	* @throws NoSuchMarketingEventSponsorException if a marketing event sponsor with the primary key could not be found
	*/
	public static MarketingEventSponsor[] findByMarketingEventId_PrevAndNext(
		long marketingEventSponsorId, long marketingEventId,
		OrderByComparator<MarketingEventSponsor> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventSponsorException {
		return getPersistence()
				   .findByMarketingEventId_PrevAndNext(marketingEventSponsorId,
			marketingEventId, orderByComparator);
	}

	/**
	* Removes all the marketing event sponsors where marketingEventId = &#63; from the database.
	*
	* @param marketingEventId the marketing event ID
	*/
	public static void removeByMarketingEventId(long marketingEventId) {
		getPersistence().removeByMarketingEventId(marketingEventId);
	}

	/**
	* Returns the number of marketing event sponsors where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @return the number of matching marketing event sponsors
	*/
	public static int countByMarketingEventId(long marketingEventId) {
		return getPersistence().countByMarketingEventId(marketingEventId);
	}

	/**
	* Returns all the marketing event sponsors where marketingEventId = &#63; and marketingEventSponsorLevelId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param marketingEventSponsorLevelId the marketing event sponsor level ID
	* @return the matching marketing event sponsors
	*/
	public static List<MarketingEventSponsor> findByMEI_MESLI(
		long marketingEventId, long marketingEventSponsorLevelId) {
		return getPersistence()
				   .findByMEI_MESLI(marketingEventId,
			marketingEventSponsorLevelId);
	}

	/**
	* Returns a range of all the marketing event sponsors where marketingEventId = &#63; and marketingEventSponsorLevelId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSponsorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param marketingEventId the marketing event ID
	* @param marketingEventSponsorLevelId the marketing event sponsor level ID
	* @param start the lower bound of the range of marketing event sponsors
	* @param end the upper bound of the range of marketing event sponsors (not inclusive)
	* @return the range of matching marketing event sponsors
	*/
	public static List<MarketingEventSponsor> findByMEI_MESLI(
		long marketingEventId, long marketingEventSponsorLevelId, int start,
		int end) {
		return getPersistence()
				   .findByMEI_MESLI(marketingEventId,
			marketingEventSponsorLevelId, start, end);
	}

	/**
	* Returns an ordered range of all the marketing event sponsors where marketingEventId = &#63; and marketingEventSponsorLevelId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSponsorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param marketingEventId the marketing event ID
	* @param marketingEventSponsorLevelId the marketing event sponsor level ID
	* @param start the lower bound of the range of marketing event sponsors
	* @param end the upper bound of the range of marketing event sponsors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching marketing event sponsors
	*/
	public static List<MarketingEventSponsor> findByMEI_MESLI(
		long marketingEventId, long marketingEventSponsorLevelId, int start,
		int end, OrderByComparator<MarketingEventSponsor> orderByComparator) {
		return getPersistence()
				   .findByMEI_MESLI(marketingEventId,
			marketingEventSponsorLevelId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the marketing event sponsors where marketingEventId = &#63; and marketingEventSponsorLevelId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSponsorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param marketingEventId the marketing event ID
	* @param marketingEventSponsorLevelId the marketing event sponsor level ID
	* @param start the lower bound of the range of marketing event sponsors
	* @param end the upper bound of the range of marketing event sponsors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching marketing event sponsors
	*/
	public static List<MarketingEventSponsor> findByMEI_MESLI(
		long marketingEventId, long marketingEventSponsorLevelId, int start,
		int end, OrderByComparator<MarketingEventSponsor> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByMEI_MESLI(marketingEventId,
			marketingEventSponsorLevelId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first marketing event sponsor in the ordered set where marketingEventId = &#63; and marketingEventSponsorLevelId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param marketingEventSponsorLevelId the marketing event sponsor level ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event sponsor
	* @throws NoSuchMarketingEventSponsorException if a matching marketing event sponsor could not be found
	*/
	public static MarketingEventSponsor findByMEI_MESLI_First(
		long marketingEventId, long marketingEventSponsorLevelId,
		OrderByComparator<MarketingEventSponsor> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventSponsorException {
		return getPersistence()
				   .findByMEI_MESLI_First(marketingEventId,
			marketingEventSponsorLevelId, orderByComparator);
	}

	/**
	* Returns the first marketing event sponsor in the ordered set where marketingEventId = &#63; and marketingEventSponsorLevelId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param marketingEventSponsorLevelId the marketing event sponsor level ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event sponsor, or <code>null</code> if a matching marketing event sponsor could not be found
	*/
	public static MarketingEventSponsor fetchByMEI_MESLI_First(
		long marketingEventId, long marketingEventSponsorLevelId,
		OrderByComparator<MarketingEventSponsor> orderByComparator) {
		return getPersistence()
				   .fetchByMEI_MESLI_First(marketingEventId,
			marketingEventSponsorLevelId, orderByComparator);
	}

	/**
	* Returns the last marketing event sponsor in the ordered set where marketingEventId = &#63; and marketingEventSponsorLevelId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param marketingEventSponsorLevelId the marketing event sponsor level ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event sponsor
	* @throws NoSuchMarketingEventSponsorException if a matching marketing event sponsor could not be found
	*/
	public static MarketingEventSponsor findByMEI_MESLI_Last(
		long marketingEventId, long marketingEventSponsorLevelId,
		OrderByComparator<MarketingEventSponsor> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventSponsorException {
		return getPersistence()
				   .findByMEI_MESLI_Last(marketingEventId,
			marketingEventSponsorLevelId, orderByComparator);
	}

	/**
	* Returns the last marketing event sponsor in the ordered set where marketingEventId = &#63; and marketingEventSponsorLevelId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param marketingEventSponsorLevelId the marketing event sponsor level ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event sponsor, or <code>null</code> if a matching marketing event sponsor could not be found
	*/
	public static MarketingEventSponsor fetchByMEI_MESLI_Last(
		long marketingEventId, long marketingEventSponsorLevelId,
		OrderByComparator<MarketingEventSponsor> orderByComparator) {
		return getPersistence()
				   .fetchByMEI_MESLI_Last(marketingEventId,
			marketingEventSponsorLevelId, orderByComparator);
	}

	/**
	* Returns the marketing event sponsors before and after the current marketing event sponsor in the ordered set where marketingEventId = &#63; and marketingEventSponsorLevelId = &#63;.
	*
	* @param marketingEventSponsorId the primary key of the current marketing event sponsor
	* @param marketingEventId the marketing event ID
	* @param marketingEventSponsorLevelId the marketing event sponsor level ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next marketing event sponsor
	* @throws NoSuchMarketingEventSponsorException if a marketing event sponsor with the primary key could not be found
	*/
	public static MarketingEventSponsor[] findByMEI_MESLI_PrevAndNext(
		long marketingEventSponsorId, long marketingEventId,
		long marketingEventSponsorLevelId,
		OrderByComparator<MarketingEventSponsor> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventSponsorException {
		return getPersistence()
				   .findByMEI_MESLI_PrevAndNext(marketingEventSponsorId,
			marketingEventId, marketingEventSponsorLevelId, orderByComparator);
	}

	/**
	* Removes all the marketing event sponsors where marketingEventId = &#63; and marketingEventSponsorLevelId = &#63; from the database.
	*
	* @param marketingEventId the marketing event ID
	* @param marketingEventSponsorLevelId the marketing event sponsor level ID
	*/
	public static void removeByMEI_MESLI(long marketingEventId,
		long marketingEventSponsorLevelId) {
		getPersistence()
			.removeByMEI_MESLI(marketingEventId, marketingEventSponsorLevelId);
	}

	/**
	* Returns the number of marketing event sponsors where marketingEventId = &#63; and marketingEventSponsorLevelId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param marketingEventSponsorLevelId the marketing event sponsor level ID
	* @return the number of matching marketing event sponsors
	*/
	public static int countByMEI_MESLI(long marketingEventId,
		long marketingEventSponsorLevelId) {
		return getPersistence()
				   .countByMEI_MESLI(marketingEventId,
			marketingEventSponsorLevelId);
	}

	/**
	* Caches the marketing event sponsor in the entity cache if it is enabled.
	*
	* @param marketingEventSponsor the marketing event sponsor
	*/
	public static void cacheResult(MarketingEventSponsor marketingEventSponsor) {
		getPersistence().cacheResult(marketingEventSponsor);
	}

	/**
	* Caches the marketing event sponsors in the entity cache if it is enabled.
	*
	* @param marketingEventSponsors the marketing event sponsors
	*/
	public static void cacheResult(
		List<MarketingEventSponsor> marketingEventSponsors) {
		getPersistence().cacheResult(marketingEventSponsors);
	}

	/**
	* Creates a new marketing event sponsor with the primary key. Does not add the marketing event sponsor to the database.
	*
	* @param marketingEventSponsorId the primary key for the new marketing event sponsor
	* @return the new marketing event sponsor
	*/
	public static MarketingEventSponsor create(long marketingEventSponsorId) {
		return getPersistence().create(marketingEventSponsorId);
	}

	/**
	* Removes the marketing event sponsor with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEventSponsorId the primary key of the marketing event sponsor
	* @return the marketing event sponsor that was removed
	* @throws NoSuchMarketingEventSponsorException if a marketing event sponsor with the primary key could not be found
	*/
	public static MarketingEventSponsor remove(long marketingEventSponsorId)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventSponsorException {
		return getPersistence().remove(marketingEventSponsorId);
	}

	public static MarketingEventSponsor updateImpl(
		MarketingEventSponsor marketingEventSponsor) {
		return getPersistence().updateImpl(marketingEventSponsor);
	}

	/**
	* Returns the marketing event sponsor with the primary key or throws a {@link NoSuchMarketingEventSponsorException} if it could not be found.
	*
	* @param marketingEventSponsorId the primary key of the marketing event sponsor
	* @return the marketing event sponsor
	* @throws NoSuchMarketingEventSponsorException if a marketing event sponsor with the primary key could not be found
	*/
	public static MarketingEventSponsor findByPrimaryKey(
		long marketingEventSponsorId)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventSponsorException {
		return getPersistence().findByPrimaryKey(marketingEventSponsorId);
	}

	/**
	* Returns the marketing event sponsor with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param marketingEventSponsorId the primary key of the marketing event sponsor
	* @return the marketing event sponsor, or <code>null</code> if a marketing event sponsor with the primary key could not be found
	*/
	public static MarketingEventSponsor fetchByPrimaryKey(
		long marketingEventSponsorId) {
		return getPersistence().fetchByPrimaryKey(marketingEventSponsorId);
	}

	public static java.util.Map<java.io.Serializable, MarketingEventSponsor> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the marketing event sponsors.
	*
	* @return the marketing event sponsors
	*/
	public static List<MarketingEventSponsor> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the marketing event sponsors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSponsorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of marketing event sponsors
	* @param end the upper bound of the range of marketing event sponsors (not inclusive)
	* @return the range of marketing event sponsors
	*/
	public static List<MarketingEventSponsor> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the marketing event sponsors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSponsorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of marketing event sponsors
	* @param end the upper bound of the range of marketing event sponsors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of marketing event sponsors
	*/
	public static List<MarketingEventSponsor> findAll(int start, int end,
		OrderByComparator<MarketingEventSponsor> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the marketing event sponsors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSponsorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of marketing event sponsors
	* @param end the upper bound of the range of marketing event sponsors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of marketing event sponsors
	*/
	public static List<MarketingEventSponsor> findAll(int start, int end,
		OrderByComparator<MarketingEventSponsor> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the marketing event sponsors from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of marketing event sponsors.
	*
	* @return the number of marketing event sponsors
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MarketingEventSponsorPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<MarketingEventSponsorPersistence, MarketingEventSponsorPersistence> _serviceTracker =
		ServiceTrackerFactory.open(MarketingEventSponsorPersistence.class);
}