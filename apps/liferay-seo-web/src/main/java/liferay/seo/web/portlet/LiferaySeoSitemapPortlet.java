package liferay.seo.web.portlet;

import com.liferay.layouts.admin.kernel.util.SitemapURLProvider;
import com.liferay.layouts.admin.kernel.util.SitemapURLProviderRegistryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutSet;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import liferay.seo.web.constants.LiferaySeoWebPortletKeys;

/**
 * @author allenziegenfus
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.css-class-wrapper=seo-sitemap-portlet",	
		"com.liferay.portlet.display-category=category.hidden",
		"com.liferay.portlet.preferences-owned-by-group=true",	
		"com.liferay.portlet.system=true",
		"javax.portlet.display-name=Sitemap",
		"com.liferay.portlet.add-default-resource=true",
		"com.liferay.portlet.render-weight=50",
		"com.liferay.portlet.use-default-template=true",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/sitemap/view.jsp",
		"javax.portlet.name=" + LiferaySeoWebPortletKeys.LiferaySeoSitemap,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=administrator",
		"com.liferay.portlet.header-portlet-css=/sitemap/css/main.css"
	},
	service = Portlet.class
)
public class LiferaySeoSitemapPortlet extends MVCPortlet {
	

	@Override
	public void render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
				WebKeys.THEME_DISPLAY);
		
		try {
		renderRequest.setAttribute("sitemap",  getSitemap(themeDisplay));
		} catch (Exception ex) {
			
			//TODO:
		}
		renderRequest.setAttribute(
			Portal.class.getName(), _portal);

		super.render(renderRequest, renderResponse);
	}

	
	public Map<Layout,Map<String,List<String>>> getSitemap(ThemeDisplay themeDisplay)  throws Exception {
		
		Map<Layout,Map<String,List<String>>> sitemap = new HashMap<>();
		
		List<SitemapURLProvider> sitemapURLProviders = 
			SitemapURLProviderRegistryUtil.getSitemapURLProviders();
		
		boolean privateLayout = false;
		
		List<Layout> layouts = _layoutLocalService.getLayouts(themeDisplay.getSiteGroupId(), privateLayout);
		

		for		(Layout layout : layouts) {
			Map<String,List<String>> urls = new HashMap<>();
			if (layout.getLayoutType().isSitemapable()) {
		
				for (SitemapURLProvider sitemapURLProvider : sitemapURLProviders) {
					List<String> providerUrls = new ArrayList<>();
					Document doc = SAXReaderUtil.createDocument();
					Element element = doc.addElement("urlset");
					sitemapURLProvider.visitLayout(
							 element, layout.getUuid(), layout.getLayoutSet(),
							 themeDisplay);
					List<Node> nodes = doc.selectNodes("/urlset/url/loc");
					for (Node node : nodes) {
						providerUrls.add(node.getText());
					}
					
					urls.put(sitemapURLProvider.getClassName(), providerUrls);
					
					
				}
				
				
			}
			sitemap.put(layout,  urls);
		
		}
	
		return sitemap;

	}
	
	@Reference
	private LayoutLocalService _layoutLocalService;
	
	@Reference
	private Portal _portal;

}