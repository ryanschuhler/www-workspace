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
String tabs1 = ParamUtil.getString(request, "tabs1", "details");

String redirect = ParamUtil.getString(request, "redirect", currentURL);

long marketingEventId = ParamUtil.getLong(request, "marketingEventId");

PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setParameter("mvcPath", "/admin/edit_marketing_event.jsp");
portletURL.setParameter("tabs1", tabs1);
portletURL.setParameter("redirect", redirect);
portletURL.setParameter("marketingEventId", String.valueOf(marketingEventId));

request.setAttribute("view.jsp-portletURL", portletURL);

MarketingEvent marketingEvent = MarketingEventLocalServiceUtil.fetchMarketingEvent(marketingEventId);

String marketingEventHeaderTitle = LanguageUtil.get(request, "marketing-event");

String tabsNames = "details";

if ((marketingEvent != null) && (marketingEvent.getType() == MarketingEventConstants.TYPE_CONFERENCE)) {
	marketingEventHeaderTitle = marketingEvent.getTitle(locale);

	tabsNames += ",sessions,users,rooms,sponsors,announcements";
}
%>

<liferay-ui:error exception="<%= RequiredMarketingEventSessionRoomException.class %>" message="the-room-cannot-be-deleted-because-it-has-associated-sessions" />
<liferay-ui:error exception="<%= RequiredMarketingEventSponsorLevelException.class %>" message="the-sponsor-level-cannot-be-deleted-because-it-has-associated-sponsors" />
<liferay-ui:error exception="<%= RequiredMarketingEventUserException.class %>" message="the-user-cannot-be-deleted-because-it-has-associated-sessions" />

<liferay-ui:header
	title="<%= marketingEventHeaderTitle %>"
/>

<liferay-ui:tabs
	backURL="<%= redirect %>"
	names="<%= tabsNames %>"
	param="tabs1"
	url="<%= portletURL.toString() %>"
/>

<c:choose>
	<c:when test='<%= tabs1.equals("announcements") %>'>
		<%@ include file="/admin/marketing_event_announcements.jspf" %>
	</c:when>
	<c:when test='<%= tabs1.equals("details") %>'>
		<%@ include file="/admin/marketing_event_details.jspf" %>
	</c:when>
	<c:when test='<%= tabs1.equals("rooms") %>'>
		<%@ include file="/admin/marketing_event_session_rooms.jspf" %>
	</c:when>
	<c:when test='<%= tabs1.equals("sessions") %>'>
		<%@ include file="/admin/marketing_event_sessions.jspf" %>
	</c:when>
	<c:when test='<%= tabs1.equals("sponsors") %>'>
		<%@ include file="/admin/marketing_event_sponsors.jspf" %>
	</c:when>
	<c:when test='<%= tabs1.equals("users") %>'>
		<%@ include file="/admin/marketing_event_users.jspf" %>
	</c:when>
</c:choose>