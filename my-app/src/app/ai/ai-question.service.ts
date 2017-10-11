import {Injectable} from '@angular/core';

import {DropdownQuestion} from './question-dropdown';
import {QuestionBase} from './question-base';
import {TextboxQuestion} from './question-textbox';
import {RadioQuestion} from "./question-radio";

@Injectable()
export class AiQuestionService {

  getQuestions() {

    let questions: QuestionBase<any>[] = [

      new DropdownQuestion({
        key: 'accident',
        label: 'Have you been in an accident in the last year?',
        options: [
          {key: 'true', value: 'Yes'},
          {key: 'false', value: 'No'}
        ],
        order: 3
      }),

      new TextboxQuestion({
        key: 'claim',
        label: 'Please describe your nearest claim.',
        value: 'Claim',
        required: true,
        order: 1
      }),

      new TextboxQuestion({
        key: 'emailAddress',
        label: 'What is your email address?',
        type: 'email',
        order: 2
      }),

      new RadioQuestion({
        key: 'winterTire',
        label: 'Do you have winter tires on your vehicle?',
        type: 'radio',
        options: [
          {key: 'Y', value: 'Yes'},
          {key: 'N', value: 'No'}
        ],
        order: 4
      })
    ];

    return questions.sort((a, b) => a.order - b.order);
  }
}
