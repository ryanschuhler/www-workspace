'use strict';

import Card from './Card.es';

export default function(elementId) {
	const btn = document.getElementById(elementId);
	let card = new Card({
		clicked: false
	});

	btn.addEventListener('click', () => {
		card.clicked = true;
	});
}