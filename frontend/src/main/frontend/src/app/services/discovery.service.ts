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

    update(discovery: Discovery) {
        return this.http.put('/api/discoveries/' + discovery.id, discovery, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    delete(id: number) {
        return this.http.delete('/api/discoveries/' + id, this.authenticationService.jwt()).map((response: Response) => response.json());
    }
}