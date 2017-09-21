
import { Injectable } from '@angular/core';
import { Http, Response, Headers } from '@angular/http';
import 'rxjs/add/operator/map'
import { Observable } from 'rxjs/Observable';
import {RestService} from "./rest.service";
import {Message} from "./message";

@Injectable()
export class FormService extends RestService<any> {
    constructor(public _http: Http  ) {
        super(_http);
        this.withUrl('/form/all');
    }

}