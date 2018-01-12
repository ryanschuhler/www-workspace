<#assign page_header = header.data! />
<#assign form_instructions = instructions.data! />
<#assign certificate_key_label = certificate_key.data />
<#assign last_name_label = last_name.data />
<#assign verify_button = button_text.data />

<h1 class="font-color w100 text-center">${page_header}</h1>

<div class="max-lg standard-padding-horizontal verification-form">
<p class="standard-padding-vertical">${form_instructions}</p>

<form action="" class="lrdcom-form" id="verifyTrainingFm" name="verifyTrainingFm" onsubmit="event.preventDefault();" role="form">
<div class="form-col form-col-1">
<div class="field-1 field-filled field-required field-text field-wrapper"><label class="field-label" for="certificateKey">${certificate_key_label}</label> <input class="field field-required field-text" id="certificateKey" name="certificateKey" required="" type="text" /></div>

<div class="field-2 field-filled field-required field-text field-wrapper"><label class="field-label" for="lastName">${last_name_label}</label> <input class="field field-required field-text" id="lastName" name="lastName" required="" type="text" /></div>
</div>

<div class="btn-wrapper"><input class="btn btn-primary" id="verifyTraining" type="submit" value="${verify_button}" /></div>
</form>

<div class="certificate-results hide large-padding-vertical">&nbsp;</div>
</div>
<style type="text/css">.certificate-results tr td:first-of-type {
	width: 50%;
}
</style>
<script>
	AUI().ready(
		'aui-base',
		'aui-io-request',
		'datatype-date',
		'osb-form',
		function(A) {
			var requiredRule = {'required': true};

			var rules = {
				'certificateKey': requiredRule,
				'lastName': requiredRule
			};

			var osbForm = new A.OSBForm(
			{
				formId: '#verifyTrainingFm',
				rules: rules
			}
			).render();

			console.log(osbForm);

			var certificateResultsNode = A.one('.certificate-results');

			function showCertificateResults(message) {
				if (certificateResultsNode) {
					certificateResultsNode.html(message);
					certificateResultsNode.show();
				}
			}

			function verifyTraining() {
				console.log(osbForm);

				var certificateKey = verifyTrainingFm.certificateKey.value;

				var lastName = verifyTrainingFm.lastName.value;

				certificateKey = certificateKey.replace(/[-\s]/g, '');

				lastName = lastName.replace(/\s/g, '');

				var failureMessage =  '<div class="failure-message w33">We were unable to find a training certificate for Last Name: \
				<b>'+ lastName + '</b> and Certificate Key: <b>' + certificateKey + '</b>. \
				If you believe this is an error, please reenter the verification \
				information or contact us here: <a href="/contact-us">Contact Us Page</a></div>';

				var successMessage = '<h3 class="text-success">Certificate Verified</h3>\
				<table>\
					<tbody>\
						<tr>\
							<td>' + Liferay.Language.get('name') + ': </td>\
							<td>{customerName}</td>\
						</tr>\
						<tr>\
							<td>Certificate Number: </td>\
							<td>{certificateNumber}</td>\
						</tr>\
						<tr>\
							<td>Course Name: </td>\
							<td>{courseName}</td>\
						</tr>\
						<tr>\
							<td>Course Version: </td>\
							<td>{courseVersion}</td>\
						</tr>\
						<tr>\
							<td>Course Date: </td>\
							<td>{courseDate}</td>\
						</tr>\
						<tr>\
							<td>Course Location: </td>\
							<td>{courseLocation}</td>\
						</tr>\
						<tr>\
							<td>Course Instructor Name: </td>\
							<td>{courseInstructorName}</td>\
						</tr>\
					</tbody>\
				</table>';

				var url = '/osb-portlet/training/training_certificates?key=' + certificateKey + '&lastName=' + lastName + '&type=${type.data}';

				if (certificateKey && lastName) {
					A.io.request(
						url,
						{
							data: {},
							dataType: 'json',
							method: 'GET',
							on: {
								success: function (event, id, obj) {
									var responseData = this.get('responseData');

									var successHtml = A.Lang.sub(successMessage, responseData);

									showCertificateResults(successHtml);
								},
								failure: function (event, id, obj) {
									showCertificateResults(failureMessage);
								}
							}
						}
						);
				}
			}

			var submitVerify = A.one('#verifyTraining');

			if (submitVerify) {
				submitVerify.on(
					'click',
					verifyTraining
					);
			}
		}
		);
	</script>