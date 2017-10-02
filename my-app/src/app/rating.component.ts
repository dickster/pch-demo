import {Component, OnInit, ElementRef, Input} from '@angular/core';

import {FormControl, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from "@angular/router";
import {Policy} from "./policy";

declare var jQuery : any;

@Component({
    selector:'rating',
    templateUrl: 'rating.component.html',
    providers: []
})
export class RatingComponent implements OnInit {

    @Input() policy: Policy;

    constructor(
        private router:Router,
        private elementRef:ElementRef) { }

    ngOnInit() {

    }


    handleSubmit(event:any) {
        event.preventDefault();
        this.router.navigate(['/login']);
    }

    ngAfterContentChecked() {
        // jQuery(this.elementRef.nativeElement).find('.completer-input').addClass('form-control');
    }


}
