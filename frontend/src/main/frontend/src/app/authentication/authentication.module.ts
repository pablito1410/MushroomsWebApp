import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthenticationComponent } from "./authentication.component";
import { LoginComponent } from "./login/login.component";
import { RegisterComponent } from "./register/register.component";
import { CommonModule } from "@angular/common";
import {AlertModule} from "../shared/alert/alert.module";
import {FormsModule} from "@angular/forms";

@NgModule({
    imports: [
        FormsModule,
        RouterModule,
        CommonModule,
        AlertModule
    ],
    declarations: [
        AuthenticationComponent,
        RegisterComponent,
        LoginComponent
    ],
    exports: [
        AuthenticationComponent,
        RegisterComponent,
        LoginComponent
    ]
})
export class AuthenticationModule{}
