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
MarketingEvent marketingEvent = MarketingEventLocalServiceUtil.getSiteGroupMarketingEvent(themeDisplay.getSiteGroupId());
%>

<c:choose>
	<c:when test="<%= marketingEvent != null %>">
		<liferay-util:include page="/admin/edit_marketing_event.jsp" servletContext="<%= application %>">
			<liferay-util:param name="marketingEventId" value="<%= String.valueOf(marketingEvent.getMarketingEventId()) %>" />
		</liferay-util:include>
	</c:when>
	<c:otherwise>
		<liferay-util:include page="/admin/marketing_events.jsp" servletContext="<%= application %>" />
	</c:otherwise>
</c:choose>