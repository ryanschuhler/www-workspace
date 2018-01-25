<style type="text/css">
	#speed-consulting-section > div {
		display: table-cell;
	}

	#speeds .portlet-body {
		margin: 0 auto;
		max-width: 1040px;
	}

	#main-content.full-screen-layout .portlet-column.aui-w30, #main-content.full-screen-layout .portlet-column.aui-w70 {
		display: inline-block;
	}

	.aui-helper-hidden.info-container {
		display: none;
	}

	.blue-text {
		color: #153F6D;
	}

	.speed-consulting-image-container .collapse {
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

	.speed {
		cursor: pointer;
		display: inline-block;
		padding: 0 5px 7.5px;
		vertical-align: top;
	}

	.speed .image-container {
		background-color: #FFF;
		height: 139px;
		overflow: hidden;
	}

	.speed .image-container img {
		max-width: 139px;
		opacity: 0.3;
		transition: opacity 0.3s ease-in-out;
	}

	.speed .image-container:hover img, .speed .image-container.active img {
		opacity: 1;
	}

	.speed-consulting-description {
		display: inline-block;
		margin-right: 5px;
		vertical-align: top;
	}

	.speed-consulting-image-container {
		margin-top: 95px;
		width: 100%;
	}

	.speed-info {
		padding: 15px;
		box-sizing: border-box;
	}

	.speed-title {
		margin-bottom: 10px;
	}

	.speed-info h3 {
		margin: 10px 0 0;
	}

	## hack if speed is repeated, move over text where image is missing

	.speed-info-repeated {
		   margin-left: 170px;
	   }

	.speed-info-title {
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
		.speed-consulting-content {
			padding: 0 10px;
		}

		.speed-info {
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
		#speed-consulting-section > div {
			display: block;
			width: 100%;
		}

		.speed-consulting-content {
			padding: 0;
		}

		.speed-consulting-description {
			margin-right: 0;
			padding: 10px;
		}

		.speed-consulting-image-container {
			margin-top: 10px;
			text-align: center;
		}

		.speed-logo {
			display: block;
			margin: 20px 0 20px 10px;
		}

		.speed-title {
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

<#assign speakers =  marketing_events.getMarketingEventUsers(marketing_event_id, "Marketing Event User Types", "Speed") />

<#assign order_by_comparator_factory_util = staticUtil["com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil"]>

<#assign first_name_order_by = order_by_comparator_factory_util.create("MarketingEventUser", ["firstName", true])>

<#assign list_util = staticUtil["com.liferay.portal.kernel.util.ListUtil"]>

<#assign speakers = list_util.sort(speakers, first_name_order_by)>

<div class="portlet-layout" id="speed-consulting-section">
	<div class="speed-consulting-image-container">

	<#list speakers as speaker>
		<#assign speaker_image_src = speaker.getImageFileEntryURL() >

		<#if !speaker_image_src?has_content>
			<#assign speaker_image_src = "/image/user_male_portrait">
		</#if>

		<div class="speed">
			<div class="image-container">
				<img src="${speaker_image_src}?width=250" />
			</div>

			<div class="aui-helper-hidden info-container">
				<div class="speed-info" >
					<h3 class="alt-font-color no-margin smaller-text">
					${speaker.getFullName()}
					</h3>
					<p class="lighter-font">
					${speaker.getJobTitle(locale)?has_content?string(speaker.getJobTitle(locale) + "", "")}
					</p>
					<p class="lighter-font">
					${speaker.getDescription(locale)}
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

				var speedconsultingContainer = A.one('.speed-consulting-image-container');
				var speeds = speedconsultingContainer.all('.speed');

				assignRow(speedconsultingContainer, speeds);
				addDisplayBoxes(speeds);

				speedconsultingContainer.delegate(
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
						'.speed'
				);

				speedconsultingContainer.on(
						'clickoutside',
						function() {
							if (A.one('.image-container.active')) {
								removeCollapse();
							}

							speedconsultingContainer.detach('clickoutside');
						}
				);

				A.on(
						'windowresize',
						function() {
							var activeContainer = A.one('.image-container.active');

							if (activeContainer) {
								activeContainer.removeClass('active');
							}

							removeRows(speeds);
							assignRow(speedconsultingContainer, speeds);
							destroyDisplayBoxes();
							addDisplayBoxes(speeds);
						}
				);
			}
	);
</script>