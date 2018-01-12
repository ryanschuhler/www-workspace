<button class="unfiltered">unfiltered</button>
<button class="someResults">someResults</button>
<button class="noResults">noResults</button>

<#assign request_url = "/osb-partnership-portlet/partnership/partnership_entries?" />

<div id="partnersDisplay">
	<#if empty_results_msg??>
		<h3 class="results-message standard-padding">${empty_results_msg.data}</h3>
	</#if>

	<div class="global-container stacked">
	</div>
</div>

<style>
	.wrapped {
		display: flex;
		flex-wrap: wrap;
	}

	.wrapped article {
		flex-basis: 230px;
		flex-grow: 1;
		max-width: 23%;
	}

	#partnersDisplay article {
		border: 1px solid #E3E4E5;

		-moz-border-radius: 3px;
		-webkit-border-radius: 3px;
		border-radius: 3px;

		height: 200px;
		margin: .5em;
		position: relative;
		width: 23%;
	}

	#partnersDisplay article:hover {
		border: 1px solid #1C75B9;
		cursor: pointer;
	}

	#partnersDisplay article a {
		align-items: center;
		color: inherit;
		display: flex;
		flex-direction: column;
		height: 100%;
		position: absolute;
		text-decoration: none;
		width: 100%;
	}

	#partnersDisplay article.regional {
		display: inline-block;
		vertical-align:top;
	}

	#partnersDisplay .global-container.stacked {
		width: 23%;
	}

	#partnersDisplay .global-container.stacked article.global {
		width: 100%;
		float: left;
	}

	#partnersDisplay .global-container.wrapped article.global {
		float: none;
	}

	#partnersDisplay .partner-level {
		text-transform: capitalize;
	}

	#partnersDisplay .partner-logo {
		height: 64px;
		padding: 1.75em 0;
	}

	#partnersDisplay .partner-name {
		padding: 3em 0.5em .5em;
	}

	#partnersDisplay .results-message {
		display: none;
	}

	@media (max-width: 968px) {
		.wrapped article {
			max-width: 33%;
		}

		#partnersDisplay article {
			width: 30%;
		}

		#partnersDisplay .global-container.stacked {
			width: 30%;
		}
	}

	@media (max-width: 768px) {
		.wrapped article {
			max-width: 50%;
		}

		#partnersDisplay article {
			width: 46%;
		}

		#partnersDisplay .global-container.stacked {
			width: 46%;
		}
	}

	@media (max-width: 500px) {
		.wrapped article {
			max-width: 100%;
		}

		#partnersDisplay article {
			width: 100%;
		}

		#partnersDisplay .global-container.stacked {
			width: 100%;
		}
	}
</style>

