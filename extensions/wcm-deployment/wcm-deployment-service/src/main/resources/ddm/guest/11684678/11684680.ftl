<#assign article_id = .vars["reserved-article-id"].data />

<div class="align-center block-container justify-center large-padding primary-background training-banner">
	<article class="block text-center w40">
		${general_course_info.course_svg.data}
	</article>

	<article class="block w60">
		<#assign course_title_data = "
			data-article-id='${article_id}'
			data-level-path='${general_course_info.course_title.name}::0'
		" />
		<h1 class="live-edit" ${course_title_data}>
			${general_course_info.course_title.data}
		</h1>

		<#assign course_quick_description_data = "
			data-article-id='${article_id}'
			data-level-path='${general_course_info.course_quick_description.name}::0'
		" />
		<h2 class="live-edit" ${course_quick_description_data}>${general_course_info.course_quick_description.data}</h2>

		<p>
			<#assign length_of_course_data = "
				data-article-id='${article_id}'
				data-level-path='${general_course_info.length_of_course.name}::0'
			" />

			<@liferay.language key="length" />:
			<span class="live-edit" ${length_of_course_data}>
				<strong>${general_course_info.length_of_course.data}</strong>
			</span> <br />

			<#assign course_formats_data = "
				data-article-id='${article_id}'
				data-level-path='${general_course_info.course_formats.name}::0'
			" />

			<@liferay.language key="formats" />:
			<span class="live-edit" ${course_formats_data}>
				<strong>${general_course_info.course_formats.data}</strong>
			</span> <br />

			<#assign liferay_version_data = "
				data-article-id='${article_id}'
				data-level-path='${general_course_info.liferay_version.name}::0'
			" />

			<@liferay.language key="liferay-versions" />:
			<span class="live-edit" ${liferay_version_data}>
				<strong>${general_course_info.liferay_version.data}</strong>
			</span> <br />

			<#if general_course_info.prerequisites.data?has_content>
				<#assign prerequisites_data = "
					data-article-id='${article_id}'
					data-level-path='${general_course_info.prerequisites.name}::0'
				" />
				<span class="live-edit" ${prerequisites_data}>
					Prerequisites: ${general_course_info.prerequisites.data}
				</span>
			</#if>
		</p>

		<div class="small-padding-vertical">
				<#assign course_disclaimer_data = "
					data-article-id='${article_id}'
					data-level-path='${general_course_info.course_disclaimer.name}::0'
				" />
			<p class="disclaimer live-edit" ${course_disclaimer_data}>
				${general_course_info.course_disclaimer.data}
			</p>
		</div>
	</article>
</div>

<div class="block-container no-padding">
	<article class="align-center block block-container element-background large-padding w50">
		<#list course_details.feature_point.siblings as point>
			<aside class="small-padding-vertical w100">
				<#assign point_title_data = "
					data-article-id='${article_id}'
					data-level-path='${point.point_title.name}::${point_index}'
				" />
				<h3 class="live-edit small-padding-vertical" ${point_title_data}>
					${point.point_title.data}
				</h3>

				<#assign point_description_data = "
					data-article-id='${article_id}'
					data-level-path='${point.point_description.name}::${point_index}'
				" />
				<p class="live-edit point-description" ${point_description_data}>
					${point.point_description.data}
				</p>
			</aside>
		</#list>

		<aside class="small-padding-vertical">
			<p>
				<strong><@liferay.language key="laptop-requirements" /></strong> <br />
				<#assign line_data = "
					data-article-id='${article_id}'
					data-level-path='${course_details.laptop_requirements.name}::0'
				" />

				<span class="live-edit" ${line_data}>
					${course_details.laptop_requirements.data?replace("\n", "<br>")}
				</span>
			</p>

			<#assign laptop_disclaimer_data = "
				data-article-id='${article_id}'
				data-level-path='${course_details.laptop_disclaimer.name}::0'
			" />
			<p class="disclaimer live-edit" ${laptop_disclaimer_data}>
				${course_details.laptop_disclaimer.data}
			</p>
		</aside>
	</article>

	<article class="block block-container large-padding w50">
		<#if course_details.classes_article_id.data?has_content>
			${journalContentUtil.getContent(groupId, course_details.classes_article_id.data, "", locale, xmlRequest)}
		</#if>
	</article>
</div>

