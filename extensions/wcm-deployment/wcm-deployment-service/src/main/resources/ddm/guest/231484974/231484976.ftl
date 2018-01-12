<#import "${templatesPath}/231368766" as article_utilities>

<div class="block-container no-padding portlet-embed-wrapper ${(article_class.data)!}" id="article-${.vars['reserved-article-id'].data}">
	<#list block.siblings as block>
		<#assign count = block_index + 1 />

		<#assign portlet_embed_section_css = "block portlet-embed-section portlet-embed-section-${count} ${block.block_class.data} w100" />

		<div class="${portlet_embed_section_css}" ${block.data} >
			<#list block.portlet_embed.siblings as cur_portlet_embed>
				<#if cur_portlet_embed.portlet_name.data?has_content>
					<#assign instance_id = "${.vars['reserved-article-id'].data}-${count}-${cur_portlet_embed_index}" />

					<runtime-portlet name="${cur_portlet_embed.portlet_name.data}" instance="${instance_id}" queryString="${cur_portlet_embed.query_string.data}" />
				<#elseif cur_portlet_embed.article_url_title?has_content>
					<@article_utilities.embed_journal_article_by_url_title cur_portlet_embed.article_url_title.data />
				</#if>
			</#list>
		</div>
	</#list>
</div>