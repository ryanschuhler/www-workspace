<#assign current_url = portal.getCurrentCompleteURL(request) />

<#if (themeDisplay.getURLCurrent()?index_of('/blog') != -1)>
	<#assign current_url = current_url?replace("[&?](regionCategoryName|blogCategoryName|topicCategoryName|title|tags)=", "/", "r") />

	<#if current_url?contains("&") && !current_url?contains("?")>
		<#assign current_url = current_url?replace("&", "?" "f") />
	</#if>

	<#assign page_title = company_name + " " + languageUtil.get(locale, "blogs") />
	<#assign servlet_request_url = portalUtil.getPortalURL(request, portalUtil.isSecure(request)) + "/osb-blogs-web" />

	<#attempt>
		<#if request.getParameter("title")?has_content>
			<#assign servlet_request_url = httpUtil.addParameter(servlet_request_url + "/blogs_entry", "title", request.getParameter("title")) />
		<#else>
			<#assign servlet_request_url = servlet_request_url + "/blogs_entries" />
		</#if>

		<#if request.getParameter("blogCategoryName")?has_content>
			<#assign servlet_request_url = httpUtil.addParameter(servlet_request_url, "blogCategoryName", request.getParameter("blogCategoryName")) />
		</#if>

		<#if request.getParameter("regionCategoryName")?has_content>
			<#assign servlet_request_url = httpUtil.addParameter(servlet_request_url, "regionCategoryName", request.getParameter("regionCategoryName")) />
		</#if>

		<#if request.getParameter("topicCategoryName")?has_content>
			<#assign servlet_request_url = httpUtil.addParameter(servlet_request_url, "topicCategoryName", request.getParameter("topicCategoryName")) />
		</#if>

		<#assign response = httpUtil.URLtoString(servlet_request_url) />

		<#assign json_response = jsonFactoryUtil.looseDeserializeSafe(response) />

		<#if json_response?is_hash>
			<#assign blog_category_name = (json_response.blog.categoryName)!"" />
			<#assign blog_title = (json_response.title)!""/>
			<#assign topic_category_name = (json_response.topic.categoryName)!"" />

			<#if blog_title?has_content && topic_category_name?has_content>
				<#assign open_graph_image = (json_response.smallImageURL)!"" />
				<#assign open_graph_images = stringUtil.split(open_graph_image) />
				<#assign open_graph_title = blog_title />
				<#assign page_description = (json_response.description)!"" />
				<#assign page_title = blog_title + " | " + blog_category_name + " | " + page_title />
			<#elseif blog_category_name?has_content && topic_category_name?has_content>
				<#assign page_description = (json_response.topic.description)!"" />
				<#assign page_title = topic_category_name + " | " + blog_category_name + " | " + page_title />
			<#elseif blog_category_name?has_content>
				<#assign page_description = (json_response.blog.description)!"" />
				<#assign page_title = blog_category_name + " | " + page_title />
			</#if>
		</#if>
	<#recover>
		<#assign page_title = "" />
	</#attempt>
<#else>
	<#assign url_folder_id = request.getParameter("folderId")!"" />
	<#assign url_title = request.getParameter("title")!"" />

	<#if url_folder_id?has_content && url_title?has_content>
		<#assign dl_file_entry_local_service = serviceLocator.findService("com.liferay.portlet.documentlibrary.service.DLFileEntryLocalService") />

		<#assign dl_file_entry = dl_file_entry_local_service.fetchFileEntry(group_id, getterUtil.getLong(url_folder_id), url_title)! />

		<#if dl_file_entry?has_content>
			<#assign dl_file_entry_expando_bridge = dl_file_entry.getExpandoBridge() />

			<#assign open_graph_images = stringUtil.split(get_localized_expando_value(dl_file_entry_expando_bridge, "open_graph_images")!) />
			<#assign page_description = get_localized_expando_value(dl_file_entry_expando_bridge, "seo_description")! />
			<#assign page_title = get_localized_expando_value(dl_file_entry_expando_bridge, "seo_title")! />

			<#if !page_title?has_content>
				<#assign page_title = dl_file_entry.getTitle() + " | " + company_name />
			</#if>
		</#if>
	<#elseif url_title?has_content>
		<#assign journal_article_service = serviceLocator.findService("com.liferay.journal.service.JournalArticleLocalService") />

		<#assign article = journal_article_service.getLatestArticleByUrlTitle(scopeGroupId, url_title, 0)!"" />

		<#if article?has_content>
			<#assign article_expando_bridge = article.getExpandoBridge() />

			<#assign open_graph_images = stringUtil.split(get_localized_expando_value(article_expando_bridge, "open_graph_images")!) />
			<#assign page_description = get_localized_expando_value(article_expando_bridge, "seo_description")! />
			<#assign page_title = get_localized_expando_value(article_expando_bridge, "seo_title")! />

			<#if !page_title?has_content>
				<#assign page_title = article.getTitle(locale) + " | " + company_name />
			</#if>
		</#if>
	<#elseif layout.getTitle(locale)?has_content>
		<#assign page_title = layout.getTitle(locale) />
	</#if>
</#if>

<#if !page_description?has_content>
	<#assign page_description = layout.getDescription(locale) />
</#if>

<#if !page_title?has_content>
	<#assign page_title = the_title + " | " + company_name />

	<#if pageTitle??>
		<#assign page_title = pageTitle + " | " + company_name />
	</#if>
</#if>

<#if !open_graph_images?has_content>
	<#assign open_graph_images = stringUtil.split(get_localized_expando_value(layoutExpandoBridge, "open_graph_images")!) />
</#if>

<#if !open_graph_images?has_content>
	<#assign open_graph_images = stringUtil.split("${images_folder}/custom/open_graph_image.jpg") />
</#if>

<#if !open_graph_title?has_content>
	<#assign open_graph_title = page_title />
</#if>

<#assign open_graph_url = htmlUtil.escape(current_url) />