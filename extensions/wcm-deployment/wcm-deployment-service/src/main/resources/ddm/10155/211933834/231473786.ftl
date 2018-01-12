<#assign portlet_bean_locator = objectUtil("com.liferay.portal.kernel.bean.PortletBeanLocatorUtil") />

<#assign asset_vocabulary_local_service = serviceLocator.findService("com.liferay.portlet.asset.service.AssetVocabularyLocalService") />
<#assign marketing_event_local_service = portlet_bean_locator.locate("osb-www-marketing-events-portlet", "com.liferay.osb.www.marketing.events.service.MarketingEventLocalService") />
<#assign marketing_event_session_local_service = portlet_bean_locator.locate("osb-www-marketing-events-portlet", "com.liferay.osb.www.marketing.events.service.MarketingEventSessionLocalService") />
<#assign marketing_event_session_room_local_service = portlet_bean_locator.locate("osb-www-marketing-events-portlet", "com.liferay.osb.www.marketing.events.service.MarketingEventSessionRoomLocalService") />
<#assign marketing_event_user_local_service = portlet_bean_locator.locate("osb-www-marketing-events-portlet", "com.liferay.osb.www.marketing.events.service.MarketingEventUserLocalService") />

<#assign marketing_event_id = getterUtil.getLong(marketing_event_id.data, 0) />

<#assign service_context = objectUtil("com.liferay.portal.kernel.service.ServiceContextThreadLocal").getServiceContext() />
<#assign http_servlet_request = service_context.getRequest() />

<#assign class_loader_util = staticUtil["com.liferay.portal.util.ClassLoaderUtil"]>
<#assign class_loader = class_loader_util.getPluginClassLoader("osb-www-marketing-events-portlet")>

<#assign marketing_events_util = staticUtil["com.liferay.portal.kernel.util.InstanceFactory"].newInstance(class_loader, "com.liferay.osb.www.marketing.events.util.MarketingEventsUtil")>

<#assign session_sponsors = marketing_events_util.getMarketingEventUsers(marketing_event_id, "Marketing Event User Types", "Session Sponsor")! />

<#assign marketing_event_session_id = paramUtil.getString(http_servlet_request, "sessionId") />

<#assign sessions_map = marketing_event_session_local_service.getMarketingEventSessionsMap(marketing_event_id, true)! />

<#assign time_zone_id = marketing_event_local_service.getMarketingEvent(marketing_event_id).getTimeZoneId() />
<#assign time_zone = timeZoneUtil.getTimeZone(time_zone_id) />

<#assign fast_date_format_factory_util = staticUtil["com.liferay.portal.kernel.util.FastDateFormatFactoryUtil"]>
<#assign time_format = fast_date_format_factory_util.getSimpleDateFormat((agenda_time_format.data)!"H:mm", locale, time_zone) />

<#assign default_day = (agenda_default_day.data)!"day-1"/>

<#import "${templatesPath}/231368766" as article_utilities>
<#import "${templatesPath}/1561886" as lang>

<#assign session_type_vocabulary_name = "Marketing Event Session Types">

