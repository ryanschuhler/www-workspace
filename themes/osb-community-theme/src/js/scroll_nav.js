AUI.add(
	'scroll-nav',
	function(A) {
		var CSS_AFFIX = 'affix';

		var CSS_NAV_TOP = 'nav-top';

		var previousWinScrollPos = 0;

		var WIN = A.getWin();

		function nodeSetter(val) {
			return A.one(val);
		}

		var ScrollNav = A.Component.create(
			{
				ATTRS: {
					alignNode: {
						setter: nodeSetter,
						value: null
					},

					contentContainerNode: {
						setter: nodeSetter,
						value: '.scroll-nav-content-container'
					},

					sideNavNode: {
						setter: nodeSetter,
						value: '.scroll-nav-content-container .navigation'
					}
				},

				NAME: 'scroll-nav',

				prototype: {
					bindUI: function() {
						var instance = this;

						instance._syncNavigation();

						WIN.on(
							'resize',
							A.debounce(
								function() {
									instance._syncNavigation();
								},
								100
							)
						);
					},

					_cleanUpListeners: function(arr) {
						var instance = this;

						var array = arr || [];

						if (array[0]) {
							array[0].detach();
						}

						return array.slice(1);
					},

					_createListeners: function() {
						var instance = this;

						var contentContainerNode = instance.get('contentContainerNode');
						var sideNavNode = instance.get('sideNavNode');

						var navContent = sideNavNode.one('.nav-content');

						instance.listeners = instance.listeners || [];

						while (instance.listeners.length > 0) {
							instance.listeners = instance._cleanUpListeners(instance.listeners);
						}

						if (instance.listeners.length == 0) {
							sideNavNode.toggleClass(CSS_AFFIX, false);
							sideNavNode.toggleClass(CSS_NAV_TOP, true);

							instance.listeners.push(instance._eventListener(contentContainerNode, 'pastscreentop', true, false));

							if (navContent && window.innerHeight < navContent.get('clientHeight')) {
								instance.listeners.push(instance._eventListener(navContent, 'beforescreenbottom', false, true, instance._onChangeDirection));
							}
							else {
								instance.listeners.push(instance._eventListener(contentContainerNode, 'beforescreentop', true, true));
							}

							instance.listeners.push(instance._eventListener(contentContainerNode, 'beforescreenbottom', false, false));
						}
					},

					_eventListener: function(node, subscription, top, affix, callback) {
						var instance = this;

						var sideNavNode = instance.get('sideNavNode');

						return node.on(
							subscription,
							function(event) {
								sideNavNode.toggleClass(CSS_AFFIX, affix);
								sideNavNode.toggleClass(CSS_NAV_TOP, top);

								if (callback) {
									callback(instance);
								}

							}
						);
					},

					_getOffsetRight: function(event) {
						var instance = this;

						var windowWidth = window.innerWidth;

						var offsetRight = 0;

						if (windowWidth > 978) {
							var alignNode = instance.get('alignNode');

							if (alignNode) {
								offsetRight = windowWidth - (alignNode.get('offsetWidth') + alignNode.get('offsetLeft'));
							}
						}

						return offsetRight;
					},

					_getScrollDirection: function() {
						var instance = this;

						var scrollDirection = 0;

						var winScrollPos = instance._getWinScrollPosition();

						if (winScrollPos >= previousWinScrollPos) {
							scrollDirection = 1;
						}

						previousWinScrollPos = winScrollPos;

						return scrollDirection;
					},

					_getWinScrollPosition: function() {
						return WIN.get('scrollY') || WIN.get('docScrollY');
					},

					_onChangeDirection: function(instance) {
						var sideNavNode = instance.get('sideNavNode');

						if (!instance._getScrollDirection()) {
							sideNavNode.toggleClass(CSS_NAV_TOP, true);
						}
					},

					_setNavbarPositionX: function() {
						var instance = this;

						var sideNavNode = instance.get('sideNavNode');

						sideNavNode.setStyle('right', instance._getOffsetRight());
					},

					_syncNavigation: function() {
						var instance = this;

						instance._setNavbarPositionX();

						if (!Liferay.Util.isTablet() && !Liferay.Util.isPhone()) {
							instance._createListeners();
						}
					}
				}
			}
		);

		A.ScrollNav = ScrollNav;
	},
	'2.0',
	{
		requires: ['aui-base', 'aui-component', 'event', 'event-onscreen']
	}
);