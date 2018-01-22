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

SocialLink socialLink = (SocialLink)row.getObject();

PortletURL portletURL = (PortletURL)request.getAttribute("edit_marketing_event_user.jsp-portletURL");
%>

<liferay-ui:icon-menu>
	<portlet:renderURL var="editSocialLinkURL" windowState="<%= WindowState.MAXIMIZED.toString() %>">
		<portlet:param name="mvcPath" value="/admin/edit_social_link.jsp" />
		<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
		<portlet:param name="socialLinkId" value="<%= String.valueOf(socialLink.getSocialLinkId()) %>" />
		<portlet:param name="marketingEventUserId" value="<%= String.valueOf(socialLink.getMarketingEventUserId()) %>" />
	</portlet:renderURL>

	<liferay-ui:icon
		image="edit"
		url="<%= editSocialLinkURL %>"
	/>

	<portlet:actionURL name="deleteSocialLink" var="deleteSocialLinkURL" windowState="<%= WindowState.MAXIMIZED.toString() %>">
		<portlet:param name="tabs1" value="social-media" />
		<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
		<portlet:param name="socialLinkId" value="<%= String.valueOf(socialLink.getSocialLinkId()) %>" />
	</portlet:actionURL>

	<liferay-ui:icon-delete
		url="<%= deleteSocialLinkURL %>"
	/>
</liferay-ui:icon-menu>