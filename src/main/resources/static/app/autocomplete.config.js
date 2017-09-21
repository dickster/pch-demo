"use strict";
const component_config_1 = require('./component.config');
class AutocompleteConfig extends component_config_1.ComponentConfig {
    constructor(options = {}) {
        super(options);
        this.type = 'autocomplete';
        this.choices = [];
        this.choices = options['choices'] || [];
        this.minSearchLength = options['minSearchLength'] || 1;
    }
}
exports.AutocompleteConfig = AutocompleteConfig;
//# sourceMappingURL=autocomplete.config.js.map