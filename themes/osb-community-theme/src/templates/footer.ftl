<footer id="footer" role="contentinfo">
	<div class="block-container footer-content justify-space-between max-full">
		<#if theme.getSetting("footer-navigation-friendly-url")?has_content>
			<#assign footer_navigation_layout = layout_local_service.fetchLayoutByFriendlyURL(group_id, false, theme.getSetting("footer-navigation-friendly-url"))! />

			<#if footer_navigation_layout?has_content>
				<div class="block-container navigation no-padding">
					<#list footer_navigation_layout.getChildren(permissionChecker) as footer_navigation_item>
						<div class="block">
							<@print_navigation_item nav_layout=footer_navigation_item tag="h4" />

							<@print_navigation nav_layouts=footer_navigation_item.getChildren(permissionChecker) />
						</div>
					</#list>
				</div>
			</#if>
		</#if>

		<div class="company-info">
			<#if footer_social_media_article_id?has_content>
				<div class="social-nav">
					${theme.runtime("56", "articleId=" + footer_social_media_article_id)}
				</div>
			</#if>

			<#if footer_contact_article_id?has_content>
				<div class="contact-info">
					${theme.runtime("56", "articleId=" + footer_contact_article_id)}
				</div>
			</#if>
		</div>
	</div>

	<div class="element-background fine-print">
		<div class="block-container justify-space-between max-full">
			<p class="block powered-by">
				<@liferay_ui.message key="powered-by-liferay" />
			</p>

			<p class="block copyright">
				&copy; ${the_year} Liferay Inc. <@liferay.language key="all-rights-reserved" />
			</p>

			<a class="block privacy-policy" href="/privacy-policy">
				<@liferay_ui.message key="privacy-policy" />
			</a>
		</div>
	</div>
</footer>