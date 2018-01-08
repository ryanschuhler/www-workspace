'use strict';

import SelectMenu from '../input/SelectMenu.es';

let component;

describe('SelectMenu', () => {
  afterEach(() => {
    if (component) {
      component.dispose();
    }
  });

  beforeAll(() => {
		window.Liferay = {
			mdc: {
				select: {
					MDCSelect: jest.fn()
				}
			},
			once: jest.fn()
    };
  });

  it('should render', () => {
    component = new SelectMenu({
      name: 'foo',
      options: [{
        label: 'foo',
        value: 'bar'
      }]
    });

    expect(component).toMatchSnapshot();
  });
});