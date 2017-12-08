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

package com.service.base;

import aQute.bnd.annotation.ProviderType;

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

import com.model.cholatalkiesusers;

import com.service.cholatalkiesusersLocalService;

import com.service.persistence.cholatalkiesFinder;
import com.service.persistence.cholatalkiesPersistence;
import com.service.persistence.cholatalkiespathPersistence;
import com.service.persistence.cholatalkiesusersPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the cholatalkiesusers local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.service.impl.cholatalkiesusersLocalServiceImpl}.
 * </p>
 *
 * @author adms.java1
 * @see com.service.impl.cholatalkiesusersLocalServiceImpl
 * @see com.service.cholatalkiesusersLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class cholatalkiesusersLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements cholatalkiesusersLocalService,
		IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.service.cholatalkiesusersLocalServiceUtil} to access the cholatalkiesusers local service.
	 */

	/**
	 * Adds the cholatalkiesusers to the database. Also notifies the appropriate model listeners.
	 *
	 * @param cholatalkiesusers the cholatalkiesusers
	 * @return the cholatalkiesusers that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public cholatalkiesusers addcholatalkiesusers(
		cholatalkiesusers cholatalkiesusers) {
		cholatalkiesusers.setNew(true);

		return cholatalkiesusersPersistence.update(cholatalkiesusers);
	}

	/**
	 * Creates a new cholatalkiesusers with the primary key. Does not add the cholatalkiesusers to the database.
	 *
	 * @param id the primary key for the new cholatalkiesusers
	 * @return the new cholatalkiesusers
	 */
	@Override
	public cholatalkiesusers createcholatalkiesusers(long id) {
		return cholatalkiesusersPersistence.create(id);
	}

	/**
	 * Deletes the cholatalkiesusers with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the cholatalkiesusers
	 * @return the cholatalkiesusers that was removed
	 * @throws PortalException if a cholatalkiesusers with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public cholatalkiesusers deletecholatalkiesusers(long id)
		throws PortalException {
		return cholatalkiesusersPersistence.remove(id);
	}

	/**
	 * Deletes the cholatalkiesusers from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cholatalkiesusers the cholatalkiesusers
	 * @return the cholatalkiesusers that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public cholatalkiesusers deletecholatalkiesusers(
		cholatalkiesusers cholatalkiesusers) {
		return cholatalkiesusersPersistence.remove(cholatalkiesusers);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(cholatalkiesusers.class,
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
		return cholatalkiesusersPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.model.impl.cholatalkiesusersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return cholatalkiesusersPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.model.impl.cholatalkiesusersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return cholatalkiesusersPersistence.findWithDynamicQuery(dynamicQuery,
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
		return cholatalkiesusersPersistence.countWithDynamicQuery(dynamicQuery);
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
		return cholatalkiesusersPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public cholatalkiesusers fetchcholatalkiesusers(long id) {
		return cholatalkiesusersPersistence.fetchByPrimaryKey(id);
	}

	/**
	 * Returns the cholatalkiesusers with the primary key.
	 *
	 * @param id the primary key of the cholatalkiesusers
	 * @return the cholatalkiesusers
	 * @throws PortalException if a cholatalkiesusers with the primary key could not be found
	 */
	@Override
	public cholatalkiesusers getcholatalkiesusers(long id)
		throws PortalException {
		return cholatalkiesusersPersistence.findByPrimaryKey(id);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(cholatalkiesusersLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(cholatalkiesusers.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(cholatalkiesusersLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(cholatalkiesusers.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("id");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(cholatalkiesusersLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(cholatalkiesusers.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return cholatalkiesusersLocalService.deletecholatalkiesusers((cholatalkiesusers)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return cholatalkiesusersPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the cholatalkiesuserses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.model.impl.cholatalkiesusersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cholatalkiesuserses
	 * @param end the upper bound of the range of cholatalkiesuserses (not inclusive)
	 * @return the range of cholatalkiesuserses
	 */
	@Override
	public List<cholatalkiesusers> getcholatalkiesuserses(int start, int end) {
		return cholatalkiesusersPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of cholatalkiesuserses.
	 *
	 * @return the number of cholatalkiesuserses
	 */
	@Override
	public int getcholatalkiesusersesCount() {
		return cholatalkiesusersPersistence.countAll();
	}

	/**
	 * Updates the cholatalkiesusers in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param cholatalkiesusers the cholatalkiesusers
	 * @return the cholatalkiesusers that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public cholatalkiesusers updatecholatalkiesusers(
		cholatalkiesusers cholatalkiesusers) {
		return cholatalkiesusersPersistence.update(cholatalkiesusers);
	}

	/**
	 * Returns the cholatalkies local service.
	 *
	 * @return the cholatalkies local service
	 */
	public com.service.cholatalkiesLocalService getcholatalkiesLocalService() {
		return cholatalkiesLocalService;
	}

	/**
	 * Sets the cholatalkies local service.
	 *
	 * @param cholatalkiesLocalService the cholatalkies local service
	 */
	public void setcholatalkiesLocalService(
		com.service.cholatalkiesLocalService cholatalkiesLocalService) {
		this.cholatalkiesLocalService = cholatalkiesLocalService;
	}

	/**
	 * Returns the cholatalkies persistence.
	 *
	 * @return the cholatalkies persistence
	 */
	public cholatalkiesPersistence getcholatalkiesPersistence() {
		return cholatalkiesPersistence;
	}

	/**
	 * Sets the cholatalkies persistence.
	 *
	 * @param cholatalkiesPersistence the cholatalkies persistence
	 */
	public void setcholatalkiesPersistence(
		cholatalkiesPersistence cholatalkiesPersistence) {
		this.cholatalkiesPersistence = cholatalkiesPersistence;
	}

	/**
	 * Returns the cholatalkies finder.
	 *
	 * @return the cholatalkies finder
	 */
	public cholatalkiesFinder getcholatalkiesFinder() {
		return cholatalkiesFinder;
	}

	/**
	 * Sets the cholatalkies finder.
	 *
	 * @param cholatalkiesFinder the cholatalkies finder
	 */
	public void setcholatalkiesFinder(cholatalkiesFinder cholatalkiesFinder) {
		this.cholatalkiesFinder = cholatalkiesFinder;
	}

	/**
	 * Returns the cholatalkiespath local service.
	 *
	 * @return the cholatalkiespath local service
	 */
	public com.service.cholatalkiespathLocalService getcholatalkiespathLocalService() {
		return cholatalkiespathLocalService;
	}

	/**
	 * Sets the cholatalkiespath local service.
	 *
	 * @param cholatalkiespathLocalService the cholatalkiespath local service
	 */
	public void setcholatalkiespathLocalService(
		com.service.cholatalkiespathLocalService cholatalkiespathLocalService) {
		this.cholatalkiespathLocalService = cholatalkiespathLocalService;
	}

	/**
	 * Returns the cholatalkiespath persistence.
	 *
	 * @return the cholatalkiespath persistence
	 */
	public cholatalkiespathPersistence getcholatalkiespathPersistence() {
		return cholatalkiespathPersistence;
	}

	/**
	 * Sets the cholatalkiespath persistence.
	 *
	 * @param cholatalkiespathPersistence the cholatalkiespath persistence
	 */
	public void setcholatalkiespathPersistence(
		cholatalkiespathPersistence cholatalkiespathPersistence) {
		this.cholatalkiespathPersistence = cholatalkiespathPersistence;
	}

	/**
	 * Returns the cholatalkiesusers local service.
	 *
	 * @return the cholatalkiesusers local service
	 */
	public cholatalkiesusersLocalService getcholatalkiesusersLocalService() {
		return cholatalkiesusersLocalService;
	}

	/**
	 * Sets the cholatalkiesusers local service.
	 *
	 * @param cholatalkiesusersLocalService the cholatalkiesusers local service
	 */
	public void setcholatalkiesusersLocalService(
		cholatalkiesusersLocalService cholatalkiesusersLocalService) {
		this.cholatalkiesusersLocalService = cholatalkiesusersLocalService;
	}

	/**
	 * Returns the cholatalkiesusers persistence.
	 *
	 * @return the cholatalkiesusers persistence
	 */
	public cholatalkiesusersPersistence getcholatalkiesusersPersistence() {
		return cholatalkiesusersPersistence;
	}

	/**
	 * Sets the cholatalkiesusers persistence.
	 *
	 * @param cholatalkiesusersPersistence the cholatalkiesusers persistence
	 */
	public void setcholatalkiesusersPersistence(
		cholatalkiesusersPersistence cholatalkiesusersPersistence) {
		this.cholatalkiesusersPersistence = cholatalkiesusersPersistence;
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

		PersistedModelLocalServiceRegistryUtil.register("com.model.cholatalkiesusers",
			cholatalkiesusersLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.model.cholatalkiesusers");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return cholatalkiesusersLocalService.class.getName();
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
		return cholatalkiesusers.class;
	}

	protected String getModelClassName() {
		return cholatalkiesusers.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = cholatalkiesusersPersistence.getDataSource();

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

	@BeanReference(type = com.service.cholatalkiesLocalService.class)
	protected com.service.cholatalkiesLocalService cholatalkiesLocalService;
	@BeanReference(type = cholatalkiesPersistence.class)
	protected cholatalkiesPersistence cholatalkiesPersistence;
	@BeanReference(type = cholatalkiesFinder.class)
	protected cholatalkiesFinder cholatalkiesFinder;
	@BeanReference(type = com.service.cholatalkiespathLocalService.class)
	protected com.service.cholatalkiespathLocalService cholatalkiespathLocalService;
	@BeanReference(type = cholatalkiespathPersistence.class)
	protected cholatalkiespathPersistence cholatalkiespathPersistence;
	@BeanReference(type = cholatalkiesusersLocalService.class)
	protected cholatalkiesusersLocalService cholatalkiesusersLocalService;
	@BeanReference(type = cholatalkiesusersPersistence.class)
	protected cholatalkiesusersPersistence cholatalkiesusersPersistence;
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
	private cholatalkiesusersLocalServiceClpInvoker _clpInvoker = new cholatalkiesusersLocalServiceClpInvoker();
}