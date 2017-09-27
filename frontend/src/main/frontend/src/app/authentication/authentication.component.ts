import { Component } from '@angular/core';
import { User } from '../model/user';
import { UserService } from '../services/user.service';

/**
 * Authentication component invokes router outlet for unlogged user
 */
@Component({
    moduleId: module.id,
    selector: 'authentication-cmp',
    templateUrl: 'authentication.component.html'
})
export class AuthenticationComponent {
}