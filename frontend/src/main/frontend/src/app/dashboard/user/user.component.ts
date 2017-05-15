import { Component, OnInit } from '@angular/core';
import { UserService } from "../../services/user.service";
import { Router } from "@angular/router";

@Component({
    moduleId: module.id,
    selector: 'user-cmp',
    templateUrl: 'user.component.html'
})
export class UserComponent implements OnInit {
    model: any = {};
    loading = false;

    constructor(
        private router: Router,
        private userService: UserService) { }

    ngOnInit() {
        if (localStorage.getItem('currentUser')) {
            this.model = localStorage.getItem('currentUser');
        }
    }

    update() {
        this.loading = true;
        this.userService.update(this.model)
            .subscribe(
                data => {
                    // this.alertService.success('Registration successful', true);
                    this.router.navigate(['/user']);
                },
                error => {
                    // this.alertService.error(error);
                    this.loading = false;
                });
    }
}
