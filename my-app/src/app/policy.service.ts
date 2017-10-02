
import { Injectable } from '@angular/core';
import { Http, Response, Headers } from '@angular/http';
import 'rxjs/add/operator/map'
// import { Observable } from 'rxjs/Observable';
import {Observable} from 'rxjs/Rx';
import {RestService} from "./rest.service";


import {Policy} from "./policy";

@Injectable()
export class PolicyService extends RestService<Policy> {


    policies:Policy[] = [
            new Policy('derek', 'dick', '123', new Date(), new Date(2018,1,18)),
            new Policy('peter', 'johnson', '738', new Date(), new Date(2018,7,5)),
            new Policy('joe', 'blow', '3738', new Date(), new Date(2018,1,29) ),
            new Policy('sally', 'silly', '849', new Date(), new Date(2018,4,13)),
            new Policy('billy', 'dally', '392', new Date(), new Date(2018,11,9))
        ];

    constructor(public _http: Http  ) {
        super(_http);
        this.withUrl('/quote/all');
    }

    // replace this with inherited get() call to REST service.
    // use a Java-->Typescript interface generating tool to update the Policy interface to contain proper fields.
    //   @see  https://github.com/vojtechhabarta/typescript-generator
    public readBogusData(): Observable<Policy[]> {
        return Observable.of(this.policies);
    }


}