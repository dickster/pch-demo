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
  constructor( private fb: FormBuilder ) {
    super();
  }

  ngOnInit(): void {
    this.ownForm = this.toFormGroup( this.child );
  }

  toFormGroup( qa: QuestionAnswer ) {
    const formGroup = this.fb.group( {
      question: [ qa.question || '' ],
      answer: [ qa.answer || "" ]
    } )

    return formGroup;
  }
}
