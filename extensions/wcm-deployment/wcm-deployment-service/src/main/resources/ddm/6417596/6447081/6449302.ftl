<#--
Web content templates are used to lay out the fields defined in a web
content structure.

Please use the left panel to quickly add commonly used variables.
Autocomplete is also available and can be invoked by typing "${".
-->

<#assign UserLocalService = serviceLocator.findService("com.liferay.portal.kernel.service.UserLocalService")>
<#assign RoleLocalService = serviceLocator.findService("com.liferay.portal.kernel.service.RoleLocalService")>

<#assign companyId = company.getCompanyId()>

<#assign adminRole = RoleLocalService.getRole(companyId, "Administrator")>

${adminRole}


<#list .data_model?keys as var>
    ${var}<br />
</#list>