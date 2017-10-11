import { Component, Injectable } from "@angular/core";
import { DynamicItem } from "./dynamicItem";
import { FormBuilder } from "@angular/forms";
import { License } from "../model";

@Injectable()
@Component( {
  selector: 'license',
  templateUrl: 'license.component.html'
} )
export class LicenseComponent extends DynamicItem {
  constructor( private fb: FormBuilder ) {
    super();
  }

  ngOnInit(): void {
    this.ownForm = this.toFormGroup( this.child );
  }

  toFormGroup( li: License ) {
    const formGroup = this.fb.group( {
      date: [ li.licensedDate || "" ],
      class: [ li.licenseClass || "" ],
      number: [ li.licenseNumber || "" ],
      stateProv: [ li.stateProv || "" ]
    } )

    return formGroup;
  }
}
