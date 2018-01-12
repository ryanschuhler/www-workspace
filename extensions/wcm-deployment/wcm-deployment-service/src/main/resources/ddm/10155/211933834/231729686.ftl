<#assign portlet_bean_locator = objectUtil("com.liferay.portal.kernel.bean.PortletBeanLocatorUtil") />

<#assign asset_category_local_service = serviceLocator.findService("com.liferay.portlet.asset.service.AssetCategoryLocalService")>
<#assign asset_vocabulary_local_service = serviceLocator.findService("com.liferay.portlet.asset.service.AssetVocabularyLocalService") />
<#assign marketing_event_local_service = portlet_bean_locator.locate("osb-www-marketing-events-portlet", "com.liferay.osb.www.marketing.events.service.MarketingEventLocalService") />
<#assign marketing_event_session_local_service = portlet_bean_locator.locate("osb-www-marketing-events-portlet", "com.liferay.osb.www.marketing.events.service.MarketingEventSessionLocalService") />
<#assign marketing_event_user_local_service = portlet_bean_locator.locate("osb-www-marketing-events-portlet", "com.liferay.osb.www.marketing.events.service.MarketingEventUserLocalService") />

<#assign marketing_event_id = getterUtil.getLong(marketing_event_id.data, 0) />

<#assign orderByComparatorFactoryUtil = staticUtil["com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil"]>

<#assign categories_order_by = orderByComparatorFactoryUtil.create("AssetCategory", ["name", true])>

<#assign class_loader_util = staticUtil["com.liferay.portal.util.ClassLoaderUtil"]>
<#assign class_loader = class_loader_util.getPluginClassLoader("osb-www-marketing-events-portlet")>

<#assign marketing_events_util = staticUtil["com.liferay.portal.kernel.util.InstanceFactory"].newInstance(class_loader, "com.liferay.osb.www.marketing.events.util.MarketingEventsUtil")>

<#assign session_sponsors = marketing_events_util.getMarketingEventUsers(marketing_event_id, "Marketing Event User Types", "Session Sponsor")! />

<#assign sessions_map = marketing_event_session_local_service.getMarketingEventSessionsMap(marketing_event_id, true)! />

<#assign time_zone_id = marketing_event_local_service.getMarketingEvent(marketing_event_id).getTimeZoneId() />
<#assign time_zone = timeZoneUtil.getTimeZone(time_zone_id) />

<#assign fast_date_format_factory_util = staticUtil["com.liferay.portal.kernel.util.FastDateFormatFactoryUtil"]>
<#assign time_format = fast_date_format_factory_util.getSimpleDateFormat((agenda_time_format.data)!"H:mm", locale, time_zone) />

<#assign default_day = (agenda_default_day.data)!"day-1"/>

<#assign marketing_event = marketing_event_local_service.getMarketingEvent(marketing_event_id)>

<#assign text_formatter = staticUtil["com.liferay.portal.kernel.util.TextFormatter"]>

<#assign initial_category = "" />
<#assign session_track_vocabulary_name = "Marketing Event Session Tracks" />
<#assign session_type_vocabulary_name = "Marketing Event Session Types" />

<#assign marketing_event_session_tracks= []>

<#assign group_vocabularies = asset_vocabulary_local_service.getGroupVocabularies(marketing_event.getSiteGroupId())>

<#list group_vocabularies as group_vocabulary>
	<#if group_vocabulary.getName()?upper_case == session_track_vocabulary_name?upper_case>
		<#assign session_track_categories = asset_category_local_service.getVocabularyCategories(group_vocabulary.getVocabularyId(), -1, -1, categories_order_by)>

		<#list session_track_categories as session_track_category>
			<#assign color = (asset_category_property_local_service.getCategoryProperty(session_track_category.getCategoryId(), "color").getValue())!"000000">
			<#assign marketing_event_session_tracks = marketing_event_session_tracks + [{ "name": session_track_category.getName(), "color": color, "formattedName": text_formatter.format(session_track_category.getName(), 2) }]>
		</#list>
	</#if>
</#list>

