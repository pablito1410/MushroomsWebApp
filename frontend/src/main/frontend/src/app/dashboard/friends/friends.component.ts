import {Component, OnInit, Inject} from '@angular/core';
import {User} from "../../model/user";
import {MdDialog} from "@angular/material";
import {SearchFriendsComponent} from "./search-friends/search-friends.component";
import {FriendDetailsComponent} from "./friend-details/friend-details.component";
import {FriendService} from "../../services/friend.service";
import {DOCUMENT} from "@angular/platform-browser";

@Component({
    moduleId: module.id,
    selector: 'friends-cmp',
    templateUrl: 'friends.component.html'
})
export class FriendsComponent implements OnInit {
    friends: User[];
    selectedOption: string;

    constructor(
        public dialog: MdDialog,
        private friendService: FriendService,
        @Inject(DOCUMENT) private document) {
        this.friends = new Array<User>();
    }

    ngOnInit() {
        if (+document.location.port == 4200) {
            // for only frontend development purposes
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
        } else {
            this.friendService.getAll().subscribe(
                result => this.friends = result
            );
        }
    }

    openSearchFriendsDialog() {
        let dialogRef = this.dialog.open(SearchFriendsComponent, {
            hasBackdrop: true,
            height: '80%',
            width: '80%',
        });
        dialogRef.afterClosed().subscribe(result => {
            this.selectedOption = result;
        });
    }

    openFriendDetailsDialog(user) {
        let dialogRef = this.dialog.open(FriendDetailsComponent, {
            data: user,
            hasBackdrop: true,
            height: '80%',
            width: '80%',
        });
        dialogRef.afterClosed().subscribe(result => {
            this.selectedOption = result;
        });
    }
}