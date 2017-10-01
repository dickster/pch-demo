import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {RouterModule} from "@angular/router";
import {routes} from "./app.routes";
import {LoginComponent} from "./login.component";
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent, LoginComponent
  ],
  imports: [
    BrowserModule, RouterModule.forRoot(routes),
    FormsModule,
    ReactiveFormsModule
  ],
  exports: [RouterModule],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
