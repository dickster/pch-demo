"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
const core_1 = require('@angular/core');
const platform_browser_1 = require('@angular/platform-browser');
const forms_1 = require('@angular/forms');
const app_routes_1 = require('./app.routes');
const router_1 = require('@angular/router');
const ng2_completer_1 = require("ng2-completer");
const mixedCase_pipe_1 = require('./mixedCase.pipe');
const app_component_1 = require('./app.component');
const insured_component_1 = require('./insured.component');
const chat_component_1 = require('./chat.component');
const ai_component_1 = require('./ai.component');
const ai2_component_1 = require('./ai2.component');
const login_component_1 = require('./login.component');
const createAccount_component_1 = require('./createAccount.component');
const review_component_1 = require('./review.component');
const payment_component_1 = require('./payment.component');
const admin_component_1 = require('./admin.component');
const quote_service_1 = require('./quote.service');
const question_component_1 = require('./question.component');
const question_service_1 = require('./question.service');
const question_panel_component_1 = require('./question-panel.component');
const quoteEngine_service_1 = require('./quoteEngine.service');
const componentFactory_1 = require('./componentFactory');
const message_service_1 = require('./message.service');
const form_service_1 = require('./form.service');
const broker_service_1 = require('./broker.service');
const http_1 = require('@angular/http');
let AppModule = class AppModule {
};
AppModule = __decorate([
    core_1.NgModule({
        imports: [http_1.HttpModule, platform_browser_1.BrowserModule, ng2_completer_1.Ng2CompleterModule, router_1.RouterModule.forRoot(app_routes_1.AppRoutes), forms_1.FormsModule, forms_1.ReactiveFormsModule],
        declarations: [mixedCase_pipe_1.MixedCase, review_component_1.ReviewComponent, payment_component_1.PaymentComponent, ai2_component_1.Ai2Component, question_component_1.QuestionComponent, question_panel_component_1.QuestionPanelComponent, ai_component_1.AiComponent, admin_component_1.AdminComponent, chat_component_1.ChatComponent, insured_component_1.InsuredComponent, app_component_1.AppComponent, login_component_1.LoginComponent, createAccount_component_1.CreateAccountComponent],
        providers: [question_service_1.QuestionService, componentFactory_1.ComponentFactory, quote_service_1.QuoteService, broker_service_1.BrokerService, message_service_1.MessageService, form_service_1.FormService, quoteEngine_service_1.QuoteEngineService],
        bootstrap: [app_component_1.AppComponent]
    }), 
    __metadata('design:paramtypes', [])
], AppModule);
exports.AppModule = AppModule;
//# sourceMappingURL=app.module.js.map