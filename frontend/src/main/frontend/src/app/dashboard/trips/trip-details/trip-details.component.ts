import {Component, Inject, OnInit} from "@angular/core";
import {MD_DIALOG_DATA, MdDialog, MdDialogRef} from "@angular/material";
import {SearchFriendsComponent} from "../../friends/search-friends/search-friends.component";
import {FormControl} from "@angular/forms";
import {Trip} from "../../../model/trip";
import {TripService} from "app/services/trip.service";
import {UserService} from "../../../services/user.service";
import {FriendDetailsComponent} from "../../friends/friend-details/friend-details.component";
import {DOCUMENT} from "@angular/platform-browser";
import {FriendService} from "../../../services/friend.service";
import {User} from "../../../model/user";

@Component({
    moduleId: module.id,
    selector: 'trip-details-cmp',
    templateUrl: 'trip-details.component.html'
})
export class TripDetailsComponent implements OnInit {
    friends: User[];
    public zoom: number = 12;
    selectedOption: string;

    constructor(
        public dialog: MdDialog,
        public dialogRef: MdDialogRef<TripDetailsComponent>,
        @Inject(MD_DIALOG_DATA) public trip: any,
        @Inject(DOCUMENT) private document,
        private tripService: TripService,
        private friendService: FriendService) { }


    ngOnInit() {
        if (+document.location.port == 4200) {
            // for only frontend development purposes
            this.friends = [
                {
                    id: 1,
                    username: 'roman33',
                    email: 'romy@mail.com',
                    firstName: 'Roman',
                    lastName: 'Nowak',
                    birthDate: '21.07.1989',
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
                    birthDate: '06.11.1991',
                    gender: 'MALE',
                    level: 'BEGINNER',
                    country: 'Germany',
                    city: 'Berlin',
                    photo: null,
                    role: 'MUSHROOMER'
                }
            ];
        } else {
            this.friendService.getAll().subscribe(
                result => this.friends = result
            );
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
        this.friendService.search(term)
            .subscribe(
                result => this.friends = result
            );
    }
}