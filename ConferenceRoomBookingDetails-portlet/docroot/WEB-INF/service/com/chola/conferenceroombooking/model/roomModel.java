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

package com.chola.conferenceroombooking.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

/**
 * The base model interface for the room service. Represents a row in the &quot;branch_room&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.chola.conferenceroombooking.model.impl.roomModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.chola.conferenceroombooking.model.impl.roomImpl}.
 * </p>
 *
 * @author adms.java1
 * @see room
 * @see com.chola.conferenceroombooking.model.impl.roomImpl
 * @see com.chola.conferenceroombooking.model.impl.roomModelImpl
 * @generated
 */
@ProviderType
public interface roomModel extends BaseModel<room> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a room model instance should use the {@link room} interface instead.
	 */

	/**
	 * Returns the primary key of this room.
	 *
	 * @return the primary key of this room
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this room.
	 *
	 * @param primaryKey the primary key of this room
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the room_id of this room.
	 *
	 * @return the room_id of this room
	 */
	public long getRoom_id();

	/**
	 * Sets the room_id of this room.
	 *
	 * @param room_id the room_id of this room
	 */
	public void setRoom_id(long room_id);

	/**
	 * Returns the state_id of this room.
	 *
	 * @return the state_id of this room
	 */
	public long getState_id();

	/**
	 * Sets the state_id of this room.
	 *
	 * @param state_id the state_id of this room
	 */
	public void setState_id(long state_id);

	/**
	 * Returns the location_id of this room.
	 *
	 * @return the location_id of this room
	 */
	public long getLocation_id();

	/**
	 * Sets the location_id of this room.
	 *
	 * @param location_id the location_id of this room
	 */
	public void setLocation_id(long location_id);

	/**
	 * Returns the floor_id of this room.
	 *
	 * @return the floor_id of this room
	 */
	public long getFloor_id();

	/**
	 * Sets the floor_id of this room.
	 *
	 * @param floor_id the floor_id of this room
	 */
	public void setFloor_id(long floor_id);

	/**
	 * Returns the room_name of this room.
	 *
	 * @return the room_name of this room
	 */
	@AutoEscape
	public String getRoom_name();

	/**
	 * Sets the room_name of this room.
	 *
	 * @param room_name the room_name of this room
	 */
	public void setRoom_name(String room_name);

	/**
	 * Returns the room_capacity of this room.
	 *
	 * @return the room_capacity of this room
	 */
	public long getRoom_capacity();

	/**
	 * Sets the room_capacity of this room.
	 *
	 * @param room_capacity the room_capacity of this room
	 */
	public void setRoom_capacity(long room_capacity);

	/**
	 * Returns the room_extension of this room.
	 *
	 * @return the room_extension of this room
	 */
	public long getRoom_extension();

	/**
	 * Sets the room_extension of this room.
	 *
	 * @param room_extension the room_extension of this room
	 */
	public void setRoom_extension(long room_extension);

	/**
	 * Returns the room_values of this room.
	 *
	 * @return the room_values of this room
	 */
	@AutoEscape
	public String getRoom_values();

	/**
	 * Sets the room_values of this room.
	 *
	 * @param room_values the room_values of this room
	 */
	public void setRoom_values(String room_values);

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
	public int compareTo(com.chola.conferenceroombooking.model.room room);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.chola.conferenceroombooking.model.room> toCacheModel();

	@Override
	public com.chola.conferenceroombooking.model.room toEscapedModel();

	@Override
	public com.chola.conferenceroombooking.model.room toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}