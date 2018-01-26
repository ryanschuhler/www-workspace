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
 * Provides the local service utility for MarketingEventSponsor. This utility wraps
 * {@link com.liferay.osb.www.marketing.events.service.impl.MarketingEventSponsorLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEventSponsorLocalService
 * @see com.liferay.osb.www.marketing.events.service.base.MarketingEventSponsorLocalServiceBaseImpl
 * @see com.liferay.osb.www.marketing.events.service.impl.MarketingEventSponsorLocalServiceImpl
 * @generated
 */
@ProviderType
public class MarketingEventSponsorLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.osb.www.marketing.events.service.impl.MarketingEventSponsorLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.osb.www.marketing.events.model.MarketingEventSponsor addMarketingEventSponsor(
		long userId, long marketingEventId, long marketingEventSponsorLevelId,
		java.lang.String name,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		long imageFileEntryId, java.lang.String url,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addMarketingEventSponsor(userId, marketingEventId,
			marketingEventSponsorLevelId, name, descriptionMap,
			imageFileEntryId, url, serviceContext);
	}

	/**
	* Adds the marketing event sponsor to the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEventSponsor the marketing event sponsor
	* @return the marketing event sponsor that was added
	*/
	public static com.liferay.osb.www.marketing.events.model.MarketingEventSponsor addMarketingEventSponsor(
		com.liferay.osb.www.marketing.events.model.MarketingEventSponsor marketingEventSponsor) {
		return getService().addMarketingEventSponsor(marketingEventSponsor);
	}

	/**
	* Creates a new marketing event sponsor with the primary key. Does not add the marketing event sponsor to the database.
	*
	* @param marketingEventSponsorId the primary key for the new marketing event sponsor
	* @return the new marketing event sponsor
	*/
	public static com.liferay.osb.www.marketing.events.model.MarketingEventSponsor createMarketingEventSponsor(
		long marketingEventSponsorId) {
		return getService().createMarketingEventSponsor(marketingEventSponsorId);
	}

	/**
	* Deletes the marketing event sponsor with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEventSponsorId the primary key of the marketing event sponsor
	* @return the marketing event sponsor that was removed
	* @throws PortalException if a marketing event sponsor with the primary key could not be found
	*/
	public static com.liferay.osb.www.marketing.events.model.MarketingEventSponsor deleteMarketingEventSponsor(
		long marketingEventSponsorId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteMarketingEventSponsor(marketingEventSponsorId);
	}

	/**
	* Deletes the marketing event sponsor from the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEventSponsor the marketing event sponsor
	* @return the marketing event sponsor that was removed
	*/
	public static com.liferay.osb.www.marketing.events.model.MarketingEventSponsor deleteMarketingEventSponsor(
		com.liferay.osb.www.marketing.events.model.MarketingEventSponsor marketingEventSponsor) {
		return getService().deleteMarketingEventSponsor(marketingEventSponsor);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.osb.www.marketing.events.model.impl.MarketingEventSponsorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.osb.www.marketing.events.model.impl.MarketingEventSponsorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.osb.www.marketing.events.model.MarketingEventSponsor fetchMarketingEventSponsor(
		long marketingEventSponsorId) {
		return getService().fetchMarketingEventSponsor(marketingEventSponsorId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the marketing event sponsor with the primary key.
	*
	* @param marketingEventSponsorId the primary key of the marketing event sponsor
	* @return the marketing event sponsor
	* @throws PortalException if a marketing event sponsor with the primary key could not be found
	*/
	public static com.liferay.osb.www.marketing.events.model.MarketingEventSponsor getMarketingEventSponsor(
		long marketingEventSponsorId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getMarketingEventSponsor(marketingEventSponsorId);
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
	public static java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventSponsor> getMarketingEventSponsors(
		int start, int end) {
		return getService().getMarketingEventSponsors(start, end);
	}

	public static java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventSponsor> getMarketingEventSponsors(
		long marketingEventId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc) {
		return getService()
				   .getMarketingEventSponsors(marketingEventId, start, end, obc);
	}

	public static java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventSponsor> getMarketingEventSponsors(
		long marketingEventId, long marketingEventSponsorLevelId) {
		return getService()
				   .getMarketingEventSponsors(marketingEventId,
			marketingEventSponsorLevelId);
	}

	/**
	* Returns the number of marketing event sponsors.
	*
	* @return the number of marketing event sponsors
	*/
	public static int getMarketingEventSponsorsCount() {
		return getService().getMarketingEventSponsorsCount();
	}

	public static int getMarketingEventSponsorsCount(long marketingEventId) {
		return getService().getMarketingEventSponsorsCount(marketingEventId);
	}

	public static int getMarketingEventSponsorsCount(long marketingEventId,
		long marketingEventSponsorLevelId) {
		return getService()
				   .getMarketingEventSponsorsCount(marketingEventId,
			marketingEventSponsorLevelId);
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

	public static com.liferay.osb.www.marketing.events.model.MarketingEventSponsor updateMarketingEventSponsor(
		long marketingEventSponsorId, long marketingEventSponsorLevelId,
		java.lang.String name,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		long imageFileEntryId, java.lang.String url,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateMarketingEventSponsor(marketingEventSponsorId,
			marketingEventSponsorLevelId, name, descriptionMap,
			imageFileEntryId, url, serviceContext);
	}

	/**
	* Updates the marketing event sponsor in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param marketingEventSponsor the marketing event sponsor
	* @return the marketing event sponsor that was updated
	*/
	public static com.liferay.osb.www.marketing.events.model.MarketingEventSponsor updateMarketingEventSponsor(
		com.liferay.osb.www.marketing.events.model.MarketingEventSponsor marketingEventSponsor) {
		return getService().updateMarketingEventSponsor(marketingEventSponsor);
	}

	public static MarketingEventSponsorLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<MarketingEventSponsorLocalService, MarketingEventSponsorLocalService> _serviceTracker =
		ServiceTrackerFactory.open(MarketingEventSponsorLocalService.class);
}