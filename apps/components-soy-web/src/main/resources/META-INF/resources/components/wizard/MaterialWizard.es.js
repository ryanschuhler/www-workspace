import core, {async} from 'metal';
import {Config} from 'metal-state';
import {EventHandler} from 'metal-events';
import Component from 'metal-component';
import dom from 'metal-dom';
import Soy from 'metal-soy';

import templates from './MaterialWizard.soy.js';

const KEY_CODE_ESC = 27;

/**
 * This component renders a wizard modal. This
 * component is used whenever a wizard modal is needed.
 * Based on material modal.
 */
class MaterialWizard extends Component {
  /**
   * @inheritDoc
   */
  created() {
    this.eventHandler_ = new EventHandler();

    this.visible = false;
  }

  /**
   * @inheritDoc
   */
  attached() {
    this.setState({
      currentPageIndex: 0,
      isFormValid: false
    });

    this.on('visibleChanged', ({newVal}) => this.updateVisibleState_({newVal}));

    this.validateForm_();
  }

  /**
   * @inheritDoc
   */
  detached() {
    super.detached();
    this.eventHandler_.removeAllListeners();
  }

  /**
   * If Wizard contains child components, validate form when child component
   * state changes
   */
  attachComponentStateEvents_() {
    const componentsArray = Object.values(this.components);

    if (componentsArray.length > 0) {
      componentsArray.forEach(component => this.eventHandler_.add(
        component.on('stateChanged', this.validateForm_.bind(this))));
    }
  }

  back() {
    this.currentPageIndex--;

    this.validateForm_();
  }

  cancel() {
    this.hide();
  }

  /**
   * Get current page of Wizard
   */
  getCurrentPage_() {
    return this.pages[this.currentPageIndex];
  }

  /**
   * Handle keyup
   * @param {Number} keycode of input
   */
  handleDocumentKeyup_({keyCode}) {
    if (keyCode === KEY_CODE_ESC) {
      this.hide();
    }
  }

  hide() {
    this.visible = false;
  }

  isLastPage_() {
    return this.currentPageIndex == this.pages.length - 1;
  }

  /**
   * Navigate to next page
   */
  next() {
    async.nextTick(() => this.validateForm_());

    if (!this.isFormValid) {
      return;
    } else if (this.isLastPage_()) {
      this.handleModalDoneAction();
    } else {
      this.currentPageIndex++;

    }
  }

  /**
   * Set disabled state of button based on boolean
   * @param {boolean} isDisabled
   */
  setButtonIsDisabled_(isDisabled) {
    this.refs['wizzardControlButton'].disabled = isDisabled;
  }

  /**
   * Runs every time the visible state attribute updates.
   * @param {boolean} newVal
   */
  updateVisibleState_(newVal) {
    if (newVal) {
      document.body.classList.add('mdc-dialog-scroll-lock');

      this.attachComponentStateEvents_();

      this.eventHandler_.add(
        dom.on(document, 'keyup', this.handleDocumentKeyup_.bind(this)))
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

  /**
   * Validate Form
   */
  validateForm_() {
    let valid = true;

    let currentPage = this.getCurrentPage_();

    if (currentPage && currentPage.validate) {
      valid = currentPage.validate();
    }

    if (valid != this.isFormValid) {
      this.isFormValid = valid;
    }

    this.setButtonIsDisabled_(!valid);
  }
}

Soy.register(MaterialWizard, templates);

/**
 * State definition.
 * @type {!Object}
 * @static
 */
MaterialWizard.STATE = {
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
   * CSS classes to be applied to the container of the modal.
   * @type {String}
   */
  containerElementClasses: Config.string(),

  /**
   * MaterialWizard container Id.
   * @type {String}
   */
  containerId: Config.string(),

  /**
   * CSS classes to be applied to the content of the modal.
   * @type {String}
   */
  contentElementClasses: Config.string(),

  /**
   * MaterialWizard content Id.
   * @type {String}
   */
  contentId: Config.string(),

  /**
   * Current page index.
   * @type {Number}
   */
  currentPageIndex: Config.number().value(0),

  /**
   * CSS classes to be applied to the footer of the modal.
   * @type {String}
   */
  footerElementClasses: Config.string(),

  /**
   * MaterialWizard footer Id.
   * @type {String}
   */
  footerId: Config.string(),

  /**
   * The function to be called when the DONE button is clicked.
   */
  handleModalDoneAction: Config.func(),

  /**
   * CSS classes to be applied to the header of the modal.
   * @type {String}
   */
  headerElementClasses: Config.string(),

  /**
   * MaterialWizard header Id.
   * @type {String}
   */
  headerId: Config.string(),

  /**
   * Is form valid
   * @type {Boolean}
   */
  isFormValid: Config.bool().value(true),

  /**
   * Pages list.
   * @instance
   * @memberof TabularList
   * @type {!array}
   * @default undefined
   */
  pages: Config.array(),

  /**
   * MaterialWizard state.
   * @type {Boolean}
   */
  scrollable: Config.bool().value(false),

  /**
   * MaterialWizard type. Available types are: 'button', 'reset' and 'submit'
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

export default MaterialWizard;