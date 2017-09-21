import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import 'rxjs/add/operator/map'
import { Observable } from 'rxjs/Observable';

@Injectable()
export class RestService<T> {

    private actionUrl: string;
    private headers: Headers;

    constructor(public http: Http ) {
        this.headers = new Headers();
        this.headers.append('Content-Type', 'application/json');
        this.headers.append('Accept', 'application/json');
    }

    public withUrl(url:string) {
        this.actionUrl = url;
        return this;
    }

    public put(data:T) : Observable<T> {
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        return this.http.post(this.actionUrl, data, options) // ...using post request
            .map((res:Response) => res.json()) // ...and calling .json() on the response to return data
            .catch((error:any) => Observable.throw(error.json().error || 'Server error')); //...errors if
    }

    public get(): Observable<T[]> {
       return this.http.get(this.actionUrl)
            .map((response: Response) => <T[]>response.json())
            .catch(this.handleError);
    // console.log('hello');
   // return null;
    }


// NOT TESTED YET:
//     public add(toAdd: T): Observable<T> {
//         return this._http.post(this.actionUrl, toAdd, { headers: this.headers })
//             .map((response: Response) => <T>response.json())
//             .catch(this.handleError);
//     }

    private handleError(error: Response) {
        console.error(error);
        return Observable.throw(error.json().error || 'rest service error');
    }
}