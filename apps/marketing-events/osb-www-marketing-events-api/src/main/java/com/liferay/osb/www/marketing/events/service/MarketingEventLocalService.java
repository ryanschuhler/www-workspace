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

import com.liferay.osb.www.marketing.events.model.MarketingEvent;
import com.liferay.osb.www.marketing.events.model.MarketingEventAgendaDisplay;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Provides the local service interface for MarketingEvent. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEventLocalServiceUtil
 * @see com.liferay.osb.www.marketing.events.service.base.MarketingEventLocalServiceBaseImpl
 * @see com.liferay.osb.www.marketing.events.service.impl.MarketingEventLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface MarketingEventLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MarketingEventLocalServiceUtil} to access the marketing event local service. Add custom service methods to {@link com.liferay.osb.www.marketing.events.service.impl.MarketingEventLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public MarketingEvent addMarketingEvent(long userId, int type,
		java.lang.String defaultLanguageId,
		Map<Locale, java.lang.String> titleMap, java.lang.String titleURL,
		java.lang.String hostedBy, java.lang.String hostedByURL,
		Map<Locale, java.lang.String> summaryMap, long siteGroupId,
		long imageFileEntryId, long slidesFileEntryId,
		java.lang.String videoTitle, java.lang.String timeZoneId,
		int startDateMonth, int startDateDay, int startDateYear,
		int startDateHour, int startDateMinute, int endDateMonth,
		int endDateDay, int endDateYear, int endDateHour, int endDateMinute,
		boolean dateTBA, java.lang.String addressStreet1,
		java.lang.String addressStreet2, java.lang.String addressStreet3,
		java.lang.String addressCity, java.lang.String addressZip,
		long addressRegionId, long addressCountryId, double latitude,
		double longitude, int globalRegion, boolean online,
		int registrationType, java.lang.String registrationURL,
		java.lang.String extraSettings, ServiceContext serviceContext)
		throws PortalException;

	/**
	* Adds the marketing event to the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEvent the marketing event
	* @return the marketing event that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public MarketingEvent addMarketingEvent(MarketingEvent marketingEvent);

	/**
	* Creates a new marketing event with the primary key. Does not add the marketing event to the database.
	*
	* @param marketingEventId the primary key for the new marketing event
	* @return the new marketing event
	*/
	public MarketingEvent createMarketingEvent(long marketingEventId);

	/**
	* Deletes the marketing event with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEventId the primary key of the marketing event
	* @return the marketing event that was removed
	* @throws PortalException if a marketing event with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public MarketingEvent deleteMarketingEvent(long marketingEventId)
		throws PortalException;

	/**
	* Deletes the marketing event from the database. Also notifies the appropriate model listeners.
	*
	* @param marketingEvent the marketing event
	* @return the marketing event that was removed
	* @throws PortalException
	*/
	@Indexable(type = IndexableType.DELETE)
	public MarketingEvent deleteMarketingEvent(MarketingEvent marketingEvent)
		throws PortalException;

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	public DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.osb.www.marketing.events.model.impl.MarketingEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.osb.www.marketing.events.model.impl.MarketingEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MarketingEvent fetchMarketingEvent(long marketingEventId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	* Returns the marketing event with the primary key.
	*
	* @param marketingEventId the primary key of the marketing event
	* @return the marketing event
	* @throws PortalException if a marketing event with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MarketingEvent getMarketingEvent(long marketingEventId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MarketingEventAgendaDisplay getMarketingEventAgendaDisplay(
		long groupId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MarketingEvent> getMarketingEvents(int type, Date startDate,
		int start, int end, OrderByComparator obc);

	/**
	* Returns a range of all the marketing events.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.osb.www.marketing.events.model.impl.MarketingEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of marketing events
	* @param end the upper bound of the range of marketing events (not inclusive)
	* @return the range of marketing events
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MarketingEvent> getMarketingEvents(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MarketingEvent> getMarketingEvents(int type, int start,
		int end, OrderByComparator obc);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MarketingEvent> getMarketingEvents(int[] types,
		int[] globalRegions, long[] countryIds, int[] locationTypes,
		boolean pastEvents, java.lang.String userLanguageId,
		java.lang.String orderByCol, java.lang.String orderByType);

	/**
	* Returns the number of marketing events.
	*
	* @return the number of marketing events
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getMarketingEventsCount();

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MarketingEvent getSiteGroupMarketingEvent(long siteGroupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Hits search(long companyId, java.lang.String title,
		java.lang.String summary, int[] types, int[] globalRegions,
		Date startDateGT, Date startDateLT, boolean andSearch, int start,
		int end, Sort sort);

	public MarketingEvent updateMarketingEvent(long marketingEventId, int type,
		java.lang.String defaultLanguageId,
		Map<Locale, java.lang.String> titleMap, java.lang.String titleURL,
		java.lang.String hostedBy, java.lang.String hostedByURL,
		Map<Locale, java.lang.String> summaryMap, long siteGroupId,
		long imageFileEntryId, long slidesFileEntryId,
		java.lang.String videoTitle, java.lang.String timeZoneId,
		int startDateMonth, int startDateDay, int startDateYear,
		int startDateHour, int startDateMinute, int endDateMonth,
		int endDateDay, int endDateYear, int endDateHour, int endDateMinute,
		boolean dateTBA, java.lang.String addressStreet1,
		java.lang.String addressStreet2, java.lang.String addressStreet3,
		java.lang.String addressCity, java.lang.String addressZip,
		long addressRegionId, long addressCountryId, double latitude,
		double longitude, int globalRegion, boolean online,
		int registrationType, java.lang.String registrationURL,
		java.lang.String extraSettings, ServiceContext serviceContext)
		throws PortalException;

	/**
	* Updates the marketing event in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param marketingEvent the marketing event
	* @return the marketing event that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public MarketingEvent updateMarketingEvent(MarketingEvent marketingEvent);
}