import {Component, OnInit, Input} from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { AuthenticationService } from '../../services/authentication.service';
import {AppComponent} from "../../app.component";
import {MdSnackBar} from "@angular/material";

@Component({
    moduleId: module.id,
    selector: 'login-cmp',
    templateUrl: 'login.component.html'
})
export class LoginComponent implements OnInit {
    model: any = {};
    loading = false;
    returnUrl: string;

    constructor(
        private route: ActivatedRoute,
        private router: Router,
        private authenticationService: AuthenticationService,
        public snackBar: MdSnackBar) { }

    ngOnInit() {
        // reset login status
        this.authenticationService.logout();

        // get return url from route parameters or default to '/'
        this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
    }

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
