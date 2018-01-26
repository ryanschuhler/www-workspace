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
 * Provides the local service utility for MarketingEventUser. This utility wraps
 * {@link com.liferay.osb.www.marketing.events.service.impl.MarketingEventUserLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEventUserLocalService
 * @see com.liferay.osb.www.marketing.events.service.base.MarketingEventUserLocalServiceBaseImpl
 * @see com.liferay.osb.www.marketing.events.service.impl.MarketingEventUserLocalServiceImpl
 * @generated
 */
@ProviderType
public class MarketingEventUserLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.osb.www.marketing.events.service.impl.MarketingEventUserLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addMarketingEventSessionMarketingEventUser(
		long marketingEventSessionId, long marketingEventUserId) {
		getService()
			.addMarketingEventSessionMarketingEventUser(marketingEventSessionId,
			marketingEventUserId);
	}

	public static void addMarketingEventSessionMarketingEventUser(
		long marketingEventSessionId,
		com.liferay.osb.www.marketing.events.model.MarketingEventUser marketingEventUser) {
		getService()
			.addMarketingEventSessionMarketingEventUser(marketingEventSessionId,
			marketingEventUser);
	}

	public static void addMarketingEventSessionMarketingEventUsers(
		long marketingEventSessionId,
		java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventUser> marketingEventUsers) {
		getService()
			.addMarketingEventSessionMarketingEventUsers(marketingEventSessionId,
			marketingEventUsers);
	}

	public static void addMarketingEventSessionMarketingEventUsers(
		long marketingEventSessionId, long[] marketingEventUserIds) {
		getService()
			.addMarketingEventSessionMarketingEventUsers(marketingEventSessionId,
			marketingEventUserIds);
	}

	public static com.liferay.osb.www.marketing.events.model.MarketingEventUser addMarketingEventUser(
		long userId, long marketingEventId, java.lang.String firstName,
		java.lang.String lastName, java.lang.String companyName,
		long companyLogoFileEntryId,
		java.util.Map<java.util.Locale, java.lang.String> jobTitleMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		long imageFileEntryId, java.lang.String phoneNumber, int status,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addMarketingEventUser(userId, marketingEventId, firstName,
			lastName, companyName, companyLogoFileEntryId, jobTitleMap,
			descriptionMap, imageFileEntryId, phoneNumber, status,
			serviceContext);
	}

	/**
	* Adds the marketing event user to the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEventUser the marketing event user
	* @return the marketing event user that was added
	*/
	public static com.liferay.osb.www.marketing.events.model.MarketingEventUser addMarketingEventUser(
		com.liferay.osb.www.marketing.events.model.MarketingEventUser marketingEventUser) {
		return getService().addMarketingEventUser(marketingEventUser);
	}

	public static void clearMarketingEventSessionMarketingEventUsers(
		long marketingEventSessionId) {
		getService()
			.clearMarketingEventSessionMarketingEventUsers(marketingEventSessionId);
	}

	/**
	* Creates a new marketing event user with the primary key. Does not add the marketing event user to the database.
	*
	* @param marketingEventUserId the primary key for the new marketing event user
	* @return the new marketing event user
	*/
	public static com.liferay.osb.www.marketing.events.model.MarketingEventUser createMarketingEventUser(
		long marketingEventUserId) {
		return getService().createMarketingEventUser(marketingEventUserId);
	}

	public static void deleteMarketingEventSessionMarketingEventUser(
		long marketingEventSessionId, long marketingEventUserId) {
		getService()
			.deleteMarketingEventSessionMarketingEventUser(marketingEventSessionId,
			marketingEventUserId);
	}

	public static void deleteMarketingEventSessionMarketingEventUser(
		long marketingEventSessionId,
		com.liferay.osb.www.marketing.events.model.MarketingEventUser marketingEventUser) {
		getService()
			.deleteMarketingEventSessionMarketingEventUser(marketingEventSessionId,
			marketingEventUser);
	}

	public static void deleteMarketingEventSessionMarketingEventUsers(
		long marketingEventSessionId,
		java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventUser> marketingEventUsers) {
		getService()
			.deleteMarketingEventSessionMarketingEventUsers(marketingEventSessionId,
			marketingEventUsers);
	}

	public static void deleteMarketingEventSessionMarketingEventUsers(
		long marketingEventSessionId, long[] marketingEventUserIds) {
		getService()
			.deleteMarketingEventSessionMarketingEventUsers(marketingEventSessionId,
			marketingEventUserIds);
	}

	/**
	* Deletes the marketing event user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEventUserId the primary key of the marketing event user
	* @return the marketing event user that was removed
	* @throws PortalException if a marketing event user with the primary key could not be found
	*/
	public static com.liferay.osb.www.marketing.events.model.MarketingEventUser deleteMarketingEventUser(
		long marketingEventUserId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteMarketingEventUser(marketingEventUserId);
	}

	/**
	* Deletes the marketing event user from the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEventUser the marketing event user
	* @return the marketing event user that was removed
	* @throws PortalException
	*/
	public static com.liferay.osb.www.marketing.events.model.MarketingEventUser deleteMarketingEventUser(
		com.liferay.osb.www.marketing.events.model.MarketingEventUser marketingEventUser)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteMarketingEventUser(marketingEventUser);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.osb.www.marketing.events.model.impl.MarketingEventUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.osb.www.marketing.events.model.impl.MarketingEventUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.osb.www.marketing.events.model.MarketingEventUser fetchMarketingEventUser(
		long marketingEventUserId) {
		return getService().fetchMarketingEventUser(marketingEventUserId);
	}

	/**
	* Returns the marketing event user with the matching UUID and company.
	*
	* @param uuid the marketing event user's UUID
	* @param companyId the primary key of the company
	* @return the matching marketing event user, or <code>null</code> if a matching marketing event user could not be found
	*/
	public static com.liferay.osb.www.marketing.events.model.MarketingEventUser fetchMarketingEventUserByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService()
				   .fetchMarketingEventUserByUuidAndCompanyId(uuid, companyId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	public static java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventUser> getMarketingEventSessionMarketingEventUsers(
		long marketingEventSessionId) {
		return getService()
				   .getMarketingEventSessionMarketingEventUsers(marketingEventSessionId);
	}

	public static java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventUser> getMarketingEventSessionMarketingEventUsers(
		long marketingEventSessionId, int start, int end) {
		return getService()
				   .getMarketingEventSessionMarketingEventUsers(marketingEventSessionId,
			start, end);
	}

	public static java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventUser> getMarketingEventSessionMarketingEventUsers(
		long marketingEventSessionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.osb.www.marketing.events.model.MarketingEventUser> orderByComparator) {
		return getService()
				   .getMarketingEventSessionMarketingEventUsers(marketingEventSessionId,
			start, end, orderByComparator);
	}

	public static int getMarketingEventSessionMarketingEventUsersCount(
		long marketingEventSessionId) {
		return getService()
				   .getMarketingEventSessionMarketingEventUsersCount(marketingEventSessionId);
	}

	/**
	* Returns the marketingEventSessionIds of the marketing event sessions associated with the marketing event user.
	*
	* @param marketingEventUserId the marketingEventUserId of the marketing event user
	* @return long[] the marketingEventSessionIds of marketing event sessions associated with the marketing event user
	*/
	public static long[] getMarketingEventSessionPrimaryKeys(
		long marketingEventUserId) {
		return getService()
				   .getMarketingEventSessionPrimaryKeys(marketingEventUserId);
	}

	/**
	* Returns the marketing event user with the primary key.
	*
	* @param marketingEventUserId the primary key of the marketing event user
	* @return the marketing event user
	* @throws PortalException if a marketing event user with the primary key could not be found
	*/
	public static com.liferay.osb.www.marketing.events.model.MarketingEventUser getMarketingEventUser(
		long marketingEventUserId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getMarketingEventUser(marketingEventUserId);
	}

	/**
	* Returns the marketing event user with the matching UUID and company.
	*
	* @param uuid the marketing event user's UUID
	* @param companyId the primary key of the company
	* @return the matching marketing event user
	* @throws PortalException if a matching marketing event user could not be found
	*/
	public static com.liferay.osb.www.marketing.events.model.MarketingEventUser getMarketingEventUserByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .getMarketingEventUserByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of all the marketing event users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.osb.www.marketing.events.model.impl.MarketingEventUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of marketing event users
	* @param end the upper bound of the range of marketing event users (not inclusive)
	* @return the range of marketing event users
	*/
	public static java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventUser> getMarketingEventUsers(
		int start, int end) {
		return getService().getMarketingEventUsers(start, end);
	}

	public static java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventUser> getMarketingEventUsers(
		long marketingEventId, int status, int start, int end) {
		return getService()
				   .getMarketingEventUsers(marketingEventId, status, start, end);
	}

	public static java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventUser> getMarketingEventUsers(
		long marketingEventId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc) {
		return getService()
				   .getMarketingEventUsers(marketingEventId, status, start,
			end, obc);
	}

	public static java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventUser> getMarketingEventUsers(
		long marketingEventId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc) {
		return getService()
				   .getMarketingEventUsers(marketingEventId, start, end, obc);
	}

	public static java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventUser> getMarketingEventUsers(
		long marketingEventId, long[] categoryIds, long[] notCategoryIds,
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getMarketingEventUsers(marketingEventId, categoryIds,
			notCategoryIds, start, end, obc);
	}

	public static java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventUser> getMarketingEventUsers(
		long[] categoryIds, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc) {
		return getService()
				   .getMarketingEventUsers(categoryIds, statuses, start, end,
			obc);
	}

	/**
	* Returns the number of marketing event users.
	*
	* @return the number of marketing event users
	*/
	public static int getMarketingEventUsersCount() {
		return getService().getMarketingEventUsersCount();
	}

	public static int getMarketingEventUsersCount(long marketingEventId) {
		return getService().getMarketingEventUsersCount(marketingEventId);
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

	public static boolean hasMarketingEventSessionMarketingEventUser(
		long marketingEventSessionId, long marketingEventUserId) {
		return getService()
				   .hasMarketingEventSessionMarketingEventUser(marketingEventSessionId,
			marketingEventUserId);
	}

	public static boolean hasMarketingEventSessionMarketingEventUsers(
		long marketingEventSessionId) {
		return getService()
				   .hasMarketingEventSessionMarketingEventUsers(marketingEventSessionId);
	}

	public static void setMarketingEventSessionMarketingEventUsers(
		long marketingEventSessionId, long[] marketingEventUserIds) {
		getService()
			.setMarketingEventSessionMarketingEventUsers(marketingEventSessionId,
			marketingEventUserIds);
	}

	public static com.liferay.osb.www.marketing.events.model.MarketingEventUser updateMarketingEventUser(
		long userId, long marketingEventUserId, java.lang.String firstName,
		java.lang.String lastName, java.lang.String companyName,
		long companyLogoFileEntryId,
		java.util.Map<java.util.Locale, java.lang.String> jobTitleMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		long imageFileEntryId, java.lang.String phoneNumber, int status,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateMarketingEventUser(userId, marketingEventUserId,
			firstName, lastName, companyName, companyLogoFileEntryId,
			jobTitleMap, descriptionMap, imageFileEntryId, phoneNumber, status,
			serviceContext);
	}

	/**
	* Updates the marketing event user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param marketingEventUser the marketing event user
	* @return the marketing event user that was updated
	*/
	public static com.liferay.osb.www.marketing.events.model.MarketingEventUser updateMarketingEventUser(
		com.liferay.osb.www.marketing.events.model.MarketingEventUser marketingEventUser) {
		return getService().updateMarketingEventUser(marketingEventUser);
	}

	public static com.liferay.osb.www.marketing.events.model.MarketingEventUser updateStatus(
		long userId, long marketingEventUserId, int status, int priority,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateStatus(userId, marketingEventUserId, status,
			priority, serviceContext);
	}

	public static MarketingEventUserLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<MarketingEventUserLocalService, MarketingEventUserLocalService> _serviceTracker =
		ServiceTrackerFactory.open(MarketingEventUserLocalService.class);
}