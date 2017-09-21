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
const core_1 = require("@angular/core");
const forms_1 = require("@angular/forms");
const router_1 = require("@angular/router");
const http_1 = require('@angular/http');
require('rxjs/Rx');
require('rxjs/add/operator/finally');
const Observable_1 = require('rxjs/Observable');
let PaymentComponent = class PaymentComponent {
    constructor(router, http, formBuilder, elementRef) {
        this.router = router;
        this.http = http;
        this.formBuilder = formBuilder;
        this.elementRef = elementRef;
        this.total = 345.00;
        this.formConfig = {
            'creditCardType': ['MasterCard', forms_1.Validators.required],
            'creditCard': ['', this.validateCC],
            'paymentDate': '1',
            'securityCode': ['', forms_1.Validators.required]
        };
        this.calculating = false;
        this.previous = {};
    }
    handleSubmit(event) {
        event.preventDefault();
        this.router.navigate(['/review']);
    }
    ngOnInit() {
        this.form = this.formBuilder.group(this.formConfig);
        this.form.valueChanges
            .debounceTime(500)
            .subscribe(data => {
            // TODO : hack.  there are better ways to compare objects and exclude fields!
            if (data.creditCard != this.previous.creditCard ||
                data.creditCardType != this.previous.creditCardType ||
                data.securityCode != this.previous.securityCode) {
                this.updateTotal(data);
            }
            this.previous = data;
        });
    }
    updateTotal(data) {
        let body = JSON.stringify(this.form.value);
        let headers = new http_1.Headers({ 'Content-Type': 'application/json' });
        let options = new http_1.RequestOptions({ headers: headers });
        this.calculating = true;
        this.http.post('/quote/calculate', body, options)
            .map((res) => res.json())
            .finally(() => this.calculating = false)
            .catch((error) => Observable_1.Observable.throw(error.json().error || 'Server error'))
            .subscribe(data => this.total = data.totalPremium);
    }
    ngAfterContentChecked() {
        jQuery.material.init();
        jQuery(this.elementRef.nativeElement).find('.completer-input').addClass('form-control');
    }
    validateCC(c) {
        let value = c.value;
        // accept only digits, dashes or spaces
        if (/[^0-9-\s]+/.test(value))
            return { isValid: 'credit card must only contain digits' };
        // The Luhn Algorithm. It's so pretty.
        var nCheck = 0, nDigit = 0, bEven = false;
        value = value.replace(/\D/g, "");
        for (var n = value.length - 1; n >= 0; n--) {
            var cDigit = value.charAt(n), nDigit = parseInt(cDigit, 10);
            if (bEven) {
                if ((nDigit *= 2) > 9)
                    nDigit -= 9;
            }
            nCheck += nDigit;
            bEven = !bEven;
        }
        return (nCheck % 10) == 0 ? null : { isValid: 'invalid credit card #.' };
    }
};
PaymentComponent = __decorate([
    core_1.Component({
        templateUrl: 'app/payment.component.html'
    }), 
    __metadata('design:paramtypes', [router_1.Router, http_1.Http, forms_1.FormBuilder, core_1.ElementRef])
], PaymentComponent);
exports.PaymentComponent = PaymentComponent;
//# sourceMappingURL=payment.component.js.map