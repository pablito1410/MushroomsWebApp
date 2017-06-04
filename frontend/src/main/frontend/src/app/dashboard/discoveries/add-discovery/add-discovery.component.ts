import {Component, OnInit} from "@angular/core";
import { MdDialogRef } from "@angular/material";
import {SearchFriendsComponent} from "../../friends/search-friends/search-friends.component";

@Component({
    moduleId: module.id,
    selector: 'add-discovery-cmp',
    templateUrl: 'add-discovery.component.html'
})
export class AddDiscoveryComponent implements OnInit {
    constructor(public dialogRef: MdDialogRef<AddDiscoveryComponent>) { }
    ngOnInit() {
    }
}