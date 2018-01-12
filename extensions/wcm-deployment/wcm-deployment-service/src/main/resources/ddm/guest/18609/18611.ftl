<#import "${templatesPath}/231368766" as article_utilities>

<#assign has_update_permissons = article_utilities.has_update_permissions() />

<div class="align-center block-container exhibit-group justify-center section-padding" id="article-${.vars['reserved-article-id'].data}">
	<#include "${templatesPath}/898140" />

	<div class="align-baseline block-container justify-center w100">
		<#list block_title.siblings as block>
			<#assign block_css_class = "block exhibit standard-padding w${row_percent.data}"/>

			<#if !block.block_link_text.data?has_content && !block.block_button_text.data?has_content>
				<#assign block_css_class = block_css_class + " text-center"/>
			</#if>

			<#if block.animation.data?has_content>
				<#assign block_css_class = block_css_class + " on-screen-helper slide-up" />
			</#if>

			<div class="${block_css_class}">
				<#assign block_url = block.block_link_text.block_link_url.data! />

				<#if block.svg_code.data?has_content>
					<#if block_url?has_content>
						<a class="block block-link" href="${block_url}">
					</#if>
						<div class="exhibit-media">
							${block.svg_code.data}
						</div>
					<#if block_url?has_content>
						</a>
					</#if>
				</#if>

				<div class="exhibit-body">
					<#if block.data?has_content>
						<#assign heading_css_class = "" />
						<#assign heading_attrs = "" />

						<#if has_update_permissons>
							<#assign heading_css_class = heading_css_class + " live-edit" />
							<#assign heading_attrs = heading_attrs + "
								data-article-id='${.vars[\"reserved-article-id\"].data}'
								data-level-path='${block.name}::${block_index}'
							" />
						</#if>

						<#if block_url?has_content>
							<a class="block block-link font-color" href="${block_url}">
						</#if>
							<h3 class="${heading_css_class}" ${heading_attrs}>
								${block.data}
							</h3>
						<#if block_url?has_content>
							</a>
						</#if>
					</#if>

					<#if block.block_content.data?has_content>
						<#assign content_css_class = "" />
						<#assign content_attrs = "" />

						<#if has_update_permissons>
							<#assign content_css_class = content_css_class + " live-edit" />
							<#assign content_attrs = content_attrs + "
								data-article-id='${.vars[\"reserved-article-id\"].data}'
								data-level-path='${block.name}::${block_index},${block.block_content.name}::0'
							" />
						</#if>

						<p class="${content_css_class}" ${content_attrs}>
							${block.block_content.data}
						</p>
					</#if>

					<#if block.block_link_text.data?has_content>
						<#list block.block_link_text.siblings as block_link>
							<#assign cta_css_class = "cta cta-primary" />
							<#assign cta_attrs = "" />

							<#if has_update_permissons>
								<#assign cta_css_class = cta_css_class + " live-edit" />
								<#assign cta_attrs = cta_attrs + "
									data-article-id='${.vars[\"reserved-article-id\"].data}'
									data-level-path='${block.name}::${block_index},${block_link.name}::${block_link_index}'
								" />
							</#if>

							<a class="${cta_css_class}" href="${block_link.block_link_url.data}" ${cta_attrs}>${block_link.data} <svg class='cta-icon' height='10' width='8'><use xlink:href='#caret' /></svg></a>
						</#list>
					</#if>

					<#if block.block_button_text.data?has_content>
						<#assign btn_css_class = "btn btn-sm standard-margin-vertical " + block.block_button_text.block_button_color.data />
						<#assign btn_attrs = "" />

						<#if has_update_permissons>
							<#assign btn_css_class = btn_css_class + " live-edit" />
							<#assign btn_attrs = btn_attrs + "
									data-article-id='${.vars[\"reserved-article-id\"].data}'
									data-level-path='${block.name}::${block_index},${block.block_button_text.name}::0'
								" />
						</#if>

						<div>
							<a class="${btn_css_class}" href="${block.block_button_text.block_button_url.data}" ${btn_attrs}>${block.block_button_text.data}</a>
						</div>
					</#if>
				</div>
			</div>
		</#list>
	</div>

	<#if button_text.data?has_content && button_text.button_url.data?has_content>
		<#assign button_css_class = "btn standard-margin-vertical " + button_text.button_color.data />
		<#assign button_attrs = "" />

		<#if has_update_permissons>
			<#assign button_css_class = button_css_class + " live-edit" />
			<#assign button_attrs = button_attrs + "
				data-article-id='${.vars[\"reserved-article-id\"].data}'
				data-level-path='${button_text.name}::0'
			" />
		</#if>

		<a class="${button_css_class}" href="${button_text.button_url.data}" ${button_attrs}>
			${button_text.data}
		</a>
	</#if>
</div>