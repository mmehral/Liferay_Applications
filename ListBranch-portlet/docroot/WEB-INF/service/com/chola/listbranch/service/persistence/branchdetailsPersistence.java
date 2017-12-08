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

package com.chola.listbranch.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.chola.listbranch.exception.NoSuchdetailsException;
import com.chola.listbranch.model.branchdetails;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the branchdetails service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author adms.java1
 * @see com.chola.listbranch.service.persistence.impl.branchdetailsPersistenceImpl
 * @see branchdetailsUtil
 * @generated
 */
@ProviderType
public interface branchdetailsPersistence extends BasePersistence<branchdetails> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link branchdetailsUtil} to access the branchdetails persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the branchdetails in the entity cache if it is enabled.
	*
	* @param branchdetails the branchdetails
	*/
	public void cacheResult(branchdetails branchdetails);

	/**
	* Caches the branchdetailses in the entity cache if it is enabled.
	*
	* @param branchdetailses the branchdetailses
	*/
	public void cacheResult(java.util.List<branchdetails> branchdetailses);

	/**
	* Creates a new branchdetails with the primary key. Does not add the branchdetails to the database.
	*
	* @param branch_id the primary key for the new branchdetails
	* @return the new branchdetails
	*/
	public branchdetails create(long branch_id);

	/**
	* Removes the branchdetails with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param branch_id the primary key of the branchdetails
	* @return the branchdetails that was removed
	* @throws NoSuchdetailsException if a branchdetails with the primary key could not be found
	*/
	public branchdetails remove(long branch_id) throws NoSuchdetailsException;

	public branchdetails updateImpl(branchdetails branchdetails);

	/**
	* Returns the branchdetails with the primary key or throws a {@link NoSuchdetailsException} if it could not be found.
	*
	* @param branch_id the primary key of the branchdetails
	* @return the branchdetails
	* @throws NoSuchdetailsException if a branchdetails with the primary key could not be found
	*/
	public branchdetails findByPrimaryKey(long branch_id)
		throws NoSuchdetailsException;

	/**
	* Returns the branchdetails with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param branch_id the primary key of the branchdetails
	* @return the branchdetails, or <code>null</code> if a branchdetails with the primary key could not be found
	*/
	public branchdetails fetchByPrimaryKey(long branch_id);

	@Override
	public java.util.Map<java.io.Serializable, branchdetails> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the branchdetailses.
	*
	* @return the branchdetailses
	*/
	public java.util.List<branchdetails> findAll();

	/**
	* Returns a range of all the branchdetailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link branchdetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of branchdetailses
	* @param end the upper bound of the range of branchdetailses (not inclusive)
	* @return the range of branchdetailses
	*/
	public java.util.List<branchdetails> findAll(int start, int end);

	/**
	* Returns an ordered range of all the branchdetailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link branchdetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of branchdetailses
	* @param end the upper bound of the range of branchdetailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of branchdetailses
	*/
	public java.util.List<branchdetails> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<branchdetails> orderByComparator);

	/**
	* Returns an ordered range of all the branchdetailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link branchdetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of branchdetailses
	* @param end the upper bound of the range of branchdetailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of branchdetailses
	*/
	public java.util.List<branchdetails> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<branchdetails> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the branchdetailses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of branchdetailses.
	*
	* @return the number of branchdetailses
	*/
	public int countAll();
}