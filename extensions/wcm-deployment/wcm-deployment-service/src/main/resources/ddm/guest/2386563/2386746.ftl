<#include "${templatesPath}/1561886" />

<#assign section_reference = stringUtil.toLowerCase(region.data)>
<#assign section_reference = stringUtil.replace(section_reference, ' ', '-') >

<div class="region-table-wrapper" id="${section_reference}" style="border-top: 3px solid ${region.highlight_color.data};">
	<table style="width: 100%;">
		<tr>
			<th class="element-border element-background region-cell text-left" colspan="4">
				${region.data} <span class="section-id">#${section_reference}</span>
			</th>
		</tr>
		<tr class="header-cells text-left">
			<th class="element-border w25">
				${localize("holiday", "Holiday")}
			</th>
			<th class="element-border w25">
				${first_year.data}
			</th>
			<th class="element-border w25">
				${second_year.data}
			</th>
		</tr>

		<#list region.holiday_title.siblings as holiday>
			<tr>
				<td class="element-border w25">
					${holiday.data}
				</td>
				<td class="element-border w25">
					${holiday.first_year_date.data}
				</td>
				<td class="element-border w25">
					${holiday.second_year_date.data}
				</td>
			</tr>
		</#list>
	</table>
</div>

<style type="text/css">
	.header-cells {
		background: #EEF9FF;
	}

	.region-cell {
		font-weight: bold;
	}

	.region-table-wrapper {
		padding-bottom: 2em;
	}

	.region-table-wrapper tr td, .region-table-wrapper tr th {
		border: 1px solid;
		border-collapse: collapse;
	}

	.region-table-wrapper table th, .region-table-wrapper table td {
		padding: 4px 8px;
		width: 25%;
	}

	.section-id {
		display: none;
	}

	.signed-in.controls-visible .section-id {
		display: inline;
	}
</style>