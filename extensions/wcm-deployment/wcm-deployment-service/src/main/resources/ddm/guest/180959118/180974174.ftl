<#assign http_servlet_request = objectUtil("com.liferay.portal.kernel.service.ServiceContextThreadLocal").getServiceContext().getRequest() />

<#assign view_count = getterUtil.getInteger(sessionClicks.get(http_servlet_request, "#article-${.vars['reserved-article-id'].data}", "0")) />

<#assign max_count = getterUtil.getInteger(promo_options.display_max_count.data) />

<#if max_count == 0>
	<#assign max_count = 99999>
</#if>

<#if (view_count <= max_count) && getterUtil.getBoolean((language_options[locale].data)!)>
	<#assign VOID = sessionClicks.put(http_servlet_request, "#article-${.vars['reserved-article-id'].data}", "${view_count + 1}") />

	<#assign importance = jsonFactoryUtil.createJSONArray(promo_options.importance.data).getString(0) />

	<#assign importance_css_property = "z-index: ${importance};" />

	<style type="text/css">
		#article-${.vars['reserved-article-id'].data} {
			background: ${promo_options.background_color.data};
			bottom: 0;
			height: 40px;
			left: 0;
			overflow: hidden;
			position: fixed;
			text-align: center;
			text-decoration: none;
			width: 100%;
			${importance_css_property}
		}
		#article-${.vars['reserved-article-id'].data}:hover {
			filter: brightness(0.9);
		}
		#article-${.vars['reserved-article-id'].data} .announcement-text {
			font-size: 1em;
			padding: 0 15px;
		}
		@media (max-width: 480px) {
			#article-${.vars['reserved-article-id'].data} .announcement-text {
				font-size: 0.7em;
			}
		}
	</style>

	<a class="align-center block-container justify-center light-color no-padding" href="${promo_content.promo_link.data}" id="article-${.vars['reserved-article-id'].data}" target="_blank">
		<span class="announcement-text light-text">
			${promo_content.promo_text.data}
		</span>
	</a>
</#if>