import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';
import { Discovery } from '../model/discovery';
import { AuthenticationService } from "./authentication.service";

/**
 * Discovery service
 */
@Injectable()
export class DiscoveryService {

    /**
     * Constructor of class
     * @param http                      Http client
     * @param authenticationService     Authentication service
     */
    constructor(private http: Http, private authenticationService: AuthenticationService) { }

    /**
     * Get all discoveries request
     * @returns     Response JSON
     */
    getAll(): any {
        return this.http.get('/api/discoveries', this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    /**
     * Get discovery by id request
     * @param id    Discovery id
     * @returns     Response JSON
     */
    getById(id: number): any {
        return this.http.get('/api/discoveries/' + id, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    /**
     * Create discovery request
     * @param discovery       Discovery
     * @returns               Response JSON
     */
    create(discovery: Discovery): any {
        return this.http.post('/api/discoveries', discovery, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    /**
     * Search discoveries request
     * @param value         Value of term we are looking for
     * @param my            My flag indicator
     * @param friends       Friends flag indicator
     * @param isPublic      Public flag indicator
     * @returns             Response JSON
     */
    search(value: string, my: boolean, friends: boolean, isPublic: boolean): any {
        return this.http.get(
            '/api/discoveries/search?value=' + value
            + '&my=' + my
            + '&friends=' + friends
            + '&public=' + isPublic,
            this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    /**
     * Get tags for discovery request
     * @param id    Discovery id
     * @returns     Response JSON
     */
    tags(id: number): any {
        return this.http.get('/api/discoveries/tags/' + id, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    /**
     * Get comments for discovery request
     * @param id    Discovery id
     * @returns     Response JSON
     */
    comments(id: number): any {
        return this.http.get('/api/discoveries/comments/' + id, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    /**
     * Get score for discovery request
     * @param id    Discovery id
     * @returns     Response JSON
     */
    score(id: number): any {
        return this.http.get('/api/discoveries/score/' + id, this.authenticationService.jwt()).map((response: Response) => response.json());
    }
}