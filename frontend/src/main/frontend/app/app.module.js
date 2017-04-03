"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require('@angular/core');
var platform_browser_1 = require('@angular/platform-browser');
var router_1 = require('@angular/router');
var http_1 = require('@angular/http');
var app_component_1 = require('./app.component');
var dashboard_component_1 = require('./dashboard/dashboard.component');
var dashboard_module_1 = require('./dashboard/dashboard.module');
var sidebar_module_1 = require('./sidebar/sidebar.module');
var footer_module_1 = require('./shared/footer/footer.module');
var navbar_module_1 = require('./shared/navbar/navbar.module');
var common_1 = require('@angular/common');
var authentication_component_1 = require("./authentication/authentication.component");
var authentication_guard_1 = require("./authentication/authentication.guard");
var alert_service_1 = require("./services/alert.service");
var authentication_service_1 = require("./services/authentication.service");
var user_service_1 = require("./services/user.service");
var app_routes_1 = require("./app.routes");
var forms_1 = require("@angular/forms");
var AppModule = (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        core_1.NgModule({
            imports: [
                router_1.RouterModule.forChild(app_routes_1.MODULE_ROUTES),
                platform_browser_1.BrowserModule,
                dashboard_module_1.DashboardModule,
                sidebar_module_1.SidebarModule,
                navbar_module_1.NavbarModule,
                footer_module_1.FooterModule,
                http_1.HttpModule,
                forms_1.FormsModule,
                router_1.RouterModule.forRoot([])
            ],
            declarations: [
                app_component_1.AppComponent,
                app_routes_1.MODULE_COMPONENTS,
                dashboard_component_1.DashboardComponent,
                authentication_component_1.AuthenticationComponent,
            ],
            providers: [
                authentication_guard_1.AuthenticationGuard,
                alert_service_1.AlertService,
                authentication_service_1.AuthenticationService,
                user_service_1.UserService, {
                    provide: common_1.LocationStrategy,
                    useClass: common_1.HashLocationStrategy
                }],
            bootstrap: [app_component_1.AppComponent]
        }), 
        __metadata('design:paramtypes', [])
    ], AppModule);
    return AppModule;
}());
exports.AppModule = AppModule;
//# sourceMappingURL=app.module.js.map