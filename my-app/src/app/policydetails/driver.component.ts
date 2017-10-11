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

  private driver: Driver;

  constructor( private fb: FormBuilder ) {
    super();
  }

  ngOnInit(): void {
    this.driver = this.child;
    this.ownForm = this.toFormGroup();
    this.ownForm.patchValue( this.driver );
  }

  toFormGroup() {
    const formGroup = this.fb.group( {
      givenName: '',
      surname: '',
      gender: '',
      birthday: '',
      maritalStatus: '',
      licenses: []
    } )

    return formGroup;
  }

}
