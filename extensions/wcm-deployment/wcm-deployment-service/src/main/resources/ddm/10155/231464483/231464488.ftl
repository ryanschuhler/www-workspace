<#attempt>
	<#import "${templatesPath}/231368766" as article_utilities>
	<#import "${templatesPath}/231464485" as blog_templates>

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

	<#assign default_params_map = {}>

	<#if default_region.data?has_content>
		<#assign default_params_map = default_params_map + {"regionCategoryName": ["${default_region.data}"]}>
	</#if>

	<#if default_blog.data?has_content>
		<#assign default_params_map = default_params_map + {"blogCategoryName": ["${default_blog.data}"]}>
	</#if>

	<#assign query_string = httpUtil.getQueryString(request.attributes['CURRENT_URL'])>
	<#assign params_map = default_params_map + httpUtil.getParameterMap(query_string)>

	<#assign blogRequestType = "BLOGS_ENTRIES">
	<#assign blogs_endpoint = "/osb-blogs-web/blogs_entries">

	<#if (params_map.title)??>
		<#assign blogRequestType = "BLOGS_POST">
		<#assign blogs_endpoint = "/osb-blogs-web/blogs_entry">
	</#if>

	<#assign servlet_request_url = request.scheme + "://" + request['server-name'] + blogs_endpoint >

	<#assign resource_url = request['resource-url']>

	<#assign escaped_params_map = {}>

	<#list params_map?keys as param_key>
		<#assign escaped_params_map = escaped_params_map + {param_key: ["${htmlUtil.escapeJS(params_map[param_key]?first)}"]}>

		<#if params?seq_contains(param_key)>
			<#assign servlet_request_url = httpUtil.addParameter(servlet_request_url, param_key, htmlUtil.escapeHREF(params_map[param_key]?first)) >

			<#if param_key != "start" && param_key != "end">
				<#assign resource_url = httpUtil.addParameter(resource_url, param_key, htmlUtil.escapeHREF(params_map[param_key]?first)) >
			</#if>
		</#if>
	</#list>

	<#if request.lifecycle == 'RENDER_PHASE'>
		<style>
			#blogsWrapper .lrdcom-form .btn {
				width: 100%;
			}

			#blogsWrapper .lrdcom-form .btn.btn-complementary:hover {
				background-color: #f5a11d;
			}

			.banner-overlay {
				background-image: linear-gradient(rgba(0, 0, 0, 0), rgba(0, 0, 0, 0.9));
				bottom: 0;
				left: 0;
				position: absolute;
				right: 0;
				top: 0;
			}

			.aui .blog-cta-bottom {
				border-radius: 4px;
				padding: 3em;
			}

			.aui .blog-cta-bottom.blogs-cx-color {
				background-color: #544988;
			}

			.aui .blog-cta-bottom.blogs-ds-color {
				background-color: #38959A;
			}

			.aui .blog-cta-bottom a.cta {
				font-size: 0.9em;
				text-decoration: none;
			}

			.aui .blog-cta-bottom .cta .blog-cta-icon {
				background-image: url(https://www.liferay.com/documents/10182/231683992/caret_right_white.png);
				background-repeat: no-repeat;
				background-size: 8px 10px;
				display: inline-block;
				height: 10px;
				line-height: 10px;
				width: 8px;
			}

			.aui .blog-cta-bottom .cta:active .blog-cta-icon, .aui .blog-cta-bottom .cta:hover .blog-cta-icon {
				background-image: url(https://www.liferay.com/documents/10182/231683992/caret_right_gray.png);
			}

			.aui .blog-cta-bottom h4 {
				color: #FFF;
				font-size: 1.125em;
				font-weight: bold;
			}

			.aui .blog-cta-bottom.blogs-cx-color p, .aui .blog-cta-bottom.blogs-ds-color p {
				color: #FFF;
				font: 400 18px/1.5 source-sans-pro, Arial, Helvetica, sans-serif;
			}

			.aui .blogs-category:after {
				background: currentColor;
			}

			.aui .blogs-cx-color, .aui .blogs-cx-color .blog-title {
				color: #544988;
			}

			.aui .blogs-ds-color, .aui .blogs-ds-color .blog-title {
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

			.aui .parent-category:hover {
				text-decoration: none;
			}

			.aui .parent-category .blog-title {
				-webkit-transition: all 0.3s ease;
				transition: all 0.3s ease;
			}

			.aui .parent-category:hover .blog-title {
				-webkit-transform: translateY(0.1em);
				transform: translateY(0.1em);
			}

			.blogs-promo.blog-color-blue {
				color: #29488C;
			}

			.blogs-promo.blog-color-green {
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

			.localization-tile .localization-tile-content {
				flex-direction: column;
				justify-content: space-around;
				width: 100%;
			}
		</style>

		<svg height="0" style="position:absolute" width="0"><symbol id="language" viewbox="0 0 180 180"><path d="M157.469 74.635c0 10.105-1.615 19.48-4.844 28.125-3.23 8.646-7.734 16.224-13.516 22.735-5.78 6.51-12.682 11.849-20.703 16.015-8.02 4.167-16.823 6.823-26.406 7.97v10.468h15.156c1.459 0 2.683.469 3.672 1.406.99.938 1.484 2.136 1.484 3.594 0 1.354-.494 2.526-1.484 3.516-.99.99-2.213 1.484-3.672 1.484H67.625c-1.458 0-2.708-.495-3.75-1.484-1.042-.99-1.563-2.162-1.563-3.516 0-1.458.521-2.656 1.563-3.594 1.042-.937 2.292-1.406 3.75-1.406h14.531v-9.844H82a73.12 73.12 0 0 1-14.375-1.406 80.003 80.003 0 0 1-13.75-4.063c-1.25-.52-2.161-1.432-2.734-2.734s-.6-2.578-.078-3.828c.52-1.25 1.432-2.135 2.734-2.656 1.302-.521 2.578-.521 3.828 0a63.03 63.03 0 0 0 11.953 3.515A66.446 66.446 0 0 0 82 140.104c9.48 0 18.23-1.64 26.25-4.922 8.02-3.281 14.922-7.812 20.703-13.593 5.781-5.782 10.313-12.683 13.594-20.704 3.281-8.02 4.922-16.77 4.922-26.25 0-5.625-.755-11.12-2.266-16.484a66.5 66.5 0 0 0-6.406-15.234 62.892 62.892 0 0 0-10.078-13.125c-3.959-3.959-8.49-7.448-13.594-10.47-1.146-.728-1.901-1.744-2.266-3.046-.364-1.302-.182-2.578.547-3.828.625-1.146 1.615-1.901 2.969-2.266 1.354-.364 2.656-.182 3.906.547 5.73 3.438 10.912 7.448 15.547 12.031 4.636 4.584 8.542 9.636 11.719 15.157a75.597 75.597 0 0 1 7.344 17.578c1.718 6.198 2.578 12.578 2.578 19.14zm-20.469.47c0 7.603-1.432 14.739-4.297 21.405-2.864 6.667-6.797 12.5-11.797 17.5-5 5-10.833 8.933-17.5 11.797-6.666 2.865-13.802 4.297-21.406 4.297-7.604 0-14.74-1.432-21.406-4.297-6.667-2.864-12.5-6.797-17.5-11.797-5-5-8.933-10.833-11.797-17.5C28.432 89.844 27 82.708 27 75.104c0-7.604 1.432-14.74 4.297-21.406 2.864-6.667 6.797-12.5 11.797-17.5 5-5 10.833-8.958 17.5-11.875C67.26 21.406 74.396 19.948 82 19.948c7.604 0 14.74 1.458 21.406 4.375 6.667 2.917 12.5 6.875 17.5 11.875s8.933 10.833 11.797 17.5C135.568 60.365 137 67.5 137 75.104zm-100.156 0c0 6.25 1.198 12.109 3.593 17.577 2.396 5.47 5.625 10.235 9.688 14.297 4.063 4.063 8.828 7.266 14.297 9.61 5.469 2.343 11.328 3.515 17.578 3.515s12.11-1.172 17.578-3.515c5.469-2.344 10.234-5.547 14.297-9.61 4.063-4.062 7.266-8.828 9.61-14.297C125.827 87.214 127 81.354 127 75.104c0-6.146-1.172-11.979-3.516-17.5-2.343-5.52-5.546-10.312-9.609-14.375-4.063-4.062-8.828-7.291-14.297-9.687C94.11 31.146 88.25 29.948 82 29.948s-12.11 1.198-17.578 3.594c-5.469 2.396-10.234 5.625-14.297 9.687-4.063 4.063-7.292 8.854-9.688 14.375-2.395 5.521-3.593 11.354-3.593 17.5z" fill="#E3E4E5" fill-rule="evenodd"></path></symbol><symbol id="envelope" viewbox="158 63 69 44"><g fill="none" fill-rule="evenodd" stroke="currentColor" stroke-width="1.5" transform="translate(159 64)"><path d="M66 41.125H0V0h66z"></path><path d="M66 7.024l-33 19.28L0 7.025"></path><path d="M43.5 23.582L66 41.125M0 41.125l22.5-17.543" stroke-linecap="round"></path></g></symbol></svg>

		<#assign response = "{ 'entries': [] }">

		<#attempt>
			<#assign response = httpUtil.URLtoString(servlet_request_url)>
		<#recover>
		</#attempt>

		<#assign json_response = jsonFactoryUtil.looseDeserializeSafe(response)>

		<#if !json_response?is_hash>
			<#assign json_response = { "entries": [] }>
		</#if>

		<div id="blogsWrapper">
			<#if blogRequestType == "BLOGS_POST">
				<@blog_templates.do_blogs_post json_response />
			<#else>
				<@blog_templates.do_blogs_overview json_response resource_url />
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
									location.href
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
								},
								{
									data: {
										${request["portlet-namespace"]}hsfgArticleContent: '${htmlUtil.escapeJS(blog_templates.hsfg_article_content)}'
									}
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
									data: config.data,
									dataType: 'JSON',
									method: 'POST',
									on: {
										failure: function(event, id, obj) {
											console.log('fail', event, id, obj);
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
							var subcategories = instance._blogsWrapper.one('.subcategories');

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

										if (subcategories) {
											subcategories.remove();
										}

										instance._blogsWrapper.appendChild(obj);
									},
									{
										data: {
											${request["portlet-namespace"]}hsfgArticleContent: '${htmlUtil.escapeJS(blog_templates.hsfg_article_content)}'
										}
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
								},
								{
									data: {
										${request["portlet-namespace"]}hsfgArticleContent: '${htmlUtil.escapeJS(blog_templates.hsfg_article_content)}'
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
								blogsEntryId: '${json_response.blogsEntryId!"null"}',
								enabled: ${getterUtil.getBoolean(use_spa.data)?string},
								paramsMap: ${jsonFactoryUtil.looseSerializeDeep(escaped_params_map)}
							}
						}
					);

					if (('${blogRequestType}' == 'BLOGS_POST') && '${json_response.blogsEntryId!}') {
						window.blogsController._renderBlogPost(${json_response.blogsEntryId!});
					}
				}
			);
		</script>

	<#elseif request.lifecycle == 'RESOURCE_PHASE'>
		<#assign response = "{}">

		<#attempt>
			<#assign response = httpUtil.URLtoString(servlet_request_url)>

			<#assign json_response = jsonFactoryUtil.looseDeserializeSafe(response)>

			<#if (params_map.blogRequestType??)>
				<#if params_map.blogRequestType?first == "BLOGS_POST">
					<@blog_templates.do_blogs_post json_response />
				<#else>
					<@blog_templates.do_blogs_overview json_response resource_url />
				</#if>
			<#elseif (params_map.start)??>
				<#list json_response.entries as blog_entry>
					<#if blog_entry.blogsEntryId?has_content>
						<@blog_templates.do_blogs_entry blog_entry />
					</#if>
				</#list>
			<#elseif (params_map.keywords)??>
				<@blog_templates.do_blogs_search_results json_response params_map.keywords?first resource_url />
			</#if>
		<#recover>
		</#attempt>
	</#if>
<#recover>
</#attempt>