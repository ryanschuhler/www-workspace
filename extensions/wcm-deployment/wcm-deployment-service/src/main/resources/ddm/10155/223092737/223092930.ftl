<#import "${templatesPath}/231368766" as article_utilities>

<#-- Get User Country ID -->
<#assign user_country = "" />

<#if request.attributes??>
    <#assign user_country = request.attributes.OSB_WWW_COUNTRY!"US" />
<#else>
    <#assign service_context = objectUtil("com.liferay.portal.kernel.service.ServiceContextThreadLocal").getServiceContext() />
    <#assign http_servlet_request = service_context.getRequest() />
    <#assign user_country = http_servlet_request.getAttribute("OSB_WWW_COUNTRY")!"US" />
</#if>

<#-- Get the Article ID based on the Country-->
<#assign article_id = "">

<#list region.siblings as current_region>
	<#if current_region.countries.getOptions()?seq_contains(user_country)>
		<#assign article_id = current_region.article_id.data />

		<#break>
	</#if>
</#list>

<#if article_id == "">
	<#assign article_id = default_article.default_article_id.data />
</#if>

<#-- Display the Article-->
<#assign journal_article_local_service = serviceLocator.findService("com.liferay.journal.service.JournalArticleLocalService") />
<#assign service_context = staticUtil["com.liferay.portal.kernel.service.ServiceContextThreadLocal"].getServiceContext() />
<#assign http_servlet_request = service_context.getRequest() />

<#if request.attributes??>
	<#assign theme_display = request["theme-display"] />
	<#assign plid = theme_display["plid"]?number />
	<#assign layout_service = serviceLocator.findService("com.liferay.portal.kernel.service.LayoutLocalService") />
	<#assign layout = layout_service.getLayout(plid)! />
	<#assign has_update_permissons = layoutPermission.contains(permissionChecker, layout, "UPDATE")/>
</#if>


<@article_utilities.runtime_embed_journal_article_by_article_id article_id/>
