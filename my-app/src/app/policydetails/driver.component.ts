import { Driver } from "../model";
import { Component, Injectable } from "@angular/core";
import { DynamicItem } from "./dynamicItem";
import { FormBuilder } from "@angular/forms";

@Injectable()
@Component( {
  selector: 'driver',
  templateUrl: 'driver.component.html'
} )
export class DriverComponent extends DynamicItem {

  constructor( private fb: FormBuilder ) {
    super();
  }

  ngOnInit(): void {
    this.ownForm = this.toFormGroup( this.child );
  }

  toFormGroup( driver: Driver ) {
    const formGroup = this.fb.group( {
      givenName: [ driver.nameInfo.personName.givenName || '' ],
      surname: [ driver.nameInfo.personName.surname || '' ],
      gender: [ driver.gender || "" ],
      birthday: [ driver.birthday || new Date() ],
      maritalStatus: [ driver.maritalStatus || "" ]
    } )

    return formGroup;
  }

}
