import { ComponentConfig } from './component.config';

export class TextAreaConfig extends ComponentConfig<string> {
    type = 'textarea';
    rows:number;
    cols:number;

    constructor(options: {} = {}) {
        super(options);
        this.rows = options['rows'];
        this.cols = options['cols'];
    }
}
