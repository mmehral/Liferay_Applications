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

package com.chola.knowledgebites.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the kbpath service. Represents a row in the &quot;chola_kbpath&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.chola.knowledgebites.model.impl.kbpathModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.chola.knowledgebites.model.impl.kbpathImpl}.
 * </p>
 *
 * @author cloverliferay01
 * @see kbpath
 * @see com.chola.knowledgebites.model.impl.kbpathImpl
 * @see com.chola.knowledgebites.model.impl.kbpathModelImpl
 * @generated
 */
@ProviderType
public interface kbpathModel extends BaseModel<kbpath> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a kbpath model instance should use the {@link kbpath} interface instead.
	 */

	/**
	 * Returns the primary key of this kbpath.
	 *
	 * @return the primary key of this kbpath
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this kbpath.
	 *
	 * @param primaryKey the primary key of this kbpath
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this kbpath.
	 *
	 * @return the ID of this kbpath
	 */
	public long getId();

	/**
	 * Sets the ID of this kbpath.
	 *
	 * @param id the ID of this kbpath
	 */
	public void setId(long id);

	/**
	 * Returns the kbfiledoc of this kbpath.
	 *
	 * @return the kbfiledoc of this kbpath
	 */
	@AutoEscape
	public String getKbfiledoc();

	/**
	 * Sets the kbfiledoc of this kbpath.
	 *
	 * @param kbfiledoc the kbfiledoc of this kbpath
	 */
	public void setKbfiledoc(String kbfiledoc);

	/**
	 * Returns the kbfilepath of this kbpath.
	 *
	 * @return the kbfilepath of this kbpath
	 */
	@AutoEscape
	public String getKbfilepath();

	/**
	 * Sets the kbfilepath of this kbpath.
	 *
	 * @param kbfilepath the kbfilepath of this kbpath
	 */
	public void setKbfilepath(String kbfilepath);

	/**
	 * Returns the created date of this kbpath.
	 *
	 * @return the created date of this kbpath
	 */
	public Date getCreatedDate();

	/**
	 * Sets the created date of this kbpath.
	 *
	 * @param createdDate the created date of this kbpath
	 */
	public void setCreatedDate(Date createdDate);

	/**
	 * Returns the created by of this kbpath.
	 *
	 * @return the created by of this kbpath
	 */
	public long getCreatedBy();

	/**
	 * Sets the created by of this kbpath.
	 *
	 * @param createdBy the created by of this kbpath
	 */
	public void setCreatedBy(long createdBy);

	/**
	 * Returns the flag of this kbpath.
	 *
	 * @return the flag of this kbpath
	 */
	@AutoEscape
	public String getFlag();

	/**
	 * Sets the flag of this kbpath.
	 *
	 * @param flag the flag of this kbpath
	 */
	public void setFlag(String flag);

	/**
	 * Returns the kbdetails_id of this kbpath.
	 *
	 * @return the kbdetails_id of this kbpath
	 */
	public long getKbdetails_id();

	/**
	 * Sets the kbdetails_id of this kbpath.
	 *
	 * @param kbdetails_id the kbdetails_id of this kbpath
	 */
	public void setKbdetails_id(long kbdetails_id);

	/**
	 * Returns the content_id of this kbpath.
	 *
	 * @return the content_id of this kbpath
	 */
	public long getContent_id();

	/**
	 * Sets the content_id of this kbpath.
	 *
	 * @param content_id the content_id of this kbpath
	 */
	public void setContent_id(long content_id);

	/**
	 * Returns the kbfilename of this kbpath.
	 *
	 * @return the kbfilename of this kbpath
	 */
	@AutoEscape
	public String getKbfilename();

	/**
	 * Sets the kbfilename of this kbpath.
	 *
	 * @param kbfilename the kbfilename of this kbpath
	 */
	public void setKbfilename(String kbfilename);

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
	public int compareTo(com.chola.knowledgebites.model.kbpath kbpath);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.chola.knowledgebites.model.kbpath> toCacheModel();

	@Override
	public com.chola.knowledgebites.model.kbpath toEscapedModel();

	@Override
	public com.chola.knowledgebites.model.kbpath toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}