import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { AuthenticationService } from "./authentication.service";
import { AcceptInvitationToFriendsCommand } from "../commands/accept-invitation-to-friends.command"
import { AddFriendCommand } from "../commands/add-friend.command"
import { User } from "../model/user";

/**
 * Friend service
 */
@Injectable()
export class FriendService {

    /**
     * Constructor of class
     * @param http                      Http client
     * @param authenticationService     Authentication service
     */
    constructor(private http: Http, private authenticationService: AuthenticationService) { }

    /**
     * Get all friends request
     * @returns     Response JSON with users array
     */
    getAll(): any {
        return this.http.get('/api/friends', this.authenticationService.jwt()).map((response: Response) => <User[]>response.json());
    }

    /**
     * Add friend request
     * @param addFriendCommand      Add friend command
     * @returns                     Response
     */
    add(addFriendCommand: AddFriendCommand): any {
        return this.http.post('/api/friends', addFriendCommand, this.authenticationService.jwt()).map((response : Response) => response);
    }

    /**
     * Accept invitation to friends request
     * @param acceptInvitationToFriendsCommand      Accept invitation to friends command
     * @returns                                     Response
     */
    accept(acceptInvitationToFriendsCommand: AcceptInvitationToFriendsCommand): any {
        return this.http.put('/api/friends', acceptInvitationToFriendsCommand, this.authenticationService.jwt()).map((response : Response) => response);
    }

    /**
     * Delete friends request
     * @param id    Friend id
     * @returns     Response JSON
     */
    delete(id: number): any {
        return this.http.delete('/api/friends/' + id, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    /**
     * Search friends request
     * @param term      Term to search
     * @returns         Response JSON
     */
    search(term: string): any {
        return this.http.get('/api/friends/search?value=' + term, this.authenticationService.jwt()).map((response: Response) => response.json());
    }

    /**
     * Get all invited friends request
     * @returns         Response JSON with users array
     */
    getAllInvited(): any {
        return this.http.get('/api/friends/invitations', this.authenticationService.jwt()).map((response: Response) => <User[]>response.json());
    }

    /**
     * Get all requested friends request
     * @returns         Response JSON with users array
     */
    getAllRequested(): any {
        return this.http.get('/api/friends/requests', this.authenticationService.jwt()).map((response: Response) => <User[]>response.json());
    }
}