import {Component, OnInit, ElementRef} from "@angular/core";
import {FormGroup, FormBuilder} from "@angular/forms";
import {Router} from "@angular/router";
import {NgModel, NgFormControl} from "@angular/common";
import {Broker} from './broker';
import {Quote} from './quote';
import {Message} from './message';
import {Form} from './form';
import {RestService} from './rest.service';
import {Observable} from 'rxjs/Observable';
import {BrokerService} from "./broker.service";
import {FormService} from "./form.service";
import {MessageService} from "./message.service";
import {QuoteService} from "./quote.service";

declare var jQuery:any;

@Component({
    selector: 'admin',
    providers: [QuoteService, MessageService, FormService, BrokerService],
    templateUrl: '/app/admin.component.html'
})
export class AdminComponent implements OnInit {
    form:FormGroup;


    private formConfig:any = {
        'tab':'Brokers'
    };

    public brokers:Observable<Broker[]>;
    public quotes:Observable<Quote[]>;
    public messages:Observable<Message[]>;
    public forms:Observable<any[]>;


    constructor(
        private router: Router,
        private formBuilder:FormBuilder,
       private brokerService: BrokerService,
       private quoteService: QuoteService,
       private messageService: MessageService,
       private formService: FormService,
        private elementRef:ElementRef) {

        this.form = this.formBuilder.group( this.formConfig, { });

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

    isBrokers(): boolean {
        return this.form.controls['tab'].value == 'brokers';
    }

    isMessages(): boolean {
        return this.form.controls['tab'].value == 'messages';
    }


    isQuotes(): boolean {
        return this.form.controls['tab'].value == 'quotes';
    }

    isForms(): boolean {
        return this.form.controls['tab'].value == 'forms';
    }
}

