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

import com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventException;
import com.liferay.osb.www.marketing.events.model.MarketingEvent;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Date;

/**
 * The persistence interface for the marketing event service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.osb.www.marketing.events.service.persistence.impl.MarketingEventPersistenceImpl
 * @see MarketingEventUtil
 * @generated
 */
@ProviderType
public interface MarketingEventPersistence extends BasePersistence<MarketingEvent> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MarketingEventUtil} to access the marketing event persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the marketing events where type = &#63;.
	*
	* @param type the type
	* @return the matching marketing events
	*/
	public java.util.List<MarketingEvent> findByType(int type);

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
	public java.util.List<MarketingEvent> findByType(int type, int start,
		int end);

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
	public java.util.List<MarketingEvent> findByType(int type, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEvent> orderByComparator);

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
	public java.util.List<MarketingEvent> findByType(int type, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEvent> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first marketing event in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event
	* @throws NoSuchMarketingEventException if a matching marketing event could not be found
	*/
	public MarketingEvent findByType_First(int type,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEvent> orderByComparator)
		throws NoSuchMarketingEventException;

	/**
	* Returns the first marketing event in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event, or <code>null</code> if a matching marketing event could not be found
	*/
	public MarketingEvent fetchByType_First(int type,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEvent> orderByComparator);

	/**
	* Returns the last marketing event in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event
	* @throws NoSuchMarketingEventException if a matching marketing event could not be found
	*/
	public MarketingEvent findByType_Last(int type,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEvent> orderByComparator)
		throws NoSuchMarketingEventException;

	/**
	* Returns the last marketing event in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event, or <code>null</code> if a matching marketing event could not be found
	*/
	public MarketingEvent fetchByType_Last(int type,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEvent> orderByComparator);

	/**
	* Returns the marketing events before and after the current marketing event in the ordered set where type = &#63;.
	*
	* @param marketingEventId the primary key of the current marketing event
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next marketing event
	* @throws NoSuchMarketingEventException if a marketing event with the primary key could not be found
	*/
	public MarketingEvent[] findByType_PrevAndNext(long marketingEventId,
		int type,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEvent> orderByComparator)
		throws NoSuchMarketingEventException;

	/**
	* Removes all the marketing events where type = &#63; from the database.
	*
	* @param type the type
	*/
	public void removeByType(int type);

	/**
	* Returns the number of marketing events where type = &#63;.
	*
	* @param type the type
	* @return the number of matching marketing events
	*/
	public int countByType(int type);

	/**
	* Returns the marketing event where siteGroupId = &#63; or throws a {@link NoSuchMarketingEventException} if it could not be found.
	*
	* @param siteGroupId the site group ID
	* @return the matching marketing event
	* @throws NoSuchMarketingEventException if a matching marketing event could not be found
	*/
	public MarketingEvent findBySiteGroupId(long siteGroupId)
		throws NoSuchMarketingEventException;

	/**
	* Returns the marketing event where siteGroupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param siteGroupId the site group ID
	* @return the matching marketing event, or <code>null</code> if a matching marketing event could not be found
	*/
	public MarketingEvent fetchBySiteGroupId(long siteGroupId);

	/**
	* Returns the marketing event where siteGroupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param siteGroupId the site group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching marketing event, or <code>null</code> if a matching marketing event could not be found
	*/
	public MarketingEvent fetchBySiteGroupId(long siteGroupId,
		boolean retrieveFromCache);

	/**
	* Removes the marketing event where siteGroupId = &#63; from the database.
	*
	* @param siteGroupId the site group ID
	* @return the marketing event that was removed
	*/
	public MarketingEvent removeBySiteGroupId(long siteGroupId)
		throws NoSuchMarketingEventException;

	/**
	* Returns the number of marketing events where siteGroupId = &#63;.
	*
	* @param siteGroupId the site group ID
	* @return the number of matching marketing events
	*/
	public int countBySiteGroupId(long siteGroupId);

	/**
	* Returns all the marketing events where globalRegion = &#63;.
	*
	* @param globalRegion the global region
	* @return the matching marketing events
	*/
	public java.util.List<MarketingEvent> findByGlobalRegion(int globalRegion);

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
	public java.util.List<MarketingEvent> findByGlobalRegion(int globalRegion,
		int start, int end);

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
	public java.util.List<MarketingEvent> findByGlobalRegion(int globalRegion,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEvent> orderByComparator);

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
	public java.util.List<MarketingEvent> findByGlobalRegion(int globalRegion,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEvent> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first marketing event in the ordered set where globalRegion = &#63;.
	*
	* @param globalRegion the global region
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event
	* @throws NoSuchMarketingEventException if a matching marketing event could not be found
	*/
	public MarketingEvent findByGlobalRegion_First(int globalRegion,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEvent> orderByComparator)
		throws NoSuchMarketingEventException;

	/**
	* Returns the first marketing event in the ordered set where globalRegion = &#63;.
	*
	* @param globalRegion the global region
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event, or <code>null</code> if a matching marketing event could not be found
	*/
	public MarketingEvent fetchByGlobalRegion_First(int globalRegion,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEvent> orderByComparator);

	/**
	* Returns the last marketing event in the ordered set where globalRegion = &#63;.
	*
	* @param globalRegion the global region
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event
	* @throws NoSuchMarketingEventException if a matching marketing event could not be found
	*/
	public MarketingEvent findByGlobalRegion_Last(int globalRegion,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEvent> orderByComparator)
		throws NoSuchMarketingEventException;

	/**
	* Returns the last marketing event in the ordered set where globalRegion = &#63;.
	*
	* @param globalRegion the global region
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event, or <code>null</code> if a matching marketing event could not be found
	*/
	public MarketingEvent fetchByGlobalRegion_Last(int globalRegion,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEvent> orderByComparator);

	/**
	* Returns the marketing events before and after the current marketing event in the ordered set where globalRegion = &#63;.
	*
	* @param marketingEventId the primary key of the current marketing event
	* @param globalRegion the global region
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next marketing event
	* @throws NoSuchMarketingEventException if a marketing event with the primary key could not be found
	*/
	public MarketingEvent[] findByGlobalRegion_PrevAndNext(
		long marketingEventId, int globalRegion,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEvent> orderByComparator)
		throws NoSuchMarketingEventException;

	/**
	* Removes all the marketing events where globalRegion = &#63; from the database.
	*
	* @param globalRegion the global region
	*/
	public void removeByGlobalRegion(int globalRegion);

	/**
	* Returns the number of marketing events where globalRegion = &#63;.
	*
	* @param globalRegion the global region
	* @return the number of matching marketing events
	*/
	public int countByGlobalRegion(int globalRegion);

	/**
	* Returns all the marketing events where type = &#63; and startDate &gt; &#63;.
	*
	* @param type the type
	* @param startDate the start date
	* @return the matching marketing events
	*/
	public java.util.List<MarketingEvent> findByT_GtSD(int type, Date startDate);

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
	public java.util.List<MarketingEvent> findByT_GtSD(int type,
		Date startDate, int start, int end);

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
	public java.util.List<MarketingEvent> findByT_GtSD(int type,
		Date startDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEvent> orderByComparator);

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
	public java.util.List<MarketingEvent> findByT_GtSD(int type,
		Date startDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEvent> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first marketing event in the ordered set where type = &#63; and startDate &gt; &#63;.
	*
	* @param type the type
	* @param startDate the start date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event
	* @throws NoSuchMarketingEventException if a matching marketing event could not be found
	*/
	public MarketingEvent findByT_GtSD_First(int type, Date startDate,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEvent> orderByComparator)
		throws NoSuchMarketingEventException;

	/**
	* Returns the first marketing event in the ordered set where type = &#63; and startDate &gt; &#63;.
	*
	* @param type the type
	* @param startDate the start date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event, or <code>null</code> if a matching marketing event could not be found
	*/
	public MarketingEvent fetchByT_GtSD_First(int type, Date startDate,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEvent> orderByComparator);

	/**
	* Returns the last marketing event in the ordered set where type = &#63; and startDate &gt; &#63;.
	*
	* @param type the type
	* @param startDate the start date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event
	* @throws NoSuchMarketingEventException if a matching marketing event could not be found
	*/
	public MarketingEvent findByT_GtSD_Last(int type, Date startDate,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEvent> orderByComparator)
		throws NoSuchMarketingEventException;

	/**
	* Returns the last marketing event in the ordered set where type = &#63; and startDate &gt; &#63;.
	*
	* @param type the type
	* @param startDate the start date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event, or <code>null</code> if a matching marketing event could not be found
	*/
	public MarketingEvent fetchByT_GtSD_Last(int type, Date startDate,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEvent> orderByComparator);

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
	public MarketingEvent[] findByT_GtSD_PrevAndNext(long marketingEventId,
		int type, Date startDate,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEvent> orderByComparator)
		throws NoSuchMarketingEventException;

	/**
	* Removes all the marketing events where type = &#63; and startDate &gt; &#63; from the database.
	*
	* @param type the type
	* @param startDate the start date
	*/
	public void removeByT_GtSD(int type, Date startDate);

	/**
	* Returns the number of marketing events where type = &#63; and startDate &gt; &#63;.
	*
	* @param type the type
	* @param startDate the start date
	* @return the number of matching marketing events
	*/
	public int countByT_GtSD(int type, Date startDate);

	/**
	* Caches the marketing event in the entity cache if it is enabled.
	*
	* @param marketingEvent the marketing event
	*/
	public void cacheResult(MarketingEvent marketingEvent);

	/**
	* Caches the marketing events in the entity cache if it is enabled.
	*
	* @param marketingEvents the marketing events
	*/
	public void cacheResult(java.util.List<MarketingEvent> marketingEvents);

	/**
	* Creates a new marketing event with the primary key. Does not add the marketing event to the database.
	*
	* @param marketingEventId the primary key for the new marketing event
	* @return the new marketing event
	*/
	public MarketingEvent create(long marketingEventId);

	/**
	* Removes the marketing event with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEventId the primary key of the marketing event
	* @return the marketing event that was removed
	* @throws NoSuchMarketingEventException if a marketing event with the primary key could not be found
	*/
	public MarketingEvent remove(long marketingEventId)
		throws NoSuchMarketingEventException;

	public MarketingEvent updateImpl(MarketingEvent marketingEvent);

	/**
	* Returns the marketing event with the primary key or throws a {@link NoSuchMarketingEventException} if it could not be found.
	*
	* @param marketingEventId the primary key of the marketing event
	* @return the marketing event
	* @throws NoSuchMarketingEventException if a marketing event with the primary key could not be found
	*/
	public MarketingEvent findByPrimaryKey(long marketingEventId)
		throws NoSuchMarketingEventException;

	/**
	* Returns the marketing event with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param marketingEventId the primary key of the marketing event
	* @return the marketing event, or <code>null</code> if a marketing event with the primary key could not be found
	*/
	public MarketingEvent fetchByPrimaryKey(long marketingEventId);

	@Override
	public java.util.Map<java.io.Serializable, MarketingEvent> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the marketing events.
	*
	* @return the marketing events
	*/
	public java.util.List<MarketingEvent> findAll();

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
	public java.util.List<MarketingEvent> findAll(int start, int end);

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
	public java.util.List<MarketingEvent> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEvent> orderByComparator);

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
	public java.util.List<MarketingEvent> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEvent> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the marketing events from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of marketing events.
	*
	* @return the number of marketing events
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}