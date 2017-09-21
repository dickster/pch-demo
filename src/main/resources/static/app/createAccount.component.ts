import {Component, OnInit} from '@angular/core';

import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {Router} from "@angular/router";
import {ControlGroup, NgModel, NgFormControl} from "@angular/common";
import { Response, Http } from '@angular/http';
import 'rxjs/Observable';
import {Observable} from 'rxjs/Rx';
import 'rxjs/add/operator/debounceTime';
import 'rxjs/add/operator/distinctUntilChanged';
import 'rxjs/add/operator/map';

const EMAIL = 'email';
const USERNAME = 'username';


declare var jQuery : any;

@Component({
    selector:'createAccount-comp',
    templateUrl: 'app/createAccount.component.html',
    providers: []
})
export class CreateAccountComponent implements OnInit {

    form:FormGroup;

    constructor(private router:Router, private http:Http, private formBuilder: FormBuilder) { }

    ngOnInit() {
        this.form = this.formBuilder.group({
                 // [EMAIL]: ['',, (control:FormControl) => { return this.checkEmail(control)}],
                [EMAIL]: [''],
                [USERNAME] : ['', Validators.required]
            }
        );
    }

    public checkUniqueEmail(value:string) : Promise<any> {
        this.checkEmail(this.form.controls.email);
    }

    ngAfterContentChecked() {
        jQuery.material.init();
        //jQuery(this.elementRef.nativeElement).find('.completer-input').addClass('form-control');
    }

    private handleSubmit(event:any) {
        // console.log(this.form.value);
        event.preventDefault();
        this.router.navigate(['/login']);
    }

    private checkEmail(control: FormControl): Promise<any> {

        // TODO : throttle this and do caching!!
        const promise :Promise<any> = new Promise<any>((resolve, reject) => {
            this.http.get('/validate/email?email=' + control.value)
                .debounceTime(500)
                // .distinctUntilChanged()
                .map(res => res.json())
                .subscribe(
                    (res: Response) => {
                        console.log(res);
                        this.form.controls.email.setErrors(res.isValid ? null : res);
                        resolve(null);
                    },
                    (err: any) => {
                        console.log(err);
                    }
                )
        });
        return promise;
    }



}
