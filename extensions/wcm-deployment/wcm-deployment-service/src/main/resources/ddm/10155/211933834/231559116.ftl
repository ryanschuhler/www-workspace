<#import "${templatesPath}/1561886" as lang>

<#assign locale_util = staticUtil["com.liferay.portal.kernel.util.LocaleUtil"]>

<#assign locale_english = locale_util.UK>

<#assign portlet_bean_locator = objectUtil("com.liferay.portal.kernel.bean.PortletBeanLocatorUtil")>

<#assign asset_category_local_service = serviceLocator.findService("com.liferay.portlet.asset.service.AssetCategoryLocalService")>
<#assign asset_category_property_local_service = serviceLocator.findService("com.liferay.portlet.asset.service.AssetCategoryPropertyLocalService")>
<#assign asset_vocabulary_local_service = serviceLocator.findService("com.liferay.portlet.asset.service.AssetVocabularyLocalService") />
<#assign marketing_event_local_service = portlet_bean_locator.locate("osb-www-marketing-events-portlet", "com.liferay.osb.www.marketing.events.service.MarketingEventLocalService")>
<#assign marketing_event_session_local_service = portlet_bean_locator.locate("osb-www-marketing-events-portlet", "com.liferay.osb.www.marketing.events.service.MarketingEventSessionLocalService")>
<#assign marketing_event_user_local_service = portlet_bean_locator.locate("osb-www-marketing-events-portlet", "com.liferay.osb.www.marketing.events.service.MarketingEventUserLocalService")>

<#assign marketing_event_id = getterUtil.getLong(marketing_event_id.data, 0)>

<#assign orderByComparatorFactoryUtil = staticUtil["com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil"]>

<#assign sessions_map = marketing_event_session_local_service.getMarketingEventSessionsMap(marketing_event_id, true)!>

<#assign marketing_event = marketing_event_local_service.getMarketingEvent(marketing_event_id)>

<#assign categories_order_by = orderByComparatorFactoryUtil.create("AssetCategory", ["name", true])>
<#assign text_formatter = staticUtil["com.liferay.portal.kernel.util.TextFormatter"]>

<#assign session_topic_vocabulary_name = "Marketing Event Session Topics">
<#assign session_track_vocabulary_name = "Marketing Event Session Tracks">
<#assign session_type_vocabulary_name = "Marketing Event Session Types">

<#assign session_topics = []>

<#assign group_vocabularies = asset_vocabulary_local_service.getGroupVocabularies(marketing_event.getSiteGroupId())>

<#list group_vocabularies as group_vocabulary>
	<#if group_vocabulary.getName()?upper_case == session_topic_vocabulary_name?upper_case>
		<#assign session_topic_categories = asset_category_local_service.getVocabularyCategories(group_vocabulary.getVocabularyId(), -1, -1, categories_order_by)>

		<#list session_topic_categories as session_topic_category>
			<#assign color = (asset_category_property_local_service.getCategoryProperty(session_topic_category.getCategoryId(), "color").getValue())!"000000">
			<#assign session_topics = session_topics + [{ "name": session_topic_category.getName(), "color": color, "cssClass": text_formatter.format(session_topic_category.getName(), 2) }]>
		</#list>
	</#if>
</#list>

<#assign time_zone_id = marketing_event.getTimeZoneId()>
<#assign time_zone = timeZoneUtil.getTimeZone(time_zone_id)>

<#assign fast_date_format_factory_util = staticUtil["com.liferay.portal.kernel.util.FastDateFormatFactoryUtil"]>
<#assign time_format = fast_date_format_factory_util.getSimpleDateFormat((agenda_time_format.data)!"H:mm", locale_english, time_zone)>

<#assign default_day = (agenda_default_day.data)!"day-1">

<#assign UNASSIGNED_TRACK_NAME = "notrack">

<#assign list_util = staticUtil["com.liferay.portal.kernel.util.ListUtil"]>

