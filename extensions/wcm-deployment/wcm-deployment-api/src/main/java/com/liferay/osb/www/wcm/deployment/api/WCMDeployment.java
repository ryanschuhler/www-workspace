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

package com.liferay.osb.www.wcm.deployment.api;

import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;

import org.osgi.framework.Bundle;

/**
 * @author Joan H. Kim
 * @author Allen Ziegenfus
 */
public interface WCMDeployment {

	public void addStructures(List<Structure> structures)
		throws PortalException;

	public void addTemplates(Structure structure, DDMStructure ddmStructure)
		throws PortalException;
	
	public void deploy(Bundle bundle)
		throws PortalException;

	public void dumpToFilesystem(String directory)
		throws PortalException;

}