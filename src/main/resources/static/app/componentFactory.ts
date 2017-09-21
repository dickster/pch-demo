import { Injectable }   from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

import { ComponentConfig } from './component.config';
import {NumericValidator} from "./numeric.validator";

@Injectable()
export class ComponentFactory {

    constructor() { }

    toFormGroup(components: ComponentConfig<any>[] ) {
        let group: any = {};

        components.forEach(component => {
            group[component.key] = new FormControl(component.value || '',
                                            this.getValidators(component),
                                            this.getAsyncValidators(component));
        });
        return new FormGroup(group);
    }

    private getAsyncValidators(component: ComponentConfig<any>) {
        return [];
    }

    private getValidators(component: ComponentConfig<any>) {
        let result:any[] = [];
        if (component.required) result.push(Validators.required);
        // TODO : remove this...for debugging only.
        //result.push(new NumericValidator());
        if (component.asyncValidators) {
            component.asyncValidators.forEach(validator => {
            });
        }
        if (component.validators) {
            component.validators.forEach(validator => {
            });
        }
        //TODO :  first check for aliases stored in map.  do i want a singleton? do i care? implement a flyweight map?
     //   var x = new window[component.asyncValidators[0]]();
        return result;
    }



}
