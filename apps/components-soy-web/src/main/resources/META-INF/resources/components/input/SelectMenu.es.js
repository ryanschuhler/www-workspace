import Component from 'metal-component';
import {Config} from 'metal-state';
import Soy from 'metal-soy';

import templates from './SelectMenu.soy.js';

/**
 * This component renders a Select
 */
class SelectMenu extends Component {

  attached() {
    this.on('valueChanged',
      ({newVal}) => this.element.setAttribute('value', newVal));
  }

  rendered() {
    if (Liferay.mdc) {
      new Liferay.mdc.select.MDCSelect(this.refs['selectMenu']);
    }
  }

  handleOnClick_({toElement}) {
    this.value = toElement.getAttribute('value');
  }
}

SelectMenu.STATE = {
  name: Config.string(),
  options: Config.arrayOf(Config.shapeOf({
    label: Config.string(),
    value: Config.any()
  })),
  value: Config.any()
};

Soy.register(SelectMenu, templates);

export default SelectMenu;