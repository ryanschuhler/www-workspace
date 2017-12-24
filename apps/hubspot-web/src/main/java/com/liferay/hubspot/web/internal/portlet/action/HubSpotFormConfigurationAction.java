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

package com.liferay.hubspot.web.internal.portlet.action;

import com.liferay.hubspot.service.HSContactLocalService;
import com.liferay.hubspot.service.HSFormLocalService;
import com.liferay.hubspot.web.internal.constants.HubSpotPortletKeys;
import com.liferay.hubspot.web.internal.constants.HubSpotWebKeys;
import com.liferay.hubspot.web.internal.display.context.HubSpotFormDisplayContext;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.Map;

import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Allen Ziegenfus
 */
@Component(
	immediate = true,
	property = {"javax.portlet.name=" + HubSpotPortletKeys.HUBSPOT_FORM},
	service = ConfigurationAction.class
)
public class HubSpotFormConfigurationAction extends DefaultConfigurationAction {

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

		HubSpotFormDisplayContext hubSpotFormDisplayContext =
			new HubSpotFormDisplayContext(renderRequest, portletPreferences,
			_hsFormLocalService, _hsContactLocalService);

		renderRequest.setAttribute(
			HubSpotWebKeys.HUBSPOT_FORM_DISPLAY_CONTEXT,
			hubSpotFormDisplayContext);
	}
	
	@Reference
	private HSContactLocalService _hsContactLocalService;
	
	@Reference
	private HSFormLocalService _hsFormLocalService;

}


