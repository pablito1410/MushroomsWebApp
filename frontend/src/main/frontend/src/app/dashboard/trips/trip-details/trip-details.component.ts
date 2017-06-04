import {Component, OnInit} from "@angular/core";
import { MdDialogRef } from "@angular/material";
import {SearchFriendsComponent} from "../../friends/search-friends/search-friends.component";

@Component({
    moduleId: module.id,
    selector: 'trip-details-cmp',
    templateUrl: 'trip-details.component.html'
})
export class TripDetailsComponent implements OnInit {
    constructor(public dialogRef: MdDialogRef<TripDetailsComponent>) { }
    ngOnInit() {
    }
}