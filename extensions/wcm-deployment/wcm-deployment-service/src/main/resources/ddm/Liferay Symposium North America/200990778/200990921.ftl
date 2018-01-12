<div class="block-container no-padding w100">
	<#list place.siblings as cur_place>
		<a class="block light-color place standard-padding" href="${htmlUtil.escapeHREF(cur_place.link.data)}" style="background: url(${cur_place.image.data}) center center / cover;" target="_blank">
			<div class="align-center block-container inner-border justify-center">
				<span class="place-name">${cur_place.data}</span>
			</div>
		</a>
	</#list>
</div>

<style>
	a.place {
		display: block;
		min-height: 400px;
		transition: all 0.25s ease-in-out;
		width: 50%;
	}

	a.place .inner-border {
		border: 1px solid #FFF;
		height: 100%;
		width: 100%;
	}

	a.place .place-name {
		font-size: 2em;
	}

	a.place:active,
	a.place:focus,
	a.place:hover {
		text-decoration: none;
	}

	a.place:hover .place-name {
		transform: scale(1.2);
		transition: all 0.25s ease-in-out;
	}
</style>