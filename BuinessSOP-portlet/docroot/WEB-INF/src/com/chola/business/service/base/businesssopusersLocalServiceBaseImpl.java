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

package com.chola.business.service.base;

import aQute.bnd.annotation.ProviderType;

import com.chola.business.model.businesssopusers;
import com.chola.business.service.businesssopusersLocalService;
import com.chola.business.service.persistence.businesssopDetailsFinder;
import com.chola.business.service.persistence.businesssopDetailsPersistence;
import com.chola.business.service.persistence.businesssoppathPersistence;
import com.chola.business.service.persistence.businesssopusersPersistence;

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
 * Provides the base implementation for the businesssopusers local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.chola.business.service.impl.businesssopusersLocalServiceImpl}.
 * </p>
 *
 * @author adms.java1
 * @see com.chola.business.service.impl.businesssopusersLocalServiceImpl
 * @see com.chola.business.service.businesssopusersLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class businesssopusersLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements businesssopusersLocalService,
		IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.chola.business.service.businesssopusersLocalServiceUtil} to access the businesssopusers local service.
	 */

	/**
	 * Adds the businesssopusers to the database. Also notifies the appropriate model listeners.
	 *
	 * @param businesssopusers the businesssopusers
	 * @return the businesssopusers that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public businesssopusers addbusinesssopusers(
		businesssopusers businesssopusers) {
		businesssopusers.setNew(true);

		return businesssopusersPersistence.update(businesssopusers);
	}

	/**
	 * Creates a new businesssopusers with the primary key. Does not add the businesssopusers to the database.
	 *
	 * @param id the primary key for the new businesssopusers
	 * @return the new businesssopusers
	 */
	@Override
	public businesssopusers createbusinesssopusers(long id) {
		return businesssopusersPersistence.create(id);
	}

	/**
	 * Deletes the businesssopusers with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the businesssopusers
	 * @return the businesssopusers that was removed
	 * @throws PortalException if a businesssopusers with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public businesssopusers deletebusinesssopusers(long id)
		throws PortalException {
		return businesssopusersPersistence.remove(id);
	}

	/**
	 * Deletes the businesssopusers from the database. Also notifies the appropriate model listeners.
	 *
	 * @param businesssopusers the businesssopusers
	 * @return the businesssopusers that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public businesssopusers deletebusinesssopusers(
		businesssopusers businesssopusers) {
		return businesssopusersPersistence.remove(businesssopusers);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(businesssopusers.class,
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
		return businesssopusersPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.chola.business.model.impl.businesssopusersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return businesssopusersPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.chola.business.model.impl.businesssopusersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return businesssopusersPersistence.findWithDynamicQuery(dynamicQuery,
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
		return businesssopusersPersistence.countWithDynamicQuery(dynamicQuery);
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
		return businesssopusersPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public businesssopusers fetchbusinesssopusers(long id) {
		return businesssopusersPersistence.fetchByPrimaryKey(id);
	}

	/**
	 * Returns the businesssopusers with the primary key.
	 *
	 * @param id the primary key of the businesssopusers
	 * @return the businesssopusers
	 * @throws PortalException if a businesssopusers with the primary key could not be found
	 */
	@Override
	public businesssopusers getbusinesssopusers(long id)
		throws PortalException {
		return businesssopusersPersistence.findByPrimaryKey(id);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(businesssopusersLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(businesssopusers.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(businesssopusersLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(businesssopusers.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("id");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(businesssopusersLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(businesssopusers.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return businesssopusersLocalService.deletebusinesssopusers((businesssopusers)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return businesssopusersPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the businesssopuserses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.chola.business.model.impl.businesssopusersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of businesssopuserses
	 * @param end the upper bound of the range of businesssopuserses (not inclusive)
	 * @return the range of businesssopuserses
	 */
	@Override
	public List<businesssopusers> getbusinesssopuserses(int start, int end) {
		return businesssopusersPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of businesssopuserses.
	 *
	 * @return the number of businesssopuserses
	 */
	@Override
	public int getbusinesssopusersesCount() {
		return businesssopusersPersistence.countAll();
	}

	/**
	 * Updates the businesssopusers in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param businesssopusers the businesssopusers
	 * @return the businesssopusers that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public businesssopusers updatebusinesssopusers(
		businesssopusers businesssopusers) {
		return businesssopusersPersistence.update(businesssopusers);
	}

	/**
	 * Returns the businesssop details local service.
	 *
	 * @return the businesssop details local service
	 */
	public com.chola.business.service.businesssopDetailsLocalService getbusinesssopDetailsLocalService() {
		return businesssopDetailsLocalService;
	}

	/**
	 * Sets the businesssop details local service.
	 *
	 * @param businesssopDetailsLocalService the businesssop details local service
	 */
	public void setbusinesssopDetailsLocalService(
		com.chola.business.service.businesssopDetailsLocalService businesssopDetailsLocalService) {
		this.businesssopDetailsLocalService = businesssopDetailsLocalService;
	}

	/**
	 * Returns the businesssop details persistence.
	 *
	 * @return the businesssop details persistence
	 */
	public businesssopDetailsPersistence getbusinesssopDetailsPersistence() {
		return businesssopDetailsPersistence;
	}

	/**
	 * Sets the businesssop details persistence.
	 *
	 * @param businesssopDetailsPersistence the businesssop details persistence
	 */
	public void setbusinesssopDetailsPersistence(
		businesssopDetailsPersistence businesssopDetailsPersistence) {
		this.businesssopDetailsPersistence = businesssopDetailsPersistence;
	}

	/**
	 * Returns the businesssop details finder.
	 *
	 * @return the businesssop details finder
	 */
	public businesssopDetailsFinder getbusinesssopDetailsFinder() {
		return businesssopDetailsFinder;
	}

	/**
	 * Sets the businesssop details finder.
	 *
	 * @param businesssopDetailsFinder the businesssop details finder
	 */
	public void setbusinesssopDetailsFinder(
		businesssopDetailsFinder businesssopDetailsFinder) {
		this.businesssopDetailsFinder = businesssopDetailsFinder;
	}

	/**
	 * Returns the businesssoppath local service.
	 *
	 * @return the businesssoppath local service
	 */
	public com.chola.business.service.businesssoppathLocalService getbusinesssoppathLocalService() {
		return businesssoppathLocalService;
	}

	/**
	 * Sets the businesssoppath local service.
	 *
	 * @param businesssoppathLocalService the businesssoppath local service
	 */
	public void setbusinesssoppathLocalService(
		com.chola.business.service.businesssoppathLocalService businesssoppathLocalService) {
		this.businesssoppathLocalService = businesssoppathLocalService;
	}

	/**
	 * Returns the businesssoppath persistence.
	 *
	 * @return the businesssoppath persistence
	 */
	public businesssoppathPersistence getbusinesssoppathPersistence() {
		return businesssoppathPersistence;
	}

	/**
	 * Sets the businesssoppath persistence.
	 *
	 * @param businesssoppathPersistence the businesssoppath persistence
	 */
	public void setbusinesssoppathPersistence(
		businesssoppathPersistence businesssoppathPersistence) {
		this.businesssoppathPersistence = businesssoppathPersistence;
	}

	/**
	 * Returns the businesssopusers local service.
	 *
	 * @return the businesssopusers local service
	 */
	public businesssopusersLocalService getbusinesssopusersLocalService() {
		return businesssopusersLocalService;
	}

	/**
	 * Sets the businesssopusers local service.
	 *
	 * @param businesssopusersLocalService the businesssopusers local service
	 */
	public void setbusinesssopusersLocalService(
		businesssopusersLocalService businesssopusersLocalService) {
		this.businesssopusersLocalService = businesssopusersLocalService;
	}

	/**
	 * Returns the businesssopusers persistence.
	 *
	 * @return the businesssopusers persistence
	 */
	public businesssopusersPersistence getbusinesssopusersPersistence() {
		return businesssopusersPersistence;
	}

	/**
	 * Sets the businesssopusers persistence.
	 *
	 * @param businesssopusersPersistence the businesssopusers persistence
	 */
	public void setbusinesssopusersPersistence(
		businesssopusersPersistence businesssopusersPersistence) {
		this.businesssopusersPersistence = businesssopusersPersistence;
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

		PersistedModelLocalServiceRegistryUtil.register("com.chola.business.model.businesssopusers",
			businesssopusersLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.chola.business.model.businesssopusers");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return businesssopusersLocalService.class.getName();
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
		return businesssopusers.class;
	}

	protected String getModelClassName() {
		return businesssopusers.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = businesssopusersPersistence.getDataSource();

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

	@BeanReference(type = com.chola.business.service.businesssopDetailsLocalService.class)
	protected com.chola.business.service.businesssopDetailsLocalService businesssopDetailsLocalService;
	@BeanReference(type = businesssopDetailsPersistence.class)
	protected businesssopDetailsPersistence businesssopDetailsPersistence;
	@BeanReference(type = businesssopDetailsFinder.class)
	protected businesssopDetailsFinder businesssopDetailsFinder;
	@BeanReference(type = com.chola.business.service.businesssoppathLocalService.class)
	protected com.chola.business.service.businesssoppathLocalService businesssoppathLocalService;
	@BeanReference(type = businesssoppathPersistence.class)
	protected businesssoppathPersistence businesssoppathPersistence;
	@BeanReference(type = businesssopusersLocalService.class)
	protected businesssopusersLocalService businesssopusersLocalService;
	@BeanReference(type = businesssopusersPersistence.class)
	protected businesssopusersPersistence businesssopusersPersistence;
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
	private businesssopusersLocalServiceClpInvoker _clpInvoker = new businesssopusersLocalServiceClpInvoker();
}