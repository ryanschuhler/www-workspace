<#assign liferay_ui = PortalJspTagLibs["/META-INF/liferay-ui.tld"] />

<#assign css_class = css_class + " dockbar-split" />

<#assign expando_column_local_service = serviceLocator.findService("com.liferay.expando.kernel.service.ExpandoColumnLocalService") />
<#assign expando_table_local_service = serviceLocator.findService("com.liferay.expando.kernel.service.ExpandoTableLocalService") />
<#assign expando_value_local_service = serviceLocator.findService("com.liferay.expando.kernel.service.ExpandoValueLocalService") />
<#assign group_local_service = serviceLocator.findService("com.liferay.portal.kernel.service.GroupLocalService") />
<#assign layout_local_service = serviceLocator.findService("com.liferay.portal.kernel.service.LayoutLocalService") />
<#assign user_group_local_service = serviceLocator.findService("com.liferay.portal.kernel.service.UserGroupLocalService") />
<#assign user_group_role_local_service = serviceLocator.findService("com.liferay.portal.kernel.service.UserGroupRoleLocalService") />
<#assign user_local_service = serviceLocator.findService("com.liferay.portal.kernel.service.UserLocalService") />

<#assign guest_group = group_local_service.fetchGroup(company_id, "Guest") />

<#assign guest_group_id = guest_group.getGroupId() />

<#assign is_gdpr_country = getterUtil.getBoolean(request.getAttribute("OSB_WWW_GDPR_COUNTRY"))>
<#assign is_site_admin = false />

<#list stringUtil.split(theme.getSetting("site-admin-role-names")) as site_admin_role_name>
	<#if user_group_role_local_service.hasUserGroupRole(user.getUserId(), scopeGroupId, site_admin_role_name, true)!>
		<#assign is_site_admin = true />

		<#break>
	</#if>
</#list>

<#assign layoutExpandoBridge = layout.getExpandoBridge() />

<#if layoutExpandoBridge.hasAttribute("nav_overlay")>
	<#assign nav_overlay = layoutExpandoBridge.getAttribute("nav_overlay")! />

	<#if nav_overlay[0]??>
		<#assign css_class = css_class + " ${nav_overlay[0]}" />
	</#if>
</#if>

<#assign layout_sections = stringUtil.split(get_localized_expando_value(layoutExpandoBridge, "sections")!, "||") />
<#assign layout_sections_label = get_localized_expando_value(layoutExpandoBridge, "sections_label")! />

<#assign root_css_class = root_css_class + " " + locale + " responsive www" />

<!-- TODO -->
<#assign show_add_content = false>
<#if !show_add_content>
	<#assign css_class =  stringUtil.replace(css_class, "controls-visible", "controls-hidden") />
</#if>

<#assign country = request.getAttribute("OSB_WWW_COUNTRY")! />

<#assign custom_navigation_article_id_json_object = jsonFactoryUtil.createJSONObject(theme.getSetting("custom-navigation-article-id-json")) />
<#assign footer_contact_article_id_json_object = jsonFactoryUtil.createJSONObject(theme.getSetting("footer-contact-article-id-json")) />
<#assign footer_social_media_article_id_json_object = jsonFactoryUtil.createJSONObject(theme.getSetting("footer-social-media-article-id-json")) />

<#if country?has_content>
	<#assign custom_navigation_article_id = custom_navigation_article_id_json_object.getString(country)! />
	<#assign footer_contact_article_id = footer_contact_article_id_json_object.getString(country)! />
	<#assign footer_social_media_article_id = footer_social_media_article_id_json_object.getString(country)! />
</#if>

<#if !custom_navigation_article_id?has_content>
	<#assign custom_navigation_article_id = custom_navigation_article_id_json_object.getString("default")! />
</#if>

<#if !footer_contact_article_id?has_content>
	<#assign footer_contact_article_id = footer_contact_article_id_json_object.getString("default")! />
</#if>

<#if !footer_social_media_article_id?has_content>
	<#assign footer_social_media_article_id = footer_social_media_article_id_json_object.getString("default")! />
</#if>

<#assign top_head_ext_include = "${dir_include}/common/themes/top_head-ext.jsp" />

<!-- TODO
include "${full_templates_path}/seo.ftl"  
-->

<#function get_localized_expando_value expandoBridge name>
	<#assign table = expando_table_local_service.getTable(company.getCompanyId(), expandoBridge.getClassName(), "CUSTOM_FIELDS")! />

	<#if expandoBridge.hasAttribute(name)>
		<#assign column = expando_column_local_service.getColumn(table.getTableId(), name)! />
		<#assign value = expando_value_local_service.getValue(table.getTableId(), column.getColumnId(), expandoBridge.getClassPK())! />

		<#if value?has_content>
			<#return value.getString(locale)>
		</#if>
	</#if>
</#function>

<#function is_user_group_member user_group_ids>
	<#list user_group_ids as user_group_id>
		<#if user_local_service.hasUserGroupUser(getterUtil.getLong(user_group_id), user.getUserId())>
			<#return true>
		</#if>
	</#list>

	<#return false>
</#function>

<#macro print_navigation nav_layouts css_class="">
	<ul class="${css_class}" role="menubar">
		<#list nav_layouts as nav_layout>
			<@print_navigation_item nav_layout=nav_layout tag="li"/>
		</#list>
	</ul>
</#macro>

<#macro print_navigation_item nav_layout tag>
	<#assign nav_layout_attr_selected = "" />
	<#assign nav_layout_css_class = "nav-item" />

	<#if nav_layout.isSelected(true, layout, layout.getAncestorPlid()) || nav_layout.isChildSelected(true, layout)>
		<#assign nav_layout_attr_selected = "aria-selected='true'" />
		<#assign nav_layout_css_class = nav_layout_css_class + " selected" />
	</#if>

	<${tag} ${nav_layout_attr_selected} class="${nav_layout_css_class}" id="layout_${nav_layout.getLayoutId()}" role="presentation">
		<a aria-labelledby="layout_${layout.getLayoutId()}" href="${nav_layout.getRegularURL(request)}" role="menuitem" ${nav_layout.getTarget()}>
			<#if (nav_layout.getIconImageId() > 0)>
				<img src="/image/layout_icon?img_id=${nav_layout.getIconImageId()}" />
			</#if>

			<span>${nav_layout.getName(locale)}</span>
		</a>
	</${tag}>
</#macro>