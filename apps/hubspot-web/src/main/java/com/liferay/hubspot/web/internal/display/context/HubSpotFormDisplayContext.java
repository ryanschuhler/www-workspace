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

import com.liferay.hubspot.model.HSForm;
import com.liferay.hubspot.model.HSFormDisplay;
import com.liferay.hubspot.service.HSFormLocalService;
import com.liferay.hubspot.service.HSFormLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.StringPool;

import javax.portlet.PortletPreferences;

import org.osgi.service.component.annotations.Reference;

/**
 * @author Allen Ziegenfus
 */
public class HubSpotFormDisplayContext {

	public HubSpotFormDisplayContext(PortletPreferences portletPreferences) {
		_portletPreferences = portletPreferences;
	}

	public String getGUID() {
		if (_guid != null) {
			return _guid;
		}

		_guid = _portletPreferences.getValue("guid", StringPool.BLANK);

		return _guid;
	}
	
	public HSFormDisplay getHSFormDisplay() {
		return HSFormLocalServiceUtil.getHSFormDisplay(_guid);		
	}
	
	private String _guid;
	private final PortletPreferences _portletPreferences;

	@Reference
	private HSFormLocalService _hsFormLocalService;
}