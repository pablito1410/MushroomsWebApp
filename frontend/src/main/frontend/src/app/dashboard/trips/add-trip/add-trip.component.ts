import {Component, ElementRef, NgZone, OnInit, ViewChild} from "@angular/core";
import {MdDialog, MdDialogRef} from "@angular/material";
import {SearchFriendsComponent} from "../../friends/search-friends/search-friends.component";
import {FormControl} from "@angular/forms";
import {MapsAPILoader} from "angular2-google-maps/core";
import {Trip} from "../../../model/trip";
import {FriendDetailsComponent} from "../../friends/friend-details/friend-details.component";
import {UserService} from "../../../services/user.service";

@Component({
    moduleId: module.id,
    selector: 'add-trip-cmp',
    templateUrl: 'add-trip.component.html'
})
export class AddTripComponent implements OnInit {
    trip: Trip;
    users: any[];
    defaultCoordinateX: number = 52.345566;
    defaultCoordinateY: number = 24.463566;
    public searchControl: FormControl;
    public zoom: number = 4;
    public radius: number = 1000;
    marker: Marker;
    selectedOption: string;

    @ViewChild("search")
    public searchElementRef: ElementRef;

    constructor(
        public dialog: MdDialog,
        public dialogRef: MdDialogRef<AddTripComponent>,
        private mapsAPILoader: MapsAPILoader,
        private ngZone: NgZone,
        private userService: UserService
    ) {
        this.marker = {
            lat: this.defaultCoordinateX,
            lng: this.defaultCoordinateY,
            label: 'Your Trip',
            draggable: true
        };
        this.trip = new Trip();
    }

    ngOnInit() {

        //create search FormControl
        this.searchControl = new FormControl();

        //set current position
        this.setCurrentPosition();

        //load Places Autocomplete
        this.mapsAPILoader.load().then(() => {
            let autocomplete = new google.maps.places.Autocomplete(this.searchElementRef.nativeElement, {
                types: ["address"]
            });
            autocomplete.addListener("place_changed", () => {
                this.ngZone.run(() => {
                    //get the place result
                    let place: google.maps.places.PlaceResult = autocomplete.getPlace();

                    //verify result
                    if (place.geometry === undefined || place.geometry === null) {
                        return;
                    }

                    //set latitude, longitude and zoom
                    this.marker.lat = place.geometry.location.lat();
                    this.marker.lng = place.geometry.location.lng();
                    this.zoom = 12;
                });
            });
        });
    }

    private setCurrentPosition() {
        if ("geolocation" in navigator) {
            navigator.geolocation.getCurrentPosition((position) => {
                this.marker.lat = position.coords.latitude;
                this.marker.lng = position.coords.longitude;
                this.zoom = 12;
            });
        }
    }

    setPlace(place) {
    }

    circleDragEnd(m: Marker, $event: any) {
        this.marker = {
            lat: $event.coords.lat,
            lng: $event.coords.lng,
            label: 'Your Trip',
            draggable: false
        };
        var latlng = new google.maps.LatLng(this.marker.lat, this.marker.lng);
        var geocoder = geocoder = new google.maps.Geocoder();
        geocoder.geocode({'latLng': latlng}, (results, status) => {
            if (status == google.maps.GeocoderStatus.OK) {
                console.log(results)
                if (results[0]) {
                    this.trip.place = results[0].formatted_address;
                }
            }
            // alert("Place: " + this.trip.place);
        });
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