AUI.add(
	'pop-up',
	function(A) {
		var INT_CLOSE_BUTTON_HEIGHT = 40;

		var Lang = A.Lang;

		var PopUp = A.Component.create(
			{
				ATTRS: {
					activateCallback: {
						value: null
					},

					alignTopNode: {
						setter: A.one
					},

					baseClassName: {
						value: 'pop-up'
					},

					centered: {
						value: true
					},

					deactivateCallback: {
						value: null
					},

					defaultCallbacks: {
						value: true
					},

					offsetTopCenter: {
						setter: '_setOffsetTop',
						validator: Lang.isNumber,
						value: 0
					},

					overlayCssClass: {
						value: 'default-overlay'
					},

					overlayDisplay: {
						value: true
					},

					overlayZIndex: {
						value: 102
					},

					popUpId: {
						value: null
					},

					toggleType: {
						value: 'offclick'
					},

					trigger: {
						value: '.pop-up-trigger'
					}
				},

				NAME: 'pop-up',

				prototype: {
					bindUI: function() {
						var instance = this;

						var popUpId = instance.get('popUpId');

						if (!popUpId) {
							var randomId = Math.floor((Math.random() * 100) + 1);

							popUpId = '#popUp-' + randomId;

							A.one('#main-content').append('<div class="pop-up-display" id="popUp-' + randomId + '"><svg class="pop-up-close" height="20" width="20"><use xlink:href="#closeIcon"></use></svg><div class="' + instance.get('baseClassName') + '-content"></div></div>');
						}

						var activateCallback = function(classToggleInstance, node, targetNodes, targetClass) {
							if (instance.get('defaultCallbacks')) {
								instance._defaultActivateCallback(classToggleInstance, node, targetNodes, targetClass);
							}

							var customActivateCallback = instance.get('activateCallback');

							if (A.Lang.isFunction(customActivateCallback)) {
								customActivateCallback(classToggleInstance, node, targetNodes, targetClass);
							}

							if (instance.get('overlayDisplay')) {
								instance._createOverlay();
							}

							if (instance.get('centered')) {
								instance._centerOnPage(targetNodes);
							}
						};

						var deactivateCallback = function(classToggleInstance, node, targetNodes, targetClass) {
							if (instance.get('defaultCallbacks')) {
								instance._defaultDeactivateCallback(classToggleInstance, node, targetNodes, targetClass);
							}

							var customDeactivateCallback = instance.get('deactivateCallback');

							if (A.Lang.isFunction(customDeactivateCallback)) {
								customDeactivateCallback(classToggleInstance, node, targetNodes, targetClass);
							}

							var overlayMask = A.one('.overlay.overlaymask');

							if (overlayMask) {
								overlayMask.remove(true);
							}
						};

						new A.ClassToggle(
							{
								activateCallback: activateCallback,
								baseClassName: instance.get('baseClassName'),
								deactivateCallback: deactivateCallback,
								item: '.' + instance.get('baseClassName'),
								offclickContent: popUpId + ' .' + instance.get('baseClassName') + '-content',
								targetNodes: popUpId,
								toggleType: instance.get('toggleType'),
								trigger: instance.get('trigger')
							}
						).render();
					},

					_centerOnPage: function(node) {
						var instance = this;

						var WIN = A.getWin();

						var currentScrollPos = WIN.get('docScrollY');

						var winHeight = WIN.get('innerHeight');

						if (winHeight == undefined) {
							winHeight = document.documentElement.clientHeight;
						}

						var contentWidth = A.one('#wrapper').get('clientWidth');

						var nodeHeight = node.get('clientHeight');
						var nodeWidth = node.get('clientWidth');

						var offsetTopCenter = instance.get('offsetTopCenter');

						var xCenter = (contentWidth - nodeWidth) / 2;
						var yCenter = ((winHeight - nodeHeight) / 2) + currentScrollPos - offsetTopCenter;

						if (nodeHeight > winHeight) {
							yCenter += ((nodeHeight - winHeight) / 2) + INT_CLOSE_BUTTON_HEIGHT;
						}

						node.setStyle('left', xCenter);
						node.setStyle('top', yCenter);
						node.setStyle('zIndex', instance.get('overlayZIndex') + 1);
					},

					_createOverlay: function() {
						var instance = this;

						if (A.one('.overlay.overlaymask')) {
							return;
						}

						new A.OverlayMask(
							{
								cssClass: instance.get('overlayCssClass'),
								opacity: .95,
								visible: true,
								zIndex: instance.get('overlayZIndex')
							}
						).render();
					},

					_defaultActivateCallback: function(classToggleInstance, node, targetNodes, targetClass) {
						var nodeContent = node.one('.' + classToggleInstance.get('baseClassName') + '-content');
						var targetNodesContent = targetNodes.one('.' + classToggleInstance.get('baseClassName') + '-content');

						if (targetNodesContent && nodeContent) {
							targetNodesContent.setContent(nodeContent.getContent());
						}
					},

					_defaultDeactivateCallback: function(classToggleInstance, node, targetNodes, targetClass) {
						var targetNodesContent = targetNodes.one('.' + classToggleInstance.get('baseClassName') + '-content');

						if (targetNodesContent) {
							targetNodesContent.empty();
						}
					},

					_setOffsetTop: function(val) {
						var instance = this;

						var returnValue = val;

						var node = instance.get('alignTopNode');

						if (node) {
							returnValue += node.getY();
						}

						return Lang.isNumber(returnValue) ? returnValue : val;
					}
				}
			}
		);

		A.PopUp = PopUp;
	},
	'2.0',
	{
		requires: ['aui-base', 'aui-overlay-mask-deprecated', 'class-toggle', 'event']
	}
);