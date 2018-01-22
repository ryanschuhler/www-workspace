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

import com.liferay.osb.www.marketing.events.model.SocialLinkType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the social link type service. This utility wraps {@link com.liferay.osb.www.marketing.events.service.persistence.impl.SocialLinkTypePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SocialLinkTypePersistence
 * @see com.liferay.osb.www.marketing.events.service.persistence.impl.SocialLinkTypePersistenceImpl
 * @generated
 */
@ProviderType
public class SocialLinkTypeUtil {
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
	public static void clearCache(SocialLinkType socialLinkType) {
		getPersistence().clearCache(socialLinkType);
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
	public static List<SocialLinkType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SocialLinkType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SocialLinkType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SocialLinkType> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SocialLinkType update(SocialLinkType socialLinkType) {
		return getPersistence().update(socialLinkType);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SocialLinkType update(SocialLinkType socialLinkType,
		ServiceContext serviceContext) {
		return getPersistence().update(socialLinkType, serviceContext);
	}

	/**
	* Caches the social link type in the entity cache if it is enabled.
	*
	* @param socialLinkType the social link type
	*/
	public static void cacheResult(SocialLinkType socialLinkType) {
		getPersistence().cacheResult(socialLinkType);
	}

	/**
	* Caches the social link types in the entity cache if it is enabled.
	*
	* @param socialLinkTypes the social link types
	*/
	public static void cacheResult(List<SocialLinkType> socialLinkTypes) {
		getPersistence().cacheResult(socialLinkTypes);
	}

	/**
	* Creates a new social link type with the primary key. Does not add the social link type to the database.
	*
	* @param socialLinkTypeId the primary key for the new social link type
	* @return the new social link type
	*/
	public static SocialLinkType create(long socialLinkTypeId) {
		return getPersistence().create(socialLinkTypeId);
	}

	/**
	* Removes the social link type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param socialLinkTypeId the primary key of the social link type
	* @return the social link type that was removed
	* @throws NoSuchSocialLinkTypeException if a social link type with the primary key could not be found
	*/
	public static SocialLinkType remove(long socialLinkTypeId)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchSocialLinkTypeException {
		return getPersistence().remove(socialLinkTypeId);
	}

	public static SocialLinkType updateImpl(SocialLinkType socialLinkType) {
		return getPersistence().updateImpl(socialLinkType);
	}

	/**
	* Returns the social link type with the primary key or throws a {@link NoSuchSocialLinkTypeException} if it could not be found.
	*
	* @param socialLinkTypeId the primary key of the social link type
	* @return the social link type
	* @throws NoSuchSocialLinkTypeException if a social link type with the primary key could not be found
	*/
	public static SocialLinkType findByPrimaryKey(long socialLinkTypeId)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchSocialLinkTypeException {
		return getPersistence().findByPrimaryKey(socialLinkTypeId);
	}

	/**
	* Returns the social link type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param socialLinkTypeId the primary key of the social link type
	* @return the social link type, or <code>null</code> if a social link type with the primary key could not be found
	*/
	public static SocialLinkType fetchByPrimaryKey(long socialLinkTypeId) {
		return getPersistence().fetchByPrimaryKey(socialLinkTypeId);
	}

	public static java.util.Map<java.io.Serializable, SocialLinkType> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the social link types.
	*
	* @return the social link types
	*/
	public static List<SocialLinkType> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the social link types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SocialLinkTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of social link types
	* @param end the upper bound of the range of social link types (not inclusive)
	* @return the range of social link types
	*/
	public static List<SocialLinkType> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the social link types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SocialLinkTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of social link types
	* @param end the upper bound of the range of social link types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of social link types
	*/
	public static List<SocialLinkType> findAll(int start, int end,
		OrderByComparator<SocialLinkType> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the social link types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SocialLinkTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of social link types
	* @param end the upper bound of the range of social link types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of social link types
	*/
	public static List<SocialLinkType> findAll(int start, int end,
		OrderByComparator<SocialLinkType> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the social link types from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of social link types.
	*
	* @return the number of social link types
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SocialLinkTypePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SocialLinkTypePersistence, SocialLinkTypePersistence> _serviceTracker =
		ServiceTrackerFactory.open(SocialLinkTypePersistence.class);
}