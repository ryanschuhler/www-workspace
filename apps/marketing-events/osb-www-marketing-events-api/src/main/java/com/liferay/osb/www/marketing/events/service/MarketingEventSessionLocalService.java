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

import com.liferay.exportimport.kernel.lar.PortletDataContext;

import com.liferay.osb.www.marketing.events.model.MarketingEventSession;
import com.liferay.osb.www.marketing.events.model.MarketingEventUser;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Provides the local service interface for MarketingEventSession. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEventSessionLocalServiceUtil
 * @see com.liferay.osb.www.marketing.events.service.base.MarketingEventSessionLocalServiceBaseImpl
 * @see com.liferay.osb.www.marketing.events.service.impl.MarketingEventSessionLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface MarketingEventSessionLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MarketingEventSessionLocalServiceUtil} to access the marketing event session local service. Add custom service methods to {@link com.liferay.osb.www.marketing.events.service.impl.MarketingEventSessionLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public MarketingEventSession addMarketingEventSession(long userId,
		long marketingEventId, long marketingEventSessionRoomId,
		Map<Locale, java.lang.String> titleMap,
		Map<Locale, java.lang.String> descriptionMap,
		Map<Locale, java.lang.String> keywordsMap, long slidesFileEntryId,
		java.lang.String videoURL, int startDateMonth, int startDateDay,
		int startDateYear, int startDateHour, int startDateMinute,
		int endDateMonth, int endDateDay, int endDateYear, int endDateHour,
		int endDateMinute, int status, long[] marketingEventUserIds,
		ServiceContext serviceContext) throws PortalException;

	/**
	* Adds the marketing event session to the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEventSession the marketing event session
	* @return the marketing event session that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public MarketingEventSession addMarketingEventSession(
		MarketingEventSession marketingEventSession);

	public void addMarketingEventUserMarketingEventSession(
		long marketingEventUserId, long marketingEventSessionId);

	public void addMarketingEventUserMarketingEventSession(
		long marketingEventUserId, MarketingEventSession marketingEventSession);

	public void addMarketingEventUserMarketingEventSessions(
		long marketingEventUserId,
		List<MarketingEventSession> marketingEventSessions);

	public void addMarketingEventUserMarketingEventSessions(
		long marketingEventUserId, long[] marketingEventSessionIds);

	public void clearMarketingEventUserMarketingEventSessions(
		long marketingEventUserId);

	/**
	* Creates a new marketing event session with the primary key. Does not add the marketing event session to the database.
	*
	* @param marketingEventSessionId the primary key for the new marketing event session
	* @return the new marketing event session
	*/
	public MarketingEventSession createMarketingEventSession(
		long marketingEventSessionId);

	/**
	* Deletes the marketing event session with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEventSessionId the primary key of the marketing event session
	* @return the marketing event session that was removed
	* @throws PortalException if a marketing event session with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public MarketingEventSession deleteMarketingEventSession(
		long marketingEventSessionId) throws PortalException;

	/**
	* Deletes the marketing event session from the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEventSession the marketing event session
	* @return the marketing event session that was removed
	* @throws PortalException
	*/
	@Indexable(type = IndexableType.DELETE)
	public MarketingEventSession deleteMarketingEventSession(
		MarketingEventSession marketingEventSession) throws PortalException;

	public void deleteMarketingEventUserMarketingEventSession(
		long marketingEventUserId, long marketingEventSessionId);

	public void deleteMarketingEventUserMarketingEventSession(
		long marketingEventUserId, MarketingEventSession marketingEventSession);

	public void deleteMarketingEventUserMarketingEventSessions(
		long marketingEventUserId,
		List<MarketingEventSession> marketingEventSessions);

	public void deleteMarketingEventUserMarketingEventSessions(
		long marketingEventUserId, long[] marketingEventSessionIds);

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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.osb.www.marketing.events.model.impl.MarketingEventSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.osb.www.marketing.events.model.impl.MarketingEventSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public MarketingEventSession fetchMarketingEventSession(
		long marketingEventSessionId);

	/**
	* Returns the marketing event session with the matching UUID and company.
	*
	* @param uuid the marketing event session's UUID
	* @param companyId the primary key of the company
	* @return the matching marketing event session, or <code>null</code> if a matching marketing event session could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MarketingEventSession fetchMarketingEventSessionByUuidAndCompanyId(
		java.lang.String uuid, long companyId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	* Returns the marketing event session with the primary key.
	*
	* @param marketingEventSessionId the primary key of the marketing event session
	* @return the marketing event session
	* @throws PortalException if a marketing event session with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MarketingEventSession getMarketingEventSession(
		long marketingEventSessionId) throws PortalException;

	/**
	* Returns the marketing event session with the matching UUID and company.
	*
	* @param uuid the marketing event session's UUID
	* @param companyId the primary key of the company
	* @return the matching marketing event session
	* @throws PortalException if a matching marketing event session could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MarketingEventSession getMarketingEventSessionByUuidAndCompanyId(
		java.lang.String uuid, long companyId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Map.Entry<Date, List<MarketingEventSession>>> getMarketingEventSessionEntries(
		long marketingEventId, boolean asc) throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MarketingEventSession> getMarketingEventSessions(int start,
		int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MarketingEventSession> getMarketingEventSessions(
		long marketingEventId, int status, int start, int end,
		OrderByComparator obc);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MarketingEventSession> getMarketingEventSessions(
		long marketingEventId, int start, int end, OrderByComparator obc);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MarketingEventSession> getMarketingEventSessions(
		long[] categoryIds, int[] statuses, int start, int end,
		OrderByComparator obc) throws PortalException;

	/**
	* Returns the number of marketing event sessions.
	*
	* @return the number of marketing event sessions
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getMarketingEventSessionsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getMarketingEventSessionsCount(long marketingEventId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getMarketingEventSessionsCount(long marketingEventId,
		long marketingEventSessionRoomId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Map<Date, List<MarketingEventSession>> getMarketingEventSessionsMap(
		long marketingEventId, boolean asc) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MarketingEventUser> getMarketingEventSessionUsers(
		long marketingEventSessionId, int start, int end, OrderByComparator obc);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MarketingEventSession> getMarketingEventUserMarketingEventSessions(
		long marketingEventUserId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MarketingEventSession> getMarketingEventUserMarketingEventSessions(
		long marketingEventUserId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MarketingEventSession> getMarketingEventUserMarketingEventSessions(
		long marketingEventUserId, int start, int end,
		OrderByComparator<MarketingEventSession> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getMarketingEventUserMarketingEventSessionsCount(
		long marketingEventUserId);

	/**
	* Returns the marketingEventUserIds of the marketing event users associated with the marketing event session.
	*
	* @param marketingEventSessionId the marketingEventSessionId of the marketing event session
	* @return long[] the marketingEventUserIds of marketing event users associated with the marketing event session
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getMarketingEventUserPrimaryKeys(long marketingEventSessionId);

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

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasMarketingEventUserMarketingEventSession(
		long marketingEventUserId, long marketingEventSessionId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasMarketingEventUserMarketingEventSessions(
		long marketingEventUserId);

	public void setMarketingEventUserMarketingEventSessions(
		long marketingEventUserId, long[] marketingEventSessionIds);

	public void updateAsset(long userId, long groupId,
		MarketingEventSession marketingEventSession, long[] assetCategoryIds,
		java.lang.String[] assetTagNames, long[] assetLinkEntryIds)
		throws PortalException, SearchException, SystemException;

	public MarketingEventSession updateMarketingEventSession(
		long marketingEventSessionId, long marketingEventSessionRoomId,
		Map<Locale, java.lang.String> titleMap,
		Map<Locale, java.lang.String> descriptionMap,
		Map<Locale, java.lang.String> keywordsMap, long slidesFileEntryId,
		java.lang.String videoURL, int startDateMonth, int startDateDay,
		int startDateYear, int startDateHour, int startDateMinute,
		int endDateMonth, int endDateDay, int endDateYear, int endDateHour,
		int endDateMinute, int status, long[] marketingEventUserIds,
		ServiceContext serviceContext) throws PortalException;

	/**
	* Updates the marketing event session in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param marketingEventSession the marketing event session
	* @return the marketing event session that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public MarketingEventSession updateMarketingEventSession(
		MarketingEventSession marketingEventSession);
}