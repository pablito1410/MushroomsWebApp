import { Injectable } from '@angular/core';
import {Http, Headers, Response, URLSearchParams, RequestOptions} from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map'

@Injectable()
export class AuthenticationService {
    constructor(private http: Http) { }

    login(email: string, password: string) {
         let headers = new Headers ();
         headers.append('Content-Type', 'application/x-www-form-urlencoded');
        let urlSearchParams = new URLSearchParams();
        urlSearchParams.append('email', email);
        urlSearchParams.append('password', password);
        let body = urlSearchParams.toString();
        let options = new RequestOptions({ headers: headers });
        return this.http.post('/login', body, options)
            .map((response: Response) => {
                // login successful if there's a jwt token in the response
                let user = response.json();
                // if (user) { // && user.token
                //     // store user details and jwt token in local storage to keep user logged in between page refreshes
                //     localStorage.setItem('currentUser', JSON.stringify(user));
                // }
            });
    }

    logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('currentUser');
    }
}