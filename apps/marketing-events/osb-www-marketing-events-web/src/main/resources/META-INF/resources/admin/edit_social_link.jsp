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

long socialLinkId = ParamUtil.getLong(request, "socialLinkId");

SocialLink socialLink = SocialLinkLocalServiceUtil.fetchSocialLink(socialLinkId);

long marketingEventUserId = ParamUtil.getLong(request, "marketingEventUserId");
%>

<liferay-ui:header
	backURL="<%= redirect %>"
	title="edit-social-media-link"
/>

<portlet:actionURL name="updateSocialLink" var="updateSocialLinkURL">
	<portlet:param name="mvcPath" value="/admin/edit_social_link.jsp" />
</portlet:actionURL>

<aui:form action="<%= updateSocialLinkURL %>" cssClass="edit-marketing-user-social-link" method="post" name="fm">
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="socialLinkId" type="hidden" value="<%= socialLinkId %>" />
	<aui:input name="marketingEventUserId" type="hidden" value="<%= marketingEventUserId %>" />

	<liferay-ui:error exception="<%= DuplicateSocialLinkTypeException.class %>" message="unable-to-add-multiple-social-links-of-the-same-type" />
	<liferay-ui:error exception="<%= SocialLinkURLException.class %>" message="please-enter-a-valid-url" />

	<aui:model-context bean="<%= socialLink %>" model="<%= SocialLink.class %>" />

	<aui:fieldset>
		<aui:input cssClass="span12" helpMessage="urls-must-start-with-http-or-https" name="url" placeholder="enter-profile-url" />

		<aui:select label="social-media-type" name="socialLinkTypeId">

			<%
			for (SocialLinkType socialLinkType : SocialLinkTypeLocalServiceUtil.getSocialLinkTypes(0, SocialLinkTypeLocalServiceUtil.getSocialLinkTypesCount())) {
			%>

				<aui:option label="<%= socialLinkType.getName() %>" selected="<%= (socialLink != null) && (socialLinkType.getSocialLinkTypeId() == socialLink.getSocialLinkTypeId()) %>" value="<%= socialLinkType.getSocialLinkTypeId() %>" />

			<%
			}
			%>

		</aui:select>

		<aui:button-row>
			<aui:button type="submit" value="save" />

			<aui:button href="<%= redirect %>" type="cancel" />
		</aui:button-row>
	</aui:fieldset>
</aui:form>