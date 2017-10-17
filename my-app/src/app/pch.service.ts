import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import 'rxjs/add/operator/map'
import {Observable} from 'rxjs/Rx';
import {RestService} from './rest.service';
import {AutoPolicy} from './model';
import {PolicyChangeData, Change, Value, Config} from './pch.model';

const baseUrl = 'http://localhost:9090/pch';

@Injectable()
export class PolicyChangeService extends RestService<PolicyChangeData> {

  constructor(public _http: Http) {
    super(_http, baseUrl);
  }

  public compare(id:number, policy:AutoPolicy): Observable<PolicyChangeData> {
    let changes =  [
        {
          type:'modify',
          id:'102',
          values:[ {code:'416 245 5738'}, {code:'416 453 8449'}]
        },
        {
          type:'modify',
          id:'203',
          values:[ {code:'12345678'}, {code:'94375693'}]
        },
        {
          type:'modify',
          id:'204',
          values:[ {code:'BMW'}, {code:'Mercedes'}]
        },
        {
          type:'modify',
          id:'205',
          values:[ {code:'1000'}, {code:'500'}]
        },
        {
          type:'modify',
          id:'206',
          values:[ {code:'1000000'}, {code:'2000000'}]
        },
        {
          type:'modify',
          id:'202',
          values:[{code: '123 Main St'}, {code:'43 Blanburry Ave'}]
        }
    ];
      // all view customization data goes here.
    let config = <Config> {
      policyNum:'HB-12789XF',
      valueLabels:['Broker', 'Carrier'],
      idLabels:{
          '102': 'Phone Number',
          '203': 'VIN',
          '204': 'Model',
          '205': 'Deductible',
          '206': 'Limit',
          '202': 'Street Name'
      }
    }

    let options = <PolicyChangeData> {
      changes: changes,
      config:config
    };
    return Observable.of(options);
//    return this.post(this.withUrl('/' + id), policy);
  }

}
