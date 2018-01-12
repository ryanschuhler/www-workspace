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

package com.liferay.osb.www.wcm.deployment.service;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Allen Ziegenfus
 */
@ExtendedObjectClassDefinition(category = "other")
@Meta.OCD(
	id = "com.liferay.osb.www.wcm.deployment.service.WCMDeploymentConfiguration"
)
public interface WCMDeploymentConfiguration {

	@Meta.AD(deflt = "20156", required = false)
	public long adminUserId();
	
	@Meta.AD(deflt = "true", required = false)
	public boolean autoDeploy();

	@Meta.AD(deflt = "/opt/java/liferay/dump", required = false)
	public String dumpDirectory();

	@Meta.AD(deflt = "20143", required = false)
	public long guestGroupId();

}