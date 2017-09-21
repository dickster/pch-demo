import { ComponentConfig } from './component.config';

export class YesNoConfig extends ComponentConfig<string> {
    type = 'yesno';

    constructor(options: {} = {}) {
        super(options);
    }
}
