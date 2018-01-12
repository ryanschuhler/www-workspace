<style>
.nav-wrapper {
	margin: 0 0 15px;
	text-align: center;
}

.nav-wrapper .nav-item {
	color: #4C4C4E;
	display: inline-block;
	padding: 10px;
	text-decoration: none;
}

.nav-wrapper .nav-item:hover, .nav-wrapper .nav-item.selected {
	color: #0EB8B8;
}
</style>

<div class="nav-wrapper">
    <#if link_urls.siblings?has_content>
    	<#list link_urls.siblings as cur_link_url>
    	    <#if cur_link_url.data == "true">
        	    <a class="nav-item selected" href="${cur_link_url.data}">${cur_link_url.link_text.data}</a>
    	    <#else>
    	        <a class="nav-item" href="${cur_link_url.data}">${cur_link_url.link_text.data}</a>
    	    </#if>
    	</#list>
    </#if>
</div>