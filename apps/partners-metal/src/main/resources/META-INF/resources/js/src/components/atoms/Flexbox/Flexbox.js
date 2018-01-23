'use strict';

import JSXComponent from 'metal-jsx';
import style from './Flexbox.scss';
import { StyleSheet, css } from 'aphrodite';

class Flexbox extends JSXComponent {
	render() {
		const styles = StyleSheet.create({
			flex: {
				boxSizing: 'border-box',
				display: 'flex',
				flexDirection: this.props.flexDirection,
				height: this.props.height,
				justifyContent: this.props.justifyContent,
				alignItems: this.props.alignItems,
				flexWrap: this.props.flexWrap,
				width: this.props.width
			}
		});
		return (
			<div class={`${style.Flexbox} ${css(styles.flex)}`}>
				{this.props.children}
			</div>
		);
	}
}

export default Flexbox;
