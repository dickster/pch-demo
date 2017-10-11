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
  constructor( private fb: FormBuilder ) {
    super();
  }

  ngOnInit(): void {
    this.ownForm = this.toFormGroup( this.child );
  }

  toFormGroup( cov: Coverage ) {
    const formGroup = this.fb.group( {
      coverageCd: [ cov.coverageCd || '' ],
      limit: [ cov.limit || 0 ],
      deductible: [ cov.deductible || 0 ]
    } )

    return formGroup;
  }
}
