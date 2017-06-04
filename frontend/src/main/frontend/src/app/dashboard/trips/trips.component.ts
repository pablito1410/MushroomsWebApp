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
        this.model = JSON.parse(localStorage.getItem('currentUser'));
        let user = this.model;
        this.tripService.getAll().subscribe(
            value => this.trips = value
            // error => this.anyErrors = true,
            // () => this.finished = true
        );
        // this.trips = [
        //     {place : 'Katowice', dateTime : '14.06.2017 9:00'},
        //     {place : 'Gliwice', dateTime : '26.06.2017 8:30'}
        // ]
    }

    openTripDetailsDialog() {
        let dialogRef = this.dialog.open(TripDetailsComponent, {
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
