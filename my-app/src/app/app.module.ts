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
import {PolicyDetailsComponent} from "./policydetails/policyDetails.component";
import {DynamicAiFormQuestionComponent} from "./ai/dynamic-question.component";
import {DynamicAiFormComponent} from "./ai/dynamic-form.component";
import {DynamicAiComponent} from "./ai/dynamic-ai.component";
import {ListComponent} from "./policydetails/list.component";
import {InsuredComponent} from "./policydetails/insured.component";
import {ItemComponent, UnknownDynamicComponent} from "./policydetails/item.component";

@NgModule({
  declarations: [
    AppComponent, LoginComponent, AdminComponent, RatingComponent, ConfirmationComponent, PolicyDetailsComponent,
    DynamicAiFormComponent, DynamicAiFormQuestionComponent, DynamicAiComponent, ListComponent, InsuredComponent,
    ItemComponent, UnknownDynamicComponent
  ],
  imports: [
    BrowserModule, RouterModule.forRoot(routes),
    HttpModule,
    FormsModule,
    ReactiveFormsModule
  ],
  exports: [RouterModule],
  providers: [Data],
  bootstrap: [AppComponent],
  entryComponents: [
    InsuredComponent,
    UnknownDynamicComponent
  ],
})
export class AppModule {
}
