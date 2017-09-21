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
const core_1 = require("@angular/core");
const forms_1 = require("@angular/forms");
const router_1 = require("@angular/router");
const broker_service_1 = require("./broker.service");
const form_service_1 = require("./form.service");
const message_service_1 = require("./message.service");
const quote_service_1 = require("./quote.service");
let AdminComponent = class AdminComponent {
    constructor(router, formBuilder, brokerService, quoteService, messageService, formService, elementRef) {
        this.router = router;
        this.formBuilder = formBuilder;
        this.brokerService = brokerService;
        this.quoteService = quoteService;
        this.messageService = messageService;
        this.formService = formService;
        this.elementRef = elementRef;
        this.formConfig = {
            'tab': 'Brokers'
        };
        this.form = this.formBuilder.group(this.formConfig, {});
        this.brokers = this.brokerService.get();
        this.quotes = this.quoteService.get();
        this.messages = this.messageService.get();
        this.forms = this.formService.get();
    }
    ngOnInit() {
    }
    ngAfterContentChecked() {
        jQuery.material.init(); // TODO : refactor this into common component.
    }
    isBrokers() {
        return this.form.controls['tab'].value == 'brokers';
    }
    isMessages() {
        return this.form.controls['tab'].value == 'messages';
    }
    isQuotes() {
        return this.form.controls['tab'].value == 'quotes';
    }
    isForms() {
        return this.form.controls['tab'].value == 'forms';
    }
};
AdminComponent = __decorate([
    core_1.Component({
        selector: 'admin',
        providers: [quote_service_1.QuoteService, message_service_1.MessageService, form_service_1.FormService, broker_service_1.BrokerService],
        templateUrl: '/app/admin.component.html'
    }), 
    __metadata('design:paramtypes', [router_1.Router, forms_1.FormBuilder, broker_service_1.BrokerService, quote_service_1.QuoteService, message_service_1.MessageService, form_service_1.FormService, core_1.ElementRef])
], AdminComponent);
exports.AdminComponent = AdminComponent;
//# sourceMappingURL=admin.component.js.map