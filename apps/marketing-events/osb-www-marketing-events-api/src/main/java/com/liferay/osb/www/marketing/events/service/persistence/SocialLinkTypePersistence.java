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

import com.liferay.osb.www.marketing.events.exception.NoSuchSocialLinkTypeException;
import com.liferay.osb.www.marketing.events.model.SocialLinkType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the social link type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.osb.www.marketing.events.service.persistence.impl.SocialLinkTypePersistenceImpl
 * @see SocialLinkTypeUtil
 * @generated
 */
@ProviderType
public interface SocialLinkTypePersistence extends BasePersistence<SocialLinkType> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SocialLinkTypeUtil} to access the social link type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the social link type in the entity cache if it is enabled.
	*
	* @param socialLinkType the social link type
	*/
	public void cacheResult(SocialLinkType socialLinkType);

	/**
	* Caches the social link types in the entity cache if it is enabled.
	*
	* @param socialLinkTypes the social link types
	*/
	public void cacheResult(java.util.List<SocialLinkType> socialLinkTypes);

	/**
	* Creates a new social link type with the primary key. Does not add the social link type to the database.
	*
	* @param socialLinkTypeId the primary key for the new social link type
	* @return the new social link type
	*/
	public SocialLinkType create(long socialLinkTypeId);

	/**
	* Removes the social link type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param socialLinkTypeId the primary key of the social link type
	* @return the social link type that was removed
	* @throws NoSuchSocialLinkTypeException if a social link type with the primary key could not be found
	*/
	public SocialLinkType remove(long socialLinkTypeId)
		throws NoSuchSocialLinkTypeException;

	public SocialLinkType updateImpl(SocialLinkType socialLinkType);

	/**
	* Returns the social link type with the primary key or throws a {@link NoSuchSocialLinkTypeException} if it could not be found.
	*
	* @param socialLinkTypeId the primary key of the social link type
	* @return the social link type
	* @throws NoSuchSocialLinkTypeException if a social link type with the primary key could not be found
	*/
	public SocialLinkType findByPrimaryKey(long socialLinkTypeId)
		throws NoSuchSocialLinkTypeException;

	/**
	* Returns the social link type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param socialLinkTypeId the primary key of the social link type
	* @return the social link type, or <code>null</code> if a social link type with the primary key could not be found
	*/
	public SocialLinkType fetchByPrimaryKey(long socialLinkTypeId);

	@Override
	public java.util.Map<java.io.Serializable, SocialLinkType> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the social link types.
	*
	* @return the social link types
	*/
	public java.util.List<SocialLinkType> findAll();

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
	public java.util.List<SocialLinkType> findAll(int start, int end);

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
	public java.util.List<SocialLinkType> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SocialLinkType> orderByComparator);

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
	public java.util.List<SocialLinkType> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SocialLinkType> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the social link types from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of social link types.
	*
	* @return the number of social link types
	*/
	public int countAll();
}