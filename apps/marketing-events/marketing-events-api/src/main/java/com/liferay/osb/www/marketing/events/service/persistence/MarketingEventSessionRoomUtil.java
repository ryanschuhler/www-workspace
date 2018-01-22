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

import com.liferay.osb.www.marketing.events.model.MarketingEventSessionRoom;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the marketing event session room service. This utility wraps {@link com.liferay.osb.www.marketing.events.service.persistence.impl.MarketingEventSessionRoomPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEventSessionRoomPersistence
 * @see com.liferay.osb.www.marketing.events.service.persistence.impl.MarketingEventSessionRoomPersistenceImpl
 * @generated
 */
@ProviderType
public class MarketingEventSessionRoomUtil {
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
	public static void clearCache(
		MarketingEventSessionRoom marketingEventSessionRoom) {
		getPersistence().clearCache(marketingEventSessionRoom);
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
	public static List<MarketingEventSessionRoom> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MarketingEventSessionRoom> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MarketingEventSessionRoom> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MarketingEventSessionRoom> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MarketingEventSessionRoom update(
		MarketingEventSessionRoom marketingEventSessionRoom) {
		return getPersistence().update(marketingEventSessionRoom);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MarketingEventSessionRoom update(
		MarketingEventSessionRoom marketingEventSessionRoom,
		ServiceContext serviceContext) {
		return getPersistence().update(marketingEventSessionRoom, serviceContext);
	}

	/**
	* Returns all the marketing event session rooms where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @return the matching marketing event session rooms
	*/
	public static List<MarketingEventSessionRoom> findByMarketingEventId(
		long marketingEventId) {
		return getPersistence().findByMarketingEventId(marketingEventId);
	}

	/**
	* Returns a range of all the marketing event session rooms where marketingEventId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSessionRoomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param marketingEventId the marketing event ID
	* @param start the lower bound of the range of marketing event session rooms
	* @param end the upper bound of the range of marketing event session rooms (not inclusive)
	* @return the range of matching marketing event session rooms
	*/
	public static List<MarketingEventSessionRoom> findByMarketingEventId(
		long marketingEventId, int start, int end) {
		return getPersistence()
				   .findByMarketingEventId(marketingEventId, start, end);
	}

	/**
	* Returns an ordered range of all the marketing event session rooms where marketingEventId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSessionRoomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param marketingEventId the marketing event ID
	* @param start the lower bound of the range of marketing event session rooms
	* @param end the upper bound of the range of marketing event session rooms (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching marketing event session rooms
	*/
	public static List<MarketingEventSessionRoom> findByMarketingEventId(
		long marketingEventId, int start, int end,
		OrderByComparator<MarketingEventSessionRoom> orderByComparator) {
		return getPersistence()
				   .findByMarketingEventId(marketingEventId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the marketing event session rooms where marketingEventId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSessionRoomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param marketingEventId the marketing event ID
	* @param start the lower bound of the range of marketing event session rooms
	* @param end the upper bound of the range of marketing event session rooms (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching marketing event session rooms
	*/
	public static List<MarketingEventSessionRoom> findByMarketingEventId(
		long marketingEventId, int start, int end,
		OrderByComparator<MarketingEventSessionRoom> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByMarketingEventId(marketingEventId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first marketing event session room in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event session room
	* @throws NoSuchMarketingEventSessionRoomException if a matching marketing event session room could not be found
	*/
	public static MarketingEventSessionRoom findByMarketingEventId_First(
		long marketingEventId,
		OrderByComparator<MarketingEventSessionRoom> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventSessionRoomException {
		return getPersistence()
				   .findByMarketingEventId_First(marketingEventId,
			orderByComparator);
	}

	/**
	* Returns the first marketing event session room in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event session room, or <code>null</code> if a matching marketing event session room could not be found
	*/
	public static MarketingEventSessionRoom fetchByMarketingEventId_First(
		long marketingEventId,
		OrderByComparator<MarketingEventSessionRoom> orderByComparator) {
		return getPersistence()
				   .fetchByMarketingEventId_First(marketingEventId,
			orderByComparator);
	}

	/**
	* Returns the last marketing event session room in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event session room
	* @throws NoSuchMarketingEventSessionRoomException if a matching marketing event session room could not be found
	*/
	public static MarketingEventSessionRoom findByMarketingEventId_Last(
		long marketingEventId,
		OrderByComparator<MarketingEventSessionRoom> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventSessionRoomException {
		return getPersistence()
				   .findByMarketingEventId_Last(marketingEventId,
			orderByComparator);
	}

	/**
	* Returns the last marketing event session room in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event session room, or <code>null</code> if a matching marketing event session room could not be found
	*/
	public static MarketingEventSessionRoom fetchByMarketingEventId_Last(
		long marketingEventId,
		OrderByComparator<MarketingEventSessionRoom> orderByComparator) {
		return getPersistence()
				   .fetchByMarketingEventId_Last(marketingEventId,
			orderByComparator);
	}

	/**
	* Returns the marketing event session rooms before and after the current marketing event session room in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventSessionRoomId the primary key of the current marketing event session room
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next marketing event session room
	* @throws NoSuchMarketingEventSessionRoomException if a marketing event session room with the primary key could not be found
	*/
	public static MarketingEventSessionRoom[] findByMarketingEventId_PrevAndNext(
		long marketingEventSessionRoomId, long marketingEventId,
		OrderByComparator<MarketingEventSessionRoom> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventSessionRoomException {
		return getPersistence()
				   .findByMarketingEventId_PrevAndNext(marketingEventSessionRoomId,
			marketingEventId, orderByComparator);
	}

	/**
	* Removes all the marketing event session rooms where marketingEventId = &#63; from the database.
	*
	* @param marketingEventId the marketing event ID
	*/
	public static void removeByMarketingEventId(long marketingEventId) {
		getPersistence().removeByMarketingEventId(marketingEventId);
	}

	/**
	* Returns the number of marketing event session rooms where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @return the number of matching marketing event session rooms
	*/
	public static int countByMarketingEventId(long marketingEventId) {
		return getPersistence().countByMarketingEventId(marketingEventId);
	}

	/**
	* Caches the marketing event session room in the entity cache if it is enabled.
	*
	* @param marketingEventSessionRoom the marketing event session room
	*/
	public static void cacheResult(
		MarketingEventSessionRoom marketingEventSessionRoom) {
		getPersistence().cacheResult(marketingEventSessionRoom);
	}

	/**
	* Caches the marketing event session rooms in the entity cache if it is enabled.
	*
	* @param marketingEventSessionRooms the marketing event session rooms
	*/
	public static void cacheResult(
		List<MarketingEventSessionRoom> marketingEventSessionRooms) {
		getPersistence().cacheResult(marketingEventSessionRooms);
	}

	/**
	* Creates a new marketing event session room with the primary key. Does not add the marketing event session room to the database.
	*
	* @param marketingEventSessionRoomId the primary key for the new marketing event session room
	* @return the new marketing event session room
	*/
	public static MarketingEventSessionRoom create(
		long marketingEventSessionRoomId) {
		return getPersistence().create(marketingEventSessionRoomId);
	}

	/**
	* Removes the marketing event session room with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEventSessionRoomId the primary key of the marketing event session room
	* @return the marketing event session room that was removed
	* @throws NoSuchMarketingEventSessionRoomException if a marketing event session room with the primary key could not be found
	*/
	public static MarketingEventSessionRoom remove(
		long marketingEventSessionRoomId)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventSessionRoomException {
		return getPersistence().remove(marketingEventSessionRoomId);
	}

	public static MarketingEventSessionRoom updateImpl(
		MarketingEventSessionRoom marketingEventSessionRoom) {
		return getPersistence().updateImpl(marketingEventSessionRoom);
	}

	/**
	* Returns the marketing event session room with the primary key or throws a {@link NoSuchMarketingEventSessionRoomException} if it could not be found.
	*
	* @param marketingEventSessionRoomId the primary key of the marketing event session room
	* @return the marketing event session room
	* @throws NoSuchMarketingEventSessionRoomException if a marketing event session room with the primary key could not be found
	*/
	public static MarketingEventSessionRoom findByPrimaryKey(
		long marketingEventSessionRoomId)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventSessionRoomException {
		return getPersistence().findByPrimaryKey(marketingEventSessionRoomId);
	}

	/**
	* Returns the marketing event session room with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param marketingEventSessionRoomId the primary key of the marketing event session room
	* @return the marketing event session room, or <code>null</code> if a marketing event session room with the primary key could not be found
	*/
	public static MarketingEventSessionRoom fetchByPrimaryKey(
		long marketingEventSessionRoomId) {
		return getPersistence().fetchByPrimaryKey(marketingEventSessionRoomId);
	}

	public static java.util.Map<java.io.Serializable, MarketingEventSessionRoom> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the marketing event session rooms.
	*
	* @return the marketing event session rooms
	*/
	public static List<MarketingEventSessionRoom> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the marketing event session rooms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSessionRoomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of marketing event session rooms
	* @param end the upper bound of the range of marketing event session rooms (not inclusive)
	* @return the range of marketing event session rooms
	*/
	public static List<MarketingEventSessionRoom> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the marketing event session rooms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSessionRoomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of marketing event session rooms
	* @param end the upper bound of the range of marketing event session rooms (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of marketing event session rooms
	*/
	public static List<MarketingEventSessionRoom> findAll(int start, int end,
		OrderByComparator<MarketingEventSessionRoom> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the marketing event session rooms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSessionRoomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of marketing event session rooms
	* @param end the upper bound of the range of marketing event session rooms (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of marketing event session rooms
	*/
	public static List<MarketingEventSessionRoom> findAll(int start, int end,
		OrderByComparator<MarketingEventSessionRoom> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the marketing event session rooms from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of marketing event session rooms.
	*
	* @return the number of marketing event session rooms
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MarketingEventSessionRoomPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<MarketingEventSessionRoomPersistence, MarketingEventSessionRoomPersistence> _serviceTracker =
		ServiceTrackerFactory.open(MarketingEventSessionRoomPersistence.class);
}