import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import 'rxjs/add/operator/map'
import {Observable} from 'rxjs/Rx';
import {RestService} from "./rest.service";
import {AutoPolicy} from "./model";

const baseUrl = "http://localhost:9090/validation";

@Injectable()
export class ValidationService extends RestService<AutoPolicy> {

  constructor(public _http: Http) {
    super(_http, baseUrl);
  }


  public validate(policy:AutoPolicy):Observable<AutoPolicy> {
    return this.post(this.baseUrl, policy);
  }

}
