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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Joan H. Kim
 * @author Allen Ziegenfus
 */
@Component
public class OSBWWWMarketingEventPermissionUtil {

	public static void check(
			PermissionChecker permissionChecker, String actionId)
		throws PortalException {

		getOSBWWWMarketingEventPermission().check(permissionChecker, actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, String actionId)
		throws PortalException {

		return getOSBWWWMarketingEventPermission().contains(
			permissionChecker, actionId);
	}

	public static OSBWWWMarketingEventPermission
		getOSBWWWMarketingEventPermission() {

		return _osbWWWMarketingEventPermissionUtil;
	}

	@Reference(unbind = "-")
	public void setOSBWWWMarketingEventPermission(
		OSBWWWMarketingEventPermission osbWWWMarketingEventPermission) {

		_osbWWWMarketingEventPermissionUtil = osbWWWMarketingEventPermission;
	}

	private static OSBWWWMarketingEventPermission
		_osbWWWMarketingEventPermissionUtil;

}