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

import com.liferay.osb.www.marketing.events.exception.NoSuchSocialLinkException;
import com.liferay.osb.www.marketing.events.model.SocialLink;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the social link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.osb.www.marketing.events.service.persistence.impl.SocialLinkPersistenceImpl
 * @see SocialLinkUtil
 * @generated
 */
@ProviderType
public interface SocialLinkPersistence extends BasePersistence<SocialLink> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SocialLinkUtil} to access the social link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the social links where marketingEventUserId = &#63;.
	*
	* @param marketingEventUserId the marketing event user ID
	* @return the matching social links
	*/
	public java.util.List<SocialLink> findByMarketingEventUserId(
		long marketingEventUserId);

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
	public java.util.List<SocialLink> findByMarketingEventUserId(
		long marketingEventUserId, int start, int end);

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
	public java.util.List<SocialLink> findByMarketingEventUserId(
		long marketingEventUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SocialLink> orderByComparator);

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
	public java.util.List<SocialLink> findByMarketingEventUserId(
		long marketingEventUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SocialLink> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first social link in the ordered set where marketingEventUserId = &#63;.
	*
	* @param marketingEventUserId the marketing event user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching social link
	* @throws NoSuchSocialLinkException if a matching social link could not be found
	*/
	public SocialLink findByMarketingEventUserId_First(
		long marketingEventUserId,
		com.liferay.portal.kernel.util.OrderByComparator<SocialLink> orderByComparator)
		throws NoSuchSocialLinkException;

	/**
	* Returns the first social link in the ordered set where marketingEventUserId = &#63;.
	*
	* @param marketingEventUserId the marketing event user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching social link, or <code>null</code> if a matching social link could not be found
	*/
	public SocialLink fetchByMarketingEventUserId_First(
		long marketingEventUserId,
		com.liferay.portal.kernel.util.OrderByComparator<SocialLink> orderByComparator);

	/**
	* Returns the last social link in the ordered set where marketingEventUserId = &#63;.
	*
	* @param marketingEventUserId the marketing event user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching social link
	* @throws NoSuchSocialLinkException if a matching social link could not be found
	*/
	public SocialLink findByMarketingEventUserId_Last(
		long marketingEventUserId,
		com.liferay.portal.kernel.util.OrderByComparator<SocialLink> orderByComparator)
		throws NoSuchSocialLinkException;

	/**
	* Returns the last social link in the ordered set where marketingEventUserId = &#63;.
	*
	* @param marketingEventUserId the marketing event user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching social link, or <code>null</code> if a matching social link could not be found
	*/
	public SocialLink fetchByMarketingEventUserId_Last(
		long marketingEventUserId,
		com.liferay.portal.kernel.util.OrderByComparator<SocialLink> orderByComparator);

	/**
	* Returns the social links before and after the current social link in the ordered set where marketingEventUserId = &#63;.
	*
	* @param socialLinkId the primary key of the current social link
	* @param marketingEventUserId the marketing event user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next social link
	* @throws NoSuchSocialLinkException if a social link with the primary key could not be found
	*/
	public SocialLink[] findByMarketingEventUserId_PrevAndNext(
		long socialLinkId, long marketingEventUserId,
		com.liferay.portal.kernel.util.OrderByComparator<SocialLink> orderByComparator)
		throws NoSuchSocialLinkException;

	/**
	* Removes all the social links where marketingEventUserId = &#63; from the database.
	*
	* @param marketingEventUserId the marketing event user ID
	*/
	public void removeByMarketingEventUserId(long marketingEventUserId);

	/**
	* Returns the number of social links where marketingEventUserId = &#63;.
	*
	* @param marketingEventUserId the marketing event user ID
	* @return the number of matching social links
	*/
	public int countByMarketingEventUserId(long marketingEventUserId);

	/**
	* Returns all the social links where socialLinkTypeId = &#63;.
	*
	* @param socialLinkTypeId the social link type ID
	* @return the matching social links
	*/
	public java.util.List<SocialLink> findBySocialLinkTypeId(
		long socialLinkTypeId);

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
	public java.util.List<SocialLink> findBySocialLinkTypeId(
		long socialLinkTypeId, int start, int end);

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
	public java.util.List<SocialLink> findBySocialLinkTypeId(
		long socialLinkTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SocialLink> orderByComparator);

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
	public java.util.List<SocialLink> findBySocialLinkTypeId(
		long socialLinkTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SocialLink> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first social link in the ordered set where socialLinkTypeId = &#63;.
	*
	* @param socialLinkTypeId the social link type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching social link
	* @throws NoSuchSocialLinkException if a matching social link could not be found
	*/
	public SocialLink findBySocialLinkTypeId_First(long socialLinkTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<SocialLink> orderByComparator)
		throws NoSuchSocialLinkException;

	/**
	* Returns the first social link in the ordered set where socialLinkTypeId = &#63;.
	*
	* @param socialLinkTypeId the social link type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching social link, or <code>null</code> if a matching social link could not be found
	*/
	public SocialLink fetchBySocialLinkTypeId_First(long socialLinkTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<SocialLink> orderByComparator);

	/**
	* Returns the last social link in the ordered set where socialLinkTypeId = &#63;.
	*
	* @param socialLinkTypeId the social link type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching social link
	* @throws NoSuchSocialLinkException if a matching social link could not be found
	*/
	public SocialLink findBySocialLinkTypeId_Last(long socialLinkTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<SocialLink> orderByComparator)
		throws NoSuchSocialLinkException;

	/**
	* Returns the last social link in the ordered set where socialLinkTypeId = &#63;.
	*
	* @param socialLinkTypeId the social link type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching social link, or <code>null</code> if a matching social link could not be found
	*/
	public SocialLink fetchBySocialLinkTypeId_Last(long socialLinkTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<SocialLink> orderByComparator);

	/**
	* Returns the social links before and after the current social link in the ordered set where socialLinkTypeId = &#63;.
	*
	* @param socialLinkId the primary key of the current social link
	* @param socialLinkTypeId the social link type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next social link
	* @throws NoSuchSocialLinkException if a social link with the primary key could not be found
	*/
	public SocialLink[] findBySocialLinkTypeId_PrevAndNext(long socialLinkId,
		long socialLinkTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<SocialLink> orderByComparator)
		throws NoSuchSocialLinkException;

	/**
	* Removes all the social links where socialLinkTypeId = &#63; from the database.
	*
	* @param socialLinkTypeId the social link type ID
	*/
	public void removeBySocialLinkTypeId(long socialLinkTypeId);

	/**
	* Returns the number of social links where socialLinkTypeId = &#63;.
	*
	* @param socialLinkTypeId the social link type ID
	* @return the number of matching social links
	*/
	public int countBySocialLinkTypeId(long socialLinkTypeId);

	/**
	* Returns all the social links where marketingEventUserId = &#63; and socialLinkTypeId = &#63;.
	*
	* @param marketingEventUserId the marketing event user ID
	* @param socialLinkTypeId the social link type ID
	* @return the matching social links
	*/
	public java.util.List<SocialLink> findByMEUI_SLTI(
		long marketingEventUserId, long socialLinkTypeId);

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
	public java.util.List<SocialLink> findByMEUI_SLTI(
		long marketingEventUserId, long socialLinkTypeId, int start, int end);

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
	public java.util.List<SocialLink> findByMEUI_SLTI(
		long marketingEventUserId, long socialLinkTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SocialLink> orderByComparator);

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
	public java.util.List<SocialLink> findByMEUI_SLTI(
		long marketingEventUserId, long socialLinkTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SocialLink> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first social link in the ordered set where marketingEventUserId = &#63; and socialLinkTypeId = &#63;.
	*
	* @param marketingEventUserId the marketing event user ID
	* @param socialLinkTypeId the social link type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching social link
	* @throws NoSuchSocialLinkException if a matching social link could not be found
	*/
	public SocialLink findByMEUI_SLTI_First(long marketingEventUserId,
		long socialLinkTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<SocialLink> orderByComparator)
		throws NoSuchSocialLinkException;

	/**
	* Returns the first social link in the ordered set where marketingEventUserId = &#63; and socialLinkTypeId = &#63;.
	*
	* @param marketingEventUserId the marketing event user ID
	* @param socialLinkTypeId the social link type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching social link, or <code>null</code> if a matching social link could not be found
	*/
	public SocialLink fetchByMEUI_SLTI_First(long marketingEventUserId,
		long socialLinkTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<SocialLink> orderByComparator);

	/**
	* Returns the last social link in the ordered set where marketingEventUserId = &#63; and socialLinkTypeId = &#63;.
	*
	* @param marketingEventUserId the marketing event user ID
	* @param socialLinkTypeId the social link type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching social link
	* @throws NoSuchSocialLinkException if a matching social link could not be found
	*/
	public SocialLink findByMEUI_SLTI_Last(long marketingEventUserId,
		long socialLinkTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<SocialLink> orderByComparator)
		throws NoSuchSocialLinkException;

	/**
	* Returns the last social link in the ordered set where marketingEventUserId = &#63; and socialLinkTypeId = &#63;.
	*
	* @param marketingEventUserId the marketing event user ID
	* @param socialLinkTypeId the social link type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching social link, or <code>null</code> if a matching social link could not be found
	*/
	public SocialLink fetchByMEUI_SLTI_Last(long marketingEventUserId,
		long socialLinkTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<SocialLink> orderByComparator);

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
	public SocialLink[] findByMEUI_SLTI_PrevAndNext(long socialLinkId,
		long marketingEventUserId, long socialLinkTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<SocialLink> orderByComparator)
		throws NoSuchSocialLinkException;

	/**
	* Removes all the social links where marketingEventUserId = &#63; and socialLinkTypeId = &#63; from the database.
	*
	* @param marketingEventUserId the marketing event user ID
	* @param socialLinkTypeId the social link type ID
	*/
	public void removeByMEUI_SLTI(long marketingEventUserId,
		long socialLinkTypeId);

	/**
	* Returns the number of social links where marketingEventUserId = &#63; and socialLinkTypeId = &#63;.
	*
	* @param marketingEventUserId the marketing event user ID
	* @param socialLinkTypeId the social link type ID
	* @return the number of matching social links
	*/
	public int countByMEUI_SLTI(long marketingEventUserId, long socialLinkTypeId);

	/**
	* Caches the social link in the entity cache if it is enabled.
	*
	* @param socialLink the social link
	*/
	public void cacheResult(SocialLink socialLink);

	/**
	* Caches the social links in the entity cache if it is enabled.
	*
	* @param socialLinks the social links
	*/
	public void cacheResult(java.util.List<SocialLink> socialLinks);

	/**
	* Creates a new social link with the primary key. Does not add the social link to the database.
	*
	* @param socialLinkId the primary key for the new social link
	* @return the new social link
	*/
	public SocialLink create(long socialLinkId);

	/**
	* Removes the social link with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param socialLinkId the primary key of the social link
	* @return the social link that was removed
	* @throws NoSuchSocialLinkException if a social link with the primary key could not be found
	*/
	public SocialLink remove(long socialLinkId)
		throws NoSuchSocialLinkException;

	public SocialLink updateImpl(SocialLink socialLink);

	/**
	* Returns the social link with the primary key or throws a {@link NoSuchSocialLinkException} if it could not be found.
	*
	* @param socialLinkId the primary key of the social link
	* @return the social link
	* @throws NoSuchSocialLinkException if a social link with the primary key could not be found
	*/
	public SocialLink findByPrimaryKey(long socialLinkId)
		throws NoSuchSocialLinkException;

	/**
	* Returns the social link with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param socialLinkId the primary key of the social link
	* @return the social link, or <code>null</code> if a social link with the primary key could not be found
	*/
	public SocialLink fetchByPrimaryKey(long socialLinkId);

	@Override
	public java.util.Map<java.io.Serializable, SocialLink> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the social links.
	*
	* @return the social links
	*/
	public java.util.List<SocialLink> findAll();

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
	public java.util.List<SocialLink> findAll(int start, int end);

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
	public java.util.List<SocialLink> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SocialLink> orderByComparator);

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
	public java.util.List<SocialLink> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SocialLink> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the social links from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of social links.
	*
	* @return the number of social links
	*/
	public int countAll();
}