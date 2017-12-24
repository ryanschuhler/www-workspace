<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%@ page import="com.liferay.portal.kernel.util.StringPool" %><%@
page import="com.liferay.portal.kernel.util.ListMergeable" %> <%@
page import="com.liferay.portal.kernel.util.Portal" %> <%@
page import="com.liferay.portal.kernel.util.GetterUtil" %><%@
page import="com.liferay.layouts.admin.kernel.util.SitemapURLProviderRegistryUtil" %> <%@
page import="com.liferay.layouts.admin.kernel.util.SitemapURLProvider" %><%@
page import="org.osgi.framework.FrameworkUtil" %><%@
page import="org.osgi.framework.Bundle" %><%@
page import="java.util.Map" %><%@
page import="com.liferay.portal.kernel.model.Layout" %>



<%
Object portalObj = renderRequest.getAttribute(Portal.class.getName());
Portal portal = null;
if (portalObj != null) {
	portal = (Portal)GetterUtil.getObject(portalObj);
}

Object sitemapObj = renderRequest.getAttribute("sitemap");
Map<Layout,Map<String,String>> sitemap = null;
if (sitemapObj != null) {
	sitemap = (Map<Layout,Map<String,String>>) GetterUtil.getObject(sitemapObj);	
}
%>
