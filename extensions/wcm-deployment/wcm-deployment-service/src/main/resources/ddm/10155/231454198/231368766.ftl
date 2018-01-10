<#assign theme_display = request["theme-display"]! {"plid": 0, "company-id": 10155} />
<#assign plid = theme_display["plid"]?number />
<#assign layout_local_service = serviceLocator.findService("com.liferay.portal.kernel.service.LayoutLocalService") />
<#assign layout = layout_local_service.getLayout(plid)! />

<#assign service_context = objectUtil("com.liferay.portal.kernel.service.ServiceContextThreadLocal").getServiceContext() />
<#assign http_servlet_request = service_context.getRequest() />

<#assign journal_article_local_service = serviceLocator.findService("com.liferay.journal.service.JournalArticleLocalService") />

<#assign runtime_id = 1>

<#macro embed_journal_article_by_article_id article_id no_content_text="">
	<#assign article = journal_article_local_service.getArticle(groupId, article_id)! />

	<#if article?has_content>
		<@embed_journal_article article />
	<#else>
		${no_content_text}
	</#if>
</#macro>

<#macro embed_journal_article_by_url_title article_url_title no_content_text="">
	<#assign article = journal_article_local_service.getArticleByUrlTitle(groupId, article_url_title)! />

	<#if article?has_content>
		<@embed_journal_article article />
	<#else>
		${no_content_text}
	</#if>
</#macro>

<#macro embed_journal_article article>
	<#if article?has_content>
		<@get_journal_article_content article />

		<#if has_update_permissions()>
			<#assign latest_article = journal_article_local_service.fetchLatestArticle(groupId, article.getArticleId(), 0)! />

			<#if latest_article??>
				<#assign edit_url = get_edit_url(latest_article) />

				<#assign ddm_structure_name = "">

				<#if latest_article.getStructureId()??>
					<#assign ddm_structure_local_service = serviceLocator.findService("com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalService") />

					<#assign ddm_structure = ddm_structure_local_service.getStructure(latest_article.getGroupId(), 10109, latest_article.getStructureId(),true)!>

					<#if ddm_structure?? && ddm_structure.getNameCurrentValue??>
						<#assign ddm_structure_name = ddm_structure.getNameCurrentValue()>
					</#if>
				</#if>

				<style>
					.edit-wrapper {
						position: relative;
						z-index: 400;
					}

					.edit-wrapper:hover:after {
						background: #E5E5E5;
						border: 1px solid black;
						bottom: 30px;
						color: black;
						content: "Title: " attr(data-edit-article-title) "\A" "Article Id: " attr(data-edit-article-id) "\A" "Structure: " attr(data-edit-structure-name);
						font-size: 0.9em;
						padding: 5px;
						position: absolute;
						white-space: pre;
						z-index: 400;
					}

					.edit-wrapper img {
						background-image: url(/osb-community-theme/sprite/images/common/_sprite.png);
						background-position: 50% -608px;
						background-repeat: no-repeat;
						height: 16px;
						width: 16px;
					}
				</style>

				<div class="icons-container lfr-meta-actions">
					<div class="lfr-icon-actions">
						<div class="edit-wrapper lfr-icon-action lfr-icon-action-edit lfr-meta-action" data-edit-article-id="${latest_article.getArticleId()!}" data-edit-article-title="${latest_article.getTitleCurrentValue()!}" data-edit-structure-name="${ddm_structure_name!}">
							<a class="taglib-icon" href="${edit_url}">
								<img alt="Edit" src="/osb-community-theme/images/spacer.png">
								<span class="taglib-text">Edit</span>
							</a>
						</div>
					</div>
				</div>
			</#if>
		</#if>
	</#if>
</#macro>

