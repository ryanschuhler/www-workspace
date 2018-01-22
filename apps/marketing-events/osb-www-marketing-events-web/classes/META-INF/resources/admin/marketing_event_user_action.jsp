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
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

MarketingEventUser marketingEventUser = (MarketingEventUser)row.getObject();

PortletURL portletURL = (PortletURL)request.getAttribute("view.jsp-portletURL");
%>

<liferay-ui:icon-menu>
	<portlet:renderURL var="editMarketingEventUserURL" windowState="<%= WindowState.MAXIMIZED.toString() %>">
		<portlet:param name="mvcPath" value="/admin/edit_marketing_event_user.jsp" />
		<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
		<portlet:param name="marketingEventUserId" value="<%= String.valueOf(marketingEventUser.getMarketingEventUserId()) %>" />
		<portlet:param name="marketingEventId" value="<%= String.valueOf(marketingEventUser.getMarketingEventId()) %>" />
	</portlet:renderURL>

	<liferay-ui:icon
		image="edit"
		url="<%= editMarketingEventUserURL %>"
	/>

	<portlet:actionURL name="deleteMarketingEventUser" var="deleteMarketingEventUserURL" windowState="<%= WindowState.MAXIMIZED.toString() %>">
		<portlet:param name="tabs1" value="users" />
		<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
		<portlet:param name="marketingEventUserId" value="<%= String.valueOf(marketingEventUser.getMarketingEventUserId()) %>" />
	</portlet:actionURL>

	<liferay-ui:icon-delete
		url="<%= deleteMarketingEventUserURL %>"
	/>
</liferay-ui:icon-menu>