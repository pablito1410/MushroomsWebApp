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

@Component({
    moduleId: module.id,
    selector: 'add-discovery-cmp',
    templateUrl: 'add-discovery.component.html'
})
export class AddDiscoveryComponent implements OnInit {
    discovery: Discovery;
    mushroomSpecies: MushroomSpecies[];
    zoom: number = 4;
    imageSrc: string;
    file: File;
    speciesId: number;

    constructor(
        public dialogRef: MdDialogRef<AddDiscoveryComponent>,
        private router: Router,
        public snackBar: MdSnackBar,
        @Inject(DOCUMENT) private document,
        private discoveryService: DiscoveryService,
        private mushroomSpeciesService: MushroomSpeciesService) {
        this.discovery = new Discovery();
        this.mushroomSpecies = new Array<MushroomSpecies>();
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
        }
        this.discovery = new Discovery();
        this.setCurrentPosition();
    }

    clickedMarker(label: string) {
        console.log(`clicked the marker: ${label}`);
    }

    mapClicked($event: any) {
        this.discovery.coordinateX = $event.coords.lat;
        this.discovery.coordinateY = $event.coords.lng;
    }

    markerDragEnd(discovery: Discovery, $event: MouseEvent) {
        console.log('dragEnd', discovery, $event);
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

    private setCurrentPosition() {
        if ("geolocation" in navigator) {
            navigator.geolocation.getCurrentPosition((position) => {
                this.discovery.coordinateX = position.coords.latitude;
                this.discovery.coordinateY = position.coords.longitude;
                this.zoom = 12;
            });
        }
    }

    getDiscoveryPhotoToDisplay() : string {
        return 'data:image/png;base64,' + this.discovery.photo;
    }
}