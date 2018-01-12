<#assign article_namespace = "article${.vars['reserved-article-id'].data}" />
<#assign page_locations = ["/resources/l", "/l"] />

<form action="" class="form-font lrdcom-form" id="${article_namespace}fm" name="landingPageAdminFm" onsubmit="event.preventDefault(); submitLandingPage('#${article_namespace}fm'); landingPageSubmitBtn.disabled = true;" role="form">
	<legend>Landing Page Templates</legend>

	<div class="form-col form-col-1">
		<div class="field-1 field-radio field-required field-wrapper">
			<label class="field-label" for="aritcleId">Landing Page Template Type:</label>

			<div class="input">
				<#list template_article.siblings as cur_template_article>
					<div class="block-container no-padding-horizontal">
						<div class="template-thumbnail w50">
							<img src="${cur_template_article.thumbnail.data}">
						</div>

						<div class="template-description w50">
							${cur_template_article.description.data}
						</div>

						<label class="field-label show">
							<input class="field field-radio field-required" name="articleId" required type="radio" value="${cur_template_article.article_id.data}" />
							${cur_template_article.title.data}
						</label>
					</div>

					<hr/>
				</#list>
			</div>
		</div>

		<div class="field-2 field-select field-required field-wrapper">
			<label class="field-label" for="location">Landing Page Location:</label>

			<select class="field field-required field-select" name="location">
				<option class="field field-radio field-required" required value=""></option>

				<#list page_locations as page_location>
					<option class="field field-radio field-required" required value="${page_location}">${page_location}</option>
				</#list>
			</select>
		</div>

		<div class="field-3 field-required field-text field-wrapper">
			<label class="field-label" for="title">Landing Page Title</label>
			<input class="field field-required field-text" id="articleTitle" name="articleTitle" required type="text" />
		</div>

		<div class="field-4 field-required field-text field-wrapper">
			<label class="" for="title">Landing Page Friendly URL</label>
			<input class="field field-required field-text" disabled="true" id="urlTitle" name="urlTitle" required type="text" />
		</div>

		<div class="field-5 field-required field-textarea field-wrapper">
			<label class="field-label" for="reason">Reason for New Page</label>
			<textarea class="field field-required field-textarea" name="reason" rows="3" required></textarea>
		</div>

		<button class="btn btn-primary" name="landingPageSubmitBtn" type="submit">Create Landing Page</button>
	</div>
</form>

<script type="text/javascript">
	var formValidator;

	AUI().ready(
		'aui-base',
		'aui-io-request',
		'osb-form',
		function(A) {
			formValidator = new A.OSBForm(
				{
					formId: '#${article_namespace}fm'
				}
			).render();

			var articleTitle = A.one('#articleTitle');
			var urlTitle = A.one('#urlTitle');

			var titleOnChange = articleTitle.on(
				'input',
				function() {
					var titleValue = articleTitle.get('value');

					var newVal = titleValue.replace(/[^\s\w]/g, '').trim().toLowerCase().replace(/\s+/g, '-');

					if (urlTitle && newVal) {
						urlTitle.val(newVal);
						urlTitle.get('parentNode').toggleClass('field-filled', newVal);
					}
				}
			);

			urlTitle.on(
				'input',
				function() {
					titleOnChange.detach();
				}
			);
		}
	);

	function submitLandingPage(formId) {
		AUI().ready(
			'aui-base',
			function(A) {
				var data = {};
				var form = A.one(formId);

				form.all('.field').each(
					function(node) {
						var value = node.get('value');

						if (node.hasClass('field-radio')) {
							value = node.get('checked') ? value : '';
						}

						if (value) {
							data[node.get('name')] = value;
						}
					}
				);

				if (!formValidator.hasErrors() && confirm('Are you sure you want to create a new landing page?')) {
					var ieVersion = A.UA.ie;

					if (ieVersion && ieVersion < 11) {
						alert('If you really like using IE, please use version 11 or later.');
					}
					else {
						window.location = window.location.origin + data.location + '?articleId=' + data.articleId + '&urlTitle=' + data.urlTitle;
					}
				}
			}
		);
	}
</script>