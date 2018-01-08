'use strict';

import DropdownMenu from '../dropdown-menu/DropdownMenu.es';

let component;

const buttonInnerHtml = 'test-button-content';

const items = [
  '<p>item1</p>',
  '<p>item2</p>',
  '<p>item3</p>'
];

describe('DropdownMenu', () => {
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
    component = new DropdownMenu({
      buttonInnerHtml: buttonInnerHtml,
      items: items
    });

    expect(component).toMatchSnapshot();

    expect(component.items.length).toBe(3);
  });
});