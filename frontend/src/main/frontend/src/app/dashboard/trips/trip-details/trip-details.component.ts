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
import {Discovery} from "app/model/discovery";
import {DiscoveryDetailsComponent} from "../../discoveries/discovery-details/discovery-details.component";
import {InviteToTripCommand} from "../../../commands/invite-to-trip.command";

@Component({
    moduleId: module.id,
    selector: 'trip-details-cmp',
    templateUrl: 'trip-details.component.html'
})
export class TripDetailsComponent implements OnInit {
    friends: User[];
    discoveries: Discovery[];
    selectedFriends: Set<User>;
    acceptedFriends: User[];
    invitedFriends: User[];
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
        this.selectedFriends = new Set<User>();
        this.acceptedFriends = new Array<User>();
        this.invitedFriends = new Array<User>();
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
            this.invitedFriends = this.friends;
            this.acceptedFriends = this.friends;
            this.discoveries = [
                {
                    id: 1,
                    tripId: 1,
                    mushroomSpeciesId: 1,
                    coordinateX: 43.341166,
                    coordinateY: 38.462563,
                    photo: null,
                    dateTime: '2016-06-21T19:09:42.646',
                    mushroomSpecies: {
                        id: 1,
                        name: "Podgrzybek",
                        examplePhoto: null,
                        genus: null
                    },
                    isPublic: true
                },
                {
                    id: 2,
                    tripId: 1,
                    mushroomSpeciesId: 1,
                    coordinateX: 45.345566,
                    coordinateY: 35.463566,
                    photo: null,
                    dateTime: '2016-07-22T19:11:32.646',
                    mushroomSpecies: {
                        id: 1,
                        name: "Podgrzybek",
                        examplePhoto: null,
                        genus: null
                    },
                    isPublic: true
                },
                {
                    id: 3,
                    tripId: 1,
                    mushroomSpeciesId: 1,
                    coordinateX: 41.174666,
                    coordinateY: 22.463226,
                    photo: null,
                    dateTime: '2017-04-28T19:08:11.646',
                    mushroomSpecies: {
                        id: 1,
                        name: "Podgrzybek",
                        examplePhoto: null,
                        genus: null
                    },
                    isPublic: true
                }
            ];
        } else {
            this.tripService.getParticipants(this.trip.id).subscribe(
                result => this.acceptedFriends = result
            );
            this.tripService.getTripRequests(this.trip.id).subscribe(
                result => this.invitedFriends = result
            );
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
            if (this.selectedFriends.has(friend)) {
                this.selectedFriends.delete(friend);
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
            data: {
                user: user,
                status: 'details'
            },
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
            data: {
                discovery: discovery,
                status: 'details'
            },
            hasBackdrop: true,
            height: '80%',
            width: '80%',
        });
        dialogRef.afterClosed().subscribe(result => {
            this.selectedOption = result;
        });
    }

    isComing() : boolean {
        let today = new Date();
        let getting = new Date(this.trip.dateTime)
        let res = today < getting;
        // console.log(today.toLocaleString() + '   ?   ' + getting.toLocaleString());
        // console.log(res);
        return res;
    }

    areDiscoveries() : boolean {
        return this.discoveries.length > 0;
    }

    areAcceptedFriends() : boolean {
        return this.acceptedFriends.length > 0;
    }
    
    areInvitedFriends() : boolean {
        return this.invitedFriends.length > 0;
    }

    convertDateToLocaleString(date: string) : string {
        return new Date(date).toLocaleString();
    }

    invite() {
        if (this.selectedFriends.size > 0) {
            console.log(this.trip.id);
            let userIds = new Set<number>();
            this.selectedFriends.forEach(f => {
                userIds.add(f.id);
            })
            console.log('start invite');
            this.tripService.invite(
                new InviteToTripCommand(this.trip.id, Array.from(userIds))).subscribe(
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

    close() {
        this.dialogRef.close('Close');
    }
}