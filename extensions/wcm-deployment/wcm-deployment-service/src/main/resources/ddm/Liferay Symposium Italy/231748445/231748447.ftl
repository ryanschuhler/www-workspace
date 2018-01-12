<#assign css_class = "stat-infographic" />

<#if background_color.data != "background-white" >
	<#assign css_class = css_class + " " + background_color.data />
</#if>

<div class="${css_class}">
	<h3 class="font-weight-bold standard-padding-vertical text-center">${heading.data?upper_case}</h3>

	<#if label.siblings?has_content>
		<div class="block-container graphic-${label.siblings?size} justify-center max-full standard-padding-vertical">
			<#list label.siblings as cur_item>
				<div class="block block-container justify-center on-screen-helper slide-up stat-block">
					<div class="stat-details">
						<div class="number">
							${cur_item.number.data}
						</div>

						<div class="percent">
							<#if cur_item.number.sup.data == "true">
								<sup>%</sup>
							</#if>
						</div>

						<div alt="Icon" class="stat-icon" >
							<img src="${cur_item.svg.data}" />
						</div>
					</div>

					<div class="stat-label">
						${cur_item.data}
					</div>
				</div>
			</#list>
		</div>
	</#if>
</div>

<style type="text/css">
	.background-blue {
		background: #198ACA;
	}

	.background-blue h3,
	.background-blue .stat-label,
	.background-blue .stat-details {
		color: #FFF;
	}

	.graphic-3 .stat-block,
	.graphic-6 .stat-block,
	.graphic-9 .stat-block {
		width: 33%;
	}

	.graphic-4 .stat-block,
	.graphic-7 .stat-block,
	.graphic-8 .stat-block {
		width: 25%;
	}

	.graphic-5 .stat-block,
	.stat-block {
		width: 20%;
	}

	.number {
		display: inline-block;
	}

	.percent {
		display: inline-block;
		width: 2vw;
	}

	.stat-block {
		box-sizing: border-box;
		padding-bottom: 60px;
		position: relative;
		text-align: center;
	}

	.stat-details {
		background: transparent;
		color: #F6BF1F;
		font-size: 10vw;
		font-weight: 900;
		letter-spacing: -0.1em;
		line-height: 1em;
		position: relative;
		width: 100%;
		z-index: 1;
	}

	.stat-icon {
		bottom: 0;
		height: 100%;
		left: 35%;
		position: absolute;
		right: 0;
	}

	.stat-icon img {
		max-height: 60%;
		position: relative;
		width: 6vw;
		z-index: 2;
	}

	.stat-label {
		color: #414142;
		font-size: 1.5em;
		font-weight: 400;
		text-transform: uppercase;
		top: 10em;
		width: 100%;
	}

	.stat-details sup {
		font-size: 60%;
	}

	@media all and (max-width: 768px) {
		.stat-details {
			font-size: 20vw;
		}

		.stat-icon {
			left: 15%;
		}

		.stat-icon img {
			width: 11vw;
		}
	}
</style>