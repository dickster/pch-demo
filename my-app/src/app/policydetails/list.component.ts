import {Component, ComponentFactoryResolver, ComponentRef, Input, OnDestroy, OnInit} from "@angular/core";
import {FormArray, FormGroup} from "@angular/forms";

@Component({
  selector: 'list',
  templateUrl: 'list.component.html'
})
export class ListComponent implements OnInit {

  @Input('itemType')
  itemType: string;

  @Input('parentForm')
  parentForm: FormGroup;

  @Input('childrenData')
  childrenData: any[];

  constructor() {

  }

  ngOnInit() {

    this.parentForm.addControl('childrenArray', new FormArray([]));
  }

}
