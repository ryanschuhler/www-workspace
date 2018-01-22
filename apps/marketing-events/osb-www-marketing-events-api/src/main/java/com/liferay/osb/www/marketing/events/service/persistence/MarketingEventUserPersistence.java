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

import com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventUserException;
import com.liferay.osb.www.marketing.events.model.MarketingEventUser;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the marketing event user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.osb.www.marketing.events.service.persistence.impl.MarketingEventUserPersistenceImpl
 * @see MarketingEventUserUtil
 * @generated
 */
@ProviderType
public interface MarketingEventUserPersistence extends BasePersistence<MarketingEventUser> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MarketingEventUserUtil} to access the marketing event user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the marketing event users where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching marketing event users
	*/
	public java.util.List<MarketingEventUser> findByUuid(java.lang.String uuid);

	/**
	* Returns a range of all the marketing event users where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of marketing event users
	* @param end the upper bound of the range of marketing event users (not inclusive)
	* @return the range of matching marketing event users
	*/
	public java.util.List<MarketingEventUser> findByUuid(
		java.lang.String uuid, int start, int end);

	/**
	* Returns an ordered range of all the marketing event users where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of marketing event users
	* @param end the upper bound of the range of marketing event users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching marketing event users
	*/
	public java.util.List<MarketingEventUser> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventUser> orderByComparator);

	/**
	* Returns an ordered range of all the marketing event users where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of marketing event users
	* @param end the upper bound of the range of marketing event users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching marketing event users
	*/
	public java.util.List<MarketingEventUser> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventUser> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first marketing event user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event user
	* @throws NoSuchMarketingEventUserException if a matching marketing event user could not be found
	*/
	public MarketingEventUser findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventUser> orderByComparator)
		throws NoSuchMarketingEventUserException;

	/**
	* Returns the first marketing event user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event user, or <code>null</code> if a matching marketing event user could not be found
	*/
	public MarketingEventUser fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventUser> orderByComparator);

	/**
	* Returns the last marketing event user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event user
	* @throws NoSuchMarketingEventUserException if a matching marketing event user could not be found
	*/
	public MarketingEventUser findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventUser> orderByComparator)
		throws NoSuchMarketingEventUserException;

	/**
	* Returns the last marketing event user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event user, or <code>null</code> if a matching marketing event user could not be found
	*/
	public MarketingEventUser fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventUser> orderByComparator);

	/**
	* Returns the marketing event users before and after the current marketing event user in the ordered set where uuid = &#63;.
	*
	* @param marketingEventUserId the primary key of the current marketing event user
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next marketing event user
	* @throws NoSuchMarketingEventUserException if a marketing event user with the primary key could not be found
	*/
	public MarketingEventUser[] findByUuid_PrevAndNext(
		long marketingEventUserId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventUser> orderByComparator)
		throws NoSuchMarketingEventUserException;

	/**
	* Removes all the marketing event users where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of marketing event users where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching marketing event users
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns all the marketing event users where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching marketing event users
	*/
	public java.util.List<MarketingEventUser> findByUuid_C(
		java.lang.String uuid, long companyId);

	/**
	* Returns a range of all the marketing event users where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of marketing event users
	* @param end the upper bound of the range of marketing event users (not inclusive)
	* @return the range of matching marketing event users
	*/
	public java.util.List<MarketingEventUser> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end);

	/**
	* Returns an ordered range of all the marketing event users where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of marketing event users
	* @param end the upper bound of the range of marketing event users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching marketing event users
	*/
	public java.util.List<MarketingEventUser> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventUser> orderByComparator);

	/**
	* Returns an ordered range of all the marketing event users where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of marketing event users
	* @param end the upper bound of the range of marketing event users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching marketing event users
	*/
	public java.util.List<MarketingEventUser> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventUser> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first marketing event user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event user
	* @throws NoSuchMarketingEventUserException if a matching marketing event user could not be found
	*/
	public MarketingEventUser findByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventUser> orderByComparator)
		throws NoSuchMarketingEventUserException;

	/**
	* Returns the first marketing event user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event user, or <code>null</code> if a matching marketing event user could not be found
	*/
	public MarketingEventUser fetchByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventUser> orderByComparator);

	/**
	* Returns the last marketing event user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event user
	* @throws NoSuchMarketingEventUserException if a matching marketing event user could not be found
	*/
	public MarketingEventUser findByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventUser> orderByComparator)
		throws NoSuchMarketingEventUserException;

	/**
	* Returns the last marketing event user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event user, or <code>null</code> if a matching marketing event user could not be found
	*/
	public MarketingEventUser fetchByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventUser> orderByComparator);

	/**
	* Returns the marketing event users before and after the current marketing event user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param marketingEventUserId the primary key of the current marketing event user
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next marketing event user
	* @throws NoSuchMarketingEventUserException if a marketing event user with the primary key could not be found
	*/
	public MarketingEventUser[] findByUuid_C_PrevAndNext(
		long marketingEventUserId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventUser> orderByComparator)
		throws NoSuchMarketingEventUserException;

	/**
	* Removes all the marketing event users where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of marketing event users where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching marketing event users
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the marketing event users where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @return the matching marketing event users
	*/
	public java.util.List<MarketingEventUser> findByMarketingEventId(
		long marketingEventId);

	/**
	* Returns a range of all the marketing event users where marketingEventId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param marketingEventId the marketing event ID
	* @param start the lower bound of the range of marketing event users
	* @param end the upper bound of the range of marketing event users (not inclusive)
	* @return the range of matching marketing event users
	*/
	public java.util.List<MarketingEventUser> findByMarketingEventId(
		long marketingEventId, int start, int end);

	/**
	* Returns an ordered range of all the marketing event users where marketingEventId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param marketingEventId the marketing event ID
	* @param start the lower bound of the range of marketing event users
	* @param end the upper bound of the range of marketing event users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching marketing event users
	*/
	public java.util.List<MarketingEventUser> findByMarketingEventId(
		long marketingEventId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventUser> orderByComparator);

	/**
	* Returns an ordered range of all the marketing event users where marketingEventId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param marketingEventId the marketing event ID
	* @param start the lower bound of the range of marketing event users
	* @param end the upper bound of the range of marketing event users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching marketing event users
	*/
	public java.util.List<MarketingEventUser> findByMarketingEventId(
		long marketingEventId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventUser> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first marketing event user in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event user
	* @throws NoSuchMarketingEventUserException if a matching marketing event user could not be found
	*/
	public MarketingEventUser findByMarketingEventId_First(
		long marketingEventId,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventUser> orderByComparator)
		throws NoSuchMarketingEventUserException;

	/**
	* Returns the first marketing event user in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event user, or <code>null</code> if a matching marketing event user could not be found
	*/
	public MarketingEventUser fetchByMarketingEventId_First(
		long marketingEventId,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventUser> orderByComparator);

	/**
	* Returns the last marketing event user in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event user
	* @throws NoSuchMarketingEventUserException if a matching marketing event user could not be found
	*/
	public MarketingEventUser findByMarketingEventId_Last(
		long marketingEventId,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventUser> orderByComparator)
		throws NoSuchMarketingEventUserException;

	/**
	* Returns the last marketing event user in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event user, or <code>null</code> if a matching marketing event user could not be found
	*/
	public MarketingEventUser fetchByMarketingEventId_Last(
		long marketingEventId,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventUser> orderByComparator);

	/**
	* Returns the marketing event users before and after the current marketing event user in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventUserId the primary key of the current marketing event user
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next marketing event user
	* @throws NoSuchMarketingEventUserException if a marketing event user with the primary key could not be found
	*/
	public MarketingEventUser[] findByMarketingEventId_PrevAndNext(
		long marketingEventUserId, long marketingEventId,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventUser> orderByComparator)
		throws NoSuchMarketingEventUserException;

	/**
	* Removes all the marketing event users where marketingEventId = &#63; from the database.
	*
	* @param marketingEventId the marketing event ID
	*/
	public void removeByMarketingEventId(long marketingEventId);

	/**
	* Returns the number of marketing event users where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @return the number of matching marketing event users
	*/
	public int countByMarketingEventId(long marketingEventId);

	/**
	* Returns all the marketing event users where marketingEventId = &#63; and status = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param status the status
	* @return the matching marketing event users
	*/
	public java.util.List<MarketingEventUser> findByMEI_S(
		long marketingEventId, int status);

	/**
	* Returns a range of all the marketing event users where marketingEventId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param marketingEventId the marketing event ID
	* @param status the status
	* @param start the lower bound of the range of marketing event users
	* @param end the upper bound of the range of marketing event users (not inclusive)
	* @return the range of matching marketing event users
	*/
	public java.util.List<MarketingEventUser> findByMEI_S(
		long marketingEventId, int status, int start, int end);

	/**
	* Returns an ordered range of all the marketing event users where marketingEventId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param marketingEventId the marketing event ID
	* @param status the status
	* @param start the lower bound of the range of marketing event users
	* @param end the upper bound of the range of marketing event users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching marketing event users
	*/
	public java.util.List<MarketingEventUser> findByMEI_S(
		long marketingEventId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventUser> orderByComparator);

	/**
	* Returns an ordered range of all the marketing event users where marketingEventId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param marketingEventId the marketing event ID
	* @param status the status
	* @param start the lower bound of the range of marketing event users
	* @param end the upper bound of the range of marketing event users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching marketing event users
	*/
	public java.util.List<MarketingEventUser> findByMEI_S(
		long marketingEventId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventUser> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first marketing event user in the ordered set where marketingEventId = &#63; and status = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event user
	* @throws NoSuchMarketingEventUserException if a matching marketing event user could not be found
	*/
	public MarketingEventUser findByMEI_S_First(long marketingEventId,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventUser> orderByComparator)
		throws NoSuchMarketingEventUserException;

	/**
	* Returns the first marketing event user in the ordered set where marketingEventId = &#63; and status = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event user, or <code>null</code> if a matching marketing event user could not be found
	*/
	public MarketingEventUser fetchByMEI_S_First(long marketingEventId,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventUser> orderByComparator);

	/**
	* Returns the last marketing event user in the ordered set where marketingEventId = &#63; and status = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event user
	* @throws NoSuchMarketingEventUserException if a matching marketing event user could not be found
	*/
	public MarketingEventUser findByMEI_S_Last(long marketingEventId,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventUser> orderByComparator)
		throws NoSuchMarketingEventUserException;

	/**
	* Returns the last marketing event user in the ordered set where marketingEventId = &#63; and status = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event user, or <code>null</code> if a matching marketing event user could not be found
	*/
	public MarketingEventUser fetchByMEI_S_Last(long marketingEventId,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventUser> orderByComparator);

	/**
	* Returns the marketing event users before and after the current marketing event user in the ordered set where marketingEventId = &#63; and status = &#63;.
	*
	* @param marketingEventUserId the primary key of the current marketing event user
	* @param marketingEventId the marketing event ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next marketing event user
	* @throws NoSuchMarketingEventUserException if a marketing event user with the primary key could not be found
	*/
	public MarketingEventUser[] findByMEI_S_PrevAndNext(
		long marketingEventUserId, long marketingEventId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventUser> orderByComparator)
		throws NoSuchMarketingEventUserException;

	/**
	* Removes all the marketing event users where marketingEventId = &#63; and status = &#63; from the database.
	*
	* @param marketingEventId the marketing event ID
	* @param status the status
	*/
	public void removeByMEI_S(long marketingEventId, int status);

	/**
	* Returns the number of marketing event users where marketingEventId = &#63; and status = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param status the status
	* @return the number of matching marketing event users
	*/
	public int countByMEI_S(long marketingEventId, int status);

	/**
	* Caches the marketing event user in the entity cache if it is enabled.
	*
	* @param marketingEventUser the marketing event user
	*/
	public void cacheResult(MarketingEventUser marketingEventUser);

	/**
	* Caches the marketing event users in the entity cache if it is enabled.
	*
	* @param marketingEventUsers the marketing event users
	*/
	public void cacheResult(
		java.util.List<MarketingEventUser> marketingEventUsers);

	/**
	* Creates a new marketing event user with the primary key. Does not add the marketing event user to the database.
	*
	* @param marketingEventUserId the primary key for the new marketing event user
	* @return the new marketing event user
	*/
	public MarketingEventUser create(long marketingEventUserId);

	/**
	* Removes the marketing event user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEventUserId the primary key of the marketing event user
	* @return the marketing event user that was removed
	* @throws NoSuchMarketingEventUserException if a marketing event user with the primary key could not be found
	*/
	public MarketingEventUser remove(long marketingEventUserId)
		throws NoSuchMarketingEventUserException;

	public MarketingEventUser updateImpl(MarketingEventUser marketingEventUser);

	/**
	* Returns the marketing event user with the primary key or throws a {@link NoSuchMarketingEventUserException} if it could not be found.
	*
	* @param marketingEventUserId the primary key of the marketing event user
	* @return the marketing event user
	* @throws NoSuchMarketingEventUserException if a marketing event user with the primary key could not be found
	*/
	public MarketingEventUser findByPrimaryKey(long marketingEventUserId)
		throws NoSuchMarketingEventUserException;

	/**
	* Returns the marketing event user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param marketingEventUserId the primary key of the marketing event user
	* @return the marketing event user, or <code>null</code> if a marketing event user with the primary key could not be found
	*/
	public MarketingEventUser fetchByPrimaryKey(long marketingEventUserId);

	@Override
	public java.util.Map<java.io.Serializable, MarketingEventUser> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the marketing event users.
	*
	* @return the marketing event users
	*/
	public java.util.List<MarketingEventUser> findAll();

	/**
	* Returns a range of all the marketing event users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of marketing event users
	* @param end the upper bound of the range of marketing event users (not inclusive)
	* @return the range of marketing event users
	*/
	public java.util.List<MarketingEventUser> findAll(int start, int end);

	/**
	* Returns an ordered range of all the marketing event users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of marketing event users
	* @param end the upper bound of the range of marketing event users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of marketing event users
	*/
	public java.util.List<MarketingEventUser> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventUser> orderByComparator);

	/**
	* Returns an ordered range of all the marketing event users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of marketing event users
	* @param end the upper bound of the range of marketing event users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of marketing event users
	*/
	public java.util.List<MarketingEventUser> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventUser> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the marketing event users from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of marketing event users.
	*
	* @return the number of marketing event users
	*/
	public int countAll();

	/**
	* Returns the primaryKeys of marketing event sessions associated with the marketing event user.
	*
	* @param pk the primary key of the marketing event user
	* @return long[] of the primaryKeys of marketing event sessions associated with the marketing event user
	*/
	public long[] getMarketingEventSessionPrimaryKeys(long pk);

	/**
	* Returns all the marketing event sessions associated with the marketing event user.
	*
	* @param pk the primary key of the marketing event user
	* @return the marketing event sessions associated with the marketing event user
	*/
	public java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventSession> getMarketingEventSessions(
		long pk);

	/**
	* Returns a range of all the marketing event sessions associated with the marketing event user.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the marketing event user
	* @param start the lower bound of the range of marketing event users
	* @param end the upper bound of the range of marketing event users (not inclusive)
	* @return the range of marketing event sessions associated with the marketing event user
	*/
	public java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventSession> getMarketingEventSessions(
		long pk, int start, int end);

	/**
	* Returns an ordered range of all the marketing event sessions associated with the marketing event user.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the marketing event user
	* @param start the lower bound of the range of marketing event users
	* @param end the upper bound of the range of marketing event users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of marketing event sessions associated with the marketing event user
	*/
	public java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventSession> getMarketingEventSessions(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.osb.www.marketing.events.model.MarketingEventSession> orderByComparator);

	/**
	* Returns the number of marketing event sessions associated with the marketing event user.
	*
	* @param pk the primary key of the marketing event user
	* @return the number of marketing event sessions associated with the marketing event user
	*/
	public int getMarketingEventSessionsSize(long pk);

	/**
	* Returns <code>true</code> if the marketing event session is associated with the marketing event user.
	*
	* @param pk the primary key of the marketing event user
	* @param marketingEventSessionPK the primary key of the marketing event session
	* @return <code>true</code> if the marketing event session is associated with the marketing event user; <code>false</code> otherwise
	*/
	public boolean containsMarketingEventSession(long pk,
		long marketingEventSessionPK);

	/**
	* Returns <code>true</code> if the marketing event user has any marketing event sessions associated with it.
	*
	* @param pk the primary key of the marketing event user to check for associations with marketing event sessions
	* @return <code>true</code> if the marketing event user has any marketing event sessions associated with it; <code>false</code> otherwise
	*/
	public boolean containsMarketingEventSessions(long pk);

	/**
	* Adds an association between the marketing event user and the marketing event session. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the marketing event user
	* @param marketingEventSessionPK the primary key of the marketing event session
	*/
	public void addMarketingEventSession(long pk, long marketingEventSessionPK);

	/**
	* Adds an association between the marketing event user and the marketing event session. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the marketing event user
	* @param marketingEventSession the marketing event session
	*/
	public void addMarketingEventSession(long pk,
		com.liferay.osb.www.marketing.events.model.MarketingEventSession marketingEventSession);

	/**
	* Adds an association between the marketing event user and the marketing event sessions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the marketing event user
	* @param marketingEventSessionPKs the primary keys of the marketing event sessions
	*/
	public void addMarketingEventSessions(long pk,
		long[] marketingEventSessionPKs);

	/**
	* Adds an association between the marketing event user and the marketing event sessions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the marketing event user
	* @param marketingEventSessions the marketing event sessions
	*/
	public void addMarketingEventSessions(long pk,
		java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventSession> marketingEventSessions);

	/**
	* Clears all associations between the marketing event user and its marketing event sessions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the marketing event user to clear the associated marketing event sessions from
	*/
	public void clearMarketingEventSessions(long pk);

	/**
	* Removes the association between the marketing event user and the marketing event session. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the marketing event user
	* @param marketingEventSessionPK the primary key of the marketing event session
	*/
	public void removeMarketingEventSession(long pk,
		long marketingEventSessionPK);

	/**
	* Removes the association between the marketing event user and the marketing event session. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the marketing event user
	* @param marketingEventSession the marketing event session
	*/
	public void removeMarketingEventSession(long pk,
		com.liferay.osb.www.marketing.events.model.MarketingEventSession marketingEventSession);

	/**
	* Removes the association between the marketing event user and the marketing event sessions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the marketing event user
	* @param marketingEventSessionPKs the primary keys of the marketing event sessions
	*/
	public void removeMarketingEventSessions(long pk,
		long[] marketingEventSessionPKs);

	/**
	* Removes the association between the marketing event user and the marketing event sessions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the marketing event user
	* @param marketingEventSessions the marketing event sessions
	*/
	public void removeMarketingEventSessions(long pk,
		java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventSession> marketingEventSessions);

	/**
	* Sets the marketing event sessions associated with the marketing event user, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the marketing event user
	* @param marketingEventSessionPKs the primary keys of the marketing event sessions to be associated with the marketing event user
	*/
	public void setMarketingEventSessions(long pk,
		long[] marketingEventSessionPKs);

	/**
	* Sets the marketing event sessions associated with the marketing event user, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the marketing event user
	* @param marketingEventSessions the marketing event sessions to be associated with the marketing event user
	*/
	public void setMarketingEventSessions(long pk,
		java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventSession> marketingEventSessions);

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}