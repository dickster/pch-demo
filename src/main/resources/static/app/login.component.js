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
const USER = 'user';
const PASSWORDS = 'passwords';
const PASSWORD = 'password';
const CONFIRM = 'confirm';
let LoginComponent = class LoginComponent {
    constructor(router, formBuilder, elementRef) {
        this.router = router;
        this.formBuilder = formBuilder;
        this.elementRef = elementRef;
    }
    ngOnInit() {
        this.passwords = this.formBuilder.group({
            [PASSWORD]: ['', forms_1.Validators.required],
            [CONFIRM]: ['', forms_1.Validators.required]
        }, { validator: this.matchPassword });
        this.form = this.formBuilder.group({
            [USER]: ['', forms_1.Validators.required],
            [PASSWORDS]: this.passwords
        });
    }
    handleSubmit(event) {
        // console.log(this.form.value);
        event.preventDefault();
        this.router.navigate(['/insured']);
    }
    ngAfterContentChecked() {
        jQuery.material.init();
        jQuery(this.elementRef.nativeElement).find('.completer-input').addClass('form-control');
    }
    matchPassword(group) {
        let password = group.controls.password;
        let confirm = group.controls.confirm;
        //console.log(password.value + ' ?= ' + confirm.value);
        if (password.touched && !password.value) {
            return { isValid: 'no password entered' };
        }
        //Don't kick in until user touches both fields
        if (password.pristine || confirm.pristine) {
            return null;
        }
        if (password.value != confirm.value) {
            return { isValid: 'passwords dont match' };
        }
        if (password.value.length < 5) {
            return { isValid: 'your password is too short' };
        }
        return null;
    }
};
LoginComponent = __decorate([
    core_1.Component({
        selector: 'login-comp',
        templateUrl: 'app/login.component.html',
        providers: []
    }), 
    __metadata('design:paramtypes', [router_1.Router, forms_1.FormBuilder, core_1.ElementRef])
], LoginComponent);
exports.LoginComponent = LoginComponent;
//# sourceMappingURL=login.component.js.map