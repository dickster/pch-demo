import { Component, Injectable } from "@angular/core";
import { DynamicItem } from "./dynamicItem";
import { FormBuilder } from "@angular/forms";
import { Coverage } from "../model";

@Injectable()
@Component( {
  selector: 'coverage',
  templateUrl: 'coverage.component.html'
} )
export class CoverageComponent extends DynamicItem {
  private coverage: Coverage;

  constructor( private fb: FormBuilder ) {
    super();
  }

  ngOnInit(): void {
    this.coverage = this.child;
    this.ownForm = this.toFormGroup();
    this.ownForm.patchValue( this.coverage );
  }

  toFormGroup() {
    const formGroup = this.fb.group( {
      coverageCd: '',
      limit: '',
      deductible: '',
    } )

    return formGroup;
  }
}
