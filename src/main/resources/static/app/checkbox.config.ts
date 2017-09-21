import { ComponentConfig } from './component.config';

export class CheckBoxConfig extends ComponentConfig<string> {
    type = 'checkbox';

    constructor(options: {} = {}) {
        super(options);
    }
}
