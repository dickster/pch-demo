export interface Policy {

    amount: Number;
    user: string;
    passwords : {
        password: string;
        confirm?: string;
    }
    // firstName:string;
    // middleName?:string;
    // lastName:string;
}