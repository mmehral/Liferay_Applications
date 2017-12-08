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

package com.chola.swagatam.service.base;

import aQute.bnd.annotation.ProviderType;

import com.chola.swagatam.model.swagatampath;
import com.chola.swagatam.service.persistence.swagatamPersistence;
import com.chola.swagatam.service.persistence.swagatamdataFinder;
import com.chola.swagatam.service.persistence.swagatamdataPersistence;
import com.chola.swagatam.service.persistence.swagatampathPersistence;
import com.chola.swagatam.service.swagatampathLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the swagatampath local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.chola.swagatam.service.impl.swagatampathLocalServiceImpl}.
 * </p>
 *
 * @author CloverLiferay02
 * @see com.chola.swagatam.service.impl.swagatampathLocalServiceImpl
 * @see com.chola.swagatam.service.swagatampathLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class swagatampathLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements swagatampathLocalService,
		IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.chola.swagatam.service.swagatampathLocalServiceUtil} to access the swagatampath local service.
	 */

	/**
	 * Adds the swagatampath to the database. Also notifies the appropriate model listeners.
	 *
	 * @param swagatampath the swagatampath
	 * @return the swagatampath that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public swagatampath addswagatampath(swagatampath swagatampath) {
		swagatampath.setNew(true);

		return swagatampathPersistence.update(swagatampath);
	}

	/**
	 * Creates a new swagatampath with the primary key. Does not add the swagatampath to the database.
	 *
	 * @param id the primary key for the new swagatampath
	 * @return the new swagatampath
	 */
	@Override
	public swagatampath createswagatampath(long id) {
		return swagatampathPersistence.create(id);
	}

	/**
	 * Deletes the swagatampath with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the swagatampath
	 * @return the swagatampath that was removed
	 * @throws PortalException if a swagatampath with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public swagatampath deleteswagatampath(long id) throws PortalException {
		return swagatampathPersistence.remove(id);
	}

	/**
	 * Deletes the swagatampath from the database. Also notifies the appropriate model listeners.
	 *
	 * @param swagatampath the swagatampath
	 * @return the swagatampath that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public swagatampath deleteswagatampath(swagatampath swagatampath) {
		return swagatampathPersistence.remove(swagatampath);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(swagatampath.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return swagatampathPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.chola.swagatam.model.impl.swagatampathModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) {
		return swagatampathPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.chola.swagatam.model.impl.swagatampathModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator) {
		return swagatampathPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return swagatampathPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) {
		return swagatampathPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public swagatampath fetchswagatampath(long id) {
		return swagatampathPersistence.fetchByPrimaryKey(id);
	}

	/**
	 * Returns the swagatampath with the primary key.
	 *
	 * @param id the primary key of the swagatampath
	 * @return the swagatampath
	 * @throws PortalException if a swagatampath with the primary key could not be found
	 */
	@Override
	public swagatampath getswagatampath(long id) throws PortalException {
		return swagatampathPersistence.findByPrimaryKey(id);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(swagatampathLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(swagatampath.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(swagatampathLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(swagatampath.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("id");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(swagatampathLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(swagatampath.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return swagatampathLocalService.deleteswagatampath((swagatampath)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return swagatampathPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the swagatampaths.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.chola.swagatam.model.impl.swagatampathModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of swagatampaths
	 * @param end the upper bound of the range of swagatampaths (not inclusive)
	 * @return the range of swagatampaths
	 */
	@Override
	public List<swagatampath> getswagatampaths(int start, int end) {
		return swagatampathPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of swagatampaths.
	 *
	 * @return the number of swagatampaths
	 */
	@Override
	public int getswagatampathsCount() {
		return swagatampathPersistence.countAll();
	}

	/**
	 * Updates the swagatampath in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param swagatampath the swagatampath
	 * @return the swagatampath that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public swagatampath updateswagatampath(swagatampath swagatampath) {
		return swagatampathPersistence.update(swagatampath);
	}

	/**
	 * Returns the swagatam local service.
	 *
	 * @return the swagatam local service
	 */
	public com.chola.swagatam.service.swagatamLocalService getswagatamLocalService() {
		return swagatamLocalService;
	}

	/**
	 * Sets the swagatam local service.
	 *
	 * @param swagatamLocalService the swagatam local service
	 */
	public void setswagatamLocalService(
		com.chola.swagatam.service.swagatamLocalService swagatamLocalService) {
		this.swagatamLocalService = swagatamLocalService;
	}

	/**
	 * Returns the swagatam persistence.
	 *
	 * @return the swagatam persistence
	 */
	public swagatamPersistence getswagatamPersistence() {
		return swagatamPersistence;
	}

	/**
	 * Sets the swagatam persistence.
	 *
	 * @param swagatamPersistence the swagatam persistence
	 */
	public void setswagatamPersistence(swagatamPersistence swagatamPersistence) {
		this.swagatamPersistence = swagatamPersistence;
	}

	/**
	 * Returns the swagatamdata local service.
	 *
	 * @return the swagatamdata local service
	 */
	public com.chola.swagatam.service.swagatamdataLocalService getswagatamdataLocalService() {
		return swagatamdataLocalService;
	}

	/**
	 * Sets the swagatamdata local service.
	 *
	 * @param swagatamdataLocalService the swagatamdata local service
	 */
	public void setswagatamdataLocalService(
		com.chola.swagatam.service.swagatamdataLocalService swagatamdataLocalService) {
		this.swagatamdataLocalService = swagatamdataLocalService;
	}

	/**
	 * Returns the swagatamdata persistence.
	 *
	 * @return the swagatamdata persistence
	 */
	public swagatamdataPersistence getswagatamdataPersistence() {
		return swagatamdataPersistence;
	}

	/**
	 * Sets the swagatamdata persistence.
	 *
	 * @param swagatamdataPersistence the swagatamdata persistence
	 */
	public void setswagatamdataPersistence(
		swagatamdataPersistence swagatamdataPersistence) {
		this.swagatamdataPersistence = swagatamdataPersistence;
	}

	/**
	 * Returns the swagatamdata finder.
	 *
	 * @return the swagatamdata finder
	 */
	public swagatamdataFinder getswagatamdataFinder() {
		return swagatamdataFinder;
	}

	/**
	 * Sets the swagatamdata finder.
	 *
	 * @param swagatamdataFinder the swagatamdata finder
	 */
	public void setswagatamdataFinder(swagatamdataFinder swagatamdataFinder) {
		this.swagatamdataFinder = swagatamdataFinder;
	}

	/**
	 * Returns the swagatampath local service.
	 *
	 * @return the swagatampath local service
	 */
	public swagatampathLocalService getswagatampathLocalService() {
		return swagatampathLocalService;
	}

	/**
	 * Sets the swagatampath local service.
	 *
	 * @param swagatampathLocalService the swagatampath local service
	 */
	public void setswagatampathLocalService(
		swagatampathLocalService swagatampathLocalService) {
		this.swagatampathLocalService = swagatampathLocalService;
	}

	/**
	 * Returns the swagatampath persistence.
	 *
	 * @return the swagatampath persistence
	 */
	public swagatampathPersistence getswagatampathPersistence() {
		return swagatampathPersistence;
	}

	/**
	 * Sets the swagatampath persistence.
	 *
	 * @param swagatampathPersistence the swagatampath persistence
	 */
	public void setswagatampathPersistence(
		swagatampathPersistence swagatampathPersistence) {
		this.swagatampathPersistence = swagatampathPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("com.chola.swagatam.model.swagatampath",
			swagatampathLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.chola.swagatam.model.swagatampath");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return swagatampathLocalService.class.getName();
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return swagatampath.class;
	}

	protected String getModelClassName() {
		return swagatampath.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = swagatampathPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.chola.swagatam.service.swagatamLocalService.class)
	protected com.chola.swagatam.service.swagatamLocalService swagatamLocalService;
	@BeanReference(type = swagatamPersistence.class)
	protected swagatamPersistence swagatamPersistence;
	@BeanReference(type = com.chola.swagatam.service.swagatamdataLocalService.class)
	protected com.chola.swagatam.service.swagatamdataLocalService swagatamdataLocalService;
	@BeanReference(type = swagatamdataPersistence.class)
	protected swagatamdataPersistence swagatamdataPersistence;
	@BeanReference(type = swagatamdataFinder.class)
	protected swagatamdataFinder swagatamdataFinder;
	@BeanReference(type = swagatampathLocalService.class)
	protected swagatampathLocalService swagatampathLocalService;
	@BeanReference(type = swagatampathPersistence.class)
	protected swagatampathPersistence swagatampathPersistence;
	@BeanReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@BeanReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@BeanReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private ClassLoader _classLoader;
	private swagatampathLocalServiceClpInvoker _clpInvoker = new swagatampathLocalServiceClpInvoker();
}