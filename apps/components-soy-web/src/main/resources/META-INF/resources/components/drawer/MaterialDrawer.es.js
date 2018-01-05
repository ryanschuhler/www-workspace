import Component from 'metal-component';
import Soy from 'metal-soy';

import templates from './MaterialDrawer.soy.js';

/**
 * This component renders a modal. This
 * component is used whenever a modal is needed.
 * https://material.io/components/web/catalog/dialogs/
 */
class MaterialDrawer extends Component {
}

Soy.register(MaterialDrawer, templates);

/**
 * State definition.
 * @type {!Object}
 * @static
 */
MaterialDrawer.STATE = {};

export default MaterialDrawer;