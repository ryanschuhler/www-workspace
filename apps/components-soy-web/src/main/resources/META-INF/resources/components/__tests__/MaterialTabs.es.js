'use strict';

import MaterialTabs from '../tabs/MaterialTabs.es';

const tabs = [
  {
    active: true,
    label: 'Current Tab',
    url: 'javascript:;'
  },
  {
    active: false,
    label: 'button 2',
    url: 'javascript:;'
  }
];

let component;

describe('MaterialTabs', () => {
  afterEach(() => {
    if (component) {
      component.dispose();
    }
  });

  beforeAll(() => {
		window.Liferay = {};
  });

  it('should render', () => {
    component = new MaterialTabs({
      items: tabs
    });

    expect(component).toMatchSnapshot();
  });
});