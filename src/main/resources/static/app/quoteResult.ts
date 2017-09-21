
export class QuoteResult {
    totalPremium: number;
    created:string;  // as date
    notes :string[] = [];
    status : number;
    expiry:string; // as date
    quoteMethod : string;
    referrer : string;
}