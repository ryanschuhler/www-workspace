<#import "${templatesPath}/231368766" as article_utilities>

<#assign has_update_permissions = article_utilities.has_update_permissions() />

<div class="block-container faq-section" id="article-${.vars['reserved-article-id'].data}">
	<div class="faq-heading standard-padding w100">
		<#include "${templatesPath}/898140" />
	</div>

	<#list question.siblings as cur_question>
		<div class="question question-${cur_question_index} standard-padding">
			<svg class="toggle-icon" height='18px' width='18px'><use xlink:href='#toggleCircle' /></svg>

			<#assign question_css_class = "" />
			<#assign question_attrs = "" />

			<#if has_update_permissions>
				<#assign question_css_class = question_css_class + " live-edit" />
				<#assign question_attrs = question_attrs + "
					data-article-id='${.vars[\"reserved-article-id\"].data}'
					data-level-path='${cur_question.name}::${cur_question_index}'
				" />
			</#if>

			<h4 class="class-toggle" data-target-nodes='#article-${.vars["reserved-article-id"].data} .question-${cur_question_index}'>
				<strong class="${question_css_class}" ${question_attrs}>
					${cur_question.data}
				</strong>
			</h4>

			<#list cur_question.answer.siblings as cur_answer>
				<#assign answer_css_class = "" />
				<#assign answer_attrs = "" />

				<#if has_update_permissions>
					<#assign answer_css_class = answer_css_class + " live-edit" />
					<#assign answer_attrs = answer_attrs + "
						data-article-id='${.vars[\"reserved-article-id\"].data}'
						data-level-path='${cur_question.name}::${cur_question_index},${cur_answer.name}::${cur_answer_index}'
					" />
				</#if>

				<p class="${answer_css_class}" ${answer_attrs}>
					${cur_answer.data}
				</p>
			</#list>
		</div>
	</#list>
</div>