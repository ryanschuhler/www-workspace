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

import com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventSponsorLevelException;
import com.liferay.osb.www.marketing.events.model.MarketingEventSponsorLevel;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the marketing event sponsor level service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.osb.www.marketing.events.service.persistence.impl.MarketingEventSponsorLevelPersistenceImpl
 * @see MarketingEventSponsorLevelUtil
 * @generated
 */
@ProviderType
public interface MarketingEventSponsorLevelPersistence extends BasePersistence<MarketingEventSponsorLevel> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MarketingEventSponsorLevelUtil} to access the marketing event sponsor level persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the marketing event sponsor levels where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @return the matching marketing event sponsor levels
	*/
	public java.util.List<MarketingEventSponsorLevel> findByMarketingEventId(
		long marketingEventId);

	/**
	* Returns a range of all the marketing event sponsor levels where marketingEventId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSponsorLevelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param marketingEventId the marketing event ID
	* @param start the lower bound of the range of marketing event sponsor levels
	* @param end the upper bound of the range of marketing event sponsor levels (not inclusive)
	* @return the range of matching marketing event sponsor levels
	*/
	public java.util.List<MarketingEventSponsorLevel> findByMarketingEventId(
		long marketingEventId, int start, int end);

	/**
	* Returns an ordered range of all the marketing event sponsor levels where marketingEventId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSponsorLevelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param marketingEventId the marketing event ID
	* @param start the lower bound of the range of marketing event sponsor levels
	* @param end the upper bound of the range of marketing event sponsor levels (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching marketing event sponsor levels
	*/
	public java.util.List<MarketingEventSponsorLevel> findByMarketingEventId(
		long marketingEventId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSponsorLevel> orderByComparator);

	/**
	* Returns an ordered range of all the marketing event sponsor levels where marketingEventId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSponsorLevelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param marketingEventId the marketing event ID
	* @param start the lower bound of the range of marketing event sponsor levels
	* @param end the upper bound of the range of marketing event sponsor levels (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching marketing event sponsor levels
	*/
	public java.util.List<MarketingEventSponsorLevel> findByMarketingEventId(
		long marketingEventId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSponsorLevel> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first marketing event sponsor level in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event sponsor level
	* @throws NoSuchMarketingEventSponsorLevelException if a matching marketing event sponsor level could not be found
	*/
	public MarketingEventSponsorLevel findByMarketingEventId_First(
		long marketingEventId,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSponsorLevel> orderByComparator)
		throws NoSuchMarketingEventSponsorLevelException;

	/**
	* Returns the first marketing event sponsor level in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marketing event sponsor level, or <code>null</code> if a matching marketing event sponsor level could not be found
	*/
	public MarketingEventSponsorLevel fetchByMarketingEventId_First(
		long marketingEventId,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSponsorLevel> orderByComparator);

	/**
	* Returns the last marketing event sponsor level in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event sponsor level
	* @throws NoSuchMarketingEventSponsorLevelException if a matching marketing event sponsor level could not be found
	*/
	public MarketingEventSponsorLevel findByMarketingEventId_Last(
		long marketingEventId,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSponsorLevel> orderByComparator)
		throws NoSuchMarketingEventSponsorLevelException;

	/**
	* Returns the last marketing event sponsor level in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marketing event sponsor level, or <code>null</code> if a matching marketing event sponsor level could not be found
	*/
	public MarketingEventSponsorLevel fetchByMarketingEventId_Last(
		long marketingEventId,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSponsorLevel> orderByComparator);

	/**
	* Returns the marketing event sponsor levels before and after the current marketing event sponsor level in the ordered set where marketingEventId = &#63;.
	*
	* @param marketingEventSponsorLevelId the primary key of the current marketing event sponsor level
	* @param marketingEventId the marketing event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next marketing event sponsor level
	* @throws NoSuchMarketingEventSponsorLevelException if a marketing event sponsor level with the primary key could not be found
	*/
	public MarketingEventSponsorLevel[] findByMarketingEventId_PrevAndNext(
		long marketingEventSponsorLevelId, long marketingEventId,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSponsorLevel> orderByComparator)
		throws NoSuchMarketingEventSponsorLevelException;

	/**
	* Removes all the marketing event sponsor levels where marketingEventId = &#63; from the database.
	*
	* @param marketingEventId the marketing event ID
	*/
	public void removeByMarketingEventId(long marketingEventId);

	/**
	* Returns the number of marketing event sponsor levels where marketingEventId = &#63;.
	*
	* @param marketingEventId the marketing event ID
	* @return the number of matching marketing event sponsor levels
	*/
	public int countByMarketingEventId(long marketingEventId);

	/**
	* Caches the marketing event sponsor level in the entity cache if it is enabled.
	*
	* @param marketingEventSponsorLevel the marketing event sponsor level
	*/
	public void cacheResult(
		MarketingEventSponsorLevel marketingEventSponsorLevel);

	/**
	* Caches the marketing event sponsor levels in the entity cache if it is enabled.
	*
	* @param marketingEventSponsorLevels the marketing event sponsor levels
	*/
	public void cacheResult(
		java.util.List<MarketingEventSponsorLevel> marketingEventSponsorLevels);

	/**
	* Creates a new marketing event sponsor level with the primary key. Does not add the marketing event sponsor level to the database.
	*
	* @param marketingEventSponsorLevelId the primary key for the new marketing event sponsor level
	* @return the new marketing event sponsor level
	*/
	public MarketingEventSponsorLevel create(long marketingEventSponsorLevelId);

	/**
	* Removes the marketing event sponsor level with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEventSponsorLevelId the primary key of the marketing event sponsor level
	* @return the marketing event sponsor level that was removed
	* @throws NoSuchMarketingEventSponsorLevelException if a marketing event sponsor level with the primary key could not be found
	*/
	public MarketingEventSponsorLevel remove(long marketingEventSponsorLevelId)
		throws NoSuchMarketingEventSponsorLevelException;

	public MarketingEventSponsorLevel updateImpl(
		MarketingEventSponsorLevel marketingEventSponsorLevel);

	/**
	* Returns the marketing event sponsor level with the primary key or throws a {@link NoSuchMarketingEventSponsorLevelException} if it could not be found.
	*
	* @param marketingEventSponsorLevelId the primary key of the marketing event sponsor level
	* @return the marketing event sponsor level
	* @throws NoSuchMarketingEventSponsorLevelException if a marketing event sponsor level with the primary key could not be found
	*/
	public MarketingEventSponsorLevel findByPrimaryKey(
		long marketingEventSponsorLevelId)
		throws NoSuchMarketingEventSponsorLevelException;

	/**
	* Returns the marketing event sponsor level with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param marketingEventSponsorLevelId the primary key of the marketing event sponsor level
	* @return the marketing event sponsor level, or <code>null</code> if a marketing event sponsor level with the primary key could not be found
	*/
	public MarketingEventSponsorLevel fetchByPrimaryKey(
		long marketingEventSponsorLevelId);

	@Override
	public java.util.Map<java.io.Serializable, MarketingEventSponsorLevel> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the marketing event sponsor levels.
	*
	* @return the marketing event sponsor levels
	*/
	public java.util.List<MarketingEventSponsorLevel> findAll();

	/**
	* Returns a range of all the marketing event sponsor levels.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSponsorLevelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of marketing event sponsor levels
	* @param end the upper bound of the range of marketing event sponsor levels (not inclusive)
	* @return the range of marketing event sponsor levels
	*/
	public java.util.List<MarketingEventSponsorLevel> findAll(int start, int end);

	/**
	* Returns an ordered range of all the marketing event sponsor levels.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSponsorLevelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of marketing event sponsor levels
	* @param end the upper bound of the range of marketing event sponsor levels (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of marketing event sponsor levels
	*/
	public java.util.List<MarketingEventSponsorLevel> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSponsorLevel> orderByComparator);

	/**
	* Returns an ordered range of all the marketing event sponsor levels.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSponsorLevelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of marketing event sponsor levels
	* @param end the upper bound of the range of marketing event sponsor levels (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of marketing event sponsor levels
	*/
	public java.util.List<MarketingEventSponsorLevel> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<MarketingEventSponsorLevel> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the marketing event sponsor levels from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of marketing event sponsor levels.
	*
	* @return the number of marketing event sponsor levels
	*/
	public int countAll();
}