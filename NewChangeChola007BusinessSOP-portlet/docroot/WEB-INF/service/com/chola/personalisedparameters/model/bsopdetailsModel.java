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

package com.chola.personalisedparameters.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the bsopdetails service. Represents a row in the &quot;chola_bsopdetails&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.chola.personalisedparameters.model.impl.bsopdetailsModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.chola.personalisedparameters.model.impl.bsopdetailsImpl}.
 * </p>
 *
 * @author cloverliferay01
 * @see bsopdetails
 * @see com.chola.personalisedparameters.model.impl.bsopdetailsImpl
 * @see com.chola.personalisedparameters.model.impl.bsopdetailsModelImpl
 * @generated
 */
@ProviderType
public interface bsopdetailsModel extends BaseModel<bsopdetails> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a bsopdetails model instance should use the {@link bsopdetails} interface instead.
	 */

	/**
	 * Returns the primary key of this bsopdetails.
	 *
	 * @return the primary key of this bsopdetails
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this bsopdetails.
	 *
	 * @param primaryKey the primary key of this bsopdetails
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this bsopdetails.
	 *
	 * @return the ID of this bsopdetails
	 */
	public long getId();

	/**
	 * Sets the ID of this bsopdetails.
	 *
	 * @param id the ID of this bsopdetails
	 */
	public void setId(long id);

	/**
	 * Returns the content_id of this bsopdetails.
	 *
	 * @return the content_id of this bsopdetails
	 */
	public long getContent_id();

	/**
	 * Sets the content_id of this bsopdetails.
	 *
	 * @param content_id the content_id of this bsopdetails
	 */
	public void setContent_id(long content_id);

	/**
	 * Returns the btitle of this bsopdetails.
	 *
	 * @return the btitle of this bsopdetails
	 */
	@AutoEscape
	public String getBtitle();

	/**
	 * Sets the btitle of this bsopdetails.
	 *
	 * @param btitle the btitle of this bsopdetails
	 */
	public void setBtitle(String btitle);

	/**
	 * Returns the bdesc of this bsopdetails.
	 *
	 * @return the bdesc of this bsopdetails
	 */
	@AutoEscape
	public String getBdesc();

	/**
	 * Sets the bdesc of this bsopdetails.
	 *
	 * @param bdesc the bdesc of this bsopdetails
	 */
	public void setBdesc(String bdesc);

	/**
	 * Returns the createddate of this bsopdetails.
	 *
	 * @return the createddate of this bsopdetails
	 */
	public Date getCreateddate();

	/**
	 * Sets the createddate of this bsopdetails.
	 *
	 * @param createddate the createddate of this bsopdetails
	 */
	public void setCreateddate(Date createddate);

	/**
	 * Returns the createdby of this bsopdetails.
	 *
	 * @return the createdby of this bsopdetails
	 */
	@AutoEscape
	public String getCreatedby();

	/**
	 * Sets the createdby of this bsopdetails.
	 *
	 * @param createdby the createdby of this bsopdetails
	 */
	public void setCreatedby(String createdby);

	/**
	 * Returns the modifieddate of this bsopdetails.
	 *
	 * @return the modifieddate of this bsopdetails
	 */
	public Date getModifieddate();

	/**
	 * Sets the modifieddate of this bsopdetails.
	 *
	 * @param modifieddate the modifieddate of this bsopdetails
	 */
	public void setModifieddate(Date modifieddate);

	/**
	 * Returns the modifiedby of this bsopdetails.
	 *
	 * @return the modifiedby of this bsopdetails
	 */
	public long getModifiedby();

	/**
	 * Sets the modifiedby of this bsopdetails.
	 *
	 * @param modifiedby the modifiedby of this bsopdetails
	 */
	public void setModifiedby(long modifiedby);

	/**
	 * Returns the flag of this bsopdetails.
	 *
	 * @return the flag of this bsopdetails
	 */
	@AutoEscape
	public String getFlag();

	/**
	 * Sets the flag of this bsopdetails.
	 *
	 * @param flag the flag of this bsopdetails
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
	public int compareTo(
		com.chola.personalisedparameters.model.bsopdetails bsopdetails);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.chola.personalisedparameters.model.bsopdetails> toCacheModel();

	@Override
	public com.chola.personalisedparameters.model.bsopdetails toEscapedModel();

	@Override
	public com.chola.personalisedparameters.model.bsopdetails toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}