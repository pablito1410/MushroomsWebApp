import {Component, OnInit} from '@angular/core';
import {Discovery} from "../../model/discovery";
import { MdDialog} from "@angular/material";
import {SearchFriendsComponent} from "../friends/search-friends/search-friends.component";
import {AddDiscoveryComponent} from "./add-discovery/add-discovery.component";
import {DiscoveryDetailsComponent} from "./discovery-details/discovery-details.component";
import {DiscoveryService} from "../../services/discovery.service";

@Component({
    moduleId: module.id,
    selector: 'discoveries-cmp',
    templateUrl: 'discoveries.component.html'
})
export class DiscoveriesComponent implements OnInit {
    model: any = {};
    discoveries: any[];
    selectedOption: string;

    constructor(
        public dialog: MdDialog,
        private discoveryService: DiscoveryService) {}

    ngOnInit(){
        this.discoveryService.getAll().subscribe(
            value => this.discoveries = value
        );
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

    openDiscoveryDetailsDialog() {
        let dialogRef = this.dialog.open(DiscoveryDetailsComponent, {
            hasBackdrop: true,
            height: '80%',
            width: '80%',
        });
        dialogRef.afterClosed().subscribe(result => {
            this.selectedOption = result;
        });
    }
}