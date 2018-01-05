'use strict';

import Snackbar from '../snackbar/Snackbar.es';

let component;

describe('Snackbar', () => {
  afterEach(() => {
    if (component) {
      component.dispose();
    }
  });

  beforeAll(() => {
		window.Liferay = {
			mdc: {
				snackbar: {
					MDCSnackbar: {
            attachTo: jest.fn()
          }
				}
			},
			once: jest.fn()
    };
  });

  it('should render checked', () => {
    component = new Snackbar({
      actionText: 'barr',
      alignStart: true,
      message: 'foo'
    });

    expect(component).toMatchSnapshot();
  });
});