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

MarketingEventSessionRoom marketingEventSessionRoom = (MarketingEventSessionRoom)row.getObject();

PortletURL portletURL = (PortletURL)request.getAttribute("view.jsp-portletURL");
%>

<liferay-ui:icon-menu>
	<portlet:renderURL var="editMarketingEventSessionRoomURL" windowState="<%= WindowState.MAXIMIZED.toString() %>">
		<portlet:param name="mvcPath" value="/admin/edit_marketing_event_session_room.jsp" />
		<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
		<portlet:param name="marketingEventSessionRoomId" value="<%= String.valueOf(marketingEventSessionRoom.getMarketingEventSessionRoomId()) %>" />
		<portlet:param name="marketingEventId" value="<%= String.valueOf(marketingEventSessionRoom.getMarketingEventId()) %>" />
	</portlet:renderURL>

	<liferay-ui:icon
		image="edit"
		url="<%= editMarketingEventSessionRoomURL %>"
	/>

	<portlet:actionURL name="deleteMarketingEventSessionRoom" var="deleteMarketingEventSessionRoomURL" windowState="<%= WindowState.MAXIMIZED.toString() %>">
		<portlet:param name="tabs1" value="rooms" />
		<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
		<portlet:param name="marketingEventSessionRoomId" value="<%= String.valueOf(marketingEventSessionRoom.getMarketingEventSessionRoomId()) %>" />
	</portlet:actionURL>

	<liferay-ui:icon-delete
		url="<%= deleteMarketingEventSessionRoomURL %>"
	/>
</liferay-ui:icon-menu>