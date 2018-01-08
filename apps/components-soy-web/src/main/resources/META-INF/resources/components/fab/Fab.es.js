import Component from 'metal-component';
import Soy from 'metal-soy';
import {Config} from 'metal-state';

import templates from './Fab.soy.js';

/**
 * This component renders a Fab button.
 */
class Fab extends Component {
}

Soy.register(Fab, templates);

/**
 * State definition.
 * @type {!Object}
 * @static
 */
Fab.STATE = {
  cssClass: Config.string(),

  /**
   * Items list.
   * @instance
   * @memberof Fab
   * @type {!string}
   * @default undefined
   */
  icon: Config.string(),

  /**
   * Items list.
   * @instance
   * @memberof Fab
   * @type {!string}
   * @default undefined
   */
  label: Config.string(),
};

export default Fab;