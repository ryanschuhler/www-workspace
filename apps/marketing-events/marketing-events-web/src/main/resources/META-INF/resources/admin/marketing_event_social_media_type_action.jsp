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

SocialLinkType socialLinkType = (SocialLinkType)row.getObject();

PortletURL portletURL = (PortletURL)request.getAttribute("edit_settings.jsp-portletURL");
%>

<liferay-ui:icon-menu>
	<portlet:renderURL var="editMarketingEventSocialMediaTypeURL" windowState="<%= WindowState.MAXIMIZED.toString() %>">
		<portlet:param name="mvcPath" value="/admin/edit_marketing_event_social_media_type.jsp" />
		<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
		<portlet:param name="socialLinkTypeId" value="<%= String.valueOf(socialLinkType.getSocialLinkTypeId()) %>" />
	</portlet:renderURL>

	<liferay-ui:icon
		image="edit"
		url="<%= editMarketingEventSocialMediaTypeURL %>"
	/>

	<portlet:actionURL name="deleteSocialLinkType" var="deleteSocialMediaTypeURL" windowState="<%= WindowState.MAXIMIZED.toString() %>">
		<portlet:param name="tabs1" value="socialLink" />
		<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
		<portlet:param name="socialLinkTypeId" value="<%= String.valueOf(socialLinkType.getSocialLinkTypeId()) %>" />
	</portlet:actionURL>

	<liferay-ui:icon-delete
		url="<%= deleteSocialMediaTypeURL %>"
	/>
</liferay-ui:icon-menu>