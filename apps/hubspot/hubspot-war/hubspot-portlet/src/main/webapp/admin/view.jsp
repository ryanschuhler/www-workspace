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

<%@ include file="/admin/init.jsp" %>

<%
JSONArray jsonArray = DossieraDatabaseUtil.getOpportunitiesJSONArray();

User user2 = UserLocalServiceUtil.fetchUserById(lastSentBy);
%>

<liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>" persistState="<%= true %>" title="liferay-subscription-renewals">
	<c:if test="<%= (lastSentDate > 0) && (user2 != null) %>">
		<div class="alert alert-block">
			<liferay-ui:message arguments="<%= user2.getFullName() %>" key="unscheduled-renewal-emails-were-last-sent-by-x-on" /> <%= dateFormatDateTime.format(new Date(lastSentDate)) %>
		</div>
	</c:if>

	<aui:button-row>
		<liferay-portlet:actionURL name="sendRenewalEmails" var="sendRenewalEmailsURL" />

		<aui:button disabled="<%= (jsonArray.length() == 0) %>" onClick="<%= sendRenewalEmailsURL %>" value="send-renewal-emails" />
	</aui:button-row>

	<c:choose>
		<c:when test="<%= (jsonArray.length() > 0) %>">
			<table class="table table-bordered table-hover table-striped">
				<thead class="table-columns">
					<tr>
						<th>
							<liferay-ui:message key="primary-contact" />
						</th>
						<th>
							<liferay-ui:message key="opportunities" />
						</th>
					</tr>
				</thead>

				<%
				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject jsonObject = jsonArray.getJSONObject(i);

					JSONObject messageJSONObject = jsonObject.getJSONObject("message");

					JSONArray customPropertiesJSONArray = jsonObject.getJSONArray("customProperties");
				%>

					<tr>
						<td>
							<%= messageJSONObject.getString("to") %>
						</td>
						<td>

							<%
							for (int j = 0; j < customPropertiesJSONArray.length(); j++) {
								JSONObject opportunityJSONObject = customPropertiesJSONArray.getJSONObject(j);
							%>

								<%= opportunityJSONObject.getString("value") %>

							<%
							}
							%>

						</td>
					</tr>

				<%
				}
				%>

			</table>
		</c:when>
		<c:otherwise>
			<div class="no-results">
				<liferay-ui:message key="no-renewals-were-found" />
			</div>
		</c:otherwise>
	</c:choose>
</liferay-ui:panel>