import { Component, OnInit, Inject } from '@angular/core';
import {MapsAPILoader} from "angular2-google-maps/core";
import {Discovery} from "../../model/discovery";
import {Trip} from "../../model/trip";
import {DOCUMENT} from "@angular/platform-browser";
import {DiscoveryService} from "app/services/discovery.service";
import {TripService} from "../../services/trip.service";

@Component({
    moduleId: module.id,
    selector: 'maps-cmp',
    templateUrl: 'maps.component.html'
})
export class MapsComponent implements OnInit {
    discoveries: Discovery[];
    trips: Trip[];
    coordinateX: number;
    coordinateY: number;
    zoom: number;

    constructor(
        private discoveryService: DiscoveryService,
        private tripService: TripService,
        @Inject(DOCUMENT) private document) {
        this.discoveries = Array<Discovery>();
        this.trips = Array<Trip>();
    }

    ngOnInit() {
        if (+document.location.port == 4200) {
            // for only frontend development purposes
            this.discoveries = [
                {
                    id: 1,
                    tripId: 1,
                    mushroomSpeciesId: 1,
                    coordinateX: 43.341166,
                    coordinateY: 38.462563,
                    photo: null,
                    dateTime: '22.12.2017 18:22:33',
                    mushroomSpecies: null,
                    isPublic: true
                },
                {
                    id: 2,
                    tripId: 1,
                    mushroomSpeciesId: 1,
                    coordinateX: 45.345566,
                    coordinateY: 35.463566,
                    photo: null,
                    dateTime: '21.12.2017 06:44:23',
                    mushroomSpecies: null,
                    isPublic: true
                },
                {
                    id: 3,
                    tripId: 1,
                    mushroomSpeciesId: 1,
                    coordinateX: 41.174666,
                    coordinateY: 22.463226,
                    photo: null,
                    dateTime: '20.12.2017 11:12:23',
                    mushroomSpecies: null,
                    isPublic: true
                }
            ];
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
                }
            ];
        } else {
            this.discoveryService.getAll().subscribe(
                result => this.discoveries = result
            );
            this.tripService.getAll().subscribe(
                result => this.trips = result
            );
        }
        this.setCurrentPosition();
    }

    private setCurrentPosition() {
        if ("geolocation" in navigator) {
            navigator.geolocation.getCurrentPosition((position) => {
                this.coordinateX = position.coords.latitude;
                this.coordinateY = position.coords.longitude;
                this.zoom = 12;
            });
        }
    }
}
