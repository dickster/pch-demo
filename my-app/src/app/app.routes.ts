import {Routes} from "@angular/router";
import {LoginComponent} from "./login.component";
import {AdminComponent} from "./admin.component";
import {RatingComponent} from "./rating.component";
import {ConfirmationComponent} from "./confirmation.component";
import {AIComponent} from "./ai.component";
import {PolicyDetailsComponent} from "./policyDetails.component";
import {DynamicAiComponent} from "./dynamicquestion/dynamic-ai.component";

export const routes: Routes = [
  {path: '', component: LoginComponent},
  {path: 'admin', component: AdminComponent},
  {path: 'rating', component: RatingComponent},
  {path: 'confirmation', component: ConfirmationComponent},
  {path: 'policyDetails', component: PolicyDetailsComponent},
  {path: 'ai', component: AIComponent},
  {path: 'dynamic-ai', component: DynamicAiComponent}
]
