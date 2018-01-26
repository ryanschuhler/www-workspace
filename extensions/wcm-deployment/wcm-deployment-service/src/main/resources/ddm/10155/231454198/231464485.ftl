<#import "${templatesPath}/1561886" as lang>

 
<#assign hs_subscriptions_json_array = []>

<#if request.attributes.OSB_WWW_HUBSPOT_UTK??>
	<#assign hsutk = request.attributes.OSB_WWW_HUBSPOT_UTK>
	<#assign hs_contact_local_service = serviceLocator.findService("com.liferay.hubspot.service.HSContactLocalService")>

	<#assign hs_contact = hs_contact_local_service.fetchHSContactByUserToken(hsutk)!>

	<#if hs_contact.getHSContactJSONObject??>
		<#assign hs_contact_json_object = hs_contact.getHSContactJSONObject().getJSONObject("properties")!>

		<#list stringUtil.split(hubspot_settings.hubspot_subscription_property_names.data) as hs_property_name>
			<#assign blog_subscription_json_object = hs_contact_json_object.getJSONObject(hs_property_name)!>

			<#if blog_subscription_json_object.getString?? && (blog_subscription_json_object.getString("value") == "Yes") >
				<#assign hs_subscriptions_json_array = hs_subscriptions_json_array + [hs_property_name]>
			</#if>
		</#list>
	</#if>
</#if>

<#if request.lifecycle == 'RENDER_PHASE'>
	<#assign hsfg_article_content>
		<@article_utilities.embed_journal_article_by_article_id hubspot_settings.article_id.data />
	</#assign>
<#elseif request.lifecycle == 'RESOURCE_PHASE'>
	<#assign hsfg_article_content = (request.parameters.hsfgArticleContent)!"" />
</#if>

<#assign current_url = httpUtil.getPath(request.attributes['CURRENT_URL']) />

<#assign base_url = request.scheme + "://" + request['server-name'] />

<#function get_region_link region>
	<#if getterUtil.getBoolean(use_query_parameters.data)>
		<#return "${current_url}?regionCategoryName=${region.urlCategoryName}">
	</#if>

	<#return "${current_url}/${region.urlCategoryName}">
</#function>

<#function get_blog_link region blog>
	<#if getterUtil.getBoolean(use_query_parameters.data)>
		<#return "${current_url}?regionCategoryName=${region.urlCategoryName}/&blogCategoryName=${blog.urlCategoryName}">
	</#if>

	<#return "${current_url}/${region.urlCategoryName}/${blog.urlCategoryName}">
</#function>

<#function get_blog_post_link blog_entry>
	<#if getterUtil.getBoolean(use_query_parameters.data)>
		<#return "${current_url}?regionCategoryName=${blog_entry.region.urlCategoryName}&blogCategoryName=${blog_entry.blog.urlCategoryName}&title=${blog_entry.urlTitle}">
	</#if>

	<#return "${current_url}/${(blog_entry.region.urlCategoryName)!}/${(blog_entry.blog.urlCategoryName)!}/${(blog_entry.urlTitle)!}">
</#function>

<#function get_subscription_form hubspot_subscription_property_name >
	<#assign subscription_form = "">

	<#if (hubspot_subscription_property_name)?? && !(hs_subscriptions_json_array?seq_contains(hubspot_subscription_property_name))>
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

<#function get_tag_link response tag>
	<#if getterUtil.getBoolean(use_query_parameters.data)>
		<#return "${current_url}?regionCategoryName=${response.region.urlCategoryName}&blogCategoryName=${response.blog.urlCategoryName}&tag=${tag}">
	</#if>

	<#return "${current_url}/${response.region.urlCategoryName}/${response.blog.urlCategoryName}/tag/${tag}">
</#function>

<#function get_blog_topic_link blog_entry>
	<#if getterUtil.getBoolean(use_query_parameters.data)>
		<#return "${current_url}?regionCategoryName=${blog_entry.region.urlCategoryName}&blogCategoryName=${blog_entry.blog.urlCategoryName}&topicCategoryName=${blog_entry.topic.urlCategoryName}">
	</#if>

	<#return "${current_url}/${blog_entry.region.urlCategoryName}/${blog_entry.blog.urlCategoryName}/category/${blog_entry.topic.urlCategoryName}">
