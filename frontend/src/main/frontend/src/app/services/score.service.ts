import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';

import { Score } from '../model/score';
import {AuthenticationService} from "./authentication.service";

@Injectable()
export class ScoreService {
    constructor(private http: Http, private authenticationService: AuthenticationService) { }

    getAll() {
        return this.http.get('/api/scores', this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    getById(id: number) {
        return this.http.get('/api/scores/' + id, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    create(score: Score) {
        return this.http.post('/api/scores', score, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    update(score: Score) {
        return this.http.put('/api/scores/' + score.id, score, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    delete(id: number) {
        return this.http.delete('/api/scores/' + id, this.authenticationService.jwt()).map((response: Response) => response.json());
    }
}