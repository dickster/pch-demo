import {Component, Input} from '@angular/core';
import {FormGroup} from '@angular/forms';

import {QuestionBase} from './question-base';

@Component({
  selector: 'df-question',
  templateUrl: './dynamic-question.component.html'
})
export class DynamicAiFormQuestionComponent {
  @Input() question: QuestionBase<any>;
  @Input() form: FormGroup;

  radioSelected: string;

  get isValid() {
    return this.form.controls[this.question.key].valid;
  }

  onClick(opt: any) {
    this.radioSelected = opt.key;
  }
}
