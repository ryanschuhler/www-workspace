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

long marketingEventSessionRoomId = ParamUtil.getLong(request, "marketingEventSessionRoomId");

MarketingEventSessionRoom marketingEventSessionRoom = MarketingEventSessionRoomLocalServiceUtil.fetchMarketingEventSessionRoom(marketingEventSessionRoomId);

long marketingEventId = ParamUtil.getLong(request, "marketingEventId");

MarketingEvent marketingEvent = MarketingEventLocalServiceUtil.fetchMarketingEvent(marketingEventId);

long marketingEventSiteGroupId = OSBWWWMarketingEventsConstants.GROUP_GUEST_ID;

if ((marketingEvent != null) && (marketingEvent.getSiteGroupId() > 0)) {
	marketingEventSiteGroupId = marketingEvent.getSiteGroupId();
}

long imageFileEntryId = BeanParamUtil.getLong(marketingEventSessionRoom, request, "imageFileEntryId");

FileEntry imageFileEntry = null;

if (marketingEventSessionRoom != null) {
	imageFileEntry = marketingEventSessionRoom.getImageFileEntry();
}
%>

<liferay-ui:header
	backURL="<%= redirect %>"
	title="edit-room"
/>

<portlet:actionURL name="updateMarketingEventSessionRoom" var="updateMarketingEventSessionRoomURL">
	<portlet:param name="mvcPath" value="/admin/edit_marketing_event_session_room.jsp" />
</portlet:actionURL>

<aui:form action="<%= updateMarketingEventSessionRoomURL %>" cssClass="edit-marketing-event-session" method="post" name="fm">
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="marketingEventSessionRoomId" type="hidden" value="<%= marketingEventSessionRoomId %>" />
	<aui:input name="marketingEventId" type="hidden" value="<%= marketingEventId %>" />
	<aui:input name="imageFileEntryId" type="hidden" value="<%= imageFileEntryId %>" />

	<liferay-ui:error exception="<%= MarketingEventSessionRoomNameException.class %>" message="please-enter-a-valid-room" />
	<liferay-ui:error exception="<%= RequiredMarketingEventSessionRoomException.class %>" message="the-room-cannot-be-deleted-because-it-has-associated-sessions" />

	<aui:model-context bean="<%= marketingEventSessionRoom %>" model="<%= MarketingEventSessionRoom.class %>" />

	<aui:fieldset>
		<aui:input name="name" />

		<div id="<portlet:namespace />eventImage">
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
				<liferay-portlet:param name="groupId" value="<%= String.valueOf(marketingEventSiteGroupId) %>" />
			</liferay-portlet:renderURL>

			Liferay.Util.selectEntity(
				{
					dialog: {
						constrain: true,
						destroyOnHide: true,
						modal: true
					},
					id: '<%= PortalUtil.getPortletNamespace(PortletKeys.DOCUMENT_LIBRARY) %>selectFileEntry_<%= marketingEventSiteGroupId %>',
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