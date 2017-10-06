import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import 'rxjs/add/operator/map'
import {Observable} from 'rxjs/Rx';
import {RestService} from "./rest.service";
import {AutoPolicy} from "./model";

const baseUrl = "http://localhost:9090/policies";

@Injectable()
export class PolicyService extends RestService<AutoPolicy> {

  constructor(public _http: Http) {
    super(_http, baseUrl);
  }

  public getAllPolicies(): Observable<AutoPolicy[]> {
    return this.getAll();
  }

  public getPolicy(policyNumber: string): Observable<AutoPolicy> {
    return this.get(this.withUrl("/" + policyNumber));
  }

  public updatePolicy(policyNumber: string, policy: AutoPolicy) {
    return this.put(this.withUrl("/" + policyNumber), policy);
  }

  public comparePolicy(policyNumber: string, policy: AutoPolicy) {
    return this.post(this.withUrl("/" + policyNumber + "/compare"), policy);
  }

  public addPolicy(policy: AutoPolicy) {
    return this.post("", policy);
  }

}
