import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';

import { Discovery } from '../model/discovery';

@Injectable()
export class DiscoveryService {
    constructor(private http: Http) { }

    getAll() {
        return this.http.get('/api/discoveries').map((response: Response) => response.json());
    }

    getById(id: number) {
        return this.http.get('/api/discoveries/' + id).map((response: Response) => response.json());
    }

    create(discovery: Discovery) {
        return this.http.post('/api/discoveries', discovery).map((response: Response) => response.json());
    }

    update(discovery: Discovery) {
        return this.http.put('/api/discoveries/' + discovery.id, discovery).map((response: Response) => response.json());
    }

    delete(id: number) {
        return this.http.delete('/api/discoveries/' + id).map((response: Response) => response.json());
    }
}