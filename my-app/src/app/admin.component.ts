import {Component, OnInit, ElementRef} from "@angular/core";
import {Router} from "@angular/router";
import {Observable} from 'rxjs/Observable';
import {PolicyService} from "./policy.service";
import {Data} from "./data.store";
import {AutoPolicy} from "./model";

declare var jQuery: any;

@Component({
  selector: 'admin',
  providers: [PolicyService],
  templateUrl: 'admin.component.html'
})
export class AdminComponent implements OnInit {

  public policies: Observable<AutoPolicy[]>;

  constructor(private data: Data<AutoPolicy>,
              private router: Router,
              private policyService: PolicyService,
              private elementRef: ElementRef) {
    this.policies = this.policyService.getAllPolicies();
  }


  ngOnInit() {
  }

  clickRow(policy: AutoPolicy, index: number) {
    console.log('clicked on....' + index + '--->' + policy.policyNumber);
    this.data.put(policy);
    // this.router.navigate(['/rating'], {id:policy.number});
    this.router.navigate( [ '/policyDetails' ] );
  }

  ngAfterContentChecked() {

  }
}

