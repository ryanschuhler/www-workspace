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
page import="com.liferay.portal.kernel.util.GetterUtil" %>



<%
Object portalObj = renderRequest.getAttribute(Portal.class.getName());
Portal portal = null;
if (portalObj != null) {
	portal = (Portal)GetterUtil.getObject(portalObj);
}
%>
