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

import com.liferay.osb.www.wcm.deployment.api.WCMDeployment;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.Map;

import org.apache.felix.service.command.Descriptor;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Allen R. Ziegenfus
 */
@Component(
		configurationPid = "com.liferay.osb.www.wcm.deployment.service.WCMDeploymentConfiguration",
		configurationPolicy = ConfigurationPolicy.OPTIONAL, immediate = true,
		property = {
			"osgi.command.function=deploy", "osgi.command.function=dumpToFilesystem",
			"osgi.command.scope=wcm"
		},
		service = {WCMDeploymentOSGICommands.class}
	)
public class WCMDeploymentOSGICommands {

	@Descriptor("Deploy structures and templates to database")
	public void deploy() throws PortalException {
		_wcmDeployment.deploy(_bundleContext.getBundle());
	}
	
	@Descriptor("Dump structures and templates from database to filesystem")
	public void dumpToFilesystem() throws PortalException {
		_wcmDeployment.dumpToFilesystem(_wcmDeploymentConfiguration.dumpDirectory());
	}
	
	@Activate
	protected void activate(
		Map<String, Object> properties, BundleContext bundleContext) {

		_wcmDeploymentConfiguration = ConfigurableUtil.createConfigurable(
			WCMDeploymentConfiguration.class, properties);
		
		_bundleContext = bundleContext;
	}
	
	@Reference
	private WCMDeployment _wcmDeployment;

	private BundleContext _bundleContext;
	private volatile WCMDeploymentConfiguration _wcmDeploymentConfiguration;
}
