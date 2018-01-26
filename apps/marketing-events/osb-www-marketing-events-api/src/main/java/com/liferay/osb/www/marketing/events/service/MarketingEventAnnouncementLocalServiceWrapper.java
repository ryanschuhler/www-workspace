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
 * Provides a wrapper for {@link MarketingEventAnnouncementLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEventAnnouncementLocalService
 * @generated
 */
@ProviderType
public class MarketingEventAnnouncementLocalServiceWrapper
	implements MarketingEventAnnouncementLocalService,
		ServiceWrapper<MarketingEventAnnouncementLocalService> {
	public MarketingEventAnnouncementLocalServiceWrapper(
		MarketingEventAnnouncementLocalService marketingEventAnnouncementLocalService) {
		_marketingEventAnnouncementLocalService = marketingEventAnnouncementLocalService;
	}

	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventAnnouncement addMarketingEventAnnouncement(
		long userId, long marketingEventId, java.lang.String title,
		java.lang.String message, java.lang.String summary,
		long imageFileEntryId, java.lang.String linkURL,
		java.lang.String linkLabel, int displayDateMonth, int displayDateDay,
		int displayDateYear, int displayDateHour, int displayDateMinute,
		int status,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventAnnouncementLocalService.addMarketingEventAnnouncement(userId,
			marketingEventId, title, message, summary, imageFileEntryId,
			linkURL, linkLabel, displayDateMonth, displayDateDay,
			displayDateYear, displayDateHour, displayDateMinute, status,
			serviceContext);
	}

	/**
	* Adds the marketing event announcement to the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEventAnnouncement the marketing event announcement
	* @return the marketing event announcement that was added
	*/
	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventAnnouncement addMarketingEventAnnouncement(
		com.liferay.osb.www.marketing.events.model.MarketingEventAnnouncement marketingEventAnnouncement) {
		return _marketingEventAnnouncementLocalService.addMarketingEventAnnouncement(marketingEventAnnouncement);
	}

	/**
	* Creates a new marketing event announcement with the primary key. Does not add the marketing event announcement to the database.
	*
	* @param marketingEventAnnouncementId the primary key for the new marketing event announcement
	* @return the new marketing event announcement
	*/
	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventAnnouncement createMarketingEventAnnouncement(
		long marketingEventAnnouncementId) {
		return _marketingEventAnnouncementLocalService.createMarketingEventAnnouncement(marketingEventAnnouncementId);
	}

	/**
	* Deletes the marketing event announcement with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEventAnnouncementId the primary key of the marketing event announcement
	* @return the marketing event announcement that was removed
	* @throws PortalException if a marketing event announcement with the primary key could not be found
	*/
	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventAnnouncement deleteMarketingEventAnnouncement(
		long marketingEventAnnouncementId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventAnnouncementLocalService.deleteMarketingEventAnnouncement(marketingEventAnnouncementId);
	}

	/**
	* Deletes the marketing event announcement from the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEventAnnouncement the marketing event announcement
	* @return the marketing event announcement that was removed
	*/
	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventAnnouncement deleteMarketingEventAnnouncement(
		com.liferay.osb.www.marketing.events.model.MarketingEventAnnouncement marketingEventAnnouncement) {
		return _marketingEventAnnouncementLocalService.deleteMarketingEventAnnouncement(marketingEventAnnouncement);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventAnnouncementLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _marketingEventAnnouncementLocalService.dynamicQuery();
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
		return _marketingEventAnnouncementLocalService.dynamicQuery(dynamicQuery);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _marketingEventAnnouncementLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _marketingEventAnnouncementLocalService.dynamicQuery(dynamicQuery,
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
		return _marketingEventAnnouncementLocalService.dynamicQueryCount(dynamicQuery);
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
		return _marketingEventAnnouncementLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventAnnouncement fetchMarketingEventAnnouncement(
		long marketingEventAnnouncementId) {
		return _marketingEventAnnouncementLocalService.fetchMarketingEventAnnouncement(marketingEventAnnouncementId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _marketingEventAnnouncementLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _marketingEventAnnouncementLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the marketing event announcement with the primary key.
	*
	* @param marketingEventAnnouncementId the primary key of the marketing event announcement
	* @return the marketing event announcement
	* @throws PortalException if a marketing event announcement with the primary key could not be found
	*/
	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventAnnouncement getMarketingEventAnnouncement(
		long marketingEventAnnouncementId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventAnnouncementLocalService.getMarketingEventAnnouncement(marketingEventAnnouncementId);
	}

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
	@Override
	public java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventAnnouncement> getMarketingEventAnnouncements(
		int start, int end) {
		return _marketingEventAnnouncementLocalService.getMarketingEventAnnouncements(start,
			end);
	}

	@Override
	public java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventAnnouncement> getMarketingEventAnnouncements(
		long marketingEventId, java.util.Date displayDate, int status,
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc) {
		return _marketingEventAnnouncementLocalService.getMarketingEventAnnouncements(marketingEventId,
			displayDate, status, start, end, obc);
	}

	@Override
	public java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventAnnouncement> getMarketingEventAnnouncements(
		long marketingEventId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc) {
		return _marketingEventAnnouncementLocalService.getMarketingEventAnnouncements(marketingEventId,
			start, end, obc);
	}

	/**
	* Returns the number of marketing event announcements.
	*
	* @return the number of marketing event announcements
	*/
	@Override
	public int getMarketingEventAnnouncementsCount() {
		return _marketingEventAnnouncementLocalService.getMarketingEventAnnouncementsCount();
	}

	@Override
	public int getMarketingEventAnnouncementsCount(long marketingEventId) {
		return _marketingEventAnnouncementLocalService.getMarketingEventAnnouncementsCount(marketingEventId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _marketingEventAnnouncementLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventAnnouncementLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventAnnouncement updateMarketingEventAnnouncement(
		long marketingEventAnnouncementId, java.lang.String title,
		java.lang.String message, java.lang.String summary,
		long imageFileEntryId, java.lang.String linkURL,
		java.lang.String linkLabel, int displayDateMonth, int displayDateDay,
		int displayDateYear, int displayDateHour, int displayDateMinute,
		int status,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventAnnouncementLocalService.updateMarketingEventAnnouncement(marketingEventAnnouncementId,
			title, message, summary, imageFileEntryId, linkURL, linkLabel,
			displayDateMonth, displayDateDay, displayDateYear, displayDateHour,
			displayDateMinute, status, serviceContext);
	}

	/**
	* Updates the marketing event announcement in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param marketingEventAnnouncement the marketing event announcement
	* @return the marketing event announcement that was updated
	*/
	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventAnnouncement updateMarketingEventAnnouncement(
		com.liferay.osb.www.marketing.events.model.MarketingEventAnnouncement marketingEventAnnouncement) {
		return _marketingEventAnnouncementLocalService.updateMarketingEventAnnouncement(marketingEventAnnouncement);
	}

	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventAnnouncement updateStatus(
		long userId, long marketingEventAnnouncementId, int status,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventAnnouncementLocalService.updateStatus(userId,
			marketingEventAnnouncementId, status, serviceContext);
	}

	@Override
	public MarketingEventAnnouncementLocalService getWrappedService() {
		return _marketingEventAnnouncementLocalService;
	}

	@Override
	public void setWrappedService(
		MarketingEventAnnouncementLocalService marketingEventAnnouncementLocalService) {
		_marketingEventAnnouncementLocalService = marketingEventAnnouncementLocalService;
	}

	private MarketingEventAnnouncementLocalService _marketingEventAnnouncementLocalService;
}