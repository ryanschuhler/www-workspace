'use strict';

import MaterialChips from '../input/MaterialChips.es';

let component;

const chips = [
  'chip1',
  'chip2',
  'chip3'
]

describe('MaterialChips', () => {
  afterEach(() => {
    if (component) {
      component.dispose();
    }
  });

  it('should render', () => {
    component = new MaterialChips({
      chips: chips
    });

    expect(component).toMatchSnapshot();
  });
});