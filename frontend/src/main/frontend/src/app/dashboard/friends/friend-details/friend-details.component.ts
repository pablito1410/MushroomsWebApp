import {Component, OnInit, Inject} from "@angular/core";
import {MdDialogRef, MD_DIALOG_DATA, MdSnackBar} from "@angular/material";
import {User} from "../../../model/user";
import {DOCUMENT} from "@angular/platform-browser";
import {FriendService} from "../../../services/friend.service";
import {AcceptInvitationToFriendsCommand} from "../../../commands/accept-invitation-to-friends.command";

@Component({
    moduleId: module.id,
    selector: 'friend-details-cmp',
    templateUrl: 'friend-details.component.html'
})
export class FriendDetailsComponent implements OnInit {

    constructor(
        public dialogRef: MdDialogRef<FriendDetailsComponent>,
        @Inject(MD_DIALOG_DATA) public data: any,
        @Inject(DOCUMENT) private document,
        public snackBar: MdSnackBar,
        private friendService: FriendService) { }

    ngOnInit() {
        if (+document.location.port == 4200) {
            // for only frontend development purposes
        } else {
            // TODO
        }
    }

    convertDateToLocaleString(date: string) : string {
        return new Date(date).toLocaleDateString();
    }

    getUserPhotoToDisplay() : string {
        return 'data:image/png;base64,' + this.data.user.photo;
    }

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

    close() {
        this.dialogRef.close('Close');
    }
}