<#if collection_title.data?has_content>
	<h2 class="text-center">${collection_title.data}</h2>
</#if>

<div class="block-container justify-center logo-collection-container">
	<#if Documents_and_Media1950.getSiblings()?has_content>
	<#list Documents_and_Media1950.getSiblings() as cur_Documents_and_Media1950>
			<div class="w25">
				<img src="${cur_Documents_and_Media1950.getData()}">
			</div>
		</#list>
	</#if>
</div>

<style>
	.logo-collection-container {
		margin: auto;
		max-width: 600px;
	}
</style>