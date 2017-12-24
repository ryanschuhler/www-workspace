<%@ include file="init.jsp" %>

<%

String pageTitle = layout.getTitle(locale);
Object pageTitleObj = request.getAttribute("LIFERAY_SHARED_PAGE_TITLE");

if (pageTitleObj != null) {
	ListMergeable<String> pageTitleListMergable = (ListMergeable<String>) pageTitleObj;
	pageTitle = pageTitleListMergable.mergeToString(StringPool.SPACE);
}
pageTitle = pageTitle + " - " + company.getName();
String portalURL = portal.getPortalURL(layout.getLayoutSet(), themeDisplay);

String metaDescription = layout.getDescription(locale);
Object pageDescriptionObj = request.getAttribute("LIFERAY_SHARED_PAGE_DESCRIPTION");

if (pageDescriptionObj != null) {
	ListMergeable<String> pageDescriptionListMergeable = (ListMergeable<String>) pageDescriptionObj;
	 metaDescription = pageDescriptionListMergeable.mergeToString(StringPool.SPACE);
}

String layoutFullURL = portal.getLayoutFullURL(layout, themeDisplay);
layoutFullURL = portal.getCanonicalURL(layoutFullURL, themeDisplay, layout);

String completeURL = portal.getCurrentCompleteURL(request);
String url = portal.getCanonicalURL(completeURL, themeDisplay, layout);

//String url = portalURL + themeDisplay.getURLCurrent();

%>
<div class="seo-snippet" id="seo-snippet">
	<div class="seo-title">
		<a class="seo-title-text">
			<h3 class="">
			<%= pageTitle %>
			</h3>
		</a>
	</div>
	<div class="seo-url">
		<cite class="seo-url-text">
		<%= url %>
		</cite>
	<div>
	<div class="seo-description">
		<span class="seo-description-text">
			<%= metaDescription %>
		</span>
	</div>
</div>



