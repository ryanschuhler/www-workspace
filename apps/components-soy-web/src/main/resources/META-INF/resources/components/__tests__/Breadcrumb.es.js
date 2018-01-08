'use strict';

import Breadcrumb from '../breadcrumb/Breadcrumb.es';

let component;

describe('Breadcrumb', () => {
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

  it('should render with three items', () => {
    component = new Breadcrumb({
      items: [{
        name: 'item-1',
        url: 'javascript:;'
      },{
        name: 'item-2',
        url: 'javascript:;'
      },{
        name: 'item-3',
        url: 'javascript:;'
      }]
    });

    expect(component).toMatchSnapshot();
  });
});