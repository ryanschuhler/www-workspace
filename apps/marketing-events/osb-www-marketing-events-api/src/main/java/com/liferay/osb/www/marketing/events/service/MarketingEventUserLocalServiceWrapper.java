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
 * Provides a wrapper for {@link MarketingEventUserLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEventUserLocalService
 * @generated
 */
@ProviderType
public class MarketingEventUserLocalServiceWrapper
	implements MarketingEventUserLocalService,
		ServiceWrapper<MarketingEventUserLocalService> {
	public MarketingEventUserLocalServiceWrapper(
		MarketingEventUserLocalService marketingEventUserLocalService) {
		_marketingEventUserLocalService = marketingEventUserLocalService;
	}

	@Override
	public void addMarketingEventSessionMarketingEventUser(
		long marketingEventSessionId, long marketingEventUserId) {
		_marketingEventUserLocalService.addMarketingEventSessionMarketingEventUser(marketingEventSessionId,
			marketingEventUserId);
	}

	@Override
	public void addMarketingEventSessionMarketingEventUser(
		long marketingEventSessionId,
		com.liferay.osb.www.marketing.events.model.MarketingEventUser marketingEventUser) {
		_marketingEventUserLocalService.addMarketingEventSessionMarketingEventUser(marketingEventSessionId,
			marketingEventUser);
	}

	@Override
	public void addMarketingEventSessionMarketingEventUsers(
		long marketingEventSessionId,
		java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventUser> marketingEventUsers) {
		_marketingEventUserLocalService.addMarketingEventSessionMarketingEventUsers(marketingEventSessionId,
			marketingEventUsers);
	}

	@Override
	public void addMarketingEventSessionMarketingEventUsers(
		long marketingEventSessionId, long[] marketingEventUserIds) {
		_marketingEventUserLocalService.addMarketingEventSessionMarketingEventUsers(marketingEventSessionId,
			marketingEventUserIds);
	}

	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventUser addMarketingEventUser(
		long userId, long marketingEventId, java.lang.String firstName,
		java.lang.String lastName, java.lang.String companyName,
		long companyLogoFileEntryId,
		java.util.Map<java.util.Locale, java.lang.String> jobTitleMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		long imageFileEntryId, java.lang.String phoneNumber, int status,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventUserLocalService.addMarketingEventUser(userId,
			marketingEventId, firstName, lastName, companyName,
			companyLogoFileEntryId, jobTitleMap, descriptionMap,
			imageFileEntryId, phoneNumber, status, serviceContext);
	}

	/**
	* Adds the marketing event user to the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEventUser the marketing event user
	* @return the marketing event user that was added
	*/
	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventUser addMarketingEventUser(
		com.liferay.osb.www.marketing.events.model.MarketingEventUser marketingEventUser) {
		return _marketingEventUserLocalService.addMarketingEventUser(marketingEventUser);
	}

	@Override
	public void clearMarketingEventSessionMarketingEventUsers(
		long marketingEventSessionId) {
		_marketingEventUserLocalService.clearMarketingEventSessionMarketingEventUsers(marketingEventSessionId);
	}

	/**
	* Creates a new marketing event user with the primary key. Does not add the marketing event user to the database.
	*
	* @param marketingEventUserId the primary key for the new marketing event user
	* @return the new marketing event user
	*/
	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventUser createMarketingEventUser(
		long marketingEventUserId) {
		return _marketingEventUserLocalService.createMarketingEventUser(marketingEventUserId);
	}

	@Override
	public void deleteMarketingEventSessionMarketingEventUser(
		long marketingEventSessionId, long marketingEventUserId) {
		_marketingEventUserLocalService.deleteMarketingEventSessionMarketingEventUser(marketingEventSessionId,
			marketingEventUserId);
	}

	@Override
	public void deleteMarketingEventSessionMarketingEventUser(
		long marketingEventSessionId,
		com.liferay.osb.www.marketing.events.model.MarketingEventUser marketingEventUser) {
		_marketingEventUserLocalService.deleteMarketingEventSessionMarketingEventUser(marketingEventSessionId,
			marketingEventUser);
	}

	@Override
	public void deleteMarketingEventSessionMarketingEventUsers(
		long marketingEventSessionId,
		java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventUser> marketingEventUsers) {
		_marketingEventUserLocalService.deleteMarketingEventSessionMarketingEventUsers(marketingEventSessionId,
			marketingEventUsers);
	}

	@Override
	public void deleteMarketingEventSessionMarketingEventUsers(
		long marketingEventSessionId, long[] marketingEventUserIds) {
		_marketingEventUserLocalService.deleteMarketingEventSessionMarketingEventUsers(marketingEventSessionId,
			marketingEventUserIds);
	}

	/**
	* Deletes the marketing event user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEventUserId the primary key of the marketing event user
	* @return the marketing event user that was removed
	* @throws PortalException if a marketing event user with the primary key could not be found
	*/
	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventUser deleteMarketingEventUser(
		long marketingEventUserId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventUserLocalService.deleteMarketingEventUser(marketingEventUserId);
	}

	/**
	* Deletes the marketing event user from the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEventUser the marketing event user
	* @return the marketing event user that was removed
	* @throws PortalException
	*/
	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventUser deleteMarketingEventUser(
		com.liferay.osb.www.marketing.events.model.MarketingEventUser marketingEventUser)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventUserLocalService.deleteMarketingEventUser(marketingEventUser);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventUserLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _marketingEventUserLocalService.dynamicQuery();
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
		return _marketingEventUserLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _marketingEventUserLocalService.dynamicQuery(dynamicQuery,
			start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _marketingEventUserLocalService.dynamicQuery(dynamicQuery,
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
		return _marketingEventUserLocalService.dynamicQueryCount(dynamicQuery);
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
		return _marketingEventUserLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventUser fetchMarketingEventUser(
		long marketingEventUserId) {
		return _marketingEventUserLocalService.fetchMarketingEventUser(marketingEventUserId);
	}

	/**
	* Returns the marketing event user with the matching UUID and company.
	*
	* @param uuid the marketing event user's UUID
	* @param companyId the primary key of the company
	* @return the matching marketing event user, or <code>null</code> if a matching marketing event user could not be found
	*/
	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventUser fetchMarketingEventUserByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _marketingEventUserLocalService.fetchMarketingEventUserByUuidAndCompanyId(uuid,
			companyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _marketingEventUserLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _marketingEventUserLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _marketingEventUserLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventUser> getMarketingEventSessionMarketingEventUsers(
		long marketingEventSessionId) {
		return _marketingEventUserLocalService.getMarketingEventSessionMarketingEventUsers(marketingEventSessionId);
	}

	@Override
	public java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventUser> getMarketingEventSessionMarketingEventUsers(
		long marketingEventSessionId, int start, int end) {
		return _marketingEventUserLocalService.getMarketingEventSessionMarketingEventUsers(marketingEventSessionId,
			start, end);
	}

	@Override
	public java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventUser> getMarketingEventSessionMarketingEventUsers(
		long marketingEventSessionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.osb.www.marketing.events.model.MarketingEventUser> orderByComparator) {
		return _marketingEventUserLocalService.getMarketingEventSessionMarketingEventUsers(marketingEventSessionId,
			start, end, orderByComparator);
	}

	@Override
	public int getMarketingEventSessionMarketingEventUsersCount(
		long marketingEventSessionId) {
		return _marketingEventUserLocalService.getMarketingEventSessionMarketingEventUsersCount(marketingEventSessionId);
	}

	/**
	* Returns the marketingEventSessionIds of the marketing event sessions associated with the marketing event user.
	*
	* @param marketingEventUserId the marketingEventUserId of the marketing event user
	* @return long[] the marketingEventSessionIds of marketing event sessions associated with the marketing event user
	*/
	@Override
	public long[] getMarketingEventSessionPrimaryKeys(long marketingEventUserId) {
		return _marketingEventUserLocalService.getMarketingEventSessionPrimaryKeys(marketingEventUserId);
	}

	/**
	* Returns the marketing event user with the primary key.
	*
	* @param marketingEventUserId the primary key of the marketing event user
	* @return the marketing event user
	* @throws PortalException if a marketing event user with the primary key could not be found
	*/
	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventUser getMarketingEventUser(
		long marketingEventUserId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventUserLocalService.getMarketingEventUser(marketingEventUserId);
	}

	/**
	* Returns the marketing event user with the matching UUID and company.
	*
	* @param uuid the marketing event user's UUID
	* @param companyId the primary key of the company
	* @return the matching marketing event user
	* @throws PortalException if a matching marketing event user could not be found
	*/
	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventUser getMarketingEventUserByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventUserLocalService.getMarketingEventUserByUuidAndCompanyId(uuid,
			companyId);
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
	@Override
	public java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventUser> getMarketingEventUsers(
		int start, int end) {
		return _marketingEventUserLocalService.getMarketingEventUsers(start, end);
	}

	@Override
	public java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventUser> getMarketingEventUsers(
		long marketingEventId, int status, int start, int end) {
		return _marketingEventUserLocalService.getMarketingEventUsers(marketingEventId,
			status, start, end);
	}

	@Override
	public java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventUser> getMarketingEventUsers(
		long marketingEventId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc) {
		return _marketingEventUserLocalService.getMarketingEventUsers(marketingEventId,
			status, start, end, obc);
	}

	@Override
	public java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventUser> getMarketingEventUsers(
		long marketingEventId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc) {
		return _marketingEventUserLocalService.getMarketingEventUsers(marketingEventId,
			start, end, obc);
	}

	@Override
	public java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventUser> getMarketingEventUsers(
		long[] categoryIds, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc) {
		return _marketingEventUserLocalService.getMarketingEventUsers(categoryIds,
			statuses, start, end, obc);
	}

	/**
	* Returns the number of marketing event users.
	*
	* @return the number of marketing event users
	*/
	@Override
	public int getMarketingEventUsersCount() {
		return _marketingEventUserLocalService.getMarketingEventUsersCount();
	}

	@Override
	public int getMarketingEventUsersCount(long marketingEventId) {
		return _marketingEventUserLocalService.getMarketingEventUsersCount(marketingEventId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _marketingEventUserLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventUserLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public boolean hasMarketingEventSessionMarketingEventUser(
		long marketingEventSessionId, long marketingEventUserId) {
		return _marketingEventUserLocalService.hasMarketingEventSessionMarketingEventUser(marketingEventSessionId,
			marketingEventUserId);
	}

	@Override
	public boolean hasMarketingEventSessionMarketingEventUsers(
		long marketingEventSessionId) {
		return _marketingEventUserLocalService.hasMarketingEventSessionMarketingEventUsers(marketingEventSessionId);
	}

	@Override
	public void setMarketingEventSessionMarketingEventUsers(
		long marketingEventSessionId, long[] marketingEventUserIds) {
		_marketingEventUserLocalService.setMarketingEventSessionMarketingEventUsers(marketingEventSessionId,
			marketingEventUserIds);
	}

	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventUser updateMarketingEventUser(
		long userId, long marketingEventUserId, java.lang.String firstName,
		java.lang.String lastName, java.lang.String companyName,
		long companyLogoFileEntryId,
		java.util.Map<java.util.Locale, java.lang.String> jobTitleMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		long imageFileEntryId, java.lang.String phoneNumber, int status,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventUserLocalService.updateMarketingEventUser(userId,
			marketingEventUserId, firstName, lastName, companyName,
			companyLogoFileEntryId, jobTitleMap, descriptionMap,
			imageFileEntryId, phoneNumber, status, serviceContext);
	}

	/**
	* Updates the marketing event user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param marketingEventUser the marketing event user
	* @return the marketing event user that was updated
	*/
	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventUser updateMarketingEventUser(
		com.liferay.osb.www.marketing.events.model.MarketingEventUser marketingEventUser) {
		return _marketingEventUserLocalService.updateMarketingEventUser(marketingEventUser);
	}

	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventUser updateStatus(
		long userId, long marketingEventUserId, int status, int priority,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventUserLocalService.updateStatus(userId,
			marketingEventUserId, status, priority, serviceContext);
	}

	@Override
	public MarketingEventUserLocalService getWrappedService() {
		return _marketingEventUserLocalService;
	}

	@Override
	public void setWrappedService(
		MarketingEventUserLocalService marketingEventUserLocalService) {
		_marketingEventUserLocalService = marketingEventUserLocalService;
	}

	private MarketingEventUserLocalService _marketingEventUserLocalService;
}