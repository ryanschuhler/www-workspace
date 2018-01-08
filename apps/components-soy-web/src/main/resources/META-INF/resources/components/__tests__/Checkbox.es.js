'use strict';

import Checkbox from '../input/Checkbox.es';

let component;

describe('Checkbox', () => {
  afterEach(() => {
    if (component) {
      component.dispose();
    }
  });

  beforeAll(() => {
		window.Liferay = {
			mdc: {
				menu: {
					MDCSimpleMenu: jest.fn()
				}
			},
			once: jest.fn()
    };
  });

  it('should render checked', () => {
    component = new Checkbox({
      id: 'test',
      checked: true
    });

    expect(component).toMatchSnapshot();
  });
});