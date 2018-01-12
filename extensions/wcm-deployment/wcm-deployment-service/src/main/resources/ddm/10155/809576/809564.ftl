<#assign service_context = objectUtil("com.liferay.portal.kernel.service.ServiceContextThreadLocal").getServiceContext() />
<#assign http_servlet_request = service_context.getRequest() />

<#import "${templatesPath}/231368766" as article_utilities>

<#assign max_height = "768px" />

<#if height.data?has_content>
	<#assign max_height = height.data />
</#if>

<#assign image_info = "" />
<#assign video_image_info = "" />
<#assign video_info = "" />

<#list media.siblings?reverse as cur_media>
	<#if cur_media.video_type.data?has_content>
		<#assign video_info = video_info + "<source src='" + cur_media.data + "' type='" + cur_media.video_type.data + "'>" />
	<#elseif cur_media.data?has_content>
		<#assign image_info = image_info + "background-image: url(" + cur_media.data + ");" />
		<#assign video_image_info = video_image_info + "<img src='" + cur_media.data + "' >" />
	</#if>
</#list>

<#assign banner_css = "align-center block-container justify-center main-banner no-padding" />
<#assign banner_style = "" />

<#if video_info?has_content && !browserSniffer.isMobile(http_servlet_request)>
	<#assign banner_css = banner_css + " video-banner" />
	<#assign banner_style = "max-height: ${max_height}" />
<#else>
	<#assign banner_style = image_info + "max-height: ${max_height}" />
</#if>

<div class="${banner_css}" id="article-${.vars['reserved-article-id'].data}" style="${banner_style}" >
	<#if video_info?has_content && !browserSniffer.isMobile(http_servlet_request)>
		<video autoplay loop muted height="100%" width="100%" >
			${video_info}
			${video_image_info}
		</video>
	</#if>

	<div class="align-center block-container main-banner-content max-full no-margin w100 ${position.data}">
		<#if heading.data?has_content || subheading.data?has_content || button_text.data?has_content >
			<div class="max-med no-margin no-padding">

				<#if svg_icon.data?has_content>
					${svg_icon.data}
				</#if>

				<#include "${templatesPath}/898140" />

				<#if button_text.data?has_content>
					<div class="${button_alignment.data}">
						<#list button_text.siblings as button>
							<#if button.data?has_content && button.button_link.data?has_content>
								<#assign button_css_class = "btn btn-" + button.button_color.data />
								<#assign button_attrs = "" />

								<#if article_utilities.has_update_permissions()>
									<#assign button_css_class = button_css_class + " live-edit" />
									<#assign button_attrs = button_attrs + "
										data-article-id='${.vars[\"reserved-article-id\"].data}'
										data-level-path='${button.name}::${button_index}'
									" />
								</#if>

								<a class="${button_css_class}" href="${button.button_link.data}" ${button_attrs}>${button.data}</a>
							</#if>
						</#list>
					</div>
				</#if>
			</div>
		</#if>
	</div>
</div>

<style type="text/css">
	<#if css.data?has_content>
		${css.data}
	</#if>
</style>