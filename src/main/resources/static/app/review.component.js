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
let ReviewComponent = class ReviewComponent {
    constructor(router, formBuilder) {
        this.router = router;
        this.formBuilder = formBuilder;
    }
    ngOnInit() {
        this.form = this.formBuilder.group({});
    }
    handleSubmit(event) {
        // console.log(this.form.value);
        event.preventDefault();
        this.router.navigate(['/login']);
    }
};
ReviewComponent = __decorate([
    core_1.Component({
        templateUrl: 'app/review.component.html'
    }), 
    __metadata('design:paramtypes', [router_1.Router, forms_1.FormBuilder])
], ReviewComponent);
exports.ReviewComponent = ReviewComponent;
//# sourceMappingURL=review.component.js.map