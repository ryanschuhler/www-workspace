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
 * Provides a wrapper for {@link MarketingEventSponsorLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEventSponsorLocalService
 * @generated
 */
@ProviderType
public class MarketingEventSponsorLocalServiceWrapper
	implements MarketingEventSponsorLocalService,
		ServiceWrapper<MarketingEventSponsorLocalService> {
	public MarketingEventSponsorLocalServiceWrapper(
		MarketingEventSponsorLocalService marketingEventSponsorLocalService) {
		_marketingEventSponsorLocalService = marketingEventSponsorLocalService;
	}

	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventSponsor addMarketingEventSponsor(
		long userId, long marketingEventId, long marketingEventSponsorLevelId,
		java.lang.String name,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		long imageFileEntryId, java.lang.String url,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventSponsorLocalService.addMarketingEventSponsor(userId,
			marketingEventId, marketingEventSponsorLevelId, name,
			descriptionMap, imageFileEntryId, url, serviceContext);
	}

	/**
	* Adds the marketing event sponsor to the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEventSponsor the marketing event sponsor
	* @return the marketing event sponsor that was added
	*/
	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventSponsor addMarketingEventSponsor(
		com.liferay.osb.www.marketing.events.model.MarketingEventSponsor marketingEventSponsor) {
		return _marketingEventSponsorLocalService.addMarketingEventSponsor(marketingEventSponsor);
	}

	/**
	* Creates a new marketing event sponsor with the primary key. Does not add the marketing event sponsor to the database.
	*
	* @param marketingEventSponsorId the primary key for the new marketing event sponsor
	* @return the new marketing event sponsor
	*/
	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventSponsor createMarketingEventSponsor(
		long marketingEventSponsorId) {
		return _marketingEventSponsorLocalService.createMarketingEventSponsor(marketingEventSponsorId);
	}

	/**
	* Deletes the marketing event sponsor with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEventSponsorId the primary key of the marketing event sponsor
	* @return the marketing event sponsor that was removed
	* @throws PortalException if a marketing event sponsor with the primary key could not be found
	*/
	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventSponsor deleteMarketingEventSponsor(
		long marketingEventSponsorId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventSponsorLocalService.deleteMarketingEventSponsor(marketingEventSponsorId);
	}

	/**
	* Deletes the marketing event sponsor from the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEventSponsor the marketing event sponsor
	* @return the marketing event sponsor that was removed
	*/
	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventSponsor deleteMarketingEventSponsor(
		com.liferay.osb.www.marketing.events.model.MarketingEventSponsor marketingEventSponsor) {
		return _marketingEventSponsorLocalService.deleteMarketingEventSponsor(marketingEventSponsor);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventSponsorLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _marketingEventSponsorLocalService.dynamicQuery();
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
		return _marketingEventSponsorLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.osb.www.marketing.events.model.impl.MarketingEventSponsorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _marketingEventSponsorLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.osb.www.marketing.events.model.impl.MarketingEventSponsorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _marketingEventSponsorLocalService.dynamicQuery(dynamicQuery,
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
		return _marketingEventSponsorLocalService.dynamicQueryCount(dynamicQuery);
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
		return _marketingEventSponsorLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventSponsor fetchMarketingEventSponsor(
		long marketingEventSponsorId) {
		return _marketingEventSponsorLocalService.fetchMarketingEventSponsor(marketingEventSponsorId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _marketingEventSponsorLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _marketingEventSponsorLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the marketing event sponsor with the primary key.
	*
	* @param marketingEventSponsorId the primary key of the marketing event sponsor
	* @return the marketing event sponsor
	* @throws PortalException if a marketing event sponsor with the primary key could not be found
	*/
	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventSponsor getMarketingEventSponsor(
		long marketingEventSponsorId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventSponsorLocalService.getMarketingEventSponsor(marketingEventSponsorId);
	}

	/**
	* Returns a range of all the marketing event sponsors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.osb.www.marketing.events.model.impl.MarketingEventSponsorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of marketing event sponsors
	* @param end the upper bound of the range of marketing event sponsors (not inclusive)
	* @return the range of marketing event sponsors
	*/
	@Override
	public java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventSponsor> getMarketingEventSponsors(
		int start, int end) {
		return _marketingEventSponsorLocalService.getMarketingEventSponsors(start,
			end);
	}

	@Override
	public java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventSponsor> getMarketingEventSponsors(
		long marketingEventId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc) {
		return _marketingEventSponsorLocalService.getMarketingEventSponsors(marketingEventId,
			start, end, obc);
	}

	@Override
	public java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventSponsor> getMarketingEventSponsors(
		long marketingEventId, long marketingEventSponsorLevelId) {
		return _marketingEventSponsorLocalService.getMarketingEventSponsors(marketingEventId,
			marketingEventSponsorLevelId);
	}

	/**
	* Returns the number of marketing event sponsors.
	*
	* @return the number of marketing event sponsors
	*/
	@Override
	public int getMarketingEventSponsorsCount() {
		return _marketingEventSponsorLocalService.getMarketingEventSponsorsCount();
	}

	@Override
	public int getMarketingEventSponsorsCount(long marketingEventId) {
		return _marketingEventSponsorLocalService.getMarketingEventSponsorsCount(marketingEventId);
	}

	@Override
	public int getMarketingEventSponsorsCount(long marketingEventId,
		long marketingEventSponsorLevelId) {
		return _marketingEventSponsorLocalService.getMarketingEventSponsorsCount(marketingEventId,
			marketingEventSponsorLevelId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _marketingEventSponsorLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventSponsorLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventSponsor updateMarketingEventSponsor(
		long marketingEventSponsorId, long marketingEventSponsorLevelId,
		java.lang.String name,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		long imageFileEntryId, java.lang.String url,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marketingEventSponsorLocalService.updateMarketingEventSponsor(marketingEventSponsorId,
			marketingEventSponsorLevelId, name, descriptionMap,
			imageFileEntryId, url, serviceContext);
	}

	/**
	* Updates the marketing event sponsor in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param marketingEventSponsor the marketing event sponsor
	* @return the marketing event sponsor that was updated
	*/
	@Override
	public com.liferay.osb.www.marketing.events.model.MarketingEventSponsor updateMarketingEventSponsor(
		com.liferay.osb.www.marketing.events.model.MarketingEventSponsor marketingEventSponsor) {
		return _marketingEventSponsorLocalService.updateMarketingEventSponsor(marketingEventSponsor);
	}

	@Override
	public MarketingEventSponsorLocalService getWrappedService() {
		return _marketingEventSponsorLocalService;
	}

	@Override
	public void setWrappedService(
		MarketingEventSponsorLocalService marketingEventSponsorLocalService) {
		_marketingEventSponsorLocalService = marketingEventSponsorLocalService;
	}

	private MarketingEventSponsorLocalService _marketingEventSponsorLocalService;
}