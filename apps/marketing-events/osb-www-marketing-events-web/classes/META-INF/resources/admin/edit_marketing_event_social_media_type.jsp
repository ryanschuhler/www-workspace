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

long socialLinkTypeId = ParamUtil.getLong(request, "socialLinkTypeId");

SocialLinkType socialLinkType = SocialLinkTypeLocalServiceUtil.fetchSocialLinkType(socialLinkTypeId);

long imageFileEntryId = BeanParamUtil.getLong(socialLinkType, request, "imageFileEntryId");

FileEntry imageFileEntry = null;

if (socialLinkType != null) {
	imageFileEntry = socialLinkType.getImageFileEntry();
}
%>

<liferay-ui:header
	backURL="<%= redirect %>"
	title="edit-social-media-type"
/>

<portlet:actionURL name="updateSocialLinkType" var="updateSocialLinkTypeURL">
	<portlet:param name="mvcPath" value="/admin/edit_marketing_event_social_media_type.jsp" />
</portlet:actionURL>

<aui:form action="<%= updateSocialLinkTypeURL %>" cssClass="edit-marketing-social-media-type" method="post" name="fm">
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="socialLinkTypeId" type="hidden" value="<%= socialLinkTypeId %>" />
	<aui:input name="imageFileEntryId" type="hidden" value="<%= imageFileEntryId %>" />

	<liferay-ui:error exception="<%= RequiredSocialLinkTypeException.class %>" message="the-social-media-type-cannot-be-deleted-because-it-has-associated-marketing-event-users" />

	<aui:model-context bean="<%= socialLinkType %>" model="<%= SocialLinkType.class %>" />

	<aui:fieldset>
		<aui:input name="name" required="true" />

		<div id="<portlet:namespace />socialMediaTypeImage">
			<strong><liferay-ui:message key="image" /></strong><br />

			<div id="<portlet:namespace />imageFileTitle">
				<%= (imageFileEntry == null) ? StringPool.BLANK : HtmlUtil.escape(imageFileEntry.getTitle()) %>
			</div>

			<aui:button-row>
				<aui:button onClick='<%= renderResponse.getNamespace() + "openSelectFileEntryWindow();" %>' value="select" />

				<aui:button onClick='<%= renderResponse.getNamespace() + "removeFileEntry();" %>' value="remove" />
			</aui:button-row>
		</div>

		<aui:button-row>
			<aui:button type="submit" value="save" />

			<aui:button href="<%= redirect %>" type="cancel" />
		</aui:button-row>
	</aui:fieldset>
</aui:form>

<aui:script>
	Liferay.provide(
		window,
		'<portlet:namespace />openSelectFileEntryWindow',
		function() {
			<liferay-portlet:renderURL portletName="<%= PortletKeys.DOCUMENT_LIBRARY %>" var="selectFileEntryURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
				<liferay-portlet:param name="struts_action" value="/document_library/select_file_entry" />
				<liferay-portlet:param name="folderId" value="<%= String.valueOf(DLFolderConstants.DEFAULT_PARENT_FOLDER_ID) %>" />
				<liferay-portlet:param name="groupId" value="<%= String.valueOf(OSBWWWMarketingEventsConstants.GROUP_GUEST_ID) %>" />
			</liferay-portlet:renderURL>

			Liferay.Util.selectEntity(
				{
					dialog: {
						constrain: true,
						destroyOnHide: true,
						modal: true
					},
					id: '<%= PortalUtil.getPortletNamespace(PortletKeys.DOCUMENT_LIBRARY) %>selectFileEntry_<%= OSBWWWMarketingEventsConstants.GROUP_GUEST_ID %>',
					title: '<liferay-ui:message key="select-file" />',
					uri: '<%= selectFileEntryURL %>'
				},
				function(event) {
					document.<portlet:namespace />fm.<portlet:namespace />imageFileEntryId.value = event.entryid;

					document.getElementById('<portlet:namespace />imageFileTitle').innerHTML = event.entryname;
				}
			);
		},
		['aui-base']
	);

	Liferay.provide(
		window,
		'<portlet:namespace />removeFileEntry',
		function() {
			document.<portlet:namespace />fm.<portlet:namespace />imageFileEntryId.value = 0;

			document.getElementById('<portlet:namespace />imageFileTitle').innerHTML = '';
		},
		['aui-base']
	);
</aui:script>