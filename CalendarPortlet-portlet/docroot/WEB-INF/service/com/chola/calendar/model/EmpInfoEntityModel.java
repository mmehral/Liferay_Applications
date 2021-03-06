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

package com.chola.calendar.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the EmpInfoEntity service. Represents a row in the &quot;events_EmpInfoEntity&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.chola.calendar.model.impl.EmpInfoEntityModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.chola.calendar.model.impl.EmpInfoEntityImpl}.
 * </p>
 *
 * @author adms.java1
 * @see EmpInfoEntity
 * @see com.chola.calendar.model.impl.EmpInfoEntityImpl
 * @see com.chola.calendar.model.impl.EmpInfoEntityModelImpl
 * @generated
 */
@ProviderType
public interface EmpInfoEntityModel extends BaseModel<EmpInfoEntity> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a emp info entity model instance should use the {@link EmpInfoEntity} interface instead.
	 */

	/**
	 * Returns the primary key of this emp info entity.
	 *
	 * @return the primary key of this emp info entity
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this emp info entity.
	 *
	 * @param primaryKey the primary key of this emp info entity
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this emp info entity.
	 *
	 * @return the ID of this emp info entity
	 */
	public long getId();

	/**
	 * Sets the ID of this emp info entity.
	 *
	 * @param id the ID of this emp info entity
	 */
	public void setId(long id);

	/**
	 * Returns the emp ID of this emp info entity.
	 *
	 * @return the emp ID of this emp info entity
	 */
	@AutoEscape
	public String getEmpId();

	/**
	 * Sets the emp ID of this emp info entity.
	 *
	 * @param empId the emp ID of this emp info entity
	 */
	public void setEmpId(String empId);

	/**
	 * Returns the name of this emp info entity.
	 *
	 * @return the name of this emp info entity
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this emp info entity.
	 *
	 * @param name the name of this emp info entity
	 */
	public void setName(String name);

	/**
	 * Returns the emailid of this emp info entity.
	 *
	 * @return the emailid of this emp info entity
	 */
	@AutoEscape
	public String getEmailid();

	/**
	 * Sets the emailid of this emp info entity.
	 *
	 * @param emailid the emailid of this emp info entity
	 */
	public void setEmailid(String emailid);

	/**
	 * Returns the birthday of this emp info entity.
	 *
	 * @return the birthday of this emp info entity
	 */
	public Date getBirthday();

	/**
	 * Sets the birthday of this emp info entity.
	 *
	 * @param birthday the birthday of this emp info entity
	 */
	public void setBirthday(Date birthday);

	/**
	 * Returns the grade of this emp info entity.
	 *
	 * @return the grade of this emp info entity
	 */
	@AutoEscape
	public String getGrade();

	/**
	 * Sets the grade of this emp info entity.
	 *
	 * @param grade the grade of this emp info entity
	 */
	public void setGrade(String grade);

	/**
	 * Returns the function name of this emp info entity.
	 *
	 * @return the function name of this emp info entity
	 */
	@AutoEscape
	public String getFunctionName();

	/**
	 * Sets the function name of this emp info entity.
	 *
	 * @param functionName the function name of this emp info entity
	 */
	public void setFunctionName(String functionName);

	/**
	 * Returns the department of this emp info entity.
	 *
	 * @return the department of this emp info entity
	 */
	@AutoEscape
	public String getDepartment();

	/**
	 * Sets the department of this emp info entity.
	 *
	 * @param department the department of this emp info entity
	 */
	public void setDepartment(String department);

	/**
	 * Returns the subdepartment of this emp info entity.
	 *
	 * @return the subdepartment of this emp info entity
	 */
	@AutoEscape
	public String getSubdepartment();

	/**
	 * Sets the subdepartment of this emp info entity.
	 *
	 * @param subdepartment the subdepartment of this emp info entity
	 */
	public void setSubdepartment(String subdepartment);

	/**
	 * Returns the location of this emp info entity.
	 *
	 * @return the location of this emp info entity
	 */
	@AutoEscape
	public String getLocation();

	/**
	 * Sets the location of this emp info entity.
	 *
	 * @param location the location of this emp info entity
	 */
	public void setLocation(String location);

	/**
	 * Returns the gender of this emp info entity.
	 *
	 * @return the gender of this emp info entity
	 */
	@AutoEscape
	public String getGender();

	/**
	 * Sets the gender of this emp info entity.
	 *
	 * @param gender the gender of this emp info entity
	 */
	public void setGender(String gender);

	/**
	 * Returns the unit of this emp info entity.
	 *
	 * @return the unit of this emp info entity
	 */
	@AutoEscape
	public String getUnit();

	/**
	 * Sets the unit of this emp info entity.
	 *
	 * @param unit the unit of this emp info entity
	 */
	public void setUnit(String unit);

	/**
	 * Returns the userid of this emp info entity.
	 *
	 * @return the userid of this emp info entity
	 */
	@AutoEscape
	public String getUserid();

	/**
	 * Sets the userid of this emp info entity.
	 *
	 * @param userid the userid of this emp info entity
	 */
	public void setUserid(String userid);

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
	public int compareTo(EmpInfoEntity empInfoEntity);

	@Override
	public int hashCode();

	@Override
	public CacheModel<EmpInfoEntity> toCacheModel();

	@Override
	public EmpInfoEntity toEscapedModel();

	@Override
	public EmpInfoEntity toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}