</#function>

<#function get_sibling_topic_link blog_entry topic>
	<#if getterUtil.getBoolean(use_query_parameters.data)>
		<#return "${current_url}?regionCategoryName=${blog_entry.region.urlCategoryName}&blogCategoryName=${blog_entry.blog.urlCategoryName}&topicCategoryName=${blog_entry.topic.urlCategoryName}">
	</#if>

	<#return "${current_url}/${blog_entry.region.urlCategoryName}/${blog_entry.blog.urlCategoryName}/category/${topic.urlCategoryName}">
</#function>

<#macro do_blogs_ad content>
	<div class="block-container blogs-promo tile w33">
		<div class="block-container no-padding promo-content">
			${content}
		</div>
	</div>
</#macro>

<#macro do_blogs_entry blog_entry>
	<div class="align-content-start block block-container blogs-entry tile w33">
		<a class="blog-entry-link" data-blogs-entry-id="${blog_entry.blogsEntryId}" href="${get_blog_post_link(blog_entry)}" >
			<div class="image-wrapper">
				<img src="${blog_entry.smallImageURL!}?width=350" />
			</div>
		</a>

		<#assign entry_link_css = "blog-entry-link standard-padding-vertical">

		<#if getterUtil.getBoolean(show_topic_label.data)>
			<a class="blogs-category-link" href="${get_blog_topic_link(blog_entry)}">
				<div class="blogs-category ${(blog_entry.blog.categoryProperties.cssClass)!"dxp-primary-color"}">
					${blog_entry.topic.categoryName}
				</div>
			</a>

			<#assign entry_link_css = "blog-entry-link">
		</#if>

		<a class="${entry_link_css}" href="${get_blog_post_link(blog_entry)}" >
			<h4 class="title">
				${blog_entry.title}
			</h4>

			<div class="description standard-padding-vertical">
				${blog_entry.description}
			</div>
		</a>
	</div>
</#macro>

<#macro do_blogs_entry_banner banner_post>
	<div class="align-center block-container blogs-entry-banner justify-center main-banner no-padding" style="background-image: url(${banner_post.smallImageURL!});">
		<div class="banner-overlay"></div>

		<div class="align-center block-container justify-center main-banner-content max-full no-margin w100">
			<div class="banner-content max-md no-margin no-padding text-center">
				<#if getterUtil.getBoolean(show_topic_label.data)>
					<p class="light-color small-caps text-center">
						${banner_post.topic.categoryName}
					</p>
				</#if>

				<h1 class="light-color small-padding-vertical text-center w100">
					${banner_post.title!}
				</h1>

				<a class="blogs-read-post-link btn btn-light" data-blogs-entry-id="${banner_post.blogsEntryId!}" href="${get_blog_post_link(banner_post)}">${lang.localize("read_post", "Read Post")}</a>
			</div>
		</div>
	</div>
</#macro>

<#macro do_blogs_entry_highlighted response>
	<div class="blogs-entry highlighted">
		<img src="${response.smallImageURL}?width=540" />

		<#if getterUtil.getBoolean(show_topic_label.data)>
			<span class="blogs-category ${(response.blog.categoryProperties.cssClass)!"dxp-primary-color"}">
				${response.topic.categoryName}
			</span>
		</#if>

		<h3>
			${response.title}
		</h3>

		<div class="blogs-entry-description">
			${response.description}
		</div>
	</div>
</#macro>

<#macro do_blogs_localization_tile response>
	<div class="block block-container blogs-entry localization-tile tile w33">
		<div class="align-center block-container border-bottom border-left border-right border-top element-border justify-center large-padding-vertical localization-tile-content">

			<svg height="140" width="140"><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#language"></use></svg>

			<h3 class="blog-title">
				${lang.localize("blogs_from_around_the_world", "Blogs from Around the World")}
			</h3>

			<select class="blogs-region-select" onChange="window.location.href=this.value">
				<option disabled="disabled" selected="true">${lang.localize("switch_locales", "Switch Locales")}</option>

				<#list response.regions as region>
					<#if stringUtil.contains(displayed_regions.data, region.urlCategoryName)>
						<option value="${get_region_link(region)}"><@liferay.language key=region.categoryProperties.country/></option>
					</#if>
				</#list>
			</select>
		</div>
	</div>
