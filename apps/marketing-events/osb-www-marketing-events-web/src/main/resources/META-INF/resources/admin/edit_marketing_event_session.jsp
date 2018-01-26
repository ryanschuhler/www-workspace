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

long marketingEventSessionId = ParamUtil.getLong(request, "marketingEventSessionId");

MarketingEventSession marketingEventSession = MarketingEventSessionLocalServiceUtil.fetchMarketingEventSession(marketingEventSessionId);

long marketingEventId = ParamUtil.getLong(request, "marketingEventId");

MarketingEvent marketingEvent = MarketingEventLocalServiceUtil.getMarketingEvent(marketingEventId);

long slidesFileEntryId = BeanParamUtil.getLong(marketingEventSession, request, "slidesFileEntryId");

TimeZone marketingEventTimeZone = TimeZoneUtil.getTimeZone(marketingEvent.getTimeZoneId());

Calendar startDate = CalendarFactoryUtil.getCalendar(marketingEventTimeZone, locale);

if ((marketingEventSession != null) && (marketingEventSession.getStartDate() != null)) {
	startDate.setTime(marketingEventSession.getStartDate());
}
else {
	startDate.setTime(marketingEvent.getStartDate());

	startDate.set(Calendar.HOUR_OF_DAY, 9);
	startDate.set(Calendar.MINUTE, 0);
}

Calendar endDate = (Calendar)startDate.clone();

if ((marketingEventSession != null) && (marketingEventSession.getEndDate() != null)) {
	endDate.setTime(marketingEventSession.getEndDate());
}
else {
	endDate.set(Calendar.HOUR_OF_DAY, 10);
}
%>

<liferay-ui:header
	backURL="<%= redirect %>"
	title="edit-session"
/>

<portlet:actionURL name="updateMarketingEventSession" var="updateMarketingEventSessionURL" />

<aui:form action="<%= updateMarketingEventSessionURL %>" cssClass="edit-marketing-event-session" method="post" name="fm">
	<aui:input name="mvcPath" type="hidden" value="/admin/edit_marketing_event_session.jsp" />
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="marketingEventSessionId" type="hidden" value="<%= marketingEventSessionId %>" />
	<aui:input name="marketingEventId" type="hidden" value="<%= marketingEventId %>" />
	<aui:input name="slidesFileEntryId" type="hidden" value="<%= slidesFileEntryId %>" />

	<liferay-ui:error exception="<%= MarketingEventSessionStartDateException.class %>" message="please-enter-a-valid-start-date" />
	<liferay-ui:error exception="<%= MarketingEventSessionTitleException.class %>" message="please-enter-a-valid-title" />
	<liferay-ui:error exception="<%= MarketingEventSessionVideoURLException.class %>" message="please-enter-a-valid-url" />

	<liferay-ui:asset-categories-error />

	<liferay-ui:asset-tags-error />

	<aui:model-context bean="<%= marketingEventSession %>" model="<%= MarketingEventSession.class %>" />

	<aui:fieldset>
		<aui:input cssClass="span12" name="title" />

		<aui:input cssClass="span12" localized="true" name="description" type="textarea" />

		<aui:input name="keywords" />

		<label class="field-label" for="<portlet:namespace />marketingEventUserIds"><liferay-ui:message key="speakers" /></label>

		<select multiple="true" name="<portlet:namespace />marketingEventUserIds">

			<%
			for (MarketingEventUser marketingEventUser : MarketingEventUserLocalServiceUtil.getMarketingEventUsers(marketingEventId, WorkflowConstants.STATUS_ANY, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			%>

				<option <%= ((marketingEventSession != null) && ArrayUtil.contains(marketingEventSession.getMarketingEventUserIds(), marketingEventUser.getMarketingEventUserId())) ? "selected" : StringPool.BLANK %> value="<%= marketingEventUser.getMarketingEventUserId() %>">
					<%= StringUtil.add(marketingEventUser.getFirstName(), marketingEventUser.getLastName(), StringPool.SPACE, true) %>
				</option>

			<%
			}
			%>

		</select>

		<aui:select label="room" name="marketingEventSessionRoomId">
			<aui:option value="" />

			<%
			for (MarketingEventSessionRoom marketingEventSessionRoom : MarketingEventSessionRoomLocalServiceUtil.getMarketingEventSessionRooms(marketingEventId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			%>

				<aui:option label="<%= marketingEventSessionRoom.getName() %>" selected="<%= (marketingEventSession != null) && (marketingEventSession.getMarketingEventSessionRoomId() == marketingEventSessionRoom.getMarketingEventSessionRoomId()) %>" value="<%= marketingEventSessionRoom.getMarketingEventSessionRoomId() %>" />

			<%
			}
			%>

		</aui:select>

		<div id="<portlet:namespace />eventSlides">
			<liferay-ui:message key="slides" /><br />

			<div id="<portlet:namespace />slidesFileTitle">

				<%
				FileEntry slidesFileEntry = null;

				if (marketingEventSession != null) {
					slidesFileEntry = marketingEventSession.getSlidesFileEntry();
				}
				%>

				<%= (slidesFileEntry == null) ? StringPool.BLANK : HtmlUtil.escape(slidesFileEntry.getTitle()) %>
			</div>

			<aui:button-row>

				<%
				String taglibSelectSlidesFileEntryWindow = renderResponse.getNamespace() + "openSelectFileEntryWindow('" + renderResponse.getNamespace() + "slidesFileEntryId','" + renderResponse.getNamespace() + "slidesFileTitle');";
				%>

				<aui:button onClick="<%= taglibSelectSlidesFileEntryWindow %>" value="select" />

				<%
				String taglibRemoveSlidesFileEntry = renderResponse.getNamespace() + "removeFileEntry('" + renderResponse.getNamespace() + "slidesFileEntryId','" + renderResponse.getNamespace() + "slidesFileTitle');";
				%>

				<aui:button onClick="<%= taglibRemoveSlidesFileEntry %>" value="remove" />
			</aui:button-row>
		</div>

		<aui:input cssClass="span12" helpMessage="urls-must-start-with-http-or-https" name="videoURL" />

		<aui:input name="startDate" value="<%= startDate %>" />

		<aui:input name="endDate" value="<%= endDate %>" />

		<aui:select label="status" name="status">

			<%
			for (int curStatus : MarketingEventSessionConstants.STATUSES) {
			%>

				<aui:option label="<%= WorkflowConstants.getStatusLabel(curStatus) %>" selected="<%= (marketingEventSession != null) ? (curStatus == marketingEventSession.getStatus()) : (curStatus == WorkflowConstants.STATUS_DRAFT) %>" value="<%= curStatus %>" />

			<%
			}
			%>

		</aui:select>

		<liferay-ui:panel defaultState="open" extended="<%= false %>" id="marketingEventSessionCategorizationPanel" persistState="<%= true %>" title="categorization">
			<aui:fieldset>
				<aui:input groupIds="<%= marketingEvent.getSiteGroupId() %>" name="categories" type="assetCategories" />
			</aui:fieldset>
		</liferay-ui:panel>
		
		<liferay-ui:panel defaultState="open" extended="<%= false %>" id="marketingEventSessionAssetLinksPanel" persistState="<%= true %>" title="related-assets">
			<liferay-ui:input-asset-links
				className="<%= MarketingEventSession.class.getName() %>"
				classPK="<%= marketingEventSessionId %>"
			/>
		</liferay-ui:panel>

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
</aui:script>