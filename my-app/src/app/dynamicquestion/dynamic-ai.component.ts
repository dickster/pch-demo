import {Component, OnInit} from '@angular/core';

import {AiQuestionService} from "./ai-question.service";
import {Router} from "@angular/router";
import {AutoPolicy} from "../model";
import {Data} from "../data.store";
import {FormBuilder} from "@angular/forms";
import {PolicyService} from "../policy.service";
import {Observable} from "rxjs/Observable";

@Component({
  selector: 'df-ai',
  templateUrl: 'dynamic-ai.component.html',
  providers: [AiQuestionService, PolicyService]
})
export class DynamicAiComponent implements OnInit {
  questions: any[];
  policy: Observable<AutoPolicy>;

  constructor(private formBuilder: FormBuilder,
              private data: Data<AutoPolicy>,
              private router: Router,
              private service: AiQuestionService,
              private policyService: PolicyService) {
    this.questions = service.getQuestions();
    this.policy = policyService.getPolicy("1");
  }


  ngOnInit(): void {
  }
}
