AUI().ready(
	'anim',
	'class-toggle',
	'event-onscreen',
	'yui-throttle',
	function(A) {
		var BODY = A.getBody();

		var WIN = A.getWin();

		var bannerHeight = 0;

		var banner = A.one('#banner .main-banner-section');

		if (banner) {
			bannerHeight = banner.get('clientHeight');
		}

		var triggerPos = 200;

		BODY.delegate(
			'click',
			function(event) {
				var node = event.currentTarget;

				var section = A.one(node.get('hash'));

				if (!section) {
					return;
				}

				event.preventDefault();

				var offset = parseInt(node.attr('data-offset'), 10);

				var scrollTo = parseInt(section.getY(), 10);

				if ((scrollTo - window.scrollY) < triggerPos) {
					scrollTo -= bannerHeight;
				}

				if (offset) {
					scrollTo -= offset;
				}

				new A.Anim(
					{
						duration: 0.5,
						easing: 'easeBoth',
						node: 'win',
						to: {
							scroll: [0, scrollTo]
						}
					}
				).run();

				window.history.pushState('', '', node.get('hash'));
			},
			'.animate-scroll'
		);

		A.all('.lazy-load').each(
			function(node) {
				node.on(
					'onscreen',
					function(event) {
						var datasrc = node.attr('data-src');
						var src = node.attr('src');

						if (src != datasrc) {
							node.attr('src', datasrc);
						}

						node.addClass('lazy-loaded');

						node.detach();
					}
				);
			}
		);

		A.all('.on-screen-helper').each(
			function(node) {
				node.on(
					'onscreen',
					function(event) {
						node.addClass('on-screen');

						if (!node.attr('data-repeat')) {
							node.detach();
						}
					}
				);

				node.on(
					'onscreentop',
					function(event) {
						node.addClass('on-screen-top');

						if (!node.attr('data-repeat')) {
							node.detach();
						}
					}
				);

				node.on(
					['offscreenbottom', 'offscreentop'],
					function(event) {
						if (node.attr('data-repeat')) {
							node.removeClass('on-screen');
						}

						if (node.attr('data-repeat-top')) {
							node.removeClass('on-screen-top');
						}
					}
				);
			}
		);

		if (A.ClassToggle) {
			new A.ClassToggle().render();
		}

		var lastScrollPos = 0;
		var savedScrollPos = 0;

		var displayBanner = function() {
			var scrollPos = WIN.get('docScrollY');

			if (scrollPos > lastScrollPos) {
				savedScrollPos = scrollPos;
			}

			lastScrollPos = scrollPos;

			if (scrollPos < (savedScrollPos - 100)) {
				savedScrollPos = scrollPos + 100;

				BODY.removeClass('hide-banner');
			}
			else if (scrollPos > triggerPos) {
				BODY.addClass('hide-banner');
			}
			else {
				BODY.removeClass('hide-banner');
			}
		};

		A.on(
			'scroll',
			function() {
				A.throttle(displayBanner(), 250);
			}
		);

		var childNav = A.one('#childNavigation');

		if (childNav) {
			var secondaryNav = A.one('#secondaryNavigation');
			var secondaryNavCaret = A.one('#rightScrollCaret');
			var sectionNav = A.one('#sectionNavigation');

			var secondaryNavWidth = 0;
			var sectionNavWidth = 0;
			var touchPointSeperator = 0;

			if (secondaryNav) {
				secondaryNavWidth = secondaryNav.outerWidth();
			}

			if (sectionNav) {
				sectionNavWidth = sectionNav.outerWidth();

				touchPointSeperator = 45;
			}

			var calculateNavWidth = function() {
				var winWidth = WIN.get('winWidth');

				if (winWidth <= (secondaryNavWidth + sectionNavWidth + touchPointSeperator)) {
					childNav.addClass('collided');

					if (winWidth <= (secondaryNavWidth + touchPointSeperator)) {
						secondaryNavCaret.removeClass('hide');
					}
					else {
						secondaryNavCaret.addClass('hide');
					}
				}
				else {
					childNav.removeClass('collided');

					secondaryNavCaret.addClass('hide');
				}
			};

			A.on(
				['load', 'resize'],
				function(event) {
					A.throttle(calculateNavWidth(), 250);
				}
			);

			if (sectionNav) {
				sectionNav.all('.nav-item').each(
					function(node) {
						var pageSection = A.one('#' + node.attr('data-page-section'));

						if (!pageSection) {
							return;
						}

						pageSection.on(
							'onscreentop',
							function(event) {
								var selectedItem = sectionNav.one('.selected');

								if (selectedItem) {
									selectedItem.removeClass('selected');
								}

								node.addClass('selected');
							}
						);
					}
				);
			}
		}
	}
);

window.addEventListener(
	'DOMContentLoaded',
		function() {
		var cookieAcceptance = document.querySelector('.cookie-acceptance');
		var cookieAcceptanceBtn = document.querySelector('.cookie-acceptance-btn');

		if (cookieAcceptance && cookieAcceptanceBtn) {
			cookieAcceptanceBtn.addEventListener(
				'click',
				function(event) {
					var expirationDate = new Date();

					expirationDate.setYear(expirationDate.getFullYear() + 1);

					document.cookie = 'OSB_WWW_GDPR_ACCEPTED=true; expires=' + expirationDate.toUTCString();

					cookieAcceptance.classList.add('hide');
				}
			);
		}
	}
);