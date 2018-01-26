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

package com.liferay.osb.www.marketing.events.service.impl;

import com.liferay.osb.www.marketing.events.exception.DuplicateSocialLinkTypeException;
import com.liferay.osb.www.marketing.events.exception.SocialLinkURLException;
import com.liferay.osb.www.marketing.events.model.SocialLink;
import com.liferay.osb.www.marketing.events.model.SocialLinkType;
import com.liferay.osb.www.marketing.events.service.base.SocialLinkLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;
import java.util.List;

/**
 * @author Joan H. Kim
 * @author Phillip Chan
 * @author Weston Hancock
 */
public class SocialLinkLocalServiceImpl extends SocialLinkLocalServiceBaseImpl {

	public SocialLink addSocialLink(
			long userId, long marketingEventUserId, long socialLinkTypeId,
			String url)
		throws PortalException {

		User user = userPersistence.findByPrimaryKey(userId);
		SocialLinkType socialLinkType =
			socialLinkTypeLocalService.getSocialLinkType(socialLinkTypeId);
		Date now = new Date();

		validate(marketingEventUserId, socialLinkTypeId, url);

		long socialLinkId = counterLocalService.increment();

		SocialLink socialLink = socialLinkPersistence.create(socialLinkId);

		socialLink.setUserId(user.getUserId());
		socialLink.setUserName(user.getFullName());
		socialLink.setCreateDate(now);
		socialLink.setModifiedDate(now);
		socialLink.setMarketingEventUserId(marketingEventUserId);
		socialLink.setSocialLinkTypeId(socialLinkType.getSocialLinkTypeId());
		socialLink.setUrl(url);

		socialLinkPersistence.update(socialLink);

		return socialLink;
	}

	public List<SocialLink> getSocialLinks(
		long marketingEventUserId, int start, int end, OrderByComparator obc) {

		return socialLinkPersistence.findByMarketingEventUserId(
			marketingEventUserId, start, end, obc);
	}

	public SocialLink updateSocialLink(
			long socialLinkId, long socialLinkTypeId, String url)
		throws PortalException {

		SocialLink socialLink = socialLinkPersistence.findByPrimaryKey(
			socialLinkId);

		validate(socialLink.getMarketingEventUserId(), socialLinkTypeId, url);

		socialLink.setModifiedDate(new Date());
		socialLink.setSocialLinkTypeId(socialLinkTypeId);
		socialLink.setUrl(url);

		socialLinkPersistence.update(socialLink);

		return socialLink;
	}

	protected void validate(
			long marketingEventUserId, long socialLinkTypeId, String url)
		throws PortalException {

		if (!Validator.isUrl(url)) {
			throw new SocialLinkURLException();
		}

		if (Validator.isNotNull(marketingEventUserId) &&
			Validator.isNotNull(socialLinkTypeId)) {

			int count = socialLinkPersistence.countByMEUI_SLTI(
				marketingEventUserId, socialLinkTypeId);

			if (count > 0) {
				throw new DuplicateSocialLinkTypeException();
			}
		}
	}

}