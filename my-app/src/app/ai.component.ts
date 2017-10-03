import {Component, NgModule, OnInit } from '@angular/core';

import { FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from "@angular/router";
import {Policy} from "./policy";
import {Data} from "./data.store";

import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';


const Q1 = 'q1';
const Q2 = 'q2';
const Q1_DESC = 'q1_desc';
const Q2_DESC = 'q2_desc';

@Component({
    selector:'ai',
    templateUrl: 'ai.component.html',
    providers: []
})
export class AIComponent implements OnInit {

    public policy:Policy;
    private form:FormGroup;

    constructor(
        private formBuilder: FormBuilder,
        private data:Data<Policy>,
        private router:Router
       ) {
            this.policy = this.data.get();
            this.form = this.formBuilder.group({
                q1:[''],
                q2:[''],
                [Q1_DESC]:[],
                [Q2_DESC]:[]
            });
            this.form.patchValue(this.policy);
    }

    ngOnInit() {

    }

    public isRadio(value:string) {
        return 'true'==value;
    }

    public isNotRadio(value:string) {
        return 'true'!=value;
    }

    handleSubmit(event:any) {
        event.preventDefault();
        this.router.navigate(['/rating']);
    }

    ngAfterContentChecked() {
        // jQuery(this.elementRef.nativeElement).find('.completer-input').addClass('form-control');
    }

}
