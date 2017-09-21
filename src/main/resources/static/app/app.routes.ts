import {ChatComponent} from "./chat.component";
import {LoginComponent} from "./login.component";
import {CreateAccountComponent} from "./createAccount.component";
import {InsuredComponent} from "./insured.component";
import {AdminComponent} from "./admin.component";

import {Routes} from "@angular/router";
import {AiComponent} from "./ai.component";
import {Ai2Component} from "./ai2.component";
import {PaymentComponent} from "./payment.component";
import {ReviewComponent} from "./review.component";


// similar to wicket "mount" page.
export const AppRoutes:Routes = [
    { path: '', component: LoginComponent },
    { path: 'admin', component: AdminComponent },
    { path: 'insured', component: InsuredComponent },
    { path: 'insured2', component: InsuredComponent, data: { demo: true }},
    { path: 'ai', component: AiComponent },
    { path: 'ai2', component: Ai2Component },
    { path: 'review', component: ReviewComponent },
    { path: 'payment', component: PaymentComponent },
    { path: 'login', component: LoginComponent },
    { path: 'create', component: CreateAccountComponent },
    { path: 'chat', component: ChatComponent }
];

