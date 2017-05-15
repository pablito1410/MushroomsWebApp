import {Component, OnInit, Inject} from '@angular/core';
import { Location} from '@angular/common';
import { Router } from "@angular/router";
import {DOCUMENT} from "@angular/platform-browser";

declare var $:any;

@Component({
    moduleId: module.id,
    selector: 'my-app',
    templateUrl: 'app.component.html'
})
export class AppComponent implements OnInit {

    location: Location;

    constructor(
        location: Location,
        @Inject(DOCUMENT) private document) {
        this.location = location;
    }

    ngOnInit() {
        $.getScript('../assets/js/material-dashboard.js');
        $.getScript('../assets/js/initMenu.js');
    }

    public isMaps(path) : boolean {
        var title = this.location.prepareExternalUrl(this.location.path());
        title = title.slice( 1 );
        if(path == title){
            return false;
        }
        else {
            return true;
        }
    }

    public isLoggedIn() : boolean {
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
