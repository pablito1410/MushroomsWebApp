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

    create(trip: Trip) {
        return this.http.post('/api/trips/', trip).map((response: Response) => response.json());
    }

    update(trip: Trip) {
        return this.http.put('/api/trips/' + trip.id, trip).map((response: Response) => response.json());
    }

    delete(id: number) {
        return this.http.delete('/api/trips/' + id).map((response: Response) => response.json());
    }
}