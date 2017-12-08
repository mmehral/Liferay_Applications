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

package com.chola.videogallery.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the videogallery service. Represents a row in the &quot;cholav_videogallery&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.chola.videogallery.model.impl.videogalleryModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.chola.videogallery.model.impl.videogalleryImpl}.
 * </p>
 *
 * @author CloverLiferay02
 * @see videogallery
 * @see com.chola.videogallery.model.impl.videogalleryImpl
 * @see com.chola.videogallery.model.impl.videogalleryModelImpl
 * @generated
 */
@ProviderType
public interface videogalleryModel extends BaseModel<videogallery> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a videogallery model instance should use the {@link videogallery} interface instead.
	 */

	/**
	 * Returns the primary key of this videogallery.
	 *
	 * @return the primary key of this videogallery
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this videogallery.
	 *
	 * @param primaryKey the primary key of this videogallery
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this videogallery.
	 *
	 * @return the ID of this videogallery
	 */
	public long getId();

	/**
	 * Sets the ID of this videogallery.
	 *
	 * @param id the ID of this videogallery
	 */
	public void setId(long id);

	/**
	 * Returns the content_id of this videogallery.
	 *
	 * @return the content_id of this videogallery
	 */
	public long getContent_id();

	/**
	 * Sets the content_id of this videogallery.
	 *
	 * @param content_id the content_id of this videogallery
	 */
	public void setContent_id(long content_id);

	/**
	 * Returns the album name of this videogallery.
	 *
	 * @return the album name of this videogallery
	 */
	@AutoEscape
	public String getAlbumName();

	/**
	 * Sets the album name of this videogallery.
	 *
	 * @param albumName the album name of this videogallery
	 */
	public void setAlbumName(String albumName);

	/**
	 * Returns the album desc of this videogallery.
	 *
	 * @return the album desc of this videogallery
	 */
	@AutoEscape
	public String getAlbumDesc();

	/**
	 * Sets the album desc of this videogallery.
	 *
	 * @param albumDesc the album desc of this videogallery
	 */
	public void setAlbumDesc(String albumDesc);

	/**
	 * Returns the album ID of this videogallery.
	 *
	 * @return the album ID of this videogallery
	 */
	@AutoEscape
	public String getAlbumId();

	/**
	 * Sets the album ID of this videogallery.
	 *
	 * @param albumId the album ID of this videogallery
	 */
	public void setAlbumId(String albumId);

	/**
	 * Returns the created date of this videogallery.
	 *
	 * @return the created date of this videogallery
	 */
	public Date getCreatedDate();

	/**
	 * Sets the created date of this videogallery.
	 *
	 * @param createdDate the created date of this videogallery
	 */
	public void setCreatedDate(Date createdDate);

	/**
	 * Returns the created by of this videogallery.
	 *
	 * @return the created by of this videogallery
	 */
	@AutoEscape
	public String getCreatedBy();

	/**
	 * Sets the created by of this videogallery.
	 *
	 * @param createdBy the created by of this videogallery
	 */
	public void setCreatedBy(String createdBy);

	/**
	 * Returns the flag of this videogallery.
	 *
	 * @return the flag of this videogallery
	 */
	@AutoEscape
	public String getFlag();

	/**
	 * Sets the flag of this videogallery.
	 *
	 * @param flag the flag of this videogallery
	 */
	public void setFlag(String flag);

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
	public int compareTo(com.chola.videogallery.model.videogallery videogallery);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.chola.videogallery.model.videogallery> toCacheModel();

	@Override
	public com.chola.videogallery.model.videogallery toEscapedModel();

	@Override
	public com.chola.videogallery.model.videogallery toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}