<#macro get_journal_article_content article>
	<#if article?has_content>
		<#assign company_local_service = serviceLocator.findService("com.liferay.portal.kernel.service.CompanyLocalService") />

        <#assign theme_display_object = staticUtil["com.liferay.portal.kernel.util.InstanceFactory"].newInstance("com.liferay.portal.kernel.theme.ThemeDisplay")>
		<#assign VOID = theme_display_object.setPermissionChecker(permissionChecker) >
		<#assign VOID = theme_display_object.setPathImage(theme_display["path-image"])>
		<#assign VOID = theme_display_object.setLocale(locale)>
		<#assign VOID = theme_display_object.setSecure(getterUtil.getBoolean(theme_display["secure"]))>
		<#assign VOID = theme_display_object.setPathFriendlyURLPublic(theme_display["path-friendly-url-public"])>
		<#assign VOID = theme_display_object.setPathThemeImages(theme_display["path-theme-images"])>
		<#assign VOID = theme_display_object.setServerPort(getterUtil.getInteger(theme_display["server-port"]))>
		<#assign VOID = theme_display_object.setServerName(theme_display["server-name"])>
		<#assign VOID = theme_display_object.setPathFriendlyURLPrivateGroup(theme_display["path-friendly-url-private-group"])>
		<#assign VOID = theme_display_object.setURLPortal(theme_display["url-portal"])>
		<#assign VOID = theme_display_object.setCompany(company_local_service.getCompanyById(getterUtil.getLong(theme_display["company-id"])))>
		<#assign VOID = theme_display_object.setLifecycleRender(getterUtil.getBoolean(true))>

		<#if layout?has_content>
			<#assign VOID = theme_display_object.setLayout(layout)>
		</#if>

		<#assign view_mode = get_view_mode()>
		<#assign articleDisplay = (journalContentUtil.getDisplay(groupId?long, article.getArticleId(), view_mode, locale, getterUtil.getInteger("1")?int, theme_display_object)!)>

		<#if articleDisplay.getContent??>
			${articleDisplay.getContent()}
		</#if>
	</#if>
</#macro>

<#function get_edit_url article>
	<#assign edit_url = portletURLFactory.create(http_servlet_request, "15", plid, "0") />

	<#assign VOID = edit_url.setParameter("p_p_state", "maximized") />
	<#assign VOID = edit_url.setParameter("p_p_lifecycle", "0") />
	<#assign VOID = edit_url.setParameter("groupId", "${groupId}") />
	<#assign VOID = edit_url.setParameter("struts_action", "/journal/edit_article") />
	<#assign VOID = edit_url.setParameter("redirect", "${request.attributes.CURRENT_COMPLETE_URL!}") />
	<#assign VOID = edit_url.setParameter("articleId", "${article.getArticleId()?string}") />

	<#return edit_url>
</#function>

<#function has_update_permissions>
	<#if !layout?has_content>
		<#return false>
	</#if>

	<#return layoutPermission.contains(permissionChecker, layout, "UPDATE") />
</#function>

<#function get_view_mode>
	<#if has_update_permissions()>
		<#return "update">
	</#if>

	<#return "">
</#function>

<#macro runtime_embed_journal_article_by_url_title article_url_title>
	<#assign article = journal_article_local_service.getArticleByUrlTitle(groupId, article_url_title)! />

	<#if article?has_content>
		<@runtime_embed_journal_article article.getArticleId() />
	</#if>
</#macro>

<#macro runtime_embed_journal_article_by_article_id article_id>
	<#assign article = journal_article_local_service.getArticle(groupId, article_id)! />

	<#if article?has_content>
		<@runtime_embed_journal_article article.getArticleId() />
	</#if>
</#macro>

<#macro runtime_embed_journal_article article_id>
	<#assign view_mode = get_view_mode()>

	<runtime-portlet instance="${.vars['reserved-article-id'].data}_${runtime_id}" name="56" queryString="articleId=${article_id}&amp;viewMode=${view_mode}"/>

	<#assign runtime_id = runtime_id + 1>
</#macro>