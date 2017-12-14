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

import com.liferay.osb.www.configuration.VerifyUserConfiguration;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.net.URI;

import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.http.whiteboard.HttpWhiteboardConstants;

/**
 * @author Joan H .Kim
 * @author Weston Hancock
 * @author Ryan Schuhler
 */
@Component(
	configurationPid = "com.liferay.osb.www.configuration.VerifyUserConfiguration",
	immediate = true,
	property = {
		HttpWhiteboardConstants.HTTP_WHITEBOARD_SERVLET_NAME + "=com.liferay.osb.www.servlet.VerifyUserServlet",
		HttpWhiteboardConstants.HTTP_WHITEBOARD_SERVLET_PATTERN + "=/osb-verify-user/*"
	},
	service = Servlet.class
)
public class VerifyUserServlet extends HttpServlet {

	@Override
	public void service(
		HttpServletRequest request, HttpServletResponse response) {

System.out.println("************ verify user service ************");
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		String uuid = ParamUtil.getString(request, "uuid");

		User user = null;

		try {
			if (Validator.isNotNull(uuid)) {
				user = UserLocalServiceUtil.getUserByUuidAndCompanyId(
					uuid, themeDisplay.getCompanyId());
			}
			else {
				user = UserLocalServiceUtil.fetchUser(
					PortalUtil.getUserId(request));
			}

			if (user == null) {
				return;
			}

//			HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
//
//			HttpClient httpClient = httpClientBuilder.build();
//
			String servletURL = HttpUtil.addParameter(
				_verifyUserConfiguration.servletURL(), "userUuid",
				user.getUuid());

			URI uri = new URI(servletURL);

//			HttpPost httpPost = new HttpPost(uri);
//
//			httpPost.addHeader(
//				"OSB_Verify_User_API_Token",
//				_verifyUserConfiguration.apiToken());
//
//			HttpResponse httpResponse = httpClient.execute(httpPost);
//
//			if (_log.isDebugEnabled()) {
//				StatusLine statusLine = httpResponse.getStatusLine();
//
//				_log.debug(
//					"Server returned status " + statusLine.getStatusCode());
//			}
		}
		catch (Exception e) {
			_log.error(e, e);
		}
	}

	@Activate
	protected void activate(Map<String, Object> properties) {
		replaceConfiguration(properties);
	}

	@Modified
	protected void modified(Map<String, Object> properties) throws Exception {
		replaceConfiguration(properties);

		init();
	}

	protected void replaceConfiguration(Map<String, Object> properties) {
		_verifyUserConfiguration = ConfigurableUtil.createConfigurable(
			VerifyUserConfiguration.class, properties);
	}

	private static Log _log = LogFactoryUtil.getLog(VerifyUserServlet.class);

	private VerifyUserConfiguration _verifyUserConfiguration;

}