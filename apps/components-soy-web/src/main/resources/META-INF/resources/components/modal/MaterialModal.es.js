import Component from 'metal-component';
import dom from 'metal-dom';
import Soy from 'metal-soy';
import core from 'metal';
import {Config} from 'metal-state';
import {EventHandler} from 'metal-events';

import templates from './MaterialModal.soy.js';

const KEY_CODE_ESC = 27;

/**
 * This component renders a modal. This
 * component is used whenever a modal is needed.
 * https://material.io/components/web/catalog/dialogs/
 */
class MaterialModal extends Component {

  attached() {
    this.on('visibleChanged', ({newVal}) => this.updateVisibleState_({newVal}));
  }

  cancel() {
    this.hide();
  }

  created() {
    this.eventHandler_ = new EventHandler();
  }

  detached() {
    this.updateVisibleState_(false);
    super.detached();
  }

  handleKeyup_(event) {
    if (event.keyCode === KEY_CODE_ESC) {
      if (core.isDefAndNotNull(this.cancel_message)) {
        if (window.confirm(this.cancel_message)) {
          this.hide();
        }
      } else {
        this.hide();
      }
    }
  }

  hide() {
    this.visible = false;
  }

  show() {
    this.visible = true;
  }

  /**
   * Runs every time the visible state attribute updates.
   */
  updateVisibleState_(newVal) {
    if (newVal) {
      document.body.classList.add('mdc-dialog-scroll-lock');

      this.eventHandler_.add(
        dom.on(document, 'keyup', this.handleKeyup_.bind(this)));
    } else {
      document.body.classList.remove('mdc-dialog-scroll-lock');

      this.eventHandler_.removeAllListeners();

      for (let ref in this.refs) {
        if (core.isDefAndNotNull(this.refs[ref].setPristine)) {
          this.refs[ref].setPristine();
        }
      }
    }

    return newVal;
  }

  show() {
    this.visible = true;
  }

  hide() {
    this.visible = false;
  }
}

Soy.register(MaterialModal, templates);

/**
 * State definition.
 * @type {!Object}
 * @static
 */
MaterialModal.STATE = {
  /**
   * WAI-ARIA ariaDescribedBy atribute.
   * @type {String}
   */
  ariaDescribedBy: Config.string(),

  /**
   * WAI-ARIA ariaLabeledBy atribute.
   * @type {String}
   */
  ariaLabeledBy: Config.string(),

  /**
   * Buttons list.
   * @instance
   * @memberof TabularList
   * @type {!array}
   * @default undefined
   */
  buttons: Config.array(),

  /**
   * CSS classes to be applied to the container of the modal.
   * @type {String}
   */
  cancel_message: Config.string(),

  /**
   * CSS classes to be applied to the container of the modal.
   * @type {String}
   */
  containerElementClasses: Config.string(),

  /**
   * MaterialModal container Id.
   * @type {String}
   */
  containerId: Config.string(),

  /**
   * MaterialModal content.
   * @type {String|Html}
   */
  content: Config.any(),

  /**
   * CSS classes to be applied to the content of the modal.
   * @type {String}
   */
  contentElementClasses: Config.string(),

  /**
   * MaterialModal content Id.
   * @type {String}
   */
  contentId: Config.string(),

  /**
   * CSS classes to be applied to the footer of the modal.
   * @type {String}
   */
  footerElementClasses: Config.string(),

  /**
   * MaterialModal footer Id.
   * @type {String}
   */
  footerId: Config.string(),

  /**
   * CSS classes to be applied to the header of the modal.
   * @type {String}
   */
  headerElementClasses: Config.string(),

  /**
   * MaterialModal header Id.
   * @type {String}
   */
  headerId: Config.string(),

  /**
   * MaterialModal state.
   * @type {Boolean}
   */
  scrollable: Config.bool().value(false),

  /**
   * MaterialModal header title.
   * @type {String}
   */
  title: Config.string(),

  /**
   * MaterialModal type. Available types are: 'button', 'reset' and 'submit'
   * @type {String}
   */
  type: Config.oneOf(['navigation', 'form', 'view']).value('view'),

  /**
   * Wether the modal is visible or not
   * @type {Boolean}
   */
  visible: {
    setter: 'updateVisibleState_',

    validator: val => core.isBoolean(val)
  }
};

export default MaterialModal;