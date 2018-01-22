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

import com.liferay.osb.www.marketing.events.model.MarketingEventAnnouncement;

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

import java.util.Date;
import java.util.List;

/**
 * Provides the local service interface for MarketingEventAnnouncement. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEventAnnouncementLocalServiceUtil
 * @see com.liferay.osb.www.marketing.events.service.base.MarketingEventAnnouncementLocalServiceBaseImpl
 * @see com.liferay.osb.www.marketing.events.service.impl.MarketingEventAnnouncementLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface MarketingEventAnnouncementLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MarketingEventAnnouncementLocalServiceUtil} to access the marketing event announcement local service. Add custom service methods to {@link com.liferay.osb.www.marketing.events.service.impl.MarketingEventAnnouncementLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public MarketingEventAnnouncement addMarketingEventAnnouncement(
		long userId, long marketingEventId, java.lang.String title,
		java.lang.String message, java.lang.String summary,
		long imageFileEntryId, java.lang.String linkURL,
		java.lang.String linkLabel, int displayDateMonth, int displayDateDay,
		int displayDateYear, int displayDateHour, int displayDateMinute,
		int status, ServiceContext serviceContext) throws PortalException;

	/**
	* Adds the marketing event announcement to the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEventAnnouncement the marketing event announcement
	* @return the marketing event announcement that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public MarketingEventAnnouncement addMarketingEventAnnouncement(
		MarketingEventAnnouncement marketingEventAnnouncement);

	/**
	* Creates a new marketing event announcement with the primary key. Does not add the marketing event announcement to the database.
	*
	* @param marketingEventAnnouncementId the primary key for the new marketing event announcement
	* @return the new marketing event announcement
	*/
	public MarketingEventAnnouncement createMarketingEventAnnouncement(
		long marketingEventAnnouncementId);

	/**
	* Deletes the marketing event announcement with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEventAnnouncementId the primary key of the marketing event announcement
	* @return the marketing event announcement that was removed
	* @throws PortalException if a marketing event announcement with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public MarketingEventAnnouncement deleteMarketingEventAnnouncement(
		long marketingEventAnnouncementId) throws PortalException;

	/**
	* Deletes the marketing event announcement from the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEventAnnouncement the marketing event announcement
	* @return the marketing event announcement that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public MarketingEventAnnouncement deleteMarketingEventAnnouncement(
		MarketingEventAnnouncement marketingEventAnnouncement);

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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.osb.www.marketing.events.model.impl.MarketingEventAnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.osb.www.marketing.events.model.impl.MarketingEventAnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public MarketingEventAnnouncement fetchMarketingEventAnnouncement(
		long marketingEventAnnouncementId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	* Returns the marketing event announcement with the primary key.
	*
	* @param marketingEventAnnouncementId the primary key of the marketing event announcement
	* @return the marketing event announcement
	* @throws PortalException if a marketing event announcement with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MarketingEventAnnouncement getMarketingEventAnnouncement(
		long marketingEventAnnouncementId) throws PortalException;

	/**
	* Returns a range of all the marketing event announcements.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.osb.www.marketing.events.model.impl.MarketingEventAnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of marketing event announcements
	* @param end the upper bound of the range of marketing event announcements (not inclusive)
	* @return the range of marketing event announcements
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MarketingEventAnnouncement> getMarketingEventAnnouncements(
		int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MarketingEventAnnouncement> getMarketingEventAnnouncements(
		long marketingEventId, Date displayDate, int status, int start,
		int end, OrderByComparator obc);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MarketingEventAnnouncement> getMarketingEventAnnouncements(
		long marketingEventId, int start, int end, OrderByComparator obc);

	/**
	* Returns the number of marketing event announcements.
	*
	* @return the number of marketing event announcements
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getMarketingEventAnnouncementsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getMarketingEventAnnouncementsCount(long marketingEventId);

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

	public MarketingEventAnnouncement updateMarketingEventAnnouncement(
		long marketingEventAnnouncementId, java.lang.String title,
		java.lang.String message, java.lang.String summary,
		long imageFileEntryId, java.lang.String linkURL,
		java.lang.String linkLabel, int displayDateMonth, int displayDateDay,
		int displayDateYear, int displayDateHour, int displayDateMinute,
		int status, ServiceContext serviceContext) throws PortalException;

	/**
	* Updates the marketing event announcement in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param marketingEventAnnouncement the marketing event announcement
	* @return the marketing event announcement that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public MarketingEventAnnouncement updateMarketingEventAnnouncement(
		MarketingEventAnnouncement marketingEventAnnouncement);

	public MarketingEventAnnouncement updateStatus(long userId,
		long marketingEventAnnouncementId, int status,
		ServiceContext serviceContext) throws PortalException;
}