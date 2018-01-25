<style>#sponsors {
		background: #EBEBEB
	}

	.sponsor-image-container a {
		display: block;
	}

	.sponsor-image-container img {
		-webkit-filter: grayscale(1);
		filter: gray;
		filter: grayscale(1);
	}

	.sponsor-image-container img:hover {
		-webkit-filter: grayscale(0);
		filter: none;
	}

	.sponsor-type {
		box-sizing: border-box;
		justify-content: center;
		margin: 0 auto;
		width: 100%;
	}

	.heading-container:after {
		border-bottom: 1px solid #ADADAD;
		content: '';
		display: block;
		margin: 0 auto;
	}

	.sponsor-type h4 {
		text-align: center;
		text-transform: uppercase;
	}

	@media (max-width: 720px) {
		.heading-container {
			display: block;
			text-align: center;
			width: 100%;
		}

		.items-container {
			justify-content: center;
		}

		.sponsor-type {
			display: block;
			width: 100%;
		}
	}

	@media (min-width: 768px) {
		.sponsor-type:nth-child(1) .sponsor-image-container img {
			max-width: 200px;
		}

		.sponsor-type:nth-child(2) .sponsor-image-container img {
			max-width: 175px;
		}

		.sponsor-type:nth-child(3) .sponsor-image-container img {
			max-width: 150px;
		}

		.sponsor-type:nth-child(4) .sponsor-image-container img {
			max-width: 125px;
		}

		.heading-container:after {
			width: 75%;
		}
	}

	@media (max-width: 767px) {
		.aui .block-container .block.sponsor-image-container {
			width: auto !important;
		}
	}
</style>

 

<#assign marketing_event_sponsor_level_local_service =   serviceLocator.findService("com.liferay.osb.www.marketing.events.service.MarketingEventSponsorLevelLocalService") />
<#assign marketing_event_sponsor_local_service =   serviceLocator.findService("com.liferay.osb.www.marketing.events.service.MarketingEventSponsorLocalService") />

<#assign order_by_comparator_factory_util = staticUtil["com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil"]>

<#assign priority_order_by = order_by_comparator_factory_util.create("MarketingEventSponsorLevel", ["priority", true])>

<#assign marketing_event_id = getterUtil.getLong(marketing_event_id.data, 0) />

<div class="large-padding" id="sponsors">
	<h2 class="text-center">THANK YOU TO OUR SPONSORS</h2>

	<div class="block-container sponsor-type-wrapper standard-padding">
		<#list marketing_event_sponsor_level_local_service.getMarketingEventSponsorLevels(marketing_event_id, -1, -1, priority_order_by) as marketing_event_sponsor_level>
			<#assign marketing_event_sponsor_level_id = marketing_event_sponsor_level.getMarketingEventSponsorLevelId() />
			<#assign sponsor_level = marketing_event_sponsor_level.getNameCurrentValue() />

			<#if (marketing_event_sponsor_local_service.getMarketingEventSponsorsCount(marketing_event_id, marketing_event_sponsor_level_id) gt 0)>
				<div class="sponsor-type">
					<div class="heading-container small-padding-vertical text-center">
						<h4>${sponsor_level}</h4>
					</div>

					<div class="align-center block-container items-container justify-center">
						<#list marketing_event_sponsor_local_service.getMarketingEventSponsors(marketing_event_id, marketing_event_sponsor_level_id) as event_sponsor>
							<#if event_sponsor.getImageFileEntryId() != 0>
								<div class="block sponsor-image-container standard-padding">
									<a href="${htmlUtil.escapeHREF(event_sponsor.getUrl())}" target="blank">
										<img alt="${htmlUtil.escape(event_sponsor.getName())} logo" src="${event_sponsor.getImageFileEntryURL()}" />
									</a>
								</div>
							</#if>
						</#list>
					</div>
				</div>
			</#if>
		</#list>
	</div>
</div>