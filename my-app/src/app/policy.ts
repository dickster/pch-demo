
export class Policy {

    public amount:number;
    constructor(public firstName:string,
                public lastName:string,
                public number:string,
                public effectiveDate:Date,
                public expirationDate:Date
            ) {
    }
}
