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

<%@ include file="/users/init.jsp" %>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationActionURL" />

<aui:form action="<%= configurationActionURL %>" method="post" name="fm">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />

	<aui:select label="marketing-event" name="preferences--marketingEventSiteGroupId--">
		<aui:option value="" />

		<%
		for (Group curGroup : marketingEventUsersDisplayContext.getGroups()) {
		%>

			<aui:option label="<%= curGroup.getDescriptiveName() %>" selected="<%= (marketingEventUsersDisplayContext.getMarketingEventSiteGroupId() == curGroup.getGroupId()) %>" value="<%= curGroup.getGroupId() %>" />

		<%
		}
		%>

	</aui:select>

	<div class="categories-selector field">
		<liferay-ui:asset-categories-selector
			className="com.liferay.osb.www.marketing.events.model.MarketingEventUser"
			curCategoryIds="<%= marketingEventUsersDisplayContext.getAnyAssetCategoryIdsString() %>"
			groupIds="<%= marketingEventUsersDisplayContext.getGroupIds() %>"
			hiddenInput="anyAssetCategoryIds"
		/>
	</div>

	<div class="categories-selector field">
		<liferay-ui:asset-categories-selector
			className="com.liferay.osb.www.marketing.events.model.MarketingEventUser"
			curCategoryIds="<%= marketingEventUsersDisplayContext.getNotAnyAssetCategoryIdsString() %>"
			groupIds="<%= marketingEventUsersDisplayContext.getGroupIds() %>"
			hiddenInput="notAnyAssetCategoryIds"
		/>
	</div>

	<aui:input name="preferences--displayStyle--" type="text" value="<%= marketingEventUsersDisplayContext.getDisplayStyle() %>"
	/>

	<aui:input name="preferences--headerText--" type="text" value="<%= marketingEventUsersDisplayContext.getHeaderText() %>" />

	<aui:input name="preferences--keynoteSpeakerBadgeText--" type="text" value="<%= marketingEventUsersDisplayContext.getKeynoteSpeakerBadgeText() %>" />
	<aui:input name="preferences--orderByCol--" type="text" value="<%= marketingEventUsersDisplayContext.getOrderByCol() %>" />
	<aui:input name="preferences--orderByType--" type="text" value="<%= marketingEventUsersDisplayContext.getOrderByType() %>" />

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>