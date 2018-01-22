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

import com.liferay.osb.www.marketing.events.model.MarketingEvent;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.Date;
import java.util.List;

/**
 * The persistence utility for the marketing event service. This utility wraps {@link com.liferay.osb.www.marketing.events.service.persistence.impl.MarketingEventPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEventPersistence
 * @see com.liferay.osb.www.marketing.events.service.persistence.impl.MarketingEventPersistenceImpl
 * @generated
 */
@ProviderType
public class MarketingEventUtil {
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
	public static void clearCache(MarketingEvent marketingEvent) {
		getPersistence().clearCache(marketingEvent);
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
	public static List<MarketingEvent> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MarketingEvent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MarketingEvent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MarketingEvent> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MarketingEvent update(MarketingEvent marketingEvent) {
		return getPersistence().update(marketingEvent);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MarketingEvent update(MarketingEvent marketingEvent,
		ServiceContext serviceContext) {
		return getPersistence().update(marketingEvent, serviceContext);
	}

	/**
	* Returns all the marketing events where type = &#63;.
	*
	* @param type the type
	* @return the matching marketing events
	*/
	public static List<MarketingEvent> findByType(int type) {
		return getPersistence().findByType(type);
	}

	/**
	* Returns a range of all the marketing events where type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param type the type
	* @param start the lower bound of the range of marketing events
	* @param end the upper bound of the range of marketing events (not inclusive)
	* @return the range of matching marketing events
	*/
	public static List<MarketingEvent> findByType(int type, int start, int end) {
		return getPersistence().findByType(type, start, end);
	}

	/**
	* Returns an ordered range of all the marketing events where type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param type the type
	* @param start the lower bound of the range of marketing events
	* @param end the upper bound of the range of marketing events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching marketing events
	*/
	public static List<MarketingEvent> findByType(int type, int start, int end,
		OrderByComparator<MarketingEvent> orderByComparator) {
		return getPersistence().findByType(type, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the marketing events where type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param type the type
	* @param start the lower bound of the range of marketing events
	* @param end the upper bound of the range of marketing events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching marketing events
	*/
	public static List<MarketingEvent> findByType(int type, int start, int end,
		OrderByComparator<MarketingEvent> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByType(type, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first marketing event in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event
	* @throws NoSuchMarketingEventException if a matching marketing event could not be found
	*/
	public static MarketingEvent findByType_First(int type,
		OrderByComparator<MarketingEvent> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventException {
		return getPersistence().findByType_First(type, orderByComparator);
	}

	/**
	* Returns the first marketing event in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event, or <code>null</code> if a matching marketing event could not be found
	*/
	public static MarketingEvent fetchByType_First(int type,
		OrderByComparator<MarketingEvent> orderByComparator) {
		return getPersistence().fetchByType_First(type, orderByComparator);
	}

	/**
	* Returns the last marketing event in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event
	* @throws NoSuchMarketingEventException if a matching marketing event could not be found
	*/
	public static MarketingEvent findByType_Last(int type,
		OrderByComparator<MarketingEvent> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventException {
		return getPersistence().findByType_Last(type, orderByComparator);
	}

	/**
	* Returns the last marketing event in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event, or <code>null</code> if a matching marketing event could not be found
	*/
	public static MarketingEvent fetchByType_Last(int type,
		OrderByComparator<MarketingEvent> orderByComparator) {
		return getPersistence().fetchByType_Last(type, orderByComparator);
	}

	/**
	* Returns the marketing events before and after the current marketing event in the ordered set where type = &#63;.
	*
	* @param marketingEventId the primary key of the current marketing event
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next marketing event
	* @throws NoSuchMarketingEventException if a marketing event with the primary key could not be found
	*/
	public static MarketingEvent[] findByType_PrevAndNext(
		long marketingEventId, int type,
		OrderByComparator<MarketingEvent> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventException {
		return getPersistence()
				   .findByType_PrevAndNext(marketingEventId, type,
			orderByComparator);
	}

	/**
	* Removes all the marketing events where type = &#63; from the database.
	*
	* @param type the type
	*/
	public static void removeByType(int type) {
		getPersistence().removeByType(type);
	}

	/**
	* Returns the number of marketing events where type = &#63;.
	*
	* @param type the type
	* @return the number of matching marketing events
	*/
	public static int countByType(int type) {
		return getPersistence().countByType(type);
	}

	/**
	* Returns the marketing event where siteGroupId = &#63; or throws a {@link NoSuchMarketingEventException} if it could not be found.
	*
	* @param siteGroupId the site group ID
	* @return the matching marketing event
	* @throws NoSuchMarketingEventException if a matching marketing event could not be found
	*/
	public static MarketingEvent findBySiteGroupId(long siteGroupId)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventException {
		return getPersistence().findBySiteGroupId(siteGroupId);
	}

	/**
	* Returns the marketing event where siteGroupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param siteGroupId the site group ID
	* @return the matching marketing event, or <code>null</code> if a matching marketing event could not be found
	*/
	public static MarketingEvent fetchBySiteGroupId(long siteGroupId) {
		return getPersistence().fetchBySiteGroupId(siteGroupId);
	}

	/**
	* Returns the marketing event where siteGroupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param siteGroupId the site group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching marketing event, or <code>null</code> if a matching marketing event could not be found
	*/
	public static MarketingEvent fetchBySiteGroupId(long siteGroupId,
		boolean retrieveFromCache) {
		return getPersistence()
				   .fetchBySiteGroupId(siteGroupId, retrieveFromCache);
	}

	/**
	* Removes the marketing event where siteGroupId = &#63; from the database.
	*
	* @param siteGroupId the site group ID
	* @return the marketing event that was removed
	*/
	public static MarketingEvent removeBySiteGroupId(long siteGroupId)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventException {
		return getPersistence().removeBySiteGroupId(siteGroupId);
	}

	/**
	* Returns the number of marketing events where siteGroupId = &#63;.
	*
	* @param siteGroupId the site group ID
	* @return the number of matching marketing events
	*/
	public static int countBySiteGroupId(long siteGroupId) {
		return getPersistence().countBySiteGroupId(siteGroupId);
	}

	/**
	* Returns all the marketing events where globalRegion = &#63;.
	*
	* @param globalRegion the global region
	* @return the matching marketing events
	*/
	public static List<MarketingEvent> findByGlobalRegion(int globalRegion) {
		return getPersistence().findByGlobalRegion(globalRegion);
	}

	/**
	* Returns a range of all the marketing events where globalRegion = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param globalRegion the global region
	* @param start the lower bound of the range of marketing events
	* @param end the upper bound of the range of marketing events (not inclusive)
	* @return the range of matching marketing events
	*/
	public static List<MarketingEvent> findByGlobalRegion(int globalRegion,
		int start, int end) {
		return getPersistence().findByGlobalRegion(globalRegion, start, end);
	}

	/**
	* Returns an ordered range of all the marketing events where globalRegion = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param globalRegion the global region
	* @param start the lower bound of the range of marketing events
	* @param end the upper bound of the range of marketing events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching marketing events
	*/
	public static List<MarketingEvent> findByGlobalRegion(int globalRegion,
		int start, int end, OrderByComparator<MarketingEvent> orderByComparator) {
		return getPersistence()
				   .findByGlobalRegion(globalRegion, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the marketing events where globalRegion = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param globalRegion the global region
	* @param start the lower bound of the range of marketing events
	* @param end the upper bound of the range of marketing events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching marketing events
	*/
	public static List<MarketingEvent> findByGlobalRegion(int globalRegion,
		int start, int end,
		OrderByComparator<MarketingEvent> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByGlobalRegion(globalRegion, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first marketing event in the ordered set where globalRegion = &#63;.
	*
	* @param globalRegion the global region
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event
	* @throws NoSuchMarketingEventException if a matching marketing event could not be found
	*/
	public static MarketingEvent findByGlobalRegion_First(int globalRegion,
		OrderByComparator<MarketingEvent> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventException {
		return getPersistence()
				   .findByGlobalRegion_First(globalRegion, orderByComparator);
	}

	/**
	* Returns the first marketing event in the ordered set where globalRegion = &#63;.
	*
	* @param globalRegion the global region
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event, or <code>null</code> if a matching marketing event could not be found
	*/
	public static MarketingEvent fetchByGlobalRegion_First(int globalRegion,
		OrderByComparator<MarketingEvent> orderByComparator) {
		return getPersistence()
				   .fetchByGlobalRegion_First(globalRegion, orderByComparator);
	}

	/**
	* Returns the last marketing event in the ordered set where globalRegion = &#63;.
	*
	* @param globalRegion the global region
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event
	* @throws NoSuchMarketingEventException if a matching marketing event could not be found
	*/
	public static MarketingEvent findByGlobalRegion_Last(int globalRegion,
		OrderByComparator<MarketingEvent> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventException {
		return getPersistence()
				   .findByGlobalRegion_Last(globalRegion, orderByComparator);
	}

	/**
	* Returns the last marketing event in the ordered set where globalRegion = &#63;.
	*
	* @param globalRegion the global region
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event, or <code>null</code> if a matching marketing event could not be found
	*/
	public static MarketingEvent fetchByGlobalRegion_Last(int globalRegion,
		OrderByComparator<MarketingEvent> orderByComparator) {
		return getPersistence()
				   .fetchByGlobalRegion_Last(globalRegion, orderByComparator);
	}

	/**
	* Returns the marketing events before and after the current marketing event in the ordered set where globalRegion = &#63;.
	*
	* @param marketingEventId the primary key of the current marketing event
	* @param globalRegion the global region
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next marketing event
	* @throws NoSuchMarketingEventException if a marketing event with the primary key could not be found
	*/
	public static MarketingEvent[] findByGlobalRegion_PrevAndNext(
		long marketingEventId, int globalRegion,
		OrderByComparator<MarketingEvent> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventException {
		return getPersistence()
				   .findByGlobalRegion_PrevAndNext(marketingEventId,
			globalRegion, orderByComparator);
	}

	/**
	* Removes all the marketing events where globalRegion = &#63; from the database.
	*
	* @param globalRegion the global region
	*/
	public static void removeByGlobalRegion(int globalRegion) {
		getPersistence().removeByGlobalRegion(globalRegion);
	}

	/**
	* Returns the number of marketing events where globalRegion = &#63;.
	*
	* @param globalRegion the global region
	* @return the number of matching marketing events
	*/
	public static int countByGlobalRegion(int globalRegion) {
		return getPersistence().countByGlobalRegion(globalRegion);
	}

	/**
	* Returns all the marketing events where type = &#63; and startDate &gt; &#63;.
	*
	* @param type the type
	* @param startDate the start date
	* @return the matching marketing events
	*/
	public static List<MarketingEvent> findByT_GtSD(int type, Date startDate) {
		return getPersistence().findByT_GtSD(type, startDate);
	}

	/**
	* Returns a range of all the marketing events where type = &#63; and startDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param type the type
	* @param startDate the start date
	* @param start the lower bound of the range of marketing events
	* @param end the upper bound of the range of marketing events (not inclusive)
	* @return the range of matching marketing events
	*/
	public static List<MarketingEvent> findByT_GtSD(int type, Date startDate,
		int start, int end) {
		return getPersistence().findByT_GtSD(type, startDate, start, end);
	}

	/**
	* Returns an ordered range of all the marketing events where type = &#63; and startDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param type the type
	* @param startDate the start date
	* @param start the lower bound of the range of marketing events
	* @param end the upper bound of the range of marketing events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching marketing events
	*/
	public static List<MarketingEvent> findByT_GtSD(int type, Date startDate,
		int start, int end, OrderByComparator<MarketingEvent> orderByComparator) {
		return getPersistence()
				   .findByT_GtSD(type, startDate, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the marketing events where type = &#63; and startDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param type the type
	* @param startDate the start date
	* @param start the lower bound of the range of marketing events
	* @param end the upper bound of the range of marketing events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching marketing events
	*/
	public static List<MarketingEvent> findByT_GtSD(int type, Date startDate,
		int start, int end,
		OrderByComparator<MarketingEvent> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByT_GtSD(type, startDate, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first marketing event in the ordered set where type = &#63; and startDate &gt; &#63;.
	*
	* @param type the type
	* @param startDate the start date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event
	* @throws NoSuchMarketingEventException if a matching marketing event could not be found
	*/
	public static MarketingEvent findByT_GtSD_First(int type, Date startDate,
		OrderByComparator<MarketingEvent> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventException {
		return getPersistence()
				   .findByT_GtSD_First(type, startDate, orderByComparator);
	}

	/**
	* Returns the first marketing event in the ordered set where type = &#63; and startDate &gt; &#63;.
	*
	* @param type the type
	* @param startDate the start date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event, or <code>null</code> if a matching marketing event could not be found
	*/
	public static MarketingEvent fetchByT_GtSD_First(int type, Date startDate,
		OrderByComparator<MarketingEvent> orderByComparator) {
		return getPersistence()
				   .fetchByT_GtSD_First(type, startDate, orderByComparator);
	}

	/**
	* Returns the last marketing event in the ordered set where type = &#63; and startDate &gt; &#63;.
	*
	* @param type the type
	* @param startDate the start date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event
	* @throws NoSuchMarketingEventException if a matching marketing event could not be found
	*/
	public static MarketingEvent findByT_GtSD_Last(int type, Date startDate,
		OrderByComparator<MarketingEvent> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventException {
		return getPersistence()
				   .findByT_GtSD_Last(type, startDate, orderByComparator);
	}

	/**
	* Returns the last marketing event in the ordered set where type = &#63; and startDate &gt; &#63;.
	*
	* @param type the type
	* @param startDate the start date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event, or <code>null</code> if a matching marketing event could not be found
	*/
	public static MarketingEvent fetchByT_GtSD_Last(int type, Date startDate,
		OrderByComparator<MarketingEvent> orderByComparator) {
		return getPersistence()
				   .fetchByT_GtSD_Last(type, startDate, orderByComparator);
	}

	/**
	* Returns the marketing events before and after the current marketing event in the ordered set where type = &#63; and startDate &gt; &#63;.
	*
	* @param marketingEventId the primary key of the current marketing event
	* @param type the type
	* @param startDate the start date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next marketing event
	* @throws NoSuchMarketingEventException if a marketing event with the primary key could not be found
	*/
	public static MarketingEvent[] findByT_GtSD_PrevAndNext(
		long marketingEventId, int type, Date startDate,
		OrderByComparator<MarketingEvent> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventException {
		return getPersistence()
				   .findByT_GtSD_PrevAndNext(marketingEventId, type, startDate,
			orderByComparator);
	}

	/**
	* Removes all the marketing events where type = &#63; and startDate &gt; &#63; from the database.
	*
	* @param type the type
	* @param startDate the start date
	*/
	public static void removeByT_GtSD(int type, Date startDate) {
		getPersistence().removeByT_GtSD(type, startDate);
	}

	/**
	* Returns the number of marketing events where type = &#63; and startDate &gt; &#63;.
	*
	* @param type the type
	* @param startDate the start date
	* @return the number of matching marketing events
	*/
	public static int countByT_GtSD(int type, Date startDate) {
		return getPersistence().countByT_GtSD(type, startDate);
	}

	/**
	* Caches the marketing event in the entity cache if it is enabled.
	*
	* @param marketingEvent the marketing event
	*/
	public static void cacheResult(MarketingEvent marketingEvent) {
		getPersistence().cacheResult(marketingEvent);
	}

	/**
	* Caches the marketing events in the entity cache if it is enabled.
	*
	* @param marketingEvents the marketing events
	*/
	public static void cacheResult(List<MarketingEvent> marketingEvents) {
		getPersistence().cacheResult(marketingEvents);
	}

	/**
	* Creates a new marketing event with the primary key. Does not add the marketing event to the database.
	*
	* @param marketingEventId the primary key for the new marketing event
	* @return the new marketing event
	*/
	public static MarketingEvent create(long marketingEventId) {
		return getPersistence().create(marketingEventId);
	}

	/**
	* Removes the marketing event with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEventId the primary key of the marketing event
	* @return the marketing event that was removed
	* @throws NoSuchMarketingEventException if a marketing event with the primary key could not be found
	*/
	public static MarketingEvent remove(long marketingEventId)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventException {
		return getPersistence().remove(marketingEventId);
	}

	public static MarketingEvent updateImpl(MarketingEvent marketingEvent) {
		return getPersistence().updateImpl(marketingEvent);
	}

	/**
	* Returns the marketing event with the primary key or throws a {@link NoSuchMarketingEventException} if it could not be found.
	*
	* @param marketingEventId the primary key of the marketing event
	* @return the marketing event
	* @throws NoSuchMarketingEventException if a marketing event with the primary key could not be found
	*/
	public static MarketingEvent findByPrimaryKey(long marketingEventId)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventException {
		return getPersistence().findByPrimaryKey(marketingEventId);
	}

	/**
	* Returns the marketing event with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param marketingEventId the primary key of the marketing event
	* @return the marketing event, or <code>null</code> if a marketing event with the primary key could not be found
	*/
	public static MarketingEvent fetchByPrimaryKey(long marketingEventId) {
		return getPersistence().fetchByPrimaryKey(marketingEventId);
	}

	public static java.util.Map<java.io.Serializable, MarketingEvent> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the marketing events.
	*
	* @return the marketing events
	*/
	public static List<MarketingEvent> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the marketing events.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of marketing events
	* @param end the upper bound of the range of marketing events (not inclusive)
	* @return the range of marketing events
	*/
	public static List<MarketingEvent> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the marketing events.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of marketing events
	* @param end the upper bound of the range of marketing events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of marketing events
	*/
	public static List<MarketingEvent> findAll(int start, int end,
		OrderByComparator<MarketingEvent> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the marketing events.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of marketing events
	* @param end the upper bound of the range of marketing events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of marketing events
	*/
	public static List<MarketingEvent> findAll(int start, int end,
		OrderByComparator<MarketingEvent> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the marketing events from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of marketing events.
	*
	* @return the number of marketing events
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static MarketingEventPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<MarketingEventPersistence, MarketingEventPersistence> _serviceTracker =
		ServiceTrackerFactory.open(MarketingEventPersistence.class);
}