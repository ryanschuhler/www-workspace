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

import com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventSessionRoomException;
import com.liferay.osb.www.marketing.events.model.MarketingEventSessionRoom;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the marketing event session room service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.osb.www.marketing.events.service.persistence.impl.MarketingEventSessionRoomPersistenceImpl
 * @see MarketingEventSessionRoomUtil
 * @generated
 */
@ProviderType
public interface MarketingEventSessionRoomPersistence extends BasePersistence<MarketingEventSessionRoom> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MarketingEventSessionRoomUtil} to access the marketing event session room persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the marketing event session rooms where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @return the matching marketing event session rooms
	*/
	public java.util.List<MarketingEventSessionRoom> findByMarketingEventId(
		long marketingEventId);

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
	public java.util.List<MarketingEventSessionRoom> findByMarketingEventId(
		long marketingEventId, int start, int end);

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
	public java.util.List<MarketingEventSessionRoom> findByMarketingEventId(
		long marketingEventId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSessionRoom> orderByComparator);

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
	public java.util.List<MarketingEventSessionRoom> findByMarketingEventId(
		long marketingEventId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSessionRoom> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first marketing event session room in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event session room
	* @throws NoSuchMarketingEventSessionRoomException if a matching marketing event session room could not be found
	*/
	public MarketingEventSessionRoom findByMarketingEventId_First(
		long marketingEventId,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSessionRoom> orderByComparator)
		throws NoSuchMarketingEventSessionRoomException;

	/**
	* Returns the first marketing event session room in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event session room, or <code>null</code> if a matching marketing event session room could not be found
	*/
	public MarketingEventSessionRoom fetchByMarketingEventId_First(
		long marketingEventId,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSessionRoom> orderByComparator);

	/**
	* Returns the last marketing event session room in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event session room
	* @throws NoSuchMarketingEventSessionRoomException if a matching marketing event session room could not be found
	*/
	public MarketingEventSessionRoom findByMarketingEventId_Last(
		long marketingEventId,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSessionRoom> orderByComparator)
		throws NoSuchMarketingEventSessionRoomException;

	/**
	* Returns the last marketing event session room in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event session room, or <code>null</code> if a matching marketing event session room could not be found
	*/
	public MarketingEventSessionRoom fetchByMarketingEventId_Last(
		long marketingEventId,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSessionRoom> orderByComparator);

	/**
	* Returns the marketing event session rooms before and after the current marketing event session room in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventSessionRoomId the primary key of the current marketing event session room
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next marketing event session room
	* @throws NoSuchMarketingEventSessionRoomException if a marketing event session room with the primary key could not be found
	*/
	public MarketingEventSessionRoom[] findByMarketingEventId_PrevAndNext(
		long marketingEventSessionRoomId, long marketingEventId,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSessionRoom> orderByComparator)
		throws NoSuchMarketingEventSessionRoomException;

	/**
	* Removes all the marketing event session rooms where marketingEventId = &#63; from the database.
	*
	* @param marketingEventId the marketing event ID
	*/
	public void removeByMarketingEventId(long marketingEventId);

	/**
	* Returns the number of marketing event session rooms where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @return the number of matching marketing event session rooms
	*/
	public int countByMarketingEventId(long marketingEventId);

	/**
	* Caches the marketing event session room in the entity cache if it is enabled.
	*
	* @param marketingEventSessionRoom the marketing event session room
	*/
	public void cacheResult(MarketingEventSessionRoom marketingEventSessionRoom);

	/**
	* Caches the marketing event session rooms in the entity cache if it is enabled.
	*
	* @param marketingEventSessionRooms the marketing event session rooms
	*/
	public void cacheResult(
		java.util.List<MarketingEventSessionRoom> marketingEventSessionRooms);

	/**
	* Creates a new marketing event session room with the primary key. Does not add the marketing event session room to the database.
	*
	* @param marketingEventSessionRoomId the primary key for the new marketing event session room
	* @return the new marketing event session room
	*/
	public MarketingEventSessionRoom create(long marketingEventSessionRoomId);

	/**
	* Removes the marketing event session room with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEventSessionRoomId the primary key of the marketing event session room
	* @return the marketing event session room that was removed
	* @throws NoSuchMarketingEventSessionRoomException if a marketing event session room with the primary key could not be found
	*/
	public MarketingEventSessionRoom remove(long marketingEventSessionRoomId)
		throws NoSuchMarketingEventSessionRoomException;

	public MarketingEventSessionRoom updateImpl(
		MarketingEventSessionRoom marketingEventSessionRoom);

	/**
	* Returns the marketing event session room with the primary key or throws a {@link NoSuchMarketingEventSessionRoomException} if it could not be found.
	*
	* @param marketingEventSessionRoomId the primary key of the marketing event session room
	* @return the marketing event session room
	* @throws NoSuchMarketingEventSessionRoomException if a marketing event session room with the primary key could not be found
	*/
	public MarketingEventSessionRoom findByPrimaryKey(
		long marketingEventSessionRoomId)
		throws NoSuchMarketingEventSessionRoomException;

	/**
	* Returns the marketing event session room with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param marketingEventSessionRoomId the primary key of the marketing event session room
	* @return the marketing event session room, or <code>null</code> if a marketing event session room with the primary key could not be found
	*/
	public MarketingEventSessionRoom fetchByPrimaryKey(
		long marketingEventSessionRoomId);

	@Override
	public java.util.Map<java.io.Serializable, MarketingEventSessionRoom> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the marketing event session rooms.
	*
	* @return the marketing event session rooms
	*/
	public java.util.List<MarketingEventSessionRoom> findAll();

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
	public java.util.List<MarketingEventSessionRoom> findAll(int start, int end);

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
	public java.util.List<MarketingEventSessionRoom> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSessionRoom> orderByComparator);

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
	public java.util.List<MarketingEventSessionRoom> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSessionRoom> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the marketing event session rooms from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of marketing event session rooms.
	*
	* @return the number of marketing event session rooms
	*/
	public int countAll();
}