import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';

import { Trip } from '../model/trip';

@Injectable()
export class TripService {
    constructor(private http: Http) { }

    getAll() {
        return this.http.get('/api/trips').map((response: Response) => response.json());
    }

    getById(id: number) {
        return this.http.get('/api/trips/' + id).map((response: Response) => response.json());
    }

    create(user: Trip) {
        return this.http.post('/api/trips/create', user).map((response: Response) => response.json());
    }

    update(user: Trip) {
        return this.http.put('/api/trips/' + user.id, user).map((response: Response) => response.json());
    }

    delete(id: number) {
        return this.http.delete('/api/trips/' + id).map((response: Response) => response.json());
    }
}