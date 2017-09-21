import {QuoteResult} from "./quoteResult";

export class Quote {
    firstName:string;
    lastName:string;
    startDate:string;
    endDate:string;
    result:QuoteResult;

    constructor() {
        this.result = new QuoteResult();
    }
}
