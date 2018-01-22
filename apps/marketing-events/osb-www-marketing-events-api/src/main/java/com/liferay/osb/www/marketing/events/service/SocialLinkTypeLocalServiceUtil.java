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
 * Provides the local service utility for SocialLinkType. This utility wraps
 * {@link com.liferay.osb.www.marketing.events.service.impl.SocialLinkTypeLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SocialLinkTypeLocalService
 * @see com.liferay.osb.www.marketing.events.service.base.SocialLinkTypeLocalServiceBaseImpl
 * @see com.liferay.osb.www.marketing.events.service.impl.SocialLinkTypeLocalServiceImpl
 * @generated
 */
@ProviderType
public class SocialLinkTypeLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.osb.www.marketing.events.service.impl.SocialLinkTypeLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.osb.www.marketing.events.model.SocialLinkType addSocialLinkType(
		long userId, java.lang.String name, long imageFileEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().addSocialLinkType(userId, name, imageFileEntryId);
	}

	/**
	* Adds the social link type to the database. Also notifies the appropriate model listeners.
	*
	* @param socialLinkType the social link type
	* @return the social link type that was added
	*/
	public static com.liferay.osb.www.marketing.events.model.SocialLinkType addSocialLinkType(
		com.liferay.osb.www.marketing.events.model.SocialLinkType socialLinkType) {
		return getService().addSocialLinkType(socialLinkType);
	}

	/**
	* Creates a new social link type with the primary key. Does not add the social link type to the database.
	*
	* @param socialLinkTypeId the primary key for the new social link type
	* @return the new social link type
	*/
	public static com.liferay.osb.www.marketing.events.model.SocialLinkType createSocialLinkType(
		long socialLinkTypeId) {
		return getService().createSocialLinkType(socialLinkTypeId);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the social link type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param socialLinkTypeId the primary key of the social link type
	* @return the social link type that was removed
	* @throws PortalException if a social link type with the primary key could not be found
	*/
	public static com.liferay.osb.www.marketing.events.model.SocialLinkType deleteSocialLinkType(
		long socialLinkTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteSocialLinkType(socialLinkTypeId);
	}

	/**
	* Deletes the social link type from the database. Also notifies the appropriate model listeners.
	*
	* @param socialLinkType the social link type
	* @return the social link type that was removed
	* @throws PortalException
	*/
	public static com.liferay.osb.www.marketing.events.model.SocialLinkType deleteSocialLinkType(
		com.liferay.osb.www.marketing.events.model.SocialLinkType socialLinkType)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteSocialLinkType(socialLinkType);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.osb.www.marketing.events.model.impl.SocialLinkTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.osb.www.marketing.events.model.impl.SocialLinkTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.osb.www.marketing.events.model.SocialLinkType fetchSocialLinkType(
		long socialLinkTypeId) {
		return getService().fetchSocialLinkType(socialLinkTypeId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
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

	/**
	* Returns the social link type with the primary key.
	*
	* @param socialLinkTypeId the primary key of the social link type
	* @return the social link type
	* @throws PortalException if a social link type with the primary key could not be found
	*/
	public static com.liferay.osb.www.marketing.events.model.SocialLinkType getSocialLinkType(
		long socialLinkTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getSocialLinkType(socialLinkTypeId);
	}

	/**
	* Returns a range of all the social link types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.osb.www.marketing.events.model.impl.SocialLinkTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of social link types
	* @param end the upper bound of the range of social link types (not inclusive)
	* @return the range of social link types
	*/
	public static java.util.List<com.liferay.osb.www.marketing.events.model.SocialLinkType> getSocialLinkTypes(
		int start, int end) {
		return getService().getSocialLinkTypes(start, end);
	}

	public static java.util.List<com.liferay.osb.www.marketing.events.model.SocialLinkType> getSocialLinkTypes(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc) {
		return getService().getSocialLinkTypes(start, end, obc);
	}

	/**
	* Returns the number of social link types.
	*
	* @return the number of social link types
	*/
	public static int getSocialLinkTypesCount() {
		return getService().getSocialLinkTypesCount();
	}

	public static com.liferay.osb.www.marketing.events.model.SocialLinkType updateSocialLinkType(
		long socialLinkTypeId, java.lang.String name, long imageFileEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateSocialLinkType(socialLinkTypeId, name,
			imageFileEntryId);
	}

	/**
	* Updates the social link type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param socialLinkType the social link type
	* @return the social link type that was updated
	*/
	public static com.liferay.osb.www.marketing.events.model.SocialLinkType updateSocialLinkType(
		com.liferay.osb.www.marketing.events.model.SocialLinkType socialLinkType) {
		return getService().updateSocialLinkType(socialLinkType);
	}

	public static SocialLinkTypeLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SocialLinkTypeLocalService, SocialLinkTypeLocalService> _serviceTracker =
		ServiceTrackerFactory.open(SocialLinkTypeLocalService.class);
}