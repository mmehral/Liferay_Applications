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

package com.chola.successstories.service.base;

import aQute.bnd.annotation.ProviderType;

import com.chola.successstories.model.ssdetails;
import com.chola.successstories.service.persistence.ssdetailsFinder;
import com.chola.successstories.service.persistence.ssdetailsPersistence;
import com.chola.successstories.service.persistence.sspathPersistence;
import com.chola.successstories.service.ssdetailsLocalService;

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
 * Provides the base implementation for the ssdetails local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.chola.successstories.service.impl.ssdetailsLocalServiceImpl}.
 * </p>
 *
 * @author cloverliferay01
 * @see com.chola.successstories.service.impl.ssdetailsLocalServiceImpl
 * @see com.chola.successstories.service.ssdetailsLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class ssdetailsLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements ssdetailsLocalService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.chola.successstories.service.ssdetailsLocalServiceUtil} to access the ssdetails local service.
	 */

	/**
	 * Adds the ssdetails to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ssdetails the ssdetails
	 * @return the ssdetails that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ssdetails addssdetails(ssdetails ssdetails) {
		ssdetails.setNew(true);

		return ssdetailsPersistence.update(ssdetails);
	}

	/**
	 * Creates a new ssdetails with the primary key. Does not add the ssdetails to the database.
	 *
	 * @param id the primary key for the new ssdetails
	 * @return the new ssdetails
	 */
	@Override
	public ssdetails createssdetails(long id) {
		return ssdetailsPersistence.create(id);
	}

	/**
	 * Deletes the ssdetails with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the ssdetails
	 * @return the ssdetails that was removed
	 * @throws PortalException if a ssdetails with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ssdetails deletessdetails(long id) throws PortalException {
		return ssdetailsPersistence.remove(id);
	}

	/**
	 * Deletes the ssdetails from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ssdetails the ssdetails
	 * @return the ssdetails that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ssdetails deletessdetails(ssdetails ssdetails) {
		return ssdetailsPersistence.remove(ssdetails);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(ssdetails.class,
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
		return ssdetailsPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.chola.successstories.model.impl.ssdetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return ssdetailsPersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.chola.successstories.model.impl.ssdetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return ssdetailsPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return ssdetailsPersistence.countWithDynamicQuery(dynamicQuery);
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
		return ssdetailsPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public ssdetails fetchssdetails(long id) {
		return ssdetailsPersistence.fetchByPrimaryKey(id);
	}

	/**
	 * Returns the ssdetails with the primary key.
	 *
	 * @param id the primary key of the ssdetails
	 * @return the ssdetails
	 * @throws PortalException if a ssdetails with the primary key could not be found
	 */
	@Override
	public ssdetails getssdetails(long id) throws PortalException {
		return ssdetailsPersistence.findByPrimaryKey(id);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(ssdetailsLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ssdetails.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(ssdetailsLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(ssdetails.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("id");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(ssdetailsLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ssdetails.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return ssdetailsLocalService.deletessdetails((ssdetails)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return ssdetailsPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the ssdetailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.chola.successstories.model.impl.ssdetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ssdetailses
	 * @param end the upper bound of the range of ssdetailses (not inclusive)
	 * @return the range of ssdetailses
	 */
	@Override
	public List<ssdetails> getssdetailses(int start, int end) {
		return ssdetailsPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of ssdetailses.
	 *
	 * @return the number of ssdetailses
	 */
	@Override
	public int getssdetailsesCount() {
		return ssdetailsPersistence.countAll();
	}

	/**
	 * Updates the ssdetails in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param ssdetails the ssdetails
	 * @return the ssdetails that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ssdetails updatessdetails(ssdetails ssdetails) {
		return ssdetailsPersistence.update(ssdetails);
	}

	/**
	 * Returns the ssdetails local service.
	 *
	 * @return the ssdetails local service
	 */
	public ssdetailsLocalService getssdetailsLocalService() {
		return ssdetailsLocalService;
	}

	/**
	 * Sets the ssdetails local service.
	 *
	 * @param ssdetailsLocalService the ssdetails local service
	 */
	public void setssdetailsLocalService(
		ssdetailsLocalService ssdetailsLocalService) {
		this.ssdetailsLocalService = ssdetailsLocalService;
	}

	/**
	 * Returns the ssdetails persistence.
	 *
	 * @return the ssdetails persistence
	 */
	public ssdetailsPersistence getssdetailsPersistence() {
		return ssdetailsPersistence;
	}

	/**
	 * Sets the ssdetails persistence.
	 *
	 * @param ssdetailsPersistence the ssdetails persistence
	 */
	public void setssdetailsPersistence(
		ssdetailsPersistence ssdetailsPersistence) {
		this.ssdetailsPersistence = ssdetailsPersistence;
	}

	/**
	 * Returns the ssdetails finder.
	 *
	 * @return the ssdetails finder
	 */
	public ssdetailsFinder getssdetailsFinder() {
		return ssdetailsFinder;
	}

	/**
	 * Sets the ssdetails finder.
	 *
	 * @param ssdetailsFinder the ssdetails finder
	 */
	public void setssdetailsFinder(ssdetailsFinder ssdetailsFinder) {
		this.ssdetailsFinder = ssdetailsFinder;
	}

	/**
	 * Returns the sspath local service.
	 *
	 * @return the sspath local service
	 */
	public com.chola.successstories.service.sspathLocalService getsspathLocalService() {
		return sspathLocalService;
	}

	/**
	 * Sets the sspath local service.
	 *
	 * @param sspathLocalService the sspath local service
	 */
	public void setsspathLocalService(
		com.chola.successstories.service.sspathLocalService sspathLocalService) {
		this.sspathLocalService = sspathLocalService;
	}

	/**
	 * Returns the sspath persistence.
	 *
	 * @return the sspath persistence
	 */
	public sspathPersistence getsspathPersistence() {
		return sspathPersistence;
	}

	/**
	 * Sets the sspath persistence.
	 *
	 * @param sspathPersistence the sspath persistence
	 */
	public void setsspathPersistence(sspathPersistence sspathPersistence) {
		this.sspathPersistence = sspathPersistence;
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

		PersistedModelLocalServiceRegistryUtil.register("com.chola.successstories.model.ssdetails",
			ssdetailsLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.chola.successstories.model.ssdetails");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return ssdetailsLocalService.class.getName();
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
		return ssdetails.class;
	}

	protected String getModelClassName() {
		return ssdetails.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = ssdetailsPersistence.getDataSource();

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

	@BeanReference(type = ssdetailsLocalService.class)
	protected ssdetailsLocalService ssdetailsLocalService;
	@BeanReference(type = ssdetailsPersistence.class)
	protected ssdetailsPersistence ssdetailsPersistence;
	@BeanReference(type = ssdetailsFinder.class)
	protected ssdetailsFinder ssdetailsFinder;
	@BeanReference(type = com.chola.successstories.service.sspathLocalService.class)
	protected com.chola.successstories.service.sspathLocalService sspathLocalService;
	@BeanReference(type = sspathPersistence.class)
	protected sspathPersistence sspathPersistence;
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
	private ssdetailsLocalServiceClpInvoker _clpInvoker = new ssdetailsLocalServiceClpInvoker();
}