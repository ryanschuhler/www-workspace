'use strict';

import RadioButton from '../input/RadioButton.es';

let component;

describe('RadioButton', () => {
  afterEach(() => {
    if (component) {
      component.dispose();
    }
  });

  it('should render', () => {
    component = new RadioButton({
      id: 'foo',
      name: 'bar'
    });

    expect(component).toMatchSnapshot();
  });
});