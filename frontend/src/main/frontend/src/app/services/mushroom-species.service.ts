import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';

import { MushroomSpecies } from '../model/mushroom-species';
import {AuthenticationService} from "./authentication.service";

@Injectable()
export class MushroomSpeciesService {
    constructor(private http: Http, private authenticationService: AuthenticationService) { }

    getAll() {
        return this.http.get('/api/mushrooms-species/all', this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    getById(id: number) {
        return this.http.get('/api/mushrooms-species/' + id, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    create(species: MushroomSpecies) {
        return this.http.post('/api/mushrooms-species', species, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    update(species: MushroomSpecies) {
        return this.http.put('/api/mushrooms-species/' + species.id, species, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    delete(id: number) {
        return this.http.delete('/api/mushrooms-species/' + id, this.authenticationService.jwt()).map((response: Response) => response.json());
    }
}