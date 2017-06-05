import {Component, OnInit, Inject} from "@angular/core";
import {MdDialogRef, MD_DIALOG_DATA, MdDialog} from "@angular/material";
import {FriendDetailsComponent} from "../friend-details/friend-details.component";
import {Subject} from "rxjs";
import {UserService} from "../../../services/user.service";

@Component({
    moduleId: module.id,
    selector: 'search-friends-cmp',
    templateUrl: 'search-friends.component.html'
})
export class SearchFriendsComponent implements OnInit {
    selectedOption: string;
    users: any[];
    searchTerm$ = new Subject<string>();

    constructor(
        public dialog: MdDialog,
        public dialogRef: MdDialogRef<SearchFriendsComponent>,
        private userService: UserService) { }

    ngOnInit() {
    }

    openUserDetailsDialog() {
        let dialogRef = this.dialog.open(FriendDetailsComponent, {
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