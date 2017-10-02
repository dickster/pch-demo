

import { Injectable } from '@angular/core';

@Injectable()
export class Data<T> {

    public storage: T;

    public constructor() { }

    public put(data:T):void {
        console.log('saving data ' + JSON.stringify(data));
        this.storage = data;
    }

    public get():T {
        return this.storage;
    }
}