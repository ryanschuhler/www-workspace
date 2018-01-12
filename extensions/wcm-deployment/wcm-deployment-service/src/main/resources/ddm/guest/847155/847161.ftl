<#include "${templatesPath}/1561886" />

<div class="office standard-padding" typeof="Organization" vocab="http://schema.org/">
	${flag.data}

	<h2 property="addressLocality">${office_title.data}</h2>
	<div property="name">${company_title.data}</div>

	<address property="address" typeof="PostalAddress">
		<div>${address.data}</div>

		<#list address.additional_line.siblings as line>
			<div>${line.data}</div>
		</#list>

		<#list phone.getSiblings() as cur_phone>
			<#if getterUtil.getBoolean(cur_phone.fax.data)>
				<div property="faxNumber">${localize("fax", "Fax")}: ${cur_phone.data}</div>
			<#else>
				<div property="telephone">${localize("tel", "Tel")}: ${cur_phone.data}</div>
			</#if>
		</#list>
	</address>

	<#if office_hours.data?has_content>
		<div>${localize("office-hours", "Office Hours")}: ${office_hours.data}</div>
	</#if>

	<#if additional_details.data?has_content>
		<#list additional_details.siblings as detail>
			<div>${detail.data}</div>
		</#list>
	</#if>
</div>