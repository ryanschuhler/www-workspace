<%@ include file="/init.jsp" %>

	<script src="<%=request.getContextPath()%>/js/dist/bundle.js"></script>

	<!-- DEV ENVIRONMENT: -->
	<!-- <script src="http://localhost:8081/src/main/resources/META-INF/resources/js/dist/bundle.js"></script> -->
	<div class="partners-metal-app"></div>

	<script type="text/javascript">
		new metal.PartnersApp({
			element: '.partners-metal-app'
		});
	</script>