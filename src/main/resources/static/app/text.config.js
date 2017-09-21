"use strict";
const component_config_1 = require('./component.config');
class TextConfig extends component_config_1.ComponentConfig {
    constructor(options = {}) {
        super(options);
        this.type = 'text';
        this.inputType = options['inputType'] || '';
    }
}
exports.TextConfig = TextConfig;
//# sourceMappingURL=text.config.js.map