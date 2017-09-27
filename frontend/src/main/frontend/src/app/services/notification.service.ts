import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';
import { Notification } from "./../model/notification";
import { AuthenticationService } from "./authentication.service";

/**
 * Notification service
 */
@Injectable()
export class NotificationService {

    /**
     * Constructor of class
     * @param http                      Http client
     * @param authenticationService     Authentication service
     */
    constructor(private http: Http, private authenticationService: AuthenticationService) { }

    /**
     * Get all notifications request
     * @returns     Response JSON
     */
    getAll(): any {
        return this.http.get('/api/notifications', this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    /**
     * Get notification by id request
     * @param id    Notification id
     * @returns     Response JSON
     */
    getById(id: number): any {
        return this.http.get('/api/notifications/' + id, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    /**
     * Create notification request
     * @param notification      Notification
     * @returns                 Response JSON
     */
    create(notification: Notification): any {
        return this.http.post('/api/notifications', notification, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    /**
     * Update notification request
     * @param notification      Notification
     * @returns                 Response JSON
     */
    update(notification: Notification): any {
        return this.http.put('/api/notifications/' + notification.id, notification, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    /**
     * Delete notification request
     * @param id      Notification id
     * @returns       Response
     */
    delete(id: number): any {
        return this.http.delete('/api/notifications/' + id, this.authenticationService.jwt()).map((response: Response) => response);
    }
}