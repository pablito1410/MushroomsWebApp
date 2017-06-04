import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';

import { User } from '../model/user';
import {AuthenticationService} from "./authentication.service";
import {Router} from "@angular/router";

@Injectable()
export class UserService {
    constructor(
        private http: Http,
        private router: Router,
        private authenticationService: AuthenticationService) { }

    getAll() {
        return this.http.get('/api/users', this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    getById(id: number) {
        return this.http.get('/api/users/' + id, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    create(user: User) {
        return this.http.post('/api/users', user, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    update(user: User) {
        return this.http.put('/api/users/', user, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    updateImage(image: File) {
        let formData: FormData = new FormData();
        formData.append('files', image, image.name);
        return this.http.post('/api/users/image', formData, this.authenticationService.jwt()).subscribe(
            res => {
                let responseData = res.json();
                // resolve(this.responseData);
            },
            error => {
                this.router.navigate(['/user']);
                // reject(error);
            }
        );
    }


    delete(id: number) {
        return this.http.delete('/api/users/' + id, this.authenticationService.jwt()).map((response: Response) => response.json());
    }
}