<style type="text/css">
	#speakerToggle {
		max-height: 320px;
		overflow: hidden;
		padding-bottom: 60px;
		position: relative;
		transition: max-height ease-in-out 0.75s;
	}

	#speakerToggle .blur-container {
		background-image: linear-gradient(to bottom, rgba(248, 248, 248, 0) 0%, rgba(248, 248, 248, 0) 1%, rgba(255, 255, 255, 0.8) 70%, rgba(255, 255, 255, 0.8) 100%);
		bottom: 0;
		display: block;
		height: 80px;
		position: absolute;
		width: 100%;
	}

	#speakerToggle.class-toggle-active {
		max-height: none;
	}

	#speakerToggle.class-toggle-active .blur-container {
		height: 0
	}

	.flip-item {
		-moz-transform-style: preserve-3d;
		-moz-transition: 0.6s;
		-ms-transform-style: preserve-3d;
		-o-transform-style: preserve-3d;
		-o-transition: 0.6s;
		-webkit-transform-style: preserve-3d;
		-webkit-transition: 0.6s;
		transition: 0.6s;
	}

	.flip-item:hover, .speaker-item .speaker-info {
		-moz-transition: all 0.4s ease-in-out;
		-ms-transition: all 0.4s ease-in-out;
		-o-transition: all 0.4s ease-in-out;
		-webkit-transition: all 0.4s ease-in-out;
		transition: all 0.4s ease-in-out;
	}

	.flip-item .flip-side,  .speaker-item .speaker-info {
		-moz-backface-visibility: hidden;
		-moz-transform: translate3d(0, 0, 0);
		-ms-backface-visibility: hidden;
		-ms-transform: translate3d(0, 0, 0);
		-o-backface-visibility: hidden;
		-o-transform: translate3d(0, 0, 0);
		-webkit-backface-visibility: hidden;
		-webkit-transform: translate3d(0, 0, 0);
		backface-visibility: hidden;
		bottom: 0;
		left: 0;
		max-height: 270px;
		max-width: 270px;
		overflow: hidden;
		position: absolute;
		right: 0;
		top: 0;
		transform: translate3d(0, 0, 0);
	}

	.flip-item .flip-side.back-side {
		-moz-transform: rotateY(-180deg);
		-ms-transform: rotateY(-180deg);
		-o-transform: rotateY(-180deg);
		-webkit-transform: rotateY(-180deg);
		transform: rotateY(-180deg);
	}

	.flip-item.class-toggle-off-click-active {
		-moz-transform: rotateY(180deg);
		-ms-transform: rotateY(180deg);
		-o-transform: rotateY(180deg);
		-webkit-transform: rotateY(180deg);
		transform: rotateY(180deg);
	}

	.flip-wrapper {
		-moz-perspective: 800px;
		-ms-perspective: 800px;
		-o-perspective: 800px;
		-webkit-perspective: 800px;
		perspective: 800px;
		position: relative;
	}

	.speaker-arrow svg {
		-ms-transform: rotate(-90deg);
		-webkit-transform: rotate(-90deg);
		margin-left: 7px;
		transform: rotate(-90deg);
	}

	.speaker-arrow.class-toggle-active svg {
		-ms-transform: rotate(90deg);
		-webkit-transform: rotate(90deg);
		transform: rotate(90deg);
	}

	.speaker-bio {
		font-size: 15px;
		padding: 15px;
	}

	.speaker-info:before {
		-moz-transform: rotate(45deg);
		-ms-transform: rotate(45deg);
		-o-transform: rotate(45deg);
		-webkit-transform: rotate(45deg);
		background: #EBEBEB;
		display: inline-block;
		height: 200%;
		left: -53%;
		pointer-events: none;
		position: absolute;
		top: 0;
		transform: rotate(45deg);
		width: 230%;
		z-index: -1;
	}

	.speaker-info .cta {
		margin-left: 0.5em;
	}

	.speaker-info .item-logo {
		margin: auto;
		max-height: 80px;
		max-width: 200px;
	}

	.speaker-item {
		cursor: default;
		height: 270px;
		text-align: left;
		width: 270px;
	}

	.speaker-item, .speaker-item .front-side {
		background-position: 0;
		background-repeat: no-repeat;
		background-size: 100%;
	}

	.speaker-item .speaker-bio, .speaker-item .speaker-info {
		background-color: #EBEBEB;
		color: #4D4D4F;
	}

	.speaker-item .speaker-info {
		-moz-transform: translate(100%, 100%);
		-ms-transform: translate(100%, 100%);
		-o-transform: translate(100%, 100%);
		-webkit-transform: translate(100%, 100%);
		padding: 5%;
		transform: translate(100%, 100%);
	}

	.speaker-item:hover .speaker-info {
		-moz-transform: translate(0, 0);
		-ms-transform: translate(0, 0);
		-o-transform: translate(0, 0);
		-webkit-transform: translate(0, 0);
		transform: translate(0, 0);
	}

	.speaker-item.class-toggle-off-click {
		cursor: pointer;
	}

	.speaker-item-wrapper {
		margin: 0 15px 15px 0;
		overflow: hidden;
	}

	.speaker-wrapper {
		padding: 40px 0 10px;
		text-align: center;
	}

	@media (min-width: 768px) {
		#popUpSpeaker {
			display: none;
		}

		.ie .class-toggle-off-click-active.flip-item .back-side {
			-ms-transform: rotateY(0);
			display: block;
			z-index: auto;
		}

		.ie .flip-item:hover, .safari .speaker-item .speaker-info {
			-ms-transition: none;
		}

		.ie .flip-item .back-side {
			display: none;
			z-index: -1;
		}

		.ie .flip-item.class-toggle-off-click-active {
			-ms-transform: rotateY(0);
		}

		.ie .speaker-info .item-logo {
			width: 100%;
		}

		.ie .speaker-item .front-side {
			height: 270px;
			position: relative;
		}

		.safari .class-toggle-off-click-active.flip-item .back-side {
			-webkit-transform: rotateY(0);
		}

		.safari .flip-item:hover, .safari .speaker-item .speaker-info {
			-webkit-transition: none;
		}

		.safari .flip-item.class-toggle-off-click-active {
			-webkit-transform: rotateY(0);
		}

		.speaker-overlay {
			display: none;
		}
	}

	@media (max-width: 768px) {
		#speakerToggle {
			max-height: none;
		}

		#speakerToggle .blur-container {
			height: 0
		}

		.aui #popUpSpeaker.pop-up-display {
			background: rgba(255, 255, 255, 0.95);
		}

		.aui #popUpSpeaker.pop-up-display .pop-up-close {
			top: 0;
		}

		.flip-item:hover {
			-moz-transition: none;
			-ms-transition: none;
			-o-transition: none;
			-webkit-transition: none;
			transition: none;
		}

		.flip-item.class-toggle-off-click-active {
			-moz-transform: rotateY(0);
			-ms-transform: rotateY(0);
			-o-transform: rotateY(0);
			-webkit-transform: rotateY(0);
			transform: rotateY(0);
		}

		.speaker-arrow {
			display: none;
		}

		.speaker-item {
			margin: 0 auto;
		}

		.speaker-item:hover .speaker-info {
			-moz-transform: translate(100%, 100%);
			-ms-transform: translate(100%, 100%);
			-o-transform: translate(100%, 100%);
			-webkit-transform: translate(100%, 100%);
			transform: translate(100%, 100%);
		}

		.speaker-item-wrapper {
			margin: 0;
		}

		.speaker-overlay-content {
			background: white;
		}
	}

	@media(max-width:768px) {
		#dots {
			-webkit-transform: translate3d(30px, 0, 0);
			transform: translate3d(30px, 0, 0);
			transition: -webkit-transform 0.3s ease;
			transition: transform 0.3s ease;
			width: 1000px;
		}

		#dots li {
			color: #E3E3E3;
			cursor: pointer;
			font-size: 3em;
			list-style: none;
			text-align: center;
			width: 30px;
		}

		#dots li.quote-active {
			color: black;
		}

		#dots li.small-dot {
			font-size: 1.5em;
			padding-top: 0.1em;
		}

		.slide-dot-container {
			margin: 0 auto;
			overflow: hidden;
			width: 210px;
		}

		.swipable-parent {
			-moz-flex-wrap: nowrap !important;
			-webkit-flex-wrap: nowrap !important;
			flex-wrap: nowrap !important;
			overflow: hidden;
		}

		.swipable-parent > *:not(.swipable) {
			display: none;
		}
	}

	@media(min-width:768px) {
		#dots {
			display: none;
		}
	}
