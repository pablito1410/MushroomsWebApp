import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';

import { Comment } from '../model/comment';

@Injectable()
export class CommentService {
    constructor(private http: Http) { }

    getAll() {
        return this.http.get('/api/comments').map((response: Response) => response.json());
    }

    getById(id: number) {
        return this.http.get('/api/comments/' + id).map((response: Response) => response.json());
    }

    create(comment: Comment) {
        return this.http.post('/api/comments', comment).map((response: Response) => response.json());
    }

    update(comment: Comment) {
        return this.http.put('/api/comments/' + comment.id, comment).map((response: Response) => response.json());
    }

    delete(id: number) {
        return this.http.delete('/api/comments/' + id).map((response: Response) => response.json());
    }
}