<#import "${templatesPath}/1561886" as lang>

<#assign current_url = httpUtil.getPath(request.attributes['CURRENT_URL']) />

<#assign base_url = request.scheme + "://" + request['server-name'] />

<#function get_region_link region>
	<#return "${current_url}/${region.urlCategoryName}">
</#function>

<#function get_blog_link region blog>
	<#return "${current_url}/${region.urlCategoryName}/${blog.urlCategoryName}">
</#function>

<#function get_blog_post_link blog_entry>
	<#return "${current_url}/${blog_entry.region.urlCategoryName}/${blog_entry.blog.urlCategoryName}/${blog_entry.urlTitle}">
</#function>

<#function get_tag_link response tag>
	<#return "${current_url}/${response.region.urlCategoryName}/${response.blog.urlCategoryName}/tag/${tag}">
</#function>

<#function get_blog_topic_link blog_entry>
	<#return "${current_url}/${blog_entry.region.urlCategoryName}/${blog_entry.blog.urlCategoryName}/category/${blog_entry.topic.urlCategoryName}">
</#function>

<#function get_sibling_topic_link blog_entry topic>
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
				<img src="${blog_entry.smallImageURL}?width=350" />
			</div>
		</a>

		<a class="blogs-category-link" href="${get_blog_topic_link(blog_entry)}">
			<div class="blogs-category ${(blog_entry.blog.categoryProperties.cssClass)!"dxp-primary-color"}">
				${blog_entry.topic.categoryName}
			</div>
		</a>

		<a class="blog-entry-link" href="${get_blog_post_link(blog_entry)}" >
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
	<div class="align-center block-container blogs-entry-banner justify-center main-banner no-padding" style="background-image: url(${banner_post.smallImageURL});">
		<div class="banner-overlay"></div>

		<div class="align-center block-container justify-center main-banner-content max-full no-margin w100">
			<div class="banner-content max-md no-margin no-padding text-center">
				<p class="light-color small-caps text-center">
					${banner_post.topic.categoryName}
				</p>

				<h1 class="light-color small-padding-vertical text-center w100">
					${banner_post.title}
				</h1>

				<a class="blogs-read-post-link btn btn-light" data-blogs-entry-id="${banner_post.blogsEntryId}" href="${get_blog_post_link(banner_post)}">${lang.localize("read-post", "Read Post")}</a>
			</div>
		</div>
	</div>
</#macro>

<#macro do_blogs_entry_highlighted response>
	<div class="blogs-entry highlighted">
		<img src="${response.smallImageURL}?width=540" />
		<span class="blogs-category ${(response.blog.categoryProperties.cssClass)!"dxp-primary-color"}">${response.topic.categoryName}</span>

		<h3>
			${response.title}
		</h3>

		<div class="blogs-entry-description">
			${response.description}
		</div>
	</div>
</#macro>

<#macro do_blogs_localization_tile response>
	<div class="block block-container blogs-entry tile w33">
		<div class="align-center block-container border-bottom border-left border-right border-top element-border justify-center large-padding-vertical">

			<svg height="140" width="140"><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#language"></use></svg>

			<div class="blogs-lang alt-font-color small-caps small-padding-vertical">
				${lang.localize("blogs-in-other-languages", "Blogs in Other Languages")}
			</div>

			<h3 class="blog-title">
				${lang.localize("practice-your-german-reading-comprehension", "Practice Your German Reading Comprehension")}
			</h3>

			<select class="blogs-region-select" onChange="window.location.href=this.value">
				<option disabled="disabled" selected="true">${lang.localize("choose-region", "Choose Region")}</option>

				<#list response.regions as region>
					<option value="${get_region_link(region)}">${region.categoryName}</option>
				</#list>
			</select>
		</div>
	</div>
</#macro>

<#macro do_blogs_load_more response resource_url fewer=0>
	<#if response.end < response.count>
		<div class="load-more section-padding text-center">
			<a class="btn" data-count="${response.count}" data-end="${response.end - fewer}" data-href="${resource_url}" data-start="${response.start}" href="javascript:;" onclick="blogsController._loadMore(this)">${lang.localize("view-more", "View More")}</a>
		</div>
	</#if>
</#macro>

<#macro do_blogs_navigation response subscription_form>
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

				<#if subscription_form?has_content>
					<h5 class="alt-font-color small-caps">
						${lang.localize("get-the-best-x-delivered-weekly", "Keep your {0} relevant", response.blog.categoryName)}
					</h5>

					<div class="small-padding-vertical" id="nav-subscribe-form-container">
						${subscription_form}
					</div>
				</#if>
			</div>

			<#if response.siblingCategories?size gt 0>
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

			<#if response.regions?size gt 1>
				<div class="nav-section small-padding-vertical">
					<h5 class="alt-font-color small-caps">
						${lang.localize("blogs-for-other-regions", "Blogs for other regions")}
					</h5>

					<select class="blogs-region-select" onchange="location.href=this.value">
						<option disabled="disabled" selected="true">${lang.localize("choose-region", "Choose Region")}</option>

						<#list response.regions as region>
							<option value="${get_region_link(region)}">${region.categoryName}</option>
						</#list>
					</select>
				</div>
			</#if>

			<div class="hidden-phone hidden-tablet">
				<h5 class="alt-font-color small-caps">
					${lang.localize("share-this-post", "Share this post")}
				</h5>

				<@social_icons/>
			</div>
		</div>
	</nav>
