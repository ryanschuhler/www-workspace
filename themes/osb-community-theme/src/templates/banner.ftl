<header id="banner" role="banner">
	<div class="align-center banner-section block-container justify-space-between main-banner-section no-padding">
		<a class="doc-heading" href="/">
			<svg viewBox="0 0 160 37">
				<use xlink:href="#liferayLogo-liferay"></use>
				<use class="light-fill" xlink:href="#liferayLogo-gradientLightest"></use>
				<use class="logo-border" xlink:href="#liferayLogo-logoBorder"></use>
				<use class="logo-gradient-light" xlink:href="#liferayLogo-gradientLight"></use>
				<use class="logo-gradient-dark" xlink:href="#liferayLogo-gradientDark"></use>
				<use class="logo-gradient-darkest" xlink:href="#liferayLogo-gradientDarkest"></use>
			</svg>
		</a>

		<nav aria-label='<@liferay_ui.message key="site-pages" />' class="banner-section hidden-phone" id="mainNavigation" role="navigation">
			<@print_navigation css_class="block-container no-padding" nav_layouts=layouts />
		</nav>

		<#if custom_navigation_article_id?has_content>
			<#assign void=freeMarkerPortletPreferences.setValue("portletSetupShowBorders", "false")>
			<#assign void=freeMarkerPortletPreferences.setValue("articleId",custom_navigation_article_id)>
			${theme.runtime("56_INSTANCE_NAVIGATION", "", freeMarkerPortletPreferences.toString())}
			<#assign void=freeMarkerPortletPreferences.reset()>
		</#if>
	</div>

	<#if layout_sections?has_content || !layout.isRootLayout()>
		<#assign ancestorLayout = layout_local_service.fetchLayout(layout.getAncestorPlid()) />

		<div class="align-center banner-section block-container child-nav no-padding ${ancestorLayout.isRootLayout()?string('justify-space-between', 'justify-end')}" id="childNavigation">
			<#if ancestorLayout.isRootLayout()>
				<div class="secondary-nav-wrapper" id="secondaryNavigation">
					<nav aria-label="<@liferay_ui.message key="site-pages" />" role="navigation">
						<@print_navigation css_class="block-container no-padding" nav_layouts=ancestorLayout.getChildren(permissionChecker) />
					</nav>
				</div>

				<a class="hide small-padding" href="javascript:;" id="rightScrollCaret" onClick="AUI().one('#secondaryNavigation nav')._node.scrollLeft += 100">
					<svg height="10" width="8"><use xlink:href="#caret" /></svg>
				</a>
			</#if>

			<#if layout_sections?? && (layout_sections?size > 0)>
				<div class="section-nav" id="sectionNavigation">
					<a class="align-center block-container class-toggle" data-target-class="show-section-nav" data-target-nodes="#childNavigation" data-toggle-type="offclick" href="javascript:;" id="sectionNavToggle">
						<svg height="44" width="40"><use xlink:href="#moreIcon" /></svg>

						<#if layout_sections_label??>
							<span>${layout_sections_label}</span>
						</#if>
					</a>

					<ul class="block-container class-toggle-content no-padding section-dropdown" role="menubar">
						<#list layout_sections as section>
							<#assign section_info = stringUtil.split(section, "::")! />

							<#assign section_name = "" />

							<#if section_info[0]?has_content>
								<#assign section_name = section_info[0] />
							</#if>

							<#assign section_href = "" />

							<#if section_info[1]?has_content>
								<#assign section_href = section_info[1] />
							</#if>

							<#assign section_attrs = "" />

							<#if section_info[2]?has_content>
								<#assign section_attrs = section_info[2] />
							</#if>

							<#assign element_id = stringUtil.replace(section_name, " ", "-") />
							<#assign element_id = stringUtil.lowerCase(element_id) />

							<li class='nav-item nav-item-${section_index + 1}' data-page-section="${htmlUtil.escape(element_id)}" role="presentation">
								<a aria-labelledby="section_${section_index + 1}" class="animate-scroll" data-offset="45" href="${htmlUtil.escape(section_href)}" role="menuitem" ${htmlUtil.escape(section_attrs)}>
									${htmlUtil.escape(section_name)}
								</a>
							</li>
						</#list>
					</ul>
				</div>
			</#if>
		</div>
	</#if>
