"use strict";
const chat_component_1 = require("./chat.component");
const login_component_1 = require("./login.component");
const createAccount_component_1 = require("./createAccount.component");
const insured_component_1 = require("./insured.component");
const admin_component_1 = require("./admin.component");
const ai_component_1 = require("./ai.component");
const ai2_component_1 = require("./ai2.component");
const payment_component_1 = require("./payment.component");
const review_component_1 = require("./review.component");
// similar to wicket "mount" page.
exports.AppRoutes = [
    { path: '', component: login_component_1.LoginComponent },
    { path: 'admin', component: admin_component_1.AdminComponent },
    { path: 'insured', component: insured_component_1.InsuredComponent },
    { path: 'insured2', component: insured_component_1.InsuredComponent, data: { demo: true } },
    { path: 'ai', component: ai_component_1.AiComponent },
    { path: 'ai2', component: ai2_component_1.Ai2Component },
    { path: 'review', component: review_component_1.ReviewComponent },
    { path: 'payment', component: payment_component_1.PaymentComponent },
    { path: 'login', component: login_component_1.LoginComponent },
    { path: 'create', component: createAccount_component_1.CreateAccountComponent },
    { path: 'chat', component: chat_component_1.ChatComponent }
];
//# sourceMappingURL=app.routes.js.map