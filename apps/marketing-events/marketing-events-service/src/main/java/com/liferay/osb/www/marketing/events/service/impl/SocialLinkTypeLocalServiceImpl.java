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

import com.liferay.osb.www.marketing.events.exception.RequiredSocialLinkTypeException;
import com.liferay.osb.www.marketing.events.exception.SocialLinkTypeNameException;
import com.liferay.osb.www.marketing.events.model.SocialLinkType;
import com.liferay.osb.www.marketing.events.service.base.SocialLinkTypeLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;
import java.util.List;

/**
 * @author Joan H. Kim
 */
public class SocialLinkTypeLocalServiceImpl
	extends SocialLinkTypeLocalServiceBaseImpl {

	public SocialLinkType addSocialLinkType(
			long userId, String name, long imageFileEntryId)
		throws PortalException {

		User user = userPersistence.findByPrimaryKey(userId);
		Date now = new Date();

		validate(name);

		long socialLinkTypeId = counterLocalService.increment();

		SocialLinkType socialLinkType = socialLinkTypePersistence.create(
			socialLinkTypeId);

		socialLinkType.setUserId(user.getUserId());
		socialLinkType.setUserName(user.getFullName());
		socialLinkType.setCreateDate(now);
		socialLinkType.setModifiedDate(now);
		socialLinkType.setName(name);
		socialLinkType.setImageFileEntryId(imageFileEntryId);

		socialLinkTypePersistence.update(socialLinkType);

		return socialLinkType;
	}

	@Override
	public SocialLinkType deleteSocialLinkType(long socialLinkTypeId)
		throws PortalException {

		SocialLinkType socialLinkType =
			socialLinkTypePersistence.findByPrimaryKey(socialLinkTypeId);

		return deleteSocialLinkType(socialLinkType);
	}

	@Override
	public SocialLinkType deleteSocialLinkType(SocialLinkType socialLinkType)
		throws PortalException {

		int count = socialLinkPersistence.countBySocialLinkTypeId(
			socialLinkType.getSocialLinkTypeId());

		if (count > 0) {
			throw new RequiredSocialLinkTypeException();
		}

		socialLinkTypePersistence.remove(socialLinkType);

		return socialLinkType;
	}

	public List<SocialLinkType> getSocialLinkTypes(
		int start, int end, OrderByComparator obc) {

		return socialLinkTypePersistence.findAll(start, end, obc);
	}

	public SocialLinkType updateSocialLinkType(
			long socialLinkTypeId, String name, long imageFileEntryId)
		throws PortalException {

		validate(name);

		SocialLinkType socialLinkType =
			socialLinkTypePersistence.findByPrimaryKey(socialLinkTypeId);

		socialLinkType.setModifiedDate(new Date());
		socialLinkType.setName(name);
		socialLinkType.setImageFileEntryId(imageFileEntryId);

		socialLinkTypePersistence.update(socialLinkType);

		return socialLinkType;
	}

	protected void validate(String name) throws PortalException {
		if (Validator.isNull(name)) {
			throw new SocialLinkTypeNameException();
		}
	}

}