import { Component, OnInit } from '@angular/core';
import { LocationStrategy, PlatformLocation, Location} from '@angular/common';

declare var $:any;

@Component({
    moduleId: module.id,
    selector: 'my-app',
    templateUrl: 'app.component.html'
})

export class AppComponent implements OnInit{
    location: Location;
    logged: boolean;
    constructor(location:Location) {
        this.location = location;
        this.logged = false;
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
    public isLogged(){
        this.logged = true;
        return this.logged;
    }
}
