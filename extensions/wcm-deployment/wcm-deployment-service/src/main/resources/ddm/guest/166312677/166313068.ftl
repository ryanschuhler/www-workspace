<#assign article_namespace = "article${.vars['reserved-article-id'].data}" />
<#assign max_items_per_row = "w25" />

<#if (row_percent.data)?has_content>
	<#assign max_items_per_row = "w${row_percent.data}" />
</#if>

<div class="align-content-stretch block-container justify-center" id="${article_namespace}">
	<#if (main_heading.data)?has_content>
		<h2 class="font-color text-center w100">${main_heading.data}</h2>
	</#if>

	<#list cta_url.siblings as cta>
		<#assign cta_href = "javascript:;" />
		<#assign popup_trigger_class = "pop-up-trigger-" + article_namespace + "-cta-" + (cta_index + 1) />

		<#if cta.data?has_content>
			<#assign cta_href = cta.data />
			<#assign popup_trigger_class = "" />
		</#if>

		<div class="block block-container card-block ${max_items_per_row}">
			<a class="large-padding-vertical cta-${cta_index + 1} cta-block standard-padding-horizontal text-center ${popup_trigger_class}" href="${cta_href}">
				<#if cta.svg_icon.data?has_content>
					<div>${cta.svg_icon.data}</div>
				</#if>

				<#if cta.heading.data?has_content>
					<h3>${cta.heading.data}</h3>
				</#if>

				<#if cta.description.data?has_content>
					<p class="font-color">${cta.description.data}</p>
				</#if>

				<#if cta.cta_text.data?has_content>
					<div class="cta standard-padding-vertical text-center">
						${cta.cta_text.data}
					</div>
				</#if>
			</a>
		</div>
	</#list>
</div>

<style>
#${article_namespace} .cta-block {
	border: 1px solid transparent;
	border-radius: 3px;
	-webkit-transition: all .5s;
	transition: all .5s;
	width: 100%;
}

#${article_namespace} .card-block:hover a {
	text-decoration: none;
}

#${article_namespace} .card-block:hover .cta {
	color: black;
	transition: color 1s;
}

#${article_namespace} .cta {
	font-weight: 400;
	transition: color 1s;
}

<#list cta_url.siblings as cta>
	<#assign hover_color = cta.hover_color.data />

	#${article_namespace} .cta-${cta_index + 1}:hover {
		border-color: ${hover_color};
	}

	#${article_namespace} .cta-${cta_index + 1}:hover h3 {
		color: ${hover_color};
	}

	#${article_namespace} .cta-${cta_index + 1} h3 {
		color: ${cta.heading.heading_color.data};
	}
</#list>

<#assign current_url = "">
<#if request.attributes??>
	<#assign current_url = request.attributes.CURRENT_COMPLETE_URL!"">
</#if>

<#assign count = cta_url.siblings?size />

<#if current_url?contains("/services/training") && (count < 4) >
	#${article_namespace} .block.card-block {
		width: 33.33%;
	}

	#${article_namespace} a.cta-block {
		height: 320px;
	}
<#else>
	@media (min-width: 768px) and (max-width: 1199px) {
		<#if count % 2 = 0>
			#${article_namespace} .card-block {
				width: 50%;
			}
		<#else>
			#${article_namespace} .card-block {
				width: 33.33%;
			}
		</#if>
	}
</#if>
</style>