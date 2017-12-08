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

package com.chola.productbuysell.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

/**
 * The base model interface for the BuySellProductsImages service. Represents a row in the &quot;chola_BuySellProductsImages&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.chola.productbuysell.model.impl.BuySellProductsImagesModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.chola.productbuysell.model.impl.BuySellProductsImagesImpl}.
 * </p>
 *
 * @author CloverLiferay03
 * @see BuySellProductsImages
 * @see com.chola.productbuysell.model.impl.BuySellProductsImagesImpl
 * @see com.chola.productbuysell.model.impl.BuySellProductsImagesModelImpl
 * @generated
 */
@ProviderType
public interface BuySellProductsImagesModel extends BaseModel<BuySellProductsImages> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a buy sell products images model instance should use the {@link BuySellProductsImages} interface instead.
	 */

	/**
	 * Returns the primary key of this buy sell products images.
	 *
	 * @return the primary key of this buy sell products images
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this buy sell products images.
	 *
	 * @param primaryKey the primary key of this buy sell products images
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this buy sell products images.
	 *
	 * @return the ID of this buy sell products images
	 */
	public long getId();

	/**
	 * Sets the ID of this buy sell products images.
	 *
	 * @param id the ID of this buy sell products images
	 */
	public void setId(long id);

	/**
	 * Returns the content_id of this buy sell products images.
	 *
	 * @return the content_id of this buy sell products images
	 */
	public long getContent_id();

	/**
	 * Sets the content_id of this buy sell products images.
	 *
	 * @param content_id the content_id of this buy sell products images
	 */
	public void setContent_id(long content_id);

	/**
	 * Returns the image_name of this buy sell products images.
	 *
	 * @return the image_name of this buy sell products images
	 */
	@AutoEscape
	public String getImage_name();

	/**
	 * Sets the image_name of this buy sell products images.
	 *
	 * @param image_name the image_name of this buy sell products images
	 */
	public void setImage_name(String image_name);

	/**
	 * Returns the image_path of this buy sell products images.
	 *
	 * @return the image_path of this buy sell products images
	 */
	@AutoEscape
	public String getImage_path();

	/**
	 * Sets the image_path of this buy sell products images.
	 *
	 * @param image_path the image_path of this buy sell products images
	 */
	public void setImage_path(String image_path);

	/**
	 * Returns the product_id of this buy sell products images.
	 *
	 * @return the product_id of this buy sell products images
	 */
	public long getProduct_id();

	/**
	 * Sets the product_id of this buy sell products images.
	 *
	 * @param product_id the product_id of this buy sell products images
	 */
	public void setProduct_id(long product_id);

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
	public int compareTo(BuySellProductsImages buySellProductsImages);

	@Override
	public int hashCode();

	@Override
	public CacheModel<BuySellProductsImages> toCacheModel();

	@Override
	public BuySellProductsImages toEscapedModel();

	@Override
	public BuySellProductsImages toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}