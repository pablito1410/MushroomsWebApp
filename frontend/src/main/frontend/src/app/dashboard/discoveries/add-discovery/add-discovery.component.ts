import { Component, Inject, OnInit } from "@angular/core";
import { MdDialogRef, MdSnackBar } from "@angular/material";
import { SearchFriendsComponent } from "../../friends/search-friends/search-friends.component";
import { UserService } from "../../../services/user.service";
import { Router } from "@angular/router";
import { DiscoveryService } from "../../../services/discovery.service";
import { TagService } from "../../../services/tag.service";
import { Discovery } from "../../../model/discovery";
import { MushroomSpecies } from "../../../model/mushroom-species";
import { DOCUMENT } from "@angular/platform-browser";
import { MushroomSpeciesService } from "app/services/mushroom-species.service";
import { Trip } from "../../../model/trip";
import { Tag } from "../../../model/tag";
import { TripService } from "../../../services/trip.service";

/**
 * Add discovery dialog component
 */
@Component({
    moduleId: module.id,
    selector: 'add-discovery-cmp',
    templateUrl: 'add-discovery.component.html'
})
export class AddDiscoveryComponent implements OnInit {

    /** Object of the added discovery */
    discovery: Discovery;
    /** Mushroom species for choose from combobox */
    mushroomSpecies: MushroomSpecies[];
    /** Trips for choose from combobox */
    trips: Trip[];
    /** Zoom on map */
    zoom: number;
    /** Choosing image src */
    imageSrc: string;
    /** File for discovery image */
    file: File;
    /** Identification number of choosing mushroom species */
    speciesId: number;
    /** Identification number of choosing trip */
    tripId: number;
    /** Flag indicating whether the trip is to be public */
    isPublic: boolean;
    /** String with tags */
    tagsString: string;

    /**
     * Constructor of class
     * @param dialogRef                 Material dialog reference to this component
     * @param router                    Router
     * @param snackBar                  Material snack bar
     * @param document                  Current document
     * @param discoveryService          Discovery service
     * @param tagService                Tag service
     * @param mushroomSpeciesService    Mushroom species service
     * @param tripService               Trip service
     */
    constructor(
        public dialogRef: MdDialogRef<AddDiscoveryComponent>,
        private router: Router,
        public snackBar: MdSnackBar,
        @Inject(DOCUMENT) private document,
        private discoveryService: DiscoveryService,
        private tagService: TagService,
        private mushroomSpeciesService: MushroomSpeciesService,
        private tripService: TripService) {
        this.discovery = new Discovery();
        this.mushroomSpecies = new Array<MushroomSpecies>();
        this.trips = new Array<Trip>();
        this.isPublic = false;
        this.zoom = 4;
    }

    /**
     * Initialization method
     */
    ngOnInit() {
        if (+document.location.port == 4200) {
            // for only frontend development purposes
            this. initFakeData();
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

    /**
     * Initialize the component with fake data
     */
     private initFakeData() {
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
    }

    /**
     * Map clicked handle
     * @param $event    Event
     */
    mapClicked($event: any) {
        this.discovery.coordinateX = $event.coords.lat;
        this.discovery.coordinateY = $event.coords.lng;
    }

    /**
     * Marker drag end handle
     * @param discovery Discovery
     * @param $event    Event
     */
    markerDragEnd(discovery: Discovery, $event: any) {
        this.discovery.coordinateX = $event.coords.lat;
        this.discovery.coordinateY = $event.coords.lng;
    }

    /**
     * Reads file as data URL
     * @param event     Event
     */
    handleReadAsDataURL(event: any) {
        var reader = event.target;
        this.imageSrc = reader.result;
    }

    /**
     * Reads file as array buffer
     * @param event     Event
     */
    handleReadAsArrayBuffer(event: any) {
        var reader = event.target;
        var array = Array.from(new Uint8Array(reader.result));
        this.discovery.photo = array;
    }

    /**
     * Input change handle
     * @param event     Event
     */
    handleInputChange(event: any) {
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

    /**
     * Checkbox on click handle
     * @param event     Event
     */
    checkboxOnClick(event: Event) {
        if ($(event.target).is("input")) {
            this.isPublic = !this.isPublic;
        }
    }

    /**
     * Add discovery button handle
     */
    addDiscovery() {
        let dateTime = new Date();
        dateTime.setHours(dateTime.getHours() + 2);
        this.discovery.dateTime = dateTime.toISOString().slice(0, -1);
        this.discovery.tripId = this.tripId;
        this.discovery.mushroomSpeciesId = this.speciesId;
        this.discovery.isPublic = this.isPublic;
        this.discoveryService.create(this.discovery).subscribe(
            data => {
                this.discovery.id = +data.toString();
                if (this.tagsString != '') {
                    var tags = this.tagsString.split(' ');
                    let tagInstance = new Tag();
                    tagInstance.discoveryId = this.discovery.id;
                    for (let tag of tags) {
                        tagInstance.name = tag;
                        this.tagService.create(tagInstance).subscribe();
                    }
                }
                this.dialogRef.close('Ok');
                this.snackBar.open('Discovery Added', '×', {
                    duration: 2000,
                });
            },
            error => {
                this.dialogRef.close('Ok');
                this.snackBar.open('Error', '×', {
                    duration: 2000,
                });
            });
    }

    /**
     * Sets current position using geolocation
     */
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