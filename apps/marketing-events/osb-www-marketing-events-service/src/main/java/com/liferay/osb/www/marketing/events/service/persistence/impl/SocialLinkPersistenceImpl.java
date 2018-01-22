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

import com.liferay.osb.www.marketing.events.exception.NoSuchSocialLinkException;
import com.liferay.osb.www.marketing.events.model.SocialLink;
import com.liferay.osb.www.marketing.events.model.impl.SocialLinkImpl;
import com.liferay.osb.www.marketing.events.model.impl.SocialLinkModelImpl;
import com.liferay.osb.www.marketing.events.service.persistence.SocialLinkPersistence;

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
import com.liferay.portal.kernel.util.StringPool;
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
 * The persistence implementation for the social link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SocialLinkPersistence
 * @see com.liferay.osb.www.marketing.events.service.persistence.SocialLinkUtil
 * @generated
 */
@ProviderType
public class SocialLinkPersistenceImpl extends BasePersistenceImpl<SocialLink>
	implements SocialLinkPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SocialLinkUtil} to access the social link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SocialLinkImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SocialLinkModelImpl.ENTITY_CACHE_ENABLED,
			SocialLinkModelImpl.FINDER_CACHE_ENABLED, SocialLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SocialLinkModelImpl.ENTITY_CACHE_ENABLED,
			SocialLinkModelImpl.FINDER_CACHE_ENABLED, SocialLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SocialLinkModelImpl.ENTITY_CACHE_ENABLED,
			SocialLinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MARKETINGEVENTUSERID =
		new FinderPath(SocialLinkModelImpl.ENTITY_CACHE_ENABLED,
			SocialLinkModelImpl.FINDER_CACHE_ENABLED, SocialLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByMarketingEventUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MARKETINGEVENTUSERID =
		new FinderPath(SocialLinkModelImpl.ENTITY_CACHE_ENABLED,
			SocialLinkModelImpl.FINDER_CACHE_ENABLED, SocialLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByMarketingEventUserId",
			new String[] { Long.class.getName() },
			SocialLinkModelImpl.MARKETINGEVENTUSERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MARKETINGEVENTUSERID = new FinderPath(SocialLinkModelImpl.ENTITY_CACHE_ENABLED,
			SocialLinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByMarketingEventUserId", new String[] { Long.class.getName() });

	/**
	 * Returns all the social links where marketingEventUserId = &#63;.
	 *
	 * @param marketingEventUserId the marketing event user ID
	 * @return the matching social links
	 */
	@Override
	public List<SocialLink> findByMarketingEventUserId(
		long marketingEventUserId) {
		return findByMarketingEventUserId(marketingEventUserId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the social links where marketingEventUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SocialLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param marketingEventUserId the marketing event user ID
	 * @param start the lower bound of the range of social links
	 * @param end the upper bound of the range of social links (not inclusive)
	 * @return the range of matching social links
	 */
	@Override
	public List<SocialLink> findByMarketingEventUserId(
		long marketingEventUserId, int start, int end) {
		return findByMarketingEventUserId(marketingEventUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the social links where marketingEventUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SocialLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param marketingEventUserId the marketing event user ID
	 * @param start the lower bound of the range of social links
	 * @param end the upper bound of the range of social links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching social links
	 */
	@Override
	public List<SocialLink> findByMarketingEventUserId(
		long marketingEventUserId, int start, int end,
		OrderByComparator<SocialLink> orderByComparator) {
		return findByMarketingEventUserId(marketingEventUserId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the social links where marketingEventUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SocialLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param marketingEventUserId the marketing event user ID
	 * @param start the lower bound of the range of social links
	 * @param end the upper bound of the range of social links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching social links
	 */
	@Override
	public List<SocialLink> findByMarketingEventUserId(
		long marketingEventUserId, int start, int end,
		OrderByComparator<SocialLink> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MARKETINGEVENTUSERID;
			finderArgs = new Object[] { marketingEventUserId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MARKETINGEVENTUSERID;
			finderArgs = new Object[] {
					marketingEventUserId,
					
					start, end, orderByComparator
				};
		}

		List<SocialLink> list = null;

		if (retrieveFromCache) {
			list = (List<SocialLink>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SocialLink socialLink : list) {
					if ((marketingEventUserId != socialLink.getMarketingEventUserId())) {
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

			query.append(_SQL_SELECT_SOCIALLINK_WHERE);

			query.append(_FINDER_COLUMN_MARKETINGEVENTUSERID_MARKETINGEVENTUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SocialLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(marketingEventUserId);

				if (!pagination) {
					list = (List<SocialLink>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SocialLink>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first social link in the ordered set where marketingEventUserId = &#63;.
	 *
	 * @param marketingEventUserId the marketing event user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social link
	 * @throws NoSuchSocialLinkException if a matching social link could not be found
	 */
	@Override
	public SocialLink findByMarketingEventUserId_First(
		long marketingEventUserId,
		OrderByComparator<SocialLink> orderByComparator)
		throws NoSuchSocialLinkException {
		SocialLink socialLink = fetchByMarketingEventUserId_First(marketingEventUserId,
				orderByComparator);

		if (socialLink != null) {
			return socialLink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("marketingEventUserId=");
		msg.append(marketingEventUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSocialLinkException(msg.toString());
	}

	/**
	 * Returns the first social link in the ordered set where marketingEventUserId = &#63;.
	 *
	 * @param marketingEventUserId the marketing event user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social link, or <code>null</code> if a matching social link could not be found
	 */
	@Override
	public SocialLink fetchByMarketingEventUserId_First(
		long marketingEventUserId,
		OrderByComparator<SocialLink> orderByComparator) {
		List<SocialLink> list = findByMarketingEventUserId(marketingEventUserId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last social link in the ordered set where marketingEventUserId = &#63;.
	 *
	 * @param marketingEventUserId the marketing event user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social link
	 * @throws NoSuchSocialLinkException if a matching social link could not be found
	 */
	@Override
	public SocialLink findByMarketingEventUserId_Last(
		long marketingEventUserId,
		OrderByComparator<SocialLink> orderByComparator)
		throws NoSuchSocialLinkException {
		SocialLink socialLink = fetchByMarketingEventUserId_Last(marketingEventUserId,
				orderByComparator);

		if (socialLink != null) {
			return socialLink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("marketingEventUserId=");
		msg.append(marketingEventUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSocialLinkException(msg.toString());
	}

	/**
	 * Returns the last social link in the ordered set where marketingEventUserId = &#63;.
	 *
	 * @param marketingEventUserId the marketing event user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social link, or <code>null</code> if a matching social link could not be found
	 */
	@Override
	public SocialLink fetchByMarketingEventUserId_Last(
		long marketingEventUserId,
		OrderByComparator<SocialLink> orderByComparator) {
		int count = countByMarketingEventUserId(marketingEventUserId);

		if (count == 0) {
			return null;
		}

		List<SocialLink> list = findByMarketingEventUserId(marketingEventUserId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the social links before and after the current social link in the ordered set where marketingEventUserId = &#63;.
	 *
	 * @param socialLinkId the primary key of the current social link
	 * @param marketingEventUserId the marketing event user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next social link
	 * @throws NoSuchSocialLinkException if a social link with the primary key could not be found
	 */
	@Override
	public SocialLink[] findByMarketingEventUserId_PrevAndNext(
		long socialLinkId, long marketingEventUserId,
		OrderByComparator<SocialLink> orderByComparator)
		throws NoSuchSocialLinkException {
		SocialLink socialLink = findByPrimaryKey(socialLinkId);

		Session session = null;

		try {
			session = openSession();

			SocialLink[] array = new SocialLinkImpl[3];

			array[0] = getByMarketingEventUserId_PrevAndNext(session,
					socialLink, marketingEventUserId, orderByComparator, true);

			array[1] = socialLink;

			array[2] = getByMarketingEventUserId_PrevAndNext(session,
					socialLink, marketingEventUserId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SocialLink getByMarketingEventUserId_PrevAndNext(
		Session session, SocialLink socialLink, long marketingEventUserId,
		OrderByComparator<SocialLink> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SOCIALLINK_WHERE);

		query.append(_FINDER_COLUMN_MARKETINGEVENTUSERID_MARKETINGEVENTUSERID_2);

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
			query.append(SocialLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(marketingEventUserId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(socialLink);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SocialLink> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the social links where marketingEventUserId = &#63; from the database.
	 *
	 * @param marketingEventUserId the marketing event user ID
	 */
	@Override
	public void removeByMarketingEventUserId(long marketingEventUserId) {
		for (SocialLink socialLink : findByMarketingEventUserId(
				marketingEventUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(socialLink);
		}
	}

	/**
	 * Returns the number of social links where marketingEventUserId = &#63;.
	 *
	 * @param marketingEventUserId the marketing event user ID
	 * @return the number of matching social links
	 */
	@Override
	public int countByMarketingEventUserId(long marketingEventUserId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MARKETINGEVENTUSERID;

		Object[] finderArgs = new Object[] { marketingEventUserId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SOCIALLINK_WHERE);

			query.append(_FINDER_COLUMN_MARKETINGEVENTUSERID_MARKETINGEVENTUSERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(marketingEventUserId);

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

	private static final String _FINDER_COLUMN_MARKETINGEVENTUSERID_MARKETINGEVENTUSERID_2 =
		"socialLink.marketingEventUserId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SOCIALLINKTYPEID =
		new FinderPath(SocialLinkModelImpl.ENTITY_CACHE_ENABLED,
			SocialLinkModelImpl.FINDER_CACHE_ENABLED, SocialLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySocialLinkTypeId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SOCIALLINKTYPEID =
		new FinderPath(SocialLinkModelImpl.ENTITY_CACHE_ENABLED,
			SocialLinkModelImpl.FINDER_CACHE_ENABLED, SocialLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBySocialLinkTypeId", new String[] { Long.class.getName() },
			SocialLinkModelImpl.SOCIALLINKTYPEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SOCIALLINKTYPEID = new FinderPath(SocialLinkModelImpl.ENTITY_CACHE_ENABLED,
			SocialLinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySocialLinkTypeId", new String[] { Long.class.getName() });

	/**
	 * Returns all the social links where socialLinkTypeId = &#63;.
	 *
	 * @param socialLinkTypeId the social link type ID
	 * @return the matching social links
	 */
	@Override
	public List<SocialLink> findBySocialLinkTypeId(long socialLinkTypeId) {
		return findBySocialLinkTypeId(socialLinkTypeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the social links where socialLinkTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SocialLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param socialLinkTypeId the social link type ID
	 * @param start the lower bound of the range of social links
	 * @param end the upper bound of the range of social links (not inclusive)
	 * @return the range of matching social links
	 */
	@Override
	public List<SocialLink> findBySocialLinkTypeId(long socialLinkTypeId,
		int start, int end) {
		return findBySocialLinkTypeId(socialLinkTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the social links where socialLinkTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SocialLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param socialLinkTypeId the social link type ID
	 * @param start the lower bound of the range of social links
	 * @param end the upper bound of the range of social links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching social links
	 */
	@Override
	public List<SocialLink> findBySocialLinkTypeId(long socialLinkTypeId,
		int start, int end, OrderByComparator<SocialLink> orderByComparator) {
		return findBySocialLinkTypeId(socialLinkTypeId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the social links where socialLinkTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SocialLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param socialLinkTypeId the social link type ID
	 * @param start the lower bound of the range of social links
	 * @param end the upper bound of the range of social links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching social links
	 */
	@Override
	public List<SocialLink> findBySocialLinkTypeId(long socialLinkTypeId,
		int start, int end, OrderByComparator<SocialLink> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SOCIALLINKTYPEID;
			finderArgs = new Object[] { socialLinkTypeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SOCIALLINKTYPEID;
			finderArgs = new Object[] {
					socialLinkTypeId,
					
					start, end, orderByComparator
				};
		}

		List<SocialLink> list = null;

		if (retrieveFromCache) {
			list = (List<SocialLink>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SocialLink socialLink : list) {
					if ((socialLinkTypeId != socialLink.getSocialLinkTypeId())) {
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

			query.append(_SQL_SELECT_SOCIALLINK_WHERE);

			query.append(_FINDER_COLUMN_SOCIALLINKTYPEID_SOCIALLINKTYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SocialLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(socialLinkTypeId);

				if (!pagination) {
					list = (List<SocialLink>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SocialLink>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first social link in the ordered set where socialLinkTypeId = &#63;.
	 *
	 * @param socialLinkTypeId the social link type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social link
	 * @throws NoSuchSocialLinkException if a matching social link could not be found
	 */
	@Override
	public SocialLink findBySocialLinkTypeId_First(long socialLinkTypeId,
		OrderByComparator<SocialLink> orderByComparator)
		throws NoSuchSocialLinkException {
		SocialLink socialLink = fetchBySocialLinkTypeId_First(socialLinkTypeId,
				orderByComparator);

		if (socialLink != null) {
			return socialLink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("socialLinkTypeId=");
		msg.append(socialLinkTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSocialLinkException(msg.toString());
	}

	/**
	 * Returns the first social link in the ordered set where socialLinkTypeId = &#63;.
	 *
	 * @param socialLinkTypeId the social link type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social link, or <code>null</code> if a matching social link could not be found
	 */
	@Override
	public SocialLink fetchBySocialLinkTypeId_First(long socialLinkTypeId,
		OrderByComparator<SocialLink> orderByComparator) {
		List<SocialLink> list = findBySocialLinkTypeId(socialLinkTypeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last social link in the ordered set where socialLinkTypeId = &#63;.
	 *
	 * @param socialLinkTypeId the social link type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social link
	 * @throws NoSuchSocialLinkException if a matching social link could not be found
	 */
	@Override
	public SocialLink findBySocialLinkTypeId_Last(long socialLinkTypeId,
		OrderByComparator<SocialLink> orderByComparator)
		throws NoSuchSocialLinkException {
		SocialLink socialLink = fetchBySocialLinkTypeId_Last(socialLinkTypeId,
				orderByComparator);

		if (socialLink != null) {
			return socialLink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("socialLinkTypeId=");
		msg.append(socialLinkTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSocialLinkException(msg.toString());
	}

	/**
	 * Returns the last social link in the ordered set where socialLinkTypeId = &#63;.
	 *
	 * @param socialLinkTypeId the social link type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social link, or <code>null</code> if a matching social link could not be found
	 */
	@Override
	public SocialLink fetchBySocialLinkTypeId_Last(long socialLinkTypeId,
		OrderByComparator<SocialLink> orderByComparator) {
		int count = countBySocialLinkTypeId(socialLinkTypeId);

		if (count == 0) {
			return null;
		}

		List<SocialLink> list = findBySocialLinkTypeId(socialLinkTypeId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the social links before and after the current social link in the ordered set where socialLinkTypeId = &#63;.
	 *
	 * @param socialLinkId the primary key of the current social link
	 * @param socialLinkTypeId the social link type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next social link
	 * @throws NoSuchSocialLinkException if a social link with the primary key could not be found
	 */
	@Override
	public SocialLink[] findBySocialLinkTypeId_PrevAndNext(long socialLinkId,
		long socialLinkTypeId, OrderByComparator<SocialLink> orderByComparator)
		throws NoSuchSocialLinkException {
		SocialLink socialLink = findByPrimaryKey(socialLinkId);

		Session session = null;

		try {
			session = openSession();

			SocialLink[] array = new SocialLinkImpl[3];

			array[0] = getBySocialLinkTypeId_PrevAndNext(session, socialLink,
					socialLinkTypeId, orderByComparator, true);

			array[1] = socialLink;

			array[2] = getBySocialLinkTypeId_PrevAndNext(session, socialLink,
					socialLinkTypeId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SocialLink getBySocialLinkTypeId_PrevAndNext(Session session,
		SocialLink socialLink, long socialLinkTypeId,
		OrderByComparator<SocialLink> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SOCIALLINK_WHERE);

		query.append(_FINDER_COLUMN_SOCIALLINKTYPEID_SOCIALLINKTYPEID_2);

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
			query.append(SocialLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(socialLinkTypeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(socialLink);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SocialLink> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the social links where socialLinkTypeId = &#63; from the database.
	 *
	 * @param socialLinkTypeId the social link type ID
	 */
	@Override
	public void removeBySocialLinkTypeId(long socialLinkTypeId) {
		for (SocialLink socialLink : findBySocialLinkTypeId(socialLinkTypeId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(socialLink);
		}
	}

	/**
	 * Returns the number of social links where socialLinkTypeId = &#63;.
	 *
	 * @param socialLinkTypeId the social link type ID
	 * @return the number of matching social links
	 */
	@Override
	public int countBySocialLinkTypeId(long socialLinkTypeId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SOCIALLINKTYPEID;

		Object[] finderArgs = new Object[] { socialLinkTypeId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SOCIALLINK_WHERE);

			query.append(_FINDER_COLUMN_SOCIALLINKTYPEID_SOCIALLINKTYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(socialLinkTypeId);

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

	private static final String _FINDER_COLUMN_SOCIALLINKTYPEID_SOCIALLINKTYPEID_2 =
		"socialLink.socialLinkTypeId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MEUI_SLTI =
		new FinderPath(SocialLinkModelImpl.ENTITY_CACHE_ENABLED,
			SocialLinkModelImpl.FINDER_CACHE_ENABLED, SocialLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMEUI_SLTI",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEUI_SLTI =
		new FinderPath(SocialLinkModelImpl.ENTITY_CACHE_ENABLED,
			SocialLinkModelImpl.FINDER_CACHE_ENABLED, SocialLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMEUI_SLTI",
			new String[] { Long.class.getName(), Long.class.getName() },
			SocialLinkModelImpl.MARKETINGEVENTUSERID_COLUMN_BITMASK |
			SocialLinkModelImpl.SOCIALLINKTYPEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MEUI_SLTI = new FinderPath(SocialLinkModelImpl.ENTITY_CACHE_ENABLED,
			SocialLinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMEUI_SLTI",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the social links where marketingEventUserId = &#63; and socialLinkTypeId = &#63;.
	 *
	 * @param marketingEventUserId the marketing event user ID
	 * @param socialLinkTypeId the social link type ID
	 * @return the matching social links
	 */
	@Override
	public List<SocialLink> findByMEUI_SLTI(long marketingEventUserId,
		long socialLinkTypeId) {
		return findByMEUI_SLTI(marketingEventUserId, socialLinkTypeId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the social links where marketingEventUserId = &#63; and socialLinkTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SocialLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param marketingEventUserId the marketing event user ID
	 * @param socialLinkTypeId the social link type ID
	 * @param start the lower bound of the range of social links
	 * @param end the upper bound of the range of social links (not inclusive)
	 * @return the range of matching social links
	 */
	@Override
	public List<SocialLink> findByMEUI_SLTI(long marketingEventUserId,
		long socialLinkTypeId, int start, int end) {
		return findByMEUI_SLTI(marketingEventUserId, socialLinkTypeId, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the social links where marketingEventUserId = &#63; and socialLinkTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SocialLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param marketingEventUserId the marketing event user ID
	 * @param socialLinkTypeId the social link type ID
	 * @param start the lower bound of the range of social links
	 * @param end the upper bound of the range of social links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching social links
	 */
	@Override
	public List<SocialLink> findByMEUI_SLTI(long marketingEventUserId,
		long socialLinkTypeId, int start, int end,
		OrderByComparator<SocialLink> orderByComparator) {
		return findByMEUI_SLTI(marketingEventUserId, socialLinkTypeId, start,
			end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the social links where marketingEventUserId = &#63; and socialLinkTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SocialLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param marketingEventUserId the marketing event user ID
	 * @param socialLinkTypeId the social link type ID
	 * @param start the lower bound of the range of social links
	 * @param end the upper bound of the range of social links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching social links
	 */
	@Override
	public List<SocialLink> findByMEUI_SLTI(long marketingEventUserId,
		long socialLinkTypeId, int start, int end,
		OrderByComparator<SocialLink> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEUI_SLTI;
			finderArgs = new Object[] { marketingEventUserId, socialLinkTypeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MEUI_SLTI;
			finderArgs = new Object[] {
					marketingEventUserId, socialLinkTypeId,
					
					start, end, orderByComparator
				};
		}

		List<SocialLink> list = null;

		if (retrieveFromCache) {
			list = (List<SocialLink>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SocialLink socialLink : list) {
					if ((marketingEventUserId != socialLink.getMarketingEventUserId()) ||
							(socialLinkTypeId != socialLink.getSocialLinkTypeId())) {
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

			query.append(_SQL_SELECT_SOCIALLINK_WHERE);

			query.append(_FINDER_COLUMN_MEUI_SLTI_MARKETINGEVENTUSERID_2);

			query.append(_FINDER_COLUMN_MEUI_SLTI_SOCIALLINKTYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SocialLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(marketingEventUserId);

				qPos.add(socialLinkTypeId);

				if (!pagination) {
					list = (List<SocialLink>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SocialLink>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first social link in the ordered set where marketingEventUserId = &#63; and socialLinkTypeId = &#63;.
	 *
	 * @param marketingEventUserId the marketing event user ID
	 * @param socialLinkTypeId the social link type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social link
	 * @throws NoSuchSocialLinkException if a matching social link could not be found
	 */
	@Override
	public SocialLink findByMEUI_SLTI_First(long marketingEventUserId,
		long socialLinkTypeId, OrderByComparator<SocialLink> orderByComparator)
		throws NoSuchSocialLinkException {
		SocialLink socialLink = fetchByMEUI_SLTI_First(marketingEventUserId,
				socialLinkTypeId, orderByComparator);

		if (socialLink != null) {
			return socialLink;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("marketingEventUserId=");
		msg.append(marketingEventUserId);

		msg.append(", socialLinkTypeId=");
		msg.append(socialLinkTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSocialLinkException(msg.toString());
	}

	/**
	 * Returns the first social link in the ordered set where marketingEventUserId = &#63; and socialLinkTypeId = &#63;.
	 *
	 * @param marketingEventUserId the marketing event user ID
	 * @param socialLinkTypeId the social link type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social link, or <code>null</code> if a matching social link could not be found
	 */
	@Override
	public SocialLink fetchByMEUI_SLTI_First(long marketingEventUserId,
		long socialLinkTypeId, OrderByComparator<SocialLink> orderByComparator) {
		List<SocialLink> list = findByMEUI_SLTI(marketingEventUserId,
				socialLinkTypeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last social link in the ordered set where marketingEventUserId = &#63; and socialLinkTypeId = &#63;.
	 *
	 * @param marketingEventUserId the marketing event user ID
	 * @param socialLinkTypeId the social link type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social link
	 * @throws NoSuchSocialLinkException if a matching social link could not be found
	 */
	@Override
	public SocialLink findByMEUI_SLTI_Last(long marketingEventUserId,
		long socialLinkTypeId, OrderByComparator<SocialLink> orderByComparator)
		throws NoSuchSocialLinkException {
		SocialLink socialLink = fetchByMEUI_SLTI_Last(marketingEventUserId,
				socialLinkTypeId, orderByComparator);

		if (socialLink != null) {
			return socialLink;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("marketingEventUserId=");
		msg.append(marketingEventUserId);

		msg.append(", socialLinkTypeId=");
		msg.append(socialLinkTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSocialLinkException(msg.toString());
	}

	/**
	 * Returns the last social link in the ordered set where marketingEventUserId = &#63; and socialLinkTypeId = &#63;.
	 *
	 * @param marketingEventUserId the marketing event user ID
	 * @param socialLinkTypeId the social link type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social link, or <code>null</code> if a matching social link could not be found
	 */
	@Override
	public SocialLink fetchByMEUI_SLTI_Last(long marketingEventUserId,
		long socialLinkTypeId, OrderByComparator<SocialLink> orderByComparator) {
		int count = countByMEUI_SLTI(marketingEventUserId, socialLinkTypeId);

		if (count == 0) {
			return null;
		}

		List<SocialLink> list = findByMEUI_SLTI(marketingEventUserId,
				socialLinkTypeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the social links before and after the current social link in the ordered set where marketingEventUserId = &#63; and socialLinkTypeId = &#63;.
	 *
	 * @param socialLinkId the primary key of the current social link
	 * @param marketingEventUserId the marketing event user ID
	 * @param socialLinkTypeId the social link type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next social link
	 * @throws NoSuchSocialLinkException if a social link with the primary key could not be found
	 */
	@Override
	public SocialLink[] findByMEUI_SLTI_PrevAndNext(long socialLinkId,
		long marketingEventUserId, long socialLinkTypeId,
		OrderByComparator<SocialLink> orderByComparator)
		throws NoSuchSocialLinkException {
		SocialLink socialLink = findByPrimaryKey(socialLinkId);

		Session session = null;

		try {
			session = openSession();

			SocialLink[] array = new SocialLinkImpl[3];

			array[0] = getByMEUI_SLTI_PrevAndNext(session, socialLink,
					marketingEventUserId, socialLinkTypeId, orderByComparator,
					true);

			array[1] = socialLink;

			array[2] = getByMEUI_SLTI_PrevAndNext(session, socialLink,
					marketingEventUserId, socialLinkTypeId, orderByComparator,
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

	protected SocialLink getByMEUI_SLTI_PrevAndNext(Session session,
		SocialLink socialLink, long marketingEventUserId,
		long socialLinkTypeId, OrderByComparator<SocialLink> orderByComparator,
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

		query.append(_SQL_SELECT_SOCIALLINK_WHERE);

		query.append(_FINDER_COLUMN_MEUI_SLTI_MARKETINGEVENTUSERID_2);

		query.append(_FINDER_COLUMN_MEUI_SLTI_SOCIALLINKTYPEID_2);

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
			query.append(SocialLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(marketingEventUserId);

		qPos.add(socialLinkTypeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(socialLink);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SocialLink> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the social links where marketingEventUserId = &#63; and socialLinkTypeId = &#63; from the database.
	 *
	 * @param marketingEventUserId the marketing event user ID
	 * @param socialLinkTypeId the social link type ID
	 */
	@Override
	public void removeByMEUI_SLTI(long marketingEventUserId,
		long socialLinkTypeId) {
		for (SocialLink socialLink : findByMEUI_SLTI(marketingEventUserId,
				socialLinkTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(socialLink);
		}
	}

	/**
	 * Returns the number of social links where marketingEventUserId = &#63; and socialLinkTypeId = &#63;.
	 *
	 * @param marketingEventUserId the marketing event user ID
	 * @param socialLinkTypeId the social link type ID
	 * @return the number of matching social links
	 */
	@Override
	public int countByMEUI_SLTI(long marketingEventUserId, long socialLinkTypeId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MEUI_SLTI;

		Object[] finderArgs = new Object[] {
				marketingEventUserId, socialLinkTypeId
			};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SOCIALLINK_WHERE);

			query.append(_FINDER_COLUMN_MEUI_SLTI_MARKETINGEVENTUSERID_2);

			query.append(_FINDER_COLUMN_MEUI_SLTI_SOCIALLINKTYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(marketingEventUserId);

				qPos.add(socialLinkTypeId);

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

	private static final String _FINDER_COLUMN_MEUI_SLTI_MARKETINGEVENTUSERID_2 = "socialLink.marketingEventUserId = ? AND ";
	private static final String _FINDER_COLUMN_MEUI_SLTI_SOCIALLINKTYPEID_2 = "socialLink.socialLinkTypeId = ?";

	public SocialLinkPersistenceImpl() {
		setModelClass(SocialLink.class);
	}

	/**
	 * Caches the social link in the entity cache if it is enabled.
	 *
	 * @param socialLink the social link
	 */
	@Override
	public void cacheResult(SocialLink socialLink) {
		entityCache.putResult(SocialLinkModelImpl.ENTITY_CACHE_ENABLED,
			SocialLinkImpl.class, socialLink.getPrimaryKey(), socialLink);

		socialLink.resetOriginalValues();
	}

	/**
	 * Caches the social links in the entity cache if it is enabled.
	 *
	 * @param socialLinks the social links
	 */
	@Override
	public void cacheResult(List<SocialLink> socialLinks) {
		for (SocialLink socialLink : socialLinks) {
			if (entityCache.getResult(
						SocialLinkModelImpl.ENTITY_CACHE_ENABLED,
						SocialLinkImpl.class, socialLink.getPrimaryKey()) == null) {
				cacheResult(socialLink);
			}
			else {
				socialLink.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all social links.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SocialLinkImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the social link.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SocialLink socialLink) {
		entityCache.removeResult(SocialLinkModelImpl.ENTITY_CACHE_ENABLED,
			SocialLinkImpl.class, socialLink.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SocialLink> socialLinks) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SocialLink socialLink : socialLinks) {
			entityCache.removeResult(SocialLinkModelImpl.ENTITY_CACHE_ENABLED,
				SocialLinkImpl.class, socialLink.getPrimaryKey());
		}
	}

	/**
	 * Creates a new social link with the primary key. Does not add the social link to the database.
	 *
	 * @param socialLinkId the primary key for the new social link
	 * @return the new social link
	 */
	@Override
	public SocialLink create(long socialLinkId) {
		SocialLink socialLink = new SocialLinkImpl();

		socialLink.setNew(true);
		socialLink.setPrimaryKey(socialLinkId);

		return socialLink;
	}

	/**
	 * Removes the social link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param socialLinkId the primary key of the social link
	 * @return the social link that was removed
	 * @throws NoSuchSocialLinkException if a social link with the primary key could not be found
	 */
	@Override
	public SocialLink remove(long socialLinkId)
		throws NoSuchSocialLinkException {
		return remove((Serializable)socialLinkId);
	}

	/**
	 * Removes the social link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the social link
	 * @return the social link that was removed
	 * @throws NoSuchSocialLinkException if a social link with the primary key could not be found
	 */
	@Override
	public SocialLink remove(Serializable primaryKey)
		throws NoSuchSocialLinkException {
		Session session = null;

		try {
			session = openSession();

			SocialLink socialLink = (SocialLink)session.get(SocialLinkImpl.class,
					primaryKey);

			if (socialLink == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSocialLinkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(socialLink);
		}
		catch (NoSuchSocialLinkException nsee) {
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
	protected SocialLink removeImpl(SocialLink socialLink) {
		socialLink = toUnwrappedModel(socialLink);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(socialLink)) {
				socialLink = (SocialLink)session.get(SocialLinkImpl.class,
						socialLink.getPrimaryKeyObj());
			}

			if (socialLink != null) {
				session.delete(socialLink);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (socialLink != null) {
			clearCache(socialLink);
		}

		return socialLink;
	}

	@Override
	public SocialLink updateImpl(SocialLink socialLink) {
		socialLink = toUnwrappedModel(socialLink);

		boolean isNew = socialLink.isNew();

		SocialLinkModelImpl socialLinkModelImpl = (SocialLinkModelImpl)socialLink;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (socialLink.getCreateDate() == null)) {
			if (serviceContext == null) {
				socialLink.setCreateDate(now);
			}
			else {
				socialLink.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!socialLinkModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				socialLink.setModifiedDate(now);
			}
			else {
				socialLink.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (socialLink.isNew()) {
				session.save(socialLink);

				socialLink.setNew(false);
			}
			else {
				socialLink = (SocialLink)session.merge(socialLink);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!SocialLinkModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					socialLinkModelImpl.getMarketingEventUserId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_MARKETINGEVENTUSERID,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MARKETINGEVENTUSERID,
				args);

			args = new Object[] { socialLinkModelImpl.getSocialLinkTypeId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_SOCIALLINKTYPEID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SOCIALLINKTYPEID,
				args);

			args = new Object[] {
					socialLinkModelImpl.getMarketingEventUserId(),
					socialLinkModelImpl.getSocialLinkTypeId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_MEUI_SLTI, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEUI_SLTI,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((socialLinkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MARKETINGEVENTUSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						socialLinkModelImpl.getOriginalMarketingEventUserId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MARKETINGEVENTUSERID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MARKETINGEVENTUSERID,
					args);

				args = new Object[] {
						socialLinkModelImpl.getMarketingEventUserId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MARKETINGEVENTUSERID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MARKETINGEVENTUSERID,
					args);
			}

			if ((socialLinkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SOCIALLINKTYPEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						socialLinkModelImpl.getOriginalSocialLinkTypeId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_SOCIALLINKTYPEID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SOCIALLINKTYPEID,
					args);

				args = new Object[] { socialLinkModelImpl.getSocialLinkTypeId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_SOCIALLINKTYPEID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SOCIALLINKTYPEID,
					args);
			}

			if ((socialLinkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEUI_SLTI.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						socialLinkModelImpl.getOriginalMarketingEventUserId(),
						socialLinkModelImpl.getOriginalSocialLinkTypeId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MEUI_SLTI, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEUI_SLTI,
					args);

				args = new Object[] {
						socialLinkModelImpl.getMarketingEventUserId(),
						socialLinkModelImpl.getSocialLinkTypeId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MEUI_SLTI, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEUI_SLTI,
					args);
			}
		}

		entityCache.putResult(SocialLinkModelImpl.ENTITY_CACHE_ENABLED,
			SocialLinkImpl.class, socialLink.getPrimaryKey(), socialLink, false);

		socialLink.resetOriginalValues();

		return socialLink;
	}

	protected SocialLink toUnwrappedModel(SocialLink socialLink) {
		if (socialLink instanceof SocialLinkImpl) {
			return socialLink;
		}

		SocialLinkImpl socialLinkImpl = new SocialLinkImpl();

		socialLinkImpl.setNew(socialLink.isNew());
		socialLinkImpl.setPrimaryKey(socialLink.getPrimaryKey());

		socialLinkImpl.setSocialLinkId(socialLink.getSocialLinkId());
		socialLinkImpl.setUserId(socialLink.getUserId());
		socialLinkImpl.setUserName(socialLink.getUserName());
		socialLinkImpl.setCreateDate(socialLink.getCreateDate());
		socialLinkImpl.setModifiedDate(socialLink.getModifiedDate());
		socialLinkImpl.setMarketingEventUserId(socialLink.getMarketingEventUserId());
		socialLinkImpl.setSocialLinkTypeId(socialLink.getSocialLinkTypeId());
		socialLinkImpl.setUrl(socialLink.getUrl());

		return socialLinkImpl;
	}

	/**
	 * Returns the social link with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the social link
	 * @return the social link
	 * @throws NoSuchSocialLinkException if a social link with the primary key could not be found
	 */
	@Override
	public SocialLink findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSocialLinkException {
		SocialLink socialLink = fetchByPrimaryKey(primaryKey);

		if (socialLink == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSocialLinkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return socialLink;
	}

	/**
	 * Returns the social link with the primary key or throws a {@link NoSuchSocialLinkException} if it could not be found.
	 *
	 * @param socialLinkId the primary key of the social link
	 * @return the social link
	 * @throws NoSuchSocialLinkException if a social link with the primary key could not be found
	 */
	@Override
	public SocialLink findByPrimaryKey(long socialLinkId)
		throws NoSuchSocialLinkException {
		return findByPrimaryKey((Serializable)socialLinkId);
	}

	/**
	 * Returns the social link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the social link
	 * @return the social link, or <code>null</code> if a social link with the primary key could not be found
	 */
	@Override
	public SocialLink fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(SocialLinkModelImpl.ENTITY_CACHE_ENABLED,
				SocialLinkImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		SocialLink socialLink = (SocialLink)serializable;

		if (socialLink == null) {
			Session session = null;

			try {
				session = openSession();

				socialLink = (SocialLink)session.get(SocialLinkImpl.class,
						primaryKey);

				if (socialLink != null) {
					cacheResult(socialLink);
				}
				else {
					entityCache.putResult(SocialLinkModelImpl.ENTITY_CACHE_ENABLED,
						SocialLinkImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(SocialLinkModelImpl.ENTITY_CACHE_ENABLED,
					SocialLinkImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return socialLink;
	}

	/**
	 * Returns the social link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param socialLinkId the primary key of the social link
	 * @return the social link, or <code>null</code> if a social link with the primary key could not be found
	 */
	@Override
	public SocialLink fetchByPrimaryKey(long socialLinkId) {
		return fetchByPrimaryKey((Serializable)socialLinkId);
	}

	@Override
	public Map<Serializable, SocialLink> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, SocialLink> map = new HashMap<Serializable, SocialLink>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			SocialLink socialLink = fetchByPrimaryKey(primaryKey);

			if (socialLink != null) {
				map.put(primaryKey, socialLink);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(SocialLinkModelImpl.ENTITY_CACHE_ENABLED,
					SocialLinkImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (SocialLink)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_SOCIALLINK_WHERE_PKS_IN);

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

			for (SocialLink socialLink : (List<SocialLink>)q.list()) {
				map.put(socialLink.getPrimaryKeyObj(), socialLink);

				cacheResult(socialLink);

				uncachedPrimaryKeys.remove(socialLink.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(SocialLinkModelImpl.ENTITY_CACHE_ENABLED,
					SocialLinkImpl.class, primaryKey, nullModel);
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
	 * Returns all the social links.
	 *
	 * @return the social links
	 */
	@Override
	public List<SocialLink> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the social links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SocialLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of social links
	 * @param end the upper bound of the range of social links (not inclusive)
	 * @return the range of social links
	 */
	@Override
	public List<SocialLink> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the social links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SocialLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of social links
	 * @param end the upper bound of the range of social links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of social links
	 */
	@Override
	public List<SocialLink> findAll(int start, int end,
		OrderByComparator<SocialLink> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the social links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SocialLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of social links
	 * @param end the upper bound of the range of social links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of social links
	 */
	@Override
	public List<SocialLink> findAll(int start, int end,
		OrderByComparator<SocialLink> orderByComparator,
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

		List<SocialLink> list = null;

		if (retrieveFromCache) {
			list = (List<SocialLink>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_SOCIALLINK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SOCIALLINK;

				if (pagination) {
					sql = sql.concat(SocialLinkModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SocialLink>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SocialLink>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the social links from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SocialLink socialLink : findAll()) {
			remove(socialLink);
		}
	}

	/**
	 * Returns the number of social links.
	 *
	 * @return the number of social links
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SOCIALLINK);

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
		return SocialLinkModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the social link persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(SocialLinkImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_SOCIALLINK = "SELECT socialLink FROM SocialLink socialLink";
	private static final String _SQL_SELECT_SOCIALLINK_WHERE_PKS_IN = "SELECT socialLink FROM SocialLink socialLink WHERE socialLinkId IN (";
	private static final String _SQL_SELECT_SOCIALLINK_WHERE = "SELECT socialLink FROM SocialLink socialLink WHERE ";
	private static final String _SQL_COUNT_SOCIALLINK = "SELECT COUNT(socialLink) FROM SocialLink socialLink";
	private static final String _SQL_COUNT_SOCIALLINK_WHERE = "SELECT COUNT(socialLink) FROM SocialLink socialLink WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "socialLink.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SocialLink exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SocialLink exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(SocialLinkPersistenceImpl.class);
}