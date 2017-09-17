import {Component, Inject, OnInit} from "@angular/core";
import {MdDialogRef, MdSnackBar} from "@angular/material";
import {SearchFriendsComponent} from "../../friends/search-friends/search-friends.component";
import {UserService} from "../../../services/user.service";
import {Router} from "@angular/router";
import {DiscoveryService} from "../../../services/discovery.service";
import {Discovery} from "../../../model/discovery";
import {MushroomSpecies} from "../../../model/mushroom-species";
import {DOCUMENT} from "@angular/platform-browser";
import {MushroomSpeciesService} from "app/services/mushroom-species.service";
import {Trip} from "../../../model/trip";
import {TripService} from "../../../services/trip.service";

@Component({
    moduleId: module.id,
    selector: 'add-discovery-cmp',
    templateUrl: 'add-discovery.component.html'
})
export class AddDiscoveryComponent implements OnInit {
    discovery: Discovery;
    mushroomSpecies: MushroomSpecies[];
    trips: Trip[];
    zoom: number = 4;
    imageSrc: string;
    file: File;
    speciesId: number;
    tripId: number;
    isPublic: boolean;

    constructor(
        public dialogRef: MdDialogRef<AddDiscoveryComponent>,
        private router: Router,
        public snackBar: MdSnackBar,
        @Inject(DOCUMENT) private document,
        private discoveryService: DiscoveryService,
        private mushroomSpeciesService: MushroomSpeciesService,
        private tripService: TripService) {
        this.discovery = new Discovery();
        this.mushroomSpecies = new Array<MushroomSpecies>();
        this.trips = new Array<Trip>();
        this.isPublic = false;
    }

    ngOnInit() {
        if (+document.location.port == 4200) {
            // for only frontend development purposes
            this.mushroomSpecies = [
                {
                    id: 1,
                    name: "Podgrzybek",
                    examplePhoto: null,
                    genus: null
                },
                {
                    id: 2,
                    name: "Kurka",
                    examplePhoto: null,
                    genus: null
                },
                {
                    id: 3,
                    name: "Maslak",
                    examplePhoto: null,
                    genus: null
                }
            ];
        } else {
            this.mushroomSpeciesService.getAll().subscribe(
                result => this.mushroomSpecies = result
            );
            this.tripService.getAll().subscribe(
                result => this.trips = result
            );
        }
        this.discovery = new Discovery();
        this.setCurrentPosition();
    }

    mapClicked($event: any) {
        this.discovery.coordinateX = $event.coords.lat;
        this.discovery.coordinateY = $event.coords.lng;
    }

    markerDragEnd(discovery: Discovery, $event) {
        this.discovery.coordinateX = $event.coords.lat;
        this.discovery.coordinateY = $event.coords.lng;
        console.log('dragEnd', discovery, $event);
    }

    handleReadAsDataURL(e) {
        console.log('handleReadAsDataURL');
        var reader = e.target;
        this.imageSrc = reader.result;
    }

    handleReadAsArrayBuffer(e) {
        console.log('handleReadAsArrayBuffer');
        var reader = e.target;
        var array = Array.from(new Uint8Array(reader.result));
        this.discovery.photo = array;
        console.log(this.discovery.photo);
    }

    handleInputChange(event) {
        this.file = event.dataTransfer ? event.dataTransfer.files[0] : event.target.files[0];
        var pattern = /image-*/;
        if (!this.file.type.match(pattern)) {
            alert('invalid format');
            return;
        }
        var readerArrayBuffer = new FileReader();
        var readerDataURL = new FileReader();
        readerArrayBuffer.onloadend = this.handleReadAsArrayBuffer.bind(this);
        readerArrayBuffer.readAsArrayBuffer(this.file);
        readerDataURL.onload = this.handleReadAsDataURL.bind(this);
        readerDataURL.readAsDataURL(this.file);
    }

    checkboxOnClick(event: Event) {
        if ($(event.target).is("input")) {
            this.isPublic = !this.isPublic;
        }
    }

    addDiscovery() {
        let dateTime = new Date();
        dateTime.setHours(dateTime.getHours() + 2);
        this.discovery.dateTime = dateTime.toISOString().slice(0, -1);
        this.discovery.tripId = this.tripId;
        this.discovery.mushroomSpeciesId = this.speciesId;
        this.discovery.isPublic = this.isPublic;
        this.discoveryService.create(this.discovery).subscribe(
        data => {
            this.snackBar.open('Discovery Added', '×', {
                duration: 2000,
            });
        },
        error => {
            this.snackBar.open('Error', '×', {
                duration: 2000,
            });
        });
        this.dialogRef.close('Ok');
    }

    private setCurrentPosition() {
        if ("geolocation" in navigator) {
            navigator.geolocation.getCurrentPosition((position) => {
                this.discovery.coordinateX = position.coords.latitude;
                this.discovery.coordinateY = position.coords.longitude;
                this.zoom = 12;
            });
        }
    }
}