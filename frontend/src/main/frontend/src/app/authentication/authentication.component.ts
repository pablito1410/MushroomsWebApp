import { Component, OnInit } from '@angular/core';

import { User } from '../model/user';
import { UserService } from '../services/user.service';

@Component({
    moduleId: module.id,
    selector: 'authentication-cmp',
    templateUrl: 'authentication.component.html'
})

export class AuthenticationComponent implements OnInit {

    constructor() {
    }

    ngOnInit() {

    }
}