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
const component_config_1 = require('./component.config');
const ng2_completer_1 = require("ng2-completer");
// TODO : refactor selector.
let QuestionComponent = class QuestionComponent {
    constructor(completerService) {
        this.completerService = completerService;
        this.dataService = {};
        this.searchData = [
            { value: 'Bob', key: '1754' },
            { value: 'Fred', key: '3972' },
            { value: 'Sally', key: '243' },
            { value: 'Cathy', key: '4948' },
            { value: 'Jim', key: '519' },
            { value: 'Sam', key: '6344' },
            { value: 'Susan', key: '9787' }
        ];
        this.dataService = this.completerService.local(this.searchData, 'value', 'value');
    }
    get isValid() { return this.form.controls[this.question.key].valid; }
    get isPristine() { return this.form.controls[this.question.key].pristine; }
    get isTouched() { return this.form.controls[this.question.key].touched; }
    isVisible(formValue) {
        for (let dependency of this.question.showWhen) {
            let actual = this.form.controls[dependency.parent].value;
            let expected = dependency.value;
            // console.log('show when ' + dependency.parent + ' is ' + dependency.value + ' ('+actual+')');
            if (actual != expected) {
                return false;
            }
        }
        return true;
    }
    isActiveYesNo(control) {
        let result = this.form.controls[control].value == 'yes';
        // console.log('yesno : ' + control + ' --> ' + result + '   (' + this.form.controls[control].value+ ')');
        return result;
    }
    ngOnInit() {
        if (this.question.type != 'autocomplete')
            return;
        console.log('init autocomplete');
        if (this.question['choices']) {
            console.log('...with choices ' + this.question['choices']);
            this.dataService.data(this.question['choices']);
        }
    }
};
__decorate([
    core_1.Input(), 
    __metadata('design:type', component_config_1.ComponentConfig)
], QuestionComponent.prototype, "question", void 0);
__decorate([
    core_1.Input(), 
    __metadata('design:type', forms_1.FormGroup)
], QuestionComponent.prototype, "form", void 0);
QuestionComponent = __decorate([
    core_1.Component({
        //moduleId: module.id,
        // styles:['[ng-reflect-value="2"] { background:pink; }'],
        selector: 'df-question',
        templateUrl: 'app/question.component.html'
    }), 
    __metadata('design:paramtypes', [ng2_completer_1.CompleterService])
], QuestionComponent);
exports.QuestionComponent = QuestionComponent;
//# sourceMappingURL=question.component.js.map