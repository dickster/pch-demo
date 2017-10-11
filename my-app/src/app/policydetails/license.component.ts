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

  private license: License;

  constructor( private fb: FormBuilder ) {
    super();
  }

  ngOnInit(): void {
    this.license = this.child;
    this.ownForm = this.toFormGroup();
    this.ownForm.patchValue( this.license );
  }

  toFormGroup() {
    const formGroup = this.fb.group( {
      licenseDate: '',
      licenseClass: '',
      licenseNumber: '',
      stateProv: ''
    } )

    return formGroup;
  }
}
