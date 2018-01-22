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

import com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventSessionException;
import com.liferay.osb.www.marketing.events.model.MarketingEventSession;
import com.liferay.osb.www.marketing.events.model.impl.MarketingEventSessionImpl;
import com.liferay.osb.www.marketing.events.model.impl.MarketingEventSessionModelImpl;
import com.liferay.osb.www.marketing.events.service.persistence.MarketingEventSessionPersistence;
import com.liferay.osb.www.marketing.events.service.persistence.MarketingEventUserPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
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
import com.liferay.portal.kernel.service.persistence.impl.TableMapper;
import com.liferay.portal.kernel.service.persistence.impl.TableMapperFactory;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReflectionUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.Field;

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
 * The persistence implementation for the marketing event session service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEventSessionPersistence
 * @see com.liferay.osb.www.marketing.events.service.persistence.MarketingEventSessionUtil
 * @generated
 */
@ProviderType
public class MarketingEventSessionPersistenceImpl extends BasePersistenceImpl<MarketingEventSession>
	implements MarketingEventSessionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MarketingEventSessionUtil} to access the marketing event session persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MarketingEventSessionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MarketingEventSessionModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventSessionModelImpl.FINDER_CACHE_ENABLED,
			MarketingEventSessionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MarketingEventSessionModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventSessionModelImpl.FINDER_CACHE_ENABLED,
			MarketingEventSessionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MarketingEventSessionModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventSessionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(MarketingEventSessionModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventSessionModelImpl.FINDER_CACHE_ENABLED,
			MarketingEventSessionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(MarketingEventSessionModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventSessionModelImpl.FINDER_CACHE_ENABLED,
			MarketingEventSessionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			MarketingEventSessionModelImpl.UUID_COLUMN_BITMASK |
			MarketingEventSessionModelImpl.STARTDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(MarketingEventSessionModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventSessionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the marketing event sessions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching marketing event sessions
	 */
	@Override
	public List<MarketingEventSession> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the marketing event sessions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of marketing event sessions
	 * @param end the upper bound of the range of marketing event sessions (not inclusive)
	 * @return the range of matching marketing event sessions
	 */
	@Override
	public List<MarketingEventSession> findByUuid(String uuid, int start,
		int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the marketing event sessions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of marketing event sessions
	 * @param end the upper bound of the range of marketing event sessions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching marketing event sessions
	 */
	@Override
	public List<MarketingEventSession> findByUuid(String uuid, int start,
		int end, OrderByComparator<MarketingEventSession> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the marketing event sessions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of marketing event sessions
	 * @param end the upper bound of the range of marketing event sessions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching marketing event sessions
	 */
	@Override
	public List<MarketingEventSession> findByUuid(String uuid, int start,
		int end, OrderByComparator<MarketingEventSession> orderByComparator,
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

		List<MarketingEventSession> list = null;

		if (retrieveFromCache) {
			list = (List<MarketingEventSession>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MarketingEventSession marketingEventSession : list) {
					if (!Objects.equals(uuid, marketingEventSession.getUuid())) {
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

			query.append(_SQL_SELECT_MARKETINGEVENTSESSION_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
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
				query.append(MarketingEventSessionModelImpl.ORDER_BY_JPQL);
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
					list = (List<MarketingEventSession>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MarketingEventSession>)QueryUtil.list(q,
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
	 * Returns the first marketing event session in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching marketing event session
	 * @throws NoSuchMarketingEventSessionException if a matching marketing event session could not be found
	 */
	@Override
	public MarketingEventSession findByUuid_First(String uuid,
		OrderByComparator<MarketingEventSession> orderByComparator)
		throws NoSuchMarketingEventSessionException {
		MarketingEventSession marketingEventSession = fetchByUuid_First(uuid,
				orderByComparator);

		if (marketingEventSession != null) {
			return marketingEventSession;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMarketingEventSessionException(msg.toString());
	}

	/**
	 * Returns the first marketing event session in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching marketing event session, or <code>null</code> if a matching marketing event session could not be found
	 */
	@Override
	public MarketingEventSession fetchByUuid_First(String uuid,
		OrderByComparator<MarketingEventSession> orderByComparator) {
		List<MarketingEventSession> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last marketing event session in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching marketing event session
	 * @throws NoSuchMarketingEventSessionException if a matching marketing event session could not be found
	 */
	@Override
	public MarketingEventSession findByUuid_Last(String uuid,
		OrderByComparator<MarketingEventSession> orderByComparator)
		throws NoSuchMarketingEventSessionException {
		MarketingEventSession marketingEventSession = fetchByUuid_Last(uuid,
				orderByComparator);

		if (marketingEventSession != null) {
			return marketingEventSession;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMarketingEventSessionException(msg.toString());
	}

	/**
	 * Returns the last marketing event session in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching marketing event session, or <code>null</code> if a matching marketing event session could not be found
	 */
	@Override
	public MarketingEventSession fetchByUuid_Last(String uuid,
		OrderByComparator<MarketingEventSession> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<MarketingEventSession> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the marketing event sessions before and after the current marketing event session in the ordered set where uuid = &#63;.
	 *
	 * @param marketingEventSessionId the primary key of the current marketing event session
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next marketing event session
	 * @throws NoSuchMarketingEventSessionException if a marketing event session with the primary key could not be found
	 */
	@Override
	public MarketingEventSession[] findByUuid_PrevAndNext(
		long marketingEventSessionId, String uuid,
		OrderByComparator<MarketingEventSession> orderByComparator)
		throws NoSuchMarketingEventSessionException {
		MarketingEventSession marketingEventSession = findByPrimaryKey(marketingEventSessionId);

		Session session = null;

		try {
			session = openSession();

			MarketingEventSession[] array = new MarketingEventSessionImpl[3];

			array[0] = getByUuid_PrevAndNext(session, marketingEventSession,
					uuid, orderByComparator, true);

			array[1] = marketingEventSession;

			array[2] = getByUuid_PrevAndNext(session, marketingEventSession,
					uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MarketingEventSession getByUuid_PrevAndNext(Session session,
		MarketingEventSession marketingEventSession, String uuid,
		OrderByComparator<MarketingEventSession> orderByComparator,
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

		query.append(_SQL_SELECT_MARKETINGEVENTSESSION_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
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
			query.append(MarketingEventSessionModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(marketingEventSession);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MarketingEventSession> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the marketing event sessions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (MarketingEventSession marketingEventSession : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(marketingEventSession);
		}
	}

	/**
	 * Returns the number of marketing event sessions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching marketing event sessions
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MARKETINGEVENTSESSION_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "marketingEventSession.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "marketingEventSession.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(marketingEventSession.uuid IS NULL OR marketingEventSession.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(MarketingEventSessionModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventSessionModelImpl.FINDER_CACHE_ENABLED,
			MarketingEventSessionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(MarketingEventSessionModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventSessionModelImpl.FINDER_CACHE_ENABLED,
			MarketingEventSessionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			MarketingEventSessionModelImpl.UUID_COLUMN_BITMASK |
			MarketingEventSessionModelImpl.COMPANYID_COLUMN_BITMASK |
			MarketingEventSessionModelImpl.STARTDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(MarketingEventSessionModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventSessionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the marketing event sessions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching marketing event sessions
	 */
	@Override
	public List<MarketingEventSession> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the marketing event sessions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of marketing event sessions
	 * @param end the upper bound of the range of marketing event sessions (not inclusive)
	 * @return the range of matching marketing event sessions
	 */
	@Override
	public List<MarketingEventSession> findByUuid_C(String uuid,
		long companyId, int start, int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the marketing event sessions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of marketing event sessions
	 * @param end the upper bound of the range of marketing event sessions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching marketing event sessions
	 */
	@Override
	public List<MarketingEventSession> findByUuid_C(String uuid,
		long companyId, int start, int end,
		OrderByComparator<MarketingEventSession> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the marketing event sessions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of marketing event sessions
	 * @param end the upper bound of the range of marketing event sessions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching marketing event sessions
	 */
	@Override
	public List<MarketingEventSession> findByUuid_C(String uuid,
		long companyId, int start, int end,
		OrderByComparator<MarketingEventSession> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<MarketingEventSession> list = null;

		if (retrieveFromCache) {
			list = (List<MarketingEventSession>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MarketingEventSession marketingEventSession : list) {
					if (!Objects.equals(uuid, marketingEventSession.getUuid()) ||
							(companyId != marketingEventSession.getCompanyId())) {
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

			query.append(_SQL_SELECT_MARKETINGEVENTSESSION_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MarketingEventSessionModelImpl.ORDER_BY_JPQL);
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

				qPos.add(companyId);

				if (!pagination) {
					list = (List<MarketingEventSession>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MarketingEventSession>)QueryUtil.list(q,
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
	 * Returns the first marketing event session in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching marketing event session
	 * @throws NoSuchMarketingEventSessionException if a matching marketing event session could not be found
	 */
	@Override
	public MarketingEventSession findByUuid_C_First(String uuid,
		long companyId,
		OrderByComparator<MarketingEventSession> orderByComparator)
		throws NoSuchMarketingEventSessionException {
		MarketingEventSession marketingEventSession = fetchByUuid_C_First(uuid,
				companyId, orderByComparator);

		if (marketingEventSession != null) {
			return marketingEventSession;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMarketingEventSessionException(msg.toString());
	}

	/**
	 * Returns the first marketing event session in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching marketing event session, or <code>null</code> if a matching marketing event session could not be found
	 */
	@Override
	public MarketingEventSession fetchByUuid_C_First(String uuid,
		long companyId,
		OrderByComparator<MarketingEventSession> orderByComparator) {
		List<MarketingEventSession> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last marketing event session in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching marketing event session
	 * @throws NoSuchMarketingEventSessionException if a matching marketing event session could not be found
	 */
	@Override
	public MarketingEventSession findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<MarketingEventSession> orderByComparator)
		throws NoSuchMarketingEventSessionException {
		MarketingEventSession marketingEventSession = fetchByUuid_C_Last(uuid,
				companyId, orderByComparator);

		if (marketingEventSession != null) {
			return marketingEventSession;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMarketingEventSessionException(msg.toString());
	}

	/**
	 * Returns the last marketing event session in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching marketing event session, or <code>null</code> if a matching marketing event session could not be found
	 */
	@Override
	public MarketingEventSession fetchByUuid_C_Last(String uuid,
		long companyId,
		OrderByComparator<MarketingEventSession> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<MarketingEventSession> list = findByUuid_C(uuid, companyId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the marketing event sessions before and after the current marketing event session in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param marketingEventSessionId the primary key of the current marketing event session
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next marketing event session
	 * @throws NoSuchMarketingEventSessionException if a marketing event session with the primary key could not be found
	 */
	@Override
	public MarketingEventSession[] findByUuid_C_PrevAndNext(
		long marketingEventSessionId, String uuid, long companyId,
		OrderByComparator<MarketingEventSession> orderByComparator)
		throws NoSuchMarketingEventSessionException {
		MarketingEventSession marketingEventSession = findByPrimaryKey(marketingEventSessionId);

		Session session = null;

		try {
			session = openSession();

			MarketingEventSession[] array = new MarketingEventSessionImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, marketingEventSession,
					uuid, companyId, orderByComparator, true);

			array[1] = marketingEventSession;

			array[2] = getByUuid_C_PrevAndNext(session, marketingEventSession,
					uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MarketingEventSession getByUuid_C_PrevAndNext(Session session,
		MarketingEventSession marketingEventSession, String uuid,
		long companyId,
		OrderByComparator<MarketingEventSession> orderByComparator,
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

		query.append(_SQL_SELECT_MARKETINGEVENTSESSION_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

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
			query.append(MarketingEventSessionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(marketingEventSession);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MarketingEventSession> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the marketing event sessions where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (MarketingEventSession marketingEventSession : findByUuid_C(uuid,
				companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(marketingEventSession);
		}
	}

	/**
	 * Returns the number of marketing event sessions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching marketing event sessions
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MARKETINGEVENTSESSION_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "marketingEventSession.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "marketingEventSession.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(marketingEventSession.uuid IS NULL OR marketingEventSession.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "marketingEventSession.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MARKETINGEVENTID =
		new FinderPath(MarketingEventSessionModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventSessionModelImpl.FINDER_CACHE_ENABLED,
			MarketingEventSessionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMarketingEventId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MARKETINGEVENTID =
		new FinderPath(MarketingEventSessionModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventSessionModelImpl.FINDER_CACHE_ENABLED,
			MarketingEventSessionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByMarketingEventId", new String[] { Long.class.getName() },
			MarketingEventSessionModelImpl.MARKETINGEVENTID_COLUMN_BITMASK |
			MarketingEventSessionModelImpl.STARTDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MARKETINGEVENTID = new FinderPath(MarketingEventSessionModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventSessionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByMarketingEventId", new String[] { Long.class.getName() });

	/**
	 * Returns all the marketing event sessions where marketingEventId = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @return the matching marketing event sessions
	 */
	@Override
	public List<MarketingEventSession> findByMarketingEventId(
		long marketingEventId) {
		return findByMarketingEventId(marketingEventId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the marketing event sessions where marketingEventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param marketingEventId the marketing event ID
	 * @param start the lower bound of the range of marketing event sessions
	 * @param end the upper bound of the range of marketing event sessions (not inclusive)
	 * @return the range of matching marketing event sessions
	 */
	@Override
	public List<MarketingEventSession> findByMarketingEventId(
		long marketingEventId, int start, int end) {
		return findByMarketingEventId(marketingEventId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the marketing event sessions where marketingEventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param marketingEventId the marketing event ID
	 * @param start the lower bound of the range of marketing event sessions
	 * @param end the upper bound of the range of marketing event sessions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching marketing event sessions
	 */
	@Override
	public List<MarketingEventSession> findByMarketingEventId(
		long marketingEventId, int start, int end,
		OrderByComparator<MarketingEventSession> orderByComparator) {
		return findByMarketingEventId(marketingEventId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the marketing event sessions where marketingEventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param marketingEventId the marketing event ID
	 * @param start the lower bound of the range of marketing event sessions
	 * @param end the upper bound of the range of marketing event sessions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching marketing event sessions
	 */
	@Override
	public List<MarketingEventSession> findByMarketingEventId(
		long marketingEventId, int start, int end,
		OrderByComparator<MarketingEventSession> orderByComparator,
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

		List<MarketingEventSession> list = null;

		if (retrieveFromCache) {
			list = (List<MarketingEventSession>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MarketingEventSession marketingEventSession : list) {
					if ((marketingEventId != marketingEventSession.getMarketingEventId())) {
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

			query.append(_SQL_SELECT_MARKETINGEVENTSESSION_WHERE);

			query.append(_FINDER_COLUMN_MARKETINGEVENTID_MARKETINGEVENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MarketingEventSessionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(marketingEventId);

				if (!pagination) {
					list = (List<MarketingEventSession>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MarketingEventSession>)QueryUtil.list(q,
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
	 * Returns the first marketing event session in the ordered set where marketingEventId = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching marketing event session
	 * @throws NoSuchMarketingEventSessionException if a matching marketing event session could not be found
	 */
	@Override
	public MarketingEventSession findByMarketingEventId_First(
		long marketingEventId,
		OrderByComparator<MarketingEventSession> orderByComparator)
		throws NoSuchMarketingEventSessionException {
		MarketingEventSession marketingEventSession = fetchByMarketingEventId_First(marketingEventId,
				orderByComparator);

		if (marketingEventSession != null) {
			return marketingEventSession;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("marketingEventId=");
		msg.append(marketingEventId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMarketingEventSessionException(msg.toString());
	}

	/**
	 * Returns the first marketing event session in the ordered set where marketingEventId = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching marketing event session, or <code>null</code> if a matching marketing event session could not be found
	 */
	@Override
	public MarketingEventSession fetchByMarketingEventId_First(
		long marketingEventId,
		OrderByComparator<MarketingEventSession> orderByComparator) {
		List<MarketingEventSession> list = findByMarketingEventId(marketingEventId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last marketing event session in the ordered set where marketingEventId = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching marketing event session
	 * @throws NoSuchMarketingEventSessionException if a matching marketing event session could not be found
	 */
	@Override
	public MarketingEventSession findByMarketingEventId_Last(
		long marketingEventId,
		OrderByComparator<MarketingEventSession> orderByComparator)
		throws NoSuchMarketingEventSessionException {
		MarketingEventSession marketingEventSession = fetchByMarketingEventId_Last(marketingEventId,
				orderByComparator);

		if (marketingEventSession != null) {
			return marketingEventSession;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("marketingEventId=");
		msg.append(marketingEventId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMarketingEventSessionException(msg.toString());
	}

	/**
	 * Returns the last marketing event session in the ordered set where marketingEventId = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching marketing event session, or <code>null</code> if a matching marketing event session could not be found
	 */
	@Override
	public MarketingEventSession fetchByMarketingEventId_Last(
		long marketingEventId,
		OrderByComparator<MarketingEventSession> orderByComparator) {
		int count = countByMarketingEventId(marketingEventId);

		if (count == 0) {
			return null;
		}

		List<MarketingEventSession> list = findByMarketingEventId(marketingEventId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the marketing event sessions before and after the current marketing event session in the ordered set where marketingEventId = &#63;.
	 *
	 * @param marketingEventSessionId the primary key of the current marketing event session
	 * @param marketingEventId the marketing event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next marketing event session
	 * @throws NoSuchMarketingEventSessionException if a marketing event session with the primary key could not be found
	 */
	@Override
	public MarketingEventSession[] findByMarketingEventId_PrevAndNext(
		long marketingEventSessionId, long marketingEventId,
		OrderByComparator<MarketingEventSession> orderByComparator)
		throws NoSuchMarketingEventSessionException {
		MarketingEventSession marketingEventSession = findByPrimaryKey(marketingEventSessionId);

		Session session = null;

		try {
			session = openSession();

			MarketingEventSession[] array = new MarketingEventSessionImpl[3];

			array[0] = getByMarketingEventId_PrevAndNext(session,
					marketingEventSession, marketingEventId, orderByComparator,
					true);

			array[1] = marketingEventSession;

			array[2] = getByMarketingEventId_PrevAndNext(session,
					marketingEventSession, marketingEventId, orderByComparator,
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

	protected MarketingEventSession getByMarketingEventId_PrevAndNext(
		Session session, MarketingEventSession marketingEventSession,
		long marketingEventId,
		OrderByComparator<MarketingEventSession> orderByComparator,
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

		query.append(_SQL_SELECT_MARKETINGEVENTSESSION_WHERE);

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
			query.append(MarketingEventSessionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(marketingEventId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(marketingEventSession);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MarketingEventSession> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the marketing event sessions where marketingEventId = &#63; from the database.
	 *
	 * @param marketingEventId the marketing event ID
	 */
	@Override
	public void removeByMarketingEventId(long marketingEventId) {
		for (MarketingEventSession marketingEventSession : findByMarketingEventId(
				marketingEventId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(marketingEventSession);
		}
	}

	/**
	 * Returns the number of marketing event sessions where marketingEventId = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @return the number of matching marketing event sessions
	 */
	@Override
	public int countByMarketingEventId(long marketingEventId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MARKETINGEVENTID;

		Object[] finderArgs = new Object[] { marketingEventId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MARKETINGEVENTSESSION_WHERE);

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
		"marketingEventSession.marketingEventId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MEI_MESRI =
		new FinderPath(MarketingEventSessionModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventSessionModelImpl.FINDER_CACHE_ENABLED,
			MarketingEventSessionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMEI_MESRI",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEI_MESRI =
		new FinderPath(MarketingEventSessionModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventSessionModelImpl.FINDER_CACHE_ENABLED,
			MarketingEventSessionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMEI_MESRI",
			new String[] { Long.class.getName(), Long.class.getName() },
			MarketingEventSessionModelImpl.MARKETINGEVENTID_COLUMN_BITMASK |
			MarketingEventSessionModelImpl.MARKETINGEVENTSESSIONROOMID_COLUMN_BITMASK |
			MarketingEventSessionModelImpl.STARTDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MEI_MESRI = new FinderPath(MarketingEventSessionModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventSessionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMEI_MESRI",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the marketing event sessions where marketingEventId = &#63; and marketingEventSessionRoomId = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param marketingEventSessionRoomId the marketing event session room ID
	 * @return the matching marketing event sessions
	 */
	@Override
	public List<MarketingEventSession> findByMEI_MESRI(long marketingEventId,
		long marketingEventSessionRoomId) {
		return findByMEI_MESRI(marketingEventId, marketingEventSessionRoomId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the marketing event sessions where marketingEventId = &#63; and marketingEventSessionRoomId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param marketingEventId the marketing event ID
	 * @param marketingEventSessionRoomId the marketing event session room ID
	 * @param start the lower bound of the range of marketing event sessions
	 * @param end the upper bound of the range of marketing event sessions (not inclusive)
	 * @return the range of matching marketing event sessions
	 */
	@Override
	public List<MarketingEventSession> findByMEI_MESRI(long marketingEventId,
		long marketingEventSessionRoomId, int start, int end) {
		return findByMEI_MESRI(marketingEventId, marketingEventSessionRoomId,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the marketing event sessions where marketingEventId = &#63; and marketingEventSessionRoomId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param marketingEventId the marketing event ID
	 * @param marketingEventSessionRoomId the marketing event session room ID
	 * @param start the lower bound of the range of marketing event sessions
	 * @param end the upper bound of the range of marketing event sessions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching marketing event sessions
	 */
	@Override
	public List<MarketingEventSession> findByMEI_MESRI(long marketingEventId,
		long marketingEventSessionRoomId, int start, int end,
		OrderByComparator<MarketingEventSession> orderByComparator) {
		return findByMEI_MESRI(marketingEventId, marketingEventSessionRoomId,
			start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the marketing event sessions where marketingEventId = &#63; and marketingEventSessionRoomId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param marketingEventId the marketing event ID
	 * @param marketingEventSessionRoomId the marketing event session room ID
	 * @param start the lower bound of the range of marketing event sessions
	 * @param end the upper bound of the range of marketing event sessions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching marketing event sessions
	 */
	@Override
	public List<MarketingEventSession> findByMEI_MESRI(long marketingEventId,
		long marketingEventSessionRoomId, int start, int end,
		OrderByComparator<MarketingEventSession> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEI_MESRI;
			finderArgs = new Object[] {
					marketingEventId, marketingEventSessionRoomId
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MEI_MESRI;
			finderArgs = new Object[] {
					marketingEventId, marketingEventSessionRoomId,
					
					start, end, orderByComparator
				};
		}

		List<MarketingEventSession> list = null;

		if (retrieveFromCache) {
			list = (List<MarketingEventSession>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MarketingEventSession marketingEventSession : list) {
					if ((marketingEventId != marketingEventSession.getMarketingEventId()) ||
							(marketingEventSessionRoomId != marketingEventSession.getMarketingEventSessionRoomId())) {
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

			query.append(_SQL_SELECT_MARKETINGEVENTSESSION_WHERE);

			query.append(_FINDER_COLUMN_MEI_MESRI_MARKETINGEVENTID_2);

			query.append(_FINDER_COLUMN_MEI_MESRI_MARKETINGEVENTSESSIONROOMID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MarketingEventSessionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(marketingEventId);

				qPos.add(marketingEventSessionRoomId);

				if (!pagination) {
					list = (List<MarketingEventSession>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MarketingEventSession>)QueryUtil.list(q,
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
	 * Returns the first marketing event session in the ordered set where marketingEventId = &#63; and marketingEventSessionRoomId = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param marketingEventSessionRoomId the marketing event session room ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching marketing event session
	 * @throws NoSuchMarketingEventSessionException if a matching marketing event session could not be found
	 */
	@Override
	public MarketingEventSession findByMEI_MESRI_First(long marketingEventId,
		long marketingEventSessionRoomId,
		OrderByComparator<MarketingEventSession> orderByComparator)
		throws NoSuchMarketingEventSessionException {
		MarketingEventSession marketingEventSession = fetchByMEI_MESRI_First(marketingEventId,
				marketingEventSessionRoomId, orderByComparator);

		if (marketingEventSession != null) {
			return marketingEventSession;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("marketingEventId=");
		msg.append(marketingEventId);

		msg.append(", marketingEventSessionRoomId=");
		msg.append(marketingEventSessionRoomId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMarketingEventSessionException(msg.toString());
	}

	/**
	 * Returns the first marketing event session in the ordered set where marketingEventId = &#63; and marketingEventSessionRoomId = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param marketingEventSessionRoomId the marketing event session room ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching marketing event session, or <code>null</code> if a matching marketing event session could not be found
	 */
	@Override
	public MarketingEventSession fetchByMEI_MESRI_First(long marketingEventId,
		long marketingEventSessionRoomId,
		OrderByComparator<MarketingEventSession> orderByComparator) {
		List<MarketingEventSession> list = findByMEI_MESRI(marketingEventId,
				marketingEventSessionRoomId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last marketing event session in the ordered set where marketingEventId = &#63; and marketingEventSessionRoomId = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param marketingEventSessionRoomId the marketing event session room ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching marketing event session
	 * @throws NoSuchMarketingEventSessionException if a matching marketing event session could not be found
	 */
	@Override
	public MarketingEventSession findByMEI_MESRI_Last(long marketingEventId,
		long marketingEventSessionRoomId,
		OrderByComparator<MarketingEventSession> orderByComparator)
		throws NoSuchMarketingEventSessionException {
		MarketingEventSession marketingEventSession = fetchByMEI_MESRI_Last(marketingEventId,
				marketingEventSessionRoomId, orderByComparator);

		if (marketingEventSession != null) {
			return marketingEventSession;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("marketingEventId=");
		msg.append(marketingEventId);

		msg.append(", marketingEventSessionRoomId=");
		msg.append(marketingEventSessionRoomId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMarketingEventSessionException(msg.toString());
	}

	/**
	 * Returns the last marketing event session in the ordered set where marketingEventId = &#63; and marketingEventSessionRoomId = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param marketingEventSessionRoomId the marketing event session room ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching marketing event session, or <code>null</code> if a matching marketing event session could not be found
	 */
	@Override
	public MarketingEventSession fetchByMEI_MESRI_Last(long marketingEventId,
		long marketingEventSessionRoomId,
		OrderByComparator<MarketingEventSession> orderByComparator) {
		int count = countByMEI_MESRI(marketingEventId,
				marketingEventSessionRoomId);

		if (count == 0) {
			return null;
		}

		List<MarketingEventSession> list = findByMEI_MESRI(marketingEventId,
				marketingEventSessionRoomId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the marketing event sessions before and after the current marketing event session in the ordered set where marketingEventId = &#63; and marketingEventSessionRoomId = &#63;.
	 *
	 * @param marketingEventSessionId the primary key of the current marketing event session
	 * @param marketingEventId the marketing event ID
	 * @param marketingEventSessionRoomId the marketing event session room ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next marketing event session
	 * @throws NoSuchMarketingEventSessionException if a marketing event session with the primary key could not be found
	 */
	@Override
	public MarketingEventSession[] findByMEI_MESRI_PrevAndNext(
		long marketingEventSessionId, long marketingEventId,
		long marketingEventSessionRoomId,
		OrderByComparator<MarketingEventSession> orderByComparator)
		throws NoSuchMarketingEventSessionException {
		MarketingEventSession marketingEventSession = findByPrimaryKey(marketingEventSessionId);

		Session session = null;

		try {
			session = openSession();

			MarketingEventSession[] array = new MarketingEventSessionImpl[3];

			array[0] = getByMEI_MESRI_PrevAndNext(session,
					marketingEventSession, marketingEventId,
					marketingEventSessionRoomId, orderByComparator, true);

			array[1] = marketingEventSession;

			array[2] = getByMEI_MESRI_PrevAndNext(session,
					marketingEventSession, marketingEventId,
					marketingEventSessionRoomId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MarketingEventSession getByMEI_MESRI_PrevAndNext(
		Session session, MarketingEventSession marketingEventSession,
		long marketingEventId, long marketingEventSessionRoomId,
		OrderByComparator<MarketingEventSession> orderByComparator,
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

		query.append(_SQL_SELECT_MARKETINGEVENTSESSION_WHERE);

		query.append(_FINDER_COLUMN_MEI_MESRI_MARKETINGEVENTID_2);

		query.append(_FINDER_COLUMN_MEI_MESRI_MARKETINGEVENTSESSIONROOMID_2);

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
			query.append(MarketingEventSessionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(marketingEventId);

		qPos.add(marketingEventSessionRoomId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(marketingEventSession);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MarketingEventSession> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the marketing event sessions where marketingEventId = &#63; and marketingEventSessionRoomId = &#63; from the database.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param marketingEventSessionRoomId the marketing event session room ID
	 */
	@Override
	public void removeByMEI_MESRI(long marketingEventId,
		long marketingEventSessionRoomId) {
		for (MarketingEventSession marketingEventSession : findByMEI_MESRI(
				marketingEventId, marketingEventSessionRoomId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(marketingEventSession);
		}
	}

	/**
	 * Returns the number of marketing event sessions where marketingEventId = &#63; and marketingEventSessionRoomId = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param marketingEventSessionRoomId the marketing event session room ID
	 * @return the number of matching marketing event sessions
	 */
	@Override
	public int countByMEI_MESRI(long marketingEventId,
		long marketingEventSessionRoomId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MEI_MESRI;

		Object[] finderArgs = new Object[] {
				marketingEventId, marketingEventSessionRoomId
			};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MARKETINGEVENTSESSION_WHERE);

			query.append(_FINDER_COLUMN_MEI_MESRI_MARKETINGEVENTID_2);

			query.append(_FINDER_COLUMN_MEI_MESRI_MARKETINGEVENTSESSIONROOMID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(marketingEventId);

				qPos.add(marketingEventSessionRoomId);

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

	private static final String _FINDER_COLUMN_MEI_MESRI_MARKETINGEVENTID_2 = "marketingEventSession.marketingEventId = ? AND ";
	private static final String _FINDER_COLUMN_MEI_MESRI_MARKETINGEVENTSESSIONROOMID_2 =
		"marketingEventSession.marketingEventSessionRoomId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MEI_S = new FinderPath(MarketingEventSessionModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventSessionModelImpl.FINDER_CACHE_ENABLED,
			MarketingEventSessionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMEI_S",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEI_S = new FinderPath(MarketingEventSessionModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventSessionModelImpl.FINDER_CACHE_ENABLED,
			MarketingEventSessionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMEI_S",
			new String[] { Long.class.getName(), Integer.class.getName() },
			MarketingEventSessionModelImpl.MARKETINGEVENTID_COLUMN_BITMASK |
			MarketingEventSessionModelImpl.STATUS_COLUMN_BITMASK |
			MarketingEventSessionModelImpl.STARTDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MEI_S = new FinderPath(MarketingEventSessionModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventSessionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMEI_S",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the marketing event sessions where marketingEventId = &#63; and status = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param status the status
	 * @return the matching marketing event sessions
	 */
	@Override
	public List<MarketingEventSession> findByMEI_S(long marketingEventId,
		int status) {
		return findByMEI_S(marketingEventId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the marketing event sessions where marketingEventId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param marketingEventId the marketing event ID
	 * @param status the status
	 * @param start the lower bound of the range of marketing event sessions
	 * @param end the upper bound of the range of marketing event sessions (not inclusive)
	 * @return the range of matching marketing event sessions
	 */
	@Override
	public List<MarketingEventSession> findByMEI_S(long marketingEventId,
		int status, int start, int end) {
		return findByMEI_S(marketingEventId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the marketing event sessions where marketingEventId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param marketingEventId the marketing event ID
	 * @param status the status
	 * @param start the lower bound of the range of marketing event sessions
	 * @param end the upper bound of the range of marketing event sessions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching marketing event sessions
	 */
	@Override
	public List<MarketingEventSession> findByMEI_S(long marketingEventId,
		int status, int start, int end,
		OrderByComparator<MarketingEventSession> orderByComparator) {
		return findByMEI_S(marketingEventId, status, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the marketing event sessions where marketingEventId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param marketingEventId the marketing event ID
	 * @param status the status
	 * @param start the lower bound of the range of marketing event sessions
	 * @param end the upper bound of the range of marketing event sessions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching marketing event sessions
	 */
	@Override
	public List<MarketingEventSession> findByMEI_S(long marketingEventId,
		int status, int start, int end,
		OrderByComparator<MarketingEventSession> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEI_S;
			finderArgs = new Object[] { marketingEventId, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MEI_S;
			finderArgs = new Object[] {
					marketingEventId, status,
					
					start, end, orderByComparator
				};
		}

		List<MarketingEventSession> list = null;

		if (retrieveFromCache) {
			list = (List<MarketingEventSession>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MarketingEventSession marketingEventSession : list) {
					if ((marketingEventId != marketingEventSession.getMarketingEventId()) ||
							(status != marketingEventSession.getStatus())) {
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

			query.append(_SQL_SELECT_MARKETINGEVENTSESSION_WHERE);

			query.append(_FINDER_COLUMN_MEI_S_MARKETINGEVENTID_2);

			query.append(_FINDER_COLUMN_MEI_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MarketingEventSessionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(marketingEventId);

				qPos.add(status);

				if (!pagination) {
					list = (List<MarketingEventSession>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MarketingEventSession>)QueryUtil.list(q,
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
	 * Returns the first marketing event session in the ordered set where marketingEventId = &#63; and status = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching marketing event session
	 * @throws NoSuchMarketingEventSessionException if a matching marketing event session could not be found
	 */
	@Override
	public MarketingEventSession findByMEI_S_First(long marketingEventId,
		int status, OrderByComparator<MarketingEventSession> orderByComparator)
		throws NoSuchMarketingEventSessionException {
		MarketingEventSession marketingEventSession = fetchByMEI_S_First(marketingEventId,
				status, orderByComparator);

		if (marketingEventSession != null) {
			return marketingEventSession;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("marketingEventId=");
		msg.append(marketingEventId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMarketingEventSessionException(msg.toString());
	}

	/**
	 * Returns the first marketing event session in the ordered set where marketingEventId = &#63; and status = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching marketing event session, or <code>null</code> if a matching marketing event session could not be found
	 */
	@Override
	public MarketingEventSession fetchByMEI_S_First(long marketingEventId,
		int status, OrderByComparator<MarketingEventSession> orderByComparator) {
		List<MarketingEventSession> list = findByMEI_S(marketingEventId,
				status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last marketing event session in the ordered set where marketingEventId = &#63; and status = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching marketing event session
	 * @throws NoSuchMarketingEventSessionException if a matching marketing event session could not be found
	 */
	@Override
	public MarketingEventSession findByMEI_S_Last(long marketingEventId,
		int status, OrderByComparator<MarketingEventSession> orderByComparator)
		throws NoSuchMarketingEventSessionException {
		MarketingEventSession marketingEventSession = fetchByMEI_S_Last(marketingEventId,
				status, orderByComparator);

		if (marketingEventSession != null) {
			return marketingEventSession;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("marketingEventId=");
		msg.append(marketingEventId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMarketingEventSessionException(msg.toString());
	}

	/**
	 * Returns the last marketing event session in the ordered set where marketingEventId = &#63; and status = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching marketing event session, or <code>null</code> if a matching marketing event session could not be found
	 */
	@Override
	public MarketingEventSession fetchByMEI_S_Last(long marketingEventId,
		int status, OrderByComparator<MarketingEventSession> orderByComparator) {
		int count = countByMEI_S(marketingEventId, status);

		if (count == 0) {
			return null;
		}

		List<MarketingEventSession> list = findByMEI_S(marketingEventId,
				status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the marketing event sessions before and after the current marketing event session in the ordered set where marketingEventId = &#63; and status = &#63;.
	 *
	 * @param marketingEventSessionId the primary key of the current marketing event session
	 * @param marketingEventId the marketing event ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next marketing event session
	 * @throws NoSuchMarketingEventSessionException if a marketing event session with the primary key could not be found
	 */
	@Override
	public MarketingEventSession[] findByMEI_S_PrevAndNext(
		long marketingEventSessionId, long marketingEventId, int status,
		OrderByComparator<MarketingEventSession> orderByComparator)
		throws NoSuchMarketingEventSessionException {
		MarketingEventSession marketingEventSession = findByPrimaryKey(marketingEventSessionId);

		Session session = null;

		try {
			session = openSession();

			MarketingEventSession[] array = new MarketingEventSessionImpl[3];

			array[0] = getByMEI_S_PrevAndNext(session, marketingEventSession,
					marketingEventId, status, orderByComparator, true);

			array[1] = marketingEventSession;

			array[2] = getByMEI_S_PrevAndNext(session, marketingEventSession,
					marketingEventId, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MarketingEventSession getByMEI_S_PrevAndNext(Session session,
		MarketingEventSession marketingEventSession, long marketingEventId,
		int status, OrderByComparator<MarketingEventSession> orderByComparator,
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

		query.append(_SQL_SELECT_MARKETINGEVENTSESSION_WHERE);

		query.append(_FINDER_COLUMN_MEI_S_MARKETINGEVENTID_2);

		query.append(_FINDER_COLUMN_MEI_S_STATUS_2);

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
			query.append(MarketingEventSessionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(marketingEventId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(marketingEventSession);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MarketingEventSession> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the marketing event sessions where marketingEventId = &#63; and status = &#63; from the database.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param status the status
	 */
	@Override
	public void removeByMEI_S(long marketingEventId, int status) {
		for (MarketingEventSession marketingEventSession : findByMEI_S(
				marketingEventId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(marketingEventSession);
		}
	}

	/**
	 * Returns the number of marketing event sessions where marketingEventId = &#63; and status = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param status the status
	 * @return the number of matching marketing event sessions
	 */
	@Override
	public int countByMEI_S(long marketingEventId, int status) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MEI_S;

		Object[] finderArgs = new Object[] { marketingEventId, status };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MARKETINGEVENTSESSION_WHERE);

			query.append(_FINDER_COLUMN_MEI_S_MARKETINGEVENTID_2);

			query.append(_FINDER_COLUMN_MEI_S_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(marketingEventId);

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

	private static final String _FINDER_COLUMN_MEI_S_MARKETINGEVENTID_2 = "marketingEventSession.marketingEventId = ? AND ";
	private static final String _FINDER_COLUMN_MEI_S_STATUS_2 = "marketingEventSession.status = ?";

	public MarketingEventSessionPersistenceImpl() {
		setModelClass(MarketingEventSession.class);

		try {
			Field field = ReflectionUtil.getDeclaredField(BasePersistenceImpl.class,
					"_dbColumnNames");

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
	 * Caches the marketing event session in the entity cache if it is enabled.
	 *
	 * @param marketingEventSession the marketing event session
	 */
	@Override
	public void cacheResult(MarketingEventSession marketingEventSession) {
		entityCache.putResult(MarketingEventSessionModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventSessionImpl.class,
			marketingEventSession.getPrimaryKey(), marketingEventSession);

		marketingEventSession.resetOriginalValues();
	}

	/**
	 * Caches the marketing event sessions in the entity cache if it is enabled.
	 *
	 * @param marketingEventSessions the marketing event sessions
	 */
	@Override
	public void cacheResult(List<MarketingEventSession> marketingEventSessions) {
		for (MarketingEventSession marketingEventSession : marketingEventSessions) {
			if (entityCache.getResult(
						MarketingEventSessionModelImpl.ENTITY_CACHE_ENABLED,
						MarketingEventSessionImpl.class,
						marketingEventSession.getPrimaryKey()) == null) {
				cacheResult(marketingEventSession);
			}
			else {
				marketingEventSession.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all marketing event sessions.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MarketingEventSessionImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the marketing event session.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MarketingEventSession marketingEventSession) {
		entityCache.removeResult(MarketingEventSessionModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventSessionImpl.class,
			marketingEventSession.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<MarketingEventSession> marketingEventSessions) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MarketingEventSession marketingEventSession : marketingEventSessions) {
			entityCache.removeResult(MarketingEventSessionModelImpl.ENTITY_CACHE_ENABLED,
				MarketingEventSessionImpl.class,
				marketingEventSession.getPrimaryKey());
		}
	}

	/**
	 * Creates a new marketing event session with the primary key. Does not add the marketing event session to the database.
	 *
	 * @param marketingEventSessionId the primary key for the new marketing event session
	 * @return the new marketing event session
	 */
	@Override
	public MarketingEventSession create(long marketingEventSessionId) {
		MarketingEventSession marketingEventSession = new MarketingEventSessionImpl();

		marketingEventSession.setNew(true);
		marketingEventSession.setPrimaryKey(marketingEventSessionId);

		String uuid = PortalUUIDUtil.generate();

		marketingEventSession.setUuid(uuid);

		marketingEventSession.setCompanyId(companyProvider.getCompanyId());

		return marketingEventSession;
	}

	/**
	 * Removes the marketing event session with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param marketingEventSessionId the primary key of the marketing event session
	 * @return the marketing event session that was removed
	 * @throws NoSuchMarketingEventSessionException if a marketing event session with the primary key could not be found
	 */
	@Override
	public MarketingEventSession remove(long marketingEventSessionId)
		throws NoSuchMarketingEventSessionException {
		return remove((Serializable)marketingEventSessionId);
	}

	/**
	 * Removes the marketing event session with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the marketing event session
	 * @return the marketing event session that was removed
	 * @throws NoSuchMarketingEventSessionException if a marketing event session with the primary key could not be found
	 */
	@Override
	public MarketingEventSession remove(Serializable primaryKey)
		throws NoSuchMarketingEventSessionException {
		Session session = null;

		try {
			session = openSession();

			MarketingEventSession marketingEventSession = (MarketingEventSession)session.get(MarketingEventSessionImpl.class,
					primaryKey);

			if (marketingEventSession == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMarketingEventSessionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(marketingEventSession);
		}
		catch (NoSuchMarketingEventSessionException nsee) {
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
	protected MarketingEventSession removeImpl(
		MarketingEventSession marketingEventSession) {
		marketingEventSession = toUnwrappedModel(marketingEventSession);

		marketingEventSessionToMarketingEventUserTableMapper.deleteLeftPrimaryKeyTableMappings(marketingEventSession.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(marketingEventSession)) {
				marketingEventSession = (MarketingEventSession)session.get(MarketingEventSessionImpl.class,
						marketingEventSession.getPrimaryKeyObj());
			}

			if (marketingEventSession != null) {
				session.delete(marketingEventSession);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (marketingEventSession != null) {
			clearCache(marketingEventSession);
		}

		return marketingEventSession;
	}

	@Override
	public MarketingEventSession updateImpl(
		MarketingEventSession marketingEventSession) {
		marketingEventSession = toUnwrappedModel(marketingEventSession);

		boolean isNew = marketingEventSession.isNew();

		MarketingEventSessionModelImpl marketingEventSessionModelImpl = (MarketingEventSessionModelImpl)marketingEventSession;

		if (Validator.isNull(marketingEventSession.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			marketingEventSession.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (marketingEventSession.getCreateDate() == null)) {
			if (serviceContext == null) {
				marketingEventSession.setCreateDate(now);
			}
			else {
				marketingEventSession.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!marketingEventSessionModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				marketingEventSession.setModifiedDate(now);
			}
			else {
				marketingEventSession.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (marketingEventSession.isNew()) {
				session.save(marketingEventSession);

				marketingEventSession.setNew(false);
			}
			else {
				marketingEventSession = (MarketingEventSession)session.merge(marketingEventSession);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!MarketingEventSessionModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					marketingEventSessionModelImpl.getUuid()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] {
					marketingEventSessionModelImpl.getUuid(),
					marketingEventSessionModelImpl.getCompanyId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
				args);

			args = new Object[] {
					marketingEventSessionModelImpl.getMarketingEventId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_MARKETINGEVENTID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MARKETINGEVENTID,
				args);

			args = new Object[] {
					marketingEventSessionModelImpl.getMarketingEventId(),
					marketingEventSessionModelImpl.getMarketingEventSessionRoomId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_MEI_MESRI, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEI_MESRI,
				args);

			args = new Object[] {
					marketingEventSessionModelImpl.getMarketingEventId(),
					marketingEventSessionModelImpl.getStatus()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_MEI_S, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEI_S,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((marketingEventSessionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						marketingEventSessionModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { marketingEventSessionModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((marketingEventSessionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						marketingEventSessionModelImpl.getOriginalUuid(),
						marketingEventSessionModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						marketingEventSessionModelImpl.getUuid(),
						marketingEventSessionModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((marketingEventSessionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MARKETINGEVENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						marketingEventSessionModelImpl.getOriginalMarketingEventId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MARKETINGEVENTID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MARKETINGEVENTID,
					args);

				args = new Object[] {
						marketingEventSessionModelImpl.getMarketingEventId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MARKETINGEVENTID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MARKETINGEVENTID,
					args);
			}

			if ((marketingEventSessionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEI_MESRI.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						marketingEventSessionModelImpl.getOriginalMarketingEventId(),
						marketingEventSessionModelImpl.getOriginalMarketingEventSessionRoomId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MEI_MESRI, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEI_MESRI,
					args);

				args = new Object[] {
						marketingEventSessionModelImpl.getMarketingEventId(),
						marketingEventSessionModelImpl.getMarketingEventSessionRoomId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MEI_MESRI, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEI_MESRI,
					args);
			}

			if ((marketingEventSessionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEI_S.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						marketingEventSessionModelImpl.getOriginalMarketingEventId(),
						marketingEventSessionModelImpl.getOriginalStatus()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MEI_S, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEI_S,
					args);

				args = new Object[] {
						marketingEventSessionModelImpl.getMarketingEventId(),
						marketingEventSessionModelImpl.getStatus()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MEI_S, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEI_S,
					args);
			}
		}

		entityCache.putResult(MarketingEventSessionModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventSessionImpl.class,
			marketingEventSession.getPrimaryKey(), marketingEventSession, false);

		marketingEventSession.resetOriginalValues();

		return marketingEventSession;
	}

	protected MarketingEventSession toUnwrappedModel(
		MarketingEventSession marketingEventSession) {
		if (marketingEventSession instanceof MarketingEventSessionImpl) {
			return marketingEventSession;
		}

		MarketingEventSessionImpl marketingEventSessionImpl = new MarketingEventSessionImpl();

		marketingEventSessionImpl.setNew(marketingEventSession.isNew());
		marketingEventSessionImpl.setPrimaryKey(marketingEventSession.getPrimaryKey());

		marketingEventSessionImpl.setUuid(marketingEventSession.getUuid());
		marketingEventSessionImpl.setMarketingEventSessionId(marketingEventSession.getMarketingEventSessionId());
		marketingEventSessionImpl.setCompanyId(marketingEventSession.getCompanyId());
		marketingEventSessionImpl.setUserId(marketingEventSession.getUserId());
		marketingEventSessionImpl.setUserName(marketingEventSession.getUserName());
		marketingEventSessionImpl.setCreateDate(marketingEventSession.getCreateDate());
		marketingEventSessionImpl.setModifiedDate(marketingEventSession.getModifiedDate());
		marketingEventSessionImpl.setMarketingEventId(marketingEventSession.getMarketingEventId());
		marketingEventSessionImpl.setMarketingEventSessionRoomId(marketingEventSession.getMarketingEventSessionRoomId());
		marketingEventSessionImpl.setTitle(marketingEventSession.getTitle());
		marketingEventSessionImpl.setDescription(marketingEventSession.getDescription());
		marketingEventSessionImpl.setKeywords(marketingEventSession.getKeywords());
		marketingEventSessionImpl.setSlidesFileEntryId(marketingEventSession.getSlidesFileEntryId());
		marketingEventSessionImpl.setVideoURL(marketingEventSession.getVideoURL());
		marketingEventSessionImpl.setStartDate(marketingEventSession.getStartDate());
		marketingEventSessionImpl.setEndDate(marketingEventSession.getEndDate());
		marketingEventSessionImpl.setStatus(marketingEventSession.getStatus());
		marketingEventSessionImpl.setStatusByUserId(marketingEventSession.getStatusByUserId());
		marketingEventSessionImpl.setStatusByUserName(marketingEventSession.getStatusByUserName());
		marketingEventSessionImpl.setStatusDate(marketingEventSession.getStatusDate());

		return marketingEventSessionImpl;
	}

	/**
	 * Returns the marketing event session with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the marketing event session
	 * @return the marketing event session
	 * @throws NoSuchMarketingEventSessionException if a marketing event session with the primary key could not be found
	 */
	@Override
	public MarketingEventSession findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMarketingEventSessionException {
		MarketingEventSession marketingEventSession = fetchByPrimaryKey(primaryKey);

		if (marketingEventSession == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMarketingEventSessionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return marketingEventSession;
	}

	/**
	 * Returns the marketing event session with the primary key or throws a {@link NoSuchMarketingEventSessionException} if it could not be found.
	 *
	 * @param marketingEventSessionId the primary key of the marketing event session
	 * @return the marketing event session
	 * @throws NoSuchMarketingEventSessionException if a marketing event session with the primary key could not be found
	 */
	@Override
	public MarketingEventSession findByPrimaryKey(long marketingEventSessionId)
		throws NoSuchMarketingEventSessionException {
		return findByPrimaryKey((Serializable)marketingEventSessionId);
	}

	/**
	 * Returns the marketing event session with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the marketing event session
	 * @return the marketing event session, or <code>null</code> if a marketing event session with the primary key could not be found
	 */
	@Override
	public MarketingEventSession fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(MarketingEventSessionModelImpl.ENTITY_CACHE_ENABLED,
				MarketingEventSessionImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		MarketingEventSession marketingEventSession = (MarketingEventSession)serializable;

		if (marketingEventSession == null) {
			Session session = null;

			try {
				session = openSession();

				marketingEventSession = (MarketingEventSession)session.get(MarketingEventSessionImpl.class,
						primaryKey);

				if (marketingEventSession != null) {
					cacheResult(marketingEventSession);
				}
				else {
					entityCache.putResult(MarketingEventSessionModelImpl.ENTITY_CACHE_ENABLED,
						MarketingEventSessionImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(MarketingEventSessionModelImpl.ENTITY_CACHE_ENABLED,
					MarketingEventSessionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return marketingEventSession;
	}

	/**
	 * Returns the marketing event session with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param marketingEventSessionId the primary key of the marketing event session
	 * @return the marketing event session, or <code>null</code> if a marketing event session with the primary key could not be found
	 */
	@Override
	public MarketingEventSession fetchByPrimaryKey(long marketingEventSessionId) {
		return fetchByPrimaryKey((Serializable)marketingEventSessionId);
	}

	@Override
	public Map<Serializable, MarketingEventSession> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, MarketingEventSession> map = new HashMap<Serializable, MarketingEventSession>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			MarketingEventSession marketingEventSession = fetchByPrimaryKey(primaryKey);

			if (marketingEventSession != null) {
				map.put(primaryKey, marketingEventSession);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(MarketingEventSessionModelImpl.ENTITY_CACHE_ENABLED,
					MarketingEventSessionImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (MarketingEventSession)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_MARKETINGEVENTSESSION_WHERE_PKS_IN);

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

			for (MarketingEventSession marketingEventSession : (List<MarketingEventSession>)q.list()) {
				map.put(marketingEventSession.getPrimaryKeyObj(),
					marketingEventSession);

				cacheResult(marketingEventSession);

				uncachedPrimaryKeys.remove(marketingEventSession.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(MarketingEventSessionModelImpl.ENTITY_CACHE_ENABLED,
					MarketingEventSessionImpl.class, primaryKey, nullModel);
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
	 * Returns all the marketing event sessions.
	 *
	 * @return the marketing event sessions
	 */
	@Override
	public List<MarketingEventSession> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the marketing event sessions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of marketing event sessions
	 * @param end the upper bound of the range of marketing event sessions (not inclusive)
	 * @return the range of marketing event sessions
	 */
	@Override
	public List<MarketingEventSession> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the marketing event sessions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of marketing event sessions
	 * @param end the upper bound of the range of marketing event sessions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of marketing event sessions
	 */
	@Override
	public List<MarketingEventSession> findAll(int start, int end,
		OrderByComparator<MarketingEventSession> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the marketing event sessions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of marketing event sessions
	 * @param end the upper bound of the range of marketing event sessions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of marketing event sessions
	 */
	@Override
	public List<MarketingEventSession> findAll(int start, int end,
		OrderByComparator<MarketingEventSession> orderByComparator,
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

		List<MarketingEventSession> list = null;

		if (retrieveFromCache) {
			list = (List<MarketingEventSession>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_MARKETINGEVENTSESSION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MARKETINGEVENTSESSION;

				if (pagination) {
					sql = sql.concat(MarketingEventSessionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<MarketingEventSession>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MarketingEventSession>)QueryUtil.list(q,
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
	 * Removes all the marketing event sessions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (MarketingEventSession marketingEventSession : findAll()) {
			remove(marketingEventSession);
		}
	}

	/**
	 * Returns the number of marketing event sessions.
	 *
	 * @return the number of marketing event sessions
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_MARKETINGEVENTSESSION);

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

	/**
	 * Returns the primaryKeys of marketing event users associated with the marketing event session.
	 *
	 * @param pk the primary key of the marketing event session
	 * @return long[] of the primaryKeys of marketing event users associated with the marketing event session
	 */
	@Override
	public long[] getMarketingEventUserPrimaryKeys(long pk) {
		long[] pks = marketingEventSessionToMarketingEventUserTableMapper.getRightPrimaryKeys(pk);

		return pks.clone();
	}

	/**
	 * Returns all the marketing event users associated with the marketing event session.
	 *
	 * @param pk the primary key of the marketing event session
	 * @return the marketing event users associated with the marketing event session
	 */
	@Override
	public List<com.liferay.osb.www.marketing.events.model.MarketingEventUser> getMarketingEventUsers(
		long pk) {
		return getMarketingEventUsers(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the marketing event users associated with the marketing event session.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the marketing event session
	 * @param start the lower bound of the range of marketing event sessions
	 * @param end the upper bound of the range of marketing event sessions (not inclusive)
	 * @return the range of marketing event users associated with the marketing event session
	 */
	@Override
	public List<com.liferay.osb.www.marketing.events.model.MarketingEventUser> getMarketingEventUsers(
		long pk, int start, int end) {
		return getMarketingEventUsers(pk, start, end, null);
	}

	/**
	 * Returns an ordered range of all the marketing event users associated with the marketing event session.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the marketing event session
	 * @param start the lower bound of the range of marketing event sessions
	 * @param end the upper bound of the range of marketing event sessions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of marketing event users associated with the marketing event session
	 */
	@Override
	public List<com.liferay.osb.www.marketing.events.model.MarketingEventUser> getMarketingEventUsers(
		long pk, int start, int end,
		OrderByComparator<com.liferay.osb.www.marketing.events.model.MarketingEventUser> orderByComparator) {
		return marketingEventSessionToMarketingEventUserTableMapper.getRightBaseModels(pk,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of marketing event users associated with the marketing event session.
	 *
	 * @param pk the primary key of the marketing event session
	 * @return the number of marketing event users associated with the marketing event session
	 */
	@Override
	public int getMarketingEventUsersSize(long pk) {
		long[] pks = marketingEventSessionToMarketingEventUserTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the marketing event user is associated with the marketing event session.
	 *
	 * @param pk the primary key of the marketing event session
	 * @param marketingEventUserPK the primary key of the marketing event user
	 * @return <code>true</code> if the marketing event user is associated with the marketing event session; <code>false</code> otherwise
	 */
	@Override
	public boolean containsMarketingEventUser(long pk, long marketingEventUserPK) {
		return marketingEventSessionToMarketingEventUserTableMapper.containsTableMapping(pk,
			marketingEventUserPK);
	}

	/**
	 * Returns <code>true</code> if the marketing event session has any marketing event users associated with it.
	 *
	 * @param pk the primary key of the marketing event session to check for associations with marketing event users
	 * @return <code>true</code> if the marketing event session has any marketing event users associated with it; <code>false</code> otherwise
	 */
	@Override
	public boolean containsMarketingEventUsers(long pk) {
		if (getMarketingEventUsersSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the marketing event session and the marketing event user. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the marketing event session
	 * @param marketingEventUserPK the primary key of the marketing event user
	 */
	@Override
	public void addMarketingEventUser(long pk, long marketingEventUserPK) {
		MarketingEventSession marketingEventSession = fetchByPrimaryKey(pk);

		if (marketingEventSession == null) {
			marketingEventSessionToMarketingEventUserTableMapper.addTableMapping(companyProvider.getCompanyId(),
				pk, marketingEventUserPK);
		}
		else {
			marketingEventSessionToMarketingEventUserTableMapper.addTableMapping(marketingEventSession.getCompanyId(),
				pk, marketingEventUserPK);
		}
	}

	/**
	 * Adds an association between the marketing event session and the marketing event user. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the marketing event session
	 * @param marketingEventUser the marketing event user
	 */
	@Override
	public void addMarketingEventUser(long pk,
		com.liferay.osb.www.marketing.events.model.MarketingEventUser marketingEventUser) {
		MarketingEventSession marketingEventSession = fetchByPrimaryKey(pk);

		if (marketingEventSession == null) {
			marketingEventSessionToMarketingEventUserTableMapper.addTableMapping(companyProvider.getCompanyId(),
				pk, marketingEventUser.getPrimaryKey());
		}
		else {
			marketingEventSessionToMarketingEventUserTableMapper.addTableMapping(marketingEventSession.getCompanyId(),
				pk, marketingEventUser.getPrimaryKey());
		}
	}

	/**
	 * Adds an association between the marketing event session and the marketing event users. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the marketing event session
	 * @param marketingEventUserPKs the primary keys of the marketing event users
	 */
	@Override
	public void addMarketingEventUsers(long pk, long[] marketingEventUserPKs) {
		long companyId = 0;

		MarketingEventSession marketingEventSession = fetchByPrimaryKey(pk);

		if (marketingEventSession == null) {
			companyId = companyProvider.getCompanyId();
		}
		else {
			companyId = marketingEventSession.getCompanyId();
		}

		marketingEventSessionToMarketingEventUserTableMapper.addTableMappings(companyId,
			pk, marketingEventUserPKs);
	}

	/**
	 * Adds an association between the marketing event session and the marketing event users. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the marketing event session
	 * @param marketingEventUsers the marketing event users
	 */
	@Override
	public void addMarketingEventUsers(long pk,
		List<com.liferay.osb.www.marketing.events.model.MarketingEventUser> marketingEventUsers) {
		addMarketingEventUsers(pk,
			ListUtil.toLongArray(marketingEventUsers,
				com.liferay.osb.www.marketing.events.model.MarketingEventUser.MARKETING_EVENT_USER_ID_ACCESSOR));
	}

	/**
	 * Clears all associations between the marketing event session and its marketing event users. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the marketing event session to clear the associated marketing event users from
	 */
	@Override
	public void clearMarketingEventUsers(long pk) {
		marketingEventSessionToMarketingEventUserTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the marketing event session and the marketing event user. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the marketing event session
	 * @param marketingEventUserPK the primary key of the marketing event user
	 */
	@Override
	public void removeMarketingEventUser(long pk, long marketingEventUserPK) {
		marketingEventSessionToMarketingEventUserTableMapper.deleteTableMapping(pk,
			marketingEventUserPK);
	}

	/**
	 * Removes the association between the marketing event session and the marketing event user. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the marketing event session
	 * @param marketingEventUser the marketing event user
	 */
	@Override
	public void removeMarketingEventUser(long pk,
		com.liferay.osb.www.marketing.events.model.MarketingEventUser marketingEventUser) {
		marketingEventSessionToMarketingEventUserTableMapper.deleteTableMapping(pk,
			marketingEventUser.getPrimaryKey());
	}

	/**
	 * Removes the association between the marketing event session and the marketing event users. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the marketing event session
	 * @param marketingEventUserPKs the primary keys of the marketing event users
	 */
	@Override
	public void removeMarketingEventUsers(long pk, long[] marketingEventUserPKs) {
		marketingEventSessionToMarketingEventUserTableMapper.deleteTableMappings(pk,
			marketingEventUserPKs);
	}

	/**
	 * Removes the association between the marketing event session and the marketing event users. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the marketing event session
	 * @param marketingEventUsers the marketing event users
	 */
	@Override
	public void removeMarketingEventUsers(long pk,
		List<com.liferay.osb.www.marketing.events.model.MarketingEventUser> marketingEventUsers) {
		removeMarketingEventUsers(pk,
			ListUtil.toLongArray(marketingEventUsers,
				com.liferay.osb.www.marketing.events.model.MarketingEventUser.MARKETING_EVENT_USER_ID_ACCESSOR));
	}

	/**
	 * Sets the marketing event users associated with the marketing event session, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the marketing event session
	 * @param marketingEventUserPKs the primary keys of the marketing event users to be associated with the marketing event session
	 */
	@Override
	public void setMarketingEventUsers(long pk, long[] marketingEventUserPKs) {
		Set<Long> newMarketingEventUserPKsSet = SetUtil.fromArray(marketingEventUserPKs);
		Set<Long> oldMarketingEventUserPKsSet = SetUtil.fromArray(marketingEventSessionToMarketingEventUserTableMapper.getRightPrimaryKeys(
					pk));

		Set<Long> removeMarketingEventUserPKsSet = new HashSet<Long>(oldMarketingEventUserPKsSet);

		removeMarketingEventUserPKsSet.removeAll(newMarketingEventUserPKsSet);

		marketingEventSessionToMarketingEventUserTableMapper.deleteTableMappings(pk,
			ArrayUtil.toLongArray(removeMarketingEventUserPKsSet));

		newMarketingEventUserPKsSet.removeAll(oldMarketingEventUserPKsSet);

		long companyId = 0;

		MarketingEventSession marketingEventSession = fetchByPrimaryKey(pk);

		if (marketingEventSession == null) {
			companyId = companyProvider.getCompanyId();
		}
		else {
			companyId = marketingEventSession.getCompanyId();
		}

		marketingEventSessionToMarketingEventUserTableMapper.addTableMappings(companyId,
			pk, ArrayUtil.toLongArray(newMarketingEventUserPKsSet));
	}

	/**
	 * Sets the marketing event users associated with the marketing event session, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the marketing event session
	 * @param marketingEventUsers the marketing event users to be associated with the marketing event session
	 */
	@Override
	public void setMarketingEventUsers(long pk,
		List<com.liferay.osb.www.marketing.events.model.MarketingEventUser> marketingEventUsers) {
		try {
			long[] marketingEventUserPKs = new long[marketingEventUsers.size()];

			for (int i = 0; i < marketingEventUsers.size(); i++) {
				com.liferay.osb.www.marketing.events.model.MarketingEventUser marketingEventUser =
					marketingEventUsers.get(i);

				marketingEventUserPKs[i] = marketingEventUser.getPrimaryKey();
			}

			setMarketingEventUsers(pk, marketingEventUserPKs);
		}
		catch (Exception e) {
			throw processException(e);
		}
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return MarketingEventSessionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the marketing event session persistence.
	 */
	public void afterPropertiesSet() {
		marketingEventSessionToMarketingEventUserTableMapper = TableMapperFactory.getTableMapper("OSB_MarketingEventSessions_MarketingEventUsers",
				"companyId", "marketingEventSessionId", "marketingEventUserId",
				this, marketingEventUserPersistence);
	}

	public void destroy() {
		entityCache.removeCache(MarketingEventSessionImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		TableMapperFactory.removeTableMapper(
			"OSB_MarketingEventSessions_MarketingEventUsers");
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	@BeanReference(type = MarketingEventUserPersistence.class)
	protected MarketingEventUserPersistence marketingEventUserPersistence;
	protected TableMapper<MarketingEventSession, com.liferay.osb.www.marketing.events.model.MarketingEventUser> marketingEventSessionToMarketingEventUserTableMapper;
	private static final String _SQL_SELECT_MARKETINGEVENTSESSION = "SELECT marketingEventSession FROM MarketingEventSession marketingEventSession";
	private static final String _SQL_SELECT_MARKETINGEVENTSESSION_WHERE_PKS_IN = "SELECT marketingEventSession FROM MarketingEventSession marketingEventSession WHERE marketingEventSessionId IN (";
	private static final String _SQL_SELECT_MARKETINGEVENTSESSION_WHERE = "SELECT marketingEventSession FROM MarketingEventSession marketingEventSession WHERE ";
	private static final String _SQL_COUNT_MARKETINGEVENTSESSION = "SELECT COUNT(marketingEventSession) FROM MarketingEventSession marketingEventSession";
	private static final String _SQL_COUNT_MARKETINGEVENTSESSION_WHERE = "SELECT COUNT(marketingEventSession) FROM MarketingEventSession marketingEventSession WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "marketingEventSession.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MarketingEventSession exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No MarketingEventSession exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(MarketingEventSessionPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}