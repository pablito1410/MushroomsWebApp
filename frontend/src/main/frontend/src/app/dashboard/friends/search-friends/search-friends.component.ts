import {Component, OnInit, Inject} from "@angular/core";
import {MdDialogRef, MD_DIALOG_DATA} from "@angular/material";

@Component({
    moduleId: module.id,
    selector: 'search-friends-cmp',
    templateUrl: 'search-friends.component.html'
})
export class SearchFriendsComponent implements OnInit {
    constructor(
        public dialogRef: MdDialogRef<SearchFriendsComponent>,
        @Inject(MD_DIALOG_DATA) public users: any) { }
    ngOnInit() {
    }
}