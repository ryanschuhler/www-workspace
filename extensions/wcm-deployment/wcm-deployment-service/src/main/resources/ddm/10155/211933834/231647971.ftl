<style type="text/css">
	#expert-exchange-section > div {
		display: table-cell;
	}

	#experts .portlet-body {
		margin: 0 auto;
		max-width: 1040px;
	}

	#main-content.full-screen-layout .portlet-column.aui-w30, #main-content.full-screen-layout .portlet-column.aui-w70 {
		display: inline-block;
	}

	.aui .expert-logo {
		display: inline-block;
		margin: 20px 10px;
		max-width: 150px;
		vertical-align: top;
	}

	.aui-helper-hidden.info-container {
		display: none;
	}

	.blue-text {
		color: #153F6D;
	}

	.expert-exchange-image-container .collapse {
		-o-transition-duration: 0.8s;
		-o-transition-property: max-height, visibility;
		-o-transition-timing-function: ease;
		-webkit-transition-duration: 0.8s;
		-webkit-transition-property: max-height, visibility;
		-webkit-transition-timing-function: ease;
		max-height: 0;
		overflow: hidden;
		position: relative;
		transition-duration: 0.8s;
		transition-property: max-height, visibility;
		transition-timing-function: ease;
		visibility: hidden;
	}

	.collapse.in {
		max-height: 999px;
		visibility: visible;
	}

	.expert {
		cursor: pointer;
		display: inline-block;
		padding: 0 5px 7.5px;
		vertical-align: top;
	}

	.expert .image-container {
		background-color: #FFF;
		height: 139px;
		overflow: hidden;
	}

	.expert .image-container img {
		max-width: 139px;
		opacity: 0.3;
		transition: opacity 0.3s ease-in-out;
	}

	.expert .image-container:hover img, .expert .image-container.active img {
		opacity: 1;
	}

	.expert-exchange-description {
		display: inline-block;
		margin-right: 5px;
		vertical-align: top;
	}

	.expert-exchange-image-container {
		margin-top: 95px;
		width: 100%;
	}

	.expert-title {
		margin-bottom: 10px;
	}

	.expert-info {
		display: inline-block;
		width: 65%;
	}

	.expert-info h3 {
		margin: 10px 0 0;
	}

	## hack if expert is repeated, move over text where image is missing

	.expert-info-repeated {
		   margin-left: 170px;
	   }

	.expert-info-title {
		text-transform: uppercase;
	}

	.firefox #main-content.full-screen-layout .portlet-column.aui-w70 {
		width: 69%;
	}

	.info-display {
		border: 0px;
		margin: 0 5px 10px;
	}

	.info-display.in.collapse {
		border: 1px solid grey;
	}

	.lighter-font {
		font-weight: 100;
	}

	@media(max-width: 1000px) {
		.expert-exchange-content {
			padding: 0 10px;
		}

		.expert-info {
			display: block;
			margin: 0 10px;
			width: auto;
		}

		.info-display {
			max-width: 505px;
		}
	}

	@media(max-width: 759px) {
		.info-display {
			max-width: 330px;
		}
	}

	@media (max-width: 720px) {
		#expert-exchange-section > div {
			display: block;
			width: 100%;
		}

		.expert-exchange-content {
			padding: 0;
		}

		.expert-exchange-description {
			margin-right: 0;
			padding: 10px;
		}

		.expert-exchange-image-container {
			margin-top: 10px;
			text-align: center;
		}

		.expert-logo {
			display: block;
			margin: 20px 0 20px 10px;
		}

		.expert-title {
			margin: 0 auto;
			padding: 5px;
		}

		.info-display {
			margin: 0 auto 20px;
			max-width: 505px;
			text-align: left;
		}
	}

	@media (max-width: 535px) {
		.info-display {
			max-width: 330px;
		}
	}
</style>

 
 

<#assign  marketing_events = serviceLocator.findService("com.liferay.osb.www.marketing.events.util.MarketingEvents") >

<#assign marketing_event_id = getterUtil.getLong(marketing_event_id.data, 0) />

<#assign speakers_sessions_map =  marketing_events.getMarketingEventUserMarketingEventSessionsMap(marketing_event_id, "Marketing Event Session Types", "Expert Exchange") />


