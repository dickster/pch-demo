import {Routes} from "@angular/router";
import {AppComponent} from "./app.component";
import {LoginComponent} from "./login.component";
import {AdminComponent} from "./admin.component";
import {RatingComponent} from "./rating.component";
import {ConfirmationComponent} from "./confirmation.component";

export const routes: Routes = [
    { path: '', component: LoginComponent},
    { path: 'admin', component: AdminComponent },
    { path: 'rating', component: RatingComponent},
    { path: 'confirmation', component: ConfirmationComponent}
]