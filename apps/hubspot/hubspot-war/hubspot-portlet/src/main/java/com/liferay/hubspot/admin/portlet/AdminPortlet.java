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

package com.liferay.hubspot.admin.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;

/**
 * @author Joan H. Kim
 */
public class AdminPortlet extends MVCPortlet {

	public void sendRenewalEmails(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		PortletPreferences portletPreferences = actionRequest.getPreferences();

		portletPreferences.setValue(
			"last-sent-by", String.valueOf(themeDisplay.getUserId()));
		portletPreferences.setValue(
			"last-sent-date", String.valueOf(System.currentTimeMillis()));

		portletPreferences.store();

		if (_log.isInfoEnabled()) {
			_log.info("Sending renewal emails");
		}

		Message message = new Message();

		MessageBusUtil.sendMessage("liferay/hubspot_renewal", message);
	}

	private static Log _log = LogFactoryUtil.getLog(AdminPortlet.class);

}
