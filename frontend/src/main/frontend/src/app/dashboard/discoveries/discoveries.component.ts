import {Component, Inject, OnInit} from '@angular/core';
import {Discovery} from "../../model/discovery";
import { MdDialog} from "@angular/material";
import {SearchFriendsComponent} from "../friends/search-friends/search-friends.component";
import {AddDiscoveryComponent} from "./add-discovery/add-discovery.component";
import {DiscoveryDetailsComponent} from "./discovery-details/discovery-details.component";
import {DiscoveryService} from "../../services/discovery.service";
import {DOCUMENT} from "@angular/platform-browser";

@Component({
    moduleId: module.id,
    selector: 'discoveries-cmp',
    templateUrl: 'discoveries.component.html'
})
export class DiscoveriesComponent implements OnInit {
    discoveries: Discovery[];
    selectedOption: string;

    constructor(
        public dialog: MdDialog,
        @Inject(DOCUMENT) private document,
        private discoveryService: DiscoveryService) {
        this.discoveries = new Array<Discovery>();
    }

    ngOnInit() {
        if (+document.location.port == 4200) {
            // for only frontend development purposes
            this.discoveries = [
                {
                    id: 1,
                    coordinateX: 43.341166,
                    coordinateY: 38.462563,
                    photo: null,
                    dateTime: '2016-06-21T19:09:42.646Z',
                    isPublic: true
                },
                {
                    id: 2,
                    coordinateX: 45.345566,
                    coordinateY: 35.463566,
                    photo: null,
                    dateTime: '2016-07-22T19:11:32.646Z',
                    isPublic: true
                },
                {
                    id: 3,
                    coordinateX: 41.174666,
                    coordinateY: 22.463226,
                    photo: null,
                    dateTime: '2017-04-28T19:08:11.646Z',
                    isPublic: true
                }
            ];
        } else {
            this.discoveryService.getAll().subscribe(
                result => this.discoveries = result
            );
        }
    }

    openAddDiscoveryDialog() {
        let dialogRef = this.dialog.open(AddDiscoveryComponent, {
            hasBackdrop: true,
            height: '80%',
            width: '80%',
        });
        dialogRef.afterClosed().subscribe(result => {
            this.selectedOption = result;
        });
    }

    searchDiscoveries(term: string) {
        // this.discoveryService.search(term)
        //     .subscribe(results => {
        //         this.discoveryService = results;
        //     });
    }

    openDiscoveryDetailsDialog(discovery) {
        let dialogRef = this.dialog.open(DiscoveryDetailsComponent, {
            data: discovery,
            hasBackdrop: true,
            height: '80%',
            width: '80%',
        });
        dialogRef.afterClosed().subscribe(result => {
            this.selectedOption = result;
        });
    }

    convertDateToLocaleString(date: string) : string {
        return new Date(date).toLocaleString();
    }

    getDiscoveryPhotoToDisplay(discovery: Discovery) : string {
        return 'data:image/png;base64,' + discovery.photo;
    }
}