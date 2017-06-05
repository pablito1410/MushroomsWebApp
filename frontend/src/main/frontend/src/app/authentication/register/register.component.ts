import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { UserService } from '../../services/user.service';
import {MdSnackBar} from "@angular/material";

@Component({
    moduleId: module.id,
    selector: 'register-cmp',
    templateUrl: 'register.component.html'
})

export class RegisterComponent {
    model: any = {};
    loading = false;

    constructor(
        private router: Router,
        private userService: UserService,
        public snackBar: MdSnackBar) { }

    private openSnackBar(message: string, action: string) {
        this.snackBar.open(message, action, {
            duration: 2000,
        });
    }

    register() {
        this.loading = true;
        this.userService.create(this.model)
            .subscribe(
                data => {
                    this.router.navigate(['/login']);
                    this.openSnackBar('Registration Success', '×');
                },
                error => {
                    this.loading = false;
                    this.openSnackBar('Registration Error', '×');
                });
    }
}
