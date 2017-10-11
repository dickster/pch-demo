import { Component, Injectable } from "@angular/core";
import { DynamicItem } from "./dynamicItem";
import { FormBuilder } from "@angular/forms";
import { PhoneInfo } from "../model";

@Injectable()
@Component( {
  selector: 'phone-info',
  templateUrl: 'phoneInfo.component.html'
} )
export class PhoneInfoComponent extends DynamicItem {

  private pi: PhoneInfo;

  constructor( private fb: FormBuilder ) {
    super();
  }

  ngOnInit(): void {
    this.pi = this.child;
    this.ownForm = this.toFormGroup();
    this.ownForm.patchValue( this.pi );
  }

  toFormGroup() {
    const formGroup = this.fb.group( {
      phoneNumber: ''
    } )

    return formGroup;
  }
}
