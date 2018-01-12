<#assign landing_page_path = "/resources/l" />
<#assign landing_page_admin_path = "/resources/admin" />
<#assign landing_pages_folder_id = getterUtil.getLong("159754595") />
<#assign journal_article_local_service = serviceLocator.findService("com.liferay.portlet.journal.service.JournalArticleLocalService") />
<#assign journal_folder_local_service = serviceLocator.findService("com.liferay.portlet.journal.service.JournalFolderLocalService") />

<#assign service_context = objectUtil("com.liferay.portal.kernel.service.ServiceContextThreadLocal").getServiceContext() />
<#assign http_servlet_request = service_context.getRequest() />

<#assign theme_display = request["theme-display"] />
<#assign plid = theme_display["plid"]?number />
<#assign layout_local_service = serviceLocator.findService("com.liferay.portal.kernel.service.LayoutLocalService") />
<#assign layout = layout_local_service.getLayout(plid)! />

<#assign template_article_id = paramUtil.getString(http_servlet_request, "articleId") />
<#assign title = paramUtil.getString(http_servlet_request, "title") />
<#assign update_url = paramUtil.getBoolean(http_servlet_request, "updateURL") />

<#include "${templatesPath}/1561886" />

<#if title?has_content>
	<#attempt>
		<#assign article = journal_article_local_service.getArticleByUrlTitle(groupId, title)! />
	<#recover>
	</#attempt>
<#elseif template_article_id?has_content>
	<#attempt>
		<#assign article = journal_article_local_service.getLatestArticle(groupId, template_article_id)! />
	<#recover>
	</#attempt>
</#if>

<#if update_url && article?has_content>
	<#assign default_language_id = article.getDefaultLanguageId() />

	<#assign new_article_url_title = stringUtil.replace(stringUtil.lowerCase(article.getTitle(default_language_id)), " ", "-") />

	<#attempt>
		<#assign existing_article = journal_article_local_service.getArticleByUrlTitle(groupId, new_article_url_title)! />
	<#recover>
	</#attempt>

	<#if existing_article?has_content>
		<p class="alert alert-info">
			The URL title <strong>${new_article_url_title}</strong> is already assigned to ${article.getTitle(default_language_id)}.<br />

			<a class="taglib-icon" href="/resources/l?title=${article.getUrlTitle()}">
				<img alt="View" src="/osb-community-theme/images/spacer.png" style="background-image: url('/osb-community-theme/sprite/images/common/_sprite.png'); background-position: 50% -608px; background-repeat: no-repeat; height: 16px; width: 16px;">
				<span class="taglib-text">View Landing Page</span>
			</a>

			<#if layoutPermission.contains(permissionChecker, layout, "UPDATE")>
				<#assign edit_url = get_edit_url(article, request.attributes.CURRENT_COMPLETE_URL!, http_servlet_request) />

				<a class="taglib-icon" href="${edit_url}">
					<img alt="Edit" src="/osb-community-theme/images/spacer.png" style="background-image: url('/osb-community-theme/sprite/images/common/_sprite.png'); background-position: 50% -608px; background-repeat: no-repeat; height: 16px; width: 16px;">
					<span class="taglib-text">Edit Landing Page</span>
				</a>
			</#if>
		</p>
	<#elseif article.getUrlTitle() != new_article_url_title >
		<#assign title_map = get_data_map(saxReaderUtil.read(article.getTitle())!, "Title") />
		<#assign description_map = get_data_map(saxReaderUtil.read(article.getDescription())!, "Description") />

		<#assign folder = journal_folder_local_service.fetchFolder(article.getFolderId()) />
		<#assign new_article = journal_article_local_service.addArticle(permissionChecker.getUserId(), groupId, article.getFolderId(), title_map, description_map, article.getContent(), article.getStructureId(), article.getTemplateId(), service_context) />

		<#assign VOID = journal_article_local_service.expireArticle(permissionChecker.getUserId(), groupId, article.getArticleId(), article.getUrlTitle(), service_context) />
		<#assign VOID = journal_folder_local_service.updateFolder(permissionChecker.getUserId(), folder.getFolderId(), folder.getParentFolderId(), new_article.getTitle(default_language_id), folder.getDescription(), false, service_context) />

		<#if new_article?has_content>
			<script type="text/javascript">
				window.location = '/resources/l?title=${new_article.getUrlTitle()}';
			</script>
		</#if>
	</#if>
