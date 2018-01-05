import {Config} from 'metal-state';

import Component from 'metal-component';
import Soy from 'metal-soy';

import templates from './InputText.soy.js';

const INPUT_TYPES = [
  'button',
  'checkbox',
  'color',
  'date',
  'datetime-local',
  'datetime',
  'email',
  'file',
  'hidden',
  'image',
  'month',
  'number',
  'password',
  'radio',
  'reset',
  'search',
  'step',
  'submit',
  'tel',
  'tel',
  'text',
  'time',
  'url',
  'value',
  'week'
];

/**
 * This component renders a Fab button.
 */
class InputText extends Component {
  /**
   * @inheritDoc
   */
  attached() {
    this.updateCurrentInputLength_(this.refs['input']);

    this.isInputInvalid = this.isInputInvalid_();
  }

  /**
   * @inheritDoc
   */
  rendered() {
    this.updateCurrentInputLength_(this.refs['input']);

    this.isInputInvalid = this.isInputInvalid_();
  }

  setPristine() {
    this.refs['input'].classList.add('pristine');
    this.value = '';
  }

  setInvalidAndIsInvalid() {
    this.isInputInvalid = this.isInputInvalid_();

    if (this.isInputInvalid != this.invalid) {
      this.invalid = this.isInputInvalid;
    }
  }

  getValue() {
    return this.refs.input.value;
  }

  handleInput_({target}) {

    this.setDirty_();

    this.updateCurrentInputLength_(target);

    this.setInvalidAndIsInvalid();

    if (this.onChange) {
      this.onChange(target.value);
    }
  }

  handleBlur_({target}) {
    this.setInvalidAndIsInvalid();

    if (this.onBlur) {
      this.onBlur(target.value);
    }
  }

  isInputInvalid_() {
    if (this.maxLength) {
      if (this.currentInputLength > this.maxLength) {
        return true;
      }
    }

    if (this.required) {
      if (!this.pristine && this.currentInputLength === 0) {
        return true;
      }
    }

    return false;
  }

  isPristine_() {
    return this.refs['input'].classList.contains('pristine');
  }

  setDirty_() {
    this.refs['input'].classList.remove('pristine');
  }

  updateCurrentInputLength_(element) {
    this.pristine = this.isPristine_();
    this.currentInputLength = element.value.trim().length;
  }
}

InputText.STATE = {
  /**
   * Current length of input
   * @type {Number}
   */
  currentInputLength: Config.number(),

  /**
   * Is input invalid
   * @type {bool}
   */
  isInputInvalid: Config.bool().value(false),

  /**
   * Max length of input
   * @type {Number}
   */
  maxLength: Config.number(),

  /**
   * Max length message to show if length is over max limit
   * @type {String}
   */
  maxLengthMessage: Config.string(),

  onBlur: Config.func(),

  onChange: Config.func(),

  pristine: Config.bool().value(true),

  /**
   * Value of input
   * @type {String}
   */
  value: Config.string().value(''),

  /**
   * Type of input
   * @type {Object}
   */
  type: Config.oneOf(INPUT_TYPES)
};

Soy.register(InputText, templates);

export default InputText;