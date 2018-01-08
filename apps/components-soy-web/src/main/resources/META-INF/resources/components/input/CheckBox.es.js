import Component from 'metal-component';
import Soy from 'metal-soy';
import {Config} from 'metal-state';

import templates from './CheckBox.soy.js';

/**
 * This component renders a Check Box.
 */
class CheckBox extends Component {

  attached() {
    const {input} = this.refs;

    input.addEventListener('click', () => input.blur());
  }

  onClick_({target}) {
    this.fireEvent_('checkboxClicked', target.checked);
  }

  onChange_({target}) {
    this.fireEvent_('checkboxChanged', target.checked);
  }

  fireEvent_(eventName, checked) {
    this.emit.call(this, eventName, checked, this.object);
  }
}

CheckBox.STATE = {
  checked: Config.bool(),
  disabled: Config.bool(),
  elementClasses: Config.string(),
  label: Config.oneOfType([
    Config.string(),
    Config.func()
  ]),
  onChange: Config.func(),
  onClick: Config.func(),
  required: Config.bool()
};

Soy.register(CheckBox, templates);

export default CheckBox;