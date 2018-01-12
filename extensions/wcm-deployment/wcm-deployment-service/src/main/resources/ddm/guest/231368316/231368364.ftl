<#import "${templatesPath}/231368766" as article_utilities>
<#import "${templatesPath}/231422122" as blog_templates>

<#assign params = [
	"blogCategoryName",
	"end",
	"keywords",
	"start",
	"tags",
	"topicCategoryName",
	"title",
	"regionCategoryName"
]/>

<#assign default_params_map = {"regionCategoryName": ["en-us"]}>

<#assign query_string = httpUtil.getQueryString(request.attributes['CURRENT_URL'])>
<#assign paramsMap = default_params_map + httpUtil.getParameterMap(query_string)>

<#assign blogRequestType = "BLOGS_ENTRIES">
<#assign blogs_endpoint = "/osb-blogs-web/blogs_entries">

<#if (paramsMap.title)??>
	<#assign blogRequestType = "BLOGS_POST">
	<#assign blogs_endpoint = "/osb-blogs-web/blogs_entry">
</#if>

<#assign servlet_request_url = request.scheme + "://" + request['server-name'] + blogs_endpoint >

<#assign resource_url = request['resource-url']>

<#list paramsMap?keys as param_key>
	<#if params?seq_contains(param_key)>
		<#assign servlet_request_url = httpUtil.addParameter(servlet_request_url, param_key, paramsMap[param_key]?first) >

		<#if param_key != "start" && param_key != "end">
			<#assign resource_url = httpUtil.addParameter(resource_url, param_key, paramsMap[param_key]?first) >
		</#if>
	</#if>
</#list>

<#if request.lifecycle == 'RENDER_PHASE'>
	<style>
		.banner-overlay {
			background-image: linear-gradient(rgba(0, 0, 0, 0), rgba(0, 0, 0, 0.9));
			bottom: 0;
			left: 0;
			position: absolute;
			right: 0;
			top: 0;
		}

		.aui .blogs-category:after {
			background: currentColor;
		}

		.aui .blogs-cx-color {
			color: #544988;
		}

		.aui  .blogs-ds-color {
			color: #38959A;
		}

		.aui .blogs-nav {
			position: static;
		}

		.aui .blogs-nav .navigation {
			height: 100vh;
		}

		.aui .scroll-nav-content-container .navigation.nav-top.affix {
			transition: top 0.25s;
		}

		.aui .hide-banner .scroll-nav-content-container .navigation.nav-top.affix {
			top: 3em;
		}

		.aui .scroll-nav-content-container .navigation.nav-top.affix {
			top: 6em;
		}

		.blogs-subscribe-form {
			margin-bottom: 3em;
		}

		.aui .blogs-search {
			opacity: 0.7;
			transition: all 0.3s ease-in-out;
		}

		.aui .blogs-search:hover,
		.aui .blogs-search:focus,
		.aui .blogs-search:active {
			opacity: 1;
		}

		.aui .blogs-search input {
			border-width: 0;
			box-shadow: none;
			font-size: 20px;
			line-height: 1.4;
			margin: 0;
		}

		.aui .blogs-search input:focus,
		.aui .blogs-search input:hover {
			box-shadow: none;
		}

		.blogs-promo.blog-color-blue {
			color: #29488C;
		}

		.blogs-promo.blog-color-green, .envelope {
			color: #38959A;
		}

		.blogs-promo.blog-color-lightgreen {
			color: #2EAD78;
		}

		.blogs-promo.blogs-subcategories.tile {
			align-items: stretch;
			flex-grow: 1;
			height: auto;
			margin-bottom: 1.5em;
			padding: 1.5em;
		}

		.promo-content {
			-webkit-flex-direction: column;
			flex-direction: column;
		}

		.blogs-overview-links {
			margin: auto 0;
		}

		.blogs-overview-links a {
			display: block;
			transition: all 0.3s ease;
			width: 100%;
		}

		.blogs-overview-links a:focus,
		.blogs-overview-links a:hover {
			text-decoration: none;
			transform: translateY(0.1em);
		}

		.blogs-overview-links .title {
			font-size: 20px;
			font-weight: 400;
		}

		.aui hr.blog-entry-link-line {
			margin: 20px auto;
			width: 50%;
		}

		.aui hr.blog-entry-link-line:last-child {
			display: none;
		}

		.promo-content .blogs-category-link {
			margin-top: auto;
		}

		.nav-section {
			margin-bottom: 10px;
		}

		@media (min-width: 768px) {
			.blogs-root-overview .blogs-entries .blogs-entry:first-child {
				flex-direction: column;
				height: 400px;
				justify-content: center;
				margin: 50px 0;
				max-width: 100%;
				width: 100%;
			}

			.blogs-root-overview .blogs-entries .blogs-entry:first-child a {
				text-align: left;
				width: 50%;
			}

			.blogs-root-overview .blogs-entries .blogs-entry:first-child .blog-entry-link:first-child,
			.blogs-root-overview .blogs-entries .blogs-entry:first-child .blog-entry-link:first-child .image-wrapper {
				height: 100%;
				margin-right: 1.5em;
			}
		}

		/* Temp styles. Remove when Theme is updated */

		.aui .blogs-entry.tile, .aui .blogs-promo {
			max-width: none;
		}

		.aui .blogs-promo .promo-content {
			height: auto;
		}
	</style>

	<#assign portlet_bean_locator = objectUtil("com.liferay.portal.kernel.bean.PortletBeanLocatorUtil")>

	<#assign hs_subscription_options = [
		"blog_en_us_customer_experience",
		"blog_en_us_digital_strategy"
	]>

	<#assign hs_subscriptions_json_array = []>

	<#if request.attributes.OSB_WWW_HUBSPOT_UTK??>
		<#assign hsutk = request.attributes.OSB_WWW_HUBSPOT_UTK>
		<#assign hs_contact_local_service = portlet_bean_locator.locate("hubspot-portlet", "com.liferay.hubspot.service.HSContactLocalService")>

		<#assign hs_contact = hs_contact_local_service.fetchHSContactByUserToken(hsutk)!>

		<#if hs_contact.getHSContactJSONObject??>
			<#assign hs_contact_json_object = hs_contact.getHSContactJSONObject().getJSONObject("properties")!>

			<#list hs_subscription_options as hs_property_name>
				<#assign blog_subscription_json_object = hs_contact_json_object.getJSONObject(hs_property_name)!>

				<#if blog_subscription_json_object.getString?? && (blog_subscription_json_object.getString("value") == "Yes") >
					<#assign hs_subscriptions_json_array = hs_subscriptions_json_array + [hs_property_name]>
				</#if>
			</#list>
		</#if>
	</#if>