<div class="portlet-layout" id="expert-exchange-section">
	<div class="expert-exchange-image-container">

	<#assign speakers = speakers_sessions_map.keySet() >

	<#list speakers as speaker >
		<#assign speaker_image_src = speaker.getImageFileEntryURL() >

		<#if !speaker_image_src?has_content>
			<#assign speaker_image_src = "/image/user_male_portrait">
		</#if>

		<div class="expert">
			<div class="image-container">
				<img src="${speaker_image_src}?width=250" />
			</div>

			<div class="aui-helper-hidden info-container">
				<#if speaker.getCompanyLogoFileEntryURL??>
					<#assign company_logo_src = speaker.getCompanyLogoFileEntryURL()>

					<#if company_logo_src?has_content>
						<img alt="${htmlUtil.escape(speaker.getCompanyName())} logo" class="expert-logo " datasrc="${company_logo_src}" src="${company_logo_src}">
					</#if>
				</#if>

				<div class="expert-info" >
					<p class="alt-font-color no-margin smaller-text">
						${speaker.getFullName()},<br> ${speaker.getJobTitle(locale)?has_content?string(speaker.getJobTitle(locale) + ", ", "")}
					</p>
					<p class="alt-font-color">
						${speaker.getCompanyName()}
					</p>
					<p class="sessions-info">
						<#assign sessions = speakers_sessions_map.get(speaker) />

						<#list sessions as session>
							<h3>
								${session.getTitle(locale)}
							</h3>
							<p>
								${session.getDescription(locale)}
							</p>
						</#list>
					</p>
				</div>
			</div>
		</div>
	</#list>
	</div>
</div>

<script>
	AUI().ready(
			'aui-base',
			function(A) {
				var addCollapse = function(displayNode, clickedNode) {
					var clickedNodeInfo = clickedNode.one('.info-container');

					var clickedNodeHTML = clickedNodeInfo.get('innerHTML');

					if (!displayNode.hasClass('collapse.in')) {
						displayNode.addClass('in');
					}

					clickedNode.one('.image-container').addClass('active');
					displayNode.set('innerHTML', clickedNodeHTML);
				};

				var removeCollapse = function() {
					var activeContainer = A.one('.image-container.active');
					var displayNode = A.one('.info-display.collapse.in');

					activeContainer.removeClass('active');
					displayNode.removeClass('in');
				};

				var assignRow = function(container, nodes) {
					var count = 1;
					var width = container.get('offsetWidth');
					var widthCount = 0;

					nodes.each(
							function(node) {
								widthCount += node.get('offsetWidth');

								if (widthCount >= width - 10) {
									widthCount = node.get('offsetWidth');
									count++;
								}

								node.addClass('row-' + count);
							}
					);
				};

				var insertAfter = function(newNode, referenceNode) {
					referenceNode.get('parentNode').insertBefore(newNode, referenceNode.get('nextSibling'));
				};

				var removeRows = function(nodes) {
					var lastNode = nodes.item(nodes.size() - 1);

					if (lastNode != null) {
						var className = lastNode.get('className');
						var numRows = className.substring(className.length - 1);

						var removeRowClass = function(node) {
							node.removeClass('row-' + i);
						};

						for (var i = 1; i <= numRows; i++) {
							var nodesInRow = A.all('.row-' + i);

							nodesInRow.each(removeRowClass);
						}
					}
				};

				var addDisplayBoxes = function(nodes) {
					var lastNode = nodes.item(nodes.size() - 1);

					if (lastNode != null) {
						var className = lastNode.get('className');
						var numRows = className.substring(className.length - 1);

						for (var i = 1; i <= numRows; i++) {
							var rowClass = 'row-' + i;

							var display = A.Node.create('<div class="collapse info-display ' + rowClass + '"></div>');
							var nodesInRow = A.all('.row-' + i);

							var lastNodeInList = nodesInRow.item(nodesInRow.size() - 1);

							insertAfter(display, lastNodeInList);
						}
					}
				};

				var destroyDisplayBoxes = function() {
					var nodes = A.all('.info-display');

					nodes.each(
							function(node) {
								node.remove(true);
							}
					);
				};

				var expertExchangeContainer = A.one('.expert-exchange-image-container');
				var experts = expertExchangeContainer.all('.expert');

				assignRow(expertExchangeContainer, experts);
				addDisplayBoxes(experts);

				expertExchangeContainer.delegate(
						'click',
						function(e) {
							var node = e.currentTarget;

							if (node.one('.image-container').hasClass('active')) {
								removeCollapse();
							}
							else {
								var nodeClassName = node.get('className');
								var rowIndex = nodeClassName.indexOf('row-') + 4;
								var rowNumber = nodeClassName.substring(rowIndex);

								var displayingNode = A.one('.info-display.collapse.in');
								var displayNode = A.one('.info-display.row-' + rowNumber);

								if (displayingNode && displayingNode.hasClass('row-' + rowNumber)) {
									A.one('.image-container.active').removeClass('active');
								}
								else if (displayingNode && !displayingNode.hasClass('row-' + rowNumber)) {
									removeCollapse();
								}

								addCollapse(displayNode, node);
							}
						},
						'.expert'
				);

				expertExchangeContainer.on(
						'clickoutside',
						function() {
							if (A.one('.image-container.active')) {
								removeCollapse();
							}

							expertExchangeContainer.detach('clickoutside');
						}
				);

				A.on(
						'windowresize',
						function() {
							var activeContainer = A.one('.image-container.active');

							if (activeContainer) {
								activeContainer.removeClass('active');
							}

							removeRows(experts);
							assignRow(expertExchangeContainer, experts);
							destroyDisplayBoxes();
							addDisplayBoxes(experts);
						}
				);
			}
	);
</script>