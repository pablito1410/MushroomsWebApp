import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';

import { User } from '../model/user';
import {AuthenticationService} from "./authentication.service";
import {Router} from "@angular/router";
import {Observable} from "rxjs";

@Injectable()
export class UserService {
    constructor(
        private http: Http,
        private router: Router,
        private authenticationService: AuthenticationService) { }

    getAll() {
        return this.http.get('http://localhost:8080/api/users', this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    getById(id: number) {
        return this.http.get('http://localhost:8080/api/users/' + id, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    create(user: User) {
        return this.http.post('http://localhost:8080/api/users', user, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    update(user: User) {
        return this.http.put('http://localhost:8080/api/users/', user, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    delete(id: number) {
        return this.http.delete('/api/users/' + id, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    updateImage(image: File) {
        let formData: FormData = new FormData();
        formData.append('files', image, image.name);
        return this.http.post('/api/users/image', formData, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    search(term) {
        return this.http.get('/api/users/search?value=' + term, this.authenticationService.jwt()).map((response: Response) => response.json());
    }
}