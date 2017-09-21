"use strict";
class ComponentConfig {
    constructor(options = {}) {
        this.asyncValidators = options.asyncValidators;
        this.validators = options.validators;
        this.value = options.value;
        this.key = options.key || '';
        this.label = options.label || '';
        this.required = !!options.required;
        this.order = options.order === undefined ? 1 : options.order;
        this.type = options.type || '';
        this.css = options.css || '';
        this.showWhen = options.showWhen || [];
        this.placeholder = options.placeholder || '';
    }
}
exports.ComponentConfig = ComponentConfig;
//# sourceMappingURL=component.config.js.map