import {Component, Inject, OnInit} from "@angular/core";
import {MD_DIALOG_DATA, MdDialog, MdDialogRef} from "@angular/material";
import {SearchFriendsComponent} from "../../friends/search-friends/search-friends.component";
import {FormControl} from "@angular/forms";
import {Trip} from "../../../model/trip";
import {TripService} from "app/services/trip.service";
import {UserService} from "../../../services/user.service";
import {FriendDetailsComponent} from "../../friends/friend-details/friend-details.component";

@Component({
    moduleId: module.id,
    selector: 'trip-details-cmp',
    templateUrl: 'trip-details.component.html'
})
export class TripDetailsComponent implements OnInit {
    trip: Trip;
    users: any[];
    defaultCoordinateX: number = 52.345566;
    defaultCoordinateY: number = 24.463566;
    public zoom: number = 4;
    public radius: number = 1000;
    marker: Marker;
    selectedOption: string;

    constructor(
        public dialog: MdDialog,
        public dialogRef: MdDialogRef<TripDetailsComponent>,
        @Inject(MD_DIALOG_DATA) public user: any,
        private tripService: TripService,
        private userService: UserService) { // chyba friends trzeba bedzie wolac

        this.marker = {
            lat: this.defaultCoordinateX,
            lng: this.defaultCoordinateY,
            label: 'Yours Discovery',
            draggable: true
        };
    }

    ngOnInit() {
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
}