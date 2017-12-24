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

package com.liferay.hubspot.web.internal.display.context;

import com.liferay.hubspot.model.HSFormDisplay;
import com.liferay.hubspot.service.HSContactLocalService;
import com.liferay.hubspot.service.HSFormLocalService;
import com.liferay.hubspot.web.internal.constants.HubSpotWebKeys;
import com.liferay.portal.kernel.util.StringPool;

import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;

/**
 * @author Allen Ziegenfus
 */
public class HubSpotFormDisplayContext {

	public HubSpotFormDisplayContext(RenderRequest renderRequest,
			PortletPreferences portletPreferences,
			HSFormLocalService hsFormLocalService,
			HSContactLocalService hsContactLocalService) {
		
		_renderRequest = renderRequest;		
		_portletPreferences = portletPreferences;
		
		_hsContactLocalService = hsContactLocalService;
		_hsFormLocalService = hsFormLocalService;
	}

	public String getGUID() {
		if (_guid != null) {
			return _guid;
		}

		_guid = _portletPreferences.getValue("guid", StringPool.BLANK);

		return _guid;
	}
	
	public HSFormDisplay getHSFormDisplay() {
		
		String userToken = 
			(String)_renderRequest.getAttribute(
				HubSpotWebKeys.OSB_WWW_HUBSPOT_UTK);
		
		return _hsFormLocalService.getHSFormDisplay(_guid, userToken);		
	}
	
	private String _guid;
	private final HSFormLocalService _hsFormLocalService;
	private final HSContactLocalService _hsContactLocalService;
	private final PortletPreferences _portletPreferences;
	private final RenderRequest _renderRequest;
}