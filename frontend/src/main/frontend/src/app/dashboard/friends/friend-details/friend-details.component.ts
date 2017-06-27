import {Component, OnInit, Inject} from "@angular/core";
import {MdDialogRef, MD_DIALOG_DATA} from "@angular/material";
import {User} from "../../../model/user";
import {DOCUMENT} from "@angular/platform-browser";

@Component({
    moduleId: module.id,
    selector: 'friend-details-cmp',
    templateUrl: 'friend-details.component.html'
})
export class FriendDetailsComponent implements OnInit {

    constructor(
        public dialogRef: MdDialogRef<FriendDetailsComponent>,
        @Inject(MD_DIALOG_DATA) public user: any,
        @Inject(DOCUMENT) private document) { }

    ngOnInit() {
        if (+document.location.port == 4200) {
            // for only frontend development purposes
        } else {
            // TODO
        }
    }

    convertDateToLocaleString(date: string) : string {
        return new Date(date).toLocaleString();
    }
}