"use strict";
var authentication_component_1 = require('./authentication/authentication.component');
var login_component_1 = require('./authentication/login/login.component');
var register_component_1 = require('./authentication/register/register.component');
var authentication_guard_1 = require('./authentication/authentication.guard');
var alert_component_1 = require("./authentication/alert/alert.component");
var home_component_1 = require("./dashboard/home/home.component");
var user_component_1 = require("./dashboard/user/user.component");
var table_component_1 = require("./dashboard/table/table.component");
var icons_component_1 = require("./dashboard/icons/icons.component");
var notifications_component_1 = require("./dashboard/notifications/notifications.component");
var typography_component_1 = require("./dashboard/typography/typography.component");
var maps_component_1 = require("./dashboard/maps/maps.component");
exports.MODULE_ROUTES = [
    { path: '', component: authentication_component_1.AuthenticationComponent, canActivate: [authentication_guard_1.AuthenticationGuard] },
    { path: 'login', component: login_component_1.LoginComponent },
    { path: 'register', component: register_component_1.RegisterComponent },
    { path: 'dashboard', component: home_component_1.HomeComponent },
    { path: 'user', component: user_component_1.UserComponent },
    { path: 'table', component: table_component_1.TableComponent },
    { path: 'icons', component: icons_component_1.IconsComponent },
    { path: 'notifications', component: notifications_component_1.NotificationsComponent },
    { path: 'typography', component: typography_component_1.TypographyComponent },
    { path: 'maps', component: maps_component_1.MapsComponent },
    // otherwise redirect to home
    { path: '**', redirectTo: '' }
];
exports.MODULE_COMPONENTS = [
    authentication_component_1.AuthenticationComponent,
    login_component_1.LoginComponent,
    register_component_1.RegisterComponent,
    alert_component_1.AlertComponent,
    home_component_1.HomeComponent,
    user_component_1.UserComponent,
    table_component_1.TableComponent,
    icons_component_1.IconsComponent,
    notifications_component_1.NotificationsComponent,
    typography_component_1.TypographyComponent,
    maps_component_1.MapsComponent
];
//# sourceMappingURL=app.routes.js.map