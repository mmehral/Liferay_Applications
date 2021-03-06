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

package com.chola.anniversary.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.chola.anniversary.model.anniversarywish;
import com.chola.anniversary.model.anniversarywishModel;
import com.chola.anniversary.model.anniversarywishSoap;

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
 * The base model implementation for the anniversarywish service. Represents a row in the &quot;add_anniversarywish&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link anniversarywishModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link anniversarywishImpl}.
 * </p>
 *
 * @author CloverLiferay02
 * @see anniversarywishImpl
 * @see anniversarywish
 * @see anniversarywishModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class anniversarywishModelImpl extends BaseModelImpl<anniversarywish>
	implements anniversarywishModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a anniversarywish model instance should use the {@link anniversarywish} interface instead.
	 */
	public static final String TABLE_NAME = "add_anniversarywish";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id_", Types.BIGINT },
			{ "userId", Types.VARCHAR },
			{ "wishedBy", Types.VARCHAR },
			{ "message", Types.VARCHAR },
			{ "createdDate", Types.TIMESTAMP }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("id_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("wishedBy", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("message", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createdDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE = "create table add_anniversarywish (id_ LONG not null primary key,userId VARCHAR(75) null,wishedBy VARCHAR(75) null,message VARCHAR(75) null,createdDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table add_anniversarywish";
	public static final String ORDER_BY_JPQL = " ORDER BY anniversarywish.id ASC";
	public static final String ORDER_BY_SQL = " ORDER BY add_anniversarywish.id_ ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.chola.anniversary.model.anniversarywish"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.chola.anniversary.model.anniversarywish"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.chola.anniversary.model.anniversarywish"),
			true);
	public static final long USERID_COLUMN_BITMASK = 1L;
	public static final long ID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static anniversarywish toModel(anniversarywishSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		anniversarywish model = new anniversarywishImpl();

		model.setId(soapModel.getId());
		model.setUserId(soapModel.getUserId());
		model.setWishedBy(soapModel.getWishedBy());
		model.setMessage(soapModel.getMessage());
		model.setCreatedDate(soapModel.getCreatedDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<anniversarywish> toModels(
		anniversarywishSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<anniversarywish> models = new ArrayList<anniversarywish>(soapModels.length);

		for (anniversarywishSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.chola.anniversary.model.anniversarywish"));

	public anniversarywishModelImpl() {
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
		return anniversarywish.class;
	}

	@Override
	public String getModelClassName() {
		return anniversarywish.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("userId", getUserId());
		attributes.put("wishedBy", getWishedBy());
		attributes.put("message", getMessage());
		attributes.put("createdDate", getCreatedDate());

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

		String userId = (String)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String wishedBy = (String)attributes.get("wishedBy");

		if (wishedBy != null) {
			setWishedBy(wishedBy);
		}

		String message = (String)attributes.get("message");

		if (message != null) {
			setMessage(message);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
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
	public String getUserId() {
		if (_userId == null) {
			return StringPool.BLANK;
		}
		else {
			return _userId;
		}
	}

	@Override
	public void setUserId(String userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (_originalUserId == null) {
			_originalUserId = _userId;
		}

		_userId = userId;
	}

	public String getOriginalUserId() {
		return GetterUtil.getString(_originalUserId);
	}

	@JSON
	@Override
	public String getWishedBy() {
		if (_wishedBy == null) {
			return StringPool.BLANK;
		}
		else {
			return _wishedBy;
		}
	}

	@Override
	public void setWishedBy(String wishedBy) {
		_wishedBy = wishedBy;
	}

	@JSON
	@Override
	public String getMessage() {
		if (_message == null) {
			return StringPool.BLANK;
		}
		else {
			return _message;
		}
	}

	@Override
	public void setMessage(String message) {
		_message = message;
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

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			anniversarywish.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public anniversarywish toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (anniversarywish)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		anniversarywishImpl anniversarywishImpl = new anniversarywishImpl();

		anniversarywishImpl.setId(getId());
		anniversarywishImpl.setUserId(getUserId());
		anniversarywishImpl.setWishedBy(getWishedBy());
		anniversarywishImpl.setMessage(getMessage());
		anniversarywishImpl.setCreatedDate(getCreatedDate());

		anniversarywishImpl.resetOriginalValues();

		return anniversarywishImpl;
	}

	@Override
	public int compareTo(anniversarywish anniversarywish) {
		long primaryKey = anniversarywish.getPrimaryKey();

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

		if (!(obj instanceof anniversarywish)) {
			return false;
		}

		anniversarywish anniversarywish = (anniversarywish)obj;

		long primaryKey = anniversarywish.getPrimaryKey();

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
		anniversarywishModelImpl anniversarywishModelImpl = this;

		anniversarywishModelImpl._originalUserId = anniversarywishModelImpl._userId;

		anniversarywishModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<anniversarywish> toCacheModel() {
		anniversarywishCacheModel anniversarywishCacheModel = new anniversarywishCacheModel();

		anniversarywishCacheModel.id = getId();

		anniversarywishCacheModel.userId = getUserId();

		String userId = anniversarywishCacheModel.userId;

		if ((userId != null) && (userId.length() == 0)) {
			anniversarywishCacheModel.userId = null;
		}

		anniversarywishCacheModel.wishedBy = getWishedBy();

		String wishedBy = anniversarywishCacheModel.wishedBy;

		if ((wishedBy != null) && (wishedBy.length() == 0)) {
			anniversarywishCacheModel.wishedBy = null;
		}

		anniversarywishCacheModel.message = getMessage();

		String message = anniversarywishCacheModel.message;

		if ((message != null) && (message.length() == 0)) {
			anniversarywishCacheModel.message = null;
		}

		Date createdDate = getCreatedDate();

		if (createdDate != null) {
			anniversarywishCacheModel.createdDate = createdDate.getTime();
		}
		else {
			anniversarywishCacheModel.createdDate = Long.MIN_VALUE;
		}

		return anniversarywishCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", wishedBy=");
		sb.append(getWishedBy());
		sb.append(", message=");
		sb.append(getMessage());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.chola.anniversary.model.anniversarywish");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>wishedBy</column-name><column-value><![CDATA[");
		sb.append(getWishedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>message</column-name><column-value><![CDATA[");
		sb.append(getMessage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdDate</column-name><column-value><![CDATA[");
		sb.append(getCreatedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = anniversarywish.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			anniversarywish.class
		};
	private long _id;
	private String _userId;
	private String _originalUserId;
	private String _wishedBy;
	private String _message;
	private Date _createdDate;
	private long _columnBitmask;
	private anniversarywish _escapedModel;
}