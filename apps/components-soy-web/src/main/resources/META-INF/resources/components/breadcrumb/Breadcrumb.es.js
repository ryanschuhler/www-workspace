import Component from 'metal-component';
import core from 'metal';
import {Config} from 'metal-state';
import {Soy} from 'metal-soy';

import '../icon/Icon.es';
import templates from './Breadcrumb.soy.js';

class Breadcrumb extends Component {
  attached() {
    Liferay.once('MaterialReady', () => {
      if (Liferay.mdc && this.refs['mdcSimpleMenu']) {
        this.isMenuRequired = true;

        this.attachMDCMenu_();
      }
    });
  }

  attachMDCMenu_() {
    this.mdcMenu = new Liferay.mdc.menu.MDCSimpleMenu(
      this.refs['mdcSimpleMenu']);
  }

  handleOpenMenu_() {
    this.mdcMenu.open = !this.mdcMenu.open
  }

  rendered() {
    if ((core.isNull(this.mdcMenu) || !core.isDef(this.mdcMenu))
      && this.isMenuRequired) {
      this.attachMDCMenu_();
    }
  }
}

Soy.register(Breadcrumb, templates);

/**
 * State definition.
 * @type {!Object}
 * @static
 */
Breadcrumb.STATE = {
  /**
   * CSS classes to be applied to the footer of the modal.
   * @type {String}
   */
  cssClass: Config.string(),

  isMenuRequired: Config.bool().value(false),

  items: Config.array(Config.shapeOf({
    name: Config.string(),
    url: Config.string()
  })),

  maxNumber: Config.number().value(6),

  mdcMenu: Config.object()
};

export default Breadcrumb;