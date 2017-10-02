import {Component, OnInit, ElementRef, ViewChild, Renderer2} from '@angular/core';

import {FormControl, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from "@angular/router";
import {Policy} from "./policy";
import {Data} from "./data.store";
import { DatePipe } from '@angular/common';

declare function update() : void;

@Component({
    selector:'confirmation',
    templateUrl: 'confirmation.component.html',
    // styles: ['.jumbotron .msg {display:block;} .jumbotron.working .msg {display:none;}  .jumbotron.working .progress {display:block;} .jumbotron .progress{display:none;}'],
    providers: []
})
export class ConfirmationComponent implements OnInit {

    // @ViewChild("bar") bar: ElementRef;
    // @ViewChild("progress") progress: ElementRef;
    // @ViewChild("msg") msg: ElementRef;

    constructor(
        // private renderer:Renderer2,
        private data:Data<Policy>,
        private router:Router) {
    }

    ngOnInit() {
        update();
    }


    handleSubmit(event:any) {
        event.preventDefault();
        this.router.navigate(['/login']);
    }

    ngAfterContentChecked() {
        // jQuery(this.elementRef.nativeElement).find('.completer-input').addClass('form-control');
    }


}
