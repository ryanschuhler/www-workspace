

'use strict';

import CircularProgressBar from '../progressbar/CircularProgressBar.es';

let component;

const buttonInnerHtml = 'test-button-content';

describe('CircularProgressBar', () => {
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

  it('should render with 25%', () => {
    component = new CircularProgressBar({
      calculatedProgress: 25
    });

    expect(component).toMatchSnapshot();
  });
});