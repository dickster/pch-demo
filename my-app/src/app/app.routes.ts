import {Routes} from "@angular/router";
import {AppComponent} from "./app.component";
import {LoginComponent} from "./login.component";
import {AdminComponent} from "./admin.component";

export const routes: Routes = [
    { path: '', component: LoginComponent},
    { path: 'admin', component: AdminComponent },
]