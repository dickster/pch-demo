
import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map'
import {RestService} from "./rest.service";
import {Broker} from "./broker";

@Injectable()
export class BrokerService extends RestService<Broker> {
    constructor(public _http: Http  ) {
        super(_http);
        this.withUrl('/broker/all');
    }

}