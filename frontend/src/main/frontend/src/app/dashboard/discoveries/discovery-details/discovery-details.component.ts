import {Component, OnInit} from "@angular/core";
import { MdDialogRef } from "@angular/material";
import {SearchFriendsComponent} from "../../friends/search-friends/search-friends.component";

@Component({
    moduleId: module.id,
    selector: 'discovery-details-cmp',
    templateUrl: 'discovery-details.component.html'
})
export class DiscoveryDetailsComponent implements OnInit {
    discovery: any;
    constructor(public dialogRef: MdDialogRef<DiscoveryDetailsComponent>) { }
    ngOnInit() {
        this.discovery = {
            id: 1,
            name: 'Podgrzybek',
            coordinateX: 51.673858,
            coordinateY: 7.815982,
            photo: null,
            date: '12.05.2017 9:44'
        };
    }
}