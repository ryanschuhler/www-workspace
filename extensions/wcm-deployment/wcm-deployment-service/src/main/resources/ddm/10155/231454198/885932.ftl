<#import "${templatesPath}/231368766" as article_utilities>

<#if article_utilities.has_update_permissions()>
	<#assign journal_article_service = serviceLocator.findService("com.liferay.portlet.journal.service.JournalArticleService") />

	<#assign journal_article_service_util = staticUtil["com.liferay.journal.service.JournalArticleLocalServiceUtil"]>

	<#assign service_context = objectUtil("com.liferay.portal.kernel.service.ServiceContextThreadLocal").getServiceContext() />
	<#assign http_servlet_request = service_context.getRequest() />

	<#assign article_id = paramUtil.getString(http_servlet_request, "articleId") />
	<#assign field_name = paramUtil.getString(http_servlet_request, "fieldName") />
	<#assign language_id = paramUtil.getString(http_servlet_request, "languageId") />
	<#assign level_path = paramUtil.getString(http_servlet_request, "levelPath") />
	<#assign value = paramUtil.getString(http_servlet_request, "value") />

	<#assign level_path = stringUtil.split(level_path) />

	<#assign article = journal_article_service_util.getLatestArticle(groupId, article_id) />

	<#assign document = saxReaderUtil.read(article.getContent()) />

	<#assign root_element = document.getRootElement() />

	<#assign dynamic_elements = root_element.elements("dynamic-element") />

	<#list level_path as level>
		<#if level_has_next>
			<#assign current_element = dynamic_elements[getterUtil.getInteger(level)] />

			<#assign dynamic_elements = current_element.elements("dynamic-element") />
		</#if>
	</#list>

	<#assign content = "" />

	<#assign element_count = 0 />

	<#list dynamic_elements as dynamic_element>
		<#if validator.equals(dynamic_element.attributeValue("name"), field_name)>
			<#if element_count == level_path[level_path?size - 1]?number>
				<#assign content = dynamic_element />
			</#if>

			<#assign element_count = element_count + 1 />
		</#if>
	</#list>

	<#assign dynamic_content = content.elements("dynamic-content") />
	<#assign found_language_id = false />

	<#list dynamic_content as dynamic_content_element>
		<#assign content_language_id = dynamic_content_element.attributeValue("language-id") />

		<#if validator.equals(language_id, content_language_id)>
			<#assign void = dynamic_content_element.clearContent() />

			<#assign void = dynamic_content_element.addCDATA(value) />

			<#assign found_language_id = true />
		</#if>
	</#list>

	<#if !found_language_id>
		<#assign dynamic_content_element = content.addElement("dynamic-content") />

		<#assign void = dynamic_content_element.addAttribute("language-id", language_id) />

		<#assign void = dynamic_content_element.addCDATA(value) />

		<#assign available_locales = root_element.attributeValue("available-locales") />

		<#assign available_locales = stringUtil.add(available_locales, language_id) />

		<#assign void = root_element.addAttribute("available-locales", available_locales) />
	</#if>

	<#-- <#assign void = journal_article_service.updateArticle(article.getGroupId(), article.getFolderId(), article.getArticleId(), article.getVersion(), document.formattedString("  "), service_context) /> -->
</#if>