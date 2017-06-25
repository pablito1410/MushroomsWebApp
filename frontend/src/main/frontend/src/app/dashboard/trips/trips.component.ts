import {Component, OnInit} from '@angular/core';
import {Trip} from "../../model/trip";
import {TripService} from "../../services/trip.service";
import {Observable} from "rxjs";
import {User} from "../../model/user";
import {TripDetailsComponent} from "./trip-details/trip-details.component";
import {MdDialog} from "@angular/material";
import {AddTripComponent} from "./add-trip/add-trip.component";

@Component({
    moduleId: module.id,
    selector: 'trips-cmp',
    templateUrl: 'trips.component.html'
})

export class TripsComponent implements OnInit {
    trips: Array<Trip>;
    // trips: any = {};
    model: any = {};
    selectedOption: string;

    constructor(
        public dialog: MdDialog,
        private tripService: TripService) { }

    ngOnInit() {
        this.tripService.getAll().subscribe(
            value => this.trips = value
        );
        // this.trips = [
        //     {
        //         id: 1,
        //         dateTime: '22.12.2017 18:22:33',
        //         place: 'Katowice',
        //         mushroomersIds: [],
        //         discoveries: []
        //     },
        //     {
        //         id: 2,
        //         dateTime: '12.06.2017 15:12:35',
        //         place: 'Rybnik',
        //         mushroomersIds: [],
        //         discoveries: []
        //     },
        //     {
        //         id: 3,
        //         dateTime: '24.10.2017 11:21:26',
        //         place: 'Gliwice',
        //         mushroomersIds: [],
        //         discoveries: []
        //     }
        // ];
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
