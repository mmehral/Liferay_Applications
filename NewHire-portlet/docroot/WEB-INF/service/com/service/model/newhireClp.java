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

package com.service.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import com.service.service.ClpSerializer;
import com.service.service.newhireLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @generated
 */
@ProviderType
public class newhireClp extends BaseModelImpl<newhire> implements newhire {
	public newhireClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return newhire.class;
	}

	@Override
	public String getModelClassName() {
		return newhire.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _newhire_id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setNewhire_id(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _newhire_id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("newhire_id", getNewhire_id());
		attributes.put("newhire_name", getNewhire_name());
		attributes.put("newhire_designation", getNewhire_designation());
		attributes.put("newhire_profileimage", getNewhire_profileimage());
		attributes.put("newhire_profileimage_path",
			getNewhire_profileimage_path());
		attributes.put("newhire_detailedimage", getNewhire_detailedimage());
		attributes.put("newhire_detailedimage_path",
			getNewhire_detailedimage_path());
		attributes.put("newhire_createdate", getNewhire_createdate());
		attributes.put("newhire_modifieddate", getNewhire_modifieddate());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long newhire_id = (Long)attributes.get("newhire_id");

		if (newhire_id != null) {
			setNewhire_id(newhire_id);
		}

		String newhire_name = (String)attributes.get("newhire_name");

		if (newhire_name != null) {
			setNewhire_name(newhire_name);
		}

		String newhire_designation = (String)attributes.get(
				"newhire_designation");

		if (newhire_designation != null) {
			setNewhire_designation(newhire_designation);
		}

		String newhire_profileimage = (String)attributes.get(
				"newhire_profileimage");

		if (newhire_profileimage != null) {
			setNewhire_profileimage(newhire_profileimage);
		}

		String newhire_profileimage_path = (String)attributes.get(
				"newhire_profileimage_path");

		if (newhire_profileimage_path != null) {
			setNewhire_profileimage_path(newhire_profileimage_path);
		}

		String newhire_detailedimage = (String)attributes.get(
				"newhire_detailedimage");

		if (newhire_detailedimage != null) {
			setNewhire_detailedimage(newhire_detailedimage);
		}

		String newhire_detailedimage_path = (String)attributes.get(
				"newhire_detailedimage_path");

		if (newhire_detailedimage_path != null) {
			setNewhire_detailedimage_path(newhire_detailedimage_path);
		}

		Date newhire_createdate = (Date)attributes.get("newhire_createdate");

		if (newhire_createdate != null) {
			setNewhire_createdate(newhire_createdate);
		}

		Date newhire_modifieddate = (Date)attributes.get("newhire_modifieddate");

		if (newhire_modifieddate != null) {
			setNewhire_modifieddate(newhire_modifieddate);
		}

		_entityCacheEnabled = GetterUtil.getBoolean("entityCacheEnabled");
		_finderCacheEnabled = GetterUtil.getBoolean("finderCacheEnabled");
	}

	@Override
	public long getNewhire_id() {
		return _newhire_id;
	}

	@Override
	public void setNewhire_id(long newhire_id) {
		_newhire_id = newhire_id;

		if (_newhireRemoteModel != null) {
			try {
				Class<?> clazz = _newhireRemoteModel.getClass();

				Method method = clazz.getMethod("setNewhire_id", long.class);

				method.invoke(_newhireRemoteModel, newhire_id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNewhire_name() {
		return _newhire_name;
	}

	@Override
	public void setNewhire_name(String newhire_name) {
		_newhire_name = newhire_name;

		if (_newhireRemoteModel != null) {
			try {
				Class<?> clazz = _newhireRemoteModel.getClass();

				Method method = clazz.getMethod("setNewhire_name", String.class);

				method.invoke(_newhireRemoteModel, newhire_name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNewhire_designation() {
		return _newhire_designation;
	}

	@Override
	public void setNewhire_designation(String newhire_designation) {
		_newhire_designation = newhire_designation;

		if (_newhireRemoteModel != null) {
			try {
				Class<?> clazz = _newhireRemoteModel.getClass();

				Method method = clazz.getMethod("setNewhire_designation",
						String.class);

				method.invoke(_newhireRemoteModel, newhire_designation);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNewhire_profileimage() {
		return _newhire_profileimage;
	}

	@Override
	public void setNewhire_profileimage(String newhire_profileimage) {
		_newhire_profileimage = newhire_profileimage;

		if (_newhireRemoteModel != null) {
			try {
				Class<?> clazz = _newhireRemoteModel.getClass();

				Method method = clazz.getMethod("setNewhire_profileimage",
						String.class);

				method.invoke(_newhireRemoteModel, newhire_profileimage);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNewhire_profileimage_path() {
		return _newhire_profileimage_path;
	}

	@Override
	public void setNewhire_profileimage_path(String newhire_profileimage_path) {
		_newhire_profileimage_path = newhire_profileimage_path;

		if (_newhireRemoteModel != null) {
			try {
				Class<?> clazz = _newhireRemoteModel.getClass();

				Method method = clazz.getMethod("setNewhire_profileimage_path",
						String.class);

				method.invoke(_newhireRemoteModel, newhire_profileimage_path);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNewhire_detailedimage() {
		return _newhire_detailedimage;
	}

	@Override
	public void setNewhire_detailedimage(String newhire_detailedimage) {
		_newhire_detailedimage = newhire_detailedimage;

		if (_newhireRemoteModel != null) {
			try {
				Class<?> clazz = _newhireRemoteModel.getClass();

				Method method = clazz.getMethod("setNewhire_detailedimage",
						String.class);

				method.invoke(_newhireRemoteModel, newhire_detailedimage);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNewhire_detailedimage_path() {
		return _newhire_detailedimage_path;
	}

	@Override
	public void setNewhire_detailedimage_path(String newhire_detailedimage_path) {
		_newhire_detailedimage_path = newhire_detailedimage_path;

		if (_newhireRemoteModel != null) {
			try {
				Class<?> clazz = _newhireRemoteModel.getClass();

				Method method = clazz.getMethod("setNewhire_detailedimage_path",
						String.class);

				method.invoke(_newhireRemoteModel, newhire_detailedimage_path);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getNewhire_createdate() {
		return _newhire_createdate;
	}

	@Override
	public void setNewhire_createdate(Date newhire_createdate) {
		_newhire_createdate = newhire_createdate;

		if (_newhireRemoteModel != null) {
			try {
				Class<?> clazz = _newhireRemoteModel.getClass();

				Method method = clazz.getMethod("setNewhire_createdate",
						Date.class);

				method.invoke(_newhireRemoteModel, newhire_createdate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getNewhire_modifieddate() {
		return _newhire_modifieddate;
	}

	@Override
	public void setNewhire_modifieddate(Date newhire_modifieddate) {
		_newhire_modifieddate = newhire_modifieddate;

		if (_newhireRemoteModel != null) {
			try {
				Class<?> clazz = _newhireRemoteModel.getClass();

				Method method = clazz.getMethod("setNewhire_modifieddate",
						Date.class);

				method.invoke(_newhireRemoteModel, newhire_modifieddate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getnewhireRemoteModel() {
		return _newhireRemoteModel;
	}

	public void setnewhireRemoteModel(BaseModel<?> newhireRemoteModel) {
		_newhireRemoteModel = newhireRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _newhireRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_newhireRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() {
		if (this.isNew()) {
			newhireLocalServiceUtil.addnewhire(this);
		}
		else {
			newhireLocalServiceUtil.updatenewhire(this);
		}
	}

	@Override
	public newhire toEscapedModel() {
		return (newhire)ProxyUtil.newProxyInstance(newhire.class.getClassLoader(),
			new Class[] { newhire.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		newhireClp clone = new newhireClp();

		clone.setNewhire_id(getNewhire_id());
		clone.setNewhire_name(getNewhire_name());
		clone.setNewhire_designation(getNewhire_designation());
		clone.setNewhire_profileimage(getNewhire_profileimage());
		clone.setNewhire_profileimage_path(getNewhire_profileimage_path());
		clone.setNewhire_detailedimage(getNewhire_detailedimage());
		clone.setNewhire_detailedimage_path(getNewhire_detailedimage_path());
		clone.setNewhire_createdate(getNewhire_createdate());
		clone.setNewhire_modifieddate(getNewhire_modifieddate());

		return clone;
	}

	@Override
	public int compareTo(newhire newhire) {
		int value = 0;

		value = DateUtil.compareTo(getNewhire_createdate(),
				newhire.getNewhire_createdate());

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

		if (!(obj instanceof newhireClp)) {
			return false;
		}

		newhireClp newhire = (newhireClp)obj;

		long primaryKey = newhire.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{newhire_id=");
		sb.append(getNewhire_id());
		sb.append(", newhire_name=");
		sb.append(getNewhire_name());
		sb.append(", newhire_designation=");
		sb.append(getNewhire_designation());
		sb.append(", newhire_profileimage=");
		sb.append(getNewhire_profileimage());
		sb.append(", newhire_profileimage_path=");
		sb.append(getNewhire_profileimage_path());
		sb.append(", newhire_detailedimage=");
		sb.append(getNewhire_detailedimage());
		sb.append(", newhire_detailedimage_path=");
		sb.append(getNewhire_detailedimage_path());
		sb.append(", newhire_createdate=");
		sb.append(getNewhire_createdate());
		sb.append(", newhire_modifieddate=");
		sb.append(getNewhire_modifieddate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.service.model.newhire");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>newhire_id</column-name><column-value><![CDATA[");
		sb.append(getNewhire_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>newhire_name</column-name><column-value><![CDATA[");
		sb.append(getNewhire_name());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>newhire_designation</column-name><column-value><![CDATA[");
		sb.append(getNewhire_designation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>newhire_profileimage</column-name><column-value><![CDATA[");
		sb.append(getNewhire_profileimage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>newhire_profileimage_path</column-name><column-value><![CDATA[");
		sb.append(getNewhire_profileimage_path());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>newhire_detailedimage</column-name><column-value><![CDATA[");
		sb.append(getNewhire_detailedimage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>newhire_detailedimage_path</column-name><column-value><![CDATA[");
		sb.append(getNewhire_detailedimage_path());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>newhire_createdate</column-name><column-value><![CDATA[");
		sb.append(getNewhire_createdate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>newhire_modifieddate</column-name><column-value><![CDATA[");
		sb.append(getNewhire_modifieddate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _newhire_id;
	private String _newhire_name;
	private String _newhire_designation;
	private String _newhire_profileimage;
	private String _newhire_profileimage_path;
	private String _newhire_detailedimage;
	private String _newhire_detailedimage_path;
	private Date _newhire_createdate;
	private Date _newhire_modifieddate;
	private BaseModel<?> _newhireRemoteModel;
	private Class<?> _clpSerializerClass = ClpSerializer.class;
	private boolean _entityCacheEnabled;
	private boolean _finderCacheEnabled;
}