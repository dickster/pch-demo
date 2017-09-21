import { ComponentConfig } from './component.config';

export class DropDownConfig extends ComponentConfig<string> {
    type = 'dropdown';
    choices: {key: string, value: string}[] = [];

    constructor(options: {} = {}) {
        super(options);
        // TODO : rename this options.choices
        this.choices = options['choices'] || [];
    }
}
