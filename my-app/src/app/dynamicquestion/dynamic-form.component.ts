import {Component, Input, OnInit} from '@angular/core';
import {FormGroup} from '@angular/forms';

import {QuestionBase} from './question-base';
import {QuestionControlService} from './question-control.service';
import {AutoPolicy, QuestionAnswer} from "../model";
import {Data} from "../data.store";

@Component({
  selector: 'dynamic-form',
  templateUrl: './dynamic-form.component.html',
  providers: [QuestionControlService]
})
export class DynamicAiFormComponent implements OnInit {

  @Input() questions: QuestionBase<any>[] = [];
  @Input() policy: AutoPolicy;
  aiQuestions: QuestionAnswer[] = [];
  form: FormGroup;
  payLoad = '';

  constructor(private qcs: QuestionControlService,
              private data: Data<AutoPolicy>) {
  }

  ngOnInit() {
    this.form = this.qcs.toFormGroup(this.questions);
  }

  onSubmit() {
    this.processForm(this.policy);
    this.data.put(this.policy);
    this.payLoad = JSON.stringify(this.aiQuestions);
  }

  private processForm(policy: AutoPolicy) {
    this.aiQuestions = [];
    policy.vehicles[0].questionAnswers = [];
    Object.keys(this.form.controls).forEach(key => {
      let v = this.form.get(key).value;
      let q = new QuestionAnswerImpl(key, v);
      policy.vehicles[0].questionAnswers.push(q);
      this.aiQuestions.push(q);
    });
  }
}

class QuestionAnswerImpl implements QuestionAnswer {
  question: string;
  answer: string;

  constructor(q: string, a: string) {
    this.question = q;
    this.answer = a;
  }
}
