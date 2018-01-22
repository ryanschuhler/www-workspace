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
String tabs1 = ParamUtil.getString(request, "tabs1", "general");

String redirect = ParamUtil.getString(request, "redirect");

String currentLanguageId = LanguageUtil.getLanguageId(request);

String headerTitleParam = "headerTitle_" + currentLanguageId;
String headerTitleContent = PrefsParamUtil.getString(portletPreferences, request, headerTitleParam, "Marketing Events");

String editorParam = "headerContent_" + currentLanguageId;
String editorContent = PrefsParamUtil.getString(portletPreferences, request, editorParam, ContentUtil.get(configuration.portletHeaderContent()));
%>

<liferay-portlet:renderURL portletConfiguration="true" var="portletURL">
	<portlet:param name="tabs1" value="<%= tabs1 %>" />
</liferay-portlet:renderURL>

<liferay-ui:tabs
	names="general,header"
	param="tabs1"
	url="<%= portletURL %>"
/>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />

<aui:form action="<%= configurationURL %>" method="post" name="fm" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "saveConfiguration();" %>'>
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<aui:input name="tabs1" type="hidden" value="<%= tabs1 %>" />

	<aui:fieldset>
		<c:choose>
			<c:when test='<%= tabs1.equals("general") %>'>
				<aui:select label="type" name="preferences--defaultType--">
					<aui:option label="all" value="" />

					<%
					for (int configurationType : MarketingEventConstants.CONFIGURATION_TYPES) {
					%>

						<aui:option label="<%= MarketingEventConstants.getConfigurationTypeLabel(configurationType) %>" selected="<%= Validator.isNotNull(defaultType) && (configurationType == GetterUtil.getInteger(defaultType)) %>" value="<%= configurationType %>" />

					<%
					}
					%>

				</aui:select>

				<aui:input name="preferences--showSearch--" type="checkbox" value="<%= showSearch %>" />
			</c:when>
			<c:otherwise>
				<aui:select label="language" name="languageId" onChange='<%= renderResponse.getNamespace() + "updateLanguage(this);" %>'>

					<%
					Set<Locale> locales = LanguageUtil.getAvailableLocales();

					for (Locale localeItem : locales) {
						String style = StringPool.BLANK;

						if (Validator.isNotNull(portletPreferences.getValue("headerContent_" + LocaleUtil.toLanguageId(localeItem), StringPool.BLANK))) {
							style = "font-weight: bold;";
						}
					%>

						<aui:option label="<%= localeItem.getDisplayName(locale) %>" selected="<%= currentLanguageId.equals(LocaleUtil.toLanguageId(localeItem)) %>" style="<%= style %>" value="<%= LocaleUtil.toLanguageId(localeItem) %>" />

					<%
					}
					%>

				</aui:select>

				<aui:input label="title" name='<%= "preferences--" + headerTitleParam + "--" %>' type="text" value="<%= headerTitleContent %>" />

				<aui:field-wrapper label="content">
					<liferay-ui:input-editor editorImpl="<%= EDITOR_WYSIWYG_IMPL_KEY %>" />

					<aui:input name='<%= "preferences--" + editorParam + "--" %>' type="hidden" />
				</aui:field-wrapper>
			</c:otherwise>
		</c:choose>
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>

<aui:script>
	function <portlet:namespace />initEditor() {
		return '<%= UnicodeFormatter.toString(editorContent) %>';
	}

	function <portlet:namespace />updateLanguage() {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = '';

		submitForm(document.<portlet:namespace />fm);
	}

	Liferay.provide(
		window,
		'<portlet:namespace />saveConfiguration',
		function() {
			<c:if test='<%= Validator.equals(tabs1, "header") %>'>
				document.<portlet:namespace />fm.<portlet:namespace /><%= editorParam %>.value = window.<portlet:namespace />editor.getHTML();
			</c:if>

			submitForm(document.<portlet:namespace />fm);
		},
		['aui-base']
	);

	Liferay.Util.toggleBoxes('<portlet:namespace />enableSocialBookmarksCheckbox', '<portlet:namespace />socialBookmarksOptions');
</aui:script>

<%!
public static final String EDITOR_WYSIWYG_IMPL_KEY = "editor.wysiwyg.osb-portlet.marketing_events.configuration.jsp";
%>