<section class="sessions" id="agenda">
	<ul class="border-bottom border-top element-border session-tab-wrapper">
		<#assign sessions_dates = sessions_map.keySet().toArray() />

		<#list sessions_dates as date>
			<#assign localized_date = dateUtil.getDate(date, (agenda_date_format.data)!"EEEE, MMM dd, yyyy" , locale, time_zone) />
			<#assign this_day = "day-${date_index + 1}" />

			<li class="class-toggle session-tab standard-padding-vertical text-center toggler-header-collapsed ${this_day}" data-target-class="class-toggle-active-${this_day}" data-target-nodes=".sessions, .sessions li.${this_day}, .sessions .session-table.${this_day}" data-toggle-type="carousel" role="presentation">
				${localized_date}
			</li>
		</#list>
	</ul>

	<div class="filter-wrapper" >
		<#list marketing_event_session_tracks as track>
			<#if track_index == 0>
				<#assign initial_category = "track-" + track.formattedName/>
			</#if>

			<button class="btn filter-toggle track-${track.formattedName}" data-target-class="filter-active-${track.formattedName}" data-target-nodes=".filter-wrapper, .sessions .track-${track.formattedName}" data-toggle-type="carousel">
				${track.name}
			</button>

		</#list>
	</div>

	<#list sessions_dates as date>
		<table class="day-${date_index + 1} session-table w100">

			<tbody>
				<#assign current_start_date = "" />
				<#assign previous_start_date = "" />
				<#assign slot_talk_counts = {} />
				<#assign talk_count = 1 />

				<#assign sessions_list = sessions_map.get(date).toArray() />

				<#list sessions_list as session>
					<#assign current_start_date = session.getStartDate().getTime()?string />

					<#if session_index == 0>
						<#assign previous_start_date = current_start_date />
					<#elseif session_index gt 0 && (current_start_date != previous_start_date)>
						<#assign slot_talk_counts = slot_talk_counts + {previous_start_date: talk_count} />
						<#assign previous_start_date = current_start_date />
						<#assign talk_count = 1 />
					<#else>
						<#assign talk_count = talk_count + 1 />
					</#if>
				</#list>

				<#assign slot_talk_counts = slot_talk_counts + {previous_start_date: talk_count} />
				<#assign previous_session_time = "" />

				<#list sessions_list as session>
					<#assign current_session_time = time_format.format(session.getStartDate()).toLowerCase() />
					<#assign current_session_time_range = "${current_session_time} - ${time_format.format(session.getEndDate()).toLowerCase()}" />

					<tr class="border-bottom element-border session-${session_index + 1}">
						<#if current_session_time != previous_session_time>
							<#assign previous_session_time = current_session_time />

							<td class="hidden-phone hidden-tablet standard-padding time-display w20" rowspan="${slot_talk_counts[session.getStartDate().getTime()?string]}">
								<h3 class="alt-font-color">
									${current_session_time}
								</h3>
							</td>
						</#if>

						<#assign session_categories = session.getAssetCategories()>
						<#assign session_track = "">
						<#assign session_type = "">

						<#list session_categories as session_category>
							<#assign category_name = session_category.getName() />
							<#assign session_category_vocabulary = asset_vocabulary_local_service.getAssetVocabulary(session_category.getVocabularyId()) />

							<#if stringUtil.equalsIgnoreCase(session_category_vocabulary.getName(), session_type_vocabulary_name) >
								<#assign session_type = text_formatter.format(category_name, 2)>

							<#elseif stringUtil.equalsIgnoreCase(session_category_vocabulary.getName(), session_track_vocabulary_name) >
								<#assign session_track = "track-" + text_formatter.format(category_name, 2) />

							</#if>
						</#list>

						<td class="align-center block-container session-detail ${session_track} standard-padding" data-session-type="${htmlUtil.escape(session_type)}" data-talks-in-row="${slot_talk_counts[session.getStartDate().getTime()?string]}">
							<div class="block w70">
								<p class="visible-phone visible-tablet">${current_session_time_range}</p>

								<h4 class="session-title">${session.getTitle(locale)}</h4>

								<#assign session_company_logos = {} />

								<#assign session_speaker_ids = session.getMarketingEventUserIds() />

								<#list session_speaker_ids as speaker_id>
									<#assign speaker = marketing_event_user_local_service.getMarketingEventUser(speaker_id) />

									<#if session_sponsors.contains(speaker)>
										<#assign session_company_logos = session_company_logos + {speaker.getCompanyName(): speaker.getCompanyLogoFileEntryURL()} />
									</#if>

									<p class="alt-font-color no-margin smaller-text">
										${speaker.getFullName()}, ${speaker.getCompanyName()}
									</p>
								</#list>

								<#assign room_name = "" />
								<#assign room_name_with_time  = current_session_time_range />
								<#assign session_room_id = session.getMarketingEventSessionRoomId() />

								<#if session_room_id != 0>
									<#assign session_room = session.getMarketingEventSessionRoom() />

									<#if session_room?has_content>
										<#assign room_name = session_room.getName() />
										<#assign room_name_with_time  = room_name + ", " + current_session_time_range />

										<p class="no-margin smaller-text">(${room_name})</p>
									</#if>
								</#if>
							</div>

							<div class="block responsive-text-left text-right w30">
								<#list session_company_logos?keys as session_company_logo_key>
									<img alt="${htmlUtil.escape(session_company_logo_key)} logo" class="agenda-company-logo small-padding-vertical" src="${session_company_logos[session_company_logo_key]}"/>
								</#list>
								<#list session.getChildFileEntryURLs() as image_url>
									<img alt="sponsor-logo" class="agenda-company-logo small-padding-vertical" src="${image_url}"/>
								</#list>
							</div>

							<div class="pop-up-content standard-padding">
								<h4 class="session-title">${session.getTitle(locale)}</h4>

								<p>${room_name_with_time}</p>

								<#list session_speaker_ids as speaker_id>
									<#assign speaker = marketing_event_user_local_service.getMarketingEventUser(speaker_id) />

									<p class="font-weight-bold">${speaker.getFirstName()} ${speaker.getLastName()}</p>

									<p>
										<#if speaker.getJobTitle(locale)?has_content>
											${speaker.getJobTitle(locale)},
										</#if>

										${speaker.getCompanyName()}
									</p>
								</#list>

								<#if session.getDescription(locale)?has_content>
									<div class="session-summary">
										${session_summary_translation.data}:

										<p class="session-summary">${session.getDescription(locale)?replace("\n", "<br>")}</p>
									</div>
								</#if>
							</div>
						</td>
					</tr>
				</#list>
			</tbody>
		</table>
	</#list>

	<div class="max-med pop-up-display" id="pop-up-agenda">
		<svg class="pop-up-close" height="20" width="20">
			<use xlink:href="#closeIcon"></use>
		</svg>

		<div class="pop-up-content standard-padding"></div>
	</div>
