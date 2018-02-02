import Component from 'metal-component/src/Component';
import Soy from 'metal-soy/src/Soy';

import templates from './Test.soy';

/**
 * Test Component
 */
class Test extends Component {}

Soy.register(Test, templates);

export default Test;