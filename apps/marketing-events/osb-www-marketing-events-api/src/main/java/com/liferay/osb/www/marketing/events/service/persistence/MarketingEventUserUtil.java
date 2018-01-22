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

import com.liferay.osb.www.marketing.events.model.MarketingEventUser;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the marketing event user service. This utility wraps {@link com.liferay.osb.www.marketing.events.service.persistence.impl.MarketingEventUserPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEventUserPersistence
 * @see com.liferay.osb.www.marketing.events.service.persistence.impl.MarketingEventUserPersistenceImpl
 * @generated
 */
@ProviderType
public class MarketingEventUserUtil {
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
	public static void clearCache(MarketingEventUser marketingEventUser) {
		getPersistence().clearCache(marketingEventUser);
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
	public static List<MarketingEventUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MarketingEventUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MarketingEventUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MarketingEventUser> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MarketingEventUser update(
		MarketingEventUser marketingEventUser) {
		return getPersistence().update(marketingEventUser);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MarketingEventUser update(
		MarketingEventUser marketingEventUser, ServiceContext serviceContext) {
		return getPersistence().update(marketingEventUser, serviceContext);
	}

	/**
	* Returns all the marketing event users where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching marketing event users
	*/
	public static List<MarketingEventUser> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<MarketingEventUser> findByUuid(java.lang.String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<MarketingEventUser> findByUuid(java.lang.String uuid,
		int start, int end,
		OrderByComparator<MarketingEventUser> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<MarketingEventUser> findByUuid(java.lang.String uuid,
		int start, int end,
		OrderByComparator<MarketingEventUser> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first marketing event user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event user
	* @throws NoSuchMarketingEventUserException if a matching marketing event user could not be found
	*/
	public static MarketingEventUser findByUuid_First(java.lang.String uuid,
		OrderByComparator<MarketingEventUser> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventUserException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first marketing event user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event user, or <code>null</code> if a matching marketing event user could not be found
	*/
	public static MarketingEventUser fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<MarketingEventUser> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last marketing event user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event user
	* @throws NoSuchMarketingEventUserException if a matching marketing event user could not be found
	*/
	public static MarketingEventUser findByUuid_Last(java.lang.String uuid,
		OrderByComparator<MarketingEventUser> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventUserException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last marketing event user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event user, or <code>null</code> if a matching marketing event user could not be found
	*/
	public static MarketingEventUser fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<MarketingEventUser> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the marketing event users before and after the current marketing event user in the ordered set where uuid = &#63;.
	*
	* @param marketingEventUserId the primary key of the current marketing event user
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next marketing event user
	* @throws NoSuchMarketingEventUserException if a marketing event user with the primary key could not be found
	*/
	public static MarketingEventUser[] findByUuid_PrevAndNext(
		long marketingEventUserId, java.lang.String uuid,
		OrderByComparator<MarketingEventUser> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventUserException {
		return getPersistence()
				   .findByUuid_PrevAndNext(marketingEventUserId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the marketing event users where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of marketing event users where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching marketing event users
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns all the marketing event users where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching marketing event users
	*/
	public static List<MarketingEventUser> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<MarketingEventUser> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<MarketingEventUser> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<MarketingEventUser> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<MarketingEventUser> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<MarketingEventUser> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first marketing event user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event user
	* @throws NoSuchMarketingEventUserException if a matching marketing event user could not be found
	*/
	public static MarketingEventUser findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<MarketingEventUser> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventUserException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first marketing event user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event user, or <code>null</code> if a matching marketing event user could not be found
	*/
	public static MarketingEventUser fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		OrderByComparator<MarketingEventUser> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last marketing event user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event user
	* @throws NoSuchMarketingEventUserException if a matching marketing event user could not be found
	*/
	public static MarketingEventUser findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<MarketingEventUser> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventUserException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last marketing event user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event user, or <code>null</code> if a matching marketing event user could not be found
	*/
	public static MarketingEventUser fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<MarketingEventUser> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

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
	public static MarketingEventUser[] findByUuid_C_PrevAndNext(
		long marketingEventUserId, java.lang.String uuid, long companyId,
		OrderByComparator<MarketingEventUser> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventUserException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(marketingEventUserId, uuid,
			companyId, orderByComparator);
	}

	/**
	* Removes all the marketing event users where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of marketing event users where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching marketing event users
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the marketing event users where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @return the matching marketing event users
	*/
	public static List<MarketingEventUser> findByMarketingEventId(
		long marketingEventId) {
		return getPersistence().findByMarketingEventId(marketingEventId);
	}

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
	public static List<MarketingEventUser> findByMarketingEventId(
		long marketingEventId, int start, int end) {
		return getPersistence()
				   .findByMarketingEventId(marketingEventId, start, end);
	}

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
	public static List<MarketingEventUser> findByMarketingEventId(
		long marketingEventId, int start, int end,
		OrderByComparator<MarketingEventUser> orderByComparator) {
		return getPersistence()
				   .findByMarketingEventId(marketingEventId, start, end,
			orderByComparator);
	}

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
	public static List<MarketingEventUser> findByMarketingEventId(
		long marketingEventId, int start, int end,
		OrderByComparator<MarketingEventUser> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByMarketingEventId(marketingEventId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first marketing event user in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event user
	* @throws NoSuchMarketingEventUserException if a matching marketing event user could not be found
	*/
	public static MarketingEventUser findByMarketingEventId_First(
		long marketingEventId,
		OrderByComparator<MarketingEventUser> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventUserException {
		return getPersistence()
				   .findByMarketingEventId_First(marketingEventId,
			orderByComparator);
	}

	/**
	* Returns the first marketing event user in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event user, or <code>null</code> if a matching marketing event user could not be found
	*/
	public static MarketingEventUser fetchByMarketingEventId_First(
		long marketingEventId,
		OrderByComparator<MarketingEventUser> orderByComparator) {
		return getPersistence()
				   .fetchByMarketingEventId_First(marketingEventId,
			orderByComparator);
	}

	/**
	* Returns the last marketing event user in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event user
	* @throws NoSuchMarketingEventUserException if a matching marketing event user could not be found
	*/
	public static MarketingEventUser findByMarketingEventId_Last(
		long marketingEventId,
		OrderByComparator<MarketingEventUser> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventUserException {
		return getPersistence()
				   .findByMarketingEventId_Last(marketingEventId,
			orderByComparator);
	}

	/**
	* Returns the last marketing event user in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event user, or <code>null</code> if a matching marketing event user could not be found
	*/
	public static MarketingEventUser fetchByMarketingEventId_Last(
		long marketingEventId,
		OrderByComparator<MarketingEventUser> orderByComparator) {
		return getPersistence()
				   .fetchByMarketingEventId_Last(marketingEventId,
			orderByComparator);
	}

	/**
	* Returns the marketing event users before and after the current marketing event user in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventUserId the primary key of the current marketing event user
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next marketing event user
	* @throws NoSuchMarketingEventUserException if a marketing event user with the primary key could not be found
	*/
	public static MarketingEventUser[] findByMarketingEventId_PrevAndNext(
		long marketingEventUserId, long marketingEventId,
		OrderByComparator<MarketingEventUser> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventUserException {
		return getPersistence()
				   .findByMarketingEventId_PrevAndNext(marketingEventUserId,
			marketingEventId, orderByComparator);
	}

	/**
	* Removes all the marketing event users where marketingEventId = &#63; from the database.
	*
	* @param marketingEventId the marketing event ID
	*/
	public static void removeByMarketingEventId(long marketingEventId) {
		getPersistence().removeByMarketingEventId(marketingEventId);
	}

	/**
	* Returns the number of marketing event users where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @return the number of matching marketing event users
	*/
	public static int countByMarketingEventId(long marketingEventId) {
		return getPersistence().countByMarketingEventId(marketingEventId);
	}

	/**
	* Returns all the marketing event users where marketingEventId = &#63; and status = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param status the status
	* @return the matching marketing event users
	*/
	public static List<MarketingEventUser> findByMEI_S(long marketingEventId,
		int status) {
		return getPersistence().findByMEI_S(marketingEventId, status);
	}

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
	public static List<MarketingEventUser> findByMEI_S(long marketingEventId,
		int status, int start, int end) {
		return getPersistence().findByMEI_S(marketingEventId, status, start, end);
	}

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
	public static List<MarketingEventUser> findByMEI_S(long marketingEventId,
		int status, int start, int end,
		OrderByComparator<MarketingEventUser> orderByComparator) {
		return getPersistence()
				   .findByMEI_S(marketingEventId, status, start, end,
			orderByComparator);
	}

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
	public static List<MarketingEventUser> findByMEI_S(long marketingEventId,
		int status, int start, int end,
		OrderByComparator<MarketingEventUser> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByMEI_S(marketingEventId, status, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first marketing event user in the ordered set where marketingEventId = &#63; and status = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event user
	* @throws NoSuchMarketingEventUserException if a matching marketing event user could not be found
	*/
	public static MarketingEventUser findByMEI_S_First(long marketingEventId,
		int status, OrderByComparator<MarketingEventUser> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventUserException {
		return getPersistence()
				   .findByMEI_S_First(marketingEventId, status,
			orderByComparator);
	}

	/**
	* Returns the first marketing event user in the ordered set where marketingEventId = &#63; and status = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event user, or <code>null</code> if a matching marketing event user could not be found
	*/
	public static MarketingEventUser fetchByMEI_S_First(long marketingEventId,
		int status, OrderByComparator<MarketingEventUser> orderByComparator) {
		return getPersistence()
				   .fetchByMEI_S_First(marketingEventId, status,
			orderByComparator);
	}

	/**
	* Returns the last marketing event user in the ordered set where marketingEventId = &#63; and status = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event user
	* @throws NoSuchMarketingEventUserException if a matching marketing event user could not be found
	*/
	public static MarketingEventUser findByMEI_S_Last(long marketingEventId,
		int status, OrderByComparator<MarketingEventUser> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventUserException {
		return getPersistence()
				   .findByMEI_S_Last(marketingEventId, status, orderByComparator);
	}

	/**
	* Returns the last marketing event user in the ordered set where marketingEventId = &#63; and status = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event user, or <code>null</code> if a matching marketing event user could not be found
	*/
	public static MarketingEventUser fetchByMEI_S_Last(long marketingEventId,
		int status, OrderByComparator<MarketingEventUser> orderByComparator) {
		return getPersistence()
				   .fetchByMEI_S_Last(marketingEventId, status,
			orderByComparator);
	}

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
	public static MarketingEventUser[] findByMEI_S_PrevAndNext(
		long marketingEventUserId, long marketingEventId, int status,
		OrderByComparator<MarketingEventUser> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventUserException {
		return getPersistence()
				   .findByMEI_S_PrevAndNext(marketingEventUserId,
			marketingEventId, status, orderByComparator);
	}

	/**
	* Removes all the marketing event users where marketingEventId = &#63; and status = &#63; from the database.
	*
	* @param marketingEventId the marketing event ID
	* @param status the status
	*/
	public static void removeByMEI_S(long marketingEventId, int status) {
		getPersistence().removeByMEI_S(marketingEventId, status);
	}

	/**
	* Returns the number of marketing event users where marketingEventId = &#63; and status = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param status the status
	* @return the number of matching marketing event users
	*/
	public static int countByMEI_S(long marketingEventId, int status) {
		return getPersistence().countByMEI_S(marketingEventId, status);
	}

	/**
	* Caches the marketing event user in the entity cache if it is enabled.
	*
	* @param marketingEventUser the marketing event user
	*/
	public static void cacheResult(MarketingEventUser marketingEventUser) {
		getPersistence().cacheResult(marketingEventUser);
	}

	/**
	* Caches the marketing event users in the entity cache if it is enabled.
	*
	* @param marketingEventUsers the marketing event users
	*/
	public static void cacheResult(List<MarketingEventUser> marketingEventUsers) {
		getPersistence().cacheResult(marketingEventUsers);
	}

	/**
	* Creates a new marketing event user with the primary key. Does not add the marketing event user to the database.
	*
	* @param marketingEventUserId the primary key for the new marketing event user
	* @return the new marketing event user
	*/
	public static MarketingEventUser create(long marketingEventUserId) {
		return getPersistence().create(marketingEventUserId);
	}

	/**
	* Removes the marketing event user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEventUserId the primary key of the marketing event user
	* @return the marketing event user that was removed
	* @throws NoSuchMarketingEventUserException if a marketing event user with the primary key could not be found
	*/
	public static MarketingEventUser remove(long marketingEventUserId)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventUserException {
		return getPersistence().remove(marketingEventUserId);
	}

	public static MarketingEventUser updateImpl(
		MarketingEventUser marketingEventUser) {
		return getPersistence().updateImpl(marketingEventUser);
	}

	/**
	* Returns the marketing event user with the primary key or throws a {@link NoSuchMarketingEventUserException} if it could not be found.
	*
	* @param marketingEventUserId the primary key of the marketing event user
	* @return the marketing event user
	* @throws NoSuchMarketingEventUserException if a marketing event user with the primary key could not be found
	*/
	public static MarketingEventUser findByPrimaryKey(long marketingEventUserId)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventUserException {
		return getPersistence().findByPrimaryKey(marketingEventUserId);
	}

	/**
	* Returns the marketing event user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param marketingEventUserId the primary key of the marketing event user
	* @return the marketing event user, or <code>null</code> if a marketing event user with the primary key could not be found
	*/
	public static MarketingEventUser fetchByPrimaryKey(
		long marketingEventUserId) {
		return getPersistence().fetchByPrimaryKey(marketingEventUserId);
	}

	public static java.util.Map<java.io.Serializable, MarketingEventUser> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the marketing event users.
	*
	* @return the marketing event users
	*/
	public static List<MarketingEventUser> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<MarketingEventUser> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<MarketingEventUser> findAll(int start, int end,
		OrderByComparator<MarketingEventUser> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<MarketingEventUser> findAll(int start, int end,
		OrderByComparator<MarketingEventUser> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the marketing event users from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of marketing event users.
	*
	* @return the number of marketing event users
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	/**
	* Returns the primaryKeys of marketing event sessions associated with the marketing event user.
	*
	* @param pk the primary key of the marketing event user
	* @return long[] of the primaryKeys of marketing event sessions associated with the marketing event user
	*/
	public static long[] getMarketingEventSessionPrimaryKeys(long pk) {
		return getPersistence().getMarketingEventSessionPrimaryKeys(pk);
	}

	/**
	* Returns all the marketing event sessions associated with the marketing event user.
	*
	* @param pk the primary key of the marketing event user
	* @return the marketing event sessions associated with the marketing event user
	*/
	public static List<com.liferay.osb.www.marketing.events.model.MarketingEventSession> getMarketingEventSessions(
		long pk) {
		return getPersistence().getMarketingEventSessions(pk);
	}

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
	public static List<com.liferay.osb.www.marketing.events.model.MarketingEventSession> getMarketingEventSessions(
		long pk, int start, int end) {
		return getPersistence().getMarketingEventSessions(pk, start, end);
	}

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
	public static List<com.liferay.osb.www.marketing.events.model.MarketingEventSession> getMarketingEventSessions(
		long pk, int start, int end,
		OrderByComparator<com.liferay.osb.www.marketing.events.model.MarketingEventSession> orderByComparator) {
		return getPersistence()
				   .getMarketingEventSessions(pk, start, end, orderByComparator);
	}

	/**
	* Returns the number of marketing event sessions associated with the marketing event user.
	*
	* @param pk the primary key of the marketing event user
	* @return the number of marketing event sessions associated with the marketing event user
	*/
	public static int getMarketingEventSessionsSize(long pk) {
		return getPersistence().getMarketingEventSessionsSize(pk);
	}

	/**
	* Returns <code>true</code> if the marketing event session is associated with the marketing event user.
	*
	* @param pk the primary key of the marketing event user
	* @param marketingEventSessionPK the primary key of the marketing event session
	* @return <code>true</code> if the marketing event session is associated with the marketing event user; <code>false</code> otherwise
	*/
	public static boolean containsMarketingEventSession(long pk,
		long marketingEventSessionPK) {
		return getPersistence()
				   .containsMarketingEventSession(pk, marketingEventSessionPK);
	}

	/**
	* Returns <code>true</code> if the marketing event user has any marketing event sessions associated with it.
	*
	* @param pk the primary key of the marketing event user to check for associations with marketing event sessions
	* @return <code>true</code> if the marketing event user has any marketing event sessions associated with it; <code>false</code> otherwise
	*/
	public static boolean containsMarketingEventSessions(long pk) {
		return getPersistence().containsMarketingEventSessions(pk);
	}

	/**
	* Adds an association between the marketing event user and the marketing event session. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the marketing event user
	* @param marketingEventSessionPK the primary key of the marketing event session
	*/
	public static void addMarketingEventSession(long pk,
		long marketingEventSessionPK) {
		getPersistence().addMarketingEventSession(pk, marketingEventSessionPK);
	}

	/**
	* Adds an association between the marketing event user and the marketing event session. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the marketing event user
	* @param marketingEventSession the marketing event session
	*/
	public static void addMarketingEventSession(long pk,
		com.liferay.osb.www.marketing.events.model.MarketingEventSession marketingEventSession) {
		getPersistence().addMarketingEventSession(pk, marketingEventSession);
	}

	/**
	* Adds an association between the marketing event user and the marketing event sessions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the marketing event user
	* @param marketingEventSessionPKs the primary keys of the marketing event sessions
	*/
	public static void addMarketingEventSessions(long pk,
		long[] marketingEventSessionPKs) {
		getPersistence().addMarketingEventSessions(pk, marketingEventSessionPKs);
	}

	/**
	* Adds an association between the marketing event user and the marketing event sessions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the marketing event user
	* @param marketingEventSessions the marketing event sessions
	*/
	public static void addMarketingEventSessions(long pk,
		List<com.liferay.osb.www.marketing.events.model.MarketingEventSession> marketingEventSessions) {
		getPersistence().addMarketingEventSessions(pk, marketingEventSessions);
	}

	/**
	* Clears all associations between the marketing event user and its marketing event sessions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the marketing event user to clear the associated marketing event sessions from
	*/
	public static void clearMarketingEventSessions(long pk) {
		getPersistence().clearMarketingEventSessions(pk);
	}

	/**
	* Removes the association between the marketing event user and the marketing event session. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the marketing event user
	* @param marketingEventSessionPK the primary key of the marketing event session
	*/
	public static void removeMarketingEventSession(long pk,
		long marketingEventSessionPK) {
		getPersistence().removeMarketingEventSession(pk, marketingEventSessionPK);
	}

	/**
	* Removes the association between the marketing event user and the marketing event session. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the marketing event user
	* @param marketingEventSession the marketing event session
	*/
	public static void removeMarketingEventSession(long pk,
		com.liferay.osb.www.marketing.events.model.MarketingEventSession marketingEventSession) {
		getPersistence().removeMarketingEventSession(pk, marketingEventSession);
	}

	/**
	* Removes the association between the marketing event user and the marketing event sessions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the marketing event user
	* @param marketingEventSessionPKs the primary keys of the marketing event sessions
	*/
	public static void removeMarketingEventSessions(long pk,
		long[] marketingEventSessionPKs) {
		getPersistence()
			.removeMarketingEventSessions(pk, marketingEventSessionPKs);
	}

	/**
	* Removes the association between the marketing event user and the marketing event sessions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the marketing event user
	* @param marketingEventSessions the marketing event sessions
	*/
	public static void removeMarketingEventSessions(long pk,
		List<com.liferay.osb.www.marketing.events.model.MarketingEventSession> marketingEventSessions) {
		getPersistence().removeMarketingEventSessions(pk, marketingEventSessions);
	}

	/**
	* Sets the marketing event sessions associated with the marketing event user, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the marketing event user
	* @param marketingEventSessionPKs the primary keys of the marketing event sessions to be associated with the marketing event user
	*/
	public static void setMarketingEventSessions(long pk,
		long[] marketingEventSessionPKs) {
		getPersistence().setMarketingEventSessions(pk, marketingEventSessionPKs);
	}

	/**
	* Sets the marketing event sessions associated with the marketing event user, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the marketing event user
	* @param marketingEventSessions the marketing event sessions to be associated with the marketing event user
	*/
	public static void setMarketingEventSessions(long pk,
		List<com.liferay.osb.www.marketing.events.model.MarketingEventSession> marketingEventSessions) {
		getPersistence().setMarketingEventSessions(pk, marketingEventSessions);
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static MarketingEventUserPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<MarketingEventUserPersistence, MarketingEventUserPersistence> _serviceTracker =
		ServiceTrackerFactory.open(MarketingEventUserPersistence.class);
}