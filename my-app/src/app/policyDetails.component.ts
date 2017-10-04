import {Component, OnInit, ElementRef} from '@angular/core';

import {FormControl, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from "@angular/router";
import {Data} from "./data.store";
import {Policy} from "./policy";


const USER = 'user';
const PASSWORDS = 'passwords';
const PASSWORD = 'password';
const CONFIRM = 'confirm';

// <ol class="breadcrumb">
// <li class="breadcrumb-item active"><a href="#">Policy Details</a></li>
// <!--<li class="breadcrumb-item">Additional Information</a></li>-->
// <!--<li class="breadcrumb-item ">Rating</a></li>-->
// <!--<li class="breadcrumb-item ">Billing</a></li>-->
// <!--<li class="breadcrumb-item ">Confirmation</li>-->
//     </ol>
//

declare var jQuery : any;

@Component({
    selector:'policy-details',
    templateUrl: 'policyDetails.component.html',
    providers: []
})
export class PolicyDetailsComponent implements OnInit {

    form:FormGroup;
    private policy:Policy;

    constructor(
        private data:Data<Policy>,
        private router:Router,
        private formBuilder: FormBuilder,
        private elementRef:ElementRef) { }

    ngOnInit() {

        this.policy = this.data.get();
        this.form = this.formBuilder.group({
            number:['',Validators.required],
            name:['',Validators.required],
            effectiveDate:['',Validators.required],
            expirationDate:['',Validators.required]
            }
        );
        this.form.patchValue(this.policy);
    }

    handleSubmit(event:any) {
        event.preventDefault();
        this.data.put(this.form.value);
        console.log('FORM = ' + JSON.stringify(this.form.value));
        this.router.navigate(['/ai']);
    }

    ngAfterContentChecked() {
        // jQuery(this.elementRef.nativeElement).find('.completer-input').addClass('form-control');
    }



}
