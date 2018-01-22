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

package com.liferay.osb.www.marketing.events.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventException;
import com.liferay.osb.www.marketing.events.model.MarketingEvent;
import com.liferay.osb.www.marketing.events.model.impl.MarketingEventImpl;
import com.liferay.osb.www.marketing.events.model.impl.MarketingEventModelImpl;
import com.liferay.osb.www.marketing.events.service.persistence.MarketingEventPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReflectionUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.sql.Timestamp;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the marketing event service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEventPersistence
 * @see com.liferay.osb.www.marketing.events.service.persistence.MarketingEventUtil
 * @generated
 */
@ProviderType
public class MarketingEventPersistenceImpl extends BasePersistenceImpl<MarketingEvent>
	implements MarketingEventPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MarketingEventUtil} to access the marketing event persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MarketingEventImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MarketingEventModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventModelImpl.FINDER_CACHE_ENABLED,
			MarketingEventImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MarketingEventModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventModelImpl.FINDER_CACHE_ENABLED,
			MarketingEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MarketingEventModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPE = new FinderPath(MarketingEventModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventModelImpl.FINDER_CACHE_ENABLED,
			MarketingEventImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByType",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE = new FinderPath(MarketingEventModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventModelImpl.FINDER_CACHE_ENABLED,
			MarketingEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByType",
			new String[] { Integer.class.getName() },
			MarketingEventModelImpl.TYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TYPE = new FinderPath(MarketingEventModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByType",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the marketing events where type = &#63;.
	 *
	 * @param type the type
	 * @return the matching marketing events
	 */
	@Override
	public List<MarketingEvent> findByType(int type) {
		return findByType(type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the marketing events where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of marketing events
	 * @param end the upper bound of the range of marketing events (not inclusive)
	 * @return the range of matching marketing events
	 */
	@Override
	public List<MarketingEvent> findByType(int type, int start, int end) {
		return findByType(type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the marketing events where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of marketing events
	 * @param end the upper bound of the range of marketing events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching marketing events
	 */
	@Override
	public List<MarketingEvent> findByType(int type, int start, int end,
		OrderByComparator<MarketingEvent> orderByComparator) {
		return findByType(type, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the marketing events where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of marketing events
	 * @param end the upper bound of the range of marketing events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching marketing events
	 */
	@Override
	public List<MarketingEvent> findByType(int type, int start, int end,
		OrderByComparator<MarketingEvent> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE;
			finderArgs = new Object[] { type };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPE;
			finderArgs = new Object[] { type, start, end, orderByComparator };
		}

		List<MarketingEvent> list = null;

		if (retrieveFromCache) {
			list = (List<MarketingEvent>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MarketingEvent marketingEvent : list) {
					if ((type != marketingEvent.getType())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_MARKETINGEVENT_WHERE);

			query.append(_FINDER_COLUMN_TYPE_TYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MarketingEventModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(type);

				if (!pagination) {
					list = (List<MarketingEvent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MarketingEvent>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first marketing event in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching marketing event
	 * @throws NoSuchMarketingEventException if a matching marketing event could not be found
	 */
	@Override
	public MarketingEvent findByType_First(int type,
		OrderByComparator<MarketingEvent> orderByComparator)
		throws NoSuchMarketingEventException {
		MarketingEvent marketingEvent = fetchByType_First(type,
				orderByComparator);

		if (marketingEvent != null) {
			return marketingEvent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("type=");
		msg.append(type);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMarketingEventException(msg.toString());
	}

	/**
	 * Returns the first marketing event in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching marketing event, or <code>null</code> if a matching marketing event could not be found
	 */
	@Override
	public MarketingEvent fetchByType_First(int type,
		OrderByComparator<MarketingEvent> orderByComparator) {
		List<MarketingEvent> list = findByType(type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last marketing event in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching marketing event
	 * @throws NoSuchMarketingEventException if a matching marketing event could not be found
	 */
	@Override
	public MarketingEvent findByType_Last(int type,
		OrderByComparator<MarketingEvent> orderByComparator)
		throws NoSuchMarketingEventException {
		MarketingEvent marketingEvent = fetchByType_Last(type, orderByComparator);

		if (marketingEvent != null) {
			return marketingEvent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("type=");
		msg.append(type);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMarketingEventException(msg.toString());
	}

	/**
	 * Returns the last marketing event in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching marketing event, or <code>null</code> if a matching marketing event could not be found
	 */
	@Override
	public MarketingEvent fetchByType_Last(int type,
		OrderByComparator<MarketingEvent> orderByComparator) {
		int count = countByType(type);

		if (count == 0) {
			return null;
		}

		List<MarketingEvent> list = findByType(type, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the marketing events before and after the current marketing event in the ordered set where type = &#63;.
	 *
	 * @param marketingEventId the primary key of the current marketing event
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next marketing event
	 * @throws NoSuchMarketingEventException if a marketing event with the primary key could not be found
	 */
	@Override
	public MarketingEvent[] findByType_PrevAndNext(long marketingEventId,
		int type, OrderByComparator<MarketingEvent> orderByComparator)
		throws NoSuchMarketingEventException {
		MarketingEvent marketingEvent = findByPrimaryKey(marketingEventId);

		Session session = null;

		try {
			session = openSession();

			MarketingEvent[] array = new MarketingEventImpl[3];

			array[0] = getByType_PrevAndNext(session, marketingEvent, type,
					orderByComparator, true);

			array[1] = marketingEvent;

			array[2] = getByType_PrevAndNext(session, marketingEvent, type,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MarketingEvent getByType_PrevAndNext(Session session,
		MarketingEvent marketingEvent, int type,
		OrderByComparator<MarketingEvent> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MARKETINGEVENT_WHERE);

		query.append(_FINDER_COLUMN_TYPE_TYPE_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(MarketingEventModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(type);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(marketingEvent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MarketingEvent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the marketing events where type = &#63; from the database.
	 *
	 * @param type the type
	 */
	@Override
	public void removeByType(int type) {
		for (MarketingEvent marketingEvent : findByType(type,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(marketingEvent);
		}
	}

	/**
	 * Returns the number of marketing events where type = &#63;.
	 *
	 * @param type the type
	 * @return the number of matching marketing events
	 */
	@Override
	public int countByType(int type) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TYPE;

		Object[] finderArgs = new Object[] { type };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MARKETINGEVENT_WHERE);

			query.append(_FINDER_COLUMN_TYPE_TYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(type);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TYPE_TYPE_2 = "marketingEvent.type = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_SITEGROUPID = new FinderPath(MarketingEventModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventModelImpl.FINDER_CACHE_ENABLED,
			MarketingEventImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBySiteGroupId", new String[] { Long.class.getName() },
			MarketingEventModelImpl.SITEGROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SITEGROUPID = new FinderPath(MarketingEventModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySiteGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the marketing event where siteGroupId = &#63; or throws a {@link NoSuchMarketingEventException} if it could not be found.
	 *
	 * @param siteGroupId the site group ID
	 * @return the matching marketing event
	 * @throws NoSuchMarketingEventException if a matching marketing event could not be found
	 */
	@Override
	public MarketingEvent findBySiteGroupId(long siteGroupId)
		throws NoSuchMarketingEventException {
		MarketingEvent marketingEvent = fetchBySiteGroupId(siteGroupId);

		if (marketingEvent == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("siteGroupId=");
			msg.append(siteGroupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchMarketingEventException(msg.toString());
		}

		return marketingEvent;
	}

	/**
	 * Returns the marketing event where siteGroupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param siteGroupId the site group ID
	 * @return the matching marketing event, or <code>null</code> if a matching marketing event could not be found
	 */
	@Override
	public MarketingEvent fetchBySiteGroupId(long siteGroupId) {
		return fetchBySiteGroupId(siteGroupId, true);
	}

	/**
	 * Returns the marketing event where siteGroupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param siteGroupId the site group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching marketing event, or <code>null</code> if a matching marketing event could not be found
	 */
	@Override
	public MarketingEvent fetchBySiteGroupId(long siteGroupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { siteGroupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_SITEGROUPID,
					finderArgs, this);
		}

		if (result instanceof MarketingEvent) {
			MarketingEvent marketingEvent = (MarketingEvent)result;

			if ((siteGroupId != marketingEvent.getSiteGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_MARKETINGEVENT_WHERE);

			query.append(_FINDER_COLUMN_SITEGROUPID_SITEGROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(siteGroupId);

				List<MarketingEvent> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_SITEGROUPID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"MarketingEventPersistenceImpl.fetchBySiteGroupId(long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					MarketingEvent marketingEvent = list.get(0);

					result = marketingEvent;

					cacheResult(marketingEvent);

					if ((marketingEvent.getSiteGroupId() != siteGroupId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_SITEGROUPID,
							finderArgs, marketingEvent);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_SITEGROUPID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (MarketingEvent)result;
		}
	}

	/**
	 * Removes the marketing event where siteGroupId = &#63; from the database.
	 *
	 * @param siteGroupId the site group ID
	 * @return the marketing event that was removed
	 */
	@Override
	public MarketingEvent removeBySiteGroupId(long siteGroupId)
		throws NoSuchMarketingEventException {
		MarketingEvent marketingEvent = findBySiteGroupId(siteGroupId);

		return remove(marketingEvent);
	}

	/**
	 * Returns the number of marketing events where siteGroupId = &#63;.
	 *
	 * @param siteGroupId the site group ID
	 * @return the number of matching marketing events
	 */
	@Override
	public int countBySiteGroupId(long siteGroupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SITEGROUPID;

		Object[] finderArgs = new Object[] { siteGroupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MARKETINGEVENT_WHERE);

			query.append(_FINDER_COLUMN_SITEGROUPID_SITEGROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(siteGroupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_SITEGROUPID_SITEGROUPID_2 = "marketingEvent.siteGroupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GLOBALREGION =
		new FinderPath(MarketingEventModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventModelImpl.FINDER_CACHE_ENABLED,
			MarketingEventImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGlobalRegion",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GLOBALREGION =
		new FinderPath(MarketingEventModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventModelImpl.FINDER_CACHE_ENABLED,
			MarketingEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGlobalRegion",
			new String[] { Integer.class.getName() },
			MarketingEventModelImpl.GLOBALREGION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GLOBALREGION = new FinderPath(MarketingEventModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGlobalRegion",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the marketing events where globalRegion = &#63;.
	 *
	 * @param globalRegion the global region
	 * @return the matching marketing events
	 */
	@Override
	public List<MarketingEvent> findByGlobalRegion(int globalRegion) {
		return findByGlobalRegion(globalRegion, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the marketing events where globalRegion = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param globalRegion the global region
	 * @param start the lower bound of the range of marketing events
	 * @param end the upper bound of the range of marketing events (not inclusive)
	 * @return the range of matching marketing events
	 */
	@Override
	public List<MarketingEvent> findByGlobalRegion(int globalRegion, int start,
		int end) {
		return findByGlobalRegion(globalRegion, start, end, null);
	}

	/**
	 * Returns an ordered range of all the marketing events where globalRegion = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param globalRegion the global region
	 * @param start the lower bound of the range of marketing events
	 * @param end the upper bound of the range of marketing events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching marketing events
	 */
	@Override
	public List<MarketingEvent> findByGlobalRegion(int globalRegion, int start,
		int end, OrderByComparator<MarketingEvent> orderByComparator) {
		return findByGlobalRegion(globalRegion, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the marketing events where globalRegion = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param globalRegion the global region
	 * @param start the lower bound of the range of marketing events
	 * @param end the upper bound of the range of marketing events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching marketing events
	 */
	@Override
	public List<MarketingEvent> findByGlobalRegion(int globalRegion, int start,
		int end, OrderByComparator<MarketingEvent> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GLOBALREGION;
			finderArgs = new Object[] { globalRegion };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GLOBALREGION;
			finderArgs = new Object[] {
					globalRegion,
					
					start, end, orderByComparator
				};
		}

		List<MarketingEvent> list = null;

		if (retrieveFromCache) {
			list = (List<MarketingEvent>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MarketingEvent marketingEvent : list) {
					if ((globalRegion != marketingEvent.getGlobalRegion())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_MARKETINGEVENT_WHERE);

			query.append(_FINDER_COLUMN_GLOBALREGION_GLOBALREGION_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MarketingEventModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(globalRegion);

				if (!pagination) {
					list = (List<MarketingEvent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MarketingEvent>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first marketing event in the ordered set where globalRegion = &#63;.
	 *
	 * @param globalRegion the global region
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching marketing event
	 * @throws NoSuchMarketingEventException if a matching marketing event could not be found
	 */
	@Override
	public MarketingEvent findByGlobalRegion_First(int globalRegion,
		OrderByComparator<MarketingEvent> orderByComparator)
		throws NoSuchMarketingEventException {
		MarketingEvent marketingEvent = fetchByGlobalRegion_First(globalRegion,
				orderByComparator);

		if (marketingEvent != null) {
			return marketingEvent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("globalRegion=");
		msg.append(globalRegion);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMarketingEventException(msg.toString());
	}

	/**
	 * Returns the first marketing event in the ordered set where globalRegion = &#63;.
	 *
	 * @param globalRegion the global region
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching marketing event, or <code>null</code> if a matching marketing event could not be found
	 */
	@Override
	public MarketingEvent fetchByGlobalRegion_First(int globalRegion,
		OrderByComparator<MarketingEvent> orderByComparator) {
		List<MarketingEvent> list = findByGlobalRegion(globalRegion, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last marketing event in the ordered set where globalRegion = &#63;.
	 *
	 * @param globalRegion the global region
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching marketing event
	 * @throws NoSuchMarketingEventException if a matching marketing event could not be found
	 */
	@Override
	public MarketingEvent findByGlobalRegion_Last(int globalRegion,
		OrderByComparator<MarketingEvent> orderByComparator)
		throws NoSuchMarketingEventException {
		MarketingEvent marketingEvent = fetchByGlobalRegion_Last(globalRegion,
				orderByComparator);

		if (marketingEvent != null) {
			return marketingEvent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("globalRegion=");
		msg.append(globalRegion);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMarketingEventException(msg.toString());
	}

	/**
	 * Returns the last marketing event in the ordered set where globalRegion = &#63;.
	 *
	 * @param globalRegion the global region
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching marketing event, or <code>null</code> if a matching marketing event could not be found
	 */
	@Override
	public MarketingEvent fetchByGlobalRegion_Last(int globalRegion,
		OrderByComparator<MarketingEvent> orderByComparator) {
		int count = countByGlobalRegion(globalRegion);

		if (count == 0) {
			return null;
		}

		List<MarketingEvent> list = findByGlobalRegion(globalRegion, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the marketing events before and after the current marketing event in the ordered set where globalRegion = &#63;.
	 *
	 * @param marketingEventId the primary key of the current marketing event
	 * @param globalRegion the global region
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next marketing event
	 * @throws NoSuchMarketingEventException if a marketing event with the primary key could not be found
	 */
	@Override
	public MarketingEvent[] findByGlobalRegion_PrevAndNext(
		long marketingEventId, int globalRegion,
		OrderByComparator<MarketingEvent> orderByComparator)
		throws NoSuchMarketingEventException {
		MarketingEvent marketingEvent = findByPrimaryKey(marketingEventId);

		Session session = null;

		try {
			session = openSession();

			MarketingEvent[] array = new MarketingEventImpl[3];

			array[0] = getByGlobalRegion_PrevAndNext(session, marketingEvent,
					globalRegion, orderByComparator, true);

			array[1] = marketingEvent;

			array[2] = getByGlobalRegion_PrevAndNext(session, marketingEvent,
					globalRegion, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MarketingEvent getByGlobalRegion_PrevAndNext(Session session,
		MarketingEvent marketingEvent, int globalRegion,
		OrderByComparator<MarketingEvent> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MARKETINGEVENT_WHERE);

		query.append(_FINDER_COLUMN_GLOBALREGION_GLOBALREGION_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(MarketingEventModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(globalRegion);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(marketingEvent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MarketingEvent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the marketing events where globalRegion = &#63; from the database.
	 *
	 * @param globalRegion the global region
	 */
	@Override
	public void removeByGlobalRegion(int globalRegion) {
		for (MarketingEvent marketingEvent : findByGlobalRegion(globalRegion,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(marketingEvent);
		}
	}

	/**
	 * Returns the number of marketing events where globalRegion = &#63;.
	 *
	 * @param globalRegion the global region
	 * @return the number of matching marketing events
	 */
	@Override
	public int countByGlobalRegion(int globalRegion) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GLOBALREGION;

		Object[] finderArgs = new Object[] { globalRegion };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MARKETINGEVENT_WHERE);

			query.append(_FINDER_COLUMN_GLOBALREGION_GLOBALREGION_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(globalRegion);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GLOBALREGION_GLOBALREGION_2 = "marketingEvent.globalRegion = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_T_GTSD = new FinderPath(MarketingEventModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventModelImpl.FINDER_CACHE_ENABLED,
			MarketingEventImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByT_GtSD",
			new String[] {
				Integer.class.getName(), Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_T_GTSD = new FinderPath(MarketingEventModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByT_GtSD",
			new String[] { Integer.class.getName(), Date.class.getName() });

	/**
	 * Returns all the marketing events where type = &#63; and startDate &gt; &#63;.
	 *
	 * @param type the type
	 * @param startDate the start date
	 * @return the matching marketing events
	 */
	@Override
	public List<MarketingEvent> findByT_GtSD(int type, Date startDate) {
		return findByT_GtSD(type, startDate, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the marketing events where type = &#63; and startDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param startDate the start date
	 * @param start the lower bound of the range of marketing events
	 * @param end the upper bound of the range of marketing events (not inclusive)
	 * @return the range of matching marketing events
	 */
	@Override
	public List<MarketingEvent> findByT_GtSD(int type, Date startDate,
		int start, int end) {
		return findByT_GtSD(type, startDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the marketing events where type = &#63; and startDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param startDate the start date
	 * @param start the lower bound of the range of marketing events
	 * @param end the upper bound of the range of marketing events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching marketing events
	 */
	@Override
	public List<MarketingEvent> findByT_GtSD(int type, Date startDate,
		int start, int end, OrderByComparator<MarketingEvent> orderByComparator) {
		return findByT_GtSD(type, startDate, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the marketing events where type = &#63; and startDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param startDate the start date
	 * @param start the lower bound of the range of marketing events
	 * @param end the upper bound of the range of marketing events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching marketing events
	 */
	@Override
	public List<MarketingEvent> findByT_GtSD(int type, Date startDate,
		int start, int end,
		OrderByComparator<MarketingEvent> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_T_GTSD;
		finderArgs = new Object[] { type, startDate, start, end, orderByComparator };

		List<MarketingEvent> list = null;

		if (retrieveFromCache) {
			list = (List<MarketingEvent>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MarketingEvent marketingEvent : list) {
					if ((type != marketingEvent.getType()) ||
							(startDate.getTime() >= marketingEvent.getStartDate()
																	  .getTime())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_MARKETINGEVENT_WHERE);

			query.append(_FINDER_COLUMN_T_GTSD_TYPE_2);

			boolean bindStartDate = false;

			if (startDate == null) {
				query.append(_FINDER_COLUMN_T_GTSD_STARTDATE_1);
			}
			else {
				bindStartDate = true;

				query.append(_FINDER_COLUMN_T_GTSD_STARTDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MarketingEventModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(type);

				if (bindStartDate) {
					qPos.add(new Timestamp(startDate.getTime()));
				}

				if (!pagination) {
					list = (List<MarketingEvent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MarketingEvent>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first marketing event in the ordered set where type = &#63; and startDate &gt; &#63;.
	 *
	 * @param type the type
	 * @param startDate the start date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching marketing event
	 * @throws NoSuchMarketingEventException if a matching marketing event could not be found
	 */
	@Override
	public MarketingEvent findByT_GtSD_First(int type, Date startDate,
		OrderByComparator<MarketingEvent> orderByComparator)
		throws NoSuchMarketingEventException {
		MarketingEvent marketingEvent = fetchByT_GtSD_First(type, startDate,
				orderByComparator);

		if (marketingEvent != null) {
			return marketingEvent;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("type=");
		msg.append(type);

		msg.append(", startDate=");
		msg.append(startDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMarketingEventException(msg.toString());
	}

	/**
	 * Returns the first marketing event in the ordered set where type = &#63; and startDate &gt; &#63;.
	 *
	 * @param type the type
	 * @param startDate the start date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching marketing event, or <code>null</code> if a matching marketing event could not be found
	 */
	@Override
	public MarketingEvent fetchByT_GtSD_First(int type, Date startDate,
		OrderByComparator<MarketingEvent> orderByComparator) {
		List<MarketingEvent> list = findByT_GtSD(type, startDate, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last marketing event in the ordered set where type = &#63; and startDate &gt; &#63;.
	 *
	 * @param type the type
	 * @param startDate the start date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching marketing event
	 * @throws NoSuchMarketingEventException if a matching marketing event could not be found
	 */
	@Override
	public MarketingEvent findByT_GtSD_Last(int type, Date startDate,
		OrderByComparator<MarketingEvent> orderByComparator)
		throws NoSuchMarketingEventException {
		MarketingEvent marketingEvent = fetchByT_GtSD_Last(type, startDate,
				orderByComparator);

		if (marketingEvent != null) {
			return marketingEvent;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("type=");
		msg.append(type);

		msg.append(", startDate=");
		msg.append(startDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMarketingEventException(msg.toString());
	}

	/**
	 * Returns the last marketing event in the ordered set where type = &#63; and startDate &gt; &#63;.
	 *
	 * @param type the type
	 * @param startDate the start date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching marketing event, or <code>null</code> if a matching marketing event could not be found
	 */
	@Override
	public MarketingEvent fetchByT_GtSD_Last(int type, Date startDate,
		OrderByComparator<MarketingEvent> orderByComparator) {
		int count = countByT_GtSD(type, startDate);

		if (count == 0) {
			return null;
		}

		List<MarketingEvent> list = findByT_GtSD(type, startDate, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the marketing events before and after the current marketing event in the ordered set where type = &#63; and startDate &gt; &#63;.
	 *
	 * @param marketingEventId the primary key of the current marketing event
	 * @param type the type
	 * @param startDate the start date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next marketing event
	 * @throws NoSuchMarketingEventException if a marketing event with the primary key could not be found
	 */
	@Override
	public MarketingEvent[] findByT_GtSD_PrevAndNext(long marketingEventId,
		int type, Date startDate,
		OrderByComparator<MarketingEvent> orderByComparator)
		throws NoSuchMarketingEventException {
		MarketingEvent marketingEvent = findByPrimaryKey(marketingEventId);

		Session session = null;

		try {
			session = openSession();

			MarketingEvent[] array = new MarketingEventImpl[3];

			array[0] = getByT_GtSD_PrevAndNext(session, marketingEvent, type,
					startDate, orderByComparator, true);

			array[1] = marketingEvent;

			array[2] = getByT_GtSD_PrevAndNext(session, marketingEvent, type,
					startDate, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MarketingEvent getByT_GtSD_PrevAndNext(Session session,
		MarketingEvent marketingEvent, int type, Date startDate,
		OrderByComparator<MarketingEvent> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_MARKETINGEVENT_WHERE);

		query.append(_FINDER_COLUMN_T_GTSD_TYPE_2);

		boolean bindStartDate = false;

		if (startDate == null) {
			query.append(_FINDER_COLUMN_T_GTSD_STARTDATE_1);
		}
		else {
			bindStartDate = true;

			query.append(_FINDER_COLUMN_T_GTSD_STARTDATE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(MarketingEventModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(type);

		if (bindStartDate) {
			qPos.add(new Timestamp(startDate.getTime()));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(marketingEvent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MarketingEvent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the marketing events where type = &#63; and startDate &gt; &#63; from the database.
	 *
	 * @param type the type
	 * @param startDate the start date
	 */
	@Override
	public void removeByT_GtSD(int type, Date startDate) {
		for (MarketingEvent marketingEvent : findByT_GtSD(type, startDate,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(marketingEvent);
		}
	}

	/**
	 * Returns the number of marketing events where type = &#63; and startDate &gt; &#63;.
	 *
	 * @param type the type
	 * @param startDate the start date
	 * @return the number of matching marketing events
	 */
	@Override
	public int countByT_GtSD(int type, Date startDate) {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_T_GTSD;

		Object[] finderArgs = new Object[] { type, startDate };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MARKETINGEVENT_WHERE);

			query.append(_FINDER_COLUMN_T_GTSD_TYPE_2);

			boolean bindStartDate = false;

			if (startDate == null) {
				query.append(_FINDER_COLUMN_T_GTSD_STARTDATE_1);
			}
			else {
				bindStartDate = true;

				query.append(_FINDER_COLUMN_T_GTSD_STARTDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(type);

				if (bindStartDate) {
					qPos.add(new Timestamp(startDate.getTime()));
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_T_GTSD_TYPE_2 = "marketingEvent.type = ? AND ";
	private static final String _FINDER_COLUMN_T_GTSD_STARTDATE_1 = "marketingEvent.startDate IS NULL";
	private static final String _FINDER_COLUMN_T_GTSD_STARTDATE_2 = "marketingEvent.startDate > ?";

	public MarketingEventPersistenceImpl() {
		setModelClass(MarketingEvent.class);

		try {
			Field field = ReflectionUtil.getDeclaredField(BasePersistenceImpl.class,
					"_dbColumnNames");

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("type", "type_");
			dbColumnNames.put("online", "online_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the marketing event in the entity cache if it is enabled.
	 *
	 * @param marketingEvent the marketing event
	 */
	@Override
	public void cacheResult(MarketingEvent marketingEvent) {
		entityCache.putResult(MarketingEventModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventImpl.class, marketingEvent.getPrimaryKey(),
			marketingEvent);

		finderCache.putResult(FINDER_PATH_FETCH_BY_SITEGROUPID,
			new Object[] { marketingEvent.getSiteGroupId() }, marketingEvent);

		marketingEvent.resetOriginalValues();
	}

	/**
	 * Caches the marketing events in the entity cache if it is enabled.
	 *
	 * @param marketingEvents the marketing events
	 */
	@Override
	public void cacheResult(List<MarketingEvent> marketingEvents) {
		for (MarketingEvent marketingEvent : marketingEvents) {
			if (entityCache.getResult(
						MarketingEventModelImpl.ENTITY_CACHE_ENABLED,
						MarketingEventImpl.class, marketingEvent.getPrimaryKey()) == null) {
				cacheResult(marketingEvent);
			}
			else {
				marketingEvent.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all marketing events.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MarketingEventImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the marketing event.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MarketingEvent marketingEvent) {
		entityCache.removeResult(MarketingEventModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventImpl.class, marketingEvent.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((MarketingEventModelImpl)marketingEvent, true);
	}

	@Override
	public void clearCache(List<MarketingEvent> marketingEvents) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MarketingEvent marketingEvent : marketingEvents) {
			entityCache.removeResult(MarketingEventModelImpl.ENTITY_CACHE_ENABLED,
				MarketingEventImpl.class, marketingEvent.getPrimaryKey());

			clearUniqueFindersCache((MarketingEventModelImpl)marketingEvent,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		MarketingEventModelImpl marketingEventModelImpl) {
		Object[] args = new Object[] { marketingEventModelImpl.getSiteGroupId() };

		finderCache.putResult(FINDER_PATH_COUNT_BY_SITEGROUPID, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_SITEGROUPID, args,
			marketingEventModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		MarketingEventModelImpl marketingEventModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					marketingEventModelImpl.getSiteGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_SITEGROUPID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_SITEGROUPID, args);
		}

		if ((marketingEventModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_SITEGROUPID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					marketingEventModelImpl.getOriginalSiteGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_SITEGROUPID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_SITEGROUPID, args);
		}
	}

	/**
	 * Creates a new marketing event with the primary key. Does not add the marketing event to the database.
	 *
	 * @param marketingEventId the primary key for the new marketing event
	 * @return the new marketing event
	 */
	@Override
	public MarketingEvent create(long marketingEventId) {
		MarketingEvent marketingEvent = new MarketingEventImpl();

		marketingEvent.setNew(true);
		marketingEvent.setPrimaryKey(marketingEventId);

		marketingEvent.setCompanyId(companyProvider.getCompanyId());

		return marketingEvent;
	}

	/**
	 * Removes the marketing event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param marketingEventId the primary key of the marketing event
	 * @return the marketing event that was removed
	 * @throws NoSuchMarketingEventException if a marketing event with the primary key could not be found
	 */
	@Override
	public MarketingEvent remove(long marketingEventId)
		throws NoSuchMarketingEventException {
		return remove((Serializable)marketingEventId);
	}

	/**
	 * Removes the marketing event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the marketing event
	 * @return the marketing event that was removed
	 * @throws NoSuchMarketingEventException if a marketing event with the primary key could not be found
	 */
	@Override
	public MarketingEvent remove(Serializable primaryKey)
		throws NoSuchMarketingEventException {
		Session session = null;

		try {
			session = openSession();

			MarketingEvent marketingEvent = (MarketingEvent)session.get(MarketingEventImpl.class,
					primaryKey);

			if (marketingEvent == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMarketingEventException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(marketingEvent);
		}
		catch (NoSuchMarketingEventException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected MarketingEvent removeImpl(MarketingEvent marketingEvent) {
		marketingEvent = toUnwrappedModel(marketingEvent);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(marketingEvent)) {
				marketingEvent = (MarketingEvent)session.get(MarketingEventImpl.class,
						marketingEvent.getPrimaryKeyObj());
			}

			if (marketingEvent != null) {
				session.delete(marketingEvent);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (marketingEvent != null) {
			clearCache(marketingEvent);
		}

		return marketingEvent;
	}

	@Override
	public MarketingEvent updateImpl(MarketingEvent marketingEvent) {
		marketingEvent = toUnwrappedModel(marketingEvent);

		boolean isNew = marketingEvent.isNew();

		MarketingEventModelImpl marketingEventModelImpl = (MarketingEventModelImpl)marketingEvent;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (marketingEvent.getCreateDate() == null)) {
			if (serviceContext == null) {
				marketingEvent.setCreateDate(now);
			}
			else {
				marketingEvent.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!marketingEventModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				marketingEvent.setModifiedDate(now);
			}
			else {
				marketingEvent.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (marketingEvent.isNew()) {
				session.save(marketingEvent);

				marketingEvent.setNew(false);
			}
			else {
				marketingEvent = (MarketingEvent)session.merge(marketingEvent);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!MarketingEventModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { marketingEventModelImpl.getType() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_TYPE, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE,
				args);

			args = new Object[] { marketingEventModelImpl.getGlobalRegion() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_GLOBALREGION, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GLOBALREGION,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((marketingEventModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						marketingEventModelImpl.getOriginalType()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_TYPE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE,
					args);

				args = new Object[] { marketingEventModelImpl.getType() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_TYPE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE,
					args);
			}

			if ((marketingEventModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GLOBALREGION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						marketingEventModelImpl.getOriginalGlobalRegion()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GLOBALREGION, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GLOBALREGION,
					args);

				args = new Object[] { marketingEventModelImpl.getGlobalRegion() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GLOBALREGION, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GLOBALREGION,
					args);
			}
		}

		entityCache.putResult(MarketingEventModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventImpl.class, marketingEvent.getPrimaryKey(),
			marketingEvent, false);

		clearUniqueFindersCache(marketingEventModelImpl, false);
		cacheUniqueFindersCache(marketingEventModelImpl);

		marketingEvent.resetOriginalValues();

		return marketingEvent;
	}

	protected MarketingEvent toUnwrappedModel(MarketingEvent marketingEvent) {
		if (marketingEvent instanceof MarketingEventImpl) {
			return marketingEvent;
		}

		MarketingEventImpl marketingEventImpl = new MarketingEventImpl();

		marketingEventImpl.setNew(marketingEvent.isNew());
		marketingEventImpl.setPrimaryKey(marketingEvent.getPrimaryKey());

		marketingEventImpl.setMarketingEventId(marketingEvent.getMarketingEventId());
		marketingEventImpl.setCompanyId(marketingEvent.getCompanyId());
		marketingEventImpl.setUserId(marketingEvent.getUserId());
		marketingEventImpl.setUserName(marketingEvent.getUserName());
		marketingEventImpl.setCreateDate(marketingEvent.getCreateDate());
		marketingEventImpl.setModifiedDate(marketingEvent.getModifiedDate());
		marketingEventImpl.setType(marketingEvent.getType());
		marketingEventImpl.setTitle(marketingEvent.getTitle());
		marketingEventImpl.setTitleURL(marketingEvent.getTitleURL());
		marketingEventImpl.setHostedBy(marketingEvent.getHostedBy());
		marketingEventImpl.setHostedByURL(marketingEvent.getHostedByURL());
		marketingEventImpl.setSummary(marketingEvent.getSummary());
		marketingEventImpl.setSiteGroupId(marketingEvent.getSiteGroupId());
		marketingEventImpl.setImageFileEntryId(marketingEvent.getImageFileEntryId());
		marketingEventImpl.setSlidesFileEntryId(marketingEvent.getSlidesFileEntryId());
		marketingEventImpl.setVideoTitle(marketingEvent.getVideoTitle());
		marketingEventImpl.setTimeZoneId(marketingEvent.getTimeZoneId());
		marketingEventImpl.setStartDate(marketingEvent.getStartDate());
		marketingEventImpl.setEndDate(marketingEvent.getEndDate());
		marketingEventImpl.setDateTBA(marketingEvent.isDateTBA());
		marketingEventImpl.setAddressId(marketingEvent.getAddressId());
		marketingEventImpl.setLatitude(marketingEvent.getLatitude());
		marketingEventImpl.setLongitude(marketingEvent.getLongitude());
		marketingEventImpl.setGlobalRegion(marketingEvent.getGlobalRegion());
		marketingEventImpl.setOnline(marketingEvent.isOnline());
		marketingEventImpl.setRegistrationType(marketingEvent.getRegistrationType());
		marketingEventImpl.setRegistrationURL(marketingEvent.getRegistrationURL());
		marketingEventImpl.setExtraSettings(marketingEvent.getExtraSettings());

		return marketingEventImpl;
	}

	/**
	 * Returns the marketing event with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the marketing event
	 * @return the marketing event
	 * @throws NoSuchMarketingEventException if a marketing event with the primary key could not be found
	 */
	@Override
	public MarketingEvent findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMarketingEventException {
		MarketingEvent marketingEvent = fetchByPrimaryKey(primaryKey);

		if (marketingEvent == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMarketingEventException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return marketingEvent;
	}

	/**
	 * Returns the marketing event with the primary key or throws a {@link NoSuchMarketingEventException} if it could not be found.
	 *
	 * @param marketingEventId the primary key of the marketing event
	 * @return the marketing event
	 * @throws NoSuchMarketingEventException if a marketing event with the primary key could not be found
	 */
	@Override
	public MarketingEvent findByPrimaryKey(long marketingEventId)
		throws NoSuchMarketingEventException {
		return findByPrimaryKey((Serializable)marketingEventId);
	}

	/**
	 * Returns the marketing event with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the marketing event
	 * @return the marketing event, or <code>null</code> if a marketing event with the primary key could not be found
	 */
	@Override
	public MarketingEvent fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(MarketingEventModelImpl.ENTITY_CACHE_ENABLED,
				MarketingEventImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		MarketingEvent marketingEvent = (MarketingEvent)serializable;

		if (marketingEvent == null) {
			Session session = null;

			try {
				session = openSession();

				marketingEvent = (MarketingEvent)session.get(MarketingEventImpl.class,
						primaryKey);

				if (marketingEvent != null) {
					cacheResult(marketingEvent);
				}
				else {
					entityCache.putResult(MarketingEventModelImpl.ENTITY_CACHE_ENABLED,
						MarketingEventImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(MarketingEventModelImpl.ENTITY_CACHE_ENABLED,
					MarketingEventImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return marketingEvent;
	}

	/**
	 * Returns the marketing event with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param marketingEventId the primary key of the marketing event
	 * @return the marketing event, or <code>null</code> if a marketing event with the primary key could not be found
	 */
	@Override
	public MarketingEvent fetchByPrimaryKey(long marketingEventId) {
		return fetchByPrimaryKey((Serializable)marketingEventId);
	}

	@Override
	public Map<Serializable, MarketingEvent> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, MarketingEvent> map = new HashMap<Serializable, MarketingEvent>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			MarketingEvent marketingEvent = fetchByPrimaryKey(primaryKey);

			if (marketingEvent != null) {
				map.put(primaryKey, marketingEvent);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(MarketingEventModelImpl.ENTITY_CACHE_ENABLED,
					MarketingEventImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (MarketingEvent)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_MARKETINGEVENT_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (MarketingEvent marketingEvent : (List<MarketingEvent>)q.list()) {
				map.put(marketingEvent.getPrimaryKeyObj(), marketingEvent);

				cacheResult(marketingEvent);

				uncachedPrimaryKeys.remove(marketingEvent.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(MarketingEventModelImpl.ENTITY_CACHE_ENABLED,
					MarketingEventImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the marketing events.
	 *
	 * @return the marketing events
	 */
	@Override
	public List<MarketingEvent> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the marketing events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of marketing events
	 * @param end the upper bound of the range of marketing events (not inclusive)
	 * @return the range of marketing events
	 */
	@Override
	public List<MarketingEvent> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the marketing events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of marketing events
	 * @param end the upper bound of the range of marketing events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of marketing events
	 */
	@Override
	public List<MarketingEvent> findAll(int start, int end,
		OrderByComparator<MarketingEvent> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the marketing events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of marketing events
	 * @param end the upper bound of the range of marketing events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of marketing events
	 */
	@Override
	public List<MarketingEvent> findAll(int start, int end,
		OrderByComparator<MarketingEvent> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<MarketingEvent> list = null;

		if (retrieveFromCache) {
			list = (List<MarketingEvent>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_MARKETINGEVENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MARKETINGEVENT;

				if (pagination) {
					sql = sql.concat(MarketingEventModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<MarketingEvent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MarketingEvent>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the marketing events from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (MarketingEvent marketingEvent : findAll()) {
			remove(marketingEvent);
		}
	}

	/**
	 * Returns the number of marketing events.
	 *
	 * @return the number of marketing events
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_MARKETINGEVENT);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return MarketingEventModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the marketing event persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(MarketingEventImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_MARKETINGEVENT = "SELECT marketingEvent FROM MarketingEvent marketingEvent";
	private static final String _SQL_SELECT_MARKETINGEVENT_WHERE_PKS_IN = "SELECT marketingEvent FROM MarketingEvent marketingEvent WHERE marketingEventId IN (";
	private static final String _SQL_SELECT_MARKETINGEVENT_WHERE = "SELECT marketingEvent FROM MarketingEvent marketingEvent WHERE ";
	private static final String _SQL_COUNT_MARKETINGEVENT = "SELECT COUNT(marketingEvent) FROM MarketingEvent marketingEvent";
	private static final String _SQL_COUNT_MARKETINGEVENT_WHERE = "SELECT COUNT(marketingEvent) FROM MarketingEvent marketingEvent WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "marketingEvent.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MarketingEvent exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No MarketingEvent exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(MarketingEventPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"type", "online"
			});
}