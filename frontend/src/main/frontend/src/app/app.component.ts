import { Component, OnInit } from '@angular/core';
import { Location} from '@angular/common';
import { Router } from "@angular/router";

declare var $:any;

@Component({
    moduleId: module.id,
    selector: 'my-app',
    templateUrl: 'app.component.html'
})
export class AppComponent implements OnInit {

    location: Location;

    constructor(location:Location, private route:Router) {
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
        if (localStorage.getItem('token')) {
            // logged in so return true
            return true;
        }
        return false;
    }
}
