'use strict';

import JSXComponent from 'metal-jsx';
import style from './PartnersDisplay.scss';
import Heading from '../../atoms/Heading/';
import Flexbox from '../../atoms/Flexbox/';
import Card from '../../molecules/Card';

class PartnersDisplay extends JSXComponent {
	render() {
		return (
			<div class={style.PartnersDisplay}>
				<Flexbox flexWrap="wrap">
					{this.props.regionPartners.map((partner, index) => {
						return (
							<Card
								cardDescription={partner.name}
								cardImage={partner.logoURL}
								cardTitle={partner.partnerships[0]['level']}
								width="23%"
							/>
						);
					})}
				</Flexbox>
			</div>
		);
	}
}

export default PartnersDisplay;
