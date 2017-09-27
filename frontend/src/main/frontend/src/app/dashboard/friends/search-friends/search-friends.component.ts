import { Component, OnInit, Inject } from "@angular/core";
import { MdDialogRef, MD_DIALOG_DATA, MdDialog, MdSnackBar } from "@angular/material";
import { UserDetailsComponent } from "../../user/user-details/user-details.component";
import { UserService } from "../../../services/user.service";
import { FriendService } from "../../../services/friend.service";
import { AddFriendCommand } from "../../../commands/add-friend.command";
import { DOCUMENT } from "@angular/platform-browser";
import { User } from "../../../model/user";
import { PhotoTool } from "../../../tools/photo-tool";

/**
 * Search friends dialog component
 */
@Component({
    moduleId: module.id,
    selector: 'search-friends-cmp',
    templateUrl: 'search-friends.component.html'
})
export class SearchFriendsComponent implements OnInit {
    
    /** Option selected in dialog */
    selectedOption: string;
    /** Model user object */
    users: User[];
    /** Selected users to invite */
    selectedUsers: Set<User>;

    /** Static method assignment */
    getPhotoStringToDisplay = PhotoTool.getPhotoStringToDisplay;

    /**
     * Constructor of class
     * @param dialog            Material dialog
     * @param dialogRef         Material dialog reference to this component
     * @param document          Current document
     * @param snackBar          Material snack bar
     * @param userService       User service
     * @param friendService     Friend service
     */
    constructor(
        public dialog: MdDialog,
        public dialogRef: MdDialogRef<SearchFriendsComponent>,
        @Inject(DOCUMENT) private document,
        public snackBar: MdSnackBar,
        private userService: UserService,
        private friendService: FriendService) {
        this.users = new Array<User>();
        this.selectedUsers = new Set<User>();
    }

    /**
     * Initialization method
     */
    ngOnInit() {
        if (+document.location.port == 4200) {
            // for only frontend development purposes
            this.initFakeData();
        } else {
            // For future use
        }
    }

    /**
     * Initialize the component with fake data
     */
    initFakeData() {
        this.users = [
            {
                id: 1,
                username: 'roman33',
                email: 'romy@mail.com',
                firstName: 'Roman',
                lastName: 'Nowak',
                birthDate: '21-07-1989',
                gender: 'MALE',
                level: 'BEGINNER',
                country: 'Polska',
                city: 'Gliwice',
                photo: null,
                role: 'MUSHROOMER'
            },
            {
                id: 2,
                username: 'thomas22',
                email: 'tomy22@mail.com',
                firstName: 'Tom',
                lastName: 'Goreing',
                birthDate: '16-11-1991',
                gender: 'MALE',
                level: 'BEGINNER',
                country: 'Germany',
                city: 'Berlin',
                photo: null,
                role: 'MUSHROOMER'
            },
            {
                id: 3,
                username: 'edi213',
                email: 'eddyyyy@mail.com',
                firstName: 'Andy',
                lastName: 'Hills',
                birthDate: '12-08-1997',
                gender: 'MALE',
                level: 'BEGINNER',
                country: 'Canada',
                city: 'Bridge',
                photo: null,
                role: 'MUSHROOMER'
            }
        ];
    }

    /**
     * Opens user details dialog
     * @param user      User
     * @param status    Status
     */
    openUserDetailsDialog(user: User, status: string) {
        let dialogRef = this.dialog.open(UserDetailsComponent, {
            data: {
                user: user,
                status: status
            },
            hasBackdrop: true,
            height: '80%',
            width: '80%',
        });
        dialogRef.afterClosed().subscribe(result => {
            this.selectedOption = result;
        });
    }

    /**
     * Search friends handle
     * @param term      term to search
     */
    search(term: string) {
        this.userService.search(term)
            .subscribe(results => {
                this.users = results;
            });
    }

    /**
     * Checks CheckboxStatus
     * @param user      User
     * @returns         Value of checkbox
     */
    checkCheckboxStatus(user: User): boolean {
        this.selectedUsers.forEach(u => {
            if (user.id == u.id) {
                return true;
            }
        });
        return false;
    }

    /**
     * Checkbox on click handle
     * @param user      User
     * @param event     Event
     */
    checkboxOnClick(user: User, event: Event) {
        if ($(event.target).is("input")) {
            if (this.selectedUsers.has(user)) {
                this.selectedUsers.delete(user);
            } else {
                this.selectedUsers.add(user);
            }
        }
    }

    /**
     * Invite button handle
     */
    invite() {
        if (this.selectedUsers.size > 0) {
            let userIds = new Set<number>();
            this.selectedUsers.forEach(f => {
                userIds.add(f.id);
            })
            this.friendService.add(
                new AddFriendCommand(Array.from(userIds))).subscribe(
                data => {
                    this.dialogRef.close('Ok');
                    this.snackBar.open('Friends Invited', '×', {
                        duration: 2000,
                    });
                },
                error => {
                    this.dialogRef.close('Ok');
                    this.snackBar.open('Error', '×', {
                        duration: 2000,
                    });
                });
        }
    }

    /**
     * Close button handle
     */
    close() {
        this.dialogRef.close('Close');
    }
}