import {
  Component,
  ComponentFactoryResolver,
  ComponentRef,
  Input,
  OnDestroy,
  OnInit,
  ViewChild,
  ViewContainerRef
} from "@angular/core";
import { FormArray } from "@angular/forms";
import { DynamicItem, UnknownDynamicComponent } from "./dynamicItem";
import { PhoneInfoComponent } from "./phoneInfo.component";
import { InsuredComponent } from "./insured.component";
import { VehicleComponent } from "./vehicle.component";
import { CoverageComponent } from "./coverage.component";
import { QuestionAnswerComponent } from "./questionAnswer.component";
import { DriverComponent } from "./driver.component";
import { LicenseComponent } from "./license.component";

@Component( {
  selector: 'dynamic-item',
  template: `
    <div>
      <div #container></div>
    </div>
  `
} )
export class ItemComponent implements OnInit, OnDestroy {

  @ViewChild( 'container', { read: ViewContainerRef } )
  container: ViewContainerRef;
  @Input( 'childrenArray' )
  childrenArray: FormArray;
  @Input( 'child' )
  child: any;
  @Input( 'itemType' )
  type: string;

  private componentRef: ComponentRef<{}>;
  private mappings = {
    'insured': InsuredComponent,
    'phoneInfo': PhoneInfoComponent,
    'vehicle': VehicleComponent,
    'coverage': CoverageComponent,
    'questionAnswer': QuestionAnswerComponent,
    'driver': DriverComponent,
    'license': LicenseComponent
  }

  constructor( private componentFactoryResolver: ComponentFactoryResolver ) {
  }

  getComponentType( typeName: string ) {
    let type = this.mappings[ typeName ];
    return type || UnknownDynamicComponent;
  }

  ngOnInit(): void {

    if ( this.type ) {
      let componentType = this.getComponentType( this.type );

      // note: componentType must be declared within module.entryComponents
      let factory = this.componentFactoryResolver.resolveComponentFactory( componentType );
      this.componentRef = this.container.createComponent( factory );

      // set component context
      let instance = <DynamicItem> this.componentRef.instance;
      instance.childrenArray = this.childrenArray;
      instance.child = this.child;
    }
  }

  ngOnDestroy() {
    if ( this.componentRef ) {
      this.componentRef.destroy();
      this.componentRef = null;
    }
  }

}

