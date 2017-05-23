import { Component } from "@angular/core";
import { MdDialogRef } from "@angular/material";

@Component({
    moduleId: module.id,
    selector: 'search-friends-cmp',
    templateUrl: 'search-friends.component.html'
})
export class SearchFriendsComponent {
    constructor(public dialogRef: MdDialogRef<SearchFriendsComponent>) { }
}