import { Component, OnInit } from '@angular/core';

import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from "@angular/router";
import { Data } from "../data.store";
import { AutoPolicy } from "../model";

const sample = "{\n" +
  "    \"policyNumber\": \"test1\",\n" +
  "    \"policyEffectiveDate\": \"2017-10-10\",\n" +
  "    \"insureds\": [\n" +
  "        {\n" +
  "            \"nameInfo\": {\n" +
  "                \"personName\": {\n" +
  "                    \"surname\": \"Bond\",\n" +
  "                    \"givenName\": \"James\"\n" +
  "                },\n" +
  "                \"commercialName\": null\n" +
  "            },\n" +
  "            \"addr\": {\n" +
  "                \"addr1\": \"123 Main Street\",\n" +
  "                \"addr2\": null,\n" +
  "                \"city\": \"Toronto\",\n" +
  "                \"postalCode\": \"A1A1A1\",\n" +
  "                \"stateProv\": \"ON\",\n" +
  "                \"country\": \"CA\"\n" +
  "            },\n" +
  "            \"phoneInfos\": [\n" +
  "                {\n" +
  "                    \"phoneTypeCd\": \"Cell\",\n" +
  "                    \"communicationUseCd\": \"Business\",\n" +
  "                    \"phoneNumber\": \"6477654321\"\n" +
  "                }\n" +
  "            ]\n" +
  "        }\n" +
  "    ],\n" +
  "    \"drivers\": [\n" +
  "        {\n" +
  "            \"nameInfo\": {\n" +
  "                \"personName\": {\n" +
  "                    \"surname\": \"Bond\",\n" +
  "                    \"givenName\": \"James\"\n" +
  "                },\n" +
  "                \"commercialName\": null\n" +
  "            },\n" +
  "            \"gender\": \"M\",\n" +
  "            \"birthday\": \"1959-01-01\",\n" +
  "            \"maritalStatus\": \"M\",\n" +
  "            \"licenses\": [\n" +
  "                {\n" +
  "                    \"licensedDate\": \"1995-01-01\",\n" +
  "                    \"licenseClass\": \"G\",\n" +
  "                    \"licenseNumber\": \"G123456\",\n" +
  "                    \"stateProv\": \"ON\"\n" +
  "                }\n" +
  "            ]\n" +
  "        }\n" +
  "    ],\n" +
  "    \"vehicles\": [\n" +
  "        {\n" +
  "            \"manufacturer\": \"Honda\",\n" +
  "            \"model\": \"Civic\",\n" +
  "            \"modelYear\": \"2016\",\n" +
  "            \"bodyType\": \"Sedan\",\n" +
  "            \"costNewAmt\": \"20000\",\n" +
  "            \"annualDistance\": 10,\n" +
  "            \"purchaseDate\": \"2017-10-09\",\n" +
  "            \"vin\": \"VIN1234567878\",\n" +
  "            \"vehUseCd\": \"Pleasure\",\n" +
  "            \"engineType\": \"gas\",\n" +
  "            \"rateClassCd\": null,\n" +
  "            \"coverages\": [\n" +
  "                {\n" +
  "                    \"coverageCd\": \"COL\",\n" +
  "                    \"limit\": 1000,\n" +
  "                    \"deductible\": 1000\n" +
  "                },\n" +
  "                {\n" +
  "                    \"coverageCd\": \"ABC\",\n" +
  "                    \"limit\": 3000,\n" +
  "                    \"deductible\": 5000\n" +
  "                }\n" +
  "            ],\n" +
  "            \"questionAnswers\": [\n" +
  "                {\n" +
  "                    \"question\": \"Hungry?\",\n" +
  "                    \"answer\": \"Y\"\n" +
  "                }\n" +
  "            ]\n" +
  "        }\n" +
  "    ],\n" +
  "    \"locations\": [\n" +
  "        {\n" +
  "            \"addr\": {\n" +
  "                \"addr1\": \"123 Main Street\",\n" +
  "                \"addr2\": null,\n" +
  "                \"city\": \"Toronto\",\n" +
  "                \"postalCode\": \"A1A1A1\",\n" +
  "                \"stateProv\": \"ON\",\n" +
  "                \"country\": \"Canada\"\n" +
  "            }\n" +
  "        }\n" +
  "    ]\n" +
  "}"

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

    // this.policy = this.data.get();
    this.policy = JSON.parse( sample );
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
      locations: [ policy.locations || [] ]
    } );
    return formGroup;
  }
}