<div class="block-container border-blocks no-padding">
	<article class="align-center block block-container justify-center no-padding target-positions w33">
		<article class="small-padding">
			<svg height="80" viewBox="0 0 80 80" width="80" xmlns="http://www.w3.org/2000/svg" ><path fill="#F5A11D" d="M40 12c15.4 0 28 12.6 28 28S55.4 68 40 68 12 55.4 12 40s12.6-28 28-28m0-8C20.1 4 4 20.1 4 40s16.1 36 36 36 36-16.1 36-36S59.9 4 40 4z"/><path fill="#F5A11D" d="M40 28c6.6 0 12 5.4 12 12s-5.4 12-12 12-12-5.4-12-12 5.4-12 12-12m0-8c-11 0-20 9-20 20s9 20 20 20 20-9 20-20-9-20-20-20z"/><path fill="#F5A11D" d="M40 36c-2.2 0-4 1.8-4 4s1.8 4 4 4 4-1.8 4-4-1.8-4-4-4z"/></svg>
		</article>

		<article class="standard-padding">
			<h3><@liferay.language key="best-for" /></h3>

			<ul class="no-margin">
				<#list course_details.target_positions.position.siblings as position>
					<#assign position_data = "
						data-article-id='${article_id}'
						data-level-path='${position.name}::${position_index}'
					" />
					<li class="live-edit" ${position_data}>
						${position.data}
					</li>
				</#list>
			</ul>
		</article>
	</article>

	<article class="block block-container w33">
		<#if course_details.advertisement_article_id.data?has_content>
			${journalContentUtil.getContent(groupId, course_details.advertisement_article_id.data, "", locale, xmlRequest)!}
		</#if>
	</article>

	<article class="block block-container element-background large-padding text-center w33">
		<#if course_details.quote_article_id.data?has_content>
			${journalContentUtil.getContent(groupId, course_details.quote_article_id.data, "", locale, xmlRequest)!}
		</#if>
	</article>

</div>

<#if course_agenda.agenda_heading?? && course_agenda.agenda_heading.data?has_content>
	<div class="large-padding-vertical text-center w100">
		<h1>${course_agenda.agenda_heading.data}</h1>
	</div>
</#if>

<#assign numOfDays = course_agenda.day.siblings?size>

<#if numOfDays == 1>
	<#assign agendaClass = "one">
<#elseif numOfDays == 2>
	<#assign agendaClass = "two">
<#elseif numOfDays == 3>
	<#assign agendaClass = "three">
</#if>

<div class="agenda block-container justify-space-around no-padding ${agendaClass} standard-padding-vertical">
	<#list course_agenda.day.siblings as cur_day>

		<article class="block block-container day large-padding-horizontal">
			<h3><@liferay.language key="day" /> ${cur_day_index + 1}</h3>

			<ul class="category-set no-margin">
				<#list cur_day.agenda_item.siblings as item>
					<#if item.subitem?? && item.subitem.data?has_content>
						<#assign category_header_class = "">
					<#else>
						<#assign category_header_class = "no-subcontent">
					</#if>

					<li class="category-header standard-padding-vertical ${category_header_class}">

						<#-- Plus / Cross Icon -->
						<#if item.subitem?? && item.subitem.data?has_content>
							<svg class="toggle-icon" data-item-index="${item_index}" width="20" height="20" viewBox="0 0 40 40" xmlns="http://www.w3.org/2000/svg"><title>Elements/toggle grey</title><g stroke="#9EA2B4" stroke-width="1.5" fill="none" fill-rule="evenodd"><ellipse cx="20" cy="20" rx="19" ry="19"></ellipse><path d="M11 19.75h17.675M19.75 28.675V11" stroke-linecap="round"></path></g></svg>
						</#if>

						<#assign item_data = "
							data-article-id='${article_id}'
							data-level-path='${item.name}::${item_index}'
						" />
						<span class="live-edit" ${item_data}>
							${item.data}
						</span>
					</li>

					<#-- Subitem -->
					<#if item.subitem??>
						<ul class="category-content toggler-content-collapsed">
							<#list item.subitem.siblings as subitem>
								<#if subitem.secondary_subitem?? && subitem.secondary_subitem.data?has_content>
									<#assign category_header_class = "">
								<#else>
									<#assign category_header_class = "no-subcontent">
								</#if>

								<li class="category-header small-padding-vertical ${category_header_class}">
									<#-- Plus / Cross Icon -->
									<#if subitem.secondary_subitem?? && subitem.secondary_subitem.data?has_content>
										<svg class="toggle-icon" data-item-index="${item_index}-${subitem_index}" width="20" height="20" viewBox="0 0 40 40" xmlns="http://www.w3.org/2000/svg"><title>Elements/toggle grey</title><g stroke="#9EA2B4" stroke-width="1.5" fill="none" fill-rule="evenodd"><ellipse cx="20" cy="20" rx="19" ry="19"></ellipse><path d="M11 19.75h17.675M19.75 28.675V11" stroke-linecap="round"></path></g></svg>
									</#if>

									<#assign subitem_data = "
										data-article-id='${article_id}'
										data-level-path='${item.name}::${item_index},${subitem.name}::${subitem_index}'
									" />

									<span class="live-edit" ${subitem_data}>
										${subitem.data}
									</span>

									<#-- Secondary Subitem -->
									<#if subitem.secondary_subitem??>
										<ul class="category-content small-padding-vertical toggler-content-collapsed">
											<#list subitem.secondary_subitem.siblings as secondary_subitem>
												<li class="small-padding-vertical">

													<#assign secondary_subitem_data = "
														data-article-id='${article_id}'
														data-level-path='${item.name}::${item_index},${subitem.name}::${subitem_index},${secondary_subitem.name}::${secondary_subitem_index}'
													" />

													<span class="live-edit" ${secondary_subitem_data}>
														${secondary_subitem.data}
													</span>
												</li>
											</#list>
										</ul>
									</#if>
								</li>
							</#list>
						</ul>
					</#if>
				</#list>
			</ul>
		</article>
	</#list>
