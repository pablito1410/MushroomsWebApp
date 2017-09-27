import { Component, OnInit, Inject } from "@angular/core";
import { MdDialogRef, MD_DIALOG_DATA, MdSnackBar } from "@angular/material";
import { User } from "../../../model/user";
import { DOCUMENT } from "@angular/platform-browser";
import { FriendService } from "../../../services/friend.service";
import { AcceptInvitationToFriendsCommand } from "../../../commands/accept-invitation-to-friends.command";
import { Tools } from "../../../tools/tools";

/**
 * User details dialog component
 */
@Component({
    moduleId: module.id,
    selector: 'user-details-cmp',
    templateUrl: 'user-details.component.html'
})
export class UserDetailsComponent implements OnInit {

    /** Static method get photo string to display assignment */
    getPhotoStringToDisplay = Tools.getPhotoStringToDisplay;
    /** Static method convert date tolocale string assignment */
    convertDateToLocaleString = Tools.convertDateToLocaleString;

    /**
     * Constructor of class
     * @param dialogRef         Material dialog to this component
     * @param data              Input data
     * @param document          Current document
     * @param snackBar          Material snack bar
     * @param friendService     Friends service
     */
    constructor(
        public dialogRef: MdDialogRef<UserDetailsComponent>,
        @Inject(MD_DIALOG_DATA) public data: any,
        @Inject(DOCUMENT) private document,
        public snackBar: MdSnackBar,
        private friendService: FriendService) { }

    /**
     * Initialization method
     */
    ngOnInit() {
        if (+document.location.port == 4200) {
            // for only frontend development purposes
        } else {
            // for future use
        }
    }

    /**
     * Accept button handle
     */
    accept() {
        this.friendService.accept(
            new AcceptInvitationToFriendsCommand(this.data.user.id)
        ).subscribe(
            data => {
                this.dialogRef.close('Accepted');
                this.snackBar.open('Invitation Accepted', '×', {
                    duration: 2000,
                });
            },
            error => {
                this.dialogRef.close('Error');
                this.snackBar.open('Error', '×', {
                    duration: 2000,
                });
            });
    }

    /**
     * Close button handle
     */
    close() {
        this.dialogRef.close('Close');
    }
}