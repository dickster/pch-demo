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
const ng2_completer_1 = require("ng2-completer");
const http_1 = require('@angular/http');
const router_1 = require('@angular/router');
require('rxjs/add/operator/switchMap');
let InsuredComponent = class InsuredComponent {
    constructor(router, formBuilder, completerService, http, route, elementRef) {
        this.router = router;
        this.formBuilder = formBuilder;
        this.completerService = completerService;
        this.http = http;
        this.route = route;
        this.elementRef = elementRef;
        this.myCovers = [
            { name: 'Employers Liability' },
            { name: 'Directors and Operators' }
        ];
        this.formConfig = {
            'broker': 'Bob',
            'proposal': 'Direct',
            'firstName': ['', forms_1.Validators.required],
            'middleName': '',
            'segment': '',
            'lastName': ['', forms_1.Validators.required],
            'phone': ['']
        };
        this.saving = false;
        this.previous = {};
        this.dataService = this.completerService.remote('/broker?search=', '', 'desc');
    }
    ngOnInit() {
        this.formConfig.covers = this.initCovers(this.myCovers);
        this.form = this.formBuilder.group(this.formConfig, { validator: this.isFormValid });
        this.form.valueChanges
            .debounceTime(500)
            .subscribe(data => this.saveDraft(data));
        let demo = this.route.snapshot.data['demo'];
        if (demo) {
            this.dataService = this.completerService.remote('/broker/demo?search=', '', 'desc');
        }
    }
    saveDraft(data) {
        if (!this.formChangedSignificantly(data)) {
            return;
        }
        this.saving = true;
        let bodyString = JSON.stringify(data); // Stringify payload
        let headers = new http_1.Headers({ 'Content-Type': 'application/json' }); // ... Set content type to JSON
        let options = new http_1.RequestOptions({ headers: headers }); // Create a request option
        return this.http.put('/drafts', bodyString, options)
            .map((res) => res.json())
            .subscribe(data => { this.saving = false; }, (err) => {
            this.saving = false;
        });
    }
    ngAfterContentChecked() {
        // ToDO : put this into common page component.
        // or add jquery.on("document router-outlet").fn(){material.init9)};
        jQuery.material.init();
        jQuery(this.elementRef.nativeElement).find('.completer-input').addClass('form-control');
    }
    isBroker() {
        return this.form.controls['proposal'].value == 'Broker';
    }
    isDirect() {
        return this.form.controls['proposal'].value == 'Direct';
    }
    isCoverEnabled(index) {
        //noinspection TypeScriptUnresolvedVariable
        return this.form.controls.covers.controls[index].controls.name.value;
    }
    anyCovers() {
        //noinspection TypeScriptUnresolvedVariable
        for (let i in this.form.controls.covers.controls) {
            if (this.isCoverEnabled(i))
                return true;
        }
        return false;
    }
    initCovers(covers) {
        let result = [];
        for (let cover of covers) {
            result.push(this.newCover());
        }
        return this.formBuilder.array(result);
    }
    newCover() {
        return this.formBuilder.group({
            name: [false],
            commission: ['']
        });
    }
    // isValidTotalCommission(form) : any {
    // }
    isFormValid(form) {
        //        if (form.controls.proposal.value=='Broker' && !form.controls.broker.value) {
        //            return {msg:'no broker specified', field:'broker'};
        //        }
        let result = 0;
        let pristine = true;
        for (let cover of form.controls.covers.controls) {
            let enabled = cover.controls.name.value;
            let commission = cover.controls.commission;
            if (enabled) {
                pristine = (commission.pristine) && pristine;
                result += commission.value;
            }
        }
        let valid = (result == 100 || pristine);
        return (valid) ? null :
            { msg: "commission must total 100, currently (" + result + ")", field: 'commission' };
    }
    handleSubmit(event) {
        console.log(this.form.value);
        event.preventDefault();
        this.router.navigate(['/ai']);
    }
    formChangedSignificantly(data) {
        let result = this.previous.segment != data.segment || this.previous.proposal != data.proposal;
        this.previous = Object.assign({}, data);
        return result;
    }
    isSaving() {
        return this.saving;
    }
};
InsuredComponent = __decorate([
    core_1.Component({
        templateUrl: 'app/insured.component.html',
        providers: []
    }), 
    __metadata('design:paramtypes', [router_1.Router, forms_1.FormBuilder, ng2_completer_1.CompleterService, http_1.Http, router_1.ActivatedRoute, core_1.ElementRef])
], InsuredComponent);
exports.InsuredComponent = InsuredComponent;
//# sourceMappingURL=insured.component.js.map