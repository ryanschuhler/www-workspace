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

import com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventSponsorException;
import com.liferay.osb.www.marketing.events.model.MarketingEventSponsor;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the marketing event sponsor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.osb.www.marketing.events.service.persistence.impl.MarketingEventSponsorPersistenceImpl
 * @see MarketingEventSponsorUtil
 * @generated
 */
@ProviderType
public interface MarketingEventSponsorPersistence extends BasePersistence<MarketingEventSponsor> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MarketingEventSponsorUtil} to access the marketing event sponsor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the marketing event sponsors where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @return the matching marketing event sponsors
	*/
	public java.util.List<MarketingEventSponsor> findByMarketingEventId(
		long marketingEventId);

	/**
	* Returns a range of all the marketing event sponsors where marketingEventId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSponsorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param marketingEventId the marketing event ID
	* @param start the lower bound of the range of marketing event sponsors
	* @param end the upper bound of the range of marketing event sponsors (not inclusive)
	* @return the range of matching marketing event sponsors
	*/
	public java.util.List<MarketingEventSponsor> findByMarketingEventId(
		long marketingEventId, int start, int end);

	/**
	* Returns an ordered range of all the marketing event sponsors where marketingEventId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSponsorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param marketingEventId the marketing event ID
	* @param start the lower bound of the range of marketing event sponsors
	* @param end the upper bound of the range of marketing event sponsors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching marketing event sponsors
	*/
	public java.util.List<MarketingEventSponsor> findByMarketingEventId(
		long marketingEventId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSponsor> orderByComparator);

	/**
	* Returns an ordered range of all the marketing event sponsors where marketingEventId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSponsorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param marketingEventId the marketing event ID
	* @param start the lower bound of the range of marketing event sponsors
	* @param end the upper bound of the range of marketing event sponsors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching marketing event sponsors
	*/
	public java.util.List<MarketingEventSponsor> findByMarketingEventId(
		long marketingEventId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSponsor> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first marketing event sponsor in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event sponsor
	* @throws NoSuchMarketingEventSponsorException if a matching marketing event sponsor could not be found
	*/
	public MarketingEventSponsor findByMarketingEventId_First(
		long marketingEventId,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSponsor> orderByComparator)
		throws NoSuchMarketingEventSponsorException;

	/**
	* Returns the first marketing event sponsor in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event sponsor, or <code>null</code> if a matching marketing event sponsor could not be found
	*/
	public MarketingEventSponsor fetchByMarketingEventId_First(
		long marketingEventId,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSponsor> orderByComparator);

	/**
	* Returns the last marketing event sponsor in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event sponsor
	* @throws NoSuchMarketingEventSponsorException if a matching marketing event sponsor could not be found
	*/
	public MarketingEventSponsor findByMarketingEventId_Last(
		long marketingEventId,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSponsor> orderByComparator)
		throws NoSuchMarketingEventSponsorException;

	/**
	* Returns the last marketing event sponsor in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event sponsor, or <code>null</code> if a matching marketing event sponsor could not be found
	*/
	public MarketingEventSponsor fetchByMarketingEventId_Last(
		long marketingEventId,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSponsor> orderByComparator);

	/**
	* Returns the marketing event sponsors before and after the current marketing event sponsor in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventSponsorId the primary key of the current marketing event sponsor
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next marketing event sponsor
	* @throws NoSuchMarketingEventSponsorException if a marketing event sponsor with the primary key could not be found
	*/
	public MarketingEventSponsor[] findByMarketingEventId_PrevAndNext(
		long marketingEventSponsorId, long marketingEventId,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSponsor> orderByComparator)
		throws NoSuchMarketingEventSponsorException;

	/**
	* Removes all the marketing event sponsors where marketingEventId = &#63; from the database.
	*
	* @param marketingEventId the marketing event ID
	*/
	public void removeByMarketingEventId(long marketingEventId);

	/**
	* Returns the number of marketing event sponsors where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @return the number of matching marketing event sponsors
	*/
	public int countByMarketingEventId(long marketingEventId);

	/**
	* Returns all the marketing event sponsors where marketingEventId = &#63; and marketingEventSponsorLevelId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param marketingEventSponsorLevelId the marketing event sponsor level ID
	* @return the matching marketing event sponsors
	*/
	public java.util.List<MarketingEventSponsor> findByMEI_MESLI(
		long marketingEventId, long marketingEventSponsorLevelId);

	/**
	* Returns a range of all the marketing event sponsors where marketingEventId = &#63; and marketingEventSponsorLevelId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSponsorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param marketingEventId the marketing event ID
	* @param marketingEventSponsorLevelId the marketing event sponsor level ID
	* @param start the lower bound of the range of marketing event sponsors
	* @param end the upper bound of the range of marketing event sponsors (not inclusive)
	* @return the range of matching marketing event sponsors
	*/
	public java.util.List<MarketingEventSponsor> findByMEI_MESLI(
		long marketingEventId, long marketingEventSponsorLevelId, int start,
		int end);

	/**
	* Returns an ordered range of all the marketing event sponsors where marketingEventId = &#63; and marketingEventSponsorLevelId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSponsorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param marketingEventId the marketing event ID
	* @param marketingEventSponsorLevelId the marketing event sponsor level ID
	* @param start the lower bound of the range of marketing event sponsors
	* @param end the upper bound of the range of marketing event sponsors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching marketing event sponsors
	*/
	public java.util.List<MarketingEventSponsor> findByMEI_MESLI(
		long marketingEventId, long marketingEventSponsorLevelId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSponsor> orderByComparator);

	/**
	* Returns an ordered range of all the marketing event sponsors where marketingEventId = &#63; and marketingEventSponsorLevelId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSponsorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param marketingEventId the marketing event ID
	* @param marketingEventSponsorLevelId the marketing event sponsor level ID
	* @param start the lower bound of the range of marketing event sponsors
	* @param end the upper bound of the range of marketing event sponsors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching marketing event sponsors
	*/
	public java.util.List<MarketingEventSponsor> findByMEI_MESLI(
		long marketingEventId, long marketingEventSponsorLevelId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSponsor> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first marketing event sponsor in the ordered set where marketingEventId = &#63; and marketingEventSponsorLevelId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param marketingEventSponsorLevelId the marketing event sponsor level ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event sponsor
	* @throws NoSuchMarketingEventSponsorException if a matching marketing event sponsor could not be found
	*/
	public MarketingEventSponsor findByMEI_MESLI_First(long marketingEventId,
		long marketingEventSponsorLevelId,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSponsor> orderByComparator)
		throws NoSuchMarketingEventSponsorException;

	/**
	* Returns the first marketing event sponsor in the ordered set where marketingEventId = &#63; and marketingEventSponsorLevelId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param marketingEventSponsorLevelId the marketing event sponsor level ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event sponsor, or <code>null</code> if a matching marketing event sponsor could not be found
	*/
	public MarketingEventSponsor fetchByMEI_MESLI_First(long marketingEventId,
		long marketingEventSponsorLevelId,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSponsor> orderByComparator);

	/**
	* Returns the last marketing event sponsor in the ordered set where marketingEventId = &#63; and marketingEventSponsorLevelId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param marketingEventSponsorLevelId the marketing event sponsor level ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event sponsor
	* @throws NoSuchMarketingEventSponsorException if a matching marketing event sponsor could not be found
	*/
	public MarketingEventSponsor findByMEI_MESLI_Last(long marketingEventId,
		long marketingEventSponsorLevelId,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSponsor> orderByComparator)
		throws NoSuchMarketingEventSponsorException;

	/**
	* Returns the last marketing event sponsor in the ordered set where marketingEventId = &#63; and marketingEventSponsorLevelId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param marketingEventSponsorLevelId the marketing event sponsor level ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event sponsor, or <code>null</code> if a matching marketing event sponsor could not be found
	*/
	public MarketingEventSponsor fetchByMEI_MESLI_Last(long marketingEventId,
		long marketingEventSponsorLevelId,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSponsor> orderByComparator);

	/**
	* Returns the marketing event sponsors before and after the current marketing event sponsor in the ordered set where marketingEventId = &#63; and marketingEventSponsorLevelId = &#63;.
	*
	* @param marketingEventSponsorId the primary key of the current marketing event sponsor
	* @param marketingEventId the marketing event ID
	* @param marketingEventSponsorLevelId the marketing event sponsor level ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next marketing event sponsor
	* @throws NoSuchMarketingEventSponsorException if a marketing event sponsor with the primary key could not be found
	*/
	public MarketingEventSponsor[] findByMEI_MESLI_PrevAndNext(
		long marketingEventSponsorId, long marketingEventId,
		long marketingEventSponsorLevelId,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSponsor> orderByComparator)
		throws NoSuchMarketingEventSponsorException;

	/**
	* Removes all the marketing event sponsors where marketingEventId = &#63; and marketingEventSponsorLevelId = &#63; from the database.
	*
	* @param marketingEventId the marketing event ID
	* @param marketingEventSponsorLevelId the marketing event sponsor level ID
	*/
	public void removeByMEI_MESLI(long marketingEventId,
		long marketingEventSponsorLevelId);

	/**
	* Returns the number of marketing event sponsors where marketingEventId = &#63; and marketingEventSponsorLevelId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param marketingEventSponsorLevelId the marketing event sponsor level ID
	* @return the number of matching marketing event sponsors
	*/
	public int countByMEI_MESLI(long marketingEventId,
		long marketingEventSponsorLevelId);

	/**
	* Caches the marketing event sponsor in the entity cache if it is enabled.
	*
	* @param marketingEventSponsor the marketing event sponsor
	*/
	public void cacheResult(MarketingEventSponsor marketingEventSponsor);

	/**
	* Caches the marketing event sponsors in the entity cache if it is enabled.
	*
	* @param marketingEventSponsors the marketing event sponsors
	*/
	public void cacheResult(
		java.util.List<MarketingEventSponsor> marketingEventSponsors);

	/**
	* Creates a new marketing event sponsor with the primary key. Does not add the marketing event sponsor to the database.
	*
	* @param marketingEventSponsorId the primary key for the new marketing event sponsor
	* @return the new marketing event sponsor
	*/
	public MarketingEventSponsor create(long marketingEventSponsorId);

	/**
	* Removes the marketing event sponsor with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEventSponsorId the primary key of the marketing event sponsor
	* @return the marketing event sponsor that was removed
	* @throws NoSuchMarketingEventSponsorException if a marketing event sponsor with the primary key could not be found
	*/
	public MarketingEventSponsor remove(long marketingEventSponsorId)
		throws NoSuchMarketingEventSponsorException;

	public MarketingEventSponsor updateImpl(
		MarketingEventSponsor marketingEventSponsor);

	/**
	* Returns the marketing event sponsor with the primary key or throws a {@link NoSuchMarketingEventSponsorException} if it could not be found.
	*
	* @param marketingEventSponsorId the primary key of the marketing event sponsor
	* @return the marketing event sponsor
	* @throws NoSuchMarketingEventSponsorException if a marketing event sponsor with the primary key could not be found
	*/
	public MarketingEventSponsor findByPrimaryKey(long marketingEventSponsorId)
		throws NoSuchMarketingEventSponsorException;

	/**
	* Returns the marketing event sponsor with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param marketingEventSponsorId the primary key of the marketing event sponsor
	* @return the marketing event sponsor, or <code>null</code> if a marketing event sponsor with the primary key could not be found
	*/
	public MarketingEventSponsor fetchByPrimaryKey(long marketingEventSponsorId);

	@Override
	public java.util.Map<java.io.Serializable, MarketingEventSponsor> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the marketing event sponsors.
	*
	* @return the marketing event sponsors
	*/
	public java.util.List<MarketingEventSponsor> findAll();

	/**
	* Returns a range of all the marketing event sponsors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSponsorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of marketing event sponsors
	* @param end the upper bound of the range of marketing event sponsors (not inclusive)
	* @return the range of marketing event sponsors
	*/
	public java.util.List<MarketingEventSponsor> findAll(int start, int end);

	/**
	* Returns an ordered range of all the marketing event sponsors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSponsorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of marketing event sponsors
	* @param end the upper bound of the range of marketing event sponsors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of marketing event sponsors
	*/
	public java.util.List<MarketingEventSponsor> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSponsor> orderByComparator);

	/**
	* Returns an ordered range of all the marketing event sponsors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSponsorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of marketing event sponsors
	* @param end the upper bound of the range of marketing event sponsors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of marketing event sponsors
	*/
	public java.util.List<MarketingEventSponsor> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSponsor> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the marketing event sponsors from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of marketing event sponsors.
	*
	* @return the number of marketing event sponsors
	*/
	public int countAll();
}