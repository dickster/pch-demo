import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {RouterModule} from "@angular/router";
import {routes} from "./app.routes";
import {LoginComponent} from "./login.component";
import {AdminComponent} from "./admin.component";
import {RatingComponent} from "./rating.component";
import {ConfirmationComponent} from "./confirmation.component";
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {Data} from './data.store';
import {AIComponent} from "./ai.component";
import {PolicyDetailsComponent} from "./policyDetails.component";
import {DynamicAiFormQuestionComponent} from "./dynamicquestion/dynamic-question.component";
import {DynamicAiFormComponent} from "./dynamicquestion/dynamic-form.component";
import {DynamicAiComponent} from "./dynamicquestion/dynamic-ai.component";

@NgModule({
  declarations: [
    AppComponent, LoginComponent, AdminComponent, RatingComponent, ConfirmationComponent, AIComponent, PolicyDetailsComponent,
    DynamicAiFormComponent, DynamicAiFormQuestionComponent, DynamicAiComponent
  ],
  imports: [
    BrowserModule, RouterModule.forRoot(routes),
    HttpModule,
    FormsModule,
    ReactiveFormsModule
  ],
  exports: [RouterModule],
  providers: [Data],
  bootstrap: [AppComponent]
})
export class AppModule {
}
