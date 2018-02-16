import Component from 'metal-component/src/Component';
import Soy from 'metal-soy/src/Soy';

import Footer from './Footer.es';
import Header from './Header.es';
import MyList from 'soy-components/MyList.es';
import templates from './View.soy';

/**
 * View Component
 */
class View extends Component {}

// Register component
Soy.register(View, templates);

export default View;