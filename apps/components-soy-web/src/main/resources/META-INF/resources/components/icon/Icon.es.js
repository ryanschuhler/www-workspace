import Component from 'metal-component';
import {Config} from 'metal-state';
import {Soy} from 'metal-soy';

import templates from './Icon.soy.js';

class Icon extends Component {
}

Icon.STATE = {
  isMaterialIcon: Config.bool(),
  elementClasses: Config.string(),
  pathThemeImages: Config.string(),
  symbol: Config.string(),
};

Soy.register(Icon, templates);

export default Icon;