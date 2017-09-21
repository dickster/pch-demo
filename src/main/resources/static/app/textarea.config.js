"use strict";
const component_config_1 = require('./component.config');
class TextAreaConfig extends component_config_1.ComponentConfig {
    constructor(options = {}) {
        super(options);
        this.type = 'textarea';
        this.rows = options['rows'];
        this.cols = options['cols'];
    }
}
exports.TextAreaConfig = TextAreaConfig;
//# sourceMappingURL=textarea.config.js.map