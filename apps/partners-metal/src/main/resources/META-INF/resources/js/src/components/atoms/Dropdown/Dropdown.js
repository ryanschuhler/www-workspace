'use strict';

import JSXComponent from 'metal-jsx';
import style from './Dropdown.scss';

class Dropdown extends JSXComponent {
	handleChange(e) {
		this.state.value = e.target.value;
		this.props.onChangeHandler(e);
	}

	render() {
		let first = '';

		if (this.props.disableFirst && this.props.selectText) {
			first = (
				<option selected="true" disabled="disabled">
					{this.props.selectText}
				</option>
			);
		} else if (this.props.selectText) {
			first = (
				<option selected="true" value="">
					{this.props.selectText}
				</option>
			);
		}

		return (
			<select
				class={style.Dropdown}
				onChange={this.handleChange.bind(this)}
				selected={this.state.value}
			>
				{first}
				{this.props.options.map(value => {
					return (
						<option selected={value === this.props.value}>
							{value}
						</option>
					);
				})}
			</select>
		);
	}
}

export default Dropdown;