<svg height="0" style="position:absolute" width="0"><symbol viewBox="0 0 86 56" id="digitalStrategy"><g fill="none" fill-rule="evenodd" transform="translate(-14 -12)"><path d="M0 0h114v80H0z"/><rect width="70" height="54" x="22" y="13" stroke="#D4D6DF" stroke-width="2" opacity=".5" rx="6"/><rect width="64" height="48" x="25" y="16" fill="#D4D6DF" opacity=".5" rx="4"/><path fill="#A3D7D9" d="M25 39c9.695 0 3.481-17.752 10.911-17.752s2.699 22.138 10.586 22.138c7.888 0 3.727-10.561 10.586-10.561 6.86 0 3.08 23.777 10.586 23.777S71.576 43.21 78.256 43.21 82.756 26 89 26c-.004 11.077 0 33.993 0 33.993A4.007 4.007 0 0 1 84.996 64H29.003A4.007 4.007 0 0 1 25 59.997V39z" opacity=".8"/><path stroke="currentColor" stroke-width="2" opacity=".8" stroke-linecap="round" stroke-linejoin="round" d="M17 59l20-14 20 4 20-16 20-12"/><circle cx="17" cy="59" r="2" stroke="#2D777A" stroke-width="2" opacity=".9"/><circle cx="37" cy="45" r="2" stroke="#2D777A" stroke-width="2" opacity=".9"/><circle cx="57" cy="49" r="2" stroke="#2D777A" stroke-width="2" opacity=".9"/><circle cx="77" cy="33" r="2" stroke="#2D777A" stroke-width="2" opacity=".9"/><circle cx="97" cy="21" r="2" stroke="#2D777A" stroke-width="2" opacity=".9"/></g></symbol><symbol viewBox="0 0 97 76" id="customerExperience"><g fill="none" fill-rule="evenodd"><path d="M-6-4h114v80H-6z"/><path fill="#D4D6DF" fill-rule="nonzero" d="M83 36c0 17.673-14.327 32-32 32-17.674 0-32-14.327-32-32C19 18.329 33.326 4 51 4c17.673 0 32 14.329 32 32z" opacity=".2"/><path fill="#D4D6DF" fill-rule="nonzero" d="M75 36c0 13.255-10.746 24-24 24S27 49.255 27 36c0-13.253 10.746-24 24-24s24 10.747 24 24z" opacity=".4"/><path fill="#D4D6DF" fill-rule="nonzero" d="M67 36c0 8.835-7.164 16-16 16s-16-7.165-16-16c0-8.836 7.164-16 16-16s16 7.164 16 16z" opacity=".6"/><path fill="currentColor" d="M51 33c-4.417 0-8 3.775-8 8.434V45h16v-3.566C59 36.775 55.419 33 51 33z" opacity=".85"/><path fill="currentColor" d="M56 30a5 5 0 1 1-10 0 5 5 0 0 1 10 0z" opacity=".85"/><path stroke="#9E97BE" stroke-width="2" d="M20 67c0-4.418 3.59-8 8-8 4.418 0 8 3.59 8 8 0 4.418-3.59 8-8 8-4.418 0-8-3.59-8-8zM24 67h8" opacity=".5" stroke-linecap="round" stroke-linejoin="round"/><path stroke="#443B6E" stroke-width="2" d="M78.562 26.105a5.333 5.333 0 1 1 7.543-7.543 5.333 5.333 0 1 1 7.542 7.543l-7.542 7.542-7.543-7.542z" opacity=".8" stroke-linecap="round" stroke-linejoin="round"/><path stroke="#6A619B" stroke-width="2" d="M9 1v16M1 9h16" opacity=".8" stroke-linecap="round" stroke-linejoin="round"/></g></symbol><symbol viewBox="0 0 180 180" id="language"><path fill="#E3E4E5" fill-rule="evenodd" d="M157.469 74.635c0 10.105-1.615 19.48-4.844 28.125-3.23 8.646-7.734 16.224-13.516 22.735-5.78 6.51-12.682 11.849-20.703 16.015-8.02 4.167-16.823 6.823-26.406 7.97v10.468h15.156c1.459 0 2.683.469 3.672 1.406.99.938 1.484 2.136 1.484 3.594 0 1.354-.494 2.526-1.484 3.516-.99.99-2.213 1.484-3.672 1.484H67.625c-1.458 0-2.708-.495-3.75-1.484-1.042-.99-1.563-2.162-1.563-3.516 0-1.458.521-2.656 1.563-3.594 1.042-.937 2.292-1.406 3.75-1.406h14.531v-9.844H82a73.12 73.12 0 0 1-14.375-1.406 80.003 80.003 0 0 1-13.75-4.063c-1.25-.52-2.161-1.432-2.734-2.734s-.6-2.578-.078-3.828c.52-1.25 1.432-2.135 2.734-2.656 1.302-.521 2.578-.521 3.828 0a63.03 63.03 0 0 0 11.953 3.515A66.446 66.446 0 0 0 82 140.104c9.48 0 18.23-1.64 26.25-4.922 8.02-3.281 14.922-7.812 20.703-13.593 5.781-5.782 10.313-12.683 13.594-20.704 3.281-8.02 4.922-16.77 4.922-26.25 0-5.625-.755-11.12-2.266-16.484a66.5 66.5 0 0 0-6.406-15.234 62.892 62.892 0 0 0-10.078-13.125c-3.959-3.959-8.49-7.448-13.594-10.47-1.146-.728-1.901-1.744-2.266-3.046-.364-1.302-.182-2.578.547-3.828.625-1.146 1.615-1.901 2.969-2.266 1.354-.364 2.656-.182 3.906.547 5.73 3.438 10.912 7.448 15.547 12.031 4.636 4.584 8.542 9.636 11.719 15.157a75.597 75.597 0 0 1 7.344 17.578c1.718 6.198 2.578 12.578 2.578 19.14zm-20.469.47c0 7.603-1.432 14.739-4.297 21.405-2.864 6.667-6.797 12.5-11.797 17.5-5 5-10.833 8.933-17.5 11.797-6.666 2.865-13.802 4.297-21.406 4.297-7.604 0-14.74-1.432-21.406-4.297-6.667-2.864-12.5-6.797-17.5-11.797-5-5-8.933-10.833-11.797-17.5C28.432 89.844 27 82.708 27 75.104c0-7.604 1.432-14.74 4.297-21.406 2.864-6.667 6.797-12.5 11.797-17.5 5-5 10.833-8.958 17.5-11.875C67.26 21.406 74.396 19.948 82 19.948c7.604 0 14.74 1.458 21.406 4.375 6.667 2.917 12.5 6.875 17.5 11.875s8.933 10.833 11.797 17.5C135.568 60.365 137 67.5 137 75.104zm-100.156 0c0 6.25 1.198 12.109 3.593 17.577 2.396 5.47 5.625 10.235 9.688 14.297 4.063 4.063 8.828 7.266 14.297 9.61 5.469 2.343 11.328 3.515 17.578 3.515s12.11-1.172 17.578-3.515c5.469-2.344 10.234-5.547 14.297-9.61 4.063-4.062 7.266-8.828 9.61-14.297C125.827 87.214 127 81.354 127 75.104c0-6.146-1.172-11.979-3.516-17.5-2.343-5.52-5.546-10.312-9.609-14.375-4.063-4.062-8.828-7.291-14.297-9.687C94.11 31.146 88.25 29.948 82 29.948s-12.11 1.198-17.578 3.594c-5.469 2.396-10.234 5.625-14.297 9.687-4.063 4.063-7.292 8.854-9.688 14.375-2.395 5.521-3.593 11.354-3.593 17.5z"/></symbol><symbol viewBox="158 63 69 44" id="envelope"><g fill="none" fill-rule="evenodd" transform="translate(159 64)" stroke="currentColor" stroke-width="1.5"><path d="M66 41.125H0V0h66z"/><path d="M66 7.024l-33 19.28L0 7.025"/><path d="M43.5 23.582L66 41.125M0 41.125l22.5-17.543" stroke-linecap="round"/></g></symbol></svg>

	<#assign response = "{ 'entries': [] }">

	<#attempt>
		<#assign response = httpUtil.URLtoString(servlet_request_url)>
	<#recover>
	</#attempt>

	<#assign json_response = jsonFactoryUtil.looseDeserializeSafe(response) >

	<#if !json_response?is_hash>
		<#assign json_response = { "entries": [] }>
	</#if>

	<#function get_subscription_form hs_subscriptions_json_array hubspot_subscription_property_name>
		<#assign subscription_form = "">

		<#if (hubspot_subscription_property_name)?? && !(hs_subscriptions_json_array?seq_contains(hubspot_subscription_property_name))>

			<#assign hsfg_article_content>
				<@article_utilities.get_article_content_by_id article_id.data />
			</#assign>

			<#assign form_tag_index = hsfg_article_content?index_of("</form>")>

			<#if form_tag_index != -1>
				<#assign subscription_form>
					${hsfg_article_content?substring(0,form_tag_index)}
					<input class="field" name="${hubspot_subscription_property_name}" type="hidden" value="Yes" />
					${hsfg_article_content?substring(form_tag_index)}
				</#assign>
			</#if>
		</#if>

		<#return subscription_form>
	</#function>

	<#assign hubspot_subscription_property_name = (json_response.blog.categoryProperties.hubspot_subscription_property_name)!>

	<#assign subscription_form = get_subscription_form(hs_subscriptions_json_array hubspot_subscription_property_name)>

	<div id="blogsWrapper">
		<#if blogRequestType == "BLOGS_POST">
			<@blog_templates.do_blogs_post json_response subscription_form />
		<#else>
			<@blog_templates.do_blogs_overview json_response subscription_form resource_url />
		</#if>
	</div>

	<script>
		AUI().add(
			'liferay-blogs-controller',
			function(A) {
				var BlogsController = function(options) {
					var instance = this;

					instance._blogsWrapper = A.one(options.blogsWrapper);
					instance._delta = options.delta;
					instance._pjaxEnabled = options.pjaxEnabled;
					instance._spaEnabled = options.spaOptions.enabled;
					instance._spaOptions = options.spaOptions;

					instance._init();
				};

				BlogsController.prototype = {
					_init: function() {
						var instance = this;

						if (instance._spaEnabled) {
							var query = {};

							for (var prop in instance._spaOptions.paramsMap) {
								query[prop] = instance._spaOptions.paramsMap[prop][0];
							}

							query.blogRequestType = instance._spaOptions.blogRequestType;

							history.replaceState(
								{
									blogRequestType: query.blogRequestType,
									blogsEntryId: instance._spaOptions.blogEntryId,
									browserUrl: location.pathname,
									query: query
								},
								document.title,
								location.pathname
							);

							window.onpopstate = function(event) {
								if (event.state) {
									instance._spaRequest(event.state.query, event.state.blogRequestType, event.state.browserUrl, event.state.blogsEntryId, false);
								}
							};

							var spaEventHandler = function(event, node, href) {
								var blogIndex = href.indexOf('blog');
								var blogsEntryId = node.getAttribute('data-blogs-entry-id');

								if (blogIndex != -1) {
									event.preventDefault();

									var params = href.substr(blogIndex).split('/').slice(1);

									var query = {
										blogRequestType: 'BLOGS_ENTRIES'
									};

									for (var i = 0; i < params.length; i++) {
										if (!params[i]) {
											continue;
										}

										if (i == 0) {
											query.regionCategoryName = params[i];
										}
										else if (i == 1) {
											query.blogCategoryName = params[i];
										}
										else if (i == 2) {
											if (params[i] == 'category') {
												query.topicCategoryName = params[i + 1];
											}
											else if (params[i] == 'tag' && (params.length == i + 2)) {
												query.tags = params[i + 1];
											}
											else {
												query.title = params[i];
												query.blogRequestType = 'BLOGS_POST';
											}
										}
									}

									instance._spaRequest(query, query.blogRequestType, href, blogsEntryId, true);
								}
							};

							instance._blogsWrapper.delegate(
								'click',
								function(e) {
									spaEventHandler(e, e.currentTarget, e.currentTarget.getAttribute('href'));
								},
								'.blog-entry-link, .blogs-category-link, .blogs-read-post-link, .blogs-sibling-link, .blogs-tag-link'
							);

							instance._blogsWrapper.delegate(
								'change',
								function(e) {
									e.currentTarget.getDOMNode().onchange = '';

									spaEventHandler(e, e.currentTarget, e.currentTarget.get('value'));
								},
								'.blogs-region-select'
							);

							instance._blogsWrapper.all('.blogs-region-select').each(
								function(select) {
									select.getDOMNode().onchange = '';
								}
							);
						}

						if (instance._pjaxEnabled) {
							var pjax = new A.Pjax(
								{
									container: '#blogsWrapper',
									linkSelector: '.blog-entry-link'
								}
							);

							pjax.on(
								'navigate',
								function(e) {
									console.log(e.url);
								}
							);
						}
					},

					_loadMore: function(node) {
						var instance = this;

						var count = parseInt(node.getAttribute('data-count'), 10);
						var end = parseInt(node.getAttribute('data-end'), 10);
						var resourceUrl = node.getAttribute('data-href');
						var start = parseInt(node.getAttribute('data-start'), 10);

						start = end;
						end += instance._delta;

						var queryString = A.QueryString.stringify(
							{
								end: end,
								start: start
							}
						);

						if (end >= count) {
							node.remove();
						}
						else {
							node.setAttribute('data-end', end);
							node.setAttribute('data-start', start);
						}

						instance._requestData(
							resourceUrl + '&' + queryString,
							function(obj, config, instance) {
								instance._blogsWrapper.one('.blogs-entries').append(obj);
							}
						);
					},

					_renderBlogPost: function(blogsEntryId) {
						var instance = this;

						if (instance.scrollNav) {
							instance.scrollNav.detach();
						}

						instance.scrollNav = new A.ScrollNav(
							{
								alignNode: '.blogs-content'
							}
						).render();

						var disqus_config = function() {
							this.page.url = document.URL;
							this.page.identifier = blogsEntryId;
						};

						if (window.DISQUS) {
							window.DISQUS.reset(
								{
									config: disqus_config,
									reload: true
								}
							);
						}
						else {
							(function() {
								var d = document;
								var s = d.createElement('script');

								s.src = '//liferay-blog.disqus.com/embed.js';
								s.setAttribute('data-timestamp', + new Date());
								(d.head || d.body).appendChild(s);
							})();
						}
					},

					_requestData: function(uri, successFn, config) {
						var instance = this;

						A.io.request(
							uri,
							{
								dataType: 'JSON',
								method: 'GET',
								on: {
									failure: function(event, id, obj) {
										console.log('fail');
									},
									success: function(event, id, obj) {
										successFn(this.get('responseData'), config, instance);
									}
								}
							}
						);
					},

					_search: function(e) {
						var instance = this;

						var keywords = e.target.value;

						var entries = instance._blogsWrapper.one('.blogs-entries');
						var loadMore = instance._blogsWrapper.one('.load-more');
						var resultsText = instance._blogsWrapper.one('.results-text');

						if (e.keyCode === 13) {
							e.preventDefault();

							instance._requestData(
								'${resource_url}' + '&' + 'keywords=' + keywords,
								function(obj, config, instance) {
									if (entries) {
										entries.remove();
									}

									if (loadMore) {
										loadMore.remove();
									}

									if (resultsText) {
										resultsText.remove();
									}

									instance._blogsWrapper.appendChild(obj);
								}
							);
						}
					},

					_spaRequest: function(query, blogRequestType, browserUrl, blogsEntryId, pushState) {
						var instance = this;

						var queryString = A.QueryString.stringify(query);

						instance._requestData(
							"${request['resource-url']}" + '&' + queryString,
							function(obj, config, instance) {
								instance._blogsWrapper.get('childNodes').remove();

								instance._blogsWrapper.append(obj);

								if (blogRequestType == 'BLOGS_POST') {
									instance._renderBlogPost(blogsEntryId);
								}

								A.config.win.scroll(0, 0);

								instance._blogsWrapper.all('.blogs-region-select').each(
									function(select) {
										select.getDOMNode().onchange = '';
									}
								);

								var htmlTitle = 'Blogs | Liferay';

								var header = instance._blogsWrapper.one('h1');

								if (header) {
									htmlTitle = header.getContent() + ' | Liferay';
								}

								if (pushState) {
									history.pushState(
										{
											blogRequestType: blogRequestType,
											blogsEntryId: blogsEntryId,
											browserUrl: browserUrl,
											query: query
										},
										htmlTitle,
										browserUrl
									);
								}
							}
						);
					}
				};

				Liferay.BlogsController = BlogsController;
			},
			'',
			{
				requires: ['aui-base', 'aui-io', 'pjax', 'scroll-nav']
			}
		);

		AUI().ready(
			'aui-base',
			'liferay-blogs-controller',
			function(A) {
				window.blogsController = new Liferay.BlogsController(
					{
						blogsWrapper: '#blogsWrapper',
						delta: 9,
						pjaxEnabled: false,
						spaOptions: {
							blogRequestType: '${blogRequestType}',
							blogsEntryId: "${json_response.blogsEntryId!"null"}",
							enabled: true,
							paramsMap: ${jsonFactoryUtil.looseSerializeDeep(paramsMap)}
						}
					}
				);

				if (("${blogRequestType}" == 'BLOGS_POST') && "${json_response.blogsEntryId!}") {
					window.blogsController._renderBlogPost(${json_response.blogsEntryId!});
				}
			}
		);
	</script>

<#elseif request.lifecycle == 'RESOURCE_PHASE'>
	<#assign response = "{}">

	<#attempt>
		<#assign response = httpUtil.URLtoString(servlet_request_url)>
	<#recover>
	</#attempt>

	<#assign json_response = jsonFactoryUtil.looseDeserializeSafe(response)>

	<#if (paramsMap.blogRequestType??)>
		<#assign subscription_form = "">

		<#if paramsMap.blogRequestType?first == "BLOGS_POST">
			<@blog_templates.do_blogs_post json_response subscription_form />
		<#else>
			<@blog_templates.do_blogs_overview json_response subscription_form resource_url />
		</#if>
	<#elseif (paramsMap.start)??>
		<#list json_response.entries as blog_entry>
			<#if blog_entry.blogsEntryId?has_content>
				<@blog_templates.do_blogs_entry blog_entry />
			</#if>
		</#list>
	<#elseif (paramsMap.keywords)??>
		<@blog_templates.do_blogs_search_results json_response paramsMap.keywords?first resource_url />
	<#else>
		<#import "${templatesPath}/229864287" as submit_hs_form>

		<@submit_hs_form.submit_form />
	</#if>
</#if>