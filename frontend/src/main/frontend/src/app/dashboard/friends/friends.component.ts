import { Component, OnInit, Inject } from '@angular/core';
import { User } from "../../model/user";
import { MdDialog } from "@angular/material";
import { SearchFriendsComponent } from "./search-friends/search-friends.component";
import { UserDetailsComponent } from "../user/user-details/user-details.component";
import { FriendService } from "../../services/friend.service";
import { DOCUMENT } from "@angular/platform-browser";
import { Tools } from "../../tools/tools";

/**
 * Friends page component
 */
@Component({
    moduleId: module.id,
    selector: 'friends-cmp',
    templateUrl: 'friends.component.html'
})
export class FriendsComponent implements OnInit {
    
    /** Array with friend */
    friends: User[];
    /** Array with invited friend */
    invitedFriends: User[];
    /** Array with requested friend */
    requestedFriends: User[];
    /** Option selected in dialog */
    selectedOption: string;
    
    /** Static method get photo string to display assignment */
    getPhotoStringToDisplay = Tools.getPhotoStringToDisplay;

    /**
     * Constructor of class
     * @param dialog            Material dialog
     * @param friendService     Friend service
     * @param document          Current document
     */
    constructor(
        public dialog: MdDialog,
        private friendService: FriendService,
        @Inject(DOCUMENT) private document) {
        this.friends = new Array<User>();
        this.invitedFriends = new Array<User>();
        this.requestedFriends = new Array<User>();
    }

    /**
     * Initialization method
     */
    ngOnInit() {
        if (+document.location.port == 4200) {
            // for only frontend development purposes
            this. initFakeData();
        } else {
            this.friendService.getAll().subscribe(
                result => this.friends = result
            );
            this.friendService.getAllInvited().subscribe(
                result => this.invitedFriends = result
            );
            this.friendService.getAllRequested().subscribe(
                result => this.requestedFriends = result
            );
        }
    }

    /**
     * Initialize the component with fake data
     */
     private initFakeData() {
        this.friends = [
            {
                id: 1,
                username: 'roman33',
                email: 'romy@mail.com',
                firstName: 'Roman',
                lastName: 'Nowak',
                birthDate: '21-07-1989',
                gender: 'MALE',
                level: 'BEGINNER',
                country: 'Polska',
                city: 'Gliwice',
                photo: null,
                role: 'MUSHROOMER'
            },
            {
                id: 2,
                username: 'thomas22',
                email: 'tomy22@mail.com',
                firstName: 'Tom',
                lastName: 'Goreing',
                birthDate: '16-11-1991',
                gender: 'MALE',
                level: 'BEGINNER',
                country: 'Germany',
                city: 'Berlin',
                photo: null,
                role: 'MUSHROOMER'
            }
        ];
    }

    /**
     * Checks if there are some invited friends
     * @returns Value true if they are
     */
    areInvitedFriends(): boolean {
        return this.invitedFriends.length > 0;
    }

    /**
     * Checks if there are some friends
     * @returns Value true if they are
     */
    areFriends(): boolean {
        return this.friends.length > 0;
    }

    /**
     * Checks if there are some requested friends
     * @returns Value true if they are
     */
    areRequestedFriends(): boolean {
        return this.requestedFriends.length > 0;
    }

    /**
     * Opens search friends dialog
     */
    openSearchFriendsDialog() {
        let dialogRef = this.dialog.open(SearchFriendsComponent, {
            hasBackdrop: true,
            height: '80%',
            width: '80%',
        });
        dialogRef.afterClosed().subscribe(result => {
            this.ngOnInit();
            this.selectedOption = result;
        });
    }

    /**
     * Opens friend detail dialog
     */
    openFriendDetailsDialog(user, status) {
        let dialogRef = this.dialog.open(UserDetailsComponent, {
            data: { 
                user: user,
                status: status
            },
            hasBackdrop: true,
            height: '80%',
            width: '80%',
        });
        dialogRef.afterClosed().subscribe(result => {
            this.ngOnInit();
            this.selectedOption = result;
        });
    }
}