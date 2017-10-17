import {Injectable} from '@angular/core';
import {Headers, Http, Response} from '@angular/http';
import 'rxjs/add/operator/map'
import {Observable} from 'rxjs/Rx';

@Injectable()
export class RestService<T> {

  private headers: Headers;

  constructor(public http: Http, public baseUrl: string) {
    this.headers = new Headers();
    this.headers.append('Content-Type', 'application/json');
    this.headers.append('Accept', 'application/json');
  }

  public withUrl(path: string): string {
    return this.baseUrl + path;
  }

  public getAll(): Observable<T[]> {
    return this.http.get(this.baseUrl)
      .map((response: Response) => <T[]>response.json())
      .catch(this.handleError);
    // console.log('hello');
    // return null;
  }

  public get(path: string): Observable<T> {
    return this.http.get(path)
      .map((response: Response) => <T>response.json())
      .catch(this.handleError);
  }

  public post(path: string, body: any): Observable<T> {
    return this.http.post(path, body, {headers: this.headers})
      .map((response: Response) => <T>response.json())
      .catch(this.handleError);
  }

  public put(path: string, body: any): Observable<T> {
    return this.http.put(path, body, {headers: this.headers})
      .map((res: Response) => <T>res.json())
      .catch(this.handleError);
  }

  private handleError(error: Response) {
    console.error(error);
    return Observable.throw(error.json().error || 'rest service error');
  }
}
