'use strict';

import Toolbar from '../toolbar/Toolbar.es';

const items = [
  {
    align: 'start',
    content: '<h1>Item One</h1>',
    elementClasses: 'item-1'
  },
  {
    align: 'end',
    content: '<h1>Item Two</h1>',
    elementClasses: 'item-2'
  },
  {
    align: '',
    content: '<h1>Item Three</h1>',
    elementClasses: 'item-3'
  }
];

let component;

describe('Toolbar', () => {
  afterEach(() => {
    if (component) {
      component.dispose();
    }
  });

  beforeAll(() => {
		window.Liferay = {};
  });

  it('should render with items', () => {
    component = new Toolbar({
      items: items
    });

    expect(component).toMatchSnapshot();
  });
});