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
MarketingEventSearch searchContainer = (MarketingEventSearch)request.getAttribute("liferay-ui:search:searchContainer");

MarketingEventDisplayTerms displayTerms = (MarketingEventDisplayTerms)searchContainer.getDisplayTerms();
%>

<liferay-ui:search-toggle
	buttonLabel="search"
	displayTerms="<%= displayTerms %>"
	id="toggle_id_marketing_event_search"
>
	<aui:fieldset>
		<div>
			<aui:input inlineField="<%= true %>" name="<%= displayTerms.TITLE %>" value="<%= displayTerms.getTitle() %>" />

			<aui:input inlineField="<%= true %>" name="<%= displayTerms.SUMMARY %>" value="<%= displayTerms.getSummary() %>" />
		</div>

		<div>
			<aui:field-wrapper inlineField="<%= true %>" label="type">
				<div>
					<select class="multiple-select" id="<portlet:namespace /><%= displayTerms.TYPES %>" multiple name="<portlet:namespace /><%= displayTerms.TYPES %>">
						<option value=""><liferay-ui:message key="any" /></option>

						<%
						for (int type : MarketingEventConstants.TYPES) {
						%>

							<option <%= ArrayUtil.contains(displayTerms.getTypes(), type) ? "selected" : "" %> value="<%= type %>"><%= LanguageUtil.get(request, MarketingEventConstants.getTypeLabel(type)) %></option>

						<%
						}
						%>

					</select>
				</div>
			</aui:field-wrapper>

			<aui:field-wrapper inlineField="<%= true %>" label="global-region">
				<div>
					<select class="multiple-select" id="<portlet:namespace /><%= displayTerms.GLOBAL_REGIONS %>" multiple name="<portlet:namespace /><%= displayTerms.GLOBAL_REGIONS %>">
						<option value=""><liferay-ui:message key="any" /></option>

						<%
						for (int globalRegion : MarketingEventConstants.GLOBAL_REGIONS) {
						%>

							<option <%= ArrayUtil.contains(displayTerms.getGlobalRegions(), globalRegion) ? "selected" : "" %> value="<%= globalRegion %>"><%= LanguageUtil.get(request, MarketingEventConstants.getGlobalRegionLabel(globalRegion)) %></option>

						<%
						}
						%>

					</select>
				</div>
			</aui:field-wrapper>
		</div>

		<aui:field-wrapper cssClass="float-container start-date" label="start-date">
			<aui:select cssClass="anytime" ignoreRequestValue="<%= true %>" inlineField="<%= true %>" label="" name="<%= displayTerms.ANYTIME %>">
				<aui:option label="anytime" selected="<%= displayTerms.isAnytime() %>" value="<%= true %>" />
				<aui:option label="between" selected="<%= !displayTerms.isAnytime() %>" value="<%= false %>" />
			</aui:select>

			<span class="<%= displayTerms.isAnytime() ? "aui-helper-hidden" : "" %>" id="<portlet:namespace />datesOptions">
				<liferay-ui:input-date
					dayParam="<%= displayTerms.START_DATE_GT_DAY %>"
					dayValue="<%= displayTerms.getStartDateGTDay() %>"
					monthParam="<%= displayTerms.START_DATE_GT_MONTH %>"
					monthValue="<%= displayTerms.getStartDateGTMonth() %>"
					yearParam="<%= displayTerms.START_DATE_GT_YEAR %>"
					yearValue="<%= displayTerms.getStartDateGTYear() %>"
				/>

				<liferay-ui:input-date
					dayParam="<%= displayTerms.START_DATE_LT_DAY %>"
					dayValue="<%= displayTerms.getStartDateLTDay() %>"
					monthParam="<%= displayTerms.START_DATE_LT_MONTH %>"
					monthValue="<%= displayTerms.getStartDateLTMonth() %>"
					yearParam="<%= displayTerms.START_DATE_LT_YEAR %>"
					yearValue="<%= displayTerms.getStartDateLTYear() %>"
				/>
			</span>
		</aui:field-wrapper>
	</aui:fieldset>
</liferay-ui:search-toggle>

<aui:script>
	Liferay.Util.toggleSelectBox("<portlet:namespace /><%= displayTerms.ANYTIME %>", "<%= false %>", "<portlet:namespace />datesOptions");
</aui:script>