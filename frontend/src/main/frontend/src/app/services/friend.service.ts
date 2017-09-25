import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { AuthenticationService } from "./authentication.service";
import { AcceptInvitationToFriendsCommand } from "../commands/accept-invitation-to-friends.command"
import { AddFriendCommand } from "../commands/add-friend.command"
import {User} from "../model/user";

@Injectable()
export class FriendService {
    constructor(private http: Http, private authenticationService: AuthenticationService) { }

    getAll() {
        return this.http.get('/api/friends', this.authenticationService.jwt()).map((response: Response) => <User[]>response.json());
    }

    add(addFriendCommand: AddFriendCommand) {
        return this.http.post('/api/friends', addFriendCommand, this.authenticationService.jwt()).map((response : Response) => response);
    }

    accept(acceptInvitationToFriendsCommand: AcceptInvitationToFriendsCommand) {
        return this.http.put('/api/friends', acceptInvitationToFriendsCommand, this.authenticationService.jwt()).map((response : Response) => response.json());
    }

    delete(id: number) {
        return this.http.delete('/api/friends/' + id, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    search(term) {
        return this.http.get('/api/friends/search?value=' + term, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    getAllInvited() {
        return this.http.get('/api/friends/invitations', this.authenticationService.jwt()).map((response: Response) => <User[]>response.json());
    }

    getAllRequested() {
        return this.http.get('/api/friends/requests', this.authenticationService.jwt()).map((response: Response) => <User[]>response.json());
    }
}