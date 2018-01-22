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
PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setParameter("mvcPath", "/admin/view.jsp");
portletURL.setWindowState(WindowState.MAXIMIZED);

request.setAttribute("view.jsp-portletURL", portletURL);
%>

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value="/admin/view.jsp" />
	<portlet:param name="tabs1" value="marketing" />
</liferay-portlet:renderURL>

<liferay-ui:error exception="<%= RequiredSocialLinkTypeException.class %>" message="the-social-media-type-cannot-be-deleted-because-it-has-associated-marketing-event-users" />

<aui:form action="<%= searchURL %>" cssClass="marketing" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />

	<aui:fieldset>
		<liferay-ui:search-container
			searchContainer="<%= new MarketingEventSearch(renderRequest, searchURL) %>"
		>
			<liferay-ui:search-form
				page="/admin/marketing_event_search.jsp"
				servletContext="<%= application %>"
			/>

			<%
			MarketingEventSearchTerms searchTerms = (MarketingEventSearchTerms)searchContainer.getSearchTerms();
			%>

			<liferay-ui:search-container-results>
				<%@ include file="/admin/marketing_event_search_results.jspf" %>
			</liferay-ui:search-container-results>

			<liferay-ui:search-container-row
				className="com.liferay.osb.www.marketing.events.model.MarketingEvent"
				escapedModel="<%= true %>"
				keyProperty="marketingEventId"
				modelVar="marketingEvent"
			>
				<liferay-portlet:renderURL doAsGroupId="<%= Validator.isNotNull(marketingEvent.getSiteGroupId()) ? marketingEvent.getSiteGroupId() : OSBWWWMarketingEventsConstants.GROUP_GUEST_ID %>" varImpl="rowURL" windowState="<%= WindowState.MAXIMIZED.toString() %>">
					<portlet:param name="mvcPath" value="/admin/edit_marketing_event.jsp" />
					<portlet:param name="redirect" value="<%= searchURL.toString() %>" />
					<portlet:param name="marketingEventId" value="<%= String.valueOf(marketingEvent.getMarketingEventId()) %>" />
				</liferay-portlet:renderURL>

				<liferay-ui:search-container-column-text
					href="<%= rowURL %>"
					name="type"
					orderable="<%= true %>"
					translate="<%= true %>"
					value="<%= MarketingEventConstants.getTypeLabel(marketingEvent.getType()) %>"
				/>

				<liferay-ui:search-container-column-text
					href="<%= rowURL %>"
					name="title"
					orderable="<%= true %>"
					value="<%= marketingEvent.getTitle(locale) %>"
				/>

				<liferay-ui:search-container-column-text
					href="<%= rowURL %>"
					name="start-date"
					orderable="<%= true %>"
					translate="<%= true %>"
					value='<%= !marketingEvent.isDateTBA() ? longDateFormatDateTime.format(marketingEvent.getStartDate()) : "to-be-announced" %>'
				/>

				<liferay-ui:search-container-column-text
					href="<%= rowURL %>"
					name="global-region"
					orderable="<%= true %>"
					translate="<%= true %>"
					value="<%= MarketingEventConstants.getGlobalRegionLabel(marketingEvent.getGlobalRegion()) %>"
				/>

				<liferay-ui:search-container-column-jsp
					align="right"
					path="/admin/marketing_event_action.jsp"
				/>
			</liferay-ui:search-container-row>

			<aui:button-row>
				<liferay-portlet:renderURL var="addMarketingEventURL">
					<portlet:param name="mvcPath" value="/admin/edit_marketing_event.jsp" />
					<portlet:param name="redirect" value="<%= searchURL.toString() %>" />
				</liferay-portlet:renderURL>

				<aui:button href="<%= addMarketingEventURL %>" value="add-event" />

				<liferay-portlet:renderURL var="editSettingsURL">
					<portlet:param name="mvcPath" value="/admin/edit_settings.jsp" />
					<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
				</liferay-portlet:renderURL>

				<aui:button href="<%= editSettingsURL %>" value="edit-settings" />
			</aui:button-row>

			<div class="separator"><!-- --></div>

			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</aui:fieldset>
</aui:form>