"use strict";
const component_config_1 = require('./component.config');
class DropDownConfig extends component_config_1.ComponentConfig {
    constructor(options = {}) {
        super(options);
        this.type = 'dropdown';
        this.choices = [];
        // TODO : rename this options.choices
        this.choices = options['choices'] || [];
    }
}
exports.DropDownConfig = DropDownConfig;
//# sourceMappingURL=dropdown.config.js.map