<%--
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
--%>

<%@ include file="/html/portal/init.jsp" %>

<%
int status = ParamUtil.getInteger(request, "status");

if (status > 0) {
	response.setStatus(status);
}

String exception = ParamUtil.getString(request, "exception");

String url = ParamUtil.getString(request, "previousURL");

if (Validator.isNull(url)) {
	url = PortalUtil.getCurrentURL(request);
}

url = themeDisplay.getPortalURL() + url;

boolean noSuchResourceException = false;

for (String key : SessionErrors.keySet(request)) {
	key = key.substring(key.lastIndexOf(StringPool.PERIOD) + 1);

	if (key.startsWith("NoSuch") && key.endsWith("Exception")) {
		noSuchResourceException = true;
	}
}

if (Validator.isNotNull(exception)) {
	exception = exception.substring(exception.lastIndexOf(StringPool.PERIOD) + 1);

	if (exception.startsWith("NoSuch") && exception.endsWith("Exception")) {
		noSuchResourceException = true;
	}
}
%>

<c:choose>
	<c:when test="<%= noSuchResourceException %>">
		<div class="block-container">
			<div class="block error-image left-block w35">
				<img src="<%= PortalUtil.getPathContext() %>/portlet_unavailable.png" />
			</div>

			<div class="block error-content responsive-text-center right-block w65">
				<h2 class="alt-secondary-color">
					<liferay-ui:message key="were-sorry-the-page-you-requested-was-not-found" />
				</h2>

				<div class="error-url"><%= HtmlUtil.escape(url) %></div>

				<%
				String portletId = "1_WAR_googlesearchapplianceportlet_INSTANCE_0000";
				String portletNamespace = "_" + portletId + "_";
				String keywords = ParamUtil.getString(request, portletNamespace + "keywords");
				%>

				<form action="<%= PortalUtil.getLayoutFullURL(themeDisplay) %>" class="doc-search" method="get" name="<%= portletNamespace %>hookFm">
					<input name="p_p_id" type="hidden" value="<%= portletId %>" />
					<input name="p_p_lifecycle" type="hidden" value="0" />
					<input name="p_p_state" type="hidden" value="maximized" />

					<input class="doc-search-input" name="<%= portletNamespace %>keywords" required type="text" value="<%= HtmlUtil.escapeAttribute(keywords) %>" />

					<input class="btn btn-sm" type="submit" value='<liferay-ui:message key="search" />'>
				</form>

				<ul class="suggested-links">
					<li>
						<a class="standard-padding" href="/community">
							<liferay-ui:message key="explore-the-liferay-community" />
						</a>
					</li>
					<li>
						<a class="standard-padding" href="/downloads">
							<liferay-ui:message key="available-software-downloads" />
						</a>
					</li>
					<li>
						<a class="standard-padding" href="/marketplace">
							<liferay-ui:message key="buy-and-sell-marketplace-apps" />
						</a>
					</li>
					<li>
						<a class="standard-padding" href="/product">
							<liferay-ui:message key="product-overview" />
						</a>
					</li>
					<li>
						<a class="standard-padding" href="/resources">
							<liferay-ui:message key="read-a-whitepaper" />
						</a>
					</li>
					<li>
						<a class="standard-padding" href="/events">
							<liferay-ui:message key="attend-an-event" />
						</a>
					</li>
				</ul>
			</div>
		</div>

		<div class="separator"><!-- --></div>

		<a href="javascript:history.go(-1);">&laquo; <liferay-ui:message key="back" /></a>
	</c:when>
	<c:otherwise>
		<liferay-util:include page="/html/portal/status.portal.jsp" />
	</c:otherwise>
</c:choose>