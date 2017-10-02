import {Component, OnInit, ElementRef, Input} from '@angular/core';

import {FormControl, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from "@angular/router";
import {Policy} from "./policy";
import {Data} from "./data.store";
import { DatePipe } from '@angular/common';


@Component({
    selector:'ai',
    templateUrl: 'ai.component.html',
    providers: []
})
export class AIComponent implements OnInit {

    private policy:Policy;

    constructor(
        private data:Data<Policy>,
        private router:Router,

       ) {
            this.policy = this.data.get();
    }

    ngOnInit() {

    }

    handleSubmit(event:any) {
        event.preventDefault();
        this.router.navigate(['/rating']);
    }

    ngAfterContentChecked() {
        // jQuery(this.elementRef.nativeElement).find('.completer-input').addClass('form-control');
    }

}
