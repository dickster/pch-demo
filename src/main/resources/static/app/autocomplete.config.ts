import { ComponentConfig } from './component.config';

export class AutocompleteConfig extends ComponentConfig<string> {
    type = 'autocomplete';
    choices: {key: string, value: string}[] = [];
    minSearchLength : number;

    constructor(options: {} = {}) {
        super(options);
        this.choices = options['choices'] || [];
        this.minSearchLength = options['minSearchLength'] || 1;
    }
}