</#macro>

<#macro do_blogs_load_more response resource_url fewer=0>
	<#if response.end < response.count>
		<div class="load-more section-padding text-center">
			<a class="btn" data-count="${response.count}" data-end="${response.end - fewer}" data-href="${resource_url}" data-start="${response.start}" href="javascript:;" onclick="blogsController._loadMore(this)">${lang.localize("view_more", "View More")}</a>
		</div>
	</#if>
</#macro>

<#macro do_blogs_navigation response>
	<#assign url = get_blog_post_link(response)>

	<nav class="navigation standard-padding">
		<div class="nav-bar-mobile">
			<@social_icons/>

			<div class="class-toggle mobile-nav-button" data-target-class="nav-open" data-target-nodes=".navigation" >
				<svg height="44" width="40"><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#moreIcon"></use></svg>
			</div>
		</div>

		<div class="nav-content">
			<div class="nav-promo nav-section small-padding-vertical">
				<#assign subscription_form = get_subscription_form((response.blog.categoryProperties.hubspot_subscription_property_name)!) />

				<#if subscription_form?has_content>
					<h5 class="alt-font-color small-caps">
						${lang.localize("get_the_best_x_delivered_weekly", "Keep your {0} relevant", response.blog.categoryName)}
					</h5>

					<div class="small-padding-vertical" id="nav-subscribe-form-container">
						${subscription_form}
					</div>
				</#if>
			</div>

			<#if response.siblingCategories?size gt 1>
				<div class="nav-section small-padding-vertical">
					<h5 class="alt-font-color small-caps">
						${response.blog.categoryName} ${lang.localize("categories", "Categories")}
					</h5>

					<ul class="unstyled">
						<#list response.siblingCategories as sibling_category>
							<#if !sibling_category.categoryProperties.draft?has_content>
								<li class="small-padding-vertical"> <a class="blogs-sibling-link" href="${get_sibling_topic_link(response,sibling_category)}">${sibling_category.categoryName}</a> </li>
							</#if>
						</#list>
					</ul>
				</div>
			</#if>

			<#if response.tags?size gt 0>
				<div class="nav-section small-padding-vertical">
					<h5 class="alt-font-color small-caps">
						${lang.localize("tags", "Tags")}
					</h5>

					<#list response.tags as tag>
						<a class="blogs-tag-link" href="${get_tag_link(response,tag)}">${tag}</a><#if tag != response.tags?last>,</#if>
					</#list>
				</div>
			</#if>

			<#if stringUtil.split(displayed_regions.data)?size gt 1>
				<div class="nav-section small-padding-vertical">
					<h5 class="alt-font-color small-caps">
						${lang.localize("blogs_from_around_the_world", "Blogs from Around the World")}
					</h5>

					<select class="blogs-region-select" onchange="location.href=this.value">
						<option disabled="disabled" selected="true">${lang.localize("switch_locales", "Switch Locales")}</option>

						<#list response.regions as region>
							<#if stringUtil.contains(displayed_regions.data, region.urlCategoryName)>
								<option value="${get_region_link(region)}"><@liferay.language key=region.categoryProperties.country/></option>
							</#if>
						</#list>
					</select>
				</div>
			</#if>

			<div class="hidden-phone hidden-tablet">
				<h5 class="alt-font-color small-caps">
					${lang.localize("share_this_post", "Share this post")}
				</h5>

				<@social_icons/>
			</div>
		</div>
	</nav>
</#macro>

