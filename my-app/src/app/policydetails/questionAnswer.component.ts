import { Component, Injectable } from "@angular/core";
import { DynamicItem } from "./dynamicItem";
import { FormBuilder } from "@angular/forms";
import { QuestionAnswer } from "../model";

@Injectable()
@Component( {
  selector: 'question-answer',
  templateUrl: 'questionAnswer.component.html'
} )
export class QuestionAnswerComponent extends DynamicItem {

  private qa: QuestionAnswer;

  constructor( private fb: FormBuilder ) {
    super();
  }

  ngOnInit(): void {
    this.qa = this.child;
    this.ownForm = this.toFormGroup();
    this.ownForm.patchValue( this.qa );
  }

  toFormGroup() {
    const formGroup = this.fb.group( {
      question: '',
      answer: ''
    } )

    return formGroup;
  }
}
