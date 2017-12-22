package com.liferay.hubspot.web.admin.portlet;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.hubspot.web.constants.HubSpotPortletKeys;
import com.liferay.portal.kernel.model.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Allen Ziegenfus
 */
@Component(
	immediate = true,
	property = {
		"panel.app.order:Integer=300",
		"panel.category.key=" + PanelCategoryKeys.CONTROL_PANEL_CONFIGURATION
	},
	service = PanelApp.class
)
public class HubSpotPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return  HubSpotPortletKeys.HUBSPOT_ADMIN ;
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + HubSpotPortletKeys.HUBSPOT_ADMIN + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}