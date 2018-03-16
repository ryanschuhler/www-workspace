<#assign service_context = objectUtil("com.liferay.portal.kernel.service.ServiceContextThreadLocal").getServiceContext() />
<#assign http_servlet_request = service_context.getRequest() />

<#assign current_url = htmlUtil.escapeURL(portalUtil.getCurrentCompleteURL(http_servlet_request)) />

<#assign summary_text = "" />

<#macro social_icons>
	<a aria-label="Share on Facebook" class="share-facebook social-icon" href="https://facebook.com/sharer/sharer.php?u=${current_url}" target="_blank"><span class="icon icon-facebook"></span></a>
	<a aria-label="Share on LinkedIn" class="share-linkedin social-icon" href="https://www.linkedin.com/shareArticle?mini=true&url=${current_url}&title=${htmlUtil.escapeURL(summary_text)}&summary=${htmlUtil.escapeURL(summary_text)}&source=${current_url}" target="_blank"><span class="icon icon-linkedin"></span></a>
	<a aria-label="Share on Twitter" class="share-twitter social-icon" href="https://twitter.com/intent/tweet/?url=${current_url}" target="_blank"><span class="icon icon-twitter"></span></a>
</#macro>

<div class="navigation-wrapper">
	<nav class="navigation">
		<div class="nav-bar-mobile">
			<div class="social-icons">
				<@social_icons />
			</div>

			<div class="class-toggle mobile-nav-button" data-target-class="nav-open" data-target-nodes=".navigation">
				<svg height="44" width="40"><use xlink:href="#moreIcon"></use></svg>
			</div>
		</div>

		<div class="nav-content">
			<#if categories.data?has_content>
				<h4 class="nav-heading small-padding-vertical">Defining Digital</h4>

				<#list categories.siblings as category>
					<div class="nav-section small-padding-vertical">
						<h5 class="alt-font-color small-caps">${category.data}</h5>

						<#if category.articles.data?has_content>
							<ul class="unstyled">
								<#list category.articles.siblings as article>
									<#assign article_href = "/resources/l/" + article.url_title.data />

									<li class="small-padding-vertical">
										<a href="${article_href}">${article.data}</a>
									</li>
								</#list>
							</ul>
						</#if>
					</div>
				</#list>
			</#if>

			<div class="nav-section share small-padding-vertical">
				<h5 class="alt-font-color small-caps">Share This Article</h5>

				<div class="small-padding-vertical social-icons">
					<@social_icons />
				</div>
			</div>

			<#if nav_ad.data?has_content>
				<div class="nav-section small-padding-vertical">
					<#if nav_ad.ad_label.data?has_content>
						<h5 class="alt-font-color small-caps">${nav_ad.ad_label.data}</h5>
					</#if>

					<a class="cta ${nav_ad.ad_text_color.data} small-padding-vertical" href="${nav_ad.url.data}">
						<div class="block-container micro-banner" style="background-image: url(${nav_ad.data?string})">
							<div class="text">
								${nav_ad.text.data}
							</div>

							<span href="${nav_ad.url.data}">
								${nav_ad.cta.data} <svg class="cta-icon" height="10" width="8"><use xlink:href="#caret"></use></svg>
							</span>
						</div>
					</a>
				</div>
			</#if>
		</div>
	</nav>
</div>

<script type="text/javascript">
	AUI().ready(
		'node',
		'scroll-nav',
		function(A) {
			new A.ScrollNav(
				{
					alignNode: '.long-form'
				}
			).render();
		}
	);
</script>