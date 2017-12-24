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

package com.liferay.hubspot.util;

import com.liferay.portal.kernel.module.configuration.ConfigurationProviderUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

/**
 * @author Peter Shin
 */
public class HubSpotURIUtil {

	public static final String API_CALL_CONTACTS = "contacts";

	public static final String API_CALL_EMAIL = "email/public";

	public static String get(String apiEndpoint) {
		return get(API_CALL_CONTACTS, apiEndpoint);
	}

	public static String get(String apiCall, String apiEndpoint) {
		StringBundler sb = new StringBundler(7);

		sb.append(PortletPropsValues.HUBSPOT_API_DOMAIN);
		sb.append(StringPool.SLASH);
		sb.append(apiCall);
		sb.append(StringPool.SLASH);
		sb.append(PortletPropsValues.HUBSPOT_API_VERSION);
		sb.append(StringPool.SLASH);
		sb.append(apiEndpoint);

		String url = sb.toString();
		return url;
	/*	return HttpUtil.addParameter(
			url, "hapikey", PortletPropsValues.HUBSPOT_SETTINGS_HAPIKEY);*/
	}

	public static String getSubmitForm(String guid) {
		StringBundler sb = new StringBundler(9);

		sb.append(PortletPropsValues.HUBSPOT_FORMS_DOMAIN);
		sb.append(StringPool.SLASH);
		sb.append(PortletPropsValues.HUBSPOT_FORMS_SUBDOMAIN);
		sb.append(StringPool.SLASH);
		sb.append(PortletPropsValues.HUBSPOT_FORMS_VERSION);
		sb.append(StringPool.SLASH);
		sb.append(PortletPropsValues.HUBSPOT_SETTINGS_PORTAL_ID);
		sb.append(StringPool.SLASH);
		sb.append(HttpUtil.encodeURL(guid, true));

		return sb.toString();
	}

}