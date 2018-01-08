import Component from 'metal-component';
import Soy from 'metal-soy';
import {Config} from 'metal-state';

import templates from './MaterialPagination.soy.js';

/**
 * This component renders tabs. This
 * https://material.io/components/web/catalog/tabs/
 */
class MaterialPagination extends Component {
}

Soy.register(MaterialPagination, templates);

/**
 * State definition.
 * @type {!Object}
 * @static
 */
MaterialPagination.STATE = {
  /**
   * End number.
   * @instance
   * @type {!number}
   * @default undefined
   */
  end: Config.string(),

  /**
   * Start number.
   * @instance
   * @type {!number}
   * @default undefined
   */
  start: Config.string(),

  /**
   * Total number.
   * @instance
   * @type {!number}
   * @default undefined
   */
  total: Config.string(),

  /**
   * Next page url.
   * @type {String}
   */
  nextURL: Config.string(),

  /**
   * previous page url.
   * @type {String}
   */
  previousURL: Config.string(),
};

export default MaterialPagination;