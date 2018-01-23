'use strict';

import JSXComponent from 'metal-jsx';
import style from './Card.scss';
import Flexbox from '../../atoms/Flexbox';
import Heading from '../../atoms/Heading/';
import { StyleSheet, css } from 'aphrodite';

class Card extends JSXComponent {
	onClick(e) {
		this.props.onClick(e);
	}

	render() {
		const styles = StyleSheet.create({
			card: {
				width: this.props.width
			}
		});
		return (
			<div
				class={`${style.Card} ${css(styles.card)}`}
				data-attr={this.props.data}
				onClick={this.onClick.bind(this)}
			>
				<Flexbox
					alignItems="center"
					flexDirection="column"
					height="100%"
					justifyContent="center"
				>
					<img src={this.props.cardImage} />
					<Heading type="h3">{this.props.cardTitle}</Heading>
					<p>{this.props.cardDescription}</p>
				</Flexbox>
			</div>
		);
	}
}

export default Card;
