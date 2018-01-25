<#import "${templatesPath}/1561886" as lang>

 

<#assign marketing_event_user_local_service =   serviceLocator.findService("com.liferay.osb.www.marketing.events.service.MarketingEventUserLocalService") />

<#assign marketing_event_id = getterUtil.getLong(marketing_event_id.data, 0) />

<#assign speaker_list = marketing_event_user_local_service.getMarketingEventUsers(marketing_event_id, 0, -1, -1) />

<#if request.lifecycle == 'RENDER_PHASE'>
	<div class="large-padding-vertical speakers-wrapper" id="speakers">

		<h2 class="lego-element light-color text-center">SPEAKER HIGHLIGHTS</h2>

		<div class="block-container max-full speakers">
			<#list speaker_list as speaker>
				<#if speaker_index < 4>
					<@print_speaker_tile speaker "" />
				<#elseif speaker_index < 6>
					<@print_speaker_tile speaker "hide-second" />
				<#else>
					<@print_speaker_tile speaker "hide-first" />
				</#if>

				<#if speaker_index == 7>
					<#break>
				</#if>
			</#list>

			<#if speaker_list?size < 8>
				<@print_speaker_tile speaker_list[0] "ghost-speaker" />
				<@print_speaker_tile speaker_list[0] "ghost-speaker" />
				<@print_speaker_tile speaker_list[0] "ghost-speaker" />
			</#if>
		</div>

		<div class="speakers-hidden toggler-content-collapsed">
			<div class="block-container max-full speakers ">
				<#list speaker_list as speaker_hidden>
					<#if speaker_hidden_index < 4>
						<@print_speaker_tile speaker_hidden "hide" />
					<#elseif speaker_hidden_index < 6>
						<@print_speaker_tile speaker_hidden "show-second" />
					<#elseif speaker_hidden_index < 8>
						<@print_speaker_tile speaker_hidden "show-first" />
					<#else>
						<@print_speaker_tile speaker_hidden "" />
					</#if>
				</#list>

				<@print_speaker_tile speaker_list[0] "ghost-speaker" />
				<@print_speaker_tile speaker_list[0] "ghost-speaker" />
				<@print_speaker_tile speaker_list[0] "ghost-speaker" />
			</div>
		</div>

		<#assign speakers_expand_css = "">
		<#if speaker_list?size gt 8>
			<#assign speakers_expand_css = "more-than-four more-than-six more-than-eight">
		<#elseif speaker_list?size gt 6>
			<#assign speakers_expand_css = "more-than-four more-than-six">
		<#elseif speaker_list?size gt 4>
			<#assign speakers_expand_css = "more-than-four">
		</#if>

		<div class="block ${speakers_expand_css} speakers-expand standard-padding-vertical text-center toggler-header-collapsed">
			<div class="light-color show-me-more text-center">
				${lang.localize("show-me-more", "Show me more")}
			</div>

			<div class="light-color show-me-less text-center">
				${lang.localize("show-me-less", "Show me less")}
			</div>

			<div class="light-color show-me-more-caret text-center">
				<svg class="cta-icon" height="19" viewBox="0 0 32 19" width="32" xmlns="http://www.w3.org/2000/svg">
					<path d="M16 14.314L2.565.88.445 3l14.494 14.496 1.06 1.06L31.556 3 29.436.88 16 14.313z" fill="#FFF" fill-rule="evenodd"/>
				</svg>
			</div>
		</div>

		<div class="max-full pop-up-display" id="popUpSpeaker">
			<svg class="pop-up-close" height="40" width="40">
				<use xlink:href="#closeIcon"></use>
			</svg>

			<div class="pop-up-content"></div>
		</div>
	</div>

	<#macro print_speaker_tile speaker css_class>
		<#assign src = speaker.getImageFileEntryURL() >
		<#if !src?has_content>
			<#assign src = "/image/user_male_portrait"/>
		</#if>

		<div class="${css_class} pop-up-trigger speaker-tile" data-marketing-event-user-id="${speaker.getMarketingEventUserId()?string}">
			<div class="speaker">
				<div class="aspect-ratio">
					<div class="speaker-img">
						<img class="w100" src="${src}" />
					</div>

					<div class="small-padding speaker-info">
						<h3 class="speaker-name">${speaker.getFirstName()} ${speaker.getLastName()}</h3>

						<#if speaker.getJobTitle()?has_content>
							<div class="speaker-title">${speaker.getJobTitle(locale)}</div>
						</#if>

						<#if speaker.getCompanyName()?has_content>
							<div class="speaker-company">${speaker.getCompanyName()}</div>
						</#if>
					</div>
				</div>
			</div>
		</div>
	</#macro>

	<style type="text/css">
		.aui .ghost-speaker, .ghost-speaker div {
			height: 0;
			overflow: hidden;
			padding: 0;
		}

		.aui .overlaymask-content.default-overlay-content {
			background-color: rgba(59, 70, 75, 0.85);
		}

		.aui .speakers.max-full {
			max-width: 1300px;
		}

		.aui .speakers .aspect-ratio {
			background-color: #FFF;
			border-radius: 2px;
			box-shadow: 2px 2px 20px 3px #333;
			height: 0;
			padding-bottom: 100%;
		}

		.aui .speakers .speaker {
			cursor: pointer;
			height: 100%;
			position: relative;
			width: 100%;
		}

		.aui .speakers .speaker img {
			min-height: 100%;
			object-fit: cover;
			transition: transform 0.25s ease;
		}

		.aui .speakers .speaker:hover img {
			transform: scale(1.05);
		}

		.aui .speakers .speaker-img {
			border-radius: 2px 2px 0 0;
			height: 72%;
			overflow: hidden;
			position: absolute;
			width: 100%;
		}

		.aui .speakers .speaker-info {
			box-sizing: border-box;
			font-size: 14px;
			font-weight: normal;
			height: 28%;
			line-height: 1;
			padding: 8px 14px;
			position: absolute;
			top: 72%;
			width: 100%;
		}

		.aui .speakers .speaker-tile {
			box-sizing: border-box;

			-webkit-flex-basis: 290px;
			flex-basis: 290px;

			-webkit-flex-grow: 1;
			flex-grow: 1;
			padding: 8px 12px;
			position: relative;
		}

		.aui .speakers-expand {
			cursor: pointer;
			font-size: 1.25em;
		}

		.aui .speakers-expand.toggler-header-expanded .cta-icon {
			transform: rotate(-180deg);
		}

		.aui .speakers-expand.toggler-header-collapsed .show-me-less {
			display: none;
		}

		.aui .speakers-expand.toggler-header-expanded .show-me-more {
			display: none;
		}

		.aui .speaker-name {
			color: #00A4CB;
			font-size: 1.3em;
			font-weight: 400;
			letter-spacing: 1px;
			line-height: 1.25;
			margin-bottom: 4px;
			text-transform: uppercase;
		}

		.aui .speaker-pop-up .block.speaker-image-block {
			margin-right: 1em;
			max-width: 30%;
		}

		.aui .speaker-pop-up .speaker-info {
			font-size: 20px;
			line-height: 1;
		}

		.aui .speaker-pop-up .speaker-name {
			font-size: 1.5em;
		}

		.aui .speakers-wrapper {
			background: #3B464B;
		}

		.aui .speakers-wrapper .pop-up-display {
			background-color: #FFF;
			max-width: 650px;
		}

		.aui .speakers-wrapper .pop-up-display .pop-up-close {
			right: 1em;
			top: 1em;
		}

		.show-first, .show-second {
			display: none;
		}

		.speakers-expand {
			display: none;
		}

		.speaker-socials a {
			margin: 0 2px;
		}

		.speaker-socials svg {
			fill: #909295;
			height: 20px;
			width: 20px;

			-moz-transition: all 0.25s ease-in-out;
			-o-transition: all 0.25s ease-in-out;
			-webkit-transition: all 0.25s ease-in-out;
			transition: all 0.25s ease-in-out;
		}

		.speaker-socials .facebook:hover svg {
			fill: #3B5998;
		}

		.speaker-socials .github:hover svg {
			fill: #181717;
		}

		.speaker-socials .instagram:hover svg {
			fill: #125688;
		}

		.speaker-socials .linkedin:hover svg {
			fill: #0077B5;
		}

		.speaker-socials .twitter:hover svg {
			fill: #55ACEE;
		}

		.speaker-socials .youtube:hover svg {
			fill: #CD201F;
		}

		@media all and (min-width: 1192px) {
			.speakers-expand.more-than-eight {
				display: block;
			}
		}

		@media all and (max-width: 1191px) {
			.hide-first {
				display: none;
			}

			.show-first {
				display: block;
			}

			.speakers-expand.more-than-six {
				display: block;
			}
		}

		@media all and (max-width: 901px) {
			.hide-second {
				display: none;
			}

			.show-second {
				display: block;
			}

			.speakers-expand.more-than-four {
				display: block;
			}
		}
	</style>

	<script id="${randomNamespace}speakerPopupTpl" type="text/x-alloy-template">
		<div class="large-padding modal-content speaker-pop-up">
			<div class="block-container no-padding">
				<div class="block hidden-phone speaker-image-block w30">
					<img src="{image_url}" />
				</div>

				<div class="block speaker-info-block w60">
					<h3 class="speaker-name">
						{name}
					</h3>

					<p class="speaker-info">
						{title}
						<br />
						{company}
					</p>

					<div class="speaker-socials">
						<tpl for="social_links">
							<a class="{class_name}" href="{url}" target="_blank" title="{type_name}">
								<svg><use xlink:href="{icon_name}" xmlns:xlink="http://www.w3.org/1999/xlink"></use></svg>
							</a>
						</tpl>
					</div>
				</div>
			</div>

			<p class="speaker-description standard-padding-vertical">
				{description}
			</p>
		</div>
	</script>

	<script>
		AUI().ready(
			'aui-io-request',
			'aui-template-deprecated',
			'aui-toggler',
			'pop-up',
			function(A) {
				new A.Toggler(
					{
						animated: true,
						container: '.speakers-wrapper',
						content: '.speakers-hidden',
						expanded: false,
						header: '.speakers-expand',
						transition: {
							duration: 0.3,
							easing: 'ease-out'
						}
					}
				);

				var SPEAKER_POPUP_DATA = 'speaker_popup_data';

				var setupSpeakerPopup = function() {
					var popupTpl = A.one('#${randomNamespace}speakerPopupTpl');
					var speakerPopupContent = A.one('#popUpSpeaker .pop-up-content');

					var speakerPopupTpl = popupTpl ? new A.Template(popupTpl.html()) : '';

					var activateCallback = function(classToggleInstance, node, targetNodes, targetClass) {
						if (speakerPopupContent && speakerPopupTpl) {
							var speakerPopupData = node.getData(SPEAKER_POPUP_DATA);

							if (speakerPopupData) {
								speakerPopupContent.setContent(speakerPopupTpl.parse(speakerPopupData));
							}
						}
					};

					var deactivateCallback = function(classToggleInstance, node, targetNodes, targetClass) {
						if (speakerPopupContent) {
							speakerPopupContent.empty();
						}
					};

					new A.PopUp(
						{
							activateCallback: activateCallback,
							alignTopNode: '.speakers-wrapper',
							deactivateCallback: deactivateCallback,
							defaultCallbacks: false,
							popUpId: '#popUpSpeaker'
						}
					).render();
				};

				A.io.request(
					'${request["resource-url"]}',
					{
						data: {},
						dataType: 'json',
						method: 'GET',
						on: {
							success: function(event, id, obj) {
								var responseData = this.get('responseData');

								for (var marketingEventUserId in responseData) {
									var speakerNode = A.one('.speaker-tile[data-marketing-event-user-id="' + marketingEventUserId + '"]');

									if (speakerNode) {
										speakerNode.setData(SPEAKER_POPUP_DATA, responseData[marketingEventUserId]);

										speakerNode.addClass('pop-up-trigger');
									}
								}

								setupSpeakerPopup();
							}
						}
					}
				);
			}
		);
	</script>
