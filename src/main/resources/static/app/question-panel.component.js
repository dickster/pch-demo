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
const componentFactory_1 = require('./componentFactory');
let QuestionPanelComponent = class QuestionPanelComponent {
    constructor(qcs) {
        this.qcs = qcs;
        this.questions = [];
    }
    ngOnInit() {
        this.form = this.qcs.toFormGroup(this.questions);
    }
};
__decorate([
    core_1.Input(), 
    __metadata('design:type', Array)
], QuestionPanelComponent.prototype, "questions", void 0);
QuestionPanelComponent = __decorate([
    core_1.Component({
        // moduleId: module.id,
        selector: 'question-panel',
        templateUrl: 'app/question-panel.component.html',
        providers: [componentFactory_1.ComponentFactory]
    }), 
    __metadata('design:paramtypes', [componentFactory_1.ComponentFactory])
], QuestionPanelComponent);
exports.QuestionPanelComponent = QuestionPanelComponent;
//# sourceMappingURL=question-panel.component.js.map