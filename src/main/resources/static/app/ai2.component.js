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
const router_1 = require("@angular/router");
const question_service_1 = require("./question.service");
let Ai2Component = class Ai2Component {
    constructor(router, formBuilder, elementRef, service) {
        this.router = router;
        this.formBuilder = formBuilder;
        this.elementRef = elementRef;
        this.service = service;
        this.questions = service.getMoreQuestions();
    }
    ngOnInit() {
        this.form = this.formBuilder.group({});
    }
    ngAfterContentChecked() {
        // TODO  : move these hacks to a better spot.  common for all application.
        jQuery.material.init();
        jQuery(this.elementRef.nativeElement).find('.completer-input').addClass('form-control');
    }
    handleSubmit(event) {
        this.router.navigate(['/payment']);
    }
};
Ai2Component = __decorate([
    core_1.Component({
        templateUrl: 'app/ai2.component.html',
        providers: [question_service_1.QuestionService]
    }), 
    __metadata('design:paramtypes', [router_1.Router, forms_1.FormBuilder, core_1.ElementRef, question_service_1.QuestionService])
], Ai2Component);
exports.Ai2Component = Ai2Component;
//# sourceMappingURL=ai2.component.js.map