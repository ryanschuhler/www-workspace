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

import com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventAnnouncementException;
import com.liferay.osb.www.marketing.events.model.MarketingEventAnnouncement;
import com.liferay.osb.www.marketing.events.model.impl.MarketingEventAnnouncementImpl;
import com.liferay.osb.www.marketing.events.model.impl.MarketingEventAnnouncementModelImpl;
import com.liferay.osb.www.marketing.events.service.persistence.MarketingEventAnnouncementPersistence;

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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
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
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the marketing event announcement service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEventAnnouncementPersistence
 * @see com.liferay.osb.www.marketing.events.service.persistence.MarketingEventAnnouncementUtil
 * @generated
 */
@ProviderType
public class MarketingEventAnnouncementPersistenceImpl
	extends BasePersistenceImpl<MarketingEventAnnouncement>
	implements MarketingEventAnnouncementPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MarketingEventAnnouncementUtil} to access the marketing event announcement persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MarketingEventAnnouncementImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MarketingEventAnnouncementModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventAnnouncementModelImpl.FINDER_CACHE_ENABLED,
			MarketingEventAnnouncementImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MarketingEventAnnouncementModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventAnnouncementModelImpl.FINDER_CACHE_ENABLED,
			MarketingEventAnnouncementImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MarketingEventAnnouncementModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventAnnouncementModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(MarketingEventAnnouncementModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventAnnouncementModelImpl.FINDER_CACHE_ENABLED,
			MarketingEventAnnouncementImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(MarketingEventAnnouncementModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventAnnouncementModelImpl.FINDER_CACHE_ENABLED,
			MarketingEventAnnouncementImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			MarketingEventAnnouncementModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(MarketingEventAnnouncementModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventAnnouncementModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUuid", new String[] { String.class.getName() });

	/**
	 * Returns all the marketing event announcements where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching marketing event announcements
	 */
	@Override
	public List<MarketingEventAnnouncement> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the marketing event announcements where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventAnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of marketing event announcements
	 * @param end the upper bound of the range of marketing event announcements (not inclusive)
	 * @return the range of matching marketing event announcements
	 */
	@Override
	public List<MarketingEventAnnouncement> findByUuid(String uuid, int start,
		int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the marketing event announcements where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventAnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of marketing event announcements
	 * @param end the upper bound of the range of marketing event announcements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching marketing event announcements
	 */
	@Override
	public List<MarketingEventAnnouncement> findByUuid(String uuid, int start,
		int end, OrderByComparator<MarketingEventAnnouncement> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the marketing event announcements where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventAnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of marketing event announcements
	 * @param end the upper bound of the range of marketing event announcements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching marketing event announcements
	 */
	@Override
	public List<MarketingEventAnnouncement> findByUuid(String uuid, int start,
		int end,
		OrderByComparator<MarketingEventAnnouncement> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<MarketingEventAnnouncement> list = null;

		if (retrieveFromCache) {
			list = (List<MarketingEventAnnouncement>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MarketingEventAnnouncement marketingEventAnnouncement : list) {
					if (!Objects.equals(uuid,
								marketingEventAnnouncement.getUuid())) {
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

			query.append(_SQL_SELECT_MARKETINGEVENTANNOUNCEMENT_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals("")) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MarketingEventAnnouncementModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<MarketingEventAnnouncement>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MarketingEventAnnouncement>)QueryUtil.list(q,
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
	 * Returns the first marketing event announcement in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching marketing event announcement
	 * @throws NoSuchMarketingEventAnnouncementException if a matching marketing event announcement could not be found
	 */
	@Override
	public MarketingEventAnnouncement findByUuid_First(String uuid,
		OrderByComparator<MarketingEventAnnouncement> orderByComparator)
		throws NoSuchMarketingEventAnnouncementException {
		MarketingEventAnnouncement marketingEventAnnouncement = fetchByUuid_First(uuid,
				orderByComparator);

		if (marketingEventAnnouncement != null) {
			return marketingEventAnnouncement;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchMarketingEventAnnouncementException(msg.toString());
	}

	/**
	 * Returns the first marketing event announcement in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching marketing event announcement, or <code>null</code> if a matching marketing event announcement could not be found
	 */
	@Override
	public MarketingEventAnnouncement fetchByUuid_First(String uuid,
		OrderByComparator<MarketingEventAnnouncement> orderByComparator) {
		List<MarketingEventAnnouncement> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last marketing event announcement in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching marketing event announcement
	 * @throws NoSuchMarketingEventAnnouncementException if a matching marketing event announcement could not be found
	 */
	@Override
	public MarketingEventAnnouncement findByUuid_Last(String uuid,
		OrderByComparator<MarketingEventAnnouncement> orderByComparator)
		throws NoSuchMarketingEventAnnouncementException {
		MarketingEventAnnouncement marketingEventAnnouncement = fetchByUuid_Last(uuid,
				orderByComparator);

		if (marketingEventAnnouncement != null) {
			return marketingEventAnnouncement;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchMarketingEventAnnouncementException(msg.toString());
	}

	/**
	 * Returns the last marketing event announcement in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching marketing event announcement, or <code>null</code> if a matching marketing event announcement could not be found
	 */
	@Override
	public MarketingEventAnnouncement fetchByUuid_Last(String uuid,
		OrderByComparator<MarketingEventAnnouncement> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<MarketingEventAnnouncement> list = findByUuid(uuid, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the marketing event announcements before and after the current marketing event announcement in the ordered set where uuid = &#63;.
	 *
	 * @param marketingEventAnnouncementId the primary key of the current marketing event announcement
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next marketing event announcement
	 * @throws NoSuchMarketingEventAnnouncementException if a marketing event announcement with the primary key could not be found
	 */
	@Override
	public MarketingEventAnnouncement[] findByUuid_PrevAndNext(
		long marketingEventAnnouncementId, String uuid,
		OrderByComparator<MarketingEventAnnouncement> orderByComparator)
		throws NoSuchMarketingEventAnnouncementException {
		MarketingEventAnnouncement marketingEventAnnouncement = findByPrimaryKey(marketingEventAnnouncementId);

		Session session = null;

		try {
			session = openSession();

			MarketingEventAnnouncement[] array = new MarketingEventAnnouncementImpl[3];

			array[0] = getByUuid_PrevAndNext(session,
					marketingEventAnnouncement, uuid, orderByComparator, true);

			array[1] = marketingEventAnnouncement;

			array[2] = getByUuid_PrevAndNext(session,
					marketingEventAnnouncement, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MarketingEventAnnouncement getByUuid_PrevAndNext(
		Session session, MarketingEventAnnouncement marketingEventAnnouncement,
		String uuid,
		OrderByComparator<MarketingEventAnnouncement> orderByComparator,
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

		query.append(_SQL_SELECT_MARKETINGEVENTANNOUNCEMENT_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals("")) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
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
			query.append(MarketingEventAnnouncementModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(marketingEventAnnouncement);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MarketingEventAnnouncement> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the marketing event announcements where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (MarketingEventAnnouncement marketingEventAnnouncement : findByUuid(
				uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(marketingEventAnnouncement);
		}
	}

	/**
	 * Returns the number of marketing event announcements where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching marketing event announcements
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MARKETINGEVENTANNOUNCEMENT_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals("")) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "marketingEventAnnouncement.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "marketingEventAnnouncement.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(marketingEventAnnouncement.uuid IS NULL OR marketingEventAnnouncement.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MARKETINGEVENTID =
		new FinderPath(MarketingEventAnnouncementModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventAnnouncementModelImpl.FINDER_CACHE_ENABLED,
			MarketingEventAnnouncementImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMarketingEventId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MARKETINGEVENTID =
		new FinderPath(MarketingEventAnnouncementModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventAnnouncementModelImpl.FINDER_CACHE_ENABLED,
			MarketingEventAnnouncementImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByMarketingEventId", new String[] { Long.class.getName() },
			MarketingEventAnnouncementModelImpl.MARKETINGEVENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MARKETINGEVENTID = new FinderPath(MarketingEventAnnouncementModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventAnnouncementModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByMarketingEventId", new String[] { Long.class.getName() });

	/**
	 * Returns all the marketing event announcements where marketingEventId = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @return the matching marketing event announcements
	 */
	@Override
	public List<MarketingEventAnnouncement> findByMarketingEventId(
		long marketingEventId) {
		return findByMarketingEventId(marketingEventId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the marketing event announcements where marketingEventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventAnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param marketingEventId the marketing event ID
	 * @param start the lower bound of the range of marketing event announcements
	 * @param end the upper bound of the range of marketing event announcements (not inclusive)
	 * @return the range of matching marketing event announcements
	 */
	@Override
	public List<MarketingEventAnnouncement> findByMarketingEventId(
		long marketingEventId, int start, int end) {
		return findByMarketingEventId(marketingEventId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the marketing event announcements where marketingEventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventAnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param marketingEventId the marketing event ID
	 * @param start the lower bound of the range of marketing event announcements
	 * @param end the upper bound of the range of marketing event announcements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching marketing event announcements
	 */
	@Override
	public List<MarketingEventAnnouncement> findByMarketingEventId(
		long marketingEventId, int start, int end,
		OrderByComparator<MarketingEventAnnouncement> orderByComparator) {
		return findByMarketingEventId(marketingEventId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the marketing event announcements where marketingEventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventAnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param marketingEventId the marketing event ID
	 * @param start the lower bound of the range of marketing event announcements
	 * @param end the upper bound of the range of marketing event announcements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching marketing event announcements
	 */
	@Override
	public List<MarketingEventAnnouncement> findByMarketingEventId(
		long marketingEventId, int start, int end,
		OrderByComparator<MarketingEventAnnouncement> orderByComparator,
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

		List<MarketingEventAnnouncement> list = null;

		if (retrieveFromCache) {
			list = (List<MarketingEventAnnouncement>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MarketingEventAnnouncement marketingEventAnnouncement : list) {
					if ((marketingEventId != marketingEventAnnouncement.getMarketingEventId())) {
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

			query.append(_SQL_SELECT_MARKETINGEVENTANNOUNCEMENT_WHERE);

			query.append(_FINDER_COLUMN_MARKETINGEVENTID_MARKETINGEVENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MarketingEventAnnouncementModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(marketingEventId);

				if (!pagination) {
					list = (List<MarketingEventAnnouncement>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MarketingEventAnnouncement>)QueryUtil.list(q,
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
	 * Returns the first marketing event announcement in the ordered set where marketingEventId = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching marketing event announcement
	 * @throws NoSuchMarketingEventAnnouncementException if a matching marketing event announcement could not be found
	 */
	@Override
	public MarketingEventAnnouncement findByMarketingEventId_First(
		long marketingEventId,
		OrderByComparator<MarketingEventAnnouncement> orderByComparator)
		throws NoSuchMarketingEventAnnouncementException {
		MarketingEventAnnouncement marketingEventAnnouncement = fetchByMarketingEventId_First(marketingEventId,
				orderByComparator);

		if (marketingEventAnnouncement != null) {
			return marketingEventAnnouncement;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("marketingEventId=");
		msg.append(marketingEventId);

		msg.append("}");

		throw new NoSuchMarketingEventAnnouncementException(msg.toString());
	}

	/**
	 * Returns the first marketing event announcement in the ordered set where marketingEventId = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching marketing event announcement, or <code>null</code> if a matching marketing event announcement could not be found
	 */
	@Override
	public MarketingEventAnnouncement fetchByMarketingEventId_First(
		long marketingEventId,
		OrderByComparator<MarketingEventAnnouncement> orderByComparator) {
		List<MarketingEventAnnouncement> list = findByMarketingEventId(marketingEventId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last marketing event announcement in the ordered set where marketingEventId = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching marketing event announcement
	 * @throws NoSuchMarketingEventAnnouncementException if a matching marketing event announcement could not be found
	 */
	@Override
	public MarketingEventAnnouncement findByMarketingEventId_Last(
		long marketingEventId,
		OrderByComparator<MarketingEventAnnouncement> orderByComparator)
		throws NoSuchMarketingEventAnnouncementException {
		MarketingEventAnnouncement marketingEventAnnouncement = fetchByMarketingEventId_Last(marketingEventId,
				orderByComparator);

		if (marketingEventAnnouncement != null) {
			return marketingEventAnnouncement;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("marketingEventId=");
		msg.append(marketingEventId);

		msg.append("}");

		throw new NoSuchMarketingEventAnnouncementException(msg.toString());
	}

	/**
	 * Returns the last marketing event announcement in the ordered set where marketingEventId = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching marketing event announcement, or <code>null</code> if a matching marketing event announcement could not be found
	 */
	@Override
	public MarketingEventAnnouncement fetchByMarketingEventId_Last(
		long marketingEventId,
		OrderByComparator<MarketingEventAnnouncement> orderByComparator) {
		int count = countByMarketingEventId(marketingEventId);

		if (count == 0) {
			return null;
		}

		List<MarketingEventAnnouncement> list = findByMarketingEventId(marketingEventId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the marketing event announcements before and after the current marketing event announcement in the ordered set where marketingEventId = &#63;.
	 *
	 * @param marketingEventAnnouncementId the primary key of the current marketing event announcement
	 * @param marketingEventId the marketing event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next marketing event announcement
	 * @throws NoSuchMarketingEventAnnouncementException if a marketing event announcement with the primary key could not be found
	 */
	@Override
	public MarketingEventAnnouncement[] findByMarketingEventId_PrevAndNext(
		long marketingEventAnnouncementId, long marketingEventId,
		OrderByComparator<MarketingEventAnnouncement> orderByComparator)
		throws NoSuchMarketingEventAnnouncementException {
		MarketingEventAnnouncement marketingEventAnnouncement = findByPrimaryKey(marketingEventAnnouncementId);

		Session session = null;

		try {
			session = openSession();

			MarketingEventAnnouncement[] array = new MarketingEventAnnouncementImpl[3];

			array[0] = getByMarketingEventId_PrevAndNext(session,
					marketingEventAnnouncement, marketingEventId,
					orderByComparator, true);

			array[1] = marketingEventAnnouncement;

			array[2] = getByMarketingEventId_PrevAndNext(session,
					marketingEventAnnouncement, marketingEventId,
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

	protected MarketingEventAnnouncement getByMarketingEventId_PrevAndNext(
		Session session, MarketingEventAnnouncement marketingEventAnnouncement,
		long marketingEventId,
		OrderByComparator<MarketingEventAnnouncement> orderByComparator,
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

		query.append(_SQL_SELECT_MARKETINGEVENTANNOUNCEMENT_WHERE);

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
			query.append(MarketingEventAnnouncementModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(marketingEventId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(marketingEventAnnouncement);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MarketingEventAnnouncement> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the marketing event announcements where marketingEventId = &#63; from the database.
	 *
	 * @param marketingEventId the marketing event ID
	 */
	@Override
	public void removeByMarketingEventId(long marketingEventId) {
		for (MarketingEventAnnouncement marketingEventAnnouncement : findByMarketingEventId(
				marketingEventId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(marketingEventAnnouncement);
		}
	}

	/**
	 * Returns the number of marketing event announcements where marketingEventId = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @return the number of matching marketing event announcements
	 */
	@Override
	public int countByMarketingEventId(long marketingEventId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MARKETINGEVENTID;

		Object[] finderArgs = new Object[] { marketingEventId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MARKETINGEVENTANNOUNCEMENT_WHERE);

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
		"marketingEventAnnouncement.marketingEventId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MEI_LTDD_S =
		new FinderPath(MarketingEventAnnouncementModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventAnnouncementModelImpl.FINDER_CACHE_ENABLED,
			MarketingEventAnnouncementImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMEI_LtDD_S",
			new String[] {
				Long.class.getName(), Date.class.getName(),
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_MEI_LTDD_S =
		new FinderPath(MarketingEventAnnouncementModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventAnnouncementModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"countByMEI_LtDD_S",
			new String[] {
				Long.class.getName(), Date.class.getName(),
				Integer.class.getName()
			});

	/**
	 * Returns all the marketing event announcements where marketingEventId = &#63; and displayDate &lt; &#63; and status = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param displayDate the display date
	 * @param status the status
	 * @return the matching marketing event announcements
	 */
	@Override
	public List<MarketingEventAnnouncement> findByMEI_LtDD_S(
		long marketingEventId, Date displayDate, int status) {
		return findByMEI_LtDD_S(marketingEventId, displayDate, status,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the marketing event announcements where marketingEventId = &#63; and displayDate &lt; &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventAnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param marketingEventId the marketing event ID
	 * @param displayDate the display date
	 * @param status the status
	 * @param start the lower bound of the range of marketing event announcements
	 * @param end the upper bound of the range of marketing event announcements (not inclusive)
	 * @return the range of matching marketing event announcements
	 */
	@Override
	public List<MarketingEventAnnouncement> findByMEI_LtDD_S(
		long marketingEventId, Date displayDate, int status, int start, int end) {
		return findByMEI_LtDD_S(marketingEventId, displayDate, status, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the marketing event announcements where marketingEventId = &#63; and displayDate &lt; &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventAnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param marketingEventId the marketing event ID
	 * @param displayDate the display date
	 * @param status the status
	 * @param start the lower bound of the range of marketing event announcements
	 * @param end the upper bound of the range of marketing event announcements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching marketing event announcements
	 */
	@Override
	public List<MarketingEventAnnouncement> findByMEI_LtDD_S(
		long marketingEventId, Date displayDate, int status, int start,
		int end, OrderByComparator<MarketingEventAnnouncement> orderByComparator) {
		return findByMEI_LtDD_S(marketingEventId, displayDate, status, start,
			end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the marketing event announcements where marketingEventId = &#63; and displayDate &lt; &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventAnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param marketingEventId the marketing event ID
	 * @param displayDate the display date
	 * @param status the status
	 * @param start the lower bound of the range of marketing event announcements
	 * @param end the upper bound of the range of marketing event announcements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching marketing event announcements
	 */
	@Override
	public List<MarketingEventAnnouncement> findByMEI_LtDD_S(
		long marketingEventId, Date displayDate, int status, int start,
		int end,
		OrderByComparator<MarketingEventAnnouncement> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MEI_LTDD_S;
		finderArgs = new Object[] {
				marketingEventId, displayDate, status,
				
				start, end, orderByComparator
			};

		List<MarketingEventAnnouncement> list = null;

		if (retrieveFromCache) {
			list = (List<MarketingEventAnnouncement>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MarketingEventAnnouncement marketingEventAnnouncement : list) {
					if ((marketingEventId != marketingEventAnnouncement.getMarketingEventId()) ||
							(displayDate.getTime() <= marketingEventAnnouncement.getDisplayDate()
																					.getTime()) ||
							(status != marketingEventAnnouncement.getStatus())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_MARKETINGEVENTANNOUNCEMENT_WHERE);

			query.append(_FINDER_COLUMN_MEI_LTDD_S_MARKETINGEVENTID_2);

			boolean bindDisplayDate = false;

			if (displayDate == null) {
				query.append(_FINDER_COLUMN_MEI_LTDD_S_DISPLAYDATE_1);
			}
			else {
				bindDisplayDate = true;

				query.append(_FINDER_COLUMN_MEI_LTDD_S_DISPLAYDATE_2);
			}

			query.append(_FINDER_COLUMN_MEI_LTDD_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MarketingEventAnnouncementModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(marketingEventId);

				if (bindDisplayDate) {
					qPos.add(new Timestamp(displayDate.getTime()));
				}

				qPos.add(status);

				if (!pagination) {
					list = (List<MarketingEventAnnouncement>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MarketingEventAnnouncement>)QueryUtil.list(q,
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
	 * Returns the first marketing event announcement in the ordered set where marketingEventId = &#63; and displayDate &lt; &#63; and status = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param displayDate the display date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching marketing event announcement
	 * @throws NoSuchMarketingEventAnnouncementException if a matching marketing event announcement could not be found
	 */
	@Override
	public MarketingEventAnnouncement findByMEI_LtDD_S_First(
		long marketingEventId, Date displayDate, int status,
		OrderByComparator<MarketingEventAnnouncement> orderByComparator)
		throws NoSuchMarketingEventAnnouncementException {
		MarketingEventAnnouncement marketingEventAnnouncement = fetchByMEI_LtDD_S_First(marketingEventId,
				displayDate, status, orderByComparator);

		if (marketingEventAnnouncement != null) {
			return marketingEventAnnouncement;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("marketingEventId=");
		msg.append(marketingEventId);

		msg.append(", displayDate=");
		msg.append(displayDate);

		msg.append(", status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchMarketingEventAnnouncementException(msg.toString());
	}

	/**
	 * Returns the first marketing event announcement in the ordered set where marketingEventId = &#63; and displayDate &lt; &#63; and status = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param displayDate the display date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching marketing event announcement, or <code>null</code> if a matching marketing event announcement could not be found
	 */
	@Override
	public MarketingEventAnnouncement fetchByMEI_LtDD_S_First(
		long marketingEventId, Date displayDate, int status,
		OrderByComparator<MarketingEventAnnouncement> orderByComparator) {
		List<MarketingEventAnnouncement> list = findByMEI_LtDD_S(marketingEventId,
				displayDate, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last marketing event announcement in the ordered set where marketingEventId = &#63; and displayDate &lt; &#63; and status = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param displayDate the display date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching marketing event announcement
	 * @throws NoSuchMarketingEventAnnouncementException if a matching marketing event announcement could not be found
	 */
	@Override
	public MarketingEventAnnouncement findByMEI_LtDD_S_Last(
		long marketingEventId, Date displayDate, int status,
		OrderByComparator<MarketingEventAnnouncement> orderByComparator)
		throws NoSuchMarketingEventAnnouncementException {
		MarketingEventAnnouncement marketingEventAnnouncement = fetchByMEI_LtDD_S_Last(marketingEventId,
				displayDate, status, orderByComparator);

		if (marketingEventAnnouncement != null) {
			return marketingEventAnnouncement;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("marketingEventId=");
		msg.append(marketingEventId);

		msg.append(", displayDate=");
		msg.append(displayDate);

		msg.append(", status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchMarketingEventAnnouncementException(msg.toString());
	}

	/**
	 * Returns the last marketing event announcement in the ordered set where marketingEventId = &#63; and displayDate &lt; &#63; and status = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param displayDate the display date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching marketing event announcement, or <code>null</code> if a matching marketing event announcement could not be found
	 */
	@Override
	public MarketingEventAnnouncement fetchByMEI_LtDD_S_Last(
		long marketingEventId, Date displayDate, int status,
		OrderByComparator<MarketingEventAnnouncement> orderByComparator) {
		int count = countByMEI_LtDD_S(marketingEventId, displayDate, status);

		if (count == 0) {
			return null;
		}

		List<MarketingEventAnnouncement> list = findByMEI_LtDD_S(marketingEventId,
				displayDate, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the marketing event announcements before and after the current marketing event announcement in the ordered set where marketingEventId = &#63; and displayDate &lt; &#63; and status = &#63;.
	 *
	 * @param marketingEventAnnouncementId the primary key of the current marketing event announcement
	 * @param marketingEventId the marketing event ID
	 * @param displayDate the display date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next marketing event announcement
	 * @throws NoSuchMarketingEventAnnouncementException if a marketing event announcement with the primary key could not be found
	 */
	@Override
	public MarketingEventAnnouncement[] findByMEI_LtDD_S_PrevAndNext(
		long marketingEventAnnouncementId, long marketingEventId,
		Date displayDate, int status,
		OrderByComparator<MarketingEventAnnouncement> orderByComparator)
		throws NoSuchMarketingEventAnnouncementException {
		MarketingEventAnnouncement marketingEventAnnouncement = findByPrimaryKey(marketingEventAnnouncementId);

		Session session = null;

		try {
			session = openSession();

			MarketingEventAnnouncement[] array = new MarketingEventAnnouncementImpl[3];

			array[0] = getByMEI_LtDD_S_PrevAndNext(session,
					marketingEventAnnouncement, marketingEventId, displayDate,
					status, orderByComparator, true);

			array[1] = marketingEventAnnouncement;

			array[2] = getByMEI_LtDD_S_PrevAndNext(session,
					marketingEventAnnouncement, marketingEventId, displayDate,
					status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MarketingEventAnnouncement getByMEI_LtDD_S_PrevAndNext(
		Session session, MarketingEventAnnouncement marketingEventAnnouncement,
		long marketingEventId, Date displayDate, int status,
		OrderByComparator<MarketingEventAnnouncement> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_MARKETINGEVENTANNOUNCEMENT_WHERE);

		query.append(_FINDER_COLUMN_MEI_LTDD_S_MARKETINGEVENTID_2);

		boolean bindDisplayDate = false;

		if (displayDate == null) {
			query.append(_FINDER_COLUMN_MEI_LTDD_S_DISPLAYDATE_1);
		}
		else {
			bindDisplayDate = true;

			query.append(_FINDER_COLUMN_MEI_LTDD_S_DISPLAYDATE_2);
		}

		query.append(_FINDER_COLUMN_MEI_LTDD_S_STATUS_2);

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
			query.append(MarketingEventAnnouncementModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(marketingEventId);

		if (bindDisplayDate) {
			qPos.add(new Timestamp(displayDate.getTime()));
		}

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(marketingEventAnnouncement);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MarketingEventAnnouncement> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the marketing event announcements where marketingEventId = &#63; and displayDate &lt; &#63; and status = &#63; from the database.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param displayDate the display date
	 * @param status the status
	 */
	@Override
	public void removeByMEI_LtDD_S(long marketingEventId, Date displayDate,
		int status) {
		for (MarketingEventAnnouncement marketingEventAnnouncement : findByMEI_LtDD_S(
				marketingEventId, displayDate, status, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(marketingEventAnnouncement);
		}
	}

	/**
	 * Returns the number of marketing event announcements where marketingEventId = &#63; and displayDate &lt; &#63; and status = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param displayDate the display date
	 * @param status the status
	 * @return the number of matching marketing event announcements
	 */
	@Override
	public int countByMEI_LtDD_S(long marketingEventId, Date displayDate,
		int status) {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_MEI_LTDD_S;

		Object[] finderArgs = new Object[] { marketingEventId, displayDate, status };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_MARKETINGEVENTANNOUNCEMENT_WHERE);

			query.append(_FINDER_COLUMN_MEI_LTDD_S_MARKETINGEVENTID_2);

			boolean bindDisplayDate = false;

			if (displayDate == null) {
				query.append(_FINDER_COLUMN_MEI_LTDD_S_DISPLAYDATE_1);
			}
			else {
				bindDisplayDate = true;

				query.append(_FINDER_COLUMN_MEI_LTDD_S_DISPLAYDATE_2);
			}

			query.append(_FINDER_COLUMN_MEI_LTDD_S_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(marketingEventId);

				if (bindDisplayDate) {
					qPos.add(new Timestamp(displayDate.getTime()));
				}

				qPos.add(status);

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

	private static final String _FINDER_COLUMN_MEI_LTDD_S_MARKETINGEVENTID_2 = "marketingEventAnnouncement.marketingEventId = ? AND ";
	private static final String _FINDER_COLUMN_MEI_LTDD_S_DISPLAYDATE_1 = "marketingEventAnnouncement.displayDate IS NULL AND ";
	private static final String _FINDER_COLUMN_MEI_LTDD_S_DISPLAYDATE_2 = "marketingEventAnnouncement.displayDate < ? AND ";
	private static final String _FINDER_COLUMN_MEI_LTDD_S_STATUS_2 = "marketingEventAnnouncement.status = ?";

	public MarketingEventAnnouncementPersistenceImpl() {
		setModelClass(MarketingEventAnnouncement.class);

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
					"_dbColumnNames");

			field.setAccessible(true);

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("uuid", "uuid_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the marketing event announcement in the entity cache if it is enabled.
	 *
	 * @param marketingEventAnnouncement the marketing event announcement
	 */
	@Override
	public void cacheResult(
		MarketingEventAnnouncement marketingEventAnnouncement) {
		entityCache.putResult(MarketingEventAnnouncementModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventAnnouncementImpl.class,
			marketingEventAnnouncement.getPrimaryKey(),
			marketingEventAnnouncement);

		marketingEventAnnouncement.resetOriginalValues();
	}

	/**
	 * Caches the marketing event announcements in the entity cache if it is enabled.
	 *
	 * @param marketingEventAnnouncements the marketing event announcements
	 */
	@Override
	public void cacheResult(
		List<MarketingEventAnnouncement> marketingEventAnnouncements) {
		for (MarketingEventAnnouncement marketingEventAnnouncement : marketingEventAnnouncements) {
			if (entityCache.getResult(
						MarketingEventAnnouncementModelImpl.ENTITY_CACHE_ENABLED,
						MarketingEventAnnouncementImpl.class,
						marketingEventAnnouncement.getPrimaryKey()) == null) {
				cacheResult(marketingEventAnnouncement);
			}
			else {
				marketingEventAnnouncement.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all marketing event announcements.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MarketingEventAnnouncementImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the marketing event announcement.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		MarketingEventAnnouncement marketingEventAnnouncement) {
		entityCache.removeResult(MarketingEventAnnouncementModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventAnnouncementImpl.class,
			marketingEventAnnouncement.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<MarketingEventAnnouncement> marketingEventAnnouncements) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MarketingEventAnnouncement marketingEventAnnouncement : marketingEventAnnouncements) {
			entityCache.removeResult(MarketingEventAnnouncementModelImpl.ENTITY_CACHE_ENABLED,
				MarketingEventAnnouncementImpl.class,
				marketingEventAnnouncement.getPrimaryKey());
		}
	}

	/**
	 * Creates a new marketing event announcement with the primary key. Does not add the marketing event announcement to the database.
	 *
	 * @param marketingEventAnnouncementId the primary key for the new marketing event announcement
	 * @return the new marketing event announcement
	 */
	@Override
	public MarketingEventAnnouncement create(long marketingEventAnnouncementId) {
		MarketingEventAnnouncement marketingEventAnnouncement = new MarketingEventAnnouncementImpl();

		marketingEventAnnouncement.setNew(true);
		marketingEventAnnouncement.setPrimaryKey(marketingEventAnnouncementId);

		String uuid = PortalUUIDUtil.generate();

		marketingEventAnnouncement.setUuid(uuid);

		return marketingEventAnnouncement;
	}

	/**
	 * Removes the marketing event announcement with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param marketingEventAnnouncementId the primary key of the marketing event announcement
	 * @return the marketing event announcement that was removed
	 * @throws NoSuchMarketingEventAnnouncementException if a marketing event announcement with the primary key could not be found
	 */
	@Override
	public MarketingEventAnnouncement remove(long marketingEventAnnouncementId)
		throws NoSuchMarketingEventAnnouncementException {
		return remove((Serializable)marketingEventAnnouncementId);
	}

	/**
	 * Removes the marketing event announcement with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the marketing event announcement
	 * @return the marketing event announcement that was removed
	 * @throws NoSuchMarketingEventAnnouncementException if a marketing event announcement with the primary key could not be found
	 */
	@Override
	public MarketingEventAnnouncement remove(Serializable primaryKey)
		throws NoSuchMarketingEventAnnouncementException {
		Session session = null;

		try {
			session = openSession();

			MarketingEventAnnouncement marketingEventAnnouncement = (MarketingEventAnnouncement)session.get(MarketingEventAnnouncementImpl.class,
					primaryKey);

			if (marketingEventAnnouncement == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMarketingEventAnnouncementException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(marketingEventAnnouncement);
		}
		catch (NoSuchMarketingEventAnnouncementException nsee) {
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
	protected MarketingEventAnnouncement removeImpl(
		MarketingEventAnnouncement marketingEventAnnouncement) {
		marketingEventAnnouncement = toUnwrappedModel(marketingEventAnnouncement);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(marketingEventAnnouncement)) {
				marketingEventAnnouncement = (MarketingEventAnnouncement)session.get(MarketingEventAnnouncementImpl.class,
						marketingEventAnnouncement.getPrimaryKeyObj());
			}

			if (marketingEventAnnouncement != null) {
				session.delete(marketingEventAnnouncement);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (marketingEventAnnouncement != null) {
			clearCache(marketingEventAnnouncement);
		}

		return marketingEventAnnouncement;
	}

	@Override
	public MarketingEventAnnouncement updateImpl(
		MarketingEventAnnouncement marketingEventAnnouncement) {
		marketingEventAnnouncement = toUnwrappedModel(marketingEventAnnouncement);

		boolean isNew = marketingEventAnnouncement.isNew();

		MarketingEventAnnouncementModelImpl marketingEventAnnouncementModelImpl = (MarketingEventAnnouncementModelImpl)marketingEventAnnouncement;

		if (Validator.isNull(marketingEventAnnouncement.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			marketingEventAnnouncement.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (marketingEventAnnouncement.getCreateDate() == null)) {
			if (serviceContext == null) {
				marketingEventAnnouncement.setCreateDate(now);
			}
			else {
				marketingEventAnnouncement.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!marketingEventAnnouncementModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				marketingEventAnnouncement.setModifiedDate(now);
			}
			else {
				marketingEventAnnouncement.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (marketingEventAnnouncement.isNew()) {
				session.save(marketingEventAnnouncement);

				marketingEventAnnouncement.setNew(false);
			}
			else {
				marketingEventAnnouncement = (MarketingEventAnnouncement)session.merge(marketingEventAnnouncement);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!MarketingEventAnnouncementModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					marketingEventAnnouncementModelImpl.getUuid()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] {
					marketingEventAnnouncementModelImpl.getMarketingEventId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_MARKETINGEVENTID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MARKETINGEVENTID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((marketingEventAnnouncementModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						marketingEventAnnouncementModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] {
						marketingEventAnnouncementModelImpl.getUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((marketingEventAnnouncementModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MARKETINGEVENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						marketingEventAnnouncementModelImpl.getOriginalMarketingEventId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MARKETINGEVENTID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MARKETINGEVENTID,
					args);

				args = new Object[] {
						marketingEventAnnouncementModelImpl.getMarketingEventId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MARKETINGEVENTID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MARKETINGEVENTID,
					args);
			}
		}

		entityCache.putResult(MarketingEventAnnouncementModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventAnnouncementImpl.class,
			marketingEventAnnouncement.getPrimaryKey(),
			marketingEventAnnouncement, false);

		marketingEventAnnouncement.resetOriginalValues();

		return marketingEventAnnouncement;
	}

	protected MarketingEventAnnouncement toUnwrappedModel(
		MarketingEventAnnouncement marketingEventAnnouncement) {
		if (marketingEventAnnouncement instanceof MarketingEventAnnouncementImpl) {
			return marketingEventAnnouncement;
		}

		MarketingEventAnnouncementImpl marketingEventAnnouncementImpl = new MarketingEventAnnouncementImpl();

		marketingEventAnnouncementImpl.setNew(marketingEventAnnouncement.isNew());
		marketingEventAnnouncementImpl.setPrimaryKey(marketingEventAnnouncement.getPrimaryKey());

		marketingEventAnnouncementImpl.setUuid(marketingEventAnnouncement.getUuid());
		marketingEventAnnouncementImpl.setMarketingEventAnnouncementId(marketingEventAnnouncement.getMarketingEventAnnouncementId());
		marketingEventAnnouncementImpl.setUserId(marketingEventAnnouncement.getUserId());
		marketingEventAnnouncementImpl.setUserName(marketingEventAnnouncement.getUserName());
		marketingEventAnnouncementImpl.setCreateDate(marketingEventAnnouncement.getCreateDate());
		marketingEventAnnouncementImpl.setModifiedDate(marketingEventAnnouncement.getModifiedDate());
		marketingEventAnnouncementImpl.setMarketingEventId(marketingEventAnnouncement.getMarketingEventId());
		marketingEventAnnouncementImpl.setTitle(marketingEventAnnouncement.getTitle());
		marketingEventAnnouncementImpl.setMessage(marketingEventAnnouncement.getMessage());
		marketingEventAnnouncementImpl.setSummary(marketingEventAnnouncement.getSummary());
		marketingEventAnnouncementImpl.setImageFileEntryId(marketingEventAnnouncement.getImageFileEntryId());
		marketingEventAnnouncementImpl.setLinkURL(marketingEventAnnouncement.getLinkURL());
		marketingEventAnnouncementImpl.setLinkLabel(marketingEventAnnouncement.getLinkLabel());
		marketingEventAnnouncementImpl.setDisplayDate(marketingEventAnnouncement.getDisplayDate());
		marketingEventAnnouncementImpl.setStatus(marketingEventAnnouncement.getStatus());
		marketingEventAnnouncementImpl.setStatusByUserId(marketingEventAnnouncement.getStatusByUserId());
		marketingEventAnnouncementImpl.setStatusByUserName(marketingEventAnnouncement.getStatusByUserName());
		marketingEventAnnouncementImpl.setStatusDate(marketingEventAnnouncement.getStatusDate());

		return marketingEventAnnouncementImpl;
	}

	/**
	 * Returns the marketing event announcement with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the marketing event announcement
	 * @return the marketing event announcement
	 * @throws NoSuchMarketingEventAnnouncementException if a marketing event announcement with the primary key could not be found
	 */
	@Override
	public MarketingEventAnnouncement findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMarketingEventAnnouncementException {
		MarketingEventAnnouncement marketingEventAnnouncement = fetchByPrimaryKey(primaryKey);

		if (marketingEventAnnouncement == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMarketingEventAnnouncementException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return marketingEventAnnouncement;
	}

	/**
	 * Returns the marketing event announcement with the primary key or throws a {@link NoSuchMarketingEventAnnouncementException} if it could not be found.
	 *
	 * @param marketingEventAnnouncementId the primary key of the marketing event announcement
	 * @return the marketing event announcement
	 * @throws NoSuchMarketingEventAnnouncementException if a marketing event announcement with the primary key could not be found
	 */
	@Override
	public MarketingEventAnnouncement findByPrimaryKey(
		long marketingEventAnnouncementId)
		throws NoSuchMarketingEventAnnouncementException {
		return findByPrimaryKey((Serializable)marketingEventAnnouncementId);
	}

	/**
	 * Returns the marketing event announcement with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the marketing event announcement
	 * @return the marketing event announcement, or <code>null</code> if a marketing event announcement with the primary key could not be found
	 */
	@Override
	public MarketingEventAnnouncement fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(MarketingEventAnnouncementModelImpl.ENTITY_CACHE_ENABLED,
				MarketingEventAnnouncementImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		MarketingEventAnnouncement marketingEventAnnouncement = (MarketingEventAnnouncement)serializable;

		if (marketingEventAnnouncement == null) {
			Session session = null;

			try {
				session = openSession();

				marketingEventAnnouncement = (MarketingEventAnnouncement)session.get(MarketingEventAnnouncementImpl.class,
						primaryKey);

				if (marketingEventAnnouncement != null) {
					cacheResult(marketingEventAnnouncement);
				}
				else {
					entityCache.putResult(MarketingEventAnnouncementModelImpl.ENTITY_CACHE_ENABLED,
						MarketingEventAnnouncementImpl.class, primaryKey,
						nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(MarketingEventAnnouncementModelImpl.ENTITY_CACHE_ENABLED,
					MarketingEventAnnouncementImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return marketingEventAnnouncement;
	}

	/**
	 * Returns the marketing event announcement with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param marketingEventAnnouncementId the primary key of the marketing event announcement
	 * @return the marketing event announcement, or <code>null</code> if a marketing event announcement with the primary key could not be found
	 */
	@Override
	public MarketingEventAnnouncement fetchByPrimaryKey(
		long marketingEventAnnouncementId) {
		return fetchByPrimaryKey((Serializable)marketingEventAnnouncementId);
	}

	@Override
	public Map<Serializable, MarketingEventAnnouncement> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, MarketingEventAnnouncement> map = new HashMap<Serializable, MarketingEventAnnouncement>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			MarketingEventAnnouncement marketingEventAnnouncement = fetchByPrimaryKey(primaryKey);

			if (marketingEventAnnouncement != null) {
				map.put(primaryKey, marketingEventAnnouncement);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(MarketingEventAnnouncementModelImpl.ENTITY_CACHE_ENABLED,
					MarketingEventAnnouncementImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (MarketingEventAnnouncement)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_MARKETINGEVENTANNOUNCEMENT_WHERE_PKS_IN);

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

			for (MarketingEventAnnouncement marketingEventAnnouncement : (List<MarketingEventAnnouncement>)q.list()) {
				map.put(marketingEventAnnouncement.getPrimaryKeyObj(),
					marketingEventAnnouncement);

				cacheResult(marketingEventAnnouncement);

				uncachedPrimaryKeys.remove(marketingEventAnnouncement.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(MarketingEventAnnouncementModelImpl.ENTITY_CACHE_ENABLED,
					MarketingEventAnnouncementImpl.class, primaryKey, nullModel);
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
	 * Returns all the marketing event announcements.
	 *
	 * @return the marketing event announcements
	 */
	@Override
	public List<MarketingEventAnnouncement> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the marketing event announcements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventAnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of marketing event announcements
	 * @param end the upper bound of the range of marketing event announcements (not inclusive)
	 * @return the range of marketing event announcements
	 */
	@Override
	public List<MarketingEventAnnouncement> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the marketing event announcements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventAnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of marketing event announcements
	 * @param end the upper bound of the range of marketing event announcements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of marketing event announcements
	 */
	@Override
	public List<MarketingEventAnnouncement> findAll(int start, int end,
		OrderByComparator<MarketingEventAnnouncement> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the marketing event announcements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventAnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of marketing event announcements
	 * @param end the upper bound of the range of marketing event announcements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of marketing event announcements
	 */
	@Override
	public List<MarketingEventAnnouncement> findAll(int start, int end,
		OrderByComparator<MarketingEventAnnouncement> orderByComparator,
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

		List<MarketingEventAnnouncement> list = null;

		if (retrieveFromCache) {
			list = (List<MarketingEventAnnouncement>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_MARKETINGEVENTANNOUNCEMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MARKETINGEVENTANNOUNCEMENT;

				if (pagination) {
					sql = sql.concat(MarketingEventAnnouncementModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<MarketingEventAnnouncement>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MarketingEventAnnouncement>)QueryUtil.list(q,
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
	 * Removes all the marketing event announcements from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (MarketingEventAnnouncement marketingEventAnnouncement : findAll()) {
			remove(marketingEventAnnouncement);
		}
	}

	/**
	 * Returns the number of marketing event announcements.
	 *
	 * @return the number of marketing event announcements
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_MARKETINGEVENTANNOUNCEMENT);

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
		return MarketingEventAnnouncementModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the marketing event announcement persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(MarketingEventAnnouncementImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_MARKETINGEVENTANNOUNCEMENT = "SELECT marketingEventAnnouncement FROM MarketingEventAnnouncement marketingEventAnnouncement";
	private static final String _SQL_SELECT_MARKETINGEVENTANNOUNCEMENT_WHERE_PKS_IN =
		"SELECT marketingEventAnnouncement FROM MarketingEventAnnouncement marketingEventAnnouncement WHERE marketingEventAnnouncementId IN (";
	private static final String _SQL_SELECT_MARKETINGEVENTANNOUNCEMENT_WHERE = "SELECT marketingEventAnnouncement FROM MarketingEventAnnouncement marketingEventAnnouncement WHERE ";
	private static final String _SQL_COUNT_MARKETINGEVENTANNOUNCEMENT = "SELECT COUNT(marketingEventAnnouncement) FROM MarketingEventAnnouncement marketingEventAnnouncement";
	private static final String _SQL_COUNT_MARKETINGEVENTANNOUNCEMENT_WHERE = "SELECT COUNT(marketingEventAnnouncement) FROM MarketingEventAnnouncement marketingEventAnnouncement WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "marketingEventAnnouncement.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MarketingEventAnnouncement exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No MarketingEventAnnouncement exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(MarketingEventAnnouncementPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}