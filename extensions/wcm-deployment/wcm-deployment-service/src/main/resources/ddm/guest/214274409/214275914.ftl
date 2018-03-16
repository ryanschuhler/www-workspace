<#attempt>
	<#import "${templatesPath}/231368766" as article_utilities>

	<#assign page_path = "/" + landing_page_path.data + "/l" />
	<#assign landing_page_admin_path = "/" + landing_page_path.data + "/admin" />
	<#assign landing_pages_folder_id = getterUtil.getLong(folder_id.data) />
	<#assign journal_article_local_service = serviceLocator.findService("com.liferay.journal.service.JournalArticleLocalService") />
	<#assign journal_folder_local_service = serviceLocator.findService("com.liferay.journal.service.JournalFolderLocalService") />

	<#assign service_context = objectUtil("com.liferay.portal.kernel.service.ServiceContextThreadLocal").getServiceContext() />
	<#assign http_servlet_request = service_context.getRequest() />

	<#assign template_article_id = paramUtil.getString(http_servlet_request, "articleId") />
	<#assign new_url_title = paramUtil.getString(http_servlet_request, "urlTitle") />
	<#assign title = paramUtil.getString(http_servlet_request, "title") />
	<#assign update_url = paramUtil.getBoolean(http_servlet_request, "updateURL") />

	<#assign has_update_permissions = article_utilities.has_update_permissions() />

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

	<#if title?has_content && article?has_content>
		<@article_utilities.get_journal_article_content article />

		<#if has_update_permissions>
			<#assign edit_url = article_utilities.get_edit_url(article) />

			<span class="lfr-icon-action lfr-icon-action-edit lfr-meta-actions pull-right">
				<div class="edit-wrapper">
					<a class="taglib-icon" href="${edit_url}">
						<img alt="Edit" src="/osb-community-theme/images/spacer.png" style="background-image: url('/osb-community-theme/sprite/images/common/_sprite.png'); background-position: 50% -608px; background-repeat: no-repeat; height: 16px; width: 16px;">
						<span class="taglib-text">Edit Landing Page</span>
					</a>
				</div>

				<div class="btn-wrapper">
					<a class="btn" href="${page_path}?articleId=${article.getArticleId()}&updateURL=1">
						<span class="taglib-text">Update URL</span>
					</a>
				</div>
			</span>
		</#if>
	<#elseif template_article_id?has_content && article?has_content>
		<#assign default_language_id = article.getDefaultLanguageId() />

		<#if !new_url_title?has_content>
			<#assign new_url_title = stringUtil.lowerCase(article.getTitle(default_language_id))?replace("[^\\w\\s]", " ", "r")! />
			<#assign new_url_title = stringUtil.trim(new_url_title)! />
			<#assign new_url_title = new_url_title?replace("\\s+", "-", "r")! />
		</#if>

		<#attempt>
			<#assign existing_article = journal_article_local_service.getArticleByUrlTitle(groupId, new_url_title)! />
		<#recover>
		</#attempt>

		<#if existing_article?has_content>
			<@article_exists new_url_title article.getTitle(default_language_id) />
		<#elseif article.getUrlTitle() != new_url_title >
			<#assign new_article = create_article(article, new_url_title) />

			<#if update_url>
				<#assign folder = journal_folder_local_service.fetchFolder(article.getFolderId()) />
				<#assign VOID = journal_folder_local_service.updateFolder(permissionChecker.getUserId(), folder.getFolderId(), folder.getParentFolderId(), new_article.getTitle(default_language_id), folder.getDescription(), false, service_context)! />
				<#assign VOID = journal_article_local_service.expireArticle(permissionChecker.getUserId(), groupId, article.getArticleId(), article.getUrlTitle(), service_context) />
			<#else>
				<#assign new_folder = journal_folder_local_service.addFolder(permissionChecker.getUserId(), groupId, landing_pages_folder_id, new_article.getUrlTitle(), "", service_context)! />

				<#assign VOID = journal_article_local_service.moveArticle(groupId, new_article.getArticleId(), new_folder.getFolderId()) />

				<#assign new_document = saxReaderUtil.read(new_article.getContent()) />

				<@copy_articles new_article new_document new_folder />
			</#if>

			<script type="text/javascript">
				window.location = '${page_path}/${new_article.getUrlTitle()}';
			</script>
		</#if>
	<#else>
		<p class="alert alert-error">Web content not found.</p>

		<div class="btn-wrapper">
			<a class="btn" href="${landing_page_admin_path}">
				<span class="taglib-text ">Landing Page Templates</span>
			</a>
		</div>
	</#if>

	<#macro article_exists url_title article_title>
		<p class="alert alert-info">
			The URL title <strong>${url_title}</strong> is already assigned to ${article_title}.<br />

			<a class="taglib-icon" href="${page_path}/${url_title}">
				<img alt="View" src="/osb-community-theme/images/spacer.png" style="background-image: url('/osb-community-theme/sprite/images/common/_sprite.png'); background-position: 50% -608px; background-repeat: no-repeat; height: 16px; width: 16px;">
				<span class="taglib-text">View Landing Page</span>
			</a>

			<#if has_update_permissions>
				<#assign edit_url = article_utilities.get_edit_url(article) />

				<a class="taglib-icon" href="${edit_url}">
					<img alt="Edit" src="/osb-community-theme/images/spacer.png" style="background-image: url('/osb-community-theme/sprite/images/common/_sprite.png'); background-position: 50% -608px; background-repeat: no-repeat; height: 16px; width: 16px;">
					<span class="taglib-text">Edit Landing Page</span>
				</a>
			</#if>
		</p>
	</#macro>

	<#function get_article_url_titles document>
		<#assign dynamic_elements_base_level = document.selectNodes("/root/dynamic-element[@name=\"article_url_title\"]") />
		<#assign dynamic_elements_bento = document.selectNodes("/root/dynamic-element[@name=\"block\"]/dynamic-element[@name=\"article_url_title\"]") />
		<#assign dynamic_elements_lego = document.selectNodes("/root/dynamic-element[@name=\"section\"]/dynamic-element[@name=\"block\"]/dynamic-element[@name=\"article_url_title\"]") />
		<#assign dynamic_elements_porlet_embed = document.selectNodes("/root/dynamic-element[@name=\"block\"]/dynamic-element[@name=\"portlet_embed\"]/dynamic-element[@name=\"article_url_title\"]") />

		<#assign dynamic_elements = dynamic_elements_base_level />

		<#if 0 < dynamic_elements_bento?size>
			<#assign dynamic_elements = dynamic_elements_bento />
		<#elseif 0 < dynamic_elements_lego?size>
			<#assign dynamic_elements = dynamic_elements_lego />
		<#elseif 0 < dynamic_elements_porlet_embed?size>
			<#assign dynamic_elements = dynamic_elements_porlet_embed />
		</#if>

		<#return dynamic_elements>
	</#function>

	<#macro copy_articles article document folder>
		<#assign dynamic_elements = get_article_url_titles(document) />

		<#list dynamic_elements as dynamic_element>
			<#assign copy = true />
			<#assign copy_node = dynamic_element.selectSingleNode("dynamic-element[@name=\"copy\"]")! />

			<#if copy_node?has_content>
				<#assign copy = getterUtil.getBoolean(copy_node.getStringValue()) />
			</#if>

			<#if copy>
				<#assign dynamic_content = dynamic_element.selectSingleNode("dynamic-content") />

				<#assign cur_article_url_title = dynamic_content.getStringValue() />

				<#assign embedded_article = journal_article_local_service.getArticleByUrlTitle(groupId, cur_article_url_title)! />

				<#if embedded_article?has_content>
					<#assign new_embedded_article = journal_article_local_service.copyArticle(permissionChecker.getUserId(), groupId, embedded_article.getArticleId(), "", true, embedded_article.getVersion())! />
					<#assign VOID = journal_article_local_service.moveArticle(groupId, new_embedded_article.getArticleId(), folder.getFolderId())! />

					<#assign VOID = dynamic_content.setText(new_embedded_article.getUrlTitle())! />

					<#assign new_document = saxReaderUtil.read(new_embedded_article.getContent()) />

					<@copy_articles new_embedded_article new_document folder />
				</#if>
			</#if>
		</#list>

		<#assign VOID = journal_article_local_service.updateArticle(article.getUserId(), article.getGroupId(), folder.getFolderId(), article.getArticleId(), article.getVersion(), document.asXML(), service_context) />
	</#macro>

	<#function create_article cur_article title>
		<#assign title_map = get_data_map(saxReaderUtil.read(cur_article.getTitle())!, "Title") />
		<#assign description_map = get_data_map(saxReaderUtil.read(cur_article.getDescription())!, "Description") />

		<#assign default_language_id = cur_article.getDefaultLanguageId() />

		<#if title?has_content>
			<#assign title_map = title_map + {default_language_id:title}/>
		</#if>

		<#assign new_article = journal_article_local_service.addArticle(permissionChecker.getUserId(), groupId, article.getFolderId(), title_map, description_map, cur_article.getContent(), cur_article.getStructureId(), cur_article.getTemplateId(), service_context) />

		<#return new_article>
	</#function>

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

	<style>
		.btn-wrapper {
			margin-top: 1.5em;
		}
	</style>
<#recover>
</#attempt>