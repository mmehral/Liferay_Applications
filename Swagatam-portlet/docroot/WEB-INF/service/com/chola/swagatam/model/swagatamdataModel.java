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

package com.chola.swagatam.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

/**
 * The base model interface for the swagatamdata service. Represents a row in the &quot;cholas_swagatamdata&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.chola.swagatam.model.impl.swagatamdataModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.chola.swagatam.model.impl.swagatamdataImpl}.
 * </p>
 *
 * @author CloverLiferay02
 * @see swagatamdata
 * @see com.chola.swagatam.model.impl.swagatamdataImpl
 * @see com.chola.swagatam.model.impl.swagatamdataModelImpl
 * @generated
 */
@ProviderType
public interface swagatamdataModel extends BaseModel<swagatamdata> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a swagatamdata model instance should use the {@link swagatamdata} interface instead.
	 */

	/**
	 * Returns the primary key of this swagatamdata.
	 *
	 * @return the primary key of this swagatamdata
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this swagatamdata.
	 *
	 * @param primaryKey the primary key of this swagatamdata
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this swagatamdata.
	 *
	 * @return the ID of this swagatamdata
	 */
	public long getId();

	/**
	 * Sets the ID of this swagatamdata.
	 *
	 * @param id the ID of this swagatamdata
	 */
	public void setId(long id);

	/**
	 * Returns the emp ID of this swagatamdata.
	 *
	 * @return the emp ID of this swagatamdata
	 */
	@AutoEscape
	public String getEmpId();

	/**
	 * Sets the emp ID of this swagatamdata.
	 *
	 * @param empId the emp ID of this swagatamdata
	 */
	public void setEmpId(String empId);

	/**
	 * Returns the watched of this swagatamdata.
	 *
	 * @return the watched of this swagatamdata
	 */
	@AutoEscape
	public String getWatched();

	/**
	 * Sets the watched of this swagatamdata.
	 *
	 * @param watched the watched of this swagatamdata
	 */
	public void setWatched(String watched);

	/**
	 * Returns the acknowledged of this swagatamdata.
	 *
	 * @return the acknowledged of this swagatamdata
	 */
	@AutoEscape
	public String getAcknowledged();

	/**
	 * Sets the acknowledged of this swagatamdata.
	 *
	 * @param acknowledged the acknowledged of this swagatamdata
	 */
	public void setAcknowledged(String acknowledged);

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
	public int compareTo(com.chola.swagatam.model.swagatamdata swagatamdata);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.chola.swagatam.model.swagatamdata> toCacheModel();

	@Override
	public com.chola.swagatam.model.swagatamdata toEscapedModel();

	@Override
	public com.chola.swagatam.model.swagatamdata toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}