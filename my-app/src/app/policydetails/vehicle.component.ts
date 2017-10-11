import { Component, Injectable } from "@angular/core";
import { DynamicItem } from "./dynamicItem";
import { FormBuilder } from "@angular/forms";
import { Vehicle } from "../model";

@Injectable()
@Component( {
  selector: 'vehicle',
  templateUrl: 'vehicle.component.html'
} )
export class VehicleComponent extends DynamicItem {
  constructor( private fb: FormBuilder ) {
    super();
  }

  ngOnInit(): void {
    this.ownForm = this.toFormGroup( this.child );
  }

  toFormGroup( veh: Vehicle ) {
    const formGroup = this.fb.group( {
      manufacturer: [ veh.manufacturer || '' ],
      model: [ veh.model || '' ],
      modelYear: [ veh.modelYear || '' ],
      bodyType: [ veh.bodyType || '' ],
      costNewAmt: [ veh.costNewAmt || 0 ],
      annualDistance: [ veh.annualDistance || 0 ],
      purchaseDate: [ veh.purchaseDate || new Date() ],
      vin: [ veh.vin || '' ],
      vehUseCd: [ veh.vehUseCd || '' ],
      engineType: [ veh.engineType ],
      rateClassCd: [ veh.rateClassCd ],
    } )

    return formGroup;
  }
}