<section class="large-padding-vertical max-full no-filter sessions" id="agenda">
	<svg display="none" height="0" width="0">
		<symbol id="arrowBtn" viewBox="0 0 26 26">
			<g fill="none" fill-rule="evenodd" stroke="#12BDE6" stroke-width="1" transform="translate(2.000000, 2.000000)">
				<circle cx="11" cy="11" r="11.75" stroke-width="1.5"></circle>
				<g stroke-linecap="square" stroke-width="2" transform="translate(11.596194, 10.596194) rotate(-45.000000) translate(-11.596194, -10.596194) translate(8.596194, 7.096194)">
					<path d="M0,1 L6,1"></path>
					<path d="M0,1 L0,7"></path>
				</g>
			</g>
		</symbol>
	</svg>

	<h2 class="lego-element no-margin no-padding text-center">AGENDA</h2>

	<ul class="element-border session-tab-wrapper">
		<#assign sessions_dates = sessions_map.keySet().toArray()>

		<#list sessions_dates as date>
			<#assign localized_date = dateUtil.getDate(date, (agenda_date_format.data)!"EEEE, MMM dd, yyyy", locale_english, time_zone)>

			<#assign this_day = "day-${date_index + 1}">

			<li class="block-container justify-center session-tab standard-padding-vertical text-center toggler-header-collapsed ${this_day}" data-target-class="class-toggle-active-${this_day}" data-target-nodes=".sessions, .sessions li.${this_day}, .sessions .session-table.${this_day}" data-toggle-type="carousel" role="presentation">
				<#if date_index gt 0>
					<#assign prev_day = "day-${date_index}">

					<svg class="agenda-day-btn agenda-previous-day-btn class-toggle w20"  data-target-class="class-toggle-active-${prev_day}" data-target-nodes=".sessions, .sessions li.${prev_day}, .sessions .session-table.${prev_day}" data-toggle-type="carousel"><use xlink:href="#arrowBtn"></use></svg>
				<#else>
					<svg class="agenda-day-btn w20"></svg>
				</#if>

				<h4 class="session-tab-date-title w30">${localized_date}</h4>

				<#if date_index lt sessions_dates?size-1>
					<#assign next_day = "day-${date_index + 2}">

					<svg class="agenda-day-btn agenda-next-day-btn class-toggle w20"  data-target-class="class-toggle-active-${next_day}" data-target-nodes=".sessions, .sessions li.${next_day}, .sessions .session-table.${next_day}" data-toggle-type="carousel"><use xlink:href="#arrowBtn"></use></svg>
				<#else>
					<svg class="agenda-day-btn w20"></svg>
				</#if>
			</li>
		</#list>
	</ul>

	<div class="block-container hidden-phone justify-center no-padding session-filter-container">
		<div class="all-filter block session-filter small-caps small-padding text-center" data-target-class="no-filter" data-target-nodes=".sessions, .all-filter">
			${languageUtil.get(locale, "all", "All")}
		</div>

		<#list session_topics as session_topic>
			<div class="block filter-toggle ${session_topic.cssClass} session-filter small-caps small-padding text-center" data-target-class="filter-active-${session_topic.cssClass}" data-target-nodes=".sessions, .sessions .${session_topic.cssClass}">
				${session_topic.name}
			</div>
		</#list>
	</div>

	<div class="agenda-hidden">
		<#list sessions_dates as date>
			<table class="day-${date_index + 1} session-table w100">
				<tbody>
					<#assign sessions_list = sessions_map.get(date).toArray()>
					<#assign slot_rowspan_offsets =  jsonFactoryUtil.createJSONObject()>
					<#assign slot_times = [sessions_list?first.getStartDate()]>

					<#assign previous_session_time = "">
					<#assign slot_sessions_by_track = {}>
					<#assign slot_track_counts = []>
					<#assign sorted_sessions = []>
					<#assign tracks = {}>

					<#function update_sessions_lists>
						<#list [UNASSIGNED_TRACK_NAME] + tracks?keys?sort as track>
							<#if slot_sessions_by_track[track]??>
								<#list slot_sessions_by_track[track] as track_session>
									<#assign sorted_sessions = sorted_sessions + [track_session]>
								</#list>
							</#if>
						</#list>

						<#assign slot_track_counts = slot_track_counts + [slot_sessions_by_track?keys?size]>
						<#assign slot_sessions_by_track = {}>
					</#function>

					<#list sessions_list as session>
						<#assign current_session_time = time_format.format(session.getStartDate()).toLowerCase()>

						<#if session_index == 0>
							<#assign previous_session_time = current_session_time>
						</#if>

						<#if session_index gt 0 && (current_session_time != previous_session_time)>
							<#assign previous_session_time = current_session_time>

							<#assign VOID = update_sessions_lists()!"">

							<#assign slot_times = slot_times + [session.getStartDate()]>
						</#if>

						<#assign current_track_name = UNASSIGNED_TRACK_NAME>
						<#assign session_categories = session.getAssetCategories()>

						<#list session_categories as session_category>
							<#assign session_category_vocabulary = asset_vocabulary_local_service.getAssetVocabulary(session_category.getVocabularyId())>

							<#if session_category_vocabulary.getName()?upper_case == session_track_vocabulary_name?upper_case>
								<#assign current_track_name = session_category.getTitle(locale_english)>
								<#assign current_track_room_name = (asset_category_property_local_service.getCategoryProperty(session_category.getCategoryId(), "Room").getValue())!"">
								<#assign tracks = tracks + { current_track_name: current_track_room_name}>
							</#if>
						</#list>

						<#if slot_sessions_by_track?keys?seq_contains(current_track_name)>
							<#assign track_session_array = slot_sessions_by_track[current_track_name]>
							<#assign track_session_array = track_session_array + [session]>

							<#assign slot_sessions_by_track = slot_sessions_by_track + { current_track_name: track_session_array}>
						<#else>
							<#assign track_session_array = [session]>

							<#assign slot_sessions_by_track = slot_sessions_by_track + { current_track_name: track_session_array}>
						</#if>
					</#list>

					<#if tracks?has_content>
						<tr class="border-bottom border-top element-border hidden-phone">
							<td class="time-display w10"></td>

							<#list tracks?keys?sort as track>
								<td class="standard-padding-horizontal">
									<span class="track-title">${track}</span>

									<#if tracks[track]?has_content>
										<p class="font-weight-normal">${tracks[track]}</p>
									</#if>
								</td>
							</#list>
						</tr>
					</#if>

					<#assign VOID = update_sessions_lists()!"">

					<#assign slot_index = 0>

					<#assign previous_session_time = "">

					<#list sorted_sessions as session>
						<#assign current_session_time = time_format.format(session.getStartDate()).toLowerCase()>
						<#assign current_session_time_range = "${current_session_time} - ${time_format.format(session.getEndDate()).toLowerCase()}">
						<#assign rowspan = 1>

						<#assign found_slot = false>

						<#list slot_times as slot_time>
							<#if found_slot && (slot_time.compareTo(session.getEndDate()) < 0)>
								<#assign rowspan = rowspan + 1>
								<#assign void = slot_rowspan_offsets.put(slot_time_index?string, "1")>
							</#if>

							<#if slot_time.compareTo(session.getStartDate()) == 0>
								<#assign found_slot = true>
							</#if>
						</#list>

						<#assign session_css_classes = "">
						<#assign session_topics_markup = []>
						<#assign session_type = "">
						<#assign track_name = "">

						<#assign session_categories = session.getAssetCategories()>

						<#list session_categories as session_category>
							<#assign session_category_vocabulary = asset_vocabulary_local_service.getAssetVocabulary(session_category.getVocabularyId())>

							<#if session_category_vocabulary.getName()?upper_case == session_type_vocabulary_name?upper_case>
								<#assign session_type = text_formatter.format(session_category.getTitle(locale_english), 2)>

								<#assign session_css_classes = session_css_classes + " " + session_type>
							</#if>

							<#if session_category_vocabulary.getName()?upper_case == session_topic_vocabulary_name?upper_case>
								<#assign session_topic_css_class = text_formatter.format(session_category.getName(), 2)>
								<#assign session_topic_name = session_category.getTitle(locale_english)>

								<#assign session_css_classes = session_css_classes + " " + session_topic_css_class>
								<#assign session_topics_markup = session_topics_markup + ["<span class=\"${session_topic_css_class}\">${session_topic_name}</span>"]>
							</#if>

							<#if session_category_vocabulary.getName()?upper_case == session_track_vocabulary_name?upper_case>
								<#assign track_name = session_category.getTitle(locale_english)>
							</#if>
						</#list>

						<#if current_session_time != previous_session_time>
							<#assign previous_session_time = current_session_time>

							<#if session_index gt 0>
								<#assign slot_index = slot_index + 1>

								</tr>
							</#if>

							<#assign colspan = tracks?keys?size - slot_track_counts[slot_index] + 1 - (slot_rowspan_offsets.getInt(slot_index?string))>
							<#assign extra_css_class = "">

							<#if colspan gt 1 && session_type != "keynote_talk">
								<#assign extra_css_class = "alltogether">
							</#if>

							<tr class="${extra_css_class} border-bottom element-border session-${session_index + 1}">
								<td class="standard-padding time-display w10">
									<h4 class="alt-font-color no-margin session-time">${current_session_time}</h4>
								</td>
						</#if>

						<td class="num-tracks-${tracks?keys?size} ${session_css_classes} session-detail standard-padding" colspan="${tracks?keys?size - slot_track_counts[slot_index] + 1  - (slot_rowspan_offsets.getInt(slot_index?string))!0 }" rowspan="${rowspan}">
							<#if session_topics_markup?has_content>
								<p class="alt-font-color no-margin session-topic small-caps white-background">
									${list_util.toString(session_topics_markup, "", ", ")}
								</p>
							</#if>

							<h4 class="no-margin session-title white-background">
								${session.getTitle(locale_english)}

								<#if session.getSlidesFileEntry()??>
									<svg class="pop-up-close" height="20" width="20">
										<use xlink:href="#LDSF-Recap-Presentation"></use>
									</svg>
								</#if>

								<#if session.getVideoURL()?? && session.getVideoURL()?has_content>
									<svg class="pop-up-close" height="20" width="20">
										<use xlink:href="#LDSF-Recap-Video"></use>
									</svg>
								</#if>
							</h4>

							<#assign session_speaker_ids = session.getMarketingEventUserIds()>

							<div class="no-margin speaker-indent ${session_type}">
								<#list session_speaker_ids as speaker_id>
									<#assign speaker = marketing_event_user_local_service.getMarketingEventUser(speaker_id)>

									<#if speaker_id_index gt 0>
										<div class="speaker-spacer"></div>
									</#if>

									<p class="font-weight-normal no-margin">
										${speaker.getFullName()}
									</p>

									<p class="font-weight-lighter hidden-phone no-margin">
										<#if speaker.getJobTitle(locale_english)?has_content>
											${speaker.getJobTitle(locale_english)},
										</#if>

										${speaker.getCompanyName()}
									</p>

									<#if track_name?has_content>
										<p class="hidden-desktop hidden-tablet no-margin">${track_name}</p>
									</#if>
								</#list>
							</div>

							<#assign room_name = "TBD">
							<#assign session_room_id = session.getMarketingEventSessionRoomId()>

							<#if session_room_id != 0>
								<#assign session_room = session.getMarketingEventSessionRoom()>

								<#if session_room?has_content>
									<#assign room_name = session_room.getName()>
								</#if>
							</#if>

							<div class="large-padding pop-up-content">

								<#assign video_url = session.getVideoURL()?string />

								<#if video_url?has_content>
									<#if video_url?matches(".*youtu\\.?.*")>
										<#assign substring_start = video_url?index_of('v=') + 2 />

										<#if substring_start == 1>
											<#assign substring_start = 17 />
										</#if>

										<#assign substring_end = substring_start + 11 />
										<#assign video_url = video_url?substring(substring_start, substring_end) />
									</#if>

									<#if video_url?length == 11>
										<div class="session-video w100 youtube" data-url="//www.youtube.com/embed/${video_url}?wmode=transparent&autoplay=&controls=0&showinfo=0&rel=0" style="background:black;">
											<iframe allowfullscreen="true" frameborder="0" height="450" src="" width="100%"></iframe>
										</div>
									<#else>
										<div class="native session-video w100" data-url="${video_url}" style="background:black;">
											<#assign video_type = video_url?substring(video_url?last_index_of(".") + 1) />

											<video class="background-video" controls height="100%" width="100%">
												<source src="" type="video/${video_type}">
											</video>
										</div>
									</#if>
								</#if>

								<h4 class="no-margin session-title">${session.getTitle(locale_english)}</h4>

								<p class="font-weight-lighter room-time">${room_name}, ${current_session_time_range}</p>

								<#if session.getDescription(locale_english)?has_content>
									<div class="session-summary">
										<p class="font-weight-bold no-margin session-summary-title">${session_summary_translation.data}:</p>

										<p class="font-weight-lighter session-summary">${session.getDescription(locale_english)?replace("\n", "<br>")}</p>
									</div>
								</#if>

								<#assign base_url = request.scheme + "://" + request['server-name'] />
								<#assign session_slides = session.getSlidesFileEntry()! />

								<#if session_slides?has_content>
									<#assign preview_url = base_url + "/documents/" + session_slides.getRepositoryId() + "/" + session_slides.getFolderId() + "/" + session_slides.getTitle() + "/" + session_slides.getUuid() />

									<#assign download_url = httpUtil.addParameter(preview_url, "download", true) />

									<div class="download-slides standard-padding-vertical">
										<a class="btn btn-dark session-slides" href="${download_url}">Download Slides</a>
									</div>
								</#if>

								<#list session_speaker_ids as speaker_id>
									<#assign speaker = marketing_event_user_local_service.getMarketingEventUser(speaker_id)>

									<#assign speaker_image_src = speaker.getImageFileEntryURL()>

									<#if !speaker_image_src?has_content>
										<#assign speaker_image_src= "/image/user_male_portrait" />
									</#if>

									<div class="block-container no-padding-horizontal speaker_container_${speaker_id_index}">
										<div class="block hidden-phone speaker-image-block w30">
											<img src="${speaker_image_src}" />
										</div>

										<div class="block speaker-info-block w60">
											<h4 class="no-margin speaker-title">${speaker.getFullName()}</h4>

											<#if speaker.getJobTitle(locale_english)?has_content>
												<p>${speaker.getJobTitle(locale_english)}, ${speaker.getCompanyName()}</p>
											</#if>

											<#if speaker.getDescription(locale)?has_content>
												<div class="font-weight-lighter speaker-bio">
													${speaker.getDescription(locale)}
												</div>

												<div class="block class-toggle text-center toggler-header-collapsed" data-target-class="session-speaker-toggle" data-target-nodes="#pop-up-agenda .speaker_container_${speaker_id_index}">
													<div class="show-me-more-caret text-center">
														<svg class="cta-icon" height="10" viewBox="0 0 32 19" width="16" xmlns="http://www.w3.org/2000/svg">
															<path d="M16 14.314L2.565.88.445 3l14.494 14.496 1.06 1.06L31.556 3 29.436.88 16 14.313z" fill="#000" fill-rule="evenodd" />
														</svg>
													</div>
												</div>
											</#if>
										</div>
									</div>
								</#list>
							</div>
						</td>
					</#list>
					</tr>
				</tbody>
			</table>
		</#list>
	</div>

	<div class="border-bottom border-left border-right border-top max-med pop-up-display" id="pop-up-agenda">
		<svg class="pop-up-close" height="40" width="40">
			<use xlink:href="#closeIcon"></use>
		</svg>

		<div class="large-padding pop-up-content"></div>
	</div>

	<div class="agenda-expand block class-toggle hidden-desktop hidden-tablet standard-padding-vertical text-center toggler-header-collapsed" data-target-class="agenda-visible" data-target-nodes=".sessions">
		<div class="show-me-more text-center">
			${lang.localize("show-me-more", "Show me more")}
		</div>

		<div class="show-me-less text-center">
			${lang.localize("show-me-less", "Show me less")}
		</div>

		<div class="show-me-more-caret text-center">
			<svg class="cta-icon" height="19" viewBox="0 0 32 19" width="32" xmlns="http://www.w3.org/2000/svg">
				<path d="M16 14.314L2.565.88.445 3l14.494 14.496 1.06 1.06L31.556 3 29.436.88 16 14.313z" fill="#000" fill-rule="evenodd" />
			</svg>
		</div>
	</div>

	<svg height="0" style="position:absolute" width="0">
		<symbol id="LDSF-Recap-Presentation" viewBox="0 0 20 20">
			<defs>
				<style>
					.acls-1{fill:#414141}
				</style>
			</defs>
			<path d="M18.93 3.7a.25.25 0 0 0 .25-.25V2.2a.25.25 0 0 0-.25-.2H1.07a.25.25 0 0 0-.25.25v1.21a.25.25 0 0 0 .25.25h.7v8.36h-.7a.25.25 0 0 0-.25.25v1.26a.25.25 0 0 0 .25.25h8.68v1.57l-2.67 2.21a.25.25 0 0 0 .32.39l2.6-2.16L12.6 18a.25.25 0 0 0 .31-.38l-2.66-2.22v-1.59h8.69a.25.25 0 0 0 .25-.25v-1.25a.25.25 0 0 0-.25-.25h-.71V3.7h.71zM1.31 2.45h17.38v.76H1.31v-.76zm17.38 10.87H1.31v-.77h17.38v.76zm-1-1.26H2.27V3.7h15.46v8.36z" class="acls-1"/>
			<path d="M9.48 7.7v2.6a.25.25 0 0 0 .25.25h1.67a.25.25 0 0 0 .25-.25V7.7a.25.25 0 0 0-.25-.25H9.73a.25.25 0 0 0-.25.25zm.52.25h1.18v2.11H10V7.95zM12.25 10.55h1.67a.25.25 0 0 0 .25-.25V9a.25.25 0 0 0-.25-.25h-1.67A.25.25 0 0 0 12 9v1.33a.25.25 0 0 0 .25.22zm.25-1.33h1.18v.84H12.5v-.84zM14.78 10.55h1.67a.25.25 0 0 0 .25-.25V6a.25.25 0 0 0-.25-.25h-1.67a.25.25 0 0 0-.25.25v4.35a.25.25 0 0 0 .25.2zM15 6.2h1.18v3.86H15V6.2zM3.54 6.47h5.8a.25.25 0 1 0 0-.49h-5.8a.25.25 0 1 0 0 .49zM3.54 7.83h4.12a.25.25 0 1 0 0-.49H3.54a.25.25 0 1 0 0 .49zM3.54 9.19h4.12a.25.25 0 0 0 0-.49H3.54a.25.25 0 0 0 0 .49zM3.54 10.56h4.12a.25.25 0 0 0 0-.49H3.54a.25.25 0 0 0 0 .49z" class="acls-1"/>
		</symbol>
		<symbol id="LDSF-Recap-Video" viewBox="0 0 20 20">
			<defs>
				<style>
					.bcls-1{fill:none;stroke:#414141;stroke-linecap:round;stroke-linejoin:round;stroke-width:0.46px}
				</style>
			</defs>
			<path d="M2.92 3.4h14.16v9.57H2.92z" class="bcls-1"/>
			<path d="M1.85 2.31h16.3v11.75H1.85z" class="bcls-1"/>
			<path d="M8.49 10.62V5.74l3.77 2.45-3.77 2.43z" class="bcls-1"/>
		</symbol>
	</svg>
</section>

<div class="agenda-background"></div>

<style>
	.font-weight-normal {
		font-weight: normal;
	}

	.num-tracks-1 {
		display: block;
	}

	.session-detail:hover {
		cursor: pointer;
	}

	.session-detail .pop-up-content {
		margin: 0 auto;
		width: 100%;
	}

	.session-detail .white-background, .sessions .pop-up-display {
		background: #FFF;
	}

	.session-filter {
		border: 1px solid currentColor;
		border-radius: 3px;
		cursor: pointer;
		margin: 0 1em 2em;
		min-width: 5em;
	}

	.session-filter:hover {
		transform: scale(1.02);
	}

	<#list session_topics as session_topic>
		.sessions .session-detail.${session_topic.cssClass} {
			background: linear-gradient(transparent 3em, #${session_topic.color} 3em) no-repeat left 20px bottom 1em / 3px 100%;
		}

		.session-filter.${session_topic.cssClass}, .sessions .session-detail span.${session_topic.cssClass} {
			color: #${session_topic.color};
		}

		.sessions:not(.no-filter) .session-filter.${session_topic.cssClass}[class*='filter-active'],
		.session-filter.${session_topic.cssClass}:hover {
			background-color: #${session_topic.color};
			color: #FFF;
		}

		.sessions .session-detail.${session_topic.cssClass} .speaker-indent {
			padding-left: 15px;
		}
	</#list>

	.session-filter.all-filter {
		color: #000;
		cursor: auto;
	}

	.sessions:not([class*='filter-active']) .session-filter.all-filter {
		background: #D3D3D3;
		border-color: #D3D3D3;
		color: #FFF;
	}

	.sessions[class*='filter-active'] .session-filter.all-filter {
		cursor: pointer;
	}

	.session-tab {
		-webkit-flex: 1;
		flex: 1;
		list-style: none;
		text-decoration: none;
	}

	.session-tab.block-container, .session-table {
		display: none;
	}

	.sessions h4.session-title {
		padding-bottom: 0.25em;
	}

	.sessions .pop-up-content .block.speaker-image-block {
		margin-right: 1em;
		max-width: 30%;
	}

	.sessions .pop-up-content .block.speaker-info-block {
		min-height: 175px;
		overflow: hidden;
		position: relative;
	}

	.sessions .pop-up-content h4.session-title, .sessions .pop-up-content h4.speaker-title {
		color: #00A4CB;
	}

	.sessions .pop-up-content h4.speaker-title {
		text-transform: uppercase;
	}

	.sessions .pop-up-content .speaker-bio {
		position: absolute;
	}

	.sessions .pop-up-content .speaker-info-block:after {
		background: linear-gradient(rgba(255, 255, 255, 0.05) 60%, white 80%);
		content: '';
		display: block;
		height: 100%;
		position: absolute;
		top: 0;
		width: 100%;
	}

	.sessions .pop-up-content .session-speaker-toggle .class-toggle,  .sessions .pop-up-content .session-speaker-toggle .speaker-bio {
		position: static;
	}

	.sessions .pop-up-content .not-overflowing:after {
		height: 0;
	}

	.sessions .pop-up-content .not-overflowing .class-toggle {
		display: none;
	}

	.sessions .pop-up-content .class-toggle {
		bottom: 0;
		position: absolute;
		width: 100%;
		z-index: 1;
	}

	.sessions .pop-up-content .session-speaker-toggle .speaker-info-block:after {
		height: 0;
	}

	.session-tab, .sessions h4.session-summary-title, .sessions h4.session-time, .sessions h4.session-title, .sessions h4.speaker-title, .track-title {
		font-size: 1.45em;
	}

	.session-tab, .sessions h4.session-summary-title, .sessions h4.session-title, .sessions h4.speaker-title, .track-title {
		font-weight: lighter;
	}

	.session-table tr {
		vertical-align: top;
	}

	.sessions .agenda-day-btn {
		height: 34px;
		margin: 0 10px;
		vertical-align: middle;
		width: 34px;
	}

	.sessions .agenda-next-day-btn, .aui .sessions.agenda-visible .agenda-expand .cta-icon, .aui .pop-up-content .session-speaker-toggle .cta-icon {
		-ms-transform: rotate(-180deg);
		-webkit-transform: rotate(-180deg);
		transform: rotate(-180deg);
	}

	.sessions tr[class*='session'], .session-detail {
		transition: opacity 0.3s ease;
	}

	.sessions:not(.no-filter)[class*='filter-active'] tr.filter-hidden-row {
		display: none;
	}

	.sessions:not(.no-filter)[class*='filter-active'] .session-detail:not([class*='filter-active']) {
		opacity: 0.2;
	}

	.sessions .pop-up-display .pop-up-content {
		margin-top: 1.5em;
	}

	.sessions #pop-up-agenda .pop-up-close {
		padding: 1em;
		top: 0;
	}

	.sessions ul.session-tab-wrapper {
		display: -moz-box;
		display: -ms-flexbox;
		display: -webkit-box;
		display: -webkit-flex;
		display: flex;
		margin: 0;
	}

	.sessions .track-title {
		text-transform: uppercase;
	}

	.sessions:not([class*='class-toggle-active']) .session-tab.${default_day},
	.session-tab[class*='class-toggle-active'] {
		display: -moz-box;
		display: -moz-flex;
		display: -ms-flexbox;
		display: -webkit-box;
		display: -webkit-flex;
		display: flex;
	}

	.sessions:not([class*='class-toggle-active']) .session-table.${default_day},
	.session-table[class*='class-toggle-active'] {
		display: table;
	}

	.session-table.no-rows-visible {
		margin-bottom: 50px;
		position: relative;
	}

	.session-table.no-rows-visible::after {
		color: red;
		content: "No talks match your filter criteria. Please select other filters or click on All to show all talks.";
		display: block;
		font-size: 20px;
		padding: 1em;
		position: absolute;
		text-align: center;
		width: 100%;
	}

	.speaker-spacer {
		background: white;
		display: block;
		height: 10px;
		margin-left: -20px;
		width: 100%;
	}

	tr.alltogether, tr.alltogether .session-detail .white-background, tr.alltogether .speaker-spacer  {
		background: #F6F6F6;
	}

	.time-display {
		vertical-align: top;
	}

	@media(min-width: 768px) {
		.session-table {
			table-layout: fixed;
		}
	}

	@media(min-width: 1200px) {
		.agenda-background {
			background-image: url(/documents/231427850/0/Piet+Mondrian+Pattern+Small.svg);
			background-position: left bottom;
			background-repeat: no-repeat;
			background-size: 20%;
			height: 250px;
			width: 100%;
		}
	}

	@media(max-width: 767px) {
		.aui .agenda-expand {
			cursor: pointer;
			font-size: 1.25em;
			padding-top: 3em;
		}

		.aui .sessions .show-me-less, .aui .sessions.agenda-visible .show-me-more {
			display: none;
		}

		.aui .sessions.agenda-visible .show-me-less {
			display: block;
		}

		#pop-up-agenda {
			width: 95vw;
		}

		.session-detail {
			display: block;
		}

		.session-tab, .sessions h4.session-title, .sessions h4.session-time, .track-title, .sessions h4.session-summary-title, .sessions h4.speaker-title {
			font-size: 1.25em;
		}

		.session-tab-date-title {
			width: 60%;
		}

		.sessions .agenda-hidden {
			height: 300px;
			overflow: hidden;
		}

		.sessions tr.hidden-desktop {
			display: table-row !important;
		}

		.sessions.agenda-visible .agenda-hidden {
			height: auto;
		}

		.time-display.w10 {
			width: auto;
		}
	}
</style>

<script type="text/javascript">
	AUI().ready(
		'class-toggle',
		'pop-up',
		'aui-base',
		function(A) {
			var endDate = new Date('${marketing_event.getEndDate()?string["EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'"]}').getTime();
			var now = new Date().getTime();
			var oneDay = 86400000;

			if (endDate < now + oneDay) {
				var breaks = A.all('.alltogether');

				breaks.setHTML();
			}

			var activateSessionPopupCallback = function(classToggleInstance, node, targetNodes, targetClass) {
				var videoNode = node.one('.session-video');

				var popUp = A.one('#pop-up-agenda .pop-up-content');

				if (videoNode) {
					var src = videoNode.attr('data-url');

					var video = popUp.one('iframe') || popUp.one('video source');

					if (video) {
						video.attr('src', src);
					}
				}

				A.all('#pop-up-agenda .speaker-info-block').each(
					function(item) {
						var speakerInfoBlockDOMNode = item.getDOMNode();

						if (speakerInfoBlockDOMNode.clientHeight < speakerInfoBlockDOMNode.scrollHeight) {
							item.addClass('overflowing');
						}
						else {
							item.addClass('not-overflowing');
						}
					}
				);
			};

			new A.PopUp(
				{
					activateCallback: activateSessionPopupCallback,
					alignTopNode: '.sessions',
					centered: true,
					popUpId: '#pop-up-agenda',
					trigger: '.session-detail'
				}
			).render();

			var rows = A.all('.sessions tr[class*="session"]');

			for (var i = 0; i < rows.size(); i++) {
				var currentRow = rows.item(i);

				var rowSessionNodes = currentRow.all('.session-detail');

				currentRow.setData('rowSessions', rowSessionNodes.getDOMNodes());
			}

			for (i = 0; i < rows.size(); i++) {
				rowSessionNodes = rows.item(i).all('.session-detail');

				for (var j = 0; j < rowSessionNodes.size(); j++) {
					var rowspan = parseInt(rowSessionNodes.item(j).getAttribute('rowspan'), 10);

					for (var k = 1; k < rowspan; k++) {
						var currentRowSpan = rows.item(i + k);

						var rowSessions = currentRowSpan.getData('rowSessions');

						currentRowSpan.setData('rowSessions', rowSessions.concat(rowSessionNodes.getDOMNodes()));
					}
				}
			}

			var setRowVisibility = function() {
				A.all('.sessions tr[class*="session"]').each(
					function(node) {
						var hasFilteredNodes = false;
						var rowSessionsArray = node.getData('rowSessions');

						for (var i = 0; i < rowSessionsArray.length; i++) {
							if (rowSessionsArray[i].className.indexOf('filter-active') != -1) {
								hasFilteredNodes = true;

								break;
							}
						}

						if (hasFilteredNodes) {
							node.removeClass('filter-hidden-row');
						}
						else {
							node.addClass('filter-hidden-row');
						}
					}
				);

				A.all('.sessions[class*="filter-active"] .session-table').each(
					function(node) {
						var visibleRows = node.all('tr[class*="session"]:not([class*="filter-hidden-row"])');

						node.toggleClass('no-rows-visible', visibleRows.isEmpty());
					}
				);
			};

			var allFilterActivateCallback = function() {
				A.all('.session-filter[class*="filter-active"]').each(
					function(node) {
						var targetClass = node.getData('target-class');

						A.all('.' + targetClass).removeClass(targetClass);
					}
				);

				A.all('.sessions tr[class*="session"]').removeClass('filter-hidden-row');
				A.all('.sessions .session-table').removeClass('no-rows-visible');
			};

			var sessions = A.one('.sessions');

			var activateCallback = function() {
				sessions.removeClass('no-filter');

				setRowVisibility();
			};

			var deactivateCallback = function() {
				if (sessions) {
					var filteredTopics = A.one('.session-filter[class*="filter-active"]');

					if (!filteredTopics) {
						sessions.addClass('no-filter');

						allFilterActivateCallback();
					}
				}

				setRowVisibility();
			};

			new A.ClassToggle(
				{
					activateCallback: activateCallback,
					baseClassName: 'filter-toggle',
					deactivateCallback: deactivateCallback,
					item: '.filter-toggle'
				}
			).render();

			new A.ClassToggle(
				{
					activateCallback: allFilterActivateCallback,
					baseClassName: 'no-filter',
					item: '.all-filter'
				}
			).render();
		}
	);
</script>