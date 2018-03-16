<#assign journal_article_local_service = serviceLocator.findService("com.liferay.journal.service.JournalArticleLocalService") />

<#import "${templatesPath}/231368766" as article_utilities>

<div class="content-hub">
	<#if article_url_title?has_content>
		<#list article_url_title.siblings as cur_article_url_title>
			<#if cur_article_url_title.data?has_content>
				<#assign article = journal_article_local_service.getArticleByUrlTitle(groupId, cur_article_url_title.data)! />

				<@wrap_article article article_url_title cur_article_url_title_index />
			</#if>
		</#list>
	</#if>

	<#if article_ids?has_content>
		<#list article_ids.siblings as cur_article_id>
			<#if cur_article_id.data?has_content>
				<#assign article = journal_article_local_service.getArticle(groupId, cur_article_id.data)! />

				<@wrap_article article article_ids cur_article_id_index />
			</#if>
		</#list>
	</#if>

	<#if related_resource.siblings?has_content || sources.siblings?has_content>
		<div class="max-med related-resources-sources standard-padding">
			<#if related_resource.data?has_content>
				<div class="related-resources standard-padding">
					<#assign resources_title = '${languageUtil.get(locale, "related-resources", "Related Resources")}' />

					<h2>${resources_title}</h2>

					<ul class="resource-list unstyled">
						<#list related_resource.siblings as cur_related_resource>
							<li><a href="${cur_related_resource.resource_url.data}">${cur_related_resource.data}</a></li>
						</#list>
					</ul>
				</div>
			</#if>

			<#if sources.data?has_content>
				<div class="alt-font-color sources standard-padding">
					<#assign sources_title = '${languageUtil.get(locale, "sources", "Sources")}' />

					<h5 class="small-caps">${sources_title}</h5>

					<ul class="source-list unstyled">
						<#list sources.siblings as cur_source>
							<li>${cur_source_index + 1}. ${cur_source.data}</li>
						</#list>
					</ul>
				</div>
			</#if>
		</div>
	</#if>
</div>

<#macro wrap_article article article_identifier index>
	<#assign css_class = "article-wrapper" />

	<#if index == 1>
		<div class="large-padding-vertical scroll-nav-content-container">

		<#assign css_class = "nav-article-wrapper" />
	</#if>

	<#if index == 2>
		<div class="content-wrapper">
	</#if>

	<div class="${css_class}">
		<@article_utilities.embed_journal_article article />
	</div>

	<#assign end_content = article_identifier.siblings?size - 2 />

	<#if index == end_content>
			</div>
		</div>
	</#if>
</#macro>

<style type="text/css">
	.article-wrapper {
		position: relative;
	}

	.aui .quote-section .source-text {
		font-size: 0.8em;
		margin-bottom: 0;
		margin-top: 0;
		padding: 1em 0;
	}

	.aui .quote-section .source-text a {
		border-bottom-width: 0;
	}

	.content-hub .content-wrapper table {
		display: block;
		overflow: auto;
	}

	.content-hub .content-wrapper table p {
		font-size: 1em;
		line-height: 20px;
	}

	.content-hub .quote-section {
		background-color: #EEF3F5;
	}

	.content-hub .quote-section .quote {
		color: #46718A;
		text-align: center;
	}
</style>