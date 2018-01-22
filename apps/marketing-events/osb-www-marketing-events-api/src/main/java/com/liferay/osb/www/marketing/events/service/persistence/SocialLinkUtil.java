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

package com.liferay.osb.www.marketing.events.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osb.www.marketing.events.model.SocialLink;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the social link service. This utility wraps {@link com.liferay.osb.www.marketing.events.service.persistence.impl.SocialLinkPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SocialLinkPersistence
 * @see com.liferay.osb.www.marketing.events.service.persistence.impl.SocialLinkPersistenceImpl
 * @generated
 */
@ProviderType
public class SocialLinkUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(SocialLink socialLink) {
		getPersistence().clearCache(socialLink);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SocialLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SocialLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SocialLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SocialLink> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SocialLink update(SocialLink socialLink) {
		return getPersistence().update(socialLink);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SocialLink update(SocialLink socialLink,
		ServiceContext serviceContext) {
		return getPersistence().update(socialLink, serviceContext);
	}

	/**
	* Returns all the social links where marketingEventUserId = &#63;.
	*
	* @param marketingEventUserId the marketing event user ID
	* @return the matching social links
	*/
	public static List<SocialLink> findByMarketingEventUserId(
		long marketingEventUserId) {
		return getPersistence().findByMarketingEventUserId(marketingEventUserId);
	}

	/**
	* Returns a range of all the social links where marketingEventUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SocialLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param marketingEventUserId the marketing event user ID
	* @param start the lower bound of the range of social links
	* @param end the upper bound of the range of social links (not inclusive)
	* @return the range of matching social links
	*/
	public static List<SocialLink> findByMarketingEventUserId(
		long marketingEventUserId, int start, int end) {
		return getPersistence()
				   .findByMarketingEventUserId(marketingEventUserId, start, end);
	}

	/**
	* Returns an ordered range of all the social links where marketingEventUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SocialLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param marketingEventUserId the marketing event user ID
	* @param start the lower bound of the range of social links
	* @param end the upper bound of the range of social links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching social links
	*/
	public static List<SocialLink> findByMarketingEventUserId(
		long marketingEventUserId, int start, int end,
		OrderByComparator<SocialLink> orderByComparator) {
		return getPersistence()
				   .findByMarketingEventUserId(marketingEventUserId, start,
			end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the social links where marketingEventUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SocialLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param marketingEventUserId the marketing event user ID
	* @param start the lower bound of the range of social links
	* @param end the upper bound of the range of social links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching social links
	*/
	public static List<SocialLink> findByMarketingEventUserId(
		long marketingEventUserId, int start, int end,
		OrderByComparator<SocialLink> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByMarketingEventUserId(marketingEventUserId, start,
			end, orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first social link in the ordered set where marketingEventUserId = &#63;.
	*
	* @param marketingEventUserId the marketing event user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching social link
	* @throws NoSuchSocialLinkException if a matching social link could not be found
	*/
	public static SocialLink findByMarketingEventUserId_First(
		long marketingEventUserId,
		OrderByComparator<SocialLink> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchSocialLinkException {
		return getPersistence()
				   .findByMarketingEventUserId_First(marketingEventUserId,
			orderByComparator);
	}

	/**
	* Returns the first social link in the ordered set where marketingEventUserId = &#63;.
	*
	* @param marketingEventUserId the marketing event user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching social link, or <code>null</code> if a matching social link could not be found
	*/
	public static SocialLink fetchByMarketingEventUserId_First(
		long marketingEventUserId,
		OrderByComparator<SocialLink> orderByComparator) {
		return getPersistence()
				   .fetchByMarketingEventUserId_First(marketingEventUserId,
			orderByComparator);
	}

	/**
	* Returns the last social link in the ordered set where marketingEventUserId = &#63;.
	*
	* @param marketingEventUserId the marketing event user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching social link
	* @throws NoSuchSocialLinkException if a matching social link could not be found
	*/
	public static SocialLink findByMarketingEventUserId_Last(
		long marketingEventUserId,
		OrderByComparator<SocialLink> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchSocialLinkException {
		return getPersistence()
				   .findByMarketingEventUserId_Last(marketingEventUserId,
			orderByComparator);
	}

	/**
	* Returns the last social link in the ordered set where marketingEventUserId = &#63;.
	*
	* @param marketingEventUserId the marketing event user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching social link, or <code>null</code> if a matching social link could not be found
	*/
	public static SocialLink fetchByMarketingEventUserId_Last(
		long marketingEventUserId,
		OrderByComparator<SocialLink> orderByComparator) {
		return getPersistence()
				   .fetchByMarketingEventUserId_Last(marketingEventUserId,
			orderByComparator);
	}

	/**
	* Returns the social links before and after the current social link in the ordered set where marketingEventUserId = &#63;.
	*
	* @param socialLinkId the primary key of the current social link
	* @param marketingEventUserId the marketing event user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next social link
	* @throws NoSuchSocialLinkException if a social link with the primary key could not be found
	*/
	public static SocialLink[] findByMarketingEventUserId_PrevAndNext(
		long socialLinkId, long marketingEventUserId,
		OrderByComparator<SocialLink> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchSocialLinkException {
		return getPersistence()
				   .findByMarketingEventUserId_PrevAndNext(socialLinkId,
			marketingEventUserId, orderByComparator);
	}

	/**
	* Removes all the social links where marketingEventUserId = &#63; from the database.
	*
	* @param marketingEventUserId the marketing event user ID
	*/
	public static void removeByMarketingEventUserId(long marketingEventUserId) {
		getPersistence().removeByMarketingEventUserId(marketingEventUserId);
	}

	/**
	* Returns the number of social links where marketingEventUserId = &#63;.
	*
	* @param marketingEventUserId the marketing event user ID
	* @return the number of matching social links
	*/
	public static int countByMarketingEventUserId(long marketingEventUserId) {
		return getPersistence().countByMarketingEventUserId(marketingEventUserId);
	}

	/**
	* Returns all the social links where socialLinkTypeId = &#63;.
	*
	* @param socialLinkTypeId the social link type ID
	* @return the matching social links
	*/
	public static List<SocialLink> findBySocialLinkTypeId(long socialLinkTypeId) {
		return getPersistence().findBySocialLinkTypeId(socialLinkTypeId);
	}

	/**
	* Returns a range of all the social links where socialLinkTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SocialLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param socialLinkTypeId the social link type ID
	* @param start the lower bound of the range of social links
	* @param end the upper bound of the range of social links (not inclusive)
	* @return the range of matching social links
	*/
	public static List<SocialLink> findBySocialLinkTypeId(
		long socialLinkTypeId, int start, int end) {
		return getPersistence()
				   .findBySocialLinkTypeId(socialLinkTypeId, start, end);
	}

	/**
	* Returns an ordered range of all the social links where socialLinkTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SocialLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param socialLinkTypeId the social link type ID
	* @param start the lower bound of the range of social links
	* @param end the upper bound of the range of social links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching social links
	*/
	public static List<SocialLink> findBySocialLinkTypeId(
		long socialLinkTypeId, int start, int end,
		OrderByComparator<SocialLink> orderByComparator) {
		return getPersistence()
				   .findBySocialLinkTypeId(socialLinkTypeId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the social links where socialLinkTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SocialLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param socialLinkTypeId the social link type ID
	* @param start the lower bound of the range of social links
	* @param end the upper bound of the range of social links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching social links
	*/
	public static List<SocialLink> findBySocialLinkTypeId(
		long socialLinkTypeId, int start, int end,
		OrderByComparator<SocialLink> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBySocialLinkTypeId(socialLinkTypeId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first social link in the ordered set where socialLinkTypeId = &#63;.
	*
	* @param socialLinkTypeId the social link type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching social link
	* @throws NoSuchSocialLinkException if a matching social link could not be found
	*/
	public static SocialLink findBySocialLinkTypeId_First(
		long socialLinkTypeId, OrderByComparator<SocialLink> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchSocialLinkException {
		return getPersistence()
				   .findBySocialLinkTypeId_First(socialLinkTypeId,
			orderByComparator);
	}

	/**
	* Returns the first social link in the ordered set where socialLinkTypeId = &#63;.
	*
	* @param socialLinkTypeId the social link type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching social link, or <code>null</code> if a matching social link could not be found
	*/
	public static SocialLink fetchBySocialLinkTypeId_First(
		long socialLinkTypeId, OrderByComparator<SocialLink> orderByComparator) {
		return getPersistence()
				   .fetchBySocialLinkTypeId_First(socialLinkTypeId,
			orderByComparator);
	}

	/**
	* Returns the last social link in the ordered set where socialLinkTypeId = &#63;.
	*
	* @param socialLinkTypeId the social link type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching social link
	* @throws NoSuchSocialLinkException if a matching social link could not be found
	*/
	public static SocialLink findBySocialLinkTypeId_Last(
		long socialLinkTypeId, OrderByComparator<SocialLink> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchSocialLinkException {
		return getPersistence()
				   .findBySocialLinkTypeId_Last(socialLinkTypeId,
			orderByComparator);
	}

	/**
	* Returns the last social link in the ordered set where socialLinkTypeId = &#63;.
	*
	* @param socialLinkTypeId the social link type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching social link, or <code>null</code> if a matching social link could not be found
	*/
	public static SocialLink fetchBySocialLinkTypeId_Last(
		long socialLinkTypeId, OrderByComparator<SocialLink> orderByComparator) {
		return getPersistence()
				   .fetchBySocialLinkTypeId_Last(socialLinkTypeId,
			orderByComparator);
	}

	/**
	* Returns the social links before and after the current social link in the ordered set where socialLinkTypeId = &#63;.
	*
	* @param socialLinkId the primary key of the current social link
	* @param socialLinkTypeId the social link type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next social link
	* @throws NoSuchSocialLinkException if a social link with the primary key could not be found
	*/
	public static SocialLink[] findBySocialLinkTypeId_PrevAndNext(
		long socialLinkId, long socialLinkTypeId,
		OrderByComparator<SocialLink> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchSocialLinkException {
		return getPersistence()
				   .findBySocialLinkTypeId_PrevAndNext(socialLinkId,
			socialLinkTypeId, orderByComparator);
	}

	/**
	* Removes all the social links where socialLinkTypeId = &#63; from the database.
	*
	* @param socialLinkTypeId the social link type ID
	*/
	public static void removeBySocialLinkTypeId(long socialLinkTypeId) {
		getPersistence().removeBySocialLinkTypeId(socialLinkTypeId);
	}

	/**
	* Returns the number of social links where socialLinkTypeId = &#63;.
	*
	* @param socialLinkTypeId the social link type ID
	* @return the number of matching social links
	*/
	public static int countBySocialLinkTypeId(long socialLinkTypeId) {
		return getPersistence().countBySocialLinkTypeId(socialLinkTypeId);
	}

	/**
	* Returns all the social links where marketingEventUserId = &#63; and socialLinkTypeId = &#63;.
	*
	* @param marketingEventUserId the marketing event user ID
	* @param socialLinkTypeId the social link type ID
	* @return the matching social links
	*/
	public static List<SocialLink> findByMEUI_SLTI(long marketingEventUserId,
		long socialLinkTypeId) {
		return getPersistence()
				   .findByMEUI_SLTI(marketingEventUserId, socialLinkTypeId);
	}

	/**
	* Returns a range of all the social links where marketingEventUserId = &#63; and socialLinkTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SocialLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param marketingEventUserId the marketing event user ID
	* @param socialLinkTypeId the social link type ID
	* @param start the lower bound of the range of social links
	* @param end the upper bound of the range of social links (not inclusive)
	* @return the range of matching social links
	*/
	public static List<SocialLink> findByMEUI_SLTI(long marketingEventUserId,
		long socialLinkTypeId, int start, int end) {
		return getPersistence()
				   .findByMEUI_SLTI(marketingEventUserId, socialLinkTypeId,
			start, end);
	}

	/**
	* Returns an ordered range of all the social links where marketingEventUserId = &#63; and socialLinkTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SocialLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param marketingEventUserId the marketing event user ID
	* @param socialLinkTypeId the social link type ID
	* @param start the lower bound of the range of social links
	* @param end the upper bound of the range of social links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching social links
	*/
	public static List<SocialLink> findByMEUI_SLTI(long marketingEventUserId,
		long socialLinkTypeId, int start, int end,
		OrderByComparator<SocialLink> orderByComparator) {
		return getPersistence()
				   .findByMEUI_SLTI(marketingEventUserId, socialLinkTypeId,
			start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the social links where marketingEventUserId = &#63; and socialLinkTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SocialLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param marketingEventUserId the marketing event user ID
	* @param socialLinkTypeId the social link type ID
	* @param start the lower bound of the range of social links
	* @param end the upper bound of the range of social links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching social links
	*/
	public static List<SocialLink> findByMEUI_SLTI(long marketingEventUserId,
		long socialLinkTypeId, int start, int end,
		OrderByComparator<SocialLink> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByMEUI_SLTI(marketingEventUserId, socialLinkTypeId,
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first social link in the ordered set where marketingEventUserId = &#63; and socialLinkTypeId = &#63;.
	*
	* @param marketingEventUserId the marketing event user ID
	* @param socialLinkTypeId the social link type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching social link
	* @throws NoSuchSocialLinkException if a matching social link could not be found
	*/
	public static SocialLink findByMEUI_SLTI_First(long marketingEventUserId,
		long socialLinkTypeId, OrderByComparator<SocialLink> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchSocialLinkException {
		return getPersistence()
				   .findByMEUI_SLTI_First(marketingEventUserId,
			socialLinkTypeId, orderByComparator);
	}

	/**
	* Returns the first social link in the ordered set where marketingEventUserId = &#63; and socialLinkTypeId = &#63;.
	*
	* @param marketingEventUserId the marketing event user ID
	* @param socialLinkTypeId the social link type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching social link, or <code>null</code> if a matching social link could not be found
	*/
	public static SocialLink fetchByMEUI_SLTI_First(long marketingEventUserId,
		long socialLinkTypeId, OrderByComparator<SocialLink> orderByComparator) {
		return getPersistence()
				   .fetchByMEUI_SLTI_First(marketingEventUserId,
			socialLinkTypeId, orderByComparator);
	}

	/**
	* Returns the last social link in the ordered set where marketingEventUserId = &#63; and socialLinkTypeId = &#63;.
	*
	* @param marketingEventUserId the marketing event user ID
	* @param socialLinkTypeId the social link type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching social link
	* @throws NoSuchSocialLinkException if a matching social link could not be found
	*/
	public static SocialLink findByMEUI_SLTI_Last(long marketingEventUserId,
		long socialLinkTypeId, OrderByComparator<SocialLink> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchSocialLinkException {
		return getPersistence()
				   .findByMEUI_SLTI_Last(marketingEventUserId,
			socialLinkTypeId, orderByComparator);
	}

	/**
	* Returns the last social link in the ordered set where marketingEventUserId = &#63; and socialLinkTypeId = &#63;.
	*
	* @param marketingEventUserId the marketing event user ID
	* @param socialLinkTypeId the social link type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching social link, or <code>null</code> if a matching social link could not be found
	*/
	public static SocialLink fetchByMEUI_SLTI_Last(long marketingEventUserId,
		long socialLinkTypeId, OrderByComparator<SocialLink> orderByComparator) {
		return getPersistence()
				   .fetchByMEUI_SLTI_Last(marketingEventUserId,
			socialLinkTypeId, orderByComparator);
	}

	/**
	* Returns the social links before and after the current social link in the ordered set where marketingEventUserId = &#63; and socialLinkTypeId = &#63;.
	*
	* @param socialLinkId the primary key of the current social link
	* @param marketingEventUserId the marketing event user ID
	* @param socialLinkTypeId the social link type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next social link
	* @throws NoSuchSocialLinkException if a social link with the primary key could not be found
	*/
	public static SocialLink[] findByMEUI_SLTI_PrevAndNext(long socialLinkId,
		long marketingEventUserId, long socialLinkTypeId,
		OrderByComparator<SocialLink> orderByComparator)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchSocialLinkException {
		return getPersistence()
				   .findByMEUI_SLTI_PrevAndNext(socialLinkId,
			marketingEventUserId, socialLinkTypeId, orderByComparator);
	}

	/**
	* Removes all the social links where marketingEventUserId = &#63; and socialLinkTypeId = &#63; from the database.
	*
	* @param marketingEventUserId the marketing event user ID
	* @param socialLinkTypeId the social link type ID
	*/
	public static void removeByMEUI_SLTI(long marketingEventUserId,
		long socialLinkTypeId) {
		getPersistence()
			.removeByMEUI_SLTI(marketingEventUserId, socialLinkTypeId);
	}

	/**
	* Returns the number of social links where marketingEventUserId = &#63; and socialLinkTypeId = &#63;.
	*
	* @param marketingEventUserId the marketing event user ID
	* @param socialLinkTypeId the social link type ID
	* @return the number of matching social links
	*/
	public static int countByMEUI_SLTI(long marketingEventUserId,
		long socialLinkTypeId) {
		return getPersistence()
				   .countByMEUI_SLTI(marketingEventUserId, socialLinkTypeId);
	}

	/**
	* Caches the social link in the entity cache if it is enabled.
	*
	* @param socialLink the social link
	*/
	public static void cacheResult(SocialLink socialLink) {
		getPersistence().cacheResult(socialLink);
	}

	/**
	* Caches the social links in the entity cache if it is enabled.
	*
	* @param socialLinks the social links
	*/
	public static void cacheResult(List<SocialLink> socialLinks) {
		getPersistence().cacheResult(socialLinks);
	}

	/**
	* Creates a new social link with the primary key. Does not add the social link to the database.
	*
	* @param socialLinkId the primary key for the new social link
	* @return the new social link
	*/
	public static SocialLink create(long socialLinkId) {
		return getPersistence().create(socialLinkId);
	}

	/**
	* Removes the social link with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param socialLinkId the primary key of the social link
	* @return the social link that was removed
	* @throws NoSuchSocialLinkException if a social link with the primary key could not be found
	*/
	public static SocialLink remove(long socialLinkId)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchSocialLinkException {
		return getPersistence().remove(socialLinkId);
	}

	public static SocialLink updateImpl(SocialLink socialLink) {
		return getPersistence().updateImpl(socialLink);
	}

	/**
	* Returns the social link with the primary key or throws a {@link NoSuchSocialLinkException} if it could not be found.
	*
	* @param socialLinkId the primary key of the social link
	* @return the social link
	* @throws NoSuchSocialLinkException if a social link with the primary key could not be found
	*/
	public static SocialLink findByPrimaryKey(long socialLinkId)
		throws com.liferay.osb.www.marketing.events.exception.NoSuchSocialLinkException {
		return getPersistence().findByPrimaryKey(socialLinkId);
	}

	/**
	* Returns the social link with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param socialLinkId the primary key of the social link
	* @return the social link, or <code>null</code> if a social link with the primary key could not be found
	*/
	public static SocialLink fetchByPrimaryKey(long socialLinkId) {
		return getPersistence().fetchByPrimaryKey(socialLinkId);
	}

	public static java.util.Map<java.io.Serializable, SocialLink> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the social links.
	*
	* @return the social links
	*/
	public static List<SocialLink> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the social links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SocialLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of social links
	* @param end the upper bound of the range of social links (not inclusive)
	* @return the range of social links
	*/
	public static List<SocialLink> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the social links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SocialLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of social links
	* @param end the upper bound of the range of social links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of social links
	*/
	public static List<SocialLink> findAll(int start, int end,
		OrderByComparator<SocialLink> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the social links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SocialLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of social links
	* @param end the upper bound of the range of social links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of social links
	*/
	public static List<SocialLink> findAll(int start, int end,
		OrderByComparator<SocialLink> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the social links from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of social links.
	*
	* @return the number of social links
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SocialLinkPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SocialLinkPersistence, SocialLinkPersistence> _serviceTracker =
		ServiceTrackerFactory.open(SocialLinkPersistence.class);
}