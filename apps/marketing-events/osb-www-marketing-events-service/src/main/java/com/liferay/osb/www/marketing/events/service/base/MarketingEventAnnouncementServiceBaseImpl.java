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

package com.liferay.osb.www.marketing.events.service.base;

import com.liferay.osb.www.marketing.events.model.MarketingEventAnnouncement;
import com.liferay.osb.www.marketing.events.service.MarketingEventAnnouncementService;
import com.liferay.osb.www.marketing.events.service.persistence.MarketingEventAnnouncementPersistence;
import com.liferay.osb.www.marketing.events.service.persistence.MarketingEventPersistence;
import com.liferay.osb.www.marketing.events.service.persistence.MarketingEventSessionFinder;
import com.liferay.osb.www.marketing.events.service.persistence.MarketingEventSessionPersistence;
import com.liferay.osb.www.marketing.events.service.persistence.MarketingEventSessionRoomPersistence;
import com.liferay.osb.www.marketing.events.service.persistence.MarketingEventSponsorLevelPersistence;
import com.liferay.osb.www.marketing.events.service.persistence.MarketingEventSponsorPersistence;
import com.liferay.osb.www.marketing.events.service.persistence.MarketingEventUserFinder;
import com.liferay.osb.www.marketing.events.service.persistence.MarketingEventUserPersistence;
import com.liferay.osb.www.marketing.events.service.persistence.SocialLinkPersistence;
import com.liferay.osb.www.marketing.events.service.persistence.SocialLinkTypePersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the marketing event announcement remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.osb.www.marketing.events.service.impl.MarketingEventAnnouncementServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.osb.www.marketing.events.service.impl.MarketingEventAnnouncementServiceImpl
 * @see com.liferay.osb.www.marketing.events.service.MarketingEventAnnouncementServiceUtil
 * @generated
 */
