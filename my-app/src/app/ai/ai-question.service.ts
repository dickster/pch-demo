import { Injectable } from '@angular/core';

import { DropdownQuestion } from './question-dropdown';
import { QuestionBase } from './question-base';
import { TextboxQuestion } from './question-textbox';
import { RadioQuestion } from "./question-radio";

const yesNo = [
  { key: 'true', value: 'Yes' },
  { key: 'false', value: 'No' }
];

@Injectable()
export class AiQuestionService {

  getQuestions() {

    let questions: QuestionBase<any>[] = [

      new DropdownQuestion( {
        key: 'accident',
        label: 'Have you been in an accident in the last year?',
        options: yesNo,
        order: 3
      } ),

      new TextboxQuestion( {
        key: 'claim',
        label: 'Please describe your nearest claim.',
        value: 'Claim',
        required: true,
        order: 1
      } ),

      new TextboxQuestion( {
        key: 'emailAddress',
        label: 'What is your email address?',
        type: 'email',
        order: 2
      } ),

      new RadioQuestion( {
        key: 'winterTire',
        label: 'Do you have winter tires on your vehicle?',
        type: 'radio',
        options: yesNo,
        order: 4
      } ),
      new RadioQuestion( {
        key: 'policyRejected',
        label: 'Have you ever been rejected by any other insurance company?',
        type: 'radio',
        options: yesNo,
        order: 5
      } ),
      new DropdownQuestion( {
        key: 'accident',
        label: 'How many accidents did you have in last 10 years?',
        options: [
          { key: '', value: 'Choose One' },
          { key: '0', value: '0' },
          { key: '1', value: '1' },
          { key: '2', value: '2' },
          { key: '3', value: '3' },
          { key: '4', value: '4' },
          { key: '5', value: '5' }
        ],
        order: 6
      } ),
      new RadioQuestion( {
        key: 'alive',
        label: 'Are you still alive?',
        options: yesNo,
        type: 'radio',
        order: 7
      })
    ];

    return questions.sort( ( a, b ) => a.order - b.order );
  }
}
