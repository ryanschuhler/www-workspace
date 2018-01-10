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

<#assign article = journal_article_local_service.getArticle(groupId, article_id)! />

<#if article?has_content>
	<@get_article_content article />
</#if>

<#macro get_article_content article>
	<#if article?has_content>
		${journalContentUtil.getContent(groupId, article.getArticleId(), "", locale)!}

		<#if has_update_permissons?? && has_update_permissons>
			<#assign current_url = request.attributes.CURRENT_COMPLETE_URL! />

			<#assign edit_url = "test" />
			<#assign edit_url = portletURLFactory.create(http_servlet_request, "15", plid, "0") />
			<#assign VOID = edit_url.setParameter("p_p_state", "maximized") />
			<#assign VOID = edit_url.setParameter("p_p_lifecycle", "0") />
			<#assign VOID = edit_url.setParameter("groupId", "${groupId}") />
			<#assign VOID = edit_url.setParameter("struts_action", "/journal/edit_article") />
			<#assign VOID = edit_url.setParameter("redirect", "${current_url}") />
			<#assign VOID = edit_url.setParameter("articleId", "${article.getArticleId()}") />

			<span class="lfr-icon-action lfr-icon-action-edit lfr-meta-actions pull-right">
				<a class="taglib-icon" href="${edit_url}">
					<img alt="Edit" src="/osb-community-theme/images/spacer.png" style="background-image: url('/osb-community-theme/sprite/images/common/_sprite.png'); background-position: 50% -608px; background-repeat: no-repeat; height: 16px; width: 16px;">
					<span class="taglib-text ">Edit</span>
				</a>
			</span>
		</#if>
	</#if>
</#macro>