<#assign text_formatter = staticUtil["com.liferay.portal.kernel.util.TextFormatter"]>

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

					<tr class="border-bottom element-border session-${session.getMarketingEventSessionId()}">
						<#if current_session_time != previous_session_time>
							<#assign previous_session_time = current_session_time />

							<td class="hidden-phone hidden-tablet standard-padding time-display w20" rowspan="${slot_talk_counts[session.getStartDate().getTime()?string]}">
								<h3 class="alt-font-color">
								${current_session_time}
								</h3>
							</td>
						</#if>

						<#assign session_type = "">

						<#assign session_categories = session.getAssetCategories()>

						<#list session_categories as session_category>
							<#assign session_category_vocabulary = asset_vocabulary_local_service.getAssetVocabulary(session_category.getVocabularyId())>

							<#if session_category_vocabulary.getName()?upper_case == session_type_vocabulary_name?upper_case>
								<#assign session_type = text_formatter.format(session_category.getName(), 2)>
							</#if>
						</#list>

						<#assign child_file_entry_urls = session.getChildFileEntryURLs() />

						<td class="align-center block-container <#if session.getMarketingEventUserIds()?has_content>session-detail</#if> standard-padding" data-session-type="${htmlUtil.escape(session_type)}" data-talks-in-row="${slot_talk_counts[session.getStartDate().getTime()?string]}">

						<#assign child_file_entry_urls = session.getChildFileEntryURLs() />

							<div class="block w70">
								<p class="visible-phone visible-tablet">${current_session_time_range}</p>

								<h4 class="session-title">${session.getTitle(locale)}</h4>

								<#assign session_company_logos = {} />

								<#if session.getSlidesFileEntry()??>
									<svg class="pop-up-close" height="20" width="20">
										<use xlink:href="#LDSF-Recap-Presentation"></use>
									</svg>
								</#if>

								<#if (session.getVideoURL()?? && session.getVideoURL()?has_content) || child_file_entry_urls?has_content>
									<svg class="pop-up-close" height="20" width="20">
										<use xlink:href="#LDSF-Recap-Video"></use>
									</svg>
								</#if>

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
							</div>

							<#if session.getMarketingEventUserIds()?has_content>
								<div class="pop-up-content standard-padding">
									<div class="block-container">
										<div class="block hidden-tablet hidden-phone standard-padding speakers w30">
											<div class="speakers">
												<#list session_speaker_ids as speaker_id>
													<#assign speaker = marketing_event_user_local_service.getMarketingEventUser(speaker_id) />
													<div class="speaker speaker-${speaker_id_index}">
														<#if speaker??>
															<#if speaker.getImageFileEntryId() != 0 >
																<#assign image_file_entry = speaker.getImageFileEntry() />

																<#assign src = "/documents/${image_file_entry.getRepositoryId()}/${image_file_entry.getFolderId()}/${image_file_entry.getTitle()}/${image_file_entry.getUuid()}" />
															<#else>
																<#assign src = "/image/user_male_portrait"/>
															</#if>

															<div class="speaker-image">
																<img class="w100" src="${src}" />
															</div>

															<div class="small-padding-vertical">
																<h3 class="speaker-name">
																	${speaker.getFirstName()} ${speaker.getLastName()}
																</h3>

																<#if speaker.getJobTitle(locale)?has_content>
																	<h4 class="speaker-title">
																		<em>${speaker.getJobTitle(locale)}</em>
																	</h4>
																	<p>${speaker.getCompanyName()}</p>
																</#if>

																<#if speaker.getDescription(locale)?has_content>
																	<div class="font-weight-lighter speaker-bio">
																		${speaker.getDescription(locale)}
																	</div>
																</#if>
															</div>
														</#if>
													</div>
												</#list>
											</div>
										</div>

										<div class="block session-detail w70 standard-padding">
											<#assign video_url = session.getVideoURL()?string />

											<#if video_url?has_content>
												<#if video_url?contains('youtube')>
													<#assign substring_start = video_url?index_of('v=') + 2 />
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

											<h3 class="session-title small-padding-vertical">${session.getTitle(locale)}</h3>

											<#if session.getDescription(locale)?has_content>
												<div class="session-summary">
												${session_summary_translation.data}:

													<p class="session-summary">${session.getDescription(locale)?replace("\n", "<br>")}</p>
												</div>
											</#if>

											<#assign base_url = request.scheme + "://" + request['server-name'] />
											<#assign current_url = httpUtil.getPath(request.attributes['CURRENT_URL']) />

											<#assign share_url = base_url + current_url />
											<#assign share_url = httpUtil.addParameter(share_url, "sessionId", session.getMarketingEventSessionId()) />

											<label class="share-session-label" for="shareLink">${lang.localize("share-this-session", "Share this Session")}:</label>
											<input class="share-session" name="shareLink" onClick="this.select();" readonly type="text" value="${share_url}" />

											<#assign session_slides = session.getSlidesFileEntry()! />

											<#if session_slides?has_content>
												<div class="session-slides-form"></div>

												<#assign preview_url = base_url + "/documents/" + session_slides.getRepositoryId() + "/" + session_slides.getFolderId() + "/" + session_slides.getTitle() + "/" + session_slides.getUuid() />

												<#assign download_url = httpUtil.addParameter(preview_url, "download", true) />

												<#if hubspot_article_id?? && hubspot_article_id.data?has_content>
													<div class="hide session-slides" data-asset-name="${session_slides.getTitle()}" data-href="${download_url}"></div>
												<#else>
													<div class="btn-wrapper standard-padding-vertical">
														<a class="btn btn-primary" href="${download_url}">Get The Slides</a>
													</div>
												</#if>

											</#if>

											<#if child_file_entry_urls?has_content && child_file_entry_urls?contains(".mp3")>
												<#assign audio_download = base_url + child_file_entry_urls.get(0) />

												<div class="btn-wrapper standard-padding-vertical">
													<a class="btn btn-primary" href="${audio_download}">Get The Audio</a>
												</div>
											</#if>
										</div>
									</div>
								</div>
							</#if>
						</td>
					</tr>
				</#list>
			</tbody>
		</table>
	</#list>

	<div class="max-full pop-up-display w90" id="pop-up-agenda">
		<svg class="pop-up-close" height="20" width="20">
			<use xlink:href="#closeIcon"></use>
		</svg>

		<div class="pop-up-content standard-padding"></div>
	</div>

	<div class="hide save-hs-form">
		<div class="hs-form">
			<#if hubspot_article_id?? && hubspot_article_id.data?has_content>
				<@article_utilities.embed_journal_article_by_article_id hubspot_article_id.data />
			</#if>
		</div>
	</div>

	<svg width="0" height="0" style="position:absolute">
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
					.bcls-1{fill:none;stroke:#414141;stroke-linecap:round;stroke-linejoin:round;stroke-width:.46px}
				</style>
			</defs>
			<path d="M2.92 3.4h14.16v9.57H2.92z" class="bcls-1"/>
			<path d="M1.85 2.31h16.3v11.75H1.85z" class="bcls-1"/>
			<path d="M8.49 10.62V5.74l3.77 2.45-3.77 2.43z" class="bcls-1"/>
		</symbol>
	</svg>
</section>

<style>
	.aui input.share-session, .aui label.share-session-label {
		display: inline-block;
	}

	.aui input.share-session {
		cursor: pointer;
		max-width: 100%;
		width: 300px;
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

	.session-detail[data-session-type="break"] {
		background: #F3F3F3;
	}

	.session-detail[data-talks-in-row="1"] {
		background: #EBEBEB;
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

	.sessions .pop-up-display {
		background: #FFF;
		box-shadow: 0 0 36px 0px rgba(0,0,0,0.2);
		max-height: 95%;
		overflow: auto;
		position: fixed;
		top: 5% !important;
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

	.session-video {
		position: relative;
	}

	.session-video.youtube {
		padding-bottom: 56.4%;
	}

	.session-video.native {
		padding-bottom: 57%;
	}

	.session-video iframe, .session-video video {
		position: absolute;
		height: 100%;
	}

	.time-display {
		vertical-align: top;
	}
</style>

<script type="text/javascript">
	AUI().ready(
			'node-event-simulate',
			'pop-up',
			function(A) {
				var activateCallback = function(classToggleInstance, node, targetNodes, targetClass) {
					var nodeContent = node.one('.' + classToggleInstance.get('baseClassName') + '-content');
					var targetNodesContent = targetNodes.one('.' + classToggleInstance.get('baseClassName') + '-content');

					if (targetNodesContent && nodeContent) {
						var videoNode = nodeContent.one('.session-video');

						var hsForm = A.one('.hs-form');

						if (videoNode) {
							var src = videoNode.attr('data-url');

							var video = videoNode.one('iframe') || videoNode.one('video source');

							if (video) {
								video.attr('src', src);
							}
						}

						var htmlFormNode = hsForm.one('form');

						var slidesNode = nodeContent.one('.session-slides');

						if (htmlFormNode && slidesNode) {
							var assetInfo = {
								'asset_name': slidesNode.attr('data-asset-name')
							};

							htmlFormNode.setAttribute('data-asset-info', JSON.stringify(assetInfo));
						}

						targetNodesContent.setContent(nodeContent.getContent());

						var formNode = targetNodesContent.one('.session-slides-form');

						if (formNode) {
							formNode.setContent(hsForm);
						}
					}

					A.one('body').setStyle('overflow-y', 'hidden');
				};

				var deactivateCallback = function(classToggleInstance, node, targetNodes, targetClass) {
					var targetNodesContent = targetNodes.one('.' + classToggleInstance.get('baseClassName') + '-content');

					if (targetNodesContent) {
						var hsForm = targetNodesContent.one('.hs-form');
						var saveHsForm = A.one('.save-hs-form');

						if (hsForm && saveHsForm) {
							saveHsForm.setContent(hsForm);
						}

						targetNodesContent.empty();
					}

					A.one('body').setStyle('overflow-y', 'visible');

					var hsSubmitBtn = A.one('.hs-form .btn[name="hsSubmitBtn"]');

					if (hsSubmitBtn) {
						hsSubmitBtn.set('disabled', false);
					}

				};

				var popUp = new A.PopUp(
						{
							activateCallback: activateCallback,
							centered: true,
							defaultCallbacks: false,
							deactivateCallback: deactivateCallback,
							popUpId: '#pop-up-agenda',
							trigger: '.session-detail'
						}
				).render();

				var sessionId = '${marketing_event_session_id}';

				if (sessionId) {
					var sessionSelector = '.session-' + sessionId + ' .session-detail';
					var sessionNode = A.one(sessionSelector);

					if (sessionNode) {
						sessionNode.simulate('click');
					}
				}
			}
	);
</script>