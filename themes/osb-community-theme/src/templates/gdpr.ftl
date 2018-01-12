

<#assign osb_www_gdpr_accepted = getterUtil.getBoolean(request.getAttribute("OSB_WWW_GDPR_ACCEPTED"))>

<#if !osb_www_gdpr_accepted>
	<div class="cookie-acceptance">
		<div class="cookie-acceptance-container">
			<div class="cookie-acceptance-message">
				<div class="message-container">
					<@liferay.language_format arguments="/privacy-policy" key="cookie-acceptance-x" />
				</div>
			</div>

			<div class="button-wrapper">
				<a class="btn cookie-acceptance-btn" href="javascript:;"><@liferay.language key="accept" /></a>
			</div>
		</div>
	</div>
</#if>