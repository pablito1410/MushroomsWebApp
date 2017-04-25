import { Component, OnInit } from '@angular/core';
import { LocationStrategy, PlatformLocation, Location} from '@angular/common';
import { ActivatedRoute, Router } from "@angular/router";

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

    public isAuthorizationPage() : boolean {
        return ((this.route.url === '/login') || (this.route.url === '/register'));
    }
}
