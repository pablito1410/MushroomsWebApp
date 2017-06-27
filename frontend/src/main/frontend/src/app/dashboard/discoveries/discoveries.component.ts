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
                // {
                //     'id': 1,
                //     'coordinateX': 43.341166,
                //     'coordinateY': 38.462563,
                //     photo: null,
                //     dateTime: '22.12.2017 18:22:33',
                // },
                // {
                //     id: 2,
                //     'coordinateX': 45.345566,
                //     'coordinateY': 35.463566,
                //     photo: null,
                //     dateTime: '21.12.2017 06:44:23',
                // },
                // {
                //     'id': 3,
                //     'coordinateX': 41.174666,
                //     'coordinateY': 22.463226,
                //     photo: null,
                //     dateTime: '20.12.2017 11:12:23',
                // }
            ];
        } else {
            this.discoveryService.getAll().subscribe(
                value => this.discoveries = value
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
}