import { Route } from '@angular/router';

import { LoginComponent } from './authentication/login/login.component';
import { RegisterComponent } from './authentication/register/register.component';
import { AuthenticationGuard } from './authentication/authentication.guard';
import { HomeComponent } from "./dashboard/home/home.component";
import { UserComponent } from "./dashboard/user/user.component";
import { FriendsComponent } from "./dashboard/friends/friends.component";
import { TripsComponent } from "./dashboard/trips/trips.component";
import { NotificationsComponent } from "./dashboard/notifications/notifications.component";
import { DiscoveriesComponent } from "./dashboard/discoveries/discoveries.component";
import { MapsComponent } from "./dashboard/maps/maps.component";

export const APP_ROUTES: Route[] = [
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegisterComponent },
    { path: 'dashboard', component: HomeComponent, canActivate: [AuthenticationGuard] },
    { path: 'user', component: UserComponent, canActivate: [AuthenticationGuard] },
    { path: 'trips', component: TripsComponent, canActivate: [AuthenticationGuard] },
    { path: 'discoveries', component: DiscoveriesComponent, canActivate: [AuthenticationGuard] },
    { path: 'friends', component: FriendsComponent, canActivate: [AuthenticationGuard] },
    { path: 'notifications', component: NotificationsComponent, canActivate: [AuthenticationGuard] },
    { path: 'maps', component: MapsComponent, canActivate: [AuthenticationGuard] },
    { path: '', redirectTo: 'dashboard', pathMatch: 'full' },

    // otherwise redirect to home
    { path: '**', redirectTo: '' }
]

