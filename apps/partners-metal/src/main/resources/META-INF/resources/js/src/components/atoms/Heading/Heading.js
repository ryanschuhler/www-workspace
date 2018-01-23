'use strict';

import JSXComponent from 'metal-jsx';
import style from './Heading.scss';

class Heading extends JSXComponent {
	render() {
		let heading = '';

		switch (this.props.type) {
			case 'h1':
				heading = <h1>{this.props.children}</h1>;
				break;
			case 'h2':
				heading = <h2>{this.props.children}</h2>;
				break;
			case 'h3':
				heading = <h3>{this.props.children}</h3>;
				break;
			case 'h4':
				heading = <h4>{this.props.children}</h4>;
				break;
			default:
				heading = <h1>{this.props.children}</h1>;
		}

		return { heading };
	}
}

export default Heading;
