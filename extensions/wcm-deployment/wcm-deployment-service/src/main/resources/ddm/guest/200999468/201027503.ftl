<#import "${templatesPath}/231368766" as article_utilities>

<#assign has_update_permissions = article_utilities.has_update_permissions() />

<section class="fss-toggler-${.vars['reserved-article-id'].data} max-lg no-padding-horizontal section-padding">
	<div class="fss-toggle-wrapper">
		<span class="fade-out"></span>

		<nav aria-label="Financial Service Sub-sector Navigation" role="navigation">
			<ul class="block-container fss-toggles justify-center text-center">
				<#list sector_name.siblings as sector>
					<li class="block class-toggle large-padding-horizontal toggle-${sector_index + 1}" data-target-class="toggle-sector-${sector_index + 1}" data-target-nodes=".fss-toggler-${.vars['reserved-article-id'].data}" data-toggle-type="carousel" role="presentation">
						<#if sector.sector_icon.data?has_content>
							${sector.sector_icon.data}
						</#if>

						<#assign nav_text_css_class = "alt-font-color small-caps small-padding-vertical" />
						<#assign nav_text_attrs = "" />

						<#if has_update_permissions>
							<#assign nav_text_css_class = nav_text_css_class + " live-edit" />
							<#assign nav_text_attrs = nav_text_attrs + "
								data-article-id='${.vars[\"reserved-article-id\"].data}'
								data-level-path='${sector.name}::${sector_index}'
							" />
						</#if>

						<p class="${nav_text_css_class}" ${nav_text_attrs}>
							${sector.data}
						</p>
					</li>
				</#list>
			</ul>
		</nav>
	</div>

	<#list sector_name.siblings as sector>
		<div class="sector-content sector-${sector_index + 1}">
			<#if sector.sector_description.data?has_content>
				<#assign sector_description_attrs = "" />
				<#assign sector_description_css_class = "standard-padding" />

				<#if has_update_permissions>
					<#assign sector_description_attrs = sector_description_attrs + "
						data-article-id='${.vars[\"reserved-article-id\"].data}'
						data-level-path='${sector.sector_description.name}::${sector_index}'
					" />
					<#assign sector_description_css_class = sector_description_css_class + " live-edit" />
				</#if>

				<h4 class="${sector_description_css_class}" ${sector_description_attrs}>
					${sector.sector_description.data}
				</h4>
			</#if>

			<div class="block-container case-study-background">
				<#if sector.case_study.data?has_content>
					<#assign case_study_desktop_attrs = "" />
					<#assign case_study_desktop_css_class = "block hidden-phone standard-padding w70" />

					<#if has_update_permissions>
						<#assign case_study_desktop_attrs = case_study_desktop_attrs + "
							data-article-id='${.vars[\"reserved-article-id\"].data}'
							data-level-path='${sector.case_study.name}::${sector_index}'
						" />
						<#assign case_study_desktop_css_class = case_study_desktop_css_class + " live-edit" />
					</#if>

					<h3 class="${case_study_desktop_css_class}" ${case_study_desktop_attrs}>
						${sector.case_study.data}
					</h3>
				</#if>

				<div class="block border-left case-study-border standard-padding text-center w30">
					<#if sector.case_study.company_logo.data?has_content>
						<div class="standard-padding">
							${sector.case_study.company_logo.data}
						</div>
					</#if>

					<#if sector.case_study.data?has_content>
						<#assign case_study_mobile_attrs = "" />
						<#assign case_study_mobile_css_class = "hidden-desktop hidden-tablet responsive standard-padding" />

						<#if has_update_permissions>
							<#assign case_study_mobile_attrs = case_study_mobile_attrs + "
								data-article-id='${.vars[\"reserved-article-id\"].data}'
								data-level-path='${sector.case_study.name}::${sector_index}'
							" />
							<#assign case_study_mobile_css_class = case_study_mobile_css_class + " live-edit" />
						</#if>

						<h3 class="${case_study_mobile_css_class}" ${case_study_mobile_attrs}>
							${sector.case_study.data}
						</h3>
					</#if>

					<#if sector.case_study.cta_url.data?has_content>
						<a class="cta standard-padding" href="${sector.case_study.cta_url.data}">
							${sector.case_study.cta_text.data}

							<svg class='cta-icon' height='10' width='8'>
								<use xlink:href='#caret' />
							</svg>
						</a>
					</#if>
				</div>
			</div>
		</div>
	</#list>
</section>

<style type="text/css">
	.aui #wrapper .toggle-1 p {
		border-bottom: 2px solid #79D9B4;
		color: #2EAD78;
	}

	.border-left {
		border-left: 1px solid;
	}

	.case-study-background {
		background-color: #BDEEDB;
	}

	.case-study-border {
		border-color: #9BE3C7;
	}

	.fss-toggles li {
		list-style: none;
	}

	.toggle-1 svg {
		filter: none;
	}

	<#list sector_name.siblings as sector>
		#wrapper .toggle-sector-${sector_index + 1} .toggle-${sector_index + 1} p {
			border-bottom: 2px solid #79D9B4;
			color: #2EAD78;
		}

		#wrapper .toggle-sector-${sector_index + 2} .toggle-1 p {
			border-bottom-width: 0;
			color: #909295;
		}

		.sector-${sector_index + 2}, .toggle-sector-${sector_index + 1} .sector-content:not(.sector-${sector_index + 1}) {
			display: none;
		}

		.toggle-${sector_index + 2} svg, .toggle-sector-${sector_index + 1} .class-toggle:not(.toggle-${sector_index + 1}) svg {
			filter: saturate(0);
		}

		.toggle-sector-${sector_index + 1} .sector-${sector_index + 1} {
			display: block;
		}

		.toggle-sector-${sector_index + 1} .toggle-${sector_index + 1} svg {
			filter: none;
		}
	</#list>

	@media (max-width: 767px) {
		.aui .fss-toggler-${.vars['reserved-article-id'].data} .fss-toggles {
			white-space: nowrap;
		}

		.aui .fss-toggler-${.vars['reserved-article-id'].data} .fss-toggles, .aui .block-container.fss-toggles li, .fss-toggles svg, .fss-toggles p {
			display: inline-block;
		}

		.aui .block-container.fss-toggles li {
			width: auto !important;
		}

		.border-left {
			border-left-width: 0;
		}

		.fade-out {
			background: linear-gradient(to right, rgba(255, 255, 255, 0) 0%, rgba(255, 255, 255, 0.5) 33%, rgba(255, 255, 255, 1) 100%);
			height: 5em;
			pointer-events: none;
			position: absolute;
			right: 0;
			top: 1em;
			width: 2em;
			z-index: 2;
		}

		.fss-toggle-wrapper {
			height: 100%;
			overflow: hidden;
			position: relative;
		}

		.fss-toggle-wrapper nav {
			margin-bottom: -1em;
			overflow-x: scroll;
			overflow-y: hidden;
		}

		.fss-toggles svg, .fss-toggles p {
			vertical-align: middle;
		}
	}
</style>