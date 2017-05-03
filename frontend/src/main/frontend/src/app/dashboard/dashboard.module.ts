import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import {CommonModule} from "@angular/common";
import {DashboardComponent} from "./dashboard.component";
import {HomeComponent} from "./home/home.component";
import {UserComponent} from "./user/user.component";
import {TableComponent} from "./table/table.component";
import {IconsComponent} from "./icons/icons.component";
import {NotificationsComponent} from "./notifications/notifications.component";
import {TypographyComponent} from "./typography/typography.component";
import {MapsComponent} from "./maps/maps.component";

@NgModule({
    imports: [
       RouterModule, CommonModule
    ],
    declarations: [
        DashboardComponent,
        HomeComponent,
        UserComponent,
        TableComponent,
        IconsComponent,
        NotificationsComponent,
        TypographyComponent,
        MapsComponent
    ],
    exports: [
        DashboardComponent,
        HomeComponent,
        UserComponent,
        TableComponent,
        IconsComponent,
        NotificationsComponent,
        TypographyComponent,
        MapsComponent
    ]
})
export class DashboardModule{}
