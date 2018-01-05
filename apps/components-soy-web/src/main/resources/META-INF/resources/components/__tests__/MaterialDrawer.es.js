'use strict';

import MaterialDrawer from '../drawer/MaterialDrawer.es';

let component;

describe('MaterialDrawer', () => {
  afterEach(() => {
    if (component) {
      component.dispose();
    }
  });

  beforeAll(() => {
		window.Liferay = {};
  });

  it('should render', () => {
    component = new MaterialDrawer();

    expect(component).toMatchSnapshot();
  });
});
