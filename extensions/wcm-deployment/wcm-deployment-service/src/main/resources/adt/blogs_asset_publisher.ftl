
<#assign blogsEntryLocalService = serviceLocator.findService("com.liferay.blogs.kernel.service.BlogsEntryLocalService") />
<#if entries?has_content >
	<section class="block-container lego-section section-1 responsive-justify-center">
		 <div class="block block-1 content-column lego-block w100 text-center large-padding">	
			 <h4 class="lego-element title " > 
			 	<b>Folgende Blogs könnten Sie auch interessieren...</b> 
			</h4> 
		</div> 

		<#list entries as curEntry>
			<#assign assetRenderer = curEntry.getAssetRenderer() />
			<#assign redirectURL = "http://localhost">
			<#assign asset_url = assetRenderer.getURLViewInContext(renderRequest, renderResponse, redirectURL)>
			
			<div class="block content-column lego-block w33 blogs-entry tile"> 
				<a class="lego-element image-wrapper live-edit" href="${asset_url}"> 
					<img src="${getJournalArticleSmallImageURL(curEntry.getClassPK())}">
				</a> 
				<a class="lego-element text-center title standard-padding-vertical live-edit">${curEntry.getTitle(locale)}</a> 
				<p class="lego-element live-edit" > ${stringUtil.shorten(curEntry.getSummary(locale),100)}</p>


				<#if assetRenderer.hasEditPermission(permissionChecker)>
					<#assign redirectURL = renderResponse.createLiferayPortletURL(themeDisplay.getPlid(), themeDisplay.getPortletDisplay().getId(), "RENDER_PHASE", false) />

					${redirectURL.setParameter("mvcPath", "/view.jsp")}



					<#assign

						editPortletURL = assetRenderer.getURLEdit(renderRequest, renderResponse, windowStateFactory.getWindowState("MAXIMIZED"), redirectURL)			
						taglibEditURL = editPortletURL.toString()
					/>
		

					<@liferay_ui.icon
						image="edit"
						label=true
						message="edit"
						url=taglibEditURL
					/>
				</#if>
			</div>


		</#list>
	</section>
</#if>


<#function getJournalArticleSmallImageURL classPK >
	<#assign article = blogsEntryLocalService.getBlogsEntry(classPK) />
	<#return article.getSmallImageURL(themeDisplay)>
</#function>