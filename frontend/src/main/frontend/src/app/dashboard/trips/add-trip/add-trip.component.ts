import {Component, OnInit} from "@angular/core";
import { MdDialogRef } from "@angular/material";
import {SearchFriendsComponent} from "../../friends/search-friends/search-friends.component";

@Component({
    moduleId: module.id,
    selector: 'add-trip-cmp',
    templateUrl: 'add-trip.component.html'
})
export class AddTripComponent implements OnInit {
    constructor(public dialogRef: MdDialogRef<AddTripComponent>) { }
    ngOnInit() {
    }
}