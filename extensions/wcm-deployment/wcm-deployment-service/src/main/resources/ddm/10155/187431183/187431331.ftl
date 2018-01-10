<#assign journal_article_local_service = serviceLocator.findService("com.liferay.portlet.journal.service.JournalArticleLocalService") />

<#import "${templatesPath}/231368766" as article_utilities>

<div class="cta-block cta-ribbon">
	<svg class="ribbon-svg" min-width="1440px" width="100%" height="259" viewBox="0 0 1440 259" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="none" style="mix-blend-mode:multiply">
		<defs>
			<linearGradient x1="77.212%" y1="-27.043%" x2="33.994%" y2="183.95%" id="linear-blue">
				<stop stop-color="#22386D" offset="0%"></stop>
				<stop stop-color="#2A488C" offset="100%"></stop>
			</linearGradient>
		</defs>

		<path d="M1440 302C1207.37 342.754 428.43 426.7 0 342v214.383c508.207 9.312 872.277 3.02 1440-34.383V302z" transform="translate(0 -302)" fill="url(#linear-blue)" fill-rule="evenodd" id="yui_patched_v3_11_0_1_1461797614539_1230"></path>
	</svg>

	<#assign content_padding = "7em 1em 4em" />

	<div class="content">
		<#if article_id.data?has_content && journal_article_local_service.hasArticle(groupId, article_id.data)>
			<#assign content_padding = "10em 1em 5em" />

			<@article_utilities.runtime_embed_journal_article_by_article_id article_id.data />
		</#if>

		<div class="cta-wrapper standard-padding">
			<a class="cta cta-light text-center" href="${cta_url.data}">${cta_text.data} <svg class="cta-icon" height="22" width="12" id="yui_patched_v3_11_0_1_1462203626458_731"><use xlink:href="#caret" id="yui_patched_v3_11_0_1_1462203626458_730"></use></svg></a>
		</div>
	</div>
</div>

<style type="text/css">
	.cta-ribbon {
		overflow: hidden;
		position: relative;
	}

	.cta-ribbon .content {
		padding: ${content_padding};
		position: relative;
	}

	.cta-ribbon .cta-wrapper a {
		display: block;
		font-size: 2.25em;
		font-weight: lighter;
		line-height: 1;
		position: relative;
		text-decoration: none;
		width: 100%;
		z-index: 1;
	}

	.cta-ribbon .ribbon-svg {
		height: 100%;
		min-width: 1000px;
		position: absolute;
	}
</style>