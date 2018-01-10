AUI().ready(
	'aui-io-request',
	function(A) {
		var removeNode = function(node) {
			if (node) {
				node.remove();
			}
		};

		var msgDismissBtn = A.one('.dismiss-btn.dismiss-msg');

		if (msgDismissBtn) {
			msgDismissBtn.on(
				'click',
				function() {
					removeNode(A.all('.notification'));
					removeNode(A.one('.verification-prompt'));

					var avatarWrapper = A.one('.account-avatar-wrapper');

					if (avatarWrapper) {
						avatarWrapper.setAttribute('data-target-class', 'show-account-links');
					}
				}
			);
		}

		var toggleMessage = function(message) {
			var promptBody = A.one('.prompt-body');

			if (promptBody && message) {
				promptBody.hide();

				message.show();
			}
		}

		var verifyUserBtn = A.one('.verify-user-btn');

		if (verifyUserBtn) {
			verifyUserBtn.on(
				'click',
				function() {
					A.io.request(
						verifyUserBtn.getAttribute('data-verification-url'),
						{
							on: {
								failure: function() {
									toggleMessage(A.one('.prompt-failure-msg'));
								},
								success: function() {
									toggleMessage(A.one('.prompt-success-msg'));
								}
							}
						}
					);
				}
			);
		}
	}
);