<style type="text/css">
	.resultset td, .resultset th {
		border: 1px solid gray;
		padding: 1em;
	}
</style>

<#assign query_string = httpUtil.getQueryString(request.attributes['CURRENT_URL'])>
<#assign params_map = httpUtil.getParameterMap(query_string)>

<h1> SQL Query</h1>
<form action="${request['render-url']}">
	<textarea class="block-container" cols=100 name="query" rows=4>
		<#if params_map.query??>
			${params_map.query[0]}

		<#else>
		select * from OSB_SocialLink
		</#if>
	</textarea>
	<input class="block-container" type="submit">
</form>

<#if params_map.query??>
	<#assign query = params_map.query[0]>
	<#assign data_access = staticUtil["com.liferay.portal.kernel.dao.jdbc.DataAccess"]>
	<#assign con = data_access.getUpgradeOptimizedConnection()>
	<#assign st = con.createStatement()>
	<#assign rs = st.executeQuery(query)>

	<h1> Results for ${query}</h1>
	<#assign metadata = rs.getMetaData()>
	<#assign num_columns = metadata.getColumnCount()>
	<table class="resultset">
		<tr>
			<#list 1..num_columns as column_number>
				<th>
					${metadata.getColumnName(column_number)}
				</th>
			</#list>
		</tr>
	<#list 1..100 as x>
		<#assign another_record = rs.next()>
		<#if another_record> 
			<tr>
				<#list 1..num_columns as column_number>
					<td> ${rs.getString(column_number)!}</td>
				</#list>
			</tr>
		<#else>
			<#break>
		</#if>
	</#list>
	</table>
	<#assign VOID = data_access.cleanUp(con, st)>
</#if>