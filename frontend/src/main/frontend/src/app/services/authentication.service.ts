import { Injectable } from '@angular/core';
import { Http, Headers, Response, URLSearchParams, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map'

/**
 * Authentication service
 */
@Injectable()
export class AuthenticationService {

    /**
     * Constructor of class
     * @param http      Http client
     */
    constructor(private http: Http) { }

    /**
     * Login request
     * @param email         Email
     * @param password      Password
     */
    login(email: string, password: string): any {
        let headers = new Headers();
        headers.append('Content-Type', 'application/x-www-form-urlencoded');
        let urlSearchParams = new URLSearchParams();
        urlSearchParams.append('email', email);
        urlSearchParams.append('password', password);
        let body = urlSearchParams.toString();
        let options = new RequestOptions({ headers: headers });
        return this.http.post('/login', body, options)
            .map((response: Response) => {
                // login successful if there's a jwt token in the response
                let token = response.headers.get('Authorization').replace('Bearer ', '');
                if (token) {
                    // store jwt token in local storage to keep user logged in between page refreshes
                    localStorage.setItem('token', token);
                }
                let user = response.json();
                if (user) {
                    // store user details
                    localStorage.setItem('currentUser', JSON.stringify(user));
                }
            });
    }

    /**
     * Logout request
     */
    logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('token');
        localStorage.removeItem('currentUser');
    }

    /**
     * Adds JSON web token to request header
     * @returns Request options with filled header
     */
    jwt() {
        // create authorization header with jwt token
        let token = localStorage.getItem('token');
        if (token) {
            let headers = new Headers({ 'Authorization': 'Bearer ' + token });
            return new RequestOptions({ headers: headers });
        }
    }
}