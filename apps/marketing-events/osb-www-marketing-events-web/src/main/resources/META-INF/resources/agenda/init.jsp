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

<%@ page import="com.liferay.osb.www.marketing.events.model.MarketingEventAgendaDisplay" %><%@
page import="com.liferay.osb.www.marketing.events.util.MarketingEventAgendaDisplayContext" %><%@
page import="com.liferay.osb.www.marketing.events.util.MarketingEventDateFormat" %><%@
page import="com.liferay.osb.www.marketing.events.util.MarketingEventSessionLogoType" %>

<%
MarketingEventAgendaDisplayContext marketingEventAgendaDisplayContext = (MarketingEventAgendaDisplayContext)request.getAttribute(WebKeys.MARKETING_EVENT_AGENDA_DISPLAY_CONTEXT);

MarketingEventAgendaDisplay marketingEventAgendaDisplay = marketingEventAgendaDisplayContext.getMarketingEventAgendaDisplay();

boolean enableCustomAgendaDateFormat = (marketingEventAgendaDisplayContext.getMarketingEventDateFormat() == MarketingEventDateFormat.CUSTOM);
%>