import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../../services/user.service';
import { MdSnackBar } from "@angular/material";

/**
 * Registration page component
 */
@Component({
    moduleId: module.id,
    selector: 'register-cmp',
    templateUrl: 'register.component.html'
})
export class RegisterComponent {
    
    /** User login data in form */
    model: any = {};
    /** Flag indicating whether to display the loading animated icon */
    loading = false;

    /**
     * Constructor of class
     * @param router        Router
     * @param userService   User service
     * @param snackBar      Material snack bar
     */
    constructor(
        private router: Router,
        private userService: UserService,
        public snackBar: MdSnackBar) { }

    /**
     * Register button handle
     */
    register() {
        this.loading = true;
        this.userService.create(this.model)
            .subscribe(
                data => {
                    this.router.navigate(['/login']);
                    this.snackBar.open('Registration Success', '×', {
                        duration: 2000,
                    });
                },
                error => {
                    this.loading = false;
                    this.snackBar.open('Registration Error', '×', {
                        duration: 2000,
                    });
                });
    }
}
