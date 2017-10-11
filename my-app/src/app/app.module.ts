import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { RouterModule } from "@angular/router";
import { routes } from "./app.routes";
import { LoginComponent } from "./login.component";
import { AdminComponent } from "./admin.component";
import { RatingComponent } from "./rating.component";
import { ConfirmationComponent } from "./confirmation.component";
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { Data } from './data.store';
import { PolicyDetailsComponent } from "./policydetails/policyDetails.component";
import { DynamicAiFormQuestionComponent } from "./ai/dynamic-question.component";
import { DynamicAiFormComponent } from "./ai/dynamic-form.component";
import { DynamicAiComponent } from "./ai/dynamic-ai.component";
import { ListComponent } from "./policydetails/list.component";
import { ItemComponent, } from "./policydetails/item.component";
import { InsuredComponent } from "./policydetails/insured.component";
import { UnknownDynamicComponent } from "./policydetails/dynamicItem";
import { PhoneInfoComponent } from "./policydetails/phoneInfo.component";
import {PCHComponent} from "./pch.component";

@NgModule( {
  declarations: [
    AppComponent, LoginComponent, AdminComponent, RatingComponent, ConfirmationComponent, PolicyDetailsComponent, PCHComponent,
    DynamicAiFormComponent, DynamicAiFormQuestionComponent, DynamicAiComponent, ListComponent, PhoneInfoComponent, InsuredComponent,
    ItemComponent, UnknownDynamicComponent
  ],
  imports: [
    BrowserModule, RouterModule.forRoot( routes ),
    HttpModule,
    FormsModule,
    ReactiveFormsModule
  ],
  exports: [ RouterModule ],
  providers: [ Data ],
  bootstrap: [ AppComponent ],
  entryComponents: [
    PhoneInfoComponent,
    InsuredComponent,
    UnknownDynamicComponent
  ],
} )
export class AppModule {
}
