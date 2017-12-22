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

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.util.portlet.PortletProps;

/**
 * @author Peter Shin
 * @author Joan H. Kim
 */
public class PortletPropsValues {

	public static final String DOSSIERA_DATABASE_HOST = PortletProps.get(
		PortletPropsKeys.DOSSIERA_DATABASE_HOST);

	public static final String DOSSIERA_DATABASE_NAME = PortletProps.get(
		PortletPropsKeys.DOSSIERA_DATABASE_NAME);

	public static final String DOSSIERA_DATABASE_PASSWORD = PortletProps.get(
		PortletPropsKeys.DOSSIERA_DATABASE_PASSWORD);

	public static final String DOSSIERA_DATABASE_USER = PortletProps.get(
		PortletPropsKeys.DOSSIERA_DATABASE_USER);

	public static final int HTTP_CLIENT_MAX_CONNECTIONS_PER_HOST =
		GetterUtil.getInteger(
			PortletProps.get(
				PortletPropsKeys.HTTP_CLIENT_MAX_CONNECTIONS_PER_HOST));

	public static final int HTTP_CLIENT_MAX_TOTAL_CONNECTIONS =
		GetterUtil.getInteger(
			PortletProps.get(
				PortletPropsKeys.HTTP_CLIENT_MAX_TOTAL_CONNECTIONS));

	public static final int HTTP_CLIENT_TIMEOUT = GetterUtil.getInteger(
		PortletProps.get(PortletPropsKeys.HTTP_CLIENT_TIMEOUT));

	public static final String HUBSPOT_API_DOMAIN = PortletProps.get(
		PortletPropsKeys.HUBSPOT_API_DOMAIN);

	public static final String HUBSPOT_API_VERSION = PortletProps.get(
		PortletPropsKeys.HUBSPOT_API_VERSION);

	public static final String HUBSPOT_FORMS_DOMAIN = PortletProps.get(
		PortletPropsKeys.HUBSPOT_FORMS_DOMAIN);

	public static final String HUBSPOT_FORMS_SUBDOMAIN = PortletProps.get(
		PortletPropsKeys.HUBSPOT_FORMS_SUBDOMAIN);

	public static final String HUBSPOT_FORMS_VERSION = PortletProps.get(
		PortletPropsKeys.HUBSPOT_FORMS_VERSION);

	public static final String HUBSPOT_RENEWAL_COUNTRY_CODES = PortletProps.get(
		PortletPropsKeys.HUBSPOT_RENEWAL_COUNTRY_CODES);

	public static final String HUBSPOT_RENEWAL_DAYS_INTERVAL = PortletProps.get(
		PortletPropsKeys.HUBSPOT_RENEWAL_DAYS_INTERVAL);

	public static final String HUBSPOT_RENEWAL_EMAIL = PortletProps.get(
		PortletPropsKeys.HUBSPOT_RENEWAL_EMAIL);

	public static final String[] HUBSPOT_RENEWAL_LANGUAGE_IDS =
		PortletProps.getArray(PortletPropsKeys.HUBSPOT_RENEWAL_LANGUAGE_IDS);

	public static final String HUBSPOT_RENEWAL_SUBJECT = PortletProps.get(
		PortletPropsKeys.HUBSPOT_RENEWAL_SUBJECT);

	public static final String HUBSPOT_RENEWAL_TEMPLATE_ID = PortletProps.get(
		PortletPropsKeys.HUBSPOT_RENEWAL_TEMPLATE_ID);

	public static final String HUBSPOT_RENEWAL_USER_ID = PortletProps.get(
		PortletPropsKeys.HUBSPOT_RENEWAL_USER_ID);

	public static final String HUBSPOT_SETTINGS_HAPIKEY = PortletProps.get(
		PortletPropsKeys.HUBSPOT_SETTINGS_HAPIKEY);

	public static final String HUBSPOT_SETTINGS_PORTAL_ID = PortletProps.get(
		PortletPropsKeys.HUBSPOT_SETTINGS_PORTAL_ID);

	public static final int HUBSPOT_VID_SYNC_INTERVAL =
		GetterUtil.getInteger(
			PortletProps.get(PortletPropsKeys.HUBSPOT_VID_SYNC_INTERVAL));

	public static final int HUBSPOT_VID_SYNC_MAX_RESULTS =
		GetterUtil.getInteger(
			PortletProps.get(PortletPropsKeys.HUBSPOT_VID_SYNC_MAX_RESULTS));

}