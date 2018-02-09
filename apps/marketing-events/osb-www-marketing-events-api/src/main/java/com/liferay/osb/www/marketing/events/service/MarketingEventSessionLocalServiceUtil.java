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
 * Provides the local service utility for MarketingEventSession. This utility wraps
 * {@link com.liferay.osb.www.marketing.events.service.impl.MarketingEventSessionLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEventSessionLocalService
 * @see com.liferay.osb.www.marketing.events.service.base.MarketingEventSessionLocalServiceBaseImpl
 * @see com.liferay.osb.www.marketing.events.service.impl.MarketingEventSessionLocalServiceImpl
 * @generated
 */
@ProviderType
public class MarketingEventSessionLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.osb.www.marketing.events.service.impl.MarketingEventSessionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.osb.www.marketing.events.model.MarketingEventSession addMarketingEventSession(
		long userId, long marketingEventId, long marketingEventSessionRoomId,
		java.util.Map<java.util.Locale, java.lang.String> titleMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Map<java.util.Locale, java.lang.String> keywordsMap,
		long slidesFileEntryId, java.lang.String videoURL, int startDateMonth,
		int startDateDay, int startDateYear, int startDateHour,
		int startDateMinute, int endDateMonth, int endDateDay, int endDateYear,
		int endDateHour, int endDateMinute, int status,
		long[] marketingEventUserIds,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addMarketingEventSession(userId, marketingEventId,
			marketingEventSessionRoomId, titleMap, descriptionMap, keywordsMap,
			slidesFileEntryId, videoURL, startDateMonth, startDateDay,
			startDateYear, startDateHour, startDateMinute, endDateMonth,
			endDateDay, endDateYear, endDateHour, endDateMinute, status,
			marketingEventUserIds, serviceContext);
	}

	/**
	* Adds the marketing event session to the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEventSession the marketing event session
	* @return the marketing event session that was added
	*/
	public static com.liferay.osb.www.marketing.events.model.MarketingEventSession addMarketingEventSession(
		com.liferay.osb.www.marketing.events.model.MarketingEventSession marketingEventSession) {
		return getService().addMarketingEventSession(marketingEventSession);
	}

	public static void addMarketingEventUserMarketingEventSession(
		long marketingEventUserId, long marketingEventSessionId) {
		getService()
			.addMarketingEventUserMarketingEventSession(marketingEventUserId,
			marketingEventSessionId);
	}

	public static void addMarketingEventUserMarketingEventSession(
		long marketingEventUserId,
		com.liferay.osb.www.marketing.events.model.MarketingEventSession marketingEventSession) {
		getService()
			.addMarketingEventUserMarketingEventSession(marketingEventUserId,
			marketingEventSession);
	}

	public static void addMarketingEventUserMarketingEventSessions(
		long marketingEventUserId,
		java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventSession> marketingEventSessions) {
		getService()
			.addMarketingEventUserMarketingEventSessions(marketingEventUserId,
			marketingEventSessions);
	}

	public static void addMarketingEventUserMarketingEventSessions(
		long marketingEventUserId, long[] marketingEventSessionIds) {
		getService()
			.addMarketingEventUserMarketingEventSessions(marketingEventUserId,
			marketingEventSessionIds);
	}

	public static void clearMarketingEventUserMarketingEventSessions(
		long marketingEventUserId) {
		getService()
			.clearMarketingEventUserMarketingEventSessions(marketingEventUserId);
	}

	/**
	* Creates a new marketing event session with the primary key. Does not add the marketing event session to the database.
	*
	* @param marketingEventSessionId the primary key for the new marketing event session
	* @return the new marketing event session
	*/
	public static com.liferay.osb.www.marketing.events.model.MarketingEventSession createMarketingEventSession(
		long marketingEventSessionId) {
		return getService().createMarketingEventSession(marketingEventSessionId);
	}

	/**
	* Deletes the marketing event session with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEventSessionId the primary key of the marketing event session
	* @return the marketing event session that was removed
	* @throws PortalException if a marketing event session with the primary key could not be found
	*/
	public static com.liferay.osb.www.marketing.events.model.MarketingEventSession deleteMarketingEventSession(
		long marketingEventSessionId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteMarketingEventSession(marketingEventSessionId);
	}

	/**
	* Deletes the marketing event session from the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEventSession the marketing event session
	* @return the marketing event session that was removed
	* @throws PortalException
	*/
	public static com.liferay.osb.www.marketing.events.model.MarketingEventSession deleteMarketingEventSession(
		com.liferay.osb.www.marketing.events.model.MarketingEventSession marketingEventSession)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteMarketingEventSession(marketingEventSession);
	}

	public static void deleteMarketingEventUserMarketingEventSession(
		long marketingEventUserId, long marketingEventSessionId) {
		getService()
			.deleteMarketingEventUserMarketingEventSession(marketingEventUserId,
			marketingEventSessionId);
	}

	public static void deleteMarketingEventUserMarketingEventSession(
		long marketingEventUserId,
		com.liferay.osb.www.marketing.events.model.MarketingEventSession marketingEventSession) {
		getService()
			.deleteMarketingEventUserMarketingEventSession(marketingEventUserId,
			marketingEventSession);
	}

	public static void deleteMarketingEventUserMarketingEventSessions(
		long marketingEventUserId,
		java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventSession> marketingEventSessions) {
		getService()
			.deleteMarketingEventUserMarketingEventSessions(marketingEventUserId,
			marketingEventSessions);
	}

	public static void deleteMarketingEventUserMarketingEventSessions(
		long marketingEventUserId, long[] marketingEventSessionIds) {
		getService()
			.deleteMarketingEventUserMarketingEventSessions(marketingEventUserId,
			marketingEventSessionIds);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.osb.www.marketing.events.model.impl.MarketingEventSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.osb.www.marketing.events.model.impl.MarketingEventSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.osb.www.marketing.events.model.MarketingEventSession fetchMarketingEventSession(
		long marketingEventSessionId) {
		return getService().fetchMarketingEventSession(marketingEventSessionId);
	}

	/**
	* Returns the marketing event session with the matching UUID and company.
	*
	* @param uuid the marketing event session's UUID
	* @param companyId the primary key of the company
	* @return the matching marketing event session, or <code>null</code> if a matching marketing event session could not be found
	*/
	public static com.liferay.osb.www.marketing.events.model.MarketingEventSession fetchMarketingEventSessionByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService()
				   .fetchMarketingEventSessionByUuidAndCompanyId(uuid, companyId);
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

	/**
	* Returns the marketing event session with the primary key.
	*
	* @param marketingEventSessionId the primary key of the marketing event session
	* @return the marketing event session
	* @throws PortalException if a marketing event session with the primary key could not be found
	*/
	public static com.liferay.osb.www.marketing.events.model.MarketingEventSession getMarketingEventSession(
		long marketingEventSessionId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getMarketingEventSession(marketingEventSessionId);
	}

	/**
	* Returns the marketing event session with the matching UUID and company.
	*
	* @param uuid the marketing event session's UUID
	* @param companyId the primary key of the company
	* @return the matching marketing event session
	* @throws PortalException if a matching marketing event session could not be found
	*/
	public static com.liferay.osb.www.marketing.events.model.MarketingEventSession getMarketingEventSessionByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .getMarketingEventSessionByUuidAndCompanyId(uuid, companyId);
	}

	public static java.util.List<java.util.Map.Entry<java.util.Date, java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventSession>>> getMarketingEventSessionEntries(
		long marketingEventId, boolean asc)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .getMarketingEventSessionEntries(marketingEventId, asc);
	}

	/**
	* Returns a range of all the marketing event sessions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.osb.www.marketing.events.model.impl.MarketingEventSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of marketing event sessions
	* @param end the upper bound of the range of marketing event sessions (not inclusive)
	* @return the range of marketing event sessions
	*/
	public static java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventSession> getMarketingEventSessions(
		int start, int end) {
		return getService().getMarketingEventSessions(start, end);
	}

	public static java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventSession> getMarketingEventSessions(
		long marketingEventId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc) {
		return getService()
				   .getMarketingEventSessions(marketingEventId, status, start,
			end, obc);
	}

	public static java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventSession> getMarketingEventSessions(
		long marketingEventId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc) {
		return getService()
				   .getMarketingEventSessions(marketingEventId, start, end, obc);
	}

	public static java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventSession> getMarketingEventSessions(
		long[] categoryIds, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .getMarketingEventSessions(categoryIds, statuses, start,
			end, obc);
	}

	/**
	* Returns the number of marketing event sessions.
	*
	* @return the number of marketing event sessions
	*/
	public static int getMarketingEventSessionsCount() {
		return getService().getMarketingEventSessionsCount();
	}

	public static int getMarketingEventSessionsCount(long marketingEventId) {
		return getService().getMarketingEventSessionsCount(marketingEventId);
	}

	public static int getMarketingEventSessionsCount(long marketingEventId,
		long marketingEventSessionRoomId) {
		return getService()
				   .getMarketingEventSessionsCount(marketingEventId,
			marketingEventSessionRoomId);
	}

	public static java.util.Map<java.util.Date, java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventSession>> getMarketingEventSessionsMap(
		long marketingEventId, boolean asc)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getMarketingEventSessionsMap(marketingEventId, asc);
	}

	public static java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventUser> getMarketingEventSessionUsers(
		long marketingEventSessionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc) {
		return getService()
				   .getMarketingEventSessionUsers(marketingEventSessionId,
			start, end, obc);
	}

	public static java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventSession> getMarketingEventUserMarketingEventSessions(
		long marketingEventUserId) {
		return getService()
				   .getMarketingEventUserMarketingEventSessions(marketingEventUserId);
	}

	public static java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventSession> getMarketingEventUserMarketingEventSessions(
		long marketingEventUserId, int start, int end) {
		return getService()
				   .getMarketingEventUserMarketingEventSessions(marketingEventUserId,
			start, end);
	}

	public static java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventSession> getMarketingEventUserMarketingEventSessions(
		long marketingEventUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.osb.www.marketing.events.model.MarketingEventSession> orderByComparator) {
		return getService()
				   .getMarketingEventUserMarketingEventSessions(marketingEventUserId,
			start, end, orderByComparator);
	}

	public static int getMarketingEventUserMarketingEventSessionsCount(
		long marketingEventUserId) {
		return getService()
				   .getMarketingEventUserMarketingEventSessionsCount(marketingEventUserId);
	}

	/**
	* Returns the marketingEventUserIds of the marketing event users associated with the marketing event session.
	*
	* @param marketingEventSessionId the marketingEventSessionId of the marketing event session
	* @return long[] the marketingEventUserIds of marketing event users associated with the marketing event session
	*/
	public static long[] getMarketingEventUserPrimaryKeys(
		long marketingEventSessionId) {
		return getService()
				   .getMarketingEventUserPrimaryKeys(marketingEventSessionId);
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

	public static boolean hasMarketingEventUserMarketingEventSession(
		long marketingEventUserId, long marketingEventSessionId) {
		return getService()
				   .hasMarketingEventUserMarketingEventSession(marketingEventUserId,
			marketingEventSessionId);
	}

	public static boolean hasMarketingEventUserMarketingEventSessions(
		long marketingEventUserId) {
		return getService()
				   .hasMarketingEventUserMarketingEventSessions(marketingEventUserId);
	}

	public static void setMarketingEventUserMarketingEventSessions(
		long marketingEventUserId, long[] marketingEventSessionIds) {
		getService()
			.setMarketingEventUserMarketingEventSessions(marketingEventUserId,
			marketingEventSessionIds);
	}

	public static void updateAsset(long userId, long groupId,
		com.liferay.osb.www.marketing.events.model.MarketingEventSession marketingEventSession,
		long[] assetCategoryIds, java.lang.String[] assetTagNames,
		long[] assetLinkEntryIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.search.SearchException {
		getService()
			.updateAsset(userId, groupId, marketingEventSession,
			assetCategoryIds, assetTagNames, assetLinkEntryIds);
	}

	public static com.liferay.osb.www.marketing.events.model.MarketingEventSession updateMarketingEventSession(
		long marketingEventSessionId, long marketingEventSessionRoomId,
		java.util.Map<java.util.Locale, java.lang.String> titleMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Map<java.util.Locale, java.lang.String> keywordsMap,
		long slidesFileEntryId, java.lang.String videoURL, int startDateMonth,
		int startDateDay, int startDateYear, int startDateHour,
		int startDateMinute, int endDateMonth, int endDateDay, int endDateYear,
		int endDateHour, int endDateMinute, int status,
		long[] marketingEventUserIds,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateMarketingEventSession(marketingEventSessionId,
			marketingEventSessionRoomId, titleMap, descriptionMap, keywordsMap,
			slidesFileEntryId, videoURL, startDateMonth, startDateDay,
			startDateYear, startDateHour, startDateMinute, endDateMonth,
			endDateDay, endDateYear, endDateHour, endDateMinute, status,
			marketingEventUserIds, serviceContext);
	}

	/**
	* Updates the marketing event session in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param marketingEventSession the marketing event session
	* @return the marketing event session that was updated
	*/
	public static com.liferay.osb.www.marketing.events.model.MarketingEventSession updateMarketingEventSession(
		com.liferay.osb.www.marketing.events.model.MarketingEventSession marketingEventSession) {
		return getService().updateMarketingEventSession(marketingEventSession);
	}

	public static MarketingEventSessionLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<MarketingEventSessionLocalService, MarketingEventSessionLocalService> _serviceTracker =
		ServiceTrackerFactory.open(MarketingEventSessionLocalService.class);
}