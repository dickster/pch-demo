import { FormArray, FormGroup } from "@angular/forms";
import { Component, Injectable } from "@angular/core";

export abstract class DynamicItem {
  ownForm: FormGroup;
  child: any;
  childrenArray: FormArray;
}

@Injectable()
@Component( {
  selector: 'unknown-component',
  template: `
    <div>Unknown component</div>`
} )
export class UnknownDynamicComponent extends DynamicItem {
}
