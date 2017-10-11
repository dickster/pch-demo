import { Component, ComponentFactoryResolver, ComponentRef, Input, OnDestroy, OnInit } from "@angular/core";
import { FormArray, FormGroup } from "@angular/forms";

@Component( {
  selector: 'list',
  templateUrl: 'list.component.html'
} )
export class ListComponent {

  @Input( 'itemType' )
  itemType: string;

  @Input( 'array' )
  array: FormArray;

  @Input( 'childrenData' )
  childrenData: any[];

  constructor() {

  }

}
