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
String redirect = ParamUtil.getString(request, "redirect");

PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setParameter("mvcPath", "/admin/edit_settings.jsp");
portletURL.setParameter("redirect", redirect);

request.setAttribute("edit_settings.jsp-portletURL", portletURL);
%>

<liferay-ui:header
	backURL="<%= redirect %>"
	title="settings"
/>

<liferay-ui:panel collapsible="<%= true %>" extended="<%= false %>" helpMessage="social-media-types-help" persistState="<%= true %>" title="social-media-types">
	<liferay-ui:search-container
		curParam="cur2"
		headerNames="name"
		iteratorURL="<%= portletURL %>"
		total="<%= SocialLinkTypeLocalServiceUtil.getSocialLinkTypesCount() %>"
	>
		<liferay-ui:search-container-results
			results="<%= SocialLinkTypeLocalServiceUtil.getSocialLinkTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS) %>"
		/>

		<liferay-ui:search-container-row
			className="com.liferay.osb.www.marketing.events.model.SocialLinkType"
			keyProperty="socialLinkTypeId"
			modelVar="curSocialLinkType"
		>
			<liferay-portlet:renderURL var="editMarketingEventSocialMediaTypeURL">
				<portlet:param name="mvcPath" value="/admin/edit_marketing_event_social_media_type.jsp" />
				<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
				<portlet:param name="socialLinkTypeId" value="<%= String.valueOf(curSocialLinkType.getSocialLinkTypeId()) %>" />
			</liferay-portlet:renderURL>

			<liferay-ui:search-container-column-text
				href="<%= editMarketingEventSocialMediaTypeURL %>"
				name="name"
				value="<%= HtmlUtil.escape(curSocialLinkType.getName()) %>"
			/>

			<liferay-ui:search-container-column-text
				name="image"
			>

				<%
				FileEntry imageFileEntry = curSocialLinkType.getImageFileEntry();
				%>

				<c:if test="<%= imageFileEntry != null %>">
					<img height="auto" src="<%= themeDisplay.getPathContext() + "/documents/" + imageFileEntry.getRepositoryId() + "/" + imageFileEntry.getFolderId() + "/" + HttpUtil.encodeURL(imageFileEntry.getTitle()) + "/" + imageFileEntry.getUuid() %>" width="25" />
				</c:if>
			</liferay-ui:search-container-column-text>

			<liferay-ui:search-container-column-jsp
				align="right"
				path="/admin/marketing_event_social_media_type_action.jsp"
			/>
		</liferay-ui:search-container-row>

		<aui:button-row>
			<liferay-portlet:renderURL var="addMarketingEventSocialMediaTypeURL">
				<portlet:param name="mvcPath" value="/admin/edit_marketing_event_social_media_type.jsp" />
				<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
			</liferay-portlet:renderURL>

			<aui:button href="<%= addMarketingEventSocialMediaTypeURL %>" value="add-social-media-type" />
		</aui:button-row>

		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</liferay-ui:panel>