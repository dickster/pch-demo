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
import {FormArray, FormBuilder, FormGroup} from "@angular/forms";
import {InsuredComponent} from "./insured.component";

@Component({
  selector: 'dynamic-item',
  template: `
    <div>
      <div #container></div>
    </div>
  `
})
export class ItemComponent implements OnInit, OnDestroy {

  @ViewChild('container', {read: ViewContainerRef})
  container: ViewContainerRef;
  @Input('childrenArray')
  childrenArray: FormArray;
  @Input('child')
  child: any;
  @Input('itemType')
  type: string;
  childForm: FormGroup;
  private componentRef: ComponentRef<{}>;
  private mappings = {
    'insured': InsuredComponent,
  }

  constructor(public fb: FormBuilder,
              private componentFactoryResolver: ComponentFactoryResolver) {

  }

  getComponentType(typeName: string) {
    let type = this.mappings[typeName];
    return type || UnknownDynamicComponent;
  }

  toFormGroup(child: any) {
    const formGroup = this.fb.group({});

    return formGroup;
  }

  ngOnInit(): void {
    this.childForm = this.toFormGroup(this.child);

    if (this.type) {
      let componentType = this.getComponentType(this.type);

      // note: componentType must be declared within module.entryComponents
      let factory = this.componentFactoryResolver.resolveComponentFactory(componentType);
      this.componentRef = this.container.createComponent(factory);

      // set component context
      let instance = <ItemComponent> this.componentRef.instance;
      instance.childrenArray = this.childrenArray;
      instance.child = this.child;
      instance.childForm = this.childForm;
    }
  }

  ngOnDestroy() {
    if (this.componentRef) {
      this.componentRef.destroy();
      this.componentRef = null;
    }
  }

}

@Component({
  selector: 'unknown-component',
  template: `
    <div>Unknown component</div>`
})
export class UnknownDynamicComponent extends ItemComponent {
}
