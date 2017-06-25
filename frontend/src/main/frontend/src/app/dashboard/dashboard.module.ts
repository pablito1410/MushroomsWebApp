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
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import {
    MdNativeDateModule, MdDialogModule, MdDatepickerModule, MdSnackBarModule, MdSnackBar,
    LiveAnnouncer, MdSelect, MdSelectModule
} from "@angular/material";
import { AgmCoreModule } from "angular2-google-maps/core";
import { SearchFriendsComponent } from "./friends/search-friends/search-friends.component";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { BrowserModule } from "@angular/platform-browser";
import {AddDiscoveryComponent} from "./discoveries/add-discovery/add-discovery.component";
import {DiscoveryDetailsComponent} from "./discoveries/discovery-details/discovery-details.component";
import {FriendDetailsComponent} from "./friends/friend-details/friend-details.component";
import {TripDetailsComponent} from "./trips/trip-details/trip-details.component";
import {AddTripComponent} from "./trips/add-trip/add-trip.component";
import {TreeModule} from "angular-tree-component";
import {CommentsTreeComponent} from "./comments/comments-tree/comments-tree.component";
import {RatingModule} from "ngx-rating";
import {CommentComponent} from "./comments/comment/comment.component";

@NgModule({
    imports: [
        BrowserModule,
        BrowserAnimationsModule,
        RouterModule,
        CommonModule,
        FormsModule,
        MdDatepickerModule,
        MdNativeDateModule,
        MdDialogModule,
        MdSnackBarModule,
        MdSelectModule,
        ReactiveFormsModule,
        TreeModule,
        RatingModule,
        AgmCoreModule.forRoot({
            apiKey: 'AIzaSyDd7pfi7_Du2senx4g4lLArVguhMd2LUKY',
            libraries: ['places']
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
        MapsComponent,
        SearchFriendsComponent,
        AddDiscoveryComponent,
        DiscoveryDetailsComponent,
        FriendDetailsComponent,
        TripDetailsComponent,
        AddTripComponent,
        CommentsTreeComponent,
        CommentComponent
    ],
    entryComponents: [
        SearchFriendsComponent,
        AddDiscoveryComponent,
        DiscoveryDetailsComponent,
        FriendDetailsComponent,
        TripDetailsComponent,
        AddTripComponent
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
    ],
    providers: [
        LiveAnnouncer
    ]
})
export class DashboardModule{}
