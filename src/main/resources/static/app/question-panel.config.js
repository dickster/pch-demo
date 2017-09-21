"use strict";
const component_config_1 = require('./component.config');
class QuestionPanelConfig extends component_config_1.ComponentConfig {
    constructor(options = {}) {
        super(options);
        this.type = 'panel';
        this.children = options['children'] || [];
    }
}
exports.QuestionPanelConfig = QuestionPanelConfig;
//# sourceMappingURL=question-panel.config.js.map