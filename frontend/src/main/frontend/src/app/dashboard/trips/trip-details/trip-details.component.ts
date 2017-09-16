import {Component, Inject, OnInit} from "@angular/core";
import {MD_DIALOG_DATA, MdDialog, MdDialogRef, MdSnackBar} from "@angular/material";
import {SearchFriendsComponent} from "../../friends/search-friends/search-friends.component";
import {FormControl} from "@angular/forms";
import {Trip} from "../../../model/trip";
import {TripService} from "app/services/trip.service";
import {UserService} from "../../../services/user.service";
import {FriendDetailsComponent} from "../../friends/friend-details/friend-details.component";
import {DOCUMENT} from "@angular/platform-browser";
import {FriendService} from "../../../services/friend.service";
import {User} from "../../../model/user";
import {DateTool} from "../../../shared/tools/date.tool";
import {Discovery} from "app/model/discovery";
import {DiscoveryDetailsComponent} from "../../discoveries/discovery-details/discovery-details.component";
import * as Collections from 'typescript-collections';
import {InviteToTripCommand} from "../../../commands/invite-to-trip.command";

@Component({
    moduleId: module.id,
    selector: 'trip-details-cmp',
    templateUrl: 'trip-details.component.html'
})
export class TripDetailsComponent implements OnInit {
    friends: User[];
    discoveries: Discovery[];
    selectedFriends: Collections.Set<User>;
    acceptedFriends: Collections.Set<User>;
    public zoom: number = 12;
    selectedOption: string;

    constructor(
        public dialog: MdDialog,
        public dialogRef: MdDialogRef<TripDetailsComponent>,
        @Inject(MD_DIALOG_DATA) public trip: Trip,
        @Inject(DOCUMENT) private document,
        private tripService: TripService,
        private friendService: FriendService,
        public snackBar: MdSnackBar) {
        this.friends = new Array<User>();
        this.discoveries = new Array<Discovery>();
        this.selectedFriends = new Collections.Set<User>();
        this.acceptedFriends = new Collections.Set<User>();
    }


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
            this.discoveries = [
                {
                    id: 1,
                    coordinateX: 43.341166,
                    coordinateY: 38.462563,
                    photo: null,
                    dateTime: '2016-06-21T19:09:42.646',
                    isPublic: true
                },
                {
                    id: 2,
                    coordinateX: 45.345566,
                    coordinateY: 35.463566,
                    photo: null,
                    dateTime: '2016-07-22T19:11:32.646',
                    isPublic: true
                },
                {
                    id: 3,
                    coordinateX: 41.174666,
                    coordinateY: 22.463226,
                    photo: null,
                    dateTime: '2017-04-28T19:08:11.646',
                    isPublic: true
                }
            ];
        } else {
            // this.friendService.getAllInvited().subscribe(
            //     result => this.friends = result
            // );
        }
    }

    checkCheckboxStatus(friend: User) : boolean {
        this.selectedFriends.forEach(f => {
            if (friend.id == f.id) {
                return true;
            }
        });
        return false;
    }

    checkboxOnClick(friend: User, event : Event) {
        if ($(event.target).is("input")) {
            if (this.selectedFriends.contains(friend)) {
                this.selectedFriends.remove(friend);
            } else {
                this.selectedFriends.add(friend);
            }
        }
    }

    getFriendPhotoToDisplay(friend: User) : string {
        return 'data:image/png;base64,' + friend.photo;
    }

    getDiscoveryPhotoToDisplay(discovery: Discovery) : string {
        return 'data:image/png;base64,' + discovery.photo;
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

    openDiscoveryDetailsDialog(discovery) {
        let dialogRef = this.dialog.open(DiscoveryDetailsComponent, {
            data: discovery,
            hasBackdrop: true,
            height: '80%',
            width: '80%',
        });
        dialogRef.afterClosed().subscribe(result => {
            this.selectedOption = result;
        });
    }

    isComing() : boolean {
        return DateTool.compareDateTime(new Date(), new Date(this.trip.dateTime)) == -1;
    }

    convertDateToLocaleString(date: string) : string {
        return new Date(date).toLocaleString();
    }

    invite() {
        if (!this.selectedFriends.isEmpty()) {
            console.log(this.trip.id);
            let userIds = new Collections.Set<number>();
            this.selectedFriends.forEach(f => {
                userIds.add(f.id);
            })
            console.log('start invite');
            this.tripService.invite(
                new InviteToTripCommand(this.trip.id, userIds.toArray())).subscribe(
                data => {
                    this.snackBar.open('Friends Invited', '×', {
                        duration: 2000,
                    });
                },
                error => {
                    this.snackBar.open('Error', '×', {
                        duration: 2000,
                    });
                });
            console.log('stop invite');
        }
    }

    search(term: string) {
        this.friendService.search(term)
            .subscribe(
                result => this.friends = result
            );
    }
}