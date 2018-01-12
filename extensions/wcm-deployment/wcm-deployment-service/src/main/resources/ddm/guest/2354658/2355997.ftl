<#import "${templatesPath}/231368766" as article_utilities>

<style>
.about-content, .additional-about-content, .contact-info, .content, .default-about-content {
	padding-top: 0.5em;
}
</style>

<div class="press-release">
	<h1 class="primary-color small-padding-vertical">
		${heading.data}
	</h1>

	<#if subheading.data?has_content>
		<h2>
			${subheading.data}
		</h2>
	</#if>

	<div class="content">
		<#list stringUtil.splitLines(content.data) as line>
			<#if line?has_content>
				<p>${line}</p>
			</#if>
		</#list>
	</div>

	<div class="about-content">
		<div class="default-about-content">
			<@article_utilities.runtime_embed_journal_article "3774443" />
		</div>

		<div class="additional-about-content">
			<#if additional_about_content.data?has_content>
				${additional_about_content.data}
			</#if>
		</div>
	</div>

	<div class="contact-info">
		<h3>${languageUtil.get(locale, "contact")}</h3>

		<#if !contact_info.data?has_content >
			Liferay, Inc.<br />
			Rebecca Shin<br />
			1-877-LIFERAY<br />
			pr@liferay.com<br />
			Twitter: <a href="http://www.twitter.com/liferay">Liferay</a></p>
		<#else>
			<#list stringUtil.splitLines(contact_info.data) as line>
				<#if line?has_content>
					${line}<br />
				</#if>
			</#list>
		</#if>
	</div>
</div>