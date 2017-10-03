import {Component, OnInit, ElementRef, Input} from '@angular/core';

// import {FormControl, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from "@angular/router";
import {Policy} from "./policy";
import {Data} from "./data.store";
// import { DatePipe } from '@angular/common';

declare var jQuery : any;

@Component({
    selector:'rating',
    templateUrl: 'rating.component.html',
    providers: []
})
export class RatingComponent implements OnInit {

    private policy:Policy;

    constructor(
        private data:Data<Policy>,
        private router:Router,
        private elementRef:ElementRef) {
        this.policy = this.data.get();
        this.policy.amount = 1000+Math.random()*2500;
    }

    ngOnInit() {

    }

    handleSubmit(event:any) {
        event.preventDefault();
        this.router.navigate(['/confirmation']);
    }

    ngAfterContentChecked() {
        // jQuery(this.elementRef.nativeElement).find('.completer-input').addClass('form-control');
    }


}
