import { Component, Inject, OnInit } from '@angular/core';
import { Trip } from "../../model/trip";
import { TripService } from "../../services/trip.service";
import { User } from "../../model/user";
import { TripDetailsComponent } from "./trip-details/trip-details.component";
import { MdDialog } from "@angular/material";
import { AddTripComponent } from "./add-trip/add-trip.component";
import { DOCUMENT } from "@angular/platform-browser";
import { Tools } from "../../tools/tools";

/**
 * Trips page component
 */
@Component({
    moduleId: module.id,
    selector: 'trips-cmp',
    templateUrl: 'trips.component.html'
})
export class TripsComponent implements OnInit {

    /** Array with trips */
    trips: Trip[];
    /** Option selected in dialog */
    selectedOption: string;
    
    /** Static method convert date tolocale string assignment */
    convertDateToLocaleString = Tools.convertDateToLocaleString;

    /**
     * Constructor of class
     * @param dialog            Material dialog
     * @param tripService       Trip service
     * @param document          Current document
     */
    constructor(
        public dialog: MdDialog,
        private tripService: TripService,
        @Inject(DOCUMENT) private document) {
        this.trips = new Array<Trip>();
    }

    /**
     * Initialization method
     */
    ngOnInit() {
        if (+document.location.port == 4200) {
            // for only frontend development purposes
            this.initFakeData();
        } else {
            this.tripService.getAll().subscribe(
                result => this.trips = result
            );
        }

    }

    /**
     * Initialize the component with fake data
     */
    private initFakeData() {
        this.trips = [
            {
                id: 1,
                dateTime: '2016-06-27T19:08:42.646',
                place: 'Katowice',
                coordinateX: 43.342845,
                coordinateY: 20.343843,
                radius: 1000.240053
            },
            {
                id: 2,
                dateTime: '2017-09-15T18:08:42.646',
                place: 'Rybnik',
                coordinateX: 13.342845,
                coordinateY: 60.343843,
                radius: 1342.170053
            },
            {
                id: 3,
                dateTime: '2017-11-27T19:08:42.646',
                place: 'Gliwice',
                coordinateX: 11.342845,
                coordinateY: 30.343843,
                radius: 800.240053
            }
        ];
    }

    /**
     * Opens discovery trip dialog
     * @param trip      Trip
     */
    openTripDetailsDialog(trip: Trip) {
        let dialogRef = this.dialog.open(TripDetailsComponent, {
            data: { 
                trip: trip,
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

    /**
     * Opens add trip dialog
     */
    openAddTripDialog() {
        let dialogRef = this.dialog.open(AddTripComponent, {
            hasBackdrop: true,
            height: '80%',
            width: '80%',
        });
        dialogRef.afterClosed().subscribe(result => {
            this.selectedOption = result;
            this.ngOnInit();
        });
    }
}
