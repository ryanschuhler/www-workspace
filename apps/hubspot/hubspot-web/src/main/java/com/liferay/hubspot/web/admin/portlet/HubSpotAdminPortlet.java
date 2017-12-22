package com.liferay.hubspot.web.admin.portlet;

import com.liferay.hubspot.web.constants.HubSpotPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author Allen Ziegenfus
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.hidden",
		"com.liferay.portlet.css-class-wrapper=>hubspot-portlet",
		"com.liferay.portlet.instanceable=false",
		"com.liferay.portlet.preferences-company-wide=true",
		"com.liferay.portlet.render-weight=12",
		"javax.portlet.display-name=HubSpot",
		"javax.portlet.init-param.template-path=/admin/",
		"javax.portlet.init-param.view-template=/admin/view.jsp",
		"javax.portlet.name=" + HubSpotPortletKeys.HUBSPOT_ADMIN,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=administrator,guest,power-user,user",
		"javax.portlet.supports.mime-type=text/html"
	},
	service = Portlet.class
)
public class HubSpotAdminPortlet extends MVCPortlet {
}