</header>

<div class="show-account-links show-verification-message" id="sideMenu">
	<#assign show_verification_notification = false />
	<#assign target_class = "show-account-links" />

	<#if (dateUtil.getDaysBetween(user.getCreateDate(), dateUtil.newDate(), timeZoneUtil.getTimeZone("UTC")) < 90) >
		<#assign verified_user_group = user_group_local_service.fetchUserGroup(company_id, "verified user")! />

		<#if verified_user_group?has_content && !user_local_service.hasUserGroupUser(verified_user_group.getUserGroupId(), user.getUserId()) >
			<#assign show_verification_notification = true />
			<#assign target_class = "show-verification-message" />
		</#if>
	</#if>

	<a class="class-toggle menu-toggle" data-offclick-content="#sideMenu .class-toggle-content" data-target-class="show-side-nav" data-target-nodes="body" data-toggle-type="offclick" href="javascript:;" id="menuToggle">
		<svg height="24" stroke="currentColor" stroke-miterlimit="10" stroke-width="1.5" viewbox="0 0 24 24" width="24">
			<line class="nav-line nav-line-top" x1="0" x2="24" y1="4" y2="4" />
			<line class="nav-line nav-line-center" x1="0" x2="24" y1="12" y2="12" />
			<line class="nav-line nav-line-bottom" x1="0" x2="24" y1="20" y2="20" />
		</svg>

		<#if show_verification_notification && is_signed_in>
			<span class="notification"></span>
		</#if>
	</a>

	<div class="class-toggle-content">
		<div class="account alt-secondary-background">
			<#if is_signed_in>
				<div class="account-user align-center block-container no-padding">
					<span class="account-avatar-wrapper class-toggle" data-target-class="${target_class}" data-target-nodes="#sideMenu" href="javascript:;">
						<img alt='<@liferay_ui.message key="avatar" />' class="account-avatar img-circle" src="${user.getPortraitURL(themeDisplay)}" />

						<#if show_verification_notification>
							<span class="notification"></span>
						</#if>
					</span>

					<a aria-labelledby="<@liferay_ui.message arguments="${htmlUtil.escape(user_first_name)}" key="hi-x" />" class="class-toggle" data-target-class="show-account-links" data-target-nodes="#sideMenu" href="javascript:;">
						<span class="welcome-text"><@liferay_ui.message arguments="${htmlUtil.escape(user_first_name)}" key="hi-x" /></span>

						<svg class="more-links" height="10" width="8"><use xlink:href="#caret" /></svg>
					</a>
				</div>

				<#if show_verification_notification>
					<div class="light-color secondary-background verification-prompt">
						<div class="prompt-body">
							<h4 class="standard-padding-vertical"><@liferay_ui.message key="verify-your-email-address" /></h4>

							<p class="prompt-message">
								<@liferay_ui.message key="in-order-to-fight-spam-within-our-community-we-are-requesting-that-you-verify-your-email-address-in-order-to-contribute-review-and-post-to-the-liferay-community" />
							</p>

							<#assign verification_url = httpUtil.addParameter(theme.getSetting("verification-url"), "uuid", user.getUuid()) />

							<div class="align-center block-container no-padding small-padding-vertical">
								<a class="btn btn-light verify-user-btn" data-verification-url='${verification_url}' href="javascript:;"><@liferay_ui.message key="send-verification-email" /></a>

								<a class="class-toggle dismiss-btn font-weight-bold" data-target-class="show-verification-message" data-target-nodes="#sideMenu" href="javascript:;">
									<@liferay_ui.message key="dismiss" />
								</a>
							</div>
						</div>

						<div class="hide prompt-success-msg standard-padding-vertical">
							<p>
								<@liferay_ui.message key="thank-you-a-verification-email-has-been-sent" />
							</p>

							<a class="dismiss-btn dismiss-msg font-weight-bold" href="javascript:;"><@liferay_ui.message key="dismiss" /></a>
						</div>

						<div class="hide prompt-failure-msg standard-padding-vertical">
							<p>
								<@liferay_ui.message key="sorry,-we-were-not-able-to-access-the-server" />
							</p>

							<a class="dismiss-btn dismiss-msg font-weight-bold" href="javascript:;"><@liferay_ui.message key="dismiss" /></a>
						</div>
					</div>
				</#if>

				<ul class="account-links">
					<li><a href="/web/${htmlUtil.escape(user.getScreenName())}/home"><@liferay_ui.message key="account-home" /></a></li>

					<#if theme.getSetting("sites-user-group-ids")?has_content>
						<#list stringUtil.split(theme.getSetting("sites-user-group-ids")) as site_user_group_id>
							<#assign user_group = user_group_local_service.fetchUserGroup(getterUtil.getLong(site_user_group_id))! />

							<#if user_group?has_content>
								<#assign user_group_expando_bridge = user_group.getExpandoBridge() />

								<#assign label = user_group.getName() />

								<#if user_group_expando_bridge.hasAttribute("label")>
									<#assign user_group_table = expando_table_local_service.getTable("com.liferay.portal.model.UserGroup", "CUSTOM_FIELDS")! />

									<#assign label_column = expando_column_local_service.getColumn(user_group_table.getTableId(), "label")! />

									<#assign user_group_label = expando_value_local_service.getValue(user_group_table.getTableId(), label_column.getColumnId(), user_group.getUserGroupId())!"" />

									<#if user_group_label.getString(locale)?has_content>
										<#assign label = user_group_label.getString(locale) />
									</#if>
								</#if>

								<#if user_group_expando_bridge.hasAttribute("link")>
									<#assign link_column = expando_column_local_service.getColumn(user_group_table.getTableId(), "link")! />

									<#assign user_group_link = expando_value_local_service.getValue(user_group_table.getTableId(), link_column.getColumnId(), user_group.getUserGroupId())!"" />
								</#if>

								<#if user_group_expando_bridge.hasAttribute("included_user_group_ids")>
									<#assign included_user_group_ids = stringUtil.split(user_group_expando_bridge.getAttribute("included_user_group_ids")!) />
								</#if>

								<#if user_group_link.getString()?has_content && (user_local_service.hasUserGroupUser(user_group.getUserGroupId(), user.getUserId()) || is_user_group_member(included_user_group_ids)) >
									<li><a href="${user_group_link.getString()}">${label}</a></li>
								</#if>
							</#if>
						</#list>
					</#if>

					<li><a href="${sign_out_url + "?referer=" + themeDisplay.getURLCurrent()}">${sign_out_text}</a></li>
				</ul>
			<#else>
				<a aria-labelledby="<@liferay_ui.message key="sign-in-create-account" />" class="account-user align-center block-container no-padding" href="${sign_in_url}">
					<svg class="account-avatar"><use xlink:href="#defaultUserIcon" /></svg>

					<span class="welcome-text"><@liferay_ui.message key="sign-in-create-account" /></span>
				</a>
			</#if>
		</div>

		<div id="mainSearch">
			<#include "${full_templates_path}/search.ftl" />
		</div>

		<nav aria-label='<@liferay_ui.message key="site-pages" />' role="navigation">
			<div class="visible-xs">
				<@print_navigation nav_layouts=layouts />
			</div>

			<#if theme.getSetting("custom-navigation-friendly-url")?has_content>
				<#assign custom_layout = layout_local_service.getFriendlyURLLayout(group_id, false, theme.getSetting("custom-navigation-friendly-url"))! />

				<#if custom_layout?has_content>
					<div class="external-links">
						<@print_navigation nav_layouts=custom_layout.getChildren(permissionChecker) />
					</div>
				</#if>
			</#if>
		</nav>

<#--
TODO
		<div class="language">
			${taglibLiferay.language("", "", "languageId", 1)}
		</div>
-->

		<a class="nav-logo" href="/">
			<svg height="34" width="160">
				<use class="alt-font-fill" xlink:href="#liferayLogo-liferay"></use>
				<use class="alt-font-fill" xlink:href="#liferayLogo-gradientLightest"></use>
				<use class="font-fill" xlink:href="#liferayLogo-gradientLight"></use>
				<use class="font-fill" xlink:href="#liferayLogo-gradientDark"></use>
				<use class="font-fill" xlink:href="#liferayLogo-gradientDarkest"></use>
			</svg>
		</a>
	</div>
</div>