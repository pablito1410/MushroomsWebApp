import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';
import { User } from '../model/user';
import { AuthenticationService } from "./authentication.service";

/**
 * User service
 */
@Injectable()
export class UserService {

    /**
     * Constructor of class
     * @param http                      Http client
     * @param authenticationService     Authentication service
     */
    constructor(private http: Http, private authenticationService: AuthenticationService) { }

    /**
     * Get all users request
     * @returns     Response JSON
     */
    get(): any {
        return this.http.get('/api/users', this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    /**
     * Get user by id request
     * @param id    User id
     * @returns     Response JSON
     */
    getById(id: number): any {
        return this.http.get('/api/users/' + id, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    /**
     * Create user request
     * @param user      User
     * @returns         Response JSON
     */
    create(user: User): any {
        return this.http.post('/api/users', user, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    /**
     * Update user request
     * @param user      User
     * @returns         Response JSON
     */
    update(user: User): any {
        return this.http.put('/api/users/', user, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    /**
     * Delete user request
     * @param id    User id
     * @returns     Response JSON
     */
    delete(id: number): any {
        return this.http.delete('/api/users/' + id, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    /**
     * Update user image request
     * @param image     File with image
     * @returns         Response
     */
    updateImage(image: File): any {
        let formData: FormData = new FormData();
        formData.append('files', image, image.name);
        return this.http.post('/api/users/image', formData, this.authenticationService.jwt()).map((response: Response) => response);
    }

    /**
     * Search users request
     * @param term      Term to search
     * @returns         Response
     */
    search(term: string): any {
        return this.http.get('/api/users/search?value=' + term, this.authenticationService.jwt()).map((response: Response) => response.json());
    }
}