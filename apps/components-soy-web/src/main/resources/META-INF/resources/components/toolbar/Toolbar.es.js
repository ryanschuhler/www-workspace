import Component from 'metal-component';
import Soy from 'metal-soy';
import {Config} from 'metal-state';

import templates from './Toolbar.soy.js';

/**
 * This component renders a modal. This
 * component is used whenever a modal is needed.
 * https://material.io/components/web/catalog/dialogs/
 */
class Toolbar extends Component {
}

Soy.register(Toolbar, templates);

/**
 * State definition.
 * @type {!Object}
 * @static
 */
Toolbar.STATE = {
  /**
   * Items list.
   * @instance
   * @memberof TabularList
   * @type {!array}
   * @default undefined
   */
  items: Config.array(),

  /**
   * CSS classes to be applied to the footer of the modal.
   * @type {String}
   */
  elementClasses: Config.string(),
};

export default Toolbar;