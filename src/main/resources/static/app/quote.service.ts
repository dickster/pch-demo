
import { Injectable } from '@angular/core';
import { Http, Response, Headers } from '@angular/http';
import 'rxjs/add/operator/map'
import { Observable } from 'rxjs/Observable';
import {RestService} from "./rest.service";
import {Quote} from "./quote";

@Injectable()
export class QuoteService extends RestService<Quote> {

    constructor(public _http: Http  ) {
        super(_http);
        this.withUrl('/quote/all');
    }


}