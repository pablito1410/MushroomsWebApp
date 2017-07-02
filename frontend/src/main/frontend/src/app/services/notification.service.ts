import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';
import {Notification} from "./../model/notification";
import {AuthenticationService} from "./authentication.service";

@Injectable()
export class NotificationService {
    constructor(private http: Http, private authenticationService: AuthenticationService) { }

    getAll() {
        return this.http.get('/api/notifications', this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    getById(id: number) {
        return this.http.get('/api/notifications/' + id, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    create(notification: Notification) {
        return this.http.post('/api/notifications', notification, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    update(notification: Notification) {
        return this.http.put('/api/notifications/' + notification.id, notification, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    delete(id: number) {
        return this.http.delete('/api/notifications/' + id, this.authenticationService.jwt()).map((response: Response) => response.json());
    }
}