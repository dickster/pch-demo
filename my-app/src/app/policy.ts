
export class Policy {

    public amount:number;
    public q1:string = '';
    public q2:string = '';
    public q1_desc:string='hello';
    public q2_desc:string='bonjour';

    constructor(public firstName:string,
                public lastName:string,
                public number:string,
                public effectiveDate:Date,
                public expirationDate:Date
            ) {
    }
}
