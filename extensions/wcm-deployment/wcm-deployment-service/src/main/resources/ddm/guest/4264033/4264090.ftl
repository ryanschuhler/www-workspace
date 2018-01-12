<a class="training-card block-container no-padding align-center justify-center ${card_class.data} ${card_color.data}" href="${cta_link.data}">
	<div class="icon standard-padding">
		<#if svg_icon.data?has_content>
			${svg_icon.data}
		</#if>
	</div>
	<div class="content small-padding">
		<#if card_title.data?has_content || card_content.data?has_content>
			<h5>${card_title.data}</h5>
				<p>${card_content.data}</p>
			<div class="cta">
				${cta_text.data}
			</div>
		</#if>
	</div>
</a>