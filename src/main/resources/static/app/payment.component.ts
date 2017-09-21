import {Component, OnInit, ElementRef} from "@angular/core";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {NgModel, NgFormControl} from "@angular/common";
import {CompleterData, CompleterService} from "ng2-completer";
import { Http, Response, Headers, URLSearchParams , RequestOptions } from '@angular/http';
import 'rxjs/Rx';
import 'rxjs/add/operator/finally';
import {Observable} from 'rxjs/Observable';

declare var jQuery:any;

@Component({
    templateUrl: 'app/payment.component.html'
})
export class PaymentComponent implements OnInit {

    form: FormGroup;
    total: number = 345.00;

    private formConfig:any = {
        'creditCardType':['MasterCard',Validators.required],
        'creditCard':['', this.validateCC],
        'paymentDate': '1',
        'securityCode': ['', Validators.required]
    };
    private calculating : boolean = false;
    private previous: any = {};

    handleSubmit(event:any) {
        event.preventDefault();
        this.router.navigate(['/review']);
    }

    constructor(
        private router: Router,
        private http:Http,
        private formBuilder: FormBuilder,
        private elementRef:ElementRef) {
    }

    ngOnInit() {
        this.form = this.formBuilder.group( this.formConfig );
        this.form.valueChanges
            .debounceTime(500)
            .subscribe(data => {
                // TODO : hack.  there are better ways to compare objects and exclude fields!
                if (data.creditCard!=this.previous.creditCard ||
                    data.creditCardType!=this.previous.creditCardType ||
                    data.securityCode!=this.previous.securityCode) {
                    this.updateTotal(data);
                }
                this.previous = data;
            });
    }

    private updateTotal(data: any) : void {
        let body = JSON.stringify(this.form.value);
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });

        this.calculating = true;

        this.http.post('/quote/calculate', body, options)
            .map((res:Response) =>
                res.json()
            )
            .finally(
                () =>this.calculating=false
            )
            .catch(
                (error: any) => Observable.throw(error.json().error || 'Server error')
            )
            .subscribe(
                data => this.total = data.totalPremium
            );
    }

    ngAfterContentChecked() {
        jQuery.material.init();
        jQuery(this.elementRef.nativeElement).find('.completer-input').addClass('form-control');
    }


    validateCC(c: FormControl) : any {

        let value: string = c.value;
        // accept only digits, dashes or spaces
        if (/[^0-9-\s]+/.test(value)) return {isValid:'credit card must only contain digits'};

        // The Luhn Algorithm. It's so pretty.
        var nCheck = 0, nDigit = 0, bEven = false;
        value = value.replace(/\D/g, "");

        for (var n = value.length - 1; n >= 0; n--) {
            var cDigit = value.charAt(n),
                nDigit = parseInt(cDigit, 10);

            if (bEven) {
                if ((nDigit *= 2) > 9) nDigit -= 9;
            }

            nCheck += nDigit;
            bEven = !bEven;
        }

        return (nCheck % 10) == 0 ? null : {isValid:'invalid credit card #.'};
    }


}
