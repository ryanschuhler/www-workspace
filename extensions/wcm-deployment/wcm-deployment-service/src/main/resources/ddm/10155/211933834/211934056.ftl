<#assign portlet_bean_locator = objectUtil("com.liferay.portal.kernel.bean.PortletBeanLocatorUtil") />

<#assign marketing_event_user_local_service = portlet_bean_locator.locate("osb-www-marketing-events-portlet", "com.liferay.osb.www.marketing.events.service.MarketingEventUserLocalService") />

<#assign marketing_event_id = getterUtil.getLong(marketing_event_id.data, 0)! />

<#if request.lifecycle == 'RENDER_PHASE'>
	<#assign class_loader_util = staticUtil["com.liferay.portal.util.ClassLoaderUtil"]>
	<#assign class_loader = class_loader_util.getPluginClassLoader("osb-www-marketing-events-portlet")>

	<#assign marketing_events_util = staticUtil["com.liferay.portal.kernel.util.InstanceFactory"].newInstance(class_loader, "com.liferay.osb.www.marketing.events.util.MarketingEventsUtil")>

	<#assign list_util = staticUtil["com.liferay.portal.kernel.util.ListUtil"]>

	<#assign order_by_comparator_factory_util = staticUtil["com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil"]>

	<#assign first_name_order_by = order_by_comparator_factory_util.create("MarketingEventUser", ["firstName", true])>

	<#assign featured_speakers = list_util.sort(marketing_events_util.getMarketingEventUsers(marketing_event_id, "Marketing Event User Types", "Featured")!, first_name_order_by)/>

	<#assign speakers = list_util.remove(marketing_event_user_local_service.getMarketingEventUsers(marketing_event_id, 0, -1, -1), featured_speakers)>

	<#import "${templatesPath}/1561886" as lang>

	<style type="text/css">
		.featured-speakers {
			margin-bottom: 3em;
		}

		.speaker-content {
			width: 244px;
		}

		.speaker-content:hover {
			cursor: pointer;
		}

		.speaker-content:hover .view-bio {
			opacity: 0.65;
			transition: all 0.25s ease-in-out;
		}

		.speaker-image-container {
			max-height: 240px;
			overflow: hidden;
			position: relative;
		}

		.speaker-image-container:after {
			border-bottom: 25px solid transparent;
			border-left: 25px solid transparent;
			border-right: 25px solid #FFF;
			border-top: 25px solid #FFF;
			content: '';
			position: absolute;
			right: 0;
			top: 0;
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

		.speakers-wrapper .modal-content {
			background-color: rgba(255, 255, 255, 0.95);
			border: 1px solid #E3E4E5;
		}

		.speakers-wrapper .pop-up-display .pop-up-close {
			right: 1em;
			top: 0.25em;
		}

		.view-bio {
			background: #000;
			height: 100%;
			left: 0;
			opacity: 0;
			position: absolute;
			top: 0;
			transition: all 0.25s ease-in-out;
			width: 100%;
		}
	</style>

	<#macro print_speakers speakers>
		<div class="block-container justify-center">
			<#list speakers as speaker>
				<article class="block-container speaker" data-marketing-event-user-id="${speaker.getMarketingEventUserId()?string}">
						<div class="speaker-content w100">
							<div class="speaker-image-container">
								<#assign src = speaker.getImageFileEntryURL()>

								<img class="w100" src="${src?has_content?string(src, "/image/user_male_portrait")}" />

								<div class="align-center block-container justify-center light-color view-bio">
									<h3 class="font-weight-bold"><em>${view_bio_hover_text.data}</em></h3>
								</div>
							</div>

							<div class="font-background light-color small-padding-vertical text-center">
								<h4 class="font-weight-bold no-margin small-padding">${speaker.getFullName()}</h4>

								<#if speaker.getJobTitle(locale)?has_content>
									<p class="no-margin">${stringUtil.shorten(speaker.getJobTitle(locale), getterUtil.getInteger(33))}</p>
								</#if>

								<#if speaker.getCompanyName()?has_content>
									<p><em>${stringUtil.shorten(speaker.getCompanyName(), getterUtil.getInteger(33))}</em></p>
								</#if>
							</div>
						</div>
				</article>
			</#list>
		</div>
	</#macro>

	<div class="block-container justify-center speakers-wrapper" id="speakers">
		<#if featured_speakers?has_content>
			<div class="featured-speakers">
				<#if (featured_speakers_label.data)?has_content>
					<h2 class="text-center">${featured_speakers_label.data}</h2>
				</#if>

				<@print_speakers featured_speakers/>
			</div>
		</#if>

		<div class="session-speakers">
			<#if featured_speakers?has_content && (speakers_label.data)?has_content>
				<h2 class="text-center">${speakers_label.data}</h2>
			</#if>

			<@print_speakers speakers/>
		</div>

		<div class="max-sm pop-up-display" id="popUpSpeaker">
			<svg class="pop-up-close" height="30" width="30">
				<use xlink:href="#closeIcon"></use>
			</svg>

			<div class="pop-up-content"></div>
		</div>
	</div>

	<script id="${randomNamespace}speakerPopupTpl" type="text/x-alloy-template">
		<div class="large-padding modal-content">
			<h4 class="primary-color">{name}</h4>
			<p class="font-weight-bold no-margin">{title}</p>
			<em class="font-weight-bold">{company}</em>
			<div class="speaker-socials">
				<tpl for="social_links">
					<a class="{class_name}" href="{url}" target="_blank" title="{type_name}">
						<svg><use xlink:href="{icon_name}" xmlns:xlink="http://www.w3.org/1999/xlink"></use></svg>
					</a>
				</tpl>
			</div>
			<p class="font-weight-lighter">{description}</p>
		</div>
	</script>

	<script>
		AUI().ready(
			'aui-io-request',
			'aui-template-deprecated',
			'pop-up',
			function(A) {
				var SPEAKER_POPUP_DATA = 'speaker_popup_data';

				var setupSpeakerPopup = function() {
					var speakerPopupContent = A.one('#popUpSpeaker .pop-up-content');
					var speakerPopupTpl = new A.Template(A.one('#${randomNamespace}speakerPopupTpl').html());

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
						overlayDisplay: false,
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
							failure: function(event, id, obj) {
							},
							success: function(event, id, obj) {
								var responseData = this.get('responseData');

								for (var marketingEventUserId in responseData) {
									var speakerNode = A.one('.speaker[data-marketing-event-user-id="' + marketingEventUserId + '"]');

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

	<#assign all_speakers = marketing_event_user_local_service.getMarketingEventUsers(marketing_event_id, 0, -1, -1) >

	<#list all_speakers as speaker>
		<#assign speaker_object = jsonFactoryUtil.createJSONObject() />

		<#assign VOID = speaker_object.put("company", speaker.getCompanyName())>
		<#assign VOID = speaker_object.put("description", speaker.getDescription(locale))>
		<#assign VOID = speaker_object.put("name", speaker.getFullName())>
		<#assign VOID = speaker_object.put("title", speaker.getJobTitle(locale))>

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