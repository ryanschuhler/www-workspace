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

import com.liferay.osb.www.marketing.events.exception.MarketingEventUserCompanyException;
import com.liferay.osb.www.marketing.events.exception.MarketingEventUserFirstNameException;
import com.liferay.osb.www.marketing.events.exception.MarketingEventUserLastNameException;
import com.liferay.osb.www.marketing.events.exception.MarketingEventUserPhoneNumberException;
import com.liferay.osb.www.marketing.events.exception.RequiredMarketingEventUserException;
import com.liferay.osb.www.marketing.events.model.MarketingEventUser;
import com.liferay.osb.www.marketing.events.service.base.MarketingEventUserLocalServiceBaseImpl;
import com.liferay.osb.www.marketing.events.util.comparator.AssetEntryPriorityComparator;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @author Joan H. Kim
 */
public class MarketingEventUserLocalServiceImpl
	extends MarketingEventUserLocalServiceBaseImpl {

	public MarketingEventUser addMarketingEventUser(
			long userId, long marketingEventId, String firstName,
			String lastName, String companyName, long companyLogoFileEntryId,
			Map<Locale, String> jobTitleMap, Map<Locale, String> descriptionMap,
			long imageFileEntryId, String phoneNumber, int status,
			ServiceContext serviceContext)
		throws PortalException {

		User user = userPersistence.findByPrimaryKey(userId);
		Date now = new Date();

		validate(firstName, lastName, companyName, phoneNumber);

		long marketingEventUserId = counterLocalService.increment();

		MarketingEventUser marketingEventUser =
			marketingEventUserPersistence.create(marketingEventUserId);

		marketingEventUser.setUserId(user.getUserId());
		marketingEventUser.setUserName(user.getFullName());
		marketingEventUser.setCreateDate(serviceContext.getCreateDate(now));
		marketingEventUser.setModifiedDate(serviceContext.getModifiedDate(now));
		marketingEventUser.setMarketingEventId(marketingEventId);
		marketingEventUser.setFirstName(firstName);
		marketingEventUser.setLastName(lastName);
		marketingEventUser.setCompanyName(companyName);
		marketingEventUser.setCompanyLogoFileEntryId(companyLogoFileEntryId);
		marketingEventUser.setJobTitleMap(jobTitleMap);
		marketingEventUser.setDescriptionMap(descriptionMap);
		marketingEventUser.setImageFileEntryId(imageFileEntryId);
		marketingEventUser.setPhoneNumber(phoneNumber);
		marketingEventUser.setStatus(status);
		marketingEventUser.setStatusByUserId(user.getUserId());
		marketingEventUser.setStatusByUserName(user.getFullName());
		marketingEventUser.setStatusDate(serviceContext.getModifiedDate(now));

		marketingEventUserPersistence.update(marketingEventUser);

		updateAsset(marketingEventUser, null, serviceContext);

		return marketingEventUser;
	}

	@Override
	public MarketingEventUser deleteMarketingEventUser(
			long marketingEventUserId)
		throws PortalException {

		MarketingEventUser marketingEventUser =
			marketingEventUserPersistence.findByPrimaryKey(
				marketingEventUserId);

		return deleteMarketingEventUser(marketingEventUser);
	}

	@Override
	public MarketingEventUser deleteMarketingEventUser(
			MarketingEventUser marketingEventUser)
		throws PortalException {

		int count = marketingEventUserPersistence.getMarketingEventSessionsSize(
			marketingEventUser.getMarketingEventUserId());

		if (count > 0) {
			throw new RequiredMarketingEventUserException();
		}

		marketingEventUserPersistence.remove(marketingEventUser);

		assetEntryLocalService.deleteEntry(
			MarketingEventUser.class.getName(),
			marketingEventUser.getMarketingEventUserId());

		return marketingEventUser;
	}

	public List<MarketingEventUser> getMarketingEventUsers(
		long marketingEventId, int status, int start, int end) {

		return getMarketingEventUsers(
			marketingEventId, status, start, end, null);
	}

	public List<MarketingEventUser> getMarketingEventUsers(
		long marketingEventId, int status, int start, int end,
		OrderByComparator obc) {

		List<MarketingEventUser> marketingEventUsers = null;

		if (status == WorkflowConstants.STATUS_ANY) {
			marketingEventUsers =
				marketingEventUserPersistence.findByMarketingEventId(
					marketingEventId, start, end, obc);
		}
		else {
			marketingEventUsers = marketingEventUserPersistence.findByMEI_S(
				marketingEventId, status, start, end, obc);
		}

		if (obc == null) {
			marketingEventUsers = ListUtil.sort(
				marketingEventUsers, new AssetEntryPriorityComparator());
		}

		return marketingEventUsers;
	}

	public List<MarketingEventUser> getMarketingEventUsers(
		long marketingEventId, int start, int end, OrderByComparator obc) {

		return getMarketingEventUsers(
			marketingEventId, WorkflowConstants.STATUS_ANY, start, end, obc);
	}

	public List<MarketingEventUser> getMarketingEventUsers(
		long[] categoryIds, int[] statuses, int start, int end,
		OrderByComparator obc) {

		return marketingEventUserFinder.findByCI_S(
			categoryIds, statuses, start, end, obc);
	}

	public int getMarketingEventUsersCount(long marketingEventId) {
		return marketingEventUserPersistence.countByMarketingEventId(
			marketingEventId);
	}

	public MarketingEventUser updateMarketingEventUser(
			long userId, long marketingEventUserId, String firstName,
			String lastName, String companyName, long companyLogoFileEntryId,
			Map<Locale, String> jobTitleMap, Map<Locale, String> descriptionMap,
			long imageFileEntryId, String phoneNumber, int status,
			ServiceContext serviceContext)
		throws PortalException {

		User user = userPersistence.findByPrimaryKey(userId);
		Date now = new Date();

		validate(firstName, lastName, companyName, phoneNumber);

		MarketingEventUser marketingEventUser =
			marketingEventUserPersistence.findByPrimaryKey(
				marketingEventUserId);

		marketingEventUser.setModifiedDate(serviceContext.getModifiedDate(now));
		marketingEventUser.setFirstName(firstName);
		marketingEventUser.setLastName(lastName);
		marketingEventUser.setCompanyName(companyName);
		marketingEventUser.setCompanyLogoFileEntryId(companyLogoFileEntryId);
		marketingEventUser.setJobTitleMap(jobTitleMap);
		marketingEventUser.setDescriptionMap(descriptionMap);
		marketingEventUser.setImageFileEntryId(imageFileEntryId);
		marketingEventUser.setPhoneNumber(phoneNumber);
		marketingEventUser.setStatus(status);
		marketingEventUser.setStatusByUserId(user.getUserId());
		marketingEventUser.setStatusByUserName(user.getFullName());
		marketingEventUser.setStatusDate(serviceContext.getModifiedDate(now));

		marketingEventUserPersistence.update(marketingEventUser);

		updateAsset(marketingEventUser, null, serviceContext);

		return marketingEventUser;
	}

	public MarketingEventUser updateStatus(
			long userId, long marketingEventUserId, int status, int priority,
			ServiceContext serviceContext)
		throws PortalException {

		User user = userPersistence.findByPrimaryKey(userId);
		Date now = new Date();

		MarketingEventUser marketingEventUser =
			marketingEventUserPersistence.findByPrimaryKey(
				marketingEventUserId);

		marketingEventUser.setModifiedDate(serviceContext.getModifiedDate(now));
		marketingEventUser.setStatus(status);
		marketingEventUser.setStatusByUserId(user.getUserId());
		marketingEventUser.setStatusByUserName(user.getFullName());
		marketingEventUser.setStatusDate(serviceContext.getModifiedDate(now));

		marketingEventUserPersistence.update(marketingEventUser);

		updateAsset(marketingEventUser, priority, serviceContext);

		return marketingEventUser;
	}

	protected void validate(
			String firstName, String lastName, String companyName,
			String phoneNumber)
		throws PortalException {

		if (Validator.isNull(firstName)) {
			throw new MarketingEventUserFirstNameException();
		}

		if (Validator.isNull(lastName)) {
			throw new MarketingEventUserLastNameException();
		}

		if (Validator.isNull(companyName)) {
			throw new MarketingEventUserCompanyException();
		}

		if (Validator.isNotNull(phoneNumber) &&
			!Validator.isPhoneNumber(phoneNumber)) {

			throw new MarketingEventUserPhoneNumberException();
		}
	}

	private void updateAsset(
			MarketingEventUser marketingEventUser, Integer priority,
			ServiceContext serviceContext)
		throws PortalException {

		assetEntryLocalService.updateEntry(
			serviceContext.getUserId(), serviceContext.getScopeGroupId(),
			marketingEventUser.getCreateDate(),
			marketingEventUser.getModifiedDate(),
			MarketingEventUser.class.getName(),
			marketingEventUser.getMarketingEventUserId(),
			marketingEventUser.getUuid(), 0,
			serviceContext.getAssetCategoryIds(),
			serviceContext.getAssetTagNames(), marketingEventUser.isApproved(),
			null, null, null, ContentTypes.TEXT,
			marketingEventUser.getFullName(),
			marketingEventUser.getDescription(), null, null, null, 0, 0,
			priority, false);
	}

}