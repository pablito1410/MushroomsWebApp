import { Component, OnInit, Inject } from '@angular/core';
import { Location} from '@angular/common';
import { Router } from "@angular/router";
import { DOCUMENT } from "@angular/platform-browser";

declare var $:any;

/**
 * App component
 */
@Component({
    moduleId: module.id,
    selector: 'my-app',
    templateUrl: 'app.component.html'
})
export class AppComponent implements OnInit {

    /** Router location */
    location: Location;

    /**
     * Constructor of class
     * @param location      Router location
     * @param document      Current document
     */
    constructor(
        location: Location,
        @Inject(DOCUMENT) private document) {
        this.location = location;
    }

    /**
     * Initialization method
     */
    ngOnInit() {
        $.getScript('../assets/js/material-dashboard.js');
        $.getScript('../assets/js/initMenu.js');
    }

    /**
     * Checks maps
     * @returns     Value true if maps is ok
     */
    public isMaps(path): boolean {
        var title = this.location.prepareExternalUrl(this.location.path());
        title = title.slice(1);
        if(path == title) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Check if the user is logged in
     * @returns     Value true if he is
     */
    public isLoggedIn(): boolean {
        if (+document.location.port == 4200) {
            // for only frontend development purposes
            return true;
        }
        if (localStorage.getItem('token')) {
            // logged in so return true
            return true;
        }
        return false;
    }
}
