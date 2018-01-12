<#assign layout_local_service = serviceLocator.findService("com.liferay.portal.kernel.service.LayoutLocalService") />

<#assign theme_display = request["theme-display"] />
<#assign plid = theme_display["plid"]?number />
<#assign curr_layout = layout_local_service.getLayout(plid?number) />

<#assign ownerId = 0 />
<#assign ownerType = 3 />

<#import "${templatesPath}/231368766" as article_utilities>

<#if article_utilities.has_update_permissions()>
	<#assign service_context = objectUtil("com.liferay.portal.kernel.service.ServiceContextThreadLocal").getServiceContext() />
	<#assign http_servlet_request = service_context.getRequest() />

	<#assign friendly_url = paramUtil.getString(http_servlet_request, "friendlyURL") />
	<#assign url_title = paramUtil.getString(http_servlet_request, "urlTitle") />
	<#assign article_id = paramUtil.getString(http_servlet_request, "articleId") />

	<#assign journal_article_local_service = serviceLocator.findService("com.liferay.portlet.journal.service.JournalArticleLocalService") />

	<div class="standard-padding">
		<h1>Web Content Search Tool</h1>

		<form id="article-search">
			<label for="friendlyURL">Layout Friendly URL</label>
			<input class="friendly-url" type=text length=40 id="friendlyURL" value="${friendly_url}">

			<label for="articleId">Article ID</label>
			<input class="article-id" type=text length=40 id="articleId" value="${article_id}">

			<label for="urlTitle">Article URL Title</label>
			<input class="url-title" type=text length=40 id="urlTitle" value="${url_title}">

			<div class="left standard-padding-vertical">
				<a class="btn" onclick="findStuffAndThings()">Search</a>
			</div>
		</form>
	</div>

	<#if friendly_url?has_content >
		<#assign layout = layout_local_service.getFriendlyURLLayout(groupId, false, friendly_url)! />

		<div class="standard-padding">
			<#if layout?has_content>
				<h2>Articles on ${friendly_url}</h2>
				<h3>Layout PLID ${layout.getPlid()}</h3>

				<#assign type_settings_properties = layout.getTypeSettingsProperties() />

				<#assign portlet_preferences_local_service = serviceLocator.findService("com.liferay.portal.kernel.service.PortletPreferencesLocalService") />

				<table class="table table-condensed">
					<thead>
						<tr class="first">
							<th class="first">
								Title
							</th>
							<th>
								Article ID
							</th>
							<th>
								Portlet ID
							</th>
							<th class="last">
								Embedded Article(s)
							</th>
						</tr>
					</thead>

					<tbody>
						<#list type_settings_properties?keys as key>
							<#assign type_setting = type_settings_properties[key] />

							<#if type_setting?contains("56_INSTANCE_")>
								<#list type_setting?split(",") as portlet_id>
									<#if portlet_id?contains("56_INSTANCE_")>
										<#assign portlet_preferences = portlet_preferences_local_service.getPortletPreferences(ownerId, ownerType, layout.getPlid(), portlet_id) />

										<#assign document = saxReaderUtil.read(portlet_preferences.getPreferences()) />

										<#assign root_element = document.getRootElement() />

										<#assign preferences = root_element.elements("preference") />

										<#list preferences as pref>
											<#assign element_name = pref.element("name") />

											<#if element_name.getText() == "articleId">
												<#assign pref_article_id = pref.element("value").getText()?string>

												<#assign pref_article = journal_article_local_service.getArticle(groupId, pref_article_id)! />

												<#if pref_article?has_content>
													<#assign edit_url = article_utilities.get_edit_url(pref_article) />

													<tr>
														<td>
															<a href="${edit_url}">${pref_article.getTitle(pref_article.getDefaultLanguageId())}</a>
														</td>
														<td>
															<a href="${edit_url}">${pref_article_id}</a>
														</td>
														<td>
															${portlet_id}
														</td>
														<td>
															<#assign prefArticle = saxReaderUtil.read(pref_article.getContent()) />

															<#assign embedded_article_nodes = prefArticle.selectNodes("//dynamic-element[@name='article_id']") />

															<#list embedded_article_nodes as embedded_article_node>
																<#assign embedded_article_id = embedded_article_node.selectSingleNode("dynamic-content") />

																<#if embedded_article_id.data?has_content>
																	<#assign embedded_article = journal_article_local_service.getArticle(groupId, embedded_article_id.data)! />

																	<a href="${article_utilities.get_edit_url(embedded_article)}">${embedded_article.getArticleId()}</a><br/>
																</#if>
															</#list>
														</td>
													</tr>
												</#if>
											</#if>
										</#list>
									</#if>
								</#list>
							</tbody>
						</#if>
					</#list>
				</table>
			<#else>
				Layout not found.
			</#if>
		</div>
	</#if>

	<#assign article = "" />

	<#if article_id?has_content>
		<#assign article = journal_article_local_service.getArticle(groupId, article_id)! />
	<#elseif url_title?has_content>
		<#assign article = journal_article_local_service.fetchArticleByUrlTitle(groupId, url_title)! />
	</#if>

	<div class="standard-padding">
		<#if article?has_content>
			<#assign journal_article_content_search_local_service = serviceLocator.findService("com.liferay.portlet.journal.service.JournalContentSearchLocalService") />

			<h2>Layouts using web content</h2>
			<h3>Title: ${article.getTitle(article.getDefaultLanguageId())}</h3>

			<p>Article ID: ${article.getArticleId()}</p>
			<p>URL Title: ${article.getUrlTitle()}</p>

			<#assign article_searches = journal_article_content_search_local_service.getArticleContentSearches(groupId, article.getArticleId()) />

			<table class="table table-condensed">
				<thead>
					<tr class="first">
						<th>
							Friendly URL
						</th>
						<th class="last">
							Layout PLID
						</th>
					</tr>
				</thead>

				<tbody>
					<#list article_searches as article_search>
						<#assign layout = layout_local_service.getLayout(groupId, false, article_search.getLayoutId() ) />

						<tr>
							<td>
								<a href="${layout.getFriendlyURL()}">${layout.getFriendlyURL()}</a>
							</td>
							<td>
								${layout.getPlid()}
							</td>
						</tr>
					</#list>
				</tbody>
			</table>
		<#elseif article_id?has_content>
			Article not found with article ID ${article_id}.
		<#elseif url_title?has_content>
			Article not found with URL title ${url_title}.
		</#if>
	</div>

	<script>
	function addParameterToURL(url, param, value){
		_url = url;
		_url += (_url.split('?')[1] ? '&':'?') + param + '=' + value;

		return _url;
	}

	function findStuffAndThings() {
		var friendlyURL = document.getElementById("friendlyURL");
		var urlTitle = document.getElementById("urlTitle");
		var articleId = document.getElementById("articleId");

		var currentURL = location.protocol + '//' + location.host + location.pathname;

		if (friendlyURL.value) {
			currentURL = addParameterToURL(currentURL, "friendlyURL", friendlyURL.value);
		}

		if (articleId.value) {
			currentURL = addParameterToURL(currentURL, "articleId", articleId.value);
		}
		if (urlTitle.value) {
			currentURL = addParameterToURL(currentURL, "urlTitle", urlTitle.value);
		}

		window.location = currentURL;
	}
	</script>
</#if>