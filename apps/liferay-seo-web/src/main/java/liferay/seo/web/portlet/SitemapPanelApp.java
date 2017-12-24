package liferay.seo.web.portlet;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.model.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import liferay.seo.web.constants.LiferaySeoWebPortletKeys;

/**
 * @author Eudaldo Alonso
 */
@Component(
	immediate = true,
	property = {
		"panel.app.order:Integer=300",
		"panel.category.key=" + PanelCategoryKeys.SITE_ADMINISTRATION_CONFIGURATION
	},
	service = PanelApp.class
)
public class SitemapPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return  LiferaySeoWebPortletKeys.LiferaySeoSitemap ;
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + LiferaySeoWebPortletKeys.LiferaySeoSitemap + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}