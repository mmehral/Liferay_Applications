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

package com.chola.service.conference.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

/**
 * The base model interface for the floorwing service. Represents a row in the &quot;cholaconference_floorwing&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.chola.service.conference.model.impl.floorwingModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.chola.service.conference.model.impl.floorwingImpl}.
 * </p>
 *
 * @author adms.java1
 * @see floorwing
 * @see com.chola.service.conference.model.impl.floorwingImpl
 * @see com.chola.service.conference.model.impl.floorwingModelImpl
 * @generated
 */
@ProviderType
public interface floorwingModel extends BaseModel<floorwing> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a floorwing model instance should use the {@link floorwing} interface instead.
	 */

	/**
	 * Returns the primary key of this floorwing.
	 *
	 * @return the primary key of this floorwing
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this floorwing.
	 *
	 * @param primaryKey the primary key of this floorwing
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the floorwing_id of this floorwing.
	 *
	 * @return the floorwing_id of this floorwing
	 */
	public long getFloorwing_id();

	/**
	 * Sets the floorwing_id of this floorwing.
	 *
	 * @param floorwing_id the floorwing_id of this floorwing
	 */
	public void setFloorwing_id(long floorwing_id);

	/**
	 * Returns the state_id of this floorwing.
	 *
	 * @return the state_id of this floorwing
	 */
	public long getState_id();

	/**
	 * Sets the state_id of this floorwing.
	 *
	 * @param state_id the state_id of this floorwing
	 */
	public void setState_id(long state_id);

	/**
	 * Returns the location_id of this floorwing.
	 *
	 * @return the location_id of this floorwing
	 */
	public long getLocation_id();

	/**
	 * Sets the location_id of this floorwing.
	 *
	 * @param location_id the location_id of this floorwing
	 */
	public void setLocation_id(long location_id);

	/**
	 * Returns the floor_name of this floorwing.
	 *
	 * @return the floor_name of this floorwing
	 */
	@AutoEscape
	public String getFloor_name();

	/**
	 * Sets the floor_name of this floorwing.
	 *
	 * @param floor_name the floor_name of this floorwing
	 */
	public void setFloor_name(String floor_name);

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
	public int compareTo(com.chola.service.conference.model.floorwing floorwing);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.chola.service.conference.model.floorwing> toCacheModel();

	@Override
	public com.chola.service.conference.model.floorwing toEscapedModel();

	@Override
	public com.chola.service.conference.model.floorwing toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}