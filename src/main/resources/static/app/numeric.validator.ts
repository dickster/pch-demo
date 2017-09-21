import { Validator, FormControl } from '@angular/forms';

export class NumericValidator implements Validator {

    validate(c: FormControl): { [key: string]: any } {

        if (isNaN(+c.value)) {
            return { isValid: 'value is not a number'}
        }
        // how to i parameterize this.
        if (c.value<0||c.value>100) {
            return { isValid: 'value must be 0..100'}
        }
        return null;
    }

}




