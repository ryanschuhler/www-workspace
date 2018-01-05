'use strict';

import MaterialModal from '../modal/MaterialModal.es';
import dom from 'metal-dom';

const alertButtonOne = () => 'button 1';
const alertButtonTwo = () => 'button 2';

const buttons = [
  {
    elementClasses: 'button-1',
    handleOnClickFn: alertButtonOne,
    label: 'button 1',
    type: 'button'
  },
  {
    elementClasses: 'button-2',
    handleOnClickFn: alertButtonTwo,
    label: 'button 2',
    type: 'button'
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
        visible: false
      });

      checkClosedClasses(component);
    });

    it('should render visible', () => {
      component = new MaterialModal({
        visible: true
      });

      checkOpenClasses(component);
    });
  });

  it('should render', () => {
    component = new MaterialModal();

    expect(component).toMatchSnapshot();
  });

  it('should render with buttons', () => {
    component = new MaterialModal({
      buttons: buttons
    });

    expect(component).toMatchSnapshot();
  });

  it('should render with content', () => {
    component = new MaterialModal({
      content: '<h1>hello world</h1>',
      contentId: 'dummyContent'
    });

    expect(component).toMatchSnapshot();
  });
});

