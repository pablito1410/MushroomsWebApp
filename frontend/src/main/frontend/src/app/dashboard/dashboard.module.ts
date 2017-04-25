import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { MODULE_COMPONENTS, MODULE_ROUTES } from './../app.routes';
import {CommonModule} from "@angular/common";

@NgModule({
    imports: [
       RouterModule, CommonModule
    ],
    declarations: [ ]
})

export class DashboardModule{}