</style>

<#assign portlet_bean_locator = objectUtil("com.liferay.portal.kernel.bean.PortletBeanLocatorUtil") >

<#assign marketing_event_user_local_service =   serviceLocator.findService("com.liferay.osb.www.marketing.events.service.MarketingEventUserLocalService") >

<#assign marketing_event_id = getterUtil.getLong(marketing_event_id.data, 0) >

<#assign speaker_list = marketing_event_user_local_service.getMarketingEventUsers(marketing_event_id, 0, -1, -1) >

<div class="speaker-pop-up" id="speakerToggle">
	<div class="block-container justify-center no-padding-horizontal speaker-wrapper" id="speakers">
		<#list speaker_list as speaker>
			<div class="block flip-wrapper pop-up-trigger speaker-item-wrapper swipable"
				data-company="${htmlUtil.escape(speaker.getCompanyName())}"
				data-description="${htmlUtil.escape(speaker.getDescription(locale))}"
				data-name="${htmlUtil.escape(speaker.getFirstName())} ${htmlUtil.escape(speaker.getLastName())}"
				data-title="${htmlUtil.escape(speaker.getJobTitle(locale))}">

				<#assign speaker_has_bio = speaker.getDescription(locale)?has_content>

				<#assign speaker_image_src = speaker.getImageFileEntryURL() >
				<#if !speaker_image_src?has_content>
					<#assign speaker_image_src = "/image/user_male_portrait">
				</#if>

				<div class="flip-item speaker-item speaker-${speaker_index} ${speaker_has_bio?string('class-toggle','')}" data-target-class="class-toggle-off-click-active">
					<div class="flip-side front-side" style="background-image: url(${speaker_image_src});">
						<div class="align-content-space-between block-container justify-start speaker-info text-center">
							<#if speaker.getCompanyLogoFileEntryURL??>
								<#assign company_logo_src = speaker.getCompanyLogoFileEntryURL()>
								<#if company_logo_src?has_content>
									<img alt="${htmlUtil.escape(speaker.getCompanyName())} logo" class="item-logo standard-padding-vertical" src="${company_logo_src}">
								</#if>
							</#if>

							<h4 class="font-weight-bold w100">
								${speaker.getFullName()?upper_case}
							</h4>

							<p class="no-margin w100">${speaker.getJobTitle(locale)}</p>
							<p class="w100">${speaker.getCompanyName()}</p>

							<#if speaker.getDescription(locale)?has_content>
								<a class="cta w100">
									${view_bio_hover_text.data}
									<svg class="cta-icon" height="10" width="8"><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#caret"></use></svg>
								</a>
							</#if>
						</div>
					</div>

					<div class="back-side flip-side speaker-bio">
						${speaker.getDescription(locale)}
					</div>
				</div>
			</div>
		</#list>
	</div>

	<div class="blur-container">
		&nbsp;
	</div>
