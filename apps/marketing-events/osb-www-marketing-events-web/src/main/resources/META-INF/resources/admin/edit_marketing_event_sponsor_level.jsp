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

long marketingEventSponsorLevelId = ParamUtil.getLong(request, "marketingEventSponsorLevelId");

MarketingEventSponsorLevel marketingEventSponsorLevel = MarketingEventSponsorLevelLocalServiceUtil.fetchMarketingEventSponsorLevel(marketingEventSponsorLevelId);

long marketingEventId = ParamUtil.getLong(request, "marketingEventId");
%>

<liferay-ui:header
	backURL="<%= redirect %>"
	title="edit-sponsor-level"
/>

<portlet:actionURL name="updateMarketingEventSponsorLevel" var="updateMarketingEventSponsorLevelURL">
	<portlet:param name="mvcPath" value="/admin/edit_marketing_event_sponsor_level.jsp" />
</portlet:actionURL>

<aui:form action="<%= updateMarketingEventSponsorLevelURL %>" cssClass="edit-marketing-sponsor-level" method="post" name="fm">
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="marketingEventSponsorLevelId" type="hidden" value="<%= marketingEventSponsorLevelId %>" />
	<aui:input name="marketingEventId" type="hidden" value="<%= marketingEventId %>" />

	<liferay-ui:error exception="<%= MarketingEventSponsorLevelNameException.class %>" message="please-enter-a-valid-name" />
	<liferay-ui:error exception="<%= RequiredMarketingEventSponsorLevelException.class %>" message="the-sponsor-level-cannot-be-deleted-because-it-has-associated-sponsors" />

	<aui:model-context bean="<%= marketingEventSponsorLevel %>" model="<%= MarketingEventSponsorLevel.class %>" />

	<aui:fieldset>
		<aui:input name="name" required="true" />

		<aui:input name="priority" />

		<aui:button-row>
			<aui:button type="submit" value="save" />

			<aui:button href="<%= redirect %>" type="cancel" />
		</aui:button-row>
	</aui:fieldset>
</aui:form>