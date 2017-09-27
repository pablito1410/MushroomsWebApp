import { Component, Inject, OnInit } from '@angular/core';
import { Discovery } from "../../model/discovery";
import { MdDialog } from "@angular/material";
import { SearchFriendsComponent } from "../friends/search-friends/search-friends.component";
import { AddDiscoveryComponent } from "./add-discovery/add-discovery.component";
import { DiscoveryDetailsComponent } from "./discovery-details/discovery-details.component";
import { DiscoveryService } from "../../services/discovery.service";
import { DOCUMENT } from "@angular/platform-browser";
import { Tools } from "../../tools/tools";

/**
 * Discoveries page component
 */
@Component({
    moduleId: module.id,
    selector: 'discoveries-cmp',
    templateUrl: 'discoveries.component.html'
})
export class DiscoveriesComponent implements OnInit {
    
    /** Array with model comment objects */
    discoveries: Discovery[];
    /** Option selected in dialog */
    selectedOption: string;
    /** Flag indicating my checkbox */
    my: boolean;
    /** Flag indicating friends checkbox */
    friends: boolean;
    /** Flag indicating public checkbox */
    isPublic: boolean;

    /** Static method get photo string to display assignment */
    getPhotoStringToDisplay = Tools.getPhotoStringToDisplay;
    /** Static method convert date tolocale string assignment */
    convertDateToLocaleString = Tools.convertDateToLocaleString;

    /**
     * Constructor of class
     * @param dialog                Material dialog
     * @param document              Current document
     * @param discoveryService      Discovery service
     */
    constructor(
        public dialog: MdDialog,
        @Inject(DOCUMENT) private document,
        private discoveryService: DiscoveryService) {
        this.discoveries = new Array<Discovery>();
        this.my = true;
        this.friends = false;
        this.isPublic = false;
    }

    /**
     * Initialization method
     */
    ngOnInit() {
        if (+document.location.port == 4200) {
            // for only frontend development purposes
            this. initFakeData();
        } else {
            this.searchDiscoveries('');
        }
    }

    /**
     * Initialize the component with fake data
     */
     private initFakeData() {
        this.discoveries = [
            {
                id: 1,
                tripId: 1,
                mushroomSpeciesId: 1,
                coordinateX: 43.341166,
                coordinateY: 38.462563,
                photo: null,
                dateTime: '2016-06-21T19:09:42.646Z',
                mushroomSpecies: {
                    id: 1,
                    name: "Podgrzybek",
                    examplePhoto: null,
                    genus: null
                },
                isPublic: true
            },
            {
                id: 2,
                tripId: 2,
                mushroomSpeciesId: 1,
                coordinateX: 45.345566,
                coordinateY: 35.463566,
                photo: null,
                dateTime: '2016-07-22T19:11:32.646Z',
                mushroomSpecies: {
                    id: 1,
                    name: "Podgrzybek",
                    examplePhoto: null,
                    genus: null
                },
                isPublic: true
            },
            {
                id: 3,
                tripId: 3,
                mushroomSpeciesId: 1,
                coordinateX: 41.174666,
                coordinateY: 22.463226,
                photo: null,
                dateTime: '2017-04-28T19:08:11.646Z',
                mushroomSpecies: {
                    id: 1,
                    name: "Podgrzybek",
                    examplePhoto: null,
                    genus: null
                },
                isPublic: true
            }
        ];
    }

    /**
     * Opens add discovery dialog
     */
    openAddDiscoveryDialog() {
        let dialogRef = this.dialog.open(AddDiscoveryComponent, {
            hasBackdrop: true,
            height: '80%',
            width: '80%',
        });
        dialogRef.afterClosed().subscribe(result => {
            this.selectedOption = result;
            this.ngOnInit();
        });
    }

    /**
     * Search discoveries handle
     * @param term      Term to searach
     */
    searchDiscoveries(term: string) {
        this.discoveryService.search(term, this.my, this.friends, this.isPublic)
            .subscribe(
                result => this.discoveries = result
            );
    }

    /**
     * Opens discovery details dialog
     * @param discovery     Discovery
     */
    openDiscoveryDetailsDialog(discovery: Discovery) {
        let dialogRef = this.dialog.open(DiscoveryDetailsComponent, {
            data: { 
                discovery: discovery,
                status: 'details'
            },
            hasBackdrop: true,
            height: '80%',
            width: '80%',
        });
        dialogRef.afterClosed().subscribe(result => {
            this.selectedOption = result;
        });
    }

    /**
     * My checkbox on click handle
     * @param event     Event
     */
    myCheckboxOnClick(event: Event) {
        if ($(event.target).is("input")) {
            this.my = !this.my;
            this.searchDiscoveries('');
        }
    }

    /**
     * Friends checkbox on click handle
     * @param event     Event
     */
    friendsCheckboxOnClick(event: Event) {
        if ($(event.target).is("input")) {
            this.friends = !this.friends;
            this.searchDiscoveries('');
        }
    }

    /**
     * Public checkbox on click handle
     * @param event     Event
     */
    publicCheckboxOnClick(event: Event) {
        if ($(event.target).is("input")) {
            this.isPublic = !this.isPublic;
            this.searchDiscoveries('');
        }
    }
}