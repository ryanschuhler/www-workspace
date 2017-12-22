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

package com.liferay.hubspot.service.impl;

import com.liferay.hubspot.model.HSForm;
import com.liferay.hubspot.service.base.HSFormServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.security.auth.AuthTokenUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Allen Ziegenfus
 */
public class HSFormServiceImpl extends HSFormServiceBaseImpl {

	@AccessControlled(guestAccessEnabled = true)
	public HSForm submitHSForm(
			String guid, String userToken, String ipAddress, String pageURL,
			String pageName, String redirectURL, String salesforceCampaignId,
			String[] fields)
		throws PortalException, SystemException {

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		HttpServletRequest request = serviceContext.getRequest();

		AuthTokenUtil.checkCSRFToken(request, getCSRFOrigin(request));

		try {
			return hsFormLocalService.submitHSForm(
				guid, userToken, ipAddress, pageURL, pageName, redirectURL,
				salesforceCampaignId, fields);
		}
		catch (PortalException pe) {
			if (_log.isErrorEnabled()) {
				StringBundler sb = new StringBundler(6);

				sb.append("Failed to submit HubSpot form: ");
				sb.append(guid);
				sb.append("on page ");
				sb.append(
					StringUtil.appendParentheticalSuffix(pageName, pageURL));
				sb.append("with fields ");
				sb.append(StringUtil.merge(fields, StringPool.COLON));

				_log.error(sb.toString());
			}

			throw pe;
		}
	}

	protected String getCSRFOrigin(HttpServletRequest request) {
		return ClassUtil.getClassName(this);
	}

	private static Log _log = LogFactoryUtil.getLog(HSFormServiceImpl.class);

}
