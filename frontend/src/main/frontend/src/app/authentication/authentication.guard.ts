import { Injectable, Inject } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { DOCUMENT } from '@angular/platform-browser';

/**
 * Authentication guard redirecting to login page when user isn't logged
 */
@Injectable()
export class AuthenticationGuard implements CanActivate {

    /**
     * Constructor of class
     * @param router    Router
     * @param document  Current document
     */
    constructor(
        private router: Router,
        @Inject(DOCUMENT) private document) { }

    /**
     * Check whether the token is stored in the session
     * @param route Activated route snapshot
     * @param state Routers tate snapshot
     * @returns     Value true if token stored
     */
    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
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