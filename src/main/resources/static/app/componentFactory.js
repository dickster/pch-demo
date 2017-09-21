"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
const core_1 = require('@angular/core');
const forms_1 = require('@angular/forms');
let ComponentFactory = class ComponentFactory {
    constructor() {
    }
    toFormGroup(components) {
        let group = {};
        components.forEach(component => {
            group[component.key] = new forms_1.FormControl(component.value || '', this.getValidators(component), this.getAsyncValidators(component));
        });
        return new forms_1.FormGroup(group);
    }
    getAsyncValidators(component) {
        return [];
    }
    getValidators(component) {
        let result = [];
        if (component.required)
            result.push(forms_1.Validators.required);
        // TODO : remove this...for debugging only.
        //result.push(new NumericValidator());
        if (component.asyncValidators) {
            component.asyncValidators.forEach(validator => {
            });
        }
        if (component.validators) {
            component.validators.forEach(validator => {
            });
        }
        //TODO :  first check for aliases stored in map.  do i want a singleton? do i care? implement a flyweight map?
        //   var x = new window[component.asyncValidators[0]]();
        return result;
    }
};
ComponentFactory = __decorate([
    core_1.Injectable(), 
    __metadata('design:paramtypes', [])
], ComponentFactory);
exports.ComponentFactory = ComponentFactory;
//# sourceMappingURL=componentFactory.js.map