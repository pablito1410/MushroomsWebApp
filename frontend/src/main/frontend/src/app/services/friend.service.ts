/**
 * Created by MiKu on 22.05.2017.
 */

import { Injectable } from '@angular/core';
import {URLSearchParams, Http, Headers, RequestOptions, Response } from '@angular/http';

import { User } from '../model/user';
import {AuthenticationService} from "./authentication.service";
import {Friendship} from "../model/friendship";

@Injectable()
export class FriendService {
    constructor(private http: Http, private authenticationService: AuthenticationService) { }

    getAllByUserId(id: number) {
        return this.http.get('/api/friends/' + id, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    // getById(id: number) {
    //     return this.http.get('/api/friends/' + id, this.authenticationService.jwt()).map((response: Response) => response.json());
    // }

    add(friendship: Friendship){
        return this.http.post('/api/friends', friendship, this.authenticationService.jwt()).map((response : Response) => response.json());
    }

    delete(friendship: Friendship) {
        let urlSearchParams = new URLSearchParams();
        urlSearchParams.append('user',friendship.userId.toString());
        urlSearchParams.append('friend',friendship.friendId.toString());
        return this.http.delete('/api/friends/' + urlSearchParams.toString(), this.authenticationService.jwt()).map((response: Response) => response.json());
    }
}