import { Component, OnInit, Input } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthenticationService } from '../../services/authentication.service';
import { AppComponent } from "../../app.component";
import { MdSnackBar } from "@angular/material";

/**
 * Login page component
 */
@Component({
    moduleId: module.id,
    selector: 'login-cmp',
    templateUrl: 'login.component.html'
})
export class LoginComponent implements OnInit {

    /** User login data in form */
    model: any;
    /** Flag indicating whether to display the loading animated icon */
    loading: boolean;
    /** Returned url from route parameters or default */
    returnUrl: string;

    /**
     * Constructor of class
     * @param route                     Activated route
     * @param router                    Router
     * @param authenticationService     Authentication service
     * @param snackBar                  Material snack bar
     */
    constructor(
        private route: ActivatedRoute,
        private router: Router,
        private authenticationService: AuthenticationService,
        public snackBar: MdSnackBar) {
        this.model = {};
        this.loading = false;
    }

    /**
     * Initialize method
     */
    ngOnInit() {
        this.authenticationService.logout();
        this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
    }

    /**
     * Login button handle
     */
    login() {
        this.loading = true;
        this.authenticationService.login(this.model.email, this.model.password)
            .subscribe(
                data => {
                    this.router.navigate([this.returnUrl]);
                    this.snackBar.open('Login Success', '×', {
                        duration: 2000,
                    });
                },
                error => {
                    this.loading = false;
                    this.snackBar.open('Login Error', '×', {
                        duration: 2000,
                    });
                });
    }
}