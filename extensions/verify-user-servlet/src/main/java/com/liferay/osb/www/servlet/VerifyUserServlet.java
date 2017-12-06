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

package com.liferay.osb.www.servlet;

import com.liferay.osb.www.util.PortletPropsValues;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

import java.net.URI;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.http.whiteboard.HttpWhiteboardConstants;

/**
 * @author Joan H .Kim
 * @author Weston Hancock
 * @author Ryan Schuhler
 */
@Component(
	immediate = true,
	property = {
		HttpWhiteboardConstants.HTTP_WHITEBOARD_SERVLET_NAME + "=com.liferay.osb.www.servlet.VerifyUserServlet",
		HttpWhiteboardConstants.HTTP_WHITEBOARD_SERVLET_PATTERN + "=/verify-user-servlet/*"
	},
	service = Servlet.class
)
public class VerifyUserServlet extends HttpServlet {

	@Override
	public void service(
		HttpServletRequest request, HttpServletResponse response) {

		String uuid = ParamUtil.getString(request, "uuid");

		User user = null;

		try {
			if (Validator.isNotNull(uuid)) {
				user = UserLocalServiceUtil.getUserByUuid(uuid);
			}
			else {
				user = UserLocalServiceUtil.fetchUser(
					PortalUtil.getUserId(request));
			}

			if (user == null) {
				return;
			}

			HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();

			HttpClient httpClient = httpClientBuilder.build();

			String servletURL = HttpUtil.addParameter(
				PortletPropsValues.OSB_VERIFY_USER_SERVLET_URL, "userUuid",
				user.getUuid());

			URI uri = new URI(servletURL);

			HttpPost httpPost = new HttpPost(uri);

			httpPost.addHeader(
				"OSB_Verify_User_API_Token",
				PortletPropsValues.OSB_VERIFY_USER_API_TOKEN);

			HttpResponse httpResponse = httpClient.execute(httpPost);

			if (_log.isDebugEnabled()) {
				StatusLine statusLine = httpResponse.getStatusLine();

				_log.debug(
					"Server returned status " + statusLine.getStatusCode());
			}
		}
		catch (Exception e) {
			_log.error(e, e);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(OSBVerifyUserServlet.class);

}