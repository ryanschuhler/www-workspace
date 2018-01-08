'use strict';

import MaterialPagination from '../pagination/MaterialPagination.es';

let component;

describe('MaterialPagination', () => {
  afterEach(() => {
    if (component) {
      component.dispose();
    }
  });

  it('should render', () => {
    component = new MaterialPagination({
      end: '10',
      portletNamespace: 'foo',
      start: '0',
      total: '20'
    });

    expect(component).toMatchSnapshot();
  });
});