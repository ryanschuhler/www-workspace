<div class="block-container justify-center">
	<#if icon.getSiblings()?has_content>
		<#list icon.getSiblings() as cur_icon>
			<div class="block block-container justify-center w25">
				<div><img class="rounded-image" alt="Icon" src="${cur_icon.getData()}" /></div>
				${cur_icon.text.data}
			</div>
		</#list>
	</#if>
</div>

<style>
.rounded-image {
	background: #FFF;
	border-radius: 50%;
	height: 100px;
	padding: 10px 10px;
	vertical-align: middle;
	width: 60%;
}
</style>