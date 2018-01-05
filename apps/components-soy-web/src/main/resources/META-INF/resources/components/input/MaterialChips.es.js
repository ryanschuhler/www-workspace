import Component from 'metal-component';
import Soy from 'metal-soy';
import {Config} from 'metal-state';

import './MaterialChip.es';
import templates from './MaterialChips.soy.js';

const KeyCodes = {
  BACKSPACE: 8,
  COMMA: 44,
  DELETE: 46,
  ENTER: 13,
  LEFT_ARROW: 37,
  RIGHT_ARROW: 39
};

/**
 * This component renders a Material Chips.
 */
class MaterialChips extends Component {

  attached() {
    this.element.addEventListener('click', () => this.activateChipEdition_());
  }

  created() {
    this.regexAllowedChars = new RegExp(`^[${this.allowedChars}]$`);
    this.regexInvalidChars = new RegExp(`[^${this.allowedChars}]`, 'g');
  }

  activateChipEdition_() {
    if (this.refs['input']) {
      this.refs['input'].focus();
    }
  }

  addChip_() {
    const value = this.refs['input'].value.trim();

    if (!value) {
      return;
    }

    if (!this.chips.includes(value)) {
      this.chips = [...this.chips, value];
    }

    this.refs['input'].value = '';
  }

  isAnyControlKeySelected_({ctrlKey, altKey, shiftKey}) {
    return ctrlKey || altKey || shiftKey;
  }

  onChipDeleteClicked_(event, label) {
    const chipIndex = this.chips.indexOf(label);
    this.removeChipAtIndex_(chipIndex);
  }

  onFakeLinkKeyDown_(event) {
    if (this.isAnyControlKeySelected_(event)) {
      return;
    }

    const {keyCode} = event;

    if (keyCode === KeyCodes.BACKSPACE || keyCode === KeyCodes.DELETE) {
      if (this.selectedIndex >= 0) {
        event.preventDefault();
        this.removeSelectedChip_();
      }
      return;
    }

    if (keyCode === KeyCodes.LEFT_ARROW) {
      this.selectPreviousChip_();
      return;
    }

    if (keyCode === KeyCodes.RIGHT_ARROW) {
      const selected = this.selectNextChip_();
      if (!selected) {
        this.activateChipEdition_();
      }
    }
  }

  onFakeLinkKeyUp_() {
    this.allowChipDeletion = true;
  }

  onInputChange_() {
    this.refs['input'].value = this.refs['input'].value.replace(
      this.regexInvalidChars, '');
    if (this.refs['input'].value) {
      this.allowChipSelection = false;
    }
  }

  onInputKeyDown_(event) {
    if (this.isAnyControlKeySelected_(event)) {
      return;
    }

    const {keyCode} = event;

    if (keyCode === KeyCodes.BACKSPACE) {

      event.stopPropagation();
      if (this.refs['input'].value.length === 0) {
        this.selectLastChip_();
      }
      return;
    }

    if (keyCode === KeyCodes.LEFT_ARROW) {
      if (!this.refs['input'].value) {
        this.selectLastChip_();
      }
    }
  }

  onInputKeyPress_(event) {
    const {keyCode} = event;
    if (keyCode === KeyCodes.ENTER || keyCode === KeyCodes.COMMA) {
      event.preventDefault();
      this.addChip_();
      return;
    }

    if (!this.regexAllowedChars.test(event.key)) {
      event.preventDefault();
    }
  }

  onInputKeyUp_() {
    if (this.refs['input'].value.length === 0) {
      this.allowChipSelection = true;
      this.allowChipDeletion = false;
    }
  }

  refreshSelectedChip_() {
    this.selectChip_(Math.min(this.selectedIndex, this.chips.length - 1));
  }

  removeChipAtIndex_(index) {
    this.chips = [
      ...this.chips.slice(0, index),
      ...this.chips.slice(index + 1)
    ];
  }

  removeSelectedChip_() {
    if (!this.allowChipDeletion) {
      return;
    }

    this.removeChipAtIndex_(this.selectedIndex);
    this.refreshSelectedChip_();
    this.allowChipDeletion = false;

    if (this.chips.length === 0) {
      this.activateChipEdition_();
    }
  }

  selectChip_(index) {
    if (!this.allowChipSelection) {
      return;
    }

    if (index >= 0 && index < this.chips.length) {
      this.selectedIndex = index;
      this.refs['anchor'].focus();
      return true;
    }

    return false;
  }

  selectLastChip_() {
    this.selectChip_(this.chips.length - 1);
  }

  selectNextChip_() {
    return this.selectChip_(this.selectedIndex + 1);
  }

  selectPreviousChip_() {
    return this.selectChip_(this.selectedIndex - 1);
  }

  unselectChip_() {
    this.selectedIndex = -1;
  }

}

MaterialChips.STATE = {
  allowChipSelection: Config.bool().value(true),
  allowChipDeletion: Config.bool().value(false),
  allowedChars: Config.string().value(' A-Za-z0-9_\-'),
  chips: Config.arrayOf(Config.string()),
  selectedIndex: Config.number()
};

Soy.register(MaterialChips, templates);

export default MaterialChips;