import { Insured } from "../model";
import { Component, Injectable, OnInit } from "@angular/core";
import { DynamicItem } from "./dynamicItem";
import { FormBuilder } from "@angular/forms";

@Injectable()
@Component( {
  selector: 'insured',
  templateUrl: 'insured.component.html'
} )
export class InsuredComponent extends DynamicItem implements OnInit {

  private insured: Insured;

  constructor( private fb: FormBuilder ) {
    super();
  }

  ngOnInit() {
    this.insured = this.child;
    this.ownForm = this.toFormGroup();
    this.ownForm.patchValue( this.insured );
  }

  toFormGroup() {
    const formGroup = this.fb.group( {
      givenName: '',
      surname: '',
      addr1: '',
      addr2: '',
      city: '',
      stateProv: '',
      postalCode: '',
      country: '',
      phoneInfos: []
    } )

    return formGroup;
  }

}
