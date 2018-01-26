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

import com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventSessionException;
import com.liferay.osb.www.marketing.events.model.MarketingEventSession;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the marketing event session service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.osb.www.marketing.events.service.persistence.impl.MarketingEventSessionPersistenceImpl
 * @see MarketingEventSessionUtil
 * @generated
 */
@ProviderType
public interface MarketingEventSessionPersistence extends BasePersistence<MarketingEventSession> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MarketingEventSessionUtil} to access the marketing event session persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the marketing event sessions where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching marketing event sessions
	*/
	public java.util.List<MarketingEventSession> findByUuid(
		java.lang.String uuid);

	/**
	* Returns a range of all the marketing event sessions where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of marketing event sessions
	* @param end the upper bound of the range of marketing event sessions (not inclusive)
	* @return the range of matching marketing event sessions
	*/
	public java.util.List<MarketingEventSession> findByUuid(
		java.lang.String uuid, int start, int end);

	/**
	* Returns an ordered range of all the marketing event sessions where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of marketing event sessions
	* @param end the upper bound of the range of marketing event sessions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching marketing event sessions
	*/
	public java.util.List<MarketingEventSession> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSession> orderByComparator);

	/**
	* Returns an ordered range of all the marketing event sessions where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of marketing event sessions
	* @param end the upper bound of the range of marketing event sessions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching marketing event sessions
	*/
	public java.util.List<MarketingEventSession> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSession> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first marketing event session in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event session
	* @throws NoSuchMarketingEventSessionException if a matching marketing event session could not be found
	*/
	public MarketingEventSession findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSession> orderByComparator)
		throws NoSuchMarketingEventSessionException;

	/**
	* Returns the first marketing event session in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event session, or <code>null</code> if a matching marketing event session could not be found
	*/
	public MarketingEventSession fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSession> orderByComparator);

	/**
	* Returns the last marketing event session in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event session
	* @throws NoSuchMarketingEventSessionException if a matching marketing event session could not be found
	*/
	public MarketingEventSession findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSession> orderByComparator)
		throws NoSuchMarketingEventSessionException;

	/**
	* Returns the last marketing event session in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event session, or <code>null</code> if a matching marketing event session could not be found
	*/
	public MarketingEventSession fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSession> orderByComparator);

	/**
	* Returns the marketing event sessions before and after the current marketing event session in the ordered set where uuid = &#63;.
	*
	* @param marketingEventSessionId the primary key of the current marketing event session
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next marketing event session
	* @throws NoSuchMarketingEventSessionException if a marketing event session with the primary key could not be found
	*/
	public MarketingEventSession[] findByUuid_PrevAndNext(
		long marketingEventSessionId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSession> orderByComparator)
		throws NoSuchMarketingEventSessionException;

	/**
	* Removes all the marketing event sessions where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of marketing event sessions where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching marketing event sessions
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns all the marketing event sessions where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching marketing event sessions
	*/
	public java.util.List<MarketingEventSession> findByUuid_C(
		java.lang.String uuid, long companyId);

	/**
	* Returns a range of all the marketing event sessions where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of marketing event sessions
	* @param end the upper bound of the range of marketing event sessions (not inclusive)
	* @return the range of matching marketing event sessions
	*/
	public java.util.List<MarketingEventSession> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end);

	/**
	* Returns an ordered range of all the marketing event sessions where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of marketing event sessions
	* @param end the upper bound of the range of marketing event sessions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching marketing event sessions
	*/
	public java.util.List<MarketingEventSession> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSession> orderByComparator);

	/**
	* Returns an ordered range of all the marketing event sessions where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of marketing event sessions
	* @param end the upper bound of the range of marketing event sessions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching marketing event sessions
	*/
	public java.util.List<MarketingEventSession> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSession> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first marketing event session in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event session
	* @throws NoSuchMarketingEventSessionException if a matching marketing event session could not be found
	*/
	public MarketingEventSession findByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSession> orderByComparator)
		throws NoSuchMarketingEventSessionException;

	/**
	* Returns the first marketing event session in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event session, or <code>null</code> if a matching marketing event session could not be found
	*/
	public MarketingEventSession fetchByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSession> orderByComparator);

	/**
	* Returns the last marketing event session in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event session
	* @throws NoSuchMarketingEventSessionException if a matching marketing event session could not be found
	*/
	public MarketingEventSession findByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSession> orderByComparator)
		throws NoSuchMarketingEventSessionException;

	/**
	* Returns the last marketing event session in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event session, or <code>null</code> if a matching marketing event session could not be found
	*/
	public MarketingEventSession fetchByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSession> orderByComparator);

	/**
	* Returns the marketing event sessions before and after the current marketing event session in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param marketingEventSessionId the primary key of the current marketing event session
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next marketing event session
	* @throws NoSuchMarketingEventSessionException if a marketing event session with the primary key could not be found
	*/
	public MarketingEventSession[] findByUuid_C_PrevAndNext(
		long marketingEventSessionId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSession> orderByComparator)
		throws NoSuchMarketingEventSessionException;

	/**
	* Removes all the marketing event sessions where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of marketing event sessions where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching marketing event sessions
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the marketing event sessions where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @return the matching marketing event sessions
	*/
	public java.util.List<MarketingEventSession> findByMarketingEventId(
		long marketingEventId);

	/**
	* Returns a range of all the marketing event sessions where marketingEventId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param marketingEventId the marketing event ID
	* @param start the lower bound of the range of marketing event sessions
	* @param end the upper bound of the range of marketing event sessions (not inclusive)
	* @return the range of matching marketing event sessions
	*/
	public java.util.List<MarketingEventSession> findByMarketingEventId(
		long marketingEventId, int start, int end);

	/**
	* Returns an ordered range of all the marketing event sessions where marketingEventId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param marketingEventId the marketing event ID
	* @param start the lower bound of the range of marketing event sessions
	* @param end the upper bound of the range of marketing event sessions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching marketing event sessions
	*/
	public java.util.List<MarketingEventSession> findByMarketingEventId(
		long marketingEventId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSession> orderByComparator);

	/**
	* Returns an ordered range of all the marketing event sessions where marketingEventId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param marketingEventId the marketing event ID
	* @param start the lower bound of the range of marketing event sessions
	* @param end the upper bound of the range of marketing event sessions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching marketing event sessions
	*/
	public java.util.List<MarketingEventSession> findByMarketingEventId(
		long marketingEventId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSession> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first marketing event session in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event session
	* @throws NoSuchMarketingEventSessionException if a matching marketing event session could not be found
	*/
	public MarketingEventSession findByMarketingEventId_First(
		long marketingEventId,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSession> orderByComparator)
		throws NoSuchMarketingEventSessionException;

	/**
	* Returns the first marketing event session in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event session, or <code>null</code> if a matching marketing event session could not be found
	*/
	public MarketingEventSession fetchByMarketingEventId_First(
		long marketingEventId,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSession> orderByComparator);

	/**
	* Returns the last marketing event session in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event session
	* @throws NoSuchMarketingEventSessionException if a matching marketing event session could not be found
	*/
	public MarketingEventSession findByMarketingEventId_Last(
		long marketingEventId,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSession> orderByComparator)
		throws NoSuchMarketingEventSessionException;

	/**
	* Returns the last marketing event session in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event session, or <code>null</code> if a matching marketing event session could not be found
	*/
	public MarketingEventSession fetchByMarketingEventId_Last(
		long marketingEventId,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSession> orderByComparator);

	/**
	* Returns the marketing event sessions before and after the current marketing event session in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventSessionId the primary key of the current marketing event session
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next marketing event session
	* @throws NoSuchMarketingEventSessionException if a marketing event session with the primary key could not be found
	*/
	public MarketingEventSession[] findByMarketingEventId_PrevAndNext(
		long marketingEventSessionId, long marketingEventId,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSession> orderByComparator)
		throws NoSuchMarketingEventSessionException;

	/**
	* Removes all the marketing event sessions where marketingEventId = &#63; from the database.
	*
	* @param marketingEventId the marketing event ID
	*/
	public void removeByMarketingEventId(long marketingEventId);

	/**
	* Returns the number of marketing event sessions where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @return the number of matching marketing event sessions
	*/
	public int countByMarketingEventId(long marketingEventId);

	/**
	* Returns all the marketing event sessions where marketingEventId = &#63; and marketingEventSessionRoomId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param marketingEventSessionRoomId the marketing event session room ID
	* @return the matching marketing event sessions
	*/
	public java.util.List<MarketingEventSession> findByMEI_MESRI(
		long marketingEventId, long marketingEventSessionRoomId);

	/**
	* Returns a range of all the marketing event sessions where marketingEventId = &#63; and marketingEventSessionRoomId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param marketingEventId the marketing event ID
	* @param marketingEventSessionRoomId the marketing event session room ID
	* @param start the lower bound of the range of marketing event sessions
	* @param end the upper bound of the range of marketing event sessions (not inclusive)
	* @return the range of matching marketing event sessions
	*/
	public java.util.List<MarketingEventSession> findByMEI_MESRI(
		long marketingEventId, long marketingEventSessionRoomId, int start,
		int end);

	/**
	* Returns an ordered range of all the marketing event sessions where marketingEventId = &#63; and marketingEventSessionRoomId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param marketingEventId the marketing event ID
	* @param marketingEventSessionRoomId the marketing event session room ID
	* @param start the lower bound of the range of marketing event sessions
	* @param end the upper bound of the range of marketing event sessions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching marketing event sessions
	*/
	public java.util.List<MarketingEventSession> findByMEI_MESRI(
		long marketingEventId, long marketingEventSessionRoomId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSession> orderByComparator);

	/**
	* Returns an ordered range of all the marketing event sessions where marketingEventId = &#63; and marketingEventSessionRoomId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param marketingEventId the marketing event ID
	* @param marketingEventSessionRoomId the marketing event session room ID
	* @param start the lower bound of the range of marketing event sessions
	* @param end the upper bound of the range of marketing event sessions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching marketing event sessions
	*/
	public java.util.List<MarketingEventSession> findByMEI_MESRI(
		long marketingEventId, long marketingEventSessionRoomId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSession> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first marketing event session in the ordered set where marketingEventId = &#63; and marketingEventSessionRoomId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param marketingEventSessionRoomId the marketing event session room ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event session
	* @throws NoSuchMarketingEventSessionException if a matching marketing event session could not be found
	*/
	public MarketingEventSession findByMEI_MESRI_First(long marketingEventId,
		long marketingEventSessionRoomId,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSession> orderByComparator)
		throws NoSuchMarketingEventSessionException;

	/**
	* Returns the first marketing event session in the ordered set where marketingEventId = &#63; and marketingEventSessionRoomId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param marketingEventSessionRoomId the marketing event session room ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event session, or <code>null</code> if a matching marketing event session could not be found
	*/
	public MarketingEventSession fetchByMEI_MESRI_First(long marketingEventId,
		long marketingEventSessionRoomId,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSession> orderByComparator);

	/**
	* Returns the last marketing event session in the ordered set where marketingEventId = &#63; and marketingEventSessionRoomId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param marketingEventSessionRoomId the marketing event session room ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event session
	* @throws NoSuchMarketingEventSessionException if a matching marketing event session could not be found
	*/
	public MarketingEventSession findByMEI_MESRI_Last(long marketingEventId,
		long marketingEventSessionRoomId,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSession> orderByComparator)
		throws NoSuchMarketingEventSessionException;

	/**
	* Returns the last marketing event session in the ordered set where marketingEventId = &#63; and marketingEventSessionRoomId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param marketingEventSessionRoomId the marketing event session room ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event session, or <code>null</code> if a matching marketing event session could not be found
	*/
	public MarketingEventSession fetchByMEI_MESRI_Last(long marketingEventId,
		long marketingEventSessionRoomId,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSession> orderByComparator);

	/**
	* Returns the marketing event sessions before and after the current marketing event session in the ordered set where marketingEventId = &#63; and marketingEventSessionRoomId = &#63;.
	*
	* @param marketingEventSessionId the primary key of the current marketing event session
	* @param marketingEventId the marketing event ID
	* @param marketingEventSessionRoomId the marketing event session room ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next marketing event session
	* @throws NoSuchMarketingEventSessionException if a marketing event session with the primary key could not be found
	*/
	public MarketingEventSession[] findByMEI_MESRI_PrevAndNext(
		long marketingEventSessionId, long marketingEventId,
		long marketingEventSessionRoomId,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSession> orderByComparator)
		throws NoSuchMarketingEventSessionException;

	/**
	* Removes all the marketing event sessions where marketingEventId = &#63; and marketingEventSessionRoomId = &#63; from the database.
	*
	* @param marketingEventId the marketing event ID
	* @param marketingEventSessionRoomId the marketing event session room ID
	*/
	public void removeByMEI_MESRI(long marketingEventId,
		long marketingEventSessionRoomId);

	/**
	* Returns the number of marketing event sessions where marketingEventId = &#63; and marketingEventSessionRoomId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param marketingEventSessionRoomId the marketing event session room ID
	* @return the number of matching marketing event sessions
	*/
	public int countByMEI_MESRI(long marketingEventId,
		long marketingEventSessionRoomId);

	/**
	* Returns all the marketing event sessions where marketingEventId = &#63; and status = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param status the status
	* @return the matching marketing event sessions
	*/
	public java.util.List<MarketingEventSession> findByMEI_S(
		long marketingEventId, int status);

	/**
	* Returns a range of all the marketing event sessions where marketingEventId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param marketingEventId the marketing event ID
	* @param status the status
	* @param start the lower bound of the range of marketing event sessions
	* @param end the upper bound of the range of marketing event sessions (not inclusive)
	* @return the range of matching marketing event sessions
	*/
	public java.util.List<MarketingEventSession> findByMEI_S(
		long marketingEventId, int status, int start, int end);

	/**
	* Returns an ordered range of all the marketing event sessions where marketingEventId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param marketingEventId the marketing event ID
	* @param status the status
	* @param start the lower bound of the range of marketing event sessions
	* @param end the upper bound of the range of marketing event sessions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching marketing event sessions
	*/
	public java.util.List<MarketingEventSession> findByMEI_S(
		long marketingEventId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSession> orderByComparator);

	/**
	* Returns an ordered range of all the marketing event sessions where marketingEventId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param marketingEventId the marketing event ID
	* @param status the status
	* @param start the lower bound of the range of marketing event sessions
	* @param end the upper bound of the range of marketing event sessions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching marketing event sessions
	*/
	public java.util.List<MarketingEventSession> findByMEI_S(
		long marketingEventId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSession> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first marketing event session in the ordered set where marketingEventId = &#63; and status = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event session
	* @throws NoSuchMarketingEventSessionException if a matching marketing event session could not be found
	*/
	public MarketingEventSession findByMEI_S_First(long marketingEventId,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSession> orderByComparator)
		throws NoSuchMarketingEventSessionException;

	/**
	* Returns the first marketing event session in the ordered set where marketingEventId = &#63; and status = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event session, or <code>null</code> if a matching marketing event session could not be found
	*/
	public MarketingEventSession fetchByMEI_S_First(long marketingEventId,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSession> orderByComparator);

	/**
	* Returns the last marketing event session in the ordered set where marketingEventId = &#63; and status = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event session
	* @throws NoSuchMarketingEventSessionException if a matching marketing event session could not be found
	*/
	public MarketingEventSession findByMEI_S_Last(long marketingEventId,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSession> orderByComparator)
		throws NoSuchMarketingEventSessionException;

	/**
	* Returns the last marketing event session in the ordered set where marketingEventId = &#63; and status = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event session, or <code>null</code> if a matching marketing event session could not be found
	*/
	public MarketingEventSession fetchByMEI_S_Last(long marketingEventId,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSession> orderByComparator);

	/**
	* Returns the marketing event sessions before and after the current marketing event session in the ordered set where marketingEventId = &#63; and status = &#63;.
	*
	* @param marketingEventSessionId the primary key of the current marketing event session
	* @param marketingEventId the marketing event ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next marketing event session
	* @throws NoSuchMarketingEventSessionException if a marketing event session with the primary key could not be found
	*/
	public MarketingEventSession[] findByMEI_S_PrevAndNext(
		long marketingEventSessionId, long marketingEventId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSession> orderByComparator)
		throws NoSuchMarketingEventSessionException;

	/**
	* Removes all the marketing event sessions where marketingEventId = &#63; and status = &#63; from the database.
	*
	* @param marketingEventId the marketing event ID
	* @param status the status
	*/
	public void removeByMEI_S(long marketingEventId, int status);

	/**
	* Returns the number of marketing event sessions where marketingEventId = &#63; and status = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param status the status
	* @return the number of matching marketing event sessions
	*/
	public int countByMEI_S(long marketingEventId, int status);

	/**
	* Caches the marketing event session in the entity cache if it is enabled.
	*
	* @param marketingEventSession the marketing event session
	*/
	public void cacheResult(MarketingEventSession marketingEventSession);

	/**
	* Caches the marketing event sessions in the entity cache if it is enabled.
	*
	* @param marketingEventSessions the marketing event sessions
	*/
	public void cacheResult(
		java.util.List<MarketingEventSession> marketingEventSessions);

	/**
	* Creates a new marketing event session with the primary key. Does not add the marketing event session to the database.
	*
	* @param marketingEventSessionId the primary key for the new marketing event session
	* @return the new marketing event session
	*/
	public MarketingEventSession create(long marketingEventSessionId);

	/**
	* Removes the marketing event session with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEventSessionId the primary key of the marketing event session
	* @return the marketing event session that was removed
	* @throws NoSuchMarketingEventSessionException if a marketing event session with the primary key could not be found
	*/
	public MarketingEventSession remove(long marketingEventSessionId)
		throws NoSuchMarketingEventSessionException;

	public MarketingEventSession updateImpl(
		MarketingEventSession marketingEventSession);

	/**
	* Returns the marketing event session with the primary key or throws a {@link NoSuchMarketingEventSessionException} if it could not be found.
	*
	* @param marketingEventSessionId the primary key of the marketing event session
	* @return the marketing event session
	* @throws NoSuchMarketingEventSessionException if a marketing event session with the primary key could not be found
	*/
	public MarketingEventSession findByPrimaryKey(long marketingEventSessionId)
		throws NoSuchMarketingEventSessionException;

	/**
	* Returns the marketing event session with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param marketingEventSessionId the primary key of the marketing event session
	* @return the marketing event session, or <code>null</code> if a marketing event session with the primary key could not be found
	*/
	public MarketingEventSession fetchByPrimaryKey(long marketingEventSessionId);

	@Override
	public java.util.Map<java.io.Serializable, MarketingEventSession> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the marketing event sessions.
	*
	* @return the marketing event sessions
	*/
	public java.util.List<MarketingEventSession> findAll();

	/**
	* Returns a range of all the marketing event sessions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of marketing event sessions
	* @param end the upper bound of the range of marketing event sessions (not inclusive)
	* @return the range of marketing event sessions
	*/
	public java.util.List<MarketingEventSession> findAll(int start, int end);

	/**
	* Returns an ordered range of all the marketing event sessions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of marketing event sessions
	* @param end the upper bound of the range of marketing event sessions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of marketing event sessions
	*/
	public java.util.List<MarketingEventSession> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSession> orderByComparator);

	/**
	* Returns an ordered range of all the marketing event sessions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of marketing event sessions
	* @param end the upper bound of the range of marketing event sessions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of marketing event sessions
	*/
	public java.util.List<MarketingEventSession> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSession> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the marketing event sessions from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of marketing event sessions.
	*
	* @return the number of marketing event sessions
	*/
	public int countAll();

	/**
	* Returns the primaryKeys of marketing event users associated with the marketing event session.
	*
	* @param pk the primary key of the marketing event session
	* @return long[] of the primaryKeys of marketing event users associated with the marketing event session
	*/
	public long[] getMarketingEventUserPrimaryKeys(long pk);

	/**
	* Returns all the marketing event users associated with the marketing event session.
	*
	* @param pk the primary key of the marketing event session
	* @return the marketing event users associated with the marketing event session
	*/
	public java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventUser> getMarketingEventUsers(
		long pk);

	/**
	* Returns a range of all the marketing event users associated with the marketing event session.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the marketing event session
	* @param start the lower bound of the range of marketing event sessions
	* @param end the upper bound of the range of marketing event sessions (not inclusive)
	* @return the range of marketing event users associated with the marketing event session
	*/
	public java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventUser> getMarketingEventUsers(
		long pk, int start, int end);

	/**
	* Returns an ordered range of all the marketing event users associated with the marketing event session.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the marketing event session
	* @param start the lower bound of the range of marketing event sessions
	* @param end the upper bound of the range of marketing event sessions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of marketing event users associated with the marketing event session
	*/
	public java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventUser> getMarketingEventUsers(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.osb.www.marketing.events.model.MarketingEventUser> orderByComparator);

	/**
	* Returns the number of marketing event users associated with the marketing event session.
	*
	* @param pk the primary key of the marketing event session
	* @return the number of marketing event users associated with the marketing event session
	*/
	public int getMarketingEventUsersSize(long pk);

	/**
	* Returns <code>true</code> if the marketing event user is associated with the marketing event session.
	*
	* @param pk the primary key of the marketing event session
	* @param marketingEventUserPK the primary key of the marketing event user
	* @return <code>true</code> if the marketing event user is associated with the marketing event session; <code>false</code> otherwise
	*/
	public boolean containsMarketingEventUser(long pk, long marketingEventUserPK);

	/**
	* Returns <code>true</code> if the marketing event session has any marketing event users associated with it.
	*
	* @param pk the primary key of the marketing event session to check for associations with marketing event users
	* @return <code>true</code> if the marketing event session has any marketing event users associated with it; <code>false</code> otherwise
	*/
	public boolean containsMarketingEventUsers(long pk);

	/**
	* Adds an association between the marketing event session and the marketing event user. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the marketing event session
	* @param marketingEventUserPK the primary key of the marketing event user
	*/
	public void addMarketingEventUser(long pk, long marketingEventUserPK);

	/**
	* Adds an association between the marketing event session and the marketing event user. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the marketing event session
	* @param marketingEventUser the marketing event user
	*/
	public void addMarketingEventUser(long pk,
		com.liferay.osb.www.marketing.events.model.MarketingEventUser marketingEventUser);

	/**
	* Adds an association between the marketing event session and the marketing event users. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the marketing event session
	* @param marketingEventUserPKs the primary keys of the marketing event users
	*/
	public void addMarketingEventUsers(long pk, long[] marketingEventUserPKs);

	/**
	* Adds an association between the marketing event session and the marketing event users. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the marketing event session
	* @param marketingEventUsers the marketing event users
	*/
	public void addMarketingEventUsers(long pk,
		java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventUser> marketingEventUsers);

	/**
	* Clears all associations between the marketing event session and its marketing event users. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the marketing event session to clear the associated marketing event users from
	*/
	public void clearMarketingEventUsers(long pk);

	/**
	* Removes the association between the marketing event session and the marketing event user. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the marketing event session
	* @param marketingEventUserPK the primary key of the marketing event user
	*/
	public void removeMarketingEventUser(long pk, long marketingEventUserPK);

	/**
	* Removes the association between the marketing event session and the marketing event user. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the marketing event session
	* @param marketingEventUser the marketing event user
	*/
	public void removeMarketingEventUser(long pk,
		com.liferay.osb.www.marketing.events.model.MarketingEventUser marketingEventUser);

	/**
	* Removes the association between the marketing event session and the marketing event users. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the marketing event session
	* @param marketingEventUserPKs the primary keys of the marketing event users
	*/
	public void removeMarketingEventUsers(long pk, long[] marketingEventUserPKs);

	/**
	* Removes the association between the marketing event session and the marketing event users. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the marketing event session
	* @param marketingEventUsers the marketing event users
	*/
	public void removeMarketingEventUsers(long pk,
		java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventUser> marketingEventUsers);

	/**
	* Sets the marketing event users associated with the marketing event session, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the marketing event session
	* @param marketingEventUserPKs the primary keys of the marketing event users to be associated with the marketing event session
	*/
	public void setMarketingEventUsers(long pk, long[] marketingEventUserPKs);

	/**
	* Sets the marketing event users associated with the marketing event session, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the marketing event session
	* @param marketingEventUsers the marketing event users to be associated with the marketing event session
	*/
	public void setMarketingEventUsers(long pk,
		java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventUser> marketingEventUsers);

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}