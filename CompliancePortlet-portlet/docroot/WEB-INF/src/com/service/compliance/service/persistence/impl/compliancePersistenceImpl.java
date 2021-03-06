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

package com.service.compliance.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import com.service.compliance.exception.NoSuchcomplianceException;
import com.service.compliance.model.compliance;
import com.service.compliance.model.impl.complianceImpl;
import com.service.compliance.model.impl.complianceModelImpl;
import com.service.compliance.service.persistence.compliancePersistence;

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
 * The persistence implementation for the compliance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author adms.java1
 * @see compliancePersistence
 * @see com.service.compliance.service.persistence.complianceUtil
 * @generated
 */
@ProviderType
public class compliancePersistenceImpl extends BasePersistenceImpl<compliance>
	implements compliancePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link complianceUtil} to access the compliance persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = complianceImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(complianceModelImpl.ENTITY_CACHE_ENABLED,
			complianceModelImpl.FINDER_CACHE_ENABLED, complianceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(complianceModelImpl.ENTITY_CACHE_ENABLED,
			complianceModelImpl.FINDER_CACHE_ENABLED, complianceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(complianceModelImpl.ENTITY_CACHE_ENABLED,
			complianceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public compliancePersistenceImpl() {
		setModelClass(compliance.class);
	}

	/**
	 * Caches the compliance in the entity cache if it is enabled.
	 *
	 * @param compliance the compliance
	 */
	@Override
	public void cacheResult(compliance compliance) {
		entityCache.putResult(complianceModelImpl.ENTITY_CACHE_ENABLED,
			complianceImpl.class, compliance.getPrimaryKey(), compliance);

		compliance.resetOriginalValues();
	}

	/**
	 * Caches the compliances in the entity cache if it is enabled.
	 *
	 * @param compliances the compliances
	 */
	@Override
	public void cacheResult(List<compliance> compliances) {
		for (compliance compliance : compliances) {
			if (entityCache.getResult(
						complianceModelImpl.ENTITY_CACHE_ENABLED,
						complianceImpl.class, compliance.getPrimaryKey()) == null) {
				cacheResult(compliance);
			}
			else {
				compliance.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all compliances.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(complianceImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the compliance.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(compliance compliance) {
		entityCache.removeResult(complianceModelImpl.ENTITY_CACHE_ENABLED,
			complianceImpl.class, compliance.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<compliance> compliances) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (compliance compliance : compliances) {
			entityCache.removeResult(complianceModelImpl.ENTITY_CACHE_ENABLED,
				complianceImpl.class, compliance.getPrimaryKey());
		}
	}

	/**
	 * Creates a new compliance with the primary key. Does not add the compliance to the database.
	 *
	 * @param compliance_id the primary key for the new compliance
	 * @return the new compliance
	 */
	@Override
	public compliance create(long compliance_id) {
		compliance compliance = new complianceImpl();

		compliance.setNew(true);
		compliance.setPrimaryKey(compliance_id);

		return compliance;
	}

	/**
	 * Removes the compliance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param compliance_id the primary key of the compliance
	 * @return the compliance that was removed
	 * @throws NoSuchcomplianceException if a compliance with the primary key could not be found
	 */
	@Override
	public compliance remove(long compliance_id)
		throws NoSuchcomplianceException {
		return remove((Serializable)compliance_id);
	}

	/**
	 * Removes the compliance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the compliance
	 * @return the compliance that was removed
	 * @throws NoSuchcomplianceException if a compliance with the primary key could not be found
	 */
	@Override
	public compliance remove(Serializable primaryKey)
		throws NoSuchcomplianceException {
		Session session = null;

		try {
			session = openSession();

			compliance compliance = (compliance)session.get(complianceImpl.class,
					primaryKey);

			if (compliance == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchcomplianceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(compliance);
		}
		catch (NoSuchcomplianceException nsee) {
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
	protected compliance removeImpl(compliance compliance) {
		compliance = toUnwrappedModel(compliance);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(compliance)) {
				compliance = (compliance)session.get(complianceImpl.class,
						compliance.getPrimaryKeyObj());
			}

			if (compliance != null) {
				session.delete(compliance);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (compliance != null) {
			clearCache(compliance);
		}

		return compliance;
	}

	@Override
	public compliance updateImpl(compliance compliance) {
		compliance = toUnwrappedModel(compliance);

		boolean isNew = compliance.isNew();

		complianceModelImpl complianceModelImpl = (complianceModelImpl)compliance;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (compliance.getCreateDate() == null)) {
			if (serviceContext == null) {
				compliance.setCreateDate(now);
			}
			else {
				compliance.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!complianceModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				compliance.setModifiedDate(now);
			}
			else {
				compliance.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (compliance.isNew()) {
				session.save(compliance);

				compliance.setNew(false);
			}
			else {
				compliance = (compliance)session.merge(compliance);
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
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		entityCache.putResult(complianceModelImpl.ENTITY_CACHE_ENABLED,
			complianceImpl.class, compliance.getPrimaryKey(), compliance, false);

		compliance.resetOriginalValues();

		return compliance;
	}

	protected compliance toUnwrappedModel(compliance compliance) {
		if (compliance instanceof complianceImpl) {
			return compliance;
		}

		complianceImpl complianceImpl = new complianceImpl();

		complianceImpl.setNew(compliance.isNew());
		complianceImpl.setPrimaryKey(compliance.getPrimaryKey());

		complianceImpl.setCompliance_id(compliance.getCompliance_id());
		complianceImpl.setCompliance_tite(compliance.getCompliance_tite());
		complianceImpl.setCompliance_shortdescription(compliance.getCompliance_shortdescription());
		complianceImpl.setCompliance_description(compliance.getCompliance_description());
		complianceImpl.setCompliance_document_name(compliance.getCompliance_document_name());
		complianceImpl.setCompliance_document_extension(compliance.getCompliance_document_extension());
		complianceImpl.setCompliance_document_path(compliance.getCompliance_document_path());
		complianceImpl.setCreateDate(compliance.getCreateDate());
		complianceImpl.setModifiedDate(compliance.getModifiedDate());

		return complianceImpl;
	}

	/**
	 * Returns the compliance with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the compliance
	 * @return the compliance
	 * @throws NoSuchcomplianceException if a compliance with the primary key could not be found
	 */
	@Override
	public compliance findByPrimaryKey(Serializable primaryKey)
		throws NoSuchcomplianceException {
		compliance compliance = fetchByPrimaryKey(primaryKey);

		if (compliance == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchcomplianceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return compliance;
	}

	/**
	 * Returns the compliance with the primary key or throws a {@link NoSuchcomplianceException} if it could not be found.
	 *
	 * @param compliance_id the primary key of the compliance
	 * @return the compliance
	 * @throws NoSuchcomplianceException if a compliance with the primary key could not be found
	 */
	@Override
	public compliance findByPrimaryKey(long compliance_id)
		throws NoSuchcomplianceException {
		return findByPrimaryKey((Serializable)compliance_id);
	}

	/**
	 * Returns the compliance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the compliance
	 * @return the compliance, or <code>null</code> if a compliance with the primary key could not be found
	 */
	@Override
	public compliance fetchByPrimaryKey(Serializable primaryKey) {
		compliance compliance = (compliance)entityCache.getResult(complianceModelImpl.ENTITY_CACHE_ENABLED,
				complianceImpl.class, primaryKey);

		if (compliance == _nullcompliance) {
			return null;
		}

		if (compliance == null) {
			Session session = null;

			try {
				session = openSession();

				compliance = (compliance)session.get(complianceImpl.class,
						primaryKey);

				if (compliance != null) {
					cacheResult(compliance);
				}
				else {
					entityCache.putResult(complianceModelImpl.ENTITY_CACHE_ENABLED,
						complianceImpl.class, primaryKey, _nullcompliance);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(complianceModelImpl.ENTITY_CACHE_ENABLED,
					complianceImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return compliance;
	}

	/**
	 * Returns the compliance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param compliance_id the primary key of the compliance
	 * @return the compliance, or <code>null</code> if a compliance with the primary key could not be found
	 */
	@Override
	public compliance fetchByPrimaryKey(long compliance_id) {
		return fetchByPrimaryKey((Serializable)compliance_id);
	}

	@Override
	public Map<Serializable, compliance> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, compliance> map = new HashMap<Serializable, compliance>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			compliance compliance = fetchByPrimaryKey(primaryKey);

			if (compliance != null) {
				map.put(primaryKey, compliance);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			compliance compliance = (compliance)entityCache.getResult(complianceModelImpl.ENTITY_CACHE_ENABLED,
					complianceImpl.class, primaryKey);

			if (compliance == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, compliance);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_COMPLIANCE_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (compliance compliance : (List<compliance>)q.list()) {
				map.put(compliance.getPrimaryKeyObj(), compliance);

				cacheResult(compliance);

				uncachedPrimaryKeys.remove(compliance.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(complianceModelImpl.ENTITY_CACHE_ENABLED,
					complianceImpl.class, primaryKey, _nullcompliance);
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
	 * Returns all the compliances.
	 *
	 * @return the compliances
	 */
	@Override
	public List<compliance> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the compliances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link complianceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of compliances
	 * @param end the upper bound of the range of compliances (not inclusive)
	 * @return the range of compliances
	 */
	@Override
	public List<compliance> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the compliances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link complianceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of compliances
	 * @param end the upper bound of the range of compliances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of compliances
	 */
	@Override
	public List<compliance> findAll(int start, int end,
		OrderByComparator<compliance> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the compliances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link complianceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of compliances
	 * @param end the upper bound of the range of compliances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of compliances
	 */
	@Override
	public List<compliance> findAll(int start, int end,
		OrderByComparator<compliance> orderByComparator,
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

		List<compliance> list = null;

		if (retrieveFromCache) {
			list = (List<compliance>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_COMPLIANCE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COMPLIANCE;

				if (pagination) {
					sql = sql.concat(complianceModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<compliance>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<compliance>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the compliances from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (compliance compliance : findAll()) {
			remove(compliance);
		}
	}

	/**
	 * Returns the number of compliances.
	 *
	 * @return the number of compliances
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_COMPLIANCE);

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
		return complianceModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the compliance persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(complianceImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	protected EntityCache entityCache = EntityCacheUtil.getEntityCache();
	protected FinderCache finderCache = FinderCacheUtil.getFinderCache();
	private static final String _SQL_SELECT_COMPLIANCE = "SELECT compliance FROM compliance compliance";
	private static final String _SQL_SELECT_COMPLIANCE_WHERE_PKS_IN = "SELECT compliance FROM compliance compliance WHERE compliance_id IN (";
	private static final String _SQL_COUNT_COMPLIANCE = "SELECT COUNT(compliance) FROM compliance compliance";
	private static final String _ORDER_BY_ENTITY_ALIAS = "compliance.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No compliance exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(compliancePersistenceImpl.class);
	private static final compliance _nullcompliance = new complianceImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<compliance> toCacheModel() {
				return _nullcomplianceCacheModel;
			}
		};

	private static final CacheModel<compliance> _nullcomplianceCacheModel = new CacheModel<compliance>() {
			@Override
			public compliance toEntityModel() {
				return _nullcompliance;
			}
		};
}