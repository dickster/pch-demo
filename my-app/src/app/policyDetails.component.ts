import {Component, OnInit, ElementRef} from '@angular/core';

import {FormControl, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from "@angular/router";


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

    constructor(
        private router:Router,
        private formBuilder: FormBuilder,
        private elementRef:ElementRef) { }


    ngOnInit() {

        this.form = this.formBuilder.group({
            }
        );
    }

    handleSubmit(event:any) {
        // console.log(this.form.value);
        event.preventDefault();
        this.router.navigate(['/ai']);
    }

    ngAfterContentChecked() {
        // jQuery(this.elementRef.nativeElement).find('.completer-input').addClass('form-control');
    }



}
