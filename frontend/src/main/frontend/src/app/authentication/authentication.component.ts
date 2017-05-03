import { Component, OnInit } from '@angular/core';

import { User } from '../model/user';
import { UserService } from '../services/user.service';

@Component({
    moduleId: module.id,
    selector: 'authentication-cmp',
    templateUrl: 'authentication.component.html'
})

export class AuthenticationComponent implements OnInit {
    token: any;
    currentUser: User;
    users: User[] = [];

    constructor(private userService: UserService) {
        this.token = localStorage.getItem('token');
    }

    ngOnInit() {
        this.loadAllUsers();
    }

    deleteUser(id: number) {
        this.userService.delete(id).subscribe(() => { this.loadAllUsers() });
    }

    private loadAllUsers() {
        this.userService.getAll().subscribe(users => { this.users = users; });
    }
}