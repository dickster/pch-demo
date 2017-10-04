import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { FormsModule, ReactiveFormsModule} from '@angular/forms';
import {AppRoutes} from './app.routes';
import {RouterModule} from '@angular/router';

import {MixedCase} from './mixedCase.pipe';
import { AppComponent }  from './app.component';
import { InsuredComponent }  from './insured.component';
import { ChatComponent }  from './chat.component';
import { AiComponent }  from './ai.component';
import { Ai2Component }  from './ai2.component';
import { LoginComponent }  from './login.component';
import {CreateAccountComponent} from './createAccount.component';
import {ReviewComponent} from './review.component';
import {PaymentComponent} from './payment.component';
import {AdminComponent} from './admin.component';
import {QuoteService} from './quote.service';
import {QuestionComponent} from './question.component';
import {QuestionService} from './question.service';
import {QuestionPanelComponent} from './question-panel.component';
import {QuoteEngineService} from './quoteEngine.service';
import {ComponentFactory} from './componentFactory';
import {MessageService} from './message.service';
import {FormService} from './form.service';
import {BrokerService} from './broker.service';
import { HttpModule } from '@angular/http';
import {Observable} from 'rxjs/Rx';




@NgModule({
    imports:      [ HttpModule, BrowserModule,  Ng2CompleterModule, RouterModule.forRoot(AppRoutes), FormsModule, ReactiveFormsModule ],
    declarations: [ MixedCase, ReviewComponent, PaymentComponent, Ai2Component, QuestionComponent, QuestionPanelComponent, AiComponent, AdminComponent, ChatComponent, InsuredComponent, AppComponent, LoginComponent, CreateAccountComponent ],
    providers: [QuestionService, ComponentFactory, QuoteService, BrokerService, MessageService, FormService, QuoteEngineService],
    bootstrap:    [ AppComponent ]
})
export class AppModule { }

