import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';

import { CreateCommentCommand } from '../commands/create-comment.command';
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

    create(createComentCommand: CreateCommentCommand) {
        return this.http.post('/api/comments', createComentCommand, this.authenticationService.jwt()).map((response: Response) => response.json());
    }
}