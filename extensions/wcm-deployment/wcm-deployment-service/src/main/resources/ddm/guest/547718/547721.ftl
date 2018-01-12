<div class="block exhibit">
	<#if logo.data?has_content>
		<img src="${logo.data}" />
	</#if>

	<#if title.data?has_content>
		<h2>${title.data}</h2>
	</#if>

	<#if description.data?has_content>
		<p class="max-med">${description.data}</p>
	</#if>

	<#if info_link.data?has_content>
		<a class="btn" href="${info_link.data}">${info_link.info_label.data}</a>
	</#if>

	<#if download_link.getSiblings()?has_content>
	<form>
		<select>
			<#list download_link.getSiblings() as download>
				<option value="${download.data}">${download.download_label.data}</option>
			</#list>

			<input class="btn" type="submit" />
		</select>
	</form>
	</#if>
</div>