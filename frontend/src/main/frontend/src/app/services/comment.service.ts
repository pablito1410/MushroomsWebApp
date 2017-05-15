import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';

import { Comment } from '../model/comment';
import {AuthenticationService} from "./authentication.service";

@Injectable()
export class CommentService {
    constructor(private http: Http, private authenticationService: AuthenticationService) { }

    getAll() {
        return this.http.get('/api/comments', this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    getById(id: number) {
        return this.http.get('/api/comments/' + id, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    create(comment: Comment) {
        return this.http.post('/api/comments', comment, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    update(comment: Comment) {
        return this.http.put('/api/comments/' + comment.id, comment, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    delete(id: number) {
        return this.http.delete('/api/comments/' + id).map((response: Response) => response.json());
    }
}