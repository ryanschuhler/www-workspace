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

import com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventUserException;
import com.liferay.osb.www.marketing.events.model.MarketingEventUser;
import com.liferay.osb.www.marketing.events.model.impl.MarketingEventUserImpl;
import com.liferay.osb.www.marketing.events.model.impl.MarketingEventUserModelImpl;
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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
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
 * The persistence implementation for the marketing event user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEventUserPersistence
 * @see com.liferay.osb.www.marketing.events.service.persistence.MarketingEventUserUtil
 * @generated
 */
@ProviderType
public class MarketingEventUserPersistenceImpl extends BasePersistenceImpl<MarketingEventUser>
	implements MarketingEventUserPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MarketingEventUserUtil} to access the marketing event user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MarketingEventUserImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MarketingEventUserModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventUserModelImpl.FINDER_CACHE_ENABLED,
			MarketingEventUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MarketingEventUserModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventUserModelImpl.FINDER_CACHE_ENABLED,
			MarketingEventUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MarketingEventUserModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(MarketingEventUserModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventUserModelImpl.FINDER_CACHE_ENABLED,
			MarketingEventUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(MarketingEventUserModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventUserModelImpl.FINDER_CACHE_ENABLED,
			MarketingEventUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			MarketingEventUserModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(MarketingEventUserModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the marketing event users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching marketing event users
	 */
	@Override
	public List<MarketingEventUser> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the marketing event users where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of marketing event users
	 * @param end the upper bound of the range of marketing event users (not inclusive)
	 * @return the range of matching marketing event users
	 */
	@Override
	public List<MarketingEventUser> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the marketing event users where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of marketing event users
	 * @param end the upper bound of the range of marketing event users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching marketing event users
	 */
	@Override
	public List<MarketingEventUser> findByUuid(String uuid, int start, int end,
		OrderByComparator<MarketingEventUser> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the marketing event users where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of marketing event users
	 * @param end the upper bound of the range of marketing event users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching marketing event users
	 */
	@Override
	public List<MarketingEventUser> findByUuid(String uuid, int start, int end,
		OrderByComparator<MarketingEventUser> orderByComparator,
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

		List<MarketingEventUser> list = null;

		if (retrieveFromCache) {
			list = (List<MarketingEventUser>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MarketingEventUser marketingEventUser : list) {
					if (!Objects.equals(uuid, marketingEventUser.getUuid())) {
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

			query.append(_SQL_SELECT_MARKETINGEVENTUSER_WHERE);

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
				query.append(MarketingEventUserModelImpl.ORDER_BY_JPQL);
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
					list = (List<MarketingEventUser>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MarketingEventUser>)QueryUtil.list(q,
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
	 * Returns the first marketing event user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching marketing event user
	 * @throws NoSuchMarketingEventUserException if a matching marketing event user could not be found
	 */
	@Override
	public MarketingEventUser findByUuid_First(String uuid,
		OrderByComparator<MarketingEventUser> orderByComparator)
		throws NoSuchMarketingEventUserException {
		MarketingEventUser marketingEventUser = fetchByUuid_First(uuid,
				orderByComparator);

		if (marketingEventUser != null) {
			return marketingEventUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchMarketingEventUserException(msg.toString());
	}

	/**
	 * Returns the first marketing event user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching marketing event user, or <code>null</code> if a matching marketing event user could not be found
	 */
	@Override
	public MarketingEventUser fetchByUuid_First(String uuid,
		OrderByComparator<MarketingEventUser> orderByComparator) {
		List<MarketingEventUser> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last marketing event user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching marketing event user
	 * @throws NoSuchMarketingEventUserException if a matching marketing event user could not be found
	 */
	@Override
	public MarketingEventUser findByUuid_Last(String uuid,
		OrderByComparator<MarketingEventUser> orderByComparator)
		throws NoSuchMarketingEventUserException {
		MarketingEventUser marketingEventUser = fetchByUuid_Last(uuid,
				orderByComparator);

		if (marketingEventUser != null) {
			return marketingEventUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchMarketingEventUserException(msg.toString());
	}

	/**
	 * Returns the last marketing event user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching marketing event user, or <code>null</code> if a matching marketing event user could not be found
	 */
	@Override
	public MarketingEventUser fetchByUuid_Last(String uuid,
		OrderByComparator<MarketingEventUser> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<MarketingEventUser> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the marketing event users before and after the current marketing event user in the ordered set where uuid = &#63;.
	 *
	 * @param marketingEventUserId the primary key of the current marketing event user
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next marketing event user
	 * @throws NoSuchMarketingEventUserException if a marketing event user with the primary key could not be found
	 */
	@Override
	public MarketingEventUser[] findByUuid_PrevAndNext(
		long marketingEventUserId, String uuid,
		OrderByComparator<MarketingEventUser> orderByComparator)
		throws NoSuchMarketingEventUserException {
		MarketingEventUser marketingEventUser = findByPrimaryKey(marketingEventUserId);

		Session session = null;

		try {
			session = openSession();

			MarketingEventUser[] array = new MarketingEventUserImpl[3];

			array[0] = getByUuid_PrevAndNext(session, marketingEventUser, uuid,
					orderByComparator, true);

			array[1] = marketingEventUser;

			array[2] = getByUuid_PrevAndNext(session, marketingEventUser, uuid,
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

	protected MarketingEventUser getByUuid_PrevAndNext(Session session,
		MarketingEventUser marketingEventUser, String uuid,
		OrderByComparator<MarketingEventUser> orderByComparator,
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

		query.append(_SQL_SELECT_MARKETINGEVENTUSER_WHERE);

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
			query.append(MarketingEventUserModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(marketingEventUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MarketingEventUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the marketing event users where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (MarketingEventUser marketingEventUser : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(marketingEventUser);
		}
	}

	/**
	 * Returns the number of marketing event users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching marketing event users
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MARKETINGEVENTUSER_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "marketingEventUser.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "marketingEventUser.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(marketingEventUser.uuid IS NULL OR marketingEventUser.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(MarketingEventUserModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventUserModelImpl.FINDER_CACHE_ENABLED,
			MarketingEventUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(MarketingEventUserModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventUserModelImpl.FINDER_CACHE_ENABLED,
			MarketingEventUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			MarketingEventUserModelImpl.UUID_COLUMN_BITMASK |
			MarketingEventUserModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(MarketingEventUserModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the marketing event users where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching marketing event users
	 */
	@Override
	public List<MarketingEventUser> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the marketing event users where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of marketing event users
	 * @param end the upper bound of the range of marketing event users (not inclusive)
	 * @return the range of matching marketing event users
	 */
	@Override
	public List<MarketingEventUser> findByUuid_C(String uuid, long companyId,
		int start, int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the marketing event users where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of marketing event users
	 * @param end the upper bound of the range of marketing event users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching marketing event users
	 */
	@Override
	public List<MarketingEventUser> findByUuid_C(String uuid, long companyId,
		int start, int end,
		OrderByComparator<MarketingEventUser> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the marketing event users where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of marketing event users
	 * @param end the upper bound of the range of marketing event users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching marketing event users
	 */
	@Override
	public List<MarketingEventUser> findByUuid_C(String uuid, long companyId,
		int start, int end,
		OrderByComparator<MarketingEventUser> orderByComparator,
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

		List<MarketingEventUser> list = null;

		if (retrieveFromCache) {
			list = (List<MarketingEventUser>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MarketingEventUser marketingEventUser : list) {
					if (!Objects.equals(uuid, marketingEventUser.getUuid()) ||
							(companyId != marketingEventUser.getCompanyId())) {
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

			query.append(_SQL_SELECT_MARKETINGEVENTUSER_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals("")) {
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
				query.append(MarketingEventUserModelImpl.ORDER_BY_JPQL);
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
					list = (List<MarketingEventUser>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MarketingEventUser>)QueryUtil.list(q,
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
	 * Returns the first marketing event user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching marketing event user
	 * @throws NoSuchMarketingEventUserException if a matching marketing event user could not be found
	 */
	@Override
	public MarketingEventUser findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<MarketingEventUser> orderByComparator)
		throws NoSuchMarketingEventUserException {
		MarketingEventUser marketingEventUser = fetchByUuid_C_First(uuid,
				companyId, orderByComparator);

		if (marketingEventUser != null) {
			return marketingEventUser;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchMarketingEventUserException(msg.toString());
	}

	/**
	 * Returns the first marketing event user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching marketing event user, or <code>null</code> if a matching marketing event user could not be found
	 */
	@Override
	public MarketingEventUser fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<MarketingEventUser> orderByComparator) {
		List<MarketingEventUser> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last marketing event user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching marketing event user
	 * @throws NoSuchMarketingEventUserException if a matching marketing event user could not be found
	 */
	@Override
	public MarketingEventUser findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<MarketingEventUser> orderByComparator)
		throws NoSuchMarketingEventUserException {
		MarketingEventUser marketingEventUser = fetchByUuid_C_Last(uuid,
				companyId, orderByComparator);

		if (marketingEventUser != null) {
			return marketingEventUser;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchMarketingEventUserException(msg.toString());
	}

	/**
	 * Returns the last marketing event user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching marketing event user, or <code>null</code> if a matching marketing event user could not be found
	 */
	@Override
	public MarketingEventUser fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<MarketingEventUser> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<MarketingEventUser> list = findByUuid_C(uuid, companyId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the marketing event users before and after the current marketing event user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param marketingEventUserId the primary key of the current marketing event user
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next marketing event user
	 * @throws NoSuchMarketingEventUserException if a marketing event user with the primary key could not be found
	 */
	@Override
	public MarketingEventUser[] findByUuid_C_PrevAndNext(
		long marketingEventUserId, String uuid, long companyId,
		OrderByComparator<MarketingEventUser> orderByComparator)
		throws NoSuchMarketingEventUserException {
		MarketingEventUser marketingEventUser = findByPrimaryKey(marketingEventUserId);

		Session session = null;

		try {
			session = openSession();

			MarketingEventUser[] array = new MarketingEventUserImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, marketingEventUser,
					uuid, companyId, orderByComparator, true);

			array[1] = marketingEventUser;

			array[2] = getByUuid_C_PrevAndNext(session, marketingEventUser,
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

	protected MarketingEventUser getByUuid_C_PrevAndNext(Session session,
		MarketingEventUser marketingEventUser, String uuid, long companyId,
		OrderByComparator<MarketingEventUser> orderByComparator,
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

		query.append(_SQL_SELECT_MARKETINGEVENTUSER_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals("")) {
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
			query.append(MarketingEventUserModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(marketingEventUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MarketingEventUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the marketing event users where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (MarketingEventUser marketingEventUser : findByUuid_C(uuid,
				companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(marketingEventUser);
		}
	}

	/**
	 * Returns the number of marketing event users where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching marketing event users
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MARKETINGEVENTUSER_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals("")) {
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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "marketingEventUser.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "marketingEventUser.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(marketingEventUser.uuid IS NULL OR marketingEventUser.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "marketingEventUser.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MARKETINGEVENTID =
		new FinderPath(MarketingEventUserModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventUserModelImpl.FINDER_CACHE_ENABLED,
			MarketingEventUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMarketingEventId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MARKETINGEVENTID =
		new FinderPath(MarketingEventUserModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventUserModelImpl.FINDER_CACHE_ENABLED,
			MarketingEventUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByMarketingEventId", new String[] { Long.class.getName() },
			MarketingEventUserModelImpl.MARKETINGEVENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MARKETINGEVENTID = new FinderPath(MarketingEventUserModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByMarketingEventId", new String[] { Long.class.getName() });

	/**
	 * Returns all the marketing event users where marketingEventId = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @return the matching marketing event users
	 */
	@Override
	public List<MarketingEventUser> findByMarketingEventId(
		long marketingEventId) {
		return findByMarketingEventId(marketingEventId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the marketing event users where marketingEventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param marketingEventId the marketing event ID
	 * @param start the lower bound of the range of marketing event users
	 * @param end the upper bound of the range of marketing event users (not inclusive)
	 * @return the range of matching marketing event users
	 */
	@Override
	public List<MarketingEventUser> findByMarketingEventId(
		long marketingEventId, int start, int end) {
		return findByMarketingEventId(marketingEventId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the marketing event users where marketingEventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param marketingEventId the marketing event ID
	 * @param start the lower bound of the range of marketing event users
	 * @param end the upper bound of the range of marketing event users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching marketing event users
	 */
	@Override
	public List<MarketingEventUser> findByMarketingEventId(
		long marketingEventId, int start, int end,
		OrderByComparator<MarketingEventUser> orderByComparator) {
		return findByMarketingEventId(marketingEventId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the marketing event users where marketingEventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param marketingEventId the marketing event ID
	 * @param start the lower bound of the range of marketing event users
	 * @param end the upper bound of the range of marketing event users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching marketing event users
	 */
	@Override
	public List<MarketingEventUser> findByMarketingEventId(
		long marketingEventId, int start, int end,
		OrderByComparator<MarketingEventUser> orderByComparator,
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

		List<MarketingEventUser> list = null;

		if (retrieveFromCache) {
			list = (List<MarketingEventUser>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MarketingEventUser marketingEventUser : list) {
					if ((marketingEventId != marketingEventUser.getMarketingEventId())) {
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

			query.append(_SQL_SELECT_MARKETINGEVENTUSER_WHERE);

			query.append(_FINDER_COLUMN_MARKETINGEVENTID_MARKETINGEVENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MarketingEventUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(marketingEventId);

				if (!pagination) {
					list = (List<MarketingEventUser>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MarketingEventUser>)QueryUtil.list(q,
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
	 * Returns the first marketing event user in the ordered set where marketingEventId = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching marketing event user
	 * @throws NoSuchMarketingEventUserException if a matching marketing event user could not be found
	 */
	@Override
	public MarketingEventUser findByMarketingEventId_First(
		long marketingEventId,
		OrderByComparator<MarketingEventUser> orderByComparator)
		throws NoSuchMarketingEventUserException {
		MarketingEventUser marketingEventUser = fetchByMarketingEventId_First(marketingEventId,
				orderByComparator);

		if (marketingEventUser != null) {
			return marketingEventUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("marketingEventId=");
		msg.append(marketingEventId);

		msg.append("}");

		throw new NoSuchMarketingEventUserException(msg.toString());
	}

	/**
	 * Returns the first marketing event user in the ordered set where marketingEventId = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching marketing event user, or <code>null</code> if a matching marketing event user could not be found
	 */
	@Override
	public MarketingEventUser fetchByMarketingEventId_First(
		long marketingEventId,
		OrderByComparator<MarketingEventUser> orderByComparator) {
		List<MarketingEventUser> list = findByMarketingEventId(marketingEventId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last marketing event user in the ordered set where marketingEventId = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching marketing event user
	 * @throws NoSuchMarketingEventUserException if a matching marketing event user could not be found
	 */
	@Override
	public MarketingEventUser findByMarketingEventId_Last(
		long marketingEventId,
		OrderByComparator<MarketingEventUser> orderByComparator)
		throws NoSuchMarketingEventUserException {
		MarketingEventUser marketingEventUser = fetchByMarketingEventId_Last(marketingEventId,
				orderByComparator);

		if (marketingEventUser != null) {
			return marketingEventUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("marketingEventId=");
		msg.append(marketingEventId);

		msg.append("}");

		throw new NoSuchMarketingEventUserException(msg.toString());
	}

	/**
	 * Returns the last marketing event user in the ordered set where marketingEventId = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching marketing event user, or <code>null</code> if a matching marketing event user could not be found
	 */
	@Override
	public MarketingEventUser fetchByMarketingEventId_Last(
		long marketingEventId,
		OrderByComparator<MarketingEventUser> orderByComparator) {
		int count = countByMarketingEventId(marketingEventId);

		if (count == 0) {
			return null;
		}

		List<MarketingEventUser> list = findByMarketingEventId(marketingEventId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the marketing event users before and after the current marketing event user in the ordered set where marketingEventId = &#63;.
	 *
	 * @param marketingEventUserId the primary key of the current marketing event user
	 * @param marketingEventId the marketing event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next marketing event user
	 * @throws NoSuchMarketingEventUserException if a marketing event user with the primary key could not be found
	 */
	@Override
	public MarketingEventUser[] findByMarketingEventId_PrevAndNext(
		long marketingEventUserId, long marketingEventId,
		OrderByComparator<MarketingEventUser> orderByComparator)
		throws NoSuchMarketingEventUserException {
		MarketingEventUser marketingEventUser = findByPrimaryKey(marketingEventUserId);

		Session session = null;

		try {
			session = openSession();

			MarketingEventUser[] array = new MarketingEventUserImpl[3];

			array[0] = getByMarketingEventId_PrevAndNext(session,
					marketingEventUser, marketingEventId, orderByComparator,
					true);

			array[1] = marketingEventUser;

			array[2] = getByMarketingEventId_PrevAndNext(session,
					marketingEventUser, marketingEventId, orderByComparator,
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

	protected MarketingEventUser getByMarketingEventId_PrevAndNext(
		Session session, MarketingEventUser marketingEventUser,
		long marketingEventId,
		OrderByComparator<MarketingEventUser> orderByComparator,
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

		query.append(_SQL_SELECT_MARKETINGEVENTUSER_WHERE);

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
			query.append(MarketingEventUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(marketingEventId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(marketingEventUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MarketingEventUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the marketing event users where marketingEventId = &#63; from the database.
	 *
	 * @param marketingEventId the marketing event ID
	 */
	@Override
	public void removeByMarketingEventId(long marketingEventId) {
		for (MarketingEventUser marketingEventUser : findByMarketingEventId(
				marketingEventId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(marketingEventUser);
		}
	}

	/**
	 * Returns the number of marketing event users where marketingEventId = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @return the number of matching marketing event users
	 */
	@Override
	public int countByMarketingEventId(long marketingEventId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MARKETINGEVENTID;

		Object[] finderArgs = new Object[] { marketingEventId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MARKETINGEVENTUSER_WHERE);

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
		"marketingEventUser.marketingEventId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MEI_S = new FinderPath(MarketingEventUserModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventUserModelImpl.FINDER_CACHE_ENABLED,
			MarketingEventUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMEI_S",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEI_S = new FinderPath(MarketingEventUserModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventUserModelImpl.FINDER_CACHE_ENABLED,
			MarketingEventUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMEI_S",
			new String[] { Long.class.getName(), Integer.class.getName() },
			MarketingEventUserModelImpl.MARKETINGEVENTID_COLUMN_BITMASK |
			MarketingEventUserModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MEI_S = new FinderPath(MarketingEventUserModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMEI_S",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the marketing event users where marketingEventId = &#63; and status = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param status the status
	 * @return the matching marketing event users
	 */
	@Override
	public List<MarketingEventUser> findByMEI_S(long marketingEventId,
		int status) {
		return findByMEI_S(marketingEventId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the marketing event users where marketingEventId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param marketingEventId the marketing event ID
	 * @param status the status
	 * @param start the lower bound of the range of marketing event users
	 * @param end the upper bound of the range of marketing event users (not inclusive)
	 * @return the range of matching marketing event users
	 */
	@Override
	public List<MarketingEventUser> findByMEI_S(long marketingEventId,
		int status, int start, int end) {
		return findByMEI_S(marketingEventId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the marketing event users where marketingEventId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param marketingEventId the marketing event ID
	 * @param status the status
	 * @param start the lower bound of the range of marketing event users
	 * @param end the upper bound of the range of marketing event users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching marketing event users
	 */
	@Override
	public List<MarketingEventUser> findByMEI_S(long marketingEventId,
		int status, int start, int end,
		OrderByComparator<MarketingEventUser> orderByComparator) {
		return findByMEI_S(marketingEventId, status, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the marketing event users where marketingEventId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param marketingEventId the marketing event ID
	 * @param status the status
	 * @param start the lower bound of the range of marketing event users
	 * @param end the upper bound of the range of marketing event users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching marketing event users
	 */
	@Override
	public List<MarketingEventUser> findByMEI_S(long marketingEventId,
		int status, int start, int end,
		OrderByComparator<MarketingEventUser> orderByComparator,
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

		List<MarketingEventUser> list = null;

		if (retrieveFromCache) {
			list = (List<MarketingEventUser>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MarketingEventUser marketingEventUser : list) {
					if ((marketingEventId != marketingEventUser.getMarketingEventId()) ||
							(status != marketingEventUser.getStatus())) {
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

			query.append(_SQL_SELECT_MARKETINGEVENTUSER_WHERE);

			query.append(_FINDER_COLUMN_MEI_S_MARKETINGEVENTID_2);

			query.append(_FINDER_COLUMN_MEI_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MarketingEventUserModelImpl.ORDER_BY_JPQL);
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
					list = (List<MarketingEventUser>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MarketingEventUser>)QueryUtil.list(q,
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
	 * Returns the first marketing event user in the ordered set where marketingEventId = &#63; and status = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching marketing event user
	 * @throws NoSuchMarketingEventUserException if a matching marketing event user could not be found
	 */
	@Override
	public MarketingEventUser findByMEI_S_First(long marketingEventId,
		int status, OrderByComparator<MarketingEventUser> orderByComparator)
		throws NoSuchMarketingEventUserException {
		MarketingEventUser marketingEventUser = fetchByMEI_S_First(marketingEventId,
				status, orderByComparator);

		if (marketingEventUser != null) {
			return marketingEventUser;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("marketingEventId=");
		msg.append(marketingEventId);

		msg.append(", status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchMarketingEventUserException(msg.toString());
	}

	/**
	 * Returns the first marketing event user in the ordered set where marketingEventId = &#63; and status = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching marketing event user, or <code>null</code> if a matching marketing event user could not be found
	 */
	@Override
	public MarketingEventUser fetchByMEI_S_First(long marketingEventId,
		int status, OrderByComparator<MarketingEventUser> orderByComparator) {
		List<MarketingEventUser> list = findByMEI_S(marketingEventId, status,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last marketing event user in the ordered set where marketingEventId = &#63; and status = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching marketing event user
	 * @throws NoSuchMarketingEventUserException if a matching marketing event user could not be found
	 */
	@Override
	public MarketingEventUser findByMEI_S_Last(long marketingEventId,
		int status, OrderByComparator<MarketingEventUser> orderByComparator)
		throws NoSuchMarketingEventUserException {
		MarketingEventUser marketingEventUser = fetchByMEI_S_Last(marketingEventId,
				status, orderByComparator);

		if (marketingEventUser != null) {
			return marketingEventUser;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("marketingEventId=");
		msg.append(marketingEventId);

		msg.append(", status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchMarketingEventUserException(msg.toString());
	}

	/**
	 * Returns the last marketing event user in the ordered set where marketingEventId = &#63; and status = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching marketing event user, or <code>null</code> if a matching marketing event user could not be found
	 */
	@Override
	public MarketingEventUser fetchByMEI_S_Last(long marketingEventId,
		int status, OrderByComparator<MarketingEventUser> orderByComparator) {
		int count = countByMEI_S(marketingEventId, status);

		if (count == 0) {
			return null;
		}

		List<MarketingEventUser> list = findByMEI_S(marketingEventId, status,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the marketing event users before and after the current marketing event user in the ordered set where marketingEventId = &#63; and status = &#63;.
	 *
	 * @param marketingEventUserId the primary key of the current marketing event user
	 * @param marketingEventId the marketing event ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next marketing event user
	 * @throws NoSuchMarketingEventUserException if a marketing event user with the primary key could not be found
	 */
	@Override
	public MarketingEventUser[] findByMEI_S_PrevAndNext(
		long marketingEventUserId, long marketingEventId, int status,
		OrderByComparator<MarketingEventUser> orderByComparator)
		throws NoSuchMarketingEventUserException {
		MarketingEventUser marketingEventUser = findByPrimaryKey(marketingEventUserId);

		Session session = null;

		try {
			session = openSession();

			MarketingEventUser[] array = new MarketingEventUserImpl[3];

			array[0] = getByMEI_S_PrevAndNext(session, marketingEventUser,
					marketingEventId, status, orderByComparator, true);

			array[1] = marketingEventUser;

			array[2] = getByMEI_S_PrevAndNext(session, marketingEventUser,
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

	protected MarketingEventUser getByMEI_S_PrevAndNext(Session session,
		MarketingEventUser marketingEventUser, long marketingEventId,
		int status, OrderByComparator<MarketingEventUser> orderByComparator,
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

		query.append(_SQL_SELECT_MARKETINGEVENTUSER_WHERE);

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
			query.append(MarketingEventUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(marketingEventId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(marketingEventUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MarketingEventUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the marketing event users where marketingEventId = &#63; and status = &#63; from the database.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param status the status
	 */
	@Override
	public void removeByMEI_S(long marketingEventId, int status) {
		for (MarketingEventUser marketingEventUser : findByMEI_S(
				marketingEventId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(marketingEventUser);
		}
	}

	/**
	 * Returns the number of marketing event users where marketingEventId = &#63; and status = &#63;.
	 *
	 * @param marketingEventId the marketing event ID
	 * @param status the status
	 * @return the number of matching marketing event users
	 */
	@Override
	public int countByMEI_S(long marketingEventId, int status) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MEI_S;

		Object[] finderArgs = new Object[] { marketingEventId, status };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MARKETINGEVENTUSER_WHERE);

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

	private static final String _FINDER_COLUMN_MEI_S_MARKETINGEVENTID_2 = "marketingEventUser.marketingEventId = ? AND ";
	private static final String _FINDER_COLUMN_MEI_S_STATUS_2 = "marketingEventUser.status = ?";

	public MarketingEventUserPersistenceImpl() {
		setModelClass(MarketingEventUser.class);

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
	 * Caches the marketing event user in the entity cache if it is enabled.
	 *
	 * @param marketingEventUser the marketing event user
	 */
	@Override
	public void cacheResult(MarketingEventUser marketingEventUser) {
		entityCache.putResult(MarketingEventUserModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventUserImpl.class, marketingEventUser.getPrimaryKey(),
			marketingEventUser);

		marketingEventUser.resetOriginalValues();
	}

	/**
	 * Caches the marketing event users in the entity cache if it is enabled.
	 *
	 * @param marketingEventUsers the marketing event users
	 */
	@Override
	public void cacheResult(List<MarketingEventUser> marketingEventUsers) {
		for (MarketingEventUser marketingEventUser : marketingEventUsers) {
			if (entityCache.getResult(
						MarketingEventUserModelImpl.ENTITY_CACHE_ENABLED,
						MarketingEventUserImpl.class,
						marketingEventUser.getPrimaryKey()) == null) {
				cacheResult(marketingEventUser);
			}
			else {
				marketingEventUser.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all marketing event users.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MarketingEventUserImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the marketing event user.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MarketingEventUser marketingEventUser) {
		entityCache.removeResult(MarketingEventUserModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventUserImpl.class, marketingEventUser.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<MarketingEventUser> marketingEventUsers) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MarketingEventUser marketingEventUser : marketingEventUsers) {
			entityCache.removeResult(MarketingEventUserModelImpl.ENTITY_CACHE_ENABLED,
				MarketingEventUserImpl.class, marketingEventUser.getPrimaryKey());
		}
	}

	/**
	 * Creates a new marketing event user with the primary key. Does not add the marketing event user to the database.
	 *
	 * @param marketingEventUserId the primary key for the new marketing event user
	 * @return the new marketing event user
	 */
	@Override
	public MarketingEventUser create(long marketingEventUserId) {
		MarketingEventUser marketingEventUser = new MarketingEventUserImpl();

		marketingEventUser.setNew(true);
		marketingEventUser.setPrimaryKey(marketingEventUserId);

		String uuid = PortalUUIDUtil.generate();

		marketingEventUser.setUuid(uuid);

		marketingEventUser.setCompanyId(companyProvider.getCompanyId());

		return marketingEventUser;
	}

	/**
	 * Removes the marketing event user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param marketingEventUserId the primary key of the marketing event user
	 * @return the marketing event user that was removed
	 * @throws NoSuchMarketingEventUserException if a marketing event user with the primary key could not be found
	 */
	@Override
	public MarketingEventUser remove(long marketingEventUserId)
		throws NoSuchMarketingEventUserException {
		return remove((Serializable)marketingEventUserId);
	}

	/**
	 * Removes the marketing event user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the marketing event user
	 * @return the marketing event user that was removed
	 * @throws NoSuchMarketingEventUserException if a marketing event user with the primary key could not be found
	 */
	@Override
	public MarketingEventUser remove(Serializable primaryKey)
		throws NoSuchMarketingEventUserException {
		Session session = null;

		try {
			session = openSession();

			MarketingEventUser marketingEventUser = (MarketingEventUser)session.get(MarketingEventUserImpl.class,
					primaryKey);

			if (marketingEventUser == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMarketingEventUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(marketingEventUser);
		}
		catch (NoSuchMarketingEventUserException nsee) {
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
	protected MarketingEventUser removeImpl(
		MarketingEventUser marketingEventUser) {
		marketingEventUser = toUnwrappedModel(marketingEventUser);

		marketingEventUserToMarketingEventSessionTableMapper.deleteLeftPrimaryKeyTableMappings(marketingEventUser.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(marketingEventUser)) {
				marketingEventUser = (MarketingEventUser)session.get(MarketingEventUserImpl.class,
						marketingEventUser.getPrimaryKeyObj());
			}

			if (marketingEventUser != null) {
				session.delete(marketingEventUser);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (marketingEventUser != null) {
			clearCache(marketingEventUser);
		}

		return marketingEventUser;
	}

	@Override
	public MarketingEventUser updateImpl(MarketingEventUser marketingEventUser) {
		marketingEventUser = toUnwrappedModel(marketingEventUser);

		boolean isNew = marketingEventUser.isNew();

		MarketingEventUserModelImpl marketingEventUserModelImpl = (MarketingEventUserModelImpl)marketingEventUser;

		if (Validator.isNull(marketingEventUser.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			marketingEventUser.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (marketingEventUser.getCreateDate() == null)) {
			if (serviceContext == null) {
				marketingEventUser.setCreateDate(now);
			}
			else {
				marketingEventUser.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!marketingEventUserModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				marketingEventUser.setModifiedDate(now);
			}
			else {
				marketingEventUser.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (marketingEventUser.isNew()) {
				session.save(marketingEventUser);

				marketingEventUser.setNew(false);
			}
			else {
				marketingEventUser = (MarketingEventUser)session.merge(marketingEventUser);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!MarketingEventUserModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { marketingEventUserModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] {
					marketingEventUserModelImpl.getUuid(),
					marketingEventUserModelImpl.getCompanyId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
				args);

			args = new Object[] {
					marketingEventUserModelImpl.getMarketingEventId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_MARKETINGEVENTID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MARKETINGEVENTID,
				args);

			args = new Object[] {
					marketingEventUserModelImpl.getMarketingEventId(),
					marketingEventUserModelImpl.getStatus()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_MEI_S, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEI_S,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((marketingEventUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						marketingEventUserModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { marketingEventUserModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((marketingEventUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						marketingEventUserModelImpl.getOriginalUuid(),
						marketingEventUserModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						marketingEventUserModelImpl.getUuid(),
						marketingEventUserModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((marketingEventUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MARKETINGEVENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						marketingEventUserModelImpl.getOriginalMarketingEventId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MARKETINGEVENTID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MARKETINGEVENTID,
					args);

				args = new Object[] {
						marketingEventUserModelImpl.getMarketingEventId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MARKETINGEVENTID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MARKETINGEVENTID,
					args);
			}

			if ((marketingEventUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEI_S.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						marketingEventUserModelImpl.getOriginalMarketingEventId(),
						marketingEventUserModelImpl.getOriginalStatus()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MEI_S, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEI_S,
					args);

				args = new Object[] {
						marketingEventUserModelImpl.getMarketingEventId(),
						marketingEventUserModelImpl.getStatus()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MEI_S, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEI_S,
					args);
			}
		}

		entityCache.putResult(MarketingEventUserModelImpl.ENTITY_CACHE_ENABLED,
			MarketingEventUserImpl.class, marketingEventUser.getPrimaryKey(),
			marketingEventUser, false);

		marketingEventUser.resetOriginalValues();

		return marketingEventUser;
	}

	protected MarketingEventUser toUnwrappedModel(
		MarketingEventUser marketingEventUser) {
		if (marketingEventUser instanceof MarketingEventUserImpl) {
			return marketingEventUser;
		}

		MarketingEventUserImpl marketingEventUserImpl = new MarketingEventUserImpl();

		marketingEventUserImpl.setNew(marketingEventUser.isNew());
		marketingEventUserImpl.setPrimaryKey(marketingEventUser.getPrimaryKey());

		marketingEventUserImpl.setUuid(marketingEventUser.getUuid());
		marketingEventUserImpl.setMarketingEventUserId(marketingEventUser.getMarketingEventUserId());
		marketingEventUserImpl.setCompanyId(marketingEventUser.getCompanyId());
		marketingEventUserImpl.setUserId(marketingEventUser.getUserId());
		marketingEventUserImpl.setUserName(marketingEventUser.getUserName());
		marketingEventUserImpl.setCreateDate(marketingEventUser.getCreateDate());
		marketingEventUserImpl.setModifiedDate(marketingEventUser.getModifiedDate());
		marketingEventUserImpl.setMarketingEventId(marketingEventUser.getMarketingEventId());
		marketingEventUserImpl.setFirstName(marketingEventUser.getFirstName());
		marketingEventUserImpl.setLastName(marketingEventUser.getLastName());
		marketingEventUserImpl.setCompanyName(marketingEventUser.getCompanyName());
		marketingEventUserImpl.setCompanyLogoFileEntryId(marketingEventUser.getCompanyLogoFileEntryId());
		marketingEventUserImpl.setJobTitle(marketingEventUser.getJobTitle());
		marketingEventUserImpl.setDescription(marketingEventUser.getDescription());
		marketingEventUserImpl.setImageFileEntryId(marketingEventUser.getImageFileEntryId());
		marketingEventUserImpl.setPhoneNumber(marketingEventUser.getPhoneNumber());
		marketingEventUserImpl.setStatus(marketingEventUser.getStatus());
		marketingEventUserImpl.setStatusByUserId(marketingEventUser.getStatusByUserId());
		marketingEventUserImpl.setStatusByUserName(marketingEventUser.getStatusByUserName());
		marketingEventUserImpl.setStatusDate(marketingEventUser.getStatusDate());

		return marketingEventUserImpl;
	}

	/**
	 * Returns the marketing event user with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the marketing event user
	 * @return the marketing event user
	 * @throws NoSuchMarketingEventUserException if a marketing event user with the primary key could not be found
	 */
	@Override
	public MarketingEventUser findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMarketingEventUserException {
		MarketingEventUser marketingEventUser = fetchByPrimaryKey(primaryKey);

		if (marketingEventUser == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMarketingEventUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return marketingEventUser;
	}

	/**
	 * Returns the marketing event user with the primary key or throws a {@link NoSuchMarketingEventUserException} if it could not be found.
	 *
	 * @param marketingEventUserId the primary key of the marketing event user
	 * @return the marketing event user
	 * @throws NoSuchMarketingEventUserException if a marketing event user with the primary key could not be found
	 */
	@Override
	public MarketingEventUser findByPrimaryKey(long marketingEventUserId)
		throws NoSuchMarketingEventUserException {
		return findByPrimaryKey((Serializable)marketingEventUserId);
	}

	/**
	 * Returns the marketing event user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the marketing event user
	 * @return the marketing event user, or <code>null</code> if a marketing event user with the primary key could not be found
	 */
	@Override
	public MarketingEventUser fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(MarketingEventUserModelImpl.ENTITY_CACHE_ENABLED,
				MarketingEventUserImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		MarketingEventUser marketingEventUser = (MarketingEventUser)serializable;

		if (marketingEventUser == null) {
			Session session = null;

			try {
				session = openSession();

				marketingEventUser = (MarketingEventUser)session.get(MarketingEventUserImpl.class,
						primaryKey);

				if (marketingEventUser != null) {
					cacheResult(marketingEventUser);
				}
				else {
					entityCache.putResult(MarketingEventUserModelImpl.ENTITY_CACHE_ENABLED,
						MarketingEventUserImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(MarketingEventUserModelImpl.ENTITY_CACHE_ENABLED,
					MarketingEventUserImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return marketingEventUser;
	}

	/**
	 * Returns the marketing event user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param marketingEventUserId the primary key of the marketing event user
	 * @return the marketing event user, or <code>null</code> if a marketing event user with the primary key could not be found
	 */
	@Override
	public MarketingEventUser fetchByPrimaryKey(long marketingEventUserId) {
		return fetchByPrimaryKey((Serializable)marketingEventUserId);
	}

	@Override
	public Map<Serializable, MarketingEventUser> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, MarketingEventUser> map = new HashMap<Serializable, MarketingEventUser>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			MarketingEventUser marketingEventUser = fetchByPrimaryKey(primaryKey);

			if (marketingEventUser != null) {
				map.put(primaryKey, marketingEventUser);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(MarketingEventUserModelImpl.ENTITY_CACHE_ENABLED,
					MarketingEventUserImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (MarketingEventUser)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_MARKETINGEVENTUSER_WHERE_PKS_IN);

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

			for (MarketingEventUser marketingEventUser : (List<MarketingEventUser>)q.list()) {
				map.put(marketingEventUser.getPrimaryKeyObj(),
					marketingEventUser);

				cacheResult(marketingEventUser);

				uncachedPrimaryKeys.remove(marketingEventUser.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(MarketingEventUserModelImpl.ENTITY_CACHE_ENABLED,
					MarketingEventUserImpl.class, primaryKey, nullModel);
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
	 * Returns all the marketing event users.
	 *
	 * @return the marketing event users
	 */
	@Override
	public List<MarketingEventUser> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the marketing event users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of marketing event users
	 * @param end the upper bound of the range of marketing event users (not inclusive)
	 * @return the range of marketing event users
	 */
	@Override
	public List<MarketingEventUser> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the marketing event users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of marketing event users
	 * @param end the upper bound of the range of marketing event users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of marketing event users
	 */
	@Override
	public List<MarketingEventUser> findAll(int start, int end,
		OrderByComparator<MarketingEventUser> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the marketing event users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of marketing event users
	 * @param end the upper bound of the range of marketing event users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of marketing event users
	 */
	@Override
	public List<MarketingEventUser> findAll(int start, int end,
		OrderByComparator<MarketingEventUser> orderByComparator,
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

		List<MarketingEventUser> list = null;

		if (retrieveFromCache) {
			list = (List<MarketingEventUser>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_MARKETINGEVENTUSER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MARKETINGEVENTUSER;

				if (pagination) {
					sql = sql.concat(MarketingEventUserModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<MarketingEventUser>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MarketingEventUser>)QueryUtil.list(q,
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
	 * Removes all the marketing event users from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (MarketingEventUser marketingEventUser : findAll()) {
			remove(marketingEventUser);
		}
	}

	/**
	 * Returns the number of marketing event users.
	 *
	 * @return the number of marketing event users
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_MARKETINGEVENTUSER);

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
	 * Returns the primaryKeys of marketing event sessions associated with the marketing event user.
	 *
	 * @param pk the primary key of the marketing event user
	 * @return long[] of the primaryKeys of marketing event sessions associated with the marketing event user
	 */
	@Override
	public long[] getMarketingEventSessionPrimaryKeys(long pk) {
		long[] pks = marketingEventUserToMarketingEventSessionTableMapper.getRightPrimaryKeys(pk);

		return pks.clone();
	}

	/**
	 * Returns all the marketing event sessions associated with the marketing event user.
	 *
	 * @param pk the primary key of the marketing event user
	 * @return the marketing event sessions associated with the marketing event user
	 */
	@Override
	public List<com.liferay.osb.www.marketing.events.model.MarketingEventSession> getMarketingEventSessions(
		long pk) {
		return getMarketingEventSessions(pk, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the marketing event sessions associated with the marketing event user.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the marketing event user
	 * @param start the lower bound of the range of marketing event users
	 * @param end the upper bound of the range of marketing event users (not inclusive)
	 * @return the range of marketing event sessions associated with the marketing event user
	 */
	@Override
	public List<com.liferay.osb.www.marketing.events.model.MarketingEventSession> getMarketingEventSessions(
		long pk, int start, int end) {
		return getMarketingEventSessions(pk, start, end, null);
	}

	/**
	 * Returns an ordered range of all the marketing event sessions associated with the marketing event user.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MarketingEventUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the marketing event user
	 * @param start the lower bound of the range of marketing event users
	 * @param end the upper bound of the range of marketing event users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of marketing event sessions associated with the marketing event user
	 */
	@Override
	public List<com.liferay.osb.www.marketing.events.model.MarketingEventSession> getMarketingEventSessions(
		long pk, int start, int end,
		OrderByComparator<com.liferay.osb.www.marketing.events.model.MarketingEventSession> orderByComparator) {
		return marketingEventUserToMarketingEventSessionTableMapper.getRightBaseModels(pk,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of marketing event sessions associated with the marketing event user.
	 *
	 * @param pk the primary key of the marketing event user
	 * @return the number of marketing event sessions associated with the marketing event user
	 */
	@Override
	public int getMarketingEventSessionsSize(long pk) {
		long[] pks = marketingEventUserToMarketingEventSessionTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the marketing event session is associated with the marketing event user.
	 *
	 * @param pk the primary key of the marketing event user
	 * @param marketingEventSessionPK the primary key of the marketing event session
	 * @return <code>true</code> if the marketing event session is associated with the marketing event user; <code>false</code> otherwise
	 */
	@Override
	public boolean containsMarketingEventSession(long pk,
		long marketingEventSessionPK) {
		return marketingEventUserToMarketingEventSessionTableMapper.containsTableMapping(pk,
			marketingEventSessionPK);
	}

	/**
	 * Returns <code>true</code> if the marketing event user has any marketing event sessions associated with it.
	 *
	 * @param pk the primary key of the marketing event user to check for associations with marketing event sessions
	 * @return <code>true</code> if the marketing event user has any marketing event sessions associated with it; <code>false</code> otherwise
	 */
	@Override
	public boolean containsMarketingEventSessions(long pk) {
		if (getMarketingEventSessionsSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the marketing event user and the marketing event session. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the marketing event user
	 * @param marketingEventSessionPK the primary key of the marketing event session
	 */
	@Override
	public void addMarketingEventSession(long pk, long marketingEventSessionPK) {
		MarketingEventUser marketingEventUser = fetchByPrimaryKey(pk);

		if (marketingEventUser == null) {
			marketingEventUserToMarketingEventSessionTableMapper.addTableMapping(companyProvider.getCompanyId(),
				pk, marketingEventSessionPK);
		}
		else {
			marketingEventUserToMarketingEventSessionTableMapper.addTableMapping(marketingEventUser.getCompanyId(),
				pk, marketingEventSessionPK);
		}
	}

	/**
	 * Adds an association between the marketing event user and the marketing event session. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the marketing event user
	 * @param marketingEventSession the marketing event session
	 */
	@Override
	public void addMarketingEventSession(long pk,
		com.liferay.osb.www.marketing.events.model.MarketingEventSession marketingEventSession) {
		MarketingEventUser marketingEventUser = fetchByPrimaryKey(pk);

		if (marketingEventUser == null) {
			marketingEventUserToMarketingEventSessionTableMapper.addTableMapping(companyProvider.getCompanyId(),
				pk, marketingEventSession.getPrimaryKey());
		}
		else {
			marketingEventUserToMarketingEventSessionTableMapper.addTableMapping(marketingEventUser.getCompanyId(),
				pk, marketingEventSession.getPrimaryKey());
		}
	}

	/**
	 * Adds an association between the marketing event user and the marketing event sessions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the marketing event user
	 * @param marketingEventSessionPKs the primary keys of the marketing event sessions
	 */
	@Override
	public void addMarketingEventSessions(long pk,
		long[] marketingEventSessionPKs) {
		long companyId = 0;

		MarketingEventUser marketingEventUser = fetchByPrimaryKey(pk);

		if (marketingEventUser == null) {
			companyId = companyProvider.getCompanyId();
		}
		else {
			companyId = marketingEventUser.getCompanyId();
		}

		marketingEventUserToMarketingEventSessionTableMapper.addTableMappings(companyId,
			pk, marketingEventSessionPKs);
	}

	/**
	 * Adds an association between the marketing event user and the marketing event sessions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the marketing event user
	 * @param marketingEventSessions the marketing event sessions
	 */
	@Override
	public void addMarketingEventSessions(long pk,
		List<com.liferay.osb.www.marketing.events.model.MarketingEventSession> marketingEventSessions) {
		addMarketingEventSessions(pk,
			ListUtil.toLongArray(marketingEventSessions,
				com.liferay.osb.www.marketing.events.model.MarketingEventSession.MARKETING_EVENT_SESSION_ID_ACCESSOR));
	}

	/**
	 * Clears all associations between the marketing event user and its marketing event sessions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the marketing event user to clear the associated marketing event sessions from
	 */
	@Override
	public void clearMarketingEventSessions(long pk) {
		marketingEventUserToMarketingEventSessionTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the marketing event user and the marketing event session. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the marketing event user
	 * @param marketingEventSessionPK the primary key of the marketing event session
	 */
	@Override
	public void removeMarketingEventSession(long pk,
		long marketingEventSessionPK) {
		marketingEventUserToMarketingEventSessionTableMapper.deleteTableMapping(pk,
			marketingEventSessionPK);
	}

	/**
	 * Removes the association between the marketing event user and the marketing event session. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the marketing event user
	 * @param marketingEventSession the marketing event session
	 */
	@Override
	public void removeMarketingEventSession(long pk,
		com.liferay.osb.www.marketing.events.model.MarketingEventSession marketingEventSession) {
		marketingEventUserToMarketingEventSessionTableMapper.deleteTableMapping(pk,
			marketingEventSession.getPrimaryKey());
	}

	/**
	 * Removes the association between the marketing event user and the marketing event sessions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the marketing event user
	 * @param marketingEventSessionPKs the primary keys of the marketing event sessions
	 */
	@Override
	public void removeMarketingEventSessions(long pk,
		long[] marketingEventSessionPKs) {
		marketingEventUserToMarketingEventSessionTableMapper.deleteTableMappings(pk,
			marketingEventSessionPKs);
	}

	/**
	 * Removes the association between the marketing event user and the marketing event sessions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the marketing event user
	 * @param marketingEventSessions the marketing event sessions
	 */
	@Override
	public void removeMarketingEventSessions(long pk,
		List<com.liferay.osb.www.marketing.events.model.MarketingEventSession> marketingEventSessions) {
		removeMarketingEventSessions(pk,
			ListUtil.toLongArray(marketingEventSessions,
				com.liferay.osb.www.marketing.events.model.MarketingEventSession.MARKETING_EVENT_SESSION_ID_ACCESSOR));
	}

	/**
	 * Sets the marketing event sessions associated with the marketing event user, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the marketing event user
	 * @param marketingEventSessionPKs the primary keys of the marketing event sessions to be associated with the marketing event user
	 */
	@Override
	public void setMarketingEventSessions(long pk,
		long[] marketingEventSessionPKs) {
		Set<Long> newMarketingEventSessionPKsSet = SetUtil.fromArray(marketingEventSessionPKs);
		Set<Long> oldMarketingEventSessionPKsSet = SetUtil.fromArray(marketingEventUserToMarketingEventSessionTableMapper.getRightPrimaryKeys(
					pk));

		Set<Long> removeMarketingEventSessionPKsSet = new HashSet<Long>(oldMarketingEventSessionPKsSet);

		removeMarketingEventSessionPKsSet.removeAll(newMarketingEventSessionPKsSet);

		marketingEventUserToMarketingEventSessionTableMapper.deleteTableMappings(pk,
			ArrayUtil.toLongArray(removeMarketingEventSessionPKsSet));

		newMarketingEventSessionPKsSet.removeAll(oldMarketingEventSessionPKsSet);

		long companyId = 0;

		MarketingEventUser marketingEventUser = fetchByPrimaryKey(pk);

		if (marketingEventUser == null) {
			companyId = companyProvider.getCompanyId();
		}
		else {
			companyId = marketingEventUser.getCompanyId();
		}

		marketingEventUserToMarketingEventSessionTableMapper.addTableMappings(companyId,
			pk, ArrayUtil.toLongArray(newMarketingEventSessionPKsSet));
	}

	/**
	 * Sets the marketing event sessions associated with the marketing event user, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the marketing event user
	 * @param marketingEventSessions the marketing event sessions to be associated with the marketing event user
	 */
	@Override
	public void setMarketingEventSessions(long pk,
		List<com.liferay.osb.www.marketing.events.model.MarketingEventSession> marketingEventSessions) {
		try {
			long[] marketingEventSessionPKs = new long[marketingEventSessions.size()];

			for (int i = 0; i < marketingEventSessions.size(); i++) {
				com.liferay.osb.www.marketing.events.model.MarketingEventSession marketingEventSession =
					marketingEventSessions.get(i);

				marketingEventSessionPKs[i] = marketingEventSession.getPrimaryKey();
			}

			setMarketingEventSessions(pk, marketingEventSessionPKs);
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
		return MarketingEventUserModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the marketing event user persistence.
	 */
	public void afterPropertiesSet() {
		marketingEventUserToMarketingEventSessionTableMapper = TableMapperFactory.getTableMapper("OSB_MarketingEventSessions_MarketingEventUsers",
				"companyId", "marketingEventUserId", "marketingEventSessionId",
				this, marketingEventSessionPersistence);
	}

	public void destroy() {
		entityCache.removeCache(MarketingEventUserImpl.class.getName());
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
	@BeanReference(type = MarketingEventSessionPersistence.class)
	protected MarketingEventSessionPersistence marketingEventSessionPersistence;
	protected TableMapper<MarketingEventUser, com.liferay.osb.www.marketing.events.model.MarketingEventSession> marketingEventUserToMarketingEventSessionTableMapper;
	private static final String _SQL_SELECT_MARKETINGEVENTUSER = "SELECT marketingEventUser FROM MarketingEventUser marketingEventUser";
	private static final String _SQL_SELECT_MARKETINGEVENTUSER_WHERE_PKS_IN = "SELECT marketingEventUser FROM MarketingEventUser marketingEventUser WHERE marketingEventUserId IN (";
	private static final String _SQL_SELECT_MARKETINGEVENTUSER_WHERE = "SELECT marketingEventUser FROM MarketingEventUser marketingEventUser WHERE ";
	private static final String _SQL_COUNT_MARKETINGEVENTUSER = "SELECT COUNT(marketingEventUser) FROM MarketingEventUser marketingEventUser";
	private static final String _SQL_COUNT_MARKETINGEVENTUSER_WHERE = "SELECT COUNT(marketingEventUser) FROM MarketingEventUser marketingEventUser WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "marketingEventUser.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MarketingEventUser exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No MarketingEventUser exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(MarketingEventUserPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}