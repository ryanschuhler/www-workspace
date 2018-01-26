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

import com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventAnnouncementException;
import com.liferay.osb.www.marketing.events.model.MarketingEventAnnouncement;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Date;

/**
 * The persistence interface for the marketing event announcement service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.osb.www.marketing.events.service.persistence.impl.MarketingEventAnnouncementPersistenceImpl
 * @see MarketingEventAnnouncementUtil
 * @generated
 */
@ProviderType
public interface MarketingEventAnnouncementPersistence extends BasePersistence<MarketingEventAnnouncement> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MarketingEventAnnouncementUtil} to access the marketing event announcement persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the marketing event announcements where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching marketing event announcements
	*/
	public java.util.List<MarketingEventAnnouncement> findByUuid(
		java.lang.String uuid);

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
	public java.util.List<MarketingEventAnnouncement> findByUuid(
		java.lang.String uuid, int start, int end);

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
	public java.util.List<MarketingEventAnnouncement> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventAnnouncement> orderByComparator);

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
	public java.util.List<MarketingEventAnnouncement> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventAnnouncement> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first marketing event announcement in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event announcement
	* @throws NoSuchMarketingEventAnnouncementException if a matching marketing event announcement could not be found
	*/
	public MarketingEventAnnouncement findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventAnnouncement> orderByComparator)
		throws NoSuchMarketingEventAnnouncementException;

	/**
	* Returns the first marketing event announcement in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event announcement, or <code>null</code> if a matching marketing event announcement could not be found
	*/
	public MarketingEventAnnouncement fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventAnnouncement> orderByComparator);

	/**
	* Returns the last marketing event announcement in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event announcement
	* @throws NoSuchMarketingEventAnnouncementException if a matching marketing event announcement could not be found
	*/
	public MarketingEventAnnouncement findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventAnnouncement> orderByComparator)
		throws NoSuchMarketingEventAnnouncementException;

	/**
	* Returns the last marketing event announcement in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event announcement, or <code>null</code> if a matching marketing event announcement could not be found
	*/
	public MarketingEventAnnouncement fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventAnnouncement> orderByComparator);

	/**
	* Returns the marketing event announcements before and after the current marketing event announcement in the ordered set where uuid = &#63;.
	*
	* @param marketingEventAnnouncementId the primary key of the current marketing event announcement
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next marketing event announcement
	* @throws NoSuchMarketingEventAnnouncementException if a marketing event announcement with the primary key could not be found
	*/
	public MarketingEventAnnouncement[] findByUuid_PrevAndNext(
		long marketingEventAnnouncementId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventAnnouncement> orderByComparator)
		throws NoSuchMarketingEventAnnouncementException;

	/**
	* Removes all the marketing event announcements where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of marketing event announcements where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching marketing event announcements
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns all the marketing event announcements where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @return the matching marketing event announcements
	*/
	public java.util.List<MarketingEventAnnouncement> findByMarketingEventId(
		long marketingEventId);

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
	public java.util.List<MarketingEventAnnouncement> findByMarketingEventId(
		long marketingEventId, int start, int end);

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
	public java.util.List<MarketingEventAnnouncement> findByMarketingEventId(
		long marketingEventId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventAnnouncement> orderByComparator);

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
	public java.util.List<MarketingEventAnnouncement> findByMarketingEventId(
		long marketingEventId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventAnnouncement> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first marketing event announcement in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event announcement
	* @throws NoSuchMarketingEventAnnouncementException if a matching marketing event announcement could not be found
	*/
	public MarketingEventAnnouncement findByMarketingEventId_First(
		long marketingEventId,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventAnnouncement> orderByComparator)
		throws NoSuchMarketingEventAnnouncementException;

	/**
	* Returns the first marketing event announcement in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event announcement, or <code>null</code> if a matching marketing event announcement could not be found
	*/
	public MarketingEventAnnouncement fetchByMarketingEventId_First(
		long marketingEventId,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventAnnouncement> orderByComparator);

	/**
	* Returns the last marketing event announcement in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event announcement
	* @throws NoSuchMarketingEventAnnouncementException if a matching marketing event announcement could not be found
	*/
	public MarketingEventAnnouncement findByMarketingEventId_Last(
		long marketingEventId,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventAnnouncement> orderByComparator)
		throws NoSuchMarketingEventAnnouncementException;

	/**
	* Returns the last marketing event announcement in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event announcement, or <code>null</code> if a matching marketing event announcement could not be found
	*/
	public MarketingEventAnnouncement fetchByMarketingEventId_Last(
		long marketingEventId,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventAnnouncement> orderByComparator);

	/**
	* Returns the marketing event announcements before and after the current marketing event announcement in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventAnnouncementId the primary key of the current marketing event announcement
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next marketing event announcement
	* @throws NoSuchMarketingEventAnnouncementException if a marketing event announcement with the primary key could not be found
	*/
	public MarketingEventAnnouncement[] findByMarketingEventId_PrevAndNext(
		long marketingEventAnnouncementId, long marketingEventId,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventAnnouncement> orderByComparator)
		throws NoSuchMarketingEventAnnouncementException;

	/**
	* Removes all the marketing event announcements where marketingEventId = &#63; from the database.
	*
	* @param marketingEventId the marketing event ID
	*/
	public void removeByMarketingEventId(long marketingEventId);

	/**
	* Returns the number of marketing event announcements where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @return the number of matching marketing event announcements
	*/
	public int countByMarketingEventId(long marketingEventId);

	/**
	* Returns all the marketing event announcements where marketingEventId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param displayDate the display date
	* @param status the status
	* @return the matching marketing event announcements
	*/
	public java.util.List<MarketingEventAnnouncement> findByMEI_LtDD_S(
		long marketingEventId, Date displayDate, int status);

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
	public java.util.List<MarketingEventAnnouncement> findByMEI_LtDD_S(
		long marketingEventId, Date displayDate, int status, int start, int end);

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
	public java.util.List<MarketingEventAnnouncement> findByMEI_LtDD_S(
		long marketingEventId, Date displayDate, int status, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventAnnouncement> orderByComparator);

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
	public java.util.List<MarketingEventAnnouncement> findByMEI_LtDD_S(
		long marketingEventId, Date displayDate, int status, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventAnnouncement> orderByComparator,
		boolean retrieveFromCache);

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
	public MarketingEventAnnouncement findByMEI_LtDD_S_First(
		long marketingEventId, Date displayDate, int status,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventAnnouncement> orderByComparator)
		throws NoSuchMarketingEventAnnouncementException;

	/**
	* Returns the first marketing event announcement in the ordered set where marketingEventId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param displayDate the display date
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event announcement, or <code>null</code> if a matching marketing event announcement could not be found
	*/
	public MarketingEventAnnouncement fetchByMEI_LtDD_S_First(
		long marketingEventId, Date displayDate, int status,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventAnnouncement> orderByComparator);

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
	public MarketingEventAnnouncement findByMEI_LtDD_S_Last(
		long marketingEventId, Date displayDate, int status,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventAnnouncement> orderByComparator)
		throws NoSuchMarketingEventAnnouncementException;

	/**
	* Returns the last marketing event announcement in the ordered set where marketingEventId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param displayDate the display date
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event announcement, or <code>null</code> if a matching marketing event announcement could not be found
	*/
	public MarketingEventAnnouncement fetchByMEI_LtDD_S_Last(
		long marketingEventId, Date displayDate, int status,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventAnnouncement> orderByComparator);

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
	public MarketingEventAnnouncement[] findByMEI_LtDD_S_PrevAndNext(
		long marketingEventAnnouncementId, long marketingEventId,
		Date displayDate, int status,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventAnnouncement> orderByComparator)
		throws NoSuchMarketingEventAnnouncementException;

	/**
	* Removes all the marketing event announcements where marketingEventId = &#63; and displayDate &lt; &#63; and status = &#63; from the database.
	*
	* @param marketingEventId the marketing event ID
	* @param displayDate the display date
	* @param status the status
	*/
	public void removeByMEI_LtDD_S(long marketingEventId, Date displayDate,
		int status);

	/**
	* Returns the number of marketing event announcements where marketingEventId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param displayDate the display date
	* @param status the status
	* @return the number of matching marketing event announcements
	*/
	public int countByMEI_LtDD_S(long marketingEventId, Date displayDate,
		int status);

	/**
	* Caches the marketing event announcement in the entity cache if it is enabled.
	*
	* @param marketingEventAnnouncement the marketing event announcement
	*/
	public void cacheResult(
		MarketingEventAnnouncement marketingEventAnnouncement);

	/**
	* Caches the marketing event announcements in the entity cache if it is enabled.
	*
	* @param marketingEventAnnouncements the marketing event announcements
	*/
	public void cacheResult(
		java.util.List<MarketingEventAnnouncement> marketingEventAnnouncements);

	/**
	* Creates a new marketing event announcement with the primary key. Does not add the marketing event announcement to the database.
	*
	* @param marketingEventAnnouncementId the primary key for the new marketing event announcement
	* @return the new marketing event announcement
	*/
	public MarketingEventAnnouncement create(long marketingEventAnnouncementId);

	/**
	* Removes the marketing event announcement with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEventAnnouncementId the primary key of the marketing event announcement
	* @return the marketing event announcement that was removed
	* @throws NoSuchMarketingEventAnnouncementException if a marketing event announcement with the primary key could not be found
	*/
	public MarketingEventAnnouncement remove(long marketingEventAnnouncementId)
		throws NoSuchMarketingEventAnnouncementException;

	public MarketingEventAnnouncement updateImpl(
		MarketingEventAnnouncement marketingEventAnnouncement);

	/**
	* Returns the marketing event announcement with the primary key or throws a {@link NoSuchMarketingEventAnnouncementException} if it could not be found.
	*
	* @param marketingEventAnnouncementId the primary key of the marketing event announcement
	* @return the marketing event announcement
	* @throws NoSuchMarketingEventAnnouncementException if a marketing event announcement with the primary key could not be found
	*/
	public MarketingEventAnnouncement findByPrimaryKey(
		long marketingEventAnnouncementId)
		throws NoSuchMarketingEventAnnouncementException;

	/**
	* Returns the marketing event announcement with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param marketingEventAnnouncementId the primary key of the marketing event announcement
	* @return the marketing event announcement, or <code>null</code> if a marketing event announcement with the primary key could not be found
	*/
	public MarketingEventAnnouncement fetchByPrimaryKey(
		long marketingEventAnnouncementId);

	@Override
	public java.util.Map<java.io.Serializable, MarketingEventAnnouncement> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the marketing event announcements.
	*
	* @return the marketing event announcements
	*/
	public java.util.List<MarketingEventAnnouncement> findAll();

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
	public java.util.List<MarketingEventAnnouncement> findAll(int start, int end);

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
	public java.util.List<MarketingEventAnnouncement> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventAnnouncement> orderByComparator);

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
	public java.util.List<MarketingEventAnnouncement> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventAnnouncement> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the marketing event announcements from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of marketing event announcements.
	*
	* @return the number of marketing event announcements
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}