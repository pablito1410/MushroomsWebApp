import { Component, OnInit } from '@angular/core';
import { LocationStrategy, PlatformLocation, Location} from '@angular/common';
import {ActivatedRoute, Router} from "@angular/router";

declare var $:any;

@Component({
    moduleId: module.id,
    selector: 'my-app',
    templateUrl: 'app.component.html'
})

export class AppComponent implements OnInit{
    location: Location;
    constructor(location:Location, private route:Router) {
        this.location = location;
    }
    ngOnInit(){
        $.getScript('../assets/js/material-dashboard.js');
        $.getScript('../assets/js/initMenu.js');
    }
    public isMaps(path){
        var titlee = this.location.prepareExternalUrl(this.location.path());
        titlee = titlee.slice( 1 );
        if(path == titlee){
            return false;
        }
        else {
            return true;
        }
    }
    public isLoginPage(){
        return (this.route.url === '/login');
    }
}
