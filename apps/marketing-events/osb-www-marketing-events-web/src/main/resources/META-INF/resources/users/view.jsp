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

<div class="speakers <%= marketingEventUsersDisplayContext.getDisplayStyle() %>" id="speakers">
	<c:choose>
		<c:when test="<%= (marketingEventUsersDisplay == null) %>">
			<h2>
				<liferay-ui:message key="speakers-coming-soon" />
			</h2>
		</c:when>
		<c:otherwise>
			<h2>
				<%= marketingEventUsersDisplayContext.getHeaderText() %>
			</h2>

			<c:forEach items="<%= marketingEventUsersDisplay.getMarketingEventUserDisplays() %>" var="marketingEventUserDisplay" varStatus="marketingEventUserDisplayStatus">
				<h3>${marketingEventUserDisplay.getFullName()}</h3>
				<img src="${marketingEventUserDisplay.getImageFileEntryURL()}" />

				<c:if test="${marketingEventUserDisplay.isKeynoteSpeaker()}">
					<h4> <%= marketingEventUsersDisplayContext.getKeynoteSpeakerBadgeText() %></h4>
				</c:if>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</div>