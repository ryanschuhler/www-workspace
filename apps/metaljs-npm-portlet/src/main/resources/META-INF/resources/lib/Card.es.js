'use strict';

import Component from 'metal-component';
import Soy from 'metal-soy';

import templates from './Card.soy';

class Card extends Component {
	click() {
		this.clicked = true;
	}
}
Soy.register(Card, templates);

Card.STATE = {
	clicked: {
		value: false,
	},
};

export default Card;