'use strict';

import flatpickr from 'flatpickr';

import DatePicker from '../input/DatePicker.es';

let component;

describe('DatePicker', () => {
  afterEach(() => {
    if (component) {
      component.dispose();
    }
  });

  beforeAll(() => {
		window.Liferay = {
      Loader: {
        require: jest.fn()
      }
    };
  });

  it('should render', () => {
    component = new DatePicker({
      id: 'foo'
    });

    component.flatpickr = new flatpickr(component.refs['input']);

    expect(component).toMatchSnapshot();
  });

  it('should render with date format m/d/Y', () => {
    component = new DatePicker({
      dateFormat: 'm/d/Y',
      id: 'foo'
    });

    let input = component.refs['input'];

    component.flatpickr = new flatpickr(input);

    expect(input.getAttribute('data-date-format')).toBe('m/d/Y');
  });
});