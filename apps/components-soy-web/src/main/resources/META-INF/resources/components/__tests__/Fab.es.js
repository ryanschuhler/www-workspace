'use strict';

import Fab from '../fab/Fab.es';

let component;

describe('Fab', () => {
  afterEach(() => {
    if (component) {
      component.dispose();
    }
  });

  beforeAll(() => {
		window.Liferay = {};
  });

  it('should render', () => {
    component = new Fab({
      icon: 'add',
      label: 'Add Site'
    });

    expect(component).toMatchSnapshot();
  });

  it('should render with url', () => {
    component = new Fab({
      icon: 'add',
      label: 'Add Site',
      url: 'https://www.google.com/'
    });

    expect(component).toMatchSnapshot();
  });
});
