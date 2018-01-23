'use strict';

import JSXComponent from 'metal-jsx';
import style from './SearchInput.scss';

class SearchInput extends JSXComponent {
	onKeyUp(e) {
		if (this.props.onKeyUp) {
			this.props.onKeyUp(e);
		}
	}

	render() {
		return (
			<input
				class={style.SearchInput}
				placeholder={this.props.placeholder}
				type="text"
				value={this.state.value}
				onKeyup={this.onKeyUp.bind(this)}
			/>
		);
	}
}

SearchInput.STATE = {
	value: {
		value: null
	}
};

export default SearchInput;
