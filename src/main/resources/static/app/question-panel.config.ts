import { ComponentConfig } from './component.config';

export class QuestionPanelConfig extends ComponentConfig<any> {
    type = 'panel';
    children : ComponentConfig<any>[];

    constructor(options: {} = {}) {
        super(options);
        this.children = options['children'] || [];
    }
}
