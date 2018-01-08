import Component from 'metal-component';
import {Config} from 'metal-state';
import {Soy} from 'metal-soy';

import templates from './DatePicker.soy.js';

/**
 * This component renders a Date Picker.
 */
class DatePicker extends Component {

  attached() {
    this.config = {
      dateFormat: this.dateFormat || 'm/d/Y',
      maxDate: this.maxDate || null,
      minDate: this.minDate || null,
      onChange: (selectedDates, dateString) => {
        this.dateChanged_(dateString, selectedDates[0]);
      }
    };

    Liferay.Loader.require(
      'flatpickr',
      Flatpickr => {
        this.flatpickr = new Flatpickr(this.refs['input'], this.config);

        this.on('minDateChanged', ({newVal}) => {
          this.flatpickr.set('minDate', newVal);
        });

        this.on('maxDateChanged', ({newVal}) => {
          this.flatpickr.set('maxDate', newVal);
        });
      },
      error => console.log(error)
    );
  }

  focusOnInput() {
    this.refs['input'].focus()
  }

  dateChanged_(newValueString, newValueDate) {
    this.emit.call(this, 'dateChange', newValueString, newValueDate);
  }

  disposed() {
    this.flatpickr.destroy();
  }
}

DatePicker.STATE = {
  cssClass: Config.string(),
  config: Config.object(),
  id: Config.string().required(),
  dateFormat: Config.string(),
  maxDate: Config.string(),
  minDate: Config.string(),
  value: Config.string(),
};

Soy.register(DatePicker, templates);

export default DatePicker;