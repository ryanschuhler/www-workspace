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

package com.liferay.osb.www.marketing.events.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osb.www.marketing.events.model.MarketingEventSessionRoom;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for MarketingEventSessionRoom. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEventSessionRoomLocalServiceUtil
 * @see com.liferay.osb.www.marketing.events.service.base.MarketingEventSessionRoomLocalServiceBaseImpl
 * @see com.liferay.osb.www.marketing.events.service.impl.MarketingEventSessionRoomLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface MarketingEventSessionRoomLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MarketingEventSessionRoomLocalServiceUtil} to access the marketing event session room local service. Add custom service methods to {@link com.liferay.osb.www.marketing.events.service.impl.MarketingEventSessionRoomLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public MarketingEventSessionRoom addMarketingEventSessionRoom(
		long marketingEventId, java.lang.String name, long imageFileEntryId,
		ServiceContext serviceContext) throws PortalException;

	/**
	* Adds the marketing event session room to the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEventSessionRoom the marketing event session room
	* @return the marketing event session room that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public MarketingEventSessionRoom addMarketingEventSessionRoom(
		MarketingEventSessionRoom marketingEventSessionRoom);

	/**
	* Creates a new marketing event session room with the primary key. Does not add the marketing event session room to the database.
	*
	* @param marketingEventSessionRoomId the primary key for the new marketing event session room
	* @return the new marketing event session room
	*/
	public MarketingEventSessionRoom createMarketingEventSessionRoom(
		long marketingEventSessionRoomId);

	/**
	* Deletes the marketing event session room with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEventSessionRoomId the primary key of the marketing event session room
	* @return the marketing event session room that was removed
	* @throws PortalException if a marketing event session room with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public MarketingEventSessionRoom deleteMarketingEventSessionRoom(
		long marketingEventSessionRoomId) throws PortalException;

	/**
	* Deletes the marketing event session room from the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEventSessionRoom the marketing event session room
	* @return the marketing event session room that was removed
	* @throws PortalException
	*/
	@Indexable(type = IndexableType.DELETE)
	public MarketingEventSessionRoom deleteMarketingEventSessionRoom(
		MarketingEventSessionRoom marketingEventSessionRoom)
		throws PortalException;

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	public DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.osb.www.marketing.events.model.impl.MarketingEventSessionRoomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.osb.www.marketing.events.model.impl.MarketingEventSessionRoomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MarketingEventSessionRoom fetchMarketingEventSessionRoom(
		long marketingEventSessionRoomId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	* Returns the marketing event session room with the primary key.
	*
	* @param marketingEventSessionRoomId the primary key of the marketing event session room
	* @return the marketing event session room
	* @throws PortalException if a marketing event session room with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MarketingEventSessionRoom getMarketingEventSessionRoom(
		long marketingEventSessionRoomId) throws PortalException;

	/**
	* Returns a range of all the marketing event session rooms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.osb.www.marketing.events.model.impl.MarketingEventSessionRoomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of marketing event session rooms
	* @param end the upper bound of the range of marketing event session rooms (not inclusive)
	* @return the range of marketing event session rooms
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MarketingEventSessionRoom> getMarketingEventSessionRooms(
		int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MarketingEventSessionRoom> getMarketingEventSessionRooms(
		long marketingEventId, int start, int end, OrderByComparator obc);

	/**
	* Returns the number of marketing event session rooms.
	*
	* @return the number of marketing event session rooms
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getMarketingEventSessionRoomsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getMarketingEventSessionRoomsCount(long marketingEventId);

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	public MarketingEventSessionRoom updateMarketingEventSessionRoom(
		long marketingEventSessionRoomId, java.lang.String name,
		long imageFileEntryId, ServiceContext serviceContext)
		throws PortalException;

	/**
	* Updates the marketing event session room in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param marketingEventSessionRoom the marketing event session room
	* @return the marketing event session room that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public MarketingEventSessionRoom updateMarketingEventSessionRoom(
		MarketingEventSessionRoom marketingEventSessionRoom);
}