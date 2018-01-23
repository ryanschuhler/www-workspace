<ul>
<#list .data_model?keys as key>
<li>
  ${key}
  </li>
</#list>
</ul>
 <dl>
<#list request?keys as key>

	<dt>${key}</dt>

	<#assign value = "">
	<dd>
		${key}
	</dd>

</#list>
</dl>