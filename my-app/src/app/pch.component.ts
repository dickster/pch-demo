import {Component, ElementRef, OnInit} from '@angular/core';

import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from "@angular/router";
import {Data} from "./data.store";
import {AutoPolicy} from "./model";
import {PolicyChangeService} from "./pch.service";


const USER = 'user';
const PASSWORDS = 'passwords';
const PASSWORD = 'password';
const CONFIRM = 'confirm';

declare var jQuery: any;
declare var wtw: any;

@Component({
  selector: 'pch',
  templateUrl: 'pch.component.html',
  providers: [PolicyChangeService]
})
export class PCHComponent implements OnInit {

  form: FormGroup;
  private policy: AutoPolicy;

  constructor(private data: Data<AutoPolicy>,
              private router: Router,
              private pchService:PolicyChangeService,
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

   let options = this.pchService.compare(1,new AutoPolicy()).subscribe(options=>{
       console.log(' init edit with options ' + JSON.stringify(options));
       wtw.changeEditor.init(options);
   });


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
