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

long marketingEventAnnouncementId = ParamUtil.getLong(request, "marketingEventAnnouncementId");

MarketingEventAnnouncement marketingEventAnnouncement = MarketingEventAnnouncementLocalServiceUtil.fetchMarketingEventAnnouncement(marketingEventAnnouncementId);

long marketingEventId = ParamUtil.getLong(request, "marketingEventId");

MarketingEvent marketingEvent = MarketingEventLocalServiceUtil.getMarketingEvent(marketingEventId);

long imageFileEntryId = BeanParamUtil.getLong(marketingEventAnnouncement, request, "imageFileEntryId");

TimeZone marketingEventTimeZone = TimeZoneUtil.getTimeZone(marketingEvent.getTimeZoneId());

Calendar displayDate = CalendarFactoryUtil.getCalendar(marketingEventTimeZone, locale);

if ((marketingEventAnnouncement != null) && (marketingEventAnnouncement.getDisplayDate() != null)) {
	displayDate.setTime(marketingEventAnnouncement.getDisplayDate());
}
%>

<liferay-ui:header
	backURL="<%= redirect %>"
	title="edit-announcement"
/>

<portlet:actionURL name="updateMarketingEventAnnouncement" var="updateMarketingEventAnnouncementURL" />

<aui:form action="<%= updateMarketingEventAnnouncementURL %>" cssClass="edit-marketing-event-announcement" method="post" name="fm">
	<aui:input name="mvcPath" type="hidden" value="/admin/edit_marketing_event_announcement.jsp" />
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="marketingEventAnnouncementId" type="hidden" value="<%= marketingEventAnnouncementId %>" />
	<aui:input name="marketingEventId" type="hidden" value="<%= marketingEventId %>" />
	<aui:input name="imageFileEntryId" type="hidden" value="<%= imageFileEntryId %>" />

	<liferay-ui:error exception="<%= MarketingEventAnnouncementDisplayDateException.class %>" message="please-enter-a-valid-display-date" />
	<liferay-ui:error exception="<%= MarketingEventAnnouncementLinkLabelException.class %>" message="please-enter-a-valid-link-label" />
	<liferay-ui:error exception="<%= MarketingEventAnnouncementLinkURLException.class %>" message="please-enter-a-valid-link-url" />
	<liferay-ui:error exception="<%= MarketingEventAnnouncementMessageException.class %>" message="please-enter-a-valid-message" />
	<liferay-ui:error exception="<%= MarketingEventAnnouncementTitleException.class %>" message="please-enter-a-valid-title" />

	<aui:model-context bean="<%= marketingEventAnnouncement %>" model="<%= MarketingEventAnnouncement.class %>" />

	<aui:fieldset>
		<aui:input name="title" />

		<aui:input name="message" type="textarea" />

		<aui:input name="summary" type="textarea" />

		<div id="<portlet:namespace />announcementImage">
			<liferay-ui:message key="image" /><br />

			<div id="<portlet:namespace />imageFileTitle">

				<%
				FileEntry imageFileEntry = null;

				if (marketingEventAnnouncement != null) {
					imageFileEntry = marketingEventAnnouncement.getImageFileEntry();
				}
				%>

				<%= (imageFileEntry == null) ? StringPool.BLANK : HtmlUtil.escape(imageFileEntry.getTitle()) %>
			</div>

			<aui:button-row>

				<%
				String taglibSelectSlidesFileEntryWindow = renderResponse.getNamespace() + "openSelectFileEntryWindow('" + renderResponse.getNamespace() + "imageFileEntryId','" + renderResponse.getNamespace() + "imageFileTitle');";
				%>

				<aui:button onClick="<%= taglibSelectSlidesFileEntryWindow %>" value="select" />

				<%
				String taglibRemoveImageFileEntry = renderResponse.getNamespace() + "removeFileEntry('" + renderResponse.getNamespace() + "imageFileEntryId','" + renderResponse.getNamespace() + "imageFileTitle');";
				%>

				<aui:button onClick="<%= taglibRemoveImageFileEntry %>" value="remove" />
			</aui:button-row>
		</div>

		<%
		boolean isDefaultURL = (marketingEventAnnouncement != null) && Validator.isNotNull(marketingEventAnnouncement.getLinkURL()) && !Validator.isUrl(marketingEventAnnouncement.getLinkURL());
		%>

		<aui:input name="linkLabel" />

		<aui:input cssClass='<%= isDefaultURL ? "hide span12" : "span12" %>' helpMessage="urls-must-start-with-http-or-https" name="linkURL" />

		<aui:select cssClass='<%= isDefaultURL ? StringPool.BLANK : "hide" %>' label="" name="defaultLinkURL" onChange='<%= renderResponse.getNamespace() + "selectDefaultLinkURL(value);" %>'>
			<aui:option value="" />

			<%
			for (MarketingEventSession marketingEventSession : MarketingEventSessionLocalServiceUtil.getMarketingEventSessions(marketingEventId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			%>

				<aui:option label="<%= marketingEventSession.getTitle() %>" selected="<%= (marketingEventAnnouncement != null) && StringUtil.endsWith(marketingEventAnnouncement.getLinkURL(), String.valueOf(marketingEventSession.getMarketingEventSessionId())) %>" value="<%= marketingEventSession.getRemoteURL() %>" />

			<%
			}
			%>

		</aui:select>

		<aui:input checked="<%= isDefaultURL %>" name="enableDefaultLinkURL" onClick='<%= renderResponse.getNamespace() + "setDefaultLinkURL(this.checked);" %>' type="checkbox" />

		<aui:input name="displayDate" value="<%= displayDate %>" />

		<aui:select label="status" name="status">

			<%
			for (int curStatus : MarketingEventAnnouncementConstants.STATUSES) {
			%>

				<aui:option label="<%= WorkflowConstants.getStatusLabel(curStatus) %>" selected="<%= (marketingEventAnnouncement != null) ? (curStatus == marketingEventAnnouncement.getStatus()) : (curStatus == WorkflowConstants.STATUS_DRAFT) %>" value="<%= curStatus %>" />

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

<aui:script>
	Liferay.provide(
		window,
		'<portlet:namespace />setDefaultLinkURL',
		function(isDefaultURL) {
			A = AUI();

			var defaultLinkURL = A.one('#<portlet:namespace />defaultLinkURL');
			var linkURL = A.one('#<portlet:namespace />linkURL');

			if (isDefaultURL) {
				defaultLinkURL.show();
				linkURL.hide();
			}
			else {
				defaultLinkURL.hide();
				linkURL.show();
			}
		},
		['aui-base']
	);

	Liferay.provide(
		window,
		'<portlet:namespace />openSelectFileEntryWindow',
		function(id, title) {

			<%
			long marketingEventSiteGroupId = OSBWWWMarketingEventsConstants.GROUP_GUEST_ID;

			if ((marketingEvent != null) && (marketingEvent.getSiteGroupId() > 0)) {
				marketingEventSiteGroupId = marketingEvent.getSiteGroupId();
			}
			%>

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
					document.<portlet:namespace />fm[id].value = event.entryid;

					document.getElementById(title).innerHTML = event.entryname;
				}
			);
		},
		['aui-base']
	);

	Liferay.provide(
		window,
		'<portlet:namespace />removeFileEntry',
		function(id, title) {
			document.<portlet:namespace />fm[id].value = 0;

			document.getElementById(title).innerHTML = '';
		},
		['aui-base']
	);

	Liferay.provide(
		window,
		'<portlet:namespace />selectDefaultLinkURL',
		function(url) {
			A = AUI();

			var linkURL = A.one('#<portlet:namespace />linkURL');

			linkURL.set('value', url);
		},
		['aui-base']
	);
</aui:script>