</section>

<style>
	.btn.filter-toggle {
		align-items: center;
		display: flex;
		margin-left: 10px;
	}

	.filter-wrapper {
		align-items: center;
		display: flex;
		justify-content: center;
		margin: 20px 0;
	}

	.filter-wrapper:not([class*='filter-active']) .filter-toggle.${initial_category},
	.filter-toggle[class*='filter-active'] {
		background-color: #1C75B9;
		color: white;
	}

	.filter-wrapper:not([class*='filter-active']) ~ table td.session-detail[class*='track-']:not([class*='${initial_category}']),
	.filter-wrapper[class*='filter-active'] ~ table td.session-detail[class*='track-']:not([class*='filter-active']) {
		display: none;
	}

	.ie11 .session-detail .w70 {
		width: 50%;
	}

	.session-detail {
		display: block;
		min-height: 75px;
	}

	.session-detail:hover {
		cursor: pointer;
	}

	.session-detail[data-talks-in-row="1"] {
		background: #EBEBEB;
	}

	.session-detail[data-session-type="break"] {
		background: #F3F3F3;
	}

	.session-detail .agenda-company-logo {
		max-width: 180px;
		width: 100%;
	}

	.session-detail .pop-up-content {
		margin: 0 auto;
		width: 100%;
	}

	.session-detail .smaller-text {
		font-size: 0.94em;
	}

	.session-tab {
		-webkit-flex: 1;
		flex: 1;
		font-size: 1.125em;
		font-weight: lighter;
		list-style: none;
		text-decoration: none;
	}

	.session-tab:hover {
		background-color: #153F6D;
		color: #FFF;
	}

	.session-table {
		display: none;
	}

	.sessions ul.session-tab-wrapper {
		display: -moz-box;
		display: -ms-flexbox;
		display: -webkit-box;
		display: -webkit-flex;
		display: flex;
		margin: 0;
	}

	.sessions:not([class*='class-toggle-active']) .session-tab.${default_day},
	.session-tab[class*='class-toggle-active'] {
		background: #0067AA;
		color: #FFF;
		font-weight: normal;
	}

	.sessions:not([class*='class-toggle-active']) .session-table.${default_day},
	.session-table[class*='class-toggle-active'] {
		display: table;
	}

	.time-display {
		vertical-align: top;
	}
</style>

<script type="text/javascript">
	AUI().ready(
		'class-toggle',
		'pop-up',
		function(A) {

			new A.ClassToggle(
				{
					baseClassName: 'filter-toggle',
					item: '.filter-toggle'
				}
			).render();

			new A.PopUp(
				{
					alignTopNode: '.sessions',
					centered: true,
					popUpId: '#pop-up-agenda',
					trigger: '.session-detail'
				}
			).render();
		}
	);
</script>