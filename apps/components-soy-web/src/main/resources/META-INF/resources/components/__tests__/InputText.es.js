'use strict';

import InputText from '../input/InputText.es';

let component;

describe('InputText', () => {
  afterEach(() => {
    if (component) {
      component.dispose();
    }
  });

  it('should render', () => {
    component = new InputText({
      name: 'test'
    });

    expect(component).toMatchSnapshot();
  });
});