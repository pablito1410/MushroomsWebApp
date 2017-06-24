import {Component, OnInit} from "@angular/core";
import {MdDialogRef, MdSnackBar} from "@angular/material";
import {SearchFriendsComponent} from "../../friends/search-friends/search-friends.component";
import {UserService} from "../../../services/user.service";
import {Router} from "@angular/router";
import {DiscoveryService} from "../../../services/discovery.service";

@Component({
    moduleId: module.id,
    selector: 'add-discovery-cmp',
    templateUrl: 'add-discovery.component.html'
})
export class AddDiscoveryComponent implements OnInit {
    defaultCoordinateX: number = 52.345566;
    defaultCoordinateY: number = 24.463566;
    photo: any;
    dateTime: string;
    zoom: number = 4;
    marker: Marker;
    imageSrc: string;
    file: File;

    constructor(
        public dialogRef: MdDialogRef<AddDiscoveryComponent>,
        private router: Router,
        private discoveryService: DiscoveryService,
        public snackBar: MdSnackBar) {
        this.marker = {
            lat: this.defaultCoordinateX,
            lng: this.defaultCoordinateY,
            label: 'Yours Discovery',
            draggable: true
        };
    }

    ngOnInit() {
    }

    clickedMarker(label: string) {
        console.log(`clicked the marker: ${label}`);
    }

    mapClicked($event: any) {
        this.marker = {
            lat: $event.coords.lat,
            lng: $event.coords.lng,
            label: 'Your Discoveries',
            draggable: false
        };
    }

    markerDragEnd(m: Marker, $event: MouseEvent) {
        console.log('dragEnd', m, $event);
    }

    handleReaderLoaded(e) {
        var reader = e.target;
        this.imageSrc = reader.result;
    }

    handleInputChange(event) {
        this.file = event.dataTransfer ? event.dataTransfer.files[0] : event.target.files[0];
        var pattern = /image-*/;
        var reader = new FileReader();
        if (!this.file.type.match(pattern)) {
            alert('invalid format');
            return;
        }
        console.log(this.file);
        reader.onload = this.handleReaderLoaded.bind(this);
        reader.readAsDataURL(this.file);
        console.log(this.file);
        // this.discoveryService.create(file).subscribe(
            // data => {
            //     this.router.navigate(['/users']);
            //     this.snackBar.open('Photo Saved', '×', {
            //         duration: 2000,
            //     });
            // },
            // error => {
            //     this.snackBar.open('Error', '×', {
            //         duration: 2000,
            //     });
            // });
    }
}