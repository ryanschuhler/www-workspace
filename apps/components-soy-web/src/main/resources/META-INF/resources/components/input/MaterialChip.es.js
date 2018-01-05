import Component from 'metal-component';
import Soy from 'metal-soy';
import {Config} from 'metal-state';

import '../icon/Icon.es';
import templates from './MaterialChip.soy.js';

/**
 * This component renders a Material Chip.
 */
class MaterialChip extends Component {

  deleteButtonClicked_(event) {
    this.emit.call(this, 'chipDeleteClicked', event, this.label);

    if (this.disposeOnDelete) {
      event.preventDefault();
      this.dispose();
    }
  }

}

MaterialChip.STATE = {
  deletable: Config.bool(),
  disposeOnDelete: Config.bool().value(false),
  label: Config.string(),
};

Soy.register(MaterialChip, templates);

export default MaterialChip;