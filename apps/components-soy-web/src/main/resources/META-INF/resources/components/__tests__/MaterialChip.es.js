'use strict';

import MaterialChip from '../input/MaterialChip.es';

let component;

describe('MaterialChip', () => {
  afterEach(() => {
    if (component) {
      component.dispose();
    }
  });

  it('should render', () => {
    component = new MaterialChip({
      label: 'test'
    });

    expect(component).toMatchSnapshot();
  });
});