package com.liferay.hubspot.web.portlet;

import com.liferay.hubspot.web.constants.HubSpotPortletKeys;
import com.liferay.hubspot.web.constants.HubSpotWebKeys;
import com.liferay.hubspot.web.internal.display.context.HubSpotFormDisplayContext;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

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
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.osb",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=HubSpot Form Portlet",
		"javax.portlet.init-param.config-template=/form/configuration.jsp",
		"javax.portlet.init-param.template-path=/form/",
		"javax.portlet.init-param.view-template=/form/view.jsp",
		"javax.portlet.name=" + HubSpotPortletKeys.HUBSPOT_FORM,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
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
		PortletPreferences portletPreferences =
				renderRequest.getPreferences();
		
		HubSpotFormDisplayContext hubSpotFormDisplayContext = 
				new HubSpotFormDisplayContext(portletPreferences);
		
		renderRequest.setAttribute(
			HubSpotWebKeys.HUBSPOT_FORM_DISPLAY_CONTEXT, hubSpotFormDisplayContext);
	}

}