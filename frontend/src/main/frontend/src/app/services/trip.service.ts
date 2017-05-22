import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';

import { Trip } from '../model/trip';
import {AuthenticationService} from "./authentication.service";

@Injectable()
export class TripService {
    constructor(private http: Http, private authenticationService: AuthenticationService) { }

    getAll() {
        return this.http.get('/api/trips', this.authenticationService.jwt()).map((response: Response) => <Trip[]>response.json());
    }

    getById(id: number) {
        return this.http.get('/api/trips/' + id, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    create(trip: Trip) {
        return this.http.post('/api/trips', trip, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    update(trip: Trip) {
        return this.http.put('/api/trips/' + trip.id, trip, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    delete(id: number) {
        return this.http.delete('/api/trips/' + id, this.authenticationService.jwt()).map((response: Response) => response.json());
    }
}