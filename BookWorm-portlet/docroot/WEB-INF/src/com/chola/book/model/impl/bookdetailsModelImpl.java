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

package com.chola.book.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.chola.book.model.bookdetails;
import com.chola.book.model.bookdetailsModel;
import com.chola.book.model.bookdetailsSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.DateUtil;
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
 * The base model implementation for the bookdetails service. Represents a row in the &quot;chola_bookdetails&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link bookdetailsModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link bookdetailsImpl}.
 * </p>
 *
 * @author CloverLiferay02
 * @see bookdetailsImpl
 * @see bookdetails
 * @see bookdetailsModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class bookdetailsModelImpl extends BaseModelImpl<bookdetails>
	implements bookdetailsModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a bookdetails model instance should use the {@link bookdetails} interface instead.
	 */
	public static final String TABLE_NAME = "chola_bookdetails";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id_", Types.BIGINT },
			{ "booktitle", Types.VARCHAR },
			{ "bookname", Types.VARCHAR },
			{ "bookpath", Types.VARCHAR },
			{ "createddate", Types.TIMESTAMP },
			{ "createdby", Types.BIGINT },
			{ "modifieddate", Types.TIMESTAMP },
			{ "modifiedby", Types.BIGINT },
			{ "flag", Types.VARCHAR },
			{ "content_id", Types.BIGINT }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("id_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("booktitle", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("bookname", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("bookpath", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createddate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("createdby", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("modifieddate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedby", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("flag", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("content_id", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE = "create table chola_bookdetails (id_ LONG not null primary key,booktitle VARCHAR(100) null,bookname VARCHAR(200) null,bookpath VARCHAR(500) null,createddate DATE null,createdby LONG,modifieddate DATE null,modifiedby LONG,flag VARCHAR(75) null,content_id LONG)";
	public static final String TABLE_SQL_DROP = "drop table chola_bookdetails";
	public static final String ORDER_BY_JPQL = " ORDER BY bookdetails.createddate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY chola_bookdetails.createddate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.chola.book.model.bookdetails"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.chola.book.model.bookdetails"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.chola.book.model.bookdetails"),
			true);
	public static final long CONTENT_ID_COLUMN_BITMASK = 1L;
	public static final long CREATEDDATE_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static bookdetails toModel(bookdetailsSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		bookdetails model = new bookdetailsImpl();

		model.setId(soapModel.getId());
		model.setBooktitle(soapModel.getBooktitle());
		model.setBookname(soapModel.getBookname());
		model.setBookpath(soapModel.getBookpath());
		model.setCreateddate(soapModel.getCreateddate());
		model.setCreatedby(soapModel.getCreatedby());
		model.setModifieddate(soapModel.getModifieddate());
		model.setModifiedby(soapModel.getModifiedby());
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
	public static List<bookdetails> toModels(bookdetailsSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<bookdetails> models = new ArrayList<bookdetails>(soapModels.length);

		for (bookdetailsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.chola.book.model.bookdetails"));

	public bookdetailsModelImpl() {
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
		return bookdetails.class;
	}

	@Override
	public String getModelClassName() {
		return bookdetails.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("booktitle", getBooktitle());
		attributes.put("bookname", getBookname());
		attributes.put("bookpath", getBookpath());
		attributes.put("createddate", getCreateddate());
		attributes.put("createdby", getCreatedby());
		attributes.put("modifieddate", getModifieddate());
		attributes.put("modifiedby", getModifiedby());
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

		String booktitle = (String)attributes.get("booktitle");

		if (booktitle != null) {
			setBooktitle(booktitle);
		}

		String bookname = (String)attributes.get("bookname");

		if (bookname != null) {
			setBookname(bookname);
		}

		String bookpath = (String)attributes.get("bookpath");

		if (bookpath != null) {
			setBookpath(bookpath);
		}

		Date createddate = (Date)attributes.get("createddate");

		if (createddate != null) {
			setCreateddate(createddate);
		}

		Long createdby = (Long)attributes.get("createdby");

		if (createdby != null) {
			setCreatedby(createdby);
		}

		Date modifieddate = (Date)attributes.get("modifieddate");

		if (modifieddate != null) {
			setModifieddate(modifieddate);
		}

		Long modifiedby = (Long)attributes.get("modifiedby");

		if (modifiedby != null) {
			setModifiedby(modifiedby);
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
	public String getBooktitle() {
		if (_booktitle == null) {
			return StringPool.BLANK;
		}
		else {
			return _booktitle;
		}
	}

	@Override
	public void setBooktitle(String booktitle) {
		_booktitle = booktitle;
	}

	@JSON
	@Override
	public String getBookname() {
		if (_bookname == null) {
			return StringPool.BLANK;
		}
		else {
			return _bookname;
		}
	}

	@Override
	public void setBookname(String bookname) {
		_bookname = bookname;
	}

	@JSON
	@Override
	public String getBookpath() {
		if (_bookpath == null) {
			return StringPool.BLANK;
		}
		else {
			return _bookpath;
		}
	}

	@Override
	public void setBookpath(String bookpath) {
		_bookpath = bookpath;
	}

	@JSON
	@Override
	public Date getCreateddate() {
		return _createddate;
	}

	@Override
	public void setCreateddate(Date createddate) {
		_columnBitmask = -1L;

		_createddate = createddate;
	}

	@JSON
	@Override
	public long getCreatedby() {
		return _createdby;
	}

	@Override
	public void setCreatedby(long createdby) {
		_createdby = createdby;
	}

	@JSON
	@Override
	public Date getModifieddate() {
		return _modifieddate;
	}

	@Override
	public void setModifieddate(Date modifieddate) {
		_modifieddate = modifieddate;
	}

	@JSON
	@Override
	public long getModifiedby() {
		return _modifiedby;
	}

	@Override
	public void setModifiedby(long modifiedby) {
		_modifiedby = modifiedby;
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
			bookdetails.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public bookdetails toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (bookdetails)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		bookdetailsImpl bookdetailsImpl = new bookdetailsImpl();

		bookdetailsImpl.setId(getId());
		bookdetailsImpl.setBooktitle(getBooktitle());
		bookdetailsImpl.setBookname(getBookname());
		bookdetailsImpl.setBookpath(getBookpath());
		bookdetailsImpl.setCreateddate(getCreateddate());
		bookdetailsImpl.setCreatedby(getCreatedby());
		bookdetailsImpl.setModifieddate(getModifieddate());
		bookdetailsImpl.setModifiedby(getModifiedby());
		bookdetailsImpl.setFlag(getFlag());
		bookdetailsImpl.setContent_id(getContent_id());

		bookdetailsImpl.resetOriginalValues();

		return bookdetailsImpl;
	}

	@Override
	public int compareTo(bookdetails bookdetails) {
		int value = 0;

		value = DateUtil.compareTo(getCreateddate(),
				bookdetails.getCreateddate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof bookdetails)) {
			return false;
		}

		bookdetails bookdetails = (bookdetails)obj;

		long primaryKey = bookdetails.getPrimaryKey();

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
		bookdetailsModelImpl bookdetailsModelImpl = this;

		bookdetailsModelImpl._originalContent_id = bookdetailsModelImpl._content_id;

		bookdetailsModelImpl._setOriginalContent_id = false;

		bookdetailsModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<bookdetails> toCacheModel() {
		bookdetailsCacheModel bookdetailsCacheModel = new bookdetailsCacheModel();

		bookdetailsCacheModel.id = getId();

		bookdetailsCacheModel.booktitle = getBooktitle();

		String booktitle = bookdetailsCacheModel.booktitle;

		if ((booktitle != null) && (booktitle.length() == 0)) {
			bookdetailsCacheModel.booktitle = null;
		}

		bookdetailsCacheModel.bookname = getBookname();

		String bookname = bookdetailsCacheModel.bookname;

		if ((bookname != null) && (bookname.length() == 0)) {
			bookdetailsCacheModel.bookname = null;
		}

		bookdetailsCacheModel.bookpath = getBookpath();

		String bookpath = bookdetailsCacheModel.bookpath;

		if ((bookpath != null) && (bookpath.length() == 0)) {
			bookdetailsCacheModel.bookpath = null;
		}

		Date createddate = getCreateddate();

		if (createddate != null) {
			bookdetailsCacheModel.createddate = createddate.getTime();
		}
		else {
			bookdetailsCacheModel.createddate = Long.MIN_VALUE;
		}

		bookdetailsCacheModel.createdby = getCreatedby();

		Date modifieddate = getModifieddate();

		if (modifieddate != null) {
			bookdetailsCacheModel.modifieddate = modifieddate.getTime();
		}
		else {
			bookdetailsCacheModel.modifieddate = Long.MIN_VALUE;
		}

		bookdetailsCacheModel.modifiedby = getModifiedby();

		bookdetailsCacheModel.flag = getFlag();

		String flag = bookdetailsCacheModel.flag;

		if ((flag != null) && (flag.length() == 0)) {
			bookdetailsCacheModel.flag = null;
		}

		bookdetailsCacheModel.content_id = getContent_id();

		return bookdetailsCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", booktitle=");
		sb.append(getBooktitle());
		sb.append(", bookname=");
		sb.append(getBookname());
		sb.append(", bookpath=");
		sb.append(getBookpath());
		sb.append(", createddate=");
		sb.append(getCreateddate());
		sb.append(", createdby=");
		sb.append(getCreatedby());
		sb.append(", modifieddate=");
		sb.append(getModifieddate());
		sb.append(", modifiedby=");
		sb.append(getModifiedby());
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
		sb.append("com.chola.book.model.bookdetails");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>booktitle</column-name><column-value><![CDATA[");
		sb.append(getBooktitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bookname</column-name><column-value><![CDATA[");
		sb.append(getBookname());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bookpath</column-name><column-value><![CDATA[");
		sb.append(getBookpath());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createddate</column-name><column-value><![CDATA[");
		sb.append(getCreateddate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdby</column-name><column-value><![CDATA[");
		sb.append(getCreatedby());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifieddate</column-name><column-value><![CDATA[");
		sb.append(getModifieddate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedby</column-name><column-value><![CDATA[");
		sb.append(getModifiedby());
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

	private static final ClassLoader _classLoader = bookdetails.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			bookdetails.class
		};
	private long _id;
	private String _booktitle;
	private String _bookname;
	private String _bookpath;
	private Date _createddate;
	private long _createdby;
	private Date _modifieddate;
	private long _modifiedby;
	private String _flag;
	private long _content_id;
	private long _originalContent_id;
	private boolean _setOriginalContent_id;
	private long _columnBitmask;
	private bookdetails _escapedModel;
}