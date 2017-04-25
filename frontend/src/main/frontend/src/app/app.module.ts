import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import {HttpModule, XSRFStrategy, CookieXSRFStrategy} from '@angular/http';

import { AppComponent }   from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';

import { DashboardModule } from './dashboard/dashboard.module';
import { SidebarModule } from './sidebar/sidebar.module';
import { FooterModule } from './shared/footer/footer.module';
import { NavbarModule} from './shared/navbar/navbar.module';

import { HashLocationStrategy, LocationStrategy } from '@angular/common';
import { AuthenticationComponent } from "./authentication/authentication.component";
import {AuthenticationGuard} from "./authentication/authentication.guard";
import {AlertService} from "./services/alert.service";
import {AuthenticationService} from "./services/authentication.service";
import {UserService} from "./services/user.service";
import {MODULE_ROUTES, MODULE_COMPONENTS} from "./app.routes";
import {FormsModule} from "@angular/forms";
import {TripService} from "./services/trip.service";
import {TagService} from "./services/tag.service";
import {DiscoveryService} from "./services/discovery.service";
import {CommentService} from "./services/comment.service";


@NgModule({
    imports: [
        RouterModule.forChild(MODULE_ROUTES),
        BrowserModule,
        DashboardModule,
        SidebarModule,
        NavbarModule,
        FooterModule,
        HttpModule,
        FormsModule,
        RouterModule.forRoot([])
    ],
    declarations: [
        AppComponent,
        MODULE_COMPONENTS,
        DashboardComponent,
        AuthenticationComponent,
    ],
    providers: [
        AuthenticationGuard,
        AlertService,
        AuthenticationService,
        UserService,
        TripService,
        TagService,
        DiscoveryService,
        CommentService,
        { provide: LocationStrategy, useClass: HashLocationStrategy }
        ],
    bootstrap: [ AppComponent ]
})
export class AppModule { }
