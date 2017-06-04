import {Component, OnInit} from "@angular/core";
import { MdDialogRef } from "@angular/material";
import {SearchFriendsComponent} from "../../friends/search-friends/search-friends.component";

@Component({
    moduleId: module.id,
    selector: 'discovery-details-cmp',
    templateUrl: 'discovery-details.component.html'
})
export class DiscoveryDetailsComponent implements OnInit {
    constructor(public dialogRef: MdDialogRef<DiscoveryDetailsComponent>) { }
    ngOnInit() {
    }
}