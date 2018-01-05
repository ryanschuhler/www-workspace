import Component from 'metal-component';
import Soy from 'metal-soy';
import {Config} from 'metal-state';

import templates from './RadioButton.soy.js';

/**
 * This component renders a Radio Button.
 */
class RadioButton extends Component {
}

RadioButton.STATE = {
  checked: Config.bool(),
  disabled: Config.bool(),
  label: Config.string(),
  name: Config.string(),
  onChange: Config.func(),
  onClick: Config.func(),
  required: Config.bool()
};

Soy.register(RadioButton, templates);

export default RadioButton;