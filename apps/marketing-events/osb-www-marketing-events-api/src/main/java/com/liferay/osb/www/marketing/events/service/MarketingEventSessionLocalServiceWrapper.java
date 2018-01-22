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
 * Provides a wrapper for {@link MarketingEventSessionLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEventSessionLocalService
 * @generated
 */
@ProviderType
public class MarketingEventSessionLocalServiceWrapper
	implements MarketingEventSessionLocalService,
		ServiceWrapper<MarketingEventSessionLocalService> {
	public MarketingEventSessionLocalServiceWrapper(
		MarketingEventSessionLocalService marketingEventSessionLocalService) {
		_marketingEventSessionLocalService = marketingEventSessionLocalService;
	}

	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventSession addMarketingEventSession(
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
		return _marketingEventSessionLocalService.addMarketingEventSession(userId,
			marketingEventId, marketingEventSessionRoomId, titleMap,
			descriptionMap, keywordsMap, slidesFileEntryId, videoURL,
			startDateMonth, startDateDay, startDateYear, startDateHour,
			startDateMinute, endDateMonth, endDateDay, endDateYear,
			endDateHour, endDateMinute, status, marketingEventUserIds,
			serviceContext);
	}

	/**
	* Adds the marketing event session to the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEventSession the marketing event session
	* @return the marketing event session that was added
	*/
	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventSession addMarketingEventSession(
		com.liferay.osb.www.marketing.events.model.MarketingEventSession marketingEventSession) {
		return _marketingEventSessionLocalService.addMarketingEventSession(marketingEventSession);
	}

	@Override
	public void addMarketingEventUserMarketingEventSession(
		long marketingEventUserId, long marketingEventSessionId) {
		_marketingEventSessionLocalService.addMarketingEventUserMarketingEventSession(marketingEventUserId,
			marketingEventSessionId);
	}

	@Override
	public void addMarketingEventUserMarketingEventSession(
		long marketingEventUserId,
		com.liferay.osb.www.marketing.events.model.MarketingEventSession marketingEventSession) {
		_marketingEventSessionLocalService.addMarketingEventUserMarketingEventSession(marketingEventUserId,
			marketingEventSession);
	}

	@Override
	public void addMarketingEventUserMarketingEventSessions(
		long marketingEventUserId,
		java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventSession> marketingEventSessions) {
		_marketingEventSessionLocalService.addMarketingEventUserMarketingEventSessions(marketingEventUserId,
			marketingEventSessions);
	}

	@Override
	public void addMarketingEventUserMarketingEventSessions(
		long marketingEventUserId, long[] marketingEventSessionIds) {
		_marketingEventSessionLocalService.addMarketingEventUserMarketingEventSessions(marketingEventUserId,
			marketingEventSessionIds);
	}

	@Override
	public void clearMarketingEventUserMarketingEventSessions(
		long marketingEventUserId) {
		_marketingEventSessionLocalService.clearMarketingEventUserMarketingEventSessions(marketingEventUserId);
	}

	/**
	* Creates a new marketing event session with the primary key. Does not add the marketing event session to the database.
	*
	* @param marketingEventSessionId the primary key for the new marketing event session
	* @return the new marketing event session
	*/
	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventSession createMarketingEventSession(
		long marketingEventSessionId) {
		return _marketingEventSessionLocalService.createMarketingEventSession(marketingEventSessionId);
	}

	/**
	* Deletes the marketing event session with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEventSessionId the primary key of the marketing event session
	* @return the marketing event session that was removed
	* @throws PortalException if a marketing event session with the primary key could not be found
	*/
	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventSession deleteMarketingEventSession(
		long marketingEventSessionId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventSessionLocalService.deleteMarketingEventSession(marketingEventSessionId);
	}

	/**
	* Deletes the marketing event session from the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEventSession the marketing event session
	* @return the marketing event session that was removed
	* @throws PortalException
	*/
	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventSession deleteMarketingEventSession(
		com.liferay.osb.www.marketing.events.model.MarketingEventSession marketingEventSession)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventSessionLocalService.deleteMarketingEventSession(marketingEventSession);
	}

	@Override
	public void deleteMarketingEventUserMarketingEventSession(
		long marketingEventUserId, long marketingEventSessionId) {
		_marketingEventSessionLocalService.deleteMarketingEventUserMarketingEventSession(marketingEventUserId,
			marketingEventSessionId);
	}

	@Override
	public void deleteMarketingEventUserMarketingEventSession(
		long marketingEventUserId,
		com.liferay.osb.www.marketing.events.model.MarketingEventSession marketingEventSession) {
		_marketingEventSessionLocalService.deleteMarketingEventUserMarketingEventSession(marketingEventUserId,
			marketingEventSession);
	}

	@Override
	public void deleteMarketingEventUserMarketingEventSessions(
		long marketingEventUserId,
		java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventSession> marketingEventSessions) {
		_marketingEventSessionLocalService.deleteMarketingEventUserMarketingEventSessions(marketingEventUserId,
			marketingEventSessions);
	}

	@Override
	public void deleteMarketingEventUserMarketingEventSessions(
		long marketingEventUserId, long[] marketingEventSessionIds) {
		_marketingEventSessionLocalService.deleteMarketingEventUserMarketingEventSessions(marketingEventUserId,
			marketingEventSessionIds);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventSessionLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _marketingEventSessionLocalService.dynamicQuery();
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
		return _marketingEventSessionLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _marketingEventSessionLocalService.dynamicQuery(dynamicQuery,
			start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _marketingEventSessionLocalService.dynamicQuery(dynamicQuery,
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
		return _marketingEventSessionLocalService.dynamicQueryCount(dynamicQuery);
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
		return _marketingEventSessionLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventSession fetchMarketingEventSession(
		long marketingEventSessionId) {
		return _marketingEventSessionLocalService.fetchMarketingEventSession(marketingEventSessionId);
	}

	/**
	* Returns the marketing event session with the matching UUID and company.
	*
	* @param uuid the marketing event session's UUID
	* @param companyId the primary key of the company
	* @return the matching marketing event session, or <code>null</code> if a matching marketing event session could not be found
	*/
	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventSession fetchMarketingEventSessionByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _marketingEventSessionLocalService.fetchMarketingEventSessionByUuidAndCompanyId(uuid,
			companyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _marketingEventSessionLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _marketingEventSessionLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _marketingEventSessionLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the marketing event session with the primary key.
	*
	* @param marketingEventSessionId the primary key of the marketing event session
	* @return the marketing event session
	* @throws PortalException if a marketing event session with the primary key could not be found
	*/
	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventSession getMarketingEventSession(
		long marketingEventSessionId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventSessionLocalService.getMarketingEventSession(marketingEventSessionId);
	}

	/**
	* Returns the marketing event session with the matching UUID and company.
	*
	* @param uuid the marketing event session's UUID
	* @param companyId the primary key of the company
	* @return the matching marketing event session
	* @throws PortalException if a matching marketing event session could not be found
	*/
	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventSession getMarketingEventSessionByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventSessionLocalService.getMarketingEventSessionByUuidAndCompanyId(uuid,
			companyId);
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
	@Override
	public java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventSession> getMarketingEventSessions(
		int start, int end) {
		return _marketingEventSessionLocalService.getMarketingEventSessions(start,
			end);
	}

	@Override
	public java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventSession> getMarketingEventSessions(
		long marketingEventId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc) {
		return _marketingEventSessionLocalService.getMarketingEventSessions(marketingEventId,
			status, start, end, obc);
	}

	@Override
	public java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventSession> getMarketingEventSessions(
		long marketingEventId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc) {
		return _marketingEventSessionLocalService.getMarketingEventSessions(marketingEventId,
			start, end, obc);
	}

	@Override
	public java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventSession> getMarketingEventSessions(
		long[] categoryIds, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventSessionLocalService.getMarketingEventSessions(categoryIds,
			statuses, start, end, obc);
	}

	/**
	* Returns the number of marketing event sessions.
	*
	* @return the number of marketing event sessions
	*/
	@Override
	public int getMarketingEventSessionsCount() {
		return _marketingEventSessionLocalService.getMarketingEventSessionsCount();
	}

	@Override
	public int getMarketingEventSessionsCount(long marketingEventId) {
		return _marketingEventSessionLocalService.getMarketingEventSessionsCount(marketingEventId);
	}

	@Override
	public int getMarketingEventSessionsCount(long marketingEventId,
		long marketingEventSessionRoomId) {
		return _marketingEventSessionLocalService.getMarketingEventSessionsCount(marketingEventId,
			marketingEventSessionRoomId);
	}

	@Override
	public java.util.Map<java.util.Date, java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventSession>> getMarketingEventSessionsMap(
		long marketingEventId, boolean asc)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventSessionLocalService.getMarketingEventSessionsMap(marketingEventId,
			asc);
	}

	@Override
	public java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventUser> getMarketingEventSessionUsers(
		long marketingEventSessionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc) {
		return _marketingEventSessionLocalService.getMarketingEventSessionUsers(marketingEventSessionId,
			start, end, obc);
	}

	@Override
	public java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventSession> getMarketingEventUserMarketingEventSessions(
		long marketingEventUserId) {
		return _marketingEventSessionLocalService.getMarketingEventUserMarketingEventSessions(marketingEventUserId);
	}

	@Override
	public java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventSession> getMarketingEventUserMarketingEventSessions(
		long marketingEventUserId, int start, int end) {
		return _marketingEventSessionLocalService.getMarketingEventUserMarketingEventSessions(marketingEventUserId,
			start, end);
	}

	@Override
	public java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventSession> getMarketingEventUserMarketingEventSessions(
		long marketingEventUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.osb.www.marketing.events.model.MarketingEventSession> orderByComparator) {
		return _marketingEventSessionLocalService.getMarketingEventUserMarketingEventSessions(marketingEventUserId,
			start, end, orderByComparator);
	}

	@Override
	public int getMarketingEventUserMarketingEventSessionsCount(
		long marketingEventUserId) {
		return _marketingEventSessionLocalService.getMarketingEventUserMarketingEventSessionsCount(marketingEventUserId);
	}

	/**
	* Returns the marketingEventUserIds of the marketing event users associated with the marketing event session.
	*
	* @param marketingEventSessionId the marketingEventSessionId of the marketing event session
	* @return long[] the marketingEventUserIds of marketing event users associated with the marketing event session
	*/
	@Override
	public long[] getMarketingEventUserPrimaryKeys(long marketingEventSessionId) {
		return _marketingEventSessionLocalService.getMarketingEventUserPrimaryKeys(marketingEventSessionId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _marketingEventSessionLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventSessionLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public boolean hasMarketingEventUserMarketingEventSession(
		long marketingEventUserId, long marketingEventSessionId) {
		return _marketingEventSessionLocalService.hasMarketingEventUserMarketingEventSession(marketingEventUserId,
			marketingEventSessionId);
	}

	@Override
	public boolean hasMarketingEventUserMarketingEventSessions(
		long marketingEventUserId) {
		return _marketingEventSessionLocalService.hasMarketingEventUserMarketingEventSessions(marketingEventUserId);
	}

	@Override
	public void setMarketingEventUserMarketingEventSessions(
		long marketingEventUserId, long[] marketingEventSessionIds) {
		_marketingEventSessionLocalService.setMarketingEventUserMarketingEventSessions(marketingEventUserId,
			marketingEventSessionIds);
	}

	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventSession updateMarketingEventSession(
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
		return _marketingEventSessionLocalService.updateMarketingEventSession(marketingEventSessionId,
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
	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventSession updateMarketingEventSession(
		com.liferay.osb.www.marketing.events.model.MarketingEventSession marketingEventSession) {
		return _marketingEventSessionLocalService.updateMarketingEventSession(marketingEventSession);
	}

	@Override
	public MarketingEventSessionLocalService getWrappedService() {
		return _marketingEventSessionLocalService;
	}

	@Override
	public void setWrappedService(
		MarketingEventSessionLocalService marketingEventSessionLocalService) {
		_marketingEventSessionLocalService = marketingEventSessionLocalService;
	}

	private MarketingEventSessionLocalService _marketingEventSessionLocalService;
}