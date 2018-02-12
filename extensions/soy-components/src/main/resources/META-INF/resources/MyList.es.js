import Component from 'metal-component/src/Component';
import Soy from 'metal-soy/src/Soy';

import templates from './MyList.soy.js';

class MyList extends Component {}

Soy.register(MyList, templates);

export default MyList;