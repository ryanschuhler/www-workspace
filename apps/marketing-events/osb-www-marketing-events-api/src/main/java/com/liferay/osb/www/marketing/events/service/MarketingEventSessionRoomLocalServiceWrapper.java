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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MarketingEventSessionRoomLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEventSessionRoomLocalService
 * @generated
 */
@ProviderType
public class MarketingEventSessionRoomLocalServiceWrapper
	implements MarketingEventSessionRoomLocalService,
		ServiceWrapper<MarketingEventSessionRoomLocalService> {
	public MarketingEventSessionRoomLocalServiceWrapper(
		MarketingEventSessionRoomLocalService marketingEventSessionRoomLocalService) {
		_marketingEventSessionRoomLocalService = marketingEventSessionRoomLocalService;
	}

	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventSessionRoom addMarketingEventSessionRoom(
		long marketingEventId, java.lang.String name, long imageFileEntryId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventSessionRoomLocalService.addMarketingEventSessionRoom(marketingEventId,
			name, imageFileEntryId, serviceContext);
	}

	/**
	* Adds the marketing event session room to the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEventSessionRoom the marketing event session room
	* @return the marketing event session room that was added
	*/
	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventSessionRoom addMarketingEventSessionRoom(
		com.liferay.osb.www.marketing.events.model.MarketingEventSessionRoom marketingEventSessionRoom) {
		return _marketingEventSessionRoomLocalService.addMarketingEventSessionRoom(marketingEventSessionRoom);
	}

	/**
	* Creates a new marketing event session room with the primary key. Does not add the marketing event session room to the database.
	*
	* @param marketingEventSessionRoomId the primary key for the new marketing event session room
	* @return the new marketing event session room
	*/
	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventSessionRoom createMarketingEventSessionRoom(
		long marketingEventSessionRoomId) {
		return _marketingEventSessionRoomLocalService.createMarketingEventSessionRoom(marketingEventSessionRoomId);
	}

	/**
	* Deletes the marketing event session room with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEventSessionRoomId the primary key of the marketing event session room
	* @return the marketing event session room that was removed
	* @throws PortalException if a marketing event session room with the primary key could not be found
	*/
	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventSessionRoom deleteMarketingEventSessionRoom(
		long marketingEventSessionRoomId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventSessionRoomLocalService.deleteMarketingEventSessionRoom(marketingEventSessionRoomId);
	}

	/**
	* Deletes the marketing event session room from the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEventSessionRoom the marketing event session room
	* @return the marketing event session room that was removed
	* @throws PortalException
	*/
	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventSessionRoom deleteMarketingEventSessionRoom(
		com.liferay.osb.www.marketing.events.model.MarketingEventSessionRoom marketingEventSessionRoom)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventSessionRoomLocalService.deleteMarketingEventSessionRoom(marketingEventSessionRoom);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventSessionRoomLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _marketingEventSessionRoomLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _marketingEventSessionRoomLocalService.dynamicQuery(dynamicQuery);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _marketingEventSessionRoomLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _marketingEventSessionRoomLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _marketingEventSessionRoomLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _marketingEventSessionRoomLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventSessionRoom fetchMarketingEventSessionRoom(
		long marketingEventSessionRoomId) {
		return _marketingEventSessionRoomLocalService.fetchMarketingEventSessionRoom(marketingEventSessionRoomId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _marketingEventSessionRoomLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _marketingEventSessionRoomLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the marketing event session room with the primary key.
	*
	* @param marketingEventSessionRoomId the primary key of the marketing event session room
	* @return the marketing event session room
	* @throws PortalException if a marketing event session room with the primary key could not be found
	*/
	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventSessionRoom getMarketingEventSessionRoom(
		long marketingEventSessionRoomId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventSessionRoomLocalService.getMarketingEventSessionRoom(marketingEventSessionRoomId);
	}

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
	@Override
	public java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventSessionRoom> getMarketingEventSessionRooms(
		int start, int end) {
		return _marketingEventSessionRoomLocalService.getMarketingEventSessionRooms(start,
			end);
	}

	@Override
	public java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventSessionRoom> getMarketingEventSessionRooms(
		long marketingEventId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc) {
		return _marketingEventSessionRoomLocalService.getMarketingEventSessionRooms(marketingEventId,
			start, end, obc);
	}

	/**
	* Returns the number of marketing event session rooms.
	*
	* @return the number of marketing event session rooms
	*/
	@Override
	public int getMarketingEventSessionRoomsCount() {
		return _marketingEventSessionRoomLocalService.getMarketingEventSessionRoomsCount();
	}

	@Override
	public int getMarketingEventSessionRoomsCount(long marketingEventId) {
		return _marketingEventSessionRoomLocalService.getMarketingEventSessionRoomsCount(marketingEventId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _marketingEventSessionRoomLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventSessionRoomLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventSessionRoom updateMarketingEventSessionRoom(
		long marketingEventSessionRoomId, java.lang.String name,
		long imageFileEntryId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventSessionRoomLocalService.updateMarketingEventSessionRoom(marketingEventSessionRoomId,
			name, imageFileEntryId, serviceContext);
	}

	/**
	* Updates the marketing event session room in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param marketingEventSessionRoom the marketing event session room
	* @return the marketing event session room that was updated
	*/
	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventSessionRoom updateMarketingEventSessionRoom(
		com.liferay.osb.www.marketing.events.model.MarketingEventSessionRoom marketingEventSessionRoom) {
		return _marketingEventSessionRoomLocalService.updateMarketingEventSessionRoom(marketingEventSessionRoom);
	}

	@Override
	public MarketingEventSessionRoomLocalService getWrappedService() {
		return _marketingEventSessionRoomLocalService;
	}

	@Override
	public void setWrappedService(
		MarketingEventSessionRoomLocalService marketingEventSessionRoomLocalService) {
		_marketingEventSessionRoomLocalService = marketingEventSessionRoomLocalService;
	}

	private MarketingEventSessionRoomLocalService _marketingEventSessionRoomLocalService;
}