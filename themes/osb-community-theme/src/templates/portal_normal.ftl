<!DOCTYPE html>

<!-- TODO -->
<#assign open_graph_images = [] />
<#assign open_graph_title = "" />
<#assign open_graph_url = "" />
<#assign page_title= "" />
<#assign page_description= "" />

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<meta charset="utf-8" />
	<meta content="minimum-scale=1.0, width=device-width" name="viewport" />

	<#if page_description?has_content>
		<meta content="${page_description}" lang="${locale}" name="description" />
	</#if>

	<meta content="${open_graph_url}" property="og:url" />
	<meta content="${open_graph_title}" property="og:title" />

	<#if page_description?has_content>
		<meta content="${page_description}" property="og:description" />
	</#if>

	<#list open_graph_images as open_graph_image>
		<meta content="${open_graph_image}" property="og:image" />
	</#list>

	<title>${page_title}</title>

	<#-- TODO -->
	<@liferay_util["include"] page=top_head_include />
	<@liferay_util["include"] page=top_head_ext_include />

	<#assign locale_util = staticUtil["com.liferay.portal.kernel.util.LocaleUtil"] />

	<#if themeDisplay.getLocale() == locale_util.CHINA>
		<link href="//fonts.googleapis.com/earlyaccess/notosansscsliced.css" rel="stylesheet">
	<#elseif themeDisplay.getLocale() == locale_util.JAPAN>
		<link href="//fonts.googleapis.com/earlyaccess/notosansjapanese.css" rel="stylesheet">
	</#if>

	<#if theme.getSetting("custom-head-code")?has_content>
		${theme.getSetting("custom-head-code")}
	</#if>

	<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,400i,600,700|Source+Serif+Pro" rel="stylesheet">

	<script type="text/javascript">
		AUI().applyConfig(
			{
				modules: {
					'class-toggle': {
						fullpath: '${htmlUtil.escape(portalUtil.getStaticResourceURL(request, "${javascript_folder}/class_toggle.js"))}',
						requires: ['aui-base', 'event']
					},
					'event-onscreen': {
						fullpath: '${htmlUtil.escape(portalUtil.getStaticResourceURL(request, "${javascript_folder}/event_onscreen.js"))}',
						requires: ['aui-base', 'event-synthetic', 'json-parse', 'yui-throttle']
					},
					'osb-form': {
						fullpath: '${htmlUtil.escape(portalUtil.getStaticResourceURL(request, "${javascript_folder}/osb_form.js"))}',
						requires: ['aui-base', 'aui-form-validator']
					},
					'pop-up': {
						fullpath: '${htmlUtil.escape(portalUtil.getStaticResourceURL(request, "${javascript_folder}/pop_up.js"))}',
						requires: ['aui-base', 'aui-overlay-mask-deprecated', 'class-toggle', 'event']
					},
					'scroll-nav': {
						fullpath: '${htmlUtil.escape(portalUtil.getStaticResourceURL(request, "${javascript_folder}/scroll_nav.js"))}',
						requires: ['aui-base', 'aui-component', 'event', 'event-onscreen']
					}
				}
			}
		);
	</script>
</head>

<body class="${css_class}">

<a class="hide-accessible" href="#main-content" id="skip-to-content"><@liferay.language key="skip-to-content" /></a>

<@liferay_util["include"] page=body_top_include />

<#--
TODO
	<#if permissionChecker.isOmniadmin() || is_site_admin>
		<@liferay.dockbar />
	</#if>
-->

<div class="container-fluid" id="wrapper">
	<div class="content">
		<#include "${full_templates_path}/icons.ftl" parse=false />

		<#include "${full_templates_path}/banner.ftl" />

		<#if selectable>
			<@liferay_util["include"] page=content_include />
		<#else>
			${portletDisplay.recycle()}

			${portletDisplay.setTitle(the_title)}

			${theme.wrapPortlet("portlet.ftl", content_include)}
		</#if>

		<#include "${full_templates_path}/footer.ftl" />
	</div>
</div>

<#if is_gdpr_country>
	<#include "${full_templates_path}/gdpr.ftl" />
</#if>

<@liferay_util["include"] page=body_bottom_include />

<@liferay_util["include"] page=bottom_include />

<script src='${htmlUtil.escape(portalUtil.getStaticResourceURL(request, "${javascript_folder}/pause_hidden_videos.js"))}' type="text/javascript"></script>
<script src='${htmlUtil.escape(portalUtil.getStaticResourceURL(request, "${javascript_folder}/verify_user.js"))}' type="text/javascript"></script>

<#if layoutPermission.contains(permissionChecker, layout, "UPDATE")>
	<script src='${htmlUtil.escape(portalUtil.getStaticResourceURL(request, "${javascript_folder}/live_edit.js"))}' type="text/javascript"></script>
</#if>

</body>

</html>