<#macro do_blogs_overview response resource_url>
	<#assign blog_level_response = response.blog??>
	<#assign topic_level_response = response.topic??>
	<#assign region_level_response = !blog_level_response && !topic_level_response>

	<#if response.entries?? && response.entries?size gt 0>
		<#assign overviewCSSClass = "blogs-overview">

		<#if region_level_response>
			<#assign overviewCSSClass = "blogs-root-overview">
		</#if>

		<div class="${overviewCSSClass}">
			<@do_blogs_entry_banner response.entries[0] />

			<div class="blogs-search max-full standard-padding">
				<form action="#" class="align-center block-container">
					<svg height="40" width="32"><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#searchIcon"></use></svg>
					<input onkeypress="blogsController._search(event)" placeholder="${lang.localize("search_all_blogs", "Search All Blogs")}" type="text"  />
				</form>
			</div>

			<#assign extra_tiles = 0>

			<#if region_level_response>
				<@do_blogs_subcategories response />
			</#if>

			<div class="block-container blogs-entries justify-center max-full">
				<#if response.entries?size gt 1>
					<#list response.entries[1..] as blog_entry>
						<#if (blog_entry.blogsEntryId)??>
							<@do_blogs_entry blog_entry />

							<#assign subscription_form = get_subscription_form((response.blog.categoryProperties.hubspot_subscription_property_name)!) />

							<#if (subscription_form?has_content && !region_level_response && ((blog_entry_index == 1) || (response.entries?size lt 3 && !blog_entry_has_next)))>
								<@do_blogs_subscribe_tile response subscription_form />

								<#assign extra_tiles = extra_tiles + 1>
							</#if>

							<#if (blog_entry_index == 3) && (stringUtil.split(displayed_regions.data)?size gt 1)>
								<@do_blogs_localization_tile response />

								<#if !region_level_response>
									<#assign extra_tiles = extra_tiles + 1>
								</#if>
							</#if>

							<#if (blog_entry_index + extra_tiles) == 8>
								<#break>
							</#if>
						</#if>
					</#list>

					<#if (response.entries?size lt 5) && (stringUtil.split(displayed_regions.data)?size gt 1)>
						<@do_blogs_localization_tile response />
					</#if>
				</#if>
			</div>
		</div>

		<@do_blogs_load_more response resource_url extra_tiles/>
	<#else>
		<h3 class="standard-padding">
			${lang.localize("no_blog_results", "No blog entries were found!")}
		</h3>
	</#if>
</#macro>

<#macro do_blogs_post response>
	<#if response?has_content && !response.error?has_content>
		<div class="blogs-entry">
			<div class="align-center block-container blogs-banner justify-center main-banner no-padding" style="background-image: url(${response.smallImageURL!}); background-size: cover;">
				<div class="banner-overlay"></div>

				<div class="align-center block-container justify-center main-banner-content max-full no-margin w100">
					<div class="banner-content light-color max-md no-margin no-padding text-center">
						<#if getterUtil.getBoolean(show_topic_label.data)>
							<p class="small-caps">
								${response.topic.categoryName}
							</p>
						</#if>

						<h1 class="small-padding-vertical">${response.title!}</h1>

						<div class="blogs-entry-author">${lang.localize("by", "by")} ${response.userName!}</div>

						<#assign date_tool = objectUtil("org.apache.velocity.tools.generic.DateTool")>
						<#assign display_date = date_tool.toDate("yyyy-MM-dd HH:mm:ss", response.displayDate)! />

						<#if !display_date?has_content>
							<#assign display_date = date_tool.toDate("EEE MMM dd HH:mm:ss z yyyy", response.displayDate)! />
						</#if>

						<#if display_date?has_content>
							<div class="blogs-entry-display-date">${lang.localize("on", "on")} ${date_tool.format("long_date", display_date, locale)}</div>
						</#if>
					</div>
				</div>
			</div>

			<div class="scroll-nav-content-container">
				<div class="blogs-nav scroll-nav">
					<div class="navigation-wrapper">
						<@do_blogs_navigation response />
					</div>
				</div>

				<div class="blogs-content clearfix content-wrapper long-form section-padding">
					<div class="standard-padding-horizontal">
						${response.content!}
					</div>
				</div>
			</div>

			<div class="blogs-author-info"></div>

			<div class="block-container blogs-related justify-center max-full">

				<#list response.relatedEntries as related_blog_entry>
					<#if related_blog_entry_index == 3>
						<#break>
					</#if>

					<@do_blogs_entry related_blog_entry />
				</#list>
			</div>

			<div class="blogs-comments">
				<h5 class="alt-font-color small-caps text-center">${lang.localize("comments", "Comments")}</h5>

				<div class="max-med" id="disqus_thread"></div>
			</div>
		</div>
	<#else>
		<h3 class="standard-padding">
			${lang.localize("no_blog_post_found", "Sorry, that blog post was not found!")}
		</h3>
	</#if>
