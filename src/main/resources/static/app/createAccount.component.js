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
const http_1 = require('@angular/http');
require('rxjs/Observable');
require('rxjs/add/operator/debounceTime');
require('rxjs/add/operator/distinctUntilChanged');
require('rxjs/add/operator/map');
const EMAIL = 'email';
const USERNAME = 'username';
let CreateAccountComponent = class CreateAccountComponent {
    constructor(router, http, formBuilder) {
        this.router = router;
        this.http = http;
        this.formBuilder = formBuilder;
    }
    ngOnInit() {
        this.form = this.formBuilder.group({
            // [EMAIL]: ['',, (control:FormControl) => { return this.checkEmail(control)}],
            [EMAIL]: [''],
            [USERNAME]: ['', forms_1.Validators.required]
        });
    }
    checkUniqueEmail(value) {
        this.checkEmail(this.form.controls.email);
    }
    ngAfterContentChecked() {
        jQuery.material.init();
        //jQuery(this.elementRef.nativeElement).find('.completer-input').addClass('form-control');
    }
    handleSubmit(event) {
        // console.log(this.form.value);
        event.preventDefault();
        this.router.navigate(['/login']);
    }
    checkEmail(control) {
        // TODO : throttle this and do caching!!
        const promise = new Promise((resolve, reject) => {
            this.http.get('/validate/email?email=' + control.value)
                .debounceTime(500)
                .map(res => res.json())
                .subscribe((res) => {
                console.log(res);
                this.form.controls.email.setErrors(res.isValid ? null : res);
                resolve(null);
            }, (err) => {
                console.log(err);
            });
        });
        return promise;
    }
};
CreateAccountComponent = __decorate([
    core_1.Component({
        selector: 'createAccount-comp',
        templateUrl: 'app/createAccount.component.html',
        providers: []
    }), 
    __metadata('design:paramtypes', [router_1.Router, http_1.Http, forms_1.FormBuilder])
], CreateAccountComponent);
exports.CreateAccountComponent = CreateAccountComponent;
//# sourceMappingURL=createAccount.component.js.map