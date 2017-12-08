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

package com.chola.business.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the businesssoppath service. Represents a row in the &quot;chola_businesssoppath&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.chola.business.model.impl.businesssoppathModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.chola.business.model.impl.businesssoppathImpl}.
 * </p>
 *
 * @author adms.java1
 * @see businesssoppath
 * @see com.chola.business.model.impl.businesssoppathImpl
 * @see com.chola.business.model.impl.businesssoppathModelImpl
 * @generated
 */
@ProviderType
public interface businesssoppathModel extends BaseModel<businesssoppath> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a businesssoppath model instance should use the {@link businesssoppath} interface instead.
	 */

	/**
	 * Returns the primary key of this businesssoppath.
	 *
	 * @return the primary key of this businesssoppath
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this businesssoppath.
	 *
	 * @param primaryKey the primary key of this businesssoppath
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this businesssoppath.
	 *
	 * @return the ID of this businesssoppath
	 */
	public long getId();

	/**
	 * Sets the ID of this businesssoppath.
	 *
	 * @param id the ID of this businesssoppath
	 */
	public void setId(long id);

	/**
	 * Returns the businessdoc of this businesssoppath.
	 *
	 * @return the businessdoc of this businesssoppath
	 */
	@AutoEscape
	public String getBusinessdoc();

	/**
	 * Sets the businessdoc of this businesssoppath.
	 *
	 * @param businessdoc the businessdoc of this businesssoppath
	 */
	public void setBusinessdoc(String businessdoc);

	/**
	 * Returns the business path of this businesssoppath.
	 *
	 * @return the business path of this businesssoppath
	 */
	@AutoEscape
	public String getBusinessPath();

	/**
	 * Sets the business path of this businesssoppath.
	 *
	 * @param businessPath the business path of this businesssoppath
	 */
	public void setBusinessPath(String businessPath);

	/**
	 * Returns the created date of this businesssoppath.
	 *
	 * @return the created date of this businesssoppath
	 */
	public Date getCreatedDate();

	/**
	 * Sets the created date of this businesssoppath.
	 *
	 * @param createdDate the created date of this businesssoppath
	 */
	public void setCreatedDate(Date createdDate);

	/**
	 * Returns the created by of this businesssoppath.
	 *
	 * @return the created by of this businesssoppath
	 */
	@AutoEscape
	public String getCreatedBy();

	/**
	 * Sets the created by of this businesssoppath.
	 *
	 * @param createdBy the created by of this businesssoppath
	 */
	public void setCreatedBy(String createdBy);

	/**
	 * Returns the flag of this businesssoppath.
	 *
	 * @return the flag of this businesssoppath
	 */
	@AutoEscape
	public String getFlag();

	/**
	 * Sets the flag of this businesssoppath.
	 *
	 * @param flag the flag of this businesssoppath
	 */
	public void setFlag(String flag);

	/**
	 * Returns the businessdetails_id of this businesssoppath.
	 *
	 * @return the businessdetails_id of this businesssoppath
	 */
	public long getBusinessdetails_id();

	/**
	 * Sets the businessdetails_id of this businesssoppath.
	 *
	 * @param businessdetails_id the businessdetails_id of this businesssoppath
	 */
	public void setBusinessdetails_id(long businessdetails_id);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(
		com.chola.business.model.businesssoppath businesssoppath);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.chola.business.model.businesssoppath> toCacheModel();

	@Override
	public com.chola.business.model.businesssoppath toEscapedModel();

	@Override
	public com.chola.business.model.businesssoppath toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}