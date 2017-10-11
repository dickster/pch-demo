import {Routes} from "@angular/router";
import {LoginComponent} from "./login.component";
import {AdminComponent} from "./admin.component";
import {RatingComponent} from "./rating.component";
import {ConfirmationComponent} from "./confirmation.component";
import {PolicyDetailsComponent} from "./policydetails/policyDetails.component";
import {DynamicAiComponent} from "./ai/dynamic-ai.component";
import {PCHComponent} from "./pch.component";

export const routes: Routes = [
  {path: '', component: LoginComponent},
  {path: 'admin', component: AdminComponent},
  {path: 'rating', component: RatingComponent},
  {path: 'confirmation', component: ConfirmationComponent},
  {path: 'policyDetails', component: PolicyDetailsComponent},
  {path: 'pch', component: PCHComponent},
  {path: 'ai', component: DynamicAiComponent}
]
