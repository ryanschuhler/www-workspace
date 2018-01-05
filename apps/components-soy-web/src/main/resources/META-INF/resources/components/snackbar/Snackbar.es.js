import Component from 'metal-component';
import core from 'metal';
import Soy from 'metal-soy';
import {Config} from 'metal-state';

import templates from './Snackbar.soy.js';

const noop = () => undefined;

class Snackbar extends Component {
  attached() {
    if (Liferay.mdc) {
      this.configure();
    } else {
      Liferay.once('MaterialReady', ({mdc}) => {
        this.configure();
      });
    }

    this.on('messageChanged', ({newVal}) => {
      if (core.isDefAndNotNull(newVal) && newVal.trim() != '') {
        if (core.isNull(this.snackbar)) {
          this.configure();
        }

        this.snackbar.show({
          actionHandler: (event) => {
            if (this.actionHandler) {
              this.actionHandler(event);
            }
          },
          actionOnBottom: this.actionOnBottom,
          actionText: this.actionText,
          message: newVal,
          multiline: this.multiline,
          timeout: this.timeout
        });
      }
    })
  }

  configure() {
    this.snackbar = Liferay.mdc.snackbar.MDCSnackbar.attachTo(
        this.refs['mdcSnackbar']);
  }

  show(message, timeout, actionText, actionHandler, multiline, actionOnBottom) {
    this.snackbar.show({
      actionHandler: actionHandler || noop,
      actionOnBottom: actionOnBottom,
      actionText: actionText || 'DISMISS',
      message: message,
      multiline: multiline,
      timeout: timeout
    });
  }
}

Snackbar.STATE = {
  actionHandler: Config.func(),
  actionHandlerParameter: Config.object(),
  actionOnBottom: Config.bool().value(false),
  actionText: Config.string().value('DISMISS'),
  alignStart: Config.bool().value(true),
  message: Config.string(),
  multiline: Config.bool().value(false),
  timeout: Config.number().value(2750)
}

Soy.register(Snackbar, templates);

export default Snackbar;