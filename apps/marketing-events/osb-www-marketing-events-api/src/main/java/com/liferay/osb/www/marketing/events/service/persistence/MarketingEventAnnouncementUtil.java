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

import com.liferay.osb.www.marketing.events.model.MarketingEventAnnouncement;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.Date;
import java.util.List;

/**
 * The persistence utility for the marketing event announcement service. This utility wraps {@link com.liferay.osb.www.marketing.events.service.persistence.impl.MarketingEventAnnouncementPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEventAnnouncementPersistence
 * @see com.liferay.osb.www.marketing.events.service.persistence.impl.MarketingEventAnnouncementPersistenceImpl
 * @generated
 */
@ProviderType
public class MarketingEventAnnouncementUtil {
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
		MarketingEventAnnouncement marketingEventAnnouncement) {
		getPersistence().clearCache(marketingEventAnnouncement);
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
	public static List<MarketingEventAnnouncement> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MarketingEventAnnouncement> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MarketingEventAnnouncement> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MarketingEventAnnouncement> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MarketingEventAnnouncement update(
		MarketingEventAnnouncement marketingEventAnnouncement) {
		return getPersistence().update(marketingEventAnnouncement);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MarketingEventAnnouncement update(
		MarketingEventAnnouncement marketingEventAnnouncement,
		ServiceContext serviceContext) {
		return getPersistence()
				   .update(marketingEventAnnouncement, serviceContext);
	}

	/**
	* Returns all the marketing event announcements where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching marketing event announcements
	*/
	public static List<MarketingEventAnnouncement> findByUuid(
		java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the marketing event announcements where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventAnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of marketing event announcements
	* @param end the upper bound of the range of marketing event announcements (not inclusive)
	* @return the range of matching marketing event announcements
	*/
	public static List<MarketingEventAnnouncement> findByUuid(
		java.lang.String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the marketing event announcements where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventAnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of marketing event announcements
	* @param end the upper bound of the range of marketing event announcements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching marketing event announcements
	*/
	public static List<MarketingEventAnnouncement> findByUuid(
		java.lang.String uuid, int start, int end,
		OrderByComparator<MarketingEventAnnouncement> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the marketing event announcements where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventAnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of marketing event announcements
	* @param end the upper bound of the range of marketing event announcements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching marketing event announcements
	*/
	public static List<MarketingEventAnnouncement> findByUuid(
		java.lang.String uuid, int start, int end,
		OrderByComparator<MarketingEventAnnouncement> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first marketing event announcement in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event announcement
	* @throws NoSuchMarketingEventAnnouncementException if a matching marketing event announcement could not be found
	*/
	public static MarketingEventAnnouncement findByUuid_First(
		java.lang.String uuid,
		OrderByComparator<MarketingEventAnnouncement> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventAnnouncementException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first marketing event announcement in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event announcement, or <code>null</code> if a matching marketing event announcement could not be found
	*/
	public static MarketingEventAnnouncement fetchByUuid_First(
		java.lang.String uuid,
		OrderByComparator<MarketingEventAnnouncement> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last marketing event announcement in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event announcement
	* @throws NoSuchMarketingEventAnnouncementException if a matching marketing event announcement could not be found
	*/
	public static MarketingEventAnnouncement findByUuid_Last(
		java.lang.String uuid,
		OrderByComparator<MarketingEventAnnouncement> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventAnnouncementException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last marketing event announcement in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event announcement, or <code>null</code> if a matching marketing event announcement could not be found
	*/
	public static MarketingEventAnnouncement fetchByUuid_Last(
		java.lang.String uuid,
		OrderByComparator<MarketingEventAnnouncement> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the marketing event announcements before and after the current marketing event announcement in the ordered set where uuid = &#63;.
	*
	* @param marketingEventAnnouncementId the primary key of the current marketing event announcement
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next marketing event announcement
	* @throws NoSuchMarketingEventAnnouncementException if a marketing event announcement with the primary key could not be found
	*/
	public static MarketingEventAnnouncement[] findByUuid_PrevAndNext(
		long marketingEventAnnouncementId, java.lang.String uuid,
		OrderByComparator<MarketingEventAnnouncement> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventAnnouncementException {
		return getPersistence()
				   .findByUuid_PrevAndNext(marketingEventAnnouncementId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the marketing event announcements where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of marketing event announcements where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching marketing event announcements
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns all the marketing event announcements where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @return the matching marketing event announcements
	*/
	public static List<MarketingEventAnnouncement> findByMarketingEventId(
		long marketingEventId) {
		return getPersistence().findByMarketingEventId(marketingEventId);
	}

	/**
	* Returns a range of all the marketing event announcements where marketingEventId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventAnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param marketingEventId the marketing event ID
	* @param start the lower bound of the range of marketing event announcements
	* @param end the upper bound of the range of marketing event announcements (not inclusive)
	* @return the range of matching marketing event announcements
	*/
	public static List<MarketingEventAnnouncement> findByMarketingEventId(
		long marketingEventId, int start, int end) {
		return getPersistence()
				   .findByMarketingEventId(marketingEventId, start, end);
	}

	/**
	* Returns an ordered range of all the marketing event announcements where marketingEventId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventAnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param marketingEventId the marketing event ID
	* @param start the lower bound of the range of marketing event announcements
	* @param end the upper bound of the range of marketing event announcements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching marketing event announcements
	*/
	public static List<MarketingEventAnnouncement> findByMarketingEventId(
		long marketingEventId, int start, int end,
		OrderByComparator<MarketingEventAnnouncement> orderByComparator) {
		return getPersistence()
				   .findByMarketingEventId(marketingEventId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the marketing event announcements where marketingEventId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventAnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param marketingEventId the marketing event ID
	* @param start the lower bound of the range of marketing event announcements
	* @param end the upper bound of the range of marketing event announcements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching marketing event announcements
	*/
	public static List<MarketingEventAnnouncement> findByMarketingEventId(
		long marketingEventId, int start, int end,
		OrderByComparator<MarketingEventAnnouncement> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByMarketingEventId(marketingEventId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first marketing event announcement in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event announcement
	* @throws NoSuchMarketingEventAnnouncementException if a matching marketing event announcement could not be found
	*/
	public static MarketingEventAnnouncement findByMarketingEventId_First(
		long marketingEventId,
		OrderByComparator<MarketingEventAnnouncement> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventAnnouncementException {
		return getPersistence()
				   .findByMarketingEventId_First(marketingEventId,
			orderByComparator);
	}

	/**
	* Returns the first marketing event announcement in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event announcement, or <code>null</code> if a matching marketing event announcement could not be found
	*/
	public static MarketingEventAnnouncement fetchByMarketingEventId_First(
		long marketingEventId,
		OrderByComparator<MarketingEventAnnouncement> orderByComparator) {
		return getPersistence()
				   .fetchByMarketingEventId_First(marketingEventId,
			orderByComparator);
	}

	/**
	* Returns the last marketing event announcement in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event announcement
	* @throws NoSuchMarketingEventAnnouncementException if a matching marketing event announcement could not be found
	*/
	public static MarketingEventAnnouncement findByMarketingEventId_Last(
		long marketingEventId,
		OrderByComparator<MarketingEventAnnouncement> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventAnnouncementException {
		return getPersistence()
				   .findByMarketingEventId_Last(marketingEventId,
			orderByComparator);
	}

	/**
	* Returns the last marketing event announcement in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event announcement, or <code>null</code> if a matching marketing event announcement could not be found
	*/
	public static MarketingEventAnnouncement fetchByMarketingEventId_Last(
		long marketingEventId,
		OrderByComparator<MarketingEventAnnouncement> orderByComparator) {
		return getPersistence()
				   .fetchByMarketingEventId_Last(marketingEventId,
			orderByComparator);
	}

	/**
	* Returns the marketing event announcements before and after the current marketing event announcement in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventAnnouncementId the primary key of the current marketing event announcement
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next marketing event announcement
	* @throws NoSuchMarketingEventAnnouncementException if a marketing event announcement with the primary key could not be found
	*/
	public static MarketingEventAnnouncement[] findByMarketingEventId_PrevAndNext(
		long marketingEventAnnouncementId, long marketingEventId,
		OrderByComparator<MarketingEventAnnouncement> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventAnnouncementException {
		return getPersistence()
				   .findByMarketingEventId_PrevAndNext(marketingEventAnnouncementId,
			marketingEventId, orderByComparator);
	}

	/**
	* Removes all the marketing event announcements where marketingEventId = &#63; from the database.
	*
	* @param marketingEventId the marketing event ID
	*/
	public static void removeByMarketingEventId(long marketingEventId) {
		getPersistence().removeByMarketingEventId(marketingEventId);
	}

	/**
	* Returns the number of marketing event announcements where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @return the number of matching marketing event announcements
	*/
	public static int countByMarketingEventId(long marketingEventId) {
		return getPersistence().countByMarketingEventId(marketingEventId);
	}

	/**
	* Returns all the marketing event announcements where marketingEventId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param displayDate the display date
	* @param status the status
	* @return the matching marketing event announcements
	*/
	public static List<MarketingEventAnnouncement> findByMEI_LtDD_S(
		long marketingEventId, Date displayDate, int status) {
		return getPersistence()
				   .findByMEI_LtDD_S(marketingEventId, displayDate, status);
	}

	/**
	* Returns a range of all the marketing event announcements where marketingEventId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventAnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param marketingEventId the marketing event ID
	* @param displayDate the display date
	* @param status the status
	* @param start the lower bound of the range of marketing event announcements
	* @param end the upper bound of the range of marketing event announcements (not inclusive)
	* @return the range of matching marketing event announcements
	*/
	public static List<MarketingEventAnnouncement> findByMEI_LtDD_S(
		long marketingEventId, Date displayDate, int status, int start, int end) {
		return getPersistence()
				   .findByMEI_LtDD_S(marketingEventId, displayDate, status,
			start, end);
	}

	/**
	* Returns an ordered range of all the marketing event announcements where marketingEventId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventAnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param marketingEventId the marketing event ID
	* @param displayDate the display date
	* @param status the status
	* @param start the lower bound of the range of marketing event announcements
	* @param end the upper bound of the range of marketing event announcements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching marketing event announcements
	*/
	public static List<MarketingEventAnnouncement> findByMEI_LtDD_S(
		long marketingEventId, Date displayDate, int status, int start,
		int end, OrderByComparator<MarketingEventAnnouncement> orderByComparator) {
		return getPersistence()
				   .findByMEI_LtDD_S(marketingEventId, displayDate, status,
			start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the marketing event announcements where marketingEventId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventAnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param marketingEventId the marketing event ID
	* @param displayDate the display date
	* @param status the status
	* @param start the lower bound of the range of marketing event announcements
	* @param end the upper bound of the range of marketing event announcements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching marketing event announcements
	*/
	public static List<MarketingEventAnnouncement> findByMEI_LtDD_S(
		long marketingEventId, Date displayDate, int status, int start,
		int end,
		OrderByComparator<MarketingEventAnnouncement> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByMEI_LtDD_S(marketingEventId, displayDate, status,
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first marketing event announcement in the ordered set where marketingEventId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param displayDate the display date
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event announcement
	* @throws NoSuchMarketingEventAnnouncementException if a matching marketing event announcement could not be found
	*/
	public static MarketingEventAnnouncement findByMEI_LtDD_S_First(
		long marketingEventId, Date displayDate, int status,
		OrderByComparator<MarketingEventAnnouncement> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventAnnouncementException {
		return getPersistence()
				   .findByMEI_LtDD_S_First(marketingEventId, displayDate,
			status, orderByComparator);
	}

	/**
	* Returns the first marketing event announcement in the ordered set where marketingEventId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param displayDate the display date
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event announcement, or <code>null</code> if a matching marketing event announcement could not be found
	*/
	public static MarketingEventAnnouncement fetchByMEI_LtDD_S_First(
		long marketingEventId, Date displayDate, int status,
		OrderByComparator<MarketingEventAnnouncement> orderByComparator) {
		return getPersistence()
				   .fetchByMEI_LtDD_S_First(marketingEventId, displayDate,
			status, orderByComparator);
	}

	/**
	* Returns the last marketing event announcement in the ordered set where marketingEventId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param displayDate the display date
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event announcement
	* @throws NoSuchMarketingEventAnnouncementException if a matching marketing event announcement could not be found
	*/
	public static MarketingEventAnnouncement findByMEI_LtDD_S_Last(
		long marketingEventId, Date displayDate, int status,
		OrderByComparator<MarketingEventAnnouncement> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventAnnouncementException {
		return getPersistence()
				   .findByMEI_LtDD_S_Last(marketingEventId, displayDate,
			status, orderByComparator);
	}

	/**
	* Returns the last marketing event announcement in the ordered set where marketingEventId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param displayDate the display date
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event announcement, or <code>null</code> if a matching marketing event announcement could not be found
	*/
	public static MarketingEventAnnouncement fetchByMEI_LtDD_S_Last(
		long marketingEventId, Date displayDate, int status,
		OrderByComparator<MarketingEventAnnouncement> orderByComparator) {
		return getPersistence()
				   .fetchByMEI_LtDD_S_Last(marketingEventId, displayDate,
			status, orderByComparator);
	}

	/**
	* Returns the marketing event announcements before and after the current marketing event announcement in the ordered set where marketingEventId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* @param marketingEventAnnouncementId the primary key of the current marketing event announcement
	* @param marketingEventId the marketing event ID
	* @param displayDate the display date
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next marketing event announcement
	* @throws NoSuchMarketingEventAnnouncementException if a marketing event announcement with the primary key could not be found
	*/
	public static MarketingEventAnnouncement[] findByMEI_LtDD_S_PrevAndNext(
		long marketingEventAnnouncementId, long marketingEventId,
		Date displayDate, int status,
		OrderByComparator<MarketingEventAnnouncement> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventAnnouncementException {
		return getPersistence()
				   .findByMEI_LtDD_S_PrevAndNext(marketingEventAnnouncementId,
			marketingEventId, displayDate, status, orderByComparator);
	}

	/**
	* Removes all the marketing event announcements where marketingEventId = &#63; and displayDate &lt; &#63; and status = &#63; from the database.
	*
	* @param marketingEventId the marketing event ID
	* @param displayDate the display date
	* @param status the status
	*/
	public static void removeByMEI_LtDD_S(long marketingEventId,
		Date displayDate, int status) {
		getPersistence()
			.removeByMEI_LtDD_S(marketingEventId, displayDate, status);
	}

	/**
	* Returns the number of marketing event announcements where marketingEventId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param displayDate the display date
	* @param status the status
	* @return the number of matching marketing event announcements
	*/
	public static int countByMEI_LtDD_S(long marketingEventId,
		Date displayDate, int status) {
		return getPersistence()
				   .countByMEI_LtDD_S(marketingEventId, displayDate, status);
	}

	/**
	* Caches the marketing event announcement in the entity cache if it is enabled.
	*
	* @param marketingEventAnnouncement the marketing event announcement
	*/
	public static void cacheResult(
		MarketingEventAnnouncement marketingEventAnnouncement) {
		getPersistence().cacheResult(marketingEventAnnouncement);
	}

	/**
	* Caches the marketing event announcements in the entity cache if it is enabled.
	*
	* @param marketingEventAnnouncements the marketing event announcements
	*/
	public static void cacheResult(
		List<MarketingEventAnnouncement> marketingEventAnnouncements) {
		getPersistence().cacheResult(marketingEventAnnouncements);
	}

	/**
	* Creates a new marketing event announcement with the primary key. Does not add the marketing event announcement to the database.
	*
	* @param marketingEventAnnouncementId the primary key for the new marketing event announcement
	* @return the new marketing event announcement
	*/
	public static MarketingEventAnnouncement create(
		long marketingEventAnnouncementId) {
		return getPersistence().create(marketingEventAnnouncementId);
	}

	/**
	* Removes the marketing event announcement with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEventAnnouncementId the primary key of the marketing event announcement
	* @return the marketing event announcement that was removed
	* @throws NoSuchMarketingEventAnnouncementException if a marketing event announcement with the primary key could not be found
	*/
	public static MarketingEventAnnouncement remove(
		long marketingEventAnnouncementId)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventAnnouncementException {
		return getPersistence().remove(marketingEventAnnouncementId);
	}

	public static MarketingEventAnnouncement updateImpl(
		MarketingEventAnnouncement marketingEventAnnouncement) {
		return getPersistence().updateImpl(marketingEventAnnouncement);
	}

	/**
	* Returns the marketing event announcement with the primary key or throws a {@link NoSuchMarketingEventAnnouncementException} if it could not be found.
	*
	* @param marketingEventAnnouncementId the primary key of the marketing event announcement
	* @return the marketing event announcement
	* @throws NoSuchMarketingEventAnnouncementException if a marketing event announcement with the primary key could not be found
	*/
	public static MarketingEventAnnouncement findByPrimaryKey(
		long marketingEventAnnouncementId)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventAnnouncementException {
		return getPersistence().findByPrimaryKey(marketingEventAnnouncementId);
	}

	/**
	* Returns the marketing event announcement with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param marketingEventAnnouncementId the primary key of the marketing event announcement
	* @return the marketing event announcement, or <code>null</code> if a marketing event announcement with the primary key could not be found
	*/
	public static MarketingEventAnnouncement fetchByPrimaryKey(
		long marketingEventAnnouncementId) {
		return getPersistence().fetchByPrimaryKey(marketingEventAnnouncementId);
	}

	public static java.util.Map<java.io.Serializable, MarketingEventAnnouncement> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the marketing event announcements.
	*
	* @return the marketing event announcements
	*/
	public static List<MarketingEventAnnouncement> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the marketing event announcements.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventAnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of marketing event announcements
	* @param end the upper bound of the range of marketing event announcements (not inclusive)
	* @return the range of marketing event announcements
	*/
	public static List<MarketingEventAnnouncement> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the marketing event announcements.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventAnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of marketing event announcements
	* @param end the upper bound of the range of marketing event announcements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of marketing event announcements
	*/
	public static List<MarketingEventAnnouncement> findAll(int start, int end,
		OrderByComparator<MarketingEventAnnouncement> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the marketing event announcements.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventAnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of marketing event announcements
	* @param end the upper bound of the range of marketing event announcements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of marketing event announcements
	*/
	public static List<MarketingEventAnnouncement> findAll(int start, int end,
		OrderByComparator<MarketingEventAnnouncement> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the marketing event announcements from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of marketing event announcements.
	*
	* @return the number of marketing event announcements
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static MarketingEventAnnouncementPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<MarketingEventAnnouncementPersistence, MarketingEventAnnouncementPersistence> _serviceTracker =
		ServiceTrackerFactory.open(MarketingEventAnnouncementPersistence.class);
}