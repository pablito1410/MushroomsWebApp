import { Route } from '@angular/router';

import { LoginComponent } from './authentication/login/login.component';
import { RegisterComponent } from './authentication/register/register.component';
import { AuthenticationGuard } from './authentication/authentication.guard';
import { HomeComponent } from "./dashboard/home/home.component";
import { UserComponent } from "./dashboard/user/user.component";
import { TableComponent } from "./dashboard/table/table.component";
import { IconsComponent } from "./dashboard/icons/icons.component";
import { NotificationsComponent } from "./dashboard/notifications/notifications.component";
import { TypographyComponent } from "./dashboard/typography/typography.component";
import { MapsComponent } from "./dashboard/maps/maps.component";

export const APP_ROUTES: Route[] = [
    { path: 'dashboard', component: HomeComponent, canActivate: [AuthenticationGuard] },
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegisterComponent },
    { path: 'user', component: UserComponent, canActivate: [AuthenticationGuard] },
    { path: 'table', component: TableComponent, canActivate: [AuthenticationGuard] },
    { path: 'icons', component: IconsComponent, canActivate: [AuthenticationGuard] },
    { path: 'notifications', component: NotificationsComponent, canActivate: [AuthenticationGuard] },
    { path: 'typography', component: TypographyComponent, canActivate: [AuthenticationGuard] },
    { path: 'maps', component: MapsComponent, canActivate: [AuthenticationGuard] },
    { path: '', redirectTo: 'dashboard', pathMatch: 'full' },

    // otherwise redirect to home
    { path: '**', redirectTo: '' }
]

