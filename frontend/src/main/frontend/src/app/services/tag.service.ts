import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';
import { Tag } from '../model/tag';
import { AuthenticationService } from "./authentication.service";

/**
 * Tag service
 */
@Injectable()
export class TagService {

    /**
     * Constructor of class
     * @param http                      Http client
     * @param authenticationService     Authentication service
     */
    constructor(private http: Http, private authenticationService: AuthenticationService) { }

    /**
     * Get all tags request
     * @returns     Response JSON
     */
    getAll(): any {
        return this.http.get('/api/tags', this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    /**
     * Get tag by id request
     * @param id    Tag id
     * @returns     Response JSON
     */
    getById(id: number): any {
        return this.http.get('/api/tags/' + id, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    /**
     * Create tag request
     * @param tag       Tag
     * @returns         Response
     */
    create(tag: Tag): any {
        return this.http.post('/api/tags', tag, this.authenticationService.jwt()).map((response: Response) => response);
    }

    /**
     * Update tag request
     * @param tag       Tag
     * @returns         Response JSON
     */
    update(tag: Tag): any {
        return this.http.put('/api/tags/' + tag.id, tag, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    /**
     * Delete tag request
     * @param id      Tag id
     * @returns       Response JSON
     */
    delete(id: number): any {
        return this.http.delete('/api/tags/' + id, this.authenticationService.jwt()).map((response: Response) => response.json());
    }
}