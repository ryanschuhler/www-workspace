<#if Photo.getSiblings()?has_content>
	<#list Photo.getSiblings() as cur_Photo>
		<div class="photo-background" style="background:url(${cur_Photo.getData()}) no-repeat fixed center center; background-size: cover;"></div>
	</#list>
</#if>

<style>
	.photo-background {
		height: 80vh;
		width: 100%;
	}
</style>