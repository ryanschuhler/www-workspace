import Component from 'metal-component';
import Soy from 'metal-soy';
import {Config} from 'metal-state';

import templates from './MaterialTabs.soy.js';

/**
 * This component renders tabs. This
 * https://material.io/components/web/catalog/tabs/
 */
class MaterialTabs extends Component {
}

Soy.register(MaterialTabs, templates);

/**
 * State definition.
 * @type {!Object}
 * @static
 */
MaterialTabs.STATE = {
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

export default MaterialTabs;