package com.liferay.blog.sitemap.util;

import com.liferay.blogs.kernel.model.BlogsEntry;
import com.liferay.blogs.kernel.service.BlogsEntryLocalService;
import com.liferay.layouts.admin.kernel.util.SitemapURLProvider;
import com.liferay.layouts.admin.kernel.util.SitemapUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutSet;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.kernel.xml.Element;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Allen Ziegenfus
 */
@Component(
	immediate = true,
	service = SitemapURLProvider.class
)
public class BlogsEntrySitemapURLProvider implements SitemapURLProvider {

	@Override
	public String getClassName() {
		return BlogsEntry.class.getName();
	}


	@Override
	public void visitLayout(Element element, String layoutUuid, LayoutSet layoutSet, ThemeDisplay themeDisplay)
			throws PortalException {
		
		Layout layout = _layoutLocalService.getLayoutByUuidAndGroupId(
				layoutUuid, layoutSet.getGroupId(),
				layoutSet.getPrivateLayout());
		
		if (!layout.getTypeSettings().contains("com_liferay_blogs_web_portlet_BlogsPortlet")) {
			return;
		}
		
		List<BlogsEntry> blogsEntries = _blogsEntryLocalService.getBlogsEntries(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		for (BlogsEntry blogsEntry : blogsEntries) {
		
			String url = themeDisplay.getCDNBaseURL() + layout.getFriendlyURL() +  Portal.FRIENDLY_URL_SEPARATOR + "blogs" +
					StringPool.SLASH + blogsEntry.getUrlTitle();
			
			UnicodeProperties typeSettingsProperties = null;
			Date modifiedDate = new Date();
			String canonicalURL = url;
			
			Map<Locale, String> alternateURLs = new HashMap<>();
			alternateURLs.put(Locale.GERMAN, url + "/de");
			
			SitemapUtil.addURLElement(
				element, url, typeSettingsProperties, modifiedDate, canonicalURL, alternateURLs);
		}
		
	}
	
	@Override
	public void visitLayoutSet(Element element, LayoutSet layoutSet, ThemeDisplay themeDisplay) throws PortalException {

		
	}
	
	@Reference
	private BlogsEntryLocalService _blogsEntryLocalService;

	@Reference
	private LayoutLocalService _layoutLocalService;
}