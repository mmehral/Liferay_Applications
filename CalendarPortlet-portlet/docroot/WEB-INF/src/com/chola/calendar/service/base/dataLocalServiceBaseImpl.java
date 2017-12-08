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

package com.chola.calendar.service.base;

import aQute.bnd.annotation.ProviderType;

import com.chola.calendar.model.data;
import com.chola.calendar.service.dataLocalService;
import com.chola.calendar.service.persistence.EmpInfoEntityPersistence;
import com.chola.calendar.service.persistence.dataPersistence;
import com.chola.calendar.service.persistence.eventcalendarFinder;
import com.chola.calendar.service.persistence.eventcalendarPersistence;

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
 * Provides the base implementation for the data local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.chola.calendar.service.impl.dataLocalServiceImpl}.
 * </p>
 *
 * @author adms.java1
 * @see com.chola.calendar.service.impl.dataLocalServiceImpl
 * @see com.chola.calendar.service.dataLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class dataLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements dataLocalService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.chola.calendar.service.dataLocalServiceUtil} to access the data local service.
	 */

	/**
	 * Adds the data to the database. Also notifies the appropriate model listeners.
	 *
	 * @param data the data
	 * @return the data that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public data adddata(data data) {
		data.setNew(true);

		return dataPersistence.update(data);
	}

	/**
	 * Creates a new data with the primary key. Does not add the data to the database.
	 *
	 * @param eventid the primary key for the new data
	 * @return the new data
	 */
	@Override
	public data createdata(long eventid) {
		return dataPersistence.create(eventid);
	}

	/**
	 * Deletes the data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventid the primary key of the data
	 * @return the data that was removed
	 * @throws PortalException if a data with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public data deletedata(long eventid) throws PortalException {
		return dataPersistence.remove(eventid);
	}

	/**
	 * Deletes the data from the database. Also notifies the appropriate model listeners.
	 *
	 * @param data the data
	 * @return the data that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public data deletedata(data data) {
		return dataPersistence.remove(data);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(data.class,
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
		return dataPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.chola.calendar.model.impl.dataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return dataPersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.chola.calendar.model.impl.dataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return dataPersistence.findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return dataPersistence.countWithDynamicQuery(dynamicQuery);
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
		return dataPersistence.countWithDynamicQuery(dynamicQuery, projection);
	}

	@Override
	public data fetchdata(long eventid) {
		return dataPersistence.fetchByPrimaryKey(eventid);
	}

	/**
	 * Returns the data with the primary key.
	 *
	 * @param eventid the primary key of the data
	 * @return the data
	 * @throws PortalException if a data with the primary key could not be found
	 */
	@Override
	public data getdata(long eventid) throws PortalException {
		return dataPersistence.findByPrimaryKey(eventid);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(dataLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(data.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("eventid");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(dataLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(data.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("eventid");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(dataLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(data.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("eventid");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return dataLocalService.deletedata((data)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return dataPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.chola.calendar.model.impl.dataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of datas
	 * @param end the upper bound of the range of datas (not inclusive)
	 * @return the range of datas
	 */
	@Override
	public List<data> getdatas(int start, int end) {
		return dataPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of datas.
	 *
	 * @return the number of datas
	 */
	@Override
	public int getdatasCount() {
		return dataPersistence.countAll();
	}

	/**
	 * Updates the data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param data the data
	 * @return the data that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public data updatedata(data data) {
		return dataPersistence.update(data);
	}

	/**
	 * Returns the data local service.
	 *
	 * @return the data local service
	 */
	public dataLocalService getdataLocalService() {
		return dataLocalService;
	}

	/**
	 * Sets the data local service.
	 *
	 * @param dataLocalService the data local service
	 */
	public void setdataLocalService(dataLocalService dataLocalService) {
		this.dataLocalService = dataLocalService;
	}

	/**
	 * Returns the data persistence.
	 *
	 * @return the data persistence
	 */
	public dataPersistence getdataPersistence() {
		return dataPersistence;
	}

	/**
	 * Sets the data persistence.
	 *
	 * @param dataPersistence the data persistence
	 */
	public void setdataPersistence(dataPersistence dataPersistence) {
		this.dataPersistence = dataPersistence;
	}

	/**
	 * Returns the emp info entity local service.
	 *
	 * @return the emp info entity local service
	 */
	public com.chola.calendar.service.EmpInfoEntityLocalService getEmpInfoEntityLocalService() {
		return empInfoEntityLocalService;
	}

	/**
	 * Sets the emp info entity local service.
	 *
	 * @param empInfoEntityLocalService the emp info entity local service
	 */
	public void setEmpInfoEntityLocalService(
		com.chola.calendar.service.EmpInfoEntityLocalService empInfoEntityLocalService) {
		this.empInfoEntityLocalService = empInfoEntityLocalService;
	}

	/**
	 * Returns the emp info entity persistence.
	 *
	 * @return the emp info entity persistence
	 */
	public EmpInfoEntityPersistence getEmpInfoEntityPersistence() {
		return empInfoEntityPersistence;
	}

	/**
	 * Sets the emp info entity persistence.
	 *
	 * @param empInfoEntityPersistence the emp info entity persistence
	 */
	public void setEmpInfoEntityPersistence(
		EmpInfoEntityPersistence empInfoEntityPersistence) {
		this.empInfoEntityPersistence = empInfoEntityPersistence;
	}

	/**
	 * Returns the eventcalendar local service.
	 *
	 * @return the eventcalendar local service
	 */
	public com.chola.calendar.service.eventcalendarLocalService geteventcalendarLocalService() {
		return eventcalendarLocalService;
	}

	/**
	 * Sets the eventcalendar local service.
	 *
	 * @param eventcalendarLocalService the eventcalendar local service
	 */
	public void seteventcalendarLocalService(
		com.chola.calendar.service.eventcalendarLocalService eventcalendarLocalService) {
		this.eventcalendarLocalService = eventcalendarLocalService;
	}

	/**
	 * Returns the eventcalendar persistence.
	 *
	 * @return the eventcalendar persistence
	 */
	public eventcalendarPersistence geteventcalendarPersistence() {
		return eventcalendarPersistence;
	}

	/**
	 * Sets the eventcalendar persistence.
	 *
	 * @param eventcalendarPersistence the eventcalendar persistence
	 */
	public void seteventcalendarPersistence(
		eventcalendarPersistence eventcalendarPersistence) {
		this.eventcalendarPersistence = eventcalendarPersistence;
	}

	/**
	 * Returns the eventcalendar finder.
	 *
	 * @return the eventcalendar finder
	 */
	public eventcalendarFinder geteventcalendarFinder() {
		return eventcalendarFinder;
	}

	/**
	 * Sets the eventcalendar finder.
	 *
	 * @param eventcalendarFinder the eventcalendar finder
	 */
	public void seteventcalendarFinder(eventcalendarFinder eventcalendarFinder) {
		this.eventcalendarFinder = eventcalendarFinder;
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

		PersistedModelLocalServiceRegistryUtil.register("com.chola.calendar.model.data",
			dataLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.chola.calendar.model.data");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return dataLocalService.class.getName();
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
		return data.class;
	}

	protected String getModelClassName() {
		return data.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = dataPersistence.getDataSource();

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

	@BeanReference(type = dataLocalService.class)
	protected dataLocalService dataLocalService;
	@BeanReference(type = dataPersistence.class)
	protected dataPersistence dataPersistence;
	@BeanReference(type = com.chola.calendar.service.EmpInfoEntityLocalService.class)
	protected com.chola.calendar.service.EmpInfoEntityLocalService empInfoEntityLocalService;
	@BeanReference(type = EmpInfoEntityPersistence.class)
	protected EmpInfoEntityPersistence empInfoEntityPersistence;
	@BeanReference(type = com.chola.calendar.service.eventcalendarLocalService.class)
	protected com.chola.calendar.service.eventcalendarLocalService eventcalendarLocalService;
	@BeanReference(type = eventcalendarPersistence.class)
	protected eventcalendarPersistence eventcalendarPersistence;
	@BeanReference(type = eventcalendarFinder.class)
	protected eventcalendarFinder eventcalendarFinder;
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
	private dataLocalServiceClpInvoker _clpInvoker = new dataLocalServiceClpInvoker();
}