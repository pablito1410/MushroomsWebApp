import {Injectable, Inject} from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { DOCUMENT } from '@angular/platform-browser';

@Injectable()
export class AuthenticationGuard implements CanActivate {

    constructor(
        private router: Router,
        @Inject(DOCUMENT) private document) { }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        if (+document.location.port == 4200) {
            // for only frontend development purposes
            return true;
        }
        if (localStorage.getItem('token')) {
            // logged in so return true
            return true;
        }
        // not logged in so redirect to login page with the return url
        this.router.navigate(['/login']);
        return false;
    }
}