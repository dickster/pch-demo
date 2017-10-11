import { Component, OnInit } from '@angular/core';

import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from "@angular/router";
import { Data } from "../data.store";
import { AutoPolicy } from "../model";

@Component( {
  selector: 'policy-details',
  templateUrl: 'policyDetails.component.html',
  providers: []
} )
export class PolicyDetailsComponent implements OnInit {

  form: FormGroup;
  private policy: AutoPolicy;

  constructor( private data: Data<AutoPolicy>,
               private router: Router,
               private fb: FormBuilder ) {
  }

  ngOnInit() {

    this.policy = this.data.get();
    this.form = this.toFormGroup( this.policy );
    this.form.patchValue( this.policy );
  }

  handleSubmit( event: any ) {
    event.preventDefault();
    this.data.put( this.form.value );
    console.log( 'FORM = ' + JSON.stringify( this.form.value ) );
    this.router.navigate( [ '/ai' ] );
  }

  private toFormGroup( policy: AutoPolicy ) {
    const formGroup = this.fb.group( {
      policyNumber: [ policy.policyNumber ],
      policyEffectiveDate: [ policy.policyEffectiveDate ],
      drivers: [ policy.drivers || [] ],
      locations: [ policy.locations || [] ],
      vehicles: [ policy.vehicles || [] ]
    } );
    return formGroup;
  }
}
