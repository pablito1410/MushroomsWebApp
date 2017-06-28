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
    // checkedUsersIds: number[];

    constructor(
        public dialog: MdDialog,
        public dialogRef: MdDialogRef<SearchFriendsComponent>,
        @Inject(DOCUMENT) private document,
        private userService: UserService) {
        this.users = new Array<User>();
        // this.checkedUsersIds = new Array<number>();
    }

    ngOnInit() {
        if (+document.location.port == 4200) {
            // for only frontend development purposes
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

    updateCheckedOptions(user, event) {
        // this.optionsMap[option] = event.target.checked;
    }
}