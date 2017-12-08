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

package com.organizationAnnouncement.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.organizationAnnouncement.model.organization;

import com.organizationAnnouncement.service.organizationLocalServiceUtil;

/**
 * The extended model base implementation for the organization service. Represents a row in the &quot;organizationAnnouncement_organization&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link organizationImpl}.
 * </p>
 *
 * @author adms.java1
 * @see organizationImpl
 * @see organization
 * @generated
 */
@ProviderType
public abstract class organizationBaseImpl extends organizationModelImpl
	implements organization {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a organization model instance should use the {@link organization} interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			organizationLocalServiceUtil.addorganization(this);
		}
		else {
			organizationLocalServiceUtil.updateorganization(this);
		}
	}
}