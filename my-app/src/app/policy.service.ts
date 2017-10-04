import {Injectable} from '@angular/core';
import {Http, Response} from '@angular/http';
import 'rxjs/add/operator/map'
import {Observable} from 'rxjs/Rx';
import {RestService} from "./rest.service";
import {AutoPolicy} from "./model";

@Injectable()
export class PolicyService extends RestService<AutoPolicy> {

  constructor(public _http: Http) {
    super(_http);
    this.withUrl('/quote/all');
  }

  public getAllPolicies(): Observable<AutoPolicy[]> {
    return this.http.get("http://localhost:9090/policies")
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json().error || 'Server Error'));
  }

}
