<div class="block-container no-padding w100">
	<#if place.getSiblings()?has_content>
		<#list place.siblings as cur_place>
			<a class="block light-color place standard-padding" href="${cur_place.link.data}" style="background: url(${cur_place.image.data}") center center fixed; background-size:cover;" target="_blank">
				<div class="align-center block-container justify-center inner-border">
					<span class="place-name">${cur_place.data}</span>
				</div>
			</a>
		</#list>
	</#if>
</div>

<style>
	a.place {
		display: block;
		min-height: 400px;
		transition: all 0.25s ease-in-out;
		width: 50%;
	}

	a.place:hover,
	a.place:focus,
	a.place:active {
		text-decoration: none;
	}

	a.place .place-name {
		font-size: 2em;
	}

	a.place:hover .place-name {
		transform: scale(1.2);
		transition: all 0.25s ease-in-out;
	}

	a.place .inner-border {
		width: 100%;
		height: 100%;
		border: 1px solid #FFF;
	}
</style>