</#macro>

<#macro do_blogs_search_results response keywords resource_url>
	<#if keywords?has_content>
		<div class="results-text text-center">
			<h3>${lang.localize("showing_results_for_x", "Showing results for <em>{0}<em>", htmlUtil.escape(keywords))}</h3>
		</div>
	</#if>

	<div class="block-container blogs-entries justify-center max-full">
		<#list response.entries as blog_entry>
			<#if (blog_entry.blogsEntryId)??>
				<@blog_templates.do_blogs_entry blog_entry />
			</#if>
		</#list>
	</div>

	<@blog_templates.do_blogs_load_more response resource_url />
</#macro>

<#macro do_blogs_subcategories response >
	<div class="block-container justify-center max-full subcategories">
		<#list response.rootCategories as category>
			<#assign category_svg_macro_id = (category.categoryProperties.svgId)!"digitalStrategy" />

			<#assign category_svg_macro_id = "render_" + category_svg_macro_id?string + "_svg" />

			<div class="align-center block block-container ${(category.categoryProperties.cssClass)!"dxp-primary-color"} blogs-promo blogs-subcategories tile">
				<div class="align-center block-container large-padding-vertical promo-content">
					<a class="parent-category" href="${get_blog_link(response.region,category)}">
						<#attempt>
							<@.vars[category_svg_macro_id]/>
						<#recover>
						</#attempt>

						<h3 class="blog-title">${category.categoryName}</h3>
					</a>

					<div class="blogs-overview-links standard-padding">
						<#list category.entries as blog_entry>
							<#if (blog_entry.blogsEntryId)??>
								<a class="blog-entry-link" data-blogs-entry-id="${blog_entry.blogsEntryId}" href="${get_blog_post_link(blog_entry)}" >
									<h4 class="title">${blog_entry.title}</h4>
								</a>
								<hr class="blog-entry-link-line">
							</#if>
						</#list>
					</div>

					<a class="blogs-category-link cta cta-alt cta-thin standard-padding-vertical" href="${get_blog_link(response.region,category)}">
						${lang.localize("view_all_x_posts", "View all {0} posts", category.categoryName)} <svg class="cta-icon" height="10" width="8"><use xlink:href="#caret" /></svg>
					</a>
				</div>
			</div>
		</#list>
	</div>
</#macro>

<#macro do_blogs_subscribe_tile response subscription_form>
	<div class="align-center block block-container blogs-entry blogs-subscription-form-tile tile w33">
		<div class="blog-subscription-form-container border-bottom border-left border-right border-top element-border large-padding-vertical standard-padding-horizontal">
			<svg height="44" width="69"><use class="${(response.blog.categoryProperties.cssClass)!""}" xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#envelope"></use></svg>

			<h3 class="${(response.blog.categoryProperties.cssClass)!""}">
				${lang.localize("get_the_best_of_x_delivered_weekly", "Get the best of {0} delivered weekly!", response.blog.categoryName)}
			</h3>

			<div class="blogs-subscribe-form standard-padding" id="subscribe-form-container">${subscription_form}</div>

			<p class="alt-font-color no-margin">${lang.localize("we_will_not_spam", "We won't spam you & unsubscribing is easy.")}</p>
		</div>
	</div>
</#macro>

