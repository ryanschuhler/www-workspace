<#import "${templatesPath}/231368766" as article_utilities>

<#if article_utilities.has_update_permissions()>
	<#assign service_context = objectUtil("com.liferay.portal.kernel.service.ServiceContextThreadLocal").getServiceContext() />
	<#assign http_servlet_request = service_context.getRequest() />

	<#assign bento_structure_key = "897801" />
	<#assign hubspot_portal_id = "252686"/>
	<#assign hubspot_structure_key = "781831" />
	<#assign lego_structure_key = "12484" />
	<#assign region_structure_key = "223092737" />

	<#assign journal_article_local_service = serviceLocator.findService("com.liferay.journal.service.JournalArticleLocalService") />
	<#assign journal_article_content_search_local_service = serviceLocator.findService("com.liferay.portlet.journal.service.JournalContentSearchLocalService") />
	<#assign layout_local_service = serviceLocator.findService("com.liferay.portal.kernel.service.LayoutLocalService") />

	<#assign class_resolver_util = staticUtil["com.liferay.portal.kernel.util.ClassResolverUtil"]>
	<#assign dynamic_query_factory_util = staticUtil["com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"]>
	<#assign order_by_comparator_factory_util = staticUtil["com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil"]>
	<#assign restrictions_factory_util = staticUtil["com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"]>

	<#assign journalArticleClass = class_resolver_util.resolveByPortalClassLoader("com.liferay.portlet.journal.model.JournalArticle") />
	<#assign modified_date_order_by_comparator = order_by_comparator_factory_util.create("JournalArticle", ["modifiedDate", false])>

	<div id="adminReportTabs">
		<ul class="nav nav-tabs">
			<li class="active"><a href="#hubspotFormGenerator">HubSpot Form Generator</a></li>
			<li><a href="#regionTargeting">Region Targeting</a></li>
		</ul>

		<div class="tab-content">
			<div class="standard-padding" id="hubspotFormGenerator">
				<h3>Layouts using HubSpot Form Generator</h3>

				<table class="table table-condensed">
					<thead>
						<@get_row_content "" "" hubspot_structure_key />
					</thead>

					<tbody>
						<#assign articles = journal_article_local_service.getStructureArticles(groupId, hubspot_structure_key, -1, -1, modified_date_order_by_comparator)! />

						<#list articles as article>
							<#assign edit_url = article_utilities.get_edit_url(article) />

							<#if article.isApproved() && journal_article_local_service.isLatestVersion(article.getGroupId(), article.getArticleId(), article.getVersion())>
								<#assign layout_count = journal_article_content_search_local_service.getLayoutIdsCount(article.getArticleId()) />

								<#if layout_count gt 0>
									<#assign article_searches = journal_article_content_search_local_service.getArticleContentSearches(article.getArticleId()) />

									<#list article_searches as article_search>
										<#assign layout = layout_local_service.getLayout(groupId, false, article_search.getLayoutId()) />

										<@get_row_content article layout hubspot_structure_key />
									</#list>
								<#else>
									<#assign dynamicQuery = dynamic_query_factory_util.forClass(journalArticleClass) />

									<#assign criterion1 = restrictions_factory_util.like("content", "%" + article.getArticleId() + "%") />
									<#assign criterion2 = restrictions_factory_util.like("content", "%" + article.getUrlTitle() + "%") />

									<#assign void = dynamicQuery.add(restrictions_factory_util.or(criterion1, criterion2)) />

									<#assign criterion3 = restrictions_factory_util.eq("structureId", bento_structure_key) />
									<#assign criterion4 = restrictions_factory_util.eq("structureId", lego_structure_key) />

									<#assign void = dynamicQuery.add(restrictions_factory_util.or(criterion3, criterion4)) />

									<#assign embedded_articles = journal_article_local_service.dynamicQuery(dynamicQuery) />

									<#list embedded_articles as embedded_article>
										<#if embedded_article.isApproved() && journal_article_local_service.isLatestVersion(embedded_article.getGroupId(), embedded_article.getArticleId(), embedded_article.getVersion())>
											<#assign article_searches = journal_article_content_search_local_service.getArticleContentSearches(embedded_article.getArticleId()) />

											<#list article_searches as article_search>
												<#assign layout = layout_local_service.getLayout(groupId, false, article_search.getLayoutId()) />

												<@get_row_content article layout hubspot_structure_key />
											</#list>
										</#if>
									</#list>
								</#if>
							</#if>
						</#list>
					</tbody>
				</table>
			</div>
			
			<div id="regionTargeting">
				<h3>Layouts using Region Targeting</h3>

				<table class="table table-condensed">
					<thead>
						<@get_row_content "" "" region_structure_key />
					</thead>

					<tbody>
						<#assign articles = journal_article_local_service.getStructureArticles(groupId, region_structure_key)! />

						<#list articles as article>
							<#if article.isApproved() && journal_article_local_service.isLatestVersion(article.getGroupId(), article.getArticleId(), article.getVersion())>
								<#assign edit_url = article_utilities.get_edit_url(article) />

								<#assign article_searches = journal_article_content_search_local_service.getArticleContentSearches(groupId, article.getArticleId()) />

								<#list article_searches as article_search>
									<#assign layout = layout_local_service.getLayout(groupId, false, article_search.getLayoutId()) />

									<@get_row_content article layout region_structure_key />
								</#list>
							</#if>
						</#list>
					</tbody>
				</table>

			</div>
		</div>
	</div>

	<#macro get_row_content article layout structure_key>
		<#if article?has_content && layout?has_content>
			<tr>
				<td>
					${layout.getPlid()}
				</td>
				<td>
					<a href="${layout.getFriendlyURL()}">${layout.getFriendlyURL()}</a>
				</td>
				<td>
					${article.getArticleId()}</a>
				</td>
				<td>
					<a href="${edit_url}">${article.getUrlTitle()}</a>
				</td>
				<#if structure_key == hubspot_structure_key>
					<td>
						<#assign document = saxReaderUtil.read(article.getContent()) />

						<#assign hubspot_form_id = document.valueOf("//dynamic-element[@name='form_id']/dynamic-content/text()") />

						<p><a href="https://app.hubspot.com/forms/${hubspot_portal_id}/${hubspot_form_id}/edit" target="_new">${hubspot_form_id}</a></p>
					</td>
				</#if>
				<td>
					${dateUtil.getDate(article.getModifiedDate(), "MM/dd/yy", locale)}
				</td>
			</tr>
		<#else>
			<tr class="first">
				<th>
					PLID
				</th>
				<th>
					Friendly URL
				</th>
				<th>
					Article ID
				</th>
				<th>
					Article URL Title
				</th>
				<#if structure_key == hubspot_structure_key>
					<th>
						Hubspot Form ID
					</th>
				</#if>
				<th class="last">
					Modified
				</th>
			</tr>		
		</#if>
	</#macro>

	<script>
	AUI().use(
		'aui-tabview',
		function(A) {
			new A.TabView(
				{
					srcNode: '#adminReportTabs'
				}
			).render();
		}
	);
	</script>
</#if>