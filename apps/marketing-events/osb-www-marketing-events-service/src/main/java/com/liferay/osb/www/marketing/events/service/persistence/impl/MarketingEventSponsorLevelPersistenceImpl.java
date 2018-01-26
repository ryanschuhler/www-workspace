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

import com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventSponsorLevelException;
import com.liferay.osb.www.marketing.events.model.MarketingEventSponsorLevel;
import com.liferay.osb.www.marketing.events.model.impl.MarketingEventSponsorLevelImpl;
import com.liferay.osb.www.marketing.events.model.impl.MarketingEventSponsorLevelModelImpl;
import com.liferay.osb.www.marketing.events.service.persistence.MarketingEventSponsorLevelPersistence;

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
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the marketing event sponsor level service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEventSponsorLevelPersistence
 * @see com.liferay.osb.www.marketing.events.service.persistence.MarketingEventSponsorLevelUtil
 * @generated
 */
@ProviderType
public class MarketingEventSponsorLevelPersistenceImpl
	extends BasePersistenceImpl<MarketingEventSponsorLevel>
	implements MarketingEventSponsorLevelPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MarketingEventSponsorLevelUtil} to access the marketing event sponsor level persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MarketingEventSponsorLevelImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MarketingEventSponsorLevelModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventSponsorLevelModelImpl.FINDER_CACHE_ENABLED,
			MarketingEventSponsorLevelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MarketingEventSponsorLevelModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventSponsorLevelModelImpl.FINDER_CACHE_ENABLED,
			MarketingEventSponsorLevelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MarketingEventSponsorLevelModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventSponsorLevelModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MARKETINGEVENTID =
		new FinderPath(MarketingEventSponsorLevelModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventSponsorLevelModelImpl.FINDER_CACHE_ENABLED,
			MarketingEventSponsorLevelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMarketingEventId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MARKETINGEVENTID =
		new FinderPath(MarketingEventSponsorLevelModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventSponsorLevelModelImpl.FINDER_CACHE_ENABLED,
			MarketingEventSponsorLevelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByMarketingEventId", new String[] { Long.class.getName() },
			MarketingEventSponsorLevelModelImpl.MARKETINGEVENTID_COLUMN_BITMASK |
			MarketingEventSponsorLevelModelImpl.PRIORITY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MARKETINGEVENTID = new FinderPath(MarketingEventSponsorLevelModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventSponsorLevelModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByMarketingEventId", new String[] { Long.class.getName() });

	/**
	 * Returns all the marketing event sponsor levels where marketingEventId = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @return the matching marketing event sponsor levels
	 */
	@Override
	public List<MarketingEventSponsorLevel> findByMarketingEventId(
		long marketingEventId) {
		return findByMarketingEventId(marketingEventId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the marketing event sponsor levels where marketingEventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSponsorLevelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param marketingEventId the marketing event ID
	 * @param start the lower bound of the range of marketing event sponsor levels
	 * @param end the upper bound of the range of marketing event sponsor levels (not inclusive)
	 * @return the range of matching marketing event sponsor levels
	 */
	@Override
	public List<MarketingEventSponsorLevel> findByMarketingEventId(
		long marketingEventId, int start, int end) {
		return findByMarketingEventId(marketingEventId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the marketing event sponsor levels where marketingEventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSponsorLevelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param marketingEventId the marketing event ID
	 * @param start the lower bound of the range of marketing event sponsor levels
	 * @param end the upper bound of the range of marketing event sponsor levels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching marketing event sponsor levels
	 */
	@Override
	public List<MarketingEventSponsorLevel> findByMarketingEventId(
		long marketingEventId, int start, int end,
		OrderByComparator<MarketingEventSponsorLevel> orderByComparator) {
		return findByMarketingEventId(marketingEventId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the marketing event sponsor levels where marketingEventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSponsorLevelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param marketingEventId the marketing event ID
	 * @param start the lower bound of the range of marketing event sponsor levels
	 * @param end the upper bound of the range of marketing event sponsor levels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching marketing event sponsor levels
	 */
	@Override
	public List<MarketingEventSponsorLevel> findByMarketingEventId(
		long marketingEventId, int start, int end,
		OrderByComparator<MarketingEventSponsorLevel> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MARKETINGEVENTID;
			finderArgs = new Object[] { marketingEventId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MARKETINGEVENTID;
			finderArgs = new Object[] {
					marketingEventId,
					
					start, end, orderByComparator
				};
		}

		List<MarketingEventSponsorLevel> list = null;

		if (retrieveFromCache) {
			list = (List<MarketingEventSponsorLevel>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MarketingEventSponsorLevel marketingEventSponsorLevel : list) {
					if ((marketingEventId != marketingEventSponsorLevel.getMarketingEventId())) {
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

			query.append(_SQL_SELECT_MARKETINGEVENTSPONSORLEVEL_WHERE);

			query.append(_FINDER_COLUMN_MARKETINGEVENTID_MARKETINGEVENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MarketingEventSponsorLevelModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(marketingEventId);

				if (!pagination) {
					list = (List<MarketingEventSponsorLevel>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MarketingEventSponsorLevel>)QueryUtil.list(q,
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
	 * Returns the first marketing event sponsor level in the ordered set where marketingEventId = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching marketing event sponsor level
	 * @throws NoSuchMarketingEventSponsorLevelException if a matching marketing event sponsor level could not be found
	 */
	@Override
	public MarketingEventSponsorLevel findByMarketingEventId_First(
		long marketingEventId,
		OrderByComparator<MarketingEventSponsorLevel> orderByComparator)
		throws NoSuchMarketingEventSponsorLevelException {
		MarketingEventSponsorLevel marketingEventSponsorLevel = fetchByMarketingEventId_First(marketingEventId,
				orderByComparator);

		if (marketingEventSponsorLevel != null) {
			return marketingEventSponsorLevel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("marketingEventId=");
		msg.append(marketingEventId);

		msg.append("}");

		throw new NoSuchMarketingEventSponsorLevelException(msg.toString());
	}

	/**
	 * Returns the first marketing event sponsor level in the ordered set where marketingEventId = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching marketing event sponsor level, or <code>null</code> if a matching marketing event sponsor level could not be found
	 */
	@Override
	public MarketingEventSponsorLevel fetchByMarketingEventId_First(
		long marketingEventId,
		OrderByComparator<MarketingEventSponsorLevel> orderByComparator) {
		List<MarketingEventSponsorLevel> list = findByMarketingEventId(marketingEventId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last marketing event sponsor level in the ordered set where marketingEventId = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching marketing event sponsor level
	 * @throws NoSuchMarketingEventSponsorLevelException if a matching marketing event sponsor level could not be found
	 */
	@Override
	public MarketingEventSponsorLevel findByMarketingEventId_Last(
		long marketingEventId,
		OrderByComparator<MarketingEventSponsorLevel> orderByComparator)
		throws NoSuchMarketingEventSponsorLevelException {
		MarketingEventSponsorLevel marketingEventSponsorLevel = fetchByMarketingEventId_Last(marketingEventId,
				orderByComparator);

		if (marketingEventSponsorLevel != null) {
			return marketingEventSponsorLevel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("marketingEventId=");
		msg.append(marketingEventId);

		msg.append("}");

		throw new NoSuchMarketingEventSponsorLevelException(msg.toString());
	}

	/**
	 * Returns the last marketing event sponsor level in the ordered set where marketingEventId = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching marketing event sponsor level, or <code>null</code> if a matching marketing event sponsor level could not be found
	 */
	@Override
	public MarketingEventSponsorLevel fetchByMarketingEventId_Last(
		long marketingEventId,
		OrderByComparator<MarketingEventSponsorLevel> orderByComparator) {
		int count = countByMarketingEventId(marketingEventId);

		if (count == 0) {
			return null;
		}

		List<MarketingEventSponsorLevel> list = findByMarketingEventId(marketingEventId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the marketing event sponsor levels before and after the current marketing event sponsor level in the ordered set where marketingEventId = &#63;.
	 *
	 * @param marketingEventSponsorLevelId the primary key of the current marketing event sponsor level
	 * @param marketingEventId the marketing event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next marketing event sponsor level
	 * @throws NoSuchMarketingEventSponsorLevelException if a marketing event sponsor level with the primary key could not be found
	 */
	@Override
	public MarketingEventSponsorLevel[] findByMarketingEventId_PrevAndNext(
		long marketingEventSponsorLevelId, long marketingEventId,
		OrderByComparator<MarketingEventSponsorLevel> orderByComparator)
		throws NoSuchMarketingEventSponsorLevelException {
		MarketingEventSponsorLevel marketingEventSponsorLevel = findByPrimaryKey(marketingEventSponsorLevelId);

		Session session = null;

		try {
			session = openSession();

			MarketingEventSponsorLevel[] array = new MarketingEventSponsorLevelImpl[3];

			array[0] = getByMarketingEventId_PrevAndNext(session,
					marketingEventSponsorLevel, marketingEventId,
					orderByComparator, true);

			array[1] = marketingEventSponsorLevel;

			array[2] = getByMarketingEventId_PrevAndNext(session,
					marketingEventSponsorLevel, marketingEventId,
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

	protected MarketingEventSponsorLevel getByMarketingEventId_PrevAndNext(
		Session session, MarketingEventSponsorLevel marketingEventSponsorLevel,
		long marketingEventId,
		OrderByComparator<MarketingEventSponsorLevel> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MARKETINGEVENTSPONSORLEVEL_WHERE);

		query.append(_FINDER_COLUMN_MARKETINGEVENTID_MARKETINGEVENTID_2);

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
			query.append(MarketingEventSponsorLevelModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(marketingEventId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(marketingEventSponsorLevel);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MarketingEventSponsorLevel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the marketing event sponsor levels where marketingEventId = &#63; from the database.
	 *
	 * @param marketingEventId the marketing event ID
	 */
	@Override
	public void removeByMarketingEventId(long marketingEventId) {
		for (MarketingEventSponsorLevel marketingEventSponsorLevel : findByMarketingEventId(
				marketingEventId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(marketingEventSponsorLevel);
		}
	}

	/**
	 * Returns the number of marketing event sponsor levels where marketingEventId = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @return the number of matching marketing event sponsor levels
	 */
	@Override
	public int countByMarketingEventId(long marketingEventId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MARKETINGEVENTID;

		Object[] finderArgs = new Object[] { marketingEventId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MARKETINGEVENTSPONSORLEVEL_WHERE);

			query.append(_FINDER_COLUMN_MARKETINGEVENTID_MARKETINGEVENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(marketingEventId);

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

	private static final String _FINDER_COLUMN_MARKETINGEVENTID_MARKETINGEVENTID_2 =
		"marketingEventSponsorLevel.marketingEventId = ?";

	public MarketingEventSponsorLevelPersistenceImpl() {
		setModelClass(MarketingEventSponsorLevel.class);
	}

	/**
	 * Caches the marketing event sponsor level in the entity cache if it is enabled.
	 *
	 * @param marketingEventSponsorLevel the marketing event sponsor level
	 */
	@Override
	public void cacheResult(
		MarketingEventSponsorLevel marketingEventSponsorLevel) {
		entityCache.putResult(MarketingEventSponsorLevelModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventSponsorLevelImpl.class,
			marketingEventSponsorLevel.getPrimaryKey(),
			marketingEventSponsorLevel);

		marketingEventSponsorLevel.resetOriginalValues();
	}

	/**
	 * Caches the marketing event sponsor levels in the entity cache if it is enabled.
	 *
	 * @param marketingEventSponsorLevels the marketing event sponsor levels
	 */
	@Override
	public void cacheResult(
		List<MarketingEventSponsorLevel> marketingEventSponsorLevels) {
		for (MarketingEventSponsorLevel marketingEventSponsorLevel : marketingEventSponsorLevels) {
			if (entityCache.getResult(
						MarketingEventSponsorLevelModelImpl.ENTITY_CACHE_ENABLED,
						MarketingEventSponsorLevelImpl.class,
						marketingEventSponsorLevel.getPrimaryKey()) == null) {
				cacheResult(marketingEventSponsorLevel);
			}
			else {
				marketingEventSponsorLevel.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all marketing event sponsor levels.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MarketingEventSponsorLevelImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the marketing event sponsor level.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		MarketingEventSponsorLevel marketingEventSponsorLevel) {
		entityCache.removeResult(MarketingEventSponsorLevelModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventSponsorLevelImpl.class,
			marketingEventSponsorLevel.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<MarketingEventSponsorLevel> marketingEventSponsorLevels) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MarketingEventSponsorLevel marketingEventSponsorLevel : marketingEventSponsorLevels) {
			entityCache.removeResult(MarketingEventSponsorLevelModelImpl.ENTITY_CACHE_ENABLED,
				MarketingEventSponsorLevelImpl.class,
				marketingEventSponsorLevel.getPrimaryKey());
		}
	}

	/**
	 * Creates a new marketing event sponsor level with the primary key. Does not add the marketing event sponsor level to the database.
	 *
	 * @param marketingEventSponsorLevelId the primary key for the new marketing event sponsor level
	 * @return the new marketing event sponsor level
	 */
	@Override
	public MarketingEventSponsorLevel create(long marketingEventSponsorLevelId) {
		MarketingEventSponsorLevel marketingEventSponsorLevel = new MarketingEventSponsorLevelImpl();

		marketingEventSponsorLevel.setNew(true);
		marketingEventSponsorLevel.setPrimaryKey(marketingEventSponsorLevelId);

		return marketingEventSponsorLevel;
	}

	/**
	 * Removes the marketing event sponsor level with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param marketingEventSponsorLevelId the primary key of the marketing event sponsor level
	 * @return the marketing event sponsor level that was removed
	 * @throws NoSuchMarketingEventSponsorLevelException if a marketing event sponsor level with the primary key could not be found
	 */
	@Override
	public MarketingEventSponsorLevel remove(long marketingEventSponsorLevelId)
		throws NoSuchMarketingEventSponsorLevelException {
		return remove((Serializable)marketingEventSponsorLevelId);
	}

	/**
	 * Removes the marketing event sponsor level with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the marketing event sponsor level
	 * @return the marketing event sponsor level that was removed
	 * @throws NoSuchMarketingEventSponsorLevelException if a marketing event sponsor level with the primary key could not be found
	 */
	@Override
	public MarketingEventSponsorLevel remove(Serializable primaryKey)
		throws NoSuchMarketingEventSponsorLevelException {
		Session session = null;

		try {
			session = openSession();

			MarketingEventSponsorLevel marketingEventSponsorLevel = (MarketingEventSponsorLevel)session.get(MarketingEventSponsorLevelImpl.class,
					primaryKey);

			if (marketingEventSponsorLevel == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMarketingEventSponsorLevelException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(marketingEventSponsorLevel);
		}
		catch (NoSuchMarketingEventSponsorLevelException nsee) {
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
	protected MarketingEventSponsorLevel removeImpl(
		MarketingEventSponsorLevel marketingEventSponsorLevel) {
		marketingEventSponsorLevel = toUnwrappedModel(marketingEventSponsorLevel);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(marketingEventSponsorLevel)) {
				marketingEventSponsorLevel = (MarketingEventSponsorLevel)session.get(MarketingEventSponsorLevelImpl.class,
						marketingEventSponsorLevel.getPrimaryKeyObj());
			}

			if (marketingEventSponsorLevel != null) {
				session.delete(marketingEventSponsorLevel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (marketingEventSponsorLevel != null) {
			clearCache(marketingEventSponsorLevel);
		}

		return marketingEventSponsorLevel;
	}

	@Override
	public MarketingEventSponsorLevel updateImpl(
		MarketingEventSponsorLevel marketingEventSponsorLevel) {
		marketingEventSponsorLevel = toUnwrappedModel(marketingEventSponsorLevel);

		boolean isNew = marketingEventSponsorLevel.isNew();

		MarketingEventSponsorLevelModelImpl marketingEventSponsorLevelModelImpl = (MarketingEventSponsorLevelModelImpl)marketingEventSponsorLevel;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (marketingEventSponsorLevel.getCreateDate() == null)) {
			if (serviceContext == null) {
				marketingEventSponsorLevel.setCreateDate(now);
			}
			else {
				marketingEventSponsorLevel.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!marketingEventSponsorLevelModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				marketingEventSponsorLevel.setModifiedDate(now);
			}
			else {
				marketingEventSponsorLevel.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (marketingEventSponsorLevel.isNew()) {
				session.save(marketingEventSponsorLevel);

				marketingEventSponsorLevel.setNew(false);
			}
			else {
				marketingEventSponsorLevel = (MarketingEventSponsorLevel)session.merge(marketingEventSponsorLevel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!MarketingEventSponsorLevelModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					marketingEventSponsorLevelModelImpl.getMarketingEventId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_MARKETINGEVENTID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MARKETINGEVENTID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((marketingEventSponsorLevelModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MARKETINGEVENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						marketingEventSponsorLevelModelImpl.getOriginalMarketingEventId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MARKETINGEVENTID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MARKETINGEVENTID,
					args);

				args = new Object[] {
						marketingEventSponsorLevelModelImpl.getMarketingEventId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MARKETINGEVENTID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MARKETINGEVENTID,
					args);
			}
		}

		entityCache.putResult(MarketingEventSponsorLevelModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventSponsorLevelImpl.class,
			marketingEventSponsorLevel.getPrimaryKey(),
			marketingEventSponsorLevel, false);

		marketingEventSponsorLevel.resetOriginalValues();

		return marketingEventSponsorLevel;
	}

	protected MarketingEventSponsorLevel toUnwrappedModel(
		MarketingEventSponsorLevel marketingEventSponsorLevel) {
		if (marketingEventSponsorLevel instanceof MarketingEventSponsorLevelImpl) {
			return marketingEventSponsorLevel;
		}

		MarketingEventSponsorLevelImpl marketingEventSponsorLevelImpl = new MarketingEventSponsorLevelImpl();

		marketingEventSponsorLevelImpl.setNew(marketingEventSponsorLevel.isNew());
		marketingEventSponsorLevelImpl.setPrimaryKey(marketingEventSponsorLevel.getPrimaryKey());

		marketingEventSponsorLevelImpl.setMarketingEventSponsorLevelId(marketingEventSponsorLevel.getMarketingEventSponsorLevelId());
		marketingEventSponsorLevelImpl.setUserId(marketingEventSponsorLevel.getUserId());
		marketingEventSponsorLevelImpl.setUserName(marketingEventSponsorLevel.getUserName());
		marketingEventSponsorLevelImpl.setCreateDate(marketingEventSponsorLevel.getCreateDate());
		marketingEventSponsorLevelImpl.setModifiedDate(marketingEventSponsorLevel.getModifiedDate());
		marketingEventSponsorLevelImpl.setMarketingEventId(marketingEventSponsorLevel.getMarketingEventId());
		marketingEventSponsorLevelImpl.setName(marketingEventSponsorLevel.getName());
		marketingEventSponsorLevelImpl.setPriority(marketingEventSponsorLevel.getPriority());

		return marketingEventSponsorLevelImpl;
	}

	/**
	 * Returns the marketing event sponsor level with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the marketing event sponsor level
	 * @return the marketing event sponsor level
	 * @throws NoSuchMarketingEventSponsorLevelException if a marketing event sponsor level with the primary key could not be found
	 */
	@Override
	public MarketingEventSponsorLevel findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMarketingEventSponsorLevelException {
		MarketingEventSponsorLevel marketingEventSponsorLevel = fetchByPrimaryKey(primaryKey);

		if (marketingEventSponsorLevel == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMarketingEventSponsorLevelException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return marketingEventSponsorLevel;
	}

	/**
	 * Returns the marketing event sponsor level with the primary key or throws a {@link NoSuchMarketingEventSponsorLevelException} if it could not be found.
	 *
	 * @param marketingEventSponsorLevelId the primary key of the marketing event sponsor level
	 * @return the marketing event sponsor level
	 * @throws NoSuchMarketingEventSponsorLevelException if a marketing event sponsor level with the primary key could not be found
	 */
	@Override
	public MarketingEventSponsorLevel findByPrimaryKey(
		long marketingEventSponsorLevelId)
		throws NoSuchMarketingEventSponsorLevelException {
		return findByPrimaryKey((Serializable)marketingEventSponsorLevelId);
	}

	/**
	 * Returns the marketing event sponsor level with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the marketing event sponsor level
	 * @return the marketing event sponsor level, or <code>null</code> if a marketing event sponsor level with the primary key could not be found
	 */
	@Override
	public MarketingEventSponsorLevel fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(MarketingEventSponsorLevelModelImpl.ENTITY_CACHE_ENABLED,
				MarketingEventSponsorLevelImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		MarketingEventSponsorLevel marketingEventSponsorLevel = (MarketingEventSponsorLevel)serializable;

		if (marketingEventSponsorLevel == null) {
			Session session = null;

			try {
				session = openSession();

				marketingEventSponsorLevel = (MarketingEventSponsorLevel)session.get(MarketingEventSponsorLevelImpl.class,
						primaryKey);

				if (marketingEventSponsorLevel != null) {
					cacheResult(marketingEventSponsorLevel);
				}
				else {
					entityCache.putResult(MarketingEventSponsorLevelModelImpl.ENTITY_CACHE_ENABLED,
						MarketingEventSponsorLevelImpl.class, primaryKey,
						nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(MarketingEventSponsorLevelModelImpl.ENTITY_CACHE_ENABLED,
					MarketingEventSponsorLevelImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return marketingEventSponsorLevel;
	}

	/**
	 * Returns the marketing event sponsor level with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param marketingEventSponsorLevelId the primary key of the marketing event sponsor level
	 * @return the marketing event sponsor level, or <code>null</code> if a marketing event sponsor level with the primary key could not be found
	 */
	@Override
	public MarketingEventSponsorLevel fetchByPrimaryKey(
		long marketingEventSponsorLevelId) {
		return fetchByPrimaryKey((Serializable)marketingEventSponsorLevelId);
	}

	@Override
	public Map<Serializable, MarketingEventSponsorLevel> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, MarketingEventSponsorLevel> map = new HashMap<Serializable, MarketingEventSponsorLevel>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			MarketingEventSponsorLevel marketingEventSponsorLevel = fetchByPrimaryKey(primaryKey);

			if (marketingEventSponsorLevel != null) {
				map.put(primaryKey, marketingEventSponsorLevel);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(MarketingEventSponsorLevelModelImpl.ENTITY_CACHE_ENABLED,
					MarketingEventSponsorLevelImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (MarketingEventSponsorLevel)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_MARKETINGEVENTSPONSORLEVEL_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (MarketingEventSponsorLevel marketingEventSponsorLevel : (List<MarketingEventSponsorLevel>)q.list()) {
				map.put(marketingEventSponsorLevel.getPrimaryKeyObj(),
					marketingEventSponsorLevel);

				cacheResult(marketingEventSponsorLevel);

				uncachedPrimaryKeys.remove(marketingEventSponsorLevel.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(MarketingEventSponsorLevelModelImpl.ENTITY_CACHE_ENABLED,
					MarketingEventSponsorLevelImpl.class, primaryKey, nullModel);
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
	 * Returns all the marketing event sponsor levels.
	 *
	 * @return the marketing event sponsor levels
	 */
	@Override
	public List<MarketingEventSponsorLevel> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the marketing event sponsor levels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSponsorLevelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of marketing event sponsor levels
	 * @param end the upper bound of the range of marketing event sponsor levels (not inclusive)
	 * @return the range of marketing event sponsor levels
	 */
	@Override
	public List<MarketingEventSponsorLevel> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the marketing event sponsor levels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSponsorLevelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of marketing event sponsor levels
	 * @param end the upper bound of the range of marketing event sponsor levels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of marketing event sponsor levels
	 */
	@Override
	public List<MarketingEventSponsorLevel> findAll(int start, int end,
		OrderByComparator<MarketingEventSponsorLevel> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the marketing event sponsor levels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSponsorLevelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of marketing event sponsor levels
	 * @param end the upper bound of the range of marketing event sponsor levels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of marketing event sponsor levels
	 */
	@Override
	public List<MarketingEventSponsorLevel> findAll(int start, int end,
		OrderByComparator<MarketingEventSponsorLevel> orderByComparator,
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

		List<MarketingEventSponsorLevel> list = null;

		if (retrieveFromCache) {
			list = (List<MarketingEventSponsorLevel>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_MARKETINGEVENTSPONSORLEVEL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MARKETINGEVENTSPONSORLEVEL;

				if (pagination) {
					sql = sql.concat(MarketingEventSponsorLevelModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<MarketingEventSponsorLevel>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MarketingEventSponsorLevel>)QueryUtil.list(q,
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
	 * Removes all the marketing event sponsor levels from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (MarketingEventSponsorLevel marketingEventSponsorLevel : findAll()) {
			remove(marketingEventSponsorLevel);
		}
	}

	/**
	 * Returns the number of marketing event sponsor levels.
	 *
	 * @return the number of marketing event sponsor levels
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_MARKETINGEVENTSPONSORLEVEL);

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
	protected Map<String, Integer> getTableColumnsMap() {
		return MarketingEventSponsorLevelModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the marketing event sponsor level persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(MarketingEventSponsorLevelImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_MARKETINGEVENTSPONSORLEVEL = "SELECT marketingEventSponsorLevel FROM MarketingEventSponsorLevel marketingEventSponsorLevel";
	private static final String _SQL_SELECT_MARKETINGEVENTSPONSORLEVEL_WHERE_PKS_IN =
		"SELECT marketingEventSponsorLevel FROM MarketingEventSponsorLevel marketingEventSponsorLevel WHERE marketingEventSponsorLevelId IN (";
	private static final String _SQL_SELECT_MARKETINGEVENTSPONSORLEVEL_WHERE = "SELECT marketingEventSponsorLevel FROM MarketingEventSponsorLevel marketingEventSponsorLevel WHERE ";
	private static final String _SQL_COUNT_MARKETINGEVENTSPONSORLEVEL = "SELECT COUNT(marketingEventSponsorLevel) FROM MarketingEventSponsorLevel marketingEventSponsorLevel";
	private static final String _SQL_COUNT_MARKETINGEVENTSPONSORLEVEL_WHERE = "SELECT COUNT(marketingEventSponsorLevel) FROM MarketingEventSponsorLevel marketingEventSponsorLevel WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "marketingEventSponsorLevel.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MarketingEventSponsorLevel exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No MarketingEventSponsorLevel exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(MarketingEventSponsorLevelPersistenceImpl.class);
}