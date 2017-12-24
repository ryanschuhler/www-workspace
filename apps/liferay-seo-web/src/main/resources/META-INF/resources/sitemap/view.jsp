<%@ include file="init.jsp" %>


<h1>SitemapURLProviders</h1>

<table>
	<tr>
		<th>Model Class</th>
		<th>SitemapURLProvider Class</th>
		<th>Bundle</th>
	</tr>

  <c:forEach var="sitemapURLProvider" items="<%= SitemapURLProviderRegistryUtil.getSitemapURLProviders() %>">
  
  	<tr>
  		<td>${sitemapURLProvider.className}</td>
  		<td>${sitemapURLProvider['class'].simpleName}</td>
  		<td>
 <%
		 SitemapURLProvider sitemapURLProvider = (SitemapURLProvider) pageContext.getAttribute("sitemapURLProvider");
 		 if (sitemapURLProvider != null) {
 			 Bundle bundle = FrameworkUtil.getBundle(sitemapURLProvider.getClass());
 			 if (bundle != null) {
 				%>
 						<%= bundle.toString()%>
 				<% 
 			 }
 		 }
 %>
 	
  		</td>
  	</tr>
  </c:forEach>
  </table>
  
  <h1>Sitemap</h1>
  <table>
	  <tr>
		  <th>Layout</th>
		  <th>Model Name</th>
		  <th>URL</th>
	  </tr>
 
  <c:forEach var="entry" items="<%= sitemap %>">  	
  	<c:forEach var="provider" items="${entry.value}">
  	  	<c:forEach var="url" items="${provider.value}">
		  	<tr>
		  		<td>${entry.key.getName(locale)}</td>
		  		<td>${provider.key}</td>
		  		<td>${url}</td>
		  	</tr>
		 </c:forEach>
  	</c:forEach>  	
  </c:forEach>
  </table>