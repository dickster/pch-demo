

import { Injectable } from '@angular/core';

@Injectable()
export class Data {

    public storage: any;

    public constructor() { }

    public put(data:any):void {
        console.log('saving data ' + JSON.stringify(data));
        this.storage = data;
    }

    public get():void {
        return this.storage;
    }
}