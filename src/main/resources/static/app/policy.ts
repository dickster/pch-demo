export interface Policy {

    user: string;
    passwords : {
        password: string;
        confirm?: string;
    }
    // firstName:string;
    // middleName?:string;
    // lastName:string;
}