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

package com.liferay.hubspot.web.internal.portlet;

import com.liferay.hubspot.model.HSForm;
import com.liferay.hubspot.service.HSContactLocalService;
import com.liferay.hubspot.service.HSFormLocalService;
import com.liferay.hubspot.web.internal.constants.HubSpotPortletKeys;
import com.liferay.hubspot.web.internal.constants.HubSpotWebKeys;
import com.liferay.hubspot.web.internal.display.context.HubSpotFormDisplayContext;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Allen Ziegenfus
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.osb",
		"com.liferay.portlet.header-portlet-css=/form/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=HubSpot Form Portlet",
		"javax.portlet.init-param.config-template=/form/configuration.jsp",
		"javax.portlet.init-param.template-path=/form/",
		"javax.portlet.init-param.view-template=/form/view.jsp",
		"javax.portlet.name=" + HubSpotPortletKeys.HUBSPOT_FORM,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.supports.mime-type=text/html"
	},
	service = Portlet.class
)
public class HubSpotFormPortlet extends MVCPortlet {

	@Override
	public void render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		setRenderRequestAttributes(renderRequest);

		super.render(renderRequest, renderResponse);
	}

	protected void setRenderRequestAttributes(RenderRequest renderRequest) {
		PortletPreferences portletPreferences = renderRequest.getPreferences();

		// TODO: test this some other way
		renderRequest.setAttribute(
				HubSpotWebKeys.OSB_WWW_HUBSPOT_UTK,
				"testuser");
		
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