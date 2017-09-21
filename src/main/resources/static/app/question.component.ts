import { Component, Input } from '@angular/core';
import { FormGroup }        from '@angular/forms';
import { ComponentConfig }     from './component.config';
import {CompleterService, CompleterData, LocalData} from "ng2-completer";

// TODO : refactor selector.
@Component({
    //moduleId: module.id,
    // styles:['[ng-reflect-value="2"] { background:pink; }'],
    selector: 'df-question',
    templateUrl: 'app/question.component.html'
})
export class QuestionComponent {
    @Input() question: ComponentConfig<any>;
    @Input() form: FormGroup;
    private dataService:CompleterData = <CompleterData>{ };

    private searchData = [
        {value: 'Bob', key: '1754'},
        {value: 'Fred', key: '3972'},
        {value: 'Sally', key: '243'},
        {value: 'Cathy', key: '4948'},
        {value: 'Jim', key: '519'},
        {value: 'Sam', key: '6344'},
        {value: 'Susan', key: '9787'}
    ];
    

    constructor(private completerService: CompleterService) {
        this.dataService = this.completerService.local(this.searchData, 'value', 'value');
    }


    get isValid() { return this.form.controls[this.question.key].valid; }
    get isPristine() { return this.form.controls[this.question.key].pristine; }
    get isTouched() { return this.form.controls[this.question.key].touched; }

    isVisible(formValue:any) : boolean  {
        for (let dependency of this.question.showWhen) {
            let actual = this.form.controls[dependency.parent].value;
            let expected = dependency.value;
            // console.log('show when ' + dependency.parent + ' is ' + dependency.value + ' ('+actual+')');
            if (actual != expected) {
                return false;
            }
        }
        return true;
    }

    isActiveYesNo(control:string) {
        let result : boolean = this.form.controls[control].value=='yes';
        // console.log('yesno : ' + control + ' --> ' + result + '   (' + this.form.controls[control].value+ ')');
        return result;
    }

    ngOnInit() {
        if (this.question.type!='autocomplete') return;
        console.log('init autocomplete');
        if (this.question['choices']) {
            console.log('...with choices ' + this.question['choices']);
            (<LocalData>this.dataService).data(this.question['choices']);
        }
    }
}
