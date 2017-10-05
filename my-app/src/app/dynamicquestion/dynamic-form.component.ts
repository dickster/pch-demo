import {Component, Input, OnInit} from '@angular/core';
import {FormGroup} from '@angular/forms';

import {QuestionBase} from './question-base';
import {QuestionControlService} from './question-control.service';
import {AutoPolicy} from "../model";

@Component({
  selector: 'dynamic-form',
  templateUrl: './dynamic-form.component.html',
  providers: [QuestionControlService]
})
export class DynamicAiFormComponent implements OnInit {

  @Input() questions: QuestionBase<any>[] = [];
  @Input() policy: AutoPolicy;
  form: FormGroup;
  payLoad = '';

  constructor(private qcs: QuestionControlService) {
  }

  ngOnInit() {
    this.form = this.qcs.toFormGroup(this.questions);
  }

  onSubmit() {
    this.payLoad = JSON.stringify(this.form.value);
  }
}