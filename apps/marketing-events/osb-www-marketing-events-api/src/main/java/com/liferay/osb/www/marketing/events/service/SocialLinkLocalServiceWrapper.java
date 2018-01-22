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
 * Provides a wrapper for {@link SocialLinkLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SocialLinkLocalService
 * @generated
 */
@ProviderType
public class SocialLinkLocalServiceWrapper implements SocialLinkLocalService,
	ServiceWrapper<SocialLinkLocalService> {
	public SocialLinkLocalServiceWrapper(
		SocialLinkLocalService socialLinkLocalService) {
		_socialLinkLocalService = socialLinkLocalService;
	}

	@Override
	public com.liferay.osb.www.marketing.events.model.SocialLink addSocialLink(
		long userId, long marketingEventUserId, long socialLinkTypeId,
		java.lang.String url)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _socialLinkLocalService.addSocialLink(userId,
			marketingEventUserId, socialLinkTypeId, url);
	}

	/**
	* Adds the social link to the database. Also notifies the appropriate model listeners.
	*
	* @param socialLink the social link
	* @return the social link that was added
	*/
	@Override
	public com.liferay.osb.www.marketing.events.model.SocialLink addSocialLink(
		com.liferay.osb.www.marketing.events.model.SocialLink socialLink) {
		return _socialLinkLocalService.addSocialLink(socialLink);
	}

	/**
	* Creates a new social link with the primary key. Does not add the social link to the database.
	*
	* @param socialLinkId the primary key for the new social link
	* @return the new social link
	*/
	@Override
	public com.liferay.osb.www.marketing.events.model.SocialLink createSocialLink(
		long socialLinkId) {
		return _socialLinkLocalService.createSocialLink(socialLinkId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _socialLinkLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the social link with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param socialLinkId the primary key of the social link
	* @return the social link that was removed
	* @throws PortalException if a social link with the primary key could not be found
	*/
	@Override
	public com.liferay.osb.www.marketing.events.model.SocialLink deleteSocialLink(
		long socialLinkId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _socialLinkLocalService.deleteSocialLink(socialLinkId);
	}

	/**
	* Deletes the social link from the database. Also notifies the appropriate model listeners.
	*
	* @param socialLink the social link
	* @return the social link that was removed
	*/
	@Override
	public com.liferay.osb.www.marketing.events.model.SocialLink deleteSocialLink(
		com.liferay.osb.www.marketing.events.model.SocialLink socialLink) {
		return _socialLinkLocalService.deleteSocialLink(socialLink);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _socialLinkLocalService.dynamicQuery();
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
		return _socialLinkLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.osb.www.marketing.events.model.impl.SocialLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _socialLinkLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.osb.www.marketing.events.model.impl.SocialLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _socialLinkLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _socialLinkLocalService.dynamicQueryCount(dynamicQuery);
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
		return _socialLinkLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.osb.www.marketing.events.model.SocialLink fetchSocialLink(
		long socialLinkId) {
		return _socialLinkLocalService.fetchSocialLink(socialLinkId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _socialLinkLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _socialLinkLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _socialLinkLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _socialLinkLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the social link with the primary key.
	*
	* @param socialLinkId the primary key of the social link
	* @return the social link
	* @throws PortalException if a social link with the primary key could not be found
	*/
	@Override
	public com.liferay.osb.www.marketing.events.model.SocialLink getSocialLink(
		long socialLinkId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _socialLinkLocalService.getSocialLink(socialLinkId);
	}

	/**
	* Returns a range of all the social links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.osb.www.marketing.events.model.impl.SocialLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of social links
	* @param end the upper bound of the range of social links (not inclusive)
	* @return the range of social links
	*/
	@Override
	public java.util.List<com.liferay.osb.www.marketing.events.model.SocialLink> getSocialLinks(
		int start, int end) {
		return _socialLinkLocalService.getSocialLinks(start, end);
	}

	@Override
	public java.util.List<com.liferay.osb.www.marketing.events.model.SocialLink> getSocialLinks(
		long marketingEventUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc) {
		return _socialLinkLocalService.getSocialLinks(marketingEventUserId,
			start, end, obc);
	}

	/**
	* Returns the number of social links.
	*
	* @return the number of social links
	*/
	@Override
	public int getSocialLinksCount() {
		return _socialLinkLocalService.getSocialLinksCount();
	}

	@Override
	public com.liferay.osb.www.marketing.events.model.SocialLink updateSocialLink(
		long socialLinkId, long socialLinkTypeId, java.lang.String url)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _socialLinkLocalService.updateSocialLink(socialLinkId,
			socialLinkTypeId, url);
	}

	/**
	* Updates the social link in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param socialLink the social link
	* @return the social link that was updated
	*/
	@Override
	public com.liferay.osb.www.marketing.events.model.SocialLink updateSocialLink(
		com.liferay.osb.www.marketing.events.model.SocialLink socialLink) {
		return _socialLinkLocalService.updateSocialLink(socialLink);
	}

	@Override
	public SocialLinkLocalService getWrappedService() {
		return _socialLinkLocalService;
	}

	@Override
	public void setWrappedService(SocialLinkLocalService socialLinkLocalService) {
		_socialLinkLocalService = socialLinkLocalService;
	}

	private SocialLinkLocalService _socialLinkLocalService;
}