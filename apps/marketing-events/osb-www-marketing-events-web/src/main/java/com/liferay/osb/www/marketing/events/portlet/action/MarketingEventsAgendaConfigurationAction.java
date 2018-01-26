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
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.WebKeys;

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
	property = {"javax.portlet.name=" + OSBWWWMarketingEventsPortletKeys.MARKETING_EVENTS_AGENDA},
	service = ConfigurationAction.class
)
public class MarketingEventsAgendaConfigurationAction extends DefaultConfigurationAction {

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


	protected void setRenderRequestAttributes(RenderRequest renderRequest) {
		PortletPreferences portletPreferences = renderRequest.getPreferences();

		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		MarketingEventAgendaDisplayContext marketingEventAgendaDisplayContext =
			new MarketingEventAgendaDisplayContext(
				portletPreferences, themeDisplay);

		renderRequest.setAttribute(
			WebKeys.MARKETING_EVENT_AGENDA_DISPLAY_CONTEXT,
			marketingEventAgendaDisplayContext);
	}

}