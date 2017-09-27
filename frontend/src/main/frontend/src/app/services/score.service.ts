import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';
import { AddScoreCommand } from "../commands/add-score.command";
import { Score } from '../model/score';
import { AuthenticationService } from "./authentication.service";

/**
 * Score service
 */
@Injectable()
export class ScoreService {

    /**
     * Constructor of class
     * @param http                      Http client
     * @param authenticationService     Authentication service
     */
    constructor(private http: Http, private authenticationService: AuthenticationService) { }

    /**
     * Get all scores request
     * @returns     Response JSON
     */
    getAll(): any {
        return this.http.get('/api/scores', this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    /**
     * Get score by id request
     * @param id    Score id
     * @returns     Response JSON
     */
    getById(id: number): any {
        return this.http.get('/api/scores/' + id, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    /**
     * Add score request
     * @param addScoreCommand       Add score command
     * @returns                     Response
     */
    add(addScoreCommand: AddScoreCommand): any {
        return this.http.post('/api/scores', addScoreCommand, this.authenticationService.jwt()).map((response: Response) => response);
    }

    /**
     * Update score request
     * @param score      Score
     * @returns          Response JSON
     */
    update(score: Score): any {
        return this.http.put('/api/scores/' + score.id, score, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    /**
     * Delete score request
     * @param id      Score id
     * @returns       Response JSON
     */
    delete(id: number): any {
        return this.http.delete('/api/scores/' + id, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    /**
     * Get scores averge for discovery request
     * @param id      Discovery id
     * @returns       Response
     */
    scoresAverge(id: number): any {
        return this.http.get('/api/scores/discovery/' + id, this.authenticationService.jwt()).map((response: Response) => response);
    }
}