</div>

<#if (general_course_info.course_pdf.data)?has_content && (general_course_info.course_pdf_button_text.data)?has_content>
	<div class="large-padding text-center">
		<a class="btn btn-accent" href="${general_course_info.course_pdf.data}">${general_course_info.course_pdf_button_text.data}</a>
	</div>
</#if>

<style>
	.agenda h3 {
		font-size: 1.5em;
		font-weight: 500;
	}

	.agenda .day {
		flex-direction: column;
	}

	.agenda .day ul {
		margin-bottom: 0;
		margin-left: 10px;
	}

	.agenda .day li {
		list-style-type: none;
		position: relative;
	}

	.agenda .day li.no-subcontent:hover {
		cursor: default;
	}

	.agenda .day li.no-subcontent *, .agenda .day li.no-subcontent + div * {
		padding: 0;
	}

	.agenda.block-container {
		margin: auto;
		width: 75%;
	}

	.agenda.two .day {
		width: 50%;
	}

	.agenda.three .day {
		width: 33%;
	}

	.aui .category-header {
		padding-left: 30px;
	}

	.aui .category-header:hover {
		cursor: pointer;
	}

	.aui .category-content {
		padding-bottom: 10px;
		padding-left: 10px;
	}

	.border-blocks > article {
		border: 1px solid #E3E4E5;
	}

	.category-set {
		position: relative;
	}

	.disclaimer {
		font-size: 0.8em;
		font-style: italic;
	}

	.training-banner {
		color: #FFF;
		min-height: 60vh;
	}

	.training-banner a {
		color: #FFF;
		text-decoration: underline;
	}

	.training-banner svg {
		width: 60%;
	}

	.training-banner article:last-child {
		flex-basis: 60%;
		flex-grow: 1;
	}

	.point-description {
		font-size: 1.3em;
	}

	.target-positions {
		align-content: center;
	}

	.target-positions p {
		font-size: 1.5em;
		margin: 0;
	}

	.target-positions li {
		font-size: 1.9em;
		line-height: 1.3em;
		list-style-type: none;
	}

	.toggle-icon {
		left: 0;
		position: absolute;
	}

	.toggler-header .toggle-icon {
		-moz-transform-origin: center 50%;
		-moz-transition: -moz-transform 1s;
		-ms-transform-origin: center 50%;
		-o-transform-origin: center 50%;
		-o-transition: -o-transform 1s;
		-webkit-transform-origin: center 50%;
		-webkit-transition: -webkit-transform 1s;
		transform-origin: center 50%;
		transition: transform 1s;
	}

	.toggler-header-expanded .toggle-icon {
		-moz-transform: rotate(45deg);
		-ms-transform: rotate(45deg);
		-o-transform: rotate(45deg);
		-webkit-transform: rotate(45deg);
		transform: rotate(45deg);
	}

	@media (max-width: 760px) {
		.aui .agenda .day {
			max-width: 100%;
		}
	}
</style>

<script>
	AUI().use(
		'aui-toggler',
		function(A) {
			new A.TogglerDelegate(
				{
					animated: true,
					closeAllOnExpand: false,
					container: '.agenda',
					content: '.category-content',
					expanded: false,
					header: '.category-header',
					transition: {
						duration: 0.6,
						easing: 'cubic-bezier(0, 0.1, 0, 1)'
					}
				}
			);
		}
	);
</script>