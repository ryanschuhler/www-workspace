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

package com.liferay.osb.www.marketing.events.portlet.action;

import com.liferay.osb.www.marketing.events.constants.OSBWWWMarketingEventsPortletKeys;
import com.liferay.osb.www.marketing.events.web.display.context.MarketingEventUsersDisplayContext;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Allen Ziegenfus
 */
@Component(
	immediate = true,
	property = {"javax.portlet.name=" + OSBWWWMarketingEventsPortletKeys.MARKETING_EVENTS_USERS},
	service = ConfigurationAction.class
)
public class MarketingEventsUsersConfigurationAction
	extends DefaultConfigurationAction {

	@Override
	public void include(
			PortletConfig portletConfig, HttpServletRequest request,
			HttpServletResponse response)
		throws Exception {

		RenderRequest renderRequest = (RenderRequest)request.getAttribute(
			JavaConstants.JAVAX_PORTLET_REQUEST);

		setRenderRequestAttributes(renderRequest);

		super.include(portletConfig, request, response);
	}

	@Override
	public void processAction(
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse)
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		if (!cmd.equals(Constants.UPDATE)) {
			return;
		}

		List<String> anyAssetCategoryIds = new ArrayList<>();
		List<String> notAnyAssetCategoryIds = new ArrayList<>();
		Enumeration<String> enu = actionRequest.getParameterNames();

		while (enu.hasMoreElements()) {
			String param = enu.nextElement();

			if (StringUtil.startsWith(param, "anyAssetCategoryIds")) {
				String[] values = actionRequest.getParameterValues(param);

				for (int i = 0; i < values.length; i++) {
					if (Validator.isNotNull(values[i])) {
						anyAssetCategoryIds.add(values[i]);
					}
				}
			}

			if (StringUtil.startsWith(param, "notAnyAssetCategoryIds")) {
				String[] values = actionRequest.getParameterValues(param);

				for (int i = 0; i < values.length; i++) {
					if (Validator.isNotNull(values[i])) {
						notAnyAssetCategoryIds.add(values[i]);
					}
				}
			}
		}

		setPreference(
			actionRequest, "anyAssetCategoryIds",
			StringUtil.merge(anyAssetCategoryIds.toArray()));
		setPreference(
			actionRequest, "notAnyAssetCategoryIds",
			StringUtil.merge(notAnyAssetCategoryIds.toArray()));

		super.processAction(portletConfig, actionRequest, actionResponse);
	}

	protected void setRenderRequestAttributes(RenderRequest renderRequest) {
		PortletPreferences portletPreferences = renderRequest.getPreferences();

		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		MarketingEventUsersDisplayContext marketingEventUsersDisplayContext =
			new MarketingEventUsersDisplayContext(
				portletPreferences, themeDisplay);

		renderRequest.setAttribute(
			WebKeys.PORTLET_DISPLAY_CONTEXT, marketingEventUsersDisplayContext);
	}

}