<#macro render_customerExperience_svg>
	<svg class="standard-padding-vertical" height="80" width="110" viewBox="-2 -2 101 80" id="customerExperience">
		<style>
			.parent-category:hover #acquisition{-webkit-transform:translate(20%,-30%);transform:translate(20%,-30%);-moz-transform:translate(5%,-6%)}.parent-category:hover #engagement{-webkit-transform:scale(1.1) translate(20%,30%);transform:scale(1.1) translate(20%,30%);-moz-transform:translate(5%,6%);-webkit-transition-delay:0.1s;transition-delay:0.1s}.parent-category:hover #conversion{-webkit-transform:translate(-20%,30%);transform:translate(-20%,30%);-moz-transform:translate(-5%,6%);-webkit-transition-delay:0.2s;transition-delay:0.2s}#ping{opacity:0;-webkit-transform:scale(0);transform:scale(0)}.parent-category:hover #ping{-webkit-animation:ping-lg 1.5s cubic-bezier(0.25,0.25,0.115,1.445) forwards;animation:ping-lg 1.5s cubic-bezier(0.25,0.25,0.115,1.445) forwards}@-webkit-keyframes ping-lg{0%{-webkit-transform:scale(0);transform:scale(0);opacity:0.5}100%{-webkit-transform:scale(1.3);transform:scale(1.3);opacity:0}}@keyframes ping-lg{0%{-webkit-transform:scale(0);transform:scale(0);opacity:0.5}100%{-webkit-transform:scale(1.3);transform:scale(1.3);opacity:0}}.parent-category:hover .icon-element,.icon-element{-webkit-transform-origin:center;transform-origin:center;vector-effect:non-scaling-stroke}.stroke{opacity:0.8;stroke-linecap:round;stroke-linejoin:round;stroke-width:2}.bounce{transition:all 0.7s cubic-bezier(0.25,0.25,0.115,1.445)}.parent-category:hover .blog-title{-webkit-transform:translateY(0.1em);transform:translateY(0.1em);-webkit-transition:all 0.3s ease;transition:all 0.3s ease}
		</style>
		<g fill="none" fill-rule="evenodd">
			<circle class="bounce icon-element" id="ping" fill="rgba(84,73,136,1.0)" cx="51" cy="36" r="32" />
			<circle fill="rgba(212,214,223,0.4)" cx="51" cy="36" r="32" />
			<circle fill="rgba(212,214,223,0.4)" cx="51" cy="36" r="24" />
			<circle fill="rgba(212,214,223,0.6)" cx="51" cy="36" r="16" />
			<path id="customer-body" opacity=".8" fill="#443B6E" d="M51 33c-4.417 0-8 3.775-8 8.434V45h16v-3.566C59 36.775 55.419 33 51 33z" />
			<path id="customer-head" opacity=".8" fill="#443B6E" d="M56 30a5 5 0 1 1-10 0 5 5 0 0 1 10 0z" />
			<g stroke="#443B6E">
				<path class="bounce icon-element stroke" id="acquisition" d="M30 67l-9-1 16-9-3 18z" />
				<path class="bounce icon-element stroke" id="conversion" d="M74.6 23.1c-2.1-2.1-2.1-5.5 0-7.5s5.5-2.1 7.5 0c2.1-2.1 5.5-2.1 7.5 0 2.1 2.1 2.1 5.5 0 7.5l-7.5 7.5-7.5-7.5z" />
				<path class="bounce icon-element stroke" id="engagement" d="M30 8H14v8h4l8 5v-5h4z" />
			</g>
		</g>
	</svg>
</#macro>

