import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';

import { Discovery } from '../model/discovery';
import {AuthenticationService} from "./authentication.service";

@Injectable()
export class DiscoveryService {
    constructor(private http: Http, private authenticationService: AuthenticationService) { }

    getAll() {
        return this.http.get('/api/discoveries', this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    getById(id: number) {
        return this.http.get('/api/discoveries/' + id, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    create(discovery: Discovery) {
        return this.http.post('/api/discoveries', discovery, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    search(value: string, my: boolean, friends: boolean, isPublic: boolean) {
        return this.http.get(
            '/api/discoveries/search?value=' + value
            + '&my=' + my
            + '&friends=' + friends
            + '&public=' + isPublic,
            this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    tags(id: number) {
        return this.http.get('/api/discoveries/tags/' + id, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    comments(id: number) {
        return this.http.get('/api/discoveries/comments/' + id, this.authenticationService.jwt()).map((response: Response) => response.json());
    }
}