<#elseif request.lifecycle == 'RESOURCE_PHASE'>
	<#assign speaker_popup_json = jsonFactoryUtil.createJSONObject() />

	<#list speaker_list as speaker>
		<#assign speaker_object = jsonFactoryUtil.createJSONObject() />

		<#assign VOID = speaker_object.put("company", speaker.getCompanyName())>
		<#assign VOID = speaker_object.put("description", speaker.getDescription(locale))>
		<#assign VOID = speaker_object.put("name", speaker.getFullName())>
		<#assign VOID = speaker_object.put("title", speaker.getJobTitle(locale))>

		<#assign speaker_image_src = speaker.getImageFileEntryURL() >

		<#if !speaker_image_src?has_content>
			<#assign speaker_image_src= "/image/user_male_portrait"/>
		</#if>

		<#assign VOID = speaker_object.put("image_url", speaker_image_src)>

		<#assign social_link_array = jsonFactoryUtil.createJSONArray() />

		<#list speaker.getSocialLinks() as social_link>
			<#assign link_type = social_link.getSocialLinkTypeName()>

			<#assign social_link_object = jsonFactoryUtil.createJSONObject() />

			<#assign VOID = social_link_object.put("class_name", link_type?lower_case)>
			<#assign VOID = social_link_object.put("icon_name", "#" + link_type?lower_case + "SocialIcon")>
			<#assign VOID = social_link_object.put("type_name", link_type)>
			<#assign VOID = social_link_object.put("url", social_link.getUrl())>

			<#assign VOID = social_link_array.put(social_link_object)>
		</#list>

		<#assign VOID = speaker_object.put("social_links", social_link_array)>

		<#assign VOID = speaker_popup_json.put(speaker.getMarketingEventUserId()?string, speaker_object)>
	</#list>

	${speaker_popup_json.toString()}
</#if>