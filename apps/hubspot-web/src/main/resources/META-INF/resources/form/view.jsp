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

<%@ include file="/form/init.jsp" %>

<h1> Showing form for guid <%= hubSpotFormDisplayContext.getGUID() %></h1>

<%
HSFormDisplay hsFormDisplay = hubSpotFormDisplayContext.getHSFormDisplay();

for (HSFormFieldDisplay hsFormFieldDisplay : hsFormDisplay.getFormFieldDisplays()) {
%>

	<div>
		<label class="field-label" for="<%= hsFormFieldDisplay.getName() %>"><%= hsFormFieldDisplay.getLabel() %></label>

		<c:choose>
			<c:when test='<%= StringUtil.equalsIgnoreCase(hsFormFieldDisplay.getFieldType(), "select") %>'>
				<select class="${field_input_css_class}" name="${field_name}" ${required_attr}>
					<option ${disabled_select_option} ${default_selected}></option>
					<% for (KeyValuePair option : hsFormFieldDisplay.getOptions()) { %>

						<option value="<%= option.getKey() %>" ${selected}><%= option.getValue() %></option>

					<%
						}
					%>

				</select>
			</c:when>
			<c:otherwise>
				<input name="<%= hsFormFieldDisplay.getName() %>"
				type="<%= hsFormFieldDisplay.getFieldType() %>"
				value="<%= hsFormFieldDisplay.getValue() %>"
				/>
			</c:otherwise>
		</c:choose>
	</div>

<%
	}
%>