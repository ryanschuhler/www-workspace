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

import com.liferay.osb.www.marketing.events.exception.NoSuchSocialLinkTypeException;
import com.liferay.osb.www.marketing.events.model.SocialLinkType;
import com.liferay.osb.www.marketing.events.model.impl.SocialLinkTypeImpl;
import com.liferay.osb.www.marketing.events.model.impl.SocialLinkTypeModelImpl;
import com.liferay.osb.www.marketing.events.service.persistence.SocialLinkTypePersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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
 * The persistence implementation for the social link type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SocialLinkTypePersistence
 * @see com.liferay.osb.www.marketing.events.service.persistence.SocialLinkTypeUtil
 * @generated
 */
@ProviderType
public class SocialLinkTypePersistenceImpl extends BasePersistenceImpl<SocialLinkType>
	implements SocialLinkTypePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SocialLinkTypeUtil} to access the social link type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SocialLinkTypeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SocialLinkTypeModelImpl.ENTITY_CACHE_ENABLED,
			SocialLinkTypeModelImpl.FINDER_CACHE_ENABLED,
			SocialLinkTypeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SocialLinkTypeModelImpl.ENTITY_CACHE_ENABLED,
			SocialLinkTypeModelImpl.FINDER_CACHE_ENABLED,
			SocialLinkTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SocialLinkTypeModelImpl.ENTITY_CACHE_ENABLED,
			SocialLinkTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public SocialLinkTypePersistenceImpl() {
		setModelClass(SocialLinkType.class);
	}

	/**
	 * Caches the social link type in the entity cache if it is enabled.
	 *
	 * @param socialLinkType the social link type
	 */
	@Override
	public void cacheResult(SocialLinkType socialLinkType) {
		entityCache.putResult(SocialLinkTypeModelImpl.ENTITY_CACHE_ENABLED,
			SocialLinkTypeImpl.class, socialLinkType.getPrimaryKey(),
			socialLinkType);

		socialLinkType.resetOriginalValues();
	}

	/**
	 * Caches the social link types in the entity cache if it is enabled.
	 *
	 * @param socialLinkTypes the social link types
	 */
	@Override
	public void cacheResult(List<SocialLinkType> socialLinkTypes) {
		for (SocialLinkType socialLinkType : socialLinkTypes) {
			if (entityCache.getResult(
						SocialLinkTypeModelImpl.ENTITY_CACHE_ENABLED,
						SocialLinkTypeImpl.class, socialLinkType.getPrimaryKey()) == null) {
				cacheResult(socialLinkType);
			}
			else {
				socialLinkType.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all social link types.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SocialLinkTypeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the social link type.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SocialLinkType socialLinkType) {
		entityCache.removeResult(SocialLinkTypeModelImpl.ENTITY_CACHE_ENABLED,
			SocialLinkTypeImpl.class, socialLinkType.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SocialLinkType> socialLinkTypes) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SocialLinkType socialLinkType : socialLinkTypes) {
			entityCache.removeResult(SocialLinkTypeModelImpl.ENTITY_CACHE_ENABLED,
				SocialLinkTypeImpl.class, socialLinkType.getPrimaryKey());
		}
	}

	/**
	 * Creates a new social link type with the primary key. Does not add the social link type to the database.
	 *
	 * @param socialLinkTypeId the primary key for the new social link type
	 * @return the new social link type
	 */
	@Override
	public SocialLinkType create(long socialLinkTypeId) {
		SocialLinkType socialLinkType = new SocialLinkTypeImpl();

		socialLinkType.setNew(true);
		socialLinkType.setPrimaryKey(socialLinkTypeId);

		return socialLinkType;
	}

	/**
	 * Removes the social link type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param socialLinkTypeId the primary key of the social link type
	 * @return the social link type that was removed
	 * @throws NoSuchSocialLinkTypeException if a social link type with the primary key could not be found
	 */
	@Override
	public SocialLinkType remove(long socialLinkTypeId)
		throws NoSuchSocialLinkTypeException {
		return remove((Serializable)socialLinkTypeId);
	}

	/**
	 * Removes the social link type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the social link type
	 * @return the social link type that was removed
	 * @throws NoSuchSocialLinkTypeException if a social link type with the primary key could not be found
	 */
	@Override
	public SocialLinkType remove(Serializable primaryKey)
		throws NoSuchSocialLinkTypeException {
		Session session = null;

		try {
			session = openSession();

			SocialLinkType socialLinkType = (SocialLinkType)session.get(SocialLinkTypeImpl.class,
					primaryKey);

			if (socialLinkType == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSocialLinkTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(socialLinkType);
		}
		catch (NoSuchSocialLinkTypeException nsee) {
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
	protected SocialLinkType removeImpl(SocialLinkType socialLinkType) {
		socialLinkType = toUnwrappedModel(socialLinkType);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(socialLinkType)) {
				socialLinkType = (SocialLinkType)session.get(SocialLinkTypeImpl.class,
						socialLinkType.getPrimaryKeyObj());
			}

			if (socialLinkType != null) {
				session.delete(socialLinkType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (socialLinkType != null) {
			clearCache(socialLinkType);
		}

		return socialLinkType;
	}

	@Override
	public SocialLinkType updateImpl(SocialLinkType socialLinkType) {
		socialLinkType = toUnwrappedModel(socialLinkType);

		boolean isNew = socialLinkType.isNew();

		SocialLinkTypeModelImpl socialLinkTypeModelImpl = (SocialLinkTypeModelImpl)socialLinkType;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (socialLinkType.getCreateDate() == null)) {
			if (serviceContext == null) {
				socialLinkType.setCreateDate(now);
			}
			else {
				socialLinkType.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!socialLinkTypeModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				socialLinkType.setModifiedDate(now);
			}
			else {
				socialLinkType.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (socialLinkType.isNew()) {
				session.save(socialLinkType);

				socialLinkType.setNew(false);
			}
			else {
				socialLinkType = (SocialLinkType)session.merge(socialLinkType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(SocialLinkTypeModelImpl.ENTITY_CACHE_ENABLED,
			SocialLinkTypeImpl.class, socialLinkType.getPrimaryKey(),
			socialLinkType, false);

		socialLinkType.resetOriginalValues();

		return socialLinkType;
	}

	protected SocialLinkType toUnwrappedModel(SocialLinkType socialLinkType) {
		if (socialLinkType instanceof SocialLinkTypeImpl) {
			return socialLinkType;
		}

		SocialLinkTypeImpl socialLinkTypeImpl = new SocialLinkTypeImpl();

		socialLinkTypeImpl.setNew(socialLinkType.isNew());
		socialLinkTypeImpl.setPrimaryKey(socialLinkType.getPrimaryKey());

		socialLinkTypeImpl.setSocialLinkTypeId(socialLinkType.getSocialLinkTypeId());
		socialLinkTypeImpl.setUserId(socialLinkType.getUserId());
		socialLinkTypeImpl.setUserName(socialLinkType.getUserName());
		socialLinkTypeImpl.setCreateDate(socialLinkType.getCreateDate());
		socialLinkTypeImpl.setModifiedDate(socialLinkType.getModifiedDate());
		socialLinkTypeImpl.setName(socialLinkType.getName());
		socialLinkTypeImpl.setImageFileEntryId(socialLinkType.getImageFileEntryId());

		return socialLinkTypeImpl;
	}

	/**
	 * Returns the social link type with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the social link type
	 * @return the social link type
	 * @throws NoSuchSocialLinkTypeException if a social link type with the primary key could not be found
	 */
	@Override
	public SocialLinkType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSocialLinkTypeException {
		SocialLinkType socialLinkType = fetchByPrimaryKey(primaryKey);

		if (socialLinkType == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSocialLinkTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return socialLinkType;
	}

	/**
	 * Returns the social link type with the primary key or throws a {@link NoSuchSocialLinkTypeException} if it could not be found.
	 *
	 * @param socialLinkTypeId the primary key of the social link type
	 * @return the social link type
	 * @throws NoSuchSocialLinkTypeException if a social link type with the primary key could not be found
	 */
	@Override
	public SocialLinkType findByPrimaryKey(long socialLinkTypeId)
		throws NoSuchSocialLinkTypeException {
		return findByPrimaryKey((Serializable)socialLinkTypeId);
	}

	/**
	 * Returns the social link type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the social link type
	 * @return the social link type, or <code>null</code> if a social link type with the primary key could not be found
	 */
	@Override
	public SocialLinkType fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(SocialLinkTypeModelImpl.ENTITY_CACHE_ENABLED,
				SocialLinkTypeImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		SocialLinkType socialLinkType = (SocialLinkType)serializable;

		if (socialLinkType == null) {
			Session session = null;

			try {
				session = openSession();

				socialLinkType = (SocialLinkType)session.get(SocialLinkTypeImpl.class,
						primaryKey);

				if (socialLinkType != null) {
					cacheResult(socialLinkType);
				}
				else {
					entityCache.putResult(SocialLinkTypeModelImpl.ENTITY_CACHE_ENABLED,
						SocialLinkTypeImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(SocialLinkTypeModelImpl.ENTITY_CACHE_ENABLED,
					SocialLinkTypeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return socialLinkType;
	}

	/**
	 * Returns the social link type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param socialLinkTypeId the primary key of the social link type
	 * @return the social link type, or <code>null</code> if a social link type with the primary key could not be found
	 */
	@Override
	public SocialLinkType fetchByPrimaryKey(long socialLinkTypeId) {
		return fetchByPrimaryKey((Serializable)socialLinkTypeId);
	}

	@Override
	public Map<Serializable, SocialLinkType> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, SocialLinkType> map = new HashMap<Serializable, SocialLinkType>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			SocialLinkType socialLinkType = fetchByPrimaryKey(primaryKey);

			if (socialLinkType != null) {
				map.put(primaryKey, socialLinkType);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(SocialLinkTypeModelImpl.ENTITY_CACHE_ENABLED,
					SocialLinkTypeImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (SocialLinkType)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_SOCIALLINKTYPE_WHERE_PKS_IN);

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

			for (SocialLinkType socialLinkType : (List<SocialLinkType>)q.list()) {
				map.put(socialLinkType.getPrimaryKeyObj(), socialLinkType);

				cacheResult(socialLinkType);

				uncachedPrimaryKeys.remove(socialLinkType.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(SocialLinkTypeModelImpl.ENTITY_CACHE_ENABLED,
					SocialLinkTypeImpl.class, primaryKey, nullModel);
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
	 * Returns all the social link types.
	 *
	 * @return the social link types
	 */
	@Override
	public List<SocialLinkType> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the social link types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SocialLinkTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of social link types
	 * @param end the upper bound of the range of social link types (not inclusive)
	 * @return the range of social link types
	 */
	@Override
	public List<SocialLinkType> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the social link types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SocialLinkTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of social link types
	 * @param end the upper bound of the range of social link types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of social link types
	 */
	@Override
	public List<SocialLinkType> findAll(int start, int end,
		OrderByComparator<SocialLinkType> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the social link types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SocialLinkTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of social link types
	 * @param end the upper bound of the range of social link types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of social link types
	 */
	@Override
	public List<SocialLinkType> findAll(int start, int end,
		OrderByComparator<SocialLinkType> orderByComparator,
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

		List<SocialLinkType> list = null;

		if (retrieveFromCache) {
			list = (List<SocialLinkType>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_SOCIALLINKTYPE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SOCIALLINKTYPE;

				if (pagination) {
					sql = sql.concat(SocialLinkTypeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SocialLinkType>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SocialLinkType>)QueryUtil.list(q,
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
	 * Removes all the social link types from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SocialLinkType socialLinkType : findAll()) {
			remove(socialLinkType);
		}
	}

	/**
	 * Returns the number of social link types.
	 *
	 * @return the number of social link types
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SOCIALLINKTYPE);

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
		return SocialLinkTypeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the social link type persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(SocialLinkTypeImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_SOCIALLINKTYPE = "SELECT socialLinkType FROM SocialLinkType socialLinkType";
	private static final String _SQL_SELECT_SOCIALLINKTYPE_WHERE_PKS_IN = "SELECT socialLinkType FROM SocialLinkType socialLinkType WHERE socialLinkTypeId IN (";
	private static final String _SQL_COUNT_SOCIALLINKTYPE = "SELECT COUNT(socialLinkType) FROM SocialLinkType socialLinkType";
	private static final String _ORDER_BY_ENTITY_ALIAS = "socialLinkType.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SocialLinkType exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(SocialLinkTypePersistenceImpl.class);
}