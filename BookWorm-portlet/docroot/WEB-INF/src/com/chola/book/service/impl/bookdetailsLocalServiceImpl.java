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

package com.chola.book.service.impl;

import aQute.bnd.annotation.ProviderType;

import java.util.List;

import com.chola.book.model.bookdetails;
import com.chola.book.service.base.bookdetailsLocalServiceBaseImpl;
import com.chola.book.service.persistence.bookdetailsFinderUtil;
import com.chola.book.service.persistence.impl.bookdetailsFinderImpl;

/**
 * The implementation of the bookdetails local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.chola.book.service.bookdetailsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author CloverLiferay02
 * @see bookdetailsLocalServiceBaseImpl
 * @see com.chola.book.service.bookdetailsLocalServiceUtil
 */
@ProviderType
public class bookdetailsLocalServiceImpl extends bookdetailsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.chola.book.service.bookdetailsLocalServiceUtil} to access the bookdetails local service.
	 */
	
	public List<bookdetails> getBookDetail(long content_id){
		return bookdetailsPersistence.findByCONTENT_ID(content_id);
	}
	
}