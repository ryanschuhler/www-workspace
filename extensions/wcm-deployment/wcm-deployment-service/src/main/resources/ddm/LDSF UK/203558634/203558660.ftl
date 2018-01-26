<style>
	.opera.safari .sponsor-image-container {
		width: inherit;
	}

	.sponsor-image-container {
		max-width: 175px;
		width: 100%;
	}
	
	.safari .sponsor-image-container {
		width: auto;
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
		margin: 2em auto 0px;
	}

	.sponsors-wrapper .sponsor-type:first-child {
		margin-top: 0px;
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
		}
	}

	@media (max-width: 445px) {
		.block.sponsor-image-container {
			width: 47% !important;
		}
	}
</style>

 
<#assign marketing_event_sponsor_level_local_service = serviceLocator.findService("com.liferay.osb.www.marketing.events.service.MarketingEventSponsorLevelLocalService") />
<#assign marketing_event_sponsor_local_service = serviceLocator.findService("com.liferay.osb.www.marketing.events.service.MarketingEventSponsorLocalService") />

<#assign order_by_comparator_factory_util = staticUtil["com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil"]>

<#assign priority_order_by = order_by_comparator_factory_util.create("MarketingEventSponsorLevel", ["priority", true])>

<#assign marketing_event_id = getterUtil.getLong(marketing_event_id.data, 0) />

<div class="sponsors-wrapper standard-padding" id="sponsors">
	<#list marketing_event_sponsor_level_local_service.getMarketingEventSponsorLevels(marketing_event_id, -1, -1, priority_order_by) as marketing_event_sponsor_level>
		<#assign marketing_event_sponsor_level_id = marketing_event_sponsor_level.getMarketingEventSponsorLevelId() />

		<#if (marketing_event_sponsor_local_service.getMarketingEventSponsorsCount(marketing_event_id, marketing_event_sponsor_level_id) gt 0)>
			<div class="block-container no-padding sponsor-type">
				<div class="align-center block-container heading-container no-padding-horizontal responsive-justify-center standard-padding-vertical w25">
					<h2>${marketing_event_sponsor_level.getName()}</h2>
				</div>

				<div class="align-center block block-container responsive-justify-center items-container w75">
					<#list marketing_event_sponsor_local_service.getMarketingEventSponsors(marketing_event_id, marketing_event_sponsor_level_id) as event_sponsor>
						<#if event_sponsor.getImageFileEntryId() != 0>
							<#assign image_file_entry = event_sponsor.getImageFileEntry() />

							<div class="block small-padding sponsor-image-container">
								<a href="${event_sponsor.getUrl()}" target="blank">
									<img alt="${event_sponsor.getName()} logo" src="/documents/${image_file_entry.getRepositoryId()}/${image_file_entry.getFolderId()}/${image_file_entry.getTitle()}/${image_file_entry.getUuid()}">
								</a>
							</div>
						</#if>
					</#list>
				</div>
			</div>
		</#if>
	</#list>
</div>