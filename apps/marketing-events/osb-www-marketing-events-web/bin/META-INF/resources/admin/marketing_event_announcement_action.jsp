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

MarketingEventAnnouncement marketingEventAnnouncement = (MarketingEventAnnouncement)row.getObject();

PortletURL portletURL = (PortletURL)request.getAttribute("view.jsp-portletURL");
%>

<liferay-ui:icon-menu>
	<portlet:renderURL var="editMarketingEventAnnouncementURL" windowState="<%= WindowState.MAXIMIZED.toString() %>">
		<portlet:param name="mvcPath" value="/admin/edit_marketing_event_announcement.jsp" />
		<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
		<portlet:param name="marketingEventAnnouncementId" value="<%= String.valueOf(marketingEventAnnouncement.getMarketingEventAnnouncementId()) %>" />
		<portlet:param name="marketingEventId" value="<%= String.valueOf(marketingEventAnnouncement.getMarketingEventId()) %>" />
	</portlet:renderURL>

	<liferay-ui:icon
		image="edit"
		url="<%= editMarketingEventAnnouncementURL %>"
	/>

	<portlet:actionURL name="deleteMarketingEventAnnouncement" var="deleteMarketingEventAnnouncementURL" windowState="<%= WindowState.MAXIMIZED.toString() %>">
		<portlet:param name="tabs1" value="announcements" />
		<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
		<portlet:param name="marketingEventAnnouncementId" value="<%= String.valueOf(marketingEventAnnouncement.getMarketingEventAnnouncementId()) %>" />
	</portlet:actionURL>

	<liferay-ui:icon-delete
		url="<%= deleteMarketingEventAnnouncementURL %>"
	/>
</liferay-ui:icon-menu>