public abstract class MarketingEventAnnouncementServiceBaseImpl
	extends BaseServiceImpl implements MarketingEventAnnouncementService,
		IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.osb.www.marketing.events.service.MarketingEventAnnouncementServiceUtil} to access the marketing event announcement remote service.
	 */

	/**
	 * Returns the marketing event local service.
	 *
	 * @return the marketing event local service
	 */
	public com.liferay.osb.www.marketing.events.service.MarketingEventLocalService getMarketingEventLocalService() {
		return marketingEventLocalService;
	}

	/**
	 * Sets the marketing event local service.
	 *
	 * @param marketingEventLocalService the marketing event local service
	 */
	public void setMarketingEventLocalService(
		com.liferay.osb.www.marketing.events.service.MarketingEventLocalService marketingEventLocalService) {
		this.marketingEventLocalService = marketingEventLocalService;
	}

	/**
	 * Returns the marketing event remote service.
	 *
	 * @return the marketing event remote service
	 */
	public com.liferay.osb.www.marketing.events.service.MarketingEventService getMarketingEventService() {
		return marketingEventService;
	}

	/**
	 * Sets the marketing event remote service.
	 *
	 * @param marketingEventService the marketing event remote service
	 */
	public void setMarketingEventService(
		com.liferay.osb.www.marketing.events.service.MarketingEventService marketingEventService) {
		this.marketingEventService = marketingEventService;
	}

	/**
	 * Returns the marketing event persistence.
	 *
	 * @return the marketing event persistence
	 */
	public MarketingEventPersistence getMarketingEventPersistence() {
		return marketingEventPersistence;
	}

	/**
	 * Sets the marketing event persistence.
	 *
	 * @param marketingEventPersistence the marketing event persistence
	 */
	public void setMarketingEventPersistence(
		MarketingEventPersistence marketingEventPersistence) {
		this.marketingEventPersistence = marketingEventPersistence;
	}

	/**
	 * Returns the marketing event announcement local service.
	 *
	 * @return the marketing event announcement local service
	 */
	public com.liferay.osb.www.marketing.events.service.MarketingEventAnnouncementLocalService getMarketingEventAnnouncementLocalService() {
		return marketingEventAnnouncementLocalService;
	}

	/**
	 * Sets the marketing event announcement local service.
	 *
	 * @param marketingEventAnnouncementLocalService the marketing event announcement local service
	 */
	public void setMarketingEventAnnouncementLocalService(
		com.liferay.osb.www.marketing.events.service.MarketingEventAnnouncementLocalService marketingEventAnnouncementLocalService) {
		this.marketingEventAnnouncementLocalService = marketingEventAnnouncementLocalService;
	}

	/**
	 * Returns the marketing event announcement remote service.
	 *
	 * @return the marketing event announcement remote service
	 */
	public MarketingEventAnnouncementService getMarketingEventAnnouncementService() {
		return marketingEventAnnouncementService;
	}

	/**
	 * Sets the marketing event announcement remote service.
	 *
	 * @param marketingEventAnnouncementService the marketing event announcement remote service
	 */
	public void setMarketingEventAnnouncementService(
		MarketingEventAnnouncementService marketingEventAnnouncementService) {
		this.marketingEventAnnouncementService = marketingEventAnnouncementService;
	}

	/**
	 * Returns the marketing event announcement persistence.
	 *
	 * @return the marketing event announcement persistence
	 */
	public MarketingEventAnnouncementPersistence getMarketingEventAnnouncementPersistence() {
		return marketingEventAnnouncementPersistence;
	}

	/**
	 * Sets the marketing event announcement persistence.
	 *
	 * @param marketingEventAnnouncementPersistence the marketing event announcement persistence
	 */
	public void setMarketingEventAnnouncementPersistence(
		MarketingEventAnnouncementPersistence marketingEventAnnouncementPersistence) {
		this.marketingEventAnnouncementPersistence = marketingEventAnnouncementPersistence;
	}

	/**
	 * Returns the marketing event session local service.
	 *
	 * @return the marketing event session local service
	 */
	public com.liferay.osb.www.marketing.events.service.MarketingEventSessionLocalService getMarketingEventSessionLocalService() {
		return marketingEventSessionLocalService;
	}

	/**
	 * Sets the marketing event session local service.
	 *
	 * @param marketingEventSessionLocalService the marketing event session local service
	 */
	public void setMarketingEventSessionLocalService(
		com.liferay.osb.www.marketing.events.service.MarketingEventSessionLocalService marketingEventSessionLocalService) {
		this.marketingEventSessionLocalService = marketingEventSessionLocalService;
	}

	/**
	 * Returns the marketing event session remote service.
	 *
	 * @return the marketing event session remote service
	 */
	public com.liferay.osb.www.marketing.events.service.MarketingEventSessionService getMarketingEventSessionService() {
		return marketingEventSessionService;
	}

	/**
	 * Sets the marketing event session remote service.
	 *
	 * @param marketingEventSessionService the marketing event session remote service
	 */
	public void setMarketingEventSessionService(
		com.liferay.osb.www.marketing.events.service.MarketingEventSessionService marketingEventSessionService) {
		this.marketingEventSessionService = marketingEventSessionService;
	}

	/**
	 * Returns the marketing event session persistence.
	 *
	 * @return the marketing event session persistence
	 */
	public MarketingEventSessionPersistence getMarketingEventSessionPersistence() {
		return marketingEventSessionPersistence;
	}

	/**
	 * Sets the marketing event session persistence.
	 *
	 * @param marketingEventSessionPersistence the marketing event session persistence
	 */
	public void setMarketingEventSessionPersistence(
		MarketingEventSessionPersistence marketingEventSessionPersistence) {
		this.marketingEventSessionPersistence = marketingEventSessionPersistence;
	}

	/**
	 * Returns the marketing event session finder.
	 *
	 * @return the marketing event session finder
	 */
	public MarketingEventSessionFinder getMarketingEventSessionFinder() {
		return marketingEventSessionFinder;
	}

	/**
	 * Sets the marketing event session finder.
	 *
	 * @param marketingEventSessionFinder the marketing event session finder
	 */
	public void setMarketingEventSessionFinder(
		MarketingEventSessionFinder marketingEventSessionFinder) {
		this.marketingEventSessionFinder = marketingEventSessionFinder;
	}

	/**
	 * Returns the marketing event session room local service.
	 *
	 * @return the marketing event session room local service
	 */
	public com.liferay.osb.www.marketing.events.service.MarketingEventSessionRoomLocalService getMarketingEventSessionRoomLocalService() {
		return marketingEventSessionRoomLocalService;
	}

	/**
	 * Sets the marketing event session room local service.
	 *
	 * @param marketingEventSessionRoomLocalService the marketing event session room local service
	 */
	public void setMarketingEventSessionRoomLocalService(
		com.liferay.osb.www.marketing.events.service.MarketingEventSessionRoomLocalService marketingEventSessionRoomLocalService) {
		this.marketingEventSessionRoomLocalService = marketingEventSessionRoomLocalService;
	}

	/**
	 * Returns the marketing event session room remote service.
	 *
	 * @return the marketing event session room remote service
	 */
	public com.liferay.osb.www.marketing.events.service.MarketingEventSessionRoomService getMarketingEventSessionRoomService() {
		return marketingEventSessionRoomService;
	}

	/**
	 * Sets the marketing event session room remote service.
	 *
	 * @param marketingEventSessionRoomService the marketing event session room remote service
	 */
	public void setMarketingEventSessionRoomService(
		com.liferay.osb.www.marketing.events.service.MarketingEventSessionRoomService marketingEventSessionRoomService) {
		this.marketingEventSessionRoomService = marketingEventSessionRoomService;
	}

	/**
	 * Returns the marketing event session room persistence.
	 *
	 * @return the marketing event session room persistence
	 */
	public MarketingEventSessionRoomPersistence getMarketingEventSessionRoomPersistence() {
		return marketingEventSessionRoomPersistence;
	}

	/**
	 * Sets the marketing event session room persistence.
	 *
	 * @param marketingEventSessionRoomPersistence the marketing event session room persistence
	 */
	public void setMarketingEventSessionRoomPersistence(
		MarketingEventSessionRoomPersistence marketingEventSessionRoomPersistence) {
		this.marketingEventSessionRoomPersistence = marketingEventSessionRoomPersistence;
	}

	/**
	 * Returns the marketing event sponsor local service.
	 *
	 * @return the marketing event sponsor local service
	 */
	public com.liferay.osb.www.marketing.events.service.MarketingEventSponsorLocalService getMarketingEventSponsorLocalService() {
		return marketingEventSponsorLocalService;
	}

	/**
	 * Sets the marketing event sponsor local service.
	 *
	 * @param marketingEventSponsorLocalService the marketing event sponsor local service
	 */
	public void setMarketingEventSponsorLocalService(
		com.liferay.osb.www.marketing.events.service.MarketingEventSponsorLocalService marketingEventSponsorLocalService) {
		this.marketingEventSponsorLocalService = marketingEventSponsorLocalService;
	}

	/**
	 * Returns the marketing event sponsor remote service.
	 *
	 * @return the marketing event sponsor remote service
	 */
	public com.liferay.osb.www.marketing.events.service.MarketingEventSponsorService getMarketingEventSponsorService() {
		return marketingEventSponsorService;
	}

	/**
	 * Sets the marketing event sponsor remote service.
	 *
	 * @param marketingEventSponsorService the marketing event sponsor remote service
	 */
	public void setMarketingEventSponsorService(
		com.liferay.osb.www.marketing.events.service.MarketingEventSponsorService marketingEventSponsorService) {
		this.marketingEventSponsorService = marketingEventSponsorService;
	}

	/**
	 * Returns the marketing event sponsor persistence.
	 *
	 * @return the marketing event sponsor persistence
	 */
	public MarketingEventSponsorPersistence getMarketingEventSponsorPersistence() {
		return marketingEventSponsorPersistence;
	}

	/**
	 * Sets the marketing event sponsor persistence.
	 *
	 * @param marketingEventSponsorPersistence the marketing event sponsor persistence
	 */
	public void setMarketingEventSponsorPersistence(
		MarketingEventSponsorPersistence marketingEventSponsorPersistence) {
		this.marketingEventSponsorPersistence = marketingEventSponsorPersistence;
	}

	/**
	 * Returns the marketing event sponsor level local service.
	 *
	 * @return the marketing event sponsor level local service
	 */
	public com.liferay.osb.www.marketing.events.service.MarketingEventSponsorLevelLocalService getMarketingEventSponsorLevelLocalService() {
		return marketingEventSponsorLevelLocalService;
	}

	/**
	 * Sets the marketing event sponsor level local service.
	 *
	 * @param marketingEventSponsorLevelLocalService the marketing event sponsor level local service
	 */
	public void setMarketingEventSponsorLevelLocalService(
		com.liferay.osb.www.marketing.events.service.MarketingEventSponsorLevelLocalService marketingEventSponsorLevelLocalService) {
		this.marketingEventSponsorLevelLocalService = marketingEventSponsorLevelLocalService;
	}

	/**
	 * Returns the marketing event sponsor level remote service.
	 *
	 * @return the marketing event sponsor level remote service
	 */
	public com.liferay.osb.www.marketing.events.service.MarketingEventSponsorLevelService getMarketingEventSponsorLevelService() {
		return marketingEventSponsorLevelService;
	}

	/**
	 * Sets the marketing event sponsor level remote service.
	 *
	 * @param marketingEventSponsorLevelService the marketing event sponsor level remote service
	 */
	public void setMarketingEventSponsorLevelService(
		com.liferay.osb.www.marketing.events.service.MarketingEventSponsorLevelService marketingEventSponsorLevelService) {
		this.marketingEventSponsorLevelService = marketingEventSponsorLevelService;
	}

	/**
	 * Returns the marketing event sponsor level persistence.
	 *
	 * @return the marketing event sponsor level persistence
	 */
	public MarketingEventSponsorLevelPersistence getMarketingEventSponsorLevelPersistence() {
		return marketingEventSponsorLevelPersistence;
	}

	/**
	 * Sets the marketing event sponsor level persistence.
	 *
	 * @param marketingEventSponsorLevelPersistence the marketing event sponsor level persistence
	 */
	public void setMarketingEventSponsorLevelPersistence(
		MarketingEventSponsorLevelPersistence marketingEventSponsorLevelPersistence) {
		this.marketingEventSponsorLevelPersistence = marketingEventSponsorLevelPersistence;
	}

	/**
	 * Returns the marketing event user local service.
	 *
	 * @return the marketing event user local service
	 */
	public com.liferay.osb.www.marketing.events.service.MarketingEventUserLocalService getMarketingEventUserLocalService() {
		return marketingEventUserLocalService;
	}

	/**
	 * Sets the marketing event user local service.
	 *
	 * @param marketingEventUserLocalService the marketing event user local service
	 */
	public void setMarketingEventUserLocalService(
		com.liferay.osb.www.marketing.events.service.MarketingEventUserLocalService marketingEventUserLocalService) {
		this.marketingEventUserLocalService = marketingEventUserLocalService;
	}

	/**
	 * Returns the marketing event user remote service.
	 *
	 * @return the marketing event user remote service
	 */
	public com.liferay.osb.www.marketing.events.service.MarketingEventUserService getMarketingEventUserService() {
		return marketingEventUserService;
	}

	/**
	 * Sets the marketing event user remote service.
	 *
	 * @param marketingEventUserService the marketing event user remote service
	 */
	public void setMarketingEventUserService(
		com.liferay.osb.www.marketing.events.service.MarketingEventUserService marketingEventUserService) {
		this.marketingEventUserService = marketingEventUserService;
	}

	/**
	 * Returns the marketing event user persistence.
	 *
	 * @return the marketing event user persistence
	 */
	public MarketingEventUserPersistence getMarketingEventUserPersistence() {
		return marketingEventUserPersistence;
	}

	/**
	 * Sets the marketing event user persistence.
	 *
	 * @param marketingEventUserPersistence the marketing event user persistence
	 */
	public void setMarketingEventUserPersistence(
		MarketingEventUserPersistence marketingEventUserPersistence) {
		this.marketingEventUserPersistence = marketingEventUserPersistence;
	}

	/**
	 * Returns the marketing event user finder.
	 *
	 * @return the marketing event user finder
	 */
	public MarketingEventUserFinder getMarketingEventUserFinder() {
		return marketingEventUserFinder;
	}

	/**
	 * Sets the marketing event user finder.
	 *
	 * @param marketingEventUserFinder the marketing event user finder
	 */
	public void setMarketingEventUserFinder(
		MarketingEventUserFinder marketingEventUserFinder) {
		this.marketingEventUserFinder = marketingEventUserFinder;
	}

	/**
	 * Returns the social link local service.
	 *
	 * @return the social link local service
	 */
	public com.liferay.osb.www.marketing.events.service.SocialLinkLocalService getSocialLinkLocalService() {
		return socialLinkLocalService;
	}

	/**
	 * Sets the social link local service.
	 *
	 * @param socialLinkLocalService the social link local service
	 */
	public void setSocialLinkLocalService(
		com.liferay.osb.www.marketing.events.service.SocialLinkLocalService socialLinkLocalService) {
		this.socialLinkLocalService = socialLinkLocalService;
	}

	/**
	 * Returns the social link remote service.
	 *
	 * @return the social link remote service
	 */
	public com.liferay.osb.www.marketing.events.service.SocialLinkService getSocialLinkService() {
		return socialLinkService;
	}

	/**
	 * Sets the social link remote service.
	 *
	 * @param socialLinkService the social link remote service
	 */
	public void setSocialLinkService(
		com.liferay.osb.www.marketing.events.service.SocialLinkService socialLinkService) {
		this.socialLinkService = socialLinkService;
	}

	/**
	 * Returns the social link persistence.
	 *
	 * @return the social link persistence
	 */
	public SocialLinkPersistence getSocialLinkPersistence() {
		return socialLinkPersistence;
	}

	/**
	 * Sets the social link persistence.
	 *
	 * @param socialLinkPersistence the social link persistence
	 */
	public void setSocialLinkPersistence(
		SocialLinkPersistence socialLinkPersistence) {
		this.socialLinkPersistence = socialLinkPersistence;
	}

	/**
	 * Returns the social link type local service.
	 *
	 * @return the social link type local service
	 */
	public com.liferay.osb.www.marketing.events.service.SocialLinkTypeLocalService getSocialLinkTypeLocalService() {
		return socialLinkTypeLocalService;
	}

	/**
	 * Sets the social link type local service.
	 *
	 * @param socialLinkTypeLocalService the social link type local service
	 */
	public void setSocialLinkTypeLocalService(
		com.liferay.osb.www.marketing.events.service.SocialLinkTypeLocalService socialLinkTypeLocalService) {
		this.socialLinkTypeLocalService = socialLinkTypeLocalService;
	}

	/**
	 * Returns the social link type remote service.
	 *
	 * @return the social link type remote service
	 */
	public com.liferay.osb.www.marketing.events.service.SocialLinkTypeService getSocialLinkTypeService() {
		return socialLinkTypeService;
	}

	/**
	 * Sets the social link type remote service.
	 *
	 * @param socialLinkTypeService the social link type remote service
	 */
	public void setSocialLinkTypeService(
		com.liferay.osb.www.marketing.events.service.SocialLinkTypeService socialLinkTypeService) {
		this.socialLinkTypeService = socialLinkTypeService;
	}

	/**
	 * Returns the social link type persistence.
	 *
	 * @return the social link type persistence
	 */
	public SocialLinkTypePersistence getSocialLinkTypePersistence() {
		return socialLinkTypePersistence;
	}

	/**
	 * Sets the social link type persistence.
	 *
	 * @param socialLinkTypePersistence the social link type persistence
	 */
	public void setSocialLinkTypePersistence(
		SocialLinkTypePersistence socialLinkTypePersistence) {
		this.socialLinkTypePersistence = socialLinkTypePersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name remote service.
	 *
	 * @return the class name remote service
	 */
	public com.liferay.portal.kernel.service.ClassNameService getClassNameService() {
		return classNameService;
	}

	/**
	 * Sets the class name remote service.
	 *
	 * @param classNameService the class name remote service
	 */
	public void setClassNameService(
		com.liferay.portal.kernel.service.ClassNameService classNameService) {
		this.classNameService = classNameService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.kernel.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.kernel.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
	}

	public void destroy() {
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return MarketingEventAnnouncementService.class.getName();
	}

	protected Class<?> getModelClass() {
		return MarketingEventAnnouncement.class;
	}

	protected String getModelClassName() {
		return MarketingEventAnnouncement.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = marketingEventAnnouncementPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.liferay.osb.www.marketing.events.service.MarketingEventLocalService.class)
	protected com.liferay.osb.www.marketing.events.service.MarketingEventLocalService marketingEventLocalService;
	@BeanReference(type = com.liferay.osb.www.marketing.events.service.MarketingEventService.class)
	protected com.liferay.osb.www.marketing.events.service.MarketingEventService marketingEventService;
	@BeanReference(type = MarketingEventPersistence.class)
	protected MarketingEventPersistence marketingEventPersistence;
	@BeanReference(type = com.liferay.osb.www.marketing.events.service.MarketingEventAnnouncementLocalService.class)
	protected com.liferay.osb.www.marketing.events.service.MarketingEventAnnouncementLocalService marketingEventAnnouncementLocalService;
	@BeanReference(type = MarketingEventAnnouncementService.class)
	protected MarketingEventAnnouncementService marketingEventAnnouncementService;
	@BeanReference(type = MarketingEventAnnouncementPersistence.class)
	protected MarketingEventAnnouncementPersistence marketingEventAnnouncementPersistence;
	@BeanReference(type = com.liferay.osb.www.marketing.events.service.MarketingEventSessionLocalService.class)
	protected com.liferay.osb.www.marketing.events.service.MarketingEventSessionLocalService marketingEventSessionLocalService;
	@BeanReference(type = com.liferay.osb.www.marketing.events.service.MarketingEventSessionService.class)
	protected com.liferay.osb.www.marketing.events.service.MarketingEventSessionService marketingEventSessionService;
	@BeanReference(type = MarketingEventSessionPersistence.class)
	protected MarketingEventSessionPersistence marketingEventSessionPersistence;
	@BeanReference(type = MarketingEventSessionFinder.class)
	protected MarketingEventSessionFinder marketingEventSessionFinder;
	@BeanReference(type = com.liferay.osb.www.marketing.events.service.MarketingEventSessionRoomLocalService.class)
	protected com.liferay.osb.www.marketing.events.service.MarketingEventSessionRoomLocalService marketingEventSessionRoomLocalService;
	@BeanReference(type = com.liferay.osb.www.marketing.events.service.MarketingEventSessionRoomService.class)
	protected com.liferay.osb.www.marketing.events.service.MarketingEventSessionRoomService marketingEventSessionRoomService;
	@BeanReference(type = MarketingEventSessionRoomPersistence.class)
	protected MarketingEventSessionRoomPersistence marketingEventSessionRoomPersistence;
	@BeanReference(type = com.liferay.osb.www.marketing.events.service.MarketingEventSponsorLocalService.class)
	protected com.liferay.osb.www.marketing.events.service.MarketingEventSponsorLocalService marketingEventSponsorLocalService;
	@BeanReference(type = com.liferay.osb.www.marketing.events.service.MarketingEventSponsorService.class)
	protected com.liferay.osb.www.marketing.events.service.MarketingEventSponsorService marketingEventSponsorService;
	@BeanReference(type = MarketingEventSponsorPersistence.class)
	protected MarketingEventSponsorPersistence marketingEventSponsorPersistence;
	@BeanReference(type = com.liferay.osb.www.marketing.events.service.MarketingEventSponsorLevelLocalService.class)
	protected com.liferay.osb.www.marketing.events.service.MarketingEventSponsorLevelLocalService marketingEventSponsorLevelLocalService;
	@BeanReference(type = com.liferay.osb.www.marketing.events.service.MarketingEventSponsorLevelService.class)
	protected com.liferay.osb.www.marketing.events.service.MarketingEventSponsorLevelService marketingEventSponsorLevelService;
	@BeanReference(type = MarketingEventSponsorLevelPersistence.class)
	protected MarketingEventSponsorLevelPersistence marketingEventSponsorLevelPersistence;
	@BeanReference(type = com.liferay.osb.www.marketing.events.service.MarketingEventUserLocalService.class)
	protected com.liferay.osb.www.marketing.events.service.MarketingEventUserLocalService marketingEventUserLocalService;
	@BeanReference(type = com.liferay.osb.www.marketing.events.service.MarketingEventUserService.class)
	protected com.liferay.osb.www.marketing.events.service.MarketingEventUserService marketingEventUserService;
	@BeanReference(type = MarketingEventUserPersistence.class)
	protected MarketingEventUserPersistence marketingEventUserPersistence;
	@BeanReference(type = MarketingEventUserFinder.class)
	protected MarketingEventUserFinder marketingEventUserFinder;
	@BeanReference(type = com.liferay.osb.www.marketing.events.service.SocialLinkLocalService.class)
	protected com.liferay.osb.www.marketing.events.service.SocialLinkLocalService socialLinkLocalService;
	@BeanReference(type = com.liferay.osb.www.marketing.events.service.SocialLinkService.class)
	protected com.liferay.osb.www.marketing.events.service.SocialLinkService socialLinkService;
	@BeanReference(type = SocialLinkPersistence.class)
	protected SocialLinkPersistence socialLinkPersistence;
	@BeanReference(type = com.liferay.osb.www.marketing.events.service.SocialLinkTypeLocalService.class)
	protected com.liferay.osb.www.marketing.events.service.SocialLinkTypeLocalService socialLinkTypeLocalService;
	@BeanReference(type = com.liferay.osb.www.marketing.events.service.SocialLinkTypeService.class)
	protected com.liferay.osb.www.marketing.events.service.SocialLinkTypeService socialLinkTypeService;
	@BeanReference(type = SocialLinkTypePersistence.class)
	protected SocialLinkTypePersistence socialLinkTypePersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameService.class)
	protected com.liferay.portal.kernel.service.ClassNameService classNameService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserService.class)
	protected com.liferay.portal.kernel.service.UserService userService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
}