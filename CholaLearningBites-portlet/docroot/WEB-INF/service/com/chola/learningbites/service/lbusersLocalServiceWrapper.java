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

package com.chola.learningbites.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link lbusersLocalService}.
 *
 * @author cloverliferay01
 * @see lbusersLocalService
 * @generated
 */
@ProviderType
public class lbusersLocalServiceWrapper implements lbusersLocalService,
	ServiceWrapper<lbusersLocalService> {
	public lbusersLocalServiceWrapper(lbusersLocalService lbusersLocalService) {
		_lbusersLocalService = lbusersLocalService;
	}

	/**
	* Adds the lbusers to the database. Also notifies the appropriate model listeners.
	*
	* @param lbusers the lbusers
	* @return the lbusers that was added
	*/
	@Override
	public com.chola.learningbites.model.lbusers addlbusers(
		com.chola.learningbites.model.lbusers lbusers) {
		return _lbusersLocalService.addlbusers(lbusers);
	}

	/**
	* Creates a new lbusers with the primary key. Does not add the lbusers to the database.
	*
	* @param id the primary key for the new lbusers
	* @return the new lbusers
	*/
	@Override
	public com.chola.learningbites.model.lbusers createlbusers(long id) {
		return _lbusersLocalService.createlbusers(id);
	}

	/**
	* Deletes the lbusers from the database. Also notifies the appropriate model listeners.
	*
	* @param lbusers the lbusers
	* @return the lbusers that was removed
	*/
	@Override
	public com.chola.learningbites.model.lbusers deletelbusers(
		com.chola.learningbites.model.lbusers lbusers) {
		return _lbusersLocalService.deletelbusers(lbusers);
	}

	/**
	* Deletes the lbusers with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the lbusers
	* @return the lbusers that was removed
	* @throws PortalException if a lbusers with the primary key could not be found
	*/
	@Override
	public com.chola.learningbites.model.lbusers deletelbusers(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _lbusersLocalService.deletelbusers(id);
	}

	@Override
	public com.chola.learningbites.model.lbusers fetchlbusers(long id) {
		return _lbusersLocalService.fetchlbusers(id);
	}

	/**
	* Returns the lbusers with the primary key.
	*
	* @param id the primary key of the lbusers
	* @return the lbusers
	* @throws PortalException if a lbusers with the primary key could not be found
	*/
	@Override
	public com.chola.learningbites.model.lbusers getlbusers(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _lbusersLocalService.getlbusers(id);
	}

	/**
	* Updates the lbusers in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param lbusers the lbusers
	* @return the lbusers that was updated
	*/
	@Override
	public com.chola.learningbites.model.lbusers updatelbusers(
		com.chola.learningbites.model.lbusers lbusers) {
		return _lbusersLocalService.updatelbusers(lbusers);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _lbusersLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _lbusersLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _lbusersLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _lbusersLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _lbusersLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of lbuserses.
	*
	* @return the number of lbuserses
	*/
	@Override
	public int getlbusersesCount() {
		return _lbusersLocalService.getlbusersesCount();
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _lbusersLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _lbusersLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _lbusersLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.chola.learningbites.model.impl.lbusersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _lbusersLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.chola.learningbites.model.impl.lbusersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _lbusersLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<com.chola.learningbites.model.lbusers> getLBDetails(
		long bookId) {
		return _lbusersLocalService.getLBDetails(bookId);
	}

	@Override
	public java.util.List<com.chola.learningbites.model.lbusers> getLBUsers(
		long user_id) {
		return _lbusersLocalService.getLBUsers(user_id);
	}

	/**
	* Returns a range of all the lbuserses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.chola.learningbites.model.impl.lbusersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lbuserses
	* @param end the upper bound of the range of lbuserses (not inclusive)
	* @return the range of lbuserses
	*/
	@Override
	public java.util.List<com.chola.learningbites.model.lbusers> getlbuserses(
		int start, int end) {
		return _lbusersLocalService.getlbuserses(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _lbusersLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _lbusersLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public lbusersLocalService getWrappedService() {
		return _lbusersLocalService;
	}

	@Override
	public void setWrappedService(lbusersLocalService lbusersLocalService) {
		_lbusersLocalService = lbusersLocalService;
	}

	private lbusersLocalService _lbusersLocalService;
}