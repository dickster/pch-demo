"use strict";
class NumericValidator {
    validate(c) {
        if (isNaN(+c.value)) {
            return { isValid: 'value is not a number' };
        }
        // how to i parameterize this.
        if (c.value < 0 || c.value > 100) {
            return { isValid: 'value must be 0..100' };
        }
        return null;
    }
}
exports.NumericValidator = NumericValidator;
//# sourceMappingURL=numeric.validator.js.map