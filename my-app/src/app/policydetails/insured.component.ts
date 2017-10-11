import {Component, OnInit} from "@angular/core";
import {Insured} from "../model";
import {ItemComponent} from "./item.component";

@Component({
  selector: 'insured',
  templateUrl: 'insured.component.html'
})
export class InsuredComponent extends ItemComponent implements OnInit {

  private insured: Insured;

  ngOnInit(): void {
    this.childForm = this.toFormGroup(this.child);
    this.insured = this.child;
    // this.insuredsFormArray.push(this.insuredForm);
  }

  toFormGroup(insured: Insured) {
    const formGroup = this.fb.group({
      givenName: [insured.nameInfo.personName.givenName || ''],
      surname: [insured.nameInfo.personName.surname || ''],
      addr1: [insured.addr.addr1 || ''],
      addr2: [insured.addr.addr2 || ''],
      city: [insured.addr.city || ''],
      stateProv: [insured.addr.stateProv],
      postalCode: [insured.addr.postalCode],
      country: [insured.addr.country]
    })

    return formGroup;
  }

}
