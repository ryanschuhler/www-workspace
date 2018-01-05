'use strict';

import MaterialModal from '../modal/MaterialModal.es';
import dom from 'metal-dom';

const pages = [
  {
    content: '<p>foo</p>',
    title: 'foo'
  },
  {
    content: '<p>barr</p>',
    title: 'barr'
  }
];

let component;

describe('MaterialModal', () => {
  afterEach(() => {
    if (component) {
      component.dispose();
    }
  });

  beforeAll(() => {
		window.Liferay = {};
  });

  function checkClosedClasses(component) {
    expect(!dom.hasClass(component.element, 'mdc-dialog--open')).toBeTruthy();
    expect(
      !dom.hasClass(component.element, 'mdc-dialog--animating')).toBeTruthy();

  }

  function checkOpenClasses(component) {
    expect(dom.hasClass(component.element, 'mdc-dialog--open')).toBeTruthy();
    expect(
      dom.hasClass(component.element, 'mdc-dialog--animating')).toBeTruthy();
  }

  describe('Content State', () => {
    it('should render not visible', () => {
      component = new MaterialModal({
        pages: pages,
        visible: false
      });

      checkClosedClasses(component);
    });

    it('should render visible', () => {
      component = new MaterialModal({
        pages: pages,
        visible: true
      });

      checkOpenClasses(component);
    });
  });

  it('should render', () => {
    component = new MaterialModal({
      pages: pages
    });

    expect(component).toMatchSnapshot();
  });
});

