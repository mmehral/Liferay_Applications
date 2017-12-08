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

package com.chola.shutterspeed.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.chola.shutterspeed.model.shutterspeedgallerypath;
import com.chola.shutterspeed.model.shutterspeedgallerypathModel;
import com.chola.shutterspeed.model.shutterspeedgallerypathSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the shutterspeedgallerypath service. Represents a row in the &quot;chola_shutterspeedgallerypath&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link shutterspeedgallerypathModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link shutterspeedgallerypathImpl}.
 * </p>
 *
 * @author CloverLiferay02
 * @see shutterspeedgallerypathImpl
 * @see shutterspeedgallerypath
 * @see shutterspeedgallerypathModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class shutterspeedgallerypathModelImpl extends BaseModelImpl<shutterspeedgallerypath>
	implements shutterspeedgallerypathModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a shutterspeedgallerypath model instance should use the {@link shutterspeedgallerypath} interface instead.
	 */
	public static final String TABLE_NAME = "chola_shutterspeedgallerypath";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id_", Types.BIGINT },
			{ "albumId", Types.VARCHAR },
			{ "albumImagePath", Types.VARCHAR },
			{ "imageTitle", Types.VARCHAR },
			{ "createdDate", Types.TIMESTAMP },
			{ "createdBy", Types.VARCHAR },
			{ "updatedDate", Types.TIMESTAMP },
			{ "updatedBy", Types.VARCHAR },
			{ "flag", Types.VARCHAR },
			{ "content_id", Types.BIGINT }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("id_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("albumId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("albumImagePath", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("imageTitle", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createdDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("createdBy", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("updatedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("updatedBy", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("flag", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("content_id", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE = "create table chola_shutterspeedgallerypath (id_ LONG not null primary key,albumId VARCHAR(75) null,albumImagePath VARCHAR(500) null,imageTitle VARCHAR(200) null,createdDate DATE null,createdBy VARCHAR(75) null,updatedDate DATE null,updatedBy VARCHAR(75) null,flag VARCHAR(75) null,content_id LONG)";
	public static final String TABLE_SQL_DROP = "drop table chola_shutterspeedgallerypath";
	public static final String ORDER_BY_JPQL = " ORDER BY shutterspeedgallerypath.id ASC";
	public static final String ORDER_BY_SQL = " ORDER BY chola_shutterspeedgallerypath.id_ ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.chola.shutterspeed.model.shutterspeedgallerypath"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.chola.shutterspeed.model.shutterspeedgallerypath"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.chola.shutterspeed.model.shutterspeedgallerypath"),
			true);
	public static final long ALBUMID_COLUMN_BITMASK = 1L;
	public static final long CONTENT_ID_COLUMN_BITMASK = 2L;
	public static final long ID_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static shutterspeedgallerypath toModel(
		shutterspeedgallerypathSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		shutterspeedgallerypath model = new shutterspeedgallerypathImpl();

		model.setId(soapModel.getId());
		model.setAlbumId(soapModel.getAlbumId());
		model.setAlbumImagePath(soapModel.getAlbumImagePath());
		model.setImageTitle(soapModel.getImageTitle());
		model.setCreatedDate(soapModel.getCreatedDate());
		model.setCreatedBy(soapModel.getCreatedBy());
		model.setUpdatedDate(soapModel.getUpdatedDate());
		model.setUpdatedBy(soapModel.getUpdatedBy());
		model.setFlag(soapModel.getFlag());
		model.setContent_id(soapModel.getContent_id());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<shutterspeedgallerypath> toModels(
		shutterspeedgallerypathSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<shutterspeedgallerypath> models = new ArrayList<shutterspeedgallerypath>(soapModels.length);

		for (shutterspeedgallerypathSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.chola.shutterspeed.model.shutterspeedgallerypath"));

	public shutterspeedgallerypathModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return shutterspeedgallerypath.class;
	}

	@Override
	public String getModelClassName() {
		return shutterspeedgallerypath.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("albumId", getAlbumId());
		attributes.put("albumImagePath", getAlbumImagePath());
		attributes.put("imageTitle", getImageTitle());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("updatedDate", getUpdatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("flag", getFlag());
		attributes.put("content_id", getContent_id());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String albumId = (String)attributes.get("albumId");

		if (albumId != null) {
			setAlbumId(albumId);
		}

		String albumImagePath = (String)attributes.get("albumImagePath");

		if (albumImagePath != null) {
			setAlbumImagePath(albumImagePath);
		}

		String imageTitle = (String)attributes.get("imageTitle");

		if (imageTitle != null) {
			setImageTitle(imageTitle);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		String createdBy = (String)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Date updatedDate = (Date)attributes.get("updatedDate");

		if (updatedDate != null) {
			setUpdatedDate(updatedDate);
		}

		String updatedBy = (String)attributes.get("updatedBy");

		if (updatedBy != null) {
			setUpdatedBy(updatedBy);
		}

		String flag = (String)attributes.get("flag");

		if (flag != null) {
			setFlag(flag);
		}

		Long content_id = (Long)attributes.get("content_id");

		if (content_id != null) {
			setContent_id(content_id);
		}
	}

	@JSON
	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;
	}

	@JSON
	@Override
	public String getAlbumId() {
		if (_albumId == null) {
			return StringPool.BLANK;
		}
		else {
			return _albumId;
		}
	}

	@Override
	public void setAlbumId(String albumId) {
		_columnBitmask |= ALBUMID_COLUMN_BITMASK;

		if (_originalAlbumId == null) {
			_originalAlbumId = _albumId;
		}

		_albumId = albumId;
	}

	public String getOriginalAlbumId() {
		return GetterUtil.getString(_originalAlbumId);
	}

	@JSON
	@Override
	public String getAlbumImagePath() {
		if (_albumImagePath == null) {
			return StringPool.BLANK;
		}
		else {
			return _albumImagePath;
		}
	}

	@Override
	public void setAlbumImagePath(String albumImagePath) {
		_albumImagePath = albumImagePath;
	}

	@JSON
	@Override
	public String getImageTitle() {
		if (_imageTitle == null) {
			return StringPool.BLANK;
		}
		else {
			return _imageTitle;
		}
	}

	@Override
	public void setImageTitle(String imageTitle) {
		_imageTitle = imageTitle;
	}

	@JSON
	@Override
	public Date getCreatedDate() {
		return _createdDate;
	}

	@Override
	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	@JSON
	@Override
	public String getCreatedBy() {
		if (_createdBy == null) {
			return StringPool.BLANK;
		}
		else {
			return _createdBy;
		}
	}

	@Override
	public void setCreatedBy(String createdBy) {
		_createdBy = createdBy;
	}

	@JSON
	@Override
	public Date getUpdatedDate() {
		return _updatedDate;
	}

	@Override
	public void setUpdatedDate(Date updatedDate) {
		_updatedDate = updatedDate;
	}

	@JSON
	@Override
	public String getUpdatedBy() {
		if (_updatedBy == null) {
			return StringPool.BLANK;
		}
		else {
			return _updatedBy;
		}
	}

	@Override
	public void setUpdatedBy(String updatedBy) {
		_updatedBy = updatedBy;
	}

	@JSON
	@Override
	public String getFlag() {
		if (_flag == null) {
			return StringPool.BLANK;
		}
		else {
			return _flag;
		}
	}

	@Override
	public void setFlag(String flag) {
		_flag = flag;
	}

	@JSON
	@Override
	public long getContent_id() {
		return _content_id;
	}

	@Override
	public void setContent_id(long content_id) {
		_columnBitmask |= CONTENT_ID_COLUMN_BITMASK;

		if (!_setOriginalContent_id) {
			_setOriginalContent_id = true;

			_originalContent_id = _content_id;
		}

		_content_id = content_id;
	}

	public long getOriginalContent_id() {
		return _originalContent_id;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			shutterspeedgallerypath.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public shutterspeedgallerypath toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (shutterspeedgallerypath)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		shutterspeedgallerypathImpl shutterspeedgallerypathImpl = new shutterspeedgallerypathImpl();

		shutterspeedgallerypathImpl.setId(getId());
		shutterspeedgallerypathImpl.setAlbumId(getAlbumId());
		shutterspeedgallerypathImpl.setAlbumImagePath(getAlbumImagePath());
		shutterspeedgallerypathImpl.setImageTitle(getImageTitle());
		shutterspeedgallerypathImpl.setCreatedDate(getCreatedDate());
		shutterspeedgallerypathImpl.setCreatedBy(getCreatedBy());
		shutterspeedgallerypathImpl.setUpdatedDate(getUpdatedDate());
		shutterspeedgallerypathImpl.setUpdatedBy(getUpdatedBy());
		shutterspeedgallerypathImpl.setFlag(getFlag());
		shutterspeedgallerypathImpl.setContent_id(getContent_id());

		shutterspeedgallerypathImpl.resetOriginalValues();

		return shutterspeedgallerypathImpl;
	}

	@Override
	public int compareTo(shutterspeedgallerypath shutterspeedgallerypath) {
		long primaryKey = shutterspeedgallerypath.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof shutterspeedgallerypath)) {
			return false;
		}

		shutterspeedgallerypath shutterspeedgallerypath = (shutterspeedgallerypath)obj;

		long primaryKey = shutterspeedgallerypath.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		shutterspeedgallerypathModelImpl shutterspeedgallerypathModelImpl = this;

		shutterspeedgallerypathModelImpl._originalAlbumId = shutterspeedgallerypathModelImpl._albumId;

		shutterspeedgallerypathModelImpl._originalContent_id = shutterspeedgallerypathModelImpl._content_id;

		shutterspeedgallerypathModelImpl._setOriginalContent_id = false;

		shutterspeedgallerypathModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<shutterspeedgallerypath> toCacheModel() {
		shutterspeedgallerypathCacheModel shutterspeedgallerypathCacheModel = new shutterspeedgallerypathCacheModel();

		shutterspeedgallerypathCacheModel.id = getId();

		shutterspeedgallerypathCacheModel.albumId = getAlbumId();

		String albumId = shutterspeedgallerypathCacheModel.albumId;

		if ((albumId != null) && (albumId.length() == 0)) {
			shutterspeedgallerypathCacheModel.albumId = null;
		}

		shutterspeedgallerypathCacheModel.albumImagePath = getAlbumImagePath();

		String albumImagePath = shutterspeedgallerypathCacheModel.albumImagePath;

		if ((albumImagePath != null) && (albumImagePath.length() == 0)) {
			shutterspeedgallerypathCacheModel.albumImagePath = null;
		}

		shutterspeedgallerypathCacheModel.imageTitle = getImageTitle();

		String imageTitle = shutterspeedgallerypathCacheModel.imageTitle;

		if ((imageTitle != null) && (imageTitle.length() == 0)) {
			shutterspeedgallerypathCacheModel.imageTitle = null;
		}

		Date createdDate = getCreatedDate();

		if (createdDate != null) {
			shutterspeedgallerypathCacheModel.createdDate = createdDate.getTime();
		}
		else {
			shutterspeedgallerypathCacheModel.createdDate = Long.MIN_VALUE;
		}

		shutterspeedgallerypathCacheModel.createdBy = getCreatedBy();

		String createdBy = shutterspeedgallerypathCacheModel.createdBy;

		if ((createdBy != null) && (createdBy.length() == 0)) {
			shutterspeedgallerypathCacheModel.createdBy = null;
		}

		Date updatedDate = getUpdatedDate();

		if (updatedDate != null) {
			shutterspeedgallerypathCacheModel.updatedDate = updatedDate.getTime();
		}
		else {
			shutterspeedgallerypathCacheModel.updatedDate = Long.MIN_VALUE;
		}

		shutterspeedgallerypathCacheModel.updatedBy = getUpdatedBy();

		String updatedBy = shutterspeedgallerypathCacheModel.updatedBy;

		if ((updatedBy != null) && (updatedBy.length() == 0)) {
			shutterspeedgallerypathCacheModel.updatedBy = null;
		}

		shutterspeedgallerypathCacheModel.flag = getFlag();

		String flag = shutterspeedgallerypathCacheModel.flag;

		if ((flag != null) && (flag.length() == 0)) {
			shutterspeedgallerypathCacheModel.flag = null;
		}

		shutterspeedgallerypathCacheModel.content_id = getContent_id();

		return shutterspeedgallerypathCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", albumId=");
		sb.append(getAlbumId());
		sb.append(", albumImagePath=");
		sb.append(getAlbumImagePath());
		sb.append(", imageTitle=");
		sb.append(getImageTitle());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", createdBy=");
		sb.append(getCreatedBy());
		sb.append(", updatedDate=");
		sb.append(getUpdatedDate());
		sb.append(", updatedBy=");
		sb.append(getUpdatedBy());
		sb.append(", flag=");
		sb.append(getFlag());
		sb.append(", content_id=");
		sb.append(getContent_id());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.chola.shutterspeed.model.shutterspeedgallerypath");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>albumId</column-name><column-value><![CDATA[");
		sb.append(getAlbumId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>albumImagePath</column-name><column-value><![CDATA[");
		sb.append(getAlbumImagePath());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageTitle</column-name><column-value><![CDATA[");
		sb.append(getImageTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdDate</column-name><column-value><![CDATA[");
		sb.append(getCreatedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdBy</column-name><column-value><![CDATA[");
		sb.append(getCreatedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updatedDate</column-name><column-value><![CDATA[");
		sb.append(getUpdatedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updatedBy</column-name><column-value><![CDATA[");
		sb.append(getUpdatedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>flag</column-name><column-value><![CDATA[");
		sb.append(getFlag());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>content_id</column-name><column-value><![CDATA[");
		sb.append(getContent_id());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = shutterspeedgallerypath.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			shutterspeedgallerypath.class
		};
	private long _id;
	private String _albumId;
	private String _originalAlbumId;
	private String _albumImagePath;
	private String _imageTitle;
	private Date _createdDate;
	private String _createdBy;
	private Date _updatedDate;
	private String _updatedBy;
	private String _flag;
	private long _content_id;
	private long _originalContent_id;
	private boolean _setOriginalContent_id;
	private long _columnBitmask;
	private shutterspeedgallerypath _escapedModel;
}