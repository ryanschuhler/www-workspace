'use strict';

import Icon from '../icon/Icon.es';

let component;

describe('Icon', () => {
  afterEach(() => {
    if (component) {
      component.dispose();
    }
  });

  beforeAll(() => {
		window.Liferay = {};
  });

  it('should render material-icon', () => {
    component = new Icon({
      isMaterialIcon: true,
      symbol: 'add'
    });

    expect(component).toMatchSnapshot();
  });
});
