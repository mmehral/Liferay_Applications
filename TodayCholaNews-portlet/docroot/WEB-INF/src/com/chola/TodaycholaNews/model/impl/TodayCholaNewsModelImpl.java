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

package com.chola.TodaycholaNews.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.chola.TodaycholaNews.model.TodayCholaNews;
import com.chola.TodaycholaNews.model.TodayCholaNewsModel;
import com.chola.TodaycholaNews.model.TodayCholaNewsSoap;

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the TodayCholaNews service. Represents a row in the &quot;chola_TodayCholaNews&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link TodayCholaNewsModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TodayCholaNewsImpl}.
 * </p>
 *
 * @author adms.java1
 * @see TodayCholaNewsImpl
 * @see TodayCholaNews
 * @see TodayCholaNewsModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class TodayCholaNewsModelImpl extends BaseModelImpl<TodayCholaNews>
	implements TodayCholaNewsModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a today chola news model instance should use the {@link TodayCholaNews} interface instead.
	 */
	public static final String TABLE_NAME = "chola_TodayCholaNews";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id_", Types.BIGINT },
			{ "title", Types.VARCHAR },
			{ "content", Types.VARCHAR },
			{ "createdate", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("id_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("title", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("content", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createdate", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table chola_TodayCholaNews (id_ LONG not null primary key,title VARCHAR(75) null,content VARCHAR(75) null,createdate VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table chola_TodayCholaNews";
	public static final String ORDER_BY_JPQL = " ORDER BY todayCholaNews.id ASC";
	public static final String ORDER_BY_SQL = " ORDER BY chola_TodayCholaNews.id_ ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.chola.TodaycholaNews.model.TodayCholaNews"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.chola.TodaycholaNews.model.TodayCholaNews"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static TodayCholaNews toModel(TodayCholaNewsSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		TodayCholaNews model = new TodayCholaNewsImpl();

		model.setId(soapModel.getId());
		model.setTitle(soapModel.getTitle());
		model.setContent(soapModel.getContent());
		model.setCreatedate(soapModel.getCreatedate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<TodayCholaNews> toModels(TodayCholaNewsSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<TodayCholaNews> models = new ArrayList<TodayCholaNews>(soapModels.length);

		for (TodayCholaNewsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.chola.TodaycholaNews.model.TodayCholaNews"));

	public TodayCholaNewsModelImpl() {
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
		return TodayCholaNews.class;
	}

	@Override
	public String getModelClassName() {
		return TodayCholaNews.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("title", getTitle());
		attributes.put("content", getContent());
		attributes.put("createdate", getCreatedate());

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

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		String createdate = (String)attributes.get("createdate");

		if (createdate != null) {
			setCreatedate(createdate);
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
	public String getTitle() {
		if (_title == null) {
			return StringPool.BLANK;
		}
		else {
			return _title;
		}
	}

	@Override
	public void setTitle(String title) {
		_title = title;
	}

	@JSON
	@Override
	public String getContent() {
		if (_content == null) {
			return StringPool.BLANK;
		}
		else {
			return _content;
		}
	}

	@Override
	public void setContent(String content) {
		_content = content;
	}

	@JSON
	@Override
	public String getCreatedate() {
		if (_createdate == null) {
			return StringPool.BLANK;
		}
		else {
			return _createdate;
		}
	}

	@Override
	public void setCreatedate(String createdate) {
		_createdate = createdate;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			TodayCholaNews.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public TodayCholaNews toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (TodayCholaNews)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TodayCholaNewsImpl todayCholaNewsImpl = new TodayCholaNewsImpl();

		todayCholaNewsImpl.setId(getId());
		todayCholaNewsImpl.setTitle(getTitle());
		todayCholaNewsImpl.setContent(getContent());
		todayCholaNewsImpl.setCreatedate(getCreatedate());

		todayCholaNewsImpl.resetOriginalValues();

		return todayCholaNewsImpl;
	}

	@Override
	public int compareTo(TodayCholaNews todayCholaNews) {
		long primaryKey = todayCholaNews.getPrimaryKey();

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

		if (!(obj instanceof TodayCholaNews)) {
			return false;
		}

		TodayCholaNews todayCholaNews = (TodayCholaNews)obj;

		long primaryKey = todayCholaNews.getPrimaryKey();

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
	}

	@Override
	public CacheModel<TodayCholaNews> toCacheModel() {
		TodayCholaNewsCacheModel todayCholaNewsCacheModel = new TodayCholaNewsCacheModel();

		todayCholaNewsCacheModel.id = getId();

		todayCholaNewsCacheModel.title = getTitle();

		String title = todayCholaNewsCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			todayCholaNewsCacheModel.title = null;
		}

		todayCholaNewsCacheModel.content = getContent();

		String content = todayCholaNewsCacheModel.content;

		if ((content != null) && (content.length() == 0)) {
			todayCholaNewsCacheModel.content = null;
		}

		todayCholaNewsCacheModel.createdate = getCreatedate();

		String createdate = todayCholaNewsCacheModel.createdate;

		if ((createdate != null) && (createdate.length() == 0)) {
			todayCholaNewsCacheModel.createdate = null;
		}

		return todayCholaNewsCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", content=");
		sb.append(getContent());
		sb.append(", createdate=");
		sb.append(getCreatedate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.chola.TodaycholaNews.model.TodayCholaNews");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>content</column-name><column-value><![CDATA[");
		sb.append(getContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdate</column-name><column-value><![CDATA[");
		sb.append(getCreatedate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = TodayCholaNews.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			TodayCholaNews.class
		};
	private long _id;
	private String _title;
	private String _content;
	private String _createdate;
	private TodayCholaNews _escapedModel;
}