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

import com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventSponsorException;
import com.liferay.osb.www.marketing.events.model.MarketingEventSponsor;
import com.liferay.osb.www.marketing.events.model.impl.MarketingEventSponsorImpl;
import com.liferay.osb.www.marketing.events.model.impl.MarketingEventSponsorModelImpl;
import com.liferay.osb.www.marketing.events.service.persistence.MarketingEventSponsorPersistence;

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
 * The persistence implementation for the marketing event sponsor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEventSponsorPersistence
 * @see com.liferay.osb.www.marketing.events.service.persistence.MarketingEventSponsorUtil
 * @generated
 */
@ProviderType
public class MarketingEventSponsorPersistenceImpl extends BasePersistenceImpl<MarketingEventSponsor>
	implements MarketingEventSponsorPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MarketingEventSponsorUtil} to access the marketing event sponsor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MarketingEventSponsorImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MarketingEventSponsorModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventSponsorModelImpl.FINDER_CACHE_ENABLED,
			MarketingEventSponsorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MarketingEventSponsorModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventSponsorModelImpl.FINDER_CACHE_ENABLED,
			MarketingEventSponsorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MarketingEventSponsorModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventSponsorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MARKETINGEVENTID =
		new FinderPath(MarketingEventSponsorModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventSponsorModelImpl.FINDER_CACHE_ENABLED,
			MarketingEventSponsorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMarketingEventId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MARKETINGEVENTID =
		new FinderPath(MarketingEventSponsorModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventSponsorModelImpl.FINDER_CACHE_ENABLED,
			MarketingEventSponsorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByMarketingEventId", new String[] { Long.class.getName() },
			MarketingEventSponsorModelImpl.MARKETINGEVENTID_COLUMN_BITMASK |
			MarketingEventSponsorModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MARKETINGEVENTID = new FinderPath(MarketingEventSponsorModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventSponsorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByMarketingEventId", new String[] { Long.class.getName() });

	/**
	 * Returns all the marketing event sponsors where marketingEventId = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @return the matching marketing event sponsors
	 */
	@Override
	public List<MarketingEventSponsor> findByMarketingEventId(
		long marketingEventId) {
		return findByMarketingEventId(marketingEventId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the marketing event sponsors where marketingEventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSponsorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param marketingEventId the marketing event ID
	 * @param start the lower bound of the range of marketing event sponsors
	 * @param end the upper bound of the range of marketing event sponsors (not inclusive)
	 * @return the range of matching marketing event sponsors
	 */
	@Override
	public List<MarketingEventSponsor> findByMarketingEventId(
		long marketingEventId, int start, int end) {
		return findByMarketingEventId(marketingEventId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the marketing event sponsors where marketingEventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSponsorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param marketingEventId the marketing event ID
	 * @param start the lower bound of the range of marketing event sponsors
	 * @param end the upper bound of the range of marketing event sponsors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching marketing event sponsors
	 */
	@Override
	public List<MarketingEventSponsor> findByMarketingEventId(
		long marketingEventId, int start, int end,
		OrderByComparator<MarketingEventSponsor> orderByComparator) {
		return findByMarketingEventId(marketingEventId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the marketing event sponsors where marketingEventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSponsorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param marketingEventId the marketing event ID
	 * @param start the lower bound of the range of marketing event sponsors
	 * @param end the upper bound of the range of marketing event sponsors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching marketing event sponsors
	 */
	@Override
	public List<MarketingEventSponsor> findByMarketingEventId(
		long marketingEventId, int start, int end,
		OrderByComparator<MarketingEventSponsor> orderByComparator,
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

		List<MarketingEventSponsor> list = null;

		if (retrieveFromCache) {
			list = (List<MarketingEventSponsor>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MarketingEventSponsor marketingEventSponsor : list) {
					if ((marketingEventId != marketingEventSponsor.getMarketingEventId())) {
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

			query.append(_SQL_SELECT_MARKETINGEVENTSPONSOR_WHERE);

			query.append(_FINDER_COLUMN_MARKETINGEVENTID_MARKETINGEVENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MarketingEventSponsorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(marketingEventId);

				if (!pagination) {
					list = (List<MarketingEventSponsor>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MarketingEventSponsor>)QueryUtil.list(q,
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
	 * Returns the first marketing event sponsor in the ordered set where marketingEventId = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching marketing event sponsor
	 * @throws NoSuchMarketingEventSponsorException if a matching marketing event sponsor could not be found
	 */
	@Override
	public MarketingEventSponsor findByMarketingEventId_First(
		long marketingEventId,
		OrderByComparator<MarketingEventSponsor> orderByComparator)
		throws NoSuchMarketingEventSponsorException {
		MarketingEventSponsor marketingEventSponsor = fetchByMarketingEventId_First(marketingEventId,
				orderByComparator);

		if (marketingEventSponsor != null) {
			return marketingEventSponsor;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("marketingEventId=");
		msg.append(marketingEventId);

		msg.append("}");

		throw new NoSuchMarketingEventSponsorException(msg.toString());
	}

	/**
	 * Returns the first marketing event sponsor in the ordered set where marketingEventId = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching marketing event sponsor, or <code>null</code> if a matching marketing event sponsor could not be found
	 */
	@Override
	public MarketingEventSponsor fetchByMarketingEventId_First(
		long marketingEventId,
		OrderByComparator<MarketingEventSponsor> orderByComparator) {
		List<MarketingEventSponsor> list = findByMarketingEventId(marketingEventId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last marketing event sponsor in the ordered set where marketingEventId = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching marketing event sponsor
	 * @throws NoSuchMarketingEventSponsorException if a matching marketing event sponsor could not be found
	 */
	@Override
	public MarketingEventSponsor findByMarketingEventId_Last(
		long marketingEventId,
		OrderByComparator<MarketingEventSponsor> orderByComparator)
		throws NoSuchMarketingEventSponsorException {
		MarketingEventSponsor marketingEventSponsor = fetchByMarketingEventId_Last(marketingEventId,
				orderByComparator);

		if (marketingEventSponsor != null) {
			return marketingEventSponsor;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("marketingEventId=");
		msg.append(marketingEventId);

		msg.append("}");

		throw new NoSuchMarketingEventSponsorException(msg.toString());
	}

	/**
	 * Returns the last marketing event sponsor in the ordered set where marketingEventId = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching marketing event sponsor, or <code>null</code> if a matching marketing event sponsor could not be found
	 */
	@Override
	public MarketingEventSponsor fetchByMarketingEventId_Last(
		long marketingEventId,
		OrderByComparator<MarketingEventSponsor> orderByComparator) {
		int count = countByMarketingEventId(marketingEventId);

		if (count == 0) {
			return null;
		}

		List<MarketingEventSponsor> list = findByMarketingEventId(marketingEventId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the marketing event sponsors before and after the current marketing event sponsor in the ordered set where marketingEventId = &#63;.
	 *
	 * @param marketingEventSponsorId the primary key of the current marketing event sponsor
	 * @param marketingEventId the marketing event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next marketing event sponsor
	 * @throws NoSuchMarketingEventSponsorException if a marketing event sponsor with the primary key could not be found
	 */
	@Override
	public MarketingEventSponsor[] findByMarketingEventId_PrevAndNext(
		long marketingEventSponsorId, long marketingEventId,
		OrderByComparator<MarketingEventSponsor> orderByComparator)
		throws NoSuchMarketingEventSponsorException {
		MarketingEventSponsor marketingEventSponsor = findByPrimaryKey(marketingEventSponsorId);

		Session session = null;

		try {
			session = openSession();

			MarketingEventSponsor[] array = new MarketingEventSponsorImpl[3];

			array[0] = getByMarketingEventId_PrevAndNext(session,
					marketingEventSponsor, marketingEventId, orderByComparator,
					true);

			array[1] = marketingEventSponsor;

			array[2] = getByMarketingEventId_PrevAndNext(session,
					marketingEventSponsor, marketingEventId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MarketingEventSponsor getByMarketingEventId_PrevAndNext(
		Session session, MarketingEventSponsor marketingEventSponsor,
		long marketingEventId,
		OrderByComparator<MarketingEventSponsor> orderByComparator,
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

		query.append(_SQL_SELECT_MARKETINGEVENTSPONSOR_WHERE);

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
			query.append(MarketingEventSponsorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(marketingEventId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(marketingEventSponsor);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MarketingEventSponsor> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the marketing event sponsors where marketingEventId = &#63; from the database.
	 *
	 * @param marketingEventId the marketing event ID
	 */
	@Override
	public void removeByMarketingEventId(long marketingEventId) {
		for (MarketingEventSponsor marketingEventSponsor : findByMarketingEventId(
				marketingEventId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(marketingEventSponsor);
		}
	}

	/**
	 * Returns the number of marketing event sponsors where marketingEventId = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @return the number of matching marketing event sponsors
	 */
	@Override
	public int countByMarketingEventId(long marketingEventId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MARKETINGEVENTID;

		Object[] finderArgs = new Object[] { marketingEventId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MARKETINGEVENTSPONSOR_WHERE);

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
		"marketingEventSponsor.marketingEventId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MEI_MESLI =
		new FinderPath(MarketingEventSponsorModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventSponsorModelImpl.FINDER_CACHE_ENABLED,
			MarketingEventSponsorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMEI_MESLI",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEI_MESLI =
		new FinderPath(MarketingEventSponsorModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventSponsorModelImpl.FINDER_CACHE_ENABLED,
			MarketingEventSponsorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMEI_MESLI",
			new String[] { Long.class.getName(), Long.class.getName() },
			MarketingEventSponsorModelImpl.MARKETINGEVENTID_COLUMN_BITMASK |
			MarketingEventSponsorModelImpl.MARKETINGEVENTSPONSORLEVELID_COLUMN_BITMASK |
			MarketingEventSponsorModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MEI_MESLI = new FinderPath(MarketingEventSponsorModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventSponsorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMEI_MESLI",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the marketing event sponsors where marketingEventId = &#63; and marketingEventSponsorLevelId = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param marketingEventSponsorLevelId the marketing event sponsor level ID
	 * @return the matching marketing event sponsors
	 */
	@Override
	public List<MarketingEventSponsor> findByMEI_MESLI(long marketingEventId,
		long marketingEventSponsorLevelId) {
		return findByMEI_MESLI(marketingEventId, marketingEventSponsorLevelId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the marketing event sponsors where marketingEventId = &#63; and marketingEventSponsorLevelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSponsorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param marketingEventId the marketing event ID
	 * @param marketingEventSponsorLevelId the marketing event sponsor level ID
	 * @param start the lower bound of the range of marketing event sponsors
	 * @param end the upper bound of the range of marketing event sponsors (not inclusive)
	 * @return the range of matching marketing event sponsors
	 */
	@Override
	public List<MarketingEventSponsor> findByMEI_MESLI(long marketingEventId,
		long marketingEventSponsorLevelId, int start, int end) {
		return findByMEI_MESLI(marketingEventId, marketingEventSponsorLevelId,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the marketing event sponsors where marketingEventId = &#63; and marketingEventSponsorLevelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSponsorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param marketingEventId the marketing event ID
	 * @param marketingEventSponsorLevelId the marketing event sponsor level ID
	 * @param start the lower bound of the range of marketing event sponsors
	 * @param end the upper bound of the range of marketing event sponsors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching marketing event sponsors
	 */
	@Override
	public List<MarketingEventSponsor> findByMEI_MESLI(long marketingEventId,
		long marketingEventSponsorLevelId, int start, int end,
		OrderByComparator<MarketingEventSponsor> orderByComparator) {
		return findByMEI_MESLI(marketingEventId, marketingEventSponsorLevelId,
			start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the marketing event sponsors where marketingEventId = &#63; and marketingEventSponsorLevelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSponsorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param marketingEventId the marketing event ID
	 * @param marketingEventSponsorLevelId the marketing event sponsor level ID
	 * @param start the lower bound of the range of marketing event sponsors
	 * @param end the upper bound of the range of marketing event sponsors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching marketing event sponsors
	 */
	@Override
	public List<MarketingEventSponsor> findByMEI_MESLI(long marketingEventId,
		long marketingEventSponsorLevelId, int start, int end,
		OrderByComparator<MarketingEventSponsor> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEI_MESLI;
			finderArgs = new Object[] {
					marketingEventId, marketingEventSponsorLevelId
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MEI_MESLI;
			finderArgs = new Object[] {
					marketingEventId, marketingEventSponsorLevelId,
					
					start, end, orderByComparator
				};
		}

		List<MarketingEventSponsor> list = null;

		if (retrieveFromCache) {
			list = (List<MarketingEventSponsor>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MarketingEventSponsor marketingEventSponsor : list) {
					if ((marketingEventId != marketingEventSponsor.getMarketingEventId()) ||
							(marketingEventSponsorLevelId != marketingEventSponsor.getMarketingEventSponsorLevelId())) {
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

			query.append(_SQL_SELECT_MARKETINGEVENTSPONSOR_WHERE);

			query.append(_FINDER_COLUMN_MEI_MESLI_MARKETINGEVENTID_2);

			query.append(_FINDER_COLUMN_MEI_MESLI_MARKETINGEVENTSPONSORLEVELID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MarketingEventSponsorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(marketingEventId);

				qPos.add(marketingEventSponsorLevelId);

				if (!pagination) {
					list = (List<MarketingEventSponsor>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MarketingEventSponsor>)QueryUtil.list(q,
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
	 * Returns the first marketing event sponsor in the ordered set where marketingEventId = &#63; and marketingEventSponsorLevelId = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param marketingEventSponsorLevelId the marketing event sponsor level ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching marketing event sponsor
	 * @throws NoSuchMarketingEventSponsorException if a matching marketing event sponsor could not be found
	 */
	@Override
	public MarketingEventSponsor findByMEI_MESLI_First(long marketingEventId,
		long marketingEventSponsorLevelId,
		OrderByComparator<MarketingEventSponsor> orderByComparator)
		throws NoSuchMarketingEventSponsorException {
		MarketingEventSponsor marketingEventSponsor = fetchByMEI_MESLI_First(marketingEventId,
				marketingEventSponsorLevelId, orderByComparator);

		if (marketingEventSponsor != null) {
			return marketingEventSponsor;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("marketingEventId=");
		msg.append(marketingEventId);

		msg.append(", marketingEventSponsorLevelId=");
		msg.append(marketingEventSponsorLevelId);

		msg.append("}");

		throw new NoSuchMarketingEventSponsorException(msg.toString());
	}

	/**
	 * Returns the first marketing event sponsor in the ordered set where marketingEventId = &#63; and marketingEventSponsorLevelId = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param marketingEventSponsorLevelId the marketing event sponsor level ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching marketing event sponsor, or <code>null</code> if a matching marketing event sponsor could not be found
	 */
	@Override
	public MarketingEventSponsor fetchByMEI_MESLI_First(long marketingEventId,
		long marketingEventSponsorLevelId,
		OrderByComparator<MarketingEventSponsor> orderByComparator) {
		List<MarketingEventSponsor> list = findByMEI_MESLI(marketingEventId,
				marketingEventSponsorLevelId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last marketing event sponsor in the ordered set where marketingEventId = &#63; and marketingEventSponsorLevelId = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param marketingEventSponsorLevelId the marketing event sponsor level ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching marketing event sponsor
	 * @throws NoSuchMarketingEventSponsorException if a matching marketing event sponsor could not be found
	 */
	@Override
	public MarketingEventSponsor findByMEI_MESLI_Last(long marketingEventId,
		long marketingEventSponsorLevelId,
		OrderByComparator<MarketingEventSponsor> orderByComparator)
		throws NoSuchMarketingEventSponsorException {
		MarketingEventSponsor marketingEventSponsor = fetchByMEI_MESLI_Last(marketingEventId,
				marketingEventSponsorLevelId, orderByComparator);

		if (marketingEventSponsor != null) {
			return marketingEventSponsor;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("marketingEventId=");
		msg.append(marketingEventId);

		msg.append(", marketingEventSponsorLevelId=");
		msg.append(marketingEventSponsorLevelId);

		msg.append("}");

		throw new NoSuchMarketingEventSponsorException(msg.toString());
	}

	/**
	 * Returns the last marketing event sponsor in the ordered set where marketingEventId = &#63; and marketingEventSponsorLevelId = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param marketingEventSponsorLevelId the marketing event sponsor level ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching marketing event sponsor, or <code>null</code> if a matching marketing event sponsor could not be found
	 */
	@Override
	public MarketingEventSponsor fetchByMEI_MESLI_Last(long marketingEventId,
		long marketingEventSponsorLevelId,
		OrderByComparator<MarketingEventSponsor> orderByComparator) {
		int count = countByMEI_MESLI(marketingEventId,
				marketingEventSponsorLevelId);

		if (count == 0) {
			return null;
		}

		List<MarketingEventSponsor> list = findByMEI_MESLI(marketingEventId,
				marketingEventSponsorLevelId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the marketing event sponsors before and after the current marketing event sponsor in the ordered set where marketingEventId = &#63; and marketingEventSponsorLevelId = &#63;.
	 *
	 * @param marketingEventSponsorId the primary key of the current marketing event sponsor
	 * @param marketingEventId the marketing event ID
	 * @param marketingEventSponsorLevelId the marketing event sponsor level ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next marketing event sponsor
	 * @throws NoSuchMarketingEventSponsorException if a marketing event sponsor with the primary key could not be found
	 */
	@Override
	public MarketingEventSponsor[] findByMEI_MESLI_PrevAndNext(
		long marketingEventSponsorId, long marketingEventId,
		long marketingEventSponsorLevelId,
		OrderByComparator<MarketingEventSponsor> orderByComparator)
		throws NoSuchMarketingEventSponsorException {
		MarketingEventSponsor marketingEventSponsor = findByPrimaryKey(marketingEventSponsorId);

		Session session = null;

		try {
			session = openSession();

			MarketingEventSponsor[] array = new MarketingEventSponsorImpl[3];

			array[0] = getByMEI_MESLI_PrevAndNext(session,
					marketingEventSponsor, marketingEventId,
					marketingEventSponsorLevelId, orderByComparator, true);

			array[1] = marketingEventSponsor;

			array[2] = getByMEI_MESLI_PrevAndNext(session,
					marketingEventSponsor, marketingEventId,
					marketingEventSponsorLevelId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MarketingEventSponsor getByMEI_MESLI_PrevAndNext(
		Session session, MarketingEventSponsor marketingEventSponsor,
		long marketingEventId, long marketingEventSponsorLevelId,
		OrderByComparator<MarketingEventSponsor> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_MARKETINGEVENTSPONSOR_WHERE);

		query.append(_FINDER_COLUMN_MEI_MESLI_MARKETINGEVENTID_2);

		query.append(_FINDER_COLUMN_MEI_MESLI_MARKETINGEVENTSPONSORLEVELID_2);

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
			query.append(MarketingEventSponsorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(marketingEventId);

		qPos.add(marketingEventSponsorLevelId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(marketingEventSponsor);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MarketingEventSponsor> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the marketing event sponsors where marketingEventId = &#63; and marketingEventSponsorLevelId = &#63; from the database.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param marketingEventSponsorLevelId the marketing event sponsor level ID
	 */
	@Override
	public void removeByMEI_MESLI(long marketingEventId,
		long marketingEventSponsorLevelId) {
		for (MarketingEventSponsor marketingEventSponsor : findByMEI_MESLI(
				marketingEventId, marketingEventSponsorLevelId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(marketingEventSponsor);
		}
	}

	/**
	 * Returns the number of marketing event sponsors where marketingEventId = &#63; and marketingEventSponsorLevelId = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param marketingEventSponsorLevelId the marketing event sponsor level ID
	 * @return the number of matching marketing event sponsors
	 */
	@Override
	public int countByMEI_MESLI(long marketingEventId,
		long marketingEventSponsorLevelId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MEI_MESLI;

		Object[] finderArgs = new Object[] {
				marketingEventId, marketingEventSponsorLevelId
			};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MARKETINGEVENTSPONSOR_WHERE);

			query.append(_FINDER_COLUMN_MEI_MESLI_MARKETINGEVENTID_2);

			query.append(_FINDER_COLUMN_MEI_MESLI_MARKETINGEVENTSPONSORLEVELID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(marketingEventId);

				qPos.add(marketingEventSponsorLevelId);

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

	private static final String _FINDER_COLUMN_MEI_MESLI_MARKETINGEVENTID_2 = "marketingEventSponsor.marketingEventId = ? AND ";
	private static final String _FINDER_COLUMN_MEI_MESLI_MARKETINGEVENTSPONSORLEVELID_2 =
		"marketingEventSponsor.marketingEventSponsorLevelId = ?";

	public MarketingEventSponsorPersistenceImpl() {
		setModelClass(MarketingEventSponsor.class);
	}

	/**
	 * Caches the marketing event sponsor in the entity cache if it is enabled.
	 *
	 * @param marketingEventSponsor the marketing event sponsor
	 */
	@Override
	public void cacheResult(MarketingEventSponsor marketingEventSponsor) {
		entityCache.putResult(MarketingEventSponsorModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventSponsorImpl.class,
			marketingEventSponsor.getPrimaryKey(), marketingEventSponsor);

		marketingEventSponsor.resetOriginalValues();
	}

	/**
	 * Caches the marketing event sponsors in the entity cache if it is enabled.
	 *
	 * @param marketingEventSponsors the marketing event sponsors
	 */
	@Override
	public void cacheResult(List<MarketingEventSponsor> marketingEventSponsors) {
		for (MarketingEventSponsor marketingEventSponsor : marketingEventSponsors) {
			if (entityCache.getResult(
						MarketingEventSponsorModelImpl.ENTITY_CACHE_ENABLED,
						MarketingEventSponsorImpl.class,
						marketingEventSponsor.getPrimaryKey()) == null) {
				cacheResult(marketingEventSponsor);
			}
			else {
				marketingEventSponsor.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all marketing event sponsors.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MarketingEventSponsorImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the marketing event sponsor.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MarketingEventSponsor marketingEventSponsor) {
		entityCache.removeResult(MarketingEventSponsorModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventSponsorImpl.class,
			marketingEventSponsor.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<MarketingEventSponsor> marketingEventSponsors) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MarketingEventSponsor marketingEventSponsor : marketingEventSponsors) {
			entityCache.removeResult(MarketingEventSponsorModelImpl.ENTITY_CACHE_ENABLED,
				MarketingEventSponsorImpl.class,
				marketingEventSponsor.getPrimaryKey());
		}
	}

	/**
	 * Creates a new marketing event sponsor with the primary key. Does not add the marketing event sponsor to the database.
	 *
	 * @param marketingEventSponsorId the primary key for the new marketing event sponsor
	 * @return the new marketing event sponsor
	 */
	@Override
	public MarketingEventSponsor create(long marketingEventSponsorId) {
		MarketingEventSponsor marketingEventSponsor = new MarketingEventSponsorImpl();

		marketingEventSponsor.setNew(true);
		marketingEventSponsor.setPrimaryKey(marketingEventSponsorId);

		return marketingEventSponsor;
	}

	/**
	 * Removes the marketing event sponsor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param marketingEventSponsorId the primary key of the marketing event sponsor
	 * @return the marketing event sponsor that was removed
	 * @throws NoSuchMarketingEventSponsorException if a marketing event sponsor with the primary key could not be found
	 */
	@Override
	public MarketingEventSponsor remove(long marketingEventSponsorId)
		throws NoSuchMarketingEventSponsorException {
		return remove((Serializable)marketingEventSponsorId);
	}

	/**
	 * Removes the marketing event sponsor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the marketing event sponsor
	 * @return the marketing event sponsor that was removed
	 * @throws NoSuchMarketingEventSponsorException if a marketing event sponsor with the primary key could not be found
	 */
	@Override
	public MarketingEventSponsor remove(Serializable primaryKey)
		throws NoSuchMarketingEventSponsorException {
		Session session = null;

		try {
			session = openSession();

			MarketingEventSponsor marketingEventSponsor = (MarketingEventSponsor)session.get(MarketingEventSponsorImpl.class,
					primaryKey);

			if (marketingEventSponsor == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMarketingEventSponsorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(marketingEventSponsor);
		}
		catch (NoSuchMarketingEventSponsorException nsee) {
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
	protected MarketingEventSponsor removeImpl(
		MarketingEventSponsor marketingEventSponsor) {
		marketingEventSponsor = toUnwrappedModel(marketingEventSponsor);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(marketingEventSponsor)) {
				marketingEventSponsor = (MarketingEventSponsor)session.get(MarketingEventSponsorImpl.class,
						marketingEventSponsor.getPrimaryKeyObj());
			}

			if (marketingEventSponsor != null) {
				session.delete(marketingEventSponsor);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (marketingEventSponsor != null) {
			clearCache(marketingEventSponsor);
		}

		return marketingEventSponsor;
	}

	@Override
	public MarketingEventSponsor updateImpl(
		MarketingEventSponsor marketingEventSponsor) {
		marketingEventSponsor = toUnwrappedModel(marketingEventSponsor);

		boolean isNew = marketingEventSponsor.isNew();

		MarketingEventSponsorModelImpl marketingEventSponsorModelImpl = (MarketingEventSponsorModelImpl)marketingEventSponsor;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (marketingEventSponsor.getCreateDate() == null)) {
			if (serviceContext == null) {
				marketingEventSponsor.setCreateDate(now);
			}
			else {
				marketingEventSponsor.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!marketingEventSponsorModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				marketingEventSponsor.setModifiedDate(now);
			}
			else {
				marketingEventSponsor.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (marketingEventSponsor.isNew()) {
				session.save(marketingEventSponsor);

				marketingEventSponsor.setNew(false);
			}
			else {
				marketingEventSponsor = (MarketingEventSponsor)session.merge(marketingEventSponsor);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!MarketingEventSponsorModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					marketingEventSponsorModelImpl.getMarketingEventId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_MARKETINGEVENTID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MARKETINGEVENTID,
				args);

			args = new Object[] {
					marketingEventSponsorModelImpl.getMarketingEventId(),
					marketingEventSponsorModelImpl.getMarketingEventSponsorLevelId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_MEI_MESLI, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEI_MESLI,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((marketingEventSponsorModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MARKETINGEVENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						marketingEventSponsorModelImpl.getOriginalMarketingEventId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MARKETINGEVENTID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MARKETINGEVENTID,
					args);

				args = new Object[] {
						marketingEventSponsorModelImpl.getMarketingEventId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MARKETINGEVENTID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MARKETINGEVENTID,
					args);
			}

			if ((marketingEventSponsorModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEI_MESLI.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						marketingEventSponsorModelImpl.getOriginalMarketingEventId(),
						marketingEventSponsorModelImpl.getOriginalMarketingEventSponsorLevelId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MEI_MESLI, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEI_MESLI,
					args);

				args = new Object[] {
						marketingEventSponsorModelImpl.getMarketingEventId(),
						marketingEventSponsorModelImpl.getMarketingEventSponsorLevelId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MEI_MESLI, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEI_MESLI,
					args);
			}
		}

		entityCache.putResult(MarketingEventSponsorModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventSponsorImpl.class,
			marketingEventSponsor.getPrimaryKey(), marketingEventSponsor, false);

		marketingEventSponsor.resetOriginalValues();

		return marketingEventSponsor;
	}

	protected MarketingEventSponsor toUnwrappedModel(
		MarketingEventSponsor marketingEventSponsor) {
		if (marketingEventSponsor instanceof MarketingEventSponsorImpl) {
			return marketingEventSponsor;
		}

		MarketingEventSponsorImpl marketingEventSponsorImpl = new MarketingEventSponsorImpl();

		marketingEventSponsorImpl.setNew(marketingEventSponsor.isNew());
		marketingEventSponsorImpl.setPrimaryKey(marketingEventSponsor.getPrimaryKey());

		marketingEventSponsorImpl.setMarketingEventSponsorId(marketingEventSponsor.getMarketingEventSponsorId());
		marketingEventSponsorImpl.setUserId(marketingEventSponsor.getUserId());
		marketingEventSponsorImpl.setUserName(marketingEventSponsor.getUserName());
		marketingEventSponsorImpl.setCreateDate(marketingEventSponsor.getCreateDate());
		marketingEventSponsorImpl.setModifiedDate(marketingEventSponsor.getModifiedDate());
		marketingEventSponsorImpl.setMarketingEventId(marketingEventSponsor.getMarketingEventId());
		marketingEventSponsorImpl.setMarketingEventSponsorLevelId(marketingEventSponsor.getMarketingEventSponsorLevelId());
		marketingEventSponsorImpl.setName(marketingEventSponsor.getName());
		marketingEventSponsorImpl.setDescription(marketingEventSponsor.getDescription());
		marketingEventSponsorImpl.setImageFileEntryId(marketingEventSponsor.getImageFileEntryId());
		marketingEventSponsorImpl.setUrl(marketingEventSponsor.getUrl());

		return marketingEventSponsorImpl;
	}

	/**
	 * Returns the marketing event sponsor with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the marketing event sponsor
	 * @return the marketing event sponsor
	 * @throws NoSuchMarketingEventSponsorException if a marketing event sponsor with the primary key could not be found
	 */
	@Override
	public MarketingEventSponsor findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMarketingEventSponsorException {
		MarketingEventSponsor marketingEventSponsor = fetchByPrimaryKey(primaryKey);

		if (marketingEventSponsor == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMarketingEventSponsorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return marketingEventSponsor;
	}

	/**
	 * Returns the marketing event sponsor with the primary key or throws a {@link NoSuchMarketingEventSponsorException} if it could not be found.
	 *
	 * @param marketingEventSponsorId the primary key of the marketing event sponsor
	 * @return the marketing event sponsor
	 * @throws NoSuchMarketingEventSponsorException if a marketing event sponsor with the primary key could not be found
	 */
	@Override
	public MarketingEventSponsor findByPrimaryKey(long marketingEventSponsorId)
		throws NoSuchMarketingEventSponsorException {
		return findByPrimaryKey((Serializable)marketingEventSponsorId);
	}

	/**
	 * Returns the marketing event sponsor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the marketing event sponsor
	 * @return the marketing event sponsor, or <code>null</code> if a marketing event sponsor with the primary key could not be found
	 */
	@Override
	public MarketingEventSponsor fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(MarketingEventSponsorModelImpl.ENTITY_CACHE_ENABLED,
				MarketingEventSponsorImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		MarketingEventSponsor marketingEventSponsor = (MarketingEventSponsor)serializable;

		if (marketingEventSponsor == null) {
			Session session = null;

			try {
				session = openSession();

				marketingEventSponsor = (MarketingEventSponsor)session.get(MarketingEventSponsorImpl.class,
						primaryKey);

				if (marketingEventSponsor != null) {
					cacheResult(marketingEventSponsor);
				}
				else {
					entityCache.putResult(MarketingEventSponsorModelImpl.ENTITY_CACHE_ENABLED,
						MarketingEventSponsorImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(MarketingEventSponsorModelImpl.ENTITY_CACHE_ENABLED,
					MarketingEventSponsorImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return marketingEventSponsor;
	}

	/**
	 * Returns the marketing event sponsor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param marketingEventSponsorId the primary key of the marketing event sponsor
	 * @return the marketing event sponsor, or <code>null</code> if a marketing event sponsor with the primary key could not be found
	 */
	@Override
	public MarketingEventSponsor fetchByPrimaryKey(long marketingEventSponsorId) {
		return fetchByPrimaryKey((Serializable)marketingEventSponsorId);
	}

	@Override
	public Map<Serializable, MarketingEventSponsor> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, MarketingEventSponsor> map = new HashMap<Serializable, MarketingEventSponsor>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			MarketingEventSponsor marketingEventSponsor = fetchByPrimaryKey(primaryKey);

			if (marketingEventSponsor != null) {
				map.put(primaryKey, marketingEventSponsor);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(MarketingEventSponsorModelImpl.ENTITY_CACHE_ENABLED,
					MarketingEventSponsorImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (MarketingEventSponsor)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_MARKETINGEVENTSPONSOR_WHERE_PKS_IN);

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

			for (MarketingEventSponsor marketingEventSponsor : (List<MarketingEventSponsor>)q.list()) {
				map.put(marketingEventSponsor.getPrimaryKeyObj(),
					marketingEventSponsor);

				cacheResult(marketingEventSponsor);

				uncachedPrimaryKeys.remove(marketingEventSponsor.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(MarketingEventSponsorModelImpl.ENTITY_CACHE_ENABLED,
					MarketingEventSponsorImpl.class, primaryKey, nullModel);
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
	 * Returns all the marketing event sponsors.
	 *
	 * @return the marketing event sponsors
	 */
	@Override
	public List<MarketingEventSponsor> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the marketing event sponsors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSponsorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of marketing event sponsors
	 * @param end the upper bound of the range of marketing event sponsors (not inclusive)
	 * @return the range of marketing event sponsors
	 */
	@Override
	public List<MarketingEventSponsor> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the marketing event sponsors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSponsorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of marketing event sponsors
	 * @param end the upper bound of the range of marketing event sponsors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of marketing event sponsors
	 */
	@Override
	public List<MarketingEventSponsor> findAll(int start, int end,
		OrderByComparator<MarketingEventSponsor> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the marketing event sponsors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSponsorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of marketing event sponsors
	 * @param end the upper bound of the range of marketing event sponsors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of marketing event sponsors
	 */
	@Override
	public List<MarketingEventSponsor> findAll(int start, int end,
		OrderByComparator<MarketingEventSponsor> orderByComparator,
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

		List<MarketingEventSponsor> list = null;

		if (retrieveFromCache) {
			list = (List<MarketingEventSponsor>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_MARKETINGEVENTSPONSOR);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MARKETINGEVENTSPONSOR;

				if (pagination) {
					sql = sql.concat(MarketingEventSponsorModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<MarketingEventSponsor>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MarketingEventSponsor>)QueryUtil.list(q,
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
	 * Removes all the marketing event sponsors from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (MarketingEventSponsor marketingEventSponsor : findAll()) {
			remove(marketingEventSponsor);
		}
	}

	/**
	 * Returns the number of marketing event sponsors.
	 *
	 * @return the number of marketing event sponsors
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_MARKETINGEVENTSPONSOR);

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
		return MarketingEventSponsorModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the marketing event sponsor persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(MarketingEventSponsorImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_MARKETINGEVENTSPONSOR = "SELECT marketingEventSponsor FROM MarketingEventSponsor marketingEventSponsor";
	private static final String _SQL_SELECT_MARKETINGEVENTSPONSOR_WHERE_PKS_IN = "SELECT marketingEventSponsor FROM MarketingEventSponsor marketingEventSponsor WHERE marketingEventSponsorId IN (";
	private static final String _SQL_SELECT_MARKETINGEVENTSPONSOR_WHERE = "SELECT marketingEventSponsor FROM MarketingEventSponsor marketingEventSponsor WHERE ";
	private static final String _SQL_COUNT_MARKETINGEVENTSPONSOR = "SELECT COUNT(marketingEventSponsor) FROM MarketingEventSponsor marketingEventSponsor";
	private static final String _SQL_COUNT_MARKETINGEVENTSPONSOR_WHERE = "SELECT COUNT(marketingEventSponsor) FROM MarketingEventSponsor marketingEventSponsor WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "marketingEventSponsor.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MarketingEventSponsor exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No MarketingEventSponsor exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(MarketingEventSponsorPersistenceImpl.class);
}