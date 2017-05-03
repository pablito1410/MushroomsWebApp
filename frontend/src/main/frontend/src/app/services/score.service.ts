import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';

import { Score } from '../model/score';

@Injectable()
export class ScoreService {
    constructor(private http: Http) { }

    getAll() {
        return this.http.get('/api/scores').map((response: Response) => response.json());
    }

    getById(id: number) {
        return this.http.get('/api/scores/' + id).map((response: Response) => response.json());
    }

    create(score: Score) {
        return this.http.post('/api/scores', score).map((response: Response) => response.json());
    }

    update(score: Score) {
        return this.http.put('/api/scores/' + score.id, score).map((response: Response) => response.json());
    }

    delete(id: number) {
        return this.http.delete('/api/scores/' + id).map((response: Response) => response.json());
    }
}