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
    comments: any;
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
        this.comments = [
            {
                id: 1,
                name: 'root1',
                children: [
                    { id: 2, name: 'child1' },
                    { id: 3, name: 'child2' }
                ]
            },
            {
                id: 4,
                name: 'root2',
                children: [
                    { id: 5, name: 'child2.1' },
                    {
                        id: 6,
                        name: 'child2.2',
                        children: [
                            { id: 7, name: 'subsub' }
                        ]
                    }
                ]
            }
        ];
    }
}