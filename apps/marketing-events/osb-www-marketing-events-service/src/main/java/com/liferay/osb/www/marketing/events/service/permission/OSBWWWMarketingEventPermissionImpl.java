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

package com.liferay.osb.www.marketing.events.service.permission;

import com.liferay.osb.www.marketing.events.configuration.MarketingEventsConfiguration;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.util.PortalUtil;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Joan H. Kim
 * @author Allen Ziegenfus
 */
@Component(
	configurationPid = "com.liferay.osb.www.marketing.events.configuration.MarketingEventsConfiguration"
)
public class OSBWWWMarketingEventPermissionImpl
	implements OSBWWWMarketingEventPermission {

	public String administratorRoleName() {
		return _configuration.administratorRoleName();
	}

	public void check(PermissionChecker permissionChecker, String actionId)
		throws PortalException {

		if (!contains(permissionChecker, actionId)) {
			throw new PrincipalException();
		}
	}

	public boolean contains(
			PermissionChecker permissionChecker, String actionId)
		throws PortalException {

		if (actionId.equals(ActionKeys.VIEW)) {
			return true;
		}

		if (permissionChecker.isCompanyAdmin()) {
			return true;
		}

		if (_roleLocalService.hasUserRole(
				permissionChecker.getUserId(), PortalUtil.getDefaultCompanyId(),
				administratorRoleName(), false)) {

			return true;
		}

		return false;
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_configuration = ConfigurableUtil.createConfigurable(
			MarketingEventsConfiguration.class, properties);
	}

	private volatile MarketingEventsConfiguration _configuration;

	@Reference
	private RoleLocalService _roleLocalService;

}