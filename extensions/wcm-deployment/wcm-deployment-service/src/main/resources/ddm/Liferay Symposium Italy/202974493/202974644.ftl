<div class="block-container justify-center">
	<#if icon.getSiblings()?has_content>
		<#list icon.getSiblings() as cur_icon>
			<div class="block standard-padding text-center w33">
				<div class="rounded-icon-container standard-padding">
				    <img alt="Icon" src="${cur_icon.getData()}" />
				</div>
				<h4 class="rounded-icon-text">
				    ${cur_icon.text.data}
				</h4>
			</div>
		</#list>
	</#if>
</div>

<style>
.rounded-icon-container {
    background-color: #fff;
    width: 100px;
    height: 100px;
    margin: auto;
    border-radius: 50%;
}

.rounded-icon-text {
	padding-top: 1em;
}
</style>