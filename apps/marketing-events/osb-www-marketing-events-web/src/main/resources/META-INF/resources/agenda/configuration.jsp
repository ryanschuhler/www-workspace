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

<%@ include file="/agenda/init.jsp" %>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationActionURL" />

<aui:form action="<%= configurationActionURL %>" method="post" name="fm">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />

	<liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>" persistState="<%= true %>" title="agenda-settings">
		<aui:select label="marketing-event" name="preferences--marketingEventSiteGroupId--">
			<aui:option value="" />

			<%
			Group group = GroupLocalServiceUtil.fetchGroup(company.getCompanyId(), OSBConstants.PARENT_GROUP_NAME_EVENTS);

			for (Group curGroup : GroupLocalServiceUtil.getGroups(company.getCompanyId(), group.getGroupId(), true)) {
			%>

				<aui:option label="<%= curGroup.getDescriptiveName() %>" selected="<%= (marketingEventAgendaDisplayContext.getMarketingEventSiteGroupId() == curGroup.getGroupId()) %>" value="<%= curGroup.getGroupId() %>" />

			<%
			}
			%>

		</aui:select>

		<aui:select label="agenda-date-format-type" name="preferences--agendaDateFormatType--" onChange='<%= renderResponse.getNamespace() + "changeAgendaDateFormatType(this.value);" %>'>>
			<c:set value="<%= marketingEventAgendaDisplayContext.getMarketingEventDateFormat() %>" var="marketingEventDateFormat" />

			<c:forEach items="<%= MarketingEventDateFormat.values() %>" var="curDateFormatType">
				<aui:option label="${curDateFormatType}" selected="${marketingEventDateFormat == curDateFormatType}" value="${curDateFormatType.getStyle()}" />
			</c:forEach>
		</aui:select>

		<div class='<%= (enableCustomAgendaDateFormat ? StringPool.BLANK : "hide") %>' id="<portlet:namespace />agendaCustomDatePattern">
			<aui:input name="preferences--agendaCustomDatePattern--" type="text" value="<%= marketingEventAgendaDisplayContext.getAgendaCustomDatePattern() %>" />
		</div>

		<c:choose>
			<c:when test="<%= (marketingEventAgendaDisplay != null) %>">
				<aui:select label="default-day" name="preferences--defaultDay--">
					<c:set value="<%= marketingEventAgendaDisplay.getMarketingEventDates() %>" var="eventDates" />
					<c:set value="<%= marketingEventAgendaDisplay.getDateFormat(marketingEventAgendaDisplayContext.getMarketingEventDateFormat(), marketingEventAgendaDisplayContext.getAgendaCustomDatePattern(), locale) %>" var="marketingEventFormatDate" />
					<c:set value="<%= marketingEventAgendaDisplayContext.getDefaultDay() %>" var="defaultDay" />

					<c:forEach items="${eventDates}" var="eventDate" varStatus="eventDateStatus">
						<aui:option label="${marketingEventFormatDate.format(eventDate)}" selected="${eventDateStatus.index == defaultDay}" value="${eventDateStatus.index}" />
					</c:forEach>
				</aui:select>
			</c:when>
		</c:choose>
	</liferay-ui:panel>

	<liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>" persistState="<%= true %>" title="session-info">
		<aui:input name="preferences--sessionTimeFormat--" type="text" value="<%= marketingEventAgendaDisplayContext.getSessionTimeFormat() %>" />

		<aui:select label="logo-type" name="preferences--logoType--">
			<c:set value="<%= marketingEventAgendaDisplayContext.getMarketingEventSessionLogoType() %>" var="marketingEventSessionLogoType" />

			<c:forEach items="<%= MarketingEventSessionLogoType.values() %>" var="curLogoType">
				<aui:option label="${curLogoType}" selected="${marketingEventSessionLogoType == curLogoType}" value="${curLogoType}" />
			</c:forEach>
		</aui:select>

		<aui:input checked="<%= marketingEventAgendaDisplayContext.isShowTopic() %>" name="preferences--showTopic--" type="checkbox" value="<%= marketingEventAgendaDisplayContext.isShowTopic() %>" />
	</liferay-ui:panel>

	<liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>" persistState="<%= true %>" title="speaker-info">
		<aui:input checked="<%= marketingEventAgendaDisplayContext.isShowSpeakerAvatar() %>" name="preferences--showSpeakerAvatar--" type="checkbox" value="<%= marketingEventAgendaDisplayContext.isShowSpeakerAvatar() %>" />

		<aui:input checked="<%= marketingEventAgendaDisplayContext.isShowSpeakerCompanyName() %>" name="preferences--showSpeakerCompanyName--" type="checkbox" value="<%= marketingEventAgendaDisplayContext.isShowSpeakerCompanyName() %>" />

		<aui:input checked="<%= marketingEventAgendaDisplayContext.isShowSpeakerName() %>" name="preferences--showSpeakerName--" type="checkbox" value="<%= marketingEventAgendaDisplayContext.isShowSpeakerName() %>" />

		<aui:input checked="<%= marketingEventAgendaDisplayContext.isShowSpeakerOnSingleLine() %>" name="preferences--showSpeakerOnSingleLine--" type="checkbox" value="<%= marketingEventAgendaDisplayContext.isShowSpeakerOnSingleLine() %>" />

		<aui:input checked="<%= marketingEventAgendaDisplayContext.isShowSpeakerTitle() %>" name="preferences--showSpeakerTitle--" type="checkbox" value="<%= marketingEventAgendaDisplayContext.isShowSpeakerTitle() %>" />
	</liferay-ui:panel>

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>

<aui:script use="aui-base">
Liferay.provide(
		window,
		'<portlet:namespace />changeAgendaDateFormatType',
		function(agendaDateFormatType) {
			var agendaCustomDatePattern = A.one('#<portlet:namespace />agendaCustomDatePattern');

			if (agendaCustomDatePattern) {
				if (agendaDateFormatType == '<%= MarketingEventDateFormat.CUSTOM.getStyle() %>') {
					agendaCustomDatePattern.show();
				}
				else {
					agendaCustomDatePattern.hide();
				}
			}
		}
	);
</aui:script>