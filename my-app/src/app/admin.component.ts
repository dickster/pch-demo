import {Component, OnInit, ElementRef} from "@angular/core";
import {Router} from "@angular/router";

import {RestService} from './rest.service';
import {Observable} from 'rxjs/Observable';
import {Policy} from "./policy";
import {PolicyService} from "./policy.service";

declare var jQuery:any;

@Component({
    selector: 'admin',
    providers: [PolicyService],
    templateUrl: 'admin.component.html'
})
export class AdminComponent implements OnInit {

    public policies:Observable<Policy[]>;

    constructor(
        private router: Router,
        private policyService: PolicyService,
        private elementRef:ElementRef) {
        this.policies = this.policyService.readBogusData();
    }

    ngOnInit() {

    }

    clickRow(policy:Policy, index:number) {
        console.log('clicked on....' + index + '--->' + policy.number);
        //this.router.navigate(['/rating'], {id:policy.number});
    }

    ngAfterContentChecked() {

    }
}

