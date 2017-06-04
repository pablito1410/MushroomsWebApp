import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthenticationComponent } from "./authentication.component";
import { LoginComponent } from "./login/login.component";
import { RegisterComponent } from "./register/register.component";
import { CommonModule } from "@angular/common";
import { FormsModule } from "@angular/forms";
import { EqualValidator } from "./equal-validator.directive";

@NgModule({
    imports: [
        FormsModule,
        RouterModule,
        CommonModule
    ],
    declarations: [
        AuthenticationComponent,
        RegisterComponent,
        LoginComponent,
        EqualValidator
    ],
    exports: [
        AuthenticationComponent,
        RegisterComponent,
        LoginComponent
    ]
})
export class AuthenticationModule{}
