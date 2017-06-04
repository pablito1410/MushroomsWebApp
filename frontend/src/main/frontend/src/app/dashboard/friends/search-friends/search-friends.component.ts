import {Component, OnInit, Inject} from "@angular/core";
import {MdDialogRef, MD_DIALOG_DATA, MdDialog} from "@angular/material";
import {FriendDetailsComponent} from "../friend-details/friend-details.component";

@Component({
    moduleId: module.id,
    selector: 'search-friends-cmp',
    templateUrl: 'search-friends.component.html'
})
export class SearchFriendsComponent implements OnInit {
    selectedOption: string;

    constructor(
        public dialog: MdDialog,
        public dialogRef: MdDialogRef<SearchFriendsComponent>,
        @Inject(MD_DIALOG_DATA) public users: any) { }

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
}