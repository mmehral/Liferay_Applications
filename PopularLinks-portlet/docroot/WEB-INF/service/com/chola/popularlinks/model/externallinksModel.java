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

package com.chola.popularlinks.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

/**
 * The base model interface for the externallinks service. Represents a row in the &quot;url_externallinks&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.chola.popularlinks.model.impl.externallinksModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.chola.popularlinks.model.impl.externallinksImpl}.
 * </p>
 *
 * @author adms.java1
 * @see externallinks
 * @see com.chola.popularlinks.model.impl.externallinksImpl
 * @see com.chola.popularlinks.model.impl.externallinksModelImpl
 * @generated
 */
@ProviderType
public interface externallinksModel extends BaseModel<externallinks> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a externallinks model instance should use the {@link externallinks} interface instead.
	 */

	/**
	 * Returns the primary key of this externallinks.
	 *
	 * @return the primary key of this externallinks
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this externallinks.
	 *
	 * @param primaryKey the primary key of this externallinks
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this externallinks.
	 *
	 * @return the ID of this externallinks
	 */
	public long getId();

	/**
	 * Sets the ID of this externallinks.
	 *
	 * @param id the ID of this externallinks
	 */
	public void setId(long id);

	/**
	 * Returns the tag of this externallinks.
	 *
	 * @return the tag of this externallinks
	 */
	@AutoEscape
	public String getTag();

	/**
	 * Sets the tag of this externallinks.
	 *
	 * @param tag the tag of this externallinks
	 */
	public void setTag(String tag);

	/**
	 * Returns the url of this externallinks.
	 *
	 * @return the url of this externallinks
	 */
	@AutoEscape
	public String getUrl();

	/**
	 * Sets the url of this externallinks.
	 *
	 * @param url the url of this externallinks
	 */
	public void setUrl(String url);

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
		com.chola.popularlinks.model.externallinks externallinks);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.chola.popularlinks.model.externallinks> toCacheModel();

	@Override
	public com.chola.popularlinks.model.externallinks toEscapedModel();

	@Override
	public com.chola.popularlinks.model.externallinks toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}