<script type="text/javascript">
	AUI().use(
		'aui-base', 'aui-io-request', 'event',
		function (A) {
			var globalPartnersContainer = A.one('#partnersDisplay .global-container');
			var partnersDisplay = A.one('#partnersDisplay');

			var DOMUtils = (function() {
				var outerHTML = function(node){
					return node.outerHTML || new XMLSerializer().serializeToString(node);
				};

				var wrapAll = function(wrapper, elems) {
					var el = elems.length ? elems[0] : elems;
					var parent  = el.parentNode;
					var sibling = el.nextSibling;

					wrapper.appendChild(el);

					for (var x = 1; x < elems.length; x++) {
						wrapper.appendChild(elems[x]);
					}

					parent.insertAdjacentHTML('afterbegin', outerHTML(wrapper));
				};

				var unwrap = function(elems) {
					elems = 'length' in elems ? elems : [elems];
					for (var i = 0; i < elems.length; i++) {
						var elem = elems[i];
						var parent = elem.parentNode;
						var grandparent = parent.parentNode;

						if (parent.id !== "partnersDisplay") {
							grandparent.insertBefore(elem, parent);

							if (parent.children.length === 0)
								grandparent.removeChild(parent);
						}
					}
				};

				var addWrapperTo = function(elems, orientation) {
					if (elems) {
						orientation = orientation ? orientation : ""
						var currentElems = document.querySelectorAll('.' + elems);
						var container = document.createElement('div');

						container.className = elems + "-container " + orientation;
						wrapAll(container, currentElems);
					}
				};

				var changeOrder = function(order) {
					var partnersDisplay = document.querySelector("#partnersDisplay");
					var regionalArticles = document.querySelectorAll('.regional');
					var globalArticles = document.querySelectorAll('.global');

					if (order === "flip") {
						for (var f = 0; f < globalArticles.length; f++) {
							partnersDisplay.appendChild(globalArticles[f]);
						}
					} else {
						for (var r = 0; r < regionalArticles.length; r++) {
							partnersDisplay.appendChild(regionalArticles[r]);
						}
					}
				};

				var toggleResultsMessage = function(toggle) {
					var partnersDisplay = document.querySelector("#partnersDisplay");
					var resultsMessage = document.querySelector(".results-message");

					if (toggle === "show") {
						resultsMessage.style.display = "block";
					} else {
						resultsMessage.style.display = "none";
					}

					partnersDisplay.insertBefore(resultsMessage, partnersDisplay.childNodes[0]);
				};

				var toggleRegional = function(mode) {
					var regionals = document.querySelectorAll('.regional');

					if (mode === "hide") {
						for (var l = 0; l < regionals.length; l++) {
							regionals[l].style.display = "none";
						}
					} else {
						for (var l = 0; l < regionals.length; l++) {
							regionals[l].style.display = "inline-block";
						}
					}
				};

				var reset = function() {
					var globalArticles = document.getElementsByClassName('global');
					var regionalArticles = document.getElementsByClassName('regional');
					var partnersDisplay = document.querySelector("#partnersDisplay");

					// 1. remove all wrappers
					unwrap(globalArticles);

					if (regionalArticles) {
						unwrap(regionalArticles);
					}

					// 2. remove classes from parent container
					partnersDisplay.className = "";

					// 3. reset order of elements
					changeOrder("reset");

					// 4. hide results message
					toggleResultsMessage("hide");

					// 5. show regional results
					toggleRegional("show");
				};

				return {
					reset: reset,
					toggleResultsMessage: toggleResultsMessage,
					changeOrder: changeOrder,
					toggleRegional: toggleRegional,
					addWrapperTo: addWrapperTo
				}
			}
			)();

			var changeView = {
				unfiltered: function() {
					DOMUtils.reset();
					DOMUtils.addWrapperTo('global', 'stacked');
				},
				someResults: function() {
					DOMUtils.reset();
					DOMUtils.changeOrder("flip");
					partnersDisplay.className = "wrapped";
				},
				noResults: function() {
					DOMUtils.reset();
					DOMUtils.addWrapperTo("global", "wrapped");
					DOMUtils.toggleResultsMessage("show");
					DOMUtils.toggleRegional("hide");
				}
			};

			var resetButton = A.one('button.reset');
			var unfilteredButton = A.one('button.unfiltered');
			var someResultsButton = A.one('button.someResults');
			var noResultsButton = A.one('button.noResults');

			unfilteredButton.on("click", function() {
				changeView.unfiltered();
			});

			someResultsButton.on("click", function() {
				changeView.someResults();
			});

			noResultsButton.on("click", function() {
				changeView.noResults();
			});

			var displayPartners = function(data) {
				var arrayGlobal = [];
				var arrayRegional = [];

				var htmlGlobal = '';
				var htmlRegional = '';

				A.Array.each(
					data,
					function(obj) {
						var logoURL = obj.logoURL;
						var partnerName = obj.name;
						var partnerships = obj.partnerships;
						var partnershipsEntries = obj.partnerships.length;
						var profileURL = obj.profileURL || '';

						var partnerLogo = '<p class="partner-name">' + partnerName + '</p>';

						if (logoURL) {
							var partnerLogo = '<img class="partner-logo" src="'+ obj.logoURL + '">';
						}

						for (i = 0; i < partnershipsEntries; i++) {
							var partnershipCountry = partnerships[i].countryName;
							var partnershipLevel = partnerships[i].level;

							if (partnershipCountry == 'global') {
								htmlGlobal = '<article class="element-background global">' +
									'<a class="block-container justify-center text-center" href="' + profileURL + '" title="' + partnerName + '">' +
									partnerLogo +
									'<h3>${languageUtil.get(locale, "global", "Global")}</h3>' +
									'</a>' +
									'</article>';

								arrayGlobal.push(htmlGlobal);
							}
							else if (partnerships[i].type == 'distributor') {
								// pending design and PM decisions
							}
							else {
								htmlRegional = '<article class="regional">' +
									'<a class="text-center" href="' + profileURL + '" title="' + partnerName + '">' +
									partnerLogo +
									'<h3 class="partner-level">${languageUtil.get(locale, "' + partnershipLevel + '")}</h3>' +
									'<p class="font-weight-bold">${languageUtil.get(locale, "' + partnershipCountry + '")}</p>' +
									'</a>' +
									'</article>';

								arrayRegional.push(htmlRegional);
							}
						}
					}
				);

				randomizePartners(arrayGlobal, globalPartnersContainer);
				randomizePartners(arrayRegional, partnersDisplay);
			};

			var randomizePartners = function(array, node) {
				if (array.length <= 0) {
					return;
				}

				for (var i = array.length -1; i > 0; i--) {
					var rand = Math.floor(Math.random() * (i + 1));
					var temp = array[i];

					array[i] = array[rand];
					array[rand] = temp;
				}

				for (var j = 0; j < array.length; j++) {
					node.appendChild(array[j]);
				}
			};

			A.io.request(
				'${request_url}',
				{
					dataType: 'JSON',
					method: 'GET',
					on: {
						success: function (event, id, obj) {
							var responseData = this.get('responseData');

							displayPartners(responseData);
						},
						failure: function (event, id, obj) {
							console.log('failed to retrieve data');
						}
					}
				}
			);
		}
	);
</script>