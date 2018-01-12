<#assign service_context = objectUtil("com.liferay.portal.kernel.service.ServiceContextThreadLocal").getServiceContext() />
<#assign http_servlet_request = service_context.getRequest() />

<#assign title = paramUtil.getString(http_servlet_request, "title", "") />

<#import "${templatesPath}/231368766" as article_utilities>

<#include "${templatesPath}/1561886" />

<div class="press-release-display standard-padding-vertical">
	<a class="cta" href="/press-releases">${languageUtil.format(locale, "back-to-x", localize("press_releases", "Press Releases"))}</a>

	<div class="block-container no-padding">
		<#assign press_release_not_found_text>
			<p class="standard-padding-vertical">
				${localize("press_release_not_found", "Press Release not found.")}
			</p>
		</#assign>

		<@article_utilities.embed_journal_article_by_url_title title press_release_not_found_text />
	</div>
</div>