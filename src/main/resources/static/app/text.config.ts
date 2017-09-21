import { ComponentConfig } from './component.config';

export class TextConfig extends ComponentConfig<string> {
    type = 'text';
    inputType : string;

    constructor(options: {} = {}) {
        super(options);
        this.inputType = options['inputType'] || '';
    }
}
