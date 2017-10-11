import { Insured } from "../model";
import { Component, Injectable } from "@angular/core";
import { DynamicItem } from "./dynamicItem";
import { FormBuilder } from "@angular/forms";

@Injectable()
@Component( {
  selector: 'insured',
  templateUrl: 'insured.component.html'
} )
export class InsuredComponent extends DynamicItem {

  constructor( private fb: FormBuilder ) {
    super();
  }

  ngOnInit(): void {
    this.ownForm = this.toFormGroup( this.child );
  }

  toFormGroup( insured: Insured ) {
    const formGroup = this.fb.group( {
      givenName: [ insured.nameInfo.personName.givenName || '' ],
      surname: [ insured.nameInfo.personName.surname || '' ],
      addr1: [ insured.addr.addr1 || '' ],
      addr2: [ insured.addr.addr2 || '' ],
      city: [ insured.addr.city || '' ],
      stateProv: [ insured.addr.stateProv ],
      postalCode: [ insured.addr.postalCode ],
      country: [ insured.addr.country ]
    } )

    return formGroup;
  }

}
