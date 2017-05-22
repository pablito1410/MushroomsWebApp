import {Component, OnInit} from '@angular/core';
import {Trip} from "../../model/trip";
import {TripService} from "../../services/trip.service";
import {Observable} from "rxjs";
import {User} from "../../model/user";

@Component({
    moduleId: module.id,
    selector: 'trips-cmp',
    templateUrl: 'trips.component.html'
})

export class TripsComponent implements OnInit {

    trips: Array<Trip>;
    model: any = {};

    constructor(
        private tripService: TripService) { }

    ngOnInit() {
        this.model = JSON.parse(localStorage.getItem('currentUser'));
        let user = this.model;
        this.tripService.getAll().subscribe(
            value => this.trips = value
            // error => this.anyErrors = true,
            // () => this.finished = true
        );
    }

}
