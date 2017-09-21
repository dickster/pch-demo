import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
    selector: 'my-app',
    templateUrl: '/app/app.component.html'
})
export class AppComponent {

    form:FormGroup;

    constructor(private formBuilder: FormBuilder) { }


}
