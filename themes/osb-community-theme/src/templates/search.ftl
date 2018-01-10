<#if (group_id == guest_group_id) || page_group.isUser()>
	<#assign portlet_id = "1_WAR_googlesearchapplianceportlet_INSTANCE_0000" />
	<#assign namespace = "_${portlet_id}_" />

	<#assign keywords = paramUtil.getString(request, "${namespace}keywords") />

	<#assign actionURL = portalUtil.getLayoutFullURL(themeDisplay) />

	<form action="${actionURL}" class="doc-search" method="get" name="${namespace}themeFm" onSubmit="event.preventDefault(); ${namespace}themeSearch();">
		<input name="p_p_id" type="hidden" value="${portlet_id}" />
		<input name="p_p_lifecycle" type="hidden" value="0" />
		<input name="p_p_state" type="hidden" value="maximized" />

		<input class="doc-search-input" name="${namespace}keywords" placeholder="<@liferay_ui.message key="search" />" value="${htmlUtil.escapeAttribute(keywords)}" />

		<a class="submit-search" href="javascript:;" onClick="event.preventDefault(); ${namespace}themeSearch();">
			<svg height="40" width="32"><use xlink:href="#searchIcon"></use></svg>
		</a>
	</form>

	<script type="text/javascript">
		function ${namespace}themeSearch() {
			var keywords = document.${namespace}themeFm.${namespace}keywords.value;

			if (keywords != '') {
				document.${namespace}themeFm.submit();
			}
		}
	</script>
<#else>
	${theme.search()}
</#if>