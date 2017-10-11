import {Component, ComponentFactoryResolver, ComponentRef, Input, OnDestroy, OnInit} from "@angular/core";
import {FormArray, FormGroup} from "@angular/forms";

@Component({
  selector: 'list',
  templateUrl: 'list.component.html'
})
export class ListComponent implements OnInit {

  @Input('itemType')
  public itemType: string;

  @Input('parentForm')
  public parentForm: FormGroup;

  @Input('childrenData')
  public childrenData: any[];

  constructor() {

  }

  ngOnInit() {

    this.parentForm.addControl('childrenArray', new FormArray([]));
  }

}
