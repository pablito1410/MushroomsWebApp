import {Component, OnInit} from '@angular/core';
import {User} from "../../model/user";
import {MdDialog} from "@angular/material";
import {SearchFriendsComponent} from "./search-friends/search-friends.component";
import {FriendDetailsComponent} from "./friend-details/friend-details.component";
import {FriendService} from "../../services/friend.service";

@Component({
    moduleId: module.id,
    selector: 'friends-cmp',
    templateUrl: 'friends.component.html'
})
export class FriendsComponent implements OnInit {
    model: any = {};
    users: any[];
    selectedOption: string;

    constructor(
        public dialog: MdDialog,
        private friendService: FriendService) {}

    ngOnInit(){
        this.friendService.getAll().subscribe(
            value => this.users = value
        );
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