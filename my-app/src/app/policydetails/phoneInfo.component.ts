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

  constructor( private fb: FormBuilder ) {
    super();
  }

  ngOnInit(): void {
    this.ownForm = this.toFormGroup( this.child );
  }

  toFormGroup( phoneInfo: PhoneInfo ) {
    const formGroup = this.fb.group( {
      phoneNumber: [ phoneInfo.phoneNumber || '' ]
    } )

    return formGroup;
  }
}
