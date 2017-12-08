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

package com.chola.annual.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the annualreports service. Represents a row in the &quot;chola_annualreports&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.chola.annual.model.impl.annualreportsModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.chola.annual.model.impl.annualreportsImpl}.
 * </p>
 *
 * @author CloverLiferay02
 * @see annualreports
 * @see com.chola.annual.model.impl.annualreportsImpl
 * @see com.chola.annual.model.impl.annualreportsModelImpl
 * @generated
 */
@ProviderType
public interface annualreportsModel extends BaseModel<annualreports> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a annualreports model instance should use the {@link annualreports} interface instead.
	 */

	/**
	 * Returns the primary key of this annualreports.
	 *
	 * @return the primary key of this annualreports
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this annualreports.
	 *
	 * @param primaryKey the primary key of this annualreports
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this annualreports.
	 *
	 * @return the ID of this annualreports
	 */
	public long getId();

	/**
	 * Sets the ID of this annualreports.
	 *
	 * @param id the ID of this annualreports
	 */
	public void setId(long id);

	/**
	 * Returns the details of this annualreports.
	 *
	 * @return the details of this annualreports
	 */
	@AutoEscape
	public String getDetails();

	/**
	 * Sets the details of this annualreports.
	 *
	 * @param details the details of this annualreports
	 */
	public void setDetails(String details);

	/**
	 * Returns the updatedon of this annualreports.
	 *
	 * @return the updatedon of this annualreports
	 */
	public Date getUpdatedon();

	/**
	 * Sets the updatedon of this annualreports.
	 *
	 * @param updatedon the updatedon of this annualreports
	 */
	public void setUpdatedon(Date updatedon);

	/**
	 * Returns the updatedby of this annualreports.
	 *
	 * @return the updatedby of this annualreports
	 */
	public long getUpdatedby();

	/**
	 * Sets the updatedby of this annualreports.
	 *
	 * @param updatedby the updatedby of this annualreports
	 */
	public void setUpdatedby(long updatedby);

	/**
	 * Returns the uniquecontentid of this annualreports.
	 *
	 * @return the uniquecontentid of this annualreports
	 */
	public long getUniquecontentid();

	/**
	 * Sets the uniquecontentid of this annualreports.
	 *
	 * @param uniquecontentid the uniquecontentid of this annualreports
	 */
	public void setUniquecontentid(long uniquecontentid);

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
	public int compareTo(com.chola.annual.model.annualreports annualreports);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.chola.annual.model.annualreports> toCacheModel();

	@Override
	public com.chola.annual.model.annualreports toEscapedModel();

	@Override
	public com.chola.annual.model.annualreports toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}