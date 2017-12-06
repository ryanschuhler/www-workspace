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

package com.liferay.osb.www.util;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.util.portlet.PortletProps;

/**
 * @author Joan H. Kim
 */
public class PortletPropsValues {

	public static final String OSB_WWW_VERIFY_USER_API_TOKEN =
		GetterUtil.getString(
			PortletProps.get(PortletPropsKeys.OSB_WWW_VERIFY_USER_API_TOKEN));

	public static final String OSB_WWW_VERIFY_USER_SERVLET_URL =
		GetterUtil.getString(
			PortletProps.get(PortletPropsKeys.OSB_WWW_VERIFY_USER_SERVLET_URL));

}