import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from "@angular/common";
import { DashboardComponent } from "./dashboard.component";
import { HomeComponent } from "./home/home.component";
import { UserComponent } from "./user/user.component";
import { FriendsComponent } from "./friends/friends.component";
import { TripsComponent } from "./trips/trips.component";
import { NotificationsComponent } from "./notifications/notifications.component";
import { DiscoveriesComponent } from "./discoveries/discoveries.component";
import { MapsComponent} from "./maps/maps.component";
import { FormsModule } from "@angular/forms";
import { MdNativeDateModule, MaterialModule } from "@angular/material";
import { AgmCoreModule } from "angular2-google-maps/core";

@NgModule({
    imports: [
        RouterModule,
        CommonModule,
        FormsModule,
        MaterialModule,
        MdNativeDateModule,
        AgmCoreModule.forRoot({
            apiKey: 'AIzaSyDd7pfi7_Du2senx4g4lLArVguhMd2LUKY'
        })
    ],
    declarations: [
        DashboardComponent,
        HomeComponent,
        UserComponent,
        FriendsComponent,
        TripsComponent,
        NotificationsComponent,
        DiscoveriesComponent,
        MapsComponent
    ],
    exports: [
        DashboardComponent,
        HomeComponent,
        UserComponent,
        FriendsComponent,
        TripsComponent,
        NotificationsComponent,
        DiscoveriesComponent,
        MapsComponent
    ]
})
export class DashboardModule{}
