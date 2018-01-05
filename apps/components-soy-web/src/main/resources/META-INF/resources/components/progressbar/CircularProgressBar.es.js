import Component from 'metal-component';
import Soy from 'metal-soy';
import {Config} from 'metal-state';

import templates from './CircularProgressBar.soy.js';

const RADIUS = 6;

class CircularProgressBar extends Component {
  setPercentageAndCalcuatedProgress(value) {
    this.calculatedProgress = (value / 100) * (Math.PI * (RADIUS * 2));
    return value;
  }
}

CircularProgressBar.STATE = {
  percentage: Config.number().setter('setPercentageAndCalcuatedProgress'),
  calculatedProgress: Config.number().value(0)
}

Soy.register(CircularProgressBar, templates);

export default CircularProgressBar;