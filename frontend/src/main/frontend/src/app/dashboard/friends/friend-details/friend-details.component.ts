import {Component, OnInit, Inject} from "@angular/core";
import {MdDialogRef, MD_DIALOG_DATA} from "@angular/material";

@Component({
    moduleId: module.id,
    selector: 'friend-details-cmp',
    templateUrl: 'friend-details.component.html'
})
export class FriendDetailsComponent implements OnInit {
    constructor(public dialogRef: MdDialogRef<FriendDetailsComponent>) { }
    ngOnInit() {
    }
}