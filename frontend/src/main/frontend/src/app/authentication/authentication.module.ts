import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { MODULE_COMPONENTS, MODULE_ROUTES } from '../app.routes';
import {AppComponent} from "../app.component";
import {AuthenticationComponent} from "./authentication.component";
import {LoginComponent} from "./login/login.component";
import {RegisterComponent} from "./register/register.component";
import {AlertComponent} from "./alert/alert.component";
import {BrowserModule} from "@angular/platform-browser";
import {FormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";
import {CommonModule} from "@angular/common";

@NgModule({
    imports: [
        RouterModule, CommonModule
    ],
    declarations: [

    ]
})

export class AuthenticationModule{}