</div>

<p class="text-center">
	<a class="animate-scroll class-toggle speaker-arrow" data-target-nodes="#speakerToggle, .speaker-arrow" href="#speakers">
		<svg enable-background="new 0 0 15 30" height="30px" id="Layer_1" version="1.1" viewbox="0 0 15 30" width="15px" x="0px" xml:space="preserve" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" y="0px">
			<polyline fill="none" points="14.5,29 0.5,15 14.5,1 " stroke="#909295" stroke-miterlimit="10"></polyline>
		</svg>
	</a>
</p>

<script id="${randomNamespace}speakerPopupTpl" type="text/x-alloy-template">
	<div class="mobile-speaker-pop-up modal-content">
		<h3 class="font-weight-bold primary-color">{name}</h3>
		<p class="primary-color">{title} | {company}</p>
		<p>{description}</p>
	</div>
</script>

<div class="max-full pop-up-display" id="popUpSpeaker">
	<svg class="pop-up-close" height="20" width="20">
		<use xlink:href="#closeIcon"></use>
	</svg>
	<div class="pop-up-content standard-padding"></div>
</div>

<script>
	AUI().ready(
		'aui-template-deprecated',
		'pop-up',
		function(A) {
			var speakerPopupContent = A.one('#popUpSpeaker .pop-up-content');
			var speakerPopupTpl = new A.Template(A.one('#${randomNamespace}speakerPopupTpl').html());

			var activateCallback = function(classToggleInstance, node, targetNodes, targetClass) {
				if (speakerPopupTpl && speakerPopupContent) {
					speakerPopupContent.setContent(speakerPopupTpl.parse(node.getData()));
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
					alignTopNode: '.speaker-wrapper',
					centered: true,
					deactivateCallback: deactivateCallback,
					defaultCallbacks: false,
					overlayCssClass: 'speaker-overlay',
					popUpId: '#popUpSpeaker'
				}
			).render();
		}
	);

	AUI().use(
		'event-move',
		'event-resize',
		'node',
		'node-base',
		'node-event-delegate',
		'transition',
		function(A) {
			var ACTIVE_CLASS_NAME = 'quote-active';

			var DOT_WIDTH = 30;

			var MAX_DOTS = 5;

			var MIN_SWIPE = 50;

			var SMALL_DOT_CLASS_NAME = 'small-dot';

			var SWIPE_ITEM_SELECTOR = '.swipable';

			var dotIndexDelta = 0;
			var dotList;
			var dots = [];
			var dotSlideContainerTranslate = DOT_WIDTH;
			var relativeDotIndex = 0;
			var scrolling;
			var slideIndex = 0;
			var slideWidth = 0;
			var slidingActive = false;
			var swipableNodes = A.all(SWIPE_ITEM_SELECTOR);
			var swipeParent = A.one(SWIPE_ITEM_SELECTOR).ancestor();

			var atLastSlide = function() {
				return (slideIndex == (swipableNodes.size() - 1));
			};

			var getMaxSlideHeight = function() {
				var maxHeight = 0;

				for (var i = 0; i < swipableNodes.size(); i++) {
					var nodeHeight = swipableNodes.item(i).get('clientHeight');

					if (nodeHeight > maxHeight) {
						maxHeight = nodeHeight;
					}
				}

				return maxHeight;
			};

			var init = function() {
				setupStyles();

				setupHeightAndWidth();

				A.on('windowresize', setupHeightAndWidth);

				dotList = setupDots();

				swipeParent.delegate(
					'gesturemovestart',
					function(e) {
						if (!slidingActive) {
							return;
						}

						var item = e.currentTarget;

						item.once(
							'selectstart',
							function(e) {
								e.preventDefault();
							}
						);

						item.setData(
							'swipeStart',
							{
								x: e.pageX,
								y: e.pageY
							}
						);
						scrolling = undefined;

						var moveSubscription = item.on(
							'gesturemove',
							function(e) {
								item.once(
									'selectstart',
									function(e) {
										e.preventDefault();
									}
								);

								var swipeStart = item.getData('swipeStart');

								var delta = {
									x: e.pageX - swipeStart.x,
									y: e.pageY - swipeStart.y
								};

								if (typeof scrolling == 'undefined') {
									scrolling = !!(scrolling || Math.abs(delta.x) < Math.abs(delta.y));
								}

								if (!scrolling) {
									if ((slideIndex == 0 && delta.x > 0) || (atLastSlide() && delta.x < 0)) {
										delta.x /= (Math.abs(delta.x) / slideWidth + 1);
									}

									translateSlides(((slideIndex * -slideWidth) + delta.x), 0);
								}
							}
						);

						item.once(
							'gesturemoveend',
							function(e) {
								var swipeEnd = e.pageX;
								var swipeStart = item.getData('swipeStart').x;

								var swipedLeft = (swipeStart - swipeEnd) > MIN_SWIPE;
								var swipedRight = (swipeEnd - swipeStart) > MIN_SWIPE;

								moveSubscription.detach();

								var newSlideIndex = slideIndex;

								if (swipedLeft && !atLastSlide()) {
									newSlideIndex++;
								}
								else if (swipedRight && (slideIndex > 0)) {
									newSlideIndex--;
								}

								moveToSlide(newSlideIndex);
							}
						);
					},
					SWIPE_ITEM_SELECTOR,
					{
						preventDefault: false
					}
				);
			};

			var moveToSlide = function(index) {
				if (index < 0 || index > swipableNodes.size()) {
					return;
				}

				var distance = index - slideIndex;
				var goingLeft = index < slideIndex;
				var goingRight = index > slideIndex;

				slideIndex = index;

				var intSlideIndex = parseInt(slideIndex, 10);

				if (goingRight && relativeDotIndex < MAX_DOTS) {
					relativeDotIndex += distance;

					if (relativeDotIndex > MAX_DOTS) {
						relativeDotIndex = MAX_DOTS;
					}
				}
				else if (goingLeft && relativeDotIndex > 0) {
					relativeDotIndex += distance;

					if (relativeDotIndex < 0) {
						relativeDotIndex = 0;
					}
				}

				if (goingRight && ((dots.length - dotIndexDelta) > MAX_DOTS) && relativeDotIndex == MAX_DOTS && ((intSlideIndex) < dots.length)) {
					dotSlideContainerTranslate -= DOT_WIDTH;
					dotIndexDelta += 1;

					translateDots(dotSlideContainerTranslate);
				}
				else if (goingLeft && dotIndexDelta > 0 && relativeDotIndex == 0 && ((intSlideIndex) >= 0)) {
					dotSlideContainerTranslate += DOT_WIDTH;
					dotIndexDelta -= 1;

					translateDots(dotSlideContainerTranslate);
				}

				for (var i = 0; i < dots.length; i++) {
					if (i == slideIndex) {
						dots[i].addClass(ACTIVE_CLASS_NAME);
					}
					else {
						dots[i].removeClass(ACTIVE_CLASS_NAME);
					}

					if ((dotIndexDelta && ((i - dotIndexDelta + 1) == 0)) || (!atLastSlide() && ((i - dotIndexDelta) == MAX_DOTS))) {
						dots[i].addClass(SMALL_DOT_CLASS_NAME);
					}
					else {
						dots[i].removeClass(SMALL_DOT_CLASS_NAME);
					}
				}

				translateSlides((slideIndex * -slideWidth), 300);
			};

			var setupDots = function() {
				var slideDotContainer = A.Node.create('<div class="slide-dot-container"></div>');

				var dotList = A.Node.create('<ul class="block-container no-margin no-padding" id="dots" ></ul>');

				swipeParent.insert(slideDotContainer, 'after');
				slideDotContainer.append(dotList);

				for (var i = 0; i < swipableNodes.size(); i++) {
					var dotClasses = 'dot ';

					if (i == 0) {
						dotClasses += ' ' + ACTIVE_CLASS_NAME;
					}
					else if (i == MAX_DOTS) {
						dotClasses += ' ' + SMALL_DOT_CLASS_NAME;
					}
					var dot = A.Node.create('<li class="' + dotClasses + '" data-slide-index="' + i + '">•</li>');

					dotList.append(dot);
					dots.push(dot);
				}

				dotList.delegate(
					'click',
					function(e) {
						var clickedDot = e.currentTarget;
						var clickedIndex = parseInt(clickedDot.getData('slide-index'), 10);

						moveToSlide(clickedIndex);
					},
					'li'
				);

				return dotList;
			};

			var setupHeightAndWidth = function() {
				slideWidth = A.one('#wrapper').get('clientWidth');

				if (slideWidth < 768) {
					swipeParent.setStyle('width', 100 * swipableNodes.size() + '%');
					slidingActive = true;
				}
				else {
					swipeParent.setStyle('width', 'auto');
					moveToSlide(0);
					slidingActive = false;
				}

				swipableNodes.setStyle('height', 'auto');
				var maxHeight = getMaxSlideHeight();

				if (maxHeight > 0) {
					swipableNodes.setStyle('height', maxHeight);
				}
			};

			var setupStyles = function() {
				swipeParent.ancestor().setStyles(
					{
						'overflow': 'hidden',
						'width': '100%'
					}
				);

				swipeParent.addClass('swipable-parent');
			};

			var translateDots = function(x) {
				dotList
					.setStyle('transform', 'translate3d(' + x + 'px, 0, 0)')
					.setStyle('transform', '-webkit-translate3d(' + x + 'px, 0, 0)');
			};

			var translateSlides = function(x, speed) {
				swipeParent
					.setStyle('transition', 'transform ' + speed + 'ms ease')
					.setStyle('transition', '-webkit-transform ' + speed + 'ms ease')
					.setStyle('transform', 'translate3d(' + x + 'px, 0, 0)');
			};

			init();
		}
	);
</script>