</#macro>

<#macro do_blogs_overview response subscription_form resource_url>
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
					<input onkeypress="blogsController._search(event)" placeholder="${lang.localize("search-all-blogs", "Search All Blogs")}" type="text"  />
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

							<#if (!region_level_response) && (blog_entry_index == 1) && subscription_form?has_content>
								<@do_blogs_subscribe_form response subscription_form />

								<#assign extra_tiles = extra_tiles + 1>
							</#if>

							<#if (blog_entry_index == 3) && (response.regions?size gt 1)>
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
				</#if>
			</div>
		</div>

		<@do_blogs_load_more response resource_url extra_tiles/>
	<#else>
		<h3 class="standard-padding">
			${lang.localize("no-blog-results", "No blog entries were found!")}
		</h3>
	</#if>
</#macro>

<#macro do_blogs_post response subscription_form>
	<#if response?has_content>
		<div class="blogs-entry">
			<div class="align-center block-container blogs-banner justify-center main-banner no-padding" style="background-image: url(${response.smallImageURL}); background-size: cover;">
				<div class="banner-overlay"></div>

				<div class="align-center block-container justify-center main-banner-content max-full no-margin w100">
					<div class="banner-content light-color max-md no-margin no-padding text-center">
						<p class="small-caps">${response.topic.categoryName}</p>

						<h1 class="small-padding-vertical">${response.title}</h1>

						<div class="blogs-entry-author">${lang.localize("by", "by")} ${response.userName}</div>

						<#assign date_tool = objectUtil("org.apache.velocity.tools.generic.DateTool")>
						<#assign date = date_tool.toDate("yyyy-MM-dd HH:mm:ss", response.displayDate, locale)! />

						<#if !date?has_content>
							<#assign date = date_tool.toDate("EEE MMM dd HH:mm:ss z yyyy", response.displayDate, locale)! />
						</#if>

						<#if date?has_content>
							<#assign display_date = dateUtil.getDate(date, "MMMMM dd, yyyy", locale)! />
						</#if>

						<#if display_date?has_content>
							<div class="blogs-entry-display-date">${lang.localize("on", "on")} ${display_date}</div>
						</#if>
					</div>
				</div>
			</div>

			<div class="scroll-nav-content-container">
				<div class="blogs-nav scroll-nav">
					<div class="navigation-wrapper">
						<@do_blogs_navigation response subscription_form/>
					</div>
				</div>

				<div class="blogs-content clearfix content-wrapper max-full section-padding">
					<div class="max-med">
						${response.content}
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
			${lang.localize("no-blog-post-found", "Sorry, that blog post was not found!")}
		</h3>
	</#if>
</#macro>

<#macro do_blogs_search_results response keywords resource_url>
	<#if keywords?has_content>
		<div class="results-text text-center">
			<h3>${lang.localize("showing-results-for", "Showing results for")} <em>${keywords}</em></h3>
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
			<div class="align-center block block-container ${(category.categoryProperties.cssClass)!"dxp-primary-color"} blogs-promo blogs-subcategories tile">
				<div class="align-center block-container promo-content large-padding-vertical">
					<svg class="standard-padding-vertical" height="80" width="110">
						<use class="blog-icon" xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#${(category.categoryProperties.svgId)!"digitalStrategy"}"></use>
					</svg>

					<h3 class="blog-title">${category.categoryName}</h3>

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
						${lang.localize("view-all-x-posts", "View all {0} posts", category.categoryName)} <svg class="cta-icon" height="10" width="8"><use xlink:href="#caret" /></svg>
					</a>
				</div>
			</div>
		</#list>
	</div>
</#macro>

<#macro do_blogs_subscribe_form response subscription_form>
	<div class="align-center block block-container blogs-entry blogs-subscription-form-tile tile w33">
		<div class="blog-subscription-form-container border-bottom border-left border-right border-top element-border large-padding-vertical standard-padding-horizontal">
			<svg height="44" width="69"><use class="envelope" xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#envelope"></use></svg>

			<h3 class="accent-color">${lang.localize("get-the-best-of-x-delivered-weekly", "Get the best of {0} delivered weekly!", response.blog.categoryName)}</h3>

			<div class="blogs-subscribe-form standard-padding" id="subscribe-form-container">${subscription_form}</div>

			<p class="alt-font-color no-margin">${lang.localize("we-will-not-spam", "We won't spam you and unsubscribing is easy")}</p>
		</div>
	</div>
</#macro>

<#macro social_icons>
	<div class="social-icons">
		<a aria-label="Share on Facebook" class="share-facebook social-icon" href="https://facebook.com/sharer/sharer.php?u=${base_url + url}" target="_blank"><i class="icon icon-facebook"></i></a>
		<a aria-label="Share on LinkedIn" class="share-linkedin social-icon" href="https://www.linkedin.com/shareArticle?mini=true&amp;url=${base_url + url}&amp;title=&amp;summary=&amp;source=${base_url + url}" target="_blank"><i class="icon icon-linkedin"></i></a>
		<a aria-label="Share on Twitter" class="share-twitter social-icon" href="https://twitter.com/intent/tweet/?url=${base_url + url}" target="_blank"><i class="icon icon-twitter"></i></a>
	</div>
</#macro>