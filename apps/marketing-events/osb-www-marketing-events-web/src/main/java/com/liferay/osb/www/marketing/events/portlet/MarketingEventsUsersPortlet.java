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

package com.liferay.osb.www.marketing.events.portlet;

import com.liferay.osb.www.marketing.events.constants.OSBWWWMarketingEventsPortletKeys;
import com.liferay.osb.www.marketing.events.web.display.context.MarketingEventUsersDisplayContext;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Allen Ziegenfus
 */
@Component(
	configurationPid = "com.liferay.osb.www.marketing.events.configuration.MarketingEventsConfiguration",
	immediate = true,
	property = {
		"com.liferay.portlet.css-class-wrapper=osb-www-marketing-events-portlet-users",
		"com.liferay.portlet.display-category=category.osb",
		"com.liferay.portlet.footer-portlet-javascript=/users/js/main.js",
		"com.liferay.portlet.header-portlet-css=/users/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=OSB WWW Marketing Events Users",
		"javax.portlet.expiration-cache=0",
		"javax.portlet.init-param.config-template=/users/configuration.jsp",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/users/view.jsp",
		"javax.portlet.name=" + OSBWWWMarketingEventsPortletKeys.MARKETING_EVENTS_USERS,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=administrator,guest,power-user,user",
		"javax.portlet.supports.mime-type=text/html"
	},
	service = Portlet.class
)
public class MarketingEventsUsersPortlet extends MVCPortlet {

	@Override
	public void render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		setRenderRequestAttributes(renderRequest);

		super.render(renderRequest, renderResponse);
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