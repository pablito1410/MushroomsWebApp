import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { AuthenticationService } from "./authentication.service";
import {User} from "../model/user";

@Injectable()
export class FriendService {
    constructor(private http: Http, private authenticationService: AuthenticationService) { }

    getAll() {
        return this.http.get('/api/friends', this.authenticationService.jwt()).map((response: Response) => <User[]>response.json());
    }

    create(id: number) {
        return this.http.post('/api/friends', id, this.authenticationService.jwt()).map((response : Response) => response.json());
    }

    delete(id: number) {
        return this.http.delete('/api/friends/' + id, this.authenticationService.jwt()).map((response: Response) => response.json());
    }
}