<#macro render_digitalStrategy_svg>
	<svg xmlns="http://www.w3.org/2000/svg" viewBox="-2 -2 90 60" id="digitalStrategy" class="standard-padding-vertical" height="80" width="110">
		<style type="text/css">
			.parent-category:hover #graph{-webkit-transform:scaleY(0.7);transform:scaleY(0.7)}#graph{-webkit-transform-origin:bottom;transform-origin:bottom;-moz-transform-origin:100% 85%}.parent-category:hover #line,.parent-category:hover .point{-webkit-transform:translateY(-0.3em);transform:translateY(-0.3em)}.point{fill:none;stroke:rgba(45,119,122,0.9);stroke-width:2}.parent-category:hover .point{-webkit-animation:ping-sm 0.5s cubic-bezier(0.66,0,0,1) forwards;animation:ping-sm 0.5s cubic-bezier(0.66,0,0,1) forwards;stroke:rgba(84,73,136,0)}@-webkit-keyframes ping-sm{0%{stroke-width:0}60%{stroke:rgba(45,119,122,0.4);stroke-width:4}100%{stroke:rgba(45,119,122,0.9);stroke-width:2}}@keyframes ping-sm{0%{stroke-width:0}60%{stroke:rgba(45,119,122,0.4);stroke-width:4}100%{stroke:rgba(45,119,122,0.9);stroke-width:2}}.parent-category:hover #one{-webkit-animation-delay:0.1s;animation-delay:0.1s}.parent-category:hover #two{-webkit-animation-delay:0.2s;animation-delay:0.2s}.parent-category:hover #three{-webkit-animation-delay:0.3s;animation-delay:0.3s}.parent-category:hover #four{-webkit-animation-delay:0.4s;animation-delay:0.4s}.stroke{opacity:0.8;stroke-linecap:round;stroke-linejoin:round;stroke-width:2}.bounce{transition:all 0.7s cubic-bezier(0.25,0.25,0.115,1.445)}.parent-category:hover .blog-title{-webkit-transform:translateY(0.1em);transform:translateY(0.1em);-webkit-transition:all 0.3s ease;transition:all 0.3s ease}
		</style>
		<rect id="frame" x="8" y="1" width="70" height="54" rx="6" ry="6" fill="none" stroke="#D4D6DF" stroke-width="2" opacity=".5" />
		<rect id="screen" x="11" y="4" width="64" height="48" rx="4" ry="4" fill="#d4d6df" opacity=".5" />
		<path class="bounce" id="graph" fill="rgba(163,215,217,.8)" d="M11 27c9.7 0 4.6-17.8 12-17.8s1.6 22 9.5 22S36.1 20.7 43 20.6s3.1 23.8 10.7 23.8 3.9-13.2 10.5-13.2S68.8 14 75 14v34a4 4 0 0 1-4 4H15a4 4 0 0 1-4-4z" />
		<path class="bounce stroke" id="line" d="M3 47l20-14 20 4 20-16L83 9" fill="none" stroke="#38959A" />
		<circle class="bounce point" cx="3" cy="47" r="2" />
		<circle class="bounce point" id="one" cx="23" cy="33" r="2" />
		<circle class="bounce point" id="two" cx="43" cy="37" r="2" />
		<circle class="bounce point" id="three" cx="63" cy="21" r="2" />
		<circle class="bounce point" id="four" cx="83" cy="9" r="2" />
	</svg>
</#macro>

<#macro render_liferayTechnology_svg>
	<svg class="standard-padding-vertical" height="80" id="liferayTechnology" viewBox="-10 -10 76 76" width="80" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" >
		<title>Liferay Icon</title>
		<defs>
				<rect id="portlet" width="8" height="8" fill="white" rx=".25" />
		</defs>
		<rect class="lr-icon" x="4" y="4" width="48" height="48" fill="#d4d6df" opacity=".5" rx="4" />
		<use x="09" y="09" xlink:href="#portlet" />
		<use x="19" y="09" xlink:href="#portlet" />
		<use x="29" y="09" xlink:href="#portlet" />
		<use x="09" y="19" xlink:href="#portlet" />
		<use x="19" y="19" xlink:href="#portlet" />
		<use x="39" y="19" xlink:href="#portlet" />
		<use x="09" y="29" xlink:href="#portlet" />
		<use x="29" y="29" xlink:href="#portlet" />
		<use x="39" y="29" xlink:href="#portlet" />
		<use x="19" y="39" xlink:href="#portlet" />
		<use x="29" y="39" xlink:href="#portlet" />
		<use x="39" y="39" xlink:href="#portlet" />
	</svg>
</#macro>

<#macro social_icons>
	<div class="social-icons">
		<a aria-label="Share on Facebook" class="share-facebook social-icon" href="https://facebook.com/sharer/sharer.php?u=${base_url + url}" target="_blank"><i class="icon icon-facebook"></i></a>
		<a aria-label="Share on LinkedIn" class="share-linkedin social-icon" href="https://www.linkedin.com/shareArticle?mini=true&amp;url=${base_url + url}&amp;title=&amp;summary=&amp;source=${base_url + url}" target="_blank"><i class="icon icon-linkedin"></i></a>
		<a aria-label="Share on Twitter" class="share-twitter social-icon" href="https://twitter.com/intent/tweet/?url=${base_url + url}" target="_blank"><i class="icon icon-twitter"></i></a>
	</div>
</#macro>