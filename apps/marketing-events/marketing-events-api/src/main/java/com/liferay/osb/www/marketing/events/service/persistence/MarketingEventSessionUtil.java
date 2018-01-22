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

import com.liferay.osb.www.marketing.events.model.MarketingEventSession;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the marketing event session service. This utility wraps {@link com.liferay.osb.www.marketing.events.service.persistence.impl.MarketingEventSessionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEventSessionPersistence
 * @see com.liferay.osb.www.marketing.events.service.persistence.impl.MarketingEventSessionPersistenceImpl
 * @generated
 */
@ProviderType
public class MarketingEventSessionUtil {
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
	public static void clearCache(MarketingEventSession marketingEventSession) {
		getPersistence().clearCache(marketingEventSession);
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
	public static List<MarketingEventSession> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MarketingEventSession> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MarketingEventSession> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MarketingEventSession> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MarketingEventSession update(
		MarketingEventSession marketingEventSession) {
		return getPersistence().update(marketingEventSession);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MarketingEventSession update(
		MarketingEventSession marketingEventSession,
		ServiceContext serviceContext) {
		return getPersistence().update(marketingEventSession, serviceContext);
	}

	/**
	* Returns all the marketing event sessions where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching marketing event sessions
	*/
	public static List<MarketingEventSession> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<MarketingEventSession> findByUuid(
		java.lang.String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<MarketingEventSession> findByUuid(
		java.lang.String uuid, int start, int end,
		OrderByComparator<MarketingEventSession> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<MarketingEventSession> findByUuid(
		java.lang.String uuid, int start, int end,
		OrderByComparator<MarketingEventSession> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first marketing event session in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event session
	* @throws NoSuchMarketingEventSessionException if a matching marketing event session could not be found
	*/
	public static MarketingEventSession findByUuid_First(
		java.lang.String uuid,
		OrderByComparator<MarketingEventSession> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventSessionException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first marketing event session in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event session, or <code>null</code> if a matching marketing event session could not be found
	*/
	public static MarketingEventSession fetchByUuid_First(
		java.lang.String uuid,
		OrderByComparator<MarketingEventSession> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last marketing event session in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event session
	* @throws NoSuchMarketingEventSessionException if a matching marketing event session could not be found
	*/
	public static MarketingEventSession findByUuid_Last(java.lang.String uuid,
		OrderByComparator<MarketingEventSession> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventSessionException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last marketing event session in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event session, or <code>null</code> if a matching marketing event session could not be found
	*/
	public static MarketingEventSession fetchByUuid_Last(
		java.lang.String uuid,
		OrderByComparator<MarketingEventSession> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the marketing event sessions before and after the current marketing event session in the ordered set where uuid = &#63;.
	*
	* @param marketingEventSessionId the primary key of the current marketing event session
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next marketing event session
	* @throws NoSuchMarketingEventSessionException if a marketing event session with the primary key could not be found
	*/
	public static MarketingEventSession[] findByUuid_PrevAndNext(
		long marketingEventSessionId, java.lang.String uuid,
		OrderByComparator<MarketingEventSession> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventSessionException {
		return getPersistence()
				   .findByUuid_PrevAndNext(marketingEventSessionId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the marketing event sessions where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of marketing event sessions where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching marketing event sessions
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns all the marketing event sessions where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching marketing event sessions
	*/
	public static List<MarketingEventSession> findByUuid_C(
		java.lang.String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<MarketingEventSession> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<MarketingEventSession> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		OrderByComparator<MarketingEventSession> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<MarketingEventSession> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		OrderByComparator<MarketingEventSession> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first marketing event session in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event session
	* @throws NoSuchMarketingEventSessionException if a matching marketing event session could not be found
	*/
	public static MarketingEventSession findByUuid_C_First(
		java.lang.String uuid, long companyId,
		OrderByComparator<MarketingEventSession> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventSessionException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first marketing event session in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event session, or <code>null</code> if a matching marketing event session could not be found
	*/
	public static MarketingEventSession fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		OrderByComparator<MarketingEventSession> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last marketing event session in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event session
	* @throws NoSuchMarketingEventSessionException if a matching marketing event session could not be found
	*/
	public static MarketingEventSession findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		OrderByComparator<MarketingEventSession> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventSessionException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last marketing event session in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event session, or <code>null</code> if a matching marketing event session could not be found
	*/
	public static MarketingEventSession fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		OrderByComparator<MarketingEventSession> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

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
	public static MarketingEventSession[] findByUuid_C_PrevAndNext(
		long marketingEventSessionId, java.lang.String uuid, long companyId,
		OrderByComparator<MarketingEventSession> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventSessionException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(marketingEventSessionId, uuid,
			companyId, orderByComparator);
	}

	/**
	* Removes all the marketing event sessions where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of marketing event sessions where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching marketing event sessions
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the marketing event sessions where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @return the matching marketing event sessions
	*/
	public static List<MarketingEventSession> findByMarketingEventId(
		long marketingEventId) {
		return getPersistence().findByMarketingEventId(marketingEventId);
	}

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
	public static List<MarketingEventSession> findByMarketingEventId(
		long marketingEventId, int start, int end) {
		return getPersistence()
				   .findByMarketingEventId(marketingEventId, start, end);
	}

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
	public static List<MarketingEventSession> findByMarketingEventId(
		long marketingEventId, int start, int end,
		OrderByComparator<MarketingEventSession> orderByComparator) {
		return getPersistence()
				   .findByMarketingEventId(marketingEventId, start, end,
			orderByComparator);
	}

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
	public static List<MarketingEventSession> findByMarketingEventId(
		long marketingEventId, int start, int end,
		OrderByComparator<MarketingEventSession> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByMarketingEventId(marketingEventId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first marketing event session in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event session
	* @throws NoSuchMarketingEventSessionException if a matching marketing event session could not be found
	*/
	public static MarketingEventSession findByMarketingEventId_First(
		long marketingEventId,
		OrderByComparator<MarketingEventSession> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventSessionException {
		return getPersistence()
				   .findByMarketingEventId_First(marketingEventId,
			orderByComparator);
	}

	/**
	* Returns the first marketing event session in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event session, or <code>null</code> if a matching marketing event session could not be found
	*/
	public static MarketingEventSession fetchByMarketingEventId_First(
		long marketingEventId,
		OrderByComparator<MarketingEventSession> orderByComparator) {
		return getPersistence()
				   .fetchByMarketingEventId_First(marketingEventId,
			orderByComparator);
	}

	/**
	* Returns the last marketing event session in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event session
	* @throws NoSuchMarketingEventSessionException if a matching marketing event session could not be found
	*/
	public static MarketingEventSession findByMarketingEventId_Last(
		long marketingEventId,
		OrderByComparator<MarketingEventSession> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventSessionException {
		return getPersistence()
				   .findByMarketingEventId_Last(marketingEventId,
			orderByComparator);
	}

	/**
	* Returns the last marketing event session in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event session, or <code>null</code> if a matching marketing event session could not be found
	*/
	public static MarketingEventSession fetchByMarketingEventId_Last(
		long marketingEventId,
		OrderByComparator<MarketingEventSession> orderByComparator) {
		return getPersistence()
				   .fetchByMarketingEventId_Last(marketingEventId,
			orderByComparator);
	}

	/**
	* Returns the marketing event sessions before and after the current marketing event session in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventSessionId the primary key of the current marketing event session
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next marketing event session
	* @throws NoSuchMarketingEventSessionException if a marketing event session with the primary key could not be found
	*/
	public static MarketingEventSession[] findByMarketingEventId_PrevAndNext(
		long marketingEventSessionId, long marketingEventId,
		OrderByComparator<MarketingEventSession> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventSessionException {
		return getPersistence()
				   .findByMarketingEventId_PrevAndNext(marketingEventSessionId,
			marketingEventId, orderByComparator);
	}

	/**
	* Removes all the marketing event sessions where marketingEventId = &#63; from the database.
	*
	* @param marketingEventId the marketing event ID
	*/
	public static void removeByMarketingEventId(long marketingEventId) {
		getPersistence().removeByMarketingEventId(marketingEventId);
	}

	/**
	* Returns the number of marketing event sessions where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @return the number of matching marketing event sessions
	*/
	public static int countByMarketingEventId(long marketingEventId) {
		return getPersistence().countByMarketingEventId(marketingEventId);
	}

	/**
	* Returns all the marketing event sessions where marketingEventId = &#63; and marketingEventSessionRoomId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param marketingEventSessionRoomId the marketing event session room ID
	* @return the matching marketing event sessions
	*/
	public static List<MarketingEventSession> findByMEI_MESRI(
		long marketingEventId, long marketingEventSessionRoomId) {
		return getPersistence()
				   .findByMEI_MESRI(marketingEventId,
			marketingEventSessionRoomId);
	}

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
	public static List<MarketingEventSession> findByMEI_MESRI(
		long marketingEventId, long marketingEventSessionRoomId, int start,
		int end) {
		return getPersistence()
				   .findByMEI_MESRI(marketingEventId,
			marketingEventSessionRoomId, start, end);
	}

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
	public static List<MarketingEventSession> findByMEI_MESRI(
		long marketingEventId, long marketingEventSessionRoomId, int start,
		int end, OrderByComparator<MarketingEventSession> orderByComparator) {
		return getPersistence()
				   .findByMEI_MESRI(marketingEventId,
			marketingEventSessionRoomId, start, end, orderByComparator);
	}

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
	public static List<MarketingEventSession> findByMEI_MESRI(
		long marketingEventId, long marketingEventSessionRoomId, int start,
		int end, OrderByComparator<MarketingEventSession> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByMEI_MESRI(marketingEventId,
			marketingEventSessionRoomId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first marketing event session in the ordered set where marketingEventId = &#63; and marketingEventSessionRoomId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param marketingEventSessionRoomId the marketing event session room ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event session
	* @throws NoSuchMarketingEventSessionException if a matching marketing event session could not be found
	*/
	public static MarketingEventSession findByMEI_MESRI_First(
		long marketingEventId, long marketingEventSessionRoomId,
		OrderByComparator<MarketingEventSession> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventSessionException {
		return getPersistence()
				   .findByMEI_MESRI_First(marketingEventId,
			marketingEventSessionRoomId, orderByComparator);
	}

	/**
	* Returns the first marketing event session in the ordered set where marketingEventId = &#63; and marketingEventSessionRoomId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param marketingEventSessionRoomId the marketing event session room ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event session, or <code>null</code> if a matching marketing event session could not be found
	*/
	public static MarketingEventSession fetchByMEI_MESRI_First(
		long marketingEventId, long marketingEventSessionRoomId,
		OrderByComparator<MarketingEventSession> orderByComparator) {
		return getPersistence()
				   .fetchByMEI_MESRI_First(marketingEventId,
			marketingEventSessionRoomId, orderByComparator);
	}

	/**
	* Returns the last marketing event session in the ordered set where marketingEventId = &#63; and marketingEventSessionRoomId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param marketingEventSessionRoomId the marketing event session room ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event session
	* @throws NoSuchMarketingEventSessionException if a matching marketing event session could not be found
	*/
	public static MarketingEventSession findByMEI_MESRI_Last(
		long marketingEventId, long marketingEventSessionRoomId,
		OrderByComparator<MarketingEventSession> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventSessionException {
		return getPersistence()
				   .findByMEI_MESRI_Last(marketingEventId,
			marketingEventSessionRoomId, orderByComparator);
	}

	/**
	* Returns the last marketing event session in the ordered set where marketingEventId = &#63; and marketingEventSessionRoomId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param marketingEventSessionRoomId the marketing event session room ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event session, or <code>null</code> if a matching marketing event session could not be found
	*/
	public static MarketingEventSession fetchByMEI_MESRI_Last(
		long marketingEventId, long marketingEventSessionRoomId,
		OrderByComparator<MarketingEventSession> orderByComparator) {
		return getPersistence()
				   .fetchByMEI_MESRI_Last(marketingEventId,
			marketingEventSessionRoomId, orderByComparator);
	}

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
	public static MarketingEventSession[] findByMEI_MESRI_PrevAndNext(
		long marketingEventSessionId, long marketingEventId,
		long marketingEventSessionRoomId,
		OrderByComparator<MarketingEventSession> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventSessionException {
		return getPersistence()
				   .findByMEI_MESRI_PrevAndNext(marketingEventSessionId,
			marketingEventId, marketingEventSessionRoomId, orderByComparator);
	}

	/**
	* Removes all the marketing event sessions where marketingEventId = &#63; and marketingEventSessionRoomId = &#63; from the database.
	*
	* @param marketingEventId the marketing event ID
	* @param marketingEventSessionRoomId the marketing event session room ID
	*/
	public static void removeByMEI_MESRI(long marketingEventId,
		long marketingEventSessionRoomId) {
		getPersistence()
			.removeByMEI_MESRI(marketingEventId, marketingEventSessionRoomId);
	}

	/**
	* Returns the number of marketing event sessions where marketingEventId = &#63; and marketingEventSessionRoomId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param marketingEventSessionRoomId the marketing event session room ID
	* @return the number of matching marketing event sessions
	*/
	public static int countByMEI_MESRI(long marketingEventId,
		long marketingEventSessionRoomId) {
		return getPersistence()
				   .countByMEI_MESRI(marketingEventId,
			marketingEventSessionRoomId);
	}

	/**
	* Returns all the marketing event sessions where marketingEventId = &#63; and status = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param status the status
	* @return the matching marketing event sessions
	*/
	public static List<MarketingEventSession> findByMEI_S(
		long marketingEventId, int status) {
		return getPersistence().findByMEI_S(marketingEventId, status);
	}

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
	public static List<MarketingEventSession> findByMEI_S(
		long marketingEventId, int status, int start, int end) {
		return getPersistence().findByMEI_S(marketingEventId, status, start, end);
	}

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
	public static List<MarketingEventSession> findByMEI_S(
		long marketingEventId, int status, int start, int end,
		OrderByComparator<MarketingEventSession> orderByComparator) {
		return getPersistence()
				   .findByMEI_S(marketingEventId, status, start, end,
			orderByComparator);
	}

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
	public static List<MarketingEventSession> findByMEI_S(
		long marketingEventId, int status, int start, int end,
		OrderByComparator<MarketingEventSession> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByMEI_S(marketingEventId, status, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first marketing event session in the ordered set where marketingEventId = &#63; and status = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event session
	* @throws NoSuchMarketingEventSessionException if a matching marketing event session could not be found
	*/
	public static MarketingEventSession findByMEI_S_First(
		long marketingEventId, int status,
		OrderByComparator<MarketingEventSession> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventSessionException {
		return getPersistence()
				   .findByMEI_S_First(marketingEventId, status,
			orderByComparator);
	}

	/**
	* Returns the first marketing event session in the ordered set where marketingEventId = &#63; and status = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event session, or <code>null</code> if a matching marketing event session could not be found
	*/
	public static MarketingEventSession fetchByMEI_S_First(
		long marketingEventId, int status,
		OrderByComparator<MarketingEventSession> orderByComparator) {
		return getPersistence()
				   .fetchByMEI_S_First(marketingEventId, status,
			orderByComparator);
	}

	/**
	* Returns the last marketing event session in the ordered set where marketingEventId = &#63; and status = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event session
	* @throws NoSuchMarketingEventSessionException if a matching marketing event session could not be found
	*/
	public static MarketingEventSession findByMEI_S_Last(
		long marketingEventId, int status,
		OrderByComparator<MarketingEventSession> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventSessionException {
		return getPersistence()
				   .findByMEI_S_Last(marketingEventId, status, orderByComparator);
	}

	/**
	* Returns the last marketing event session in the ordered set where marketingEventId = &#63; and status = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event session, or <code>null</code> if a matching marketing event session could not be found
	*/
	public static MarketingEventSession fetchByMEI_S_Last(
		long marketingEventId, int status,
		OrderByComparator<MarketingEventSession> orderByComparator) {
		return getPersistence()
				   .fetchByMEI_S_Last(marketingEventId, status,
			orderByComparator);
	}

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
	public static MarketingEventSession[] findByMEI_S_PrevAndNext(
		long marketingEventSessionId, long marketingEventId, int status,
		OrderByComparator<MarketingEventSession> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventSessionException {
		return getPersistence()
				   .findByMEI_S_PrevAndNext(marketingEventSessionId,
			marketingEventId, status, orderByComparator);
	}

	/**
	* Removes all the marketing event sessions where marketingEventId = &#63; and status = &#63; from the database.
	*
	* @param marketingEventId the marketing event ID
	* @param status the status
	*/
	public static void removeByMEI_S(long marketingEventId, int status) {
		getPersistence().removeByMEI_S(marketingEventId, status);
	}

	/**
	* Returns the number of marketing event sessions where marketingEventId = &#63; and status = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param status the status
	* @return the number of matching marketing event sessions
	*/
	public static int countByMEI_S(long marketingEventId, int status) {
		return getPersistence().countByMEI_S(marketingEventId, status);
	}

	/**
	* Caches the marketing event session in the entity cache if it is enabled.
	*
	* @param marketingEventSession the marketing event session
	*/
	public static void cacheResult(MarketingEventSession marketingEventSession) {
		getPersistence().cacheResult(marketingEventSession);
	}

	/**
	* Caches the marketing event sessions in the entity cache if it is enabled.
	*
	* @param marketingEventSessions the marketing event sessions
	*/
	public static void cacheResult(
		List<MarketingEventSession> marketingEventSessions) {
		getPersistence().cacheResult(marketingEventSessions);
	}

	/**
	* Creates a new marketing event session with the primary key. Does not add the marketing event session to the database.
	*
	* @param marketingEventSessionId the primary key for the new marketing event session
	* @return the new marketing event session
	*/
	public static MarketingEventSession create(long marketingEventSessionId) {
		return getPersistence().create(marketingEventSessionId);
	}

	/**
	* Removes the marketing event session with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEventSessionId the primary key of the marketing event session
	* @return the marketing event session that was removed
	* @throws NoSuchMarketingEventSessionException if a marketing event session with the primary key could not be found
	*/
	public static MarketingEventSession remove(long marketingEventSessionId)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventSessionException {
		return getPersistence().remove(marketingEventSessionId);
	}

	public static MarketingEventSession updateImpl(
		MarketingEventSession marketingEventSession) {
		return getPersistence().updateImpl(marketingEventSession);
	}

	/**
	* Returns the marketing event session with the primary key or throws a {@link NoSuchMarketingEventSessionException} if it could not be found.
	*
	* @param marketingEventSessionId the primary key of the marketing event session
	* @return the marketing event session
	* @throws NoSuchMarketingEventSessionException if a marketing event session with the primary key could not be found
	*/
	public static MarketingEventSession findByPrimaryKey(
		long marketingEventSessionId)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventSessionException {
		return getPersistence().findByPrimaryKey(marketingEventSessionId);
	}

	/**
	* Returns the marketing event session with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param marketingEventSessionId the primary key of the marketing event session
	* @return the marketing event session, or <code>null</code> if a marketing event session with the primary key could not be found
	*/
	public static MarketingEventSession fetchByPrimaryKey(
		long marketingEventSessionId) {
		return getPersistence().fetchByPrimaryKey(marketingEventSessionId);
	}

	public static java.util.Map<java.io.Serializable, MarketingEventSession> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the marketing event sessions.
	*
	* @return the marketing event sessions
	*/
	public static List<MarketingEventSession> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<MarketingEventSession> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<MarketingEventSession> findAll(int start, int end,
		OrderByComparator<MarketingEventSession> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<MarketingEventSession> findAll(int start, int end,
		OrderByComparator<MarketingEventSession> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the marketing event sessions from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of marketing event sessions.
	*
	* @return the number of marketing event sessions
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	/**
	* Returns the primaryKeys of marketing event users associated with the marketing event session.
	*
	* @param pk the primary key of the marketing event session
	* @return long[] of the primaryKeys of marketing event users associated with the marketing event session
	*/
	public static long[] getMarketingEventUserPrimaryKeys(long pk) {
		return getPersistence().getMarketingEventUserPrimaryKeys(pk);
	}

	/**
	* Returns all the marketing event users associated with the marketing event session.
	*
	* @param pk the primary key of the marketing event session
	* @return the marketing event users associated with the marketing event session
	*/
	public static List<com.liferay.osb.www.marketing.events.model.MarketingEventUser> getMarketingEventUsers(
		long pk) {
		return getPersistence().getMarketingEventUsers(pk);
	}

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
	public static List<com.liferay.osb.www.marketing.events.model.MarketingEventUser> getMarketingEventUsers(
		long pk, int start, int end) {
		return getPersistence().getMarketingEventUsers(pk, start, end);
	}

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
	public static List<com.liferay.osb.www.marketing.events.model.MarketingEventUser> getMarketingEventUsers(
		long pk, int start, int end,
		OrderByComparator<com.liferay.osb.www.marketing.events.model.MarketingEventUser> orderByComparator) {
		return getPersistence()
				   .getMarketingEventUsers(pk, start, end, orderByComparator);
	}

	/**
	* Returns the number of marketing event users associated with the marketing event session.
	*
	* @param pk the primary key of the marketing event session
	* @return the number of marketing event users associated with the marketing event session
	*/
	public static int getMarketingEventUsersSize(long pk) {
		return getPersistence().getMarketingEventUsersSize(pk);
	}

	/**
	* Returns <code>true</code> if the marketing event user is associated with the marketing event session.
	*
	* @param pk the primary key of the marketing event session
	* @param marketingEventUserPK the primary key of the marketing event user
	* @return <code>true</code> if the marketing event user is associated with the marketing event session; <code>false</code> otherwise
	*/
	public static boolean containsMarketingEventUser(long pk,
		long marketingEventUserPK) {
		return getPersistence()
				   .containsMarketingEventUser(pk, marketingEventUserPK);
	}

	/**
	* Returns <code>true</code> if the marketing event session has any marketing event users associated with it.
	*
	* @param pk the primary key of the marketing event session to check for associations with marketing event users
	* @return <code>true</code> if the marketing event session has any marketing event users associated with it; <code>false</code> otherwise
	*/
	public static boolean containsMarketingEventUsers(long pk) {
		return getPersistence().containsMarketingEventUsers(pk);
	}

	/**
	* Adds an association between the marketing event session and the marketing event user. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the marketing event session
	* @param marketingEventUserPK the primary key of the marketing event user
	*/
	public static void addMarketingEventUser(long pk, long marketingEventUserPK) {
		getPersistence().addMarketingEventUser(pk, marketingEventUserPK);
	}

	/**
	* Adds an association between the marketing event session and the marketing event user. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the marketing event session
	* @param marketingEventUser the marketing event user
	*/
	public static void addMarketingEventUser(long pk,
		com.liferay.osb.www.marketing.events.model.MarketingEventUser marketingEventUser) {
		getPersistence().addMarketingEventUser(pk, marketingEventUser);
	}

	/**
	* Adds an association between the marketing event session and the marketing event users. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the marketing event session
	* @param marketingEventUserPKs the primary keys of the marketing event users
	*/
	public static void addMarketingEventUsers(long pk,
		long[] marketingEventUserPKs) {
		getPersistence().addMarketingEventUsers(pk, marketingEventUserPKs);
	}

	/**
	* Adds an association between the marketing event session and the marketing event users. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the marketing event session
	* @param marketingEventUsers the marketing event users
	*/
	public static void addMarketingEventUsers(long pk,
		List<com.liferay.osb.www.marketing.events.model.MarketingEventUser> marketingEventUsers) {
		getPersistence().addMarketingEventUsers(pk, marketingEventUsers);
	}

	/**
	* Clears all associations between the marketing event session and its marketing event users. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the marketing event session to clear the associated marketing event users from
	*/
	public static void clearMarketingEventUsers(long pk) {
		getPersistence().clearMarketingEventUsers(pk);
	}

	/**
	* Removes the association between the marketing event session and the marketing event user. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the marketing event session
	* @param marketingEventUserPK the primary key of the marketing event user
	*/
	public static void removeMarketingEventUser(long pk,
		long marketingEventUserPK) {
		getPersistence().removeMarketingEventUser(pk, marketingEventUserPK);
	}

	/**
	* Removes the association between the marketing event session and the marketing event user. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the marketing event session
	* @param marketingEventUser the marketing event user
	*/
	public static void removeMarketingEventUser(long pk,
		com.liferay.osb.www.marketing.events.model.MarketingEventUser marketingEventUser) {
		getPersistence().removeMarketingEventUser(pk, marketingEventUser);
	}

	/**
	* Removes the association between the marketing event session and the marketing event users. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the marketing event session
	* @param marketingEventUserPKs the primary keys of the marketing event users
	*/
	public static void removeMarketingEventUsers(long pk,
		long[] marketingEventUserPKs) {
		getPersistence().removeMarketingEventUsers(pk, marketingEventUserPKs);
	}

	/**
	* Removes the association between the marketing event session and the marketing event users. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the marketing event session
	* @param marketingEventUsers the marketing event users
	*/
	public static void removeMarketingEventUsers(long pk,
		List<com.liferay.osb.www.marketing.events.model.MarketingEventUser> marketingEventUsers) {
		getPersistence().removeMarketingEventUsers(pk, marketingEventUsers);
	}

	/**
	* Sets the marketing event users associated with the marketing event session, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the marketing event session
	* @param marketingEventUserPKs the primary keys of the marketing event users to be associated with the marketing event session
	*/
	public static void setMarketingEventUsers(long pk,
		long[] marketingEventUserPKs) {
		getPersistence().setMarketingEventUsers(pk, marketingEventUserPKs);
	}

	/**
	* Sets the marketing event users associated with the marketing event session, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the marketing event session
	* @param marketingEventUsers the marketing event users to be associated with the marketing event session
	*/
	public static void setMarketingEventUsers(long pk,
		List<com.liferay.osb.www.marketing.events.model.MarketingEventUser> marketingEventUsers) {
		getPersistence().setMarketingEventUsers(pk, marketingEventUsers);
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static MarketingEventSessionPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<MarketingEventSessionPersistence, MarketingEventSessionPersistence> _serviceTracker =
		ServiceTrackerFactory.open(MarketingEventSessionPersistence.class);
}