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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for MarketingEventSessionRoom. This utility wraps
 * {@link com.liferay.osb.www.marketing.events.service.impl.MarketingEventSessionRoomLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEventSessionRoomLocalService
 * @see com.liferay.osb.www.marketing.events.service.base.MarketingEventSessionRoomLocalServiceBaseImpl
 * @see com.liferay.osb.www.marketing.events.service.impl.MarketingEventSessionRoomLocalServiceImpl
 * @generated
 */
@ProviderType
public class MarketingEventSessionRoomLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.osb.www.marketing.events.service.impl.MarketingEventSessionRoomLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.osb.www.marketing.events.model.MarketingEventSessionRoom addMarketingEventSessionRoom(
		long marketingEventId, java.lang.String name, long imageFileEntryId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addMarketingEventSessionRoom(marketingEventId, name,
			imageFileEntryId, serviceContext);
	}

	/**
	* Adds the marketing event session room to the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEventSessionRoom the marketing event session room
	* @return the marketing event session room that was added
	*/
	public static com.liferay.osb.www.marketing.events.model.MarketingEventSessionRoom addMarketingEventSessionRoom(
		com.liferay.osb.www.marketing.events.model.MarketingEventSessionRoom marketingEventSessionRoom) {
		return getService()
				   .addMarketingEventSessionRoom(marketingEventSessionRoom);
	}

	/**
	* Creates a new marketing event session room with the primary key. Does not add the marketing event session room to the database.
	*
	* @param marketingEventSessionRoomId the primary key for the new marketing event session room
	* @return the new marketing event session room
	*/
	public static com.liferay.osb.www.marketing.events.model.MarketingEventSessionRoom createMarketingEventSessionRoom(
		long marketingEventSessionRoomId) {
		return getService()
				   .createMarketingEventSessionRoom(marketingEventSessionRoomId);
	}

	/**
	* Deletes the marketing event session room with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEventSessionRoomId the primary key of the marketing event session room
	* @return the marketing event session room that was removed
	* @throws PortalException if a marketing event session room with the primary key could not be found
	*/
	public static com.liferay.osb.www.marketing.events.model.MarketingEventSessionRoom deleteMarketingEventSessionRoom(
		long marketingEventSessionRoomId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .deleteMarketingEventSessionRoom(marketingEventSessionRoomId);
	}

	/**
	* Deletes the marketing event session room from the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEventSessionRoom the marketing event session room
	* @return the marketing event session room that was removed
	* @throws PortalException
	*/
	public static com.liferay.osb.www.marketing.events.model.MarketingEventSessionRoom deleteMarketingEventSessionRoom(
		com.liferay.osb.www.marketing.events.model.MarketingEventSessionRoom marketingEventSessionRoom)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .deleteMarketingEventSessionRoom(marketingEventSessionRoom);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.osb.www.marketing.events.model.MarketingEventSessionRoom fetchMarketingEventSessionRoom(
		long marketingEventSessionRoomId) {
		return getService()
				   .fetchMarketingEventSessionRoom(marketingEventSessionRoomId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the marketing event session room with the primary key.
	*
	* @param marketingEventSessionRoomId the primary key of the marketing event session room
	* @return the marketing event session room
	* @throws PortalException if a marketing event session room with the primary key could not be found
	*/
	public static com.liferay.osb.www.marketing.events.model.MarketingEventSessionRoom getMarketingEventSessionRoom(
		long marketingEventSessionRoomId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .getMarketingEventSessionRoom(marketingEventSessionRoomId);
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
	public static java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventSessionRoom> getMarketingEventSessionRooms(
		int start, int end) {
		return getService().getMarketingEventSessionRooms(start, end);
	}

	public static java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventSessionRoom> getMarketingEventSessionRooms(
		long marketingEventId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc) {
		return getService()
				   .getMarketingEventSessionRooms(marketingEventId, start, end,
			obc);
	}

	/**
	* Returns the number of marketing event session rooms.
	*
	* @return the number of marketing event session rooms
	*/
	public static int getMarketingEventSessionRoomsCount() {
		return getService().getMarketingEventSessionRoomsCount();
	}

	public static int getMarketingEventSessionRoomsCount(long marketingEventId) {
		return getService().getMarketingEventSessionRoomsCount(marketingEventId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	public static com.liferay.osb.www.marketing.events.model.MarketingEventSessionRoom updateMarketingEventSessionRoom(
		long marketingEventSessionRoomId, java.lang.String name,
		long imageFileEntryId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateMarketingEventSessionRoom(marketingEventSessionRoomId,
			name, imageFileEntryId, serviceContext);
	}

	/**
	* Updates the marketing event session room in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param marketingEventSessionRoom the marketing event session room
	* @return the marketing event session room that was updated
	*/
	public static com.liferay.osb.www.marketing.events.model.MarketingEventSessionRoom updateMarketingEventSessionRoom(
		com.liferay.osb.www.marketing.events.model.MarketingEventSessionRoom marketingEventSessionRoom) {
		return getService()
				   .updateMarketingEventSessionRoom(marketingEventSessionRoom);
	}

	public static MarketingEventSessionRoomLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<MarketingEventSessionRoomLocalService, MarketingEventSessionRoomLocalService> _serviceTracker =
		ServiceTrackerFactory.open(MarketingEventSessionRoomLocalService.class);
}