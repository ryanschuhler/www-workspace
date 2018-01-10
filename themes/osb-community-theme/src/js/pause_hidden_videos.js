AUI().ready(
	'event-onscreen',
	function(A) {
		var videos = A.all('video[autoplay]');

		if (videos.isEmpty()) {
			return;
		}

		var pause = function(video) {
			if (!video.paused) {
				video.pause();
			}
		};

		var play = function(video) {
			if (video.paused && !video.userPaused) {
				video.play();
			}
		};

		var hiddenPropertyName;
		var visibilityChangeEventName;

		if (typeof document.hidden !== 'undefined') {
			hiddenPropertyName = 'hidden';
			visibilityChangeEventName = 'visibilitychange';
		}
		else if (typeof document.msHidden !== 'undefined') {
			hiddenPropertyName = 'msHidden';
			visibilityChangeEventName = 'msvisibilitychange';
		}
		else if (typeof document.webkitHidden !== 'undefined') {
			hiddenPropertyName = 'webkitHidden';
			visibilityChangeEventName = 'webkitvisibilitychange';
		}

		if ((typeof document.addEventListener !== 'undefined') && (typeof document[hiddenPropertyName] !== 'undefined')) {
			document.addEventListener(
				visibilityChangeEventName,
				function(event) {
					videos.each(
						function(node) {
							if (document[hiddenPropertyName]) {
								pause(node.getDOMNode());
							}
							else {
								play(node.getDOMNode());
							}
						}
					);
				},
				false
			);
		}

		videos.each(
			function(node) {
				node.on(
					['offscreenbottom', 'offscreentop'],
					function(event) {
						pause(node.getDOMNode());
					}
				);

				node.on(
					['onscreen'],
					function(event) {
						play(node.getDOMNode());
					}
				);
			}
		);
	}
);