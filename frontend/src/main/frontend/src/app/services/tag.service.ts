import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';

import { Tag } from '../model/tag';
import {AuthenticationService} from "./authentication.service";

@Injectable()
export class TagService {
    constructor(private http: Http, private authenticationService: AuthenticationService) { }

    getAll() {
        return this.http.get('/api/tags', this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    getById(id: number) {
        return this.http.get('/api/tags/' + id, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    create(tag: Tag) {
        return this.http.post('/api/tags', tag, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    update(tag: Tag) {
        return this.http.put('/api/tags/' + tag.id, tag, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    delete(id: number) {
        return this.http.delete('/api/tags/' + id, this.authenticationService.jwt()).map((response: Response) => response.json());
    }
}