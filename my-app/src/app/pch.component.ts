import {Component, ElementRef, OnInit} from '@angular/core';

import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from "@angular/router";
import {Data} from "./data.store";
import {AutoPolicy} from "./model";


const USER = 'user';
const PASSWORDS = 'passwords';
const PASSWORD = 'password';
const CONFIRM = 'confirm';

// <ol class="breadcrumb">
// <li class="breadcrumb-item active"><a href="#">Policy Details</a></li>
// <!--<li class="breadcrumb-item">Additional Information</a></li>-->
// <!--<li class="breadcrumb-item ">Rating</a></li>-->
// <!--<li class="breadcrumb-item ">Billing</a></li>-->
// <!--<li class="breadcrumb-item ">Confirmation</li>-->
//     </ol>

declare var jQuery: any;
declare var wtw: any;

@Component({
  selector: 'pch',
  templateUrl: 'pch.component.html',
  providers: []
})
export class PCHComponent implements OnInit {

  form: FormGroup;
  private policy: AutoPolicy;

  constructor(private data: Data<AutoPolicy>,
              private router: Router,
              private formBuilder: FormBuilder,
              private elementRef: ElementRef) {
  }

  ngOnInit() {
    this.policy = this.data.get();

    this.form = this.formBuilder.group({
        number: ['', Validators.required],
        name: ['', Validators.required],
        effectiveDate: ['', Validators.required],
        expirationDate: ['', Validators.required]
      }
    );
    if (this.policy) this.form.patchValue(this.policy);

    // TODO : read this object from charles' policy change REST service.
   let options = {
    changes:[
          {
            "type": "modify",
            "id": 102,

            // TOM CRUISE-->
            "values": [
              {
                "code": "foo@bar.com"
              },
              {
                "code": "derek.gmail.com"
              }
            ]
          },
          {
            "type": "modify",
            "id": 202,
            "values": [
              {
                "code": "Simcoe Ave"
              },
              {
                "code": "Blanburry St"
              }
            ]
          }
    ],
    // all view customization data goes here.
    config:
      {
          "policyNum": "HB-12789XF",
          "valueLabels": ["Broker", "Carrier"],
          "idLabels": {
              102:'Email',
              202:'Street Name'
            },

      }

   };

    wtw.changeEditor.init(options);

  }

  handleSubmit(event: any) {
    event.preventDefault();
    this.data.put(this.form.value);
    console.log('FORM = ' + JSON.stringify(this.form.value));
    this.router.navigate(['/ai']);
  }

  ngAfterContentChecked() {
    // jQuery(this.elementRef.nativeElement).find('.completer-input').addClass('form-control');
  }


}
