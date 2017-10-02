import {Routes} from "@angular/router";
import {AppComponent} from "./app.component";
import {LoginComponent} from "./login.component";

export const routes: Routes = [
    {
        path: '',
        component: LoginComponent
        // children: [
        //     {
        //         path: '',
        //         component: LoginComponent
        //     },
        // ]
    }
]