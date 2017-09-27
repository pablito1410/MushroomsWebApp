import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';
import { Trip } from '../model/trip';
import { AuthenticationService } from "./authentication.service";
import { InviteToTripCommand } from "../commands/invite-to-trip.command";
import { JoinTripCommand } from "../commands/join-trip.command";

/**
 * Trip service
 */
@Injectable()
export class TripService {

    /**
     * Constructor of class
     * @param http                      Http client
     * @param authenticationService     Authentication service
     */
    constructor(private http: Http, private authenticationService: AuthenticationService) { }

    /**
     * Get all trips request
     * @returns     Response JSON with trips array
     */
    getAll(): any {
        return this.http.get('/api/trips', this.authenticationService.jwt()).map((response: Response) => <Trip[]>response.json());
    }

    /**
     * Get trip by id request
     * @param id    Trip id
     * @returns     Response JSON
     */
    getById(id: number): any {
        return this.http.get('/api/trips/' + id, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    /**
     * Create trip request
     * @param trip      Trip
     * @returns         Response JSON
     */
    create(trip: Trip): any {
        return this.http.post('/api/trips', trip, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    /**
     * Update trip request
     * @param trip      Trip
     * @returns         Response JSON
     */
    update(trip: Trip): any {
        return this.http.put('/api/trips/' + trip.id, trip, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    /**
     * Delete trip request
     * @param id    Trip id
     * @returns     Response JSON
     */
    delete(id: number): any {
        return this.http.delete('/api/trips/' + id, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    /**
     * Invite to trip request
     * @param inviteToTripCommand       Invite to trip command
     * @returns                         Response
     */
    invite(inviteToTripCommand: InviteToTripCommand): any {
        return this.http.post('/api/trips/invite', inviteToTripCommand, this.authenticationService.jwt()).map((response: Response) => response);
    }

    /**
     * Get all trip participants request
     * @param id    Trip id
     * @returns     Response JSON
     */
    getParticipants(id: number): any {
        return this.http.get('/api/trips/participants/' + id, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    /**
     * Get all trip requests request
     * @param id    Trip id
     * @returns     Response JSON
     */
    getTripRequests(id: number): any {
        return this.http.get('/api/trips/invited/' + id, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    /**
     * Join to trip request
     * @param joinTripCommand       Join trip command
     * @returns                     Response
     */
    joinTrip(joinTripCommand: JoinTripCommand): any {
        return this.http.post('/api/trips/join', joinTripCommand, this.authenticationService.jwt()).map((response: Response) => response);
    }
}