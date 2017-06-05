import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { HttpModule } from '@angular/http';
import { AppComponent } from './app.component';
import { DashboardModule } from './dashboard/dashboard.module';
import { SidebarModule } from './sidebar/sidebar.module';
import { FooterModule } from './shared/footer/footer.module';
import { NavbarModule} from './shared/navbar/navbar.module';
import { HashLocationStrategy, LocationStrategy } from '@angular/common';
import { AuthenticationGuard } from "./authentication/authentication.guard";
import { AuthenticationService } from "./services/authentication.service";
import { UserService } from "./services/user.service";
import { APP_ROUTES } from "./app.routes";
import { FormsModule } from "@angular/forms";
import { TripService } from "./services/trip.service";
import { TagService } from "./services/tag.service";
import { DiscoveryService } from "./services/discovery.service";
import { CommentService } from "./services/comment.service";
import { AuthenticationModule } from "./authentication/authentication.module";
import {FriendService} from "./services/friend.service";


@NgModule({
    imports: [
        FormsModule,
        BrowserModule,
        HttpModule,
        DashboardModule,
        SidebarModule,
        NavbarModule,
        FooterModule,
        AuthenticationModule,
        RouterModule.forRoot(APP_ROUTES)
    ],
    declarations: [
        AppComponent
    ],
    providers: [
        AuthenticationGuard,
        AuthenticationService,
        UserService,
        TripService,
        TagService,
        DiscoveryService,
        CommentService,
        FriendService,
        { provide: LocationStrategy, useClass: HashLocationStrategy }
    ],
    bootstrap: [ AppComponent ]
})
export class AppModule { }
