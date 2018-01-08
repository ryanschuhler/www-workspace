import Component from 'metal-component';
import core from 'metal';
import {Config} from 'metal-state';
import {Soy} from 'metal-soy';

import templates from './DropdownMenu.soy.js';

class DropdownMenu extends Component {

  attached() {
    if (Liferay.mdc) {
      this.addMenuToggleListener()
    } else {
      Liferay.once('MaterialReady', () => this.addMenuToggleListener());
    }
  }

  addMenuToggleListener() {
    this.mdcMenu = new Liferay.mdc.menu.MDCSimpleMenu(
      this.refs['mdcSimpleMenu']
    );

    if (!this.shouldFocus) {
      this.mdcMenu.foundation_.__proto__.focusOnOpen_ = () => {};
    }
  }

  handleOpenMenu_() {
    this.mdcMenu.open = !this.mdcMenu.open
  }

  rendered() {
    if ((core.isNull(this.mdcMenu) || !core.isDef(this.mdcMenu))
      && Liferay.mdc) {
      this.addMenuToggleListener();
    }
  }
}

Soy.register(DropdownMenu, templates);

/**
 * State definition.
 * @type {!Object}
 * @static
 */
DropdownMenu.STATE = {
  items: Config.array(),
  mdcMenu: Config.object(),
  shouldFocus: Config.bool().value(true)
};

export default DropdownMenu;