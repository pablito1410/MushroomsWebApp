import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { AlertComponent } from "./alert.component";

@NgModule({
    imports: [ RouterModule, CommonModule ],
    declarations: [ AlertComponent ],
    exports: [ AlertComponent ]
})
export class AlertModule {}
