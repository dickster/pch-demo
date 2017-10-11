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

  private vehicle: Vehicle;

  constructor( private fb: FormBuilder ) {
    super();
  }

  ngOnInit(): void {
    this.vehicle = this.child;
    this.ownForm = this.toFormGroup();
    this.ownForm.patchValue( this.vehicle )
  }

  toFormGroup() {
    const formGroup = this.fb.group( {
      manufacturer: '',
      model: '',
      modelYear: '',
      bodyType: '',
      costNewAmt: '',
      annualDistance: '',
      purchaseDate: '',
      vin: '',
      vehUseCd: '',
      engineType: '',
      rateClassCd: '',
      coverages: [],
      questionAnswers: []
    } )

    return formGroup;
  }
}
