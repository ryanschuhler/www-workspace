<#assign color_black = "#404041" />
<#assign color_gradient_1 = "#386BB5" />
<#assign color_gradient_2 = "#1C8CCC" />
<#assign color_primary = "#00547C" />
<#assign color_secondary = "#1C8CCC" />
<#assign color_white = "#FFF" />
<#assign large = "992px" />
<#assign medium = "768px" />
<#assign small = "576px" />

<#assign extra_topics = topic_4.getSiblings() />

<article id="topicsContainer">
	<h2 class="topic-heading">${topic_heading.data}</h2>

	<div class="flex justify-center large-padding">
		<div class="topic">
			${topic_1.icon_1.data}
			<h4 class="topic-title">${topic_1.data}</h4>
		</div>

		<div class="topic">
			${topic_2.icon_2.data}
			<h4 class="topic-title">${topic_2.data}</h4>
		</div>

		<div class="topic">
			${topic_3.icon_3.data}
			<h4 class="topic-title">${topic_3.data}</h4>
		</div>

		<#if extra_topics?has_content>
			<#list 0..extra_topics?size - 1 as i>
				<#if i < 7>
					<div class="topic">
						${extra_topics[i].icon.data}
						<h4 class="topic-title">${extra_topics[i].data}</h4>
					</div>
				</#if>
			</#list>

		<#else>
			<div class="topic">
				${topic_4.icon.data}
				<h4 class="topic-title">${topic_4.data}</h4>
			</div>
		</#if>
	</div>

	<a class="align-baseline flex justify-end topic-cta" href="${cta.cta_link.data}">
		<h3 class="small-padding-horizontal topic-cta-text">${cta.data}</h3>

		<svg height="15" width="14" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"><use xlink:href="#path0_fill" transform="translate(0 .76)"/><defs><path id="path0_fill" d="M6.63 8.687H0V6.954h8.217v4.179l4.128-4.515L8.108 2.19v3.962H6.522V0h1.784L14 5.946V7.27l-5.647 6.17H6.63V8.687z"/></defs></svg>
	</a>
</article>

<style>
#topicsContainer {
	padding-top: 1em;
}

#topicsContainer > div {
	flex-wrap: wrap;
}

#topicsContainer .topic {
	align-items: center;
	box-sizing: border-box;
	display: flex;
	flex-basis: calc(25% - 1em);
	height: 8em;
	justify-content: flex-start;
	margin: 0.5em;
}

#topicsContainer .topic svg {
	fill: ${color_primary};
	flex-shrink: 0;
	height: 3em;
	width: 3em;
}

#topicsContainer .topic-cta {
	background-color: ${color_white};
	box-sizing: border-box;
	padding: 1em 3em;
	width: 100%;
}

#topicsContainer .topic-cta svg {
	fill: ${color_black};
	padding-bottom: 2px;
}

#topicsContainer .topic-cta-text {
	color: ${color_black};
	font-weight: 300;
}

#topicsContainer .topic-heading {
	color: ${color_black};
	display: block;
	padding-left: 1.5em;
}

#topicsContainer .topic-title {
	color: ${color_primary};
	font-weight: 400;
	padding: 0 1em;
}

@media all and (max-width: ${large}) {
	#topicsContainer > div {
		padding: 1em;
	}

	#topicsContainer .topic-cta {
		justify-content: center;
	}

	#topicsContainer .topic-heading {
		padding-left: 0;
		text-align: center;
	}

	#topicsContainer .topic {
		flex-basis: calc(50% - 2em);
	}
}

@media all and (max-width: ${medium}) {
	#topicsContainer {
		background: ${color_gradient_1};  /* fallback for old browsers */
		background: -webkit-linear-gradient(to right, ${color_gradient_1}, ${color_gradient_2});
		background: linear-gradient(to right, ${color_gradient_1}, ${color_gradient_2});
	}

	#topicsContainer .topic {
		flex-direction: column;
		height: 10em;
		justify-content: baseline;
	}

	#topicsContainer .topic svg {
		fill: ${color_white};
		margin: 1em;
	}

	#topicsContainer .topic-cta {
		justify-content: flex-end;
	}

	#topicsContainer .topic-cta svg {
		fill: ${color_secondary};
		padding-bottom: 0;
	}

	#topicsContainer .topic-cta-text {
		color: ${color_secondary};
	}

	#topicsContainer .topic-heading, #topicsContainer .topic-title {
		color: ${color_white};
		text-align: center;
	}
}

@media all and (max-width: ${small}) {
	#topicsContainer .topic {
		flex-basis: calc(100% - 2em);
	}
}
</style>