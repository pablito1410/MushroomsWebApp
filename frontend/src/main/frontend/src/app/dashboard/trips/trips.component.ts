import {Component, Inject, OnInit} from '@angular/core';
import {Trip} from "../../model/trip";
import {TripService} from "../../services/trip.service";
import {Observable} from "rxjs";
import {User} from "../../model/user";
import {TripDetailsComponent} from "./trip-details/trip-details.component";
import {MdDialog} from "@angular/material";
import {AddTripComponent} from "./add-trip/add-trip.component";
import {DOCUMENT} from "@angular/platform-browser";

@Component({
    moduleId: module.id,
    selector: 'trips-cmp',
    templateUrl: 'trips.component.html'
})

export class TripsComponent implements OnInit {
    trips: Trip[];
    selectedOption: string;

    constructor(
        public dialog: MdDialog,
        private tripService: TripService,
        @Inject(DOCUMENT) private document) { }

    ngOnInit() {
        if (+document.location.port == 4200) {
            // for only frontend development purposes
            this.trips = [
                {
                    id: 1,
                    dateTime: '22.12.2017 18:22:33',
                    place: 'Katowice',
                    coordinateX: 43.342845,
                    coordinateY: 20.343843,
                    radius: 1000.240053
                },
                {
                    id: 2,
                    dateTime: '12.06.2017 15:12:35',
                    place: 'Rybnik',
                    coordinateX: 13.342845,
                    coordinateY: 60.343843,
                    radius: 1342.170053
                },
                {
                    id: 3,
                    dateTime: '24.10.2017 11:21:26',
                    place: 'Gliwice',
                    coordinateX: 11.342845,
                    coordinateY: 30.343843,
                    radius: 800.240053
                }
            ];
        } else {
            this.tripService.getAll().subscribe(
                result => this.trips = result
            );
        }

    }

    openTripDetailsDialog(trip) {
        let dialogRef = this.dialog.open(TripDetailsComponent, {
            data: trip,
            hasBackdrop: true,
            height: '80%',
            width: '80%',
        });
        dialogRef.afterClosed().subscribe(result => {
            this.selectedOption = result;
        });
    }

    openAddTripDialog() {
        let dialogRef = this.dialog.open(AddTripComponent, {
            hasBackdrop: true,
            height: '80%',
            width: '80%',
        });
        dialogRef.afterClosed().subscribe(result => {
            this.selectedOption = result;
        });
    }

}
