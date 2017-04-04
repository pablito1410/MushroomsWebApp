import { Route } from '@angular/router';

import { AuthenticationComponent } from './authentication/authentication.component';
import { LoginComponent } from './authentication/login/login.component';
import { RegisterComponent } from './authentication/register/register.component';
import { AuthenticationGuard } from './authentication/authentication.guard';
import { AlertComponent } from "./authentication/alert/alert.component";
import {HomeComponent} from "./dashboard/home/home.component";
import {UserComponent} from "./dashboard/user/user.component";
import {TableComponent} from "./dashboard/table/table.component";
import {IconsComponent} from "./dashboard/icons/icons.component";
import {NotificationsComponent} from "./dashboard/notifications/notifications.component";
import {TypographyComponent} from "./dashboard/typography/typography.component";
import {MapsComponent} from "./dashboard/maps/maps.component";

export const MODULE_ROUTES: Route[] =[
    { path: '', component: AuthenticationComponent, canActivate: [AuthenticationGuard] },
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegisterComponent },
    { path: 'dashboard', component: HomeComponent },
    { path: 'user', component: UserComponent },
    { path: 'table', component: TableComponent },
    { path: 'icons', component: IconsComponent },
    { path: 'notifications', component: NotificationsComponent },
    { path: 'typography', component: TypographyComponent },
    { path: 'maps', component: MapsComponent },

    // otherwise redirect to home
    { path: '**', redirectTo: '' }
]

export const MODULE_COMPONENTS = [
    AuthenticationComponent,
    LoginComponent,
    RegisterComponent,
    AlertComponent,
    HomeComponent,
    UserComponent,
    TableComponent,
    IconsComponent,
    NotificationsComponent,
    TypographyComponent,
    MapsComponent
]
