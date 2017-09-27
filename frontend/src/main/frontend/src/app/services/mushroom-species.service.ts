import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';

import { MushroomSpecies } from '../model/mushroom-species';
import { AuthenticationService } from "./authentication.service";

/**
 * Mushroom species service
 */
@Injectable()
export class MushroomSpeciesService {

    /**
     * Constructor of class
     * @param http                      Http client
     * @param authenticationService     Authentication service
     */
    constructor(private http: Http, private authenticationService: AuthenticationService) { }

    /**
     * Get all mushroom species request
     * @returns     Response JSON
     */
    getAll(): any {
        return this.http.get('/api/mushroom-species', this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    /**
     * Get mushroom species by id request
     * @param id    Mushroom species id
     * @returns     Response JSON
     */
    getById(id: number): any {
        return this.http.get('/api/mushroom-species/' + id, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    /**
     * Create mushroom species request
     * @param species    Mushroom species
     * @returns          Response JSON
     */
    create(species: MushroomSpecies): any {
        return this.http.post('/api/mushroom-species', species, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    /**
     * Update mushroom species request
     * @param species    Mushroom species
     * @returns          Response JSON
     */
    update(species: MushroomSpecies): any {
        return this.http.put('/api/mushroom-species/' + species.id, species, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    /**
     * Delete mushroom species request
     * @param id    Mushroom species id
     * @returns          Response JSON
     */
    delete(id: number): any {
        return this.http.delete('/api/mushroom-species/' + id, this.authenticationService.jwt()).map((response: Response) => response.json());
    }
}