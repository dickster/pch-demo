import {Component, OnInit, ElementRef} from '@angular/core';

import {FormControl, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from "@angular/router";


const USER = 'user';
const PASSWORDS = 'passwords';
const PASSWORD = 'password';
const CONFIRM = 'confirm';


declare var jQuery : any;

@Component({
    selector:'login-comp',
    templateUrl: 'login.component.html',
    providers: []
})
export class LoginComponent implements OnInit {

    form:FormGroup;
    passwords:FormGroup;

    constructor(
        private router:Router,
        private formBuilder: FormBuilder,
        private elementRef:ElementRef) { }


    ngOnInit() {

        this.passwords = this.formBuilder.group({
                [PASSWORD]: ['', Validators.required],
                [CONFIRM]:  ['', Validators.required]
            },
            {validator: this.matchPassword}
        );
        this.form = this.formBuilder.group({
                [USER]: ['',Validators.required],
                [PASSWORDS] : this.passwords
            }
        );

    }


    handleSubmit(event:any) {
        // console.log(this.form.value);
        event.preventDefault();
        this.router.navigate(['/admin']);
    }

    ngAfterContentChecked() {
        // jQuery(this.elementRef.nativeElement).find('.completer-input').addClass('form-control');
    }

    matchPassword(group:any): any {
        let password = group.controls.password;
        let confirm = group.controls.confirm;

        //console.log(password.value + ' ?= ' + confirm.value);

        if (password.touched && !password.value) {
            return {isValid:'no password entered'};
        }

        //Don't kick in until user touches both fields
        if (password.pristine || confirm.pristine) {
            return null;
        }

        if (password.value != confirm.value) {
            return {isValid: 'passwords dont match'};
        }

        if (password.value.length<5) {
            return { isValid: 'your password is too short'};
        }

        return null;
    }


}
