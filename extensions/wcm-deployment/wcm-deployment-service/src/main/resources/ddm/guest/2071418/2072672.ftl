<style>
.desktop-show.table-wrapper table th {
	border: 1px solid white;
}

.table-wrapper table {
    width: 100%;
}

.table-wrapper table td {
	border: 1px solid #EFEFEF;
}

.table-wrapper table th {
	background: #EFEFEF;
	font-weight: bold;
}

.table-wrapper table th, .table-wrapper table td {
	padding: 4px 8px;
}

.table-wrapper table th:first-of-type {
	border-left: 1px solid #EFEFEF !important;
}

.table-wrapper table th:last-of-type {
	border-right: 1px solid #EFEFEF !important;
}

</style>

<div class="hidden-phone table-wrapper">
	<table>
		<tr>
			<th>
				${title_fields.support_region.data}
			</th>
			<th>
				${title_fields.support_center.data}
			</th>
			<th>
				${title_fields.time_zone.data}
			</th>
			<th>
				${title_fields.standard_days.data}
			</th>
			<th>
				${title_fields.standard_hours.data}
			</th>
		</tr>
		<#list region.siblings as region>
			<tr>
				<td>
					${region.data}
				</td>
				<td>
					${region.center.data}
				</td>
				<td>
					${region.region_time_zone.data}
				</td>
				<td>
					${region.region_standard_days.data}
				</td>
				<td>
					${region.region_standard_hours.data}
				</td>
			</tr>
		</#list>
	</table>
</div>

<div class="visible-phone table-wrapper">
	<table>
		<#list region.siblings as region>
			<tr>
				<th colspan="2">
					${region.data}
				</th>
			</tr>
			<tr>
				<td>
					${title_fields.support_center.data}
				</td>
				<td>
					${region.center.data}
				</td>
			</tr>
			<tr>
				<td>
					${title_fields.time_zone.data}
				</td>
				<td>
					${region.region_time_zone.data}
				</td>
			</tr>
			<tr>
				<td>
					${title_fields.standard_days.data}
				</td>
				<td>
					${region.region_standard_days.data}
				</td>
			</tr>
			<tr>
				<td>
					${title_fields.standard_hours.data}
				</td>
				<td>
					${region.region_standard_hours.data}
				</td>
			</tr>
		</#list>
	</table>
</div>