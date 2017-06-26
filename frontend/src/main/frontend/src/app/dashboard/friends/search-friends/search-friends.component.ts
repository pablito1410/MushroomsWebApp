import {Component, OnInit, Inject} from "@angular/core";
import {MdDialogRef, MD_DIALOG_DATA, MdDialog} from "@angular/material";
import {FriendDetailsComponent} from "../friend-details/friend-details.component";
import {Subject} from "rxjs";
import {UserService} from "../../../services/user.service";
import {DOCUMENT} from "@angular/platform-browser";
import {User} from "../../../model/user";

@Component({
    moduleId: module.id,
    selector: 'search-friends-cmp',
    templateUrl: 'search-friends.component.html'
})
export class SearchFriendsComponent implements OnInit {
    selectedOption: string;
    users: User[];

    constructor(
        public dialog: MdDialog,
        public dialogRef: MdDialogRef<SearchFriendsComponent>,
        @Inject(DOCUMENT) private document,
        private userService: UserService) { }

    ngOnInit() {
        if (+document.location.port == 4200) {
            // for only frontend development purposes
        } else {
            // TODO
        }
    }

    openUserDetailsDialog(user) {
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

    search(term: string) {
        this.userService.search(term)
            .subscribe(results => {
                this.users = results;
            });
    }

}