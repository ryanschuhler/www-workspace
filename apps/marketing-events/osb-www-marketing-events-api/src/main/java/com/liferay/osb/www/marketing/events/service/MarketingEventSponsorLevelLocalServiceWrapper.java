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
 * Provides a wrapper for {@link MarketingEventSponsorLevelLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEventSponsorLevelLocalService
 * @generated
 */
@ProviderType
public class MarketingEventSponsorLevelLocalServiceWrapper
	implements MarketingEventSponsorLevelLocalService,
		ServiceWrapper<MarketingEventSponsorLevelLocalService> {
	public MarketingEventSponsorLevelLocalServiceWrapper(
		MarketingEventSponsorLevelLocalService marketingEventSponsorLevelLocalService) {
		_marketingEventSponsorLevelLocalService = marketingEventSponsorLevelLocalService;
	}

	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventSponsorLevel addMarketingEventSponsorLevel(
		long userId, long marketingEventId,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		int priority,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventSponsorLevelLocalService.addMarketingEventSponsorLevel(userId,
			marketingEventId, nameMap, priority, serviceContext);
	}

	/**
	* Adds the marketing event sponsor level to the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEventSponsorLevel the marketing event sponsor level
	* @return the marketing event sponsor level that was added
	*/
	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventSponsorLevel addMarketingEventSponsorLevel(
		com.liferay.osb.www.marketing.events.model.MarketingEventSponsorLevel marketingEventSponsorLevel) {
		return _marketingEventSponsorLevelLocalService.addMarketingEventSponsorLevel(marketingEventSponsorLevel);
	}

	/**
	* Creates a new marketing event sponsor level with the primary key. Does not add the marketing event sponsor level to the database.
	*
	* @param marketingEventSponsorLevelId the primary key for the new marketing event sponsor level
	* @return the new marketing event sponsor level
	*/
	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventSponsorLevel createMarketingEventSponsorLevel(
		long marketingEventSponsorLevelId) {
		return _marketingEventSponsorLevelLocalService.createMarketingEventSponsorLevel(marketingEventSponsorLevelId);
	}

	/**
	* Deletes the marketing event sponsor level with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEventSponsorLevelId the primary key of the marketing event sponsor level
	* @return the marketing event sponsor level that was removed
	* @throws PortalException if a marketing event sponsor level with the primary key could not be found
	*/
	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventSponsorLevel deleteMarketingEventSponsorLevel(
		long marketingEventSponsorLevelId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventSponsorLevelLocalService.deleteMarketingEventSponsorLevel(marketingEventSponsorLevelId);
	}

	/**
	* Deletes the marketing event sponsor level from the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEventSponsorLevel the marketing event sponsor level
	* @return the marketing event sponsor level that was removed
	* @throws PortalException
	*/
	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventSponsorLevel deleteMarketingEventSponsorLevel(
		com.liferay.osb.www.marketing.events.model.MarketingEventSponsorLevel marketingEventSponsorLevel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventSponsorLevelLocalService.deleteMarketingEventSponsorLevel(marketingEventSponsorLevel);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventSponsorLevelLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _marketingEventSponsorLevelLocalService.dynamicQuery();
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
		return _marketingEventSponsorLevelLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.osb.www.marketing.events.model.impl.MarketingEventSponsorLevelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _marketingEventSponsorLevelLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.osb.www.marketing.events.model.impl.MarketingEventSponsorLevelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _marketingEventSponsorLevelLocalService.dynamicQuery(dynamicQuery,
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
		return _marketingEventSponsorLevelLocalService.dynamicQueryCount(dynamicQuery);
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
		return _marketingEventSponsorLevelLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventSponsorLevel fetchMarketingEventSponsorLevel(
		long marketingEventSponsorLevelId) {
		return _marketingEventSponsorLevelLocalService.fetchMarketingEventSponsorLevel(marketingEventSponsorLevelId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _marketingEventSponsorLevelLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _marketingEventSponsorLevelLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the marketing event sponsor level with the primary key.
	*
	* @param marketingEventSponsorLevelId the primary key of the marketing event sponsor level
	* @return the marketing event sponsor level
	* @throws PortalException if a marketing event sponsor level with the primary key could not be found
	*/
	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventSponsorLevel getMarketingEventSponsorLevel(
		long marketingEventSponsorLevelId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventSponsorLevelLocalService.getMarketingEventSponsorLevel(marketingEventSponsorLevelId);
	}

	/**
	* Returns a range of all the marketing event sponsor levels.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.osb.www.marketing.events.model.impl.MarketingEventSponsorLevelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of marketing event sponsor levels
	* @param end the upper bound of the range of marketing event sponsor levels (not inclusive)
	* @return the range of marketing event sponsor levels
	*/
	@Override
	public java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventSponsorLevel> getMarketingEventSponsorLevels(
		int start, int end) {
		return _marketingEventSponsorLevelLocalService.getMarketingEventSponsorLevels(start,
			end);
	}

	@Override
	public java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventSponsorLevel> getMarketingEventSponsorLevels(
		long marketingEventId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc) {
		return _marketingEventSponsorLevelLocalService.getMarketingEventSponsorLevels(marketingEventId,
			start, end, obc);
	}

	/**
	* Returns the number of marketing event sponsor levels.
	*
	* @return the number of marketing event sponsor levels
	*/
	@Override
	public int getMarketingEventSponsorLevelsCount() {
		return _marketingEventSponsorLevelLocalService.getMarketingEventSponsorLevelsCount();
	}

	@Override
	public int getMarketingEventSponsorLevelsCount(long marketingEventId) {
		return _marketingEventSponsorLevelLocalService.getMarketingEventSponsorLevelsCount(marketingEventId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _marketingEventSponsorLevelLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventSponsorLevelLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventSponsorLevel updateMarketingEventSponsorLevel(
		long marketingEventSponsorLevelId,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		int priority,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventSponsorLevelLocalService.updateMarketingEventSponsorLevel(marketingEventSponsorLevelId,
			nameMap, priority, serviceContext);
	}

	/**
	* Updates the marketing event sponsor level in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param marketingEventSponsorLevel the marketing event sponsor level
	* @return the marketing event sponsor level that was updated
	*/
	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventSponsorLevel updateMarketingEventSponsorLevel(
		com.liferay.osb.www.marketing.events.model.MarketingEventSponsorLevel marketingEventSponsorLevel) {
		return _marketingEventSponsorLevelLocalService.updateMarketingEventSponsorLevel(marketingEventSponsorLevel);
	}

	@Override
	public MarketingEventSponsorLevelLocalService getWrappedService() {
		return _marketingEventSponsorLevelLocalService;
	}

	@Override
	public void setWrappedService(
		MarketingEventSponsorLevelLocalService marketingEventSponsorLevelLocalService) {
		_marketingEventSponsorLevelLocalService = marketingEventSponsorLevelLocalService;
	}

	private MarketingEventSponsorLevelLocalService _marketingEventSponsorLevelLocalService;
}