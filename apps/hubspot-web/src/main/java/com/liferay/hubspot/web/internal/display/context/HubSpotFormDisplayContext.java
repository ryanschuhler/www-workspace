package com.liferay.hubspot.web.internal.display.context;

import com.liferay.portal.kernel.util.StringPool;

import javax.portlet.PortletPreferences;

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
	
	private String _guid;
	private final PortletPreferences _portletPreferences;

}
