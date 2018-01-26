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
MarketingEventUser marketingEventUser = (MarketingEventUser)request.getAttribute(OSBWWWMarketingEventsWebKeys.MARKETING_EVENT_USER);
%>

<h4>
	<liferay-ui:message key="first-name" />
</h4>

<p>
	<%= HtmlUtil.escape(marketingEventUser.getFirstName()) %>
</p>

<h4>
	<liferay-ui:message key="last-name" />
</h4>

<p>
	<%= HtmlUtil.escape(marketingEventUser.getLastName()) %>
</p>

<h4>
	<liferay-ui:message key="company-name" />
</h4>

<p>
	<%= HtmlUtil.escape(marketingEventUser.getCompanyName()) %>
</p>

<h4>
	<liferay-ui:message key="description" />
</h4>

<p>
	<%= marketingEventUser.getDescription(locale) %>
</p>