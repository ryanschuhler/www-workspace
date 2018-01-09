<#assign service_context = staticUtil["com.liferay.portal.kernel.service.ServiceContextThreadLocal"].getServiceContext() />
<#assign http_servlet_request = service_context.getRequest() />

<#import "${templatesPath}/231368766" as article_utilities>

<div class="bento block-container no-padding ${(article_class.data)!}" id="article-${.vars['reserved-article-id'].data}">
	<#list block.siblings as block>
		<#assign image_info = "" />
		<#assign video_image_info = "" />
		<#assign video_info = "" />

		<#list block.media.siblings?reverse as cur_media>
			<#if cur_media.video_type.data?has_content>
				<#assign video_info = video_info + "<source src='" + cur_media.data + "' type='" + cur_media.video_type.data + "'>" />
			<#elseif cur_media.data?has_content>
				<#assign image_info = image_info + "background-image: url(" + cur_media.data + ");" />
				<#assign video_image_info = video_image_info + "<img src='" + cur_media.data + "' >" />
			</#if>
		</#list>

		<#assign bento_section_css = "bento-section bento-section-${block_index + 1} block ${block.background_color.data} ${block.width.data} ${block.block_class.data}" />
		<#assign bento_section_style = "" />

		<#if video_info?has_content && !browserSniffer.isMobile(http_servlet_request) && !browserSniffer.isIe(http_servlet_request)>
			<#assign bento_section_css = bento_section_css + " video-banner" />
		<#else>
			<#assign bento_section_style = "style='${image_info}'" />
		</#if>

		<div class="${bento_section_css}" ${bento_section_style} ${block.data}>
			<#if video_info?has_content && !browserSniffer.isMobile(http_servlet_request) && !browserSniffer.isIe(http_servlet_request)>
				<video autoplay class="background-video" height="100%" loop muted width="100%">
					${video_info}
					${video_image_info}
				</video>
			</#if>

			<#if block.article_url_title.data?has_content>
				<#list block.article_url_title.siblings as article_url_title>
					<@article_utilities.embed_journal_article_by_url_title article_url_title.data />
				</#list>
			</#if>

			<#if block.article_id.data?has_content>
				<#list block.article_id.siblings as article_id>
					<@article_utilities.embed_journal_article_by_article_id article_id.data />
				</#list>
			</#if>
		</div>
	</#list>
</div>

<#if css.data?has_content>
	<style type="text/css">
		${css.data}
	</style>
</#if>