<#elseif title?has_content && article?has_content>
	${journalContentUtil.getContent(groupId, article.getArticleId()?string, "", locale, xmlRequest)}

	<#if layoutPermission.contains(permissionChecker, layout, "UPDATE")>
		<#assign edit_url = get_edit_url(article, request.attributes.CURRENT_COMPLETE_URL!, http_servlet_request) />

		<span class="lfr-icon-action lfr-icon-action-edit lfr-meta-actions pull-right">
			<div class="edit-wrapper">
				<a class="taglib-icon" href="${edit_url}">
					<img alt="Edit" src="/osb-community-theme/images/spacer.png" style="background-image: url('/osb-community-theme/sprite/images/common/_sprite.png'); background-position: 50% -608px; background-repeat: no-repeat; height: 16px; width: 16px;">
					<span class="taglib-text">Edit Landing Page</span>
				</a>
			</div>

			<div class="btn-wrapper">
				<a class="btn" href="${landing_page_path}?articleId=${article.getArticleId()}&updateURL=1">
					<span class="taglib-text ">Update URL</span>
				</a>
			</div>
		</span>
	</#if>
<#elseif template_article_id?has_content && article?has_content>
	<#assign new_article = journal_article_local_service.copyArticle(permissionChecker.getUserId(), groupId, article.getArticleId(), "", true, article.getVersion())! />
	<#assign new_folder = journal_folder_local_service.addFolder(permissionChecker.getUserId(), groupId, landing_pages_folder_id, new_article.getUrlTitle(), "", service_context)! />

	<#assign VOID = journal_article_local_service.moveArticle(groupId, new_article.getArticleId(), new_folder.getFolderId()) />

	<#assign document = saxReaderUtil.read(new_article.getContent()) />

	<#assign dynamic_elements = document.selectNodes("/root/dynamic-element[@name=\"article_ids\"]/dynamic-content") />
	<#assign no_copy_nodes = document.selectNodes("/root/dynamic-element[@name=\"article_ids\"]/dynamic-element[@name=\"no_copy\"]/dynamic-content") />

	<#list dynamic_elements as dynamic_element>
		<#assign no_copy_node = no_copy_nodes[dynamic_element_index] />
		<#assign no_copy = no_copy_node.getStringValue()?trim />

		<#if !getterUtil.getBoolean(no_copy)>
			<#assign embedded_article = journal_article_local_service.getLatestArticle(groupId, dynamic_element.getText())! />

			<#assign new_embedded_article = journal_article_local_service.copyArticle(permissionChecker.getUserId(), groupId, embedded_article.getArticleId(), "", true, embedded_article.getVersion())! />
			<#assign VOID = journal_article_local_service.moveArticle(groupId, new_embedded_article.getArticleId(), new_folder.getFolderId()) />

			<#assign VOID = dynamic_element.setText(new_embedded_article.getArticleId()) />
		</#if>
	</#list>

	<#assign VOID = journal_article_local_service.updateArticle(new_article.getUserId(), new_article.getGroupId(), new_folder.getFolderId(), new_article.getArticleId(), new_article.getVersion(), document.asXML(), service_context) />

	<script type="text/javascript">
		window.location = '${landing_page_path}?title=${new_article.getUrlTitle()}';
	</script>

<#else>
	<p class="alert alert-error">Web content not found.</p>

	<div class="btn-wrapper">
		<a class="btn" href="${landing_page_admin_path}">
			<span class="taglib-text ">Landing Page Templates</span>
		</a>
	</div>
</#if>

<#function get_data_map document element>
	<#assign data_map = {} />

	<#if document?has_content && element?has_content>
		<#assign dynamic_elements = document.selectNodes("/root/${element}") />

		<#list dynamic_elements as dynamic_element>
			<#assign data_map = data_map + {dynamic_element.attributeValue('language-id'):dynamic_element.getText()} />
		</#list>
	</#if>

	<#return data_map>
</#function>

<#function get_edit_url article current_url http_servlet_request>
	<#assign edit_url = portletURLFactory.create(http_servlet_request, "15", plid, "0") />

	<#assign VOID = edit_url.setParameter("p_p_state", "maximized") />
	<#assign VOID = edit_url.setParameter("p_p_lifecycle", "0") />
	<#assign VOID = edit_url.setParameter("groupId", "${groupId}") />
	<#assign VOID = edit_url.setParameter("struts_action", "/journal/edit_article") />
	<#assign VOID = edit_url.setParameter("redirect", "${current_url}") />
	<#assign VOID = edit_url.setParameter("articleId", "${article.getArticleId()?string}") />

	<#return edit_url>
</#function>

<style>
	.btn-wrapper {
		margin-top: 1.5em;
	}
</style>