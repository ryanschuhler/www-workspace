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

<%@ include file="/init.jsp" %>

<%
String tabs1 = ParamUtil.getString(request, "tabs1", "general");

String redirect = ParamUtil.getString(request, "redirect");

long marketingEventUserId = ParamUtil.getLong(request, "marketingEventUserId");

MarketingEventUser marketingEventUser = MarketingEventUserLocalServiceUtil.fetchMarketingEventUser(marketingEventUserId);

long marketingEventId = ParamUtil.getLong(request, "marketingEventId");

MarketingEvent marketingEvent = MarketingEventLocalServiceUtil.fetchMarketingEvent(marketingEventId);

PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setParameter("mvcPath", "/admin/edit_marketing_event_user.jsp");
portletURL.setParameter("tabs1", tabs1);
portletURL.setParameter("redirect", redirect);
portletURL.setParameter("marketingEventUserId", String.valueOf(marketingEventUserId));
portletURL.setParameter("marketingEventId", String.valueOf(marketingEventId));

request.setAttribute("edit_marketing_event_user.jsp-portletURL", portletURL);
%>

<liferay-ui:header
	backURL="<%= redirect %>"
	title="edit-user"
/>

<liferay-ui:tabs
	names="general,social-media"
	param="tabs1"
	url="<%= portletURL.toString() %>"
/>

<c:choose>
	<c:when test='<%= tabs1.equals("general") %>'>
		<%@ include file="/admin/edit_marketing_event_user_general.jspf" %>
	</c:when>
	<c:when test='<%= tabs1.equals("social-media") %>'>
		<%@ include file="/admin/edit_marketing_event_user_social_links.jspf" %>
	</c:when>
</c:choose>