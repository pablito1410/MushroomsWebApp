import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';
import { CreateCommentCommand } from '../commands/create-comment.command';
import { AuthenticationService } from "./authentication.service";

/**
 * Comment service
 */
@Injectable()
export class CommentService {

    /**
     * Constructor of class
     * @param http                      Http client
     * @param authenticationService     Authentication service
     */
    constructor(private http: Http, private authenticationService: AuthenticationService) { }

    /**
     * Get all comments request
     * @returns     Response JSON
     */
    getAll() {
        return this.http.get('/api/comments', this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    /**
     * Get comment by id request
     * @param id    Comment id
     * @returns     Response JSON
     */
    getById(id: number) {
        return this.http.get('/api/comments/' + id, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    /**
     * Create comment request
     * @param createComentCommand       Create coment command
     * @returns                         Response JSON
     */
    create(createComentCommand: CreateCommentCommand) {
        return this.http.post('/api/comments', createComentCommand, this.authenticationService.jwt()).map((response: Response) => response.json());
    }
}