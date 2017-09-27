import { Component } from '@angular/core';
import { User } from '../model/user';
import { UserService } from '../services/user.service';

/**
 * Main component invokes router outlet
 */
@Component({
    moduleId: module.id,
    selector: 'authentication-cmp',
    templateUrl: 'authentication.component.html'
})
export class AuthenticationComponent {
}